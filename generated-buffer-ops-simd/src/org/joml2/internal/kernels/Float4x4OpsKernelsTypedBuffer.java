package org.joml2.internal.kernels;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.ops.*;
import org.joml2.internal.unsafe.*;
import org.joml2.internal.simd.*;

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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _t6 = Math.fma(_self21, _self21, Math.fma(_self01, _self01, _self11 * _self11));
        float _t7 = Math.fma(_self22, _self22, Math.fma(_self02, _self02, _self12 * _self12));
        float _t8 = Math.fma(_self20, _self20, Math.fma(_self00, _self00, _self10 * _self10));
        float _t9 = (1.0f / (float) Math.sqrt(_t6));
        float _t10 = (1.0f / (float) Math.sqrt(_t7));
        float _t11 = (1.0f / (float) Math.sqrt(_t8));
        float _t21, _t23, _t27;
        if (_t6 > 0.0f) {
            _t21 = _self01 * _t9;
            _t23 = _self11 * _t9;
            _t27 = _self21 * _t9;
        } else {
            _t21 = 0.0f;
            _t23 = 0.0f;
            _t27 = 0.0f;
        }
        float _t22, _t24, _t26;
        if (_t7 > 0.0f) {
            _t22 = _self12 * _t10;
            _t24 = _self02 * _t10;
            _t26 = _self22 * _t10;
        } else {
            _t22 = 0.0f;
            _t24 = 0.0f;
            _t26 = 0.0f;
        }
        float _t25, _t28, _t29;
        if (_t8 > 0.0f) {
            _t25 = _self20 * _t11;
            _t28 = _self00 * _t11;
            _t29 = _self10 * _t11;
        } else {
            _t25 = 0.0f;
            _t28 = 0.0f;
            _t29 = 0.0f;
        }
        float _t36 = _t27 - _t22;
        float _t37 = Math.max(_t23, _t26);
        float _t39 = _t27 + _t22;
        float _t48 = Math.fma(Math.fma(_t21, _t22, -(_t23 * _t24)), _t25, Math.fma(Math.fma(_t23, _t26, -(_t27 * _t22)), _t28, Math.fma(_t27, _t24, -(_t21 * _t26)) * _t29));
        float _t49, _t50, _t51;
        if (_t48 < 0.0f) {
            _t49 = -_t28;
            _t50 = -_t29;
            _t51 = -_t25;
        } else {
            _t49 = _t28;
            _t50 = _t29;
            _t51 = _t25;
        }
        float _t52 = _t49 + _t23;
        float _t53 = _t50 + _t21;
        float _t55 = _t51 + _t24;
        float _t56 = _t24 - _t51;
        float _t57 = _t50 - _t21;
        float _t58 = _t52 + _t26;
        float _t62 = 1.0f + _t58;
        float _t63 = 1.0f + (_t49 - (_t23 + _t26));
        float _t64 = 1.0f + (_t23 - (_t49 + _t26));
        float _t65 = 1.0f + (_t26 - _t52);
        float _t66 = (1.0f / (float) Math.sqrt(_t62));
        float _t67 = (1.0f / (float) Math.sqrt(_t64));
        float _t68 = (1.0f / (float) Math.sqrt(_t65));
        float _t69 = (1.0f / (float) Math.sqrt(_t63));
        if (_t58 > 0.0f) {
            dest.put(destOffset + 0, 0.5f * _t36 * _t66);
            dest.put(destOffset + 1, 0.5f * _t56 * _t66);
            dest.put(destOffset + 2, 0.5f * _t57 * _t66);
            dest.put(destOffset + 3, 0.5f * (float) Math.sqrt(_t62));
        } else {
            if (_t49 > _t37) {
                dest.put(destOffset + 0, 0.5f * (float) Math.sqrt(_t63));
                dest.put(destOffset + 1, 0.5f * _t53 * _t69);
                dest.put(destOffset + 2, 0.5f * _t55 * _t69);
                dest.put(destOffset + 3, 0.5f * _t36 * _t69);
            } else {
                if (_t23 > _t26) {
                    dest.put(destOffset + 0, 0.5f * _t53 * _t67);
                    dest.put(destOffset + 1, 0.5f * (float) Math.sqrt(_t64));
                    dest.put(destOffset + 2, 0.5f * _t39 * _t67);
                    dest.put(destOffset + 3, 0.5f * _t56 * _t67);
                } else {
                    dest.put(destOffset + 0, 0.5f * _t55 * _t68);
                    dest.put(destOffset + 1, 0.5f * _t39 * _t68);
                    dest.put(destOffset + 2, 0.5f * (float) Math.sqrt(_t65));
                    dest.put(destOffset + 3, 0.5f * _t57 * _t68);
                }
            }
        }
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _t0 = _self00 + _self11;
        float _t1 = _self21 - _self12;
        float _t2 = Math.max(_self11, _self22);
        float _t4 = _self01 + _self10;
        float _t6 = _self02 + _self20;
        float _t7 = _self02 - _self20;
        float _t8 = _self12 + _self21;
        float _t9 = _self10 - _self01;
        float _t10 = _self22 + _t0;
        float _t14 = 1.0f + _t10;
        float _t15 = 1.0f + (_self00 - (_self11 + _self22));
        float _t16 = 1.0f + (_self11 - (_self00 + _self22));
        float _t17 = 1.0f + (_self22 - _t0);
        float _t18 = (1.0f / (float) Math.sqrt(_t14));
        float _t19 = (1.0f / (float) Math.sqrt(_t16));
        float _t20 = (1.0f / (float) Math.sqrt(_t17));
        float _t21 = (1.0f / (float) Math.sqrt(_t15));
        if (_t10 > 0.0f) {
            dest.put(destOffset + 0, 0.5f * _t1 * _t18);
            dest.put(destOffset + 1, 0.5f * _t7 * _t18);
            dest.put(destOffset + 2, 0.5f * _t9 * _t18);
            dest.put(destOffset + 3, 0.5f * (float) Math.sqrt(_t14));
        } else {
            if (_self00 > _t2) {
                dest.put(destOffset + 0, 0.5f * (float) Math.sqrt(_t15));
                dest.put(destOffset + 1, 0.5f * _t4 * _t21);
                dest.put(destOffset + 2, 0.5f * _t6 * _t21);
                dest.put(destOffset + 3, 0.5f * _t1 * _t21);
            } else {
                if (_self11 > _self22) {
                    dest.put(destOffset + 0, 0.5f * _t4 * _t19);
                    dest.put(destOffset + 1, 0.5f * (float) Math.sqrt(_t16));
                    dest.put(destOffset + 2, 0.5f * _t8 * _t19);
                    dest.put(destOffset + 3, 0.5f * _t7 * _t19);
                } else {
                    dest.put(destOffset + 0, 0.5f * _t6 * _t20);
                    dest.put(destOffset + 1, 0.5f * _t8 * _t20);
                    dest.put(destOffset + 2, 0.5f * (float) Math.sqrt(_t17));
                    dest.put(destOffset + 3, 0.5f * _t9 * _t20);
                }
            }
        }
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
        for (int _i = 0; _i < 16; _i++) {
            float _eself = src.get(srcOffset + _i);
            float _eother = other.get(otherOffset + _i);
            dest.put(destOffset + _i, _eother + _eself);
        }
        return dest;
    }

    public static java.nio.FloatBuffer negate_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.negate_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer negate_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        for (int _i = 0; _i < 16; _i++) {
            float _eself = src.get(srcOffset + _i);
            dest.put(destOffset + _i, -_eself);
        }
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
        for (int _i = 0; _i < 16; _i++) {
            float _eself = src.get(srcOffset + _i);
            float _eother = other.get(otherOffset + _i);
            dest.put(destOffset + _i, _eself - _eother);
        }
        return dest;
    }

    public static java.nio.FloatBuffer set_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 4L;
        Float4x4OpsKernelsAddress.set_unsafe(_destBase, _vBase);
        return dest;
    }

    public static java.nio.FloatBuffer set_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer v, int vOffset) {
        for (int _i = 0; _i < 16; _i++) {
            float _ev = v.get(vOffset + _i);
            dest.put(destOffset + _i, _ev);
        }
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
        float _t0 = tRZ * tRZ;
        float _t1 = tRZ * tRW;
        float _t2 = tRY * tRW;
        dest.put(destOffset + 0, tSX * Math.fma(-2.0f, Math.fma(tRY, tRY, _t0), 1.0f));
        dest.put(destOffset + 1, tSX * 2.0f * Math.fma(tRX, tRY, _t1));
        dest.put(destOffset + 2, tSX * 2.0f * Math.fma(tRX, tRZ, -_t2));
        dest.put(destOffset + 3, 0.0f);
        dest.put(destOffset + 4, tSY * 2.0f * Math.fma(tRX, tRY, -_t1));
        dest.put(destOffset + 5, tSY * Math.fma(-2.0f, Math.fma(tRX, tRX, _t0), 1.0f));
        dest.put(destOffset + 6, tSY * 2.0f * Math.fma(tRX, tRW, tRY * tRZ));
        dest.put(destOffset + 7, 0.0f);
        dest.put(destOffset + 8, tSZ * 2.0f * Math.fma(tRX, tRZ, _t2));
        dest.put(destOffset + 9, tSZ * 2.0f * Math.fma(tRY, tRZ, -(tRX * tRW)));
        dest.put(destOffset + 10, tSZ * Math.fma(-2.0f, Math.fma(tRX, tRX, tRY * tRY), 1.0f));
        dest.put(destOffset + 11, 0.0f);
        dest.put(destOffset + 12, tTX);
        dest.put(destOffset + 13, tTY);
        dest.put(destOffset + 14, tTZ);
        dest.put(destOffset + 15, 1.0f);
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _t2 = Math.fma(_self20, _self20, Math.fma(_self00, _self00, _self10 * _self10));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t7, _t8, _t9;
        if (_t2 > 0.0f) {
            _t7 = _self20 * _t3;
            _t8 = _self00 * _t3;
            _t9 = _self10 * _t3;
        } else {
            _t7 = 0.0f;
            _t8 = 0.0f;
            _t9 = 0.0f;
        }
        float _t19 = -Math.fma(_self21, _t7, Math.fma(_self01, _t8, _self11 * _t9));
        float _t20 = -Math.fma(_self22, _t7, Math.fma(_self02, _t8, _self12 * _t9));
        float _t21 = Math.fma(_t19, _t7, _self21);
        float _t22 = Math.fma(_t19, _t8, _self01);
        float _t23 = Math.fma(_t19, _t9, _self11);
        float _t29 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        float _t30 = (1.0f / (float) Math.sqrt(_t29));
        float _t34, _t35, _t36;
        if (_t29 > 0.0f) {
            _t34 = _t22 * _t30;
            _t35 = _t21 * _t30;
            _t36 = _t23 * _t30;
        } else {
            _t34 = 0.0f;
            _t35 = 0.0f;
            _t36 = 0.0f;
        }
        float _t40 = -Math.fma(Math.fma(_t20, _t7, _self22), _t35, Math.fma(Math.fma(_t20, _t8, _self02), _t34, Math.fma(_t20, _t9, _self12) * _t36));
        float _t44 = Math.fma(_t20, _t7, Math.fma(_t40, _t35, _self22));
        float _t45 = Math.fma(_t20, _t8, Math.fma(_t40, _t34, _self02));
        float _t46 = Math.fma(_t20, _t9, Math.fma(_t40, _t36, _self12));
        float _t49 = Math.fma(_t44, _t44, Math.fma(_t45, _t45, _t46 * _t46));
        float _t50 = (1.0f / (float) Math.sqrt(_t49));
        float _t54, _t55, _t56;
        if (_t49 > 0.0f) {
            _t54 = _t46 * _t50;
            _t55 = _t45 * _t50;
            _t56 = _t44 * _t50;
        } else {
            _t54 = 0.0f;
            _t55 = 0.0f;
            _t56 = 0.0f;
        }
        float _t60 = _t35 - _t54;
        float _t61 = Math.max(_t36, _t56);
        float _t63 = _t35 + _t54;
        float _t72 = Math.fma(Math.fma(_t34, _t54, -(_t36 * _t55)), _t7, Math.fma(Math.fma(_t36, _t56, -(_t35 * _t54)), _t8, Math.fma(_t35, _t55, -(_t34 * _t56)) * _t9));
        float _t73, _t74, _t75;
        if (_t72 < 0.0f) {
            _t73 = -_t8;
            _t74 = -_t9;
            _t75 = -_t7;
        } else {
            _t73 = _t8;
            _t74 = _t9;
            _t75 = _t7;
        }
        float _t76 = _t73 + _t36;
        float _t77 = _t74 + _t34;
        float _t78 = _t74 - _t34;
        float _t80 = _t75 + _t55;
        float _t81 = _t55 - _t75;
        float _t82 = _t76 + _t56;
        float _t86 = 1.0f + _t82;
        float _t87 = 1.0f + (_t73 - (_t36 + _t56));
        float _t88 = 1.0f + (_t36 - (_t73 + _t56));
        float _t89 = 1.0f + (_t56 - _t76);
        float _t90 = (1.0f / (float) Math.sqrt(_t86));
        float _t91 = (1.0f / (float) Math.sqrt(_t88));
        float _t92 = (1.0f / (float) Math.sqrt(_t89));
        float _t93 = (1.0f / (float) Math.sqrt(_t87));
        if (_t82 > 0.0f) {
            dest.put(destOffset + 0, 0.5f * _t60 * _t90);
            dest.put(destOffset + 1, 0.5f * _t81 * _t90);
            dest.put(destOffset + 2, 0.5f * _t78 * _t90);
            dest.put(destOffset + 3, 0.5f * (float) Math.sqrt(_t86));
        } else {
            if (_t73 > _t61) {
                dest.put(destOffset + 0, 0.5f * (float) Math.sqrt(_t87));
                dest.put(destOffset + 1, 0.5f * _t77 * _t93);
                dest.put(destOffset + 2, 0.5f * _t80 * _t93);
                dest.put(destOffset + 3, 0.5f * _t60 * _t93);
            } else {
                if (_t36 > _t56) {
                    dest.put(destOffset + 0, 0.5f * _t77 * _t91);
                    dest.put(destOffset + 1, 0.5f * (float) Math.sqrt(_t88));
                    dest.put(destOffset + 2, 0.5f * _t63 * _t91);
                    dest.put(destOffset + 3, 0.5f * _t81 * _t91);
                } else {
                    dest.put(destOffset + 0, 0.5f * _t80 * _t92);
                    dest.put(destOffset + 1, 0.5f * _t63 * _t92);
                    dest.put(destOffset + 2, 0.5f * (float) Math.sqrt(_t89));
                    dest.put(destOffset + 3, 0.5f * _t78 * _t92);
                }
            }
        }
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
        for (int _i = 0; _i < 16; _i++) {
            float _eself = src.get(srcOffset + _i);
            float _eother = other.get(otherOffset + _i);
            dest.put(destOffset + _i, Math.fma(t, _eother - _eself, _eself));
        }
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        for (int _l = 0; _l < 4; _l++) {
            int _lo = _l * 4;
            float _eright0 = right.get(rightOffset + _lo);
            float _eright1 = right.get(rightOffset + _lo + 1);
            float _eright2 = right.get(rightOffset + _lo + 2);
            float _eright3 = right.get(rightOffset + _lo + 3);
            dest.put(destOffset + _lo, Math.fma(_eright3, _self03, Math.fma(_eright2, _self02, Math.fma(_eright0, _self00, _eright1 * _self01))));
            dest.put(destOffset + _lo + 1, Math.fma(_eright3, _self13, Math.fma(_eright2, _self12, Math.fma(_eright0, _self10, _eright1 * _self11))));
            dest.put(destOffset + _lo + 2, Math.fma(_eright3, _self23, Math.fma(_eright2, _self22, Math.fma(_eright0, _self20, _eright1 * _self21))));
            dest.put(destOffset + _lo + 3, Math.fma(_eright3, _self33, Math.fma(_eright2, _self32, Math.fma(_eright0, _self30, _eright1 * _self31))));
        }
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _right00 = right.get(rightOffset + 0);
        float _right10 = right.get(rightOffset + 1);
        float _right01 = right.get(rightOffset + 2);
        float _right11 = right.get(rightOffset + 3);
        dest.put(destOffset + 0, Math.fma(_right00, _self00, _right10 * _self01));
        dest.put(destOffset + 1, Math.fma(_right00, _self10, _right10 * _self11));
        dest.put(destOffset + 2, Math.fma(_right00, _self20, _right10 * _self21));
        dest.put(destOffset + 3, Math.fma(_right00, _self30, _right10 * _self31));
        dest.put(destOffset + 4, Math.fma(_right01, _self00, _right11 * _self01));
        dest.put(destOffset + 5, Math.fma(_right01, _self10, _right11 * _self11));
        dest.put(destOffset + 6, Math.fma(_right01, _self20, _right11 * _self21));
        dest.put(destOffset + 7, Math.fma(_right01, _self30, _right11 * _self31));
        dest.put(destOffset + 8, _self02);
        dest.put(destOffset + 9, _self12);
        dest.put(destOffset + 10, _self22);
        dest.put(destOffset + 11, _self32);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _right00 = right.get(rightOffset + 0);
        float _right10 = right.get(rightOffset + 1);
        float _right01 = right.get(rightOffset + 2);
        float _right11 = right.get(rightOffset + 3);
        float _right02 = right.get(rightOffset + 4);
        float _right12 = right.get(rightOffset + 5);
        dest.put(destOffset + 0, Math.fma(_right00, _self00, _right10 * _self01));
        dest.put(destOffset + 1, Math.fma(_right00, _self10, _right10 * _self11));
        dest.put(destOffset + 2, Math.fma(_right00, _self20, _right10 * _self21));
        dest.put(destOffset + 3, Math.fma(_right00, _self30, _right10 * _self31));
        dest.put(destOffset + 4, Math.fma(_right01, _self00, _right11 * _self01));
        dest.put(destOffset + 5, Math.fma(_right01, _self10, _right11 * _self11));
        dest.put(destOffset + 6, Math.fma(_right01, _self20, _right11 * _self21));
        dest.put(destOffset + 7, Math.fma(_right01, _self30, _right11 * _self31));
        dest.put(destOffset + 8, Math.fma(_right02, _self00, Math.fma(_right12, _self01, _self02)));
        dest.put(destOffset + 9, Math.fma(_right02, _self10, Math.fma(_right12, _self11, _self12)));
        dest.put(destOffset + 10, Math.fma(_right02, _self20, Math.fma(_right12, _self21, _self22)));
        dest.put(destOffset + 11, Math.fma(_right02, _self30, Math.fma(_right12, _self31, _self32)));
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _right00 = right.get(rightOffset + 0);
        float _right10 = right.get(rightOffset + 1);
        float _right20 = right.get(rightOffset + 2);
        float _right01 = right.get(rightOffset + 3);
        float _right11 = right.get(rightOffset + 4);
        float _right21 = right.get(rightOffset + 5);
        float _right02 = right.get(rightOffset + 6);
        float _right12 = right.get(rightOffset + 7);
        float _right22 = right.get(rightOffset + 8);
        dest.put(destOffset + 0, Math.fma(_right20, _self02, Math.fma(_right00, _self00, _right10 * _self01)));
        dest.put(destOffset + 1, Math.fma(_right20, _self12, Math.fma(_right00, _self10, _right10 * _self11)));
        dest.put(destOffset + 2, Math.fma(_right20, _self22, Math.fma(_right00, _self20, _right10 * _self21)));
        dest.put(destOffset + 3, Math.fma(_right20, _self32, Math.fma(_right00, _self30, _right10 * _self31)));
        dest.put(destOffset + 4, Math.fma(_right21, _self02, Math.fma(_right01, _self00, _right11 * _self01)));
        dest.put(destOffset + 5, Math.fma(_right21, _self12, Math.fma(_right01, _self10, _right11 * _self11)));
        dest.put(destOffset + 6, Math.fma(_right21, _self22, Math.fma(_right01, _self20, _right11 * _self21)));
        dest.put(destOffset + 7, Math.fma(_right21, _self32, Math.fma(_right01, _self30, _right11 * _self31)));
        dest.put(destOffset + 8, Math.fma(_right22, _self02, Math.fma(_right02, _self00, _right12 * _self01)));
        dest.put(destOffset + 9, Math.fma(_right22, _self12, Math.fma(_right02, _self10, _right12 * _self11)));
        dest.put(destOffset + 10, Math.fma(_right22, _self22, Math.fma(_right02, _self20, _right12 * _self21)));
        dest.put(destOffset + 11, Math.fma(_right22, _self32, Math.fma(_right02, _self30, _right12 * _self31)));
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _right00 = right.get(rightOffset + 0);
        float _right01 = right.get(rightOffset + 1);
        float _right02 = right.get(rightOffset + 2);
        float _right03 = right.get(rightOffset + 3);
        float _right10 = right.get(rightOffset + 4);
        float _right11 = right.get(rightOffset + 5);
        float _right12 = right.get(rightOffset + 6);
        float _right13 = right.get(rightOffset + 7);
        float _right20 = right.get(rightOffset + 8);
        float _right21 = right.get(rightOffset + 9);
        float _right22 = right.get(rightOffset + 10);
        float _right23 = right.get(rightOffset + 11);
        dest.put(destOffset + 0, Math.fma(_right20, _self02, Math.fma(_right00, _self00, _right10 * _self01)));
        dest.put(destOffset + 1, Math.fma(_right20, _self12, Math.fma(_right00, _self10, _right10 * _self11)));
        dest.put(destOffset + 2, Math.fma(_right20, _self22, Math.fma(_right00, _self20, _right10 * _self21)));
        dest.put(destOffset + 3, Math.fma(_right20, _self32, Math.fma(_right00, _self30, _right10 * _self31)));
        dest.put(destOffset + 4, Math.fma(_right21, _self02, Math.fma(_right01, _self00, _right11 * _self01)));
        dest.put(destOffset + 5, Math.fma(_right21, _self12, Math.fma(_right01, _self10, _right11 * _self11)));
        dest.put(destOffset + 6, Math.fma(_right21, _self22, Math.fma(_right01, _self20, _right11 * _self21)));
        dest.put(destOffset + 7, Math.fma(_right21, _self32, Math.fma(_right01, _self30, _right11 * _self31)));
        dest.put(destOffset + 8, Math.fma(_right22, _self02, Math.fma(_right02, _self00, _right12 * _self01)));
        dest.put(destOffset + 9, Math.fma(_right22, _self12, Math.fma(_right02, _self10, _right12 * _self11)));
        dest.put(destOffset + 10, Math.fma(_right22, _self22, Math.fma(_right02, _self20, _right12 * _self21)));
        dest.put(destOffset + 11, Math.fma(_right22, _self32, Math.fma(_right02, _self30, _right12 * _self31)));
        dest.put(destOffset + 12, Math.fma(_right03, _self00, Math.fma(_right13, _self01, Math.fma(_right23, _self02, _self03))));
        dest.put(destOffset + 13, Math.fma(_right03, _self10, Math.fma(_right13, _self11, Math.fma(_right23, _self12, _self13))));
        dest.put(destOffset + 14, Math.fma(_right03, _self20, Math.fma(_right13, _self21, Math.fma(_right23, _self22, _self23))));
        dest.put(destOffset + 15, Math.fma(_right03, _self30, Math.fma(_right13, _self31, Math.fma(_right23, _self32, _self33))));
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
        float _other00 = other.get(otherOffset + 0);
        float _other10 = other.get(otherOffset + 1);
        float _other20 = other.get(otherOffset + 2);
        float _other30 = other.get(otherOffset + 3);
        float _other01 = other.get(otherOffset + 4);
        float _other11 = other.get(otherOffset + 5);
        float _other21 = other.get(otherOffset + 6);
        float _other31 = other.get(otherOffset + 7);
        float _other02 = other.get(otherOffset + 8);
        float _other12 = other.get(otherOffset + 9);
        float _other22 = other.get(otherOffset + 10);
        float _other32 = other.get(otherOffset + 11);
        float _other03 = other.get(otherOffset + 12);
        float _other13 = other.get(otherOffset + 13);
        float _other23 = other.get(otherOffset + 14);
        float _other33 = other.get(otherOffset + 15);
        for (int _l = 0; _l < 4; _l++) {
            int _lo = _l * 4;
            float _eself0 = src.get(srcOffset + _lo);
            float _eself1 = src.get(srcOffset + _lo + 1);
            float _eself2 = src.get(srcOffset + _lo + 2);
            float _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, Math.fma(_other03, _eself3, Math.fma(_other02, _eself2, Math.fma(_other00, _eself0, _other01 * _eself1))));
            dest.put(destOffset + _lo + 1, Math.fma(_other13, _eself3, Math.fma(_other12, _eself2, Math.fma(_other10, _eself0, _other11 * _eself1))));
            dest.put(destOffset + _lo + 2, Math.fma(_other23, _eself3, Math.fma(_other22, _eself2, Math.fma(_other20, _eself0, _other21 * _eself1))));
            dest.put(destOffset + _lo + 3, Math.fma(_other33, _eself3, Math.fma(_other32, _eself2, Math.fma(_other30, _eself0, _other31 * _eself1))));
        }
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
        float _colx = col.get(colOffset + 0);
        float _coly = col.get(colOffset + 1);
        float _colz = col.get(colOffset + 2);
        float _colw = col.get(colOffset + 3);
        float _rowx = row.get(rowOffset + 0);
        float _rowy = row.get(rowOffset + 1);
        float _rowz = row.get(rowOffset + 2);
        float _roww = row.get(rowOffset + 3);
        dest.put(destOffset + 0, _colx * _rowx);
        dest.put(destOffset + 1, _coly * _rowx);
        dest.put(destOffset + 2, _colz * _rowx);
        dest.put(destOffset + 3, _colw * _rowx);
        dest.put(destOffset + 4, _colx * _rowy);
        dest.put(destOffset + 5, _coly * _rowy);
        dest.put(destOffset + 6, _colz * _rowy);
        dest.put(destOffset + 7, _colw * _rowy);
        dest.put(destOffset + 8, _colx * _rowz);
        dest.put(destOffset + 9, _coly * _rowz);
        dest.put(destOffset + 10, _colz * _rowz);
        dest.put(destOffset + 11, _colw * _rowz);
        dest.put(destOffset + 12, _colx * _roww);
        dest.put(destOffset + 13, _coly * _roww);
        dest.put(destOffset + 14, _colz * _roww);
        dest.put(destOffset + 15, _colw * _roww);
        return dest;
    }

    public static java.nio.FloatBuffer arcball_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float radius, float centerX, float centerY, float centerZ, float angleX, float angleY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.arcball_unsafe(_destBase, _srcBase, radius, centerX, centerY, centerZ, angleX, angleY);
        return dest;
    }

    public static java.nio.FloatBuffer arcball_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float radius, float centerX, float centerY, float centerZ, float angleX, float angleY) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = (float) Math.sin(angleY);
        float _t1 = (float) Math.cos(angleX);
        float _t2 = (float) Math.cos(angleY);
        float _t3 = (float) Math.sin(angleX);
        float _t4 = -centerZ;
        float _t5 = -centerY;
        float _t6 = _t0 * _t1;
        float _t7 = _t3 * _t0;
        float _t8 = _t1 * _t2;
        float _t9 = _t3 * _t2;
        float _t15 = Math.fma(_t4, _t0, -(centerX * _t2));
        float _t18 = Math.fma(centerZ, _t9, Math.fma(_t5, _t1, -(centerX * _t7)));
        float _t19 = Math.fma(centerX, _t6, Math.fma(_t5, _t3, Math.fma(_t4, _t8, -radius)));
        dest.put(destOffset + 0, Math.fma(-_self02, _t6, Math.fma(_self00, _t2, _self01 * _t7)));
        dest.put(destOffset + 1, Math.fma(-_self12, _t6, Math.fma(_self10, _t2, _self11 * _t7)));
        dest.put(destOffset + 2, Math.fma(-_self22, _t6, Math.fma(_self20, _t2, _self21 * _t7)));
        dest.put(destOffset + 3, Math.fma(-_self32, _t6, Math.fma(_self30, _t2, _self31 * _t7)));
        dest.put(destOffset + 4, Math.fma(_self01, _t1, _self02 * _t3));
        dest.put(destOffset + 5, Math.fma(_self11, _t1, _self12 * _t3));
        dest.put(destOffset + 6, Math.fma(_self21, _t1, _self22 * _t3));
        dest.put(destOffset + 7, Math.fma(_self31, _t1, _self32 * _t3));
        dest.put(destOffset + 8, Math.fma(_self02, _t8, Math.fma(_self00, _t0, -(_self01 * _t9))));
        dest.put(destOffset + 9, Math.fma(_self12, _t8, Math.fma(_self10, _t0, -(_self11 * _t9))));
        dest.put(destOffset + 10, Math.fma(_self22, _t8, Math.fma(_self20, _t0, -(_self21 * _t9))));
        dest.put(destOffset + 11, Math.fma(_self32, _t8, Math.fma(_self30, _t0, -(_self31 * _t9))));
        dest.put(destOffset + 12, Math.fma(_self00, _t15, Math.fma(_self01, _t18, Math.fma(_self02, _t19, _self03))));
        dest.put(destOffset + 13, Math.fma(_self10, _t15, Math.fma(_self11, _t18, Math.fma(_self12, _t19, _self13))));
        dest.put(destOffset + 14, Math.fma(_self20, _t15, Math.fma(_self21, _t18, Math.fma(_self22, _t19, _self23))));
        dest.put(destOffset + 15, Math.fma(_self30, _t15, Math.fma(_self31, _t18, Math.fma(_self32, _t19, _self33))));
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _centerx = center.get(centerOffset + 0);
        float _centery = center.get(centerOffset + 1);
        float _centerz = center.get(centerOffset + 2);
        float _t0 = (float) Math.sin(angleY);
        float _t1 = (float) Math.cos(angleX);
        float _t2 = (float) Math.cos(angleY);
        float _t3 = (float) Math.sin(angleX);
        float _t4 = -_centerz;
        float _t5 = -_centery;
        float _t6 = _t0 * _t1;
        float _t7 = _t3 * _t0;
        float _t8 = _t1 * _t2;
        float _t9 = _t3 * _t2;
        float _t15 = Math.fma(_t4, _t0, -(_centerx * _t2));
        float _t18 = Math.fma(_centerz, _t9, Math.fma(_t5, _t1, -(_centerx * _t7)));
        float _t19 = Math.fma(_centerx, _t6, Math.fma(_t5, _t3, Math.fma(_t4, _t8, -radius)));
        dest.put(destOffset + 0, Math.fma(-_self02, _t6, Math.fma(_self00, _t2, _self01 * _t7)));
        dest.put(destOffset + 1, Math.fma(-_self12, _t6, Math.fma(_self10, _t2, _self11 * _t7)));
        dest.put(destOffset + 2, Math.fma(-_self22, _t6, Math.fma(_self20, _t2, _self21 * _t7)));
        dest.put(destOffset + 3, Math.fma(-_self32, _t6, Math.fma(_self30, _t2, _self31 * _t7)));
        dest.put(destOffset + 4, Math.fma(_self01, _t1, _self02 * _t3));
        dest.put(destOffset + 5, Math.fma(_self11, _t1, _self12 * _t3));
        dest.put(destOffset + 6, Math.fma(_self21, _t1, _self22 * _t3));
        dest.put(destOffset + 7, Math.fma(_self31, _t1, _self32 * _t3));
        dest.put(destOffset + 8, Math.fma(_self02, _t8, Math.fma(_self00, _t0, -(_self01 * _t9))));
        dest.put(destOffset + 9, Math.fma(_self12, _t8, Math.fma(_self10, _t0, -(_self11 * _t9))));
        dest.put(destOffset + 10, Math.fma(_self22, _t8, Math.fma(_self20, _t0, -(_self21 * _t9))));
        dest.put(destOffset + 11, Math.fma(_self32, _t8, Math.fma(_self30, _t0, -(_self31 * _t9))));
        dest.put(destOffset + 12, Math.fma(_self00, _t15, Math.fma(_self01, _t18, Math.fma(_self02, _t19, _self03))));
        dest.put(destOffset + 13, Math.fma(_self10, _t15, Math.fma(_self11, _t18, Math.fma(_self12, _t19, _self13))));
        dest.put(destOffset + 14, Math.fma(_self20, _t15, Math.fma(_self21, _t18, Math.fma(_self22, _t19, _self23))));
        dest.put(destOffset + 15, Math.fma(_self30, _t15, Math.fma(_self31, _t18, Math.fma(_self32, _t19, _self33))));
        return dest;
    }

    public static java.nio.FloatBuffer axonometricDimetric_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float alpha) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.axonometricDimetric_unsafe(_destBase, _srcBase, alpha);
        return dest;
    }

    public static java.nio.FloatBuffer axonometricDimetric_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float alpha) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = (float) Math.cos(alpha);
        float _t1 = (float) Math.sqrt(2.0f);
        float _t2 = (float) Math.sin(alpha);
        float _t5 = _self00 * _t1;
        float _t6 = _self10 * _t1;
        float _t7 = _self20 * _t1;
        float _t8 = _self30 * _t1;
        float _t9 = 0.5f * _t0 * _t1;
        float _t10 = 0.5f * _t2 * _t1;
        dest.put(destOffset + 0, Math.fma(-_self02, _t9, Math.fma(_self01, _t10, 0.5f * _t5)));
        dest.put(destOffset + 1, Math.fma(-_self12, _t9, Math.fma(_self11, _t10, 0.5f * _t6)));
        dest.put(destOffset + 2, Math.fma(-_self22, _t9, Math.fma(_self21, _t10, 0.5f * _t7)));
        dest.put(destOffset + 3, Math.fma(-_self32, _t9, Math.fma(_self31, _t10, 0.5f * _t8)));
        dest.put(destOffset + 4, Math.fma(_self01, _t0, _self02 * _t2));
        dest.put(destOffset + 5, Math.fma(_self11, _t0, _self12 * _t2));
        dest.put(destOffset + 6, Math.fma(_self21, _t0, _self22 * _t2));
        dest.put(destOffset + 7, Math.fma(_self31, _t0, _self32 * _t2));
        dest.put(destOffset + 8, Math.fma(_self02, _t9, Math.fma(0.5f, _t5, -(_self01 * _t10))));
        dest.put(destOffset + 9, Math.fma(_self12, _t9, Math.fma(0.5f, _t6, -(_self11 * _t10))));
        dest.put(destOffset + 10, Math.fma(_self22, _t9, Math.fma(0.5f, _t7, -(_self21 * _t10))));
        dest.put(destOffset + 11, Math.fma(_self32, _t9, Math.fma(0.5f, _t8, -(_self31 * _t10))));
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = (float) Math.sin(alphaY);
        float _t1 = (float) Math.cos(alphaX);
        float _t2 = (float) Math.cos(alphaY);
        float _t3 = (float) Math.sin(alphaX);
        float _t4 = _t0 * _t1;
        float _t5 = _t3 * _t0;
        float _t6 = _t1 * _t2;
        float _t7 = _t3 * _t2;
        dest.put(destOffset + 0, Math.fma(-_self02, _t4, Math.fma(_self00, _t2, _self01 * _t5)));
        dest.put(destOffset + 1, Math.fma(-_self12, _t4, Math.fma(_self10, _t2, _self11 * _t5)));
        dest.put(destOffset + 2, Math.fma(-_self22, _t4, Math.fma(_self20, _t2, _self21 * _t5)));
        dest.put(destOffset + 3, Math.fma(-_self32, _t4, Math.fma(_self30, _t2, _self31 * _t5)));
        dest.put(destOffset + 4, Math.fma(_self01, _t1, _self02 * _t3));
        dest.put(destOffset + 5, Math.fma(_self11, _t1, _self12 * _t3));
        dest.put(destOffset + 6, Math.fma(_self21, _t1, _self22 * _t3));
        dest.put(destOffset + 7, Math.fma(_self31, _t1, _self32 * _t3));
        dest.put(destOffset + 8, Math.fma(_self02, _t6, Math.fma(_self00, _t0, -(_self01 * _t7))));
        dest.put(destOffset + 9, Math.fma(_self12, _t6, Math.fma(_self10, _t0, -(_self11 * _t7))));
        dest.put(destOffset + 10, Math.fma(_self22, _t6, Math.fma(_self20, _t0, -(_self21 * _t7))));
        dest.put(destOffset + 11, Math.fma(_self32, _t6, Math.fma(_self30, _t0, -(_self31 * _t7))));
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer composeTRS_unsafe(java.nio.FloatBuffer dest, int destOffset, float translationX, float translationY, float translationZ, float rotationX, float rotationY, float rotationZ, float rotationW, float scaleX, float scaleY, float scaleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float4x4OpsKernelsAddress.composeTRS_unsafe(_destBase, translationX, translationY, translationZ, rotationX, rotationY, rotationZ, rotationW, scaleX, scaleY, scaleZ);
        return dest;
    }

    public static java.nio.FloatBuffer composeTRS_api(java.nio.FloatBuffer dest, int destOffset, float translationX, float translationY, float translationZ, float rotationX, float rotationY, float rotationZ, float rotationW, float scaleX, float scaleY, float scaleZ) {
        float _t0 = rotationZ * rotationZ;
        float _t1 = rotationZ * rotationW;
        float _t2 = rotationY * rotationW;
        dest.put(destOffset + 0, scaleX * Math.fma(-2.0f, Math.fma(rotationY, rotationY, _t0), 1.0f));
        dest.put(destOffset + 1, scaleX * 2.0f * Math.fma(rotationX, rotationY, _t1));
        dest.put(destOffset + 2, scaleX * 2.0f * Math.fma(rotationX, rotationZ, -_t2));
        dest.put(destOffset + 3, 0.0f);
        dest.put(destOffset + 4, scaleY * 2.0f * Math.fma(rotationX, rotationY, -_t1));
        dest.put(destOffset + 5, scaleY * Math.fma(-2.0f, Math.fma(rotationX, rotationX, _t0), 1.0f));
        dest.put(destOffset + 6, scaleY * 2.0f * Math.fma(rotationX, rotationW, rotationY * rotationZ));
        dest.put(destOffset + 7, 0.0f);
        dest.put(destOffset + 8, scaleZ * 2.0f * Math.fma(rotationX, rotationZ, _t2));
        dest.put(destOffset + 9, scaleZ * 2.0f * Math.fma(rotationY, rotationZ, -(rotationX * rotationW)));
        dest.put(destOffset + 10, scaleZ * Math.fma(-2.0f, Math.fma(rotationX, rotationX, rotationY * rotationY), 1.0f));
        dest.put(destOffset + 11, 0.0f);
        dest.put(destOffset + 12, translationX);
        dest.put(destOffset + 13, translationY);
        dest.put(destOffset + 14, translationZ);
        dest.put(destOffset + 15, 1.0f);
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
        float _translationx = translation.get(translationOffset + 0);
        float _translationy = translation.get(translationOffset + 1);
        float _translationz = translation.get(translationOffset + 2);
        float _rotationx = rotation.get(rotationOffset + 0);
        float _rotationy = rotation.get(rotationOffset + 1);
        float _rotationz = rotation.get(rotationOffset + 2);
        float _rotationw = rotation.get(rotationOffset + 3);
        float _scalex = scale.get(scaleOffset + 0);
        float _scaley = scale.get(scaleOffset + 1);
        float _scalez = scale.get(scaleOffset + 2);
        float _t0 = _rotationz * _rotationz;
        float _t1 = _rotationz * _rotationw;
        float _t2 = _rotationy * _rotationw;
        dest.put(destOffset + 0, _scalex * Math.fma(-2.0f, Math.fma(_rotationy, _rotationy, _t0), 1.0f));
        dest.put(destOffset + 1, _scalex * 2.0f * Math.fma(_rotationx, _rotationy, _t1));
        dest.put(destOffset + 2, _scalex * 2.0f * Math.fma(_rotationx, _rotationz, -_t2));
        dest.put(destOffset + 3, 0.0f);
        dest.put(destOffset + 4, _scaley * 2.0f * Math.fma(_rotationx, _rotationy, -_t1));
        dest.put(destOffset + 5, _scaley * Math.fma(-2.0f, Math.fma(_rotationx, _rotationx, _t0), 1.0f));
        dest.put(destOffset + 6, _scaley * 2.0f * Math.fma(_rotationx, _rotationw, _rotationy * _rotationz));
        dest.put(destOffset + 7, 0.0f);
        dest.put(destOffset + 8, _scalez * 2.0f * Math.fma(_rotationx, _rotationz, _t2));
        dest.put(destOffset + 9, _scalez * 2.0f * Math.fma(_rotationy, _rotationz, -(_rotationx * _rotationw)));
        dest.put(destOffset + 10, _scalez * Math.fma(-2.0f, Math.fma(_rotationx, _rotationx, _rotationy * _rotationy), 1.0f));
        dest.put(destOffset + 11, 0.0f);
        dest.put(destOffset + 12, _translationx);
        dest.put(destOffset + 13, _translationy);
        dest.put(destOffset + 14, _translationz);
        dest.put(destOffset + 15, 1.0f);
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = 2.0f * zNear;
        float _t1 = right - left;
        float _t1_inv = 1.0f / _t1;
        float _t2 = top - bottom;
        float _t2_inv = 1.0f / _t2;
        float _t4 = zNear - zFar;
        float _t4_inv = 1.0f / _t4;
        float _t5 = left + right;
        float _t6 = bottom + top;
        float _t16, _t17;
        if (zFar == Float.POSITIVE_INFINITY) {
            _t16 = 1.0f;
            _t17 = -_t0;
        } else {
            if (zNear == Float.POSITIVE_INFINITY) {
                _t16 = -1.0f;
                _t17 = 2.0f * zFar;
            } else {
                _t16 = -((zFar + zNear) * _t4_inv);
                _t17 = 2.0f * zFar * zNear * _t4_inv;
            }
        }
        dest.put(destOffset + 0, _self00 * _t0 * _t1_inv);
        dest.put(destOffset + 1, _self10 * _t0 * _t1_inv);
        dest.put(destOffset + 2, _self20 * _t0 * _t1_inv);
        dest.put(destOffset + 3, _self30 * _t0 * _t1_inv);
        dest.put(destOffset + 4, _self01 * _t0 * _t2_inv);
        dest.put(destOffset + 5, _self11 * _t0 * _t2_inv);
        dest.put(destOffset + 6, _self21 * _t0 * _t2_inv);
        dest.put(destOffset + 7, _self31 * _t0 * _t2_inv);
        dest.put(destOffset + 8, Math.fma(_self02, _t16, _self03 - _self00 * _t5 * _t1_inv - _self01 * _t6 * _t2_inv));
        dest.put(destOffset + 9, Math.fma(_self12, _t16, _self13 - _self10 * _t5 * _t1_inv - _self11 * _t6 * _t2_inv));
        dest.put(destOffset + 10, Math.fma(_self22, _t16, _self23 - _self20 * _t5 * _t1_inv - _self21 * _t6 * _t2_inv));
        dest.put(destOffset + 11, Math.fma(_self32, _t16, _self33 - _self30 * _t5 * _t1_inv - _self31 * _t6 * _t2_inv));
        dest.put(destOffset + 12, _self02 * _t17);
        dest.put(destOffset + 13, _self12 * _t17);
        dest.put(destOffset + 14, _self22 * _t17);
        dest.put(destOffset + 15, _self32 * _t17);
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = 2.0f * zNear;
        float _t1 = right - left;
        float _t1_inv = 1.0f / _t1;
        float _t2 = top - bottom;
        float _t2_inv = 1.0f / _t2;
        float _t4 = zNear - zFar;
        float _t4_inv = 1.0f / _t4;
        float _t5 = left + right;
        float _t6 = bottom + top;
        float _t14, _t16;
        if (zFar == Float.POSITIVE_INFINITY) {
            _t14 = -1.0f;
            _t16 = -_t0;
        } else {
            if (zNear == Float.POSITIVE_INFINITY) {
                _t14 = 1.0f;
                _t16 = 2.0f * zFar;
            } else {
                _t14 = (zFar + zNear) * _t4_inv;
                _t16 = 2.0f * zFar * zNear * _t4_inv;
            }
        }
        dest.put(destOffset + 0, _self00 * _t0 * _t1_inv);
        dest.put(destOffset + 1, _self10 * _t0 * _t1_inv);
        dest.put(destOffset + 2, _self20 * _t0 * _t1_inv);
        dest.put(destOffset + 3, _self30 * _t0 * _t1_inv);
        dest.put(destOffset + 4, _self01 * _t0 * _t2_inv);
        dest.put(destOffset + 5, _self11 * _t0 * _t2_inv);
        dest.put(destOffset + 6, _self21 * _t0 * _t2_inv);
        dest.put(destOffset + 7, _self31 * _t0 * _t2_inv);
        dest.put(destOffset + 8, Math.fma(_self02, _t14, _self00 * _t5 * _t1_inv + _self01 * _t6 * _t2_inv - _self03));
        dest.put(destOffset + 9, Math.fma(_self12, _t14, _self10 * _t5 * _t1_inv + _self11 * _t6 * _t2_inv - _self13));
        dest.put(destOffset + 10, Math.fma(_self22, _t14, _self20 * _t5 * _t1_inv + _self21 * _t6 * _t2_inv - _self23));
        dest.put(destOffset + 11, Math.fma(_self32, _t14, _self30 * _t5 * _t1_inv + _self31 * _t6 * _t2_inv - _self33));
        dest.put(destOffset + 12, _self02 * _t16);
        dest.put(destOffset + 13, _self12 * _t16);
        dest.put(destOffset + 14, _self22 * _t16);
        dest.put(destOffset + 15, _self32 * _t16);
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = 2.0f * zNear;
        float _t1 = right - left;
        float _t1_inv = 1.0f / _t1;
        float _t2 = top - bottom;
        float _t2_inv = 1.0f / _t2;
        float _t3 = zNear - zFar;
        float _t3_inv = 1.0f / _t3;
        float _t4 = left + right;
        float _t5 = bottom + top;
        float _t12, _t13;
        if (zFar == Float.POSITIVE_INFINITY) {
            _t12 = 1.0f;
            _t13 = -zNear;
        } else {
            if (zNear == Float.POSITIVE_INFINITY) {
                _t12 = 0.0f;
                _t13 = zFar;
            } else {
                _t12 = -(zFar * _t3_inv);
                _t13 = zFar * zNear * _t3_inv;
            }
        }
        dest.put(destOffset + 0, _self00 * _t0 * _t1_inv);
        dest.put(destOffset + 1, _self10 * _t0 * _t1_inv);
        dest.put(destOffset + 2, _self20 * _t0 * _t1_inv);
        dest.put(destOffset + 3, _self30 * _t0 * _t1_inv);
        dest.put(destOffset + 4, _self01 * _t0 * _t2_inv);
        dest.put(destOffset + 5, _self11 * _t0 * _t2_inv);
        dest.put(destOffset + 6, _self21 * _t0 * _t2_inv);
        dest.put(destOffset + 7, _self31 * _t0 * _t2_inv);
        dest.put(destOffset + 8, Math.fma(_self02, _t12, _self03 - _self00 * _t4 * _t1_inv - _self01 * _t5 * _t2_inv));
        dest.put(destOffset + 9, Math.fma(_self12, _t12, _self13 - _self10 * _t4 * _t1_inv - _self11 * _t5 * _t2_inv));
        dest.put(destOffset + 10, Math.fma(_self22, _t12, _self23 - _self20 * _t4 * _t1_inv - _self21 * _t5 * _t2_inv));
        dest.put(destOffset + 11, Math.fma(_self32, _t12, _self33 - _self30 * _t4 * _t1_inv - _self31 * _t5 * _t2_inv));
        dest.put(destOffset + 12, _self02 * _t13);
        dest.put(destOffset + 13, _self12 * _t13);
        dest.put(destOffset + 14, _self22 * _t13);
        dest.put(destOffset + 15, _self32 * _t13);
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = 2.0f * zNear;
        float _t1 = right - left;
        float _t1_inv = 1.0f / _t1;
        float _t2 = top - bottom;
        float _t2_inv = 1.0f / _t2;
        float _t3 = zNear - zFar;
        float _t3_inv = 1.0f / _t3;
        float _t4 = left + right;
        float _t5 = bottom + top;
        float _t11, _t12;
        if (zFar == Float.POSITIVE_INFINITY) {
            _t11 = -1.0f;
            _t12 = -zNear;
        } else {
            if (zNear == Float.POSITIVE_INFINITY) {
                _t11 = 0.0f;
                _t12 = zFar;
            } else {
                _t11 = zFar * _t3_inv;
                _t12 = zFar * zNear * _t3_inv;
            }
        }
        dest.put(destOffset + 0, _self00 * _t0 * _t1_inv);
        dest.put(destOffset + 1, _self10 * _t0 * _t1_inv);
        dest.put(destOffset + 2, _self20 * _t0 * _t1_inv);
        dest.put(destOffset + 3, _self30 * _t0 * _t1_inv);
        dest.put(destOffset + 4, _self01 * _t0 * _t2_inv);
        dest.put(destOffset + 5, _self11 * _t0 * _t2_inv);
        dest.put(destOffset + 6, _self21 * _t0 * _t2_inv);
        dest.put(destOffset + 7, _self31 * _t0 * _t2_inv);
        dest.put(destOffset + 8, Math.fma(_self02, _t11, _self00 * _t4 * _t1_inv + _self01 * _t5 * _t2_inv - _self03));
        dest.put(destOffset + 9, Math.fma(_self12, _t11, _self10 * _t4 * _t1_inv + _self11 * _t5 * _t2_inv - _self13));
        dest.put(destOffset + 10, Math.fma(_self22, _t11, _self20 * _t4 * _t1_inv + _self21 * _t5 * _t2_inv - _self23));
        dest.put(destOffset + 11, Math.fma(_self32, _t11, _self30 * _t4 * _t1_inv + _self31 * _t5 * _t2_inv - _self33));
        dest.put(destOffset + 12, _self02 * _t12);
        dest.put(destOffset + 13, _self12 * _t12);
        dest.put(destOffset + 14, _self22 * _t12);
        dest.put(destOffset + 15, _self32 * _t12);
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t7, _t8, _t9;
        if (_t2 > 0.0f) {
            _t7 = dirY * _t3;
            _t8 = dirX * _t3;
            _t9 = dirZ * _t3;
        } else {
            _t7 = 0.0f;
            _t8 = 0.0f;
            _t9 = 0.0f;
        }
        float _t16 = Math.fma(upX, _t7, -(upY * _t8));
        float _t17 = Math.fma(upY, _t9, -(upZ * _t7));
        float _t18 = Math.fma(upZ, _t8, -(upX * _t9));
        float _t21 = Math.fma(_t16, _t16, Math.fma(_t17, _t17, _t18 * _t18));
        float _t22 = (1.0f / (float) Math.sqrt(_t21));
        float _t26, _t27, _t28;
        if (_t21 > 0.0f) {
            _t26 = _t16 * _t22;
            _t27 = _t17 * _t22;
            _t28 = _t18 * _t22;
        } else {
            _t26 = 0.0f;
            _t27 = 0.0f;
            _t28 = 0.0f;
        }
        float _t35 = Math.fma(_t8, _t28, -(_t7 * _t27));
        float _t36 = Math.fma(_t7, _t26, -(_t9 * _t28));
        float _t37 = Math.fma(_t9, _t27, -(_t8 * _t26));
        dest.put(destOffset + 0, Math.fma(_self02, _t26, Math.fma(_self00, _t27, _self01 * _t28)));
        dest.put(destOffset + 1, Math.fma(_self12, _t26, Math.fma(_self10, _t27, _self11 * _t28)));
        dest.put(destOffset + 2, Math.fma(_self22, _t26, Math.fma(_self20, _t27, _self21 * _t28)));
        dest.put(destOffset + 3, Math.fma(_self32, _t26, Math.fma(_self30, _t27, _self31 * _t28)));
        dest.put(destOffset + 4, Math.fma(_self02, _t35, Math.fma(_self00, _t36, _self01 * _t37)));
        dest.put(destOffset + 5, Math.fma(_self12, _t35, Math.fma(_self10, _t36, _self11 * _t37)));
        dest.put(destOffset + 6, Math.fma(_self22, _t35, Math.fma(_self20, _t36, _self21 * _t37)));
        dest.put(destOffset + 7, Math.fma(_self32, _t35, Math.fma(_self30, _t36, _self31 * _t37)));
        dest.put(destOffset + 8, Math.fma(_self02, _t9, Math.fma(_self00, _t8, _self01 * _t7)));
        dest.put(destOffset + 9, Math.fma(_self12, _t9, Math.fma(_self10, _t8, _self11 * _t7)));
        dest.put(destOffset + 10, Math.fma(_self22, _t9, Math.fma(_self20, _t8, _self21 * _t7)));
        dest.put(destOffset + 11, Math.fma(_self32, _t9, Math.fma(_self30, _t8, _self31 * _t7)));
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _dirx = dir.get(dirOffset + 0);
        float _diry = dir.get(dirOffset + 1);
        float _dirz = dir.get(dirOffset + 2);
        float _upx = up.get(upOffset + 0);
        float _upy = up.get(upOffset + 1);
        float _upz = up.get(upOffset + 2);
        float _t2 = Math.fma(_dirz, _dirz, Math.fma(_dirx, _dirx, _diry * _diry));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t7, _t8, _t9;
        if (_t2 > 0.0f) {
            _t7 = _diry * _t3;
            _t8 = _dirx * _t3;
            _t9 = _dirz * _t3;
        } else {
            _t7 = 0.0f;
            _t8 = 0.0f;
            _t9 = 0.0f;
        }
        float _t16 = Math.fma(_upx, _t7, -(_upy * _t8));
        float _t17 = Math.fma(_upy, _t9, -(_upz * _t7));
        float _t18 = Math.fma(_upz, _t8, -(_upx * _t9));
        float _t21 = Math.fma(_t16, _t16, Math.fma(_t17, _t17, _t18 * _t18));
        float _t22 = (1.0f / (float) Math.sqrt(_t21));
        float _t26, _t27, _t28;
        if (_t21 > 0.0f) {
            _t26 = _t16 * _t22;
            _t27 = _t17 * _t22;
            _t28 = _t18 * _t22;
        } else {
            _t26 = 0.0f;
            _t27 = 0.0f;
            _t28 = 0.0f;
        }
        float _t35 = Math.fma(_t8, _t28, -(_t7 * _t27));
        float _t36 = Math.fma(_t7, _t26, -(_t9 * _t28));
        float _t37 = Math.fma(_t9, _t27, -(_t8 * _t26));
        dest.put(destOffset + 0, Math.fma(_self02, _t26, Math.fma(_self00, _t27, _self01 * _t28)));
        dest.put(destOffset + 1, Math.fma(_self12, _t26, Math.fma(_self10, _t27, _self11 * _t28)));
        dest.put(destOffset + 2, Math.fma(_self22, _t26, Math.fma(_self20, _t27, _self21 * _t28)));
        dest.put(destOffset + 3, Math.fma(_self32, _t26, Math.fma(_self30, _t27, _self31 * _t28)));
        dest.put(destOffset + 4, Math.fma(_self02, _t35, Math.fma(_self00, _t36, _self01 * _t37)));
        dest.put(destOffset + 5, Math.fma(_self12, _t35, Math.fma(_self10, _t36, _self11 * _t37)));
        dest.put(destOffset + 6, Math.fma(_self22, _t35, Math.fma(_self20, _t36, _self21 * _t37)));
        dest.put(destOffset + 7, Math.fma(_self32, _t35, Math.fma(_self30, _t36, _self31 * _t37)));
        dest.put(destOffset + 8, Math.fma(_self02, _t9, Math.fma(_self00, _t8, _self01 * _t7)));
        dest.put(destOffset + 9, Math.fma(_self12, _t9, Math.fma(_self10, _t8, _self11 * _t7)));
        dest.put(destOffset + 10, Math.fma(_self22, _t9, Math.fma(_self20, _t8, _self21 * _t7)));
        dest.put(destOffset + 11, Math.fma(_self32, _t9, Math.fma(_self30, _t8, _self31 * _t7)));
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = centerZ - eyeZ;
        float _t1 = centerX - eyeX;
        float _t2 = centerY - eyeY;
        float _t5 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        float _t6 = (1.0f / (float) Math.sqrt(_t5));
        float _t10, _t11, _t12;
        if (_t5 > 0.0f) {
            _t10 = _t1 * _t6;
            _t11 = _t2 * _t6;
            _t12 = _t0 * _t6;
        } else {
            _t10 = 0.0f;
            _t11 = 0.0f;
            _t12 = 0.0f;
        }
        float _t21 = Math.fma(upX, _t11, -(upY * _t10));
        float _t22 = Math.fma(upY, _t12, -(upZ * _t11));
        float _t23 = Math.fma(upZ, _t10, -(upX * _t12));
        float _t24 = Math.fma(eyeZ, _t12, Math.fma(eyeX, _t10, eyeY * _t11));
        float _t27 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        float _t28 = (1.0f / (float) Math.sqrt(_t27));
        float _t32, _t33, _t34;
        if (_t27 > 0.0f) {
            _t32 = _t22 * _t28;
            _t33 = _t21 * _t28;
            _t34 = _t23 * _t28;
        } else {
            _t32 = 0.0f;
            _t33 = 0.0f;
            _t34 = 0.0f;
        }
        float _t43 = Math.fma(_t11, _t33, -(_t12 * _t34));
        float _t44 = Math.fma(_t12, _t32, -(_t10 * _t33));
        float _t45 = Math.fma(_t10, _t34, -(_t11 * _t32));
        float _t47 = Math.fma(eyeZ, _t33, Math.fma(eyeX, _t32, eyeY * _t34));
        float _t49 = Math.fma(eyeZ, _t45, Math.fma(eyeX, _t43, eyeY * _t44));
        dest.put(destOffset + 0, Math.fma(_self02, _t10, Math.fma(_self00, _t32, _self01 * _t43)));
        dest.put(destOffset + 1, Math.fma(_self12, _t10, Math.fma(_self10, _t32, _self11 * _t43)));
        dest.put(destOffset + 2, Math.fma(_self22, _t10, Math.fma(_self20, _t32, _self21 * _t43)));
        dest.put(destOffset + 3, Math.fma(_self32, _t10, Math.fma(_self30, _t32, _self31 * _t43)));
        dest.put(destOffset + 4, Math.fma(_self02, _t11, Math.fma(_self00, _t34, _self01 * _t44)));
        dest.put(destOffset + 5, Math.fma(_self12, _t11, Math.fma(_self10, _t34, _self11 * _t44)));
        dest.put(destOffset + 6, Math.fma(_self22, _t11, Math.fma(_self20, _t34, _self21 * _t44)));
        dest.put(destOffset + 7, Math.fma(_self32, _t11, Math.fma(_self30, _t34, _self31 * _t44)));
        dest.put(destOffset + 8, Math.fma(_self02, _t12, Math.fma(_self00, _t33, _self01 * _t45)));
        dest.put(destOffset + 9, Math.fma(_self12, _t12, Math.fma(_self10, _t33, _self11 * _t45)));
        dest.put(destOffset + 10, Math.fma(_self22, _t12, Math.fma(_self20, _t33, _self21 * _t45)));
        dest.put(destOffset + 11, Math.fma(_self32, _t12, Math.fma(_self30, _t33, _self31 * _t45)));
        dest.put(destOffset + 12, Math.fma(-_self00, _t47, Math.fma(-_self01, _t49, Math.fma(-_self02, _t24, _self03))));
        dest.put(destOffset + 13, Math.fma(-_self10, _t47, Math.fma(-_self11, _t49, Math.fma(-_self12, _t24, _self13))));
        dest.put(destOffset + 14, Math.fma(-_self20, _t47, Math.fma(-_self21, _t49, Math.fma(-_self22, _t24, _self23))));
        dest.put(destOffset + 15, Math.fma(-_self30, _t47, Math.fma(-_self31, _t49, Math.fma(-_self32, _t24, _self33))));
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = -_self02;
        float _t1 = -_self12;
        float _t2 = -_self22;
        float _t3 = -_self32;
        float _t4 = centerZ - eyeZ;
        float _t5 = centerX - eyeX;
        float _t6 = centerY - eyeY;
        float _t9 = Math.fma(_t4, _t4, Math.fma(_t5, _t5, _t6 * _t6));
        float _t10 = (1.0f / (float) Math.sqrt(_t9));
        float _t14, _t15, _t16;
        if (_t9 > 0.0f) {
            _t14 = _t5 * _t10;
            _t15 = _t6 * _t10;
            _t16 = _t4 * _t10;
        } else {
            _t14 = 0.0f;
            _t15 = 0.0f;
            _t16 = 0.0f;
        }
        float _t25 = Math.fma(upY, _t14, -(upX * _t15));
        float _t26 = Math.fma(upX, _t16, -(upZ * _t14));
        float _t27 = Math.fma(upZ, _t15, -(upY * _t16));
        float _t28 = Math.fma(eyeZ, _t16, Math.fma(eyeX, _t14, eyeY * _t15));
        float _t31 = Math.fma(_t25, _t25, Math.fma(_t26, _t26, _t27 * _t27));
        float _t32 = (1.0f / (float) Math.sqrt(_t31));
        float _t36, _t37, _t38;
        if (_t31 > 0.0f) {
            _t36 = _t27 * _t32;
            _t37 = _t26 * _t32;
            _t38 = _t25 * _t32;
        } else {
            _t36 = 0.0f;
            _t37 = 0.0f;
            _t38 = 0.0f;
        }
        float _t47 = Math.fma(_t16, _t37, -(_t15 * _t38));
        float _t48 = Math.fma(_t14, _t38, -(_t16 * _t36));
        float _t49 = Math.fma(_t15, _t36, -(_t14 * _t37));
        float _t51 = Math.fma(eyeZ, _t38, Math.fma(eyeX, _t36, eyeY * _t37));
        float _t53 = Math.fma(eyeZ, _t49, Math.fma(eyeX, _t47, eyeY * _t48));
        dest.put(destOffset + 0, Math.fma(_t0, _t14, Math.fma(_self00, _t36, _self01 * _t47)));
        dest.put(destOffset + 1, Math.fma(_t1, _t14, Math.fma(_self10, _t36, _self11 * _t47)));
        dest.put(destOffset + 2, Math.fma(_t2, _t14, Math.fma(_self20, _t36, _self21 * _t47)));
        dest.put(destOffset + 3, Math.fma(_t3, _t14, Math.fma(_self30, _t36, _self31 * _t47)));
        dest.put(destOffset + 4, Math.fma(_t0, _t15, Math.fma(_self00, _t37, _self01 * _t48)));
        dest.put(destOffset + 5, Math.fma(_t1, _t15, Math.fma(_self10, _t37, _self11 * _t48)));
        dest.put(destOffset + 6, Math.fma(_t2, _t15, Math.fma(_self20, _t37, _self21 * _t48)));
        dest.put(destOffset + 7, Math.fma(_t3, _t15, Math.fma(_self30, _t37, _self31 * _t48)));
        dest.put(destOffset + 8, Math.fma(_t0, _t16, Math.fma(_self00, _t38, _self01 * _t49)));
        dest.put(destOffset + 9, Math.fma(_t1, _t16, Math.fma(_self10, _t38, _self11 * _t49)));
        dest.put(destOffset + 10, Math.fma(_t2, _t16, Math.fma(_self20, _t38, _self21 * _t49)));
        dest.put(destOffset + 11, Math.fma(_t3, _t16, Math.fma(_self30, _t38, _self31 * _t49)));
        dest.put(destOffset + 12, Math.fma(-_self00, _t51, Math.fma(-_self01, _t53, Math.fma(_self02, _t28, _self03))));
        dest.put(destOffset + 13, Math.fma(-_self10, _t51, Math.fma(-_self11, _t53, Math.fma(_self12, _t28, _self13))));
        dest.put(destOffset + 14, Math.fma(-_self20, _t51, Math.fma(-_self21, _t53, Math.fma(_self22, _t28, _self23))));
        dest.put(destOffset + 15, Math.fma(-_self30, _t51, Math.fma(-_self31, _t53, Math.fma(_self32, _t28, _self33))));
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _eyex = eye.get(eyeOffset + 0);
        float _eyey = eye.get(eyeOffset + 1);
        float _eyez = eye.get(eyeOffset + 2);
        float _centerx = center.get(centerOffset + 0);
        float _centery = center.get(centerOffset + 1);
        float _centerz = center.get(centerOffset + 2);
        float _upx = up.get(upOffset + 0);
        float _upy = up.get(upOffset + 1);
        float _upz = up.get(upOffset + 2);
        float _t0 = _centerz - _eyez;
        float _t1 = _centerx - _eyex;
        float _t2 = _centery - _eyey;
        float _t5 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        float _t6 = (1.0f / (float) Math.sqrt(_t5));
        float _t10, _t11, _t12;
        if (_t5 > 0.0f) {
            _t10 = _t1 * _t6;
            _t11 = _t2 * _t6;
            _t12 = _t0 * _t6;
        } else {
            _t10 = 0.0f;
            _t11 = 0.0f;
            _t12 = 0.0f;
        }
        float _t21 = Math.fma(_upx, _t11, -(_upy * _t10));
        float _t22 = Math.fma(_upy, _t12, -(_upz * _t11));
        float _t23 = Math.fma(_upz, _t10, -(_upx * _t12));
        float _t24 = Math.fma(_eyez, _t12, Math.fma(_eyex, _t10, _eyey * _t11));
        float _t27 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        float _t28 = (1.0f / (float) Math.sqrt(_t27));
        float _t32, _t33, _t34;
        if (_t27 > 0.0f) {
            _t32 = _t22 * _t28;
            _t33 = _t21 * _t28;
            _t34 = _t23 * _t28;
        } else {
            _t32 = 0.0f;
            _t33 = 0.0f;
            _t34 = 0.0f;
        }
        float _t43 = Math.fma(_t11, _t33, -(_t12 * _t34));
        float _t44 = Math.fma(_t12, _t32, -(_t10 * _t33));
        float _t45 = Math.fma(_t10, _t34, -(_t11 * _t32));
        float _t47 = Math.fma(_eyez, _t33, Math.fma(_eyex, _t32, _eyey * _t34));
        float _t49 = Math.fma(_eyez, _t45, Math.fma(_eyex, _t43, _eyey * _t44));
        dest.put(destOffset + 0, Math.fma(_self02, _t10, Math.fma(_self00, _t32, _self01 * _t43)));
        dest.put(destOffset + 1, Math.fma(_self12, _t10, Math.fma(_self10, _t32, _self11 * _t43)));
        dest.put(destOffset + 2, Math.fma(_self22, _t10, Math.fma(_self20, _t32, _self21 * _t43)));
        dest.put(destOffset + 3, Math.fma(_self32, _t10, Math.fma(_self30, _t32, _self31 * _t43)));
        dest.put(destOffset + 4, Math.fma(_self02, _t11, Math.fma(_self00, _t34, _self01 * _t44)));
        dest.put(destOffset + 5, Math.fma(_self12, _t11, Math.fma(_self10, _t34, _self11 * _t44)));
        dest.put(destOffset + 6, Math.fma(_self22, _t11, Math.fma(_self20, _t34, _self21 * _t44)));
        dest.put(destOffset + 7, Math.fma(_self32, _t11, Math.fma(_self30, _t34, _self31 * _t44)));
        dest.put(destOffset + 8, Math.fma(_self02, _t12, Math.fma(_self00, _t33, _self01 * _t45)));
        dest.put(destOffset + 9, Math.fma(_self12, _t12, Math.fma(_self10, _t33, _self11 * _t45)));
        dest.put(destOffset + 10, Math.fma(_self22, _t12, Math.fma(_self20, _t33, _self21 * _t45)));
        dest.put(destOffset + 11, Math.fma(_self32, _t12, Math.fma(_self30, _t33, _self31 * _t45)));
        dest.put(destOffset + 12, Math.fma(-_self00, _t47, Math.fma(-_self01, _t49, Math.fma(-_self02, _t24, _self03))));
        dest.put(destOffset + 13, Math.fma(-_self10, _t47, Math.fma(-_self11, _t49, Math.fma(-_self12, _t24, _self13))));
        dest.put(destOffset + 14, Math.fma(-_self20, _t47, Math.fma(-_self21, _t49, Math.fma(-_self22, _t24, _self23))));
        dest.put(destOffset + 15, Math.fma(-_self30, _t47, Math.fma(-_self31, _t49, Math.fma(-_self32, _t24, _self33))));
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _eyex = eye.get(eyeOffset + 0);
        float _eyey = eye.get(eyeOffset + 1);
        float _eyez = eye.get(eyeOffset + 2);
        float _centerx = center.get(centerOffset + 0);
        float _centery = center.get(centerOffset + 1);
        float _centerz = center.get(centerOffset + 2);
        float _upx = up.get(upOffset + 0);
        float _upy = up.get(upOffset + 1);
        float _upz = up.get(upOffset + 2);
        float _t0 = -_self02;
        float _t1 = -_self12;
        float _t2 = -_self22;
        float _t3 = -_self32;
        float _t4 = _centerz - _eyez;
        float _t5 = _centerx - _eyex;
        float _t6 = _centery - _eyey;
        float _t9 = Math.fma(_t4, _t4, Math.fma(_t5, _t5, _t6 * _t6));
        float _t10 = (1.0f / (float) Math.sqrt(_t9));
        float _t14, _t15, _t16;
        if (_t9 > 0.0f) {
            _t14 = _t5 * _t10;
            _t15 = _t6 * _t10;
            _t16 = _t4 * _t10;
        } else {
            _t14 = 0.0f;
            _t15 = 0.0f;
            _t16 = 0.0f;
        }
        float _t25 = Math.fma(_upy, _t14, -(_upx * _t15));
        float _t26 = Math.fma(_upx, _t16, -(_upz * _t14));
        float _t27 = Math.fma(_upz, _t15, -(_upy * _t16));
        float _t28 = Math.fma(_eyez, _t16, Math.fma(_eyex, _t14, _eyey * _t15));
        float _t31 = Math.fma(_t25, _t25, Math.fma(_t26, _t26, _t27 * _t27));
        float _t32 = (1.0f / (float) Math.sqrt(_t31));
        float _t36, _t37, _t38;
        if (_t31 > 0.0f) {
            _t36 = _t27 * _t32;
            _t37 = _t26 * _t32;
            _t38 = _t25 * _t32;
        } else {
            _t36 = 0.0f;
            _t37 = 0.0f;
            _t38 = 0.0f;
        }
        float _t47 = Math.fma(_t16, _t37, -(_t15 * _t38));
        float _t48 = Math.fma(_t14, _t38, -(_t16 * _t36));
        float _t49 = Math.fma(_t15, _t36, -(_t14 * _t37));
        float _t51 = Math.fma(_eyez, _t38, Math.fma(_eyex, _t36, _eyey * _t37));
        float _t53 = Math.fma(_eyez, _t49, Math.fma(_eyex, _t47, _eyey * _t48));
        dest.put(destOffset + 0, Math.fma(_t0, _t14, Math.fma(_self00, _t36, _self01 * _t47)));
        dest.put(destOffset + 1, Math.fma(_t1, _t14, Math.fma(_self10, _t36, _self11 * _t47)));
        dest.put(destOffset + 2, Math.fma(_t2, _t14, Math.fma(_self20, _t36, _self21 * _t47)));
        dest.put(destOffset + 3, Math.fma(_t3, _t14, Math.fma(_self30, _t36, _self31 * _t47)));
        dest.put(destOffset + 4, Math.fma(_t0, _t15, Math.fma(_self00, _t37, _self01 * _t48)));
        dest.put(destOffset + 5, Math.fma(_t1, _t15, Math.fma(_self10, _t37, _self11 * _t48)));
        dest.put(destOffset + 6, Math.fma(_t2, _t15, Math.fma(_self20, _t37, _self21 * _t48)));
        dest.put(destOffset + 7, Math.fma(_t3, _t15, Math.fma(_self30, _t37, _self31 * _t48)));
        dest.put(destOffset + 8, Math.fma(_t0, _t16, Math.fma(_self00, _t38, _self01 * _t49)));
        dest.put(destOffset + 9, Math.fma(_t1, _t16, Math.fma(_self10, _t38, _self11 * _t49)));
        dest.put(destOffset + 10, Math.fma(_t2, _t16, Math.fma(_self20, _t38, _self21 * _t49)));
        dest.put(destOffset + 11, Math.fma(_t3, _t16, Math.fma(_self30, _t38, _self31 * _t49)));
        dest.put(destOffset + 12, Math.fma(-_self00, _t51, Math.fma(-_self01, _t53, Math.fma(_self02, _t28, _self03))));
        dest.put(destOffset + 13, Math.fma(-_self10, _t51, Math.fma(-_self11, _t53, Math.fma(_self12, _t28, _self13))));
        dest.put(destOffset + 14, Math.fma(-_self20, _t51, Math.fma(-_self21, _t53, Math.fma(_self22, _t28, _self23))));
        dest.put(destOffset + 15, Math.fma(-_self30, _t51, Math.fma(-_self31, _t53, Math.fma(_self32, _t28, _self33))));
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
        for (int _i = 0; _i < 16; _i++) {
            float _eself = src.get(srcOffset + _i);
            dest.put(destOffset + _i, _eself);
        }
        return dest;
    }

    public static java.nio.FloatBuffer mapXYnZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapXYnZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapXYnZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, _self00);
        dest.put(destOffset + 1, _self10);
        dest.put(destOffset + 2, _self20);
        dest.put(destOffset + 3, _self30);
        dest.put(destOffset + 4, _self01);
        dest.put(destOffset + 5, _self11);
        dest.put(destOffset + 6, _self21);
        dest.put(destOffset + 7, _self31);
        dest.put(destOffset + 8, -_self02);
        dest.put(destOffset + 9, -_self12);
        dest.put(destOffset + 10, -_self22);
        dest.put(destOffset + 11, -_self32);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapXZY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapXZY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapXZY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, _self00);
        dest.put(destOffset + 1, _self10);
        dest.put(destOffset + 2, _self20);
        dest.put(destOffset + 3, _self30);
        dest.put(destOffset + 4, _self02);
        dest.put(destOffset + 5, _self12);
        dest.put(destOffset + 6, _self22);
        dest.put(destOffset + 7, _self32);
        dest.put(destOffset + 8, _self01);
        dest.put(destOffset + 9, _self11);
        dest.put(destOffset + 10, _self21);
        dest.put(destOffset + 11, _self31);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapXZnY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapXZnY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapXZnY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, _self00);
        dest.put(destOffset + 1, _self10);
        dest.put(destOffset + 2, _self20);
        dest.put(destOffset + 3, _self30);
        dest.put(destOffset + 4, _self02);
        dest.put(destOffset + 5, _self12);
        dest.put(destOffset + 6, _self22);
        dest.put(destOffset + 7, _self32);
        dest.put(destOffset + 8, -_self01);
        dest.put(destOffset + 9, -_self11);
        dest.put(destOffset + 10, -_self21);
        dest.put(destOffset + 11, -_self31);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapXnYZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapXnYZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapXnYZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, _self00);
        dest.put(destOffset + 1, _self10);
        dest.put(destOffset + 2, _self20);
        dest.put(destOffset + 3, _self30);
        dest.put(destOffset + 4, -_self01);
        dest.put(destOffset + 5, -_self11);
        dest.put(destOffset + 6, -_self21);
        dest.put(destOffset + 7, -_self31);
        dest.put(destOffset + 8, _self02);
        dest.put(destOffset + 9, _self12);
        dest.put(destOffset + 10, _self22);
        dest.put(destOffset + 11, _self32);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapXnYnZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapXnYnZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapXnYnZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, _self00);
        dest.put(destOffset + 1, _self10);
        dest.put(destOffset + 2, _self20);
        dest.put(destOffset + 3, _self30);
        dest.put(destOffset + 4, -_self01);
        dest.put(destOffset + 5, -_self11);
        dest.put(destOffset + 6, -_self21);
        dest.put(destOffset + 7, -_self31);
        dest.put(destOffset + 8, -_self02);
        dest.put(destOffset + 9, -_self12);
        dest.put(destOffset + 10, -_self22);
        dest.put(destOffset + 11, -_self32);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapXnZY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapXnZY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapXnZY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, _self00);
        dest.put(destOffset + 1, _self10);
        dest.put(destOffset + 2, _self20);
        dest.put(destOffset + 3, _self30);
        dest.put(destOffset + 4, -_self02);
        dest.put(destOffset + 5, -_self12);
        dest.put(destOffset + 6, -_self22);
        dest.put(destOffset + 7, -_self32);
        dest.put(destOffset + 8, _self01);
        dest.put(destOffset + 9, _self11);
        dest.put(destOffset + 10, _self21);
        dest.put(destOffset + 11, _self31);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapXnZnY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapXnZnY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapXnZnY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, _self00);
        dest.put(destOffset + 1, _self10);
        dest.put(destOffset + 2, _self20);
        dest.put(destOffset + 3, _self30);
        dest.put(destOffset + 4, -_self02);
        dest.put(destOffset + 5, -_self12);
        dest.put(destOffset + 6, -_self22);
        dest.put(destOffset + 7, -_self32);
        dest.put(destOffset + 8, -_self01);
        dest.put(destOffset + 9, -_self11);
        dest.put(destOffset + 10, -_self21);
        dest.put(destOffset + 11, -_self31);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapYXZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapYXZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapYXZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, _self01);
        dest.put(destOffset + 1, _self11);
        dest.put(destOffset + 2, _self21);
        dest.put(destOffset + 3, _self31);
        dest.put(destOffset + 4, _self00);
        dest.put(destOffset + 5, _self10);
        dest.put(destOffset + 6, _self20);
        dest.put(destOffset + 7, _self30);
        dest.put(destOffset + 8, _self02);
        dest.put(destOffset + 9, _self12);
        dest.put(destOffset + 10, _self22);
        dest.put(destOffset + 11, _self32);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapYXnZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapYXnZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapYXnZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, _self01);
        dest.put(destOffset + 1, _self11);
        dest.put(destOffset + 2, _self21);
        dest.put(destOffset + 3, _self31);
        dest.put(destOffset + 4, _self00);
        dest.put(destOffset + 5, _self10);
        dest.put(destOffset + 6, _self20);
        dest.put(destOffset + 7, _self30);
        dest.put(destOffset + 8, -_self02);
        dest.put(destOffset + 9, -_self12);
        dest.put(destOffset + 10, -_self22);
        dest.put(destOffset + 11, -_self32);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapYZX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapYZX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapYZX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, _self01);
        dest.put(destOffset + 1, _self11);
        dest.put(destOffset + 2, _self21);
        dest.put(destOffset + 3, _self31);
        dest.put(destOffset + 4, _self02);
        dest.put(destOffset + 5, _self12);
        dest.put(destOffset + 6, _self22);
        dest.put(destOffset + 7, _self32);
        dest.put(destOffset + 8, _self00);
        dest.put(destOffset + 9, _self10);
        dest.put(destOffset + 10, _self20);
        dest.put(destOffset + 11, _self30);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapYZnX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapYZnX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapYZnX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, _self01);
        dest.put(destOffset + 1, _self11);
        dest.put(destOffset + 2, _self21);
        dest.put(destOffset + 3, _self31);
        dest.put(destOffset + 4, _self02);
        dest.put(destOffset + 5, _self12);
        dest.put(destOffset + 6, _self22);
        dest.put(destOffset + 7, _self32);
        dest.put(destOffset + 8, -_self00);
        dest.put(destOffset + 9, -_self10);
        dest.put(destOffset + 10, -_self20);
        dest.put(destOffset + 11, -_self30);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapYnXZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapYnXZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapYnXZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, _self01);
        dest.put(destOffset + 1, _self11);
        dest.put(destOffset + 2, _self21);
        dest.put(destOffset + 3, _self31);
        dest.put(destOffset + 4, -_self00);
        dest.put(destOffset + 5, -_self10);
        dest.put(destOffset + 6, -_self20);
        dest.put(destOffset + 7, -_self30);
        dest.put(destOffset + 8, _self02);
        dest.put(destOffset + 9, _self12);
        dest.put(destOffset + 10, _self22);
        dest.put(destOffset + 11, _self32);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapYnXnZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapYnXnZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapYnXnZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, _self01);
        dest.put(destOffset + 1, _self11);
        dest.put(destOffset + 2, _self21);
        dest.put(destOffset + 3, _self31);
        dest.put(destOffset + 4, -_self00);
        dest.put(destOffset + 5, -_self10);
        dest.put(destOffset + 6, -_self20);
        dest.put(destOffset + 7, -_self30);
        dest.put(destOffset + 8, -_self02);
        dest.put(destOffset + 9, -_self12);
        dest.put(destOffset + 10, -_self22);
        dest.put(destOffset + 11, -_self32);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapYnZX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapYnZX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapYnZX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, _self01);
        dest.put(destOffset + 1, _self11);
        dest.put(destOffset + 2, _self21);
        dest.put(destOffset + 3, _self31);
        dest.put(destOffset + 4, -_self02);
        dest.put(destOffset + 5, -_self12);
        dest.put(destOffset + 6, -_self22);
        dest.put(destOffset + 7, -_self32);
        dest.put(destOffset + 8, _self00);
        dest.put(destOffset + 9, _self10);
        dest.put(destOffset + 10, _self20);
        dest.put(destOffset + 11, _self30);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapYnZnX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapYnZnX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapYnZnX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, _self01);
        dest.put(destOffset + 1, _self11);
        dest.put(destOffset + 2, _self21);
        dest.put(destOffset + 3, _self31);
        dest.put(destOffset + 4, -_self02);
        dest.put(destOffset + 5, -_self12);
        dest.put(destOffset + 6, -_self22);
        dest.put(destOffset + 7, -_self32);
        dest.put(destOffset + 8, -_self00);
        dest.put(destOffset + 9, -_self10);
        dest.put(destOffset + 10, -_self20);
        dest.put(destOffset + 11, -_self30);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapZXY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapZXY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapZXY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, _self02);
        dest.put(destOffset + 1, _self12);
        dest.put(destOffset + 2, _self22);
        dest.put(destOffset + 3, _self32);
        dest.put(destOffset + 4, _self00);
        dest.put(destOffset + 5, _self10);
        dest.put(destOffset + 6, _self20);
        dest.put(destOffset + 7, _self30);
        dest.put(destOffset + 8, _self01);
        dest.put(destOffset + 9, _self11);
        dest.put(destOffset + 10, _self21);
        dest.put(destOffset + 11, _self31);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapZXnY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapZXnY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapZXnY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, _self02);
        dest.put(destOffset + 1, _self12);
        dest.put(destOffset + 2, _self22);
        dest.put(destOffset + 3, _self32);
        dest.put(destOffset + 4, _self00);
        dest.put(destOffset + 5, _self10);
        dest.put(destOffset + 6, _self20);
        dest.put(destOffset + 7, _self30);
        dest.put(destOffset + 8, -_self01);
        dest.put(destOffset + 9, -_self11);
        dest.put(destOffset + 10, -_self21);
        dest.put(destOffset + 11, -_self31);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapZYX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapZYX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapZYX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, _self02);
        dest.put(destOffset + 1, _self12);
        dest.put(destOffset + 2, _self22);
        dest.put(destOffset + 3, _self32);
        dest.put(destOffset + 4, _self01);
        dest.put(destOffset + 5, _self11);
        dest.put(destOffset + 6, _self21);
        dest.put(destOffset + 7, _self31);
        dest.put(destOffset + 8, _self00);
        dest.put(destOffset + 9, _self10);
        dest.put(destOffset + 10, _self20);
        dest.put(destOffset + 11, _self30);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapZYnX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapZYnX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapZYnX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, _self02);
        dest.put(destOffset + 1, _self12);
        dest.put(destOffset + 2, _self22);
        dest.put(destOffset + 3, _self32);
        dest.put(destOffset + 4, _self01);
        dest.put(destOffset + 5, _self11);
        dest.put(destOffset + 6, _self21);
        dest.put(destOffset + 7, _self31);
        dest.put(destOffset + 8, -_self00);
        dest.put(destOffset + 9, -_self10);
        dest.put(destOffset + 10, -_self20);
        dest.put(destOffset + 11, -_self30);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapZnXY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapZnXY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapZnXY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, _self02);
        dest.put(destOffset + 1, _self12);
        dest.put(destOffset + 2, _self22);
        dest.put(destOffset + 3, _self32);
        dest.put(destOffset + 4, -_self00);
        dest.put(destOffset + 5, -_self10);
        dest.put(destOffset + 6, -_self20);
        dest.put(destOffset + 7, -_self30);
        dest.put(destOffset + 8, _self01);
        dest.put(destOffset + 9, _self11);
        dest.put(destOffset + 10, _self21);
        dest.put(destOffset + 11, _self31);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapZnXnY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapZnXnY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapZnXnY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, _self02);
        dest.put(destOffset + 1, _self12);
        dest.put(destOffset + 2, _self22);
        dest.put(destOffset + 3, _self32);
        dest.put(destOffset + 4, -_self00);
        dest.put(destOffset + 5, -_self10);
        dest.put(destOffset + 6, -_self20);
        dest.put(destOffset + 7, -_self30);
        dest.put(destOffset + 8, -_self01);
        dest.put(destOffset + 9, -_self11);
        dest.put(destOffset + 10, -_self21);
        dest.put(destOffset + 11, -_self31);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapZnYX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapZnYX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapZnYX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, _self02);
        dest.put(destOffset + 1, _self12);
        dest.put(destOffset + 2, _self22);
        dest.put(destOffset + 3, _self32);
        dest.put(destOffset + 4, -_self01);
        dest.put(destOffset + 5, -_self11);
        dest.put(destOffset + 6, -_self21);
        dest.put(destOffset + 7, -_self31);
        dest.put(destOffset + 8, _self00);
        dest.put(destOffset + 9, _self10);
        dest.put(destOffset + 10, _self20);
        dest.put(destOffset + 11, _self30);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapZnYnX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapZnYnX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapZnYnX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, _self02);
        dest.put(destOffset + 1, _self12);
        dest.put(destOffset + 2, _self22);
        dest.put(destOffset + 3, _self32);
        dest.put(destOffset + 4, -_self01);
        dest.put(destOffset + 5, -_self11);
        dest.put(destOffset + 6, -_self21);
        dest.put(destOffset + 7, -_self31);
        dest.put(destOffset + 8, -_self00);
        dest.put(destOffset + 9, -_self10);
        dest.put(destOffset + 10, -_self20);
        dest.put(destOffset + 11, -_self30);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapnXYZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnXYZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnXYZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, -_self00);
        dest.put(destOffset + 1, -_self10);
        dest.put(destOffset + 2, -_self20);
        dest.put(destOffset + 3, -_self30);
        dest.put(destOffset + 4, _self01);
        dest.put(destOffset + 5, _self11);
        dest.put(destOffset + 6, _self21);
        dest.put(destOffset + 7, _self31);
        dest.put(destOffset + 8, _self02);
        dest.put(destOffset + 9, _self12);
        dest.put(destOffset + 10, _self22);
        dest.put(destOffset + 11, _self32);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapnXYnZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnXYnZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnXYnZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, -_self00);
        dest.put(destOffset + 1, -_self10);
        dest.put(destOffset + 2, -_self20);
        dest.put(destOffset + 3, -_self30);
        dest.put(destOffset + 4, _self01);
        dest.put(destOffset + 5, _self11);
        dest.put(destOffset + 6, _self21);
        dest.put(destOffset + 7, _self31);
        dest.put(destOffset + 8, -_self02);
        dest.put(destOffset + 9, -_self12);
        dest.put(destOffset + 10, -_self22);
        dest.put(destOffset + 11, -_self32);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapnXZY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnXZY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnXZY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, -_self00);
        dest.put(destOffset + 1, -_self10);
        dest.put(destOffset + 2, -_self20);
        dest.put(destOffset + 3, -_self30);
        dest.put(destOffset + 4, _self02);
        dest.put(destOffset + 5, _self12);
        dest.put(destOffset + 6, _self22);
        dest.put(destOffset + 7, _self32);
        dest.put(destOffset + 8, _self01);
        dest.put(destOffset + 9, _self11);
        dest.put(destOffset + 10, _self21);
        dest.put(destOffset + 11, _self31);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapnXZnY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnXZnY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnXZnY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, -_self00);
        dest.put(destOffset + 1, -_self10);
        dest.put(destOffset + 2, -_self20);
        dest.put(destOffset + 3, -_self30);
        dest.put(destOffset + 4, _self02);
        dest.put(destOffset + 5, _self12);
        dest.put(destOffset + 6, _self22);
        dest.put(destOffset + 7, _self32);
        dest.put(destOffset + 8, -_self01);
        dest.put(destOffset + 9, -_self11);
        dest.put(destOffset + 10, -_self21);
        dest.put(destOffset + 11, -_self31);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapnXnYZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnXnYZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnXnYZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, -_self00);
        dest.put(destOffset + 1, -_self10);
        dest.put(destOffset + 2, -_self20);
        dest.put(destOffset + 3, -_self30);
        dest.put(destOffset + 4, -_self01);
        dest.put(destOffset + 5, -_self11);
        dest.put(destOffset + 6, -_self21);
        dest.put(destOffset + 7, -_self31);
        dest.put(destOffset + 8, _self02);
        dest.put(destOffset + 9, _self12);
        dest.put(destOffset + 10, _self22);
        dest.put(destOffset + 11, _self32);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapnXnYnZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnXnYnZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnXnYnZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, -_self00);
        dest.put(destOffset + 1, -_self10);
        dest.put(destOffset + 2, -_self20);
        dest.put(destOffset + 3, -_self30);
        dest.put(destOffset + 4, -_self01);
        dest.put(destOffset + 5, -_self11);
        dest.put(destOffset + 6, -_self21);
        dest.put(destOffset + 7, -_self31);
        dest.put(destOffset + 8, -_self02);
        dest.put(destOffset + 9, -_self12);
        dest.put(destOffset + 10, -_self22);
        dest.put(destOffset + 11, -_self32);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapnXnZY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnXnZY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnXnZY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, -_self00);
        dest.put(destOffset + 1, -_self10);
        dest.put(destOffset + 2, -_self20);
        dest.put(destOffset + 3, -_self30);
        dest.put(destOffset + 4, -_self02);
        dest.put(destOffset + 5, -_self12);
        dest.put(destOffset + 6, -_self22);
        dest.put(destOffset + 7, -_self32);
        dest.put(destOffset + 8, _self01);
        dest.put(destOffset + 9, _self11);
        dest.put(destOffset + 10, _self21);
        dest.put(destOffset + 11, _self31);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapnXnZnY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnXnZnY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnXnZnY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, -_self00);
        dest.put(destOffset + 1, -_self10);
        dest.put(destOffset + 2, -_self20);
        dest.put(destOffset + 3, -_self30);
        dest.put(destOffset + 4, -_self02);
        dest.put(destOffset + 5, -_self12);
        dest.put(destOffset + 6, -_self22);
        dest.put(destOffset + 7, -_self32);
        dest.put(destOffset + 8, -_self01);
        dest.put(destOffset + 9, -_self11);
        dest.put(destOffset + 10, -_self21);
        dest.put(destOffset + 11, -_self31);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapnYXZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnYXZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnYXZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, -_self01);
        dest.put(destOffset + 1, -_self11);
        dest.put(destOffset + 2, -_self21);
        dest.put(destOffset + 3, -_self31);
        dest.put(destOffset + 4, _self00);
        dest.put(destOffset + 5, _self10);
        dest.put(destOffset + 6, _self20);
        dest.put(destOffset + 7, _self30);
        dest.put(destOffset + 8, _self02);
        dest.put(destOffset + 9, _self12);
        dest.put(destOffset + 10, _self22);
        dest.put(destOffset + 11, _self32);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapnYXnZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnYXnZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnYXnZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, -_self01);
        dest.put(destOffset + 1, -_self11);
        dest.put(destOffset + 2, -_self21);
        dest.put(destOffset + 3, -_self31);
        dest.put(destOffset + 4, _self00);
        dest.put(destOffset + 5, _self10);
        dest.put(destOffset + 6, _self20);
        dest.put(destOffset + 7, _self30);
        dest.put(destOffset + 8, -_self02);
        dest.put(destOffset + 9, -_self12);
        dest.put(destOffset + 10, -_self22);
        dest.put(destOffset + 11, -_self32);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapnYZX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnYZX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnYZX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, -_self01);
        dest.put(destOffset + 1, -_self11);
        dest.put(destOffset + 2, -_self21);
        dest.put(destOffset + 3, -_self31);
        dest.put(destOffset + 4, _self02);
        dest.put(destOffset + 5, _self12);
        dest.put(destOffset + 6, _self22);
        dest.put(destOffset + 7, _self32);
        dest.put(destOffset + 8, _self00);
        dest.put(destOffset + 9, _self10);
        dest.put(destOffset + 10, _self20);
        dest.put(destOffset + 11, _self30);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapnYZnX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnYZnX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnYZnX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, -_self01);
        dest.put(destOffset + 1, -_self11);
        dest.put(destOffset + 2, -_self21);
        dest.put(destOffset + 3, -_self31);
        dest.put(destOffset + 4, _self02);
        dest.put(destOffset + 5, _self12);
        dest.put(destOffset + 6, _self22);
        dest.put(destOffset + 7, _self32);
        dest.put(destOffset + 8, -_self00);
        dest.put(destOffset + 9, -_self10);
        dest.put(destOffset + 10, -_self20);
        dest.put(destOffset + 11, -_self30);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapnYnXZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnYnXZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnYnXZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, -_self01);
        dest.put(destOffset + 1, -_self11);
        dest.put(destOffset + 2, -_self21);
        dest.put(destOffset + 3, -_self31);
        dest.put(destOffset + 4, -_self00);
        dest.put(destOffset + 5, -_self10);
        dest.put(destOffset + 6, -_self20);
        dest.put(destOffset + 7, -_self30);
        dest.put(destOffset + 8, _self02);
        dest.put(destOffset + 9, _self12);
        dest.put(destOffset + 10, _self22);
        dest.put(destOffset + 11, _self32);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapnYnXnZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnYnXnZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnYnXnZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, -_self01);
        dest.put(destOffset + 1, -_self11);
        dest.put(destOffset + 2, -_self21);
        dest.put(destOffset + 3, -_self31);
        dest.put(destOffset + 4, -_self00);
        dest.put(destOffset + 5, -_self10);
        dest.put(destOffset + 6, -_self20);
        dest.put(destOffset + 7, -_self30);
        dest.put(destOffset + 8, -_self02);
        dest.put(destOffset + 9, -_self12);
        dest.put(destOffset + 10, -_self22);
        dest.put(destOffset + 11, -_self32);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapnYnZX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnYnZX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnYnZX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, -_self01);
        dest.put(destOffset + 1, -_self11);
        dest.put(destOffset + 2, -_self21);
        dest.put(destOffset + 3, -_self31);
        dest.put(destOffset + 4, -_self02);
        dest.put(destOffset + 5, -_self12);
        dest.put(destOffset + 6, -_self22);
        dest.put(destOffset + 7, -_self32);
        dest.put(destOffset + 8, _self00);
        dest.put(destOffset + 9, _self10);
        dest.put(destOffset + 10, _self20);
        dest.put(destOffset + 11, _self30);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapnYnZnX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnYnZnX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnYnZnX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, -_self01);
        dest.put(destOffset + 1, -_self11);
        dest.put(destOffset + 2, -_self21);
        dest.put(destOffset + 3, -_self31);
        dest.put(destOffset + 4, -_self02);
        dest.put(destOffset + 5, -_self12);
        dest.put(destOffset + 6, -_self22);
        dest.put(destOffset + 7, -_self32);
        dest.put(destOffset + 8, -_self00);
        dest.put(destOffset + 9, -_self10);
        dest.put(destOffset + 10, -_self20);
        dest.put(destOffset + 11, -_self30);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapnZXY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnZXY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnZXY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, -_self02);
        dest.put(destOffset + 1, -_self12);
        dest.put(destOffset + 2, -_self22);
        dest.put(destOffset + 3, -_self32);
        dest.put(destOffset + 4, _self00);
        dest.put(destOffset + 5, _self10);
        dest.put(destOffset + 6, _self20);
        dest.put(destOffset + 7, _self30);
        dest.put(destOffset + 8, _self01);
        dest.put(destOffset + 9, _self11);
        dest.put(destOffset + 10, _self21);
        dest.put(destOffset + 11, _self31);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapnZXnY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnZXnY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnZXnY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, -_self02);
        dest.put(destOffset + 1, -_self12);
        dest.put(destOffset + 2, -_self22);
        dest.put(destOffset + 3, -_self32);
        dest.put(destOffset + 4, _self00);
        dest.put(destOffset + 5, _self10);
        dest.put(destOffset + 6, _self20);
        dest.put(destOffset + 7, _self30);
        dest.put(destOffset + 8, -_self01);
        dest.put(destOffset + 9, -_self11);
        dest.put(destOffset + 10, -_self21);
        dest.put(destOffset + 11, -_self31);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapnZYX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnZYX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnZYX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, -_self02);
        dest.put(destOffset + 1, -_self12);
        dest.put(destOffset + 2, -_self22);
        dest.put(destOffset + 3, -_self32);
        dest.put(destOffset + 4, _self01);
        dest.put(destOffset + 5, _self11);
        dest.put(destOffset + 6, _self21);
        dest.put(destOffset + 7, _self31);
        dest.put(destOffset + 8, _self00);
        dest.put(destOffset + 9, _self10);
        dest.put(destOffset + 10, _self20);
        dest.put(destOffset + 11, _self30);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapnZYnX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnZYnX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnZYnX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, -_self02);
        dest.put(destOffset + 1, -_self12);
        dest.put(destOffset + 2, -_self22);
        dest.put(destOffset + 3, -_self32);
        dest.put(destOffset + 4, _self01);
        dest.put(destOffset + 5, _self11);
        dest.put(destOffset + 6, _self21);
        dest.put(destOffset + 7, _self31);
        dest.put(destOffset + 8, -_self00);
        dest.put(destOffset + 9, -_self10);
        dest.put(destOffset + 10, -_self20);
        dest.put(destOffset + 11, -_self30);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapnZnXY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnZnXY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnZnXY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, -_self02);
        dest.put(destOffset + 1, -_self12);
        dest.put(destOffset + 2, -_self22);
        dest.put(destOffset + 3, -_self32);
        dest.put(destOffset + 4, -_self00);
        dest.put(destOffset + 5, -_self10);
        dest.put(destOffset + 6, -_self20);
        dest.put(destOffset + 7, -_self30);
        dest.put(destOffset + 8, _self01);
        dest.put(destOffset + 9, _self11);
        dest.put(destOffset + 10, _self21);
        dest.put(destOffset + 11, _self31);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapnZnXnY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnZnXnY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnZnXnY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, -_self02);
        dest.put(destOffset + 1, -_self12);
        dest.put(destOffset + 2, -_self22);
        dest.put(destOffset + 3, -_self32);
        dest.put(destOffset + 4, -_self00);
        dest.put(destOffset + 5, -_self10);
        dest.put(destOffset + 6, -_self20);
        dest.put(destOffset + 7, -_self30);
        dest.put(destOffset + 8, -_self01);
        dest.put(destOffset + 9, -_self11);
        dest.put(destOffset + 10, -_self21);
        dest.put(destOffset + 11, -_self31);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapnZnYX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnZnYX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnZnYX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, -_self02);
        dest.put(destOffset + 1, -_self12);
        dest.put(destOffset + 2, -_self22);
        dest.put(destOffset + 3, -_self32);
        dest.put(destOffset + 4, -_self01);
        dest.put(destOffset + 5, -_self11);
        dest.put(destOffset + 6, -_self21);
        dest.put(destOffset + 7, -_self31);
        dest.put(destOffset + 8, _self00);
        dest.put(destOffset + 9, _self10);
        dest.put(destOffset + 10, _self20);
        dest.put(destOffset + 11, _self30);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer mapnZnYnX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.mapnZnYnX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer mapnZnYnX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, -_self02);
        dest.put(destOffset + 1, -_self12);
        dest.put(destOffset + 2, -_self22);
        dest.put(destOffset + 3, -_self32);
        dest.put(destOffset + 4, -_self01);
        dest.put(destOffset + 5, -_self11);
        dest.put(destOffset + 6, -_self21);
        dest.put(destOffset + 7, -_self31);
        dest.put(destOffset + 8, -_self00);
        dest.put(destOffset + 9, -_self10);
        dest.put(destOffset + 10, -_self20);
        dest.put(destOffset + 11, -_self30);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer obliqueCabinet_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.obliqueCabinet_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.FloatBuffer obliqueCabinet_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t2 = 0.5f * (float) Math.cos(angle);
        float _t3 = 0.5f * (float) Math.sin(angle);
        dest.put(destOffset + 0, _self00);
        dest.put(destOffset + 1, _self10);
        dest.put(destOffset + 2, _self20);
        dest.put(destOffset + 3, _self30);
        dest.put(destOffset + 4, _self01);
        dest.put(destOffset + 5, _self11);
        dest.put(destOffset + 6, _self21);
        dest.put(destOffset + 7, _self31);
        dest.put(destOffset + 8, Math.fma(-_self00, _t2, Math.fma(-_self01, _t3, _self02)));
        dest.put(destOffset + 9, Math.fma(-_self10, _t2, Math.fma(-_self11, _t3, _self12)));
        dest.put(destOffset + 10, Math.fma(-_self20, _t2, Math.fma(-_self21, _t3, _self22)));
        dest.put(destOffset + 11, Math.fma(-_self30, _t2, Math.fma(-_self31, _t3, _self32)));
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer obliqueCavalier_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.obliqueCavalier_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.FloatBuffer obliqueCavalier_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        dest.put(destOffset + 0, _self00);
        dest.put(destOffset + 1, _self10);
        dest.put(destOffset + 2, _self20);
        dest.put(destOffset + 3, _self30);
        dest.put(destOffset + 4, _self01);
        dest.put(destOffset + 5, _self11);
        dest.put(destOffset + 6, _self21);
        dest.put(destOffset + 7, _self31);
        dest.put(destOffset + 8, Math.fma(-_self00, _t0, Math.fma(-_self01, _t1, _self02)));
        dest.put(destOffset + 9, Math.fma(-_self10, _t0, Math.fma(-_self11, _t1, _self12)));
        dest.put(destOffset + 10, Math.fma(-_self20, _t0, Math.fma(-_self21, _t1, _self22)));
        dest.put(destOffset + 11, Math.fma(-_self30, _t0, Math.fma(-_self31, _t1, _self32)));
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer obliqueMilitary_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.obliqueMilitary_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.FloatBuffer obliqueMilitary_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        dest.put(destOffset + 0, _self00);
        dest.put(destOffset + 1, _self10);
        dest.put(destOffset + 2, _self20);
        dest.put(destOffset + 3, _self30);
        dest.put(destOffset + 4, Math.fma(_self00, _t0, Math.fma(_self01, _t1, -_self02)));
        dest.put(destOffset + 5, Math.fma(_self10, _t0, Math.fma(_self11, _t1, -_self12)));
        dest.put(destOffset + 6, Math.fma(_self20, _t0, Math.fma(_self21, _t1, -_self22)));
        dest.put(destOffset + 7, Math.fma(_self30, _t0, Math.fma(_self31, _t1, -_self32)));
        dest.put(destOffset + 8, _self01);
        dest.put(destOffset + 9, _self11);
        dest.put(destOffset + 10, _self21);
        dest.put(destOffset + 11, _self31);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer obliqueZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float planeX, float planeY, float planeZ, float planeW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.obliqueZ_unsafe(_destBase, _srcBase, planeX, planeY, planeZ, planeW);
        return dest;
    }

    public static java.nio.FloatBuffer obliqueZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float planeX, float planeY, float planeZ, float planeW) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = 2.0f * _self23;
        float _t15 = Math.fma(planeW, 1.0f + _self22, _self23 * (planeX * (_self02 + (planeX < 0.0f ? -1.0f : planeX > 0.0f ? 1.0f : 0.0f)) / _self00 + planeY * (_self12 + (planeY < 0.0f ? -1.0f : planeY > 0.0f ? 1.0f : 0.0f)) / _self11 - planeZ));
        float _t15_inv = 1.0f / _t15;
        dest.put(destOffset + 0, _self00);
        dest.put(destOffset + 1, _self10);
        dest.put(destOffset + 2, planeX * _t0 * _t15_inv - _self30);
        dest.put(destOffset + 3, _self30);
        dest.put(destOffset + 4, _self01);
        dest.put(destOffset + 5, _self11);
        dest.put(destOffset + 6, planeY * _t0 * _t15_inv - _self31);
        dest.put(destOffset + 7, _self31);
        dest.put(destOffset + 8, _self02);
        dest.put(destOffset + 9, _self12);
        dest.put(destOffset + 10, planeZ * _t0 * _t15_inv - _self32);
        dest.put(destOffset + 11, _self32);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, planeW * _t0 * _t15_inv - _self33);
        dest.put(destOffset + 15, _self33);
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _planex = plane.get(planeOffset + 0);
        float _planey = plane.get(planeOffset + 1);
        float _planez = plane.get(planeOffset + 2);
        float _planew = plane.get(planeOffset + 3);
        float _t0 = 2.0f * _self23;
        float _t15 = Math.fma(_planew, 1.0f + _self22, _self23 * (_planex * (_self02 + (_planex < 0.0f ? -1.0f : _planex > 0.0f ? 1.0f : 0.0f)) / _self00 + _planey * (_self12 + (_planey < 0.0f ? -1.0f : _planey > 0.0f ? 1.0f : 0.0f)) / _self11 - _planez));
        float _t15_inv = 1.0f / _t15;
        dest.put(destOffset + 0, _self00);
        dest.put(destOffset + 1, _self10);
        dest.put(destOffset + 2, _planex * _t0 * _t15_inv - _self30);
        dest.put(destOffset + 3, _self30);
        dest.put(destOffset + 4, _self01);
        dest.put(destOffset + 5, _self11);
        dest.put(destOffset + 6, _planey * _t0 * _t15_inv - _self31);
        dest.put(destOffset + 7, _self31);
        dest.put(destOffset + 8, _self02);
        dest.put(destOffset + 9, _self12);
        dest.put(destOffset + 10, _planez * _t0 * _t15_inv - _self32);
        dest.put(destOffset + 11, _self32);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _planew * _t0 * _t15_inv - _self33);
        dest.put(destOffset + 15, _self33);
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        float _t2 = zFar - zNear;
        float _t2_inv = 1.0f / _t2;
        float _t3 = left + right;
        float _t4 = bottom + top;
        float _t5 = zFar + zNear;
        dest.put(destOffset + 0, 2.0f * _self00 * _t0_inv);
        dest.put(destOffset + 1, 2.0f * _self10 * _t0_inv);
        dest.put(destOffset + 2, 2.0f * _self20 * _t0_inv);
        dest.put(destOffset + 3, 2.0f * _self30 * _t0_inv);
        dest.put(destOffset + 4, 2.0f * _self01 * _t1_inv);
        dest.put(destOffset + 5, 2.0f * _self11 * _t1_inv);
        dest.put(destOffset + 6, 2.0f * _self21 * _t1_inv);
        dest.put(destOffset + 7, 2.0f * _self31 * _t1_inv);
        dest.put(destOffset + 8, 2.0f * _self02 * _t2_inv);
        dest.put(destOffset + 9, 2.0f * _self12 * _t2_inv);
        dest.put(destOffset + 10, 2.0f * _self22 * _t2_inv);
        dest.put(destOffset + 11, 2.0f * _self32 * _t2_inv);
        dest.put(destOffset + 12, _self03 + (-(_self00 * _t3 * _t0_inv) - _self01 * _t4 * _t1_inv - _self02 * _t5 * _t2_inv));
        dest.put(destOffset + 13, _self13 + (-(_self10 * _t3 * _t0_inv) - _self11 * _t4 * _t1_inv - _self12 * _t5 * _t2_inv));
        dest.put(destOffset + 14, _self23 + (-(_self20 * _t3 * _t0_inv) - _self21 * _t4 * _t1_inv - _self22 * _t5 * _t2_inv));
        dest.put(destOffset + 15, _self33 + (-(_self30 * _t3 * _t0_inv) - _self31 * _t4 * _t1_inv - _self32 * _t5 * _t2_inv));
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        float _t2 = zFar - zNear;
        float _t2_inv = 1.0f / _t2;
        float _t3 = left + right;
        float _t4 = bottom + top;
        float _t5 = zFar + zNear;
        dest.put(destOffset + 0, 2.0f * _self00 * _t0_inv);
        dest.put(destOffset + 1, 2.0f * _self10 * _t0_inv);
        dest.put(destOffset + 2, 2.0f * _self20 * _t0_inv);
        dest.put(destOffset + 3, 2.0f * _self30 * _t0_inv);
        dest.put(destOffset + 4, 2.0f * _self01 * _t1_inv);
        dest.put(destOffset + 5, 2.0f * _self11 * _t1_inv);
        dest.put(destOffset + 6, 2.0f * _self21 * _t1_inv);
        dest.put(destOffset + 7, 2.0f * _self31 * _t1_inv);
        dest.put(destOffset + 8, -2.0f * _self02 * _t2_inv);
        dest.put(destOffset + 9, -2.0f * _self12 * _t2_inv);
        dest.put(destOffset + 10, -2.0f * _self22 * _t2_inv);
        dest.put(destOffset + 11, -2.0f * _self32 * _t2_inv);
        dest.put(destOffset + 12, _self03 + (-(_self00 * _t3 * _t0_inv) - _self01 * _t4 * _t1_inv - _self02 * _t5 * _t2_inv));
        dest.put(destOffset + 13, _self13 + (-(_self10 * _t3 * _t0_inv) - _self11 * _t4 * _t1_inv - _self12 * _t5 * _t2_inv));
        dest.put(destOffset + 14, _self23 + (-(_self20 * _t3 * _t0_inv) - _self21 * _t4 * _t1_inv - _self22 * _t5 * _t2_inv));
        dest.put(destOffset + 15, _self33 + (-(_self30 * _t3 * _t0_inv) - _self31 * _t4 * _t1_inv - _self32 * _t5 * _t2_inv));
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        float _t2 = zFar - zNear;
        float _t2_inv = 1.0f / _t2;
        float _t3 = left + right;
        float _t4 = bottom + top;
        dest.put(destOffset + 0, 2.0f * _self00 * _t0_inv);
        dest.put(destOffset + 1, 2.0f * _self10 * _t0_inv);
        dest.put(destOffset + 2, 2.0f * _self20 * _t0_inv);
        dest.put(destOffset + 3, 2.0f * _self30 * _t0_inv);
        dest.put(destOffset + 4, 2.0f * _self01 * _t1_inv);
        dest.put(destOffset + 5, 2.0f * _self11 * _t1_inv);
        dest.put(destOffset + 6, 2.0f * _self21 * _t1_inv);
        dest.put(destOffset + 7, 2.0f * _self31 * _t1_inv);
        dest.put(destOffset + 8, _self02 * _t2_inv);
        dest.put(destOffset + 9, _self12 * _t2_inv);
        dest.put(destOffset + 10, _self22 * _t2_inv);
        dest.put(destOffset + 11, _self32 * _t2_inv);
        dest.put(destOffset + 12, _self03 + (-(_self00 * _t3 * _t0_inv) - _self01 * _t4 * _t1_inv - zNear * _self02 * _t2_inv));
        dest.put(destOffset + 13, _self13 + (-(_self10 * _t3 * _t0_inv) - _self11 * _t4 * _t1_inv - zNear * _self12 * _t2_inv));
        dest.put(destOffset + 14, _self23 + (-(_self20 * _t3 * _t0_inv) - _self21 * _t4 * _t1_inv - zNear * _self22 * _t2_inv));
        dest.put(destOffset + 15, _self33 + (-(_self30 * _t3 * _t0_inv) - _self31 * _t4 * _t1_inv - zNear * _self32 * _t2_inv));
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        float _t2 = zFar - zNear;
        float _t2_inv = 1.0f / _t2;
        float _t3 = left + right;
        float _t4 = bottom + top;
        dest.put(destOffset + 0, 2.0f * _self00 * _t0_inv);
        dest.put(destOffset + 1, 2.0f * _self10 * _t0_inv);
        dest.put(destOffset + 2, 2.0f * _self20 * _t0_inv);
        dest.put(destOffset + 3, 2.0f * _self30 * _t0_inv);
        dest.put(destOffset + 4, 2.0f * _self01 * _t1_inv);
        dest.put(destOffset + 5, 2.0f * _self11 * _t1_inv);
        dest.put(destOffset + 6, 2.0f * _self21 * _t1_inv);
        dest.put(destOffset + 7, 2.0f * _self31 * _t1_inv);
        dest.put(destOffset + 8, -(_self02 * _t2_inv));
        dest.put(destOffset + 9, -(_self12 * _t2_inv));
        dest.put(destOffset + 10, -(_self22 * _t2_inv));
        dest.put(destOffset + 11, -(_self32 * _t2_inv));
        dest.put(destOffset + 12, _self03 + (-(_self00 * _t3 * _t0_inv) - _self01 * _t4 * _t1_inv - zNear * _self02 * _t2_inv));
        dest.put(destOffset + 13, _self13 + (-(_self10 * _t3 * _t0_inv) - _self11 * _t4 * _t1_inv - zNear * _self12 * _t2_inv));
        dest.put(destOffset + 14, _self23 + (-(_self20 * _t3 * _t0_inv) - _self21 * _t4 * _t1_inv - zNear * _self22 * _t2_inv));
        dest.put(destOffset + 15, _self33 + (-(_self30 * _t3 * _t0_inv) - _self31 * _t4 * _t1_inv - zNear * _self32 * _t2_inv));
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        float _t2 = left + right;
        float _t3 = bottom + top;
        dest.put(destOffset + 0, 2.0f * _self00 * _t0_inv);
        dest.put(destOffset + 1, 2.0f * _self10 * _t0_inv);
        dest.put(destOffset + 2, 2.0f * _self20 * _t0_inv);
        dest.put(destOffset + 3, 2.0f * _self30 * _t0_inv);
        dest.put(destOffset + 4, 2.0f * _self01 * _t1_inv);
        dest.put(destOffset + 5, 2.0f * _self11 * _t1_inv);
        dest.put(destOffset + 6, 2.0f * _self21 * _t1_inv);
        dest.put(destOffset + 7, 2.0f * _self31 * _t1_inv);
        dest.put(destOffset + 8, _self02);
        dest.put(destOffset + 9, _self12);
        dest.put(destOffset + 10, _self22);
        dest.put(destOffset + 11, _self32);
        dest.put(destOffset + 12, _self03 + (-(_self00 * _t2 * _t0_inv) - _self01 * _t3 * _t1_inv));
        dest.put(destOffset + 13, _self13 + (-(_self10 * _t2 * _t0_inv) - _self11 * _t3 * _t1_inv));
        dest.put(destOffset + 14, _self23 + (-(_self20 * _t2 * _t0_inv) - _self21 * _t3 * _t1_inv));
        dest.put(destOffset + 15, _self33 + (-(_self30 * _t2 * _t0_inv) - _self31 * _t3 * _t1_inv));
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        float _t2 = left + right;
        float _t3 = bottom + top;
        dest.put(destOffset + 0, 2.0f * _self00 * _t0_inv);
        dest.put(destOffset + 1, 2.0f * _self10 * _t0_inv);
        dest.put(destOffset + 2, 2.0f * _self20 * _t0_inv);
        dest.put(destOffset + 3, 2.0f * _self30 * _t0_inv);
        dest.put(destOffset + 4, 2.0f * _self01 * _t1_inv);
        dest.put(destOffset + 5, 2.0f * _self11 * _t1_inv);
        dest.put(destOffset + 6, 2.0f * _self21 * _t1_inv);
        dest.put(destOffset + 7, 2.0f * _self31 * _t1_inv);
        dest.put(destOffset + 8, -_self02);
        dest.put(destOffset + 9, -_self12);
        dest.put(destOffset + 10, -_self22);
        dest.put(destOffset + 11, -_self32);
        dest.put(destOffset + 12, _self03 + (-(_self00 * _t2 * _t0_inv) - _self01 * _t3 * _t1_inv));
        dest.put(destOffset + 13, _self13 + (-(_self10 * _t2 * _t0_inv) - _self11 * _t3 * _t1_inv));
        dest.put(destOffset + 14, _self23 + (-(_self20 * _t2 * _t0_inv) - _self21 * _t3 * _t1_inv));
        dest.put(destOffset + 15, _self33 + (-(_self30 * _t2 * _t0_inv) - _self31 * _t3 * _t1_inv));
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        float _t2 = left + right;
        float _t3 = bottom + top;
        dest.put(destOffset + 0, 2.0f * _self00 * _t0_inv);
        dest.put(destOffset + 1, 2.0f * _self10 * _t0_inv);
        dest.put(destOffset + 2, 2.0f * _self20 * _t0_inv);
        dest.put(destOffset + 3, 2.0f * _self30 * _t0_inv);
        dest.put(destOffset + 4, 2.0f * _self01 * _t1_inv);
        dest.put(destOffset + 5, 2.0f * _self11 * _t1_inv);
        dest.put(destOffset + 6, 2.0f * _self21 * _t1_inv);
        dest.put(destOffset + 7, 2.0f * _self31 * _t1_inv);
        dest.put(destOffset + 8, 0.5f * _self02);
        dest.put(destOffset + 9, 0.5f * _self12);
        dest.put(destOffset + 10, 0.5f * _self22);
        dest.put(destOffset + 11, 0.5f * _self32);
        dest.put(destOffset + 12, Math.fma(0.5f, _self02, _self03 - _self00 * _t2 * _t0_inv - _self01 * _t3 * _t1_inv));
        dest.put(destOffset + 13, Math.fma(0.5f, _self12, _self13 - _self10 * _t2 * _t0_inv - _self11 * _t3 * _t1_inv));
        dest.put(destOffset + 14, Math.fma(0.5f, _self22, _self23 - _self20 * _t2 * _t0_inv - _self21 * _t3 * _t1_inv));
        dest.put(destOffset + 15, Math.fma(0.5f, _self32, _self33 - _self30 * _t2 * _t0_inv - _self31 * _t3 * _t1_inv));
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        float _t2 = left + right;
        float _t3 = bottom + top;
        dest.put(destOffset + 0, 2.0f * _self00 * _t0_inv);
        dest.put(destOffset + 1, 2.0f * _self10 * _t0_inv);
        dest.put(destOffset + 2, 2.0f * _self20 * _t0_inv);
        dest.put(destOffset + 3, 2.0f * _self30 * _t0_inv);
        dest.put(destOffset + 4, 2.0f * _self01 * _t1_inv);
        dest.put(destOffset + 5, 2.0f * _self11 * _t1_inv);
        dest.put(destOffset + 6, 2.0f * _self21 * _t1_inv);
        dest.put(destOffset + 7, 2.0f * _self31 * _t1_inv);
        dest.put(destOffset + 8, -0.5f * _self02);
        dest.put(destOffset + 9, -0.5f * _self12);
        dest.put(destOffset + 10, -0.5f * _self22);
        dest.put(destOffset + 11, -0.5f * _self32);
        dest.put(destOffset + 12, Math.fma(0.5f, _self02, _self03 - _self00 * _t2 * _t0_inv - _self01 * _t3 * _t1_inv));
        dest.put(destOffset + 13, Math.fma(0.5f, _self12, _self13 - _self10 * _t2 * _t0_inv - _self11 * _t3 * _t1_inv));
        dest.put(destOffset + 14, Math.fma(0.5f, _self22, _self23 - _self20 * _t2 * _t0_inv - _self21 * _t3 * _t1_inv));
        dest.put(destOffset + 15, Math.fma(0.5f, _self32, _self33 - _self30 * _t2 * _t0_inv - _self31 * _t3 * _t1_inv));
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t2 = near - far;
        float _t2_inv = 1.0f / _t2;
        float _t6 = (float) Math.tan(0.5f * fovy);
        float _t6_inv = 1.0f / _t6;
        float _t9 = aspect * _t6;
        float _t9_inv = 1.0f / _t9;
        float _t15, _t16;
        if (far == Float.POSITIVE_INFINITY) {
            _t15 = 1.0f;
            _t16 = -(2.0f * near);
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                _t15 = -1.0f;
                _t16 = 2.0f * far;
            } else {
                _t15 = -((far + near) * _t2_inv);
                _t16 = 2.0f * far * near * _t2_inv;
            }
        }
        dest.put(destOffset + 0, _self00 * _t9_inv);
        dest.put(destOffset + 1, _self10 * _t9_inv);
        dest.put(destOffset + 2, _self20 * _t9_inv);
        dest.put(destOffset + 3, _self30 * _t9_inv);
        dest.put(destOffset + 4, _self01 * _t6_inv);
        dest.put(destOffset + 5, _self11 * _t6_inv);
        dest.put(destOffset + 6, _self21 * _t6_inv);
        dest.put(destOffset + 7, _self31 * _t6_inv);
        dest.put(destOffset + 8, Math.fma(_self02, _t15, _self03));
        dest.put(destOffset + 9, Math.fma(_self12, _t15, _self13));
        dest.put(destOffset + 10, Math.fma(_self22, _t15, _self23));
        dest.put(destOffset + 11, Math.fma(_self32, _t15, _self33));
        dest.put(destOffset + 12, _self02 * _t16);
        dest.put(destOffset + 13, _self12 * _t16);
        dest.put(destOffset + 14, _self22 * _t16);
        dest.put(destOffset + 15, _self32 * _t16);
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t2 = near - far;
        float _t2_inv = 1.0f / _t2;
        float _t6 = (float) Math.tan(0.5f * fovy);
        float _t6_inv = 1.0f / _t6;
        float _t9 = aspect * _t6;
        float _t9_inv = 1.0f / _t9;
        float _t13, _t15;
        if (far == Float.POSITIVE_INFINITY) {
            _t13 = -1.0f;
            _t15 = -(2.0f * near);
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                _t13 = 1.0f;
                _t15 = 2.0f * far;
            } else {
                _t13 = (far + near) * _t2_inv;
                _t15 = 2.0f * far * near * _t2_inv;
            }
        }
        dest.put(destOffset + 0, _self00 * _t9_inv);
        dest.put(destOffset + 1, _self10 * _t9_inv);
        dest.put(destOffset + 2, _self20 * _t9_inv);
        dest.put(destOffset + 3, _self30 * _t9_inv);
        dest.put(destOffset + 4, _self01 * _t6_inv);
        dest.put(destOffset + 5, _self11 * _t6_inv);
        dest.put(destOffset + 6, _self21 * _t6_inv);
        dest.put(destOffset + 7, _self31 * _t6_inv);
        dest.put(destOffset + 8, Math.fma(_self02, _t13, -_self03));
        dest.put(destOffset + 9, Math.fma(_self12, _t13, -_self13));
        dest.put(destOffset + 10, Math.fma(_self22, _t13, -_self23));
        dest.put(destOffset + 11, Math.fma(_self32, _t13, -_self33));
        dest.put(destOffset + 12, _self02 * _t15);
        dest.put(destOffset + 13, _self12 * _t15);
        dest.put(destOffset + 14, _self22 * _t15);
        dest.put(destOffset + 15, _self32 * _t15);
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t1 = near - far;
        float _t1_inv = 1.0f / _t1;
        float _t3 = (float) Math.tan(0.5f * fovy);
        float _t3_inv = 1.0f / _t3;
        float _t5 = aspect * _t3;
        float _t5_inv = 1.0f / _t5;
        float _t10, _t11;
        if (far == Float.POSITIVE_INFINITY) {
            _t10 = 1.0f;
            _t11 = -near;
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                _t10 = 0.0f;
                _t11 = far;
            } else {
                _t10 = -(far * _t1_inv);
                _t11 = far * near * _t1_inv;
            }
        }
        dest.put(destOffset + 0, _self00 * _t5_inv);
        dest.put(destOffset + 1, _self10 * _t5_inv);
        dest.put(destOffset + 2, _self20 * _t5_inv);
        dest.put(destOffset + 3, _self30 * _t5_inv);
        dest.put(destOffset + 4, _self01 * _t3_inv);
        dest.put(destOffset + 5, _self11 * _t3_inv);
        dest.put(destOffset + 6, _self21 * _t3_inv);
        dest.put(destOffset + 7, _self31 * _t3_inv);
        dest.put(destOffset + 8, Math.fma(_self02, _t10, _self03));
        dest.put(destOffset + 9, Math.fma(_self12, _t10, _self13));
        dest.put(destOffset + 10, Math.fma(_self22, _t10, _self23));
        dest.put(destOffset + 11, Math.fma(_self32, _t10, _self33));
        dest.put(destOffset + 12, _self02 * _t11);
        dest.put(destOffset + 13, _self12 * _t11);
        dest.put(destOffset + 14, _self22 * _t11);
        dest.put(destOffset + 15, _self32 * _t11);
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t1 = near - far;
        float _t1_inv = 1.0f / _t1;
        float _t3 = (float) Math.tan(0.5f * fovy);
        float _t3_inv = 1.0f / _t3;
        float _t5 = aspect * _t3;
        float _t5_inv = 1.0f / _t5;
        float _t9, _t10;
        if (far == Float.POSITIVE_INFINITY) {
            _t9 = -1.0f;
            _t10 = -near;
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                _t9 = 0.0f;
                _t10 = far;
            } else {
                _t9 = far * _t1_inv;
                _t10 = far * near * _t1_inv;
            }
        }
        dest.put(destOffset + 0, _self00 * _t5_inv);
        dest.put(destOffset + 1, _self10 * _t5_inv);
        dest.put(destOffset + 2, _self20 * _t5_inv);
        dest.put(destOffset + 3, _self30 * _t5_inv);
        dest.put(destOffset + 4, _self01 * _t3_inv);
        dest.put(destOffset + 5, _self11 * _t3_inv);
        dest.put(destOffset + 6, _self21 * _t3_inv);
        dest.put(destOffset + 7, _self31 * _t3_inv);
        dest.put(destOffset + 8, Math.fma(_self02, _t9, -_self03));
        dest.put(destOffset + 9, Math.fma(_self12, _t9, -_self13));
        dest.put(destOffset + 10, Math.fma(_self22, _t9, -_self23));
        dest.put(destOffset + 11, Math.fma(_self32, _t9, -_self33));
        dest.put(destOffset + 12, _self02 * _t10);
        dest.put(destOffset + 13, _self12 * _t10);
        dest.put(destOffset + 14, _self22 * _t10);
        dest.put(destOffset + 15, _self32 * _t10);
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = (float) Math.tan(angleMax);
        float _t1 = (float) Math.tan(angleMin);
        float _t3 = near - far;
        float _t3_inv = 1.0f / _t3;
        float _t8 = _t0 - _t1;
        float _t8_inv = 1.0f / _t8;
        float _t9 = _t0 + _t1;
        float _t11 = aspect * _t8;
        float _t11_inv = 1.0f / _t11;
        float _t17, _t18;
        if (far == Float.POSITIVE_INFINITY) {
            _t17 = 1.0f;
            _t18 = -(2.0f * near);
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                _t17 = -1.0f;
                _t18 = 2.0f * far;
            } else {
                _t17 = -((far + near) * _t3_inv);
                _t18 = 2.0f * far * near * _t3_inv;
            }
        }
        dest.put(destOffset + 0, 2.0f * _self00 * _t11_inv);
        dest.put(destOffset + 1, 2.0f * _self10 * _t11_inv);
        dest.put(destOffset + 2, 2.0f * _self20 * _t11_inv);
        dest.put(destOffset + 3, 2.0f * _self30 * _t11_inv);
        dest.put(destOffset + 4, 2.0f * _self01 * _t8_inv);
        dest.put(destOffset + 5, 2.0f * _self11 * _t8_inv);
        dest.put(destOffset + 6, 2.0f * _self21 * _t8_inv);
        dest.put(destOffset + 7, 2.0f * _self31 * _t8_inv);
        dest.put(destOffset + 8, Math.fma(_self02, _t17, _self03 - _self01 * _t9 * _t8_inv));
        dest.put(destOffset + 9, Math.fma(_self12, _t17, _self13 - _self11 * _t9 * _t8_inv));
        dest.put(destOffset + 10, Math.fma(_self22, _t17, _self23 - _self21 * _t9 * _t8_inv));
        dest.put(destOffset + 11, Math.fma(_self32, _t17, _self33 - _self31 * _t9 * _t8_inv));
        dest.put(destOffset + 12, _self02 * _t18);
        dest.put(destOffset + 13, _self12 * _t18);
        dest.put(destOffset + 14, _self22 * _t18);
        dest.put(destOffset + 15, _self32 * _t18);
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = (float) Math.tan(angleMax);
        float _t1 = (float) Math.tan(angleMin);
        float _t3 = near - far;
        float _t3_inv = 1.0f / _t3;
        float _t8 = _t0 - _t1;
        float _t8_inv = 1.0f / _t8;
        float _t9 = _t0 + _t1;
        float _t11 = aspect * _t8;
        float _t11_inv = 1.0f / _t11;
        float _t15, _t17;
        if (far == Float.POSITIVE_INFINITY) {
            _t15 = -1.0f;
            _t17 = -(2.0f * near);
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                _t15 = 1.0f;
                _t17 = 2.0f * far;
            } else {
                _t15 = (far + near) * _t3_inv;
                _t17 = 2.0f * far * near * _t3_inv;
            }
        }
        dest.put(destOffset + 0, 2.0f * _self00 * _t11_inv);
        dest.put(destOffset + 1, 2.0f * _self10 * _t11_inv);
        dest.put(destOffset + 2, 2.0f * _self20 * _t11_inv);
        dest.put(destOffset + 3, 2.0f * _self30 * _t11_inv);
        dest.put(destOffset + 4, 2.0f * _self01 * _t8_inv);
        dest.put(destOffset + 5, 2.0f * _self11 * _t8_inv);
        dest.put(destOffset + 6, 2.0f * _self21 * _t8_inv);
        dest.put(destOffset + 7, 2.0f * _self31 * _t8_inv);
        dest.put(destOffset + 8, Math.fma(_self02, _t15, _self01 * _t9 * _t8_inv - _self03));
        dest.put(destOffset + 9, Math.fma(_self12, _t15, _self11 * _t9 * _t8_inv - _self13));
        dest.put(destOffset + 10, Math.fma(_self22, _t15, _self21 * _t9 * _t8_inv - _self23));
        dest.put(destOffset + 11, Math.fma(_self32, _t15, _self31 * _t9 * _t8_inv - _self33));
        dest.put(destOffset + 12, _self02 * _t17);
        dest.put(destOffset + 13, _self12 * _t17);
        dest.put(destOffset + 14, _self22 * _t17);
        dest.put(destOffset + 15, _self32 * _t17);
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = (float) Math.tan(angleMax);
        float _t1 = (float) Math.tan(angleMin);
        float _t2 = near - far;
        float _t2_inv = 1.0f / _t2;
        float _t4 = _t0 - _t1;
        float _t4_inv = 1.0f / _t4;
        float _t6 = _t0 + _t1;
        float _t8 = aspect * _t4;
        float _t8_inv = 1.0f / _t8;
        float _t12, _t13;
        if (far == Float.POSITIVE_INFINITY) {
            _t12 = 1.0f;
            _t13 = -near;
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                _t12 = 0.0f;
                _t13 = far;
            } else {
                _t12 = -(far * _t2_inv);
                _t13 = far * near * _t2_inv;
            }
        }
        dest.put(destOffset + 0, 2.0f * _self00 * _t8_inv);
        dest.put(destOffset + 1, 2.0f * _self10 * _t8_inv);
        dest.put(destOffset + 2, 2.0f * _self20 * _t8_inv);
        dest.put(destOffset + 3, 2.0f * _self30 * _t8_inv);
        dest.put(destOffset + 4, 2.0f * _self01 * _t4_inv);
        dest.put(destOffset + 5, 2.0f * _self11 * _t4_inv);
        dest.put(destOffset + 6, 2.0f * _self21 * _t4_inv);
        dest.put(destOffset + 7, 2.0f * _self31 * _t4_inv);
        dest.put(destOffset + 8, Math.fma(_self02, _t12, _self03 - _self01 * _t6 * _t4_inv));
        dest.put(destOffset + 9, Math.fma(_self12, _t12, _self13 - _self11 * _t6 * _t4_inv));
        dest.put(destOffset + 10, Math.fma(_self22, _t12, _self23 - _self21 * _t6 * _t4_inv));
        dest.put(destOffset + 11, Math.fma(_self32, _t12, _self33 - _self31 * _t6 * _t4_inv));
        dest.put(destOffset + 12, _self02 * _t13);
        dest.put(destOffset + 13, _self12 * _t13);
        dest.put(destOffset + 14, _self22 * _t13);
        dest.put(destOffset + 15, _self32 * _t13);
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = (float) Math.tan(angleMax);
        float _t1 = (float) Math.tan(angleMin);
        float _t2 = near - far;
        float _t2_inv = 1.0f / _t2;
        float _t4 = _t0 - _t1;
        float _t4_inv = 1.0f / _t4;
        float _t6 = _t0 + _t1;
        float _t7 = aspect * _t4;
        float _t7_inv = 1.0f / _t7;
        float _t11, _t12;
        if (far == Float.POSITIVE_INFINITY) {
            _t11 = -1.0f;
            _t12 = -near;
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                _t11 = 0.0f;
                _t12 = far;
            } else {
                _t11 = far * _t2_inv;
                _t12 = far * near * _t2_inv;
            }
        }
        dest.put(destOffset + 0, 2.0f * _self00 * _t7_inv);
        dest.put(destOffset + 1, 2.0f * _self10 * _t7_inv);
        dest.put(destOffset + 2, 2.0f * _self20 * _t7_inv);
        dest.put(destOffset + 3, 2.0f * _self30 * _t7_inv);
        dest.put(destOffset + 4, 2.0f * _self01 * _t4_inv);
        dest.put(destOffset + 5, 2.0f * _self11 * _t4_inv);
        dest.put(destOffset + 6, 2.0f * _self21 * _t4_inv);
        dest.put(destOffset + 7, 2.0f * _self31 * _t4_inv);
        dest.put(destOffset + 8, Math.fma(_self02, _t11, _self01 * _t6 * _t4_inv - _self03));
        dest.put(destOffset + 9, Math.fma(_self12, _t11, _self11 * _t6 * _t4_inv - _self13));
        dest.put(destOffset + 10, Math.fma(_self22, _t11, _self21 * _t6 * _t4_inv - _self23));
        dest.put(destOffset + 11, Math.fma(_self32, _t11, _self31 * _t6 * _t4_inv - _self33));
        dest.put(destOffset + 12, _self02 * _t12);
        dest.put(destOffset + 13, _self12 * _t12);
        dest.put(destOffset + 14, _self22 * _t12);
        dest.put(destOffset + 15, _self32 * _t12);
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = near - far;
        float _t0_inv = 1.0f / _t0;
        if (far == Float.POSITIVE_INFINITY) {
            dest.put(destOffset + 10, 1.0f);
            dest.put(destOffset + 14, -(2.0f * near));
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                dest.put(destOffset + 10, -1.0f);
                dest.put(destOffset + 14, 2.0f * far);
            } else {
                dest.put(destOffset + 10, -((far + near) * _t0_inv));
                dest.put(destOffset + 14, 2.0f * far * near * _t0_inv);
            }
        }
        dest.put(destOffset + 0, _self00);
        dest.put(destOffset + 1, _self10);
        dest.put(destOffset + 2, _self20);
        dest.put(destOffset + 3, _self30);
        dest.put(destOffset + 4, _self01);
        dest.put(destOffset + 5, _self11);
        dest.put(destOffset + 6, _self21);
        dest.put(destOffset + 7, _self31);
        dest.put(destOffset + 8, _self02);
        dest.put(destOffset + 9, _self12);
        dest.put(destOffset + 11, _self32);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 15, _self33);
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = near - far;
        float _t0_inv = 1.0f / _t0;
        if (far == Float.POSITIVE_INFINITY) {
            dest.put(destOffset + 10, -1.0f);
            dest.put(destOffset + 14, -(2.0f * near));
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                dest.put(destOffset + 10, 1.0f);
                dest.put(destOffset + 14, 2.0f * far);
            } else {
                dest.put(destOffset + 10, (far + near) * _t0_inv);
                dest.put(destOffset + 14, 2.0f * far * near * _t0_inv);
            }
        }
        dest.put(destOffset + 0, _self00);
        dest.put(destOffset + 1, _self10);
        dest.put(destOffset + 2, _self20);
        dest.put(destOffset + 3, _self30);
        dest.put(destOffset + 4, _self01);
        dest.put(destOffset + 5, _self11);
        dest.put(destOffset + 6, _self21);
        dest.put(destOffset + 7, _self31);
        dest.put(destOffset + 8, _self02);
        dest.put(destOffset + 9, _self12);
        dest.put(destOffset + 11, _self32);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 15, _self33);
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = near - far;
        float _t0_inv = 1.0f / _t0;
        if (far == Float.POSITIVE_INFINITY) {
            dest.put(destOffset + 10, 1.0f);
            dest.put(destOffset + 14, -near);
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                dest.put(destOffset + 10, 0.0f);
                dest.put(destOffset + 14, far);
            } else {
                dest.put(destOffset + 10, -(far * _t0_inv));
                dest.put(destOffset + 14, far * near * _t0_inv);
            }
        }
        dest.put(destOffset + 0, _self00);
        dest.put(destOffset + 1, _self10);
        dest.put(destOffset + 2, _self20);
        dest.put(destOffset + 3, _self30);
        dest.put(destOffset + 4, _self01);
        dest.put(destOffset + 5, _self11);
        dest.put(destOffset + 6, _self21);
        dest.put(destOffset + 7, _self31);
        dest.put(destOffset + 8, _self02);
        dest.put(destOffset + 9, _self12);
        dest.put(destOffset + 11, _self32);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 15, _self33);
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = near - far;
        float _t0_inv = 1.0f / _t0;
        if (far == Float.POSITIVE_INFINITY) {
            dest.put(destOffset + 10, -1.0f);
            dest.put(destOffset + 14, -near);
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                dest.put(destOffset + 10, 0.0f);
                dest.put(destOffset + 14, far);
            } else {
                dest.put(destOffset + 10, far * _t0_inv);
                dest.put(destOffset + 14, far * near * _t0_inv);
            }
        }
        dest.put(destOffset + 0, _self00);
        dest.put(destOffset + 1, _self10);
        dest.put(destOffset + 2, _self20);
        dest.put(destOffset + 3, _self30);
        dest.put(destOffset + 4, _self01);
        dest.put(destOffset + 5, _self11);
        dest.put(destOffset + 6, _self21);
        dest.put(destOffset + 7, _self31);
        dest.put(destOffset + 8, _self02);
        dest.put(destOffset + 9, _self12);
        dest.put(destOffset + 11, _self32);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 15, _self33);
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = (float) Math.tan(angleRight);
        float _t1 = (float) Math.tan(angleLeft);
        float _t2 = (float) Math.tan(angleUp);
        float _t3 = (float) Math.tan(angleDown);
        float _t5 = near - far;
        float _t5_inv = 1.0f / _t5;
        float _t10 = _t0 - _t1;
        float _t10_inv = 1.0f / _t10;
        float _t11 = _t2 - _t3;
        float _t11_inv = 1.0f / _t11;
        float _t12 = _t1 + _t0;
        float _t13 = _t3 + _t2;
        float _t20, _t21;
        if (far == Float.POSITIVE_INFINITY) {
            _t20 = 1.0f;
            _t21 = -(2.0f * near);
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                _t20 = -1.0f;
                _t21 = 2.0f * far;
            } else {
                _t20 = -((far + near) * _t5_inv);
                _t21 = 2.0f * far * near * _t5_inv;
            }
        }
        dest.put(destOffset + 0, 2.0f * _self00 * _t10_inv);
        dest.put(destOffset + 1, 2.0f * _self10 * _t10_inv);
        dest.put(destOffset + 2, 2.0f * _self20 * _t10_inv);
        dest.put(destOffset + 3, 2.0f * _self30 * _t10_inv);
        dest.put(destOffset + 4, 2.0f * _self01 * _t11_inv);
        dest.put(destOffset + 5, 2.0f * _self11 * _t11_inv);
        dest.put(destOffset + 6, 2.0f * _self21 * _t11_inv);
        dest.put(destOffset + 7, 2.0f * _self31 * _t11_inv);
        dest.put(destOffset + 8, Math.fma(_self02, _t20, _self03 - _self00 * _t12 * _t10_inv - _self01 * _t13 * _t11_inv));
        dest.put(destOffset + 9, Math.fma(_self12, _t20, _self13 - _self10 * _t12 * _t10_inv - _self11 * _t13 * _t11_inv));
        dest.put(destOffset + 10, Math.fma(_self22, _t20, _self23 - _self20 * _t12 * _t10_inv - _self21 * _t13 * _t11_inv));
        dest.put(destOffset + 11, Math.fma(_self32, _t20, _self33 - _self30 * _t12 * _t10_inv - _self31 * _t13 * _t11_inv));
        dest.put(destOffset + 12, _self02 * _t21);
        dest.put(destOffset + 13, _self12 * _t21);
        dest.put(destOffset + 14, _self22 * _t21);
        dest.put(destOffset + 15, _self32 * _t21);
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = (float) Math.tan(angleRight);
        float _t1 = (float) Math.tan(angleLeft);
        float _t2 = (float) Math.tan(angleUp);
        float _t3 = (float) Math.tan(angleDown);
        float _t5 = near - far;
        float _t5_inv = 1.0f / _t5;
        float _t10 = _t0 - _t1;
        float _t10_inv = 1.0f / _t10;
        float _t11 = _t2 - _t3;
        float _t11_inv = 1.0f / _t11;
        float _t12 = _t1 + _t0;
        float _t13 = _t3 + _t2;
        float _t18, _t20;
        if (far == Float.POSITIVE_INFINITY) {
            _t18 = -1.0f;
            _t20 = -(2.0f * near);
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                _t18 = 1.0f;
                _t20 = 2.0f * far;
            } else {
                _t18 = (far + near) * _t5_inv;
                _t20 = 2.0f * far * near * _t5_inv;
            }
        }
        dest.put(destOffset + 0, 2.0f * _self00 * _t10_inv);
        dest.put(destOffset + 1, 2.0f * _self10 * _t10_inv);
        dest.put(destOffset + 2, 2.0f * _self20 * _t10_inv);
        dest.put(destOffset + 3, 2.0f * _self30 * _t10_inv);
        dest.put(destOffset + 4, 2.0f * _self01 * _t11_inv);
        dest.put(destOffset + 5, 2.0f * _self11 * _t11_inv);
        dest.put(destOffset + 6, 2.0f * _self21 * _t11_inv);
        dest.put(destOffset + 7, 2.0f * _self31 * _t11_inv);
        dest.put(destOffset + 8, Math.fma(_self02, _t18, _self00 * _t12 * _t10_inv + _self01 * _t13 * _t11_inv - _self03));
        dest.put(destOffset + 9, Math.fma(_self12, _t18, _self10 * _t12 * _t10_inv + _self11 * _t13 * _t11_inv - _self13));
        dest.put(destOffset + 10, Math.fma(_self22, _t18, _self20 * _t12 * _t10_inv + _self21 * _t13 * _t11_inv - _self23));
        dest.put(destOffset + 11, Math.fma(_self32, _t18, _self30 * _t12 * _t10_inv + _self31 * _t13 * _t11_inv - _self33));
        dest.put(destOffset + 12, _self02 * _t20);
        dest.put(destOffset + 13, _self12 * _t20);
        dest.put(destOffset + 14, _self22 * _t20);
        dest.put(destOffset + 15, _self32 * _t20);
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = (float) Math.tan(angleRight);
        float _t1 = (float) Math.tan(angleLeft);
        float _t2 = (float) Math.tan(angleUp);
        float _t3 = (float) Math.tan(angleDown);
        float _t4 = near - far;
        float _t4_inv = 1.0f / _t4;
        float _t6 = _t0 - _t1;
        float _t6_inv = 1.0f / _t6;
        float _t7 = _t2 - _t3;
        float _t7_inv = 1.0f / _t7;
        float _t9 = _t1 + _t0;
        float _t10 = _t3 + _t2;
        float _t15, _t16;
        if (far == Float.POSITIVE_INFINITY) {
            _t15 = 1.0f;
            _t16 = -near;
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                _t15 = 0.0f;
                _t16 = far;
            } else {
                _t15 = -(far * _t4_inv);
                _t16 = far * near * _t4_inv;
            }
        }
        dest.put(destOffset + 0, 2.0f * _self00 * _t6_inv);
        dest.put(destOffset + 1, 2.0f * _self10 * _t6_inv);
        dest.put(destOffset + 2, 2.0f * _self20 * _t6_inv);
        dest.put(destOffset + 3, 2.0f * _self30 * _t6_inv);
        dest.put(destOffset + 4, 2.0f * _self01 * _t7_inv);
        dest.put(destOffset + 5, 2.0f * _self11 * _t7_inv);
        dest.put(destOffset + 6, 2.0f * _self21 * _t7_inv);
        dest.put(destOffset + 7, 2.0f * _self31 * _t7_inv);
        dest.put(destOffset + 8, Math.fma(_self02, _t15, _self03 - _self00 * _t9 * _t6_inv - _self01 * _t10 * _t7_inv));
        dest.put(destOffset + 9, Math.fma(_self12, _t15, _self13 - _self10 * _t9 * _t6_inv - _self11 * _t10 * _t7_inv));
        dest.put(destOffset + 10, Math.fma(_self22, _t15, _self23 - _self20 * _t9 * _t6_inv - _self21 * _t10 * _t7_inv));
        dest.put(destOffset + 11, Math.fma(_self32, _t15, _self33 - _self30 * _t9 * _t6_inv - _self31 * _t10 * _t7_inv));
        dest.put(destOffset + 12, _self02 * _t16);
        dest.put(destOffset + 13, _self12 * _t16);
        dest.put(destOffset + 14, _self22 * _t16);
        dest.put(destOffset + 15, _self32 * _t16);
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = (float) Math.tan(angleRight);
        float _t1 = (float) Math.tan(angleLeft);
        float _t2 = (float) Math.tan(angleUp);
        float _t3 = (float) Math.tan(angleDown);
        float _t4 = near - far;
        float _t4_inv = 1.0f / _t4;
        float _t6 = _t0 - _t1;
        float _t6_inv = 1.0f / _t6;
        float _t7 = _t2 - _t3;
        float _t7_inv = 1.0f / _t7;
        float _t9 = _t1 + _t0;
        float _t10 = _t3 + _t2;
        float _t14, _t15;
        if (far == Float.POSITIVE_INFINITY) {
            _t14 = -1.0f;
            _t15 = -near;
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                _t14 = 0.0f;
                _t15 = far;
            } else {
                _t14 = far * _t4_inv;
                _t15 = far * near * _t4_inv;
            }
        }
        dest.put(destOffset + 0, 2.0f * _self00 * _t6_inv);
        dest.put(destOffset + 1, 2.0f * _self10 * _t6_inv);
        dest.put(destOffset + 2, 2.0f * _self20 * _t6_inv);
        dest.put(destOffset + 3, 2.0f * _self30 * _t6_inv);
        dest.put(destOffset + 4, 2.0f * _self01 * _t7_inv);
        dest.put(destOffset + 5, 2.0f * _self11 * _t7_inv);
        dest.put(destOffset + 6, 2.0f * _self21 * _t7_inv);
        dest.put(destOffset + 7, 2.0f * _self31 * _t7_inv);
        dest.put(destOffset + 8, Math.fma(_self02, _t14, _self00 * _t9 * _t6_inv + _self01 * _t10 * _t7_inv - _self03));
        dest.put(destOffset + 9, Math.fma(_self12, _t14, _self10 * _t9 * _t6_inv + _self11 * _t10 * _t7_inv - _self13));
        dest.put(destOffset + 10, Math.fma(_self22, _t14, _self20 * _t9 * _t6_inv + _self21 * _t10 * _t7_inv - _self23));
        dest.put(destOffset + 11, Math.fma(_self32, _t14, _self30 * _t9 * _t6_inv + _self31 * _t10 * _t7_inv - _self33));
        dest.put(destOffset + 12, _self02 * _t15);
        dest.put(destOffset + 13, _self12 * _t15);
        dest.put(destOffset + 14, _self22 * _t15);
        dest.put(destOffset + 15, _self32 * _t15);
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _rcp0 = 1.0f / deltaX;
        float _rcp1 = 1.0f / deltaY;
        float _t2 = Math.fma(-2.0f, centerX - vpX, vpW);
        float _t3 = Math.fma(-2.0f, centerY - vpY, vpH);
        dest.put(destOffset + 0, vpW * _self00 * _rcp0);
        dest.put(destOffset + 1, vpW * _self10 * _rcp0);
        dest.put(destOffset + 2, vpW * _self20 * _rcp0);
        dest.put(destOffset + 3, vpW * _self30 * _rcp0);
        dest.put(destOffset + 4, vpH * _self01 * _rcp1);
        dest.put(destOffset + 5, vpH * _self11 * _rcp1);
        dest.put(destOffset + 6, vpH * _self21 * _rcp1);
        dest.put(destOffset + 7, vpH * _self31 * _rcp1);
        dest.put(destOffset + 8, _self02);
        dest.put(destOffset + 9, _self12);
        dest.put(destOffset + 10, _self22);
        dest.put(destOffset + 11, _self32);
        dest.put(destOffset + 12, _self03 + (_self00 * _t2 * _rcp0 + _self01 * _t3 * _rcp1));
        dest.put(destOffset + 13, _self13 + (_self10 * _t2 * _rcp0 + _self11 * _t3 * _rcp1));
        dest.put(destOffset + 14, _self23 + (_self20 * _t2 * _rcp0 + _self21 * _t3 * _rcp1));
        dest.put(destOffset + 15, _self33 + (_self30 * _t2 * _rcp0 + _self31 * _t3 * _rcp1));
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
        for (int _l = 0; _l < 4; _l++) {
            int _lo = _l * 4;
            float _eself0 = src.get(srcOffset + _lo);
            float _eself1 = src.get(srcOffset + _lo + 1);
            float _eself2 = src.get(srcOffset + _lo + 2);
            float _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, _eself0 * vX);
            dest.put(destOffset + _lo + 1, _eself1 * vY);
            dest.put(destOffset + _lo + 2, _eself2 * vZ);
            dest.put(destOffset + _lo + 3, _eself3);
        }
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
        float _vx = v.get(vOffset + 0);
        float _vy = v.get(vOffset + 1);
        float _vz = v.get(vOffset + 2);
        for (int _l = 0; _l < 4; _l++) {
            int _lo = _l * 4;
            float _eself0 = src.get(srcOffset + _lo);
            float _eself1 = src.get(srcOffset + _lo + 1);
            float _eself2 = src.get(srcOffset + _lo + 2);
            float _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, _eself0 * _vx);
            dest.put(destOffset + _lo + 1, _eself1 * _vy);
            dest.put(destOffset + _lo + 2, _eself2 * _vz);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.FloatBuffer preScale_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float s) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.preScale_unsafe(_destBase, _srcBase, s);
        return dest;
    }

    public static java.nio.FloatBuffer preScale_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float s) {
        for (int _l = 0; _l < 4; _l++) {
            int _lo = _l * 4;
            float _eself0 = src.get(srcOffset + _lo);
            float _eself1 = src.get(srcOffset + _lo + 1);
            float _eself2 = src.get(srcOffset + _lo + 2);
            float _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, s * _eself0);
            dest.put(destOffset + _lo + 1, s * _eself1);
            dest.put(destOffset + _lo + 2, s * _eself2);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.FloatBuffer preScaleAround_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float s, float pivotX, float pivotY, float pivotZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.preScaleAround_unsafe(_destBase, _srcBase, s, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.FloatBuffer preScaleAround_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float s, float pivotX, float pivotY, float pivotZ) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = Math.fma(-s, pivotX, pivotX);
        float _t1 = Math.fma(-s, pivotY, pivotY);
        float _t2 = Math.fma(-s, pivotZ, pivotZ);
        dest.put(destOffset + 0, Math.fma(s, _self00, _self30 * _t0));
        dest.put(destOffset + 1, Math.fma(s, _self10, _self30 * _t1));
        dest.put(destOffset + 2, Math.fma(s, _self20, _self30 * _t2));
        dest.put(destOffset + 3, _self30);
        dest.put(destOffset + 4, Math.fma(s, _self01, _self31 * _t0));
        dest.put(destOffset + 5, Math.fma(s, _self11, _self31 * _t1));
        dest.put(destOffset + 6, Math.fma(s, _self21, _self31 * _t2));
        dest.put(destOffset + 7, _self31);
        dest.put(destOffset + 8, Math.fma(s, _self02, _self32 * _t0));
        dest.put(destOffset + 9, Math.fma(s, _self12, _self32 * _t1));
        dest.put(destOffset + 10, Math.fma(s, _self22, _self32 * _t2));
        dest.put(destOffset + 11, _self32);
        dest.put(destOffset + 12, Math.fma(s, _self03, _self33 * _t0));
        dest.put(destOffset + 13, Math.fma(s, _self13, _self33 * _t1));
        dest.put(destOffset + 14, Math.fma(s, _self23, _self33 * _t2));
        dest.put(destOffset + 15, _self33);
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _pivotx = pivot.get(pivotOffset + 0);
        float _pivoty = pivot.get(pivotOffset + 1);
        float _pivotz = pivot.get(pivotOffset + 2);
        float _t0 = Math.fma(-s, _pivotx, _pivotx);
        float _t1 = Math.fma(-s, _pivoty, _pivoty);
        float _t2 = Math.fma(-s, _pivotz, _pivotz);
        dest.put(destOffset + 0, Math.fma(s, _self00, _self30 * _t0));
        dest.put(destOffset + 1, Math.fma(s, _self10, _self30 * _t1));
        dest.put(destOffset + 2, Math.fma(s, _self20, _self30 * _t2));
        dest.put(destOffset + 3, _self30);
        dest.put(destOffset + 4, Math.fma(s, _self01, _self31 * _t0));
        dest.put(destOffset + 5, Math.fma(s, _self11, _self31 * _t1));
        dest.put(destOffset + 6, Math.fma(s, _self21, _self31 * _t2));
        dest.put(destOffset + 7, _self31);
        dest.put(destOffset + 8, Math.fma(s, _self02, _self32 * _t0));
        dest.put(destOffset + 9, Math.fma(s, _self12, _self32 * _t1));
        dest.put(destOffset + 10, Math.fma(s, _self22, _self32 * _t2));
        dest.put(destOffset + 11, _self32);
        dest.put(destOffset + 12, Math.fma(s, _self03, _self33 * _t0));
        dest.put(destOffset + 13, Math.fma(s, _self13, _self33 * _t1));
        dest.put(destOffset + 14, Math.fma(s, _self23, _self33 * _t2));
        dest.put(destOffset + 15, _self33);
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
        for (int _l = 0; _l < 4; _l++) {
            int _lo = _l * 4;
            float _eself0 = src.get(srcOffset + _lo);
            float _eself1 = src.get(srcOffset + _lo + 1);
            float _eself2 = src.get(srcOffset + _lo + 2);
            float _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, Math.fma(_eself3, vX, _eself0));
            dest.put(destOffset + _lo + 1, Math.fma(_eself3, vY, _eself1));
            dest.put(destOffset + _lo + 2, Math.fma(_eself3, vZ, _eself2));
            dest.put(destOffset + _lo + 3, _eself3);
        }
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
        float _vx = v.get(vOffset + 0);
        float _vy = v.get(vOffset + 1);
        float _vz = v.get(vOffset + 2);
        for (int _l = 0; _l < 4; _l++) {
            int _lo = _l * 4;
            float _eself0 = src.get(srcOffset + _lo);
            float _eself1 = src.get(srcOffset + _lo + 1);
            float _eself2 = src.get(srcOffset + _lo + 2);
            float _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, Math.fma(_eself3, _vx, _eself0));
            dest.put(destOffset + _lo + 1, Math.fma(_eself3, _vy, _eself1));
            dest.put(destOffset + _lo + 2, Math.fma(_eself3, _vz, _eself2));
            dest.put(destOffset + _lo + 3, _eself3);
        }
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = -_self02;
        float _t1 = -_self12;
        float _t2 = -_self22;
        float _t3 = -_self32;
        float _t10 = 2.0f * normalX * normalZ;
        float _t11 = 2.0f * normalX * normalY;
        float _t12 = 2.0f * normalY * normalZ;
        float _t13 = Math.fma(-2.0f, normalX * normalX, 1.0f);
        float _t14 = Math.fma(-2.0f, normalY * normalY, 1.0f);
        float _t15 = Math.fma(-2.0f, normalZ * normalZ, 1.0f);
        dest.put(destOffset + 0, Math.fma(_t0, _t10, Math.fma(_self00, _t13, -(_self01 * _t11))));
        dest.put(destOffset + 1, Math.fma(_t1, _t10, Math.fma(_self10, _t13, -(_self11 * _t11))));
        dest.put(destOffset + 2, Math.fma(_t2, _t10, Math.fma(_self20, _t13, -(_self21 * _t11))));
        dest.put(destOffset + 3, Math.fma(_t3, _t10, Math.fma(_self30, _t13, -(_self31 * _t11))));
        dest.put(destOffset + 4, Math.fma(_t0, _t12, Math.fma(_self01, _t14, -(_self00 * _t11))));
        dest.put(destOffset + 5, Math.fma(_t1, _t12, Math.fma(_self11, _t14, -(_self10 * _t11))));
        dest.put(destOffset + 6, Math.fma(_t2, _t12, Math.fma(_self21, _t14, -(_self20 * _t11))));
        dest.put(destOffset + 7, Math.fma(_t3, _t12, Math.fma(_self31, _t14, -(_self30 * _t11))));
        dest.put(destOffset + 8, Math.fma(_self02, _t15, Math.fma(-_self01, _t12, -(_self00 * _t10))));
        dest.put(destOffset + 9, Math.fma(_self12, _t15, Math.fma(-_self11, _t12, -(_self10 * _t10))));
        dest.put(destOffset + 10, Math.fma(_self22, _t15, Math.fma(-_self21, _t12, -(_self20 * _t10))));
        dest.put(destOffset + 11, Math.fma(_self32, _t15, Math.fma(-_self31, _t12, -(_self30 * _t10))));
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _normalx = normal.get(normalOffset + 0);
        float _normaly = normal.get(normalOffset + 1);
        float _normalz = normal.get(normalOffset + 2);
        float _t0 = -_self02;
        float _t1 = -_self12;
        float _t2 = -_self22;
        float _t3 = -_self32;
        float _t10 = 2.0f * _normalx * _normalz;
        float _t11 = 2.0f * _normalx * _normaly;
        float _t12 = 2.0f * _normaly * _normalz;
        float _t13 = Math.fma(-2.0f, _normalx * _normalx, 1.0f);
        float _t14 = Math.fma(-2.0f, _normaly * _normaly, 1.0f);
        float _t15 = Math.fma(-2.0f, _normalz * _normalz, 1.0f);
        dest.put(destOffset + 0, Math.fma(_t0, _t10, Math.fma(_self00, _t13, -(_self01 * _t11))));
        dest.put(destOffset + 1, Math.fma(_t1, _t10, Math.fma(_self10, _t13, -(_self11 * _t11))));
        dest.put(destOffset + 2, Math.fma(_t2, _t10, Math.fma(_self20, _t13, -(_self21 * _t11))));
        dest.put(destOffset + 3, Math.fma(_t3, _t10, Math.fma(_self30, _t13, -(_self31 * _t11))));
        dest.put(destOffset + 4, Math.fma(_t0, _t12, Math.fma(_self01, _t14, -(_self00 * _t11))));
        dest.put(destOffset + 5, Math.fma(_t1, _t12, Math.fma(_self11, _t14, -(_self10 * _t11))));
        dest.put(destOffset + 6, Math.fma(_t2, _t12, Math.fma(_self21, _t14, -(_self20 * _t11))));
        dest.put(destOffset + 7, Math.fma(_t3, _t12, Math.fma(_self31, _t14, -(_self30 * _t11))));
        dest.put(destOffset + 8, Math.fma(_self02, _t15, Math.fma(-_self01, _t12, -(_self00 * _t10))));
        dest.put(destOffset + 9, Math.fma(_self12, _t15, Math.fma(-_self11, _t12, -(_self10 * _t10))));
        dest.put(destOffset + 10, Math.fma(_self22, _t15, Math.fma(-_self21, _t12, -(_self20 * _t10))));
        dest.put(destOffset + 11, Math.fma(_self32, _t15, Math.fma(-_self31, _t12, -(_self30 * _t10))));
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer rotateAround_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float rotX, float rotY, float rotZ, float rotW, float pivotX, float pivotY, float pivotZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.rotateAround_unsafe(_destBase, _srcBase, rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.FloatBuffer rotateAround_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float rotX, float rotY, float rotZ, float rotW, float pivotX, float pivotY, float pivotZ) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = -pivotX;
        float _t1 = -pivotY;
        float _t2 = -pivotZ;
        float _t3 = rotY * rotW;
        float _t4 = rotZ * rotZ;
        float _t5 = rotZ * rotW;
        float _t21 = 2.0f * Math.fma(rotX, rotY, _t5);
        float _t22 = 2.0f * Math.fma(rotX, rotW, rotY * rotZ);
        float _t23 = 2.0f * Math.fma(rotX, rotZ, _t3);
        float _t24 = 2.0f * Math.fma(rotX, rotZ, -_t3);
        float _t25 = 2.0f * Math.fma(rotX, rotY, -_t5);
        float _t26 = 2.0f * Math.fma(rotY, rotZ, -(rotX * rotW));
        float _t27 = Math.fma(-2.0f, Math.fma(rotY, rotY, _t4), 1.0f);
        float _t28 = Math.fma(-2.0f, Math.fma(rotX, rotX, _t4), 1.0f);
        float _t29 = Math.fma(-2.0f, Math.fma(rotX, rotX, rotY * rotY), 1.0f);
        float _t36 = Math.fma(_t0, _t27, Math.fma(_t1, _t25, Math.fma(_t2, _t23, pivotX)));
        float _t37 = Math.fma(_t0, _t21, Math.fma(_t1, _t28, Math.fma(_t2, _t26, pivotY)));
        float _t38 = Math.fma(_t0, _t24, Math.fma(_t1, _t22, Math.fma(_t2, _t29, pivotZ)));
        dest.put(destOffset + 0, Math.fma(_self02, _t24, Math.fma(_self00, _t27, _self01 * _t21)));
        dest.put(destOffset + 1, Math.fma(_self12, _t24, Math.fma(_self10, _t27, _self11 * _t21)));
        dest.put(destOffset + 2, Math.fma(_self22, _t24, Math.fma(_self20, _t27, _self21 * _t21)));
        dest.put(destOffset + 3, Math.fma(_self32, _t24, Math.fma(_self30, _t27, _self31 * _t21)));
        dest.put(destOffset + 4, Math.fma(_self02, _t22, Math.fma(_self00, _t25, _self01 * _t28)));
        dest.put(destOffset + 5, Math.fma(_self12, _t22, Math.fma(_self10, _t25, _self11 * _t28)));
        dest.put(destOffset + 6, Math.fma(_self22, _t22, Math.fma(_self20, _t25, _self21 * _t28)));
        dest.put(destOffset + 7, Math.fma(_self32, _t22, Math.fma(_self30, _t25, _self31 * _t28)));
        dest.put(destOffset + 8, Math.fma(_self02, _t29, Math.fma(_self00, _t23, _self01 * _t26)));
        dest.put(destOffset + 9, Math.fma(_self12, _t29, Math.fma(_self10, _t23, _self11 * _t26)));
        dest.put(destOffset + 10, Math.fma(_self22, _t29, Math.fma(_self20, _t23, _self21 * _t26)));
        dest.put(destOffset + 11, Math.fma(_self32, _t29, Math.fma(_self30, _t23, _self31 * _t26)));
        dest.put(destOffset + 12, Math.fma(_self00, _t36, Math.fma(_self01, _t37, Math.fma(_self02, _t38, _self03))));
        dest.put(destOffset + 13, Math.fma(_self10, _t36, Math.fma(_self11, _t37, Math.fma(_self12, _t38, _self13))));
        dest.put(destOffset + 14, Math.fma(_self20, _t36, Math.fma(_self21, _t37, Math.fma(_self22, _t38, _self23))));
        dest.put(destOffset + 15, Math.fma(_self30, _t36, Math.fma(_self31, _t37, Math.fma(_self32, _t38, _self33))));
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _rotx = rot.get(rotOffset + 0);
        float _roty = rot.get(rotOffset + 1);
        float _rotz = rot.get(rotOffset + 2);
        float _rotw = rot.get(rotOffset + 3);
        float _pivotx = pivot.get(pivotOffset + 0);
        float _pivoty = pivot.get(pivotOffset + 1);
        float _pivotz = pivot.get(pivotOffset + 2);
        float _t0 = -_pivotx;
        float _t1 = -_pivoty;
        float _t2 = -_pivotz;
        float _t3 = _roty * _rotw;
        float _t4 = _rotz * _rotz;
        float _t5 = _rotz * _rotw;
        float _t21 = 2.0f * Math.fma(_rotx, _roty, _t5);
        float _t22 = 2.0f * Math.fma(_rotx, _rotw, _roty * _rotz);
        float _t23 = 2.0f * Math.fma(_rotx, _rotz, _t3);
        float _t24 = 2.0f * Math.fma(_rotx, _rotz, -_t3);
        float _t25 = 2.0f * Math.fma(_rotx, _roty, -_t5);
        float _t26 = 2.0f * Math.fma(_roty, _rotz, -(_rotx * _rotw));
        float _t27 = Math.fma(-2.0f, Math.fma(_roty, _roty, _t4), 1.0f);
        float _t28 = Math.fma(-2.0f, Math.fma(_rotx, _rotx, _t4), 1.0f);
        float _t29 = Math.fma(-2.0f, Math.fma(_rotx, _rotx, _roty * _roty), 1.0f);
        float _t36 = Math.fma(_t0, _t27, Math.fma(_t1, _t25, Math.fma(_t2, _t23, _pivotx)));
        float _t37 = Math.fma(_t0, _t21, Math.fma(_t1, _t28, Math.fma(_t2, _t26, _pivoty)));
        float _t38 = Math.fma(_t0, _t24, Math.fma(_t1, _t22, Math.fma(_t2, _t29, _pivotz)));
        dest.put(destOffset + 0, Math.fma(_self02, _t24, Math.fma(_self00, _t27, _self01 * _t21)));
        dest.put(destOffset + 1, Math.fma(_self12, _t24, Math.fma(_self10, _t27, _self11 * _t21)));
        dest.put(destOffset + 2, Math.fma(_self22, _t24, Math.fma(_self20, _t27, _self21 * _t21)));
        dest.put(destOffset + 3, Math.fma(_self32, _t24, Math.fma(_self30, _t27, _self31 * _t21)));
        dest.put(destOffset + 4, Math.fma(_self02, _t22, Math.fma(_self00, _t25, _self01 * _t28)));
        dest.put(destOffset + 5, Math.fma(_self12, _t22, Math.fma(_self10, _t25, _self11 * _t28)));
        dest.put(destOffset + 6, Math.fma(_self22, _t22, Math.fma(_self20, _t25, _self21 * _t28)));
        dest.put(destOffset + 7, Math.fma(_self32, _t22, Math.fma(_self30, _t25, _self31 * _t28)));
        dest.put(destOffset + 8, Math.fma(_self02, _t29, Math.fma(_self00, _t23, _self01 * _t26)));
        dest.put(destOffset + 9, Math.fma(_self12, _t29, Math.fma(_self10, _t23, _self11 * _t26)));
        dest.put(destOffset + 10, Math.fma(_self22, _t29, Math.fma(_self20, _t23, _self21 * _t26)));
        dest.put(destOffset + 11, Math.fma(_self32, _t29, Math.fma(_self30, _t23, _self31 * _t26)));
        dest.put(destOffset + 12, Math.fma(_self00, _t36, Math.fma(_self01, _t37, Math.fma(_self02, _t38, _self03))));
        dest.put(destOffset + 13, Math.fma(_self10, _t36, Math.fma(_self11, _t37, Math.fma(_self12, _t38, _self13))));
        dest.put(destOffset + 14, Math.fma(_self20, _t36, Math.fma(_self21, _t37, Math.fma(_self22, _t38, _self23))));
        dest.put(destOffset + 15, Math.fma(_self30, _t36, Math.fma(_self31, _t37, Math.fma(_self32, _t38, _self33))));
        return dest;
    }

    public static java.nio.FloatBuffer rotateAxis_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle, float axisX, float axisY, float axisZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.rotateAxis_unsafe(_destBase, _srcBase, angle, axisX, axisY, axisZ);
        return dest;
    }

    public static java.nio.FloatBuffer rotateAxis_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle, float axisX, float axisY, float axisZ) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = 1.0f - _t0;
        float _t3 = axisX * axisZ;
        float _t6 = axisX * axisY;
        float _t7 = axisY * axisZ;
        float _t18 = Math.fma(_t2, axisX * axisX, _t0);
        float _t19 = Math.fma(_t2, axisY * axisY, _t0);
        float _t20 = Math.fma(_t2, axisZ * axisZ, _t0);
        float _t21 = Math.fma(axisZ, _t1, _t2 * _t6);
        float _t22 = Math.fma(axisX, _t1, _t2 * _t7);
        float _t23 = Math.fma(axisY, _t1, _t2 * _t3);
        float _t24 = Math.fma(_t2, _t3, -(axisY * _t1));
        float _t25 = Math.fma(_t2, _t6, -(axisZ * _t1));
        float _t26 = Math.fma(_t2, _t7, -(axisX * _t1));
        dest.put(destOffset + 0, Math.fma(_self02, _t24, Math.fma(_self00, _t18, _self01 * _t21)));
        dest.put(destOffset + 1, Math.fma(_self12, _t24, Math.fma(_self10, _t18, _self11 * _t21)));
        dest.put(destOffset + 2, Math.fma(_self22, _t24, Math.fma(_self20, _t18, _self21 * _t21)));
        dest.put(destOffset + 3, Math.fma(_self32, _t24, Math.fma(_self30, _t18, _self31 * _t21)));
        dest.put(destOffset + 4, Math.fma(_self02, _t22, Math.fma(_self00, _t25, _self01 * _t19)));
        dest.put(destOffset + 5, Math.fma(_self12, _t22, Math.fma(_self10, _t25, _self11 * _t19)));
        dest.put(destOffset + 6, Math.fma(_self22, _t22, Math.fma(_self20, _t25, _self21 * _t19)));
        dest.put(destOffset + 7, Math.fma(_self32, _t22, Math.fma(_self30, _t25, _self31 * _t19)));
        dest.put(destOffset + 8, Math.fma(_self02, _t20, Math.fma(_self00, _t23, _self01 * _t26)));
        dest.put(destOffset + 9, Math.fma(_self12, _t20, Math.fma(_self10, _t23, _self11 * _t26)));
        dest.put(destOffset + 10, Math.fma(_self22, _t20, Math.fma(_self20, _t23, _self21 * _t26)));
        dest.put(destOffset + 11, Math.fma(_self32, _t20, Math.fma(_self30, _t23, _self31 * _t26)));
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _axisx = axis.get(axisOffset + 0);
        float _axisy = axis.get(axisOffset + 1);
        float _axisz = axis.get(axisOffset + 2);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = 1.0f - _t0;
        float _t3 = _axisx * _axisz;
        float _t6 = _axisx * _axisy;
        float _t7 = _axisy * _axisz;
        float _t18 = Math.fma(_t2, _axisx * _axisx, _t0);
        float _t19 = Math.fma(_t2, _axisy * _axisy, _t0);
        float _t20 = Math.fma(_t2, _axisz * _axisz, _t0);
        float _t21 = Math.fma(_axisz, _t1, _t2 * _t6);
        float _t22 = Math.fma(_axisx, _t1, _t2 * _t7);
        float _t23 = Math.fma(_axisy, _t1, _t2 * _t3);
        float _t24 = Math.fma(_t2, _t3, -(_axisy * _t1));
        float _t25 = Math.fma(_t2, _t6, -(_axisz * _t1));
        float _t26 = Math.fma(_t2, _t7, -(_axisx * _t1));
        dest.put(destOffset + 0, Math.fma(_self02, _t24, Math.fma(_self00, _t18, _self01 * _t21)));
        dest.put(destOffset + 1, Math.fma(_self12, _t24, Math.fma(_self10, _t18, _self11 * _t21)));
        dest.put(destOffset + 2, Math.fma(_self22, _t24, Math.fma(_self20, _t18, _self21 * _t21)));
        dest.put(destOffset + 3, Math.fma(_self32, _t24, Math.fma(_self30, _t18, _self31 * _t21)));
        dest.put(destOffset + 4, Math.fma(_self02, _t22, Math.fma(_self00, _t25, _self01 * _t19)));
        dest.put(destOffset + 5, Math.fma(_self12, _t22, Math.fma(_self10, _t25, _self11 * _t19)));
        dest.put(destOffset + 6, Math.fma(_self22, _t22, Math.fma(_self20, _t25, _self21 * _t19)));
        dest.put(destOffset + 7, Math.fma(_self32, _t22, Math.fma(_self30, _t25, _self31 * _t19)));
        dest.put(destOffset + 8, Math.fma(_self02, _t20, Math.fma(_self00, _t23, _self01 * _t26)));
        dest.put(destOffset + 9, Math.fma(_self12, _t20, Math.fma(_self10, _t23, _self11 * _t26)));
        dest.put(destOffset + 10, Math.fma(_self22, _t20, Math.fma(_self20, _t23, _self21 * _t26)));
        dest.put(destOffset + 11, Math.fma(_self32, _t20, Math.fma(_self30, _t23, _self31 * _t26)));
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer rotateQuat_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float qX, float qY, float qZ, float qW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.rotateQuat_unsafe(_destBase, _srcBase, qX, qY, qZ, qW);
        return dest;
    }

    public static java.nio.FloatBuffer rotateQuat_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float qX, float qY, float qZ, float qW) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = qY * qW;
        float _t1 = qZ * qZ;
        float _t2 = qZ * qW;
        float _t18 = 2.0f * Math.fma(qX, qY, _t2);
        float _t19 = 2.0f * Math.fma(qX, qW, qY * qZ);
        float _t20 = 2.0f * Math.fma(qX, qZ, _t0);
        float _t21 = 2.0f * Math.fma(qX, qZ, -_t0);
        float _t22 = 2.0f * Math.fma(qX, qY, -_t2);
        float _t23 = 2.0f * Math.fma(qY, qZ, -(qX * qW));
        float _t24 = Math.fma(-2.0f, Math.fma(qY, qY, _t1), 1.0f);
        float _t25 = Math.fma(-2.0f, Math.fma(qX, qX, _t1), 1.0f);
        float _t26 = Math.fma(-2.0f, Math.fma(qX, qX, qY * qY), 1.0f);
        dest.put(destOffset + 0, Math.fma(_self02, _t21, Math.fma(_self00, _t24, _self01 * _t18)));
        dest.put(destOffset + 1, Math.fma(_self12, _t21, Math.fma(_self10, _t24, _self11 * _t18)));
        dest.put(destOffset + 2, Math.fma(_self22, _t21, Math.fma(_self20, _t24, _self21 * _t18)));
        dest.put(destOffset + 3, Math.fma(_self32, _t21, Math.fma(_self30, _t24, _self31 * _t18)));
        dest.put(destOffset + 4, Math.fma(_self02, _t19, Math.fma(_self00, _t22, _self01 * _t25)));
        dest.put(destOffset + 5, Math.fma(_self12, _t19, Math.fma(_self10, _t22, _self11 * _t25)));
        dest.put(destOffset + 6, Math.fma(_self22, _t19, Math.fma(_self20, _t22, _self21 * _t25)));
        dest.put(destOffset + 7, Math.fma(_self32, _t19, Math.fma(_self30, _t22, _self31 * _t25)));
        dest.put(destOffset + 8, Math.fma(_self02, _t26, Math.fma(_self00, _t20, _self01 * _t23)));
        dest.put(destOffset + 9, Math.fma(_self12, _t26, Math.fma(_self10, _t20, _self11 * _t23)));
        dest.put(destOffset + 10, Math.fma(_self22, _t26, Math.fma(_self20, _t20, _self21 * _t23)));
        dest.put(destOffset + 11, Math.fma(_self32, _t26, Math.fma(_self30, _t20, _self31 * _t23)));
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _qx = q.get(qOffset + 0);
        float _qy = q.get(qOffset + 1);
        float _qz = q.get(qOffset + 2);
        float _qw = q.get(qOffset + 3);
        float _t0 = _qy * _qw;
        float _t1 = _qz * _qz;
        float _t2 = _qz * _qw;
        float _t18 = 2.0f * Math.fma(_qx, _qy, _t2);
        float _t19 = 2.0f * Math.fma(_qx, _qw, _qy * _qz);
        float _t20 = 2.0f * Math.fma(_qx, _qz, _t0);
        float _t21 = 2.0f * Math.fma(_qx, _qz, -_t0);
        float _t22 = 2.0f * Math.fma(_qx, _qy, -_t2);
        float _t23 = 2.0f * Math.fma(_qy, _qz, -(_qx * _qw));
        float _t24 = Math.fma(-2.0f, Math.fma(_qy, _qy, _t1), 1.0f);
        float _t25 = Math.fma(-2.0f, Math.fma(_qx, _qx, _t1), 1.0f);
        float _t26 = Math.fma(-2.0f, Math.fma(_qx, _qx, _qy * _qy), 1.0f);
        dest.put(destOffset + 0, Math.fma(_self02, _t21, Math.fma(_self00, _t24, _self01 * _t18)));
        dest.put(destOffset + 1, Math.fma(_self12, _t21, Math.fma(_self10, _t24, _self11 * _t18)));
        dest.put(destOffset + 2, Math.fma(_self22, _t21, Math.fma(_self20, _t24, _self21 * _t18)));
        dest.put(destOffset + 3, Math.fma(_self32, _t21, Math.fma(_self30, _t24, _self31 * _t18)));
        dest.put(destOffset + 4, Math.fma(_self02, _t19, Math.fma(_self00, _t22, _self01 * _t25)));
        dest.put(destOffset + 5, Math.fma(_self12, _t19, Math.fma(_self10, _t22, _self11 * _t25)));
        dest.put(destOffset + 6, Math.fma(_self22, _t19, Math.fma(_self20, _t22, _self21 * _t25)));
        dest.put(destOffset + 7, Math.fma(_self32, _t19, Math.fma(_self30, _t22, _self31 * _t25)));
        dest.put(destOffset + 8, Math.fma(_self02, _t26, Math.fma(_self00, _t20, _self01 * _t23)));
        dest.put(destOffset + 9, Math.fma(_self12, _t26, Math.fma(_self10, _t20, _self11 * _t23)));
        dest.put(destOffset + 10, Math.fma(_self22, _t26, Math.fma(_self20, _t20, _self21 * _t23)));
        dest.put(destOffset + 11, Math.fma(_self32, _t26, Math.fma(_self30, _t20, _self31 * _t23)));
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer rotateX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.rotateX_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.FloatBuffer rotateX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        dest.put(destOffset + 0, _self00);
        dest.put(destOffset + 1, _self10);
        dest.put(destOffset + 2, _self20);
        dest.put(destOffset + 3, _self30);
        dest.put(destOffset + 4, Math.fma(_self01, _t0, _self02 * _t1));
        dest.put(destOffset + 5, Math.fma(_self11, _t0, _self12 * _t1));
        dest.put(destOffset + 6, Math.fma(_self21, _t0, _self22 * _t1));
        dest.put(destOffset + 7, Math.fma(_self31, _t0, _self32 * _t1));
        dest.put(destOffset + 8, Math.fma(_self02, _t0, -(_self01 * _t1)));
        dest.put(destOffset + 9, Math.fma(_self12, _t0, -(_self11 * _t1)));
        dest.put(destOffset + 10, Math.fma(_self22, _t0, -(_self21 * _t1)));
        dest.put(destOffset + 11, Math.fma(_self32, _t0, -(_self31 * _t1)));
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer rotateXYZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.rotateXYZ_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.FloatBuffer rotateXYZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = (float) Math.sin(angleX);
        float _t1 = (float) Math.sin(angleZ);
        float _t2 = (float) Math.sin(angleY);
        float _t3 = (float) Math.cos(angleX);
        float _t4 = (float) Math.cos(angleZ);
        float _t5 = (float) Math.cos(angleY);
        float _t6 = _t2 * _t3;
        float _t7 = _t5 * _t4;
        float _t8 = _t0 * _t2;
        float _t11 = _t1 * _t5;
        float _t12 = _t3 * _t5;
        float _t13 = _t0 * _t5;
        float _t18 = Math.fma(_t8, _t4, _t1 * _t3);
        float _t19 = Math.fma(_t6, _t1, _t0 * _t4);
        float _t20 = Math.fma(_t0, _t1, -(_t6 * _t4));
        float _t21 = Math.fma(_t3, _t4, -(_t8 * _t1));
        dest.put(destOffset + 0, Math.fma(_self02, _t20, Math.fma(_self00, _t7, _self01 * _t18)));
        dest.put(destOffset + 1, Math.fma(_self12, _t20, Math.fma(_self10, _t7, _self11 * _t18)));
        dest.put(destOffset + 2, Math.fma(_self22, _t20, Math.fma(_self20, _t7, _self21 * _t18)));
        dest.put(destOffset + 3, Math.fma(_self32, _t20, Math.fma(_self30, _t7, _self31 * _t18)));
        dest.put(destOffset + 4, Math.fma(_self02, _t19, Math.fma(_self01, _t21, -(_self00 * _t11))));
        dest.put(destOffset + 5, Math.fma(_self12, _t19, Math.fma(_self11, _t21, -(_self10 * _t11))));
        dest.put(destOffset + 6, Math.fma(_self22, _t19, Math.fma(_self21, _t21, -(_self20 * _t11))));
        dest.put(destOffset + 7, Math.fma(_self32, _t19, Math.fma(_self31, _t21, -(_self30 * _t11))));
        dest.put(destOffset + 8, Math.fma(_self02, _t12, Math.fma(_self00, _t2, -(_self01 * _t13))));
        dest.put(destOffset + 9, Math.fma(_self12, _t12, Math.fma(_self10, _t2, -(_self11 * _t13))));
        dest.put(destOffset + 10, Math.fma(_self22, _t12, Math.fma(_self20, _t2, -(_self21 * _t13))));
        dest.put(destOffset + 11, Math.fma(_self32, _t12, Math.fma(_self30, _t2, -(_self31 * _t13))));
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer rotateXZY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.rotateXZY_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.FloatBuffer rotateXZY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = (float) Math.sin(angleX);
        float _t1 = (float) Math.sin(angleZ);
        float _t2 = (float) Math.cos(angleY);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.cos(angleX);
        float _t5 = (float) Math.cos(angleZ);
        float _t6 = _t0 * _t1;
        float _t8 = _t2 * _t5;
        float _t9 = _t1 * _t4;
        float _t11 = _t0 * _t5;
        float _t12 = _t4 * _t5;
        float _t14 = _t3 * _t5;
        float _t18 = Math.fma(_t9, _t2, _t0 * _t3);
        float _t19 = Math.fma(_t6, _t3, _t4 * _t2);
        float _t20 = Math.fma(_t6, _t2, -(_t3 * _t4));
        float _t21 = Math.fma(_t9, _t3, -(_t0 * _t2));
        dest.put(destOffset + 0, Math.fma(_self02, _t20, Math.fma(_self00, _t8, _self01 * _t18)));
        dest.put(destOffset + 1, Math.fma(_self12, _t20, Math.fma(_self10, _t8, _self11 * _t18)));
        dest.put(destOffset + 2, Math.fma(_self22, _t20, Math.fma(_self20, _t8, _self21 * _t18)));
        dest.put(destOffset + 3, Math.fma(_self32, _t20, Math.fma(_self30, _t8, _self31 * _t18)));
        dest.put(destOffset + 4, Math.fma(_self02, _t11, Math.fma(_self01, _t12, -(_self00 * _t1))));
        dest.put(destOffset + 5, Math.fma(_self12, _t11, Math.fma(_self11, _t12, -(_self10 * _t1))));
        dest.put(destOffset + 6, Math.fma(_self22, _t11, Math.fma(_self21, _t12, -(_self20 * _t1))));
        dest.put(destOffset + 7, Math.fma(_self32, _t11, Math.fma(_self31, _t12, -(_self30 * _t1))));
        dest.put(destOffset + 8, Math.fma(_self02, _t19, Math.fma(_self00, _t14, _self01 * _t21)));
        dest.put(destOffset + 9, Math.fma(_self12, _t19, Math.fma(_self10, _t14, _self11 * _t21)));
        dest.put(destOffset + 10, Math.fma(_self22, _t19, Math.fma(_self20, _t14, _self21 * _t21)));
        dest.put(destOffset + 11, Math.fma(_self32, _t19, Math.fma(_self30, _t14, _self31 * _t21)));
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer rotateY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.rotateY_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.FloatBuffer rotateY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        dest.put(destOffset + 0, Math.fma(_self00, _t0, -(_self02 * _t1)));
        dest.put(destOffset + 1, Math.fma(_self10, _t0, -(_self12 * _t1)));
        dest.put(destOffset + 2, Math.fma(_self20, _t0, -(_self22 * _t1)));
        dest.put(destOffset + 3, Math.fma(_self30, _t0, -(_self32 * _t1)));
        dest.put(destOffset + 4, _self01);
        dest.put(destOffset + 5, _self11);
        dest.put(destOffset + 6, _self21);
        dest.put(destOffset + 7, _self31);
        dest.put(destOffset + 8, Math.fma(_self00, _t1, _self02 * _t0));
        dest.put(destOffset + 9, Math.fma(_self10, _t1, _self12 * _t0));
        dest.put(destOffset + 10, Math.fma(_self20, _t1, _self22 * _t0));
        dest.put(destOffset + 11, Math.fma(_self30, _t1, _self32 * _t0));
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer rotateYXZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.rotateYXZ_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.FloatBuffer rotateYXZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = (float) Math.sin(angleX);
        float _t1 = (float) Math.cos(angleY);
        float _t2 = (float) Math.sin(angleZ);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.cos(angleZ);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t0 * _t1;
        float _t8 = _t0 * _t3;
        float _t10 = _t2 * _t5;
        float _t13 = _t5 * _t4;
        float _t14 = _t5 * _t1;
        float _t15 = _t3 * _t5;
        float _t18 = Math.fma(_t8, _t2, _t1 * _t4);
        float _t19 = Math.fma(_t6, _t4, _t3 * _t2);
        float _t20 = Math.fma(_t6, _t2, -(_t3 * _t4));
        float _t21 = Math.fma(_t8, _t4, -(_t2 * _t1));
        dest.put(destOffset + 0, Math.fma(_self02, _t20, Math.fma(_self00, _t18, _self01 * _t10)));
        dest.put(destOffset + 1, Math.fma(_self12, _t20, Math.fma(_self10, _t18, _self11 * _t10)));
        dest.put(destOffset + 2, Math.fma(_self22, _t20, Math.fma(_self20, _t18, _self21 * _t10)));
        dest.put(destOffset + 3, Math.fma(_self32, _t20, Math.fma(_self30, _t18, _self31 * _t10)));
        dest.put(destOffset + 4, Math.fma(_self02, _t19, Math.fma(_self00, _t21, _self01 * _t13)));
        dest.put(destOffset + 5, Math.fma(_self12, _t19, Math.fma(_self10, _t21, _self11 * _t13)));
        dest.put(destOffset + 6, Math.fma(_self22, _t19, Math.fma(_self20, _t21, _self21 * _t13)));
        dest.put(destOffset + 7, Math.fma(_self32, _t19, Math.fma(_self30, _t21, _self31 * _t13)));
        dest.put(destOffset + 8, Math.fma(_self02, _t14, Math.fma(_self00, _t15, -(_self01 * _t0))));
        dest.put(destOffset + 9, Math.fma(_self12, _t14, Math.fma(_self10, _t15, -(_self11 * _t0))));
        dest.put(destOffset + 10, Math.fma(_self22, _t14, Math.fma(_self20, _t15, -(_self21 * _t0))));
        dest.put(destOffset + 11, Math.fma(_self32, _t14, Math.fma(_self30, _t15, -(_self31 * _t0))));
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer rotateYZX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.rotateYZX_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.FloatBuffer rotateYZX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = (float) Math.sin(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.cos(angleY);
        float _t3 = (float) Math.sin(angleZ);
        float _t4 = (float) Math.cos(angleX);
        float _t5 = (float) Math.sin(angleX);
        float _t6 = _t0 * _t1;
        float _t7 = _t2 * _t1;
        float _t8 = _t0 * _t3;
        float _t10 = _t3 * _t2;
        float _t11 = _t4 * _t1;
        float _t13 = _t5 * _t1;
        float _t18 = Math.fma(_t8, _t4, _t5 * _t2);
        float _t19 = Math.fma(_t10, _t5, _t0 * _t4);
        float _t20 = Math.fma(_t5, _t0, -(_t10 * _t4));
        float _t21 = Math.fma(_t4, _t2, -(_t8 * _t5));
        dest.put(destOffset + 0, Math.fma(-_self02, _t6, Math.fma(_self00, _t7, _self01 * _t3)));
        dest.put(destOffset + 1, Math.fma(-_self12, _t6, Math.fma(_self10, _t7, _self11 * _t3)));
        dest.put(destOffset + 2, Math.fma(-_self22, _t6, Math.fma(_self20, _t7, _self21 * _t3)));
        dest.put(destOffset + 3, Math.fma(-_self32, _t6, Math.fma(_self30, _t7, _self31 * _t3)));
        dest.put(destOffset + 4, Math.fma(_self02, _t18, Math.fma(_self00, _t20, _self01 * _t11)));
        dest.put(destOffset + 5, Math.fma(_self12, _t18, Math.fma(_self10, _t20, _self11 * _t11)));
        dest.put(destOffset + 6, Math.fma(_self22, _t18, Math.fma(_self20, _t20, _self21 * _t11)));
        dest.put(destOffset + 7, Math.fma(_self32, _t18, Math.fma(_self30, _t20, _self31 * _t11)));
        dest.put(destOffset + 8, Math.fma(_self02, _t21, Math.fma(_self00, _t19, -(_self01 * _t13))));
        dest.put(destOffset + 9, Math.fma(_self12, _t21, Math.fma(_self10, _t19, -(_self11 * _t13))));
        dest.put(destOffset + 10, Math.fma(_self22, _t21, Math.fma(_self20, _t19, -(_self21 * _t13))));
        dest.put(destOffset + 11, Math.fma(_self32, _t21, Math.fma(_self30, _t19, -(_self31 * _t13))));
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer rotateZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.rotateZ_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.FloatBuffer rotateZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        dest.put(destOffset + 0, Math.fma(_self00, _t0, _self01 * _t1));
        dest.put(destOffset + 1, Math.fma(_self10, _t0, _self11 * _t1));
        dest.put(destOffset + 2, Math.fma(_self20, _t0, _self21 * _t1));
        dest.put(destOffset + 3, Math.fma(_self30, _t0, _self31 * _t1));
        dest.put(destOffset + 4, Math.fma(_self01, _t0, -(_self00 * _t1)));
        dest.put(destOffset + 5, Math.fma(_self11, _t0, -(_self10 * _t1)));
        dest.put(destOffset + 6, Math.fma(_self21, _t0, -(_self20 * _t1)));
        dest.put(destOffset + 7, Math.fma(_self31, _t0, -(_self30 * _t1)));
        dest.put(destOffset + 8, _self02);
        dest.put(destOffset + 9, _self12);
        dest.put(destOffset + 10, _self22);
        dest.put(destOffset + 11, _self32);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer rotateZXY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.rotateZXY_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.FloatBuffer rotateZXY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = (float) Math.sin(angleY);
        float _t1 = (float) Math.cos(angleX);
        float _t2 = (float) Math.cos(angleY);
        float _t3 = (float) Math.cos(angleZ);
        float _t4 = (float) Math.sin(angleX);
        float _t5 = (float) Math.sin(angleZ);
        float _t6 = _t0 * _t1;
        float _t7 = _t4 * _t5;
        float _t8 = _t4 * _t3;
        float _t10 = _t1 * _t3;
        float _t11 = _t5 * _t1;
        float _t12 = _t1 * _t2;
        float _t18 = Math.fma(_t8, _t0, _t5 * _t2);
        float _t19 = Math.fma(_t7, _t2, _t0 * _t3);
        float _t20 = Math.fma(_t2, _t3, -(_t7 * _t0));
        float _t21 = Math.fma(_t0, _t5, -(_t8 * _t2));
        dest.put(destOffset + 0, Math.fma(-_self02, _t6, Math.fma(_self00, _t20, _self01 * _t18)));
        dest.put(destOffset + 1, Math.fma(-_self12, _t6, Math.fma(_self10, _t20, _self11 * _t18)));
        dest.put(destOffset + 2, Math.fma(-_self22, _t6, Math.fma(_self20, _t20, _self21 * _t18)));
        dest.put(destOffset + 3, Math.fma(-_self32, _t6, Math.fma(_self30, _t20, _self31 * _t18)));
        dest.put(destOffset + 4, Math.fma(_self02, _t4, Math.fma(_self01, _t10, -(_self00 * _t11))));
        dest.put(destOffset + 5, Math.fma(_self12, _t4, Math.fma(_self11, _t10, -(_self10 * _t11))));
        dest.put(destOffset + 6, Math.fma(_self22, _t4, Math.fma(_self21, _t10, -(_self20 * _t11))));
        dest.put(destOffset + 7, Math.fma(_self32, _t4, Math.fma(_self31, _t10, -(_self30 * _t11))));
        dest.put(destOffset + 8, Math.fma(_self02, _t12, Math.fma(_self00, _t19, _self01 * _t21)));
        dest.put(destOffset + 9, Math.fma(_self12, _t12, Math.fma(_self10, _t19, _self11 * _t21)));
        dest.put(destOffset + 10, Math.fma(_self22, _t12, Math.fma(_self20, _t19, _self21 * _t21)));
        dest.put(destOffset + 11, Math.fma(_self32, _t12, Math.fma(_self30, _t19, _self31 * _t21)));
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer rotateZYX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.rotateZYX_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.FloatBuffer rotateZYX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = (float) Math.sin(angleY);
        float _t1 = (float) Math.cos(angleY);
        float _t2 = (float) Math.cos(angleZ);
        float _t3 = (float) Math.sin(angleZ);
        float _t4 = (float) Math.sin(angleX);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t1 * _t2;
        float _t7 = _t3 * _t1;
        float _t8 = _t4 * _t1;
        float _t9 = _t0 * _t2;
        float _t11 = _t0 * _t3;
        float _t13 = _t5 * _t1;
        float _t18 = Math.fma(_t11, _t4, _t5 * _t2);
        float _t19 = Math.fma(_t9, _t5, _t4 * _t3);
        float _t20 = Math.fma(_t9, _t4, -(_t3 * _t5));
        float _t21 = Math.fma(_t11, _t5, -(_t4 * _t2));
        dest.put(destOffset + 0, Math.fma(-_self02, _t0, Math.fma(_self00, _t6, _self01 * _t7)));
        dest.put(destOffset + 1, Math.fma(-_self12, _t0, Math.fma(_self10, _t6, _self11 * _t7)));
        dest.put(destOffset + 2, Math.fma(-_self22, _t0, Math.fma(_self20, _t6, _self21 * _t7)));
        dest.put(destOffset + 3, Math.fma(-_self32, _t0, Math.fma(_self30, _t6, _self31 * _t7)));
        dest.put(destOffset + 4, Math.fma(_self02, _t8, Math.fma(_self00, _t20, _self01 * _t18)));
        dest.put(destOffset + 5, Math.fma(_self12, _t8, Math.fma(_self10, _t20, _self11 * _t18)));
        dest.put(destOffset + 6, Math.fma(_self22, _t8, Math.fma(_self20, _t20, _self21 * _t18)));
        dest.put(destOffset + 7, Math.fma(_self32, _t8, Math.fma(_self30, _t20, _self31 * _t18)));
        dest.put(destOffset + 8, Math.fma(_self02, _t13, Math.fma(_self00, _t19, _self01 * _t21)));
        dest.put(destOffset + 9, Math.fma(_self12, _t13, Math.fma(_self10, _t19, _self11 * _t21)));
        dest.put(destOffset + 10, Math.fma(_self22, _t13, Math.fma(_self20, _t19, _self21 * _t21)));
        dest.put(destOffset + 11, Math.fma(_self32, _t13, Math.fma(_self30, _t19, _self31 * _t21)));
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer scale_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float vX, float vY, float vZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.scale_unsafe(_destBase, _srcBase, vX, vY, vZ);
        return dest;
    }

    public static java.nio.FloatBuffer scale_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float vX, float vY, float vZ) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, _self00 * vX);
        dest.put(destOffset + 1, _self10 * vX);
        dest.put(destOffset + 2, _self20 * vX);
        dest.put(destOffset + 3, _self30 * vX);
        dest.put(destOffset + 4, _self01 * vY);
        dest.put(destOffset + 5, _self11 * vY);
        dest.put(destOffset + 6, _self21 * vY);
        dest.put(destOffset + 7, _self31 * vY);
        dest.put(destOffset + 8, _self02 * vZ);
        dest.put(destOffset + 9, _self12 * vZ);
        dest.put(destOffset + 10, _self22 * vZ);
        dest.put(destOffset + 11, _self32 * vZ);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _vx = v.get(vOffset + 0);
        float _vy = v.get(vOffset + 1);
        float _vz = v.get(vOffset + 2);
        dest.put(destOffset + 0, _self00 * _vx);
        dest.put(destOffset + 1, _self10 * _vx);
        dest.put(destOffset + 2, _self20 * _vx);
        dest.put(destOffset + 3, _self30 * _vx);
        dest.put(destOffset + 4, _self01 * _vy);
        dest.put(destOffset + 5, _self11 * _vy);
        dest.put(destOffset + 6, _self21 * _vy);
        dest.put(destOffset + 7, _self31 * _vy);
        dest.put(destOffset + 8, _self02 * _vz);
        dest.put(destOffset + 9, _self12 * _vz);
        dest.put(destOffset + 10, _self22 * _vz);
        dest.put(destOffset + 11, _self32 * _vz);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer scale_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float s) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.scale_unsafe(_destBase, _srcBase, s);
        return dest;
    }

    public static java.nio.FloatBuffer scale_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float s) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, s * _self00);
        dest.put(destOffset + 1, s * _self10);
        dest.put(destOffset + 2, s * _self20);
        dest.put(destOffset + 3, s * _self30);
        dest.put(destOffset + 4, s * _self01);
        dest.put(destOffset + 5, s * _self11);
        dest.put(destOffset + 6, s * _self21);
        dest.put(destOffset + 7, s * _self31);
        dest.put(destOffset + 8, s * _self02);
        dest.put(destOffset + 9, s * _self12);
        dest.put(destOffset + 10, s * _self22);
        dest.put(destOffset + 11, s * _self32);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer scaleAround_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float s, float pivotX, float pivotY, float pivotZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.scaleAround_unsafe(_destBase, _srcBase, s, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.FloatBuffer scaleAround_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float s, float pivotX, float pivotY, float pivotZ) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = Math.fma(-s, pivotX, pivotX);
        float _t1 = Math.fma(-s, pivotY, pivotY);
        float _t2 = Math.fma(-s, pivotZ, pivotZ);
        dest.put(destOffset + 0, s * _self00);
        dest.put(destOffset + 1, s * _self10);
        dest.put(destOffset + 2, s * _self20);
        dest.put(destOffset + 3, s * _self30);
        dest.put(destOffset + 4, s * _self01);
        dest.put(destOffset + 5, s * _self11);
        dest.put(destOffset + 6, s * _self21);
        dest.put(destOffset + 7, s * _self31);
        dest.put(destOffset + 8, s * _self02);
        dest.put(destOffset + 9, s * _self12);
        dest.put(destOffset + 10, s * _self22);
        dest.put(destOffset + 11, s * _self32);
        dest.put(destOffset + 12, Math.fma(_self00, _t0, Math.fma(_self01, _t1, Math.fma(_self02, _t2, _self03))));
        dest.put(destOffset + 13, Math.fma(_self10, _t0, Math.fma(_self11, _t1, Math.fma(_self12, _t2, _self13))));
        dest.put(destOffset + 14, Math.fma(_self20, _t0, Math.fma(_self21, _t1, Math.fma(_self22, _t2, _self23))));
        dest.put(destOffset + 15, Math.fma(_self30, _t0, Math.fma(_self31, _t1, Math.fma(_self32, _t2, _self33))));
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _pivotx = pivot.get(pivotOffset + 0);
        float _pivoty = pivot.get(pivotOffset + 1);
        float _pivotz = pivot.get(pivotOffset + 2);
        float _t0 = Math.fma(-s, _pivotx, _pivotx);
        float _t1 = Math.fma(-s, _pivoty, _pivoty);
        float _t2 = Math.fma(-s, _pivotz, _pivotz);
        dest.put(destOffset + 0, s * _self00);
        dest.put(destOffset + 1, s * _self10);
        dest.put(destOffset + 2, s * _self20);
        dest.put(destOffset + 3, s * _self30);
        dest.put(destOffset + 4, s * _self01);
        dest.put(destOffset + 5, s * _self11);
        dest.put(destOffset + 6, s * _self21);
        dest.put(destOffset + 7, s * _self31);
        dest.put(destOffset + 8, s * _self02);
        dest.put(destOffset + 9, s * _self12);
        dest.put(destOffset + 10, s * _self22);
        dest.put(destOffset + 11, s * _self32);
        dest.put(destOffset + 12, Math.fma(_self00, _t0, Math.fma(_self01, _t1, Math.fma(_self02, _t2, _self03))));
        dest.put(destOffset + 13, Math.fma(_self10, _t0, Math.fma(_self11, _t1, Math.fma(_self12, _t2, _self13))));
        dest.put(destOffset + 14, Math.fma(_self20, _t0, Math.fma(_self21, _t1, Math.fma(_self22, _t2, _self23))));
        dest.put(destOffset + 15, Math.fma(_self30, _t0, Math.fma(_self31, _t1, Math.fma(_self32, _t2, _self33))));
        return dest;
    }

    public static java.nio.FloatBuffer scaleAround_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float sX, float sY, float sZ, float pivotX, float pivotY, float pivotZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.scaleAround_unsafe(_destBase, _srcBase, sX, sY, sZ, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.FloatBuffer scaleAround_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float sX, float sY, float sZ, float pivotX, float pivotY, float pivotZ) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t3 = Math.fma(-pivotX, sX, pivotX);
        float _t4 = Math.fma(-pivotY, sY, pivotY);
        float _t5 = Math.fma(-pivotZ, sZ, pivotZ);
        dest.put(destOffset + 0, sX * _self00);
        dest.put(destOffset + 1, sX * _self10);
        dest.put(destOffset + 2, sX * _self20);
        dest.put(destOffset + 3, sX * _self30);
        dest.put(destOffset + 4, sY * _self01);
        dest.put(destOffset + 5, sY * _self11);
        dest.put(destOffset + 6, sY * _self21);
        dest.put(destOffset + 7, sY * _self31);
        dest.put(destOffset + 8, sZ * _self02);
        dest.put(destOffset + 9, sZ * _self12);
        dest.put(destOffset + 10, sZ * _self22);
        dest.put(destOffset + 11, sZ * _self32);
        dest.put(destOffset + 12, Math.fma(_self00, _t3, Math.fma(_self01, _t4, Math.fma(_self02, _t5, _self03))));
        dest.put(destOffset + 13, Math.fma(_self10, _t3, Math.fma(_self11, _t4, Math.fma(_self12, _t5, _self13))));
        dest.put(destOffset + 14, Math.fma(_self20, _t3, Math.fma(_self21, _t4, Math.fma(_self22, _t5, _self23))));
        dest.put(destOffset + 15, Math.fma(_self30, _t3, Math.fma(_self31, _t4, Math.fma(_self32, _t5, _self33))));
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _sx = s.get(sOffset + 0);
        float _sy = s.get(sOffset + 1);
        float _sz = s.get(sOffset + 2);
        float _pivotx = pivot.get(pivotOffset + 0);
        float _pivoty = pivot.get(pivotOffset + 1);
        float _pivotz = pivot.get(pivotOffset + 2);
        float _t3 = Math.fma(-_pivotx, _sx, _pivotx);
        float _t4 = Math.fma(-_pivoty, _sy, _pivoty);
        float _t5 = Math.fma(-_pivotz, _sz, _pivotz);
        dest.put(destOffset + 0, _sx * _self00);
        dest.put(destOffset + 1, _sx * _self10);
        dest.put(destOffset + 2, _sx * _self20);
        dest.put(destOffset + 3, _sx * _self30);
        dest.put(destOffset + 4, _sy * _self01);
        dest.put(destOffset + 5, _sy * _self11);
        dest.put(destOffset + 6, _sy * _self21);
        dest.put(destOffset + 7, _sy * _self31);
        dest.put(destOffset + 8, _sz * _self02);
        dest.put(destOffset + 9, _sz * _self12);
        dest.put(destOffset + 10, _sz * _self22);
        dest.put(destOffset + 11, _sz * _self32);
        dest.put(destOffset + 12, Math.fma(_self00, _t3, Math.fma(_self01, _t4, Math.fma(_self02, _t5, _self03))));
        dest.put(destOffset + 13, Math.fma(_self10, _t3, Math.fma(_self11, _t4, Math.fma(_self12, _t5, _self13))));
        dest.put(destOffset + 14, Math.fma(_self20, _t3, Math.fma(_self21, _t4, Math.fma(_self22, _t5, _self23))));
        dest.put(destOffset + 15, Math.fma(_self30, _t3, Math.fma(_self31, _t4, Math.fma(_self32, _t5, _self33))));
        return dest;
    }

    public static java.nio.FloatBuffer shadow_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float lightX, float lightY, float lightZ, float lightW, float planeX, float planeY, float planeZ, float planeW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.shadow_unsafe(_destBase, _srcBase, lightX, lightY, lightZ, lightW, planeX, planeY, planeZ, planeW);
        return dest;
    }

    public static java.nio.FloatBuffer shadow_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float lightX, float lightY, float lightZ, float lightW, float planeX, float planeY, float planeZ, float planeW) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t0 = -_self03;
        float _t1 = -_self02;
        float _t5 = -_self01;
        float _t7 = -_self13;
        float _t8 = -_self12;
        float _t9 = -_self11;
        float _t10 = -_self23;
        float _t11 = -_self22;
        float _t12 = -_self21;
        float _t13 = -_self33;
        float _t14 = -_self32;
        float _t15 = -_self31;
        float _t16 = lightW * planeX;
        float _t17 = lightZ * planeX;
        float _t20 = lightY * planeX;
        float _t21 = lightW * planeY;
        float _t22 = lightZ * planeY;
        float _t23 = lightX * planeY;
        float _t24 = lightW * planeZ;
        float _t25 = lightY * planeZ;
        float _t26 = lightX * planeZ;
        float _t27 = lightZ * planeW;
        float _t28 = lightY * planeW;
        float _t29 = lightX * planeW;
        float _t32 = Math.fma(lightX, planeX, lightY * planeY) + Math.fma(lightZ, planeZ, lightW * planeW);
        float _t33 = Math.fma(-lightX, planeX, _t32);
        float _t34 = Math.fma(-lightY, planeY, _t32);
        float _t35 = Math.fma(-lightZ, planeZ, _t32);
        float _t36 = Math.fma(-lightW, planeW, _t32);
        dest.put(destOffset + 0, Math.fma(_t0, _t16, Math.fma(_t1, _t17, Math.fma(_self00, _t33, -(_self01 * _t20)))));
        dest.put(destOffset + 1, Math.fma(_t7, _t16, Math.fma(_t8, _t17, Math.fma(_self10, _t33, -(_self11 * _t20)))));
        dest.put(destOffset + 2, Math.fma(_t10, _t16, Math.fma(_t11, _t17, Math.fma(_self20, _t33, -(_self21 * _t20)))));
        dest.put(destOffset + 3, Math.fma(_t13, _t16, Math.fma(_t14, _t17, Math.fma(_self30, _t33, -(_self31 * _t20)))));
        dest.put(destOffset + 4, Math.fma(_t0, _t21, Math.fma(_t1, _t22, Math.fma(_self01, _t34, -(_self00 * _t23)))));
        dest.put(destOffset + 5, Math.fma(_t7, _t21, Math.fma(_t8, _t22, Math.fma(_self11, _t34, -(_self10 * _t23)))));
        dest.put(destOffset + 6, Math.fma(_t10, _t21, Math.fma(_t11, _t22, Math.fma(_self21, _t34, -(_self20 * _t23)))));
        dest.put(destOffset + 7, Math.fma(_t13, _t21, Math.fma(_t14, _t22, Math.fma(_self31, _t34, -(_self30 * _t23)))));
        dest.put(destOffset + 8, Math.fma(_t0, _t24, Math.fma(_self02, _t35, Math.fma(_t5, _t25, -(_self00 * _t26)))));
        dest.put(destOffset + 9, Math.fma(_t7, _t24, Math.fma(_self12, _t35, Math.fma(_t9, _t25, -(_self10 * _t26)))));
        dest.put(destOffset + 10, Math.fma(_t10, _t24, Math.fma(_self22, _t35, Math.fma(_t12, _t25, -(_self20 * _t26)))));
        dest.put(destOffset + 11, Math.fma(_t13, _t24, Math.fma(_self32, _t35, Math.fma(_t15, _t25, -(_self30 * _t26)))));
        dest.put(destOffset + 12, Math.fma(_self03, _t36, Math.fma(_t1, _t27, Math.fma(_t5, _t28, -(_self00 * _t29)))));
        dest.put(destOffset + 13, Math.fma(_self13, _t36, Math.fma(_t8, _t27, Math.fma(_t9, _t28, -(_self10 * _t29)))));
        dest.put(destOffset + 14, Math.fma(_self23, _t36, Math.fma(_t11, _t27, Math.fma(_t12, _t28, -(_self20 * _t29)))));
        dest.put(destOffset + 15, Math.fma(_self33, _t36, Math.fma(_t14, _t27, Math.fma(_t15, _t28, -(_self30 * _t29)))));
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _lightx = light.get(lightOffset + 0);
        float _lighty = light.get(lightOffset + 1);
        float _lightz = light.get(lightOffset + 2);
        float _lightw = light.get(lightOffset + 3);
        float _planex = plane.get(planeOffset + 0);
        float _planey = plane.get(planeOffset + 1);
        float _planez = plane.get(planeOffset + 2);
        float _planew = plane.get(planeOffset + 3);
        float _t0 = -_self03;
        float _t1 = -_self02;
        float _t5 = -_self01;
        float _t7 = -_self13;
        float _t8 = -_self12;
        float _t9 = -_self11;
        float _t10 = -_self23;
        float _t11 = -_self22;
        float _t12 = -_self21;
        float _t13 = -_self33;
        float _t14 = -_self32;
        float _t15 = -_self31;
        float _t16 = _lightw * _planex;
        float _t17 = _lightz * _planex;
        float _t20 = _lighty * _planex;
        float _t21 = _lightw * _planey;
        float _t22 = _lightz * _planey;
        float _t23 = _lightx * _planey;
        float _t24 = _lightw * _planez;
        float _t25 = _lighty * _planez;
        float _t26 = _lightx * _planez;
        float _t27 = _lightz * _planew;
        float _t28 = _lighty * _planew;
        float _t29 = _lightx * _planew;
        float _t32 = Math.fma(_lightx, _planex, _lighty * _planey) + Math.fma(_lightz, _planez, _lightw * _planew);
        float _t33 = Math.fma(-_lightx, _planex, _t32);
        float _t34 = Math.fma(-_lighty, _planey, _t32);
        float _t35 = Math.fma(-_lightz, _planez, _t32);
        float _t36 = Math.fma(-_lightw, _planew, _t32);
        dest.put(destOffset + 0, Math.fma(_t0, _t16, Math.fma(_t1, _t17, Math.fma(_self00, _t33, -(_self01 * _t20)))));
        dest.put(destOffset + 1, Math.fma(_t7, _t16, Math.fma(_t8, _t17, Math.fma(_self10, _t33, -(_self11 * _t20)))));
        dest.put(destOffset + 2, Math.fma(_t10, _t16, Math.fma(_t11, _t17, Math.fma(_self20, _t33, -(_self21 * _t20)))));
        dest.put(destOffset + 3, Math.fma(_t13, _t16, Math.fma(_t14, _t17, Math.fma(_self30, _t33, -(_self31 * _t20)))));
        dest.put(destOffset + 4, Math.fma(_t0, _t21, Math.fma(_t1, _t22, Math.fma(_self01, _t34, -(_self00 * _t23)))));
        dest.put(destOffset + 5, Math.fma(_t7, _t21, Math.fma(_t8, _t22, Math.fma(_self11, _t34, -(_self10 * _t23)))));
        dest.put(destOffset + 6, Math.fma(_t10, _t21, Math.fma(_t11, _t22, Math.fma(_self21, _t34, -(_self20 * _t23)))));
        dest.put(destOffset + 7, Math.fma(_t13, _t21, Math.fma(_t14, _t22, Math.fma(_self31, _t34, -(_self30 * _t23)))));
        dest.put(destOffset + 8, Math.fma(_t0, _t24, Math.fma(_self02, _t35, Math.fma(_t5, _t25, -(_self00 * _t26)))));
        dest.put(destOffset + 9, Math.fma(_t7, _t24, Math.fma(_self12, _t35, Math.fma(_t9, _t25, -(_self10 * _t26)))));
        dest.put(destOffset + 10, Math.fma(_t10, _t24, Math.fma(_self22, _t35, Math.fma(_t12, _t25, -(_self20 * _t26)))));
        dest.put(destOffset + 11, Math.fma(_t13, _t24, Math.fma(_self32, _t35, Math.fma(_t15, _t25, -(_self30 * _t26)))));
        dest.put(destOffset + 12, Math.fma(_self03, _t36, Math.fma(_t1, _t27, Math.fma(_t5, _t28, -(_self00 * _t29)))));
        dest.put(destOffset + 13, Math.fma(_self13, _t36, Math.fma(_t8, _t27, Math.fma(_t9, _t28, -(_self10 * _t29)))));
        dest.put(destOffset + 14, Math.fma(_self23, _t36, Math.fma(_t11, _t27, Math.fma(_t12, _t28, -(_self20 * _t29)))));
        dest.put(destOffset + 15, Math.fma(_self33, _t36, Math.fma(_t14, _t27, Math.fma(_t15, _t28, -(_self30 * _t29)))));
        return dest;
    }

    public static java.nio.FloatBuffer shear_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float xy, float xz, float yx, float yz, float zx, float zy) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.shear_unsafe(_destBase, _srcBase, xy, xz, yx, yz, zx, zy);
        return dest;
    }

    public static java.nio.FloatBuffer shear_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float xy, float xz, float yx, float yz, float zx, float zy) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, Math.fma(yx, _self01, Math.fma(zx, _self02, _self00)));
        dest.put(destOffset + 1, Math.fma(yx, _self11, Math.fma(zx, _self12, _self10)));
        dest.put(destOffset + 2, Math.fma(yx, _self21, Math.fma(zx, _self22, _self20)));
        dest.put(destOffset + 3, Math.fma(yx, _self31, Math.fma(zx, _self32, _self30)));
        dest.put(destOffset + 4, Math.fma(xy, _self00, Math.fma(zy, _self02, _self01)));
        dest.put(destOffset + 5, Math.fma(xy, _self10, Math.fma(zy, _self12, _self11)));
        dest.put(destOffset + 6, Math.fma(xy, _self20, Math.fma(zy, _self22, _self21)));
        dest.put(destOffset + 7, Math.fma(xy, _self30, Math.fma(zy, _self32, _self31)));
        dest.put(destOffset + 8, Math.fma(xz, _self00, Math.fma(yz, _self01, _self02)));
        dest.put(destOffset + 9, Math.fma(xz, _self10, Math.fma(yz, _self11, _self12)));
        dest.put(destOffset + 10, Math.fma(xz, _self20, Math.fma(yz, _self21, _self22)));
        dest.put(destOffset + 11, Math.fma(xz, _self30, Math.fma(yz, _self31, _self32)));
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, _self33);
        return dest;
    }

    public static java.nio.FloatBuffer tile_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float x, float y, float w, float h) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.tile_unsafe(_destBase, _srcBase, x, y, w, h);
        return dest;
    }

    public static java.nio.FloatBuffer tile_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float x, float y, float w, float h) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _t2 = Math.fma(-2.0f, x, w - 1.0f);
        float _t3 = Math.fma(-2.0f, y, h - 1.0f);
        dest.put(destOffset + 0, w * _self00);
        dest.put(destOffset + 1, w * _self10);
        dest.put(destOffset + 2, w * _self20);
        dest.put(destOffset + 3, w * _self30);
        dest.put(destOffset + 4, h * _self01);
        dest.put(destOffset + 5, h * _self11);
        dest.put(destOffset + 6, h * _self21);
        dest.put(destOffset + 7, h * _self31);
        dest.put(destOffset + 8, _self02);
        dest.put(destOffset + 9, _self12);
        dest.put(destOffset + 10, _self22);
        dest.put(destOffset + 11, _self32);
        dest.put(destOffset + 12, Math.fma(_self00, _t2, Math.fma(_self01, _t3, _self03)));
        dest.put(destOffset + 13, Math.fma(_self10, _t2, Math.fma(_self11, _t3, _self13)));
        dest.put(destOffset + 14, Math.fma(_self20, _t2, Math.fma(_self21, _t3, _self23)));
        dest.put(destOffset + 15, Math.fma(_self30, _t2, Math.fma(_self31, _t3, _self33)));
        return dest;
    }

    public static java.nio.FloatBuffer translate_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float vX, float vY, float vZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float4x4OpsKernelsAddress.translate_unsafe(_destBase, _srcBase, vX, vY, vZ);
        return dest;
    }

    public static java.nio.FloatBuffer translate_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float vX, float vY, float vZ) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, _self00);
        dest.put(destOffset + 1, _self10);
        dest.put(destOffset + 2, _self20);
        dest.put(destOffset + 3, _self30);
        dest.put(destOffset + 4, _self01);
        dest.put(destOffset + 5, _self11);
        dest.put(destOffset + 6, _self21);
        dest.put(destOffset + 7, _self31);
        dest.put(destOffset + 8, _self02);
        dest.put(destOffset + 9, _self12);
        dest.put(destOffset + 10, _self22);
        dest.put(destOffset + 11, _self32);
        dest.put(destOffset + 12, Math.fma(_self00, vX, Math.fma(_self01, vY, Math.fma(_self02, vZ, _self03))));
        dest.put(destOffset + 13, Math.fma(_self10, vX, Math.fma(_self11, vY, Math.fma(_self12, vZ, _self13))));
        dest.put(destOffset + 14, Math.fma(_self20, vX, Math.fma(_self21, vY, Math.fma(_self22, vZ, _self23))));
        dest.put(destOffset + 15, Math.fma(_self30, vX, Math.fma(_self31, vY, Math.fma(_self32, vZ, _self33))));
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _vx = v.get(vOffset + 0);
        float _vy = v.get(vOffset + 1);
        float _vz = v.get(vOffset + 2);
        dest.put(destOffset + 0, _self00);
        dest.put(destOffset + 1, _self10);
        dest.put(destOffset + 2, _self20);
        dest.put(destOffset + 3, _self30);
        dest.put(destOffset + 4, _self01);
        dest.put(destOffset + 5, _self11);
        dest.put(destOffset + 6, _self21);
        dest.put(destOffset + 7, _self31);
        dest.put(destOffset + 8, _self02);
        dest.put(destOffset + 9, _self12);
        dest.put(destOffset + 10, _self22);
        dest.put(destOffset + 11, _self32);
        dest.put(destOffset + 12, Math.fma(_self00, _vx, Math.fma(_self01, _vy, Math.fma(_self02, _vz, _self03))));
        dest.put(destOffset + 13, Math.fma(_self10, _vx, Math.fma(_self11, _vy, Math.fma(_self12, _vz, _self13))));
        dest.put(destOffset + 14, Math.fma(_self20, _vx, Math.fma(_self21, _vy, Math.fma(_self22, _vz, _self23))));
        dest.put(destOffset + 15, Math.fma(_self30, _vx, Math.fma(_self31, _vy, Math.fma(_self32, _vz, _self33))));
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        dest.put(destOffset + 0, Math.fma(_self03, vW, Math.fma(_self02, vZ, Math.fma(_self00, vX, _self01 * vY))));
        dest.put(destOffset + 1, Math.fma(_self13, vW, Math.fma(_self12, vZ, Math.fma(_self10, vX, _self11 * vY))));
        dest.put(destOffset + 2, Math.fma(_self23, vW, Math.fma(_self22, vZ, Math.fma(_self20, vX, _self21 * vY))));
        dest.put(destOffset + 3, Math.fma(_self33, vW, Math.fma(_self32, vZ, Math.fma(_self30, vX, _self31 * vY))));
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
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self30 = src.get(srcOffset + 3);
        float _self01 = src.get(srcOffset + 4);
        float _self11 = src.get(srcOffset + 5);
        float _self21 = src.get(srcOffset + 6);
        float _self31 = src.get(srcOffset + 7);
        float _self02 = src.get(srcOffset + 8);
        float _self12 = src.get(srcOffset + 9);
        float _self22 = src.get(srcOffset + 10);
        float _self32 = src.get(srcOffset + 11);
        float _self03 = src.get(srcOffset + 12);
        float _self13 = src.get(srcOffset + 13);
        float _self23 = src.get(srcOffset + 14);
        float _self33 = src.get(srcOffset + 15);
        float _vx = v.get(vOffset + 0);
        float _vy = v.get(vOffset + 1);
        float _vz = v.get(vOffset + 2);
        float _vw = v.get(vOffset + 3);
        dest.put(destOffset + 0, Math.fma(_self03, _vw, Math.fma(_self02, _vz, Math.fma(_self00, _vx, _self01 * _vy))));
        dest.put(destOffset + 1, Math.fma(_self13, _vw, Math.fma(_self12, _vz, Math.fma(_self10, _vx, _self11 * _vy))));
        dest.put(destOffset + 2, Math.fma(_self23, _vw, Math.fma(_self22, _vz, Math.fma(_self20, _vx, _self21 * _vy))));
        dest.put(destOffset + 3, Math.fma(_self33, _vw, Math.fma(_self32, _vz, Math.fma(_self30, _vx, _self31 * _vy))));
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
