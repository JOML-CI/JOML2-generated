package org.joml2.internal.kernels;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.ops.*;
import org.joml2.internal.unsafe.*;

/**
 * Scalar/Unsafe kernel leaves of {@link Float3x3Ops} whose leading storage
 * parameter is a {@link java.nio.ByteBuffer}. Split into a sibling compilation unit purely
 * to keep generated sources IDE-sized; package-private, called only from
 * {@code Float3x3Ops} and its sibling kernel units. Not public API.
 */
public final class Float3x3OpsKernelsByteBuffer {
    private Float3x3OpsKernelsByteBuffer() {}

    public static java.nio.ByteBuffer getColumn_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, int col) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.getColumn_unsafe(_destBase, _srcBase, col);
        return dest;
    }

    public static java.nio.ByteBuffer getColumn_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, int col) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        float _idxSw0;
        float _idxSw1;
        float _idxSw2;
        switch (col) {
            case 0: _idxSw0 = _self00; _idxSw1 = _self10; _idxSw2 = _self20; break;
            case 1: _idxSw0 = _self01; _idxSw1 = _self11; _idxSw2 = _self21; break;
            case 2: _idxSw0 = _self02; _idxSw1 = _self12; _idxSw2 = _self22; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + col);
        }
        dest.putFloat(destOffset + 0, _idxSw0);
        dest.putFloat(destOffset + 4, _idxSw1);
        dest.putFloat(destOffset + 8, _idxSw2);
        return dest;
    }

    public static java.nio.ByteBuffer getEulerAnglesXYZ_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.getEulerAnglesXYZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer getEulerAnglesXYZ_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        float _t1 = Math.fma(_self12, _self12, _self22 * _self22);
        float _t3 = Math.fma(_self02, _self02, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            dest.putFloat(destOffset + 0, (float) Math.atan2(_self21, _self11));
            dest.putFloat(destOffset + 8, 0.0f);
        } else {
            dest.putFloat(destOffset + 0, (float) Math.atan2(-_self12, _self22));
            dest.putFloat(destOffset + 8, (float) Math.atan2(-_self01, _self00));
        }
        dest.putFloat(destOffset + 4, (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _self02))));
        return dest;
    }

    public static java.nio.ByteBuffer getEulerAnglesXZY_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.getEulerAnglesXZY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer getEulerAnglesXZY_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        float _t1 = Math.fma(_self11, _self11, _self21 * _self21);
        float _t3 = Math.fma(_self01, _self01, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            dest.putFloat(destOffset + 0, (float) Math.atan2(-_self12, _self22));
            dest.putFloat(destOffset + 4, 0.0f);
        } else {
            dest.putFloat(destOffset + 0, (float) Math.atan2(_self21, _self11));
            dest.putFloat(destOffset + 4, (float) Math.atan2(_self02, _self00));
        }
        dest.putFloat(destOffset + 8, (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, -_self01))));
        return dest;
    }

    public static java.nio.ByteBuffer getEulerAnglesYXZ_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.getEulerAnglesYXZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer getEulerAnglesYXZ_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        float _t1 = Math.fma(_self02, _self02, _self22 * _self22);
        float _t3 = Math.fma(_self12, _self12, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            dest.putFloat(destOffset + 4, (float) Math.atan2(-_self20, _self00));
            dest.putFloat(destOffset + 8, 0.0f);
        } else {
            dest.putFloat(destOffset + 4, (float) Math.atan2(_self02, _self22));
            dest.putFloat(destOffset + 8, (float) Math.atan2(_self10, _self11));
        }
        dest.putFloat(destOffset + 0, (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, -_self12))));
        return dest;
    }

    public static java.nio.ByteBuffer getEulerAnglesYZX_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.getEulerAnglesYZX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer getEulerAnglesYZX_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        float _t1 = Math.fma(_self11, _self11, _self12 * _self12);
        float _t3 = Math.fma(_self10, _self10, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            dest.putFloat(destOffset + 0, 0.0f);
            dest.putFloat(destOffset + 4, (float) Math.atan2(_self02, _self22));
        } else {
            dest.putFloat(destOffset + 0, (float) Math.atan2(-_self12, _self11));
            dest.putFloat(destOffset + 4, (float) Math.atan2(-_self20, _self00));
        }
        dest.putFloat(destOffset + 8, (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _self10))));
        return dest;
    }

    public static java.nio.ByteBuffer getEulerAnglesZXY_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.getEulerAnglesZXY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer getEulerAnglesZXY_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self22 = src.getFloat(srcOffset + 32);
        float _t1 = Math.fma(_self01, _self01, _self11 * _self11);
        float _t3 = Math.fma(_self21, _self21, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            dest.putFloat(destOffset + 4, 0.0f);
            dest.putFloat(destOffset + 8, (float) Math.atan2(_self10, _self00));
        } else {
            dest.putFloat(destOffset + 4, (float) Math.atan2(-_self20, _self22));
            dest.putFloat(destOffset + 8, (float) Math.atan2(-_self01, _self11));
        }
        dest.putFloat(destOffset + 0, (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _self21))));
        return dest;
    }

    public static java.nio.ByteBuffer getEulerAnglesZYX_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.getEulerAnglesZYX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer getEulerAnglesZYX_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self22 = src.getFloat(srcOffset + 32);
        float _t1 = Math.fma(_self21, _self21, _self22 * _self22);
        float _t3 = Math.fma(_self20, _self20, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            dest.putFloat(destOffset + 0, 0.0f);
            dest.putFloat(destOffset + 8, (float) Math.atan2(-_self01, _self11));
        } else {
            dest.putFloat(destOffset + 0, (float) Math.atan2(_self21, _self22));
            dest.putFloat(destOffset + 8, (float) Math.atan2(_self10, _self00));
        }
        dest.putFloat(destOffset + 4, (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, -_self20))));
        return dest;
    }

    public static java.nio.ByteBuffer getNormalizedRotation_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.getNormalizedRotation_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer getNormalizedRotation_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
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
            dest.putFloat(destOffset + 0, 0.5f * _t36 * _t66);
            dest.putFloat(destOffset + 4, 0.5f * _t56 * _t66);
            dest.putFloat(destOffset + 8, 0.5f * _t57 * _t66);
            dest.putFloat(destOffset + 12, 0.5f * (float) Math.sqrt(_t62));
        } else {
            if (_t49 > _t37) {
                dest.putFloat(destOffset + 0, 0.5f * (float) Math.sqrt(_t63));
                dest.putFloat(destOffset + 4, 0.5f * _t53 * _t69);
                dest.putFloat(destOffset + 8, 0.5f * _t55 * _t69);
                dest.putFloat(destOffset + 12, 0.5f * _t36 * _t69);
            } else {
                if (_t23 > _t26) {
                    dest.putFloat(destOffset + 0, 0.5f * _t53 * _t67);
                    dest.putFloat(destOffset + 4, 0.5f * (float) Math.sqrt(_t64));
                    dest.putFloat(destOffset + 8, 0.5f * _t39 * _t67);
                    dest.putFloat(destOffset + 12, 0.5f * _t56 * _t67);
                } else {
                    dest.putFloat(destOffset + 0, 0.5f * _t55 * _t68);
                    dest.putFloat(destOffset + 4, 0.5f * _t39 * _t68);
                    dest.putFloat(destOffset + 8, 0.5f * (float) Math.sqrt(_t65));
                    dest.putFloat(destOffset + 12, 0.5f * _t57 * _t68);
                }
            }
        }
        return dest;
    }

    public static java.nio.ByteBuffer getRow_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, int row) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.getRow_unsafe(_destBase, _srcBase, row);
        return dest;
    }

    public static java.nio.ByteBuffer getRow_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, int row) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        float _idxSw0;
        float _idxSw1;
        float _idxSw2;
        switch (row) {
            case 0: _idxSw0 = _self00; _idxSw1 = _self01; _idxSw2 = _self02; break;
            case 1: _idxSw0 = _self10; _idxSw1 = _self11; _idxSw2 = _self12; break;
            case 2: _idxSw0 = _self20; _idxSw1 = _self21; _idxSw2 = _self22; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + row);
        }
        dest.putFloat(destOffset + 0, _idxSw0);
        dest.putFloat(destOffset + 4, _idxSw1);
        dest.putFloat(destOffset + 8, _idxSw2);
        return dest;
    }

    public static java.nio.ByteBuffer getScale_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.getScale_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer getScale_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        dest.putFloat(destOffset + 0, (float) Math.sqrt(Math.fma(_self20, _self20, Math.fma(_self00, _self00, _self10 * _self10))));
        dest.putFloat(destOffset + 4, (float) Math.sqrt(Math.fma(_self21, _self21, Math.fma(_self01, _self01, _self11 * _self11))));
        dest.putFloat(destOffset + 8, (float) Math.sqrt(Math.fma(_self22, _self22, Math.fma(_self02, _self02, _self12 * _self12))));
        return dest;
    }

    public static java.nio.ByteBuffer getTranslation_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.getTranslation_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer getTranslation_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        dest.putFloat(destOffset + 0, _self02);
        dest.putFloat(destOffset + 4, _self12);
        return dest;
    }

    public static java.nio.ByteBuffer getUnnormalizedRotation_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.getUnnormalizedRotation_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer getUnnormalizedRotation_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
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
            dest.putFloat(destOffset + 0, 0.5f * _t1 * _t18);
            dest.putFloat(destOffset + 4, 0.5f * _t7 * _t18);
            dest.putFloat(destOffset + 8, 0.5f * _t9 * _t18);
            dest.putFloat(destOffset + 12, 0.5f * (float) Math.sqrt(_t14));
        } else {
            if (_self00 > _t2) {
                dest.putFloat(destOffset + 0, 0.5f * (float) Math.sqrt(_t15));
                dest.putFloat(destOffset + 4, 0.5f * _t4 * _t21);
                dest.putFloat(destOffset + 8, 0.5f * _t6 * _t21);
                dest.putFloat(destOffset + 12, 0.5f * _t1 * _t21);
            } else {
                if (_self11 > _self22) {
                    dest.putFloat(destOffset + 0, 0.5f * _t4 * _t19);
                    dest.putFloat(destOffset + 4, 0.5f * (float) Math.sqrt(_t16));
                    dest.putFloat(destOffset + 8, 0.5f * _t8 * _t19);
                    dest.putFloat(destOffset + 12, 0.5f * _t7 * _t19);
                } else {
                    dest.putFloat(destOffset + 0, 0.5f * _t6 * _t20);
                    dest.putFloat(destOffset + 4, 0.5f * _t8 * _t20);
                    dest.putFloat(destOffset + 8, 0.5f * (float) Math.sqrt(_t17));
                    dest.putFloat(destOffset + 12, 0.5f * _t9 * _t20);
                }
            }
        }
        return dest;
    }

    public static java.nio.ByteBuffer cofactor_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.cofactor_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer cofactor_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        dest.putFloat(destOffset + 0, Math.fma(_self11, _self22, -(_self12 * _self21)));
        dest.putFloat(destOffset + 4, Math.fma(_self02, _self21, -(_self01 * _self22)));
        dest.putFloat(destOffset + 8, Math.fma(_self01, _self12, -(_self02 * _self11)));
        dest.putFloat(destOffset + 12, Math.fma(_self12, _self20, -(_self10 * _self22)));
        dest.putFloat(destOffset + 16, Math.fma(_self00, _self22, -(_self02 * _self20)));
        dest.putFloat(destOffset + 20, Math.fma(_self02, _self10, -(_self00 * _self12)));
        dest.putFloat(destOffset + 24, Math.fma(_self10, _self21, -(_self11 * _self20)));
        dest.putFloat(destOffset + 28, Math.fma(_self01, _self20, -(_self00 * _self21)));
        dest.putFloat(destOffset + 32, Math.fma(_self00, _self11, -(_self01 * _self10)));
        return dest;
    }

    public static float determinant_unsafe(java.nio.ByteBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        return Float3x3OpsKernelsAddress.determinant_unsafe(_srcBase);
    }

    public static float determinant_api(java.nio.ByteBuffer src, int srcOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        return Math.fma(_self02, Math.fma(_self10, _self21, -(_self11 * _self20)), Math.fma(_self00, Math.fma(_self11, _self22, -(_self12 * _self21)), -(_self01 * Math.fma(_self10, _self22, -(_self12 * _self20)))));
    }

    public static float frobeniusNorm_unsafe(java.nio.ByteBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        return Float3x3OpsKernelsAddress.frobeniusNorm_unsafe(_srcBase);
    }

    public static float frobeniusNorm_api(java.nio.ByteBuffer src, int srcOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        return (float) Math.sqrt(Math.fma(_self00, _self00, _self01 * _self01) + Math.fma(_self02, _self02, _self10 * _self10) + (Math.fma(_self11, _self11, _self12 * _self12) + Math.fma(_self20, _self20, Math.fma(_self21, _self21, _self22 * _self22))));
    }

    public static java.nio.ByteBuffer invert_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.invert_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer invert_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        float _t6 = Math.fma(_self11, _self22, -(_self12 * _self21));
        float _t7 = Math.fma(_self10, _self21, -(_self11 * _self20));
        float _t12 = Math.fma(_self02, _t7, Math.fma(_self00, _t6, -(_self01 * Math.fma(_self10, _self22, -(_self12 * _self20)))));
        float _t12_inv = 1.0f / _t12;
        dest.putFloat(destOffset + 0, _t6 * _t12_inv);
        dest.putFloat(destOffset + 4, Math.fma(_self12, _self20, -(_self10 * _self22)) * _t12_inv);
        dest.putFloat(destOffset + 8, _t7 * _t12_inv);
        dest.putFloat(destOffset + 12, Math.fma(_self02, _self21, -(_self01 * _self22)) * _t12_inv);
        dest.putFloat(destOffset + 16, Math.fma(_self00, _self22, -(_self02 * _self20)) * _t12_inv);
        dest.putFloat(destOffset + 20, Math.fma(_self01, _self20, -(_self00 * _self21)) * _t12_inv);
        dest.putFloat(destOffset + 24, Math.fma(_self01, _self12, -(_self02 * _self11)) * _t12_inv);
        dest.putFloat(destOffset + 28, Math.fma(_self02, _self10, -(_self00 * _self12)) * _t12_inv);
        dest.putFloat(destOffset + 32, Math.fma(_self00, _self11, -(_self01 * _self10)) * _t12_inv);
        return dest;
    }

    public static java.nio.ByteBuffer invertProduct_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + otherOffset;
        Float3x3OpsKernelsAddress.invertProduct_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.ByteBuffer invertProduct_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        float _other00 = other.getFloat(otherOffset + 0);
        float _other10 = other.getFloat(otherOffset + 4);
        float _other20 = other.getFloat(otherOffset + 8);
        float _other01 = other.getFloat(otherOffset + 12);
        float _other11 = other.getFloat(otherOffset + 16);
        float _other21 = other.getFloat(otherOffset + 20);
        float _other02 = other.getFloat(otherOffset + 24);
        float _other12 = other.getFloat(otherOffset + 28);
        float _other22 = other.getFloat(otherOffset + 32);
        float _t18 = Math.fma(_other21, _self12, Math.fma(_other01, _self10, _other11 * _self11));
        float _t19 = Math.fma(_other22, _self22, Math.fma(_other02, _self20, _other12 * _self21));
        float _t20 = Math.fma(_other21, _self22, Math.fma(_other01, _self20, _other11 * _self21));
        float _t21 = Math.fma(_other22, _self12, Math.fma(_other02, _self10, _other12 * _self11));
        float _t22 = Math.fma(_other22, _self02, Math.fma(_other02, _self00, _other12 * _self01));
        float _t23 = Math.fma(_other20, _self12, Math.fma(_other00, _self10, _other10 * _self11));
        float _t24 = Math.fma(_other20, _self22, Math.fma(_other00, _self20, _other10 * _self21));
        float _t25 = Math.fma(_other20, _self02, Math.fma(_other00, _self00, _other10 * _self01));
        float _t26 = Math.fma(_other21, _self02, Math.fma(_other01, _self00, _other11 * _self01));
        float _t33 = Math.fma(_t18, _t19, -(_t20 * _t21));
        float _t34 = Math.fma(_t23, _t20, -(_t24 * _t18));
        float _t39 = Math.fma(_t22, _t34, Math.fma(_t25, _t33, -(_t26 * Math.fma(_t23, _t19, -(_t24 * _t21)))));
        float _t39_inv = 1.0f / _t39;
        dest.putFloat(destOffset + 0, _t33 * _t39_inv);
        dest.putFloat(destOffset + 4, Math.fma(_t24, _t21, -(_t23 * _t19)) * _t39_inv);
        dest.putFloat(destOffset + 8, _t34 * _t39_inv);
        dest.putFloat(destOffset + 12, Math.fma(_t20, _t22, -(_t26 * _t19)) * _t39_inv);
        dest.putFloat(destOffset + 16, Math.fma(_t25, _t19, -(_t24 * _t22)) * _t39_inv);
        dest.putFloat(destOffset + 20, Math.fma(_t24, _t26, -(_t25 * _t20)) * _t39_inv);
        dest.putFloat(destOffset + 24, Math.fma(_t26, _t21, -(_t18 * _t22)) * _t39_inv);
        dest.putFloat(destOffset + 28, Math.fma(_t23, _t22, -(_t25 * _t21)) * _t39_inv);
        dest.putFloat(destOffset + 32, Math.fma(_t25, _t18, -(_t23 * _t26)) * _t39_inv);
        return dest;
    }

    public static java.nio.ByteBuffer normal_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.normal_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer normal_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        float _t6 = Math.fma(_self11, _self22, -(_self12 * _self21));
        float _t7 = Math.fma(_self10, _self21, -(_self11 * _self20));
        float _t12 = Math.fma(_self02, _t7, Math.fma(_self00, _t6, -(_self01 * Math.fma(_self10, _self22, -(_self12 * _self20)))));
        float _t12_inv = 1.0f / _t12;
        dest.putFloat(destOffset + 0, _t6 * _t12_inv);
        dest.putFloat(destOffset + 4, Math.fma(_self02, _self21, -(_self01 * _self22)) * _t12_inv);
        dest.putFloat(destOffset + 8, Math.fma(_self01, _self12, -(_self02 * _self11)) * _t12_inv);
        dest.putFloat(destOffset + 12, Math.fma(_self12, _self20, -(_self10 * _self22)) * _t12_inv);
        dest.putFloat(destOffset + 16, Math.fma(_self00, _self22, -(_self02 * _self20)) * _t12_inv);
        dest.putFloat(destOffset + 20, Math.fma(_self02, _self10, -(_self00 * _self12)) * _t12_inv);
        dest.putFloat(destOffset + 24, _t7 * _t12_inv);
        dest.putFloat(destOffset + 28, Math.fma(_self01, _self20, -(_self00 * _self21)) * _t12_inv);
        dest.putFloat(destOffset + 32, Math.fma(_self00, _self11, -(_self01 * _self10)) * _t12_inv);
        return dest;
    }

    public static float trace_unsafe(java.nio.ByteBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        return Float3x3OpsKernelsAddress.trace_unsafe(_srcBase);
    }

    public static float trace_api(java.nio.ByteBuffer src, int srcOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self22 = src.getFloat(srcOffset + 32);
        return _self22 + (_self00 + _self11);
    }

    public static java.nio.ByteBuffer transpose_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.transpose_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer transpose_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        dest.putFloat(destOffset + 0, _self00);
        dest.putFloat(destOffset + 4, _self01);
        dest.putFloat(destOffset + 8, _self02);
        dest.putFloat(destOffset + 12, _self10);
        dest.putFloat(destOffset + 16, _self11);
        dest.putFloat(destOffset + 20, _self12);
        dest.putFloat(destOffset + 24, _self20);
        dest.putFloat(destOffset + 28, _self21);
        dest.putFloat(destOffset + 32, _self22);
        return dest;
    }

    public static java.nio.ByteBuffer add_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + otherOffset;
        Float3x3OpsKernelsAddress.add_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.ByteBuffer add_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        for (int _i = 0; _i < 9; _i++) {
            float _eself = src.getFloat(srcOffset + _i * 4);
            float _eother = other.getFloat(otherOffset + _i * 4);
            dest.putFloat(destOffset + _i * 4, _eother + _eself);
        }
        return dest;
    }

    public static java.nio.ByteBuffer negate_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.negate_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer negate_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        for (int _i = 0; _i < 9; _i++) {
            float _eself = src.getFloat(srcOffset + _i * 4);
            dest.putFloat(destOffset + _i * 4, -_eself);
        }
        return dest;
    }

    public static java.nio.ByteBuffer sub_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + otherOffset;
        Float3x3OpsKernelsAddress.sub_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.ByteBuffer sub_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        for (int _i = 0; _i < 9; _i++) {
            float _eself = src.getFloat(srcOffset + _i * 4);
            float _eother = other.getFloat(otherOffset + _i * 4);
            dest.putFloat(destOffset + _i * 4, _eself - _eother);
        }
        return dest;
    }

    public static java.nio.ByteBuffer set_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + vOffset;
        Float3x3OpsKernelsAddress.set_unsafe(_destBase, _vBase);
        return dest;
    }

    public static java.nio.ByteBuffer set_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer v, int vOffset) {
        for (int _i = 0; _i < 9; _i++) {
            float _ev = v.getFloat(vOffset + _i * 4);
            dest.putFloat(destOffset + _i * 4, _ev);
        }
        return dest;
    }

    public static java.nio.ByteBuffer setMat2x2_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer m, int mOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _mBase = UnsafeOpsHolder.U.getLong(m, UnsafeCopy.BB_ADDRESS_OFFSET) + mOffset;
        Float3x3OpsKernelsAddress.setMat2x2_unsafe(_destBase, _mBase);
        return dest;
    }

    public static java.nio.ByteBuffer setMat2x2_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer m, int mOffset) {
        float _m00 = m.getFloat(mOffset + 0);
        float _m10 = m.getFloat(mOffset + 4);
        float _m01 = m.getFloat(mOffset + 8);
        float _m11 = m.getFloat(mOffset + 12);
        dest.putFloat(destOffset + 0, _m00);
        dest.putFloat(destOffset + 4, _m10);
        dest.putFloat(destOffset + 8, 0.0f);
        dest.putFloat(destOffset + 12, _m01);
        dest.putFloat(destOffset + 16, _m11);
        dest.putFloat(destOffset + 20, 0.0f);
        dest.putFloat(destOffset + 24, 0.0f);
        dest.putFloat(destOffset + 28, 0.0f);
        dest.putFloat(destOffset + 32, 1.0f);
        return dest;
    }

    public static java.nio.ByteBuffer setMat2x3_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer m, int mOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _mBase = UnsafeOpsHolder.U.getLong(m, UnsafeCopy.BB_ADDRESS_OFFSET) + mOffset;
        Float3x3OpsKernelsAddress.setMat2x3_unsafe(_destBase, _mBase);
        return dest;
    }

    public static java.nio.ByteBuffer setMat2x3_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer m, int mOffset) {
        float _m00 = m.getFloat(mOffset + 0);
        float _m10 = m.getFloat(mOffset + 4);
        float _m01 = m.getFloat(mOffset + 8);
        float _m11 = m.getFloat(mOffset + 12);
        float _m02 = m.getFloat(mOffset + 16);
        float _m12 = m.getFloat(mOffset + 20);
        dest.putFloat(destOffset + 0, _m00);
        dest.putFloat(destOffset + 4, _m10);
        dest.putFloat(destOffset + 8, 0.0f);
        dest.putFloat(destOffset + 12, _m01);
        dest.putFloat(destOffset + 16, _m11);
        dest.putFloat(destOffset + 20, 0.0f);
        dest.putFloat(destOffset + 24, _m02);
        dest.putFloat(destOffset + 28, _m12);
        dest.putFloat(destOffset + 32, 1.0f);
        return dest;
    }

    public static java.nio.ByteBuffer setMat3x4_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer m, int mOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _mBase = UnsafeOpsHolder.U.getLong(m, UnsafeCopy.BB_ADDRESS_OFFSET) + mOffset;
        Float3x3OpsKernelsAddress.setMat3x4_unsafe(_destBase, _mBase);
        return dest;
    }

    public static java.nio.ByteBuffer setMat3x4_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer m, int mOffset) {
        float _m00 = m.getFloat(mOffset + 0);
        float _m01 = m.getFloat(mOffset + 4);
        float _m02 = m.getFloat(mOffset + 8);
        float _m10 = m.getFloat(mOffset + 16);
        float _m11 = m.getFloat(mOffset + 20);
        float _m12 = m.getFloat(mOffset + 24);
        float _m20 = m.getFloat(mOffset + 32);
        float _m21 = m.getFloat(mOffset + 36);
        float _m22 = m.getFloat(mOffset + 40);
        dest.putFloat(destOffset + 0, _m00);
        dest.putFloat(destOffset + 4, _m10);
        dest.putFloat(destOffset + 8, _m20);
        dest.putFloat(destOffset + 12, _m01);
        dest.putFloat(destOffset + 16, _m11);
        dest.putFloat(destOffset + 20, _m21);
        dest.putFloat(destOffset + 24, _m02);
        dest.putFloat(destOffset + 28, _m12);
        dest.putFloat(destOffset + 32, _m22);
        return dest;
    }

    public static java.nio.ByteBuffer setMat4x4_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer m, int mOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _mBase = UnsafeOpsHolder.U.getLong(m, UnsafeCopy.BB_ADDRESS_OFFSET) + mOffset;
        Float3x3OpsKernelsAddress.setMat4x4_unsafe(_destBase, _mBase);
        return dest;
    }

    public static java.nio.ByteBuffer setMat4x4_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer m, int mOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 3;
            int _lom = _l * 4;
            float _em0 = m.getFloat(mOffset + _lom * 4);
            float _em1 = m.getFloat(mOffset + (_lom + 1) * 4);
            float _em2 = m.getFloat(mOffset + (_lom + 2) * 4);
            dest.putFloat(destOffset + _lo * 4, _em0);
            dest.putFloat(destOffset + (_lo + 1) * 4, _em1);
            dest.putFloat(destOffset + (_lo + 2) * 4, _em2);
        }
        return dest;
    }

    public static java.nio.ByteBuffer withTranslation_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float tX, float tY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.withTranslation_unsafe(_destBase, _srcBase, tX, tY);
        return dest;
    }

    public static java.nio.ByteBuffer withTranslation_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float tX, float tY) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self22 = src.getFloat(srcOffset + 32);
        dest.putFloat(destOffset + 0, _self00);
        dest.putFloat(destOffset + 4, _self10);
        dest.putFloat(destOffset + 8, _self20);
        dest.putFloat(destOffset + 12, _self01);
        dest.putFloat(destOffset + 16, _self11);
        dest.putFloat(destOffset + 20, _self21);
        dest.putFloat(destOffset + 24, tX);
        dest.putFloat(destOffset + 28, tY);
        dest.putFloat(destOffset + 32, _self22);
        return dest;
    }

    public static java.nio.ByteBuffer withTranslation_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer t, int tOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _tBase = UnsafeOpsHolder.U.getLong(t, UnsafeCopy.BB_ADDRESS_OFFSET) + tOffset;
        Float3x3OpsKernelsAddress.withTranslation_unsafe(_destBase, _srcBase, _tBase);
        return dest;
    }

    public static java.nio.ByteBuffer withTranslation_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer t, int tOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self22 = src.getFloat(srcOffset + 32);
        float _tx = t.getFloat(tOffset + 0);
        float _ty = t.getFloat(tOffset + 4);
        dest.putFloat(destOffset + 0, _self00);
        dest.putFloat(destOffset + 4, _self10);
        dest.putFloat(destOffset + 8, _self20);
        dest.putFloat(destOffset + 12, _self01);
        dest.putFloat(destOffset + 16, _self11);
        dest.putFloat(destOffset + 20, _self21);
        dest.putFloat(destOffset + 24, _tx);
        dest.putFloat(destOffset + 28, _ty);
        dest.putFloat(destOffset + 32, _self22);
        return dest;
    }

    public static java.nio.ByteBuffer makeFromRigid_unsafe(java.nio.ByteBuffer dest, int destOffset, float rTX, float rTY, float rTZ, float rRX, float rRY, float rRZ, float rRW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Float3x3OpsKernelsAddress.makeFromRigid_unsafe(_destBase, rTX, rTY, rTZ, rRX, rRY, rRZ, rRW);
        return dest;
    }

    public static java.nio.ByteBuffer makeFromRigid_api(java.nio.ByteBuffer dest, int destOffset, float rTX, float rTY, float rTZ, float rRX, float rRY, float rRZ, float rRW) {
        float _t0 = rRZ * rRZ;
        float _t1 = rRZ * rRW;
        float _t2 = rRY * rRW;
        dest.putFloat(destOffset + 0, Math.fma(-2.0f, Math.fma(rRY, rRY, _t0), 1.0f));
        dest.putFloat(destOffset + 4, 2.0f * Math.fma(rRX, rRY, _t1));
        dest.putFloat(destOffset + 8, 2.0f * Math.fma(rRX, rRZ, -_t2));
        dest.putFloat(destOffset + 12, 2.0f * Math.fma(rRX, rRY, -_t1));
        dest.putFloat(destOffset + 16, Math.fma(-2.0f, Math.fma(rRX, rRX, _t0), 1.0f));
        dest.putFloat(destOffset + 20, 2.0f * Math.fma(rRX, rRW, rRY * rRZ));
        dest.putFloat(destOffset + 24, 2.0f * Math.fma(rRX, rRZ, _t2));
        dest.putFloat(destOffset + 28, 2.0f * Math.fma(rRY, rRZ, -(rRX * rRW)));
        dest.putFloat(destOffset + 32, Math.fma(-2.0f, Math.fma(rRX, rRX, rRY * rRY), 1.0f));
        return dest;
    }

    public static java.nio.ByteBuffer makeFromTransform_unsafe(java.nio.ByteBuffer dest, int destOffset, float tTX, float tTY, float tTZ, float tRX, float tRY, float tRZ, float tRW, float tSX, float tSY, float tSZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Float3x3OpsKernelsAddress.makeFromTransform_unsafe(_destBase, tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ);
        return dest;
    }

    public static java.nio.ByteBuffer makeFromTransform_api(java.nio.ByteBuffer dest, int destOffset, float tTX, float tTY, float tTZ, float tRX, float tRY, float tRZ, float tRW, float tSX, float tSY, float tSZ) {
        float _t0 = tRZ * tRZ;
        float _t1 = tRZ * tRW;
        float _t2 = tRY * tRW;
        dest.putFloat(destOffset + 0, tSX * Math.fma(-2.0f, Math.fma(tRY, tRY, _t0), 1.0f));
        dest.putFloat(destOffset + 4, tSX * 2.0f * Math.fma(tRX, tRY, _t1));
        dest.putFloat(destOffset + 8, tSX * 2.0f * Math.fma(tRX, tRZ, -_t2));
        dest.putFloat(destOffset + 12, tSY * 2.0f * Math.fma(tRX, tRY, -_t1));
        dest.putFloat(destOffset + 16, tSY * Math.fma(-2.0f, Math.fma(tRX, tRX, _t0), 1.0f));
        dest.putFloat(destOffset + 20, tSY * 2.0f * Math.fma(tRX, tRW, tRY * tRZ));
        dest.putFloat(destOffset + 24, tSZ * 2.0f * Math.fma(tRX, tRZ, _t2));
        dest.putFloat(destOffset + 28, tSZ * 2.0f * Math.fma(tRY, tRZ, -(tRX * tRW)));
        dest.putFloat(destOffset + 32, tSZ * Math.fma(-2.0f, Math.fma(tRX, tRX, tRY * tRY), 1.0f));
        return dest;
    }

    public static java.nio.ByteBuffer to2x2_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.to2x2_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer to2x2_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        dest.putFloat(destOffset + 0, _self00);
        dest.putFloat(destOffset + 4, _self10);
        dest.putFloat(destOffset + 8, _self01);
        dest.putFloat(destOffset + 12, _self11);
        return dest;
    }

    public static java.nio.ByteBuffer to2x3_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.to2x3_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer to2x3_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 2;
            int _loself = _l * 3;
            float _eself0 = src.getFloat(srcOffset + _loself * 4);
            float _eself1 = src.getFloat(srcOffset + (_loself + 1) * 4);
            dest.putFloat(destOffset + _lo * 4, _eself0);
            dest.putFloat(destOffset + (_lo + 1) * 4, _eself1);
        }
        return dest;
    }

    public static java.nio.ByteBuffer to3x4_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.to3x4_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer to3x4_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        dest.putFloat(destOffset + 0, _self00);
        dest.putFloat(destOffset + 4, _self01);
        dest.putFloat(destOffset + 8, _self02);
        dest.putFloat(destOffset + 12, 0.0f);
        dest.putFloat(destOffset + 16, _self10);
        dest.putFloat(destOffset + 20, _self11);
        dest.putFloat(destOffset + 24, _self12);
        dest.putFloat(destOffset + 28, 0.0f);
        dest.putFloat(destOffset + 32, _self20);
        dest.putFloat(destOffset + 36, _self21);
        dest.putFloat(destOffset + 40, _self22);
        dest.putFloat(destOffset + 44, 0.0f);
        return dest;
    }

    public static java.nio.ByteBuffer to4x4_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.to4x4_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer to4x4_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        dest.putFloat(destOffset + 0, _self00);
        dest.putFloat(destOffset + 4, _self10);
        dest.putFloat(destOffset + 8, _self20);
        dest.putFloat(destOffset + 12, 0.0f);
        dest.putFloat(destOffset + 16, _self01);
        dest.putFloat(destOffset + 20, _self11);
        dest.putFloat(destOffset + 24, _self21);
        dest.putFloat(destOffset + 28, 0.0f);
        dest.putFloat(destOffset + 32, _self02);
        dest.putFloat(destOffset + 36, _self12);
        dest.putFloat(destOffset + 40, _self22);
        dest.putFloat(destOffset + 44, 0.0f);
        dest.putFloat(destOffset + 48, 0.0f);
        dest.putFloat(destOffset + 52, 0.0f);
        dest.putFloat(destOffset + 56, 0.0f);
        dest.putFloat(destOffset + 60, 1.0f);
        return dest;
    }

    public static java.nio.ByteBuffer toDualQuat_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.toDualQuat_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer toDualQuat_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        float _t1 = 1.0f - _self00;
        float _t3 = _self21 - _self12;
        float _t4 = Math.max(_self11, _self22);
        float _t5 = _self01 + _self10;
        float _t6 = _self02 + _self20;
        float _t7 = _self02 - _self20;
        float _t8 = _self12 + _self21;
        float _t9 = _self10 - _self01;
        float _t13 = _self22 + (_self00 + _self11);
        float _t14 = 1.0f + _t13;
        float _t15 = _self00 + (1.0f - _self11 - _self22);
        float _t16 = _self11 + (_t1 - _self22);
        float _t17 = _self22 + (_t1 - _self11);
        float _t18 = (1.0f / (float) Math.sqrt(_t14));
        float _t19 = (1.0f / (float) Math.sqrt(_t16));
        float _t20 = (1.0f / (float) Math.sqrt(_t17));
        float _t21 = (1.0f / (float) Math.sqrt(_t15));
        if (_t13 > 0.0f) {
            dest.putFloat(destOffset + 0, 0.5f * _t3 * _t18);
            dest.putFloat(destOffset + 4, 0.5f * _t7 * _t18);
            dest.putFloat(destOffset + 8, 0.5f * _t9 * _t18);
            dest.putFloat(destOffset + 12, 0.5f * (float) Math.sqrt(_t14));
        } else {
            if (_self00 > _t4) {
                dest.putFloat(destOffset + 0, 0.5f * (float) Math.sqrt(_t15));
                dest.putFloat(destOffset + 4, 0.5f * _t5 * _t21);
                dest.putFloat(destOffset + 8, 0.5f * _t6 * _t21);
                dest.putFloat(destOffset + 12, 0.5f * _t3 * _t21);
            } else {
                if (_self11 > _self22) {
                    dest.putFloat(destOffset + 0, 0.5f * _t5 * _t19);
                    dest.putFloat(destOffset + 4, 0.5f * (float) Math.sqrt(_t16));
                    dest.putFloat(destOffset + 8, 0.5f * _t8 * _t19);
                    dest.putFloat(destOffset + 12, 0.5f * _t7 * _t19);
                } else {
                    dest.putFloat(destOffset + 0, 0.5f * _t6 * _t20);
                    dest.putFloat(destOffset + 4, 0.5f * _t8 * _t20);
                    dest.putFloat(destOffset + 8, 0.5f * (float) Math.sqrt(_t17));
                    dest.putFloat(destOffset + 12, 0.5f * _t9 * _t20);
                }
            }
        }
        dest.putFloat(destOffset + 16, 0.0f);
        dest.putFloat(destOffset + 20, 0.0f);
        dest.putFloat(destOffset + 24, 0.0f);
        dest.putFloat(destOffset + 28, 0.0f);
        return dest;
    }

    public static java.nio.ByteBuffer toRigid_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.toRigid_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer toRigid_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        float _t0 = -_self11;
        float _t1 = -_self22;
        float _t12 = (1.0f / (float) Math.sqrt(Math.fma(_self21, _self21, Math.fma(_self01, _self01, _self11 * _self11))));
        float _t13 = (1.0f / (float) Math.sqrt(Math.fma(_self22, _self22, Math.fma(_self02, _self02, _self12 * _self12))));
        float _t14 = (1.0f / (float) Math.sqrt(Math.fma(_self20, _self20, Math.fma(_self00, _self00, _self10 * _self10))));
        float _t15 = _self10 * _t14;
        float _t16 = _self22 * _t13;
        float _t17 = _self12 * _t13;
        float _t18 = _self20 * _t14;
        float _t20 = _self21 * _t12;
        float _t21 = _self11 * _t12;
        float _t23 = _self00 * _t14;
        float _t28 = Math.fma(_self12, _t13, _t20);
        float _t32 = Math.fma(_self21, _t12, -_t17);
        float _t33 = Math.max(_t21, _t16);
        float _t43 = Math.fma(-Math.fma(_t15, _t16, -(_t17 * _t18)), _self01 * _t12, Math.fma(Math.fma(_t15, _t20, -(_t21 * _t18)), _self02 * _t13, Math.fma(_t21, _t16, -(_t17 * _t20)) * _t23));
        float _t44, _t45, _t46;
        if (_t43 < 0.0f) {
            _t44 = -_t23;
            _t45 = -_t15;
            _t46 = -_t18;
        } else {
            _t44 = _t23;
            _t45 = _t15;
            _t46 = _t18;
        }
        float _t48 = 1.0f + _t44;
        float _t49 = 1.0f - _t44;
        float _t51 = Math.fma(_self01, _t12, _t45);
        float _t52 = Math.fma(_self02, _t13, _t46);
        float _t53 = Math.fma(_self02, _t13, -_t46);
        float _t54 = Math.fma(-_self01, _t12, _t45);
        float _t59 = Math.fma(_self11, _t12, Math.fma(_self22, _t13, _t44));
        float _t60 = Math.fma(_self11, _t12, Math.fma(_self22, _t13, _t48));
        float _t61 = (1.0f / (float) Math.sqrt(_t60));
        float _t62 = Math.fma(_self11, _t12, Math.fma(_t1, _t13, _t49));
        float _t63 = Math.fma(_self22, _t13, Math.fma(_t0, _t12, _t49));
        float _t64 = Math.fma(_t0, _t12, Math.fma(_t1, _t13, _t48));
        float _t65 = (1.0f / (float) Math.sqrt(_t62));
        float _t66 = (1.0f / (float) Math.sqrt(_t63));
        float _t67 = (1.0f / (float) Math.sqrt(_t64));
        if (_t59 > 0.0f) {
            dest.putFloat(destOffset + 12, 0.5f * _t32 * _t61);
            dest.putFloat(destOffset + 16, 0.5f * _t53 * _t61);
            dest.putFloat(destOffset + 20, 0.5f * _t54 * _t61);
            dest.putFloat(destOffset + 24, 0.5f * (float) Math.sqrt(_t60));
        } else {
            if (_t44 > _t33) {
                dest.putFloat(destOffset + 12, 0.5f * (float) Math.sqrt(_t64));
                dest.putFloat(destOffset + 16, 0.5f * _t51 * _t67);
                dest.putFloat(destOffset + 20, 0.5f * _t52 * _t67);
                dest.putFloat(destOffset + 24, 0.5f * _t32 * _t67);
            } else {
                if (_t21 > _t16) {
                    dest.putFloat(destOffset + 12, 0.5f * _t51 * _t65);
                    dest.putFloat(destOffset + 16, 0.5f * (float) Math.sqrt(_t62));
                    dest.putFloat(destOffset + 20, 0.5f * _t28 * _t65);
                    dest.putFloat(destOffset + 24, 0.5f * _t53 * _t65);
                } else {
                    dest.putFloat(destOffset + 12, 0.5f * _t52 * _t66);
                    dest.putFloat(destOffset + 16, 0.5f * _t28 * _t66);
                    dest.putFloat(destOffset + 20, 0.5f * (float) Math.sqrt(_t63));
                    dest.putFloat(destOffset + 24, 0.5f * _t54 * _t66);
                }
            }
        }
        dest.putFloat(destOffset + 0, 0.0f);
        dest.putFloat(destOffset + 4, 0.0f);
        dest.putFloat(destOffset + 8, 0.0f);
        return dest;
    }

    public static java.nio.ByteBuffer toTransform_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.toTransform_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer toTransform_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        float _t0 = -_self11;
        float _t1 = -_self22;
        float _t9 = Math.fma(_self21, _self21, Math.fma(_self01, _self01, _self11 * _self11));
        float _t10 = Math.fma(_self22, _self22, Math.fma(_self02, _self02, _self12 * _self12));
        float _t11 = Math.fma(_self20, _self20, Math.fma(_self00, _self00, _self10 * _self10));
        float _t12 = (1.0f / (float) Math.sqrt(_t9));
        float _t13 = (1.0f / (float) Math.sqrt(_t10));
        float _t14 = (1.0f / (float) Math.sqrt(_t11));
        float _t15 = (float) Math.sqrt(_t11);
        float _t16 = _self10 * _t14;
        float _t17 = _self22 * _t13;
        float _t18 = _self12 * _t13;
        float _t19 = _self20 * _t14;
        float _t21 = _self21 * _t12;
        float _t22 = _self11 * _t12;
        float _t24 = _self00 * _t14;
        float _t29 = Math.fma(_self12, _t13, _t21);
        float _t33 = Math.fma(_self21, _t12, -_t18);
        float _t34 = Math.max(_t22, _t17);
        float _t44 = Math.fma(-Math.fma(_t16, _t17, -(_t18 * _t19)), _self01 * _t12, Math.fma(Math.fma(_t16, _t21, -(_t22 * _t19)), _self02 * _t13, Math.fma(_t22, _t17, -(_t18 * _t21)) * _t24));
        float _t45, _t46, _t47;
        if (_t44 < 0.0f) {
            _t45 = -_t24;
            _t46 = -_t16;
            _t47 = -_t19;
        } else {
            _t45 = _t24;
            _t46 = _t16;
            _t47 = _t19;
        }
        float _t49 = 1.0f + _t45;
        float _t50 = 1.0f - _t45;
        float _t52 = Math.fma(_self01, _t12, _t46);
        float _t53 = Math.fma(_self02, _t13, _t47);
        float _t54 = Math.fma(_self02, _t13, -_t47);
        float _t55 = Math.fma(-_self01, _t12, _t46);
        float _t60 = Math.fma(_self11, _t12, Math.fma(_self22, _t13, _t45));
        float _t61 = Math.fma(_self11, _t12, Math.fma(_self22, _t13, _t49));
        float _t62 = (1.0f / (float) Math.sqrt(_t61));
        float _t63 = Math.fma(_self11, _t12, Math.fma(_t1, _t13, _t50));
        float _t64 = Math.fma(_self22, _t13, Math.fma(_t0, _t12, _t50));
        float _t65 = Math.fma(_t0, _t12, Math.fma(_t1, _t13, _t49));
        float _t66 = (1.0f / (float) Math.sqrt(_t63));
        float _t67 = (1.0f / (float) Math.sqrt(_t64));
        float _t68 = (1.0f / (float) Math.sqrt(_t65));
        dest.putFloat(destOffset + 0, 0.0f);
        dest.putFloat(destOffset + 4, 0.0f);
        dest.putFloat(destOffset + 8, 0.0f);
        dest.putFloat(destOffset + 12, _t60 > 0.0f ? 0.5f * _t33 * _t62 : _t45 > _t34 ? 0.5f * (float) Math.sqrt(_t65) : _t22 > _t17 ? 0.5f * _t52 * _t66 : 0.5f * _t53 * _t67);
        dest.putFloat(destOffset + 16, _t60 > 0.0f ? 0.5f * _t54 * _t62 : _t45 > _t34 ? 0.5f * _t52 * _t68 : _t22 > _t17 ? 0.5f * (float) Math.sqrt(_t63) : 0.5f * _t29 * _t67);
        dest.putFloat(destOffset + 20, _t60 > 0.0f ? 0.5f * _t55 * _t62 : _t45 > _t34 ? 0.5f * _t53 * _t68 : _t22 > _t17 ? 0.5f * _t29 * _t66 : 0.5f * (float) Math.sqrt(_t64));
        dest.putFloat(destOffset + 24, _t60 > 0.0f ? 0.5f * (float) Math.sqrt(_t61) : _t45 > _t34 ? 0.5f * _t33 * _t68 : _t22 > _t17 ? 0.5f * _t54 * _t66 : 0.5f * _t55 * _t67);
        dest.putFloat(destOffset + 28, _t44 < 0.0f ? -_t15 : _t15);
        dest.putFloat(destOffset + 32, (float) Math.sqrt(_t9));
        dest.putFloat(destOffset + 36, (float) Math.sqrt(_t10));
        return dest;
    }

    public static java.nio.ByteBuffer decomposeRotation_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.decomposeRotation_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer decomposeRotation_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
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
            dest.putFloat(destOffset + 0, 0.5f * _t60 * _t90);
            dest.putFloat(destOffset + 4, 0.5f * _t81 * _t90);
            dest.putFloat(destOffset + 8, 0.5f * _t78 * _t90);
            dest.putFloat(destOffset + 12, 0.5f * (float) Math.sqrt(_t86));
        } else {
            if (_t73 > _t61) {
                dest.putFloat(destOffset + 0, 0.5f * (float) Math.sqrt(_t87));
                dest.putFloat(destOffset + 4, 0.5f * _t77 * _t93);
                dest.putFloat(destOffset + 8, 0.5f * _t80 * _t93);
                dest.putFloat(destOffset + 12, 0.5f * _t60 * _t93);
            } else {
                if (_t36 > _t56) {
                    dest.putFloat(destOffset + 0, 0.5f * _t77 * _t91);
                    dest.putFloat(destOffset + 4, 0.5f * (float) Math.sqrt(_t88));
                    dest.putFloat(destOffset + 8, 0.5f * _t63 * _t91);
                    dest.putFloat(destOffset + 12, 0.5f * _t81 * _t91);
                } else {
                    dest.putFloat(destOffset + 0, 0.5f * _t80 * _t92);
                    dest.putFloat(destOffset + 4, 0.5f * _t63 * _t92);
                    dest.putFloat(destOffset + 8, 0.5f * (float) Math.sqrt(_t89));
                    dest.putFloat(destOffset + 12, 0.5f * _t78 * _t92);
                }
            }
        }
        return dest;
    }

    public static java.nio.ByteBuffer decomposeScale_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.decomposeScale_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer decomposeScale_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        float _t2 = Math.fma(_self20, _self20, Math.fma(_self00, _self00, _self10 * _self10));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t4 = (float) Math.sqrt(_t2);
        float _t8, _t9, _t10;
        if (_t2 > 0.0f) {
            _t8 = _self20 * _t3;
            _t9 = _self00 * _t3;
            _t10 = _self10 * _t3;
        } else {
            _t8 = 0.0f;
            _t9 = 0.0f;
            _t10 = 0.0f;
        }
        float _t17 = -Math.fma(_self21, _t8, Math.fma(_self01, _t9, _self11 * _t10));
        float _t18 = -Math.fma(_self22, _t8, Math.fma(_self02, _t9, _self12 * _t10));
        float _t19 = Math.fma(_t17, _t8, _self21);
        float _t20 = Math.fma(_t17, _t9, _self01);
        float _t21 = Math.fma(_t17, _t10, _self11);
        float _t27 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        float _t28 = (1.0f / (float) Math.sqrt(_t27));
        float _t32, _t33, _t34;
        if (_t27 > 0.0f) {
            _t32 = _t20 * _t28;
            _t33 = _t19 * _t28;
            _t34 = _t21 * _t28;
        } else {
            _t32 = 0.0f;
            _t33 = 0.0f;
            _t34 = 0.0f;
        }
        float _t38 = -Math.fma(Math.fma(_t18, _t8, _self22), _t33, Math.fma(Math.fma(_t18, _t9, _self02), _t32, Math.fma(_t18, _t10, _self12) * _t34));
        float _t42 = Math.fma(_t18, _t8, Math.fma(_t38, _t33, _self22));
        float _t43 = Math.fma(_t18, _t9, Math.fma(_t38, _t32, _self02));
        float _t44 = Math.fma(_t18, _t10, Math.fma(_t38, _t34, _self12));
        float _t47 = Math.fma(_t42, _t42, Math.fma(_t43, _t43, _t44 * _t44));
        float _t48 = (1.0f / (float) Math.sqrt(_t47));
        float _t52, _t53, _t54;
        if (_t47 > 0.0f) {
            _t52 = _t44 * _t48;
            _t53 = _t43 * _t48;
            _t54 = _t42 * _t48;
        } else {
            _t52 = 0.0f;
            _t53 = 0.0f;
            _t54 = 0.0f;
        }
        dest.putFloat(destOffset + 0, Math.fma(Math.fma(_t32, _t52, -(_t34 * _t53)), _t8, Math.fma(Math.fma(_t34, _t54, -(_t33 * _t52)), _t9, Math.fma(_t33, _t53, -(_t32 * _t54)) * _t10)) < 0.0f ? -_t4 : _t4);
        dest.putFloat(destOffset + 4, (float) Math.sqrt(_t27));
        dest.putFloat(destOffset + 8, (float) Math.sqrt(_t47));
        return dest;
    }

    public static java.nio.ByteBuffer decomposeSkew_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.decomposeSkew_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer decomposeSkew_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
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
        float _t14 = Math.fma(_self22, _t7, Math.fma(_self02, _t8, _self12 * _t9));
        float _t15 = Math.fma(_self21, _t7, Math.fma(_self01, _t8, _self11 * _t9));
        float _t16 = -_t14;
        float _t17 = -_t15;
        float _t19 = Math.fma(_t17, _t7, _self21);
        float _t20 = Math.fma(_t17, _t8, _self01);
        float _t21 = Math.fma(_t17, _t9, _self11);
        float _t26 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        float _t27 = (1.0f / (float) Math.sqrt(_t26));
        float _t28 = _t15 * _t27;
        float _t32, _t33, _t34;
        if (_t26 > 0.0f) {
            _t32 = _t19 * _t27;
            _t33 = _t20 * _t27;
            _t34 = _t21 * _t27;
        } else {
            _t32 = 0.0f;
            _t33 = 0.0f;
            _t34 = 0.0f;
        }
        float _t37 = Math.fma(Math.fma(_t16, _t7, _self22), _t32, Math.fma(Math.fma(_t16, _t8, _self02), _t33, Math.fma(_t16, _t9, _self12) * _t34));
        float _t38 = -_t37;
        float _t42 = Math.fma(_t16, _t7, Math.fma(_t38, _t32, _self22));
        float _t43 = Math.fma(_t16, _t8, Math.fma(_t38, _t33, _self02));
        float _t44 = Math.fma(_t16, _t9, Math.fma(_t38, _t34, _self12));
        float _t47 = Math.fma(_t42, _t42, Math.fma(_t43, _t43, _t44 * _t44));
        float _t48 = (1.0f / (float) Math.sqrt(_t47));
        float _t49 = _t14 * _t48;
        float _t53, _t54, _t55;
        if (_t47 > 0.0f) {
            _t53 = _t44 * _t48;
            _t54 = _t43 * _t48;
            _t55 = _t42 * _t48;
        } else {
            _t53 = 0.0f;
            _t54 = 0.0f;
            _t55 = 0.0f;
        }
        float _t67 = Math.fma(Math.fma(_t33, _t53, -(_t34 * _t54)), _t7, Math.fma(Math.fma(_t34, _t55, -(_t32 * _t53)), _t8, Math.fma(_t32, _t54, -(_t33 * _t55)) * _t9));
        if (_t67 < 0.0f) {
            dest.putFloat(destOffset + 4, -_t49);
            dest.putFloat(destOffset + 8, -_t28);
        } else {
            dest.putFloat(destOffset + 4, _t49);
            dest.putFloat(destOffset + 8, _t28);
        }
        dest.putFloat(destOffset + 0, _t37 * _t48);
        return dest;
    }

    public static java.nio.ByteBuffer makeIdentity_unsafe(java.nio.ByteBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Float3x3OpsKernelsAddress.makeIdentity_unsafe(_destBase);
        return dest;
    }

    public static java.nio.ByteBuffer makeIdentity_api(java.nio.ByteBuffer dest, int destOffset) {
        dest.putFloat(destOffset + 0, 1.0f);
        dest.putFloat(destOffset + 4, 0.0f);
        dest.putFloat(destOffset + 8, 0.0f);
        dest.putFloat(destOffset + 12, 0.0f);
        dest.putFloat(destOffset + 16, 1.0f);
        dest.putFloat(destOffset + 20, 0.0f);
        dest.putFloat(destOffset + 24, 0.0f);
        dest.putFloat(destOffset + 28, 0.0f);
        dest.putFloat(destOffset + 32, 1.0f);
        return dest;
    }

    public static java.nio.ByteBuffer lerp_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset, float t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + otherOffset;
        Float3x3OpsKernelsAddress.lerp_unsafe(_destBase, _srcBase, _otherBase, t);
        return dest;
    }

    public static java.nio.ByteBuffer lerp_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset, float t) {
        for (int _i = 0; _i < 9; _i++) {
            float _eself = src.getFloat(srcOffset + _i * 4);
            float _eother = other.getFloat(otherOffset + _i * 4);
            dest.putFloat(destOffset + _i * 4, Math.fma(t, _eother - _eself, _eself));
        }
        return dest;
    }

    public static java.nio.ByteBuffer mul_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer right, int rightOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _rightBase = UnsafeOpsHolder.U.getLong(right, UnsafeCopy.BB_ADDRESS_OFFSET) + rightOffset;
        Float3x3OpsKernelsAddress.mul_unsafe(_destBase, _srcBase, _rightBase);
        return dest;
    }

    public static java.nio.ByteBuffer mul_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer right, int rightOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 3;
            float _eright0 = right.getFloat(rightOffset + _lo * 4);
            float _eright1 = right.getFloat(rightOffset + (_lo + 1) * 4);
            float _eright2 = right.getFloat(rightOffset + (_lo + 2) * 4);
            dest.putFloat(destOffset + _lo * 4, Math.fma(_eright2, _self02, Math.fma(_eright0, _self00, _eright1 * _self01)));
            dest.putFloat(destOffset + (_lo + 1) * 4, Math.fma(_eright2, _self12, Math.fma(_eright0, _self10, _eright1 * _self11)));
            dest.putFloat(destOffset + (_lo + 2) * 4, Math.fma(_eright2, _self22, Math.fma(_eright0, _self20, _eright1 * _self21)));
        }
        return dest;
    }

    public static java.nio.ByteBuffer mulMat2x2_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer right, int rightOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _rightBase = UnsafeOpsHolder.U.getLong(right, UnsafeCopy.BB_ADDRESS_OFFSET) + rightOffset;
        Float3x3OpsKernelsAddress.mulMat2x2_unsafe(_destBase, _srcBase, _rightBase);
        return dest;
    }

    public static java.nio.ByteBuffer mulMat2x2_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer right, int rightOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        float _right00 = right.getFloat(rightOffset + 0);
        float _right10 = right.getFloat(rightOffset + 4);
        float _right01 = right.getFloat(rightOffset + 8);
        float _right11 = right.getFloat(rightOffset + 12);
        dest.putFloat(destOffset + 0, Math.fma(_right00, _self00, _right10 * _self01));
        dest.putFloat(destOffset + 4, Math.fma(_right00, _self10, _right10 * _self11));
        dest.putFloat(destOffset + 8, Math.fma(_right00, _self20, _right10 * _self21));
        dest.putFloat(destOffset + 12, Math.fma(_right01, _self00, _right11 * _self01));
        dest.putFloat(destOffset + 16, Math.fma(_right01, _self10, _right11 * _self11));
        dest.putFloat(destOffset + 20, Math.fma(_right01, _self20, _right11 * _self21));
        dest.putFloat(destOffset + 24, _self02);
        dest.putFloat(destOffset + 28, _self12);
        dest.putFloat(destOffset + 32, _self22);
        return dest;
    }

    public static java.nio.ByteBuffer mulMat2x3_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer right, int rightOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _rightBase = UnsafeOpsHolder.U.getLong(right, UnsafeCopy.BB_ADDRESS_OFFSET) + rightOffset;
        Float3x3OpsKernelsAddress.mulMat2x3_unsafe(_destBase, _srcBase, _rightBase);
        return dest;
    }

    public static java.nio.ByteBuffer mulMat2x3_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer right, int rightOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        float _right00 = right.getFloat(rightOffset + 0);
        float _right10 = right.getFloat(rightOffset + 4);
        float _right01 = right.getFloat(rightOffset + 8);
        float _right11 = right.getFloat(rightOffset + 12);
        float _right02 = right.getFloat(rightOffset + 16);
        float _right12 = right.getFloat(rightOffset + 20);
        dest.putFloat(destOffset + 0, Math.fma(_right00, _self00, _right10 * _self01));
        dest.putFloat(destOffset + 4, Math.fma(_right00, _self10, _right10 * _self11));
        dest.putFloat(destOffset + 8, Math.fma(_right00, _self20, _right10 * _self21));
        dest.putFloat(destOffset + 12, Math.fma(_right01, _self00, _right11 * _self01));
        dest.putFloat(destOffset + 16, Math.fma(_right01, _self10, _right11 * _self11));
        dest.putFloat(destOffset + 20, Math.fma(_right01, _self20, _right11 * _self21));
        dest.putFloat(destOffset + 24, Math.fma(_right02, _self00, Math.fma(_right12, _self01, _self02)));
        dest.putFloat(destOffset + 28, Math.fma(_right02, _self10, Math.fma(_right12, _self11, _self12)));
        dest.putFloat(destOffset + 32, Math.fma(_right02, _self20, Math.fma(_right12, _self21, _self22)));
        return dest;
    }

    public static java.nio.ByteBuffer preMul_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + otherOffset;
        Float3x3OpsKernelsAddress.preMul_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.ByteBuffer preMul_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        float _other00 = other.getFloat(otherOffset + 0);
        float _other10 = other.getFloat(otherOffset + 4);
        float _other20 = other.getFloat(otherOffset + 8);
        float _other01 = other.getFloat(otherOffset + 12);
        float _other11 = other.getFloat(otherOffset + 16);
        float _other21 = other.getFloat(otherOffset + 20);
        float _other02 = other.getFloat(otherOffset + 24);
        float _other12 = other.getFloat(otherOffset + 28);
        float _other22 = other.getFloat(otherOffset + 32);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 3;
            float _eself0 = src.getFloat(srcOffset + _lo * 4);
            float _eself1 = src.getFloat(srcOffset + (_lo + 1) * 4);
            float _eself2 = src.getFloat(srcOffset + (_lo + 2) * 4);
            dest.putFloat(destOffset + _lo * 4, Math.fma(_other02, _eself2, Math.fma(_other00, _eself0, _other01 * _eself1)));
            dest.putFloat(destOffset + (_lo + 1) * 4, Math.fma(_other12, _eself2, Math.fma(_other10, _eself0, _other11 * _eself1)));
            dest.putFloat(destOffset + (_lo + 2) * 4, Math.fma(_other22, _eself2, Math.fma(_other20, _eself0, _other21 * _eself1)));
        }
        return dest;
    }

    public static java.nio.ByteBuffer preMulMat2x2_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + otherOffset;
        Float3x3OpsKernelsAddress.preMulMat2x2_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.ByteBuffer preMulMat2x2_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        float _other00 = other.getFloat(otherOffset + 0);
        float _other10 = other.getFloat(otherOffset + 4);
        float _other01 = other.getFloat(otherOffset + 8);
        float _other11 = other.getFloat(otherOffset + 12);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 3;
            float _eself0 = src.getFloat(srcOffset + _lo * 4);
            float _eself1 = src.getFloat(srcOffset + (_lo + 1) * 4);
            float _eself2 = src.getFloat(srcOffset + (_lo + 2) * 4);
            dest.putFloat(destOffset + _lo * 4, Math.fma(_other00, _eself0, _other01 * _eself1));
            dest.putFloat(destOffset + (_lo + 1) * 4, Math.fma(_other10, _eself0, _other11 * _eself1));
            dest.putFloat(destOffset + (_lo + 2) * 4, _eself2);
        }
        return dest;
    }

    public static java.nio.ByteBuffer preMulMat2x3_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + otherOffset;
        Float3x3OpsKernelsAddress.preMulMat2x3_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.ByteBuffer preMulMat2x3_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        float _other00 = other.getFloat(otherOffset + 0);
        float _other10 = other.getFloat(otherOffset + 4);
        float _other01 = other.getFloat(otherOffset + 8);
        float _other11 = other.getFloat(otherOffset + 12);
        float _other02 = other.getFloat(otherOffset + 16);
        float _other12 = other.getFloat(otherOffset + 20);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 3;
            float _eself0 = src.getFloat(srcOffset + _lo * 4);
            float _eself1 = src.getFloat(srcOffset + (_lo + 1) * 4);
            float _eself2 = src.getFloat(srcOffset + (_lo + 2) * 4);
            dest.putFloat(destOffset + _lo * 4, Math.fma(_other02, _eself2, Math.fma(_other00, _eself0, _other01 * _eself1)));
            dest.putFloat(destOffset + (_lo + 1) * 4, Math.fma(_other12, _eself2, Math.fma(_other10, _eself0, _other11 * _eself1)));
            dest.putFloat(destOffset + (_lo + 2) * 4, _eself2);
        }
        return dest;
    }

    public static java.nio.ByteBuffer makeOuterProduct_unsafe(java.nio.ByteBuffer dest, int destOffset, float colX, float colY, float colZ, float rowX, float rowY, float rowZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Float3x3OpsKernelsAddress.makeOuterProduct_unsafe(_destBase, colX, colY, colZ, rowX, rowY, rowZ);
        return dest;
    }

    public static java.nio.ByteBuffer makeOuterProduct_api(java.nio.ByteBuffer dest, int destOffset, float colX, float colY, float colZ, float rowX, float rowY, float rowZ) {
        dest.putFloat(destOffset + 0, colX * rowX);
        dest.putFloat(destOffset + 4, colY * rowX);
        dest.putFloat(destOffset + 8, colZ * rowX);
        dest.putFloat(destOffset + 12, colX * rowY);
        dest.putFloat(destOffset + 16, colY * rowY);
        dest.putFloat(destOffset + 20, colZ * rowY);
        dest.putFloat(destOffset + 24, colX * rowZ);
        dest.putFloat(destOffset + 28, colY * rowZ);
        dest.putFloat(destOffset + 32, colZ * rowZ);
        return dest;
    }

    public static java.nio.ByteBuffer makeOuterProduct_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer col, int colOffset, java.nio.ByteBuffer row, int rowOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _colBase = UnsafeOpsHolder.U.getLong(col, UnsafeCopy.BB_ADDRESS_OFFSET) + colOffset;
        long _rowBase = UnsafeOpsHolder.U.getLong(row, UnsafeCopy.BB_ADDRESS_OFFSET) + rowOffset;
        Float3x3OpsKernelsAddress.makeOuterProduct_unsafe(_destBase, _colBase, _rowBase);
        return dest;
    }

    public static java.nio.ByteBuffer makeOuterProduct_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer col, int colOffset, java.nio.ByteBuffer row, int rowOffset) {
        float _colx = col.getFloat(colOffset + 0);
        float _coly = col.getFloat(colOffset + 4);
        float _colz = col.getFloat(colOffset + 8);
        float _rowx = row.getFloat(rowOffset + 0);
        float _rowy = row.getFloat(rowOffset + 4);
        float _rowz = row.getFloat(rowOffset + 8);
        dest.putFloat(destOffset + 0, _colx * _rowx);
        dest.putFloat(destOffset + 4, _coly * _rowx);
        dest.putFloat(destOffset + 8, _colz * _rowx);
        dest.putFloat(destOffset + 12, _colx * _rowy);
        dest.putFloat(destOffset + 16, _coly * _rowy);
        dest.putFloat(destOffset + 20, _colz * _rowy);
        dest.putFloat(destOffset + 24, _colx * _rowz);
        dest.putFloat(destOffset + 28, _coly * _rowz);
        dest.putFloat(destOffset + 32, _colz * _rowz);
        return dest;
    }

    public static java.nio.ByteBuffer lookAlong_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.lookAlong_unsafe(_destBase, _srcBase, dirX, dirY, dirZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.ByteBuffer lookAlong_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
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
        dest.putFloat(destOffset + 0, Math.fma(_self02, _t26, Math.fma(_self00, _t27, _self01 * _t28)));
        dest.putFloat(destOffset + 4, Math.fma(_self12, _t26, Math.fma(_self10, _t27, _self11 * _t28)));
        dest.putFloat(destOffset + 8, Math.fma(_self22, _t26, Math.fma(_self20, _t27, _self21 * _t28)));
        dest.putFloat(destOffset + 12, Math.fma(_self02, _t35, Math.fma(_self00, _t36, _self01 * _t37)));
        dest.putFloat(destOffset + 16, Math.fma(_self12, _t35, Math.fma(_self10, _t36, _self11 * _t37)));
        dest.putFloat(destOffset + 20, Math.fma(_self22, _t35, Math.fma(_self20, _t36, _self21 * _t37)));
        dest.putFloat(destOffset + 24, Math.fma(_self02, _t9, Math.fma(_self00, _t8, _self01 * _t7)));
        dest.putFloat(destOffset + 28, Math.fma(_self12, _t9, Math.fma(_self10, _t8, _self11 * _t7)));
        dest.putFloat(destOffset + 32, Math.fma(_self22, _t9, Math.fma(_self20, _t8, _self21 * _t7)));
        return dest;
    }

    public static java.nio.ByteBuffer lookAlong_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer dir, int dirOffset, java.nio.ByteBuffer up, int upOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _dirBase = UnsafeOpsHolder.U.getLong(dir, UnsafeCopy.BB_ADDRESS_OFFSET) + dirOffset;
        long _upBase = UnsafeOpsHolder.U.getLong(up, UnsafeCopy.BB_ADDRESS_OFFSET) + upOffset;
        Float3x3OpsKernelsAddress.lookAlong_unsafe(_destBase, _srcBase, _dirBase, _upBase);
        return dest;
    }

    public static java.nio.ByteBuffer lookAlong_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer dir, int dirOffset, java.nio.ByteBuffer up, int upOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        float _dirx = dir.getFloat(dirOffset + 0);
        float _diry = dir.getFloat(dirOffset + 4);
        float _dirz = dir.getFloat(dirOffset + 8);
        float _upx = up.getFloat(upOffset + 0);
        float _upy = up.getFloat(upOffset + 4);
        float _upz = up.getFloat(upOffset + 8);
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
        dest.putFloat(destOffset + 0, Math.fma(_self02, _t26, Math.fma(_self00, _t27, _self01 * _t28)));
        dest.putFloat(destOffset + 4, Math.fma(_self12, _t26, Math.fma(_self10, _t27, _self11 * _t28)));
        dest.putFloat(destOffset + 8, Math.fma(_self22, _t26, Math.fma(_self20, _t27, _self21 * _t28)));
        dest.putFloat(destOffset + 12, Math.fma(_self02, _t35, Math.fma(_self00, _t36, _self01 * _t37)));
        dest.putFloat(destOffset + 16, Math.fma(_self12, _t35, Math.fma(_self10, _t36, _self11 * _t37)));
        dest.putFloat(destOffset + 20, Math.fma(_self22, _t35, Math.fma(_self20, _t36, _self21 * _t37)));
        dest.putFloat(destOffset + 24, Math.fma(_self02, _t9, Math.fma(_self00, _t8, _self01 * _t7)));
        dest.putFloat(destOffset + 28, Math.fma(_self12, _t9, Math.fma(_self10, _t8, _self11 * _t7)));
        dest.putFloat(destOffset + 32, Math.fma(_self22, _t9, Math.fma(_self20, _t8, _self21 * _t7)));
        return dest;
    }

    public static java.nio.ByteBuffer makeFromDualQuat_unsafe(java.nio.ByteBuffer dest, int destOffset, float dqRX, float dqRY, float dqRZ, float dqRW, float dqDX, float dqDY, float dqDZ, float dqDW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Float3x3OpsKernelsAddress.makeFromDualQuat_unsafe(_destBase, dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW);
        return dest;
    }

    public static java.nio.ByteBuffer makeFromDualQuat_api(java.nio.ByteBuffer dest, int destOffset, float dqRX, float dqRY, float dqRZ, float dqRW, float dqDX, float dqDY, float dqDZ, float dqDW) {
        float _t0 = dqRY * dqRY;
        float _t2 = dqRZ * dqRW;
        float _t3 = dqRY * dqRW;
        float _t4 = dqRX * dqRX;
        float _t5 = dqRY * dqRZ;
        float _t6 = Math.fma(-2.0f, dqRZ * dqRZ, 1.0f);
        dest.putFloat(destOffset + 0, Math.fma(-2.0f, _t0, _t6));
        dest.putFloat(destOffset + 4, 2.0f * Math.fma(dqRX, dqRY, _t2));
        dest.putFloat(destOffset + 8, Math.fma(-2.0f, _t3, 2.0f * dqRX * dqRZ));
        dest.putFloat(destOffset + 12, Math.fma(-2.0f, _t2, 2.0f * dqRX * dqRY));
        dest.putFloat(destOffset + 16, Math.fma(-2.0f, _t4, _t6));
        dest.putFloat(destOffset + 20, 2.0f * Math.fma(dqRX, dqRW, _t5));
        dest.putFloat(destOffset + 24, 2.0f * Math.fma(dqRX, dqRZ, _t3));
        dest.putFloat(destOffset + 28, Math.fma(-2.0f, dqRX * dqRW, 2.0f * _t5));
        dest.putFloat(destOffset + 32, Math.fma(-2.0f, _t4, Math.fma(-2.0f, _t0, 1.0f)));
        return dest;
    }

    public static java.nio.ByteBuffer makeRotation_unsafe(java.nio.ByteBuffer dest, int destOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Float3x3OpsKernelsAddress.makeRotation_unsafe(_destBase, angle);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotation_api(java.nio.ByteBuffer dest, int destOffset, float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        dest.putFloat(destOffset + 0, _t0);
        dest.putFloat(destOffset + 4, _t1);
        dest.putFloat(destOffset + 8, 0.0f);
        dest.putFloat(destOffset + 12, -_t1);
        dest.putFloat(destOffset + 16, _t0);
        dest.putFloat(destOffset + 20, 0.0f);
        dest.putFloat(destOffset + 24, 0.0f);
        dest.putFloat(destOffset + 28, 0.0f);
        dest.putFloat(destOffset + 32, 1.0f);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationAxis_unsafe(java.nio.ByteBuffer dest, int destOffset, float angle, float axisX, float axisY, float axisZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Float3x3OpsKernelsAddress.makeRotationAxis_unsafe(_destBase, angle, axisX, axisY, axisZ);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationAxis_api(java.nio.ByteBuffer dest, int destOffset, float angle, float axisX, float axisY, float axisZ) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = 1.0f - _t0;
        float _t3 = axisX * axisY;
        float _t4 = axisX * axisZ;
        float _t5 = axisY * axisZ;
        dest.putFloat(destOffset + 0, Math.fma(_t2, axisX * axisX, _t0));
        dest.putFloat(destOffset + 4, Math.fma(axisZ, _t1, _t2 * _t3));
        dest.putFloat(destOffset + 8, Math.fma(_t2, _t4, -(axisY * _t1)));
        dest.putFloat(destOffset + 12, Math.fma(_t2, _t3, -(axisZ * _t1)));
        dest.putFloat(destOffset + 16, Math.fma(_t2, axisY * axisY, _t0));
        dest.putFloat(destOffset + 20, Math.fma(axisX, _t1, _t2 * _t5));
        dest.putFloat(destOffset + 24, Math.fma(axisY, _t1, _t2 * _t4));
        dest.putFloat(destOffset + 28, Math.fma(_t2, _t5, -(axisX * _t1)));
        dest.putFloat(destOffset + 32, Math.fma(_t2, axisZ * axisZ, _t0));
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationAxis_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer axis, int axisOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _axisBase = UnsafeOpsHolder.U.getLong(axis, UnsafeCopy.BB_ADDRESS_OFFSET) + axisOffset;
        Float3x3OpsKernelsAddress.makeRotationAxis_unsafe(_destBase, _axisBase, angle);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationAxis_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer axis, int axisOffset, float angle) {
        float _axisx = axis.getFloat(axisOffset + 0);
        float _axisy = axis.getFloat(axisOffset + 4);
        float _axisz = axis.getFloat(axisOffset + 8);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = 1.0f - _t0;
        float _t3 = _axisx * _axisy;
        float _t4 = _axisx * _axisz;
        float _t5 = _axisy * _axisz;
        dest.putFloat(destOffset + 0, Math.fma(_t2, _axisx * _axisx, _t0));
        dest.putFloat(destOffset + 4, Math.fma(_axisz, _t1, _t2 * _t3));
        dest.putFloat(destOffset + 8, Math.fma(_t2, _t4, -(_axisy * _t1)));
        dest.putFloat(destOffset + 12, Math.fma(_t2, _t3, -(_axisz * _t1)));
        dest.putFloat(destOffset + 16, Math.fma(_t2, _axisy * _axisy, _t0));
        dest.putFloat(destOffset + 20, Math.fma(_axisx, _t1, _t2 * _t5));
        dest.putFloat(destOffset + 24, Math.fma(_axisy, _t1, _t2 * _t4));
        dest.putFloat(destOffset + 28, Math.fma(_t2, _t5, -(_axisx * _t1)));
        dest.putFloat(destOffset + 32, Math.fma(_t2, _axisz * _axisz, _t0));
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationLookAlong_unsafe(java.nio.ByteBuffer dest, int destOffset, float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Float3x3OpsKernelsAddress.makeRotationLookAlong_unsafe(_destBase, dirX, dirY, dirZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationLookAlong_api(java.nio.ByteBuffer dest, int destOffset, float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
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
            _t26 = _t17 * _t22;
            _t27 = _t16 * _t22;
            _t28 = _t18 * _t22;
        } else {
            _t26 = 0.0f;
            _t27 = 0.0f;
            _t28 = 0.0f;
        }
        dest.putFloat(destOffset + 0, _t26);
        dest.putFloat(destOffset + 4, _t28);
        dest.putFloat(destOffset + 8, _t27);
        dest.putFloat(destOffset + 12, Math.fma(_t7, _t27, -(_t9 * _t28)));
        dest.putFloat(destOffset + 16, Math.fma(_t9, _t26, -(_t8 * _t27)));
        dest.putFloat(destOffset + 20, Math.fma(_t8, _t28, -(_t7 * _t26)));
        dest.putFloat(destOffset + 24, _t8);
        dest.putFloat(destOffset + 28, _t7);
        dest.putFloat(destOffset + 32, _t9);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationLookAlong_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer dir, int dirOffset, java.nio.ByteBuffer up, int upOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _dirBase = UnsafeOpsHolder.U.getLong(dir, UnsafeCopy.BB_ADDRESS_OFFSET) + dirOffset;
        long _upBase = UnsafeOpsHolder.U.getLong(up, UnsafeCopy.BB_ADDRESS_OFFSET) + upOffset;
        Float3x3OpsKernelsAddress.makeRotationLookAlong_unsafe(_destBase, _dirBase, _upBase);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationLookAlong_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer dir, int dirOffset, java.nio.ByteBuffer up, int upOffset) {
        float _dirx = dir.getFloat(dirOffset + 0);
        float _diry = dir.getFloat(dirOffset + 4);
        float _dirz = dir.getFloat(dirOffset + 8);
        float _upx = up.getFloat(upOffset + 0);
        float _upy = up.getFloat(upOffset + 4);
        float _upz = up.getFloat(upOffset + 8);
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
            _t26 = _t17 * _t22;
            _t27 = _t16 * _t22;
            _t28 = _t18 * _t22;
        } else {
            _t26 = 0.0f;
            _t27 = 0.0f;
            _t28 = 0.0f;
        }
        dest.putFloat(destOffset + 0, _t26);
        dest.putFloat(destOffset + 4, _t28);
        dest.putFloat(destOffset + 8, _t27);
        dest.putFloat(destOffset + 12, Math.fma(_t7, _t27, -(_t9 * _t28)));
        dest.putFloat(destOffset + 16, Math.fma(_t9, _t26, -(_t8 * _t27)));
        dest.putFloat(destOffset + 20, Math.fma(_t8, _t28, -(_t7 * _t26)));
        dest.putFloat(destOffset + 24, _t8);
        dest.putFloat(destOffset + 28, _t7);
        dest.putFloat(destOffset + 32, _t9);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationQuat_unsafe(java.nio.ByteBuffer dest, int destOffset, float qX, float qY, float qZ, float qW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Float3x3OpsKernelsAddress.makeRotationQuat_unsafe(_destBase, qX, qY, qZ, qW);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationQuat_api(java.nio.ByteBuffer dest, int destOffset, float qX, float qY, float qZ, float qW) {
        float _t0 = qZ * qZ;
        float _t1 = qZ * qW;
        float _t2 = qY * qW;
        dest.putFloat(destOffset + 0, Math.fma(-2.0f, Math.fma(qY, qY, _t0), 1.0f));
        dest.putFloat(destOffset + 4, 2.0f * Math.fma(qX, qY, _t1));
        dest.putFloat(destOffset + 8, 2.0f * Math.fma(qX, qZ, -_t2));
        dest.putFloat(destOffset + 12, 2.0f * Math.fma(qX, qY, -_t1));
        dest.putFloat(destOffset + 16, Math.fma(-2.0f, Math.fma(qX, qX, _t0), 1.0f));
        dest.putFloat(destOffset + 20, 2.0f * Math.fma(qX, qW, qY * qZ));
        dest.putFloat(destOffset + 24, 2.0f * Math.fma(qX, qZ, _t2));
        dest.putFloat(destOffset + 28, 2.0f * Math.fma(qY, qZ, -(qX * qW)));
        dest.putFloat(destOffset + 32, Math.fma(-2.0f, Math.fma(qX, qX, qY * qY), 1.0f));
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationQuat_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer q, int qOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _qBase = UnsafeOpsHolder.U.getLong(q, UnsafeCopy.BB_ADDRESS_OFFSET) + qOffset;
        Float3x3OpsKernelsAddress.makeRotationQuat_unsafe(_destBase, _qBase);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationQuat_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer q, int qOffset) {
        float _qx = q.getFloat(qOffset + 0);
        float _qy = q.getFloat(qOffset + 4);
        float _qz = q.getFloat(qOffset + 8);
        float _qw = q.getFloat(qOffset + 12);
        float _t0 = _qz * _qz;
        float _t1 = _qz * _qw;
        float _t2 = _qy * _qw;
        dest.putFloat(destOffset + 0, Math.fma(-2.0f, Math.fma(_qy, _qy, _t0), 1.0f));
        dest.putFloat(destOffset + 4, 2.0f * Math.fma(_qx, _qy, _t1));
        dest.putFloat(destOffset + 8, 2.0f * Math.fma(_qx, _qz, -_t2));
        dest.putFloat(destOffset + 12, 2.0f * Math.fma(_qx, _qy, -_t1));
        dest.putFloat(destOffset + 16, Math.fma(-2.0f, Math.fma(_qx, _qx, _t0), 1.0f));
        dest.putFloat(destOffset + 20, 2.0f * Math.fma(_qx, _qw, _qy * _qz));
        dest.putFloat(destOffset + 24, 2.0f * Math.fma(_qx, _qz, _t2));
        dest.putFloat(destOffset + 28, 2.0f * Math.fma(_qy, _qz, -(_qx * _qw)));
        dest.putFloat(destOffset + 32, Math.fma(-2.0f, Math.fma(_qx, _qx, _qy * _qy), 1.0f));
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationX_unsafe(java.nio.ByteBuffer dest, int destOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Float3x3OpsKernelsAddress.makeRotationX_unsafe(_destBase, angle);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationX_api(java.nio.ByteBuffer dest, int destOffset, float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        dest.putFloat(destOffset + 0, 1.0f);
        dest.putFloat(destOffset + 4, 0.0f);
        dest.putFloat(destOffset + 8, 0.0f);
        dest.putFloat(destOffset + 12, 0.0f);
        dest.putFloat(destOffset + 16, _t0);
        dest.putFloat(destOffset + 20, _t1);
        dest.putFloat(destOffset + 24, 0.0f);
        dest.putFloat(destOffset + 28, -_t1);
        dest.putFloat(destOffset + 32, _t0);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationXYZ_unsafe(java.nio.ByteBuffer dest, int destOffset, float angleX, float angleY, float angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Float3x3OpsKernelsAddress.makeRotationXYZ_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationXYZ_api(java.nio.ByteBuffer dest, int destOffset, float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleZ);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.sin(angleX);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t4 * _t3;
        float _t7 = _t3 * _t5;
        dest.putFloat(destOffset + 0, _t0 * _t1);
        dest.putFloat(destOffset + 4, Math.fma(_t6, _t1, _t2 * _t5));
        dest.putFloat(destOffset + 8, Math.fma(_t4, _t2, -(_t7 * _t1)));
        dest.putFloat(destOffset + 12, -(_t2 * _t0));
        dest.putFloat(destOffset + 16, Math.fma(_t5, _t1, -(_t6 * _t2)));
        dest.putFloat(destOffset + 20, Math.fma(_t7, _t2, _t4 * _t1));
        dest.putFloat(destOffset + 24, _t3);
        dest.putFloat(destOffset + 28, -(_t4 * _t0));
        dest.putFloat(destOffset + 32, _t5 * _t0);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationXZY_unsafe(java.nio.ByteBuffer dest, int destOffset, float angleX, float angleY, float angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Float3x3OpsKernelsAddress.makeRotationXZY_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationXZY_api(java.nio.ByteBuffer dest, int destOffset, float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleZ);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.cos(angleX);
        float _t5 = (float) Math.sin(angleX);
        float _t6 = _t2 * _t4;
        float _t7 = _t5 * _t2;
        dest.putFloat(destOffset + 0, _t0 * _t1);
        dest.putFloat(destOffset + 4, Math.fma(_t6, _t0, _t5 * _t3));
        dest.putFloat(destOffset + 8, Math.fma(_t7, _t0, -(_t3 * _t4)));
        dest.putFloat(destOffset + 12, -_t2);
        dest.putFloat(destOffset + 16, _t4 * _t1);
        dest.putFloat(destOffset + 20, _t5 * _t1);
        dest.putFloat(destOffset + 24, _t3 * _t1);
        dest.putFloat(destOffset + 28, Math.fma(_t6, _t3, -(_t5 * _t0)));
        dest.putFloat(destOffset + 32, Math.fma(_t7, _t3, _t4 * _t0));
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationY_unsafe(java.nio.ByteBuffer dest, int destOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Float3x3OpsKernelsAddress.makeRotationY_unsafe(_destBase, angle);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationY_api(java.nio.ByteBuffer dest, int destOffset, float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        dest.putFloat(destOffset + 0, _t0);
        dest.putFloat(destOffset + 4, 0.0f);
        dest.putFloat(destOffset + 8, -_t1);
        dest.putFloat(destOffset + 12, 0.0f);
        dest.putFloat(destOffset + 16, 1.0f);
        dest.putFloat(destOffset + 20, 0.0f);
        dest.putFloat(destOffset + 24, _t1);
        dest.putFloat(destOffset + 28, 0.0f);
        dest.putFloat(destOffset + 32, _t0);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationYXZ_unsafe(java.nio.ByteBuffer dest, int destOffset, float angleX, float angleY, float angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Float3x3OpsKernelsAddress.makeRotationYXZ_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationYXZ_api(java.nio.ByteBuffer dest, int destOffset, float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.sin(angleX);
        float _t1 = (float) Math.sin(angleY);
        float _t2 = (float) Math.sin(angleZ);
        float _t3 = (float) Math.cos(angleY);
        float _t4 = (float) Math.cos(angleZ);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t0 * _t1;
        float _t7 = _t0 * _t3;
        dest.putFloat(destOffset + 0, Math.fma(_t6, _t2, _t3 * _t4));
        dest.putFloat(destOffset + 4, _t2 * _t5);
        dest.putFloat(destOffset + 8, Math.fma(_t7, _t2, -(_t1 * _t4)));
        dest.putFloat(destOffset + 12, Math.fma(_t6, _t4, -(_t2 * _t3)));
        dest.putFloat(destOffset + 16, _t5 * _t4);
        dest.putFloat(destOffset + 20, Math.fma(_t7, _t4, _t1 * _t2));
        dest.putFloat(destOffset + 24, _t1 * _t5);
        dest.putFloat(destOffset + 28, -_t0);
        dest.putFloat(destOffset + 32, _t5 * _t3);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationYZX_unsafe(java.nio.ByteBuffer dest, int destOffset, float angleX, float angleY, float angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Float3x3OpsKernelsAddress.makeRotationYZX_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationYZX_api(java.nio.ByteBuffer dest, int destOffset, float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleX);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.sin(angleZ);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t4 * _t0;
        float _t7 = _t3 * _t4;
        dest.putFloat(destOffset + 0, _t0 * _t1);
        dest.putFloat(destOffset + 4, _t4);
        dest.putFloat(destOffset + 8, -(_t3 * _t1));
        dest.putFloat(destOffset + 12, Math.fma(_t2, _t3, -(_t6 * _t5)));
        dest.putFloat(destOffset + 16, _t5 * _t1);
        dest.putFloat(destOffset + 20, Math.fma(_t7, _t5, _t2 * _t0));
        dest.putFloat(destOffset + 24, Math.fma(_t6, _t2, _t3 * _t5));
        dest.putFloat(destOffset + 28, -(_t2 * _t1));
        dest.putFloat(destOffset + 32, Math.fma(_t5, _t0, -(_t7 * _t2)));
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationZXY_unsafe(java.nio.ByteBuffer dest, int destOffset, float angleX, float angleY, float angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Float3x3OpsKernelsAddress.makeRotationZXY_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationZXY_api(java.nio.ByteBuffer dest, int destOffset, float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleX);
        float _t3 = (float) Math.sin(angleZ);
        float _t4 = (float) Math.sin(angleY);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t2 * _t3;
        float _t7 = _t2 * _t1;
        dest.putFloat(destOffset + 0, Math.fma(_t0, _t1, -(_t6 * _t4)));
        dest.putFloat(destOffset + 4, Math.fma(_t7, _t4, _t3 * _t0));
        dest.putFloat(destOffset + 8, -(_t4 * _t5));
        dest.putFloat(destOffset + 12, -(_t3 * _t5));
        dest.putFloat(destOffset + 16, _t5 * _t1);
        dest.putFloat(destOffset + 20, _t2);
        dest.putFloat(destOffset + 24, Math.fma(_t6, _t0, _t4 * _t1));
        dest.putFloat(destOffset + 28, Math.fma(_t4, _t3, -(_t7 * _t0)));
        dest.putFloat(destOffset + 32, _t5 * _t0);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationZYX_unsafe(java.nio.ByteBuffer dest, int destOffset, float angleX, float angleY, float angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Float3x3OpsKernelsAddress.makeRotationZYX_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationZYX_api(java.nio.ByteBuffer dest, int destOffset, float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleY);
        float _t3 = (float) Math.sin(angleX);
        float _t4 = (float) Math.sin(angleZ);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t2 * _t1;
        float _t7 = _t2 * _t4;
        dest.putFloat(destOffset + 0, _t0 * _t1);
        dest.putFloat(destOffset + 4, _t4 * _t0);
        dest.putFloat(destOffset + 8, -_t2);
        dest.putFloat(destOffset + 12, Math.fma(_t6, _t3, -(_t4 * _t5)));
        dest.putFloat(destOffset + 16, Math.fma(_t7, _t3, _t5 * _t1));
        dest.putFloat(destOffset + 20, _t3 * _t0);
        dest.putFloat(destOffset + 24, Math.fma(_t6, _t5, _t3 * _t4));
        dest.putFloat(destOffset + 28, Math.fma(_t7, _t5, -(_t3 * _t1)));
        dest.putFloat(destOffset + 32, _t5 * _t0);
        return dest;
    }

    public static java.nio.ByteBuffer makeScaling_unsafe(java.nio.ByteBuffer dest, int destOffset, float vX, float vY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Float3x3OpsKernelsAddress.makeScaling_unsafe(_destBase, vX, vY);
        return dest;
    }

    public static java.nio.ByteBuffer makeScaling_api(java.nio.ByteBuffer dest, int destOffset, float vX, float vY) {
        dest.putFloat(destOffset + 0, vX);
        dest.putFloat(destOffset + 4, 0.0f);
        dest.putFloat(destOffset + 8, 0.0f);
        dest.putFloat(destOffset + 12, 0.0f);
        dest.putFloat(destOffset + 16, vY);
        dest.putFloat(destOffset + 20, 0.0f);
        dest.putFloat(destOffset + 24, 0.0f);
        dest.putFloat(destOffset + 28, 0.0f);
        dest.putFloat(destOffset + 32, 1.0f);
        return dest;
    }

    public static java.nio.ByteBuffer makeScaling_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + vOffset;
        Float3x3OpsKernelsAddress.makeScaling_unsafe(_destBase, _vBase);
        return dest;
    }

    public static java.nio.ByteBuffer makeScaling_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer v, int vOffset) {
        float _vx = v.getFloat(vOffset + 0);
        float _vy = v.getFloat(vOffset + 4);
        dest.putFloat(destOffset + 0, _vx);
        dest.putFloat(destOffset + 4, 0.0f);
        dest.putFloat(destOffset + 8, 0.0f);
        dest.putFloat(destOffset + 12, 0.0f);
        dest.putFloat(destOffset + 16, _vy);
        dest.putFloat(destOffset + 20, 0.0f);
        dest.putFloat(destOffset + 24, 0.0f);
        dest.putFloat(destOffset + 28, 0.0f);
        dest.putFloat(destOffset + 32, 1.0f);
        return dest;
    }

    public static java.nio.ByteBuffer makeScaling_unsafe(java.nio.ByteBuffer dest, int destOffset, float s) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Float3x3OpsKernelsAddress.makeScaling_unsafe(_destBase, s);
        return dest;
    }

    public static java.nio.ByteBuffer makeScaling_api(java.nio.ByteBuffer dest, int destOffset, float s) {
        dest.putFloat(destOffset + 0, s);
        dest.putFloat(destOffset + 4, 0.0f);
        dest.putFloat(destOffset + 8, 0.0f);
        dest.putFloat(destOffset + 12, 0.0f);
        dest.putFloat(destOffset + 16, s);
        dest.putFloat(destOffset + 20, 0.0f);
        dest.putFloat(destOffset + 24, 0.0f);
        dest.putFloat(destOffset + 28, 0.0f);
        dest.putFloat(destOffset + 32, 1.0f);
        return dest;
    }

    public static java.nio.ByteBuffer makeTranslation_unsafe(java.nio.ByteBuffer dest, int destOffset, float vX, float vY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Float3x3OpsKernelsAddress.makeTranslation_unsafe(_destBase, vX, vY);
        return dest;
    }

    public static java.nio.ByteBuffer makeTranslation_api(java.nio.ByteBuffer dest, int destOffset, float vX, float vY) {
        dest.putFloat(destOffset + 0, 1.0f);
        dest.putFloat(destOffset + 4, 0.0f);
        dest.putFloat(destOffset + 8, 0.0f);
        dest.putFloat(destOffset + 12, 0.0f);
        dest.putFloat(destOffset + 16, 1.0f);
        dest.putFloat(destOffset + 20, 0.0f);
        dest.putFloat(destOffset + 24, vX);
        dest.putFloat(destOffset + 28, vY);
        dest.putFloat(destOffset + 32, 1.0f);
        return dest;
    }

    public static java.nio.ByteBuffer makeTranslation_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + vOffset;
        Float3x3OpsKernelsAddress.makeTranslation_unsafe(_destBase, _vBase);
        return dest;
    }

    public static java.nio.ByteBuffer makeTranslation_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer v, int vOffset) {
        float _vx = v.getFloat(vOffset + 0);
        float _vy = v.getFloat(vOffset + 4);
        dest.putFloat(destOffset + 0, 1.0f);
        dest.putFloat(destOffset + 4, 0.0f);
        dest.putFloat(destOffset + 8, 0.0f);
        dest.putFloat(destOffset + 12, 0.0f);
        dest.putFloat(destOffset + 16, 1.0f);
        dest.putFloat(destOffset + 20, 0.0f);
        dest.putFloat(destOffset + 24, _vx);
        dest.putFloat(destOffset + 28, _vy);
        dest.putFloat(destOffset + 32, 1.0f);
        return dest;
    }

    public static java.nio.ByteBuffer makeView_unsafe(java.nio.ByteBuffer dest, int destOffset, float left, float right, float bottom, float top) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Float3x3OpsKernelsAddress.makeView_unsafe(_destBase, left, right, bottom, top);
        return dest;
    }

    public static java.nio.ByteBuffer makeView_api(java.nio.ByteBuffer dest, int destOffset, float left, float right, float bottom, float top) {
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        dest.putFloat(destOffset + 0, 2.0f * _t0_inv);
        dest.putFloat(destOffset + 4, 0.0f);
        dest.putFloat(destOffset + 8, 0.0f);
        dest.putFloat(destOffset + 12, 0.0f);
        dest.putFloat(destOffset + 16, 2.0f * _t1_inv);
        dest.putFloat(destOffset + 20, 0.0f);
        dest.putFloat(destOffset + 24, -((left + right) * _t0_inv));
        dest.putFloat(destOffset + 28, -((bottom + top) * _t1_inv));
        dest.putFloat(destOffset + 32, 1.0f);
        return dest;
    }

    public static java.nio.ByteBuffer preRotate_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.preRotate_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.ByteBuffer preRotate_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float angle) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        dest.putFloat(destOffset + 0, Math.fma(_self00, _t0, -(_self10 * _t1)));
        dest.putFloat(destOffset + 4, Math.fma(_self00, _t1, _self10 * _t0));
        dest.putFloat(destOffset + 8, _self20);
        dest.putFloat(destOffset + 12, Math.fma(_self01, _t0, -(_self11 * _t1)));
        dest.putFloat(destOffset + 16, Math.fma(_self01, _t1, _self11 * _t0));
        dest.putFloat(destOffset + 20, _self21);
        dest.putFloat(destOffset + 24, Math.fma(_self02, _t0, -(_self12 * _t1)));
        dest.putFloat(destOffset + 28, Math.fma(_self02, _t1, _self12 * _t0));
        dest.putFloat(destOffset + 32, _self22);
        return dest;
    }

    public static java.nio.ByteBuffer preRotateAround_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float angle, float pivotX, float pivotY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.preRotateAround_unsafe(_destBase, _srcBase, angle, pivotX, pivotY);
        return dest;
    }

    public static java.nio.ByteBuffer preRotateAround_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float angle, float pivotX, float pivotY) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        float _t0 = (float) Math.sin(angle);
        float _t1 = (float) Math.cos(angle);
        float _t2 = -pivotX;
        float _t6 = Math.fma(pivotY, _t0, Math.fma(_t2, _t1, pivotX));
        float _t7 = Math.fma(_t2, _t0, Math.fma(-pivotY, _t1, pivotY));
        dest.putFloat(destOffset + 0, Math.fma(_self20, _t6, Math.fma(_self00, _t1, -(_self10 * _t0))));
        dest.putFloat(destOffset + 4, Math.fma(_self20, _t7, Math.fma(_self00, _t0, _self10 * _t1)));
        dest.putFloat(destOffset + 8, _self20);
        dest.putFloat(destOffset + 12, Math.fma(_self21, _t6, Math.fma(_self01, _t1, -(_self11 * _t0))));
        dest.putFloat(destOffset + 16, Math.fma(_self21, _t7, Math.fma(_self01, _t0, _self11 * _t1)));
        dest.putFloat(destOffset + 20, _self21);
        dest.putFloat(destOffset + 24, Math.fma(_self22, _t6, Math.fma(_self02, _t1, -(_self12 * _t0))));
        dest.putFloat(destOffset + 28, Math.fma(_self22, _t7, Math.fma(_self02, _t0, _self12 * _t1)));
        dest.putFloat(destOffset + 32, _self22);
        return dest;
    }

    public static java.nio.ByteBuffer preRotateAround_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer pivot, int pivotOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _pivotBase = UnsafeOpsHolder.U.getLong(pivot, UnsafeCopy.BB_ADDRESS_OFFSET) + pivotOffset;
        Float3x3OpsKernelsAddress.preRotateAround_unsafe(_destBase, _srcBase, _pivotBase, angle);
        return dest;
    }

    public static java.nio.ByteBuffer preRotateAround_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer pivot, int pivotOffset, float angle) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        float _pivotx = pivot.getFloat(pivotOffset + 0);
        float _pivoty = pivot.getFloat(pivotOffset + 4);
        float _t0 = (float) Math.sin(angle);
        float _t1 = (float) Math.cos(angle);
        float _t2 = -_pivotx;
        float _t6 = Math.fma(_pivoty, _t0, Math.fma(_t2, _t1, _pivotx));
        float _t7 = Math.fma(_t2, _t0, Math.fma(-_pivoty, _t1, _pivoty));
        dest.putFloat(destOffset + 0, Math.fma(_self20, _t6, Math.fma(_self00, _t1, -(_self10 * _t0))));
        dest.putFloat(destOffset + 4, Math.fma(_self20, _t7, Math.fma(_self00, _t0, _self10 * _t1)));
        dest.putFloat(destOffset + 8, _self20);
        dest.putFloat(destOffset + 12, Math.fma(_self21, _t6, Math.fma(_self01, _t1, -(_self11 * _t0))));
        dest.putFloat(destOffset + 16, Math.fma(_self21, _t7, Math.fma(_self01, _t0, _self11 * _t1)));
        dest.putFloat(destOffset + 20, _self21);
        dest.putFloat(destOffset + 24, Math.fma(_self22, _t6, Math.fma(_self02, _t1, -(_self12 * _t0))));
        dest.putFloat(destOffset + 28, Math.fma(_self22, _t7, Math.fma(_self02, _t0, _self12 * _t1)));
        dest.putFloat(destOffset + 32, _self22);
        return dest;
    }

    public static java.nio.ByteBuffer preRotateAxis_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float angle, float axisX, float axisY, float axisZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.preRotateAxis_unsafe(_destBase, _srcBase, angle, axisX, axisY, axisZ);
        return dest;
    }

    public static java.nio.ByteBuffer preRotateAxis_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float angle, float axisX, float axisY, float axisZ) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        float _t0 = (float) Math.sin(angle);
        float _t1 = (float) Math.cos(angle);
        float _t2 = 1.0f - _t1;
        float _t3 = axisX * axisZ;
        float _t5 = axisX * axisY;
        float _t7 = axisY * axisZ;
        float _t18 = Math.fma(_t2, axisX * axisX, _t1);
        float _t19 = Math.fma(_t2, axisY * axisY, _t1);
        float _t20 = Math.fma(_t2, axisZ * axisZ, _t1);
        float _t21 = Math.fma(axisY, _t0, _t2 * _t3);
        float _t22 = Math.fma(axisZ, _t0, _t2 * _t5);
        float _t23 = Math.fma(axisX, _t0, _t2 * _t7);
        float _t24 = Math.fma(_t2, _t5, -(axisZ * _t0));
        float _t25 = Math.fma(_t2, _t7, -(axisX * _t0));
        float _t26 = Math.fma(_t2, _t3, -(axisY * _t0));
        dest.putFloat(destOffset + 0, Math.fma(_self20, _t21, Math.fma(_self00, _t18, _self10 * _t24)));
        dest.putFloat(destOffset + 4, Math.fma(_self20, _t25, Math.fma(_self00, _t22, _self10 * _t19)));
        dest.putFloat(destOffset + 8, Math.fma(_self20, _t20, Math.fma(_self00, _t26, _self10 * _t23)));
        dest.putFloat(destOffset + 12, Math.fma(_self21, _t21, Math.fma(_self01, _t18, _self11 * _t24)));
        dest.putFloat(destOffset + 16, Math.fma(_self21, _t25, Math.fma(_self01, _t22, _self11 * _t19)));
        dest.putFloat(destOffset + 20, Math.fma(_self21, _t20, Math.fma(_self01, _t26, _self11 * _t23)));
        dest.putFloat(destOffset + 24, Math.fma(_self22, _t21, Math.fma(_self02, _t18, _self12 * _t24)));
        dest.putFloat(destOffset + 28, Math.fma(_self22, _t25, Math.fma(_self02, _t22, _self12 * _t19)));
        dest.putFloat(destOffset + 32, Math.fma(_self22, _t20, Math.fma(_self02, _t26, _self12 * _t23)));
        return dest;
    }

    public static java.nio.ByteBuffer preRotateAxis_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer axis, int axisOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _axisBase = UnsafeOpsHolder.U.getLong(axis, UnsafeCopy.BB_ADDRESS_OFFSET) + axisOffset;
        Float3x3OpsKernelsAddress.preRotateAxis_unsafe(_destBase, _srcBase, _axisBase, angle);
        return dest;
    }

    public static java.nio.ByteBuffer preRotateAxis_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer axis, int axisOffset, float angle) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        float _axisx = axis.getFloat(axisOffset + 0);
        float _axisy = axis.getFloat(axisOffset + 4);
        float _axisz = axis.getFloat(axisOffset + 8);
        float _t0 = (float) Math.sin(angle);
        float _t1 = (float) Math.cos(angle);
        float _t2 = 1.0f - _t1;
        float _t3 = _axisx * _axisz;
        float _t5 = _axisx * _axisy;
        float _t7 = _axisy * _axisz;
        float _t18 = Math.fma(_t2, _axisx * _axisx, _t1);
        float _t19 = Math.fma(_t2, _axisy * _axisy, _t1);
        float _t20 = Math.fma(_t2, _axisz * _axisz, _t1);
        float _t21 = Math.fma(_axisy, _t0, _t2 * _t3);
        float _t22 = Math.fma(_axisz, _t0, _t2 * _t5);
        float _t23 = Math.fma(_axisx, _t0, _t2 * _t7);
        float _t24 = Math.fma(_t2, _t5, -(_axisz * _t0));
        float _t25 = Math.fma(_t2, _t7, -(_axisx * _t0));
        float _t26 = Math.fma(_t2, _t3, -(_axisy * _t0));
        dest.putFloat(destOffset + 0, Math.fma(_self20, _t21, Math.fma(_self00, _t18, _self10 * _t24)));
        dest.putFloat(destOffset + 4, Math.fma(_self20, _t25, Math.fma(_self00, _t22, _self10 * _t19)));
        dest.putFloat(destOffset + 8, Math.fma(_self20, _t20, Math.fma(_self00, _t26, _self10 * _t23)));
        dest.putFloat(destOffset + 12, Math.fma(_self21, _t21, Math.fma(_self01, _t18, _self11 * _t24)));
        dest.putFloat(destOffset + 16, Math.fma(_self21, _t25, Math.fma(_self01, _t22, _self11 * _t19)));
        dest.putFloat(destOffset + 20, Math.fma(_self21, _t20, Math.fma(_self01, _t26, _self11 * _t23)));
        dest.putFloat(destOffset + 24, Math.fma(_self22, _t21, Math.fma(_self02, _t18, _self12 * _t24)));
        dest.putFloat(destOffset + 28, Math.fma(_self22, _t25, Math.fma(_self02, _t22, _self12 * _t19)));
        dest.putFloat(destOffset + 32, Math.fma(_self22, _t20, Math.fma(_self02, _t26, _self12 * _t23)));
        return dest;
    }

    public static java.nio.ByteBuffer preRotateX_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.preRotateX_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.ByteBuffer preRotateX_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float angle) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        dest.putFloat(destOffset + 0, _self00);
        dest.putFloat(destOffset + 4, Math.fma(_self10, _t0, -(_self20 * _t1)));
        dest.putFloat(destOffset + 8, Math.fma(_self10, _t1, _self20 * _t0));
        dest.putFloat(destOffset + 12, _self01);
        dest.putFloat(destOffset + 16, Math.fma(_self11, _t0, -(_self21 * _t1)));
        dest.putFloat(destOffset + 20, Math.fma(_self11, _t1, _self21 * _t0));
        dest.putFloat(destOffset + 24, _self02);
        dest.putFloat(destOffset + 28, Math.fma(_self12, _t0, -(_self22 * _t1)));
        dest.putFloat(destOffset + 32, Math.fma(_self12, _t1, _self22 * _t0));
        return dest;
    }

    public static java.nio.ByteBuffer preRotateY_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.preRotateY_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.ByteBuffer preRotateY_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float angle) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        dest.putFloat(destOffset + 0, Math.fma(_self00, _t0, _self20 * _t1));
        dest.putFloat(destOffset + 4, _self10);
        dest.putFloat(destOffset + 8, Math.fma(_self20, _t0, -(_self00 * _t1)));
        dest.putFloat(destOffset + 12, Math.fma(_self01, _t0, _self21 * _t1));
        dest.putFloat(destOffset + 16, _self11);
        dest.putFloat(destOffset + 20, Math.fma(_self21, _t0, -(_self01 * _t1)));
        dest.putFloat(destOffset + 24, Math.fma(_self02, _t0, _self22 * _t1));
        dest.putFloat(destOffset + 28, _self12);
        dest.putFloat(destOffset + 32, Math.fma(_self22, _t0, -(_self02 * _t1)));
        return dest;
    }

    public static java.nio.ByteBuffer preScale_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float vX, float vY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.preScale_unsafe(_destBase, _srcBase, vX, vY);
        return dest;
    }

    public static java.nio.ByteBuffer preScale_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float vX, float vY) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 3;
            float _eself0 = src.getFloat(srcOffset + _lo * 4);
            float _eself1 = src.getFloat(srcOffset + (_lo + 1) * 4);
            float _eself2 = src.getFloat(srcOffset + (_lo + 2) * 4);
            dest.putFloat(destOffset + _lo * 4, _eself0 * vX);
            dest.putFloat(destOffset + (_lo + 1) * 4, _eself1 * vY);
            dest.putFloat(destOffset + (_lo + 2) * 4, _eself2);
        }
        return dest;
    }

    public static java.nio.ByteBuffer preScale_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + vOffset;
        Float3x3OpsKernelsAddress.preScale_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.ByteBuffer preScale_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer v, int vOffset) {
        float _vx = v.getFloat(vOffset + 0);
        float _vy = v.getFloat(vOffset + 4);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 3;
            float _eself0 = src.getFloat(srcOffset + _lo * 4);
            float _eself1 = src.getFloat(srcOffset + (_lo + 1) * 4);
            float _eself2 = src.getFloat(srcOffset + (_lo + 2) * 4);
            dest.putFloat(destOffset + _lo * 4, _eself0 * _vx);
            dest.putFloat(destOffset + (_lo + 1) * 4, _eself1 * _vy);
            dest.putFloat(destOffset + (_lo + 2) * 4, _eself2);
        }
        return dest;
    }

    public static java.nio.ByteBuffer preScale_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float s) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.preScale_unsafe(_destBase, _srcBase, s);
        return dest;
    }

    public static java.nio.ByteBuffer preScale_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float s) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 3;
            float _eself0 = src.getFloat(srcOffset + _lo * 4);
            float _eself1 = src.getFloat(srcOffset + (_lo + 1) * 4);
            float _eself2 = src.getFloat(srcOffset + (_lo + 2) * 4);
            dest.putFloat(destOffset + _lo * 4, s * _eself0);
            dest.putFloat(destOffset + (_lo + 1) * 4, s * _eself1);
            dest.putFloat(destOffset + (_lo + 2) * 4, _eself2);
        }
        return dest;
    }

    public static java.nio.ByteBuffer preScaleAround_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float s, float pivotX, float pivotY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.preScaleAround_unsafe(_destBase, _srcBase, s, pivotX, pivotY);
        return dest;
    }

    public static java.nio.ByteBuffer preScaleAround_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float s, float pivotX, float pivotY) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        float _t0 = Math.fma(-s, pivotX, pivotX);
        float _t1 = Math.fma(-s, pivotY, pivotY);
        dest.putFloat(destOffset + 0, Math.fma(s, _self00, _self20 * _t0));
        dest.putFloat(destOffset + 4, Math.fma(s, _self10, _self20 * _t1));
        dest.putFloat(destOffset + 8, _self20);
        dest.putFloat(destOffset + 12, Math.fma(s, _self01, _self21 * _t0));
        dest.putFloat(destOffset + 16, Math.fma(s, _self11, _self21 * _t1));
        dest.putFloat(destOffset + 20, _self21);
        dest.putFloat(destOffset + 24, Math.fma(s, _self02, _self22 * _t0));
        dest.putFloat(destOffset + 28, Math.fma(s, _self12, _self22 * _t1));
        dest.putFloat(destOffset + 32, _self22);
        return dest;
    }

    public static java.nio.ByteBuffer preScaleAround_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer pivot, int pivotOffset, float s) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _pivotBase = UnsafeOpsHolder.U.getLong(pivot, UnsafeCopy.BB_ADDRESS_OFFSET) + pivotOffset;
        Float3x3OpsKernelsAddress.preScaleAround_unsafe(_destBase, _srcBase, _pivotBase, s);
        return dest;
    }

    public static java.nio.ByteBuffer preScaleAround_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer pivot, int pivotOffset, float s) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        float _pivotx = pivot.getFloat(pivotOffset + 0);
        float _pivoty = pivot.getFloat(pivotOffset + 4);
        float _t0 = Math.fma(-s, _pivotx, _pivotx);
        float _t1 = Math.fma(-s, _pivoty, _pivoty);
        dest.putFloat(destOffset + 0, Math.fma(s, _self00, _self20 * _t0));
        dest.putFloat(destOffset + 4, Math.fma(s, _self10, _self20 * _t1));
        dest.putFloat(destOffset + 8, _self20);
        dest.putFloat(destOffset + 12, Math.fma(s, _self01, _self21 * _t0));
        dest.putFloat(destOffset + 16, Math.fma(s, _self11, _self21 * _t1));
        dest.putFloat(destOffset + 20, _self21);
        dest.putFloat(destOffset + 24, Math.fma(s, _self02, _self22 * _t0));
        dest.putFloat(destOffset + 28, Math.fma(s, _self12, _self22 * _t1));
        dest.putFloat(destOffset + 32, _self22);
        return dest;
    }

    public static java.nio.ByteBuffer preScaleAround_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float sX, float sY, float pivotX, float pivotY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.preScaleAround_unsafe(_destBase, _srcBase, sX, sY, pivotX, pivotY);
        return dest;
    }

    public static java.nio.ByteBuffer preScaleAround_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float sX, float sY, float pivotX, float pivotY) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        float _t2 = Math.fma(-pivotX, sX, pivotX);
        float _t3 = Math.fma(-pivotY, sY, pivotY);
        dest.putFloat(destOffset + 0, Math.fma(sX, _self00, _self20 * _t2));
        dest.putFloat(destOffset + 4, Math.fma(sY, _self10, _self20 * _t3));
        dest.putFloat(destOffset + 8, _self20);
        dest.putFloat(destOffset + 12, Math.fma(sX, _self01, _self21 * _t2));
        dest.putFloat(destOffset + 16, Math.fma(sY, _self11, _self21 * _t3));
        dest.putFloat(destOffset + 20, _self21);
        dest.putFloat(destOffset + 24, Math.fma(sX, _self02, _self22 * _t2));
        dest.putFloat(destOffset + 28, Math.fma(sY, _self12, _self22 * _t3));
        dest.putFloat(destOffset + 32, _self22);
        return dest;
    }

    public static java.nio.ByteBuffer preScaleAround_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer s, int sOffset, java.nio.ByteBuffer pivot, int pivotOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _sBase = UnsafeOpsHolder.U.getLong(s, UnsafeCopy.BB_ADDRESS_OFFSET) + sOffset;
        long _pivotBase = UnsafeOpsHolder.U.getLong(pivot, UnsafeCopy.BB_ADDRESS_OFFSET) + pivotOffset;
        Float3x3OpsKernelsAddress.preScaleAround_unsafe(_destBase, _srcBase, _sBase, _pivotBase);
        return dest;
    }

    public static java.nio.ByteBuffer preScaleAround_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer s, int sOffset, java.nio.ByteBuffer pivot, int pivotOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        float _sx = s.getFloat(sOffset + 0);
        float _sy = s.getFloat(sOffset + 4);
        float _pivotx = pivot.getFloat(pivotOffset + 0);
        float _pivoty = pivot.getFloat(pivotOffset + 4);
        float _t2 = Math.fma(-_pivotx, _sx, _pivotx);
        float _t3 = Math.fma(-_pivoty, _sy, _pivoty);
        dest.putFloat(destOffset + 0, Math.fma(_sx, _self00, _self20 * _t2));
        dest.putFloat(destOffset + 4, Math.fma(_sy, _self10, _self20 * _t3));
        dest.putFloat(destOffset + 8, _self20);
        dest.putFloat(destOffset + 12, Math.fma(_sx, _self01, _self21 * _t2));
        dest.putFloat(destOffset + 16, Math.fma(_sy, _self11, _self21 * _t3));
        dest.putFloat(destOffset + 20, _self21);
        dest.putFloat(destOffset + 24, Math.fma(_sx, _self02, _self22 * _t2));
        dest.putFloat(destOffset + 28, Math.fma(_sy, _self12, _self22 * _t3));
        dest.putFloat(destOffset + 32, _self22);
        return dest;
    }

    public static java.nio.ByteBuffer preTranslate_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float vX, float vY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.preTranslate_unsafe(_destBase, _srcBase, vX, vY);
        return dest;
    }

    public static java.nio.ByteBuffer preTranslate_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float vX, float vY) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 3;
            float _eself0 = src.getFloat(srcOffset + _lo * 4);
            float _eself1 = src.getFloat(srcOffset + (_lo + 1) * 4);
            float _eself2 = src.getFloat(srcOffset + (_lo + 2) * 4);
            dest.putFloat(destOffset + _lo * 4, Math.fma(_eself2, vX, _eself0));
            dest.putFloat(destOffset + (_lo + 1) * 4, Math.fma(_eself2, vY, _eself1));
            dest.putFloat(destOffset + (_lo + 2) * 4, _eself2);
        }
        return dest;
    }

    public static java.nio.ByteBuffer preTranslate_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + vOffset;
        Float3x3OpsKernelsAddress.preTranslate_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.ByteBuffer preTranslate_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer v, int vOffset) {
        float _vx = v.getFloat(vOffset + 0);
        float _vy = v.getFloat(vOffset + 4);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 3;
            float _eself0 = src.getFloat(srcOffset + _lo * 4);
            float _eself1 = src.getFloat(srcOffset + (_lo + 1) * 4);
            float _eself2 = src.getFloat(srcOffset + (_lo + 2) * 4);
            dest.putFloat(destOffset + _lo * 4, Math.fma(_eself2, _vx, _eself0));
            dest.putFloat(destOffset + (_lo + 1) * 4, Math.fma(_eself2, _vy, _eself1));
            dest.putFloat(destOffset + (_lo + 2) * 4, _eself2);
        }
        return dest;
    }

    public static java.nio.ByteBuffer rotate_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.rotate_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.ByteBuffer rotate_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float angle) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        dest.putFloat(destOffset + 0, Math.fma(_self00, _t0, _self01 * _t1));
        dest.putFloat(destOffset + 4, Math.fma(_self10, _t0, _self11 * _t1));
        dest.putFloat(destOffset + 8, Math.fma(_self20, _t0, _self21 * _t1));
        dest.putFloat(destOffset + 12, Math.fma(_self01, _t0, -(_self00 * _t1)));
        dest.putFloat(destOffset + 16, Math.fma(_self11, _t0, -(_self10 * _t1)));
        dest.putFloat(destOffset + 20, Math.fma(_self21, _t0, -(_self20 * _t1)));
        dest.putFloat(destOffset + 24, _self02);
        dest.putFloat(destOffset + 28, _self12);
        dest.putFloat(destOffset + 32, _self22);
        return dest;
    }

    public static java.nio.ByteBuffer rotateAround_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float angle, float pivotX, float pivotY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.rotateAround_unsafe(_destBase, _srcBase, angle, pivotX, pivotY);
        return dest;
    }

    public static java.nio.ByteBuffer rotateAround_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float angle, float pivotX, float pivotY) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = -pivotX;
        float _t6 = Math.fma(pivotY, _t1, Math.fma(_t2, _t0, pivotX));
        float _t7 = Math.fma(_t2, _t1, Math.fma(-pivotY, _t0, pivotY));
        dest.putFloat(destOffset + 0, Math.fma(_self00, _t0, _self01 * _t1));
        dest.putFloat(destOffset + 4, Math.fma(_self10, _t0, _self11 * _t1));
        dest.putFloat(destOffset + 8, Math.fma(_self20, _t0, _self21 * _t1));
        dest.putFloat(destOffset + 12, Math.fma(_self01, _t0, -(_self00 * _t1)));
        dest.putFloat(destOffset + 16, Math.fma(_self11, _t0, -(_self10 * _t1)));
        dest.putFloat(destOffset + 20, Math.fma(_self21, _t0, -(_self20 * _t1)));
        dest.putFloat(destOffset + 24, Math.fma(_self00, _t6, Math.fma(_self01, _t7, _self02)));
        dest.putFloat(destOffset + 28, Math.fma(_self10, _t6, Math.fma(_self11, _t7, _self12)));
        dest.putFloat(destOffset + 32, Math.fma(_self20, _t6, Math.fma(_self21, _t7, _self22)));
        return dest;
    }

    public static java.nio.ByteBuffer rotateAround_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer pivot, int pivotOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _pivotBase = UnsafeOpsHolder.U.getLong(pivot, UnsafeCopy.BB_ADDRESS_OFFSET) + pivotOffset;
        Float3x3OpsKernelsAddress.rotateAround_unsafe(_destBase, _srcBase, _pivotBase, angle);
        return dest;
    }

    public static java.nio.ByteBuffer rotateAround_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer pivot, int pivotOffset, float angle) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        float _pivotx = pivot.getFloat(pivotOffset + 0);
        float _pivoty = pivot.getFloat(pivotOffset + 4);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = -_pivotx;
        float _t6 = Math.fma(_pivoty, _t1, Math.fma(_t2, _t0, _pivotx));
        float _t7 = Math.fma(_t2, _t1, Math.fma(-_pivoty, _t0, _pivoty));
        dest.putFloat(destOffset + 0, Math.fma(_self00, _t0, _self01 * _t1));
        dest.putFloat(destOffset + 4, Math.fma(_self10, _t0, _self11 * _t1));
        dest.putFloat(destOffset + 8, Math.fma(_self20, _t0, _self21 * _t1));
        dest.putFloat(destOffset + 12, Math.fma(_self01, _t0, -(_self00 * _t1)));
        dest.putFloat(destOffset + 16, Math.fma(_self11, _t0, -(_self10 * _t1)));
        dest.putFloat(destOffset + 20, Math.fma(_self21, _t0, -(_self20 * _t1)));
        dest.putFloat(destOffset + 24, Math.fma(_self00, _t6, Math.fma(_self01, _t7, _self02)));
        dest.putFloat(destOffset + 28, Math.fma(_self10, _t6, Math.fma(_self11, _t7, _self12)));
        dest.putFloat(destOffset + 32, Math.fma(_self20, _t6, Math.fma(_self21, _t7, _self22)));
        return dest;
    }

    public static java.nio.ByteBuffer rotateAxis_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float angle, float axisX, float axisY, float axisZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.rotateAxis_unsafe(_destBase, _srcBase, angle, axisX, axisY, axisZ);
        return dest;
    }

    public static java.nio.ByteBuffer rotateAxis_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float angle, float axisX, float axisY, float axisZ) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
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
        dest.putFloat(destOffset + 0, Math.fma(_self02, _t24, Math.fma(_self00, _t18, _self01 * _t21)));
        dest.putFloat(destOffset + 4, Math.fma(_self12, _t24, Math.fma(_self10, _t18, _self11 * _t21)));
        dest.putFloat(destOffset + 8, Math.fma(_self22, _t24, Math.fma(_self20, _t18, _self21 * _t21)));
        dest.putFloat(destOffset + 12, Math.fma(_self02, _t22, Math.fma(_self00, _t25, _self01 * _t19)));
        dest.putFloat(destOffset + 16, Math.fma(_self12, _t22, Math.fma(_self10, _t25, _self11 * _t19)));
        dest.putFloat(destOffset + 20, Math.fma(_self22, _t22, Math.fma(_self20, _t25, _self21 * _t19)));
        dest.putFloat(destOffset + 24, Math.fma(_self02, _t20, Math.fma(_self00, _t23, _self01 * _t26)));
        dest.putFloat(destOffset + 28, Math.fma(_self12, _t20, Math.fma(_self10, _t23, _self11 * _t26)));
        dest.putFloat(destOffset + 32, Math.fma(_self22, _t20, Math.fma(_self20, _t23, _self21 * _t26)));
        return dest;
    }

    public static java.nio.ByteBuffer rotateAxis_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer axis, int axisOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _axisBase = UnsafeOpsHolder.U.getLong(axis, UnsafeCopy.BB_ADDRESS_OFFSET) + axisOffset;
        Float3x3OpsKernelsAddress.rotateAxis_unsafe(_destBase, _srcBase, _axisBase, angle);
        return dest;
    }

    public static java.nio.ByteBuffer rotateAxis_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer axis, int axisOffset, float angle) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        float _axisx = axis.getFloat(axisOffset + 0);
        float _axisy = axis.getFloat(axisOffset + 4);
        float _axisz = axis.getFloat(axisOffset + 8);
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
        dest.putFloat(destOffset + 0, Math.fma(_self02, _t24, Math.fma(_self00, _t18, _self01 * _t21)));
        dest.putFloat(destOffset + 4, Math.fma(_self12, _t24, Math.fma(_self10, _t18, _self11 * _t21)));
        dest.putFloat(destOffset + 8, Math.fma(_self22, _t24, Math.fma(_self20, _t18, _self21 * _t21)));
        dest.putFloat(destOffset + 12, Math.fma(_self02, _t22, Math.fma(_self00, _t25, _self01 * _t19)));
        dest.putFloat(destOffset + 16, Math.fma(_self12, _t22, Math.fma(_self10, _t25, _self11 * _t19)));
        dest.putFloat(destOffset + 20, Math.fma(_self22, _t22, Math.fma(_self20, _t25, _self21 * _t19)));
        dest.putFloat(destOffset + 24, Math.fma(_self02, _t20, Math.fma(_self00, _t23, _self01 * _t26)));
        dest.putFloat(destOffset + 28, Math.fma(_self12, _t20, Math.fma(_self10, _t23, _self11 * _t26)));
        dest.putFloat(destOffset + 32, Math.fma(_self22, _t20, Math.fma(_self20, _t23, _self21 * _t26)));
        return dest;
    }

    public static java.nio.ByteBuffer rotateX_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.rotateX_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.ByteBuffer rotateX_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float angle) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        dest.putFloat(destOffset + 0, _self00);
        dest.putFloat(destOffset + 4, _self10);
        dest.putFloat(destOffset + 8, _self20);
        dest.putFloat(destOffset + 12, Math.fma(_self01, _t0, _self02 * _t1));
        dest.putFloat(destOffset + 16, Math.fma(_self11, _t0, _self12 * _t1));
        dest.putFloat(destOffset + 20, Math.fma(_self21, _t0, _self22 * _t1));
        dest.putFloat(destOffset + 24, Math.fma(_self02, _t0, -(_self01 * _t1)));
        dest.putFloat(destOffset + 28, Math.fma(_self12, _t0, -(_self11 * _t1)));
        dest.putFloat(destOffset + 32, Math.fma(_self22, _t0, -(_self21 * _t1)));
        return dest;
    }

    public static java.nio.ByteBuffer rotateX180_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.rotateX180_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer rotateX180_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        dest.putFloat(destOffset + 0, _self00);
        dest.putFloat(destOffset + 4, _self10);
        dest.putFloat(destOffset + 8, _self20);
        dest.putFloat(destOffset + 12, -_self01);
        dest.putFloat(destOffset + 16, -_self11);
        dest.putFloat(destOffset + 20, -_self21);
        dest.putFloat(destOffset + 24, -_self02);
        dest.putFloat(destOffset + 28, -_self12);
        dest.putFloat(destOffset + 32, -_self22);
        return dest;
    }

    public static java.nio.ByteBuffer rotateX270_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.rotateX270_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer rotateX270_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        dest.putFloat(destOffset + 0, _self00);
        dest.putFloat(destOffset + 4, _self10);
        dest.putFloat(destOffset + 8, _self20);
        dest.putFloat(destOffset + 12, -_self02);
        dest.putFloat(destOffset + 16, -_self12);
        dest.putFloat(destOffset + 20, -_self22);
        dest.putFloat(destOffset + 24, _self01);
        dest.putFloat(destOffset + 28, _self11);
        dest.putFloat(destOffset + 32, _self21);
        return dest;
    }

    public static java.nio.ByteBuffer rotateX90_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.rotateX90_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer rotateX90_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        dest.putFloat(destOffset + 0, _self00);
        dest.putFloat(destOffset + 4, _self10);
        dest.putFloat(destOffset + 8, _self20);
        dest.putFloat(destOffset + 12, _self02);
        dest.putFloat(destOffset + 16, _self12);
        dest.putFloat(destOffset + 20, _self22);
        dest.putFloat(destOffset + 24, -_self01);
        dest.putFloat(destOffset + 28, -_self11);
        dest.putFloat(destOffset + 32, -_self21);
        return dest;
    }

    public static java.nio.ByteBuffer rotateXYZ_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.rotateXYZ_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.ByteBuffer rotateXYZ_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
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
        dest.putFloat(destOffset + 0, Math.fma(_self02, _t20, Math.fma(_self00, _t7, _self01 * _t18)));
        dest.putFloat(destOffset + 4, Math.fma(_self12, _t20, Math.fma(_self10, _t7, _self11 * _t18)));
        dest.putFloat(destOffset + 8, Math.fma(_self22, _t20, Math.fma(_self20, _t7, _self21 * _t18)));
        dest.putFloat(destOffset + 12, Math.fma(_self02, _t19, Math.fma(_self01, _t21, -(_self00 * _t11))));
        dest.putFloat(destOffset + 16, Math.fma(_self12, _t19, Math.fma(_self11, _t21, -(_self10 * _t11))));
        dest.putFloat(destOffset + 20, Math.fma(_self22, _t19, Math.fma(_self21, _t21, -(_self20 * _t11))));
        dest.putFloat(destOffset + 24, Math.fma(_self02, _t12, Math.fma(_self00, _t2, -(_self01 * _t13))));
        dest.putFloat(destOffset + 28, Math.fma(_self12, _t12, Math.fma(_self10, _t2, -(_self11 * _t13))));
        dest.putFloat(destOffset + 32, Math.fma(_self22, _t12, Math.fma(_self20, _t2, -(_self21 * _t13))));
        return dest;
    }

    public static java.nio.ByteBuffer rotateXZY_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.rotateXZY_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.ByteBuffer rotateXZY_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
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
        dest.putFloat(destOffset + 0, Math.fma(_self02, _t20, Math.fma(_self00, _t8, _self01 * _t18)));
        dest.putFloat(destOffset + 4, Math.fma(_self12, _t20, Math.fma(_self10, _t8, _self11 * _t18)));
        dest.putFloat(destOffset + 8, Math.fma(_self22, _t20, Math.fma(_self20, _t8, _self21 * _t18)));
        dest.putFloat(destOffset + 12, Math.fma(_self02, _t11, Math.fma(_self01, _t12, -(_self00 * _t1))));
        dest.putFloat(destOffset + 16, Math.fma(_self12, _t11, Math.fma(_self11, _t12, -(_self10 * _t1))));
        dest.putFloat(destOffset + 20, Math.fma(_self22, _t11, Math.fma(_self21, _t12, -(_self20 * _t1))));
        dest.putFloat(destOffset + 24, Math.fma(_self02, _t19, Math.fma(_self00, _t14, _self01 * _t21)));
        dest.putFloat(destOffset + 28, Math.fma(_self12, _t19, Math.fma(_self10, _t14, _self11 * _t21)));
        dest.putFloat(destOffset + 32, Math.fma(_self22, _t19, Math.fma(_self20, _t14, _self21 * _t21)));
        return dest;
    }

    public static java.nio.ByteBuffer rotateY_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.rotateY_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.ByteBuffer rotateY_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float angle) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        dest.putFloat(destOffset + 0, Math.fma(_self00, _t0, -(_self02 * _t1)));
        dest.putFloat(destOffset + 4, Math.fma(_self10, _t0, -(_self12 * _t1)));
        dest.putFloat(destOffset + 8, Math.fma(_self20, _t0, -(_self22 * _t1)));
        dest.putFloat(destOffset + 12, _self01);
        dest.putFloat(destOffset + 16, _self11);
        dest.putFloat(destOffset + 20, _self21);
        dest.putFloat(destOffset + 24, Math.fma(_self00, _t1, _self02 * _t0));
        dest.putFloat(destOffset + 28, Math.fma(_self10, _t1, _self12 * _t0));
        dest.putFloat(destOffset + 32, Math.fma(_self20, _t1, _self22 * _t0));
        return dest;
    }

    public static java.nio.ByteBuffer rotateY180_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.rotateY180_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer rotateY180_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        dest.putFloat(destOffset + 0, -_self00);
        dest.putFloat(destOffset + 4, -_self10);
        dest.putFloat(destOffset + 8, -_self20);
        dest.putFloat(destOffset + 12, _self01);
        dest.putFloat(destOffset + 16, _self11);
        dest.putFloat(destOffset + 20, _self21);
        dest.putFloat(destOffset + 24, -_self02);
        dest.putFloat(destOffset + 28, -_self12);
        dest.putFloat(destOffset + 32, -_self22);
        return dest;
    }

    public static java.nio.ByteBuffer rotateY270_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.rotateY270_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer rotateY270_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        dest.putFloat(destOffset + 0, _self02);
        dest.putFloat(destOffset + 4, _self12);
        dest.putFloat(destOffset + 8, _self22);
        dest.putFloat(destOffset + 12, _self01);
        dest.putFloat(destOffset + 16, _self11);
        dest.putFloat(destOffset + 20, _self21);
        dest.putFloat(destOffset + 24, -_self00);
        dest.putFloat(destOffset + 28, -_self10);
        dest.putFloat(destOffset + 32, -_self20);
        return dest;
    }

    public static java.nio.ByteBuffer rotateY90_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.rotateY90_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer rotateY90_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        dest.putFloat(destOffset + 0, -_self02);
        dest.putFloat(destOffset + 4, -_self12);
        dest.putFloat(destOffset + 8, -_self22);
        dest.putFloat(destOffset + 12, _self01);
        dest.putFloat(destOffset + 16, _self11);
        dest.putFloat(destOffset + 20, _self21);
        dest.putFloat(destOffset + 24, _self00);
        dest.putFloat(destOffset + 28, _self10);
        dest.putFloat(destOffset + 32, _self20);
        return dest;
    }

    public static java.nio.ByteBuffer rotateYXZ_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.rotateYXZ_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.ByteBuffer rotateYXZ_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
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
        dest.putFloat(destOffset + 0, Math.fma(_self02, _t20, Math.fma(_self00, _t18, _self01 * _t10)));
        dest.putFloat(destOffset + 4, Math.fma(_self12, _t20, Math.fma(_self10, _t18, _self11 * _t10)));
        dest.putFloat(destOffset + 8, Math.fma(_self22, _t20, Math.fma(_self20, _t18, _self21 * _t10)));
        dest.putFloat(destOffset + 12, Math.fma(_self02, _t19, Math.fma(_self00, _t21, _self01 * _t13)));
        dest.putFloat(destOffset + 16, Math.fma(_self12, _t19, Math.fma(_self10, _t21, _self11 * _t13)));
        dest.putFloat(destOffset + 20, Math.fma(_self22, _t19, Math.fma(_self20, _t21, _self21 * _t13)));
        dest.putFloat(destOffset + 24, Math.fma(_self02, _t14, Math.fma(_self00, _t15, -(_self01 * _t0))));
        dest.putFloat(destOffset + 28, Math.fma(_self12, _t14, Math.fma(_self10, _t15, -(_self11 * _t0))));
        dest.putFloat(destOffset + 32, Math.fma(_self22, _t14, Math.fma(_self20, _t15, -(_self21 * _t0))));
        return dest;
    }

    public static java.nio.ByteBuffer rotateYZX_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.rotateYZX_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.ByteBuffer rotateYZX_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
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
        dest.putFloat(destOffset + 0, Math.fma(-_self02, _t6, Math.fma(_self00, _t7, _self01 * _t3)));
        dest.putFloat(destOffset + 4, Math.fma(-_self12, _t6, Math.fma(_self10, _t7, _self11 * _t3)));
        dest.putFloat(destOffset + 8, Math.fma(-_self22, _t6, Math.fma(_self20, _t7, _self21 * _t3)));
        dest.putFloat(destOffset + 12, Math.fma(_self02, _t18, Math.fma(_self00, _t20, _self01 * _t11)));
        dest.putFloat(destOffset + 16, Math.fma(_self12, _t18, Math.fma(_self10, _t20, _self11 * _t11)));
        dest.putFloat(destOffset + 20, Math.fma(_self22, _t18, Math.fma(_self20, _t20, _self21 * _t11)));
        dest.putFloat(destOffset + 24, Math.fma(_self02, _t21, Math.fma(_self00, _t19, -(_self01 * _t13))));
        dest.putFloat(destOffset + 28, Math.fma(_self12, _t21, Math.fma(_self10, _t19, -(_self11 * _t13))));
        dest.putFloat(destOffset + 32, Math.fma(_self22, _t21, Math.fma(_self20, _t19, -(_self21 * _t13))));
        return dest;
    }

    public static java.nio.ByteBuffer rotateZ180_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.rotateZ180_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer rotateZ180_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        dest.putFloat(destOffset + 0, -_self00);
        dest.putFloat(destOffset + 4, -_self10);
        dest.putFloat(destOffset + 8, -_self20);
        dest.putFloat(destOffset + 12, -_self01);
        dest.putFloat(destOffset + 16, -_self11);
        dest.putFloat(destOffset + 20, -_self21);
        dest.putFloat(destOffset + 24, _self02);
        dest.putFloat(destOffset + 28, _self12);
        dest.putFloat(destOffset + 32, _self22);
        return dest;
    }

    public static java.nio.ByteBuffer rotateZ270_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.rotateZ270_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer rotateZ270_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        dest.putFloat(destOffset + 0, -_self01);
        dest.putFloat(destOffset + 4, -_self11);
        dest.putFloat(destOffset + 8, -_self21);
        dest.putFloat(destOffset + 12, _self00);
        dest.putFloat(destOffset + 16, _self10);
        dest.putFloat(destOffset + 20, _self20);
        dest.putFloat(destOffset + 24, _self02);
        dest.putFloat(destOffset + 28, _self12);
        dest.putFloat(destOffset + 32, _self22);
        return dest;
    }

    public static java.nio.ByteBuffer rotateZ90_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.rotateZ90_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer rotateZ90_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        dest.putFloat(destOffset + 0, _self01);
        dest.putFloat(destOffset + 4, _self11);
        dest.putFloat(destOffset + 8, _self21);
        dest.putFloat(destOffset + 12, -_self00);
        dest.putFloat(destOffset + 16, -_self10);
        dest.putFloat(destOffset + 20, -_self20);
        dest.putFloat(destOffset + 24, _self02);
        dest.putFloat(destOffset + 28, _self12);
        dest.putFloat(destOffset + 32, _self22);
        return dest;
    }

    public static java.nio.ByteBuffer rotateZXY_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.rotateZXY_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.ByteBuffer rotateZXY_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
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
        dest.putFloat(destOffset + 0, Math.fma(-_self02, _t6, Math.fma(_self00, _t20, _self01 * _t18)));
        dest.putFloat(destOffset + 4, Math.fma(-_self12, _t6, Math.fma(_self10, _t20, _self11 * _t18)));
        dest.putFloat(destOffset + 8, Math.fma(-_self22, _t6, Math.fma(_self20, _t20, _self21 * _t18)));
        dest.putFloat(destOffset + 12, Math.fma(_self02, _t4, Math.fma(_self01, _t10, -(_self00 * _t11))));
        dest.putFloat(destOffset + 16, Math.fma(_self12, _t4, Math.fma(_self11, _t10, -(_self10 * _t11))));
        dest.putFloat(destOffset + 20, Math.fma(_self22, _t4, Math.fma(_self21, _t10, -(_self20 * _t11))));
        dest.putFloat(destOffset + 24, Math.fma(_self02, _t12, Math.fma(_self00, _t19, _self01 * _t21)));
        dest.putFloat(destOffset + 28, Math.fma(_self12, _t12, Math.fma(_self10, _t19, _self11 * _t21)));
        dest.putFloat(destOffset + 32, Math.fma(_self22, _t12, Math.fma(_self20, _t19, _self21 * _t21)));
        return dest;
    }

    public static java.nio.ByteBuffer rotateZYX_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.rotateZYX_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.ByteBuffer rotateZYX_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
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
        dest.putFloat(destOffset + 0, Math.fma(-_self02, _t0, Math.fma(_self00, _t6, _self01 * _t7)));
        dest.putFloat(destOffset + 4, Math.fma(-_self12, _t0, Math.fma(_self10, _t6, _self11 * _t7)));
        dest.putFloat(destOffset + 8, Math.fma(-_self22, _t0, Math.fma(_self20, _t6, _self21 * _t7)));
        dest.putFloat(destOffset + 12, Math.fma(_self02, _t8, Math.fma(_self00, _t20, _self01 * _t18)));
        dest.putFloat(destOffset + 16, Math.fma(_self12, _t8, Math.fma(_self10, _t20, _self11 * _t18)));
        dest.putFloat(destOffset + 20, Math.fma(_self22, _t8, Math.fma(_self20, _t20, _self21 * _t18)));
        dest.putFloat(destOffset + 24, Math.fma(_self02, _t13, Math.fma(_self00, _t19, _self01 * _t21)));
        dest.putFloat(destOffset + 28, Math.fma(_self12, _t13, Math.fma(_self10, _t19, _self11 * _t21)));
        dest.putFloat(destOffset + 32, Math.fma(_self22, _t13, Math.fma(_self20, _t19, _self21 * _t21)));
        return dest;
    }

    public static java.nio.ByteBuffer scale_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float vX, float vY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.scale_unsafe(_destBase, _srcBase, vX, vY);
        return dest;
    }

    public static java.nio.ByteBuffer scale_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float vX, float vY) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        dest.putFloat(destOffset + 0, _self00 * vX);
        dest.putFloat(destOffset + 4, _self10 * vX);
        dest.putFloat(destOffset + 8, _self20 * vX);
        dest.putFloat(destOffset + 12, _self01 * vY);
        dest.putFloat(destOffset + 16, _self11 * vY);
        dest.putFloat(destOffset + 20, _self21 * vY);
        dest.putFloat(destOffset + 24, _self02);
        dest.putFloat(destOffset + 28, _self12);
        dest.putFloat(destOffset + 32, _self22);
        return dest;
    }

    public static java.nio.ByteBuffer scale_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + vOffset;
        Float3x3OpsKernelsAddress.scale_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.ByteBuffer scale_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer v, int vOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        float _vx = v.getFloat(vOffset + 0);
        float _vy = v.getFloat(vOffset + 4);
        dest.putFloat(destOffset + 0, _self00 * _vx);
        dest.putFloat(destOffset + 4, _self10 * _vx);
        dest.putFloat(destOffset + 8, _self20 * _vx);
        dest.putFloat(destOffset + 12, _self01 * _vy);
        dest.putFloat(destOffset + 16, _self11 * _vy);
        dest.putFloat(destOffset + 20, _self21 * _vy);
        dest.putFloat(destOffset + 24, _self02);
        dest.putFloat(destOffset + 28, _self12);
        dest.putFloat(destOffset + 32, _self22);
        return dest;
    }

    public static java.nio.ByteBuffer scale_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float s) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.scale_unsafe(_destBase, _srcBase, s);
        return dest;
    }

    public static java.nio.ByteBuffer scale_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float s) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        dest.putFloat(destOffset + 0, s * _self00);
        dest.putFloat(destOffset + 4, s * _self10);
        dest.putFloat(destOffset + 8, s * _self20);
        dest.putFloat(destOffset + 12, s * _self01);
        dest.putFloat(destOffset + 16, s * _self11);
        dest.putFloat(destOffset + 20, s * _self21);
        dest.putFloat(destOffset + 24, _self02);
        dest.putFloat(destOffset + 28, _self12);
        dest.putFloat(destOffset + 32, _self22);
        return dest;
    }

    public static java.nio.ByteBuffer scaleAround_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float s, float pivotX, float pivotY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.scaleAround_unsafe(_destBase, _srcBase, s, pivotX, pivotY);
        return dest;
    }

    public static java.nio.ByteBuffer scaleAround_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float s, float pivotX, float pivotY) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        float _t0 = Math.fma(-s, pivotX, pivotX);
        float _t1 = Math.fma(-s, pivotY, pivotY);
        dest.putFloat(destOffset + 0, s * _self00);
        dest.putFloat(destOffset + 4, s * _self10);
        dest.putFloat(destOffset + 8, s * _self20);
        dest.putFloat(destOffset + 12, s * _self01);
        dest.putFloat(destOffset + 16, s * _self11);
        dest.putFloat(destOffset + 20, s * _self21);
        dest.putFloat(destOffset + 24, Math.fma(_self00, _t0, Math.fma(_self01, _t1, _self02)));
        dest.putFloat(destOffset + 28, Math.fma(_self10, _t0, Math.fma(_self11, _t1, _self12)));
        dest.putFloat(destOffset + 32, Math.fma(_self20, _t0, Math.fma(_self21, _t1, _self22)));
        return dest;
    }

    public static java.nio.ByteBuffer scaleAround_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer pivot, int pivotOffset, float s) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _pivotBase = UnsafeOpsHolder.U.getLong(pivot, UnsafeCopy.BB_ADDRESS_OFFSET) + pivotOffset;
        Float3x3OpsKernelsAddress.scaleAround_unsafe(_destBase, _srcBase, _pivotBase, s);
        return dest;
    }

    public static java.nio.ByteBuffer scaleAround_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer pivot, int pivotOffset, float s) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        float _pivotx = pivot.getFloat(pivotOffset + 0);
        float _pivoty = pivot.getFloat(pivotOffset + 4);
        float _t0 = Math.fma(-s, _pivotx, _pivotx);
        float _t1 = Math.fma(-s, _pivoty, _pivoty);
        dest.putFloat(destOffset + 0, s * _self00);
        dest.putFloat(destOffset + 4, s * _self10);
        dest.putFloat(destOffset + 8, s * _self20);
        dest.putFloat(destOffset + 12, s * _self01);
        dest.putFloat(destOffset + 16, s * _self11);
        dest.putFloat(destOffset + 20, s * _self21);
        dest.putFloat(destOffset + 24, Math.fma(_self00, _t0, Math.fma(_self01, _t1, _self02)));
        dest.putFloat(destOffset + 28, Math.fma(_self10, _t0, Math.fma(_self11, _t1, _self12)));
        dest.putFloat(destOffset + 32, Math.fma(_self20, _t0, Math.fma(_self21, _t1, _self22)));
        return dest;
    }

    public static java.nio.ByteBuffer scaleAround_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float sX, float sY, float pivotX, float pivotY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.scaleAround_unsafe(_destBase, _srcBase, sX, sY, pivotX, pivotY);
        return dest;
    }

    public static java.nio.ByteBuffer scaleAround_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float sX, float sY, float pivotX, float pivotY) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        float _t2 = Math.fma(-pivotX, sX, pivotX);
        float _t3 = Math.fma(-pivotY, sY, pivotY);
        dest.putFloat(destOffset + 0, sX * _self00);
        dest.putFloat(destOffset + 4, sX * _self10);
        dest.putFloat(destOffset + 8, sX * _self20);
        dest.putFloat(destOffset + 12, sY * _self01);
        dest.putFloat(destOffset + 16, sY * _self11);
        dest.putFloat(destOffset + 20, sY * _self21);
        dest.putFloat(destOffset + 24, Math.fma(_self00, _t2, Math.fma(_self01, _t3, _self02)));
        dest.putFloat(destOffset + 28, Math.fma(_self10, _t2, Math.fma(_self11, _t3, _self12)));
        dest.putFloat(destOffset + 32, Math.fma(_self20, _t2, Math.fma(_self21, _t3, _self22)));
        return dest;
    }

    public static java.nio.ByteBuffer scaleAround_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer s, int sOffset, java.nio.ByteBuffer pivot, int pivotOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _sBase = UnsafeOpsHolder.U.getLong(s, UnsafeCopy.BB_ADDRESS_OFFSET) + sOffset;
        long _pivotBase = UnsafeOpsHolder.U.getLong(pivot, UnsafeCopy.BB_ADDRESS_OFFSET) + pivotOffset;
        Float3x3OpsKernelsAddress.scaleAround_unsafe(_destBase, _srcBase, _sBase, _pivotBase);
        return dest;
    }

    public static java.nio.ByteBuffer scaleAround_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer s, int sOffset, java.nio.ByteBuffer pivot, int pivotOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        float _sx = s.getFloat(sOffset + 0);
        float _sy = s.getFloat(sOffset + 4);
        float _pivotx = pivot.getFloat(pivotOffset + 0);
        float _pivoty = pivot.getFloat(pivotOffset + 4);
        float _t2 = Math.fma(-_pivotx, _sx, _pivotx);
        float _t3 = Math.fma(-_pivoty, _sy, _pivoty);
        dest.putFloat(destOffset + 0, _sx * _self00);
        dest.putFloat(destOffset + 4, _sx * _self10);
        dest.putFloat(destOffset + 8, _sx * _self20);
        dest.putFloat(destOffset + 12, _sy * _self01);
        dest.putFloat(destOffset + 16, _sy * _self11);
        dest.putFloat(destOffset + 20, _sy * _self21);
        dest.putFloat(destOffset + 24, Math.fma(_self00, _t2, Math.fma(_self01, _t3, _self02)));
        dest.putFloat(destOffset + 28, Math.fma(_self10, _t2, Math.fma(_self11, _t3, _self12)));
        dest.putFloat(destOffset + 32, Math.fma(_self20, _t2, Math.fma(_self21, _t3, _self22)));
        return dest;
    }

    public static java.nio.ByteBuffer translate_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float vX, float vY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.translate_unsafe(_destBase, _srcBase, vX, vY);
        return dest;
    }

    public static java.nio.ByteBuffer translate_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float vX, float vY) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        dest.putFloat(destOffset + 0, _self00);
        dest.putFloat(destOffset + 4, _self10);
        dest.putFloat(destOffset + 8, _self20);
        dest.putFloat(destOffset + 12, _self01);
        dest.putFloat(destOffset + 16, _self11);
        dest.putFloat(destOffset + 20, _self21);
        dest.putFloat(destOffset + 24, Math.fma(_self00, vX, Math.fma(_self01, vY, _self02)));
        dest.putFloat(destOffset + 28, Math.fma(_self10, vX, Math.fma(_self11, vY, _self12)));
        dest.putFloat(destOffset + 32, Math.fma(_self20, vX, Math.fma(_self21, vY, _self22)));
        return dest;
    }

    public static java.nio.ByteBuffer translate_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + vOffset;
        Float3x3OpsKernelsAddress.translate_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.ByteBuffer translate_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer v, int vOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        float _vx = v.getFloat(vOffset + 0);
        float _vy = v.getFloat(vOffset + 4);
        dest.putFloat(destOffset + 0, _self00);
        dest.putFloat(destOffset + 4, _self10);
        dest.putFloat(destOffset + 8, _self20);
        dest.putFloat(destOffset + 12, _self01);
        dest.putFloat(destOffset + 16, _self11);
        dest.putFloat(destOffset + 20, _self21);
        dest.putFloat(destOffset + 24, Math.fma(_self00, _vx, Math.fma(_self01, _vy, _self02)));
        dest.putFloat(destOffset + 28, Math.fma(_self10, _vx, Math.fma(_self11, _vy, _self12)));
        dest.putFloat(destOffset + 32, Math.fma(_self20, _vx, Math.fma(_self21, _vy, _self22)));
        return dest;
    }

    public static java.nio.ByteBuffer view_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float left, float right, float bottom, float top) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.view_unsafe(_destBase, _srcBase, left, right, bottom, top);
        return dest;
    }

    public static java.nio.ByteBuffer view_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float left, float right, float bottom, float top) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        float _t2 = left + right;
        float _t3 = bottom + top;
        dest.putFloat(destOffset + 0, 2.0f * _self00 * _t0_inv);
        dest.putFloat(destOffset + 4, 2.0f * _self10 * _t0_inv);
        dest.putFloat(destOffset + 8, 2.0f * _self20 * _t0_inv);
        dest.putFloat(destOffset + 12, 2.0f * _self01 * _t1_inv);
        dest.putFloat(destOffset + 16, 2.0f * _self11 * _t1_inv);
        dest.putFloat(destOffset + 20, 2.0f * _self21 * _t1_inv);
        dest.putFloat(destOffset + 24, _self02 + (-(_self00 * _t2 * _t0_inv) - _self01 * _t3 * _t1_inv));
        dest.putFloat(destOffset + 28, _self12 + (-(_self10 * _t2 * _t0_inv) - _self11 * _t3 * _t1_inv));
        dest.putFloat(destOffset + 32, _self22 + (-(_self20 * _t2 * _t0_inv) - _self21 * _t3 * _t1_inv));
        return dest;
    }

    public static java.nio.ByteBuffer mulVec3_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float vX, float vY, float vZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Float3x3OpsKernelsAddress.mulVec3_unsafe(_destBase, _srcBase, vX, vY, vZ);
        return dest;
    }

    public static java.nio.ByteBuffer mulVec3_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, float vX, float vY, float vZ) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        dest.putFloat(destOffset + 0, Math.fma(_self02, vZ, Math.fma(_self00, vX, _self01 * vY)));
        dest.putFloat(destOffset + 4, Math.fma(_self12, vZ, Math.fma(_self10, vX, _self11 * vY)));
        dest.putFloat(destOffset + 8, Math.fma(_self22, vZ, Math.fma(_self20, vX, _self21 * vY)));
        return dest;
    }

    public static java.nio.ByteBuffer mulVec3_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + vOffset;
        Float3x3OpsKernelsAddress.mulVec3_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.ByteBuffer mulVec3_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer v, int vOffset) {
        float _self00 = src.getFloat(srcOffset + 0);
        float _self10 = src.getFloat(srcOffset + 4);
        float _self20 = src.getFloat(srcOffset + 8);
        float _self01 = src.getFloat(srcOffset + 12);
        float _self11 = src.getFloat(srcOffset + 16);
        float _self21 = src.getFloat(srcOffset + 20);
        float _self02 = src.getFloat(srcOffset + 24);
        float _self12 = src.getFloat(srcOffset + 28);
        float _self22 = src.getFloat(srcOffset + 32);
        float _vx = v.getFloat(vOffset + 0);
        float _vy = v.getFloat(vOffset + 4);
        float _vz = v.getFloat(vOffset + 8);
        dest.putFloat(destOffset + 0, Math.fma(_self02, _vz, Math.fma(_self00, _vx, _self01 * _vy)));
        dest.putFloat(destOffset + 4, Math.fma(_self12, _vz, Math.fma(_self10, _vx, _self11 * _vy)));
        dest.putFloat(destOffset + 8, Math.fma(_self22, _vz, Math.fma(_self20, _vx, _self21 * _vy)));
        return dest;
    }

}
