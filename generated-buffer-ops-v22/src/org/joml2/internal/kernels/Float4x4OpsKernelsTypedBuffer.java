package org.joml2.internal.kernels;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.ops.*;
import org.joml2.internal.unsafe.*;

/**
 * Scalar/Unsafe kernel leaves of {@link Float4x4Ops} whose leading storage
 * parameter is a typed {@link java.nio.FloatBuffer}. Split into a sibling compilation unit purely
 * to keep generated sources IDE-sized; package-private, called only from
 * {@code Float4x4Ops} and its sibling kernel units. Not public API.
 */
public final class Float4x4OpsKernelsTypedBuffer {
    private Float4x4OpsKernelsTypedBuffer() {}

    public static java.nio.FloatBuffer getColumn_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, int col) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.getColumn_unsafe(_destBase, _srcBase, col);
        return dest;
    }

    public static java.nio.FloatBuffer getColumn_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, int col) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.getColumn(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, col);
            return dest;
        }
        Float4x4OpsKernelsSegment.getColumn_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, col);
        return dest;
    }

    public static java.nio.FloatBuffer getEulerAnglesXYZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.getEulerAnglesXYZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer getEulerAnglesXYZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.getEulerAnglesXYZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.getEulerAnglesXYZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer getEulerAnglesXZY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.getEulerAnglesXZY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer getEulerAnglesXZY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.getEulerAnglesXZY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.getEulerAnglesXZY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer getEulerAnglesYXZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.getEulerAnglesYXZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer getEulerAnglesYXZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.getEulerAnglesYXZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.getEulerAnglesYXZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer getEulerAnglesYZX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.getEulerAnglesYZX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer getEulerAnglesYZX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.getEulerAnglesYZX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.getEulerAnglesYZX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer getEulerAnglesZXY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.getEulerAnglesZXY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer getEulerAnglesZXY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.getEulerAnglesZXY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.getEulerAnglesZXY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer getEulerAnglesZYX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.getEulerAnglesZYX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer getEulerAnglesZYX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.getEulerAnglesZYX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.getEulerAnglesZYX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer getNormalizedRotation_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.getNormalizedRotation_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer getNormalizedRotation_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.getNormalizedRotation(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.getNormalizedRotation_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer getRow_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, int row) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.getRow_unsafe(_destBase, _srcBase, row);
        return dest;
    }

    public static java.nio.FloatBuffer getRow_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, int row) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.getRow(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, row);
            return dest;
        }
        Float4x4OpsKernelsSegment.getRow_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, row);
        return dest;
    }

    public static java.nio.FloatBuffer getScale_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.getScale_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer getScale_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.getScale(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.getScale_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer getTranslation_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.getTranslation_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer getTranslation_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.getTranslation(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.getTranslation_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer getUnnormalizedRotation_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.getUnnormalizedRotation_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer getUnnormalizedRotation_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.getUnnormalizedRotation(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.getUnnormalizedRotation_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer invNegativeX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.invNegativeX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer invNegativeX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.invNegativeX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.invNegativeX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer invNegativeY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.invNegativeY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer invNegativeY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.invNegativeY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.invNegativeY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer invNegativeZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.invNegativeZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer invNegativeZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.invNegativeZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.invNegativeZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer invNormalizedNegativeX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.invNormalizedNegativeX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer invNormalizedNegativeX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.invNormalizedNegativeX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.invNormalizedNegativeX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer invNormalizedNegativeY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.invNormalizedNegativeY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer invNormalizedNegativeY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.invNormalizedNegativeY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.invNormalizedNegativeY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer invNormalizedNegativeZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.invNormalizedNegativeZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer invNormalizedNegativeZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.invNormalizedNegativeZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.invNormalizedNegativeZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer invNormalizedPositiveX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.invNormalizedPositiveX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer invNormalizedPositiveX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.invNormalizedPositiveX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.invNormalizedPositiveX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer invNormalizedPositiveY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.invNormalizedPositiveY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer invNormalizedPositiveY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.invNormalizedPositiveY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.invNormalizedPositiveY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer invNormalizedPositiveZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.invNormalizedPositiveZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer invNormalizedPositiveZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.invNormalizedPositiveZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.invNormalizedPositiveZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer invPositiveX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.invPositiveX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer invPositiveX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.invPositiveX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.invPositiveX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer invPositiveY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.invPositiveY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer invPositiveY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.invPositiveY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.invPositiveY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer invPositiveZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.invPositiveZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer invPositiveZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.invPositiveZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.invPositiveZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer negativeX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.negativeX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer negativeX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.negativeX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.negativeX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer negativeY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.negativeY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer negativeY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.negativeY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.negativeY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer negativeZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.negativeZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer negativeZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.negativeZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.negativeZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer normalizedNegativeX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.normalizedNegativeX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer normalizedNegativeX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.normalizedNegativeX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.normalizedNegativeX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer normalizedNegativeY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.normalizedNegativeY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer normalizedNegativeY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.normalizedNegativeY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.normalizedNegativeY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer normalizedNegativeZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.normalizedNegativeZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer normalizedNegativeZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.normalizedNegativeZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.normalizedNegativeZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer normalizedPositiveX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.normalizedPositiveX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer normalizedPositiveX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.normalizedPositiveX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.normalizedPositiveX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer normalizedPositiveY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.normalizedPositiveY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer normalizedPositiveY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.normalizedPositiveY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.normalizedPositiveY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer normalizedPositiveZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.normalizedPositiveZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer normalizedPositiveZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.normalizedPositiveZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.normalizedPositiveZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer origin_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.origin_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer origin_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.origin(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.origin_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer originAffine_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.originAffine_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer originAffine_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.originAffine(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.originAffine_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer positiveX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.positiveX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer positiveX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.positiveX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.positiveX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer positiveY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.positiveY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer positiveY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.positiveY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.positiveY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer positiveZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.positiveZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer positiveZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.positiveZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.positiveZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer cofactor_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.cofactor_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer cofactor_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.cofactor(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.cofactor_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static float determinant_unsafe(java.nio.FloatBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        return Float4x4OpsKernelsAddress.determinant_unsafe(_srcBase);
    }

    public static float determinant_api(java.nio.FloatBuffer src, int srcOffset) {
        if (src.hasArray()) {
            return Float4x4Ops.determinant(src.array(), src.arrayOffset() + srcOffset);
        }
        return Float4x4OpsKernelsSegment.determinant_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
    }

    public static float frobeniusNorm_unsafe(java.nio.FloatBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        return Float4x4OpsKernelsAddress.frobeniusNorm_unsafe(_srcBase);
    }

    public static float frobeniusNorm_api(java.nio.FloatBuffer src, int srcOffset) {
        if (src.hasArray()) {
            return Float4x4Ops.frobeniusNorm(src.array(), src.arrayOffset() + srcOffset);
        }
        return Float4x4OpsKernelsSegment.frobeniusNorm_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
    }

    public static java.nio.FloatBuffer invert_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.invert_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer invert_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.invert(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.invert_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer invertProduct_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 4L;
        Float4x4OpsKernelsAddress.invertProduct_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.FloatBuffer invertProduct_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer other, int otherOffset) {
        if (dest.hasArray() && src.hasArray() && other.hasArray()) {
            Float4x4Ops.invertProduct(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.invertProduct_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer normal_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.normal_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer normal_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.normal(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.normal_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static float trace_unsafe(java.nio.FloatBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        return Float4x4OpsKernelsAddress.trace_unsafe(_srcBase);
    }

    public static float trace_api(java.nio.FloatBuffer src, int srcOffset) {
        if (src.hasArray()) {
            return Float4x4Ops.trace(src.array(), src.arrayOffset() + srcOffset);
        }
        return Float4x4OpsKernelsSegment.trace_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
    }

    public static java.nio.FloatBuffer transpose_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.transpose_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer transpose_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.transpose(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.transpose_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer add_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 4L;
        Float4x4OpsKernelsAddress.add_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.FloatBuffer add_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer other, int otherOffset) {
        if (dest.hasArray() && src.hasArray() && other.hasArray()) {
            Float4x4Ops.add(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.add_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer negate_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.negate_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer negate_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.negate(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.negate_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer sub_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 4L;
        Float4x4OpsKernelsAddress.sub_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.FloatBuffer sub_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer other, int otherOffset) {
        if (dest.hasArray() && src.hasArray() && other.hasArray()) {
            Float4x4Ops.sub(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.sub_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer set_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 4L;
        Float4x4OpsKernelsAddress.set_unsafe(_destBase, _vBase);
        return dest;
    }

    public static java.nio.FloatBuffer set_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer v, int vOffset) {
        if (dest.hasArray() && v.hasArray()) {
            Float4x4Ops.set(dest.array(), dest.arrayOffset() + destOffset, v.array(), v.arrayOffset() + vOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.set_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(v.duplicate().position(0)), (long) vOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer setMat3x3_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer m, int mOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _mBase = UnsafeOpsHolder.U.getLong(m, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) mOffset * 4L;
        Float4x4OpsKernelsAddress.setMat3x3_unsafe(_destBase, _mBase);
        return dest;
    }

    public static java.nio.FloatBuffer setMat3x3_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer m, int mOffset) {
        if (dest.hasArray() && m.hasArray()) {
            Float4x4Ops.setMat3x3(dest.array(), dest.arrayOffset() + destOffset, m.array(), m.arrayOffset() + mOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.setMat3x3_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(m.duplicate().position(0)), (long) mOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer setMat3x4_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer m, int mOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _mBase = UnsafeOpsHolder.U.getLong(m, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) mOffset * 4L;
        Float4x4OpsKernelsAddress.setMat3x4_unsafe(_destBase, _mBase);
        return dest;
    }

    public static java.nio.FloatBuffer setMat3x4_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer m, int mOffset) {
        if (dest.hasArray() && m.hasArray()) {
            Float4x4Ops.setMat3x4(dest.array(), dest.arrayOffset() + destOffset, m.array(), m.arrayOffset() + mOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.setMat3x4_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(m.duplicate().position(0)), (long) mOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer withTranslation_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float tX, float tY, float tZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.withTranslation_unsafe(_destBase, _srcBase, tX, tY, tZ);
        return dest;
    }

    public static java.nio.FloatBuffer withTranslation_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float tX, float tY, float tZ) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.withTranslation(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, tX, tY, tZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.withTranslation_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, tX, tY, tZ);
        return dest;
    }

    public static java.nio.FloatBuffer withTranslation_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer t, int tOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _tBase = UnsafeOpsHolder.U.getLong(t, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) tOffset * 4L;
        Float4x4OpsKernelsAddress.withTranslation_unsafe(_destBase, _srcBase, _tBase);
        return dest;
    }

    public static java.nio.FloatBuffer withTranslation_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer t, int tOffset) {
        if (dest.hasArray() && src.hasArray() && t.hasArray()) {
            Float4x4Ops.withTranslation(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, t.array(), t.arrayOffset() + tOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.withTranslation_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(t.duplicate().position(0)), (long) tOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeFromRigid_unsafe(java.nio.FloatBuffer dest, int destOffset, float rTX, float rTY, float rTZ, float rRX, float rRY, float rRZ, float rRW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeFromRigid_unsafe(_destBase, rTX, rTY, rTZ, rRX, rRY, rRZ, rRW);
        return dest;
    }

    public static java.nio.FloatBuffer makeFromRigid_api(java.nio.FloatBuffer dest, int destOffset, float rTX, float rTY, float rTZ, float rRX, float rRY, float rRZ, float rRW) {
        if (dest.hasArray()) {
            Float4x4Ops.makeFromRigid(dest.array(), dest.arrayOffset() + destOffset, rTX, rTY, rTZ, rRX, rRY, rRZ, rRW);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeFromRigid_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, rTX, rTY, rTZ, rRX, rRY, rRZ, rRW);
        return dest;
    }

    public static java.nio.FloatBuffer makeFromTransform_unsafe(java.nio.FloatBuffer dest, int destOffset, float tTX, float tTY, float tTZ, float tRX, float tRY, float tRZ, float tRW, float tSX, float tSY, float tSZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeFromTransform_unsafe(_destBase, tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ);
        return dest;
    }

    public static java.nio.FloatBuffer makeFromTransform_api(java.nio.FloatBuffer dest, int destOffset, float tTX, float tTY, float tTZ, float tRX, float tRY, float tRZ, float tRW, float tSX, float tSY, float tSZ) {
        if (dest.hasArray()) {
            Float4x4Ops.makeFromTransform(dest.array(), dest.arrayOffset() + destOffset, tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeFromTransform_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ);
        return dest;
    }

    public static java.nio.FloatBuffer to3x3_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.to3x3_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer to3x3_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.to3x3(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.to3x3_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer to3x4_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.to3x4_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer to3x4_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.to3x4(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.to3x4_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer toDualQuat_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.toDualQuat_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer toDualQuat_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.toDualQuat(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.toDualQuat_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer toRigid_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.toRigid_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer toRigid_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.toRigid(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.toRigid_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer toTransform_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.toTransform_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer toTransform_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.toTransform(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.toTransform_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer decomposeRotation_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.decomposeRotation_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer decomposeRotation_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.decomposeRotation(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.decomposeRotation_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer decomposeScale_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.decomposeScale_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer decomposeScale_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.decomposeScale(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.decomposeScale_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer decomposeSkew_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.decomposeSkew_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer decomposeSkew_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.decomposeSkew(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.decomposeSkew_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer decomposeTRS_unsafe(java.nio.FloatBuffer translation, int translationOffset, java.nio.FloatBuffer rotation, int rotationOffset, java.nio.FloatBuffer scale, int scaleOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _translationBase = UnsafeOpsHolder.U.getLong(translation, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) translationOffset * 4L;
        long _rotationBase = UnsafeOpsHolder.U.getLong(rotation, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rotationOffset * 4L;
        long _scaleBase = UnsafeOpsHolder.U.getLong(scale, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) scaleOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.decomposeTRS_unsafe(_translationBase, _rotationBase, _scaleBase, _srcBase);
        return translation;
    }

    public static java.nio.FloatBuffer decomposeTRS_api(java.nio.FloatBuffer translation, int translationOffset, java.nio.FloatBuffer rotation, int rotationOffset, java.nio.FloatBuffer scale, int scaleOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (translation.hasArray() && rotation.hasArray() && scale.hasArray() && src.hasArray()) {
            Float4x4Ops.decomposeTRS(translation.array(), translation.arrayOffset() + translationOffset, rotation.array(), rotation.arrayOffset() + rotationOffset, scale.array(), scale.arrayOffset() + scaleOffset, src.array(), src.arrayOffset() + srcOffset);
            return translation;
        }
        Float4x4OpsKernelsSegment.decomposeTRS_api(java.lang.foreign.MemorySegment.ofBuffer(translation.duplicate().position(0)), (long) translationOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(rotation.duplicate().position(0)), (long) rotationOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(scale.duplicate().position(0)), (long) scaleOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return translation;
    }

    public static java.nio.FloatBuffer frustumAabb_no(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Float4x4OpsKernelsTypedBuffer.frustumAabb_no_unsafe(dest, destOffset, src, srcOffset);
        return Float4x4OpsKernelsTypedBuffer.frustumAabb_no_api(dest, destOffset, src, srcOffset);
    }

    public static java.nio.FloatBuffer frustumAabb_no_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.frustumAabb_no_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer frustumAabb_no_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4OpsKernelsArray.frustumAabb_no(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.frustumAabb_no_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer frustumAabb_zo(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Float4x4OpsKernelsTypedBuffer.frustumAabb_zo_unsafe(dest, destOffset, src, srcOffset);
        return Float4x4OpsKernelsTypedBuffer.frustumAabb_zo_api(dest, destOffset, src, srcOffset);
    }

    public static java.nio.FloatBuffer frustumAabb_zo_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.frustumAabb_zo_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer frustumAabb_zo_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4OpsKernelsArray.frustumAabb_zo(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.frustumAabb_zo_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer frustumCorner_no(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, FrustumCorner corner) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Float4x4OpsKernelsTypedBuffer.frustumCorner_no_unsafe(dest, destOffset, src, srcOffset, corner);
        return Float4x4OpsKernelsTypedBuffer.frustumCorner_no_api(dest, destOffset, src, srcOffset, corner);
    }

    public static java.nio.FloatBuffer frustumCorner_no_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, FrustumCorner corner) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.frustumCorner_no_unsafe(_destBase, _srcBase, corner);
        return dest;
    }

    public static java.nio.FloatBuffer frustumCorner_no_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, FrustumCorner corner) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4OpsKernelsArray.frustumCorner_no(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, corner);
            return dest;
        }
        Float4x4OpsKernelsSegment.frustumCorner_no_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, corner);
        return dest;
    }

    public static java.nio.FloatBuffer frustumCorner_zo(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, FrustumCorner corner) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Float4x4OpsKernelsTypedBuffer.frustumCorner_zo_unsafe(dest, destOffset, src, srcOffset, corner);
        return Float4x4OpsKernelsTypedBuffer.frustumCorner_zo_api(dest, destOffset, src, srcOffset, corner);
    }

    public static java.nio.FloatBuffer frustumCorner_zo_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, FrustumCorner corner) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.frustumCorner_zo_unsafe(_destBase, _srcBase, corner);
        return dest;
    }

    public static java.nio.FloatBuffer frustumCorner_zo_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, FrustumCorner corner) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4OpsKernelsArray.frustumCorner_zo(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, corner);
            return dest;
        }
        Float4x4OpsKernelsSegment.frustumCorner_zo_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, corner);
        return dest;
    }

    public static java.nio.FloatBuffer frustumPlane_no(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, FrustumPlane plane) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Float4x4OpsKernelsTypedBuffer.frustumPlane_no_unsafe(dest, destOffset, src, srcOffset, plane);
        return Float4x4OpsKernelsTypedBuffer.frustumPlane_no_api(dest, destOffset, src, srcOffset, plane);
    }

    public static java.nio.FloatBuffer frustumPlane_no_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, FrustumPlane plane) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.frustumPlane_no_unsafe(_destBase, _srcBase, plane);
        return dest;
    }

    public static java.nio.FloatBuffer frustumPlane_no_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, FrustumPlane plane) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4OpsKernelsArray.frustumPlane_no(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, plane);
            return dest;
        }
        Float4x4OpsKernelsSegment.frustumPlane_no_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, plane);
        return dest;
    }

    public static java.nio.FloatBuffer frustumPlane_zo(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, FrustumPlane plane) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Float4x4OpsKernelsTypedBuffer.frustumPlane_zo_unsafe(dest, destOffset, src, srcOffset, plane);
        return Float4x4OpsKernelsTypedBuffer.frustumPlane_zo_api(dest, destOffset, src, srcOffset, plane);
    }

    public static java.nio.FloatBuffer frustumPlane_zo_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, FrustumPlane plane) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.frustumPlane_zo_unsafe(_destBase, _srcBase, plane);
        return dest;
    }

    public static java.nio.FloatBuffer frustumPlane_zo_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, FrustumPlane plane) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4OpsKernelsArray.frustumPlane_zo(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, plane);
            return dest;
        }
        Float4x4OpsKernelsSegment.frustumPlane_zo_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, plane);
        return dest;
    }

    public static java.nio.FloatBuffer frustumRayDir_no(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float x, float y) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Float4x4OpsKernelsTypedBuffer.frustumRayDir_no_unsafe(dest, destOffset, src, srcOffset, x, y);
        return Float4x4OpsKernelsTypedBuffer.frustumRayDir_no_api(dest, destOffset, src, srcOffset, x, y);
    }

    public static java.nio.FloatBuffer frustumRayDir_no_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float x, float y) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.frustumRayDir_no_unsafe(_destBase, _srcBase, x, y);
        return dest;
    }

    public static java.nio.FloatBuffer frustumRayDir_no_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float x, float y) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4OpsKernelsArray.frustumRayDir_no(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, x, y);
            return dest;
        }
        Float4x4OpsKernelsSegment.frustumRayDir_no_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, x, y);
        return dest;
    }

    public static java.nio.FloatBuffer frustumRayDir_zo(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float x, float y) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Float4x4OpsKernelsTypedBuffer.frustumRayDir_zo_unsafe(dest, destOffset, src, srcOffset, x, y);
        return Float4x4OpsKernelsTypedBuffer.frustumRayDir_zo_api(dest, destOffset, src, srcOffset, x, y);
    }

    public static java.nio.FloatBuffer frustumRayDir_zo_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float x, float y) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.frustumRayDir_zo_unsafe(_destBase, _srcBase, x, y);
        return dest;
    }

    public static java.nio.FloatBuffer frustumRayDir_zo_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float x, float y) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4OpsKernelsArray.frustumRayDir_zo(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, x, y);
            return dest;
        }
        Float4x4OpsKernelsSegment.frustumRayDir_zo_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, x, y);
        return dest;
    }

    public static float testAabb_no(java.nio.FloatBuffer src, int srcOffset, float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isDirect()) return Float4x4OpsKernelsTypedBuffer.testAabb_no_unsafe(src, srcOffset, minX, minY, minZ, maxX, maxY, maxZ);
        return Float4x4OpsKernelsTypedBuffer.testAabb_no_api(src, srcOffset, minX, minY, minZ, maxX, maxY, maxZ);
    }

    public static float testAabb_no_unsafe(java.nio.FloatBuffer src, int srcOffset, float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        return Float4x4OpsKernelsAddress.testAabb_no_unsafe(_srcBase, minX, minY, minZ, maxX, maxY, maxZ);
    }

    public static float testAabb_no_api(java.nio.FloatBuffer src, int srcOffset, float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
        if (src.hasArray()) {
            return Float4x4OpsKernelsArray.testAabb_no(src.array(), src.arrayOffset() + srcOffset, minX, minY, minZ, maxX, maxY, maxZ);
        }
        return Float4x4OpsKernelsSegment.testAabb_no_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, minX, minY, minZ, maxX, maxY, maxZ);
    }

    public static float testAabb_zo(java.nio.FloatBuffer src, int srcOffset, float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isDirect()) return Float4x4OpsKernelsTypedBuffer.testAabb_zo_unsafe(src, srcOffset, minX, minY, minZ, maxX, maxY, maxZ);
        return Float4x4OpsKernelsTypedBuffer.testAabb_zo_api(src, srcOffset, minX, minY, minZ, maxX, maxY, maxZ);
    }

    public static float testAabb_zo_unsafe(java.nio.FloatBuffer src, int srcOffset, float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        return Float4x4OpsKernelsAddress.testAabb_zo_unsafe(_srcBase, minX, minY, minZ, maxX, maxY, maxZ);
    }

    public static float testAabb_zo_api(java.nio.FloatBuffer src, int srcOffset, float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
        if (src.hasArray()) {
            return Float4x4OpsKernelsArray.testAabb_zo(src.array(), src.arrayOffset() + srcOffset, minX, minY, minZ, maxX, maxY, maxZ);
        }
        return Float4x4OpsKernelsSegment.testAabb_zo_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, minX, minY, minZ, maxX, maxY, maxZ);
    }

    public static float testAabb_no(java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer min, int minOffset, java.nio.FloatBuffer max, int maxOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isDirect() && min.isDirect() && max.isDirect()) return Float4x4OpsKernelsTypedBuffer.testAabb_no_unsafe(src, srcOffset, min, minOffset, max, maxOffset);
        return Float4x4OpsKernelsTypedBuffer.testAabb_no_api(src, srcOffset, min, minOffset, max, maxOffset);
    }

    public static float testAabb_no_unsafe(java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer min, int minOffset, java.nio.FloatBuffer max, int maxOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _minBase = UnsafeOpsHolder.U.getLong(min, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) minOffset * 4L;
        long _maxBase = UnsafeOpsHolder.U.getLong(max, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) maxOffset * 4L;
        return Float4x4OpsKernelsAddress.testAabb_no_unsafe(_srcBase, _minBase, _maxBase);
    }

    public static float testAabb_no_api(java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer min, int minOffset, java.nio.FloatBuffer max, int maxOffset) {
        if (src.hasArray() && min.hasArray() && max.hasArray()) {
            return Float4x4OpsKernelsArray.testAabb_no(src.array(), src.arrayOffset() + srcOffset, min.array(), min.arrayOffset() + minOffset, max.array(), max.arrayOffset() + maxOffset);
        }
        return Float4x4OpsKernelsSegment.testAabb_no_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(min.duplicate().position(0)), (long) minOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(max.duplicate().position(0)), (long) maxOffset * 4L);
    }

    public static float testAabb_zo(java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer min, int minOffset, java.nio.FloatBuffer max, int maxOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isDirect() && min.isDirect() && max.isDirect()) return Float4x4OpsKernelsTypedBuffer.testAabb_zo_unsafe(src, srcOffset, min, minOffset, max, maxOffset);
        return Float4x4OpsKernelsTypedBuffer.testAabb_zo_api(src, srcOffset, min, minOffset, max, maxOffset);
    }

    public static float testAabb_zo_unsafe(java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer min, int minOffset, java.nio.FloatBuffer max, int maxOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _minBase = UnsafeOpsHolder.U.getLong(min, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) minOffset * 4L;
        long _maxBase = UnsafeOpsHolder.U.getLong(max, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) maxOffset * 4L;
        return Float4x4OpsKernelsAddress.testAabb_zo_unsafe(_srcBase, _minBase, _maxBase);
    }

    public static float testAabb_zo_api(java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer min, int minOffset, java.nio.FloatBuffer max, int maxOffset) {
        if (src.hasArray() && min.hasArray() && max.hasArray()) {
            return Float4x4OpsKernelsArray.testAabb_zo(src.array(), src.arrayOffset() + srcOffset, min.array(), min.arrayOffset() + minOffset, max.array(), max.arrayOffset() + maxOffset);
        }
        return Float4x4OpsKernelsSegment.testAabb_zo_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(min.duplicate().position(0)), (long) minOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(max.duplicate().position(0)), (long) maxOffset * 4L);
    }

    public static float testPoint_no(java.nio.FloatBuffer src, int srcOffset, float pointX, float pointY, float pointZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isDirect()) return Float4x4OpsKernelsTypedBuffer.testPoint_no_unsafe(src, srcOffset, pointX, pointY, pointZ);
        return Float4x4OpsKernelsTypedBuffer.testPoint_no_api(src, srcOffset, pointX, pointY, pointZ);
    }

    public static float testPoint_no_unsafe(java.nio.FloatBuffer src, int srcOffset, float pointX, float pointY, float pointZ) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        return Float4x4OpsKernelsAddress.testPoint_no_unsafe(_srcBase, pointX, pointY, pointZ);
    }

    public static float testPoint_no_api(java.nio.FloatBuffer src, int srcOffset, float pointX, float pointY, float pointZ) {
        if (src.hasArray()) {
            return Float4x4OpsKernelsArray.testPoint_no(src.array(), src.arrayOffset() + srcOffset, pointX, pointY, pointZ);
        }
        return Float4x4OpsKernelsSegment.testPoint_no_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, pointX, pointY, pointZ);
    }

    public static float testPoint_zo(java.nio.FloatBuffer src, int srcOffset, float pointX, float pointY, float pointZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isDirect()) return Float4x4OpsKernelsTypedBuffer.testPoint_zo_unsafe(src, srcOffset, pointX, pointY, pointZ);
        return Float4x4OpsKernelsTypedBuffer.testPoint_zo_api(src, srcOffset, pointX, pointY, pointZ);
    }

    public static float testPoint_zo_unsafe(java.nio.FloatBuffer src, int srcOffset, float pointX, float pointY, float pointZ) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        return Float4x4OpsKernelsAddress.testPoint_zo_unsafe(_srcBase, pointX, pointY, pointZ);
    }

    public static float testPoint_zo_api(java.nio.FloatBuffer src, int srcOffset, float pointX, float pointY, float pointZ) {
        if (src.hasArray()) {
            return Float4x4OpsKernelsArray.testPoint_zo(src.array(), src.arrayOffset() + srcOffset, pointX, pointY, pointZ);
        }
        return Float4x4OpsKernelsSegment.testPoint_zo_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, pointX, pointY, pointZ);
    }

    public static float testPoint_no(java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer point, int pointOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isDirect() && point.isDirect()) return Float4x4OpsKernelsTypedBuffer.testPoint_no_unsafe(src, srcOffset, point, pointOffset);
        return Float4x4OpsKernelsTypedBuffer.testPoint_no_api(src, srcOffset, point, pointOffset);
    }

    public static float testPoint_no_unsafe(java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer point, int pointOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _pointBase = UnsafeOpsHolder.U.getLong(point, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pointOffset * 4L;
        return Float4x4OpsKernelsAddress.testPoint_no_unsafe(_srcBase, _pointBase);
    }

    public static float testPoint_no_api(java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer point, int pointOffset) {
        if (src.hasArray() && point.hasArray()) {
            return Float4x4OpsKernelsArray.testPoint_no(src.array(), src.arrayOffset() + srcOffset, point.array(), point.arrayOffset() + pointOffset);
        }
        return Float4x4OpsKernelsSegment.testPoint_no_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(point.duplicate().position(0)), (long) pointOffset * 4L);
    }

    public static float testPoint_zo(java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer point, int pointOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isDirect() && point.isDirect()) return Float4x4OpsKernelsTypedBuffer.testPoint_zo_unsafe(src, srcOffset, point, pointOffset);
        return Float4x4OpsKernelsTypedBuffer.testPoint_zo_api(src, srcOffset, point, pointOffset);
    }

    public static float testPoint_zo_unsafe(java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer point, int pointOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _pointBase = UnsafeOpsHolder.U.getLong(point, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pointOffset * 4L;
        return Float4x4OpsKernelsAddress.testPoint_zo_unsafe(_srcBase, _pointBase);
    }

    public static float testPoint_zo_api(java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer point, int pointOffset) {
        if (src.hasArray() && point.hasArray()) {
            return Float4x4OpsKernelsArray.testPoint_zo(src.array(), src.arrayOffset() + srcOffset, point.array(), point.arrayOffset() + pointOffset);
        }
        return Float4x4OpsKernelsSegment.testPoint_zo_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(point.duplicate().position(0)), (long) pointOffset * 4L);
    }

    public static float testSphere_no(java.nio.FloatBuffer src, int srcOffset, float centerX, float centerY, float centerZ, float radius) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isDirect()) return Float4x4OpsKernelsTypedBuffer.testSphere_no_unsafe(src, srcOffset, centerX, centerY, centerZ, radius);
        return Float4x4OpsKernelsTypedBuffer.testSphere_no_api(src, srcOffset, centerX, centerY, centerZ, radius);
    }

    public static float testSphere_no_unsafe(java.nio.FloatBuffer src, int srcOffset, float centerX, float centerY, float centerZ, float radius) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        return Float4x4OpsKernelsAddress.testSphere_no_unsafe(_srcBase, centerX, centerY, centerZ, radius);
    }

    public static float testSphere_no_api(java.nio.FloatBuffer src, int srcOffset, float centerX, float centerY, float centerZ, float radius) {
        if (src.hasArray()) {
            return Float4x4OpsKernelsArray.testSphere_no(src.array(), src.arrayOffset() + srcOffset, centerX, centerY, centerZ, radius);
        }
        return Float4x4OpsKernelsSegment.testSphere_no_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, centerX, centerY, centerZ, radius);
    }

    public static float testSphere_zo(java.nio.FloatBuffer src, int srcOffset, float centerX, float centerY, float centerZ, float radius) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isDirect()) return Float4x4OpsKernelsTypedBuffer.testSphere_zo_unsafe(src, srcOffset, centerX, centerY, centerZ, radius);
        return Float4x4OpsKernelsTypedBuffer.testSphere_zo_api(src, srcOffset, centerX, centerY, centerZ, radius);
    }

    public static float testSphere_zo_unsafe(java.nio.FloatBuffer src, int srcOffset, float centerX, float centerY, float centerZ, float radius) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        return Float4x4OpsKernelsAddress.testSphere_zo_unsafe(_srcBase, centerX, centerY, centerZ, radius);
    }

    public static float testSphere_zo_api(java.nio.FloatBuffer src, int srcOffset, float centerX, float centerY, float centerZ, float radius) {
        if (src.hasArray()) {
            return Float4x4OpsKernelsArray.testSphere_zo(src.array(), src.arrayOffset() + srcOffset, centerX, centerY, centerZ, radius);
        }
        return Float4x4OpsKernelsSegment.testSphere_zo_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, centerX, centerY, centerZ, radius);
    }

    public static float testSphere_no(java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer center, int centerOffset, float radius) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isDirect() && center.isDirect()) return Float4x4OpsKernelsTypedBuffer.testSphere_no_unsafe(src, srcOffset, center, centerOffset, radius);
        return Float4x4OpsKernelsTypedBuffer.testSphere_no_api(src, srcOffset, center, centerOffset, radius);
    }

    public static float testSphere_no_unsafe(java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer center, int centerOffset, float radius) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _centerBase = UnsafeOpsHolder.U.getLong(center, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) centerOffset * 4L;
        return Float4x4OpsKernelsAddress.testSphere_no_unsafe(_srcBase, _centerBase, radius);
    }

    public static float testSphere_no_api(java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer center, int centerOffset, float radius) {
        if (src.hasArray() && center.hasArray()) {
            return Float4x4OpsKernelsArray.testSphere_no(src.array(), src.arrayOffset() + srcOffset, center.array(), center.arrayOffset() + centerOffset, radius);
        }
        return Float4x4OpsKernelsSegment.testSphere_no_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(center.duplicate().position(0)), (long) centerOffset * 4L, radius);
    }

    public static float testSphere_zo(java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer center, int centerOffset, float radius) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isDirect() && center.isDirect()) return Float4x4OpsKernelsTypedBuffer.testSphere_zo_unsafe(src, srcOffset, center, centerOffset, radius);
        return Float4x4OpsKernelsTypedBuffer.testSphere_zo_api(src, srcOffset, center, centerOffset, radius);
    }

    public static float testSphere_zo_unsafe(java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer center, int centerOffset, float radius) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _centerBase = UnsafeOpsHolder.U.getLong(center, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) centerOffset * 4L;
        return Float4x4OpsKernelsAddress.testSphere_zo_unsafe(_srcBase, _centerBase, radius);
    }

    public static float testSphere_zo_api(java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer center, int centerOffset, float radius) {
        if (src.hasArray() && center.hasArray()) {
            return Float4x4OpsKernelsArray.testSphere_zo(src.array(), src.arrayOffset() + srcOffset, center.array(), center.arrayOffset() + centerOffset, radius);
        }
        return Float4x4OpsKernelsSegment.testSphere_zo_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(center.duplicate().position(0)), (long) centerOffset * 4L, radius);
    }

    public static java.nio.FloatBuffer makeIdentity_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeIdentity_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeIdentity_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeIdentity(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeIdentity_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer lerp_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer other, int otherOffset, float t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 4L;
        Float4x4OpsKernelsAddress.lerp_unsafe(_destBase, _srcBase, _otherBase, t);
        return dest;
    }

    public static java.nio.FloatBuffer lerp_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer other, int otherOffset, float t) {
        if (dest.hasArray() && src.hasArray() && other.hasArray()) {
            Float4x4Ops.lerp(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset, t);
            return dest;
        }
        Float4x4OpsKernelsSegment.lerp_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 4L, t);
        return dest;
    }

    public static java.nio.FloatBuffer mul_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer right, int rightOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _rightBase = UnsafeOpsHolder.U.getLong(right, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rightOffset * 4L;
        Float4x4OpsKernelsAddress.mul_unsafe(_destBase, _srcBase, _rightBase);
        return dest;
    }

    public static java.nio.FloatBuffer mul_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer right, int rightOffset) {
        if (dest.hasArray() && src.hasArray() && right.hasArray()) {
            Float4x4Ops.mul(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, right.array(), right.arrayOffset() + rightOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mul_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(right.duplicate().position(0)), (long) rightOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mulMat2x2_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer right, int rightOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _rightBase = UnsafeOpsHolder.U.getLong(right, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rightOffset * 4L;
        Float4x4OpsKernelsAddress.mulMat2x2_unsafe(_destBase, _srcBase, _rightBase);
        return dest;
    }

    public static java.nio.FloatBuffer mulMat2x2_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer right, int rightOffset) {
        if (dest.hasArray() && src.hasArray() && right.hasArray()) {
            Float4x4Ops.mulMat2x2(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, right.array(), right.arrayOffset() + rightOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mulMat2x2_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(right.duplicate().position(0)), (long) rightOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mulMat2x3_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer right, int rightOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _rightBase = UnsafeOpsHolder.U.getLong(right, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rightOffset * 4L;
        Float4x4OpsKernelsAddress.mulMat2x3_unsafe(_destBase, _srcBase, _rightBase);
        return dest;
    }

    public static java.nio.FloatBuffer mulMat2x3_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer right, int rightOffset) {
        if (dest.hasArray() && src.hasArray() && right.hasArray()) {
            Float4x4Ops.mulMat2x3(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, right.array(), right.arrayOffset() + rightOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mulMat2x3_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(right.duplicate().position(0)), (long) rightOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mulMat3x3_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer right, int rightOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _rightBase = UnsafeOpsHolder.U.getLong(right, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rightOffset * 4L;
        Float4x4OpsKernelsAddress.mulMat3x3_unsafe(_destBase, _srcBase, _rightBase);
        return dest;
    }

    public static java.nio.FloatBuffer mulMat3x3_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer right, int rightOffset) {
        if (dest.hasArray() && src.hasArray() && right.hasArray()) {
            Float4x4Ops.mulMat3x3(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, right.array(), right.arrayOffset() + rightOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mulMat3x3_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(right.duplicate().position(0)), (long) rightOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mulMat3x4_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer right, int rightOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _rightBase = UnsafeOpsHolder.U.getLong(right, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rightOffset * 4L;
        Float4x4OpsKernelsAddress.mulMat3x4_unsafe(_destBase, _srcBase, _rightBase);
        return dest;
    }

    public static java.nio.FloatBuffer mulMat3x4_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer right, int rightOffset) {
        if (dest.hasArray() && src.hasArray() && right.hasArray()) {
            Float4x4Ops.mulMat3x4(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, right.array(), right.arrayOffset() + rightOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mulMat3x4_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(right.duplicate().position(0)), (long) rightOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer preMul_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 4L;
        Float4x4OpsKernelsAddress.preMul_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.FloatBuffer preMul_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer other, int otherOffset) {
        if (dest.hasArray() && src.hasArray() && other.hasArray()) {
            Float4x4Ops.preMul(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.preMul_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer preMulMat2x2_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 4L;
        Float4x4OpsKernelsAddress.preMulMat2x2_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.FloatBuffer preMulMat2x2_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer other, int otherOffset) {
        if (dest.hasArray() && src.hasArray() && other.hasArray()) {
            Float4x4Ops.preMulMat2x2(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.preMulMat2x2_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer preMulMat2x3_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 4L;
        Float4x4OpsKernelsAddress.preMulMat2x3_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.FloatBuffer preMulMat2x3_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer other, int otherOffset) {
        if (dest.hasArray() && src.hasArray() && other.hasArray()) {
            Float4x4Ops.preMulMat2x3(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.preMulMat2x3_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer preMulMat3x3_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 4L;
        Float4x4OpsKernelsAddress.preMulMat3x3_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.FloatBuffer preMulMat3x3_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer other, int otherOffset) {
        if (dest.hasArray() && src.hasArray() && other.hasArray()) {
            Float4x4Ops.preMulMat3x3(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.preMulMat3x3_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer preMulMat3x4_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 4L;
        Float4x4OpsKernelsAddress.preMulMat3x4_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.FloatBuffer preMulMat3x4_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer other, int otherOffset) {
        if (dest.hasArray() && src.hasArray() && other.hasArray()) {
            Float4x4Ops.preMulMat3x4(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.preMulMat3x4_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeOuterProduct_unsafe(java.nio.FloatBuffer dest, int destOffset, float colX, float colY, float colZ, float colW, float rowX, float rowY, float rowZ, float rowW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeOuterProduct_unsafe(_destBase, colX, colY, colZ, colW, rowX, rowY, rowZ, rowW);
        return dest;
    }

    public static java.nio.FloatBuffer makeOuterProduct_api(java.nio.FloatBuffer dest, int destOffset, float colX, float colY, float colZ, float colW, float rowX, float rowY, float rowZ, float rowW) {
        if (dest.hasArray()) {
            Float4x4Ops.makeOuterProduct(dest.array(), dest.arrayOffset() + destOffset, colX, colY, colZ, colW, rowX, rowY, rowZ, rowW);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeOuterProduct_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, colX, colY, colZ, colW, rowX, rowY, rowZ, rowW);
        return dest;
    }

    public static java.nio.FloatBuffer makeOuterProduct_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer col, int colOffset, java.nio.FloatBuffer row, int rowOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _colBase = UnsafeOpsHolder.U.getLong(col, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) colOffset * 4L;
        long _rowBase = UnsafeOpsHolder.U.getLong(row, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rowOffset * 4L;
        Float4x4OpsKernelsAddress.makeOuterProduct_unsafe(_destBase, _colBase, _rowBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeOuterProduct_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer col, int colOffset, java.nio.FloatBuffer row, int rowOffset) {
        if (dest.hasArray() && col.hasArray() && row.hasArray()) {
            Float4x4Ops.makeOuterProduct(dest.array(), dest.arrayOffset() + destOffset, col.array(), col.arrayOffset() + colOffset, row.array(), row.arrayOffset() + rowOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeOuterProduct_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(col.duplicate().position(0)), (long) colOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(row.duplicate().position(0)), (long) rowOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer arcball_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float radius, float centerX, float centerY, float centerZ, float angleX, float angleY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.arcball_unsafe(_destBase, _srcBase, radius, centerX, centerY, centerZ, angleX, angleY);
        return dest;
    }

    public static java.nio.FloatBuffer arcball_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float radius, float centerX, float centerY, float centerZ, float angleX, float angleY) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.arcball(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, radius, centerX, centerY, centerZ, angleX, angleY);
            return dest;
        }
        Float4x4OpsKernelsSegment.arcball_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, radius, centerX, centerY, centerZ, angleX, angleY);
        return dest;
    }

    public static java.nio.FloatBuffer arcball_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer center, int centerOffset, float radius, float angleX, float angleY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _centerBase = UnsafeOpsHolder.U.getLong(center, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) centerOffset * 4L;
        Float4x4OpsKernelsAddress.arcball_unsafe(_destBase, _srcBase, _centerBase, radius, angleX, angleY);
        return dest;
    }

    public static java.nio.FloatBuffer arcball_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer center, int centerOffset, float radius, float angleX, float angleY) {
        if (dest.hasArray() && src.hasArray() && center.hasArray()) {
            Float4x4Ops.arcball(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, center.array(), center.arrayOffset() + centerOffset, radius, angleX, angleY);
            return dest;
        }
        Float4x4OpsKernelsSegment.arcball_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(center.duplicate().position(0)), (long) centerOffset * 4L, radius, angleX, angleY);
        return dest;
    }

    public static java.nio.FloatBuffer axonometricDimetric_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float alpha) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.axonometricDimetric_unsafe(_destBase, _srcBase, alpha);
        return dest;
    }

    public static java.nio.FloatBuffer axonometricDimetric_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float alpha) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.axonometricDimetric(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, alpha);
            return dest;
        }
        Float4x4OpsKernelsSegment.axonometricDimetric_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, alpha);
        return dest;
    }

    public static java.nio.FloatBuffer axonometricIsometric_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.axonometricIsometric_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer axonometricIsometric_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.axonometricIsometric(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.axonometricIsometric_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer axonometricTrimetric_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float alphaX, float alphaY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.axonometricTrimetric_unsafe(_destBase, _srcBase, alphaX, alphaY);
        return dest;
    }

    public static java.nio.FloatBuffer axonometricTrimetric_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float alphaX, float alphaY) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.axonometricTrimetric(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, alphaX, alphaY);
            return dest;
        }
        Float4x4OpsKernelsSegment.axonometricTrimetric_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, alphaX, alphaY);
        return dest;
    }

    public static java.nio.FloatBuffer composeTRS_unsafe(java.nio.FloatBuffer dest, int destOffset, float translationX, float translationY, float translationZ, float rotationX, float rotationY, float rotationZ, float rotationW, float scaleX, float scaleY, float scaleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.composeTRS_unsafe(_destBase, translationX, translationY, translationZ, rotationX, rotationY, rotationZ, rotationW, scaleX, scaleY, scaleZ);
        return dest;
    }

    public static java.nio.FloatBuffer composeTRS_api(java.nio.FloatBuffer dest, int destOffset, float translationX, float translationY, float translationZ, float rotationX, float rotationY, float rotationZ, float rotationW, float scaleX, float scaleY, float scaleZ) {
        if (dest.hasArray()) {
            Float4x4Ops.composeTRS(dest.array(), dest.arrayOffset() + destOffset, translationX, translationY, translationZ, rotationX, rotationY, rotationZ, rotationW, scaleX, scaleY, scaleZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.composeTRS_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, translationX, translationY, translationZ, rotationX, rotationY, rotationZ, rotationW, scaleX, scaleY, scaleZ);
        return dest;
    }

    public static java.nio.FloatBuffer composeTRS_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer translation, int translationOffset, java.nio.FloatBuffer rotation, int rotationOffset, java.nio.FloatBuffer scale, int scaleOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _translationBase = UnsafeOpsHolder.U.getLong(translation, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) translationOffset * 4L;
        long _rotationBase = UnsafeOpsHolder.U.getLong(rotation, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rotationOffset * 4L;
        long _scaleBase = UnsafeOpsHolder.U.getLong(scale, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) scaleOffset * 4L;
        Float4x4OpsKernelsAddress.composeTRS_unsafe(_destBase, _translationBase, _rotationBase, _scaleBase);
        return dest;
    }

    public static java.nio.FloatBuffer composeTRS_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer translation, int translationOffset, java.nio.FloatBuffer rotation, int rotationOffset, java.nio.FloatBuffer scale, int scaleOffset) {
        if (dest.hasArray() && translation.hasArray() && rotation.hasArray() && scale.hasArray()) {
            Float4x4Ops.composeTRS(dest.array(), dest.arrayOffset() + destOffset, translation.array(), translation.arrayOffset() + translationOffset, rotation.array(), rotation.arrayOffset() + rotationOffset, scale.array(), scale.arrayOffset() + scaleOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.composeTRS_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(translation.duplicate().position(0)), (long) translationOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(rotation.duplicate().position(0)), (long) rotationOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(scale.duplicate().position(0)), (long) scaleOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer composeTRSMul_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer m, int mOffset, float translationX, float translationY, float translationZ, float rotationX, float rotationY, float rotationZ, float rotationW, float scaleX, float scaleY, float scaleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _mBase = UnsafeOpsHolder.U.getLong(m, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) mOffset * 4L;
        Float4x4OpsKernelsAddress.composeTRSMul_unsafe(_destBase, _mBase, translationX, translationY, translationZ, rotationX, rotationY, rotationZ, rotationW, scaleX, scaleY, scaleZ);
        return dest;
    }

    public static java.nio.FloatBuffer composeTRSMul_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer m, int mOffset, float translationX, float translationY, float translationZ, float rotationX, float rotationY, float rotationZ, float rotationW, float scaleX, float scaleY, float scaleZ) {
        if (dest.hasArray() && m.hasArray()) {
            Float4x4Ops.composeTRSMul(dest.array(), dest.arrayOffset() + destOffset, m.array(), m.arrayOffset() + mOffset, translationX, translationY, translationZ, rotationX, rotationY, rotationZ, rotationW, scaleX, scaleY, scaleZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.composeTRSMul_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(m.duplicate().position(0)), (long) mOffset * 4L, translationX, translationY, translationZ, rotationX, rotationY, rotationZ, rotationW, scaleX, scaleY, scaleZ);
        return dest;
    }

    public static java.nio.FloatBuffer composeTRSMul_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer translation, int translationOffset, java.nio.FloatBuffer rotation, int rotationOffset, java.nio.FloatBuffer scale, int scaleOffset, java.nio.FloatBuffer m, int mOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _translationBase = UnsafeOpsHolder.U.getLong(translation, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) translationOffset * 4L;
        long _rotationBase = UnsafeOpsHolder.U.getLong(rotation, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rotationOffset * 4L;
        long _scaleBase = UnsafeOpsHolder.U.getLong(scale, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) scaleOffset * 4L;
        long _mBase = UnsafeOpsHolder.U.getLong(m, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) mOffset * 4L;
        Float4x4OpsKernelsAddress.composeTRSMul_unsafe(_destBase, _translationBase, _rotationBase, _scaleBase, _mBase);
        return dest;
    }

    public static java.nio.FloatBuffer composeTRSMul_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer translation, int translationOffset, java.nio.FloatBuffer rotation, int rotationOffset, java.nio.FloatBuffer scale, int scaleOffset, java.nio.FloatBuffer m, int mOffset) {
        if (dest.hasArray() && translation.hasArray() && rotation.hasArray() && scale.hasArray() && m.hasArray()) {
            Float4x4Ops.composeTRSMul(dest.array(), dest.arrayOffset() + destOffset, translation.array(), translation.arrayOffset() + translationOffset, rotation.array(), rotation.arrayOffset() + rotationOffset, scale.array(), scale.arrayOffset() + scaleOffset, m.array(), m.arrayOffset() + mOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.composeTRSMul_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(translation.duplicate().position(0)), (long) translationOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(rotation.duplicate().position(0)), (long) rotationOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(scale.duplicate().position(0)), (long) scaleOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(m.duplicate().position(0)), (long) mOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer frustum_no_lh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Float4x4OpsKernelsTypedBuffer.frustum_no_lh_unsafe(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
        return Float4x4OpsKernelsTypedBuffer.frustum_no_lh_api(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
    }

    public static java.nio.FloatBuffer frustum_no_lh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.frustum_no_lh_unsafe(_destBase, _srcBase, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.FloatBuffer frustum_no_lh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4OpsKernelsArray.frustum_no_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, left, right, bottom, top, zNear, zFar);
            return dest;
        }
        Float4x4OpsKernelsSegment.frustum_no_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.FloatBuffer frustum_no_rh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Float4x4OpsKernelsTypedBuffer.frustum_no_rh_unsafe(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
        return Float4x4OpsKernelsTypedBuffer.frustum_no_rh_api(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
    }

    public static java.nio.FloatBuffer frustum_no_rh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.frustum_no_rh_unsafe(_destBase, _srcBase, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.FloatBuffer frustum_no_rh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4OpsKernelsArray.frustum_no_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, left, right, bottom, top, zNear, zFar);
            return dest;
        }
        Float4x4OpsKernelsSegment.frustum_no_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.FloatBuffer frustum_no(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsTypedBuffer.frustum_no_lh(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar); }
            default -> { return Float4x4OpsKernelsTypedBuffer.frustum_no_rh(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar); }
        }
    }

    public static java.nio.FloatBuffer frustum_zo_lh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Float4x4OpsKernelsTypedBuffer.frustum_zo_lh_unsafe(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
        return Float4x4OpsKernelsTypedBuffer.frustum_zo_lh_api(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
    }

    public static java.nio.FloatBuffer frustum_zo_lh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.frustum_zo_lh_unsafe(_destBase, _srcBase, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.FloatBuffer frustum_zo_lh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4OpsKernelsArray.frustum_zo_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, left, right, bottom, top, zNear, zFar);
            return dest;
        }
        Float4x4OpsKernelsSegment.frustum_zo_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.FloatBuffer frustum_zo_rh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Float4x4OpsKernelsTypedBuffer.frustum_zo_rh_unsafe(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
        return Float4x4OpsKernelsTypedBuffer.frustum_zo_rh_api(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
    }

    public static java.nio.FloatBuffer frustum_zo_rh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.frustum_zo_rh_unsafe(_destBase, _srcBase, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.FloatBuffer frustum_zo_rh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4OpsKernelsArray.frustum_zo_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, left, right, bottom, top, zNear, zFar);
            return dest;
        }
        Float4x4OpsKernelsSegment.frustum_zo_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.FloatBuffer frustum_zo(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsTypedBuffer.frustum_zo_lh(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar); }
            default -> { return Float4x4OpsKernelsTypedBuffer.frustum_zo_rh(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar); }
        }
    }

    public static java.nio.FloatBuffer lookAlong_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.lookAlong_unsafe(_destBase, _srcBase, dirX, dirY, dirZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.FloatBuffer lookAlong_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.lookAlong(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, dirX, dirY, dirZ, upX, upY, upZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.lookAlong_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, dirX, dirY, dirZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.FloatBuffer lookAlong_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer dir, int dirOffset, java.nio.FloatBuffer up, int upOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _dirBase = UnsafeOpsHolder.U.getLong(dir, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) dirOffset * 4L;
        long _upBase = UnsafeOpsHolder.U.getLong(up, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) upOffset * 4L;
        Float4x4OpsKernelsAddress.lookAlong_unsafe(_destBase, _srcBase, _dirBase, _upBase);
        return dest;
    }

    public static java.nio.FloatBuffer lookAlong_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer dir, int dirOffset, java.nio.FloatBuffer up, int upOffset) {
        if (dest.hasArray() && src.hasArray() && dir.hasArray() && up.hasArray()) {
            Float4x4Ops.lookAlong(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, dir.array(), dir.arrayOffset() + dirOffset, up.array(), up.arrayOffset() + upOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.lookAlong_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(dir.duplicate().position(0)), (long) dirOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(up.duplicate().position(0)), (long) upOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer lookAt_lh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Float4x4OpsKernelsTypedBuffer.lookAt_lh_unsafe(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return Float4x4OpsKernelsTypedBuffer.lookAt_lh_api(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
    }

    public static java.nio.FloatBuffer lookAt_lh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.lookAt_lh_unsafe(_destBase, _srcBase, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.FloatBuffer lookAt_lh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4OpsKernelsArray.lookAt_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.lookAt_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.FloatBuffer lookAt_rh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Float4x4OpsKernelsTypedBuffer.lookAt_rh_unsafe(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return Float4x4OpsKernelsTypedBuffer.lookAt_rh_api(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
    }

    public static java.nio.FloatBuffer lookAt_rh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.lookAt_rh_unsafe(_destBase, _srcBase, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.FloatBuffer lookAt_rh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4OpsKernelsArray.lookAt_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.lookAt_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.FloatBuffer lookAt_lh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer eye, int eyeOffset, java.nio.FloatBuffer center, int centerOffset, java.nio.FloatBuffer up, int upOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && eye.isDirect() && center.isDirect() && up.isDirect()) return Float4x4OpsKernelsTypedBuffer.lookAt_lh_unsafe(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
        return Float4x4OpsKernelsTypedBuffer.lookAt_lh_api(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
    }

    public static java.nio.FloatBuffer lookAt_lh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer eye, int eyeOffset, java.nio.FloatBuffer center, int centerOffset, java.nio.FloatBuffer up, int upOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _eyeBase = UnsafeOpsHolder.U.getLong(eye, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) eyeOffset * 4L;
        long _centerBase = UnsafeOpsHolder.U.getLong(center, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) centerOffset * 4L;
        long _upBase = UnsafeOpsHolder.U.getLong(up, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) upOffset * 4L;
        Float4x4OpsKernelsAddress.lookAt_lh_unsafe(_destBase, _srcBase, _eyeBase, _centerBase, _upBase);
        return dest;
    }

    public static java.nio.FloatBuffer lookAt_lh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer eye, int eyeOffset, java.nio.FloatBuffer center, int centerOffset, java.nio.FloatBuffer up, int upOffset) {
        if (dest.hasArray() && src.hasArray() && eye.hasArray() && center.hasArray() && up.hasArray()) {
            Float4x4OpsKernelsArray.lookAt_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, eye.array(), eye.arrayOffset() + eyeOffset, center.array(), center.arrayOffset() + centerOffset, up.array(), up.arrayOffset() + upOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.lookAt_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(eye.duplicate().position(0)), (long) eyeOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(center.duplicate().position(0)), (long) centerOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(up.duplicate().position(0)), (long) upOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer lookAt_rh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer eye, int eyeOffset, java.nio.FloatBuffer center, int centerOffset, java.nio.FloatBuffer up, int upOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && eye.isDirect() && center.isDirect() && up.isDirect()) return Float4x4OpsKernelsTypedBuffer.lookAt_rh_unsafe(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
        return Float4x4OpsKernelsTypedBuffer.lookAt_rh_api(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
    }

    public static java.nio.FloatBuffer lookAt_rh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer eye, int eyeOffset, java.nio.FloatBuffer center, int centerOffset, java.nio.FloatBuffer up, int upOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _eyeBase = UnsafeOpsHolder.U.getLong(eye, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) eyeOffset * 4L;
        long _centerBase = UnsafeOpsHolder.U.getLong(center, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) centerOffset * 4L;
        long _upBase = UnsafeOpsHolder.U.getLong(up, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) upOffset * 4L;
        Float4x4OpsKernelsAddress.lookAt_rh_unsafe(_destBase, _srcBase, _eyeBase, _centerBase, _upBase);
        return dest;
    }

    public static java.nio.FloatBuffer lookAt_rh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer eye, int eyeOffset, java.nio.FloatBuffer center, int centerOffset, java.nio.FloatBuffer up, int upOffset) {
        if (dest.hasArray() && src.hasArray() && eye.hasArray() && center.hasArray() && up.hasArray()) {
            Float4x4OpsKernelsArray.lookAt_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, eye.array(), eye.arrayOffset() + eyeOffset, center.array(), center.arrayOffset() + centerOffset, up.array(), up.arrayOffset() + upOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.lookAt_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(eye.duplicate().position(0)), (long) eyeOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(center.duplicate().position(0)), (long) centerOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(up.duplicate().position(0)), (long) upOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeArcball_unsafe(java.nio.FloatBuffer dest, int destOffset, float radius, float centerX, float centerY, float centerZ, float angleX, float angleY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeArcball_unsafe(_destBase, radius, centerX, centerY, centerZ, angleX, angleY);
        return dest;
    }

    public static java.nio.FloatBuffer makeArcball_api(java.nio.FloatBuffer dest, int destOffset, float radius, float centerX, float centerY, float centerZ, float angleX, float angleY) {
        if (dest.hasArray()) {
            Float4x4Ops.makeArcball(dest.array(), dest.arrayOffset() + destOffset, radius, centerX, centerY, centerZ, angleX, angleY);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeArcball_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, radius, centerX, centerY, centerZ, angleX, angleY);
        return dest;
    }

    public static java.nio.FloatBuffer makeArcball_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer center, int centerOffset, float radius, float angleX, float angleY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _centerBase = UnsafeOpsHolder.U.getLong(center, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) centerOffset * 4L;
        Float4x4OpsKernelsAddress.makeArcball_unsafe(_destBase, _centerBase, radius, angleX, angleY);
        return dest;
    }

    public static java.nio.FloatBuffer makeArcball_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer center, int centerOffset, float radius, float angleX, float angleY) {
        if (dest.hasArray() && center.hasArray()) {
            Float4x4Ops.makeArcball(dest.array(), dest.arrayOffset() + destOffset, center.array(), center.arrayOffset() + centerOffset, radius, angleX, angleY);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeArcball_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(center.duplicate().position(0)), (long) centerOffset * 4L, radius, angleX, angleY);
        return dest;
    }

    public static java.nio.FloatBuffer makeAxonometricDimetric_unsafe(java.nio.FloatBuffer dest, int destOffset, float alpha) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeAxonometricDimetric_unsafe(_destBase, alpha);
        return dest;
    }

    public static java.nio.FloatBuffer makeAxonometricDimetric_api(java.nio.FloatBuffer dest, int destOffset, float alpha) {
        if (dest.hasArray()) {
            Float4x4Ops.makeAxonometricDimetric(dest.array(), dest.arrayOffset() + destOffset, alpha);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeAxonometricDimetric_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, alpha);
        return dest;
    }

    public static java.nio.FloatBuffer makeAxonometricIsometric_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeAxonometricIsometric_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeAxonometricIsometric_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeAxonometricIsometric(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeAxonometricIsometric_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeAxonometricTrimetric_unsafe(java.nio.FloatBuffer dest, int destOffset, float alphaX, float alphaY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeAxonometricTrimetric_unsafe(_destBase, alphaX, alphaY);
        return dest;
    }

    public static java.nio.FloatBuffer makeAxonometricTrimetric_api(java.nio.FloatBuffer dest, int destOffset, float alphaX, float alphaY) {
        if (dest.hasArray()) {
            Float4x4Ops.makeAxonometricTrimetric(dest.array(), dest.arrayOffset() + destOffset, alphaX, alphaY);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeAxonometricTrimetric_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, alphaX, alphaY);
        return dest;
    }

    public static java.nio.FloatBuffer makeBillboardCylindrical_unsafe(java.nio.FloatBuffer dest, int destOffset, float objPosX, float objPosY, float objPosZ, float targetPosX, float targetPosY, float targetPosZ, float upX, float upY, float upZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeBillboardCylindrical_unsafe(_destBase, objPosX, objPosY, objPosZ, targetPosX, targetPosY, targetPosZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.FloatBuffer makeBillboardCylindrical_api(java.nio.FloatBuffer dest, int destOffset, float objPosX, float objPosY, float objPosZ, float targetPosX, float targetPosY, float targetPosZ, float upX, float upY, float upZ) {
        if (dest.hasArray()) {
            Float4x4Ops.makeBillboardCylindrical(dest.array(), dest.arrayOffset() + destOffset, objPosX, objPosY, objPosZ, targetPosX, targetPosY, targetPosZ, upX, upY, upZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeBillboardCylindrical_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, objPosX, objPosY, objPosZ, targetPosX, targetPosY, targetPosZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.FloatBuffer makeBillboardCylindrical_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer objPos, int objPosOffset, java.nio.FloatBuffer targetPos, int targetPosOffset, java.nio.FloatBuffer up, int upOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _objPosBase = UnsafeOpsHolder.U.getLong(objPos, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) objPosOffset * 4L;
        long _targetPosBase = UnsafeOpsHolder.U.getLong(targetPos, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) targetPosOffset * 4L;
        long _upBase = UnsafeOpsHolder.U.getLong(up, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) upOffset * 4L;
        Float4x4OpsKernelsAddress.makeBillboardCylindrical_unsafe(_destBase, _objPosBase, _targetPosBase, _upBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeBillboardCylindrical_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer objPos, int objPosOffset, java.nio.FloatBuffer targetPos, int targetPosOffset, java.nio.FloatBuffer up, int upOffset) {
        if (dest.hasArray() && objPos.hasArray() && targetPos.hasArray() && up.hasArray()) {
            Float4x4Ops.makeBillboardCylindrical(dest.array(), dest.arrayOffset() + destOffset, objPos.array(), objPos.arrayOffset() + objPosOffset, targetPos.array(), targetPos.arrayOffset() + targetPosOffset, up.array(), up.arrayOffset() + upOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeBillboardCylindrical_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(objPos.duplicate().position(0)), (long) objPosOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(targetPos.duplicate().position(0)), (long) targetPosOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(up.duplicate().position(0)), (long) upOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeBillboardSpherical_unsafe(java.nio.FloatBuffer dest, int destOffset, float objPosX, float objPosY, float objPosZ, float targetPosX, float targetPosY, float targetPosZ, float upX, float upY, float upZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeBillboardSpherical_unsafe(_destBase, objPosX, objPosY, objPosZ, targetPosX, targetPosY, targetPosZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.FloatBuffer makeBillboardSpherical_api(java.nio.FloatBuffer dest, int destOffset, float objPosX, float objPosY, float objPosZ, float targetPosX, float targetPosY, float targetPosZ, float upX, float upY, float upZ) {
        if (dest.hasArray()) {
            Float4x4Ops.makeBillboardSpherical(dest.array(), dest.arrayOffset() + destOffset, objPosX, objPosY, objPosZ, targetPosX, targetPosY, targetPosZ, upX, upY, upZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeBillboardSpherical_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, objPosX, objPosY, objPosZ, targetPosX, targetPosY, targetPosZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.FloatBuffer makeBillboardSpherical_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer objPos, int objPosOffset, java.nio.FloatBuffer targetPos, int targetPosOffset, java.nio.FloatBuffer up, int upOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _objPosBase = UnsafeOpsHolder.U.getLong(objPos, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) objPosOffset * 4L;
        long _targetPosBase = UnsafeOpsHolder.U.getLong(targetPos, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) targetPosOffset * 4L;
        long _upBase = UnsafeOpsHolder.U.getLong(up, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) upOffset * 4L;
        Float4x4OpsKernelsAddress.makeBillboardSpherical_unsafe(_destBase, _objPosBase, _targetPosBase, _upBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeBillboardSpherical_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer objPos, int objPosOffset, java.nio.FloatBuffer targetPos, int targetPosOffset, java.nio.FloatBuffer up, int upOffset) {
        if (dest.hasArray() && objPos.hasArray() && targetPos.hasArray() && up.hasArray()) {
            Float4x4Ops.makeBillboardSpherical(dest.array(), dest.arrayOffset() + destOffset, objPos.array(), objPos.arrayOffset() + objPosOffset, targetPos.array(), targetPos.arrayOffset() + targetPosOffset, up.array(), up.arrayOffset() + upOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeBillboardSpherical_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(objPos.duplicate().position(0)), (long) objPosOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(targetPos.duplicate().position(0)), (long) targetPosOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(up.duplicate().position(0)), (long) upOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeBillboardSphericalShortest_unsafe(java.nio.FloatBuffer dest, int destOffset, float objPosX, float objPosY, float objPosZ, float targetPosX, float targetPosY, float targetPosZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeBillboardSphericalShortest_unsafe(_destBase, objPosX, objPosY, objPosZ, targetPosX, targetPosY, targetPosZ);
        return dest;
    }

    public static java.nio.FloatBuffer makeBillboardSphericalShortest_api(java.nio.FloatBuffer dest, int destOffset, float objPosX, float objPosY, float objPosZ, float targetPosX, float targetPosY, float targetPosZ) {
        if (dest.hasArray()) {
            Float4x4Ops.makeBillboardSphericalShortest(dest.array(), dest.arrayOffset() + destOffset, objPosX, objPosY, objPosZ, targetPosX, targetPosY, targetPosZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeBillboardSphericalShortest_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, objPosX, objPosY, objPosZ, targetPosX, targetPosY, targetPosZ);
        return dest;
    }

    public static java.nio.FloatBuffer makeBillboardSphericalShortest_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer objPos, int objPosOffset, java.nio.FloatBuffer targetPos, int targetPosOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _objPosBase = UnsafeOpsHolder.U.getLong(objPos, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) objPosOffset * 4L;
        long _targetPosBase = UnsafeOpsHolder.U.getLong(targetPos, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) targetPosOffset * 4L;
        Float4x4OpsKernelsAddress.makeBillboardSphericalShortest_unsafe(_destBase, _objPosBase, _targetPosBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeBillboardSphericalShortest_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer objPos, int objPosOffset, java.nio.FloatBuffer targetPos, int targetPosOffset) {
        if (dest.hasArray() && objPos.hasArray() && targetPos.hasArray()) {
            Float4x4Ops.makeBillboardSphericalShortest(dest.array(), dest.arrayOffset() + destOffset, objPos.array(), objPos.arrayOffset() + objPosOffset, targetPos.array(), targetPos.arrayOffset() + targetPosOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeBillboardSphericalShortest_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(objPos.duplicate().position(0)), (long) objPosOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(targetPos.duplicate().position(0)), (long) targetPosOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeFromDualQuat_unsafe(java.nio.FloatBuffer dest, int destOffset, float dqRX, float dqRY, float dqRZ, float dqRW, float dqDX, float dqDY, float dqDZ, float dqDW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeFromDualQuat_unsafe(_destBase, dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW);
        return dest;
    }

    public static java.nio.FloatBuffer makeFromDualQuat_api(java.nio.FloatBuffer dest, int destOffset, float dqRX, float dqRY, float dqRZ, float dqRW, float dqDX, float dqDY, float dqDZ, float dqDW) {
        if (dest.hasArray()) {
            Float4x4Ops.makeFromDualQuat(dest.array(), dest.arrayOffset() + destOffset, dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeFromDualQuat_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW);
        return dest;
    }

    public static java.nio.FloatBuffer makeFrustum_no_lh(java.nio.FloatBuffer dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Float4x4OpsKernelsTypedBuffer.makeFrustum_no_lh_unsafe(dest, destOffset, left, right, bottom, top, zNear, zFar);
        return Float4x4OpsKernelsTypedBuffer.makeFrustum_no_lh_api(dest, destOffset, left, right, bottom, top, zNear, zFar);
    }

    public static java.nio.FloatBuffer makeFrustum_no_lh_unsafe(java.nio.FloatBuffer dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeFrustum_no_lh_unsafe(_destBase, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.FloatBuffer makeFrustum_no_lh_api(java.nio.FloatBuffer dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (dest.hasArray()) {
            Float4x4OpsKernelsArray.makeFrustum_no_lh(dest.array(), dest.arrayOffset() + destOffset, left, right, bottom, top, zNear, zFar);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeFrustum_no_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.FloatBuffer makeFrustum_no_rh(java.nio.FloatBuffer dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Float4x4OpsKernelsTypedBuffer.makeFrustum_no_rh_unsafe(dest, destOffset, left, right, bottom, top, zNear, zFar);
        return Float4x4OpsKernelsTypedBuffer.makeFrustum_no_rh_api(dest, destOffset, left, right, bottom, top, zNear, zFar);
    }

    public static java.nio.FloatBuffer makeFrustum_no_rh_unsafe(java.nio.FloatBuffer dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeFrustum_no_rh_unsafe(_destBase, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.FloatBuffer makeFrustum_no_rh_api(java.nio.FloatBuffer dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (dest.hasArray()) {
            Float4x4OpsKernelsArray.makeFrustum_no_rh(dest.array(), dest.arrayOffset() + destOffset, left, right, bottom, top, zNear, zFar);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeFrustum_no_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.FloatBuffer makeFrustum_no(java.nio.FloatBuffer dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsTypedBuffer.makeFrustum_no_lh(dest, destOffset, left, right, bottom, top, zNear, zFar); }
            default -> { return Float4x4OpsKernelsTypedBuffer.makeFrustum_no_rh(dest, destOffset, left, right, bottom, top, zNear, zFar); }
        }
    }

    public static java.nio.FloatBuffer makeFrustum_zo_lh(java.nio.FloatBuffer dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Float4x4OpsKernelsTypedBuffer.makeFrustum_zo_lh_unsafe(dest, destOffset, left, right, bottom, top, zNear, zFar);
        return Float4x4OpsKernelsTypedBuffer.makeFrustum_zo_lh_api(dest, destOffset, left, right, bottom, top, zNear, zFar);
    }

    public static java.nio.FloatBuffer makeFrustum_zo_lh_unsafe(java.nio.FloatBuffer dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeFrustum_zo_lh_unsafe(_destBase, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.FloatBuffer makeFrustum_zo_lh_api(java.nio.FloatBuffer dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (dest.hasArray()) {
            Float4x4OpsKernelsArray.makeFrustum_zo_lh(dest.array(), dest.arrayOffset() + destOffset, left, right, bottom, top, zNear, zFar);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeFrustum_zo_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.FloatBuffer makeFrustum_zo_rh(java.nio.FloatBuffer dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Float4x4OpsKernelsTypedBuffer.makeFrustum_zo_rh_unsafe(dest, destOffset, left, right, bottom, top, zNear, zFar);
        return Float4x4OpsKernelsTypedBuffer.makeFrustum_zo_rh_api(dest, destOffset, left, right, bottom, top, zNear, zFar);
    }

    public static java.nio.FloatBuffer makeFrustum_zo_rh_unsafe(java.nio.FloatBuffer dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeFrustum_zo_rh_unsafe(_destBase, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.FloatBuffer makeFrustum_zo_rh_api(java.nio.FloatBuffer dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (dest.hasArray()) {
            Float4x4OpsKernelsArray.makeFrustum_zo_rh(dest.array(), dest.arrayOffset() + destOffset, left, right, bottom, top, zNear, zFar);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeFrustum_zo_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.FloatBuffer makeFrustum_zo(java.nio.FloatBuffer dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsTypedBuffer.makeFrustum_zo_lh(dest, destOffset, left, right, bottom, top, zNear, zFar); }
            default -> { return Float4x4OpsKernelsTypedBuffer.makeFrustum_zo_rh(dest, destOffset, left, right, bottom, top, zNear, zFar); }
        }
    }

    public static java.nio.FloatBuffer makeLookAt_lh(java.nio.FloatBuffer dest, int destOffset, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Float4x4OpsKernelsTypedBuffer.makeLookAt_lh_unsafe(dest, destOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return Float4x4OpsKernelsTypedBuffer.makeLookAt_lh_api(dest, destOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
    }

    public static java.nio.FloatBuffer makeLookAt_lh_unsafe(java.nio.FloatBuffer dest, int destOffset, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeLookAt_lh_unsafe(_destBase, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.FloatBuffer makeLookAt_lh_api(java.nio.FloatBuffer dest, int destOffset, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        if (dest.hasArray()) {
            Float4x4OpsKernelsArray.makeLookAt_lh(dest.array(), dest.arrayOffset() + destOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeLookAt_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.FloatBuffer makeLookAt_rh(java.nio.FloatBuffer dest, int destOffset, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Float4x4OpsKernelsTypedBuffer.makeLookAt_rh_unsafe(dest, destOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return Float4x4OpsKernelsTypedBuffer.makeLookAt_rh_api(dest, destOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
    }

    public static java.nio.FloatBuffer makeLookAt_rh_unsafe(java.nio.FloatBuffer dest, int destOffset, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeLookAt_rh_unsafe(_destBase, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.FloatBuffer makeLookAt_rh_api(java.nio.FloatBuffer dest, int destOffset, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        if (dest.hasArray()) {
            Float4x4OpsKernelsArray.makeLookAt_rh(dest.array(), dest.arrayOffset() + destOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeLookAt_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.FloatBuffer makeLookAt_lh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer eye, int eyeOffset, java.nio.FloatBuffer center, int centerOffset, java.nio.FloatBuffer up, int upOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && eye.isDirect() && center.isDirect() && up.isDirect()) return Float4x4OpsKernelsTypedBuffer.makeLookAt_lh_unsafe(dest, destOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
        return Float4x4OpsKernelsTypedBuffer.makeLookAt_lh_api(dest, destOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
    }

    public static java.nio.FloatBuffer makeLookAt_lh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer eye, int eyeOffset, java.nio.FloatBuffer center, int centerOffset, java.nio.FloatBuffer up, int upOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _eyeBase = UnsafeOpsHolder.U.getLong(eye, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) eyeOffset * 4L;
        long _centerBase = UnsafeOpsHolder.U.getLong(center, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) centerOffset * 4L;
        long _upBase = UnsafeOpsHolder.U.getLong(up, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) upOffset * 4L;
        Float4x4OpsKernelsAddress.makeLookAt_lh_unsafe(_destBase, _eyeBase, _centerBase, _upBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeLookAt_lh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer eye, int eyeOffset, java.nio.FloatBuffer center, int centerOffset, java.nio.FloatBuffer up, int upOffset) {
        if (dest.hasArray() && eye.hasArray() && center.hasArray() && up.hasArray()) {
            Float4x4OpsKernelsArray.makeLookAt_lh(dest.array(), dest.arrayOffset() + destOffset, eye.array(), eye.arrayOffset() + eyeOffset, center.array(), center.arrayOffset() + centerOffset, up.array(), up.arrayOffset() + upOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeLookAt_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(eye.duplicate().position(0)), (long) eyeOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(center.duplicate().position(0)), (long) centerOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(up.duplicate().position(0)), (long) upOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeLookAt_rh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer eye, int eyeOffset, java.nio.FloatBuffer center, int centerOffset, java.nio.FloatBuffer up, int upOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && eye.isDirect() && center.isDirect() && up.isDirect()) return Float4x4OpsKernelsTypedBuffer.makeLookAt_rh_unsafe(dest, destOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
        return Float4x4OpsKernelsTypedBuffer.makeLookAt_rh_api(dest, destOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
    }

    public static java.nio.FloatBuffer makeLookAt_rh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer eye, int eyeOffset, java.nio.FloatBuffer center, int centerOffset, java.nio.FloatBuffer up, int upOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _eyeBase = UnsafeOpsHolder.U.getLong(eye, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) eyeOffset * 4L;
        long _centerBase = UnsafeOpsHolder.U.getLong(center, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) centerOffset * 4L;
        long _upBase = UnsafeOpsHolder.U.getLong(up, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) upOffset * 4L;
        Float4x4OpsKernelsAddress.makeLookAt_rh_unsafe(_destBase, _eyeBase, _centerBase, _upBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeLookAt_rh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer eye, int eyeOffset, java.nio.FloatBuffer center, int centerOffset, java.nio.FloatBuffer up, int upOffset) {
        if (dest.hasArray() && eye.hasArray() && center.hasArray() && up.hasArray()) {
            Float4x4OpsKernelsArray.makeLookAt_rh(dest.array(), dest.arrayOffset() + destOffset, eye.array(), eye.arrayOffset() + eyeOffset, center.array(), center.arrayOffset() + centerOffset, up.array(), up.arrayOffset() + upOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeLookAt_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(eye.duplicate().position(0)), (long) eyeOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(center.duplicate().position(0)), (long) centerOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(up.duplicate().position(0)), (long) upOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingXYnZ_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingXYnZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingXYnZ_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingXYnZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingXYnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingXZY_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingXZY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingXZY_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingXZY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingXZY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingXZnY_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingXZnY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingXZnY_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingXZnY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingXZnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingXnYZ_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingXnYZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingXnYZ_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingXnYZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingXnYZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingXnYnZ_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingXnYnZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingXnYnZ_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingXnYnZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingXnYnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingXnZY_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingXnZY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingXnZY_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingXnZY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingXnZY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingXnZnY_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingXnZnY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingXnZnY_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingXnZnY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingXnZnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingYXZ_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingYXZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingYXZ_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingYXZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingYXZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingYXnZ_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingYXnZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingYXnZ_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingYXnZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingYXnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingYZX_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingYZX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingYZX_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingYZX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingYZX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingYZnX_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingYZnX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingYZnX_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingYZnX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingYZnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingYnXZ_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingYnXZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingYnXZ_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingYnXZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingYnXZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingYnXnZ_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingYnXnZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingYnXnZ_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingYnXnZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingYnXnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingYnZX_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingYnZX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingYnZX_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingYnZX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingYnZX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingYnZnX_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingYnZnX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingYnZnX_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingYnZnX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingYnZnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingZXY_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingZXY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingZXY_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingZXY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingZXY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingZXnY_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingZXnY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingZXnY_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingZXnY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingZXnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingZYX_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingZYX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingZYX_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingZYX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingZYX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingZYnX_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingZYnX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingZYnX_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingZYnX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingZYnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingZnXY_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingZnXY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingZnXY_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingZnXY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingZnXY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingZnXnY_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingZnXnY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingZnXnY_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingZnXnY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingZnXnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingZnYX_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingZnYX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingZnYX_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingZnYX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingZnYX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingZnYnX_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingZnYnX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingZnYnX_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingZnYnX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingZnYnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnXYZ_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingnXYZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnXYZ_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingnXYZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingnXYZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnXYnZ_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingnXYnZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnXYnZ_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingnXYnZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingnXYnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnXZY_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingnXZY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnXZY_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingnXZY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingnXZY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnXZnY_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingnXZnY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnXZnY_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingnXZnY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingnXZnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnXnYZ_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingnXnYZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnXnYZ_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingnXnYZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingnXnYZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnXnYnZ_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingnXnYnZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnXnYnZ_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingnXnYnZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingnXnYnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnXnZY_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingnXnZY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnXnZY_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingnXnZY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingnXnZY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnXnZnY_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingnXnZnY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnXnZnY_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingnXnZnY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingnXnZnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnYXZ_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingnYXZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnYXZ_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingnYXZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingnYXZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnYXnZ_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingnYXnZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnYXnZ_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingnYXnZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingnYXnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnYZX_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingnYZX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnYZX_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingnYZX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingnYZX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnYZnX_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingnYZnX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnYZnX_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingnYZnX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingnYZnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnYnXZ_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingnYnXZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnYnXZ_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingnYnXZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingnYnXZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnYnXnZ_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingnYnXnZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnYnXnZ_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingnYnXnZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingnYnXnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnYnZX_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingnYnZX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnYnZX_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingnYnZX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingnYnZX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnYnZnX_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingnYnZnX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnYnZnX_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingnYnZnX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingnYnZnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnZXY_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingnZXY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnZXY_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingnZXY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingnZXY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnZXnY_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingnZXnY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnZXnY_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingnZXnY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingnZXnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnZYX_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingnZYX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnZYX_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingnZYX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingnZYX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnZYnX_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingnZYnX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnZYnX_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingnZYnX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingnZYnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnZnXY_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingnZnXY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnZnXY_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingnZnXY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingnZnXY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnZnXnY_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingnZnXnY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnZnXnY_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingnZnXnY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingnZnXnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnZnYX_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingnZnYX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnZnYX_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingnZnYX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingnZnYX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnZnYnX_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeMappingnZnYnX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeMappingnZnYnX_api(java.nio.FloatBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Float4x4Ops.makeMappingnZnYnX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeMappingnZnYnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeObliqueCabinet_unsafe(java.nio.FloatBuffer dest, int destOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeObliqueCabinet_unsafe(_destBase, angle);
        return dest;
    }

    public static java.nio.FloatBuffer makeObliqueCabinet_api(java.nio.FloatBuffer dest, int destOffset, float angle) {
        if (dest.hasArray()) {
            Float4x4Ops.makeObliqueCabinet(dest.array(), dest.arrayOffset() + destOffset, angle);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeObliqueCabinet_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, angle);
        return dest;
    }

    public static java.nio.FloatBuffer makeObliqueCavalier_unsafe(java.nio.FloatBuffer dest, int destOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeObliqueCavalier_unsafe(_destBase, angle);
        return dest;
    }

    public static java.nio.FloatBuffer makeObliqueCavalier_api(java.nio.FloatBuffer dest, int destOffset, float angle) {
        if (dest.hasArray()) {
            Float4x4Ops.makeObliqueCavalier(dest.array(), dest.arrayOffset() + destOffset, angle);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeObliqueCavalier_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, angle);
        return dest;
    }

    public static java.nio.FloatBuffer makeObliqueMilitary_unsafe(java.nio.FloatBuffer dest, int destOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeObliqueMilitary_unsafe(_destBase, angle);
        return dest;
    }

    public static java.nio.FloatBuffer makeObliqueMilitary_api(java.nio.FloatBuffer dest, int destOffset, float angle) {
        if (dest.hasArray()) {
            Float4x4Ops.makeObliqueMilitary(dest.array(), dest.arrayOffset() + destOffset, angle);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeObliqueMilitary_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, angle);
        return dest;
    }

    public static java.nio.FloatBuffer makeOrtho_no_lh(java.nio.FloatBuffer dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Float4x4OpsKernelsTypedBuffer.makeOrtho_no_lh_unsafe(dest, destOffset, left, right, bottom, top, zNear, zFar);
        return Float4x4OpsKernelsTypedBuffer.makeOrtho_no_lh_api(dest, destOffset, left, right, bottom, top, zNear, zFar);
    }

    public static java.nio.FloatBuffer makeOrtho_no_lh_unsafe(java.nio.FloatBuffer dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeOrtho_no_lh_unsafe(_destBase, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.FloatBuffer makeOrtho_no_lh_api(java.nio.FloatBuffer dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (dest.hasArray()) {
            Float4x4OpsKernelsArray.makeOrtho_no_lh(dest.array(), dest.arrayOffset() + destOffset, left, right, bottom, top, zNear, zFar);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeOrtho_no_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.FloatBuffer makeOrtho_no_rh(java.nio.FloatBuffer dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Float4x4OpsKernelsTypedBuffer.makeOrtho_no_rh_unsafe(dest, destOffset, left, right, bottom, top, zNear, zFar);
        return Float4x4OpsKernelsTypedBuffer.makeOrtho_no_rh_api(dest, destOffset, left, right, bottom, top, zNear, zFar);
    }

    public static java.nio.FloatBuffer makeOrtho_no_rh_unsafe(java.nio.FloatBuffer dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeOrtho_no_rh_unsafe(_destBase, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.FloatBuffer makeOrtho_no_rh_api(java.nio.FloatBuffer dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (dest.hasArray()) {
            Float4x4OpsKernelsArray.makeOrtho_no_rh(dest.array(), dest.arrayOffset() + destOffset, left, right, bottom, top, zNear, zFar);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeOrtho_no_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.FloatBuffer makeOrtho_no(java.nio.FloatBuffer dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsTypedBuffer.makeOrtho_no_lh(dest, destOffset, left, right, bottom, top, zNear, zFar); }
            default -> { return Float4x4OpsKernelsTypedBuffer.makeOrtho_no_rh(dest, destOffset, left, right, bottom, top, zNear, zFar); }
        }
    }

    public static java.nio.FloatBuffer makeOrtho_zo_lh(java.nio.FloatBuffer dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Float4x4OpsKernelsTypedBuffer.makeOrtho_zo_lh_unsafe(dest, destOffset, left, right, bottom, top, zNear, zFar);
        return Float4x4OpsKernelsTypedBuffer.makeOrtho_zo_lh_api(dest, destOffset, left, right, bottom, top, zNear, zFar);
    }

    public static java.nio.FloatBuffer makeOrtho_zo_lh_unsafe(java.nio.FloatBuffer dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeOrtho_zo_lh_unsafe(_destBase, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.FloatBuffer makeOrtho_zo_lh_api(java.nio.FloatBuffer dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (dest.hasArray()) {
            Float4x4OpsKernelsArray.makeOrtho_zo_lh(dest.array(), dest.arrayOffset() + destOffset, left, right, bottom, top, zNear, zFar);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeOrtho_zo_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.FloatBuffer makeOrtho_zo_rh(java.nio.FloatBuffer dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Float4x4OpsKernelsTypedBuffer.makeOrtho_zo_rh_unsafe(dest, destOffset, left, right, bottom, top, zNear, zFar);
        return Float4x4OpsKernelsTypedBuffer.makeOrtho_zo_rh_api(dest, destOffset, left, right, bottom, top, zNear, zFar);
    }

    public static java.nio.FloatBuffer makeOrtho_zo_rh_unsafe(java.nio.FloatBuffer dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeOrtho_zo_rh_unsafe(_destBase, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.FloatBuffer makeOrtho_zo_rh_api(java.nio.FloatBuffer dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (dest.hasArray()) {
            Float4x4OpsKernelsArray.makeOrtho_zo_rh(dest.array(), dest.arrayOffset() + destOffset, left, right, bottom, top, zNear, zFar);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeOrtho_zo_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.FloatBuffer makeOrtho_zo(java.nio.FloatBuffer dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsTypedBuffer.makeOrtho_zo_lh(dest, destOffset, left, right, bottom, top, zNear, zFar); }
            default -> { return Float4x4OpsKernelsTypedBuffer.makeOrtho_zo_rh(dest, destOffset, left, right, bottom, top, zNear, zFar); }
        }
    }

    public static java.nio.FloatBuffer makeOrtho2D_no_lh(java.nio.FloatBuffer dest, int destOffset, float left, float right, float bottom, float top) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Float4x4OpsKernelsTypedBuffer.makeOrtho2D_no_lh_unsafe(dest, destOffset, left, right, bottom, top);
        return Float4x4OpsKernelsTypedBuffer.makeOrtho2D_no_lh_api(dest, destOffset, left, right, bottom, top);
    }

    public static java.nio.FloatBuffer makeOrtho2D_no_lh_unsafe(java.nio.FloatBuffer dest, int destOffset, float left, float right, float bottom, float top) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeOrtho2D_no_lh_unsafe(_destBase, left, right, bottom, top);
        return dest;
    }

    public static java.nio.FloatBuffer makeOrtho2D_no_lh_api(java.nio.FloatBuffer dest, int destOffset, float left, float right, float bottom, float top) {
        if (dest.hasArray()) {
            Float4x4OpsKernelsArray.makeOrtho2D_no_lh(dest.array(), dest.arrayOffset() + destOffset, left, right, bottom, top);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeOrtho2D_no_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, left, right, bottom, top);
        return dest;
    }

    public static java.nio.FloatBuffer makeOrtho2D_no_rh(java.nio.FloatBuffer dest, int destOffset, float left, float right, float bottom, float top) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Float4x4OpsKernelsTypedBuffer.makeOrtho2D_no_rh_unsafe(dest, destOffset, left, right, bottom, top);
        return Float4x4OpsKernelsTypedBuffer.makeOrtho2D_no_rh_api(dest, destOffset, left, right, bottom, top);
    }

    public static java.nio.FloatBuffer makeOrtho2D_no_rh_unsafe(java.nio.FloatBuffer dest, int destOffset, float left, float right, float bottom, float top) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeOrtho2D_no_rh_unsafe(_destBase, left, right, bottom, top);
        return dest;
    }

    public static java.nio.FloatBuffer makeOrtho2D_no_rh_api(java.nio.FloatBuffer dest, int destOffset, float left, float right, float bottom, float top) {
        if (dest.hasArray()) {
            Float4x4OpsKernelsArray.makeOrtho2D_no_rh(dest.array(), dest.arrayOffset() + destOffset, left, right, bottom, top);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeOrtho2D_no_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, left, right, bottom, top);
        return dest;
    }

    public static java.nio.FloatBuffer makeOrtho2D_no(java.nio.FloatBuffer dest, int destOffset, float left, float right, float bottom, float top, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsTypedBuffer.makeOrtho2D_no_lh(dest, destOffset, left, right, bottom, top); }
            default -> { return Float4x4OpsKernelsTypedBuffer.makeOrtho2D_no_rh(dest, destOffset, left, right, bottom, top); }
        }
    }

    public static java.nio.FloatBuffer makeOrtho2D_zo_lh(java.nio.FloatBuffer dest, int destOffset, float left, float right, float bottom, float top) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Float4x4OpsKernelsTypedBuffer.makeOrtho2D_zo_lh_unsafe(dest, destOffset, left, right, bottom, top);
        return Float4x4OpsKernelsTypedBuffer.makeOrtho2D_zo_lh_api(dest, destOffset, left, right, bottom, top);
    }

    public static java.nio.FloatBuffer makeOrtho2D_zo_lh_unsafe(java.nio.FloatBuffer dest, int destOffset, float left, float right, float bottom, float top) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeOrtho2D_zo_lh_unsafe(_destBase, left, right, bottom, top);
        return dest;
    }

    public static java.nio.FloatBuffer makeOrtho2D_zo_lh_api(java.nio.FloatBuffer dest, int destOffset, float left, float right, float bottom, float top) {
        if (dest.hasArray()) {
            Float4x4OpsKernelsArray.makeOrtho2D_zo_lh(dest.array(), dest.arrayOffset() + destOffset, left, right, bottom, top);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeOrtho2D_zo_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, left, right, bottom, top);
        return dest;
    }

    public static java.nio.FloatBuffer makeOrtho2D_zo_rh(java.nio.FloatBuffer dest, int destOffset, float left, float right, float bottom, float top) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Float4x4OpsKernelsTypedBuffer.makeOrtho2D_zo_rh_unsafe(dest, destOffset, left, right, bottom, top);
        return Float4x4OpsKernelsTypedBuffer.makeOrtho2D_zo_rh_api(dest, destOffset, left, right, bottom, top);
    }

    public static java.nio.FloatBuffer makeOrtho2D_zo_rh_unsafe(java.nio.FloatBuffer dest, int destOffset, float left, float right, float bottom, float top) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeOrtho2D_zo_rh_unsafe(_destBase, left, right, bottom, top);
        return dest;
    }

    public static java.nio.FloatBuffer makeOrtho2D_zo_rh_api(java.nio.FloatBuffer dest, int destOffset, float left, float right, float bottom, float top) {
        if (dest.hasArray()) {
            Float4x4OpsKernelsArray.makeOrtho2D_zo_rh(dest.array(), dest.arrayOffset() + destOffset, left, right, bottom, top);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeOrtho2D_zo_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, left, right, bottom, top);
        return dest;
    }

    public static java.nio.FloatBuffer makeOrtho2D_zo(java.nio.FloatBuffer dest, int destOffset, float left, float right, float bottom, float top, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsTypedBuffer.makeOrtho2D_zo_lh(dest, destOffset, left, right, bottom, top); }
            default -> { return Float4x4OpsKernelsTypedBuffer.makeOrtho2D_zo_rh(dest, destOffset, left, right, bottom, top); }
        }
    }

    public static java.nio.FloatBuffer makePerspective_no_lh(java.nio.FloatBuffer dest, int destOffset, float fovy, float aspect, float near, float far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Float4x4OpsKernelsTypedBuffer.makePerspective_no_lh_unsafe(dest, destOffset, fovy, aspect, near, far);
        return Float4x4OpsKernelsTypedBuffer.makePerspective_no_lh_api(dest, destOffset, fovy, aspect, near, far);
    }

    public static java.nio.FloatBuffer makePerspective_no_lh_unsafe(java.nio.FloatBuffer dest, int destOffset, float fovy, float aspect, float near, float far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makePerspective_no_lh_unsafe(_destBase, fovy, aspect, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspective_no_lh_api(java.nio.FloatBuffer dest, int destOffset, float fovy, float aspect, float near, float far) {
        if (dest.hasArray()) {
            Float4x4OpsKernelsArray.makePerspective_no_lh(dest.array(), dest.arrayOffset() + destOffset, fovy, aspect, near, far);
            return dest;
        }
        Float4x4OpsKernelsSegment.makePerspective_no_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, fovy, aspect, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspective_no_rh(java.nio.FloatBuffer dest, int destOffset, float fovy, float aspect, float near, float far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Float4x4OpsKernelsTypedBuffer.makePerspective_no_rh_unsafe(dest, destOffset, fovy, aspect, near, far);
        return Float4x4OpsKernelsTypedBuffer.makePerspective_no_rh_api(dest, destOffset, fovy, aspect, near, far);
    }

    public static java.nio.FloatBuffer makePerspective_no_rh_unsafe(java.nio.FloatBuffer dest, int destOffset, float fovy, float aspect, float near, float far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makePerspective_no_rh_unsafe(_destBase, fovy, aspect, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspective_no_rh_api(java.nio.FloatBuffer dest, int destOffset, float fovy, float aspect, float near, float far) {
        if (dest.hasArray()) {
            Float4x4OpsKernelsArray.makePerspective_no_rh(dest.array(), dest.arrayOffset() + destOffset, fovy, aspect, near, far);
            return dest;
        }
        Float4x4OpsKernelsSegment.makePerspective_no_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, fovy, aspect, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspective_no(java.nio.FloatBuffer dest, int destOffset, float fovy, float aspect, float near, float far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsTypedBuffer.makePerspective_no_lh(dest, destOffset, fovy, aspect, near, far); }
            default -> { return Float4x4OpsKernelsTypedBuffer.makePerspective_no_rh(dest, destOffset, fovy, aspect, near, far); }
        }
    }

    public static java.nio.FloatBuffer makePerspective_zo_lh(java.nio.FloatBuffer dest, int destOffset, float fovy, float aspect, float near, float far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Float4x4OpsKernelsTypedBuffer.makePerspective_zo_lh_unsafe(dest, destOffset, fovy, aspect, near, far);
        return Float4x4OpsKernelsTypedBuffer.makePerspective_zo_lh_api(dest, destOffset, fovy, aspect, near, far);
    }

    public static java.nio.FloatBuffer makePerspective_zo_lh_unsafe(java.nio.FloatBuffer dest, int destOffset, float fovy, float aspect, float near, float far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makePerspective_zo_lh_unsafe(_destBase, fovy, aspect, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspective_zo_lh_api(java.nio.FloatBuffer dest, int destOffset, float fovy, float aspect, float near, float far) {
        if (dest.hasArray()) {
            Float4x4OpsKernelsArray.makePerspective_zo_lh(dest.array(), dest.arrayOffset() + destOffset, fovy, aspect, near, far);
            return dest;
        }
        Float4x4OpsKernelsSegment.makePerspective_zo_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, fovy, aspect, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspective_zo_rh(java.nio.FloatBuffer dest, int destOffset, float fovy, float aspect, float near, float far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Float4x4OpsKernelsTypedBuffer.makePerspective_zo_rh_unsafe(dest, destOffset, fovy, aspect, near, far);
        return Float4x4OpsKernelsTypedBuffer.makePerspective_zo_rh_api(dest, destOffset, fovy, aspect, near, far);
    }

    public static java.nio.FloatBuffer makePerspective_zo_rh_unsafe(java.nio.FloatBuffer dest, int destOffset, float fovy, float aspect, float near, float far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makePerspective_zo_rh_unsafe(_destBase, fovy, aspect, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspective_zo_rh_api(java.nio.FloatBuffer dest, int destOffset, float fovy, float aspect, float near, float far) {
        if (dest.hasArray()) {
            Float4x4OpsKernelsArray.makePerspective_zo_rh(dest.array(), dest.arrayOffset() + destOffset, fovy, aspect, near, far);
            return dest;
        }
        Float4x4OpsKernelsSegment.makePerspective_zo_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, fovy, aspect, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspective_zo(java.nio.FloatBuffer dest, int destOffset, float fovy, float aspect, float near, float far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsTypedBuffer.makePerspective_zo_lh(dest, destOffset, fovy, aspect, near, far); }
            default -> { return Float4x4OpsKernelsTypedBuffer.makePerspective_zo_rh(dest, destOffset, fovy, aspect, near, far); }
        }
    }

    public static java.nio.FloatBuffer makePerspectiveFovRange_no_lh(java.nio.FloatBuffer dest, int destOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Float4x4OpsKernelsTypedBuffer.makePerspectiveFovRange_no_lh_unsafe(dest, destOffset, angleMin, angleMax, aspect, near, far);
        return Float4x4OpsKernelsTypedBuffer.makePerspectiveFovRange_no_lh_api(dest, destOffset, angleMin, angleMax, aspect, near, far);
    }

    public static java.nio.FloatBuffer makePerspectiveFovRange_no_lh_unsafe(java.nio.FloatBuffer dest, int destOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makePerspectiveFovRange_no_lh_unsafe(_destBase, angleMin, angleMax, aspect, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspectiveFovRange_no_lh_api(java.nio.FloatBuffer dest, int destOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        if (dest.hasArray()) {
            Float4x4OpsKernelsArray.makePerspectiveFovRange_no_lh(dest.array(), dest.arrayOffset() + destOffset, angleMin, angleMax, aspect, near, far);
            return dest;
        }
        Float4x4OpsKernelsSegment.makePerspectiveFovRange_no_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, angleMin, angleMax, aspect, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspectiveFovRange_no_rh(java.nio.FloatBuffer dest, int destOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Float4x4OpsKernelsTypedBuffer.makePerspectiveFovRange_no_rh_unsafe(dest, destOffset, angleMin, angleMax, aspect, near, far);
        return Float4x4OpsKernelsTypedBuffer.makePerspectiveFovRange_no_rh_api(dest, destOffset, angleMin, angleMax, aspect, near, far);
    }

    public static java.nio.FloatBuffer makePerspectiveFovRange_no_rh_unsafe(java.nio.FloatBuffer dest, int destOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makePerspectiveFovRange_no_rh_unsafe(_destBase, angleMin, angleMax, aspect, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspectiveFovRange_no_rh_api(java.nio.FloatBuffer dest, int destOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        if (dest.hasArray()) {
            Float4x4OpsKernelsArray.makePerspectiveFovRange_no_rh(dest.array(), dest.arrayOffset() + destOffset, angleMin, angleMax, aspect, near, far);
            return dest;
        }
        Float4x4OpsKernelsSegment.makePerspectiveFovRange_no_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, angleMin, angleMax, aspect, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspectiveFovRange_no(java.nio.FloatBuffer dest, int destOffset, float angleMin, float angleMax, float aspect, float near, float far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsTypedBuffer.makePerspectiveFovRange_no_lh(dest, destOffset, angleMin, angleMax, aspect, near, far); }
            default -> { return Float4x4OpsKernelsTypedBuffer.makePerspectiveFovRange_no_rh(dest, destOffset, angleMin, angleMax, aspect, near, far); }
        }
    }

    public static java.nio.FloatBuffer makePerspectiveFovRange_zo_lh(java.nio.FloatBuffer dest, int destOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Float4x4OpsKernelsTypedBuffer.makePerspectiveFovRange_zo_lh_unsafe(dest, destOffset, angleMin, angleMax, aspect, near, far);
        return Float4x4OpsKernelsTypedBuffer.makePerspectiveFovRange_zo_lh_api(dest, destOffset, angleMin, angleMax, aspect, near, far);
    }

    public static java.nio.FloatBuffer makePerspectiveFovRange_zo_lh_unsafe(java.nio.FloatBuffer dest, int destOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makePerspectiveFovRange_zo_lh_unsafe(_destBase, angleMin, angleMax, aspect, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspectiveFovRange_zo_lh_api(java.nio.FloatBuffer dest, int destOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        if (dest.hasArray()) {
            Float4x4OpsKernelsArray.makePerspectiveFovRange_zo_lh(dest.array(), dest.arrayOffset() + destOffset, angleMin, angleMax, aspect, near, far);
            return dest;
        }
        Float4x4OpsKernelsSegment.makePerspectiveFovRange_zo_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, angleMin, angleMax, aspect, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspectiveFovRange_zo_rh(java.nio.FloatBuffer dest, int destOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Float4x4OpsKernelsTypedBuffer.makePerspectiveFovRange_zo_rh_unsafe(dest, destOffset, angleMin, angleMax, aspect, near, far);
        return Float4x4OpsKernelsTypedBuffer.makePerspectiveFovRange_zo_rh_api(dest, destOffset, angleMin, angleMax, aspect, near, far);
    }

    public static java.nio.FloatBuffer makePerspectiveFovRange_zo_rh_unsafe(java.nio.FloatBuffer dest, int destOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makePerspectiveFovRange_zo_rh_unsafe(_destBase, angleMin, angleMax, aspect, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspectiveFovRange_zo_rh_api(java.nio.FloatBuffer dest, int destOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        if (dest.hasArray()) {
            Float4x4OpsKernelsArray.makePerspectiveFovRange_zo_rh(dest.array(), dest.arrayOffset() + destOffset, angleMin, angleMax, aspect, near, far);
            return dest;
        }
        Float4x4OpsKernelsSegment.makePerspectiveFovRange_zo_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, angleMin, angleMax, aspect, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspectiveFovRange_zo(java.nio.FloatBuffer dest, int destOffset, float angleMin, float angleMax, float aspect, float near, float far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsTypedBuffer.makePerspectiveFovRange_zo_lh(dest, destOffset, angleMin, angleMax, aspect, near, far); }
            default -> { return Float4x4OpsKernelsTypedBuffer.makePerspectiveFovRange_zo_rh(dest, destOffset, angleMin, angleMax, aspect, near, far); }
        }
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterFov_no_lh(java.nio.FloatBuffer dest, int destOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Float4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterFov_no_lh_unsafe(dest, destOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
        return Float4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterFov_no_lh_api(dest, destOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterFov_no_lh_unsafe(java.nio.FloatBuffer dest, int destOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makePerspectiveOffCenterFov_no_lh_unsafe(_destBase, angleLeft, angleRight, angleDown, angleUp, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterFov_no_lh_api(java.nio.FloatBuffer dest, int destOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        if (dest.hasArray()) {
            Float4x4OpsKernelsArray.makePerspectiveOffCenterFov_no_lh(dest.array(), dest.arrayOffset() + destOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
            return dest;
        }
        Float4x4OpsKernelsSegment.makePerspectiveOffCenterFov_no_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, angleLeft, angleRight, angleDown, angleUp, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterFov_no_rh(java.nio.FloatBuffer dest, int destOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Float4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterFov_no_rh_unsafe(dest, destOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
        return Float4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterFov_no_rh_api(dest, destOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterFov_no_rh_unsafe(java.nio.FloatBuffer dest, int destOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makePerspectiveOffCenterFov_no_rh_unsafe(_destBase, angleLeft, angleRight, angleDown, angleUp, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterFov_no_rh_api(java.nio.FloatBuffer dest, int destOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        if (dest.hasArray()) {
            Float4x4OpsKernelsArray.makePerspectiveOffCenterFov_no_rh(dest.array(), dest.arrayOffset() + destOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
            return dest;
        }
        Float4x4OpsKernelsSegment.makePerspectiveOffCenterFov_no_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, angleLeft, angleRight, angleDown, angleUp, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterFov_no(java.nio.FloatBuffer dest, int destOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterFov_no_lh(dest, destOffset, angleLeft, angleRight, angleDown, angleUp, near, far); }
            default -> { return Float4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterFov_no_rh(dest, destOffset, angleLeft, angleRight, angleDown, angleUp, near, far); }
        }
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterFov_zo_lh(java.nio.FloatBuffer dest, int destOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Float4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterFov_zo_lh_unsafe(dest, destOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
        return Float4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterFov_zo_lh_api(dest, destOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterFov_zo_lh_unsafe(java.nio.FloatBuffer dest, int destOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makePerspectiveOffCenterFov_zo_lh_unsafe(_destBase, angleLeft, angleRight, angleDown, angleUp, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterFov_zo_lh_api(java.nio.FloatBuffer dest, int destOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        if (dest.hasArray()) {
            Float4x4OpsKernelsArray.makePerspectiveOffCenterFov_zo_lh(dest.array(), dest.arrayOffset() + destOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
            return dest;
        }
        Float4x4OpsKernelsSegment.makePerspectiveOffCenterFov_zo_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, angleLeft, angleRight, angleDown, angleUp, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterFov_zo_rh(java.nio.FloatBuffer dest, int destOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Float4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterFov_zo_rh_unsafe(dest, destOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
        return Float4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterFov_zo_rh_api(dest, destOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterFov_zo_rh_unsafe(java.nio.FloatBuffer dest, int destOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makePerspectiveOffCenterFov_zo_rh_unsafe(_destBase, angleLeft, angleRight, angleDown, angleUp, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterFov_zo_rh_api(java.nio.FloatBuffer dest, int destOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        if (dest.hasArray()) {
            Float4x4OpsKernelsArray.makePerspectiveOffCenterFov_zo_rh(dest.array(), dest.arrayOffset() + destOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
            return dest;
        }
        Float4x4OpsKernelsSegment.makePerspectiveOffCenterFov_zo_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, angleLeft, angleRight, angleDown, angleUp, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterFov_zo(java.nio.FloatBuffer dest, int destOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterFov_zo_lh(dest, destOffset, angleLeft, angleRight, angleDown, angleUp, near, far); }
            default -> { return Float4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterFov_zo_rh(dest, destOffset, angleLeft, angleRight, angleDown, angleUp, near, far); }
        }
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterRectangleProj_no_lh(java.nio.FloatBuffer dest, int destOffset, float eyeX, float eyeY, float eyeZ, float pX, float pY, float pZ, float xX, float xY, float xZ, float yX, float yY, float yZ, float nearFarDist) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Float4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_no_lh_unsafe(dest, destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist);
        return Float4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_no_lh_api(dest, destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist);
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterRectangleProj_no_lh_unsafe(java.nio.FloatBuffer dest, int destOffset, float eyeX, float eyeY, float eyeZ, float pX, float pY, float pZ, float xX, float xY, float xZ, float yX, float yY, float yZ, float nearFarDist) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makePerspectiveOffCenterRectangleProj_no_lh_unsafe(_destBase, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterRectangleProj_no_lh_api(java.nio.FloatBuffer dest, int destOffset, float eyeX, float eyeY, float eyeZ, float pX, float pY, float pZ, float xX, float xY, float xZ, float yX, float yY, float yZ, float nearFarDist) {
        if (dest.hasArray()) {
            Float4x4OpsKernelsArray.makePerspectiveOffCenterRectangleProj_no_lh(dest.array(), dest.arrayOffset() + destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist);
            return dest;
        }
        Float4x4OpsKernelsSegment.makePerspectiveOffCenterRectangleProj_no_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterRectangleProj_no_rh(java.nio.FloatBuffer dest, int destOffset, float eyeX, float eyeY, float eyeZ, float pX, float pY, float pZ, float xX, float xY, float xZ, float yX, float yY, float yZ, float nearFarDist) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Float4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_no_rh_unsafe(dest, destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist);
        return Float4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_no_rh_api(dest, destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist);
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterRectangleProj_no_rh_unsafe(java.nio.FloatBuffer dest, int destOffset, float eyeX, float eyeY, float eyeZ, float pX, float pY, float pZ, float xX, float xY, float xZ, float yX, float yY, float yZ, float nearFarDist) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makePerspectiveOffCenterRectangleProj_no_rh_unsafe(_destBase, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterRectangleProj_no_rh_api(java.nio.FloatBuffer dest, int destOffset, float eyeX, float eyeY, float eyeZ, float pX, float pY, float pZ, float xX, float xY, float xZ, float yX, float yY, float yZ, float nearFarDist) {
        if (dest.hasArray()) {
            Float4x4OpsKernelsArray.makePerspectiveOffCenterRectangleProj_no_rh(dest.array(), dest.arrayOffset() + destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist);
            return dest;
        }
        Float4x4OpsKernelsSegment.makePerspectiveOffCenterRectangleProj_no_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterRectangleProj_no(java.nio.FloatBuffer dest, int destOffset, float eyeX, float eyeY, float eyeZ, float pX, float pY, float pZ, float xX, float xY, float xZ, float yX, float yY, float yZ, float nearFarDist, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_no_lh(dest, destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist); }
            default -> { return Float4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_no_rh(dest, destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist); }
        }
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterRectangleProj_zo_lh(java.nio.FloatBuffer dest, int destOffset, float eyeX, float eyeY, float eyeZ, float pX, float pY, float pZ, float xX, float xY, float xZ, float yX, float yY, float yZ, float nearFarDist) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Float4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_zo_lh_unsafe(dest, destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist);
        return Float4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_zo_lh_api(dest, destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist);
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterRectangleProj_zo_lh_unsafe(java.nio.FloatBuffer dest, int destOffset, float eyeX, float eyeY, float eyeZ, float pX, float pY, float pZ, float xX, float xY, float xZ, float yX, float yY, float yZ, float nearFarDist) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makePerspectiveOffCenterRectangleProj_zo_lh_unsafe(_destBase, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterRectangleProj_zo_lh_api(java.nio.FloatBuffer dest, int destOffset, float eyeX, float eyeY, float eyeZ, float pX, float pY, float pZ, float xX, float xY, float xZ, float yX, float yY, float yZ, float nearFarDist) {
        if (dest.hasArray()) {
            Float4x4OpsKernelsArray.makePerspectiveOffCenterRectangleProj_zo_lh(dest.array(), dest.arrayOffset() + destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist);
            return dest;
        }
        Float4x4OpsKernelsSegment.makePerspectiveOffCenterRectangleProj_zo_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterRectangleProj_zo_rh(java.nio.FloatBuffer dest, int destOffset, float eyeX, float eyeY, float eyeZ, float pX, float pY, float pZ, float xX, float xY, float xZ, float yX, float yY, float yZ, float nearFarDist) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Float4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_zo_rh_unsafe(dest, destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist);
        return Float4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_zo_rh_api(dest, destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist);
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterRectangleProj_zo_rh_unsafe(java.nio.FloatBuffer dest, int destOffset, float eyeX, float eyeY, float eyeZ, float pX, float pY, float pZ, float xX, float xY, float xZ, float yX, float yY, float yZ, float nearFarDist) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makePerspectiveOffCenterRectangleProj_zo_rh_unsafe(_destBase, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterRectangleProj_zo_rh_api(java.nio.FloatBuffer dest, int destOffset, float eyeX, float eyeY, float eyeZ, float pX, float pY, float pZ, float xX, float xY, float xZ, float yX, float yY, float yZ, float nearFarDist) {
        if (dest.hasArray()) {
            Float4x4OpsKernelsArray.makePerspectiveOffCenterRectangleProj_zo_rh(dest.array(), dest.arrayOffset() + destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist);
            return dest;
        }
        Float4x4OpsKernelsSegment.makePerspectiveOffCenterRectangleProj_zo_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterRectangleProj_zo(java.nio.FloatBuffer dest, int destOffset, float eyeX, float eyeY, float eyeZ, float pX, float pY, float pZ, float xX, float xY, float xZ, float yX, float yY, float yZ, float nearFarDist, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_zo_lh(dest, destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist); }
            default -> { return Float4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_zo_rh(dest, destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist); }
        }
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterRectangleProj_no_lh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer eye, int eyeOffset, java.nio.FloatBuffer p, int pOffset, java.nio.FloatBuffer x, int xOffset, java.nio.FloatBuffer y, int yOffset, float nearFarDist) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && eye.isDirect() && p.isDirect() && x.isDirect() && y.isDirect()) return Float4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_no_lh_unsafe(dest, destOffset, eye, eyeOffset, p, pOffset, x, xOffset, y, yOffset, nearFarDist);
        return Float4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_no_lh_api(dest, destOffset, eye, eyeOffset, p, pOffset, x, xOffset, y, yOffset, nearFarDist);
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterRectangleProj_no_lh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer eye, int eyeOffset, java.nio.FloatBuffer p, int pOffset, java.nio.FloatBuffer x, int xOffset, java.nio.FloatBuffer y, int yOffset, float nearFarDist) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _eyeBase = UnsafeOpsHolder.U.getLong(eye, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) eyeOffset * 4L;
        long _pBase = UnsafeOpsHolder.U.getLong(p, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pOffset * 4L;
        long _xBase = UnsafeOpsHolder.U.getLong(x, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) xOffset * 4L;
        long _yBase = UnsafeOpsHolder.U.getLong(y, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) yOffset * 4L;
        Float4x4OpsKernelsAddress.makePerspectiveOffCenterRectangleProj_no_lh_unsafe(_destBase, _eyeBase, _pBase, _xBase, _yBase, nearFarDist);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterRectangleProj_no_lh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer eye, int eyeOffset, java.nio.FloatBuffer p, int pOffset, java.nio.FloatBuffer x, int xOffset, java.nio.FloatBuffer y, int yOffset, float nearFarDist) {
        if (dest.hasArray() && eye.hasArray() && p.hasArray() && x.hasArray() && y.hasArray()) {
            Float4x4OpsKernelsArray.makePerspectiveOffCenterRectangleProj_no_lh(dest.array(), dest.arrayOffset() + destOffset, eye.array(), eye.arrayOffset() + eyeOffset, p.array(), p.arrayOffset() + pOffset, x.array(), x.arrayOffset() + xOffset, y.array(), y.arrayOffset() + yOffset, nearFarDist);
            return dest;
        }
        Float4x4OpsKernelsSegment.makePerspectiveOffCenterRectangleProj_no_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(eye.duplicate().position(0)), (long) eyeOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(p.duplicate().position(0)), (long) pOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(x.duplicate().position(0)), (long) xOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(y.duplicate().position(0)), (long) yOffset * 4L, nearFarDist);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterRectangleProj_no_rh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer eye, int eyeOffset, java.nio.FloatBuffer p, int pOffset, java.nio.FloatBuffer x, int xOffset, java.nio.FloatBuffer y, int yOffset, float nearFarDist) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && eye.isDirect() && p.isDirect() && x.isDirect() && y.isDirect()) return Float4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_no_rh_unsafe(dest, destOffset, eye, eyeOffset, p, pOffset, x, xOffset, y, yOffset, nearFarDist);
        return Float4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_no_rh_api(dest, destOffset, eye, eyeOffset, p, pOffset, x, xOffset, y, yOffset, nearFarDist);
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterRectangleProj_no_rh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer eye, int eyeOffset, java.nio.FloatBuffer p, int pOffset, java.nio.FloatBuffer x, int xOffset, java.nio.FloatBuffer y, int yOffset, float nearFarDist) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _eyeBase = UnsafeOpsHolder.U.getLong(eye, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) eyeOffset * 4L;
        long _pBase = UnsafeOpsHolder.U.getLong(p, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pOffset * 4L;
        long _xBase = UnsafeOpsHolder.U.getLong(x, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) xOffset * 4L;
        long _yBase = UnsafeOpsHolder.U.getLong(y, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) yOffset * 4L;
        Float4x4OpsKernelsAddress.makePerspectiveOffCenterRectangleProj_no_rh_unsafe(_destBase, _eyeBase, _pBase, _xBase, _yBase, nearFarDist);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterRectangleProj_no_rh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer eye, int eyeOffset, java.nio.FloatBuffer p, int pOffset, java.nio.FloatBuffer x, int xOffset, java.nio.FloatBuffer y, int yOffset, float nearFarDist) {
        if (dest.hasArray() && eye.hasArray() && p.hasArray() && x.hasArray() && y.hasArray()) {
            Float4x4OpsKernelsArray.makePerspectiveOffCenterRectangleProj_no_rh(dest.array(), dest.arrayOffset() + destOffset, eye.array(), eye.arrayOffset() + eyeOffset, p.array(), p.arrayOffset() + pOffset, x.array(), x.arrayOffset() + xOffset, y.array(), y.arrayOffset() + yOffset, nearFarDist);
            return dest;
        }
        Float4x4OpsKernelsSegment.makePerspectiveOffCenterRectangleProj_no_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(eye.duplicate().position(0)), (long) eyeOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(p.duplicate().position(0)), (long) pOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(x.duplicate().position(0)), (long) xOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(y.duplicate().position(0)), (long) yOffset * 4L, nearFarDist);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterRectangleProj_no(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer eye, int eyeOffset, java.nio.FloatBuffer p, int pOffset, java.nio.FloatBuffer x, int xOffset, java.nio.FloatBuffer y, int yOffset, float nearFarDist, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_no_lh(dest, destOffset, eye, eyeOffset, p, pOffset, x, xOffset, y, yOffset, nearFarDist); }
            default -> { return Float4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_no_rh(dest, destOffset, eye, eyeOffset, p, pOffset, x, xOffset, y, yOffset, nearFarDist); }
        }
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterRectangleProj_zo_lh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer eye, int eyeOffset, java.nio.FloatBuffer p, int pOffset, java.nio.FloatBuffer x, int xOffset, java.nio.FloatBuffer y, int yOffset, float nearFarDist) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && eye.isDirect() && p.isDirect() && x.isDirect() && y.isDirect()) return Float4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_zo_lh_unsafe(dest, destOffset, eye, eyeOffset, p, pOffset, x, xOffset, y, yOffset, nearFarDist);
        return Float4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_zo_lh_api(dest, destOffset, eye, eyeOffset, p, pOffset, x, xOffset, y, yOffset, nearFarDist);
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterRectangleProj_zo_lh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer eye, int eyeOffset, java.nio.FloatBuffer p, int pOffset, java.nio.FloatBuffer x, int xOffset, java.nio.FloatBuffer y, int yOffset, float nearFarDist) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _eyeBase = UnsafeOpsHolder.U.getLong(eye, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) eyeOffset * 4L;
        long _pBase = UnsafeOpsHolder.U.getLong(p, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pOffset * 4L;
        long _xBase = UnsafeOpsHolder.U.getLong(x, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) xOffset * 4L;
        long _yBase = UnsafeOpsHolder.U.getLong(y, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) yOffset * 4L;
        Float4x4OpsKernelsAddress.makePerspectiveOffCenterRectangleProj_zo_lh_unsafe(_destBase, _eyeBase, _pBase, _xBase, _yBase, nearFarDist);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterRectangleProj_zo_lh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer eye, int eyeOffset, java.nio.FloatBuffer p, int pOffset, java.nio.FloatBuffer x, int xOffset, java.nio.FloatBuffer y, int yOffset, float nearFarDist) {
        if (dest.hasArray() && eye.hasArray() && p.hasArray() && x.hasArray() && y.hasArray()) {
            Float4x4OpsKernelsArray.makePerspectiveOffCenterRectangleProj_zo_lh(dest.array(), dest.arrayOffset() + destOffset, eye.array(), eye.arrayOffset() + eyeOffset, p.array(), p.arrayOffset() + pOffset, x.array(), x.arrayOffset() + xOffset, y.array(), y.arrayOffset() + yOffset, nearFarDist);
            return dest;
        }
        Float4x4OpsKernelsSegment.makePerspectiveOffCenterRectangleProj_zo_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(eye.duplicate().position(0)), (long) eyeOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(p.duplicate().position(0)), (long) pOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(x.duplicate().position(0)), (long) xOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(y.duplicate().position(0)), (long) yOffset * 4L, nearFarDist);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterRectangleProj_zo_rh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer eye, int eyeOffset, java.nio.FloatBuffer p, int pOffset, java.nio.FloatBuffer x, int xOffset, java.nio.FloatBuffer y, int yOffset, float nearFarDist) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && eye.isDirect() && p.isDirect() && x.isDirect() && y.isDirect()) return Float4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_zo_rh_unsafe(dest, destOffset, eye, eyeOffset, p, pOffset, x, xOffset, y, yOffset, nearFarDist);
        return Float4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_zo_rh_api(dest, destOffset, eye, eyeOffset, p, pOffset, x, xOffset, y, yOffset, nearFarDist);
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterRectangleProj_zo_rh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer eye, int eyeOffset, java.nio.FloatBuffer p, int pOffset, java.nio.FloatBuffer x, int xOffset, java.nio.FloatBuffer y, int yOffset, float nearFarDist) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _eyeBase = UnsafeOpsHolder.U.getLong(eye, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) eyeOffset * 4L;
        long _pBase = UnsafeOpsHolder.U.getLong(p, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pOffset * 4L;
        long _xBase = UnsafeOpsHolder.U.getLong(x, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) xOffset * 4L;
        long _yBase = UnsafeOpsHolder.U.getLong(y, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) yOffset * 4L;
        Float4x4OpsKernelsAddress.makePerspectiveOffCenterRectangleProj_zo_rh_unsafe(_destBase, _eyeBase, _pBase, _xBase, _yBase, nearFarDist);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterRectangleProj_zo_rh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer eye, int eyeOffset, java.nio.FloatBuffer p, int pOffset, java.nio.FloatBuffer x, int xOffset, java.nio.FloatBuffer y, int yOffset, float nearFarDist) {
        if (dest.hasArray() && eye.hasArray() && p.hasArray() && x.hasArray() && y.hasArray()) {
            Float4x4OpsKernelsArray.makePerspectiveOffCenterRectangleProj_zo_rh(dest.array(), dest.arrayOffset() + destOffset, eye.array(), eye.arrayOffset() + eyeOffset, p.array(), p.arrayOffset() + pOffset, x.array(), x.arrayOffset() + xOffset, y.array(), y.arrayOffset() + yOffset, nearFarDist);
            return dest;
        }
        Float4x4OpsKernelsSegment.makePerspectiveOffCenterRectangleProj_zo_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(eye.duplicate().position(0)), (long) eyeOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(p.duplicate().position(0)), (long) pOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(x.duplicate().position(0)), (long) xOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(y.duplicate().position(0)), (long) yOffset * 4L, nearFarDist);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterRectangleProj_zo(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer eye, int eyeOffset, java.nio.FloatBuffer p, int pOffset, java.nio.FloatBuffer x, int xOffset, java.nio.FloatBuffer y, int yOffset, float nearFarDist, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_zo_lh(dest, destOffset, eye, eyeOffset, p, pOffset, x, xOffset, y, yOffset, nearFarDist); }
            default -> { return Float4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_zo_rh(dest, destOffset, eye, eyeOffset, p, pOffset, x, xOffset, y, yOffset, nearFarDist); }
        }
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterRectangleView_lh(java.nio.FloatBuffer dest, int destOffset, float eyeX, float eyeY, float eyeZ, float pX, float pY, float pZ, float xX, float xY, float xZ, float yX, float yY, float yZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Float4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleView_lh_unsafe(dest, destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ);
        return Float4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleView_lh_api(dest, destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ);
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterRectangleView_lh_unsafe(java.nio.FloatBuffer dest, int destOffset, float eyeX, float eyeY, float eyeZ, float pX, float pY, float pZ, float xX, float xY, float xZ, float yX, float yY, float yZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makePerspectiveOffCenterRectangleView_lh_unsafe(_destBase, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterRectangleView_lh_api(java.nio.FloatBuffer dest, int destOffset, float eyeX, float eyeY, float eyeZ, float pX, float pY, float pZ, float xX, float xY, float xZ, float yX, float yY, float yZ) {
        if (dest.hasArray()) {
            Float4x4OpsKernelsArray.makePerspectiveOffCenterRectangleView_lh(dest.array(), dest.arrayOffset() + destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.makePerspectiveOffCenterRectangleView_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterRectangleView_rh(java.nio.FloatBuffer dest, int destOffset, float eyeX, float eyeY, float eyeZ, float pX, float pY, float pZ, float xX, float xY, float xZ, float yX, float yY, float yZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Float4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleView_rh_unsafe(dest, destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ);
        return Float4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleView_rh_api(dest, destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ);
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterRectangleView_rh_unsafe(java.nio.FloatBuffer dest, int destOffset, float eyeX, float eyeY, float eyeZ, float pX, float pY, float pZ, float xX, float xY, float xZ, float yX, float yY, float yZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makePerspectiveOffCenterRectangleView_rh_unsafe(_destBase, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterRectangleView_rh_api(java.nio.FloatBuffer dest, int destOffset, float eyeX, float eyeY, float eyeZ, float pX, float pY, float pZ, float xX, float xY, float xZ, float yX, float yY, float yZ) {
        if (dest.hasArray()) {
            Float4x4OpsKernelsArray.makePerspectiveOffCenterRectangleView_rh(dest.array(), dest.arrayOffset() + destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.makePerspectiveOffCenterRectangleView_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterRectangleView_lh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer eye, int eyeOffset, java.nio.FloatBuffer p, int pOffset, java.nio.FloatBuffer x, int xOffset, java.nio.FloatBuffer y, int yOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && eye.isDirect() && p.isDirect() && x.isDirect() && y.isDirect()) return Float4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleView_lh_unsafe(dest, destOffset, eye, eyeOffset, p, pOffset, x, xOffset, y, yOffset);
        return Float4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleView_lh_api(dest, destOffset, eye, eyeOffset, p, pOffset, x, xOffset, y, yOffset);
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterRectangleView_lh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer eye, int eyeOffset, java.nio.FloatBuffer p, int pOffset, java.nio.FloatBuffer x, int xOffset, java.nio.FloatBuffer y, int yOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _eyeBase = UnsafeOpsHolder.U.getLong(eye, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) eyeOffset * 4L;
        long _pBase = UnsafeOpsHolder.U.getLong(p, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pOffset * 4L;
        long _xBase = UnsafeOpsHolder.U.getLong(x, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) xOffset * 4L;
        long _yBase = UnsafeOpsHolder.U.getLong(y, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) yOffset * 4L;
        Float4x4OpsKernelsAddress.makePerspectiveOffCenterRectangleView_lh_unsafe(_destBase, _eyeBase, _pBase, _xBase, _yBase);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterRectangleView_lh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer eye, int eyeOffset, java.nio.FloatBuffer p, int pOffset, java.nio.FloatBuffer x, int xOffset, java.nio.FloatBuffer y, int yOffset) {
        if (dest.hasArray() && eye.hasArray() && p.hasArray() && x.hasArray() && y.hasArray()) {
            Float4x4OpsKernelsArray.makePerspectiveOffCenterRectangleView_lh(dest.array(), dest.arrayOffset() + destOffset, eye.array(), eye.arrayOffset() + eyeOffset, p.array(), p.arrayOffset() + pOffset, x.array(), x.arrayOffset() + xOffset, y.array(), y.arrayOffset() + yOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makePerspectiveOffCenterRectangleView_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(eye.duplicate().position(0)), (long) eyeOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(p.duplicate().position(0)), (long) pOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(x.duplicate().position(0)), (long) xOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(y.duplicate().position(0)), (long) yOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterRectangleView_rh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer eye, int eyeOffset, java.nio.FloatBuffer p, int pOffset, java.nio.FloatBuffer x, int xOffset, java.nio.FloatBuffer y, int yOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && eye.isDirect() && p.isDirect() && x.isDirect() && y.isDirect()) return Float4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleView_rh_unsafe(dest, destOffset, eye, eyeOffset, p, pOffset, x, xOffset, y, yOffset);
        return Float4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleView_rh_api(dest, destOffset, eye, eyeOffset, p, pOffset, x, xOffset, y, yOffset);
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterRectangleView_rh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer eye, int eyeOffset, java.nio.FloatBuffer p, int pOffset, java.nio.FloatBuffer x, int xOffset, java.nio.FloatBuffer y, int yOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _eyeBase = UnsafeOpsHolder.U.getLong(eye, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) eyeOffset * 4L;
        long _pBase = UnsafeOpsHolder.U.getLong(p, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pOffset * 4L;
        long _xBase = UnsafeOpsHolder.U.getLong(x, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) xOffset * 4L;
        long _yBase = UnsafeOpsHolder.U.getLong(y, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) yOffset * 4L;
        Float4x4OpsKernelsAddress.makePerspectiveOffCenterRectangleView_rh_unsafe(_destBase, _eyeBase, _pBase, _xBase, _yBase);
        return dest;
    }

    public static java.nio.FloatBuffer makePerspectiveOffCenterRectangleView_rh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer eye, int eyeOffset, java.nio.FloatBuffer p, int pOffset, java.nio.FloatBuffer x, int xOffset, java.nio.FloatBuffer y, int yOffset) {
        if (dest.hasArray() && eye.hasArray() && p.hasArray() && x.hasArray() && y.hasArray()) {
            Float4x4OpsKernelsArray.makePerspectiveOffCenterRectangleView_rh(dest.array(), dest.arrayOffset() + destOffset, eye.array(), eye.arrayOffset() + eyeOffset, p.array(), p.arrayOffset() + pOffset, x.array(), x.arrayOffset() + xOffset, y.array(), y.arrayOffset() + yOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makePerspectiveOffCenterRectangleView_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(eye.duplicate().position(0)), (long) eyeOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(p.duplicate().position(0)), (long) pOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(x.duplicate().position(0)), (long) xOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(y.duplicate().position(0)), (long) yOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makePickMatrix_unsafe(java.nio.FloatBuffer dest, int destOffset, float centerX, float centerY, float deltaX, float deltaY, float vpX, float vpY, float vpW, float vpH) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makePickMatrix_unsafe(_destBase, centerX, centerY, deltaX, deltaY, vpX, vpY, vpW, vpH);
        return dest;
    }

    public static java.nio.FloatBuffer makePickMatrix_api(java.nio.FloatBuffer dest, int destOffset, float centerX, float centerY, float deltaX, float deltaY, float vpX, float vpY, float vpW, float vpH) {
        if (dest.hasArray()) {
            Float4x4Ops.makePickMatrix(dest.array(), dest.arrayOffset() + destOffset, centerX, centerY, deltaX, deltaY, vpX, vpY, vpW, vpH);
            return dest;
        }
        Float4x4OpsKernelsSegment.makePickMatrix_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, centerX, centerY, deltaX, deltaY, vpX, vpY, vpW, vpH);
        return dest;
    }

    public static java.nio.FloatBuffer makeReflection_unsafe(java.nio.FloatBuffer dest, int destOffset, float normalX, float normalY, float normalZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeReflection_unsafe(_destBase, normalX, normalY, normalZ);
        return dest;
    }

    public static java.nio.FloatBuffer makeReflection_api(java.nio.FloatBuffer dest, int destOffset, float normalX, float normalY, float normalZ) {
        if (dest.hasArray()) {
            Float4x4Ops.makeReflection(dest.array(), dest.arrayOffset() + destOffset, normalX, normalY, normalZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeReflection_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, normalX, normalY, normalZ);
        return dest;
    }

    public static java.nio.FloatBuffer makeReflection_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer normal, int normalOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _normalBase = UnsafeOpsHolder.U.getLong(normal, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) normalOffset * 4L;
        Float4x4OpsKernelsAddress.makeReflection_unsafe(_destBase, _normalBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeReflection_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer normal, int normalOffset) {
        if (dest.hasArray() && normal.hasArray()) {
            Float4x4Ops.makeReflection(dest.array(), dest.arrayOffset() + destOffset, normal.array(), normal.arrayOffset() + normalOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeReflection_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(normal.duplicate().position(0)), (long) normalOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationAxis_unsafe(java.nio.FloatBuffer dest, int destOffset, float angle, float axisX, float axisY, float axisZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeRotationAxis_unsafe(_destBase, angle, axisX, axisY, axisZ);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationAxis_api(java.nio.FloatBuffer dest, int destOffset, float angle, float axisX, float axisY, float axisZ) {
        if (dest.hasArray()) {
            Float4x4Ops.makeRotationAxis(dest.array(), dest.arrayOffset() + destOffset, angle, axisX, axisY, axisZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeRotationAxis_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, angle, axisX, axisY, axisZ);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationAxis_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer axis, int axisOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _axisBase = UnsafeOpsHolder.U.getLong(axis, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) axisOffset * 4L;
        Float4x4OpsKernelsAddress.makeRotationAxis_unsafe(_destBase, _axisBase, angle);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationAxis_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer axis, int axisOffset, float angle) {
        if (dest.hasArray() && axis.hasArray()) {
            Float4x4Ops.makeRotationAxis(dest.array(), dest.arrayOffset() + destOffset, axis.array(), axis.arrayOffset() + axisOffset, angle);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeRotationAxis_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(axis.duplicate().position(0)), (long) axisOffset * 4L, angle);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationLookAlong_unsafe(java.nio.FloatBuffer dest, int destOffset, float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeRotationLookAlong_unsafe(_destBase, dirX, dirY, dirZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationLookAlong_api(java.nio.FloatBuffer dest, int destOffset, float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        if (dest.hasArray()) {
            Float4x4Ops.makeRotationLookAlong(dest.array(), dest.arrayOffset() + destOffset, dirX, dirY, dirZ, upX, upY, upZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeRotationLookAlong_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, dirX, dirY, dirZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationLookAlong_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer dir, int dirOffset, java.nio.FloatBuffer up, int upOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _dirBase = UnsafeOpsHolder.U.getLong(dir, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) dirOffset * 4L;
        long _upBase = UnsafeOpsHolder.U.getLong(up, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) upOffset * 4L;
        Float4x4OpsKernelsAddress.makeRotationLookAlong_unsafe(_destBase, _dirBase, _upBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationLookAlong_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer dir, int dirOffset, java.nio.FloatBuffer up, int upOffset) {
        if (dest.hasArray() && dir.hasArray() && up.hasArray()) {
            Float4x4Ops.makeRotationLookAlong(dest.array(), dest.arrayOffset() + destOffset, dir.array(), dir.arrayOffset() + dirOffset, up.array(), up.arrayOffset() + upOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeRotationLookAlong_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(dir.duplicate().position(0)), (long) dirOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(up.duplicate().position(0)), (long) upOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationQuat_unsafe(java.nio.FloatBuffer dest, int destOffset, float qX, float qY, float qZ, float qW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeRotationQuat_unsafe(_destBase, qX, qY, qZ, qW);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationQuat_api(java.nio.FloatBuffer dest, int destOffset, float qX, float qY, float qZ, float qW) {
        if (dest.hasArray()) {
            Float4x4Ops.makeRotationQuat(dest.array(), dest.arrayOffset() + destOffset, qX, qY, qZ, qW);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeRotationQuat_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, qX, qY, qZ, qW);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationQuat_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer q, int qOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _qBase = UnsafeOpsHolder.U.getLong(q, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) qOffset * 4L;
        Float4x4OpsKernelsAddress.makeRotationQuat_unsafe(_destBase, _qBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationQuat_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer q, int qOffset) {
        if (dest.hasArray() && q.hasArray()) {
            Float4x4Ops.makeRotationQuat(dest.array(), dest.arrayOffset() + destOffset, q.array(), q.arrayOffset() + qOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeRotationQuat_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(q.duplicate().position(0)), (long) qOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationX_unsafe(java.nio.FloatBuffer dest, int destOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeRotationX_unsafe(_destBase, angle);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationX_api(java.nio.FloatBuffer dest, int destOffset, float angle) {
        if (dest.hasArray()) {
            Float4x4Ops.makeRotationX(dest.array(), dest.arrayOffset() + destOffset, angle);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeRotationX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, angle);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationXYZ_unsafe(java.nio.FloatBuffer dest, int destOffset, float angleX, float angleY, float angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeRotationXYZ_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationXYZ_api(java.nio.FloatBuffer dest, int destOffset, float angleX, float angleY, float angleZ) {
        if (dest.hasArray()) {
            Float4x4Ops.makeRotationXYZ(dest.array(), dest.arrayOffset() + destOffset, angleX, angleY, angleZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeRotationXYZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationXZY_unsafe(java.nio.FloatBuffer dest, int destOffset, float angleX, float angleY, float angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeRotationXZY_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationXZY_api(java.nio.FloatBuffer dest, int destOffset, float angleX, float angleY, float angleZ) {
        if (dest.hasArray()) {
            Float4x4Ops.makeRotationXZY(dest.array(), dest.arrayOffset() + destOffset, angleX, angleY, angleZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeRotationXZY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationY_unsafe(java.nio.FloatBuffer dest, int destOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeRotationY_unsafe(_destBase, angle);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationY_api(java.nio.FloatBuffer dest, int destOffset, float angle) {
        if (dest.hasArray()) {
            Float4x4Ops.makeRotationY(dest.array(), dest.arrayOffset() + destOffset, angle);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeRotationY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, angle);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationYXZ_unsafe(java.nio.FloatBuffer dest, int destOffset, float angleX, float angleY, float angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeRotationYXZ_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationYXZ_api(java.nio.FloatBuffer dest, int destOffset, float angleX, float angleY, float angleZ) {
        if (dest.hasArray()) {
            Float4x4Ops.makeRotationYXZ(dest.array(), dest.arrayOffset() + destOffset, angleX, angleY, angleZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeRotationYXZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationYZX_unsafe(java.nio.FloatBuffer dest, int destOffset, float angleX, float angleY, float angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeRotationYZX_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationYZX_api(java.nio.FloatBuffer dest, int destOffset, float angleX, float angleY, float angleZ) {
        if (dest.hasArray()) {
            Float4x4Ops.makeRotationYZX(dest.array(), dest.arrayOffset() + destOffset, angleX, angleY, angleZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeRotationYZX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationZ_unsafe(java.nio.FloatBuffer dest, int destOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeRotationZ_unsafe(_destBase, angle);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationZ_api(java.nio.FloatBuffer dest, int destOffset, float angle) {
        if (dest.hasArray()) {
            Float4x4Ops.makeRotationZ(dest.array(), dest.arrayOffset() + destOffset, angle);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeRotationZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, angle);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationZXY_unsafe(java.nio.FloatBuffer dest, int destOffset, float angleX, float angleY, float angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeRotationZXY_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationZXY_api(java.nio.FloatBuffer dest, int destOffset, float angleX, float angleY, float angleZ) {
        if (dest.hasArray()) {
            Float4x4Ops.makeRotationZXY(dest.array(), dest.arrayOffset() + destOffset, angleX, angleY, angleZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeRotationZXY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationZYX_unsafe(java.nio.FloatBuffer dest, int destOffset, float angleX, float angleY, float angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeRotationZYX_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationZYX_api(java.nio.FloatBuffer dest, int destOffset, float angleX, float angleY, float angleZ) {
        if (dest.hasArray()) {
            Float4x4Ops.makeRotationZYX(dest.array(), dest.arrayOffset() + destOffset, angleX, angleY, angleZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeRotationZYX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.FloatBuffer makeScaling_unsafe(java.nio.FloatBuffer dest, int destOffset, float vX, float vY, float vZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeScaling_unsafe(_destBase, vX, vY, vZ);
        return dest;
    }

    public static java.nio.FloatBuffer makeScaling_api(java.nio.FloatBuffer dest, int destOffset, float vX, float vY, float vZ) {
        if (dest.hasArray()) {
            Float4x4Ops.makeScaling(dest.array(), dest.arrayOffset() + destOffset, vX, vY, vZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeScaling_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, vX, vY, vZ);
        return dest;
    }

    public static java.nio.FloatBuffer makeScaling_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 4L;
        Float4x4OpsKernelsAddress.makeScaling_unsafe(_destBase, _vBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeScaling_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer v, int vOffset) {
        if (dest.hasArray() && v.hasArray()) {
            Float4x4Ops.makeScaling(dest.array(), dest.arrayOffset() + destOffset, v.array(), v.arrayOffset() + vOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeScaling_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(v.duplicate().position(0)), (long) vOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeScaling_unsafe(java.nio.FloatBuffer dest, int destOffset, float s) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeScaling_unsafe(_destBase, s);
        return dest;
    }

    public static java.nio.FloatBuffer makeScaling_api(java.nio.FloatBuffer dest, int destOffset, float s) {
        if (dest.hasArray()) {
            Float4x4Ops.makeScaling(dest.array(), dest.arrayOffset() + destOffset, s);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeScaling_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, s);
        return dest;
    }

    public static java.nio.FloatBuffer makeShadow_unsafe(java.nio.FloatBuffer dest, int destOffset, float lightX, float lightY, float lightZ, float lightW, float planeX, float planeY, float planeZ, float planeW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeShadow_unsafe(_destBase, lightX, lightY, lightZ, lightW, planeX, planeY, planeZ, planeW);
        return dest;
    }

    public static java.nio.FloatBuffer makeShadow_api(java.nio.FloatBuffer dest, int destOffset, float lightX, float lightY, float lightZ, float lightW, float planeX, float planeY, float planeZ, float planeW) {
        if (dest.hasArray()) {
            Float4x4Ops.makeShadow(dest.array(), dest.arrayOffset() + destOffset, lightX, lightY, lightZ, lightW, planeX, planeY, planeZ, planeW);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeShadow_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, lightX, lightY, lightZ, lightW, planeX, planeY, planeZ, planeW);
        return dest;
    }

    public static java.nio.FloatBuffer makeShadow_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer light, int lightOffset, java.nio.FloatBuffer plane, int planeOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _lightBase = UnsafeOpsHolder.U.getLong(light, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) lightOffset * 4L;
        long _planeBase = UnsafeOpsHolder.U.getLong(plane, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) planeOffset * 4L;
        Float4x4OpsKernelsAddress.makeShadow_unsafe(_destBase, _lightBase, _planeBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeShadow_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer light, int lightOffset, java.nio.FloatBuffer plane, int planeOffset) {
        if (dest.hasArray() && light.hasArray() && plane.hasArray()) {
            Float4x4Ops.makeShadow(dest.array(), dest.arrayOffset() + destOffset, light.array(), light.arrayOffset() + lightOffset, plane.array(), plane.arrayOffset() + planeOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeShadow_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(light.duplicate().position(0)), (long) lightOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(plane.duplicate().position(0)), (long) planeOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeShear_unsafe(java.nio.FloatBuffer dest, int destOffset, float xy, float xz, float yx, float yz, float zx, float zy) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeShear_unsafe(_destBase, xy, xz, yx, yz, zx, zy);
        return dest;
    }

    public static java.nio.FloatBuffer makeShear_api(java.nio.FloatBuffer dest, int destOffset, float xy, float xz, float yx, float yz, float zx, float zy) {
        if (dest.hasArray()) {
            Float4x4Ops.makeShear(dest.array(), dest.arrayOffset() + destOffset, xy, xz, yx, yz, zx, zy);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeShear_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, xy, xz, yx, yz, zx, zy);
        return dest;
    }

    public static java.nio.FloatBuffer makeTile_unsafe(java.nio.FloatBuffer dest, int destOffset, float x, float y, float w, float h) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeTile_unsafe(_destBase, x, y, w, h);
        return dest;
    }

    public static java.nio.FloatBuffer makeTile_api(java.nio.FloatBuffer dest, int destOffset, float x, float y, float w, float h) {
        if (dest.hasArray()) {
            Float4x4Ops.makeTile(dest.array(), dest.arrayOffset() + destOffset, x, y, w, h);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeTile_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, x, y, w, h);
        return dest;
    }

    public static java.nio.FloatBuffer makeTranslation_unsafe(java.nio.FloatBuffer dest, int destOffset, float vX, float vY, float vZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeTranslation_unsafe(_destBase, vX, vY, vZ);
        return dest;
    }

    public static java.nio.FloatBuffer makeTranslation_api(java.nio.FloatBuffer dest, int destOffset, float vX, float vY, float vZ) {
        if (dest.hasArray()) {
            Float4x4Ops.makeTranslation(dest.array(), dest.arrayOffset() + destOffset, vX, vY, vZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeTranslation_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, vX, vY, vZ);
        return dest;
    }

    public static java.nio.FloatBuffer makeTranslation_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 4L;
        Float4x4OpsKernelsAddress.makeTranslation_unsafe(_destBase, _vBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeTranslation_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer v, int vOffset) {
        if (dest.hasArray() && v.hasArray()) {
            Float4x4Ops.makeTranslation(dest.array(), dest.arrayOffset() + destOffset, v.array(), v.arrayOffset() + vOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeTranslation_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(v.duplicate().position(0)), (long) vOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer makeTrapezoidCrop_unsafe(java.nio.FloatBuffer dest, int destOffset, float p0X, float p0Y, float p1X, float p1Y, float p2X, float p2Y, float p3X, float p3Y) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.makeTrapezoidCrop_unsafe(_destBase, p0X, p0Y, p1X, p1Y, p2X, p2Y, p3X, p3Y);
        return dest;
    }

    public static java.nio.FloatBuffer makeTrapezoidCrop_api(java.nio.FloatBuffer dest, int destOffset, float p0X, float p0Y, float p1X, float p1Y, float p2X, float p2Y, float p3X, float p3Y) {
        if (dest.hasArray()) {
            Float4x4Ops.makeTrapezoidCrop(dest.array(), dest.arrayOffset() + destOffset, p0X, p0Y, p1X, p1Y, p2X, p2Y, p3X, p3Y);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeTrapezoidCrop_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, p0X, p0Y, p1X, p1Y, p2X, p2Y, p3X, p3Y);
        return dest;
    }

    public static java.nio.FloatBuffer makeTrapezoidCrop_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer p0, int p0Offset, java.nio.FloatBuffer p1, int p1Offset, java.nio.FloatBuffer p2, int p2Offset, java.nio.FloatBuffer p3, int p3Offset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _p0Base = UnsafeOpsHolder.U.getLong(p0, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p0Offset * 4L;
        long _p1Base = UnsafeOpsHolder.U.getLong(p1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p1Offset * 4L;
        long _p2Base = UnsafeOpsHolder.U.getLong(p2, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p2Offset * 4L;
        long _p3Base = UnsafeOpsHolder.U.getLong(p3, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p3Offset * 4L;
        Float4x4OpsKernelsAddress.makeTrapezoidCrop_unsafe(_destBase, _p0Base, _p1Base, _p2Base, _p3Base);
        return dest;
    }

    public static java.nio.FloatBuffer makeTrapezoidCrop_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer p0, int p0Offset, java.nio.FloatBuffer p1, int p1Offset, java.nio.FloatBuffer p2, int p2Offset, java.nio.FloatBuffer p3, int p3Offset) {
        if (dest.hasArray() && p0.hasArray() && p1.hasArray() && p2.hasArray() && p3.hasArray()) {
            Float4x4Ops.makeTrapezoidCrop(dest.array(), dest.arrayOffset() + destOffset, p0.array(), p0.arrayOffset() + p0Offset, p1.array(), p1.arrayOffset() + p1Offset, p2.array(), p2.arrayOffset() + p2Offset, p3.array(), p3.arrayOffset() + p3Offset);
            return dest;
        }
        Float4x4OpsKernelsSegment.makeTrapezoidCrop_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(p0.duplicate().position(0)), (long) p0Offset * 4L, java.lang.foreign.MemorySegment.ofBuffer(p1.duplicate().position(0)), (long) p1Offset * 4L, java.lang.foreign.MemorySegment.ofBuffer(p2.duplicate().position(0)), (long) p2Offset * 4L, java.lang.foreign.MemorySegment.ofBuffer(p3.duplicate().position(0)), (long) p3Offset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapXYZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapXYZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapXYZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapXYZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapXYZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapXYnZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapXYnZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapXYnZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapXYnZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapXYnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapXZY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapXZY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapXZY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapXZY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapXZY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapXZnY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapXZnY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapXZnY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapXZnY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapXZnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapXnYZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapXnYZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapXnYZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapXnYZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapXnYZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapXnYnZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapXnYnZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapXnYnZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapXnYnZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapXnYnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapXnZY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapXnZY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapXnZY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapXnZY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapXnZY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapXnZnY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapXnZnY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapXnZnY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapXnZnY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapXnZnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapYXZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapYXZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapYXZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapYXZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapYXZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapYXnZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapYXnZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapYXnZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapYXnZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapYXnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapYZX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapYZX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapYZX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapYZX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapYZX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapYZnX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapYZnX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapYZnX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapYZnX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapYZnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapYnXZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapYnXZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapYnXZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapYnXZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapYnXZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapYnXnZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapYnXnZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapYnXnZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapYnXnZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapYnXnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapYnZX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapYnZX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapYnZX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapYnZX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapYnZX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapYnZnX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapYnZnX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapYnZnX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapYnZnX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapYnZnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapZXY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapZXY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapZXY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapZXY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapZXY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapZXnY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapZXnY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapZXnY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapZXnY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapZXnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapZYX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapZYX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapZYX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapZYX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapZYX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapZYnX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapZYnX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapZYnX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapZYnX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapZYnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapZnXY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapZnXY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapZnXY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapZnXY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapZnXY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapZnXnY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapZnXnY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapZnXnY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapZnXnY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapZnXnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapZnYX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapZnYX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapZnYX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapZnYX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapZnYX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapZnYnX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapZnYnX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapZnYnX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapZnYnX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapZnYnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapnXYZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnXYZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnXYZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapnXYZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapnXYZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapnXYnZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnXYnZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnXYnZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapnXYnZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapnXYnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapnXZY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnXZY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnXZY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapnXZY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapnXZY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapnXZnY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnXZnY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnXZnY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapnXZnY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapnXZnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapnXnYZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnXnYZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnXnYZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapnXnYZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapnXnYZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapnXnYnZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnXnYnZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnXnYnZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapnXnYnZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapnXnYnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapnXnZY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnXnZY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnXnZY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapnXnZY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapnXnZY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapnXnZnY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnXnZnY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnXnZnY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapnXnZnY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapnXnZnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapnYXZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnYXZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnYXZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapnYXZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapnYXZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapnYXnZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnYXnZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnYXnZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapnYXnZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapnYXnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapnYZX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnYZX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnYZX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapnYZX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapnYZX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapnYZnX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnYZnX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnYZnX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapnYZnX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapnYZnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapnYnXZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnYnXZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnYnXZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapnYnXZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapnYnXZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapnYnXnZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnYnXnZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnYnXnZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapnYnXnZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapnYnXnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapnYnZX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnYnZX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnYnZX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapnYnZX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapnYnZX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapnYnZnX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnYnZnX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnYnZnX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapnYnZnX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapnYnZnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapnZXY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnZXY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnZXY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapnZXY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapnZXY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapnZXnY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnZXnY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnZXnY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapnZXnY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapnZXnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapnZYX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnZYX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnZYX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapnZYX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapnZYX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapnZYnX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnZYnX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnZYnX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapnZYnX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapnZYnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapnZnXY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnZnXY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnZnXY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapnZnXY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapnZnXY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapnZnXnY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnZnXnY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnZnXnY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapnZnXnY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapnZnXnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapnZnYX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnZnYX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnZnYX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapnZnYX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapnZnYX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer mapnZnYnX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnZnYnX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnZnYnX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mapnZnYnX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mapnZnYnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer obliqueCabinet_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.obliqueCabinet_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.FloatBuffer obliqueCabinet_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.obliqueCabinet(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angle);
            return dest;
        }
        Float4x4OpsKernelsSegment.obliqueCabinet_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, angle);
        return dest;
    }

    public static java.nio.FloatBuffer obliqueCavalier_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.obliqueCavalier_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.FloatBuffer obliqueCavalier_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.obliqueCavalier(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angle);
            return dest;
        }
        Float4x4OpsKernelsSegment.obliqueCavalier_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, angle);
        return dest;
    }

    public static java.nio.FloatBuffer obliqueMilitary_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.obliqueMilitary_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.FloatBuffer obliqueMilitary_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.obliqueMilitary(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angle);
            return dest;
        }
        Float4x4OpsKernelsSegment.obliqueMilitary_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, angle);
        return dest;
    }

    public static java.nio.FloatBuffer obliqueZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float planeX, float planeY, float planeZ, float planeW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.obliqueZ_unsafe(_destBase, _srcBase, planeX, planeY, planeZ, planeW);
        return dest;
    }

    public static java.nio.FloatBuffer obliqueZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float planeX, float planeY, float planeZ, float planeW) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.obliqueZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, planeX, planeY, planeZ, planeW);
            return dest;
        }
        Float4x4OpsKernelsSegment.obliqueZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, planeX, planeY, planeZ, planeW);
        return dest;
    }

    public static java.nio.FloatBuffer obliqueZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer plane, int planeOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _planeBase = UnsafeOpsHolder.U.getLong(plane, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) planeOffset * 4L;
        Float4x4OpsKernelsAddress.obliqueZ_unsafe(_destBase, _srcBase, _planeBase);
        return dest;
    }

    public static java.nio.FloatBuffer obliqueZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer plane, int planeOffset) {
        if (dest.hasArray() && src.hasArray() && plane.hasArray()) {
            Float4x4Ops.obliqueZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, plane.array(), plane.arrayOffset() + planeOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.obliqueZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(plane.duplicate().position(0)), (long) planeOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer ortho_no_lh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Float4x4OpsKernelsTypedBuffer.ortho_no_lh_unsafe(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
        return Float4x4OpsKernelsTypedBuffer.ortho_no_lh_api(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
    }

    public static java.nio.FloatBuffer ortho_no_lh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.ortho_no_lh_unsafe(_destBase, _srcBase, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.FloatBuffer ortho_no_lh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4OpsKernelsArray.ortho_no_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, left, right, bottom, top, zNear, zFar);
            return dest;
        }
        Float4x4OpsKernelsSegment.ortho_no_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.FloatBuffer ortho_no_rh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Float4x4OpsKernelsTypedBuffer.ortho_no_rh_unsafe(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
        return Float4x4OpsKernelsTypedBuffer.ortho_no_rh_api(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
    }

    public static java.nio.FloatBuffer ortho_no_rh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.ortho_no_rh_unsafe(_destBase, _srcBase, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.FloatBuffer ortho_no_rh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4OpsKernelsArray.ortho_no_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, left, right, bottom, top, zNear, zFar);
            return dest;
        }
        Float4x4OpsKernelsSegment.ortho_no_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.FloatBuffer ortho_no(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsTypedBuffer.ortho_no_lh(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar); }
            default -> { return Float4x4OpsKernelsTypedBuffer.ortho_no_rh(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar); }
        }
    }

    public static java.nio.FloatBuffer ortho_zo_lh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Float4x4OpsKernelsTypedBuffer.ortho_zo_lh_unsafe(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
        return Float4x4OpsKernelsTypedBuffer.ortho_zo_lh_api(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
    }

    public static java.nio.FloatBuffer ortho_zo_lh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.ortho_zo_lh_unsafe(_destBase, _srcBase, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.FloatBuffer ortho_zo_lh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4OpsKernelsArray.ortho_zo_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, left, right, bottom, top, zNear, zFar);
            return dest;
        }
        Float4x4OpsKernelsSegment.ortho_zo_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.FloatBuffer ortho_zo_rh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Float4x4OpsKernelsTypedBuffer.ortho_zo_rh_unsafe(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
        return Float4x4OpsKernelsTypedBuffer.ortho_zo_rh_api(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
    }

    public static java.nio.FloatBuffer ortho_zo_rh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.ortho_zo_rh_unsafe(_destBase, _srcBase, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.FloatBuffer ortho_zo_rh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4OpsKernelsArray.ortho_zo_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, left, right, bottom, top, zNear, zFar);
            return dest;
        }
        Float4x4OpsKernelsSegment.ortho_zo_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.FloatBuffer ortho_zo(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsTypedBuffer.ortho_zo_lh(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar); }
            default -> { return Float4x4OpsKernelsTypedBuffer.ortho_zo_rh(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar); }
        }
    }

    public static java.nio.FloatBuffer ortho2D_no_lh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float left, float right, float bottom, float top) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Float4x4OpsKernelsTypedBuffer.ortho2D_no_lh_unsafe(dest, destOffset, src, srcOffset, left, right, bottom, top);
        return Float4x4OpsKernelsTypedBuffer.ortho2D_no_lh_api(dest, destOffset, src, srcOffset, left, right, bottom, top);
    }

    public static java.nio.FloatBuffer ortho2D_no_lh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float left, float right, float bottom, float top) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.ortho2D_no_lh_unsafe(_destBase, _srcBase, left, right, bottom, top);
        return dest;
    }

    public static java.nio.FloatBuffer ortho2D_no_lh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float left, float right, float bottom, float top) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4OpsKernelsArray.ortho2D_no_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, left, right, bottom, top);
            return dest;
        }
        Float4x4OpsKernelsSegment.ortho2D_no_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, left, right, bottom, top);
        return dest;
    }

    public static java.nio.FloatBuffer ortho2D_no_rh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float left, float right, float bottom, float top) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Float4x4OpsKernelsTypedBuffer.ortho2D_no_rh_unsafe(dest, destOffset, src, srcOffset, left, right, bottom, top);
        return Float4x4OpsKernelsTypedBuffer.ortho2D_no_rh_api(dest, destOffset, src, srcOffset, left, right, bottom, top);
    }

    public static java.nio.FloatBuffer ortho2D_no_rh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float left, float right, float bottom, float top) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.ortho2D_no_rh_unsafe(_destBase, _srcBase, left, right, bottom, top);
        return dest;
    }

    public static java.nio.FloatBuffer ortho2D_no_rh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float left, float right, float bottom, float top) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4OpsKernelsArray.ortho2D_no_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, left, right, bottom, top);
            return dest;
        }
        Float4x4OpsKernelsSegment.ortho2D_no_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, left, right, bottom, top);
        return dest;
    }

    public static java.nio.FloatBuffer ortho2D_no(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float left, float right, float bottom, float top, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsTypedBuffer.ortho2D_no_lh(dest, destOffset, src, srcOffset, left, right, bottom, top); }
            default -> { return Float4x4OpsKernelsTypedBuffer.ortho2D_no_rh(dest, destOffset, src, srcOffset, left, right, bottom, top); }
        }
    }

    public static java.nio.FloatBuffer ortho2D_zo_lh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float left, float right, float bottom, float top) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Float4x4OpsKernelsTypedBuffer.ortho2D_zo_lh_unsafe(dest, destOffset, src, srcOffset, left, right, bottom, top);
        return Float4x4OpsKernelsTypedBuffer.ortho2D_zo_lh_api(dest, destOffset, src, srcOffset, left, right, bottom, top);
    }

    public static java.nio.FloatBuffer ortho2D_zo_lh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float left, float right, float bottom, float top) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.ortho2D_zo_lh_unsafe(_destBase, _srcBase, left, right, bottom, top);
        return dest;
    }

    public static java.nio.FloatBuffer ortho2D_zo_lh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float left, float right, float bottom, float top) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4OpsKernelsArray.ortho2D_zo_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, left, right, bottom, top);
            return dest;
        }
        Float4x4OpsKernelsSegment.ortho2D_zo_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, left, right, bottom, top);
        return dest;
    }

    public static java.nio.FloatBuffer ortho2D_zo_rh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float left, float right, float bottom, float top) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Float4x4OpsKernelsTypedBuffer.ortho2D_zo_rh_unsafe(dest, destOffset, src, srcOffset, left, right, bottom, top);
        return Float4x4OpsKernelsTypedBuffer.ortho2D_zo_rh_api(dest, destOffset, src, srcOffset, left, right, bottom, top);
    }

    public static java.nio.FloatBuffer ortho2D_zo_rh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float left, float right, float bottom, float top) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.ortho2D_zo_rh_unsafe(_destBase, _srcBase, left, right, bottom, top);
        return dest;
    }

    public static java.nio.FloatBuffer ortho2D_zo_rh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float left, float right, float bottom, float top) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4OpsKernelsArray.ortho2D_zo_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, left, right, bottom, top);
            return dest;
        }
        Float4x4OpsKernelsSegment.ortho2D_zo_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, left, right, bottom, top);
        return dest;
    }

    public static java.nio.FloatBuffer ortho2D_zo(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float left, float right, float bottom, float top, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsTypedBuffer.ortho2D_zo_lh(dest, destOffset, src, srcOffset, left, right, bottom, top); }
            default -> { return Float4x4OpsKernelsTypedBuffer.ortho2D_zo_rh(dest, destOffset, src, srcOffset, left, right, bottom, top); }
        }
    }

    public static java.nio.FloatBuffer orthoCrop_no_lh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer view, int viewOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && view.isDirect()) return Float4x4OpsKernelsTypedBuffer.orthoCrop_no_lh_unsafe(dest, destOffset, src, srcOffset, view, viewOffset);
        return Float4x4OpsKernelsTypedBuffer.orthoCrop_no_lh_api(dest, destOffset, src, srcOffset, view, viewOffset);
    }

    public static java.nio.FloatBuffer orthoCrop_no_lh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer view, int viewOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _viewBase = UnsafeOpsHolder.U.getLong(view, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) viewOffset * 4L;
        Float4x4OpsKernelsAddress.orthoCrop_no_lh_unsafe(_destBase, _srcBase, _viewBase);
        return dest;
    }

    public static java.nio.FloatBuffer orthoCrop_no_lh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer view, int viewOffset) {
        if (dest.hasArray() && src.hasArray() && view.hasArray()) {
            Float4x4OpsKernelsArray.orthoCrop_no_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, view.array(), view.arrayOffset() + viewOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.orthoCrop_no_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(view.duplicate().position(0)), (long) viewOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer orthoCrop_no_rh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer view, int viewOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && view.isDirect()) return Float4x4OpsKernelsTypedBuffer.orthoCrop_no_rh_unsafe(dest, destOffset, src, srcOffset, view, viewOffset);
        return Float4x4OpsKernelsTypedBuffer.orthoCrop_no_rh_api(dest, destOffset, src, srcOffset, view, viewOffset);
    }

    public static java.nio.FloatBuffer orthoCrop_no_rh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer view, int viewOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _viewBase = UnsafeOpsHolder.U.getLong(view, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) viewOffset * 4L;
        Float4x4OpsKernelsAddress.orthoCrop_no_rh_unsafe(_destBase, _srcBase, _viewBase);
        return dest;
    }

    public static java.nio.FloatBuffer orthoCrop_no_rh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer view, int viewOffset) {
        if (dest.hasArray() && src.hasArray() && view.hasArray()) {
            Float4x4OpsKernelsArray.orthoCrop_no_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, view.array(), view.arrayOffset() + viewOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.orthoCrop_no_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(view.duplicate().position(0)), (long) viewOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer orthoCrop_no(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer view, int viewOffset, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsTypedBuffer.orthoCrop_no_lh(dest, destOffset, src, srcOffset, view, viewOffset); }
            default -> { return Float4x4OpsKernelsTypedBuffer.orthoCrop_no_rh(dest, destOffset, src, srcOffset, view, viewOffset); }
        }
    }

    public static java.nio.FloatBuffer orthoCrop_zo_lh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer view, int viewOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && view.isDirect()) return Float4x4OpsKernelsTypedBuffer.orthoCrop_zo_lh_unsafe(dest, destOffset, src, srcOffset, view, viewOffset);
        return Float4x4OpsKernelsTypedBuffer.orthoCrop_zo_lh_api(dest, destOffset, src, srcOffset, view, viewOffset);
    }

    public static java.nio.FloatBuffer orthoCrop_zo_lh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer view, int viewOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _viewBase = UnsafeOpsHolder.U.getLong(view, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) viewOffset * 4L;
        Float4x4OpsKernelsAddress.orthoCrop_zo_lh_unsafe(_destBase, _srcBase, _viewBase);
        return dest;
    }

    public static java.nio.FloatBuffer orthoCrop_zo_lh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer view, int viewOffset) {
        if (dest.hasArray() && src.hasArray() && view.hasArray()) {
            Float4x4OpsKernelsArray.orthoCrop_zo_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, view.array(), view.arrayOffset() + viewOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.orthoCrop_zo_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(view.duplicate().position(0)), (long) viewOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer orthoCrop_zo_rh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer view, int viewOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && view.isDirect()) return Float4x4OpsKernelsTypedBuffer.orthoCrop_zo_rh_unsafe(dest, destOffset, src, srcOffset, view, viewOffset);
        return Float4x4OpsKernelsTypedBuffer.orthoCrop_zo_rh_api(dest, destOffset, src, srcOffset, view, viewOffset);
    }

    public static java.nio.FloatBuffer orthoCrop_zo_rh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer view, int viewOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _viewBase = UnsafeOpsHolder.U.getLong(view, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) viewOffset * 4L;
        Float4x4OpsKernelsAddress.orthoCrop_zo_rh_unsafe(_destBase, _srcBase, _viewBase);
        return dest;
    }

    public static java.nio.FloatBuffer orthoCrop_zo_rh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer view, int viewOffset) {
        if (dest.hasArray() && src.hasArray() && view.hasArray()) {
            Float4x4OpsKernelsArray.orthoCrop_zo_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, view.array(), view.arrayOffset() + viewOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.orthoCrop_zo_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(view.duplicate().position(0)), (long) viewOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer orthoCrop_zo(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer view, int viewOffset, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsTypedBuffer.orthoCrop_zo_lh(dest, destOffset, src, srcOffset, view, viewOffset); }
            default -> { return Float4x4OpsKernelsTypedBuffer.orthoCrop_zo_rh(dest, destOffset, src, srcOffset, view, viewOffset); }
        }
    }

    public static java.nio.FloatBuffer orthoCrop_no_lh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer view, int viewOffset, float minZ, float maxZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && view.isDirect()) return Float4x4OpsKernelsTypedBuffer.orthoCrop_no_lh_unsafe(dest, destOffset, src, srcOffset, view, viewOffset, minZ, maxZ);
        return Float4x4OpsKernelsTypedBuffer.orthoCrop_no_lh_api(dest, destOffset, src, srcOffset, view, viewOffset, minZ, maxZ);
    }

    public static java.nio.FloatBuffer orthoCrop_no_lh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer view, int viewOffset, float minZ, float maxZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _viewBase = UnsafeOpsHolder.U.getLong(view, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) viewOffset * 4L;
        Float4x4OpsKernelsAddress.orthoCrop_no_lh_unsafe(_destBase, _srcBase, _viewBase, minZ, maxZ);
        return dest;
    }

    public static java.nio.FloatBuffer orthoCrop_no_lh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer view, int viewOffset, float minZ, float maxZ) {
        if (dest.hasArray() && src.hasArray() && view.hasArray()) {
            Float4x4OpsKernelsArray.orthoCrop_no_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, view.array(), view.arrayOffset() + viewOffset, minZ, maxZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.orthoCrop_no_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(view.duplicate().position(0)), (long) viewOffset * 4L, minZ, maxZ);
        return dest;
    }

    public static java.nio.FloatBuffer orthoCrop_no_rh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer view, int viewOffset, float minZ, float maxZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && view.isDirect()) return Float4x4OpsKernelsTypedBuffer.orthoCrop_no_rh_unsafe(dest, destOffset, src, srcOffset, view, viewOffset, minZ, maxZ);
        return Float4x4OpsKernelsTypedBuffer.orthoCrop_no_rh_api(dest, destOffset, src, srcOffset, view, viewOffset, minZ, maxZ);
    }

    public static java.nio.FloatBuffer orthoCrop_no_rh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer view, int viewOffset, float minZ, float maxZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _viewBase = UnsafeOpsHolder.U.getLong(view, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) viewOffset * 4L;
        Float4x4OpsKernelsAddress.orthoCrop_no_rh_unsafe(_destBase, _srcBase, _viewBase, minZ, maxZ);
        return dest;
    }

    public static java.nio.FloatBuffer orthoCrop_no_rh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer view, int viewOffset, float minZ, float maxZ) {
        if (dest.hasArray() && src.hasArray() && view.hasArray()) {
            Float4x4OpsKernelsArray.orthoCrop_no_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, view.array(), view.arrayOffset() + viewOffset, minZ, maxZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.orthoCrop_no_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(view.duplicate().position(0)), (long) viewOffset * 4L, minZ, maxZ);
        return dest;
    }

    public static java.nio.FloatBuffer orthoCrop_no(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer view, int viewOffset, float minZ, float maxZ, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsTypedBuffer.orthoCrop_no_lh(dest, destOffset, src, srcOffset, view, viewOffset, minZ, maxZ); }
            default -> { return Float4x4OpsKernelsTypedBuffer.orthoCrop_no_rh(dest, destOffset, src, srcOffset, view, viewOffset, minZ, maxZ); }
        }
    }

    public static java.nio.FloatBuffer orthoCrop_zo_lh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer view, int viewOffset, float minZ, float maxZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && view.isDirect()) return Float4x4OpsKernelsTypedBuffer.orthoCrop_zo_lh_unsafe(dest, destOffset, src, srcOffset, view, viewOffset, minZ, maxZ);
        return Float4x4OpsKernelsTypedBuffer.orthoCrop_zo_lh_api(dest, destOffset, src, srcOffset, view, viewOffset, minZ, maxZ);
    }

    public static java.nio.FloatBuffer orthoCrop_zo_lh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer view, int viewOffset, float minZ, float maxZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _viewBase = UnsafeOpsHolder.U.getLong(view, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) viewOffset * 4L;
        Float4x4OpsKernelsAddress.orthoCrop_zo_lh_unsafe(_destBase, _srcBase, _viewBase, minZ, maxZ);
        return dest;
    }

    public static java.nio.FloatBuffer orthoCrop_zo_lh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer view, int viewOffset, float minZ, float maxZ) {
        if (dest.hasArray() && src.hasArray() && view.hasArray()) {
            Float4x4OpsKernelsArray.orthoCrop_zo_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, view.array(), view.arrayOffset() + viewOffset, minZ, maxZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.orthoCrop_zo_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(view.duplicate().position(0)), (long) viewOffset * 4L, minZ, maxZ);
        return dest;
    }

    public static java.nio.FloatBuffer orthoCrop_zo_rh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer view, int viewOffset, float minZ, float maxZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && view.isDirect()) return Float4x4OpsKernelsTypedBuffer.orthoCrop_zo_rh_unsafe(dest, destOffset, src, srcOffset, view, viewOffset, minZ, maxZ);
        return Float4x4OpsKernelsTypedBuffer.orthoCrop_zo_rh_api(dest, destOffset, src, srcOffset, view, viewOffset, minZ, maxZ);
    }

    public static java.nio.FloatBuffer orthoCrop_zo_rh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer view, int viewOffset, float minZ, float maxZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _viewBase = UnsafeOpsHolder.U.getLong(view, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) viewOffset * 4L;
        Float4x4OpsKernelsAddress.orthoCrop_zo_rh_unsafe(_destBase, _srcBase, _viewBase, minZ, maxZ);
        return dest;
    }

    public static java.nio.FloatBuffer orthoCrop_zo_rh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer view, int viewOffset, float minZ, float maxZ) {
        if (dest.hasArray() && src.hasArray() && view.hasArray()) {
            Float4x4OpsKernelsArray.orthoCrop_zo_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, view.array(), view.arrayOffset() + viewOffset, minZ, maxZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.orthoCrop_zo_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(view.duplicate().position(0)), (long) viewOffset * 4L, minZ, maxZ);
        return dest;
    }

    public static java.nio.FloatBuffer orthoCrop_zo(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer view, int viewOffset, float minZ, float maxZ, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsTypedBuffer.orthoCrop_zo_lh(dest, destOffset, src, srcOffset, view, viewOffset, minZ, maxZ); }
            default -> { return Float4x4OpsKernelsTypedBuffer.orthoCrop_zo_rh(dest, destOffset, src, srcOffset, view, viewOffset, minZ, maxZ); }
        }
    }

    public static java.nio.FloatBuffer perspective_no_lh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float fovy, float aspect, float near, float far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Float4x4OpsKernelsTypedBuffer.perspective_no_lh_unsafe(dest, destOffset, src, srcOffset, fovy, aspect, near, far);
        return Float4x4OpsKernelsTypedBuffer.perspective_no_lh_api(dest, destOffset, src, srcOffset, fovy, aspect, near, far);
    }

    public static java.nio.FloatBuffer perspective_no_lh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float fovy, float aspect, float near, float far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.perspective_no_lh_unsafe(_destBase, _srcBase, fovy, aspect, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer perspective_no_lh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float fovy, float aspect, float near, float far) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4OpsKernelsArray.perspective_no_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, fovy, aspect, near, far);
            return dest;
        }
        Float4x4OpsKernelsSegment.perspective_no_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, fovy, aspect, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer perspective_no_rh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float fovy, float aspect, float near, float far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Float4x4OpsKernelsTypedBuffer.perspective_no_rh_unsafe(dest, destOffset, src, srcOffset, fovy, aspect, near, far);
        return Float4x4OpsKernelsTypedBuffer.perspective_no_rh_api(dest, destOffset, src, srcOffset, fovy, aspect, near, far);
    }

    public static java.nio.FloatBuffer perspective_no_rh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float fovy, float aspect, float near, float far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.perspective_no_rh_unsafe(_destBase, _srcBase, fovy, aspect, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer perspective_no_rh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float fovy, float aspect, float near, float far) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4OpsKernelsArray.perspective_no_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, fovy, aspect, near, far);
            return dest;
        }
        Float4x4OpsKernelsSegment.perspective_no_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, fovy, aspect, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer perspective_no(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float fovy, float aspect, float near, float far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsTypedBuffer.perspective_no_lh(dest, destOffset, src, srcOffset, fovy, aspect, near, far); }
            default -> { return Float4x4OpsKernelsTypedBuffer.perspective_no_rh(dest, destOffset, src, srcOffset, fovy, aspect, near, far); }
        }
    }

    public static java.nio.FloatBuffer perspective_zo_lh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float fovy, float aspect, float near, float far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Float4x4OpsKernelsTypedBuffer.perspective_zo_lh_unsafe(dest, destOffset, src, srcOffset, fovy, aspect, near, far);
        return Float4x4OpsKernelsTypedBuffer.perspective_zo_lh_api(dest, destOffset, src, srcOffset, fovy, aspect, near, far);
    }

    public static java.nio.FloatBuffer perspective_zo_lh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float fovy, float aspect, float near, float far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.perspective_zo_lh_unsafe(_destBase, _srcBase, fovy, aspect, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer perspective_zo_lh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float fovy, float aspect, float near, float far) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4OpsKernelsArray.perspective_zo_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, fovy, aspect, near, far);
            return dest;
        }
        Float4x4OpsKernelsSegment.perspective_zo_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, fovy, aspect, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer perspective_zo_rh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float fovy, float aspect, float near, float far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Float4x4OpsKernelsTypedBuffer.perspective_zo_rh_unsafe(dest, destOffset, src, srcOffset, fovy, aspect, near, far);
        return Float4x4OpsKernelsTypedBuffer.perspective_zo_rh_api(dest, destOffset, src, srcOffset, fovy, aspect, near, far);
    }

    public static java.nio.FloatBuffer perspective_zo_rh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float fovy, float aspect, float near, float far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.perspective_zo_rh_unsafe(_destBase, _srcBase, fovy, aspect, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer perspective_zo_rh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float fovy, float aspect, float near, float far) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4OpsKernelsArray.perspective_zo_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, fovy, aspect, near, far);
            return dest;
        }
        Float4x4OpsKernelsSegment.perspective_zo_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, fovy, aspect, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer perspective_zo(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float fovy, float aspect, float near, float far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsTypedBuffer.perspective_zo_lh(dest, destOffset, src, srcOffset, fovy, aspect, near, far); }
            default -> { return Float4x4OpsKernelsTypedBuffer.perspective_zo_rh(dest, destOffset, src, srcOffset, fovy, aspect, near, far); }
        }
    }

    public static java.nio.FloatBuffer perspectiveFovRange_no_lh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Float4x4OpsKernelsTypedBuffer.perspectiveFovRange_no_lh_unsafe(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far);
        return Float4x4OpsKernelsTypedBuffer.perspectiveFovRange_no_lh_api(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far);
    }

    public static java.nio.FloatBuffer perspectiveFovRange_no_lh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.perspectiveFovRange_no_lh_unsafe(_destBase, _srcBase, angleMin, angleMax, aspect, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer perspectiveFovRange_no_lh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4OpsKernelsArray.perspectiveFovRange_no_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angleMin, angleMax, aspect, near, far);
            return dest;
        }
        Float4x4OpsKernelsSegment.perspectiveFovRange_no_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, angleMin, angleMax, aspect, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer perspectiveFovRange_no_rh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Float4x4OpsKernelsTypedBuffer.perspectiveFovRange_no_rh_unsafe(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far);
        return Float4x4OpsKernelsTypedBuffer.perspectiveFovRange_no_rh_api(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far);
    }

    public static java.nio.FloatBuffer perspectiveFovRange_no_rh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.perspectiveFovRange_no_rh_unsafe(_destBase, _srcBase, angleMin, angleMax, aspect, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer perspectiveFovRange_no_rh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4OpsKernelsArray.perspectiveFovRange_no_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angleMin, angleMax, aspect, near, far);
            return dest;
        }
        Float4x4OpsKernelsSegment.perspectiveFovRange_no_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, angleMin, angleMax, aspect, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer perspectiveFovRange_no(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleMin, float angleMax, float aspect, float near, float far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsTypedBuffer.perspectiveFovRange_no_lh(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far); }
            default -> { return Float4x4OpsKernelsTypedBuffer.perspectiveFovRange_no_rh(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far); }
        }
    }

    public static java.nio.FloatBuffer perspectiveFovRange_zo_lh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Float4x4OpsKernelsTypedBuffer.perspectiveFovRange_zo_lh_unsafe(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far);
        return Float4x4OpsKernelsTypedBuffer.perspectiveFovRange_zo_lh_api(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far);
    }

    public static java.nio.FloatBuffer perspectiveFovRange_zo_lh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.perspectiveFovRange_zo_lh_unsafe(_destBase, _srcBase, angleMin, angleMax, aspect, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer perspectiveFovRange_zo_lh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4OpsKernelsArray.perspectiveFovRange_zo_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angleMin, angleMax, aspect, near, far);
            return dest;
        }
        Float4x4OpsKernelsSegment.perspectiveFovRange_zo_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, angleMin, angleMax, aspect, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer perspectiveFovRange_zo_rh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Float4x4OpsKernelsTypedBuffer.perspectiveFovRange_zo_rh_unsafe(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far);
        return Float4x4OpsKernelsTypedBuffer.perspectiveFovRange_zo_rh_api(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far);
    }

    public static java.nio.FloatBuffer perspectiveFovRange_zo_rh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.perspectiveFovRange_zo_rh_unsafe(_destBase, _srcBase, angleMin, angleMax, aspect, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer perspectiveFovRange_zo_rh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4OpsKernelsArray.perspectiveFovRange_zo_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angleMin, angleMax, aspect, near, far);
            return dest;
        }
        Float4x4OpsKernelsSegment.perspectiveFovRange_zo_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, angleMin, angleMax, aspect, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer perspectiveFovRange_zo(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleMin, float angleMax, float aspect, float near, float far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsTypedBuffer.perspectiveFovRange_zo_lh(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far); }
            default -> { return Float4x4OpsKernelsTypedBuffer.perspectiveFovRange_zo_rh(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far); }
        }
    }

    public static java.nio.FloatBuffer perspectiveFrustumSlice_no_lh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float near, float far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Float4x4OpsKernelsTypedBuffer.perspectiveFrustumSlice_no_lh_unsafe(dest, destOffset, src, srcOffset, near, far);
        return Float4x4OpsKernelsTypedBuffer.perspectiveFrustumSlice_no_lh_api(dest, destOffset, src, srcOffset, near, far);
    }

    public static java.nio.FloatBuffer perspectiveFrustumSlice_no_lh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float near, float far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.perspectiveFrustumSlice_no_lh_unsafe(_destBase, _srcBase, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer perspectiveFrustumSlice_no_lh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float near, float far) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4OpsKernelsArray.perspectiveFrustumSlice_no_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, near, far);
            return dest;
        }
        Float4x4OpsKernelsSegment.perspectiveFrustumSlice_no_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer perspectiveFrustumSlice_no_rh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float near, float far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Float4x4OpsKernelsTypedBuffer.perspectiveFrustumSlice_no_rh_unsafe(dest, destOffset, src, srcOffset, near, far);
        return Float4x4OpsKernelsTypedBuffer.perspectiveFrustumSlice_no_rh_api(dest, destOffset, src, srcOffset, near, far);
    }

    public static java.nio.FloatBuffer perspectiveFrustumSlice_no_rh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float near, float far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.perspectiveFrustumSlice_no_rh_unsafe(_destBase, _srcBase, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer perspectiveFrustumSlice_no_rh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float near, float far) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4OpsKernelsArray.perspectiveFrustumSlice_no_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, near, far);
            return dest;
        }
        Float4x4OpsKernelsSegment.perspectiveFrustumSlice_no_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer perspectiveFrustumSlice_no(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float near, float far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsTypedBuffer.perspectiveFrustumSlice_no_lh(dest, destOffset, src, srcOffset, near, far); }
            default -> { return Float4x4OpsKernelsTypedBuffer.perspectiveFrustumSlice_no_rh(dest, destOffset, src, srcOffset, near, far); }
        }
    }

    public static java.nio.FloatBuffer perspectiveFrustumSlice_zo_lh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float near, float far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Float4x4OpsKernelsTypedBuffer.perspectiveFrustumSlice_zo_lh_unsafe(dest, destOffset, src, srcOffset, near, far);
        return Float4x4OpsKernelsTypedBuffer.perspectiveFrustumSlice_zo_lh_api(dest, destOffset, src, srcOffset, near, far);
    }

    public static java.nio.FloatBuffer perspectiveFrustumSlice_zo_lh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float near, float far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.perspectiveFrustumSlice_zo_lh_unsafe(_destBase, _srcBase, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer perspectiveFrustumSlice_zo_lh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float near, float far) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4OpsKernelsArray.perspectiveFrustumSlice_zo_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, near, far);
            return dest;
        }
        Float4x4OpsKernelsSegment.perspectiveFrustumSlice_zo_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer perspectiveFrustumSlice_zo_rh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float near, float far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Float4x4OpsKernelsTypedBuffer.perspectiveFrustumSlice_zo_rh_unsafe(dest, destOffset, src, srcOffset, near, far);
        return Float4x4OpsKernelsTypedBuffer.perspectiveFrustumSlice_zo_rh_api(dest, destOffset, src, srcOffset, near, far);
    }

    public static java.nio.FloatBuffer perspectiveFrustumSlice_zo_rh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float near, float far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.perspectiveFrustumSlice_zo_rh_unsafe(_destBase, _srcBase, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer perspectiveFrustumSlice_zo_rh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float near, float far) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4OpsKernelsArray.perspectiveFrustumSlice_zo_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, near, far);
            return dest;
        }
        Float4x4OpsKernelsSegment.perspectiveFrustumSlice_zo_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer perspectiveFrustumSlice_zo(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float near, float far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsTypedBuffer.perspectiveFrustumSlice_zo_lh(dest, destOffset, src, srcOffset, near, far); }
            default -> { return Float4x4OpsKernelsTypedBuffer.perspectiveFrustumSlice_zo_rh(dest, destOffset, src, srcOffset, near, far); }
        }
    }

    public static java.nio.FloatBuffer perspectiveOffCenterFov_no_lh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Float4x4OpsKernelsTypedBuffer.perspectiveOffCenterFov_no_lh_unsafe(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
        return Float4x4OpsKernelsTypedBuffer.perspectiveOffCenterFov_no_lh_api(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
    }

    public static java.nio.FloatBuffer perspectiveOffCenterFov_no_lh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.perspectiveOffCenterFov_no_lh_unsafe(_destBase, _srcBase, angleLeft, angleRight, angleDown, angleUp, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer perspectiveOffCenterFov_no_lh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4OpsKernelsArray.perspectiveOffCenterFov_no_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
            return dest;
        }
        Float4x4OpsKernelsSegment.perspectiveOffCenterFov_no_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, angleLeft, angleRight, angleDown, angleUp, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer perspectiveOffCenterFov_no_rh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Float4x4OpsKernelsTypedBuffer.perspectiveOffCenterFov_no_rh_unsafe(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
        return Float4x4OpsKernelsTypedBuffer.perspectiveOffCenterFov_no_rh_api(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
    }

    public static java.nio.FloatBuffer perspectiveOffCenterFov_no_rh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.perspectiveOffCenterFov_no_rh_unsafe(_destBase, _srcBase, angleLeft, angleRight, angleDown, angleUp, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer perspectiveOffCenterFov_no_rh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4OpsKernelsArray.perspectiveOffCenterFov_no_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
            return dest;
        }
        Float4x4OpsKernelsSegment.perspectiveOffCenterFov_no_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, angleLeft, angleRight, angleDown, angleUp, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer perspectiveOffCenterFov_no(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsTypedBuffer.perspectiveOffCenterFov_no_lh(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far); }
            default -> { return Float4x4OpsKernelsTypedBuffer.perspectiveOffCenterFov_no_rh(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far); }
        }
    }

    public static java.nio.FloatBuffer perspectiveOffCenterFov_zo_lh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Float4x4OpsKernelsTypedBuffer.perspectiveOffCenterFov_zo_lh_unsafe(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
        return Float4x4OpsKernelsTypedBuffer.perspectiveOffCenterFov_zo_lh_api(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
    }

    public static java.nio.FloatBuffer perspectiveOffCenterFov_zo_lh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.perspectiveOffCenterFov_zo_lh_unsafe(_destBase, _srcBase, angleLeft, angleRight, angleDown, angleUp, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer perspectiveOffCenterFov_zo_lh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4OpsKernelsArray.perspectiveOffCenterFov_zo_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
            return dest;
        }
        Float4x4OpsKernelsSegment.perspectiveOffCenterFov_zo_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, angleLeft, angleRight, angleDown, angleUp, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer perspectiveOffCenterFov_zo_rh(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Float4x4OpsKernelsTypedBuffer.perspectiveOffCenterFov_zo_rh_unsafe(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
        return Float4x4OpsKernelsTypedBuffer.perspectiveOffCenterFov_zo_rh_api(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
    }

    public static java.nio.FloatBuffer perspectiveOffCenterFov_zo_rh_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.perspectiveOffCenterFov_zo_rh_unsafe(_destBase, _srcBase, angleLeft, angleRight, angleDown, angleUp, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer perspectiveOffCenterFov_zo_rh_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4OpsKernelsArray.perspectiveOffCenterFov_zo_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
            return dest;
        }
        Float4x4OpsKernelsSegment.perspectiveOffCenterFov_zo_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, angleLeft, angleRight, angleDown, angleUp, near, far);
        return dest;
    }

    public static java.nio.FloatBuffer perspectiveOffCenterFov_zo(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsTypedBuffer.perspectiveOffCenterFov_zo_lh(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far); }
            default -> { return Float4x4OpsKernelsTypedBuffer.perspectiveOffCenterFov_zo_rh(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far); }
        }
    }

    public static java.nio.FloatBuffer pickMatrix_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float centerX, float centerY, float deltaX, float deltaY, float vpX, float vpY, float vpW, float vpH) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.pickMatrix_unsafe(_destBase, _srcBase, centerX, centerY, deltaX, deltaY, vpX, vpY, vpW, vpH);
        return dest;
    }

    public static java.nio.FloatBuffer pickMatrix_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float centerX, float centerY, float deltaX, float deltaY, float vpX, float vpY, float vpW, float vpH) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.pickMatrix(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, centerX, centerY, deltaX, deltaY, vpX, vpY, vpW, vpH);
            return dest;
        }
        Float4x4OpsKernelsSegment.pickMatrix_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, centerX, centerY, deltaX, deltaY, vpX, vpY, vpW, vpH);
        return dest;
    }

    public static java.nio.FloatBuffer preRotateAround_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float rotX, float rotY, float rotZ, float rotW, float pivotX, float pivotY, float pivotZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.preRotateAround_unsafe(_destBase, _srcBase, rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.FloatBuffer preRotateAround_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float rotX, float rotY, float rotZ, float rotW, float pivotX, float pivotY, float pivotZ) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.preRotateAround(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.preRotateAround_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.FloatBuffer preRotateAround_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer rot, int rotOffset, java.nio.FloatBuffer pivot, int pivotOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _rotBase = UnsafeOpsHolder.U.getLong(rot, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rotOffset * 4L;
        long _pivotBase = UnsafeOpsHolder.U.getLong(pivot, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pivotOffset * 4L;
        Float4x4OpsKernelsAddress.preRotateAround_unsafe(_destBase, _srcBase, _rotBase, _pivotBase);
        return dest;
    }

    public static java.nio.FloatBuffer preRotateAround_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer rot, int rotOffset, java.nio.FloatBuffer pivot, int pivotOffset) {
        if (dest.hasArray() && src.hasArray() && rot.hasArray() && pivot.hasArray()) {
            Float4x4Ops.preRotateAround(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, rot.array(), rot.arrayOffset() + rotOffset, pivot.array(), pivot.arrayOffset() + pivotOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.preRotateAround_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(rot.duplicate().position(0)), (long) rotOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(pivot.duplicate().position(0)), (long) pivotOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer preRotateAxis_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle, float axisX, float axisY, float axisZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.preRotateAxis_unsafe(_destBase, _srcBase, angle, axisX, axisY, axisZ);
        return dest;
    }

    public static java.nio.FloatBuffer preRotateAxis_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle, float axisX, float axisY, float axisZ) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.preRotateAxis(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angle, axisX, axisY, axisZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.preRotateAxis_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, angle, axisX, axisY, axisZ);
        return dest;
    }

    public static java.nio.FloatBuffer preRotateAxis_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer axis, int axisOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _axisBase = UnsafeOpsHolder.U.getLong(axis, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) axisOffset * 4L;
        Float4x4OpsKernelsAddress.preRotateAxis_unsafe(_destBase, _srcBase, _axisBase, angle);
        return dest;
    }

    public static java.nio.FloatBuffer preRotateAxis_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer axis, int axisOffset, float angle) {
        if (dest.hasArray() && src.hasArray() && axis.hasArray()) {
            Float4x4Ops.preRotateAxis(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, axis.array(), axis.arrayOffset() + axisOffset, angle);
            return dest;
        }
        Float4x4OpsKernelsSegment.preRotateAxis_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(axis.duplicate().position(0)), (long) axisOffset * 4L, angle);
        return dest;
    }

    public static java.nio.FloatBuffer preRotateQuat_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float qX, float qY, float qZ, float qW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.preRotateQuat_unsafe(_destBase, _srcBase, qX, qY, qZ, qW);
        return dest;
    }

    public static java.nio.FloatBuffer preRotateQuat_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float qX, float qY, float qZ, float qW) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.preRotateQuat(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, qX, qY, qZ, qW);
            return dest;
        }
        Float4x4OpsKernelsSegment.preRotateQuat_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, qX, qY, qZ, qW);
        return dest;
    }

    public static java.nio.FloatBuffer preRotateQuat_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer q, int qOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _qBase = UnsafeOpsHolder.U.getLong(q, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) qOffset * 4L;
        Float4x4OpsKernelsAddress.preRotateQuat_unsafe(_destBase, _srcBase, _qBase);
        return dest;
    }

    public static java.nio.FloatBuffer preRotateQuat_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer q, int qOffset) {
        if (dest.hasArray() && src.hasArray() && q.hasArray()) {
            Float4x4Ops.preRotateQuat(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, q.array(), q.arrayOffset() + qOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.preRotateQuat_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(q.duplicate().position(0)), (long) qOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer preRotateX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.preRotateX_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.FloatBuffer preRotateX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.preRotateX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angle);
            return dest;
        }
        Float4x4OpsKernelsSegment.preRotateX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, angle);
        return dest;
    }

    public static java.nio.FloatBuffer preRotateY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.preRotateY_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.FloatBuffer preRotateY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.preRotateY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angle);
            return dest;
        }
        Float4x4OpsKernelsSegment.preRotateY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, angle);
        return dest;
    }

    public static java.nio.FloatBuffer preRotateZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.preRotateZ_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.FloatBuffer preRotateZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.preRotateZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angle);
            return dest;
        }
        Float4x4OpsKernelsSegment.preRotateZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, angle);
        return dest;
    }

    public static java.nio.FloatBuffer preScale_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float vX, float vY, float vZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.preScale_unsafe(_destBase, _srcBase, vX, vY, vZ);
        return dest;
    }

    public static java.nio.FloatBuffer preScale_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float vX, float vY, float vZ) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.preScale(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, vX, vY, vZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.preScale_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, vX, vY, vZ);
        return dest;
    }

    public static java.nio.FloatBuffer preScale_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 4L;
        Float4x4OpsKernelsAddress.preScale_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.FloatBuffer preScale_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer v, int vOffset) {
        if (dest.hasArray() && src.hasArray() && v.hasArray()) {
            Float4x4Ops.preScale(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, v.array(), v.arrayOffset() + vOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.preScale_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(v.duplicate().position(0)), (long) vOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer preScale_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float s) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.preScale_unsafe(_destBase, _srcBase, s);
        return dest;
    }

    public static java.nio.FloatBuffer preScale_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float s) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.preScale(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, s);
            return dest;
        }
        Float4x4OpsKernelsSegment.preScale_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, s);
        return dest;
    }

    public static java.nio.FloatBuffer preScaleAround_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float s, float pivotX, float pivotY, float pivotZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.preScaleAround_unsafe(_destBase, _srcBase, s, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.FloatBuffer preScaleAround_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float s, float pivotX, float pivotY, float pivotZ) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.preScaleAround(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, s, pivotX, pivotY, pivotZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.preScaleAround_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, s, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.FloatBuffer preScaleAround_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer pivot, int pivotOffset, float s) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _pivotBase = UnsafeOpsHolder.U.getLong(pivot, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pivotOffset * 4L;
        Float4x4OpsKernelsAddress.preScaleAround_unsafe(_destBase, _srcBase, _pivotBase, s);
        return dest;
    }

    public static java.nio.FloatBuffer preScaleAround_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer pivot, int pivotOffset, float s) {
        if (dest.hasArray() && src.hasArray() && pivot.hasArray()) {
            Float4x4Ops.preScaleAround(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, pivot.array(), pivot.arrayOffset() + pivotOffset, s);
            return dest;
        }
        Float4x4OpsKernelsSegment.preScaleAround_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(pivot.duplicate().position(0)), (long) pivotOffset * 4L, s);
        return dest;
    }

    public static java.nio.FloatBuffer preScaleAround_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float sX, float sY, float sZ, float pivotX, float pivotY, float pivotZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.preScaleAround_unsafe(_destBase, _srcBase, sX, sY, sZ, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.FloatBuffer preScaleAround_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float sX, float sY, float sZ, float pivotX, float pivotY, float pivotZ) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.preScaleAround(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, sX, sY, sZ, pivotX, pivotY, pivotZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.preScaleAround_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, sX, sY, sZ, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.FloatBuffer preScaleAround_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer s, int sOffset, java.nio.FloatBuffer pivot, int pivotOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _sBase = UnsafeOpsHolder.U.getLong(s, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) sOffset * 4L;
        long _pivotBase = UnsafeOpsHolder.U.getLong(pivot, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pivotOffset * 4L;
        Float4x4OpsKernelsAddress.preScaleAround_unsafe(_destBase, _srcBase, _sBase, _pivotBase);
        return dest;
    }

    public static java.nio.FloatBuffer preScaleAround_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer s, int sOffset, java.nio.FloatBuffer pivot, int pivotOffset) {
        if (dest.hasArray() && src.hasArray() && s.hasArray() && pivot.hasArray()) {
            Float4x4Ops.preScaleAround(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, s.array(), s.arrayOffset() + sOffset, pivot.array(), pivot.arrayOffset() + pivotOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.preScaleAround_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(s.duplicate().position(0)), (long) sOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(pivot.duplicate().position(0)), (long) pivotOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer preTranslate_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float vX, float vY, float vZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.preTranslate_unsafe(_destBase, _srcBase, vX, vY, vZ);
        return dest;
    }

    public static java.nio.FloatBuffer preTranslate_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float vX, float vY, float vZ) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.preTranslate(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, vX, vY, vZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.preTranslate_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, vX, vY, vZ);
        return dest;
    }

    public static java.nio.FloatBuffer preTranslate_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 4L;
        Float4x4OpsKernelsAddress.preTranslate_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.FloatBuffer preTranslate_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer v, int vOffset) {
        if (dest.hasArray() && src.hasArray() && v.hasArray()) {
            Float4x4Ops.preTranslate(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, v.array(), v.arrayOffset() + vOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.preTranslate_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(v.duplicate().position(0)), (long) vOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer project_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float objX, float objY, float objZ, float viewportX, float viewportY, float viewportZ, float viewportW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.project_unsafe(_destBase, _srcBase, objX, objY, objZ, viewportX, viewportY, viewportZ, viewportW);
        return dest;
    }

    public static java.nio.FloatBuffer project_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float objX, float objY, float objZ, float viewportX, float viewportY, float viewportZ, float viewportW) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.project(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, objX, objY, objZ, viewportX, viewportY, viewportZ, viewportW);
            return dest;
        }
        Float4x4OpsKernelsSegment.project_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, objX, objY, objZ, viewportX, viewportY, viewportZ, viewportW);
        return dest;
    }

    public static java.nio.FloatBuffer project_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer obj, int objOffset, java.nio.FloatBuffer viewport, int viewportOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _objBase = UnsafeOpsHolder.U.getLong(obj, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) objOffset * 4L;
        long _viewportBase = UnsafeOpsHolder.U.getLong(viewport, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) viewportOffset * 4L;
        Float4x4OpsKernelsAddress.project_unsafe(_destBase, _srcBase, _objBase, _viewportBase);
        return dest;
    }

    public static java.nio.FloatBuffer project_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer obj, int objOffset, java.nio.FloatBuffer viewport, int viewportOffset) {
        if (dest.hasArray() && src.hasArray() && obj.hasArray() && viewport.hasArray()) {
            Float4x4Ops.project(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, obj.array(), obj.arrayOffset() + objOffset, viewport.array(), viewport.arrayOffset() + viewportOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.project_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(obj.duplicate().position(0)), (long) objOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(viewport.duplicate().position(0)), (long) viewportOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer reflect_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float normalX, float normalY, float normalZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.reflect_unsafe(_destBase, _srcBase, normalX, normalY, normalZ);
        return dest;
    }

    public static java.nio.FloatBuffer reflect_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float normalX, float normalY, float normalZ) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.reflect(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, normalX, normalY, normalZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.reflect_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, normalX, normalY, normalZ);
        return dest;
    }

    public static java.nio.FloatBuffer reflect_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer normal, int normalOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _normalBase = UnsafeOpsHolder.U.getLong(normal, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) normalOffset * 4L;
        Float4x4OpsKernelsAddress.reflect_unsafe(_destBase, _srcBase, _normalBase);
        return dest;
    }

    public static java.nio.FloatBuffer reflect_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer normal, int normalOffset) {
        if (dest.hasArray() && src.hasArray() && normal.hasArray()) {
            Float4x4Ops.reflect(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, normal.array(), normal.arrayOffset() + normalOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.reflect_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(normal.duplicate().position(0)), (long) normalOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer rotateAround_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float rotX, float rotY, float rotZ, float rotW, float pivotX, float pivotY, float pivotZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.rotateAround_unsafe(_destBase, _srcBase, rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.FloatBuffer rotateAround_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float rotX, float rotY, float rotZ, float rotW, float pivotX, float pivotY, float pivotZ) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.rotateAround(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.rotateAround_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.FloatBuffer rotateAround_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer rot, int rotOffset, java.nio.FloatBuffer pivot, int pivotOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _rotBase = UnsafeOpsHolder.U.getLong(rot, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rotOffset * 4L;
        long _pivotBase = UnsafeOpsHolder.U.getLong(pivot, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pivotOffset * 4L;
        Float4x4OpsKernelsAddress.rotateAround_unsafe(_destBase, _srcBase, _rotBase, _pivotBase);
        return dest;
    }

    public static java.nio.FloatBuffer rotateAround_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer rot, int rotOffset, java.nio.FloatBuffer pivot, int pivotOffset) {
        if (dest.hasArray() && src.hasArray() && rot.hasArray() && pivot.hasArray()) {
            Float4x4Ops.rotateAround(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, rot.array(), rot.arrayOffset() + rotOffset, pivot.array(), pivot.arrayOffset() + pivotOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.rotateAround_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(rot.duplicate().position(0)), (long) rotOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(pivot.duplicate().position(0)), (long) pivotOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer rotateAxis_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle, float axisX, float axisY, float axisZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.rotateAxis_unsafe(_destBase, _srcBase, angle, axisX, axisY, axisZ);
        return dest;
    }

    public static java.nio.FloatBuffer rotateAxis_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle, float axisX, float axisY, float axisZ) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.rotateAxis(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angle, axisX, axisY, axisZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.rotateAxis_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, angle, axisX, axisY, axisZ);
        return dest;
    }

    public static java.nio.FloatBuffer rotateAxis_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer axis, int axisOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _axisBase = UnsafeOpsHolder.U.getLong(axis, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) axisOffset * 4L;
        Float4x4OpsKernelsAddress.rotateAxis_unsafe(_destBase, _srcBase, _axisBase, angle);
        return dest;
    }

    public static java.nio.FloatBuffer rotateAxis_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer axis, int axisOffset, float angle) {
        if (dest.hasArray() && src.hasArray() && axis.hasArray()) {
            Float4x4Ops.rotateAxis(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, axis.array(), axis.arrayOffset() + axisOffset, angle);
            return dest;
        }
        Float4x4OpsKernelsSegment.rotateAxis_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(axis.duplicate().position(0)), (long) axisOffset * 4L, angle);
        return dest;
    }

    public static java.nio.FloatBuffer rotateQuat_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float qX, float qY, float qZ, float qW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.rotateQuat_unsafe(_destBase, _srcBase, qX, qY, qZ, qW);
        return dest;
    }

    public static java.nio.FloatBuffer rotateQuat_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float qX, float qY, float qZ, float qW) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.rotateQuat(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, qX, qY, qZ, qW);
            return dest;
        }
        Float4x4OpsKernelsSegment.rotateQuat_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, qX, qY, qZ, qW);
        return dest;
    }

    public static java.nio.FloatBuffer rotateQuat_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer q, int qOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _qBase = UnsafeOpsHolder.U.getLong(q, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) qOffset * 4L;
        Float4x4OpsKernelsAddress.rotateQuat_unsafe(_destBase, _srcBase, _qBase);
        return dest;
    }

    public static java.nio.FloatBuffer rotateQuat_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer q, int qOffset) {
        if (dest.hasArray() && src.hasArray() && q.hasArray()) {
            Float4x4Ops.rotateQuat(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, q.array(), q.arrayOffset() + qOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.rotateQuat_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(q.duplicate().position(0)), (long) qOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer rotateX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.rotateX_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.FloatBuffer rotateX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.rotateX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angle);
            return dest;
        }
        Float4x4OpsKernelsSegment.rotateX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, angle);
        return dest;
    }

    public static java.nio.FloatBuffer rotateXYZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.rotateXYZ_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.FloatBuffer rotateXYZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.rotateXYZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angleX, angleY, angleZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.rotateXYZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.FloatBuffer rotateXZY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.rotateXZY_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.FloatBuffer rotateXZY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.rotateXZY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angleX, angleY, angleZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.rotateXZY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.FloatBuffer rotateY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.rotateY_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.FloatBuffer rotateY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.rotateY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angle);
            return dest;
        }
        Float4x4OpsKernelsSegment.rotateY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, angle);
        return dest;
    }

    public static java.nio.FloatBuffer rotateYXZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.rotateYXZ_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.FloatBuffer rotateYXZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.rotateYXZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angleX, angleY, angleZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.rotateYXZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.FloatBuffer rotateYZX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.rotateYZX_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.FloatBuffer rotateYZX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.rotateYZX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angleX, angleY, angleZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.rotateYZX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.FloatBuffer rotateZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.rotateZ_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.FloatBuffer rotateZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.rotateZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angle);
            return dest;
        }
        Float4x4OpsKernelsSegment.rotateZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, angle);
        return dest;
    }

    public static java.nio.FloatBuffer rotateZXY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.rotateZXY_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.FloatBuffer rotateZXY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.rotateZXY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angleX, angleY, angleZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.rotateZXY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.FloatBuffer rotateZYX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.rotateZYX_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.FloatBuffer rotateZYX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.rotateZYX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angleX, angleY, angleZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.rotateZYX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.FloatBuffer scale_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float vX, float vY, float vZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.scale_unsafe(_destBase, _srcBase, vX, vY, vZ);
        return dest;
    }

    public static java.nio.FloatBuffer scale_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float vX, float vY, float vZ) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.scale(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, vX, vY, vZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.scale_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, vX, vY, vZ);
        return dest;
    }

    public static java.nio.FloatBuffer scale_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 4L;
        Float4x4OpsKernelsAddress.scale_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.FloatBuffer scale_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer v, int vOffset) {
        if (dest.hasArray() && src.hasArray() && v.hasArray()) {
            Float4x4Ops.scale(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, v.array(), v.arrayOffset() + vOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.scale_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(v.duplicate().position(0)), (long) vOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer scale_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float s) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.scale_unsafe(_destBase, _srcBase, s);
        return dest;
    }

    public static java.nio.FloatBuffer scale_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float s) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.scale(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, s);
            return dest;
        }
        Float4x4OpsKernelsSegment.scale_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, s);
        return dest;
    }

    public static java.nio.FloatBuffer scaleAround_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float s, float pivotX, float pivotY, float pivotZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.scaleAround_unsafe(_destBase, _srcBase, s, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.FloatBuffer scaleAround_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float s, float pivotX, float pivotY, float pivotZ) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.scaleAround(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, s, pivotX, pivotY, pivotZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.scaleAround_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, s, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.FloatBuffer scaleAround_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer pivot, int pivotOffset, float s) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _pivotBase = UnsafeOpsHolder.U.getLong(pivot, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pivotOffset * 4L;
        Float4x4OpsKernelsAddress.scaleAround_unsafe(_destBase, _srcBase, _pivotBase, s);
        return dest;
    }

    public static java.nio.FloatBuffer scaleAround_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer pivot, int pivotOffset, float s) {
        if (dest.hasArray() && src.hasArray() && pivot.hasArray()) {
            Float4x4Ops.scaleAround(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, pivot.array(), pivot.arrayOffset() + pivotOffset, s);
            return dest;
        }
        Float4x4OpsKernelsSegment.scaleAround_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(pivot.duplicate().position(0)), (long) pivotOffset * 4L, s);
        return dest;
    }

    public static java.nio.FloatBuffer scaleAround_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float sX, float sY, float sZ, float pivotX, float pivotY, float pivotZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.scaleAround_unsafe(_destBase, _srcBase, sX, sY, sZ, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.FloatBuffer scaleAround_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float sX, float sY, float sZ, float pivotX, float pivotY, float pivotZ) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.scaleAround(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, sX, sY, sZ, pivotX, pivotY, pivotZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.scaleAround_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, sX, sY, sZ, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.FloatBuffer scaleAround_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer s, int sOffset, java.nio.FloatBuffer pivot, int pivotOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _sBase = UnsafeOpsHolder.U.getLong(s, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) sOffset * 4L;
        long _pivotBase = UnsafeOpsHolder.U.getLong(pivot, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pivotOffset * 4L;
        Float4x4OpsKernelsAddress.scaleAround_unsafe(_destBase, _srcBase, _sBase, _pivotBase);
        return dest;
    }

    public static java.nio.FloatBuffer scaleAround_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer s, int sOffset, java.nio.FloatBuffer pivot, int pivotOffset) {
        if (dest.hasArray() && src.hasArray() && s.hasArray() && pivot.hasArray()) {
            Float4x4Ops.scaleAround(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, s.array(), s.arrayOffset() + sOffset, pivot.array(), pivot.arrayOffset() + pivotOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.scaleAround_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(s.duplicate().position(0)), (long) sOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(pivot.duplicate().position(0)), (long) pivotOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer shadow_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float lightX, float lightY, float lightZ, float lightW, float planeX, float planeY, float planeZ, float planeW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.shadow_unsafe(_destBase, _srcBase, lightX, lightY, lightZ, lightW, planeX, planeY, planeZ, planeW);
        return dest;
    }

    public static java.nio.FloatBuffer shadow_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float lightX, float lightY, float lightZ, float lightW, float planeX, float planeY, float planeZ, float planeW) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.shadow(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, lightX, lightY, lightZ, lightW, planeX, planeY, planeZ, planeW);
            return dest;
        }
        Float4x4OpsKernelsSegment.shadow_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, lightX, lightY, lightZ, lightW, planeX, planeY, planeZ, planeW);
        return dest;
    }

    public static java.nio.FloatBuffer shadow_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer light, int lightOffset, java.nio.FloatBuffer plane, int planeOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _lightBase = UnsafeOpsHolder.U.getLong(light, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) lightOffset * 4L;
        long _planeBase = UnsafeOpsHolder.U.getLong(plane, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) planeOffset * 4L;
        Float4x4OpsKernelsAddress.shadow_unsafe(_destBase, _srcBase, _lightBase, _planeBase);
        return dest;
    }

    public static java.nio.FloatBuffer shadow_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer light, int lightOffset, java.nio.FloatBuffer plane, int planeOffset) {
        if (dest.hasArray() && src.hasArray() && light.hasArray() && plane.hasArray()) {
            Float4x4Ops.shadow(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, light.array(), light.arrayOffset() + lightOffset, plane.array(), plane.arrayOffset() + planeOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.shadow_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(light.duplicate().position(0)), (long) lightOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(plane.duplicate().position(0)), (long) planeOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer shear_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float xy, float xz, float yx, float yz, float zx, float zy) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.shear_unsafe(_destBase, _srcBase, xy, xz, yx, yz, zx, zy);
        return dest;
    }

    public static java.nio.FloatBuffer shear_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float xy, float xz, float yx, float yz, float zx, float zy) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.shear(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, xy, xz, yx, yz, zx, zy);
            return dest;
        }
        Float4x4OpsKernelsSegment.shear_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, xy, xz, yx, yz, zx, zy);
        return dest;
    }

    public static java.nio.FloatBuffer tile_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float x, float y, float w, float h) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.tile_unsafe(_destBase, _srcBase, x, y, w, h);
        return dest;
    }

    public static java.nio.FloatBuffer tile_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float x, float y, float w, float h) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.tile(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, x, y, w, h);
            return dest;
        }
        Float4x4OpsKernelsSegment.tile_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, x, y, w, h);
        return dest;
    }

    public static java.nio.FloatBuffer translate_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float vX, float vY, float vZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.translate_unsafe(_destBase, _srcBase, vX, vY, vZ);
        return dest;
    }

    public static java.nio.FloatBuffer translate_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float vX, float vY, float vZ) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.translate(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, vX, vY, vZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.translate_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, vX, vY, vZ);
        return dest;
    }

    public static java.nio.FloatBuffer translate_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 4L;
        Float4x4OpsKernelsAddress.translate_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.FloatBuffer translate_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer v, int vOffset) {
        if (dest.hasArray() && src.hasArray() && v.hasArray()) {
            Float4x4Ops.translate(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, v.array(), v.arrayOffset() + vOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.translate_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(v.duplicate().position(0)), (long) vOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer trapezoidCrop_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float p0X, float p0Y, float p1X, float p1Y, float p2X, float p2Y, float p3X, float p3Y) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.trapezoidCrop_unsafe(_destBase, _srcBase, p0X, p0Y, p1X, p1Y, p2X, p2Y, p3X, p3Y);
        return dest;
    }

    public static java.nio.FloatBuffer trapezoidCrop_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float p0X, float p0Y, float p1X, float p1Y, float p2X, float p2Y, float p3X, float p3Y) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.trapezoidCrop(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, p0X, p0Y, p1X, p1Y, p2X, p2Y, p3X, p3Y);
            return dest;
        }
        Float4x4OpsKernelsSegment.trapezoidCrop_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, p0X, p0Y, p1X, p1Y, p2X, p2Y, p3X, p3Y);
        return dest;
    }

    public static java.nio.FloatBuffer trapezoidCrop_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer p0, int p0Offset, java.nio.FloatBuffer p1, int p1Offset, java.nio.FloatBuffer p2, int p2Offset, java.nio.FloatBuffer p3, int p3Offset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _p0Base = UnsafeOpsHolder.U.getLong(p0, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p0Offset * 4L;
        long _p1Base = UnsafeOpsHolder.U.getLong(p1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p1Offset * 4L;
        long _p2Base = UnsafeOpsHolder.U.getLong(p2, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p2Offset * 4L;
        long _p3Base = UnsafeOpsHolder.U.getLong(p3, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p3Offset * 4L;
        Float4x4OpsKernelsAddress.trapezoidCrop_unsafe(_destBase, _srcBase, _p0Base, _p1Base, _p2Base, _p3Base);
        return dest;
    }

    public static java.nio.FloatBuffer trapezoidCrop_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer p0, int p0Offset, java.nio.FloatBuffer p1, int p1Offset, java.nio.FloatBuffer p2, int p2Offset, java.nio.FloatBuffer p3, int p3Offset) {
        if (dest.hasArray() && src.hasArray() && p0.hasArray() && p1.hasArray() && p2.hasArray() && p3.hasArray()) {
            Float4x4Ops.trapezoidCrop(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, p0.array(), p0.arrayOffset() + p0Offset, p1.array(), p1.arrayOffset() + p1Offset, p2.array(), p2.arrayOffset() + p2Offset, p3.array(), p3.arrayOffset() + p3Offset);
            return dest;
        }
        Float4x4OpsKernelsSegment.trapezoidCrop_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(p0.duplicate().position(0)), (long) p0Offset * 4L, java.lang.foreign.MemorySegment.ofBuffer(p1.duplicate().position(0)), (long) p1Offset * 4L, java.lang.foreign.MemorySegment.ofBuffer(p2.duplicate().position(0)), (long) p2Offset * 4L, java.lang.foreign.MemorySegment.ofBuffer(p3.duplicate().position(0)), (long) p3Offset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer unproject_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float winCoordsX, float winCoordsY, float winCoordsZ, float viewportX, float viewportY, float viewportZ, float viewportW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.unproject_unsafe(_destBase, _srcBase, winCoordsX, winCoordsY, winCoordsZ, viewportX, viewportY, viewportZ, viewportW);
        return dest;
    }

    public static java.nio.FloatBuffer unproject_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float winCoordsX, float winCoordsY, float winCoordsZ, float viewportX, float viewportY, float viewportZ, float viewportW) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.unproject(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, winCoordsX, winCoordsY, winCoordsZ, viewportX, viewportY, viewportZ, viewportW);
            return dest;
        }
        Float4x4OpsKernelsSegment.unproject_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, winCoordsX, winCoordsY, winCoordsZ, viewportX, viewportY, viewportZ, viewportW);
        return dest;
    }

    public static java.nio.FloatBuffer unproject_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer winCoords, int winCoordsOffset, java.nio.FloatBuffer viewport, int viewportOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _winCoordsBase = UnsafeOpsHolder.U.getLong(winCoords, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) winCoordsOffset * 4L;
        long _viewportBase = UnsafeOpsHolder.U.getLong(viewport, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) viewportOffset * 4L;
        Float4x4OpsKernelsAddress.unproject_unsafe(_destBase, _srcBase, _winCoordsBase, _viewportBase);
        return dest;
    }

    public static java.nio.FloatBuffer unproject_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer winCoords, int winCoordsOffset, java.nio.FloatBuffer viewport, int viewportOffset) {
        if (dest.hasArray() && src.hasArray() && winCoords.hasArray() && viewport.hasArray()) {
            Float4x4Ops.unproject(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, winCoords.array(), winCoords.arrayOffset() + winCoordsOffset, viewport.array(), viewport.arrayOffset() + viewportOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.unproject_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(winCoords.duplicate().position(0)), (long) winCoordsOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(viewport.duplicate().position(0)), (long) viewportOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer unprojectInv_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float winCoordsX, float winCoordsY, float winCoordsZ, float viewportX, float viewportY, float viewportZ, float viewportW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.unprojectInv_unsafe(_destBase, _srcBase, winCoordsX, winCoordsY, winCoordsZ, viewportX, viewportY, viewportZ, viewportW);
        return dest;
    }

    public static java.nio.FloatBuffer unprojectInv_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float winCoordsX, float winCoordsY, float winCoordsZ, float viewportX, float viewportY, float viewportZ, float viewportW) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.unprojectInv(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, winCoordsX, winCoordsY, winCoordsZ, viewportX, viewportY, viewportZ, viewportW);
            return dest;
        }
        Float4x4OpsKernelsSegment.unprojectInv_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, winCoordsX, winCoordsY, winCoordsZ, viewportX, viewportY, viewportZ, viewportW);
        return dest;
    }

    public static java.nio.FloatBuffer unprojectInv_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer winCoords, int winCoordsOffset, java.nio.FloatBuffer viewport, int viewportOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _winCoordsBase = UnsafeOpsHolder.U.getLong(winCoords, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) winCoordsOffset * 4L;
        long _viewportBase = UnsafeOpsHolder.U.getLong(viewport, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) viewportOffset * 4L;
        Float4x4OpsKernelsAddress.unprojectInv_unsafe(_destBase, _srcBase, _winCoordsBase, _viewportBase);
        return dest;
    }

    public static java.nio.FloatBuffer unprojectInv_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer winCoords, int winCoordsOffset, java.nio.FloatBuffer viewport, int viewportOffset) {
        if (dest.hasArray() && src.hasArray() && winCoords.hasArray() && viewport.hasArray()) {
            Float4x4Ops.unprojectInv(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, winCoords.array(), winCoords.arrayOffset() + winCoordsOffset, viewport.array(), viewport.arrayOffset() + viewportOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.unprojectInv_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(winCoords.duplicate().position(0)), (long) winCoordsOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(viewport.duplicate().position(0)), (long) viewportOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer unprojectInvRay_unsafe(java.nio.FloatBuffer rayOrigin, int rayOriginOffset, java.nio.FloatBuffer rayDir, int rayDirOffset, java.nio.FloatBuffer src, int srcOffset, float winCoordsX, float winCoordsY, float viewportX, float viewportY, float viewportZ, float viewportW) {
        long _rayOriginBase = UnsafeOpsHolder.U.getLong(rayOrigin, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rayOriginOffset * 4L;
        long _rayDirBase = UnsafeOpsHolder.U.getLong(rayDir, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rayDirOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.unprojectInvRay_unsafe(_rayOriginBase, _rayDirBase, _srcBase, winCoordsX, winCoordsY, viewportX, viewportY, viewportZ, viewportW);
        return rayOrigin;
    }

    public static java.nio.FloatBuffer unprojectInvRay_api(java.nio.FloatBuffer rayOrigin, int rayOriginOffset, java.nio.FloatBuffer rayDir, int rayDirOffset, java.nio.FloatBuffer src, int srcOffset, float winCoordsX, float winCoordsY, float viewportX, float viewportY, float viewportZ, float viewportW) {
        if (rayOrigin.hasArray() && rayDir.hasArray() && src.hasArray()) {
            Float4x4Ops.unprojectInvRay(rayOrigin.array(), rayOrigin.arrayOffset() + rayOriginOffset, rayDir.array(), rayDir.arrayOffset() + rayDirOffset, src.array(), src.arrayOffset() + srcOffset, winCoordsX, winCoordsY, viewportX, viewportY, viewportZ, viewportW);
            return rayOrigin;
        }
        Float4x4OpsKernelsSegment.unprojectInvRay_api(java.lang.foreign.MemorySegment.ofBuffer(rayOrigin.duplicate().position(0)), (long) rayOriginOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(rayDir.duplicate().position(0)), (long) rayDirOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, winCoordsX, winCoordsY, viewportX, viewportY, viewportZ, viewportW);
        return rayOrigin;
    }

    public static java.nio.FloatBuffer unprojectInvRay_unsafe(java.nio.FloatBuffer rayOrigin, int rayOriginOffset, java.nio.FloatBuffer rayDir, int rayDirOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer winCoords, int winCoordsOffset, java.nio.FloatBuffer viewport, int viewportOffset) {
        long _rayOriginBase = UnsafeOpsHolder.U.getLong(rayOrigin, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rayOriginOffset * 4L;
        long _rayDirBase = UnsafeOpsHolder.U.getLong(rayDir, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rayDirOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _winCoordsBase = UnsafeOpsHolder.U.getLong(winCoords, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) winCoordsOffset * 4L;
        long _viewportBase = UnsafeOpsHolder.U.getLong(viewport, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) viewportOffset * 4L;
        Float4x4OpsKernelsAddress.unprojectInvRay_unsafe(_rayOriginBase, _rayDirBase, _srcBase, _winCoordsBase, _viewportBase);
        return rayOrigin;
    }

    public static java.nio.FloatBuffer unprojectInvRay_api(java.nio.FloatBuffer rayOrigin, int rayOriginOffset, java.nio.FloatBuffer rayDir, int rayDirOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer winCoords, int winCoordsOffset, java.nio.FloatBuffer viewport, int viewportOffset) {
        if (rayOrigin.hasArray() && rayDir.hasArray() && src.hasArray() && winCoords.hasArray() && viewport.hasArray()) {
            Float4x4Ops.unprojectInvRay(rayOrigin.array(), rayOrigin.arrayOffset() + rayOriginOffset, rayDir.array(), rayDir.arrayOffset() + rayDirOffset, src.array(), src.arrayOffset() + srcOffset, winCoords.array(), winCoords.arrayOffset() + winCoordsOffset, viewport.array(), viewport.arrayOffset() + viewportOffset);
            return rayOrigin;
        }
        Float4x4OpsKernelsSegment.unprojectInvRay_api(java.lang.foreign.MemorySegment.ofBuffer(rayOrigin.duplicate().position(0)), (long) rayOriginOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(rayDir.duplicate().position(0)), (long) rayDirOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(winCoords.duplicate().position(0)), (long) winCoordsOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(viewport.duplicate().position(0)), (long) viewportOffset * 4L);
        return rayOrigin;
    }

    public static java.nio.FloatBuffer unprojectRay_unsafe(java.nio.FloatBuffer rayOrigin, int rayOriginOffset, java.nio.FloatBuffer rayDir, int rayDirOffset, java.nio.FloatBuffer src, int srcOffset, float winCoordsX, float winCoordsY, float viewportX, float viewportY, float viewportZ, float viewportW) {
        long _rayOriginBase = UnsafeOpsHolder.U.getLong(rayOrigin, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rayOriginOffset * 4L;
        long _rayDirBase = UnsafeOpsHolder.U.getLong(rayDir, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rayDirOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.unprojectRay_unsafe(_rayOriginBase, _rayDirBase, _srcBase, winCoordsX, winCoordsY, viewportX, viewportY, viewportZ, viewportW);
        return rayOrigin;
    }

    public static java.nio.FloatBuffer unprojectRay_api(java.nio.FloatBuffer rayOrigin, int rayOriginOffset, java.nio.FloatBuffer rayDir, int rayDirOffset, java.nio.FloatBuffer src, int srcOffset, float winCoordsX, float winCoordsY, float viewportX, float viewportY, float viewportZ, float viewportW) {
        if (rayOrigin.hasArray() && rayDir.hasArray() && src.hasArray()) {
            Float4x4Ops.unprojectRay(rayOrigin.array(), rayOrigin.arrayOffset() + rayOriginOffset, rayDir.array(), rayDir.arrayOffset() + rayDirOffset, src.array(), src.arrayOffset() + srcOffset, winCoordsX, winCoordsY, viewportX, viewportY, viewportZ, viewportW);
            return rayOrigin;
        }
        Float4x4OpsKernelsSegment.unprojectRay_api(java.lang.foreign.MemorySegment.ofBuffer(rayOrigin.duplicate().position(0)), (long) rayOriginOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(rayDir.duplicate().position(0)), (long) rayDirOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, winCoordsX, winCoordsY, viewportX, viewportY, viewportZ, viewportW);
        return rayOrigin;
    }

    public static java.nio.FloatBuffer unprojectRay_unsafe(java.nio.FloatBuffer rayOrigin, int rayOriginOffset, java.nio.FloatBuffer rayDir, int rayDirOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer winCoords, int winCoordsOffset, java.nio.FloatBuffer viewport, int viewportOffset) {
        long _rayOriginBase = UnsafeOpsHolder.U.getLong(rayOrigin, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rayOriginOffset * 4L;
        long _rayDirBase = UnsafeOpsHolder.U.getLong(rayDir, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rayDirOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _winCoordsBase = UnsafeOpsHolder.U.getLong(winCoords, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) winCoordsOffset * 4L;
        long _viewportBase = UnsafeOpsHolder.U.getLong(viewport, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) viewportOffset * 4L;
        Float4x4OpsKernelsAddress.unprojectRay_unsafe(_rayOriginBase, _rayDirBase, _srcBase, _winCoordsBase, _viewportBase);
        return rayOrigin;
    }

    public static java.nio.FloatBuffer unprojectRay_api(java.nio.FloatBuffer rayOrigin, int rayOriginOffset, java.nio.FloatBuffer rayDir, int rayDirOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer winCoords, int winCoordsOffset, java.nio.FloatBuffer viewport, int viewportOffset) {
        if (rayOrigin.hasArray() && rayDir.hasArray() && src.hasArray() && winCoords.hasArray() && viewport.hasArray()) {
            Float4x4Ops.unprojectRay(rayOrigin.array(), rayOrigin.arrayOffset() + rayOriginOffset, rayDir.array(), rayDir.arrayOffset() + rayDirOffset, src.array(), src.arrayOffset() + srcOffset, winCoords.array(), winCoords.arrayOffset() + winCoordsOffset, viewport.array(), viewport.arrayOffset() + viewportOffset);
            return rayOrigin;
        }
        Float4x4OpsKernelsSegment.unprojectRay_api(java.lang.foreign.MemorySegment.ofBuffer(rayOrigin.duplicate().position(0)), (long) rayOriginOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(rayDir.duplicate().position(0)), (long) rayDirOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(winCoords.duplicate().position(0)), (long) winCoordsOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(viewport.duplicate().position(0)), (long) viewportOffset * 4L);
        return rayOrigin;
    }

    public static java.nio.FloatBuffer mulVec4_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float vX, float vY, float vZ, float vW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mulVec4_unsafe(_destBase, _srcBase, vX, vY, vZ, vW);
        return dest;
    }

    public static java.nio.FloatBuffer mulVec4_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float vX, float vY, float vZ, float vW) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.mulVec4(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, vX, vY, vZ, vW);
            return dest;
        }
        Float4x4OpsKernelsSegment.mulVec4_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, vX, vY, vZ, vW);
        return dest;
    }

    public static java.nio.FloatBuffer mulVec4_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 4L;
        Float4x4OpsKernelsAddress.mulVec4_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.FloatBuffer mulVec4_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer v, int vOffset) {
        if (dest.hasArray() && src.hasArray() && v.hasArray()) {
            Float4x4Ops.mulVec4(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, v.array(), v.arrayOffset() + vOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.mulVec4_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(v.duplicate().position(0)), (long) vOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer transformAabb_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.transformAabb_unsafe(_destBase, _srcBase, minX, minY, minZ, maxX, maxY, maxZ);
        return dest;
    }

    public static java.nio.FloatBuffer transformAabb_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.transformAabb(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, minX, minY, minZ, maxX, maxY, maxZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.transformAabb_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, minX, minY, minZ, maxX, maxY, maxZ);
        return dest;
    }

    public static java.nio.FloatBuffer transformDirection_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float vX, float vY, float vZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.transformDirection_unsafe(_destBase, _srcBase, vX, vY, vZ);
        return dest;
    }

    public static java.nio.FloatBuffer transformDirection_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float vX, float vY, float vZ) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.transformDirection(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, vX, vY, vZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.transformDirection_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, vX, vY, vZ);
        return dest;
    }

    public static java.nio.FloatBuffer transformDirection_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 4L;
        Float4x4OpsKernelsAddress.transformDirection_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.FloatBuffer transformDirection_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer v, int vOffset) {
        if (dest.hasArray() && src.hasArray() && v.hasArray()) {
            Float4x4Ops.transformDirection(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, v.array(), v.arrayOffset() + vOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.transformDirection_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(v.duplicate().position(0)), (long) vOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer transformPosition_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float vX, float vY, float vZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.transformPosition_unsafe(_destBase, _srcBase, vX, vY, vZ);
        return dest;
    }

    public static java.nio.FloatBuffer transformPosition_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float vX, float vY, float vZ) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.transformPosition(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, vX, vY, vZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.transformPosition_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, vX, vY, vZ);
        return dest;
    }

    public static java.nio.FloatBuffer transformPosition_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 4L;
        Float4x4OpsKernelsAddress.transformPosition_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.FloatBuffer transformPosition_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer v, int vOffset) {
        if (dest.hasArray() && src.hasArray() && v.hasArray()) {
            Float4x4Ops.transformPosition(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, v.array(), v.arrayOffset() + vOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.transformPosition_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(v.duplicate().position(0)), (long) vOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer transformProject_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float vX, float vY, float vZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.transformProject_unsafe(_destBase, _srcBase, vX, vY, vZ);
        return dest;
    }

    public static java.nio.FloatBuffer transformProject_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float vX, float vY, float vZ) {
        if (dest.hasArray() && src.hasArray()) {
            Float4x4Ops.transformProject(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, vX, vY, vZ);
            return dest;
        }
        Float4x4OpsKernelsSegment.transformProject_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, vX, vY, vZ);
        return dest;
    }

    public static java.nio.FloatBuffer transformProject_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 4L;
        Float4x4OpsKernelsAddress.transformProject_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.FloatBuffer transformProject_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer v, int vOffset) {
        if (dest.hasArray() && src.hasArray() && v.hasArray()) {
            Float4x4Ops.transformProject(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, v.array(), v.arrayOffset() + vOffset);
            return dest;
        }
        Float4x4OpsKernelsSegment.transformProject_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 4L, java.lang.foreign.MemorySegment.ofBuffer(v.duplicate().position(0)), (long) vOffset * 4L);
        return dest;
    }

    public static java.nio.FloatBuffer transformPosition_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer matrix, int matrixOffset, java.nio.FloatBuffer points, int pointsOffset, int count) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _matrixBase = UnsafeOpsHolder.U.getLong(matrix, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) matrixOffset * 4L;
        long _pointsBase = UnsafeOpsHolder.U.getLong(points, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pointsOffset * 4L;
        Float4x4OpsKernelsAddress.transformPosition_unsafe(_destBase, _matrixBase, _pointsBase, count);
        return dest;
    }

    public static java.nio.FloatBuffer transformPosition_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer matrix, int matrixOffset, java.nio.FloatBuffer points, int pointsOffset, int count) {
        float _m00 = matrix.get(matrixOffset + 0);
        float _m01 = matrix.get(matrixOffset + 4);
        float _m02 = matrix.get(matrixOffset + 8);
        float _m03 = matrix.get(matrixOffset + 12);
        float _m10 = matrix.get(matrixOffset + 1);
        float _m11 = matrix.get(matrixOffset + 5);
        float _m12 = matrix.get(matrixOffset + 9);
        float _m13 = matrix.get(matrixOffset + 13);
        float _m20 = matrix.get(matrixOffset + 2);
        float _m21 = matrix.get(matrixOffset + 6);
        float _m22 = matrix.get(matrixOffset + 10);
        float _m23 = matrix.get(matrixOffset + 14);
        for (int _i = 0; _i < count; _i++) {
            int _po = pointsOffset + _i * 3;
            int _do = destOffset + _i * 3;
            float px = points.get(_po + 0), py = points.get(_po + 1), pz = points.get(_po + 2);
            dest.put(_do + 0, Math.fma(_m00, px, Math.fma(_m01, py, Math.fma(_m02, pz, _m03))));
            dest.put(_do + 1, Math.fma(_m10, px, Math.fma(_m11, py, Math.fma(_m12, pz, _m13))));
            dest.put(_do + 2, Math.fma(_m20, px, Math.fma(_m21, py, Math.fma(_m22, pz, _m23))));
        }
        return dest;
    }

    public static java.nio.FloatBuffer transformDirection_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer matrix, int matrixOffset, java.nio.FloatBuffer points, int pointsOffset, int count) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _matrixBase = UnsafeOpsHolder.U.getLong(matrix, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) matrixOffset * 4L;
        long _pointsBase = UnsafeOpsHolder.U.getLong(points, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pointsOffset * 4L;
        Float4x4OpsKernelsAddress.transformDirection_unsafe(_destBase, _matrixBase, _pointsBase, count);
        return dest;
    }

    public static java.nio.FloatBuffer transformDirection_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer matrix, int matrixOffset, java.nio.FloatBuffer points, int pointsOffset, int count) {
        float _m00 = matrix.get(matrixOffset + 0);
        float _m01 = matrix.get(matrixOffset + 4);
        float _m02 = matrix.get(matrixOffset + 8);
        float _m10 = matrix.get(matrixOffset + 1);
        float _m11 = matrix.get(matrixOffset + 5);
        float _m12 = matrix.get(matrixOffset + 9);
        float _m20 = matrix.get(matrixOffset + 2);
        float _m21 = matrix.get(matrixOffset + 6);
        float _m22 = matrix.get(matrixOffset + 10);
        for (int _i = 0; _i < count; _i++) {
            int _po = pointsOffset + _i * 3;
            int _do = destOffset + _i * 3;
            float px = points.get(_po + 0), py = points.get(_po + 1), pz = points.get(_po + 2);
            dest.put(_do + 0, Math.fma(_m02, pz, Math.fma(_m00, px, _m01 * py)));
            dest.put(_do + 1, Math.fma(_m12, pz, Math.fma(_m10, px, _m11 * py)));
            dest.put(_do + 2, Math.fma(_m22, pz, Math.fma(_m20, px, _m21 * py)));
        }
        return dest;
    }

    public static java.nio.FloatBuffer transformProject_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer matrix, int matrixOffset, java.nio.FloatBuffer points, int pointsOffset, int count) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _matrixBase = UnsafeOpsHolder.U.getLong(matrix, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) matrixOffset * 4L;
        long _pointsBase = UnsafeOpsHolder.U.getLong(points, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pointsOffset * 4L;
        Float4x4OpsKernelsAddress.transformProject_unsafe(_destBase, _matrixBase, _pointsBase, count);
        return dest;
    }

    public static java.nio.FloatBuffer transformProject_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer matrix, int matrixOffset, java.nio.FloatBuffer points, int pointsOffset, int count) {
        float _m00 = matrix.get(matrixOffset + 0);
        float _m01 = matrix.get(matrixOffset + 4);
        float _m02 = matrix.get(matrixOffset + 8);
        float _m03 = matrix.get(matrixOffset + 12);
        float _m10 = matrix.get(matrixOffset + 1);
        float _m11 = matrix.get(matrixOffset + 5);
        float _m12 = matrix.get(matrixOffset + 9);
        float _m13 = matrix.get(matrixOffset + 13);
        float _m20 = matrix.get(matrixOffset + 2);
        float _m21 = matrix.get(matrixOffset + 6);
        float _m22 = matrix.get(matrixOffset + 10);
        float _m23 = matrix.get(matrixOffset + 14);
        float _m30 = matrix.get(matrixOffset + 3);
        float _m31 = matrix.get(matrixOffset + 7);
        float _m32 = matrix.get(matrixOffset + 11);
        float _m33 = matrix.get(matrixOffset + 15);
        for (int _i = 0; _i < count; _i++) {
            int _po = pointsOffset + _i * 3;
            int _do = destOffset + _i * 3;
            float px = points.get(_po + 0), py = points.get(_po + 1), pz = points.get(_po + 2);
            float _w = Math.fma(_m30, px, Math.fma(_m31, py, Math.fma(_m32, pz, _m33)));
            float _inv = 1.0f / _w;
            dest.put(_do + 0, (Math.fma(_m00, px, Math.fma(_m01, py, Math.fma(_m02, pz, _m03)))) * _inv);
            dest.put(_do + 1, (Math.fma(_m10, px, Math.fma(_m11, py, Math.fma(_m12, pz, _m13)))) * _inv);
            dest.put(_do + 2, (Math.fma(_m20, px, Math.fma(_m21, py, Math.fma(_m22, pz, _m23)))) * _inv);
        }
        return dest;
    }

}
