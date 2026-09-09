package org.joml2.internal.kernels;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.ops.*;
import org.joml2.internal.unsafe.*;
import org.joml2.internal.simd.*;

/**
 * Scalar/Unsafe kernel leaves of {@link Float3x3Ops} whose leading storage
 * parameter is a typed {@link java.nio.FloatBuffer}. Split into a sibling compilation unit purely
 * to keep generated sources IDE-sized; package-private, called only from
 * {@code Float3x3Ops} and its sibling kernel units. Not public API.
 */
public final class Float3x3OpsKernelsTypedBuffer {
    private Float3x3OpsKernelsTypedBuffer() {}

    public static java.nio.FloatBuffer getColumn_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, int col) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.getColumn_unsafe(_destBase, _srcBase, col);
        return dest;
    }

    public static java.nio.FloatBuffer getColumn_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, int col) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        float _idxSw0;
        float _idxSw1;
        float _idxSw2;
        switch (col) {
            case 0: _idxSw0 = _self00; _idxSw1 = _self10; _idxSw2 = _self20; break;
            case 1: _idxSw0 = _self01; _idxSw1 = _self11; _idxSw2 = _self21; break;
            case 2: _idxSw0 = _self02; _idxSw1 = _self12; _idxSw2 = _self22; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + col);
        }
        dest.put(destOffset + 0, _idxSw0);
        dest.put(destOffset + 1, _idxSw1);
        dest.put(destOffset + 2, _idxSw2);
        return dest;
    }

    public static java.nio.FloatBuffer getEulerAnglesXYZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.getEulerAnglesXYZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer getEulerAnglesXYZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        float _t1 = Math.fma(_self12, _self12, _self22 * _self22);
        float _t3 = Math.fma(_self02, _self02, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            dest.put(destOffset + 0, (float) Math.atan2(_self21, _self11));
            dest.put(destOffset + 2, 0.0f);
        } else {
            dest.put(destOffset + 0, (float) Math.atan2(-_self12, _self22));
            dest.put(destOffset + 2, (float) Math.atan2(-_self01, _self00));
        }
        dest.put(destOffset + 1, (float) Math.atan2(_self02, (float) Math.sqrt(_t1)));
        return dest;
    }

    public static java.nio.FloatBuffer getEulerAnglesXZY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.getEulerAnglesXZY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer getEulerAnglesXZY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        float _t1 = Math.fma(_self11, _self11, _self21 * _self21);
        float _t3 = Math.fma(_self01, _self01, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            dest.put(destOffset + 0, (float) Math.atan2(-_self12, _self22));
            dest.put(destOffset + 1, 0.0f);
        } else {
            dest.put(destOffset + 0, (float) Math.atan2(_self21, _self11));
            dest.put(destOffset + 1, (float) Math.atan2(_self02, _self00));
        }
        dest.put(destOffset + 2, (float) Math.atan2(-_self01, (float) Math.sqrt(_t1)));
        return dest;
    }

    public static java.nio.FloatBuffer getEulerAnglesYXZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.getEulerAnglesYXZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer getEulerAnglesYXZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self11 = src.get(srcOffset + 4);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        float _t1 = Math.fma(_self02, _self02, _self22 * _self22);
        float _t3 = Math.fma(_self12, _self12, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            dest.put(destOffset + 1, (float) Math.atan2(-_self20, _self00));
            dest.put(destOffset + 2, 0.0f);
        } else {
            dest.put(destOffset + 1, (float) Math.atan2(_self02, _self22));
            dest.put(destOffset + 2, (float) Math.atan2(_self10, _self11));
        }
        dest.put(destOffset + 0, (float) Math.atan2(-_self12, (float) Math.sqrt(_t1)));
        return dest;
    }

    public static java.nio.FloatBuffer getEulerAnglesYZX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.getEulerAnglesYZX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer getEulerAnglesYZX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self11 = src.get(srcOffset + 4);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        float _t1 = Math.fma(_self11, _self11, _self12 * _self12);
        float _t3 = Math.fma(_self10, _self10, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            dest.put(destOffset + 0, 0.0f);
            dest.put(destOffset + 1, (float) Math.atan2(_self02, _self22));
        } else {
            dest.put(destOffset + 0, (float) Math.atan2(-_self12, _self11));
            dest.put(destOffset + 1, (float) Math.atan2(-_self20, _self00));
        }
        dest.put(destOffset + 2, (float) Math.atan2(_self10, (float) Math.sqrt(_t1)));
        return dest;
    }

    public static java.nio.FloatBuffer getEulerAnglesZXY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.getEulerAnglesZXY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer getEulerAnglesZXY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self22 = src.get(srcOffset + 8);
        float _t1 = Math.fma(_self01, _self01, _self11 * _self11);
        float _t3 = Math.fma(_self21, _self21, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            dest.put(destOffset + 1, 0.0f);
            dest.put(destOffset + 2, (float) Math.atan2(_self10, _self00));
        } else {
            dest.put(destOffset + 1, (float) Math.atan2(-_self20, _self22));
            dest.put(destOffset + 2, (float) Math.atan2(-_self01, _self11));
        }
        dest.put(destOffset + 0, (float) Math.atan2(_self21, (float) Math.sqrt(_t1)));
        return dest;
    }

    public static java.nio.FloatBuffer getEulerAnglesZYX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.getEulerAnglesZYX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer getEulerAnglesZYX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self22 = src.get(srcOffset + 8);
        float _t1 = Math.fma(_self21, _self21, _self22 * _self22);
        float _t3 = Math.fma(_self20, _self20, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            dest.put(destOffset + 0, 0.0f);
            dest.put(destOffset + 2, (float) Math.atan2(-_self01, _self11));
        } else {
            dest.put(destOffset + 0, (float) Math.atan2(_self21, _self22));
            dest.put(destOffset + 2, (float) Math.atan2(_self10, _self00));
        }
        dest.put(destOffset + 1, (float) Math.atan2(-_self20, (float) Math.sqrt(_t1)));
        return dest;
    }

    public static java.nio.FloatBuffer getNormalizedRotation_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.getNormalizedRotation_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer getNormalizedRotation_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
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
        Float3x3OpsKernelsAddress.getRow_unsafe(_destBase, _srcBase, row);
        return dest;
    }

    public static java.nio.FloatBuffer getRow_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, int row) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        float _idxSw0;
        float _idxSw1;
        float _idxSw2;
        switch (row) {
            case 0: _idxSw0 = _self00; _idxSw1 = _self01; _idxSw2 = _self02; break;
            case 1: _idxSw0 = _self10; _idxSw1 = _self11; _idxSw2 = _self12; break;
            case 2: _idxSw0 = _self20; _idxSw1 = _self21; _idxSw2 = _self22; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + row);
        }
        dest.put(destOffset + 0, _idxSw0);
        dest.put(destOffset + 1, _idxSw1);
        dest.put(destOffset + 2, _idxSw2);
        return dest;
    }

    public static java.nio.FloatBuffer getScale_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.getScale_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer getScale_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        dest.put(destOffset + 0, (float) Math.sqrt(Math.fma(_self20, _self20, Math.fma(_self00, _self00, _self10 * _self10))));
        dest.put(destOffset + 1, (float) Math.sqrt(Math.fma(_self21, _self21, Math.fma(_self01, _self01, _self11 * _self11))));
        dest.put(destOffset + 2, (float) Math.sqrt(Math.fma(_self22, _self22, Math.fma(_self02, _self02, _self12 * _self12))));
        return dest;
    }

    public static java.nio.FloatBuffer getTranslation_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.getTranslation_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer getTranslation_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        dest.put(destOffset + 0, _self02);
        dest.put(destOffset + 1, _self12);
        return dest;
    }

    public static java.nio.FloatBuffer getUnnormalizedRotation_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.getUnnormalizedRotation_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer getUnnormalizedRotation_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
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

    public static java.nio.FloatBuffer cofactor_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.cofactor_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer cofactor_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        dest.put(destOffset + 0, Math.fma(_self11, _self22, -(_self12 * _self21)));
        dest.put(destOffset + 1, Math.fma(_self02, _self21, -(_self01 * _self22)));
        dest.put(destOffset + 2, Math.fma(_self01, _self12, -(_self02 * _self11)));
        dest.put(destOffset + 3, Math.fma(_self12, _self20, -(_self10 * _self22)));
        dest.put(destOffset + 4, Math.fma(_self00, _self22, -(_self02 * _self20)));
        dest.put(destOffset + 5, Math.fma(_self02, _self10, -(_self00 * _self12)));
        dest.put(destOffset + 6, Math.fma(_self10, _self21, -(_self11 * _self20)));
        dest.put(destOffset + 7, Math.fma(_self01, _self20, -(_self00 * _self21)));
        dest.put(destOffset + 8, Math.fma(_self00, _self11, -(_self01 * _self10)));
        return dest;
    }

    public static float determinant_unsafe(java.nio.FloatBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        return Float3x3OpsKernelsAddress.determinant_unsafe(_srcBase);
    }

    public static float determinant_api(java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        return Math.fma(_self02, Math.fma(_self10, _self21, -(_self11 * _self20)), Math.fma(_self00, Math.fma(_self11, _self22, -(_self12 * _self21)), -(_self01 * Math.fma(_self10, _self22, -(_self12 * _self20)))));
    }

    public static float frobeniusNorm_unsafe(java.nio.FloatBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        return Float3x3OpsKernelsAddress.frobeniusNorm_unsafe(_srcBase);
    }

    public static float frobeniusNorm_api(java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        return (float) Math.sqrt(Math.fma(_self00, _self00, _self01 * _self01) + Math.fma(_self02, _self02, _self10 * _self10) + (Math.fma(_self11, _self11, _self12 * _self12) + Math.fma(_self20, _self20, Math.fma(_self21, _self21, _self22 * _self22))));
    }

    public static java.nio.FloatBuffer invert_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.invert_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer invert_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        float _t6 = Math.fma(_self11, _self22, -(_self12 * _self21));
        float _t7 = Math.fma(_self10, _self21, -(_self11 * _self20));
        float _t12 = Math.fma(_self02, _t7, Math.fma(_self00, _t6, -(_self01 * Math.fma(_self10, _self22, -(_self12 * _self20)))));
        float _t12_inv = 1.0f / _t12;
        dest.put(destOffset + 0, _t6 * _t12_inv);
        dest.put(destOffset + 1, Math.fma(_self12, _self20, -(_self10 * _self22)) * _t12_inv);
        dest.put(destOffset + 2, _t7 * _t12_inv);
        dest.put(destOffset + 3, Math.fma(_self02, _self21, -(_self01 * _self22)) * _t12_inv);
        dest.put(destOffset + 4, Math.fma(_self00, _self22, -(_self02 * _self20)) * _t12_inv);
        dest.put(destOffset + 5, Math.fma(_self01, _self20, -(_self00 * _self21)) * _t12_inv);
        dest.put(destOffset + 6, Math.fma(_self01, _self12, -(_self02 * _self11)) * _t12_inv);
        dest.put(destOffset + 7, Math.fma(_self02, _self10, -(_self00 * _self12)) * _t12_inv);
        dest.put(destOffset + 8, Math.fma(_self00, _self11, -(_self01 * _self10)) * _t12_inv);
        return dest;
    }

    public static java.nio.FloatBuffer invertProduct_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 4L;
        Float3x3OpsKernelsAddress.invertProduct_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.FloatBuffer invertProduct_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer other, int otherOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        float _other00 = other.get(otherOffset + 0);
        float _other10 = other.get(otherOffset + 1);
        float _other20 = other.get(otherOffset + 2);
        float _other01 = other.get(otherOffset + 3);
        float _other11 = other.get(otherOffset + 4);
        float _other21 = other.get(otherOffset + 5);
        float _other02 = other.get(otherOffset + 6);
        float _other12 = other.get(otherOffset + 7);
        float _other22 = other.get(otherOffset + 8);
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
        dest.put(destOffset + 0, _t33 * _t39_inv);
        dest.put(destOffset + 1, Math.fma(_t24, _t21, -(_t23 * _t19)) * _t39_inv);
        dest.put(destOffset + 2, _t34 * _t39_inv);
        dest.put(destOffset + 3, Math.fma(_t20, _t22, -(_t26 * _t19)) * _t39_inv);
        dest.put(destOffset + 4, Math.fma(_t25, _t19, -(_t24 * _t22)) * _t39_inv);
        dest.put(destOffset + 5, Math.fma(_t24, _t26, -(_t25 * _t20)) * _t39_inv);
        dest.put(destOffset + 6, Math.fma(_t26, _t21, -(_t18 * _t22)) * _t39_inv);
        dest.put(destOffset + 7, Math.fma(_t23, _t22, -(_t25 * _t21)) * _t39_inv);
        dest.put(destOffset + 8, Math.fma(_t25, _t18, -(_t23 * _t26)) * _t39_inv);
        return dest;
    }

    public static java.nio.FloatBuffer normal_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.normal_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer normal_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        float _t6 = Math.fma(_self11, _self22, -(_self12 * _self21));
        float _t7 = Math.fma(_self10, _self21, -(_self11 * _self20));
        float _t12 = Math.fma(_self02, _t7, Math.fma(_self00, _t6, -(_self01 * Math.fma(_self10, _self22, -(_self12 * _self20)))));
        float _t12_inv = 1.0f / _t12;
        dest.put(destOffset + 0, _t6 * _t12_inv);
        dest.put(destOffset + 1, Math.fma(_self02, _self21, -(_self01 * _self22)) * _t12_inv);
        dest.put(destOffset + 2, Math.fma(_self01, _self12, -(_self02 * _self11)) * _t12_inv);
        dest.put(destOffset + 3, Math.fma(_self12, _self20, -(_self10 * _self22)) * _t12_inv);
        dest.put(destOffset + 4, Math.fma(_self00, _self22, -(_self02 * _self20)) * _t12_inv);
        dest.put(destOffset + 5, Math.fma(_self02, _self10, -(_self00 * _self12)) * _t12_inv);
        dest.put(destOffset + 6, _t7 * _t12_inv);
        dest.put(destOffset + 7, Math.fma(_self01, _self20, -(_self00 * _self21)) * _t12_inv);
        dest.put(destOffset + 8, Math.fma(_self00, _self11, -(_self01 * _self10)) * _t12_inv);
        return dest;
    }

    public static float trace_unsafe(java.nio.FloatBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        return Float3x3OpsKernelsAddress.trace_unsafe(_srcBase);
    }

    public static float trace_api(java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self11 = src.get(srcOffset + 4);
        float _self22 = src.get(srcOffset + 8);
        return _self22 + (_self00 + _self11);
    }

    public static java.nio.FloatBuffer transpose_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.transpose_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer transpose_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        dest.put(destOffset + 0, _self00);
        dest.put(destOffset + 1, _self01);
        dest.put(destOffset + 2, _self02);
        dest.put(destOffset + 3, _self10);
        dest.put(destOffset + 4, _self11);
        dest.put(destOffset + 5, _self12);
        dest.put(destOffset + 6, _self20);
        dest.put(destOffset + 7, _self21);
        dest.put(destOffset + 8, _self22);
        return dest;
    }

    public static java.nio.FloatBuffer add_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 4L;
        Float3x3OpsKernelsAddress.add_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.FloatBuffer add_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer other, int otherOffset) {
        for (int _i = 0; _i < 9; _i++) {
            float _eself = src.get(srcOffset + _i);
            float _eother = other.get(otherOffset + _i);
            dest.put(destOffset + _i, _eother + _eself);
        }
        return dest;
    }

    public static java.nio.FloatBuffer negate_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.negate_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer negate_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        for (int _i = 0; _i < 9; _i++) {
            float _eself = src.get(srcOffset + _i);
            dest.put(destOffset + _i, -_eself);
        }
        return dest;
    }

    public static java.nio.FloatBuffer sub_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 4L;
        Float3x3OpsKernelsAddress.sub_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.FloatBuffer sub_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer other, int otherOffset) {
        for (int _i = 0; _i < 9; _i++) {
            float _eself = src.get(srcOffset + _i);
            float _eother = other.get(otherOffset + _i);
            dest.put(destOffset + _i, _eself - _eother);
        }
        return dest;
    }

    public static java.nio.FloatBuffer set_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 4L;
        Float3x3OpsKernelsAddress.set_unsafe(_destBase, _vBase);
        return dest;
    }

    public static java.nio.FloatBuffer set_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer v, int vOffset) {
        for (int _i = 0; _i < 9; _i++) {
            float _ev = v.get(vOffset + _i);
            dest.put(destOffset + _i, _ev);
        }
        return dest;
    }

    public static java.nio.FloatBuffer setMat2x2_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer m, int mOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _mBase = UnsafeOpsHolder.U.getLong(m, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) mOffset * 4L;
        Float3x3OpsKernelsAddress.setMat2x2_unsafe(_destBase, _mBase);
        return dest;
    }

    public static java.nio.FloatBuffer setMat2x2_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer m, int mOffset) {
        float _m00 = m.get(mOffset + 0);
        float _m10 = m.get(mOffset + 1);
        float _m01 = m.get(mOffset + 2);
        float _m11 = m.get(mOffset + 3);
        dest.put(destOffset + 0, _m00);
        dest.put(destOffset + 1, _m10);
        dest.put(destOffset + 2, 0.0f);
        dest.put(destOffset + 3, _m01);
        dest.put(destOffset + 4, _m11);
        dest.put(destOffset + 5, 0.0f);
        dest.put(destOffset + 6, 0.0f);
        dest.put(destOffset + 7, 0.0f);
        dest.put(destOffset + 8, 1.0f);
        return dest;
    }

    public static java.nio.FloatBuffer setMat2x3_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer m, int mOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _mBase = UnsafeOpsHolder.U.getLong(m, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) mOffset * 4L;
        Float3x3OpsKernelsAddress.setMat2x3_unsafe(_destBase, _mBase);
        return dest;
    }

    public static java.nio.FloatBuffer setMat2x3_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer m, int mOffset) {
        float _m00 = m.get(mOffset + 0);
        float _m10 = m.get(mOffset + 1);
        float _m01 = m.get(mOffset + 2);
        float _m11 = m.get(mOffset + 3);
        float _m02 = m.get(mOffset + 4);
        float _m12 = m.get(mOffset + 5);
        dest.put(destOffset + 0, _m00);
        dest.put(destOffset + 1, _m10);
        dest.put(destOffset + 2, 0.0f);
        dest.put(destOffset + 3, _m01);
        dest.put(destOffset + 4, _m11);
        dest.put(destOffset + 5, 0.0f);
        dest.put(destOffset + 6, _m02);
        dest.put(destOffset + 7, _m12);
        dest.put(destOffset + 8, 1.0f);
        return dest;
    }

    public static java.nio.FloatBuffer setMat3x4_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer m, int mOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _mBase = UnsafeOpsHolder.U.getLong(m, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) mOffset * 4L;
        Float3x3OpsKernelsAddress.setMat3x4_unsafe(_destBase, _mBase);
        return dest;
    }

    public static java.nio.FloatBuffer setMat3x4_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer m, int mOffset) {
        float _m00 = m.get(mOffset + 0);
        float _m01 = m.get(mOffset + 1);
        float _m02 = m.get(mOffset + 2);
        float _m10 = m.get(mOffset + 4);
        float _m11 = m.get(mOffset + 5);
        float _m12 = m.get(mOffset + 6);
        float _m20 = m.get(mOffset + 8);
        float _m21 = m.get(mOffset + 9);
        float _m22 = m.get(mOffset + 10);
        dest.put(destOffset + 0, _m00);
        dest.put(destOffset + 1, _m10);
        dest.put(destOffset + 2, _m20);
        dest.put(destOffset + 3, _m01);
        dest.put(destOffset + 4, _m11);
        dest.put(destOffset + 5, _m21);
        dest.put(destOffset + 6, _m02);
        dest.put(destOffset + 7, _m12);
        dest.put(destOffset + 8, _m22);
        return dest;
    }

    public static java.nio.FloatBuffer setMat4x4_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer m, int mOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _mBase = UnsafeOpsHolder.U.getLong(m, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) mOffset * 4L;
        Float3x3OpsKernelsAddress.setMat4x4_unsafe(_destBase, _mBase);
        return dest;
    }

    public static java.nio.FloatBuffer setMat4x4_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer m, int mOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 3;
            int _lom = _l * 4;
            float _em0 = m.get(mOffset + _lom);
            float _em1 = m.get(mOffset + _lom + 1);
            float _em2 = m.get(mOffset + _lom + 2);
            dest.put(destOffset + _lo, _em0);
            dest.put(destOffset + _lo + 1, _em1);
            dest.put(destOffset + _lo + 2, _em2);
        }
        return dest;
    }

    public static java.nio.FloatBuffer withTranslation_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float tX, float tY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.withTranslation_unsafe(_destBase, _srcBase, tX, tY);
        return dest;
    }

    public static java.nio.FloatBuffer withTranslation_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float tX, float tY) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self22 = src.get(srcOffset + 8);
        dest.put(destOffset + 0, _self00);
        dest.put(destOffset + 1, _self10);
        dest.put(destOffset + 2, _self20);
        dest.put(destOffset + 3, _self01);
        dest.put(destOffset + 4, _self11);
        dest.put(destOffset + 5, _self21);
        dest.put(destOffset + 6, tX);
        dest.put(destOffset + 7, tY);
        dest.put(destOffset + 8, _self22);
        return dest;
    }

    public static java.nio.FloatBuffer withTranslation_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer t, int tOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _tBase = UnsafeOpsHolder.U.getLong(t, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) tOffset * 4L;
        Float3x3OpsKernelsAddress.withTranslation_unsafe(_destBase, _srcBase, _tBase);
        return dest;
    }

    public static java.nio.FloatBuffer withTranslation_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer t, int tOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self22 = src.get(srcOffset + 8);
        float _tx = t.get(tOffset + 0);
        float _ty = t.get(tOffset + 1);
        dest.put(destOffset + 0, _self00);
        dest.put(destOffset + 1, _self10);
        dest.put(destOffset + 2, _self20);
        dest.put(destOffset + 3, _self01);
        dest.put(destOffset + 4, _self11);
        dest.put(destOffset + 5, _self21);
        dest.put(destOffset + 6, _tx);
        dest.put(destOffset + 7, _ty);
        dest.put(destOffset + 8, _self22);
        return dest;
    }

    public static java.nio.FloatBuffer makeFromRigid_unsafe(java.nio.FloatBuffer dest, int destOffset, float rTX, float rTY, float rTZ, float rRX, float rRY, float rRZ, float rRW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float3x3OpsKernelsAddress.makeFromRigid_unsafe(_destBase, rTX, rTY, rTZ, rRX, rRY, rRZ, rRW);
        return dest;
    }

    public static java.nio.FloatBuffer makeFromRigid_api(java.nio.FloatBuffer dest, int destOffset, float rTX, float rTY, float rTZ, float rRX, float rRY, float rRZ, float rRW) {
        float _t0 = rRZ * rRZ;
        float _t1 = rRZ * rRW;
        float _t2 = rRY * rRW;
        dest.put(destOffset + 0, Math.fma(-2.0f, Math.fma(rRY, rRY, _t0), 1.0f));
        dest.put(destOffset + 1, 2.0f * Math.fma(rRX, rRY, _t1));
        dest.put(destOffset + 2, 2.0f * Math.fma(rRX, rRZ, -_t2));
        dest.put(destOffset + 3, 2.0f * Math.fma(rRX, rRY, -_t1));
        dest.put(destOffset + 4, Math.fma(-2.0f, Math.fma(rRX, rRX, _t0), 1.0f));
        dest.put(destOffset + 5, 2.0f * Math.fma(rRX, rRW, rRY * rRZ));
        dest.put(destOffset + 6, 2.0f * Math.fma(rRX, rRZ, _t2));
        dest.put(destOffset + 7, 2.0f * Math.fma(rRY, rRZ, -(rRX * rRW)));
        dest.put(destOffset + 8, Math.fma(-2.0f, Math.fma(rRX, rRX, rRY * rRY), 1.0f));
        return dest;
    }

    public static java.nio.FloatBuffer makeFromTransform_unsafe(java.nio.FloatBuffer dest, int destOffset, float tTX, float tTY, float tTZ, float tRX, float tRY, float tRZ, float tRW, float tSX, float tSY, float tSZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float3x3OpsKernelsAddress.makeFromTransform_unsafe(_destBase, tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ);
        return dest;
    }

    public static java.nio.FloatBuffer makeFromTransform_api(java.nio.FloatBuffer dest, int destOffset, float tTX, float tTY, float tTZ, float tRX, float tRY, float tRZ, float tRW, float tSX, float tSY, float tSZ) {
        float _t0 = tRZ * tRZ;
        float _t1 = tRZ * tRW;
        float _t2 = tRY * tRW;
        dest.put(destOffset + 0, tSX * Math.fma(-2.0f, Math.fma(tRY, tRY, _t0), 1.0f));
        dest.put(destOffset + 1, tSX * 2.0f * Math.fma(tRX, tRY, _t1));
        dest.put(destOffset + 2, tSX * 2.0f * Math.fma(tRX, tRZ, -_t2));
        dest.put(destOffset + 3, tSY * 2.0f * Math.fma(tRX, tRY, -_t1));
        dest.put(destOffset + 4, tSY * Math.fma(-2.0f, Math.fma(tRX, tRX, _t0), 1.0f));
        dest.put(destOffset + 5, tSY * 2.0f * Math.fma(tRX, tRW, tRY * tRZ));
        dest.put(destOffset + 6, tSZ * 2.0f * Math.fma(tRX, tRZ, _t2));
        dest.put(destOffset + 7, tSZ * 2.0f * Math.fma(tRY, tRZ, -(tRX * tRW)));
        dest.put(destOffset + 8, tSZ * Math.fma(-2.0f, Math.fma(tRX, tRX, tRY * tRY), 1.0f));
        return dest;
    }

    public static java.nio.FloatBuffer to2x2_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.to2x2_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer to2x2_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        dest.put(destOffset + 0, _self00);
        dest.put(destOffset + 1, _self10);
        dest.put(destOffset + 2, _self01);
        dest.put(destOffset + 3, _self11);
        return dest;
    }

    public static java.nio.FloatBuffer to2x3_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.to2x3_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer to2x3_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 2;
            int _loself = _l * 3;
            float _eself0 = src.get(srcOffset + _loself);
            float _eself1 = src.get(srcOffset + _loself + 1);
            dest.put(destOffset + _lo, _eself0);
            dest.put(destOffset + _lo + 1, _eself1);
        }
        return dest;
    }

    public static java.nio.FloatBuffer to3x4_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.to3x4_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer to3x4_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        dest.put(destOffset + 0, _self00);
        dest.put(destOffset + 1, _self01);
        dest.put(destOffset + 2, _self02);
        dest.put(destOffset + 3, 0.0f);
        dest.put(destOffset + 4, _self10);
        dest.put(destOffset + 5, _self11);
        dest.put(destOffset + 6, _self12);
        dest.put(destOffset + 7, 0.0f);
        dest.put(destOffset + 8, _self20);
        dest.put(destOffset + 9, _self21);
        dest.put(destOffset + 10, _self22);
        dest.put(destOffset + 11, 0.0f);
        return dest;
    }

    public static java.nio.FloatBuffer to4x4_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.to4x4_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer to4x4_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        dest.put(destOffset + 0, _self00);
        dest.put(destOffset + 1, _self10);
        dest.put(destOffset + 2, _self20);
        dest.put(destOffset + 3, 0.0f);
        dest.put(destOffset + 4, _self01);
        dest.put(destOffset + 5, _self11);
        dest.put(destOffset + 6, _self21);
        dest.put(destOffset + 7, 0.0f);
        dest.put(destOffset + 8, _self02);
        dest.put(destOffset + 9, _self12);
        dest.put(destOffset + 10, _self22);
        dest.put(destOffset + 11, 0.0f);
        dest.put(destOffset + 12, 0.0f);
        dest.put(destOffset + 13, 0.0f);
        dest.put(destOffset + 14, 0.0f);
        dest.put(destOffset + 15, 1.0f);
        return dest;
    }

    public static java.nio.FloatBuffer toDualQuat_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.toDualQuat_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer toDualQuat_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
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
            dest.put(destOffset + 0, 0.5f * _t3 * _t18);
            dest.put(destOffset + 1, 0.5f * _t7 * _t18);
            dest.put(destOffset + 2, 0.5f * _t9 * _t18);
            dest.put(destOffset + 3, 0.5f * (float) Math.sqrt(_t14));
        } else {
            if (_self00 > _t4) {
                dest.put(destOffset + 0, 0.5f * (float) Math.sqrt(_t15));
                dest.put(destOffset + 1, 0.5f * _t5 * _t21);
                dest.put(destOffset + 2, 0.5f * _t6 * _t21);
                dest.put(destOffset + 3, 0.5f * _t3 * _t21);
            } else {
                if (_self11 > _self22) {
                    dest.put(destOffset + 0, 0.5f * _t5 * _t19);
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
        dest.put(destOffset + 4, 0.0f);
        dest.put(destOffset + 5, 0.0f);
        dest.put(destOffset + 6, 0.0f);
        dest.put(destOffset + 7, 0.0f);
        return dest;
    }

    public static java.nio.FloatBuffer toRigid_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.toRigid_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer toRigid_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
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
            dest.put(destOffset + 3, 0.5f * _t32 * _t61);
            dest.put(destOffset + 4, 0.5f * _t53 * _t61);
            dest.put(destOffset + 5, 0.5f * _t54 * _t61);
            dest.put(destOffset + 6, 0.5f * (float) Math.sqrt(_t60));
        } else {
            if (_t44 > _t33) {
                dest.put(destOffset + 3, 0.5f * (float) Math.sqrt(_t64));
                dest.put(destOffset + 4, 0.5f * _t51 * _t67);
                dest.put(destOffset + 5, 0.5f * _t52 * _t67);
                dest.put(destOffset + 6, 0.5f * _t32 * _t67);
            } else {
                if (_t21 > _t16) {
                    dest.put(destOffset + 3, 0.5f * _t51 * _t65);
                    dest.put(destOffset + 4, 0.5f * (float) Math.sqrt(_t62));
                    dest.put(destOffset + 5, 0.5f * _t28 * _t65);
                    dest.put(destOffset + 6, 0.5f * _t53 * _t65);
                } else {
                    dest.put(destOffset + 3, 0.5f * _t52 * _t66);
                    dest.put(destOffset + 4, 0.5f * _t28 * _t66);
                    dest.put(destOffset + 5, 0.5f * (float) Math.sqrt(_t63));
                    dest.put(destOffset + 6, 0.5f * _t54 * _t66);
                }
            }
        }
        dest.put(destOffset + 0, 0.0f);
        dest.put(destOffset + 1, 0.0f);
        dest.put(destOffset + 2, 0.0f);
        return dest;
    }

    public static java.nio.FloatBuffer toTransform_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.toTransform_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer toTransform_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
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
        dest.put(destOffset + 0, 0.0f);
        dest.put(destOffset + 1, 0.0f);
        dest.put(destOffset + 2, 0.0f);
        dest.put(destOffset + 3, _t60 > 0.0f ? 0.5f * _t33 * _t62 : _t45 > _t34 ? 0.5f * (float) Math.sqrt(_t65) : _t22 > _t17 ? 0.5f * _t52 * _t66 : 0.5f * _t53 * _t67);
        dest.put(destOffset + 4, _t60 > 0.0f ? 0.5f * _t54 * _t62 : _t45 > _t34 ? 0.5f * _t52 * _t68 : _t22 > _t17 ? 0.5f * (float) Math.sqrt(_t63) : 0.5f * _t29 * _t67);
        dest.put(destOffset + 5, _t60 > 0.0f ? 0.5f * _t55 * _t62 : _t45 > _t34 ? 0.5f * _t53 * _t68 : _t22 > _t17 ? 0.5f * _t29 * _t66 : 0.5f * (float) Math.sqrt(_t64));
        dest.put(destOffset + 6, _t60 > 0.0f ? 0.5f * (float) Math.sqrt(_t61) : _t45 > _t34 ? 0.5f * _t33 * _t68 : _t22 > _t17 ? 0.5f * _t54 * _t66 : 0.5f * _t55 * _t67);
        dest.put(destOffset + 7, _t44 < 0.0f ? -_t15 : _t15);
        dest.put(destOffset + 8, (float) Math.sqrt(_t9));
        dest.put(destOffset + 9, (float) Math.sqrt(_t10));
        return dest;
    }

    public static java.nio.FloatBuffer decomposeRotation_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.decomposeRotation_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer decomposeRotation_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
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
        Float3x3OpsKernelsAddress.decomposeScale_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer decomposeScale_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
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
        dest.put(destOffset + 0, Math.fma(Math.fma(_t32, _t52, -(_t34 * _t53)), _t8, Math.fma(Math.fma(_t34, _t54, -(_t33 * _t52)), _t9, Math.fma(_t33, _t53, -(_t32 * _t54)) * _t10)) < 0.0f ? -_t4 : _t4);
        dest.put(destOffset + 1, (float) Math.sqrt(_t27));
        dest.put(destOffset + 2, (float) Math.sqrt(_t47));
        return dest;
    }

    public static java.nio.FloatBuffer decomposeSkew_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.decomposeSkew_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer decomposeSkew_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
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
            dest.put(destOffset + 1, -_t49);
            dest.put(destOffset + 2, -_t28);
        } else {
            dest.put(destOffset + 1, _t49);
            dest.put(destOffset + 2, _t28);
        }
        dest.put(destOffset + 0, _t37 * _t48);
        return dest;
    }

    public static java.nio.FloatBuffer makeIdentity_unsafe(java.nio.FloatBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float3x3OpsKernelsAddress.makeIdentity_unsafe(_destBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeIdentity_api(java.nio.FloatBuffer dest, int destOffset) {
        dest.put(destOffset + 0, 1.0f);
        dest.put(destOffset + 1, 0.0f);
        dest.put(destOffset + 2, 0.0f);
        dest.put(destOffset + 3, 0.0f);
        dest.put(destOffset + 4, 1.0f);
        dest.put(destOffset + 5, 0.0f);
        dest.put(destOffset + 6, 0.0f);
        dest.put(destOffset + 7, 0.0f);
        dest.put(destOffset + 8, 1.0f);
        return dest;
    }

    public static java.nio.FloatBuffer lerp_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer other, int otherOffset, float t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 4L;
        Float3x3OpsKernelsAddress.lerp_unsafe(_destBase, _srcBase, _otherBase, t);
        return dest;
    }

    public static java.nio.FloatBuffer lerp_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer other, int otherOffset, float t) {
        for (int _i = 0; _i < 9; _i++) {
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
        Float3x3OpsKernelsAddress.mul_unsafe(_destBase, _srcBase, _rightBase);
        return dest;
    }

    public static java.nio.FloatBuffer mul_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer right, int rightOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 3;
            float _eright0 = right.get(rightOffset + _lo);
            float _eright1 = right.get(rightOffset + _lo + 1);
            float _eright2 = right.get(rightOffset + _lo + 2);
            dest.put(destOffset + _lo, Math.fma(_eright2, _self02, Math.fma(_eright0, _self00, _eright1 * _self01)));
            dest.put(destOffset + _lo + 1, Math.fma(_eright2, _self12, Math.fma(_eright0, _self10, _eright1 * _self11)));
            dest.put(destOffset + _lo + 2, Math.fma(_eright2, _self22, Math.fma(_eright0, _self20, _eright1 * _self21)));
        }
        return dest;
    }

    public static java.nio.FloatBuffer mulMat2x2_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer right, int rightOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _rightBase = UnsafeOpsHolder.U.getLong(right, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rightOffset * 4L;
        Float3x3OpsKernelsAddress.mulMat2x2_unsafe(_destBase, _srcBase, _rightBase);
        return dest;
    }

    public static java.nio.FloatBuffer mulMat2x2_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer right, int rightOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        float _right00 = right.get(rightOffset + 0);
        float _right10 = right.get(rightOffset + 1);
        float _right01 = right.get(rightOffset + 2);
        float _right11 = right.get(rightOffset + 3);
        dest.put(destOffset + 0, Math.fma(_right00, _self00, _right10 * _self01));
        dest.put(destOffset + 1, Math.fma(_right00, _self10, _right10 * _self11));
        dest.put(destOffset + 2, Math.fma(_right00, _self20, _right10 * _self21));
        dest.put(destOffset + 3, Math.fma(_right01, _self00, _right11 * _self01));
        dest.put(destOffset + 4, Math.fma(_right01, _self10, _right11 * _self11));
        dest.put(destOffset + 5, Math.fma(_right01, _self20, _right11 * _self21));
        dest.put(destOffset + 6, _self02);
        dest.put(destOffset + 7, _self12);
        dest.put(destOffset + 8, _self22);
        return dest;
    }

    public static java.nio.FloatBuffer mulMat2x3_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer right, int rightOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _rightBase = UnsafeOpsHolder.U.getLong(right, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rightOffset * 4L;
        Float3x3OpsKernelsAddress.mulMat2x3_unsafe(_destBase, _srcBase, _rightBase);
        return dest;
    }

    public static java.nio.FloatBuffer mulMat2x3_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer right, int rightOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        float _right00 = right.get(rightOffset + 0);
        float _right10 = right.get(rightOffset + 1);
        float _right01 = right.get(rightOffset + 2);
        float _right11 = right.get(rightOffset + 3);
        float _right02 = right.get(rightOffset + 4);
        float _right12 = right.get(rightOffset + 5);
        dest.put(destOffset + 0, Math.fma(_right00, _self00, _right10 * _self01));
        dest.put(destOffset + 1, Math.fma(_right00, _self10, _right10 * _self11));
        dest.put(destOffset + 2, Math.fma(_right00, _self20, _right10 * _self21));
        dest.put(destOffset + 3, Math.fma(_right01, _self00, _right11 * _self01));
        dest.put(destOffset + 4, Math.fma(_right01, _self10, _right11 * _self11));
        dest.put(destOffset + 5, Math.fma(_right01, _self20, _right11 * _self21));
        dest.put(destOffset + 6, Math.fma(_right02, _self00, Math.fma(_right12, _self01, _self02)));
        dest.put(destOffset + 7, Math.fma(_right02, _self10, Math.fma(_right12, _self11, _self12)));
        dest.put(destOffset + 8, Math.fma(_right02, _self20, Math.fma(_right12, _self21, _self22)));
        return dest;
    }

    public static java.nio.FloatBuffer preMul_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 4L;
        Float3x3OpsKernelsAddress.preMul_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.FloatBuffer preMul_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer other, int otherOffset) {
        float _other00 = other.get(otherOffset + 0);
        float _other10 = other.get(otherOffset + 1);
        float _other20 = other.get(otherOffset + 2);
        float _other01 = other.get(otherOffset + 3);
        float _other11 = other.get(otherOffset + 4);
        float _other21 = other.get(otherOffset + 5);
        float _other02 = other.get(otherOffset + 6);
        float _other12 = other.get(otherOffset + 7);
        float _other22 = other.get(otherOffset + 8);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 3;
            float _eself0 = src.get(srcOffset + _lo);
            float _eself1 = src.get(srcOffset + _lo + 1);
            float _eself2 = src.get(srcOffset + _lo + 2);
            dest.put(destOffset + _lo, Math.fma(_other02, _eself2, Math.fma(_other00, _eself0, _other01 * _eself1)));
            dest.put(destOffset + _lo + 1, Math.fma(_other12, _eself2, Math.fma(_other10, _eself0, _other11 * _eself1)));
            dest.put(destOffset + _lo + 2, Math.fma(_other22, _eself2, Math.fma(_other20, _eself0, _other21 * _eself1)));
        }
        return dest;
    }

    public static java.nio.FloatBuffer preMulMat2x2_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 4L;
        Float3x3OpsKernelsAddress.preMulMat2x2_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.FloatBuffer preMulMat2x2_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer other, int otherOffset) {
        float _other00 = other.get(otherOffset + 0);
        float _other10 = other.get(otherOffset + 1);
        float _other01 = other.get(otherOffset + 2);
        float _other11 = other.get(otherOffset + 3);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 3;
            float _eself0 = src.get(srcOffset + _lo);
            float _eself1 = src.get(srcOffset + _lo + 1);
            float _eself2 = src.get(srcOffset + _lo + 2);
            dest.put(destOffset + _lo, Math.fma(_other00, _eself0, _other01 * _eself1));
            dest.put(destOffset + _lo + 1, Math.fma(_other10, _eself0, _other11 * _eself1));
            dest.put(destOffset + _lo + 2, _eself2);
        }
        return dest;
    }

    public static java.nio.FloatBuffer preMulMat2x3_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 4L;
        Float3x3OpsKernelsAddress.preMulMat2x3_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.FloatBuffer preMulMat2x3_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer other, int otherOffset) {
        float _other00 = other.get(otherOffset + 0);
        float _other10 = other.get(otherOffset + 1);
        float _other01 = other.get(otherOffset + 2);
        float _other11 = other.get(otherOffset + 3);
        float _other02 = other.get(otherOffset + 4);
        float _other12 = other.get(otherOffset + 5);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 3;
            float _eself0 = src.get(srcOffset + _lo);
            float _eself1 = src.get(srcOffset + _lo + 1);
            float _eself2 = src.get(srcOffset + _lo + 2);
            dest.put(destOffset + _lo, Math.fma(_other02, _eself2, Math.fma(_other00, _eself0, _other01 * _eself1)));
            dest.put(destOffset + _lo + 1, Math.fma(_other12, _eself2, Math.fma(_other10, _eself0, _other11 * _eself1)));
            dest.put(destOffset + _lo + 2, _eself2);
        }
        return dest;
    }

    public static java.nio.FloatBuffer makeOuterProduct_unsafe(java.nio.FloatBuffer dest, int destOffset, float colX, float colY, float colZ, float rowX, float rowY, float rowZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float3x3OpsKernelsAddress.makeOuterProduct_unsafe(_destBase, colX, colY, colZ, rowX, rowY, rowZ);
        return dest;
    }

    public static java.nio.FloatBuffer makeOuterProduct_api(java.nio.FloatBuffer dest, int destOffset, float colX, float colY, float colZ, float rowX, float rowY, float rowZ) {
        dest.put(destOffset + 0, colX * rowX);
        dest.put(destOffset + 1, colY * rowX);
        dest.put(destOffset + 2, colZ * rowX);
        dest.put(destOffset + 3, colX * rowY);
        dest.put(destOffset + 4, colY * rowY);
        dest.put(destOffset + 5, colZ * rowY);
        dest.put(destOffset + 6, colX * rowZ);
        dest.put(destOffset + 7, colY * rowZ);
        dest.put(destOffset + 8, colZ * rowZ);
        return dest;
    }

    public static java.nio.FloatBuffer makeOuterProduct_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer col, int colOffset, java.nio.FloatBuffer row, int rowOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _colBase = UnsafeOpsHolder.U.getLong(col, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) colOffset * 4L;
        long _rowBase = UnsafeOpsHolder.U.getLong(row, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rowOffset * 4L;
        Float3x3OpsKernelsAddress.makeOuterProduct_unsafe(_destBase, _colBase, _rowBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeOuterProduct_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer col, int colOffset, java.nio.FloatBuffer row, int rowOffset) {
        float _colx = col.get(colOffset + 0);
        float _coly = col.get(colOffset + 1);
        float _colz = col.get(colOffset + 2);
        float _rowx = row.get(rowOffset + 0);
        float _rowy = row.get(rowOffset + 1);
        float _rowz = row.get(rowOffset + 2);
        dest.put(destOffset + 0, _colx * _rowx);
        dest.put(destOffset + 1, _coly * _rowx);
        dest.put(destOffset + 2, _colz * _rowx);
        dest.put(destOffset + 3, _colx * _rowy);
        dest.put(destOffset + 4, _coly * _rowy);
        dest.put(destOffset + 5, _colz * _rowy);
        dest.put(destOffset + 6, _colx * _rowz);
        dest.put(destOffset + 7, _coly * _rowz);
        dest.put(destOffset + 8, _colz * _rowz);
        return dest;
    }

    public static java.nio.FloatBuffer lookAlong_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.lookAlong_unsafe(_destBase, _srcBase, dirX, dirY, dirZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.FloatBuffer lookAlong_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
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
        dest.put(destOffset + 3, Math.fma(_self02, _t35, Math.fma(_self00, _t36, _self01 * _t37)));
        dest.put(destOffset + 4, Math.fma(_self12, _t35, Math.fma(_self10, _t36, _self11 * _t37)));
        dest.put(destOffset + 5, Math.fma(_self22, _t35, Math.fma(_self20, _t36, _self21 * _t37)));
        dest.put(destOffset + 6, Math.fma(_self02, _t9, Math.fma(_self00, _t8, _self01 * _t7)));
        dest.put(destOffset + 7, Math.fma(_self12, _t9, Math.fma(_self10, _t8, _self11 * _t7)));
        dest.put(destOffset + 8, Math.fma(_self22, _t9, Math.fma(_self20, _t8, _self21 * _t7)));
        return dest;
    }

    public static java.nio.FloatBuffer lookAlong_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer dir, int dirOffset, java.nio.FloatBuffer up, int upOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _dirBase = UnsafeOpsHolder.U.getLong(dir, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) dirOffset * 4L;
        long _upBase = UnsafeOpsHolder.U.getLong(up, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) upOffset * 4L;
        Float3x3OpsKernelsAddress.lookAlong_unsafe(_destBase, _srcBase, _dirBase, _upBase);
        return dest;
    }

    public static java.nio.FloatBuffer lookAlong_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer dir, int dirOffset, java.nio.FloatBuffer up, int upOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
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
        dest.put(destOffset + 3, Math.fma(_self02, _t35, Math.fma(_self00, _t36, _self01 * _t37)));
        dest.put(destOffset + 4, Math.fma(_self12, _t35, Math.fma(_self10, _t36, _self11 * _t37)));
        dest.put(destOffset + 5, Math.fma(_self22, _t35, Math.fma(_self20, _t36, _self21 * _t37)));
        dest.put(destOffset + 6, Math.fma(_self02, _t9, Math.fma(_self00, _t8, _self01 * _t7)));
        dest.put(destOffset + 7, Math.fma(_self12, _t9, Math.fma(_self10, _t8, _self11 * _t7)));
        dest.put(destOffset + 8, Math.fma(_self22, _t9, Math.fma(_self20, _t8, _self21 * _t7)));
        return dest;
    }

    public static java.nio.FloatBuffer makeFromDualQuat_unsafe(java.nio.FloatBuffer dest, int destOffset, float dqRX, float dqRY, float dqRZ, float dqRW, float dqDX, float dqDY, float dqDZ, float dqDW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float3x3OpsKernelsAddress.makeFromDualQuat_unsafe(_destBase, dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW);
        return dest;
    }

    public static java.nio.FloatBuffer makeFromDualQuat_api(java.nio.FloatBuffer dest, int destOffset, float dqRX, float dqRY, float dqRZ, float dqRW, float dqDX, float dqDY, float dqDZ, float dqDW) {
        float _t0 = dqRY * dqRY;
        float _t2 = dqRZ * dqRW;
        float _t3 = dqRY * dqRW;
        float _t4 = dqRX * dqRX;
        float _t5 = dqRY * dqRZ;
        float _t6 = Math.fma(-2.0f, dqRZ * dqRZ, 1.0f);
        dest.put(destOffset + 0, Math.fma(-2.0f, _t0, _t6));
        dest.put(destOffset + 1, 2.0f * Math.fma(dqRX, dqRY, _t2));
        dest.put(destOffset + 2, Math.fma(-2.0f, _t3, 2.0f * dqRX * dqRZ));
        dest.put(destOffset + 3, Math.fma(-2.0f, _t2, 2.0f * dqRX * dqRY));
        dest.put(destOffset + 4, Math.fma(-2.0f, _t4, _t6));
        dest.put(destOffset + 5, 2.0f * Math.fma(dqRX, dqRW, _t5));
        dest.put(destOffset + 6, 2.0f * Math.fma(dqRX, dqRZ, _t3));
        dest.put(destOffset + 7, Math.fma(-2.0f, dqRX * dqRW, 2.0f * _t5));
        dest.put(destOffset + 8, Math.fma(-2.0f, _t4, Math.fma(-2.0f, _t0, 1.0f)));
        return dest;
    }

    public static java.nio.FloatBuffer makeRotation_unsafe(java.nio.FloatBuffer dest, int destOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float3x3OpsKernelsAddress.makeRotation_unsafe(_destBase, angle);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotation_api(java.nio.FloatBuffer dest, int destOffset, float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        dest.put(destOffset + 0, _t0);
        dest.put(destOffset + 1, _t1);
        dest.put(destOffset + 2, 0.0f);
        dest.put(destOffset + 3, -_t1);
        dest.put(destOffset + 4, _t0);
        dest.put(destOffset + 5, 0.0f);
        dest.put(destOffset + 6, 0.0f);
        dest.put(destOffset + 7, 0.0f);
        dest.put(destOffset + 8, 1.0f);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationAxis_unsafe(java.nio.FloatBuffer dest, int destOffset, float angle, float axisX, float axisY, float axisZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float3x3OpsKernelsAddress.makeRotationAxis_unsafe(_destBase, angle, axisX, axisY, axisZ);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationAxis_api(java.nio.FloatBuffer dest, int destOffset, float angle, float axisX, float axisY, float axisZ) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = 1.0f - _t0;
        float _t3 = axisX * axisY;
        float _t4 = axisX * axisZ;
        float _t5 = axisY * axisZ;
        dest.put(destOffset + 0, Math.fma(_t2, axisX * axisX, _t0));
        dest.put(destOffset + 1, Math.fma(axisZ, _t1, _t2 * _t3));
        dest.put(destOffset + 2, Math.fma(_t2, _t4, -(axisY * _t1)));
        dest.put(destOffset + 3, Math.fma(_t2, _t3, -(axisZ * _t1)));
        dest.put(destOffset + 4, Math.fma(_t2, axisY * axisY, _t0));
        dest.put(destOffset + 5, Math.fma(axisX, _t1, _t2 * _t5));
        dest.put(destOffset + 6, Math.fma(axisY, _t1, _t2 * _t4));
        dest.put(destOffset + 7, Math.fma(_t2, _t5, -(axisX * _t1)));
        dest.put(destOffset + 8, Math.fma(_t2, axisZ * axisZ, _t0));
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationAxis_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer axis, int axisOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _axisBase = UnsafeOpsHolder.U.getLong(axis, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) axisOffset * 4L;
        Float3x3OpsKernelsAddress.makeRotationAxis_unsafe(_destBase, _axisBase, angle);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationAxis_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer axis, int axisOffset, float angle) {
        float _axisx = axis.get(axisOffset + 0);
        float _axisy = axis.get(axisOffset + 1);
        float _axisz = axis.get(axisOffset + 2);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = 1.0f - _t0;
        float _t3 = _axisx * _axisy;
        float _t4 = _axisx * _axisz;
        float _t5 = _axisy * _axisz;
        dest.put(destOffset + 0, Math.fma(_t2, _axisx * _axisx, _t0));
        dest.put(destOffset + 1, Math.fma(_axisz, _t1, _t2 * _t3));
        dest.put(destOffset + 2, Math.fma(_t2, _t4, -(_axisy * _t1)));
        dest.put(destOffset + 3, Math.fma(_t2, _t3, -(_axisz * _t1)));
        dest.put(destOffset + 4, Math.fma(_t2, _axisy * _axisy, _t0));
        dest.put(destOffset + 5, Math.fma(_axisx, _t1, _t2 * _t5));
        dest.put(destOffset + 6, Math.fma(_axisy, _t1, _t2 * _t4));
        dest.put(destOffset + 7, Math.fma(_t2, _t5, -(_axisx * _t1)));
        dest.put(destOffset + 8, Math.fma(_t2, _axisz * _axisz, _t0));
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationLookAlong_unsafe(java.nio.FloatBuffer dest, int destOffset, float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float3x3OpsKernelsAddress.makeRotationLookAlong_unsafe(_destBase, dirX, dirY, dirZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationLookAlong_api(java.nio.FloatBuffer dest, int destOffset, float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
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
        dest.put(destOffset + 0, _t26);
        dest.put(destOffset + 1, _t28);
        dest.put(destOffset + 2, _t27);
        dest.put(destOffset + 3, Math.fma(_t7, _t27, -(_t9 * _t28)));
        dest.put(destOffset + 4, Math.fma(_t9, _t26, -(_t8 * _t27)));
        dest.put(destOffset + 5, Math.fma(_t8, _t28, -(_t7 * _t26)));
        dest.put(destOffset + 6, _t8);
        dest.put(destOffset + 7, _t7);
        dest.put(destOffset + 8, _t9);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationLookAlong_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer dir, int dirOffset, java.nio.FloatBuffer up, int upOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _dirBase = UnsafeOpsHolder.U.getLong(dir, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) dirOffset * 4L;
        long _upBase = UnsafeOpsHolder.U.getLong(up, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) upOffset * 4L;
        Float3x3OpsKernelsAddress.makeRotationLookAlong_unsafe(_destBase, _dirBase, _upBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationLookAlong_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer dir, int dirOffset, java.nio.FloatBuffer up, int upOffset) {
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
            _t26 = _t17 * _t22;
            _t27 = _t16 * _t22;
            _t28 = _t18 * _t22;
        } else {
            _t26 = 0.0f;
            _t27 = 0.0f;
            _t28 = 0.0f;
        }
        dest.put(destOffset + 0, _t26);
        dest.put(destOffset + 1, _t28);
        dest.put(destOffset + 2, _t27);
        dest.put(destOffset + 3, Math.fma(_t7, _t27, -(_t9 * _t28)));
        dest.put(destOffset + 4, Math.fma(_t9, _t26, -(_t8 * _t27)));
        dest.put(destOffset + 5, Math.fma(_t8, _t28, -(_t7 * _t26)));
        dest.put(destOffset + 6, _t8);
        dest.put(destOffset + 7, _t7);
        dest.put(destOffset + 8, _t9);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationQuat_unsafe(java.nio.FloatBuffer dest, int destOffset, float qX, float qY, float qZ, float qW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float3x3OpsKernelsAddress.makeRotationQuat_unsafe(_destBase, qX, qY, qZ, qW);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationQuat_api(java.nio.FloatBuffer dest, int destOffset, float qX, float qY, float qZ, float qW) {
        float _t0 = qZ * qZ;
        float _t1 = qZ * qW;
        float _t2 = qY * qW;
        dest.put(destOffset + 0, Math.fma(-2.0f, Math.fma(qY, qY, _t0), 1.0f));
        dest.put(destOffset + 1, 2.0f * Math.fma(qX, qY, _t1));
        dest.put(destOffset + 2, 2.0f * Math.fma(qX, qZ, -_t2));
        dest.put(destOffset + 3, 2.0f * Math.fma(qX, qY, -_t1));
        dest.put(destOffset + 4, Math.fma(-2.0f, Math.fma(qX, qX, _t0), 1.0f));
        dest.put(destOffset + 5, 2.0f * Math.fma(qX, qW, qY * qZ));
        dest.put(destOffset + 6, 2.0f * Math.fma(qX, qZ, _t2));
        dest.put(destOffset + 7, 2.0f * Math.fma(qY, qZ, -(qX * qW)));
        dest.put(destOffset + 8, Math.fma(-2.0f, Math.fma(qX, qX, qY * qY), 1.0f));
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationQuat_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer q, int qOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _qBase = UnsafeOpsHolder.U.getLong(q, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) qOffset * 4L;
        Float3x3OpsKernelsAddress.makeRotationQuat_unsafe(_destBase, _qBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationQuat_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer q, int qOffset) {
        float _qx = q.get(qOffset + 0);
        float _qy = q.get(qOffset + 1);
        float _qz = q.get(qOffset + 2);
        float _qw = q.get(qOffset + 3);
        float _t0 = _qz * _qz;
        float _t1 = _qz * _qw;
        float _t2 = _qy * _qw;
        dest.put(destOffset + 0, Math.fma(-2.0f, Math.fma(_qy, _qy, _t0), 1.0f));
        dest.put(destOffset + 1, 2.0f * Math.fma(_qx, _qy, _t1));
        dest.put(destOffset + 2, 2.0f * Math.fma(_qx, _qz, -_t2));
        dest.put(destOffset + 3, 2.0f * Math.fma(_qx, _qy, -_t1));
        dest.put(destOffset + 4, Math.fma(-2.0f, Math.fma(_qx, _qx, _t0), 1.0f));
        dest.put(destOffset + 5, 2.0f * Math.fma(_qx, _qw, _qy * _qz));
        dest.put(destOffset + 6, 2.0f * Math.fma(_qx, _qz, _t2));
        dest.put(destOffset + 7, 2.0f * Math.fma(_qy, _qz, -(_qx * _qw)));
        dest.put(destOffset + 8, Math.fma(-2.0f, Math.fma(_qx, _qx, _qy * _qy), 1.0f));
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationX_unsafe(java.nio.FloatBuffer dest, int destOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float3x3OpsKernelsAddress.makeRotationX_unsafe(_destBase, angle);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationX_api(java.nio.FloatBuffer dest, int destOffset, float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        dest.put(destOffset + 0, 1.0f);
        dest.put(destOffset + 1, 0.0f);
        dest.put(destOffset + 2, 0.0f);
        dest.put(destOffset + 3, 0.0f);
        dest.put(destOffset + 4, _t0);
        dest.put(destOffset + 5, _t1);
        dest.put(destOffset + 6, 0.0f);
        dest.put(destOffset + 7, -_t1);
        dest.put(destOffset + 8, _t0);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationXYZ_unsafe(java.nio.FloatBuffer dest, int destOffset, float angleX, float angleY, float angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float3x3OpsKernelsAddress.makeRotationXYZ_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationXYZ_api(java.nio.FloatBuffer dest, int destOffset, float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleZ);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.sin(angleX);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t4 * _t3;
        float _t7 = _t3 * _t5;
        dest.put(destOffset + 0, _t0 * _t1);
        dest.put(destOffset + 1, Math.fma(_t6, _t1, _t2 * _t5));
        dest.put(destOffset + 2, Math.fma(_t4, _t2, -(_t7 * _t1)));
        dest.put(destOffset + 3, -(_t2 * _t0));
        dest.put(destOffset + 4, Math.fma(_t5, _t1, -(_t6 * _t2)));
        dest.put(destOffset + 5, Math.fma(_t7, _t2, _t4 * _t1));
        dest.put(destOffset + 6, _t3);
        dest.put(destOffset + 7, -(_t4 * _t0));
        dest.put(destOffset + 8, _t5 * _t0);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationXZY_unsafe(java.nio.FloatBuffer dest, int destOffset, float angleX, float angleY, float angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float3x3OpsKernelsAddress.makeRotationXZY_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationXZY_api(java.nio.FloatBuffer dest, int destOffset, float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleZ);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.cos(angleX);
        float _t5 = (float) Math.sin(angleX);
        float _t6 = _t2 * _t4;
        float _t7 = _t5 * _t2;
        dest.put(destOffset + 0, _t0 * _t1);
        dest.put(destOffset + 1, Math.fma(_t6, _t0, _t5 * _t3));
        dest.put(destOffset + 2, Math.fma(_t7, _t0, -(_t3 * _t4)));
        dest.put(destOffset + 3, -_t2);
        dest.put(destOffset + 4, _t4 * _t1);
        dest.put(destOffset + 5, _t5 * _t1);
        dest.put(destOffset + 6, _t3 * _t1);
        dest.put(destOffset + 7, Math.fma(_t6, _t3, -(_t5 * _t0)));
        dest.put(destOffset + 8, Math.fma(_t7, _t3, _t4 * _t0));
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationY_unsafe(java.nio.FloatBuffer dest, int destOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float3x3OpsKernelsAddress.makeRotationY_unsafe(_destBase, angle);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationY_api(java.nio.FloatBuffer dest, int destOffset, float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        dest.put(destOffset + 0, _t0);
        dest.put(destOffset + 1, 0.0f);
        dest.put(destOffset + 2, -_t1);
        dest.put(destOffset + 3, 0.0f);
        dest.put(destOffset + 4, 1.0f);
        dest.put(destOffset + 5, 0.0f);
        dest.put(destOffset + 6, _t1);
        dest.put(destOffset + 7, 0.0f);
        dest.put(destOffset + 8, _t0);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationYXZ_unsafe(java.nio.FloatBuffer dest, int destOffset, float angleX, float angleY, float angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float3x3OpsKernelsAddress.makeRotationYXZ_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationYXZ_api(java.nio.FloatBuffer dest, int destOffset, float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.sin(angleX);
        float _t1 = (float) Math.sin(angleY);
        float _t2 = (float) Math.sin(angleZ);
        float _t3 = (float) Math.cos(angleY);
        float _t4 = (float) Math.cos(angleZ);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t0 * _t1;
        float _t7 = _t0 * _t3;
        dest.put(destOffset + 0, Math.fma(_t6, _t2, _t3 * _t4));
        dest.put(destOffset + 1, _t2 * _t5);
        dest.put(destOffset + 2, Math.fma(_t7, _t2, -(_t1 * _t4)));
        dest.put(destOffset + 3, Math.fma(_t6, _t4, -(_t2 * _t3)));
        dest.put(destOffset + 4, _t5 * _t4);
        dest.put(destOffset + 5, Math.fma(_t7, _t4, _t1 * _t2));
        dest.put(destOffset + 6, _t1 * _t5);
        dest.put(destOffset + 7, -_t0);
        dest.put(destOffset + 8, _t5 * _t3);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationYZX_unsafe(java.nio.FloatBuffer dest, int destOffset, float angleX, float angleY, float angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float3x3OpsKernelsAddress.makeRotationYZX_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationYZX_api(java.nio.FloatBuffer dest, int destOffset, float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleX);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.sin(angleZ);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t4 * _t0;
        float _t7 = _t3 * _t4;
        dest.put(destOffset + 0, _t0 * _t1);
        dest.put(destOffset + 1, _t4);
        dest.put(destOffset + 2, -(_t3 * _t1));
        dest.put(destOffset + 3, Math.fma(_t2, _t3, -(_t6 * _t5)));
        dest.put(destOffset + 4, _t5 * _t1);
        dest.put(destOffset + 5, Math.fma(_t7, _t5, _t2 * _t0));
        dest.put(destOffset + 6, Math.fma(_t6, _t2, _t3 * _t5));
        dest.put(destOffset + 7, -(_t2 * _t1));
        dest.put(destOffset + 8, Math.fma(_t5, _t0, -(_t7 * _t2)));
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationZXY_unsafe(java.nio.FloatBuffer dest, int destOffset, float angleX, float angleY, float angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float3x3OpsKernelsAddress.makeRotationZXY_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationZXY_api(java.nio.FloatBuffer dest, int destOffset, float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleX);
        float _t3 = (float) Math.sin(angleZ);
        float _t4 = (float) Math.sin(angleY);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t2 * _t3;
        float _t7 = _t2 * _t1;
        dest.put(destOffset + 0, Math.fma(_t0, _t1, -(_t6 * _t4)));
        dest.put(destOffset + 1, Math.fma(_t7, _t4, _t3 * _t0));
        dest.put(destOffset + 2, -(_t4 * _t5));
        dest.put(destOffset + 3, -(_t3 * _t5));
        dest.put(destOffset + 4, _t5 * _t1);
        dest.put(destOffset + 5, _t2);
        dest.put(destOffset + 6, Math.fma(_t6, _t0, _t4 * _t1));
        dest.put(destOffset + 7, Math.fma(_t4, _t3, -(_t7 * _t0)));
        dest.put(destOffset + 8, _t5 * _t0);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationZYX_unsafe(java.nio.FloatBuffer dest, int destOffset, float angleX, float angleY, float angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float3x3OpsKernelsAddress.makeRotationZYX_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.FloatBuffer makeRotationZYX_api(java.nio.FloatBuffer dest, int destOffset, float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleY);
        float _t3 = (float) Math.sin(angleX);
        float _t4 = (float) Math.sin(angleZ);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t2 * _t1;
        float _t7 = _t2 * _t4;
        dest.put(destOffset + 0, _t0 * _t1);
        dest.put(destOffset + 1, _t4 * _t0);
        dest.put(destOffset + 2, -_t2);
        dest.put(destOffset + 3, Math.fma(_t6, _t3, -(_t4 * _t5)));
        dest.put(destOffset + 4, Math.fma(_t7, _t3, _t5 * _t1));
        dest.put(destOffset + 5, _t3 * _t0);
        dest.put(destOffset + 6, Math.fma(_t6, _t5, _t3 * _t4));
        dest.put(destOffset + 7, Math.fma(_t7, _t5, -(_t3 * _t1)));
        dest.put(destOffset + 8, _t5 * _t0);
        return dest;
    }

    public static java.nio.FloatBuffer makeScaling_unsafe(java.nio.FloatBuffer dest, int destOffset, float vX, float vY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float3x3OpsKernelsAddress.makeScaling_unsafe(_destBase, vX, vY);
        return dest;
    }

    public static java.nio.FloatBuffer makeScaling_api(java.nio.FloatBuffer dest, int destOffset, float vX, float vY) {
        dest.put(destOffset + 0, vX);
        dest.put(destOffset + 1, 0.0f);
        dest.put(destOffset + 2, 0.0f);
        dest.put(destOffset + 3, 0.0f);
        dest.put(destOffset + 4, vY);
        dest.put(destOffset + 5, 0.0f);
        dest.put(destOffset + 6, 0.0f);
        dest.put(destOffset + 7, 0.0f);
        dest.put(destOffset + 8, 1.0f);
        return dest;
    }

    public static java.nio.FloatBuffer makeScaling_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 4L;
        Float3x3OpsKernelsAddress.makeScaling_unsafe(_destBase, _vBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeScaling_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer v, int vOffset) {
        float _vx = v.get(vOffset + 0);
        float _vy = v.get(vOffset + 1);
        dest.put(destOffset + 0, _vx);
        dest.put(destOffset + 1, 0.0f);
        dest.put(destOffset + 2, 0.0f);
        dest.put(destOffset + 3, 0.0f);
        dest.put(destOffset + 4, _vy);
        dest.put(destOffset + 5, 0.0f);
        dest.put(destOffset + 6, 0.0f);
        dest.put(destOffset + 7, 0.0f);
        dest.put(destOffset + 8, 1.0f);
        return dest;
    }

    public static java.nio.FloatBuffer makeScaling_unsafe(java.nio.FloatBuffer dest, int destOffset, float s) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float3x3OpsKernelsAddress.makeScaling_unsafe(_destBase, s);
        return dest;
    }

    public static java.nio.FloatBuffer makeScaling_api(java.nio.FloatBuffer dest, int destOffset, float s) {
        dest.put(destOffset + 0, s);
        dest.put(destOffset + 1, 0.0f);
        dest.put(destOffset + 2, 0.0f);
        dest.put(destOffset + 3, 0.0f);
        dest.put(destOffset + 4, s);
        dest.put(destOffset + 5, 0.0f);
        dest.put(destOffset + 6, 0.0f);
        dest.put(destOffset + 7, 0.0f);
        dest.put(destOffset + 8, 1.0f);
        return dest;
    }

    public static java.nio.FloatBuffer makeTranslation_unsafe(java.nio.FloatBuffer dest, int destOffset, float vX, float vY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float3x3OpsKernelsAddress.makeTranslation_unsafe(_destBase, vX, vY);
        return dest;
    }

    public static java.nio.FloatBuffer makeTranslation_api(java.nio.FloatBuffer dest, int destOffset, float vX, float vY) {
        dest.put(destOffset + 0, 1.0f);
        dest.put(destOffset + 1, 0.0f);
        dest.put(destOffset + 2, 0.0f);
        dest.put(destOffset + 3, 0.0f);
        dest.put(destOffset + 4, 1.0f);
        dest.put(destOffset + 5, 0.0f);
        dest.put(destOffset + 6, vX);
        dest.put(destOffset + 7, vY);
        dest.put(destOffset + 8, 1.0f);
        return dest;
    }

    public static java.nio.FloatBuffer makeTranslation_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 4L;
        Float3x3OpsKernelsAddress.makeTranslation_unsafe(_destBase, _vBase);
        return dest;
    }

    public static java.nio.FloatBuffer makeTranslation_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer v, int vOffset) {
        float _vx = v.get(vOffset + 0);
        float _vy = v.get(vOffset + 1);
        dest.put(destOffset + 0, 1.0f);
        dest.put(destOffset + 1, 0.0f);
        dest.put(destOffset + 2, 0.0f);
        dest.put(destOffset + 3, 0.0f);
        dest.put(destOffset + 4, 1.0f);
        dest.put(destOffset + 5, 0.0f);
        dest.put(destOffset + 6, _vx);
        dest.put(destOffset + 7, _vy);
        dest.put(destOffset + 8, 1.0f);
        return dest;
    }

    public static java.nio.FloatBuffer makeView_unsafe(java.nio.FloatBuffer dest, int destOffset, float left, float right, float bottom, float top) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        Float3x3OpsKernelsAddress.makeView_unsafe(_destBase, left, right, bottom, top);
        return dest;
    }

    public static java.nio.FloatBuffer makeView_api(java.nio.FloatBuffer dest, int destOffset, float left, float right, float bottom, float top) {
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        dest.put(destOffset + 0, 2.0f * _t0_inv);
        dest.put(destOffset + 1, 0.0f);
        dest.put(destOffset + 2, 0.0f);
        dest.put(destOffset + 3, 0.0f);
        dest.put(destOffset + 4, 2.0f * _t1_inv);
        dest.put(destOffset + 5, 0.0f);
        dest.put(destOffset + 6, -((left + right) * _t0_inv));
        dest.put(destOffset + 7, -((bottom + top) * _t1_inv));
        dest.put(destOffset + 8, 1.0f);
        return dest;
    }

    public static java.nio.FloatBuffer preRotate_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.preRotate_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.FloatBuffer preRotate_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        dest.put(destOffset + 0, Math.fma(_self00, _t0, -(_self10 * _t1)));
        dest.put(destOffset + 1, Math.fma(_self00, _t1, _self10 * _t0));
        dest.put(destOffset + 2, _self20);
        dest.put(destOffset + 3, Math.fma(_self01, _t0, -(_self11 * _t1)));
        dest.put(destOffset + 4, Math.fma(_self01, _t1, _self11 * _t0));
        dest.put(destOffset + 5, _self21);
        dest.put(destOffset + 6, Math.fma(_self02, _t0, -(_self12 * _t1)));
        dest.put(destOffset + 7, Math.fma(_self02, _t1, _self12 * _t0));
        dest.put(destOffset + 8, _self22);
        return dest;
    }

    public static java.nio.FloatBuffer preRotateAround_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle, float pivotX, float pivotY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.preRotateAround_unsafe(_destBase, _srcBase, angle, pivotX, pivotY);
        return dest;
    }

    public static java.nio.FloatBuffer preRotateAround_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle, float pivotX, float pivotY) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        float _t0 = (float) Math.sin(angle);
        float _t1 = (float) Math.cos(angle);
        float _t3 = (float) Math.sin(0.5f * angle);
        float _t8 = 2.0f * _t3 * _t3;
        float _t9 = Math.fma(pivotX, _t8, pivotY * _t0);
        float _t10 = Math.fma(pivotY, _t8, -(pivotX * _t0));
        dest.put(destOffset + 0, Math.fma(_self20, _t9, Math.fma(_self00, _t1, -(_self10 * _t0))));
        dest.put(destOffset + 1, Math.fma(_self20, _t10, Math.fma(_self00, _t0, _self10 * _t1)));
        dest.put(destOffset + 2, _self20);
        dest.put(destOffset + 3, Math.fma(_self21, _t9, Math.fma(_self01, _t1, -(_self11 * _t0))));
        dest.put(destOffset + 4, Math.fma(_self21, _t10, Math.fma(_self01, _t0, _self11 * _t1)));
        dest.put(destOffset + 5, _self21);
        dest.put(destOffset + 6, Math.fma(_self22, _t9, Math.fma(_self02, _t1, -(_self12 * _t0))));
        dest.put(destOffset + 7, Math.fma(_self22, _t10, Math.fma(_self02, _t0, _self12 * _t1)));
        dest.put(destOffset + 8, _self22);
        return dest;
    }

    public static java.nio.FloatBuffer preRotateAround_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer pivot, int pivotOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _pivotBase = UnsafeOpsHolder.U.getLong(pivot, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pivotOffset * 4L;
        Float3x3OpsKernelsAddress.preRotateAround_unsafe(_destBase, _srcBase, _pivotBase, angle);
        return dest;
    }

    public static java.nio.FloatBuffer preRotateAround_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer pivot, int pivotOffset, float angle) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        float _pivotx = pivot.get(pivotOffset + 0);
        float _pivoty = pivot.get(pivotOffset + 1);
        float _t0 = (float) Math.sin(angle);
        float _t1 = (float) Math.cos(angle);
        float _t3 = (float) Math.sin(0.5f * angle);
        float _t8 = 2.0f * _t3 * _t3;
        float _t9 = Math.fma(_pivotx, _t8, _pivoty * _t0);
        float _t10 = Math.fma(_pivoty, _t8, -(_pivotx * _t0));
        dest.put(destOffset + 0, Math.fma(_self20, _t9, Math.fma(_self00, _t1, -(_self10 * _t0))));
        dest.put(destOffset + 1, Math.fma(_self20, _t10, Math.fma(_self00, _t0, _self10 * _t1)));
        dest.put(destOffset + 2, _self20);
        dest.put(destOffset + 3, Math.fma(_self21, _t9, Math.fma(_self01, _t1, -(_self11 * _t0))));
        dest.put(destOffset + 4, Math.fma(_self21, _t10, Math.fma(_self01, _t0, _self11 * _t1)));
        dest.put(destOffset + 5, _self21);
        dest.put(destOffset + 6, Math.fma(_self22, _t9, Math.fma(_self02, _t1, -(_self12 * _t0))));
        dest.put(destOffset + 7, Math.fma(_self22, _t10, Math.fma(_self02, _t0, _self12 * _t1)));
        dest.put(destOffset + 8, _self22);
        return dest;
    }

    public static java.nio.FloatBuffer preRotateAxis_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle, float axisX, float axisY, float axisZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.preRotateAxis_unsafe(_destBase, _srcBase, angle, axisX, axisY, axisZ);
        return dest;
    }

    public static java.nio.FloatBuffer preRotateAxis_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle, float axisX, float axisY, float axisZ) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
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
        dest.put(destOffset + 0, Math.fma(_self20, _t21, Math.fma(_self00, _t18, _self10 * _t24)));
        dest.put(destOffset + 1, Math.fma(_self20, _t25, Math.fma(_self00, _t22, _self10 * _t19)));
        dest.put(destOffset + 2, Math.fma(_self20, _t20, Math.fma(_self00, _t26, _self10 * _t23)));
        dest.put(destOffset + 3, Math.fma(_self21, _t21, Math.fma(_self01, _t18, _self11 * _t24)));
        dest.put(destOffset + 4, Math.fma(_self21, _t25, Math.fma(_self01, _t22, _self11 * _t19)));
        dest.put(destOffset + 5, Math.fma(_self21, _t20, Math.fma(_self01, _t26, _self11 * _t23)));
        dest.put(destOffset + 6, Math.fma(_self22, _t21, Math.fma(_self02, _t18, _self12 * _t24)));
        dest.put(destOffset + 7, Math.fma(_self22, _t25, Math.fma(_self02, _t22, _self12 * _t19)));
        dest.put(destOffset + 8, Math.fma(_self22, _t20, Math.fma(_self02, _t26, _self12 * _t23)));
        return dest;
    }

    public static java.nio.FloatBuffer preRotateAxis_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer axis, int axisOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _axisBase = UnsafeOpsHolder.U.getLong(axis, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) axisOffset * 4L;
        Float3x3OpsKernelsAddress.preRotateAxis_unsafe(_destBase, _srcBase, _axisBase, angle);
        return dest;
    }

    public static java.nio.FloatBuffer preRotateAxis_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer axis, int axisOffset, float angle) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        float _axisx = axis.get(axisOffset + 0);
        float _axisy = axis.get(axisOffset + 1);
        float _axisz = axis.get(axisOffset + 2);
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
        dest.put(destOffset + 0, Math.fma(_self20, _t21, Math.fma(_self00, _t18, _self10 * _t24)));
        dest.put(destOffset + 1, Math.fma(_self20, _t25, Math.fma(_self00, _t22, _self10 * _t19)));
        dest.put(destOffset + 2, Math.fma(_self20, _t20, Math.fma(_self00, _t26, _self10 * _t23)));
        dest.put(destOffset + 3, Math.fma(_self21, _t21, Math.fma(_self01, _t18, _self11 * _t24)));
        dest.put(destOffset + 4, Math.fma(_self21, _t25, Math.fma(_self01, _t22, _self11 * _t19)));
        dest.put(destOffset + 5, Math.fma(_self21, _t20, Math.fma(_self01, _t26, _self11 * _t23)));
        dest.put(destOffset + 6, Math.fma(_self22, _t21, Math.fma(_self02, _t18, _self12 * _t24)));
        dest.put(destOffset + 7, Math.fma(_self22, _t25, Math.fma(_self02, _t22, _self12 * _t19)));
        dest.put(destOffset + 8, Math.fma(_self22, _t20, Math.fma(_self02, _t26, _self12 * _t23)));
        return dest;
    }

    public static java.nio.FloatBuffer preRotateX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.preRotateX_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.FloatBuffer preRotateX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        dest.put(destOffset + 0, _self00);
        dest.put(destOffset + 1, Math.fma(_self10, _t0, -(_self20 * _t1)));
        dest.put(destOffset + 2, Math.fma(_self10, _t1, _self20 * _t0));
        dest.put(destOffset + 3, _self01);
        dest.put(destOffset + 4, Math.fma(_self11, _t0, -(_self21 * _t1)));
        dest.put(destOffset + 5, Math.fma(_self11, _t1, _self21 * _t0));
        dest.put(destOffset + 6, _self02);
        dest.put(destOffset + 7, Math.fma(_self12, _t0, -(_self22 * _t1)));
        dest.put(destOffset + 8, Math.fma(_self12, _t1, _self22 * _t0));
        return dest;
    }

    public static java.nio.FloatBuffer preRotateY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.preRotateY_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.FloatBuffer preRotateY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        dest.put(destOffset + 0, Math.fma(_self00, _t0, _self20 * _t1));
        dest.put(destOffset + 1, _self10);
        dest.put(destOffset + 2, Math.fma(_self20, _t0, -(_self00 * _t1)));
        dest.put(destOffset + 3, Math.fma(_self01, _t0, _self21 * _t1));
        dest.put(destOffset + 4, _self11);
        dest.put(destOffset + 5, Math.fma(_self21, _t0, -(_self01 * _t1)));
        dest.put(destOffset + 6, Math.fma(_self02, _t0, _self22 * _t1));
        dest.put(destOffset + 7, _self12);
        dest.put(destOffset + 8, Math.fma(_self22, _t0, -(_self02 * _t1)));
        return dest;
    }

    public static java.nio.FloatBuffer preScale_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float vX, float vY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.preScale_unsafe(_destBase, _srcBase, vX, vY);
        return dest;
    }

    public static java.nio.FloatBuffer preScale_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float vX, float vY) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 3;
            float _eself0 = src.get(srcOffset + _lo);
            float _eself1 = src.get(srcOffset + _lo + 1);
            float _eself2 = src.get(srcOffset + _lo + 2);
            dest.put(destOffset + _lo, _eself0 * vX);
            dest.put(destOffset + _lo + 1, _eself1 * vY);
            dest.put(destOffset + _lo + 2, _eself2);
        }
        return dest;
    }

    public static java.nio.FloatBuffer preScale_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 4L;
        Float3x3OpsKernelsAddress.preScale_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.FloatBuffer preScale_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer v, int vOffset) {
        float _vx = v.get(vOffset + 0);
        float _vy = v.get(vOffset + 1);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 3;
            float _eself0 = src.get(srcOffset + _lo);
            float _eself1 = src.get(srcOffset + _lo + 1);
            float _eself2 = src.get(srcOffset + _lo + 2);
            dest.put(destOffset + _lo, _eself0 * _vx);
            dest.put(destOffset + _lo + 1, _eself1 * _vy);
            dest.put(destOffset + _lo + 2, _eself2);
        }
        return dest;
    }

    public static java.nio.FloatBuffer preScale_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float s) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.preScale_unsafe(_destBase, _srcBase, s);
        return dest;
    }

    public static java.nio.FloatBuffer preScale_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float s) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 3;
            float _eself0 = src.get(srcOffset + _lo);
            float _eself1 = src.get(srcOffset + _lo + 1);
            float _eself2 = src.get(srcOffset + _lo + 2);
            dest.put(destOffset + _lo, s * _eself0);
            dest.put(destOffset + _lo + 1, s * _eself1);
            dest.put(destOffset + _lo + 2, _eself2);
        }
        return dest;
    }

    public static java.nio.FloatBuffer preScaleAround_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float s, float pivotX, float pivotY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.preScaleAround_unsafe(_destBase, _srcBase, s, pivotX, pivotY);
        return dest;
    }

    public static java.nio.FloatBuffer preScaleAround_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float s, float pivotX, float pivotY) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        float _t0 = Math.fma(-s, pivotX, pivotX);
        float _t1 = Math.fma(-s, pivotY, pivotY);
        dest.put(destOffset + 0, Math.fma(s, _self00, _self20 * _t0));
        dest.put(destOffset + 1, Math.fma(s, _self10, _self20 * _t1));
        dest.put(destOffset + 2, _self20);
        dest.put(destOffset + 3, Math.fma(s, _self01, _self21 * _t0));
        dest.put(destOffset + 4, Math.fma(s, _self11, _self21 * _t1));
        dest.put(destOffset + 5, _self21);
        dest.put(destOffset + 6, Math.fma(s, _self02, _self22 * _t0));
        dest.put(destOffset + 7, Math.fma(s, _self12, _self22 * _t1));
        dest.put(destOffset + 8, _self22);
        return dest;
    }

    public static java.nio.FloatBuffer preScaleAround_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer pivot, int pivotOffset, float s) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _pivotBase = UnsafeOpsHolder.U.getLong(pivot, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pivotOffset * 4L;
        Float3x3OpsKernelsAddress.preScaleAround_unsafe(_destBase, _srcBase, _pivotBase, s);
        return dest;
    }

    public static java.nio.FloatBuffer preScaleAround_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer pivot, int pivotOffset, float s) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        float _pivotx = pivot.get(pivotOffset + 0);
        float _pivoty = pivot.get(pivotOffset + 1);
        float _t0 = Math.fma(-s, _pivotx, _pivotx);
        float _t1 = Math.fma(-s, _pivoty, _pivoty);
        dest.put(destOffset + 0, Math.fma(s, _self00, _self20 * _t0));
        dest.put(destOffset + 1, Math.fma(s, _self10, _self20 * _t1));
        dest.put(destOffset + 2, _self20);
        dest.put(destOffset + 3, Math.fma(s, _self01, _self21 * _t0));
        dest.put(destOffset + 4, Math.fma(s, _self11, _self21 * _t1));
        dest.put(destOffset + 5, _self21);
        dest.put(destOffset + 6, Math.fma(s, _self02, _self22 * _t0));
        dest.put(destOffset + 7, Math.fma(s, _self12, _self22 * _t1));
        dest.put(destOffset + 8, _self22);
        return dest;
    }

    public static java.nio.FloatBuffer preScaleAround_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float sX, float sY, float pivotX, float pivotY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.preScaleAround_unsafe(_destBase, _srcBase, sX, sY, pivotX, pivotY);
        return dest;
    }

    public static java.nio.FloatBuffer preScaleAround_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float sX, float sY, float pivotX, float pivotY) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        float _t2 = Math.fma(-pivotX, sX, pivotX);
        float _t3 = Math.fma(-pivotY, sY, pivotY);
        dest.put(destOffset + 0, Math.fma(sX, _self00, _self20 * _t2));
        dest.put(destOffset + 1, Math.fma(sY, _self10, _self20 * _t3));
        dest.put(destOffset + 2, _self20);
        dest.put(destOffset + 3, Math.fma(sX, _self01, _self21 * _t2));
        dest.put(destOffset + 4, Math.fma(sY, _self11, _self21 * _t3));
        dest.put(destOffset + 5, _self21);
        dest.put(destOffset + 6, Math.fma(sX, _self02, _self22 * _t2));
        dest.put(destOffset + 7, Math.fma(sY, _self12, _self22 * _t3));
        dest.put(destOffset + 8, _self22);
        return dest;
    }

    public static java.nio.FloatBuffer preScaleAround_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer s, int sOffset, java.nio.FloatBuffer pivot, int pivotOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _sBase = UnsafeOpsHolder.U.getLong(s, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) sOffset * 4L;
        long _pivotBase = UnsafeOpsHolder.U.getLong(pivot, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pivotOffset * 4L;
        Float3x3OpsKernelsAddress.preScaleAround_unsafe(_destBase, _srcBase, _sBase, _pivotBase);
        return dest;
    }

    public static java.nio.FloatBuffer preScaleAround_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer s, int sOffset, java.nio.FloatBuffer pivot, int pivotOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        float _sx = s.get(sOffset + 0);
        float _sy = s.get(sOffset + 1);
        float _pivotx = pivot.get(pivotOffset + 0);
        float _pivoty = pivot.get(pivotOffset + 1);
        float _t2 = Math.fma(-_pivotx, _sx, _pivotx);
        float _t3 = Math.fma(-_pivoty, _sy, _pivoty);
        dest.put(destOffset + 0, Math.fma(_sx, _self00, _self20 * _t2));
        dest.put(destOffset + 1, Math.fma(_sy, _self10, _self20 * _t3));
        dest.put(destOffset + 2, _self20);
        dest.put(destOffset + 3, Math.fma(_sx, _self01, _self21 * _t2));
        dest.put(destOffset + 4, Math.fma(_sy, _self11, _self21 * _t3));
        dest.put(destOffset + 5, _self21);
        dest.put(destOffset + 6, Math.fma(_sx, _self02, _self22 * _t2));
        dest.put(destOffset + 7, Math.fma(_sy, _self12, _self22 * _t3));
        dest.put(destOffset + 8, _self22);
        return dest;
    }

    public static java.nio.FloatBuffer preTranslate_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float vX, float vY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.preTranslate_unsafe(_destBase, _srcBase, vX, vY);
        return dest;
    }

    public static java.nio.FloatBuffer preTranslate_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float vX, float vY) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 3;
            float _eself0 = src.get(srcOffset + _lo);
            float _eself1 = src.get(srcOffset + _lo + 1);
            float _eself2 = src.get(srcOffset + _lo + 2);
            dest.put(destOffset + _lo, Math.fma(_eself2, vX, _eself0));
            dest.put(destOffset + _lo + 1, Math.fma(_eself2, vY, _eself1));
            dest.put(destOffset + _lo + 2, _eself2);
        }
        return dest;
    }

    public static java.nio.FloatBuffer preTranslate_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 4L;
        Float3x3OpsKernelsAddress.preTranslate_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.FloatBuffer preTranslate_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer v, int vOffset) {
        float _vx = v.get(vOffset + 0);
        float _vy = v.get(vOffset + 1);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 3;
            float _eself0 = src.get(srcOffset + _lo);
            float _eself1 = src.get(srcOffset + _lo + 1);
            float _eself2 = src.get(srcOffset + _lo + 2);
            dest.put(destOffset + _lo, Math.fma(_eself2, _vx, _eself0));
            dest.put(destOffset + _lo + 1, Math.fma(_eself2, _vy, _eself1));
            dest.put(destOffset + _lo + 2, _eself2);
        }
        return dest;
    }

    public static java.nio.FloatBuffer rotate_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.rotate_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.FloatBuffer rotate_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        dest.put(destOffset + 0, Math.fma(_self00, _t0, _self01 * _t1));
        dest.put(destOffset + 1, Math.fma(_self10, _t0, _self11 * _t1));
        dest.put(destOffset + 2, Math.fma(_self20, _t0, _self21 * _t1));
        dest.put(destOffset + 3, Math.fma(_self01, _t0, -(_self00 * _t1)));
        dest.put(destOffset + 4, Math.fma(_self11, _t0, -(_self10 * _t1)));
        dest.put(destOffset + 5, Math.fma(_self21, _t0, -(_self20 * _t1)));
        dest.put(destOffset + 6, _self02);
        dest.put(destOffset + 7, _self12);
        dest.put(destOffset + 8, _self22);
        return dest;
    }

    public static java.nio.FloatBuffer rotateAround_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle, float pivotX, float pivotY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.rotateAround_unsafe(_destBase, _srcBase, angle, pivotX, pivotY);
        return dest;
    }

    public static java.nio.FloatBuffer rotateAround_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle, float pivotX, float pivotY) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t3 = (float) Math.sin(0.5f * angle);
        float _t8 = 2.0f * _t3 * _t3;
        float _t9 = Math.fma(pivotX, _t8, pivotY * _t1);
        float _t10 = Math.fma(pivotY, _t8, -(pivotX * _t1));
        dest.put(destOffset + 0, Math.fma(_self00, _t0, _self01 * _t1));
        dest.put(destOffset + 1, Math.fma(_self10, _t0, _self11 * _t1));
        dest.put(destOffset + 2, Math.fma(_self20, _t0, _self21 * _t1));
        dest.put(destOffset + 3, Math.fma(_self01, _t0, -(_self00 * _t1)));
        dest.put(destOffset + 4, Math.fma(_self11, _t0, -(_self10 * _t1)));
        dest.put(destOffset + 5, Math.fma(_self21, _t0, -(_self20 * _t1)));
        dest.put(destOffset + 6, Math.fma(_self00, _t9, Math.fma(_self01, _t10, _self02)));
        dest.put(destOffset + 7, Math.fma(_self10, _t9, Math.fma(_self11, _t10, _self12)));
        dest.put(destOffset + 8, Math.fma(_self20, _t9, Math.fma(_self21, _t10, _self22)));
        return dest;
    }

    public static java.nio.FloatBuffer rotateAround_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer pivot, int pivotOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _pivotBase = UnsafeOpsHolder.U.getLong(pivot, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pivotOffset * 4L;
        Float3x3OpsKernelsAddress.rotateAround_unsafe(_destBase, _srcBase, _pivotBase, angle);
        return dest;
    }

    public static java.nio.FloatBuffer rotateAround_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer pivot, int pivotOffset, float angle) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        float _pivotx = pivot.get(pivotOffset + 0);
        float _pivoty = pivot.get(pivotOffset + 1);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t3 = (float) Math.sin(0.5f * angle);
        float _t8 = 2.0f * _t3 * _t3;
        float _t9 = Math.fma(_pivotx, _t8, _pivoty * _t1);
        float _t10 = Math.fma(_pivoty, _t8, -(_pivotx * _t1));
        dest.put(destOffset + 0, Math.fma(_self00, _t0, _self01 * _t1));
        dest.put(destOffset + 1, Math.fma(_self10, _t0, _self11 * _t1));
        dest.put(destOffset + 2, Math.fma(_self20, _t0, _self21 * _t1));
        dest.put(destOffset + 3, Math.fma(_self01, _t0, -(_self00 * _t1)));
        dest.put(destOffset + 4, Math.fma(_self11, _t0, -(_self10 * _t1)));
        dest.put(destOffset + 5, Math.fma(_self21, _t0, -(_self20 * _t1)));
        dest.put(destOffset + 6, Math.fma(_self00, _t9, Math.fma(_self01, _t10, _self02)));
        dest.put(destOffset + 7, Math.fma(_self10, _t9, Math.fma(_self11, _t10, _self12)));
        dest.put(destOffset + 8, Math.fma(_self20, _t9, Math.fma(_self21, _t10, _self22)));
        return dest;
    }

    public static java.nio.FloatBuffer rotateAxis_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle, float axisX, float axisY, float axisZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.rotateAxis_unsafe(_destBase, _srcBase, angle, axisX, axisY, axisZ);
        return dest;
    }

    public static java.nio.FloatBuffer rotateAxis_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle, float axisX, float axisY, float axisZ) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
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
        dest.put(destOffset + 3, Math.fma(_self02, _t22, Math.fma(_self00, _t25, _self01 * _t19)));
        dest.put(destOffset + 4, Math.fma(_self12, _t22, Math.fma(_self10, _t25, _self11 * _t19)));
        dest.put(destOffset + 5, Math.fma(_self22, _t22, Math.fma(_self20, _t25, _self21 * _t19)));
        dest.put(destOffset + 6, Math.fma(_self02, _t20, Math.fma(_self00, _t23, _self01 * _t26)));
        dest.put(destOffset + 7, Math.fma(_self12, _t20, Math.fma(_self10, _t23, _self11 * _t26)));
        dest.put(destOffset + 8, Math.fma(_self22, _t20, Math.fma(_self20, _t23, _self21 * _t26)));
        return dest;
    }

    public static java.nio.FloatBuffer rotateAxis_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer axis, int axisOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _axisBase = UnsafeOpsHolder.U.getLong(axis, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) axisOffset * 4L;
        Float3x3OpsKernelsAddress.rotateAxis_unsafe(_destBase, _srcBase, _axisBase, angle);
        return dest;
    }

    public static java.nio.FloatBuffer rotateAxis_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer axis, int axisOffset, float angle) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
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
        dest.put(destOffset + 3, Math.fma(_self02, _t22, Math.fma(_self00, _t25, _self01 * _t19)));
        dest.put(destOffset + 4, Math.fma(_self12, _t22, Math.fma(_self10, _t25, _self11 * _t19)));
        dest.put(destOffset + 5, Math.fma(_self22, _t22, Math.fma(_self20, _t25, _self21 * _t19)));
        dest.put(destOffset + 6, Math.fma(_self02, _t20, Math.fma(_self00, _t23, _self01 * _t26)));
        dest.put(destOffset + 7, Math.fma(_self12, _t20, Math.fma(_self10, _t23, _self11 * _t26)));
        dest.put(destOffset + 8, Math.fma(_self22, _t20, Math.fma(_self20, _t23, _self21 * _t26)));
        return dest;
    }

    public static java.nio.FloatBuffer rotateX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.rotateX_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.FloatBuffer rotateX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        dest.put(destOffset + 0, _self00);
        dest.put(destOffset + 1, _self10);
        dest.put(destOffset + 2, _self20);
        dest.put(destOffset + 3, Math.fma(_self01, _t0, _self02 * _t1));
        dest.put(destOffset + 4, Math.fma(_self11, _t0, _self12 * _t1));
        dest.put(destOffset + 5, Math.fma(_self21, _t0, _self22 * _t1));
        dest.put(destOffset + 6, Math.fma(_self02, _t0, -(_self01 * _t1)));
        dest.put(destOffset + 7, Math.fma(_self12, _t0, -(_self11 * _t1)));
        dest.put(destOffset + 8, Math.fma(_self22, _t0, -(_self21 * _t1)));
        return dest;
    }

    public static java.nio.FloatBuffer rotateX180_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.rotateX180_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer rotateX180_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        dest.put(destOffset + 0, _self00);
        dest.put(destOffset + 1, _self10);
        dest.put(destOffset + 2, _self20);
        dest.put(destOffset + 3, -_self01);
        dest.put(destOffset + 4, -_self11);
        dest.put(destOffset + 5, -_self21);
        dest.put(destOffset + 6, -_self02);
        dest.put(destOffset + 7, -_self12);
        dest.put(destOffset + 8, -_self22);
        return dest;
    }

    public static java.nio.FloatBuffer rotateX270_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.rotateX270_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer rotateX270_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        dest.put(destOffset + 0, _self00);
        dest.put(destOffset + 1, _self10);
        dest.put(destOffset + 2, _self20);
        dest.put(destOffset + 3, -_self02);
        dest.put(destOffset + 4, -_self12);
        dest.put(destOffset + 5, -_self22);
        dest.put(destOffset + 6, _self01);
        dest.put(destOffset + 7, _self11);
        dest.put(destOffset + 8, _self21);
        return dest;
    }

    public static java.nio.FloatBuffer rotateX90_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.rotateX90_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer rotateX90_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        dest.put(destOffset + 0, _self00);
        dest.put(destOffset + 1, _self10);
        dest.put(destOffset + 2, _self20);
        dest.put(destOffset + 3, _self02);
        dest.put(destOffset + 4, _self12);
        dest.put(destOffset + 5, _self22);
        dest.put(destOffset + 6, -_self01);
        dest.put(destOffset + 7, -_self11);
        dest.put(destOffset + 8, -_self21);
        return dest;
    }

    public static java.nio.FloatBuffer rotateXYZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.rotateXYZ_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.FloatBuffer rotateXYZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
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
        dest.put(destOffset + 3, Math.fma(_self02, _t19, Math.fma(_self01, _t21, -(_self00 * _t11))));
        dest.put(destOffset + 4, Math.fma(_self12, _t19, Math.fma(_self11, _t21, -(_self10 * _t11))));
        dest.put(destOffset + 5, Math.fma(_self22, _t19, Math.fma(_self21, _t21, -(_self20 * _t11))));
        dest.put(destOffset + 6, Math.fma(_self02, _t12, Math.fma(_self00, _t2, -(_self01 * _t13))));
        dest.put(destOffset + 7, Math.fma(_self12, _t12, Math.fma(_self10, _t2, -(_self11 * _t13))));
        dest.put(destOffset + 8, Math.fma(_self22, _t12, Math.fma(_self20, _t2, -(_self21 * _t13))));
        return dest;
    }

    public static java.nio.FloatBuffer rotateXZY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.rotateXZY_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.FloatBuffer rotateXZY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
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
        dest.put(destOffset + 3, Math.fma(_self02, _t11, Math.fma(_self01, _t12, -(_self00 * _t1))));
        dest.put(destOffset + 4, Math.fma(_self12, _t11, Math.fma(_self11, _t12, -(_self10 * _t1))));
        dest.put(destOffset + 5, Math.fma(_self22, _t11, Math.fma(_self21, _t12, -(_self20 * _t1))));
        dest.put(destOffset + 6, Math.fma(_self02, _t19, Math.fma(_self00, _t14, _self01 * _t21)));
        dest.put(destOffset + 7, Math.fma(_self12, _t19, Math.fma(_self10, _t14, _self11 * _t21)));
        dest.put(destOffset + 8, Math.fma(_self22, _t19, Math.fma(_self20, _t14, _self21 * _t21)));
        return dest;
    }

    public static java.nio.FloatBuffer rotateY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.rotateY_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.FloatBuffer rotateY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angle) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        dest.put(destOffset + 0, Math.fma(_self00, _t0, -(_self02 * _t1)));
        dest.put(destOffset + 1, Math.fma(_self10, _t0, -(_self12 * _t1)));
        dest.put(destOffset + 2, Math.fma(_self20, _t0, -(_self22 * _t1)));
        dest.put(destOffset + 3, _self01);
        dest.put(destOffset + 4, _self11);
        dest.put(destOffset + 5, _self21);
        dest.put(destOffset + 6, Math.fma(_self00, _t1, _self02 * _t0));
        dest.put(destOffset + 7, Math.fma(_self10, _t1, _self12 * _t0));
        dest.put(destOffset + 8, Math.fma(_self20, _t1, _self22 * _t0));
        return dest;
    }

    public static java.nio.FloatBuffer rotateY180_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.rotateY180_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer rotateY180_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        dest.put(destOffset + 0, -_self00);
        dest.put(destOffset + 1, -_self10);
        dest.put(destOffset + 2, -_self20);
        dest.put(destOffset + 3, _self01);
        dest.put(destOffset + 4, _self11);
        dest.put(destOffset + 5, _self21);
        dest.put(destOffset + 6, -_self02);
        dest.put(destOffset + 7, -_self12);
        dest.put(destOffset + 8, -_self22);
        return dest;
    }

    public static java.nio.FloatBuffer rotateY270_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.rotateY270_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer rotateY270_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        dest.put(destOffset + 0, _self02);
        dest.put(destOffset + 1, _self12);
        dest.put(destOffset + 2, _self22);
        dest.put(destOffset + 3, _self01);
        dest.put(destOffset + 4, _self11);
        dest.put(destOffset + 5, _self21);
        dest.put(destOffset + 6, -_self00);
        dest.put(destOffset + 7, -_self10);
        dest.put(destOffset + 8, -_self20);
        return dest;
    }

    public static java.nio.FloatBuffer rotateY90_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.rotateY90_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer rotateY90_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        dest.put(destOffset + 0, -_self02);
        dest.put(destOffset + 1, -_self12);
        dest.put(destOffset + 2, -_self22);
        dest.put(destOffset + 3, _self01);
        dest.put(destOffset + 4, _self11);
        dest.put(destOffset + 5, _self21);
        dest.put(destOffset + 6, _self00);
        dest.put(destOffset + 7, _self10);
        dest.put(destOffset + 8, _self20);
        return dest;
    }

    public static java.nio.FloatBuffer rotateYXZ_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.rotateYXZ_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.FloatBuffer rotateYXZ_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
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
        dest.put(destOffset + 3, Math.fma(_self02, _t19, Math.fma(_self00, _t21, _self01 * _t13)));
        dest.put(destOffset + 4, Math.fma(_self12, _t19, Math.fma(_self10, _t21, _self11 * _t13)));
        dest.put(destOffset + 5, Math.fma(_self22, _t19, Math.fma(_self20, _t21, _self21 * _t13)));
        dest.put(destOffset + 6, Math.fma(_self02, _t14, Math.fma(_self00, _t15, -(_self01 * _t0))));
        dest.put(destOffset + 7, Math.fma(_self12, _t14, Math.fma(_self10, _t15, -(_self11 * _t0))));
        dest.put(destOffset + 8, Math.fma(_self22, _t14, Math.fma(_self20, _t15, -(_self21 * _t0))));
        return dest;
    }

    public static java.nio.FloatBuffer rotateYZX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.rotateYZX_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.FloatBuffer rotateYZX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
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
        dest.put(destOffset + 3, Math.fma(_self02, _t18, Math.fma(_self00, _t20, _self01 * _t11)));
        dest.put(destOffset + 4, Math.fma(_self12, _t18, Math.fma(_self10, _t20, _self11 * _t11)));
        dest.put(destOffset + 5, Math.fma(_self22, _t18, Math.fma(_self20, _t20, _self21 * _t11)));
        dest.put(destOffset + 6, Math.fma(_self02, _t21, Math.fma(_self00, _t19, -(_self01 * _t13))));
        dest.put(destOffset + 7, Math.fma(_self12, _t21, Math.fma(_self10, _t19, -(_self11 * _t13))));
        dest.put(destOffset + 8, Math.fma(_self22, _t21, Math.fma(_self20, _t19, -(_self21 * _t13))));
        return dest;
    }

    public static java.nio.FloatBuffer rotateZ180_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.rotateZ180_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer rotateZ180_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        dest.put(destOffset + 0, -_self00);
        dest.put(destOffset + 1, -_self10);
        dest.put(destOffset + 2, -_self20);
        dest.put(destOffset + 3, -_self01);
        dest.put(destOffset + 4, -_self11);
        dest.put(destOffset + 5, -_self21);
        dest.put(destOffset + 6, _self02);
        dest.put(destOffset + 7, _self12);
        dest.put(destOffset + 8, _self22);
        return dest;
    }

    public static java.nio.FloatBuffer rotateZ270_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.rotateZ270_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer rotateZ270_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        dest.put(destOffset + 0, -_self01);
        dest.put(destOffset + 1, -_self11);
        dest.put(destOffset + 2, -_self21);
        dest.put(destOffset + 3, _self00);
        dest.put(destOffset + 4, _self10);
        dest.put(destOffset + 5, _self20);
        dest.put(destOffset + 6, _self02);
        dest.put(destOffset + 7, _self12);
        dest.put(destOffset + 8, _self22);
        return dest;
    }

    public static java.nio.FloatBuffer rotateZ90_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.rotateZ90_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.FloatBuffer rotateZ90_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        dest.put(destOffset + 0, _self01);
        dest.put(destOffset + 1, _self11);
        dest.put(destOffset + 2, _self21);
        dest.put(destOffset + 3, -_self00);
        dest.put(destOffset + 4, -_self10);
        dest.put(destOffset + 5, -_self20);
        dest.put(destOffset + 6, _self02);
        dest.put(destOffset + 7, _self12);
        dest.put(destOffset + 8, _self22);
        return dest;
    }

    public static java.nio.FloatBuffer rotateZXY_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.rotateZXY_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.FloatBuffer rotateZXY_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
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
        dest.put(destOffset + 3, Math.fma(_self02, _t4, Math.fma(_self01, _t10, -(_self00 * _t11))));
        dest.put(destOffset + 4, Math.fma(_self12, _t4, Math.fma(_self11, _t10, -(_self10 * _t11))));
        dest.put(destOffset + 5, Math.fma(_self22, _t4, Math.fma(_self21, _t10, -(_self20 * _t11))));
        dest.put(destOffset + 6, Math.fma(_self02, _t12, Math.fma(_self00, _t19, _self01 * _t21)));
        dest.put(destOffset + 7, Math.fma(_self12, _t12, Math.fma(_self10, _t19, _self11 * _t21)));
        dest.put(destOffset + 8, Math.fma(_self22, _t12, Math.fma(_self20, _t19, _self21 * _t21)));
        return dest;
    }

    public static java.nio.FloatBuffer rotateZYX_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.rotateZYX_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.FloatBuffer rotateZYX_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float angleX, float angleY, float angleZ) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
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
        dest.put(destOffset + 3, Math.fma(_self02, _t8, Math.fma(_self00, _t20, _self01 * _t18)));
        dest.put(destOffset + 4, Math.fma(_self12, _t8, Math.fma(_self10, _t20, _self11 * _t18)));
        dest.put(destOffset + 5, Math.fma(_self22, _t8, Math.fma(_self20, _t20, _self21 * _t18)));
        dest.put(destOffset + 6, Math.fma(_self02, _t13, Math.fma(_self00, _t19, _self01 * _t21)));
        dest.put(destOffset + 7, Math.fma(_self12, _t13, Math.fma(_self10, _t19, _self11 * _t21)));
        dest.put(destOffset + 8, Math.fma(_self22, _t13, Math.fma(_self20, _t19, _self21 * _t21)));
        return dest;
    }

    public static java.nio.FloatBuffer scale_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float vX, float vY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.scale_unsafe(_destBase, _srcBase, vX, vY);
        return dest;
    }

    public static java.nio.FloatBuffer scale_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float vX, float vY) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        dest.put(destOffset + 0, _self00 * vX);
        dest.put(destOffset + 1, _self10 * vX);
        dest.put(destOffset + 2, _self20 * vX);
        dest.put(destOffset + 3, _self01 * vY);
        dest.put(destOffset + 4, _self11 * vY);
        dest.put(destOffset + 5, _self21 * vY);
        dest.put(destOffset + 6, _self02);
        dest.put(destOffset + 7, _self12);
        dest.put(destOffset + 8, _self22);
        return dest;
    }

    public static java.nio.FloatBuffer scale_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 4L;
        Float3x3OpsKernelsAddress.scale_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.FloatBuffer scale_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer v, int vOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        float _vx = v.get(vOffset + 0);
        float _vy = v.get(vOffset + 1);
        dest.put(destOffset + 0, _self00 * _vx);
        dest.put(destOffset + 1, _self10 * _vx);
        dest.put(destOffset + 2, _self20 * _vx);
        dest.put(destOffset + 3, _self01 * _vy);
        dest.put(destOffset + 4, _self11 * _vy);
        dest.put(destOffset + 5, _self21 * _vy);
        dest.put(destOffset + 6, _self02);
        dest.put(destOffset + 7, _self12);
        dest.put(destOffset + 8, _self22);
        return dest;
    }

    public static java.nio.FloatBuffer scale_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float s) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.scale_unsafe(_destBase, _srcBase, s);
        return dest;
    }

    public static java.nio.FloatBuffer scale_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float s) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        dest.put(destOffset + 0, s * _self00);
        dest.put(destOffset + 1, s * _self10);
        dest.put(destOffset + 2, s * _self20);
        dest.put(destOffset + 3, s * _self01);
        dest.put(destOffset + 4, s * _self11);
        dest.put(destOffset + 5, s * _self21);
        dest.put(destOffset + 6, _self02);
        dest.put(destOffset + 7, _self12);
        dest.put(destOffset + 8, _self22);
        return dest;
    }

    public static java.nio.FloatBuffer scaleAround_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float s, float pivotX, float pivotY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.scaleAround_unsafe(_destBase, _srcBase, s, pivotX, pivotY);
        return dest;
    }

    public static java.nio.FloatBuffer scaleAround_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float s, float pivotX, float pivotY) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        float _t0 = Math.fma(-s, pivotX, pivotX);
        float _t1 = Math.fma(-s, pivotY, pivotY);
        dest.put(destOffset + 0, s * _self00);
        dest.put(destOffset + 1, s * _self10);
        dest.put(destOffset + 2, s * _self20);
        dest.put(destOffset + 3, s * _self01);
        dest.put(destOffset + 4, s * _self11);
        dest.put(destOffset + 5, s * _self21);
        dest.put(destOffset + 6, Math.fma(_self00, _t0, Math.fma(_self01, _t1, _self02)));
        dest.put(destOffset + 7, Math.fma(_self10, _t0, Math.fma(_self11, _t1, _self12)));
        dest.put(destOffset + 8, Math.fma(_self20, _t0, Math.fma(_self21, _t1, _self22)));
        return dest;
    }

    public static java.nio.FloatBuffer scaleAround_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer pivot, int pivotOffset, float s) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _pivotBase = UnsafeOpsHolder.U.getLong(pivot, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pivotOffset * 4L;
        Float3x3OpsKernelsAddress.scaleAround_unsafe(_destBase, _srcBase, _pivotBase, s);
        return dest;
    }

    public static java.nio.FloatBuffer scaleAround_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer pivot, int pivotOffset, float s) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        float _pivotx = pivot.get(pivotOffset + 0);
        float _pivoty = pivot.get(pivotOffset + 1);
        float _t0 = Math.fma(-s, _pivotx, _pivotx);
        float _t1 = Math.fma(-s, _pivoty, _pivoty);
        dest.put(destOffset + 0, s * _self00);
        dest.put(destOffset + 1, s * _self10);
        dest.put(destOffset + 2, s * _self20);
        dest.put(destOffset + 3, s * _self01);
        dest.put(destOffset + 4, s * _self11);
        dest.put(destOffset + 5, s * _self21);
        dest.put(destOffset + 6, Math.fma(_self00, _t0, Math.fma(_self01, _t1, _self02)));
        dest.put(destOffset + 7, Math.fma(_self10, _t0, Math.fma(_self11, _t1, _self12)));
        dest.put(destOffset + 8, Math.fma(_self20, _t0, Math.fma(_self21, _t1, _self22)));
        return dest;
    }

    public static java.nio.FloatBuffer scaleAround_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float sX, float sY, float pivotX, float pivotY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.scaleAround_unsafe(_destBase, _srcBase, sX, sY, pivotX, pivotY);
        return dest;
    }

    public static java.nio.FloatBuffer scaleAround_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float sX, float sY, float pivotX, float pivotY) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        float _t2 = Math.fma(-pivotX, sX, pivotX);
        float _t3 = Math.fma(-pivotY, sY, pivotY);
        dest.put(destOffset + 0, sX * _self00);
        dest.put(destOffset + 1, sX * _self10);
        dest.put(destOffset + 2, sX * _self20);
        dest.put(destOffset + 3, sY * _self01);
        dest.put(destOffset + 4, sY * _self11);
        dest.put(destOffset + 5, sY * _self21);
        dest.put(destOffset + 6, Math.fma(_self00, _t2, Math.fma(_self01, _t3, _self02)));
        dest.put(destOffset + 7, Math.fma(_self10, _t2, Math.fma(_self11, _t3, _self12)));
        dest.put(destOffset + 8, Math.fma(_self20, _t2, Math.fma(_self21, _t3, _self22)));
        return dest;
    }

    public static java.nio.FloatBuffer scaleAround_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer s, int sOffset, java.nio.FloatBuffer pivot, int pivotOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _sBase = UnsafeOpsHolder.U.getLong(s, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) sOffset * 4L;
        long _pivotBase = UnsafeOpsHolder.U.getLong(pivot, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pivotOffset * 4L;
        Float3x3OpsKernelsAddress.scaleAround_unsafe(_destBase, _srcBase, _sBase, _pivotBase);
        return dest;
    }

    public static java.nio.FloatBuffer scaleAround_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer s, int sOffset, java.nio.FloatBuffer pivot, int pivotOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        float _sx = s.get(sOffset + 0);
        float _sy = s.get(sOffset + 1);
        float _pivotx = pivot.get(pivotOffset + 0);
        float _pivoty = pivot.get(pivotOffset + 1);
        float _t2 = Math.fma(-_pivotx, _sx, _pivotx);
        float _t3 = Math.fma(-_pivoty, _sy, _pivoty);
        dest.put(destOffset + 0, _sx * _self00);
        dest.put(destOffset + 1, _sx * _self10);
        dest.put(destOffset + 2, _sx * _self20);
        dest.put(destOffset + 3, _sy * _self01);
        dest.put(destOffset + 4, _sy * _self11);
        dest.put(destOffset + 5, _sy * _self21);
        dest.put(destOffset + 6, Math.fma(_self00, _t2, Math.fma(_self01, _t3, _self02)));
        dest.put(destOffset + 7, Math.fma(_self10, _t2, Math.fma(_self11, _t3, _self12)));
        dest.put(destOffset + 8, Math.fma(_self20, _t2, Math.fma(_self21, _t3, _self22)));
        return dest;
    }

    public static java.nio.FloatBuffer translate_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float vX, float vY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.translate_unsafe(_destBase, _srcBase, vX, vY);
        return dest;
    }

    public static java.nio.FloatBuffer translate_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float vX, float vY) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        dest.put(destOffset + 0, _self00);
        dest.put(destOffset + 1, _self10);
        dest.put(destOffset + 2, _self20);
        dest.put(destOffset + 3, _self01);
        dest.put(destOffset + 4, _self11);
        dest.put(destOffset + 5, _self21);
        dest.put(destOffset + 6, Math.fma(_self00, vX, Math.fma(_self01, vY, _self02)));
        dest.put(destOffset + 7, Math.fma(_self10, vX, Math.fma(_self11, vY, _self12)));
        dest.put(destOffset + 8, Math.fma(_self20, vX, Math.fma(_self21, vY, _self22)));
        return dest;
    }

    public static java.nio.FloatBuffer translate_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 4L;
        Float3x3OpsKernelsAddress.translate_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.FloatBuffer translate_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer v, int vOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        float _vx = v.get(vOffset + 0);
        float _vy = v.get(vOffset + 1);
        dest.put(destOffset + 0, _self00);
        dest.put(destOffset + 1, _self10);
        dest.put(destOffset + 2, _self20);
        dest.put(destOffset + 3, _self01);
        dest.put(destOffset + 4, _self11);
        dest.put(destOffset + 5, _self21);
        dest.put(destOffset + 6, Math.fma(_self00, _vx, Math.fma(_self01, _vy, _self02)));
        dest.put(destOffset + 7, Math.fma(_self10, _vx, Math.fma(_self11, _vy, _self12)));
        dest.put(destOffset + 8, Math.fma(_self20, _vx, Math.fma(_self21, _vy, _self22)));
        return dest;
    }

    public static java.nio.FloatBuffer view_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float left, float right, float bottom, float top) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.view_unsafe(_destBase, _srcBase, left, right, bottom, top);
        return dest;
    }

    public static java.nio.FloatBuffer view_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float left, float right, float bottom, float top) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        float _t2 = left + right;
        float _t3 = bottom + top;
        dest.put(destOffset + 0, 2.0f * _self00 * _t0_inv);
        dest.put(destOffset + 1, 2.0f * _self10 * _t0_inv);
        dest.put(destOffset + 2, 2.0f * _self20 * _t0_inv);
        dest.put(destOffset + 3, 2.0f * _self01 * _t1_inv);
        dest.put(destOffset + 4, 2.0f * _self11 * _t1_inv);
        dest.put(destOffset + 5, 2.0f * _self21 * _t1_inv);
        dest.put(destOffset + 6, _self02 + (-(_self00 * _t2 * _t0_inv) - _self01 * _t3 * _t1_inv));
        dest.put(destOffset + 7, _self12 + (-(_self10 * _t2 * _t0_inv) - _self11 * _t3 * _t1_inv));
        dest.put(destOffset + 8, _self22 + (-(_self20 * _t2 * _t0_inv) - _self21 * _t3 * _t1_inv));
        return dest;
    }

    public static java.nio.FloatBuffer mulVec3_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float vX, float vY, float vZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        Float3x3OpsKernelsAddress.mulVec3_unsafe(_destBase, _srcBase, vX, vY, vZ);
        return dest;
    }

    public static java.nio.FloatBuffer mulVec3_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, float vX, float vY, float vZ) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        dest.put(destOffset + 0, Math.fma(_self02, vZ, Math.fma(_self00, vX, _self01 * vY)));
        dest.put(destOffset + 1, Math.fma(_self12, vZ, Math.fma(_self10, vX, _self11 * vY)));
        dest.put(destOffset + 2, Math.fma(_self22, vZ, Math.fma(_self20, vX, _self21 * vY)));
        return dest;
    }

    public static java.nio.FloatBuffer mulVec3_unsafe(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 4L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 4L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 4L;
        Float3x3OpsKernelsAddress.mulVec3_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.FloatBuffer mulVec3_api(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, java.nio.FloatBuffer v, int vOffset) {
        float _self00 = src.get(srcOffset + 0);
        float _self10 = src.get(srcOffset + 1);
        float _self20 = src.get(srcOffset + 2);
        float _self01 = src.get(srcOffset + 3);
        float _self11 = src.get(srcOffset + 4);
        float _self21 = src.get(srcOffset + 5);
        float _self02 = src.get(srcOffset + 6);
        float _self12 = src.get(srcOffset + 7);
        float _self22 = src.get(srcOffset + 8);
        float _vx = v.get(vOffset + 0);
        float _vy = v.get(vOffset + 1);
        float _vz = v.get(vOffset + 2);
        dest.put(destOffset + 0, Math.fma(_self02, _vz, Math.fma(_self00, _vx, _self01 * _vy)));
        dest.put(destOffset + 1, Math.fma(_self12, _vz, Math.fma(_self10, _vx, _self11 * _vy)));
        dest.put(destOffset + 2, Math.fma(_self22, _vz, Math.fma(_self20, _vx, _self21 * _vy)));
        return dest;
    }

}
