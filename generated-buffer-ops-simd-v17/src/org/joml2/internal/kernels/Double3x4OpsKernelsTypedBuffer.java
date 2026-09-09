package org.joml2.internal.kernels;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.ops.*;
import org.joml2.internal.unsafe.*;
import org.joml2.internal.simd.*;

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
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _idxSw0;
        double _idxSw1;
        double _idxSw2;
        switch (col) {
            case 0: _idxSw0 = _self00; _idxSw1 = _self10; _idxSw2 = _self20; break;
            case 1: _idxSw0 = _self01; _idxSw1 = _self11; _idxSw2 = _self21; break;
            case 2: _idxSw0 = _self02; _idxSw1 = _self12; _idxSw2 = _self22; break;
            case 3: _idxSw0 = _self03; _idxSw1 = _self13; _idxSw2 = _self23; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + col);
        }
        dest.put(destOffset + 0, _idxSw0);
        dest.put(destOffset + 1, _idxSw1);
        dest.put(destOffset + 2, _idxSw2);
        return dest;
    }

    public static java.nio.DoubleBuffer getEulerAnglesXYZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.getEulerAnglesXYZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer getEulerAnglesXYZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _t1 = Math.fma(_self12, _self12, _self22 * _self22);
        double _t3 = Math.fma(_self02, _self02, _t1) * 1.0E-15;
        if (_t1 < _t3) {
            dest.put(destOffset + 0, Math.atan2(_self21, _self11));
            dest.put(destOffset + 2, 0.0);
        } else {
            dest.put(destOffset + 0, Math.atan2(-_self12, _self22));
            dest.put(destOffset + 2, Math.atan2(-_self01, _self00));
        }
        dest.put(destOffset + 1, Math.atan2(_self02, Math.sqrt(_t1)));
        return dest;
    }

    public static java.nio.DoubleBuffer getEulerAnglesXZY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.getEulerAnglesXZY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer getEulerAnglesXZY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _t1 = Math.fma(_self11, _self11, _self21 * _self21);
        double _t3 = Math.fma(_self01, _self01, _t1) * 1.0E-15;
        if (_t1 < _t3) {
            dest.put(destOffset + 0, Math.atan2(-_self12, _self22));
            dest.put(destOffset + 1, 0.0);
        } else {
            dest.put(destOffset + 0, Math.atan2(_self21, _self11));
            dest.put(destOffset + 1, Math.atan2(_self02, _self00));
        }
        dest.put(destOffset + 2, Math.atan2(-_self01, Math.sqrt(_t1)));
        return dest;
    }

    public static java.nio.DoubleBuffer getEulerAnglesYXZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.getEulerAnglesYXZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer getEulerAnglesYXZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _self00 = src.get(srcOffset + 0);
        double _self02 = src.get(srcOffset + 2);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self20 = src.get(srcOffset + 8);
        double _self22 = src.get(srcOffset + 10);
        double _t1 = Math.fma(_self02, _self02, _self22 * _self22);
        double _t3 = Math.fma(_self12, _self12, _t1) * 1.0E-15;
        if (_t1 < _t3) {
            dest.put(destOffset + 1, Math.atan2(-_self20, _self00));
            dest.put(destOffset + 2, 0.0);
        } else {
            dest.put(destOffset + 1, Math.atan2(_self02, _self22));
            dest.put(destOffset + 2, Math.atan2(_self10, _self11));
        }
        dest.put(destOffset + 0, Math.atan2(-_self12, Math.sqrt(_t1)));
        return dest;
    }

    public static java.nio.DoubleBuffer getEulerAnglesYZX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.getEulerAnglesYZX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer getEulerAnglesYZX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _self00 = src.get(srcOffset + 0);
        double _self02 = src.get(srcOffset + 2);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self20 = src.get(srcOffset + 8);
        double _self22 = src.get(srcOffset + 10);
        double _t1 = Math.fma(_self11, _self11, _self12 * _self12);
        double _t3 = Math.fma(_self10, _self10, _t1) * 1.0E-15;
        if (_t1 < _t3) {
            dest.put(destOffset + 0, 0.0);
            dest.put(destOffset + 1, Math.atan2(_self02, _self22));
        } else {
            dest.put(destOffset + 0, Math.atan2(-_self12, _self11));
            dest.put(destOffset + 1, Math.atan2(-_self20, _self00));
        }
        dest.put(destOffset + 2, Math.atan2(_self10, Math.sqrt(_t1)));
        return dest;
    }

    public static java.nio.DoubleBuffer getEulerAnglesZXY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.getEulerAnglesZXY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer getEulerAnglesZXY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _t1 = Math.fma(_self01, _self01, _self11 * _self11);
        double _t3 = Math.fma(_self21, _self21, _t1) * 1.0E-15;
        if (_t1 < _t3) {
            dest.put(destOffset + 1, 0.0);
            dest.put(destOffset + 2, Math.atan2(_self10, _self00));
        } else {
            dest.put(destOffset + 1, Math.atan2(-_self20, _self22));
            dest.put(destOffset + 2, Math.atan2(-_self01, _self11));
        }
        dest.put(destOffset + 0, Math.atan2(_self21, Math.sqrt(_t1)));
        return dest;
    }

    public static java.nio.DoubleBuffer getEulerAnglesZYX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.getEulerAnglesZYX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer getEulerAnglesZYX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _t1 = Math.fma(_self21, _self21, _self22 * _self22);
        double _t3 = Math.fma(_self20, _self20, _t1) * 1.0E-15;
        if (_t1 < _t3) {
            dest.put(destOffset + 0, 0.0);
            dest.put(destOffset + 2, Math.atan2(-_self01, _self11));
        } else {
            dest.put(destOffset + 0, Math.atan2(_self21, _self22));
            dest.put(destOffset + 2, Math.atan2(_self10, _self00));
        }
        dest.put(destOffset + 1, Math.atan2(-_self20, Math.sqrt(_t1)));
        return dest;
    }

    public static java.nio.DoubleBuffer getNormalizedRotation_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.getNormalizedRotation_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer getNormalizedRotation_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _t6 = Math.fma(_self21, _self21, Math.fma(_self01, _self01, _self11 * _self11));
        double _t7 = Math.fma(_self22, _self22, Math.fma(_self02, _self02, _self12 * _self12));
        double _t8 = Math.fma(_self20, _self20, Math.fma(_self00, _self00, _self10 * _self10));
        double _t9 = (1.0 / Math.sqrt(_t6));
        double _t10 = (1.0 / Math.sqrt(_t7));
        double _t11 = (1.0 / Math.sqrt(_t8));
        double _t21, _t23, _t27;
        if (_t6 > 0.0) {
            _t21 = _self01 * _t9;
            _t23 = _self11 * _t9;
            _t27 = _self21 * _t9;
        } else {
            _t21 = 0.0;
            _t23 = 0.0;
            _t27 = 0.0;
        }
        double _t22, _t24, _t26;
        if (_t7 > 0.0) {
            _t22 = _self12 * _t10;
            _t24 = _self02 * _t10;
            _t26 = _self22 * _t10;
        } else {
            _t22 = 0.0;
            _t24 = 0.0;
            _t26 = 0.0;
        }
        double _t25, _t28, _t29;
        if (_t8 > 0.0) {
            _t25 = _self20 * _t11;
            _t28 = _self00 * _t11;
            _t29 = _self10 * _t11;
        } else {
            _t25 = 0.0;
            _t28 = 0.0;
            _t29 = 0.0;
        }
        double _t36 = _t27 - _t22;
        double _t37 = Math.max(_t23, _t26);
        double _t39 = _t27 + _t22;
        double _t48 = Math.fma(Math.fma(_t21, _t22, -(_t23 * _t24)), _t25, Math.fma(Math.fma(_t23, _t26, -(_t27 * _t22)), _t28, Math.fma(_t27, _t24, -(_t21 * _t26)) * _t29));
        double _t49, _t50, _t51;
        if (_t48 < 0.0) {
            _t49 = -_t28;
            _t50 = -_t29;
            _t51 = -_t25;
        } else {
            _t49 = _t28;
            _t50 = _t29;
            _t51 = _t25;
        }
        double _t52 = _t49 + _t23;
        double _t53 = _t50 + _t21;
        double _t55 = _t51 + _t24;
        double _t56 = _t24 - _t51;
        double _t57 = _t50 - _t21;
        double _t58 = _t52 + _t26;
        double _t62 = 1.0 + _t58;
        double _t63 = 1.0 + (_t49 - (_t23 + _t26));
        double _t64 = 1.0 + (_t23 - (_t49 + _t26));
        double _t65 = 1.0 + (_t26 - _t52);
        double _t66 = (1.0 / Math.sqrt(_t62));
        double _t67 = (1.0 / Math.sqrt(_t64));
        double _t68 = (1.0 / Math.sqrt(_t65));
        double _t69 = (1.0 / Math.sqrt(_t63));
        if (_t58 > 0.0) {
            dest.put(destOffset + 0, 0.5 * _t36 * _t66);
            dest.put(destOffset + 1, 0.5 * _t56 * _t66);
            dest.put(destOffset + 2, 0.5 * _t57 * _t66);
            dest.put(destOffset + 3, 0.5 * Math.sqrt(_t62));
        } else {
            if (_t49 > _t37) {
                dest.put(destOffset + 0, 0.5 * Math.sqrt(_t63));
                dest.put(destOffset + 1, 0.5 * _t53 * _t69);
                dest.put(destOffset + 2, 0.5 * _t55 * _t69);
                dest.put(destOffset + 3, 0.5 * _t36 * _t69);
            } else {
                if (_t23 > _t26) {
                    dest.put(destOffset + 0, 0.5 * _t53 * _t67);
                    dest.put(destOffset + 1, 0.5 * Math.sqrt(_t64));
                    dest.put(destOffset + 2, 0.5 * _t39 * _t67);
                    dest.put(destOffset + 3, 0.5 * _t56 * _t67);
                } else {
                    dest.put(destOffset + 0, 0.5 * _t55 * _t68);
                    dest.put(destOffset + 1, 0.5 * _t39 * _t68);
                    dest.put(destOffset + 2, 0.5 * Math.sqrt(_t65));
                    dest.put(destOffset + 3, 0.5 * _t57 * _t68);
                }
            }
        }
        return dest;
    }

    public static java.nio.DoubleBuffer getRow_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, int row) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.getRow_unsafe(_destBase, _srcBase, row);
        return dest;
    }

    public static java.nio.DoubleBuffer getRow_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, int row) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _idxSw0;
        double _idxSw1;
        double _idxSw2;
        double _idxSw3;
        switch (row) {
            case 0: _idxSw0 = _self00; _idxSw1 = _self01; _idxSw2 = _self02; _idxSw3 = _self03; break;
            case 1: _idxSw0 = _self10; _idxSw1 = _self11; _idxSw2 = _self12; _idxSw3 = _self13; break;
            case 2: _idxSw0 = _self20; _idxSw1 = _self21; _idxSw2 = _self22; _idxSw3 = _self23; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + row);
        }
        dest.put(destOffset + 0, _idxSw0);
        dest.put(destOffset + 1, _idxSw1);
        dest.put(destOffset + 2, _idxSw2);
        dest.put(destOffset + 3, _idxSw3);
        return dest;
    }

    public static java.nio.DoubleBuffer getScale_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.getScale_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer getScale_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        dest.put(destOffset + 0, Math.sqrt(Math.fma(_self20, _self20, Math.fma(_self00, _self00, _self10 * _self10))));
        dest.put(destOffset + 1, Math.sqrt(Math.fma(_self21, _self21, Math.fma(_self01, _self01, _self11 * _self11))));
        dest.put(destOffset + 2, Math.sqrt(Math.fma(_self22, _self22, Math.fma(_self02, _self02, _self12 * _self12))));
        return dest;
    }

    public static java.nio.DoubleBuffer getTranslation_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.getTranslation_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer getTranslation_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _self03 = src.get(srcOffset + 3);
        double _self13 = src.get(srcOffset + 7);
        double _self23 = src.get(srcOffset + 11);
        dest.put(destOffset + 0, _self03);
        dest.put(destOffset + 1, _self13);
        dest.put(destOffset + 2, _self23);
        return dest;
    }

    public static java.nio.DoubleBuffer getUnnormalizedRotation_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.getUnnormalizedRotation_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer getUnnormalizedRotation_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _t0 = _self00 + _self11;
        double _t1 = _self21 - _self12;
        double _t2 = Math.max(_self11, _self22);
        double _t4 = _self01 + _self10;
        double _t6 = _self02 + _self20;
        double _t7 = _self02 - _self20;
        double _t8 = _self12 + _self21;
        double _t9 = _self10 - _self01;
        double _t10 = _self22 + _t0;
        double _t14 = 1.0 + _t10;
        double _t15 = 1.0 + (_self00 - (_self11 + _self22));
        double _t16 = 1.0 + (_self11 - (_self00 + _self22));
        double _t17 = 1.0 + (_self22 - _t0);
        double _t18 = (1.0 / Math.sqrt(_t14));
        double _t19 = (1.0 / Math.sqrt(_t16));
        double _t20 = (1.0 / Math.sqrt(_t17));
        double _t21 = (1.0 / Math.sqrt(_t15));
        if (_t10 > 0.0) {
            dest.put(destOffset + 0, 0.5 * _t1 * _t18);
            dest.put(destOffset + 1, 0.5 * _t7 * _t18);
            dest.put(destOffset + 2, 0.5 * _t9 * _t18);
            dest.put(destOffset + 3, 0.5 * Math.sqrt(_t14));
        } else {
            if (_self00 > _t2) {
                dest.put(destOffset + 0, 0.5 * Math.sqrt(_t15));
                dest.put(destOffset + 1, 0.5 * _t4 * _t21);
                dest.put(destOffset + 2, 0.5 * _t6 * _t21);
                dest.put(destOffset + 3, 0.5 * _t1 * _t21);
            } else {
                if (_self11 > _self22) {
                    dest.put(destOffset + 0, 0.5 * _t4 * _t19);
                    dest.put(destOffset + 1, 0.5 * Math.sqrt(_t16));
                    dest.put(destOffset + 2, 0.5 * _t8 * _t19);
                    dest.put(destOffset + 3, 0.5 * _t7 * _t19);
                } else {
                    dest.put(destOffset + 0, 0.5 * _t6 * _t20);
                    dest.put(destOffset + 1, 0.5 * _t8 * _t20);
                    dest.put(destOffset + 2, 0.5 * Math.sqrt(_t17));
                    dest.put(destOffset + 3, 0.5 * _t9 * _t20);
                }
            }
        }
        return dest;
    }

    public static java.nio.DoubleBuffer invNegativeX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.invNegativeX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer invNegativeX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _t6 = Math.fma(_self10, _self21, -(_self11 * _self20));
        double _t7 = Math.fma(_self11, _self22, -(_self12 * _self21));
        double _t8 = Math.fma(_self12, _self20, -(_self10 * _self22));
        double _t11 = Math.fma(_t6, _t6, Math.fma(_t7, _t7, _t8 * _t8));
        double _t12 = (1.0 / Math.sqrt(_t11));
        if (_t11 > 0.0) {
            dest.put(destOffset + 0, -(_t7 * _t12));
            dest.put(destOffset + 1, -(_t8 * _t12));
            dest.put(destOffset + 2, -(_t6 * _t12));
        } else {
            dest.put(destOffset + 0, -0.0);
            dest.put(destOffset + 1, -0.0);
            dest.put(destOffset + 2, -0.0);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer invNegativeY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.invNegativeY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer invNegativeY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _t6 = Math.fma(_self01, _self20, -(_self00 * _self21));
        double _t7 = Math.fma(_self00, _self22, -(_self02 * _self20));
        double _t8 = Math.fma(_self02, _self21, -(_self01 * _self22));
        double _t11 = Math.fma(_t6, _t6, Math.fma(_t7, _t7, _t8 * _t8));
        double _t12 = (1.0 / Math.sqrt(_t11));
        if (_t11 > 0.0) {
            dest.put(destOffset + 0, -(_t8 * _t12));
            dest.put(destOffset + 1, -(_t7 * _t12));
            dest.put(destOffset + 2, -(_t6 * _t12));
        } else {
            dest.put(destOffset + 0, -0.0);
            dest.put(destOffset + 1, -0.0);
            dest.put(destOffset + 2, -0.0);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer invNegativeZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.invNegativeZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer invNegativeZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _t6 = Math.fma(_self00, _self11, -(_self01 * _self10));
        double _t7 = Math.fma(_self01, _self12, -(_self02 * _self11));
        double _t8 = Math.fma(_self02, _self10, -(_self00 * _self12));
        double _t11 = Math.fma(_t6, _t6, Math.fma(_t7, _t7, _t8 * _t8));
        double _t12 = (1.0 / Math.sqrt(_t11));
        if (_t11 > 0.0) {
            dest.put(destOffset + 0, -(_t7 * _t12));
            dest.put(destOffset + 1, -(_t8 * _t12));
            dest.put(destOffset + 2, -(_t6 * _t12));
        } else {
            dest.put(destOffset + 0, -0.0);
            dest.put(destOffset + 1, -0.0);
            dest.put(destOffset + 2, -0.0);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer invNormalizedNegativeX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.invNormalizedNegativeX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer invNormalizedNegativeX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        dest.put(destOffset + 0, -_self00);
        dest.put(destOffset + 1, -_self01);
        dest.put(destOffset + 2, -_self02);
        return dest;
    }

    public static java.nio.DoubleBuffer invNormalizedNegativeY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.invNormalizedNegativeY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer invNormalizedNegativeY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        dest.put(destOffset + 0, -_self10);
        dest.put(destOffset + 1, -_self11);
        dest.put(destOffset + 2, -_self12);
        return dest;
    }

    public static java.nio.DoubleBuffer invNormalizedNegativeZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.invNormalizedNegativeZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer invNormalizedNegativeZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        dest.put(destOffset + 0, -_self20);
        dest.put(destOffset + 1, -_self21);
        dest.put(destOffset + 2, -_self22);
        return dest;
    }

    public static java.nio.DoubleBuffer invNormalizedPositiveX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.invNormalizedPositiveX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer invNormalizedPositiveX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        dest.put(destOffset + 0, _self00);
        dest.put(destOffset + 1, _self01);
        dest.put(destOffset + 2, _self02);
        return dest;
    }

    public static java.nio.DoubleBuffer invNormalizedPositiveY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.invNormalizedPositiveY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer invNormalizedPositiveY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        dest.put(destOffset + 0, _self10);
        dest.put(destOffset + 1, _self11);
        dest.put(destOffset + 2, _self12);
        return dest;
    }

    public static java.nio.DoubleBuffer invNormalizedPositiveZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.invNormalizedPositiveZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer invNormalizedPositiveZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        dest.put(destOffset + 0, _self20);
        dest.put(destOffset + 1, _self21);
        dest.put(destOffset + 2, _self22);
        return dest;
    }

    public static java.nio.DoubleBuffer invPositiveX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.invPositiveX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer invPositiveX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _t6 = Math.fma(_self10, _self21, -(_self11 * _self20));
        double _t7 = Math.fma(_self11, _self22, -(_self12 * _self21));
        double _t8 = Math.fma(_self12, _self20, -(_self10 * _self22));
        double _t11 = Math.fma(_t6, _t6, Math.fma(_t7, _t7, _t8 * _t8));
        double _t12 = (1.0 / Math.sqrt(_t11));
        if (_t11 > 0.0) {
            dest.put(destOffset + 0, _t7 * _t12);
            dest.put(destOffset + 1, _t8 * _t12);
            dest.put(destOffset + 2, _t6 * _t12);
        } else {
            dest.put(destOffset + 0, 0.0);
            dest.put(destOffset + 1, 0.0);
            dest.put(destOffset + 2, 0.0);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer invPositiveY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.invPositiveY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer invPositiveY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _t6 = Math.fma(_self01, _self20, -(_self00 * _self21));
        double _t7 = Math.fma(_self00, _self22, -(_self02 * _self20));
        double _t8 = Math.fma(_self02, _self21, -(_self01 * _self22));
        double _t11 = Math.fma(_t6, _t6, Math.fma(_t7, _t7, _t8 * _t8));
        double _t12 = (1.0 / Math.sqrt(_t11));
        if (_t11 > 0.0) {
            dest.put(destOffset + 0, _t8 * _t12);
            dest.put(destOffset + 1, _t7 * _t12);
            dest.put(destOffset + 2, _t6 * _t12);
        } else {
            dest.put(destOffset + 0, 0.0);
            dest.put(destOffset + 1, 0.0);
            dest.put(destOffset + 2, 0.0);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer invPositiveZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.invPositiveZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer invPositiveZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _t6 = Math.fma(_self00, _self11, -(_self01 * _self10));
        double _t7 = Math.fma(_self01, _self12, -(_self02 * _self11));
        double _t8 = Math.fma(_self02, _self10, -(_self00 * _self12));
        double _t11 = Math.fma(_t6, _t6, Math.fma(_t7, _t7, _t8 * _t8));
        double _t12 = (1.0 / Math.sqrt(_t11));
        if (_t11 > 0.0) {
            dest.put(destOffset + 0, _t7 * _t12);
            dest.put(destOffset + 1, _t8 * _t12);
            dest.put(destOffset + 2, _t6 * _t12);
        } else {
            dest.put(destOffset + 0, 0.0);
            dest.put(destOffset + 1, 0.0);
            dest.put(destOffset + 2, 0.0);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer negativeX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.negativeX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer negativeX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _self00 = src.get(srcOffset + 0);
        double _self10 = src.get(srcOffset + 4);
        double _self20 = src.get(srcOffset + 8);
        double _t2 = Math.fma(_self20, _self20, Math.fma(_self00, _self00, _self10 * _self10));
        double _t3 = (1.0 / Math.sqrt(_t2));
        if (_t2 > 0.0) {
            dest.put(destOffset + 0, -(_self00 * _t3));
            dest.put(destOffset + 1, -(_self10 * _t3));
            dest.put(destOffset + 2, -(_self20 * _t3));
        } else {
            dest.put(destOffset + 0, -0.0);
            dest.put(destOffset + 1, -0.0);
            dest.put(destOffset + 2, -0.0);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer negativeY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.negativeY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer negativeY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _self01 = src.get(srcOffset + 1);
        double _self11 = src.get(srcOffset + 5);
        double _self21 = src.get(srcOffset + 9);
        double _t2 = Math.fma(_self21, _self21, Math.fma(_self01, _self01, _self11 * _self11));
        double _t3 = (1.0 / Math.sqrt(_t2));
        if (_t2 > 0.0) {
            dest.put(destOffset + 0, -(_self01 * _t3));
            dest.put(destOffset + 1, -(_self11 * _t3));
            dest.put(destOffset + 2, -(_self21 * _t3));
        } else {
            dest.put(destOffset + 0, -0.0);
            dest.put(destOffset + 1, -0.0);
            dest.put(destOffset + 2, -0.0);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer negativeZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.negativeZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer negativeZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _self02 = src.get(srcOffset + 2);
        double _self12 = src.get(srcOffset + 6);
        double _self22 = src.get(srcOffset + 10);
        double _t2 = Math.fma(_self22, _self22, Math.fma(_self02, _self02, _self12 * _self12));
        double _t3 = (1.0 / Math.sqrt(_t2));
        if (_t2 > 0.0) {
            dest.put(destOffset + 0, -(_self02 * _t3));
            dest.put(destOffset + 1, -(_self12 * _t3));
            dest.put(destOffset + 2, -(_self22 * _t3));
        } else {
            dest.put(destOffset + 0, -0.0);
            dest.put(destOffset + 1, -0.0);
            dest.put(destOffset + 2, -0.0);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer normalizedNegativeX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.normalizedNegativeX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer normalizedNegativeX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _self00 = src.get(srcOffset + 0);
        double _self10 = src.get(srcOffset + 4);
        double _self20 = src.get(srcOffset + 8);
        dest.put(destOffset + 0, -_self00);
        dest.put(destOffset + 1, -_self10);
        dest.put(destOffset + 2, -_self20);
        return dest;
    }

    public static java.nio.DoubleBuffer normalizedNegativeY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.normalizedNegativeY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer normalizedNegativeY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _self01 = src.get(srcOffset + 1);
        double _self11 = src.get(srcOffset + 5);
        double _self21 = src.get(srcOffset + 9);
        dest.put(destOffset + 0, -_self01);
        dest.put(destOffset + 1, -_self11);
        dest.put(destOffset + 2, -_self21);
        return dest;
    }

    public static java.nio.DoubleBuffer normalizedNegativeZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.normalizedNegativeZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer normalizedNegativeZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _self02 = src.get(srcOffset + 2);
        double _self12 = src.get(srcOffset + 6);
        double _self22 = src.get(srcOffset + 10);
        dest.put(destOffset + 0, -_self02);
        dest.put(destOffset + 1, -_self12);
        dest.put(destOffset + 2, -_self22);
        return dest;
    }

    public static java.nio.DoubleBuffer normalizedPositiveX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.normalizedPositiveX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer normalizedPositiveX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _self00 = src.get(srcOffset + 0);
        double _self10 = src.get(srcOffset + 4);
        double _self20 = src.get(srcOffset + 8);
        dest.put(destOffset + 0, _self00);
        dest.put(destOffset + 1, _self10);
        dest.put(destOffset + 2, _self20);
        return dest;
    }

    public static java.nio.DoubleBuffer normalizedPositiveY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.normalizedPositiveY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer normalizedPositiveY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _self01 = src.get(srcOffset + 1);
        double _self11 = src.get(srcOffset + 5);
        double _self21 = src.get(srcOffset + 9);
        dest.put(destOffset + 0, _self01);
        dest.put(destOffset + 1, _self11);
        dest.put(destOffset + 2, _self21);
        return dest;
    }

    public static java.nio.DoubleBuffer normalizedPositiveZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.normalizedPositiveZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer normalizedPositiveZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _self02 = src.get(srcOffset + 2);
        double _self12 = src.get(srcOffset + 6);
        double _self22 = src.get(srcOffset + 10);
        dest.put(destOffset + 0, _self02);
        dest.put(destOffset + 1, _self12);
        dest.put(destOffset + 2, _self22);
        return dest;
    }

    public static java.nio.DoubleBuffer origin_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.origin_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer origin_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        dest.put(destOffset + 0, -Math.fma(_self20, _self23, Math.fma(_self00, _self03, _self10 * _self13)));
        dest.put(destOffset + 1, -Math.fma(_self21, _self23, Math.fma(_self01, _self03, _self11 * _self13)));
        dest.put(destOffset + 2, -Math.fma(_self22, _self23, Math.fma(_self02, _self03, _self12 * _self13)));
        return dest;
    }

    public static java.nio.DoubleBuffer positiveX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.positiveX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer positiveX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _self00 = src.get(srcOffset + 0);
        double _self10 = src.get(srcOffset + 4);
        double _self20 = src.get(srcOffset + 8);
        double _t2 = Math.fma(_self20, _self20, Math.fma(_self00, _self00, _self10 * _self10));
        double _t3 = (1.0 / Math.sqrt(_t2));
        if (_t2 > 0.0) {
            dest.put(destOffset + 0, _self00 * _t3);
            dest.put(destOffset + 1, _self10 * _t3);
            dest.put(destOffset + 2, _self20 * _t3);
        } else {
            dest.put(destOffset + 0, 0.0);
            dest.put(destOffset + 1, 0.0);
            dest.put(destOffset + 2, 0.0);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer positiveY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.positiveY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer positiveY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _self01 = src.get(srcOffset + 1);
        double _self11 = src.get(srcOffset + 5);
        double _self21 = src.get(srcOffset + 9);
        double _t2 = Math.fma(_self21, _self21, Math.fma(_self01, _self01, _self11 * _self11));
        double _t3 = (1.0 / Math.sqrt(_t2));
        if (_t2 > 0.0) {
            dest.put(destOffset + 0, _self01 * _t3);
            dest.put(destOffset + 1, _self11 * _t3);
            dest.put(destOffset + 2, _self21 * _t3);
        } else {
            dest.put(destOffset + 0, 0.0);
            dest.put(destOffset + 1, 0.0);
            dest.put(destOffset + 2, 0.0);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer positiveZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.positiveZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer positiveZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _self02 = src.get(srcOffset + 2);
        double _self12 = src.get(srcOffset + 6);
        double _self22 = src.get(srcOffset + 10);
        double _t2 = Math.fma(_self22, _self22, Math.fma(_self02, _self02, _self12 * _self12));
        double _t3 = (1.0 / Math.sqrt(_t2));
        if (_t2 > 0.0) {
            dest.put(destOffset + 0, _self02 * _t3);
            dest.put(destOffset + 1, _self12 * _t3);
            dest.put(destOffset + 2, _self22 * _t3);
        } else {
            dest.put(destOffset + 0, 0.0);
            dest.put(destOffset + 1, 0.0);
            dest.put(destOffset + 2, 0.0);
        }
        return dest;
    }

    public static double determinant_unsafe(java.nio.DoubleBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double3x4OpsKernelsAddress.determinant_unsafe(_srcBase);
    }

    public static double determinant_api(java.nio.DoubleBuffer src, int srcOffset) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        return Math.fma(_self02, Math.fma(_self10, _self21, -(_self11 * _self20)), Math.fma(_self00, Math.fma(_self11, _self22, -(_self12 * _self21)), -(_self01 * Math.fma(_self10, _self22, -(_self12 * _self20)))));
    }

    public static double frobeniusNorm_unsafe(java.nio.DoubleBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double3x4OpsKernelsAddress.frobeniusNorm_unsafe(_srcBase);
    }

    public static double frobeniusNorm_api(java.nio.DoubleBuffer src, int srcOffset) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        return Math.sqrt(Math.fma(_self00, _self00, Math.fma(_self01, _self01, _self02 * _self02)) + Math.fma(_self03, _self03, Math.fma(_self10, _self10, _self11 * _self11)) + (Math.fma(_self12, _self12, Math.fma(_self13, _self13, _self20 * _self20)) + Math.fma(_self21, _self21, Math.fma(_self22, _self22, _self23 * _self23))));
    }

    public static java.nio.DoubleBuffer invert_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.invert_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer invert_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _t20 = Math.fma(_self11, _self22, -(_self12 * _self21));
        double _t21 = Math.fma(_self10, _self21, -(_self11 * _self20));
        double _t23 = Math.fma(_self02, _self21, -(_self01 * _self22));
        double _t24 = Math.fma(_self01, _self12, -(_self02 * _self11));
        double _t25 = Math.fma(_self12, _self20, -(_self10 * _self22));
        double _t26 = Math.fma(_self00, _self22, -(_self02 * _self20));
        double _t27 = Math.fma(_self02, _self10, -(_self00 * _self12));
        double _t28 = Math.fma(_self01, _self20, -(_self00 * _self21));
        double _t29 = Math.fma(_self00, _self11, -(_self01 * _self10));
        double _t33 = Math.fma(_self02, _t21, Math.fma(_self00, _t20, -(_self01 * Math.fma(_self10, _self22, -(_self12 * _self20)))));
        double _t33_inv = 1.0 / _t33;
        dest.put(destOffset + 0, _t20 * _t33_inv);
        dest.put(destOffset + 1, _t23 * _t33_inv);
        dest.put(destOffset + 2, _t24 * _t33_inv);
        dest.put(destOffset + 3, -(Math.fma(_self23, _t24, Math.fma(_self03, _t20, _self13 * _t23)) * _t33_inv));
        dest.put(destOffset + 4, _t25 * _t33_inv);
        dest.put(destOffset + 5, _t26 * _t33_inv);
        dest.put(destOffset + 6, _t27 * _t33_inv);
        dest.put(destOffset + 7, -(Math.fma(_self23, _t27, Math.fma(_self03, _t25, _self13 * _t26)) * _t33_inv));
        dest.put(destOffset + 8, _t21 * _t33_inv);
        dest.put(destOffset + 9, _t28 * _t33_inv);
        dest.put(destOffset + 10, _t29 * _t33_inv);
        dest.put(destOffset + 11, -(Math.fma(_self23, _t29, Math.fma(_self03, _t21, _self13 * _t28)) * _t33_inv));
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
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _other00 = other.get(otherOffset + 0);
        double _other01 = other.get(otherOffset + 1);
        double _other02 = other.get(otherOffset + 2);
        double _other03 = other.get(otherOffset + 3);
        double _other10 = other.get(otherOffset + 4);
        double _other11 = other.get(otherOffset + 5);
        double _other12 = other.get(otherOffset + 6);
        double _other13 = other.get(otherOffset + 7);
        double _other20 = other.get(otherOffset + 8);
        double _other21 = other.get(otherOffset + 9);
        double _other22 = other.get(otherOffset + 10);
        double _other23 = other.get(otherOffset + 11);
        double _t24 = Math.fma(_other21, _self12, Math.fma(_other01, _self10, _other11 * _self11));
        double _t25 = Math.fma(_other22, _self22, Math.fma(_other02, _self20, _other12 * _self21));
        double _t26 = Math.fma(_other21, _self22, Math.fma(_other01, _self20, _other11 * _self21));
        double _t27 = Math.fma(_other22, _self12, Math.fma(_other02, _self10, _other12 * _self11));
        double _t28 = Math.fma(_other22, _self02, Math.fma(_other02, _self00, _other12 * _self01));
        double _t29 = Math.fma(_other20, _self12, Math.fma(_other00, _self10, _other10 * _self11));
        double _t30 = Math.fma(_other20, _self22, Math.fma(_other00, _self20, _other10 * _self21));
        double _t31 = Math.fma(_other20, _self02, Math.fma(_other00, _self00, _other10 * _self01));
        double _t32 = Math.fma(_other21, _self02, Math.fma(_other01, _self00, _other11 * _self01));
        double _t33 = Math.fma(_other03, _self20, Math.fma(_other13, _self21, Math.fma(_other23, _self22, _self23)));
        double _t34 = Math.fma(_other03, _self00, Math.fma(_other13, _self01, Math.fma(_other23, _self02, _self03)));
        double _t35 = Math.fma(_other03, _self10, Math.fma(_other13, _self11, Math.fma(_other23, _self12, _self13)));
        double _t56 = Math.fma(_t24, _t25, -(_t26 * _t27));
        double _t57 = Math.fma(_t29, _t26, -(_t30 * _t24));
        double _t59 = Math.fma(_t26, _t28, -(_t32 * _t25));
        double _t60 = Math.fma(_t32, _t27, -(_t24 * _t28));
        double _t61 = Math.fma(_t30, _t27, -(_t29 * _t25));
        double _t62 = Math.fma(_t31, _t25, -(_t30 * _t28));
        double _t63 = Math.fma(_t29, _t28, -(_t31 * _t27));
        double _t64 = Math.fma(_t30, _t32, -(_t31 * _t26));
        double _t65 = Math.fma(_t31, _t24, -(_t29 * _t32));
        double _t69 = Math.fma(_t28, _t57, Math.fma(_t31, _t56, -(_t32 * Math.fma(_t29, _t25, -(_t30 * _t27)))));
        double _t69_inv = 1.0 / _t69;
        dest.put(destOffset + 0, _t56 * _t69_inv);
        dest.put(destOffset + 1, _t59 * _t69_inv);
        dest.put(destOffset + 2, _t60 * _t69_inv);
        dest.put(destOffset + 3, -(Math.fma(_t33, _t60, Math.fma(_t34, _t56, _t35 * _t59)) * _t69_inv));
        dest.put(destOffset + 4, _t61 * _t69_inv);
        dest.put(destOffset + 5, _t62 * _t69_inv);
        dest.put(destOffset + 6, _t63 * _t69_inv);
        dest.put(destOffset + 7, -(Math.fma(_t33, _t63, Math.fma(_t34, _t61, _t35 * _t62)) * _t69_inv));
        dest.put(destOffset + 8, _t57 * _t69_inv);
        dest.put(destOffset + 9, _t64 * _t69_inv);
        dest.put(destOffset + 10, _t65 * _t69_inv);
        dest.put(destOffset + 11, -(Math.fma(_t33, _t65, Math.fma(_t34, _t57, _t35 * _t64)) * _t69_inv));
        return dest;
    }

    public static java.nio.DoubleBuffer transpose_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.transpose_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer transpose_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _i = 0; _i < 12; _i++) {
            double _eself = src.get(srcOffset + _i);
            dest.put(destOffset + _i, _eself);
        }
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
        for (int _i = 0; _i < 12; _i++) {
            double _eself = src.get(srcOffset + _i);
            double _eother = other.get(otherOffset + _i);
            dest.put(destOffset + _i, _eother + _eself);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer negate_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.negate_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer negate_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _i = 0; _i < 12; _i++) {
            double _eself = src.get(srcOffset + _i);
            dest.put(destOffset + _i, -_eself);
        }
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
        for (int _i = 0; _i < 12; _i++) {
            double _eself = src.get(srcOffset + _i);
            double _eother = other.get(otherOffset + _i);
            dest.put(destOffset + _i, _eself - _eother);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer set_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 8L;
        Double3x4OpsKernelsAddress.set_unsafe(_destBase, _vBase);
        return dest;
    }

    public static java.nio.DoubleBuffer set_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer v, int vOffset) {
        for (int _i = 0; _i < 12; _i++) {
            double _ev = v.get(vOffset + _i);
            dest.put(destOffset + _i, _ev);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer setMat3x3_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer m, int mOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _mBase = UnsafeOpsHolder.U.getLong(m, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) mOffset * 8L;
        Double3x4OpsKernelsAddress.setMat3x3_unsafe(_destBase, _mBase);
        return dest;
    }

    public static java.nio.DoubleBuffer setMat3x3_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer m, int mOffset) {
        double _m00 = m.get(mOffset + 0);
        double _m10 = m.get(mOffset + 1);
        double _m20 = m.get(mOffset + 2);
        double _m01 = m.get(mOffset + 3);
        double _m11 = m.get(mOffset + 4);
        double _m21 = m.get(mOffset + 5);
        double _m02 = m.get(mOffset + 6);
        double _m12 = m.get(mOffset + 7);
        double _m22 = m.get(mOffset + 8);
        dest.put(destOffset + 0, _m00);
        dest.put(destOffset + 1, _m01);
        dest.put(destOffset + 2, _m02);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, _m10);
        dest.put(destOffset + 5, _m11);
        dest.put(destOffset + 6, _m12);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, _m20);
        dest.put(destOffset + 9, _m21);
        dest.put(destOffset + 10, _m22);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer setMat4x4_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer m, int mOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _mBase = UnsafeOpsHolder.U.getLong(m, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) mOffset * 8L;
        Double3x4OpsKernelsAddress.setMat4x4_unsafe(_destBase, _mBase);
        return dest;
    }

    public static java.nio.DoubleBuffer setMat4x4_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer m, int mOffset) {
        double _m00 = m.get(mOffset + 0);
        double _m10 = m.get(mOffset + 1);
        double _m20 = m.get(mOffset + 2);
        double _m01 = m.get(mOffset + 4);
        double _m11 = m.get(mOffset + 5);
        double _m21 = m.get(mOffset + 6);
        double _m02 = m.get(mOffset + 8);
        double _m12 = m.get(mOffset + 9);
        double _m22 = m.get(mOffset + 10);
        double _m03 = m.get(mOffset + 12);
        double _m13 = m.get(mOffset + 13);
        double _m23 = m.get(mOffset + 14);
        dest.put(destOffset + 0, _m00);
        dest.put(destOffset + 1, _m01);
        dest.put(destOffset + 2, _m02);
        dest.put(destOffset + 3, _m03);
        dest.put(destOffset + 4, _m10);
        dest.put(destOffset + 5, _m11);
        dest.put(destOffset + 6, _m12);
        dest.put(destOffset + 7, _m13);
        dest.put(destOffset + 8, _m20);
        dest.put(destOffset + 9, _m21);
        dest.put(destOffset + 10, _m22);
        dest.put(destOffset + 11, _m23);
        return dest;
    }

    public static java.nio.DoubleBuffer withTranslation_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double tX, double tY, double tZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.withTranslation_unsafe(_destBase, _srcBase, tX, tY, tZ);
        return dest;
    }

    public static java.nio.DoubleBuffer withTranslation_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double tX, double tY, double tZ) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        dest.put(destOffset + 0, _self00);
        dest.put(destOffset + 1, _self01);
        dest.put(destOffset + 2, _self02);
        dest.put(destOffset + 3, tX);
        dest.put(destOffset + 4, _self10);
        dest.put(destOffset + 5, _self11);
        dest.put(destOffset + 6, _self12);
        dest.put(destOffset + 7, tY);
        dest.put(destOffset + 8, _self20);
        dest.put(destOffset + 9, _self21);
        dest.put(destOffset + 10, _self22);
        dest.put(destOffset + 11, tZ);
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
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _tx = t.get(tOffset + 0);
        double _ty = t.get(tOffset + 1);
        double _tz = t.get(tOffset + 2);
        dest.put(destOffset + 0, _self00);
        dest.put(destOffset + 1, _self01);
        dest.put(destOffset + 2, _self02);
        dest.put(destOffset + 3, _tx);
        dest.put(destOffset + 4, _self10);
        dest.put(destOffset + 5, _self11);
        dest.put(destOffset + 6, _self12);
        dest.put(destOffset + 7, _ty);
        dest.put(destOffset + 8, _self20);
        dest.put(destOffset + 9, _self21);
        dest.put(destOffset + 10, _self22);
        dest.put(destOffset + 11, _tz);
        return dest;
    }

    public static java.nio.DoubleBuffer makeFromRigid_unsafe(java.nio.DoubleBuffer dest, int destOffset, double rTX, double rTY, double rTZ, double rRX, double rRY, double rRZ, double rRW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeFromRigid_unsafe(_destBase, rTX, rTY, rTZ, rRX, rRY, rRZ, rRW);
        return dest;
    }

    public static java.nio.DoubleBuffer makeFromRigid_api(java.nio.DoubleBuffer dest, int destOffset, double rTX, double rTY, double rTZ, double rRX, double rRY, double rRZ, double rRW) {
        double _t0 = rRZ * rRZ;
        double _t1 = rRZ * rRW;
        double _t2 = rRY * rRW;
        dest.put(destOffset + 0, Math.fma(-2.0, Math.fma(rRY, rRY, _t0), 1.0));
        dest.put(destOffset + 1, 2.0 * Math.fma(rRX, rRY, -_t1));
        dest.put(destOffset + 2, 2.0 * Math.fma(rRX, rRZ, _t2));
        dest.put(destOffset + 3, rTX);
        dest.put(destOffset + 4, 2.0 * Math.fma(rRX, rRY, _t1));
        dest.put(destOffset + 5, Math.fma(-2.0, Math.fma(rRX, rRX, _t0), 1.0));
        dest.put(destOffset + 6, 2.0 * Math.fma(rRY, rRZ, -(rRX * rRW)));
        dest.put(destOffset + 7, rTY);
        dest.put(destOffset + 8, 2.0 * Math.fma(rRX, rRZ, -_t2));
        dest.put(destOffset + 9, 2.0 * Math.fma(rRX, rRW, rRY * rRZ));
        dest.put(destOffset + 10, Math.fma(-2.0, Math.fma(rRX, rRX, rRY * rRY), 1.0));
        dest.put(destOffset + 11, rTZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeFromTransform_unsafe(java.nio.DoubleBuffer dest, int destOffset, double tTX, double tTY, double tTZ, double tRX, double tRY, double tRZ, double tRW, double tSX, double tSY, double tSZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeFromTransform_unsafe(_destBase, tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeFromTransform_api(java.nio.DoubleBuffer dest, int destOffset, double tTX, double tTY, double tTZ, double tRX, double tRY, double tRZ, double tRW, double tSX, double tSY, double tSZ) {
        double _t0 = tRZ * tRZ;
        double _t1 = tRZ * tRW;
        double _t2 = tRY * tRW;
        dest.put(destOffset + 0, tSX * Math.fma(-2.0, Math.fma(tRY, tRY, _t0), 1.0));
        dest.put(destOffset + 1, tSY * 2.0 * Math.fma(tRX, tRY, -_t1));
        dest.put(destOffset + 2, tSZ * 2.0 * Math.fma(tRX, tRZ, _t2));
        dest.put(destOffset + 3, tTX);
        dest.put(destOffset + 4, tSX * 2.0 * Math.fma(tRX, tRY, _t1));
        dest.put(destOffset + 5, tSY * Math.fma(-2.0, Math.fma(tRX, tRX, _t0), 1.0));
        dest.put(destOffset + 6, tSZ * 2.0 * Math.fma(tRY, tRZ, -(tRX * tRW)));
        dest.put(destOffset + 7, tTY);
        dest.put(destOffset + 8, tSX * 2.0 * Math.fma(tRX, tRZ, -_t2));
        dest.put(destOffset + 9, tSY * 2.0 * Math.fma(tRX, tRW, tRY * tRZ));
        dest.put(destOffset + 10, tSZ * Math.fma(-2.0, Math.fma(tRX, tRX, tRY * tRY), 1.0));
        dest.put(destOffset + 11, tTZ);
        return dest;
    }

    public static java.nio.DoubleBuffer to3x3_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.to3x3_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer to3x3_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        dest.put(destOffset + 0, _self00);
        dest.put(destOffset + 1, _self10);
        dest.put(destOffset + 2, _self20);
        dest.put(destOffset + 3, _self01);
        dest.put(destOffset + 4, _self11);
        dest.put(destOffset + 5, _self21);
        dest.put(destOffset + 6, _self02);
        dest.put(destOffset + 7, _self12);
        dest.put(destOffset + 8, _self22);
        return dest;
    }

    public static java.nio.DoubleBuffer to4x4_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.to4x4_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer to4x4_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        dest.put(destOffset + 0, _self00);
        dest.put(destOffset + 1, _self10);
        dest.put(destOffset + 2, _self20);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, _self01);
        dest.put(destOffset + 5, _self11);
        dest.put(destOffset + 6, _self21);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, _self02);
        dest.put(destOffset + 9, _self12);
        dest.put(destOffset + 10, _self22);
        dest.put(destOffset + 11, 0.0);
        dest.put(destOffset + 12, _self03);
        dest.put(destOffset + 13, _self13);
        dest.put(destOffset + 14, _self23);
        dest.put(destOffset + 15, 1.0);
        return dest;
    }

    public static java.nio.DoubleBuffer toDualQuat_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.toDualQuat_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer toDualQuat_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _t0 = -_self23;
        double _t2 = 1.0 - _self00;
        double _t4 = _self21 - _self12;
        double _t5 = Math.max(_self11, _self22);
        double _t6 = _self01 + _self10;
        double _t7 = _self02 + _self20;
        double _t8 = _self02 - _self20;
        double _t9 = _self12 + _self21;
        double _t10 = _self10 - _self01;
        double _t14 = _self22 + (_self00 + _self11);
        double _t15 = 1.0 + _t14;
        double _t16 = _self00 + (1.0 - _self11 - _self22);
        double _t17 = _self11 + (_t2 - _self22);
        double _t18 = _self22 + (_t2 - _self11);
        double _t19 = (1.0 / Math.sqrt(_t15));
        double _t21 = (1.0 / Math.sqrt(_t17));
        double _t22 = (1.0 / Math.sqrt(_t18));
        double _t23 = (1.0 / Math.sqrt(_t16));
        double _t63, _t64, _t65, _t66;
        if (_t14 > 0.0) {
            _t63 = 0.5 * _t4 * _t19;
            _t64 = 0.5 * _t8 * _t19;
            _t65 = 0.5 * _t10 * _t19;
            _t66 = 0.5 * Math.sqrt(_t15);
        } else {
            if (_self00 > _t5) {
                _t63 = 0.5 * Math.sqrt(_t16);
                _t64 = 0.5 * _t6 * _t23;
                _t65 = 0.5 * _t7 * _t23;
                _t66 = 0.5 * _t4 * _t23;
            } else {
                if (_self11 > _self22) {
                    _t63 = 0.5 * _t6 * _t21;
                    _t64 = 0.5 * Math.sqrt(_t17);
                    _t65 = 0.5 * _t9 * _t21;
                    _t66 = 0.5 * _t8 * _t21;
                } else {
                    _t63 = 0.5 * _t7 * _t22;
                    _t64 = 0.5 * _t9 * _t22;
                    _t65 = 0.5 * Math.sqrt(_t18);
                    _t66 = 0.5 * _t10 * _t22;
                }
            }
        }
        dest.put(destOffset + 0, _t63);
        dest.put(destOffset + 1, _t64);
        dest.put(destOffset + 2, _t65);
        dest.put(destOffset + 3, _t66);
        dest.put(destOffset + 4, 0.5 * Math.fma(_t0, _t64, Math.fma(_self03, _t66, _self13 * _t65)));
        dest.put(destOffset + 5, 0.5 * Math.fma(_self23, _t63, Math.fma(_self13, _t66, -(_self03 * _t65))));
        dest.put(destOffset + 6, 0.5 * Math.fma(_self23, _t66, Math.fma(_self03, _t64, -(_self13 * _t63))));
        dest.put(destOffset + 7, 0.5 * Math.fma(_t0, _t65, Math.fma(-_self13, _t64, -(_self03 * _t63))));
        return dest;
    }

    public static java.nio.DoubleBuffer toRigid_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.toRigid_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer toRigid_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _t0 = -_self11;
        double _t1 = -_self22;
        double _t12 = (1.0 / Math.sqrt(Math.fma(_self21, _self21, Math.fma(_self01, _self01, _self11 * _self11))));
        double _t13 = (1.0 / Math.sqrt(Math.fma(_self22, _self22, Math.fma(_self02, _self02, _self12 * _self12))));
        double _t14 = (1.0 / Math.sqrt(Math.fma(_self20, _self20, Math.fma(_self00, _self00, _self10 * _self10))));
        double _t15 = _self10 * _t14;
        double _t16 = _self22 * _t13;
        double _t17 = _self12 * _t13;
        double _t18 = _self20 * _t14;
        double _t20 = _self21 * _t12;
        double _t21 = _self11 * _t12;
        double _t23 = _self00 * _t14;
        double _t28 = Math.fma(_self12, _t13, _t20);
        double _t32 = Math.fma(_self21, _t12, -_t17);
        double _t33 = Math.max(_t21, _t16);
        double _t43 = Math.fma(-Math.fma(_t15, _t16, -(_t17 * _t18)), _self01 * _t12, Math.fma(Math.fma(_t15, _t20, -(_t21 * _t18)), _self02 * _t13, Math.fma(_t21, _t16, -(_t17 * _t20)) * _t23));
        double _t44, _t45, _t46;
        if (_t43 < 0.0) {
            _t44 = -_t23;
            _t45 = -_t15;
            _t46 = -_t18;
        } else {
            _t44 = _t23;
            _t45 = _t15;
            _t46 = _t18;
        }
        double _t48 = 1.0 + _t44;
        double _t49 = 1.0 - _t44;
        double _t51 = Math.fma(_self01, _t12, _t45);
        double _t52 = Math.fma(_self02, _t13, _t46);
        double _t53 = Math.fma(_self02, _t13, -_t46);
        double _t54 = Math.fma(-_self01, _t12, _t45);
        double _t59 = Math.fma(_self11, _t12, Math.fma(_self22, _t13, _t44));
        double _t60 = Math.fma(_self11, _t12, Math.fma(_self22, _t13, _t48));
        double _t61 = (1.0 / Math.sqrt(_t60));
        double _t62 = Math.fma(_self11, _t12, Math.fma(_t1, _t13, _t49));
        double _t63 = Math.fma(_self22, _t13, Math.fma(_t0, _t12, _t49));
        double _t64 = Math.fma(_t0, _t12, Math.fma(_t1, _t13, _t48));
        double _t65 = (1.0 / Math.sqrt(_t62));
        double _t66 = (1.0 / Math.sqrt(_t63));
        double _t67 = (1.0 / Math.sqrt(_t64));
        if (_t59 > 0.0) {
            dest.put(destOffset + 3, 0.5 * _t32 * _t61);
            dest.put(destOffset + 4, 0.5 * _t53 * _t61);
            dest.put(destOffset + 5, 0.5 * _t54 * _t61);
            dest.put(destOffset + 6, 0.5 * Math.sqrt(_t60));
        } else {
            if (_t44 > _t33) {
                dest.put(destOffset + 3, 0.5 * Math.sqrt(_t64));
                dest.put(destOffset + 4, 0.5 * _t51 * _t67);
                dest.put(destOffset + 5, 0.5 * _t52 * _t67);
                dest.put(destOffset + 6, 0.5 * _t32 * _t67);
            } else {
                if (_t21 > _t16) {
                    dest.put(destOffset + 3, 0.5 * _t51 * _t65);
                    dest.put(destOffset + 4, 0.5 * Math.sqrt(_t62));
                    dest.put(destOffset + 5, 0.5 * _t28 * _t65);
                    dest.put(destOffset + 6, 0.5 * _t53 * _t65);
                } else {
                    dest.put(destOffset + 3, 0.5 * _t52 * _t66);
                    dest.put(destOffset + 4, 0.5 * _t28 * _t66);
                    dest.put(destOffset + 5, 0.5 * Math.sqrt(_t63));
                    dest.put(destOffset + 6, 0.5 * _t54 * _t66);
                }
            }
        }
        dest.put(destOffset + 0, _self03);
        dest.put(destOffset + 1, _self13);
        dest.put(destOffset + 2, _self23);
        return dest;
    }

    public static java.nio.DoubleBuffer toTransform_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.toTransform_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer toTransform_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _t0 = -_self11;
        double _t1 = -_self22;
        double _t9 = Math.fma(_self21, _self21, Math.fma(_self01, _self01, _self11 * _self11));
        double _t10 = Math.fma(_self22, _self22, Math.fma(_self02, _self02, _self12 * _self12));
        double _t11 = Math.fma(_self20, _self20, Math.fma(_self00, _self00, _self10 * _self10));
        double _t12 = (1.0 / Math.sqrt(_t9));
        double _t13 = (1.0 / Math.sqrt(_t10));
        double _t14 = (1.0 / Math.sqrt(_t11));
        double _t15 = Math.sqrt(_t11);
        double _t16 = _self10 * _t14;
        double _t17 = _self22 * _t13;
        double _t18 = _self12 * _t13;
        double _t19 = _self20 * _t14;
        double _t21 = _self21 * _t12;
        double _t22 = _self11 * _t12;
        double _t24 = _self00 * _t14;
        double _t29 = Math.fma(_self12, _t13, _t21);
        double _t33 = Math.fma(_self21, _t12, -_t18);
        double _t34 = Math.max(_t22, _t17);
        double _t44 = Math.fma(-Math.fma(_t16, _t17, -(_t18 * _t19)), _self01 * _t12, Math.fma(Math.fma(_t16, _t21, -(_t22 * _t19)), _self02 * _t13, Math.fma(_t22, _t17, -(_t18 * _t21)) * _t24));
        double _t45, _t46, _t47;
        if (_t44 < 0.0) {
            _t45 = -_t24;
            _t46 = -_t16;
            _t47 = -_t19;
        } else {
            _t45 = _t24;
            _t46 = _t16;
            _t47 = _t19;
        }
        double _t49 = 1.0 + _t45;
        double _t50 = 1.0 - _t45;
        double _t52 = Math.fma(_self01, _t12, _t46);
        double _t53 = Math.fma(_self02, _t13, _t47);
        double _t54 = Math.fma(_self02, _t13, -_t47);
        double _t55 = Math.fma(-_self01, _t12, _t46);
        double _t60 = Math.fma(_self11, _t12, Math.fma(_self22, _t13, _t45));
        double _t61 = Math.fma(_self11, _t12, Math.fma(_self22, _t13, _t49));
        double _t62 = (1.0 / Math.sqrt(_t61));
        double _t63 = Math.fma(_self11, _t12, Math.fma(_t1, _t13, _t50));
        double _t64 = Math.fma(_self22, _t13, Math.fma(_t0, _t12, _t50));
        double _t65 = Math.fma(_t0, _t12, Math.fma(_t1, _t13, _t49));
        double _t66 = (1.0 / Math.sqrt(_t63));
        double _t67 = (1.0 / Math.sqrt(_t64));
        double _t68 = (1.0 / Math.sqrt(_t65));
        dest.put(destOffset + 0, _self03);
        dest.put(destOffset + 1, _self13);
        dest.put(destOffset + 2, _self23);
        dest.put(destOffset + 3, _t60 > 0.0 ? 0.5 * _t33 * _t62 : _t45 > _t34 ? 0.5 * Math.sqrt(_t65) : _t22 > _t17 ? 0.5 * _t52 * _t66 : 0.5 * _t53 * _t67);
        dest.put(destOffset + 4, _t60 > 0.0 ? 0.5 * _t54 * _t62 : _t45 > _t34 ? 0.5 * _t52 * _t68 : _t22 > _t17 ? 0.5 * Math.sqrt(_t63) : 0.5 * _t29 * _t67);
        dest.put(destOffset + 5, _t60 > 0.0 ? 0.5 * _t55 * _t62 : _t45 > _t34 ? 0.5 * _t53 * _t68 : _t22 > _t17 ? 0.5 * _t29 * _t66 : 0.5 * Math.sqrt(_t64));
        dest.put(destOffset + 6, _t60 > 0.0 ? 0.5 * Math.sqrt(_t61) : _t45 > _t34 ? 0.5 * _t33 * _t68 : _t22 > _t17 ? 0.5 * _t54 * _t66 : 0.5 * _t55 * _t67);
        dest.put(destOffset + 7, _t44 < 0.0 ? -_t15 : _t15);
        dest.put(destOffset + 8, Math.sqrt(_t9));
        dest.put(destOffset + 9, Math.sqrt(_t10));
        return dest;
    }

    public static java.nio.DoubleBuffer decomposeRotation_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.decomposeRotation_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer decomposeRotation_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _t2 = Math.fma(_self20, _self20, Math.fma(_self00, _self00, _self10 * _self10));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7, _t8, _t9;
        if (_t2 > 0.0) {
            _t7 = _self20 * _t3;
            _t8 = _self00 * _t3;
            _t9 = _self10 * _t3;
        } else {
            _t7 = 0.0;
            _t8 = 0.0;
            _t9 = 0.0;
        }
        double _t19 = -Math.fma(_self21, _t7, Math.fma(_self01, _t8, _self11 * _t9));
        double _t20 = -Math.fma(_self22, _t7, Math.fma(_self02, _t8, _self12 * _t9));
        double _t21 = Math.fma(_t19, _t7, _self21);
        double _t22 = Math.fma(_t19, _t8, _self01);
        double _t23 = Math.fma(_t19, _t9, _self11);
        double _t29 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        double _t30 = (1.0 / Math.sqrt(_t29));
        double _t34, _t35, _t36;
        if (_t29 > 0.0) {
            _t34 = _t22 * _t30;
            _t35 = _t21 * _t30;
            _t36 = _t23 * _t30;
        } else {
            _t34 = 0.0;
            _t35 = 0.0;
            _t36 = 0.0;
        }
        double _t40 = -Math.fma(Math.fma(_t20, _t7, _self22), _t35, Math.fma(Math.fma(_t20, _t8, _self02), _t34, Math.fma(_t20, _t9, _self12) * _t36));
        double _t44 = Math.fma(_t20, _t7, Math.fma(_t40, _t35, _self22));
        double _t45 = Math.fma(_t20, _t8, Math.fma(_t40, _t34, _self02));
        double _t46 = Math.fma(_t20, _t9, Math.fma(_t40, _t36, _self12));
        double _t49 = Math.fma(_t44, _t44, Math.fma(_t45, _t45, _t46 * _t46));
        double _t50 = (1.0 / Math.sqrt(_t49));
        double _t54, _t55, _t56;
        if (_t49 > 0.0) {
            _t54 = _t46 * _t50;
            _t55 = _t45 * _t50;
            _t56 = _t44 * _t50;
        } else {
            _t54 = 0.0;
            _t55 = 0.0;
            _t56 = 0.0;
        }
        double _t60 = _t35 - _t54;
        double _t61 = Math.max(_t36, _t56);
        double _t63 = _t35 + _t54;
        double _t72 = Math.fma(Math.fma(_t34, _t54, -(_t36 * _t55)), _t7, Math.fma(Math.fma(_t36, _t56, -(_t35 * _t54)), _t8, Math.fma(_t35, _t55, -(_t34 * _t56)) * _t9));
        double _t73, _t74, _t75;
        if (_t72 < 0.0) {
            _t73 = -_t8;
            _t74 = -_t9;
            _t75 = -_t7;
        } else {
            _t73 = _t8;
            _t74 = _t9;
            _t75 = _t7;
        }
        double _t76 = _t73 + _t36;
        double _t77 = _t74 + _t34;
        double _t78 = _t74 - _t34;
        double _t80 = _t75 + _t55;
        double _t81 = _t55 - _t75;
        double _t82 = _t76 + _t56;
        double _t86 = 1.0 + _t82;
        double _t87 = 1.0 + (_t73 - (_t36 + _t56));
        double _t88 = 1.0 + (_t36 - (_t73 + _t56));
        double _t89 = 1.0 + (_t56 - _t76);
        double _t90 = (1.0 / Math.sqrt(_t86));
        double _t91 = (1.0 / Math.sqrt(_t88));
        double _t92 = (1.0 / Math.sqrt(_t89));
        double _t93 = (1.0 / Math.sqrt(_t87));
        if (_t82 > 0.0) {
            dest.put(destOffset + 0, 0.5 * _t60 * _t90);
            dest.put(destOffset + 1, 0.5 * _t81 * _t90);
            dest.put(destOffset + 2, 0.5 * _t78 * _t90);
            dest.put(destOffset + 3, 0.5 * Math.sqrt(_t86));
        } else {
            if (_t73 > _t61) {
                dest.put(destOffset + 0, 0.5 * Math.sqrt(_t87));
                dest.put(destOffset + 1, 0.5 * _t77 * _t93);
                dest.put(destOffset + 2, 0.5 * _t80 * _t93);
                dest.put(destOffset + 3, 0.5 * _t60 * _t93);
            } else {
                if (_t36 > _t56) {
                    dest.put(destOffset + 0, 0.5 * _t77 * _t91);
                    dest.put(destOffset + 1, 0.5 * Math.sqrt(_t88));
                    dest.put(destOffset + 2, 0.5 * _t63 * _t91);
                    dest.put(destOffset + 3, 0.5 * _t81 * _t91);
                } else {
                    dest.put(destOffset + 0, 0.5 * _t80 * _t92);
                    dest.put(destOffset + 1, 0.5 * _t63 * _t92);
                    dest.put(destOffset + 2, 0.5 * Math.sqrt(_t89));
                    dest.put(destOffset + 3, 0.5 * _t78 * _t92);
                }
            }
        }
        return dest;
    }

    public static java.nio.DoubleBuffer decomposeScale_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.decomposeScale_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer decomposeScale_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _t2 = Math.fma(_self20, _self20, Math.fma(_self00, _self00, _self10 * _self10));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t4 = Math.sqrt(_t2);
        double _t8, _t9, _t10;
        if (_t2 > 0.0) {
            _t8 = _self20 * _t3;
            _t9 = _self00 * _t3;
            _t10 = _self10 * _t3;
        } else {
            _t8 = 0.0;
            _t9 = 0.0;
            _t10 = 0.0;
        }
        double _t17 = -Math.fma(_self21, _t8, Math.fma(_self01, _t9, _self11 * _t10));
        double _t18 = -Math.fma(_self22, _t8, Math.fma(_self02, _t9, _self12 * _t10));
        double _t19 = Math.fma(_t17, _t8, _self21);
        double _t20 = Math.fma(_t17, _t9, _self01);
        double _t21 = Math.fma(_t17, _t10, _self11);
        double _t27 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        double _t28 = (1.0 / Math.sqrt(_t27));
        double _t32, _t33, _t34;
        if (_t27 > 0.0) {
            _t32 = _t20 * _t28;
            _t33 = _t19 * _t28;
            _t34 = _t21 * _t28;
        } else {
            _t32 = 0.0;
            _t33 = 0.0;
            _t34 = 0.0;
        }
        double _t38 = -Math.fma(Math.fma(_t18, _t8, _self22), _t33, Math.fma(Math.fma(_t18, _t9, _self02), _t32, Math.fma(_t18, _t10, _self12) * _t34));
        double _t42 = Math.fma(_t18, _t8, Math.fma(_t38, _t33, _self22));
        double _t43 = Math.fma(_t18, _t9, Math.fma(_t38, _t32, _self02));
        double _t44 = Math.fma(_t18, _t10, Math.fma(_t38, _t34, _self12));
        double _t47 = Math.fma(_t42, _t42, Math.fma(_t43, _t43, _t44 * _t44));
        double _t48 = (1.0 / Math.sqrt(_t47));
        double _t52, _t53, _t54;
        if (_t47 > 0.0) {
            _t52 = _t44 * _t48;
            _t53 = _t43 * _t48;
            _t54 = _t42 * _t48;
        } else {
            _t52 = 0.0;
            _t53 = 0.0;
            _t54 = 0.0;
        }
        dest.put(destOffset + 0, Math.fma(Math.fma(_t32, _t52, -(_t34 * _t53)), _t8, Math.fma(Math.fma(_t34, _t54, -(_t33 * _t52)), _t9, Math.fma(_t33, _t53, -(_t32 * _t54)) * _t10)) < 0.0 ? -_t4 : _t4);
        dest.put(destOffset + 1, Math.sqrt(_t27));
        dest.put(destOffset + 2, Math.sqrt(_t47));
        return dest;
    }

    public static java.nio.DoubleBuffer decomposeSkew_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.decomposeSkew_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer decomposeSkew_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _t2 = Math.fma(_self20, _self20, Math.fma(_self00, _self00, _self10 * _self10));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7, _t8, _t9;
        if (_t2 > 0.0) {
            _t7 = _self20 * _t3;
            _t8 = _self00 * _t3;
            _t9 = _self10 * _t3;
        } else {
            _t7 = 0.0;
            _t8 = 0.0;
            _t9 = 0.0;
        }
        double _t14 = Math.fma(_self22, _t7, Math.fma(_self02, _t8, _self12 * _t9));
        double _t15 = Math.fma(_self21, _t7, Math.fma(_self01, _t8, _self11 * _t9));
        double _t16 = -_t14;
        double _t17 = -_t15;
        double _t19 = Math.fma(_t17, _t7, _self21);
        double _t20 = Math.fma(_t17, _t8, _self01);
        double _t21 = Math.fma(_t17, _t9, _self11);
        double _t26 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        double _t27 = (1.0 / Math.sqrt(_t26));
        double _t28 = _t15 * _t27;
        double _t32, _t33, _t34;
        if (_t26 > 0.0) {
            _t32 = _t19 * _t27;
            _t33 = _t20 * _t27;
            _t34 = _t21 * _t27;
        } else {
            _t32 = 0.0;
            _t33 = 0.0;
            _t34 = 0.0;
        }
        double _t37 = Math.fma(Math.fma(_t16, _t7, _self22), _t32, Math.fma(Math.fma(_t16, _t8, _self02), _t33, Math.fma(_t16, _t9, _self12) * _t34));
        double _t38 = -_t37;
        double _t42 = Math.fma(_t16, _t7, Math.fma(_t38, _t32, _self22));
        double _t43 = Math.fma(_t16, _t8, Math.fma(_t38, _t33, _self02));
        double _t44 = Math.fma(_t16, _t9, Math.fma(_t38, _t34, _self12));
        double _t47 = Math.fma(_t42, _t42, Math.fma(_t43, _t43, _t44 * _t44));
        double _t48 = (1.0 / Math.sqrt(_t47));
        double _t49 = _t14 * _t48;
        double _t53, _t54, _t55;
        if (_t47 > 0.0) {
            _t53 = _t44 * _t48;
            _t54 = _t43 * _t48;
            _t55 = _t42 * _t48;
        } else {
            _t53 = 0.0;
            _t54 = 0.0;
            _t55 = 0.0;
        }
        double _t67 = Math.fma(Math.fma(_t33, _t53, -(_t34 * _t54)), _t7, Math.fma(Math.fma(_t34, _t55, -(_t32 * _t53)), _t8, Math.fma(_t32, _t54, -(_t33 * _t55)) * _t9));
        if (_t67 < 0.0) {
            dest.put(destOffset + 1, -_t49);
            dest.put(destOffset + 2, -_t28);
        } else {
            dest.put(destOffset + 1, _t49);
            dest.put(destOffset + 2, _t28);
        }
        dest.put(destOffset + 0, _t37 * _t48);
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
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _t2 = Math.fma(_self20, _self20, Math.fma(_self00, _self00, _self10 * _self10));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t4 = Math.sqrt(_t2);
        double _t8, _t9, _t10;
        if (_t2 > 0.0) {
            _t8 = _self20 * _t3;
            _t9 = _self00 * _t3;
            _t10 = _self10 * _t3;
        } else {
            _t8 = 0.0;
            _t9 = 0.0;
            _t10 = 0.0;
        }
        double _t20 = -Math.fma(_self21, _t8, Math.fma(_self01, _t9, _self11 * _t10));
        double _t21 = -Math.fma(_self22, _t8, Math.fma(_self02, _t9, _self12 * _t10));
        double _t22 = Math.fma(_t20, _t8, _self21);
        double _t23 = Math.fma(_t20, _t9, _self01);
        double _t24 = Math.fma(_t20, _t10, _self11);
        double _t30 = Math.fma(_t22, _t22, Math.fma(_t23, _t23, _t24 * _t24));
        double _t31 = (1.0 / Math.sqrt(_t30));
        double _t35, _t36, _t37;
        if (_t30 > 0.0) {
            _t35 = _t23 * _t31;
            _t36 = _t22 * _t31;
            _t37 = _t24 * _t31;
        } else {
            _t35 = 0.0;
            _t36 = 0.0;
            _t37 = 0.0;
        }
        double _t41 = -Math.fma(Math.fma(_t21, _t8, _self22), _t36, Math.fma(Math.fma(_t21, _t9, _self02), _t35, Math.fma(_t21, _t10, _self12) * _t37));
        double _t45 = Math.fma(_t21, _t8, Math.fma(_t41, _t36, _self22));
        double _t46 = Math.fma(_t21, _t9, Math.fma(_t41, _t35, _self02));
        double _t47 = Math.fma(_t21, _t10, Math.fma(_t41, _t37, _self12));
        double _t50 = Math.fma(_t45, _t45, Math.fma(_t46, _t46, _t47 * _t47));
        double _t51 = (1.0 / Math.sqrt(_t50));
        double _t55, _t56, _t57;
        if (_t50 > 0.0) {
            _t55 = _t47 * _t51;
            _t56 = _t46 * _t51;
            _t57 = _t45 * _t51;
        } else {
            _t55 = 0.0;
            _t56 = 0.0;
            _t57 = 0.0;
        }
        double _t61 = _t36 - _t55;
        double _t62 = Math.max(_t37, _t57);
        double _t64 = _t36 + _t55;
        double _t73 = Math.fma(Math.fma(_t35, _t55, -(_t37 * _t56)), _t8, Math.fma(Math.fma(_t37, _t57, -(_t36 * _t55)), _t9, Math.fma(_t36, _t56, -(_t35 * _t57)) * _t10));
        double _t74, _t75, _t76;
        if (_t73 < 0.0) {
            _t74 = -_t9;
            _t75 = -_t10;
            _t76 = -_t8;
        } else {
            _t74 = _t9;
            _t75 = _t10;
            _t76 = _t8;
        }
        double _t77 = _t74 + _t37;
        double _t78 = _t75 + _t35;
        double _t79 = _t75 - _t35;
        double _t81 = _t76 + _t56;
        double _t82 = _t56 - _t76;
        double _t83 = _t77 + _t57;
        double _t87 = 1.0 + _t83;
        double _t88 = 1.0 + (_t74 - (_t37 + _t57));
        double _t89 = 1.0 + (_t37 - (_t74 + _t57));
        double _t90 = 1.0 + (_t57 - _t77);
        double _t91 = (1.0 / Math.sqrt(_t87));
        double _t92 = (1.0 / Math.sqrt(_t89));
        double _t93 = (1.0 / Math.sqrt(_t90));
        double _t94 = (1.0 / Math.sqrt(_t88));
        translation.put(translationOffset + 0, _self03);
        translation.put(translationOffset + 1, _self13);
        translation.put(translationOffset + 2, _self23);
        if (_t83 > 0.0) {
            rotation.put(rotationOffset + 0, 0.5 * _t61 * _t91);
            rotation.put(rotationOffset + 1, 0.5 * _t82 * _t91);
            rotation.put(rotationOffset + 2, 0.5 * _t79 * _t91);
            rotation.put(rotationOffset + 3, 0.5 * Math.sqrt(_t87));
        } else {
            if (_t74 > _t62) {
                rotation.put(rotationOffset + 0, 0.5 * Math.sqrt(_t88));
                rotation.put(rotationOffset + 1, 0.5 * _t78 * _t94);
                rotation.put(rotationOffset + 2, 0.5 * _t81 * _t94);
                rotation.put(rotationOffset + 3, 0.5 * _t61 * _t94);
            } else {
                if (_t37 > _t57) {
                    rotation.put(rotationOffset + 0, 0.5 * _t78 * _t92);
                    rotation.put(rotationOffset + 1, 0.5 * Math.sqrt(_t89));
                    rotation.put(rotationOffset + 2, 0.5 * _t64 * _t92);
                    rotation.put(rotationOffset + 3, 0.5 * _t82 * _t92);
                } else {
                    rotation.put(rotationOffset + 0, 0.5 * _t81 * _t93);
                    rotation.put(rotationOffset + 1, 0.5 * _t64 * _t93);
                    rotation.put(rotationOffset + 2, 0.5 * Math.sqrt(_t90));
                    rotation.put(rotationOffset + 3, 0.5 * _t79 * _t93);
                }
            }
        }
        scale.put(scaleOffset + 0, _t73 < 0.0 ? -_t4 : _t4);
        scale.put(scaleOffset + 1, Math.sqrt(_t30));
        scale.put(scaleOffset + 2, Math.sqrt(_t50));
        return translation;
    }

    public static java.nio.DoubleBuffer makeIdentity_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeIdentity_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeIdentity_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, 1.0);
        dest.put(destOffset + 1, 0.0);
        dest.put(destOffset + 2, 0.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 0.0);
        dest.put(destOffset + 5, 1.0);
        dest.put(destOffset + 6, 0.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 0.0);
        dest.put(destOffset + 9, 0.0);
        dest.put(destOffset + 10, 1.0);
        dest.put(destOffset + 11, 0.0);
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
        for (int _i = 0; _i < 12; _i++) {
            double _eself = src.get(srcOffset + _i);
            double _eother = other.get(otherOffset + _i);
            dest.put(destOffset + _i, Math.fma(t, _eother - _eself, _eself));
        }
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
        double _right00 = right.get(rightOffset + 0);
        double _right01 = right.get(rightOffset + 1);
        double _right02 = right.get(rightOffset + 2);
        double _right03 = right.get(rightOffset + 3);
        double _right10 = right.get(rightOffset + 4);
        double _right11 = right.get(rightOffset + 5);
        double _right12 = right.get(rightOffset + 6);
        double _right13 = right.get(rightOffset + 7);
        double _right20 = right.get(rightOffset + 8);
        double _right21 = right.get(rightOffset + 9);
        double _right22 = right.get(rightOffset + 10);
        double _right23 = right.get(rightOffset + 11);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, Math.fma(_right20, _eself2, Math.fma(_right00, _eself0, _right10 * _eself1)));
            dest.put(destOffset + _lo + 1, Math.fma(_right21, _eself2, Math.fma(_right01, _eself0, _right11 * _eself1)));
            dest.put(destOffset + _lo + 2, Math.fma(_right22, _eself2, Math.fma(_right02, _eself0, _right12 * _eself1)));
            dest.put(destOffset + _lo + 3, Math.fma(_right03, _eself0, Math.fma(_right13, _eself1, Math.fma(_right23, _eself2, _eself3))));
        }
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
        double _right00 = right.get(rightOffset + 0);
        double _right10 = right.get(rightOffset + 1);
        double _right01 = right.get(rightOffset + 2);
        double _right11 = right.get(rightOffset + 3);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, Math.fma(_right00, _eself0, _right10 * _eself1));
            dest.put(destOffset + _lo + 1, Math.fma(_right01, _eself0, _right11 * _eself1));
            dest.put(destOffset + _lo + 2, _eself2);
            dest.put(destOffset + _lo + 3, _eself3);
        }
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
        double _right00 = right.get(rightOffset + 0);
        double _right10 = right.get(rightOffset + 1);
        double _right01 = right.get(rightOffset + 2);
        double _right11 = right.get(rightOffset + 3);
        double _right02 = right.get(rightOffset + 4);
        double _right12 = right.get(rightOffset + 5);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, Math.fma(_right00, _eself0, _right10 * _eself1));
            dest.put(destOffset + _lo + 1, Math.fma(_right01, _eself0, _right11 * _eself1));
            dest.put(destOffset + _lo + 2, Math.fma(_right02, _eself0, Math.fma(_right12, _eself1, _eself2)));
            dest.put(destOffset + _lo + 3, _eself3);
        }
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
        double _right00 = right.get(rightOffset + 0);
        double _right10 = right.get(rightOffset + 1);
        double _right20 = right.get(rightOffset + 2);
        double _right01 = right.get(rightOffset + 3);
        double _right11 = right.get(rightOffset + 4);
        double _right21 = right.get(rightOffset + 5);
        double _right02 = right.get(rightOffset + 6);
        double _right12 = right.get(rightOffset + 7);
        double _right22 = right.get(rightOffset + 8);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, Math.fma(_right20, _eself2, Math.fma(_right00, _eself0, _right10 * _eself1)));
            dest.put(destOffset + _lo + 1, Math.fma(_right21, _eself2, Math.fma(_right01, _eself0, _right11 * _eself1)));
            dest.put(destOffset + _lo + 2, Math.fma(_right22, _eself2, Math.fma(_right02, _eself0, _right12 * _eself1)));
            dest.put(destOffset + _lo + 3, _eself3);
        }
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
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        for (int _l = 0; _l < 4; _l++) {
            int _lo = _l * 4;
            double _eright0 = right.get(rightOffset + _lo);
            double _eright1 = right.get(rightOffset + _lo + 1);
            double _eright2 = right.get(rightOffset + _lo + 2);
            double _eright3 = right.get(rightOffset + _lo + 3);
            dest.put(destOffset + _lo, Math.fma(_eright3, _self03, Math.fma(_eright2, _self02, Math.fma(_eright0, _self00, _eright1 * _self01))));
            dest.put(destOffset + _lo + 1, Math.fma(_eright3, _self13, Math.fma(_eright2, _self12, Math.fma(_eright0, _self10, _eright1 * _self11))));
            dest.put(destOffset + _lo + 2, Math.fma(_eright3, _self23, Math.fma(_eright2, _self22, Math.fma(_eright0, _self20, _eright1 * _self21))));
            dest.put(destOffset + _lo + 3, _eright3);
        }
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
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eother0 = other.get(otherOffset + _lo);
            double _eother1 = other.get(otherOffset + _lo + 1);
            double _eother2 = other.get(otherOffset + _lo + 2);
            double _eother3 = other.get(otherOffset + _lo + 3);
            dest.put(destOffset + _lo, Math.fma(_eother2, _self20, Math.fma(_eother0, _self00, _eother1 * _self10)));
            dest.put(destOffset + _lo + 1, Math.fma(_eother2, _self21, Math.fma(_eother0, _self01, _eother1 * _self11)));
            dest.put(destOffset + _lo + 2, Math.fma(_eother2, _self22, Math.fma(_eother0, _self02, _eother1 * _self12)));
            dest.put(destOffset + _lo + 3, Math.fma(_eother0, _self03, Math.fma(_eother1, _self13, Math.fma(_eother2, _self23, _eother3))));
        }
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
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _other00 = other.get(otherOffset + 0);
        double _other10 = other.get(otherOffset + 1);
        double _other01 = other.get(otherOffset + 2);
        double _other11 = other.get(otherOffset + 3);
        dest.put(destOffset + 0, Math.fma(_other00, _self00, _other01 * _self10));
        dest.put(destOffset + 1, Math.fma(_other00, _self01, _other01 * _self11));
        dest.put(destOffset + 2, Math.fma(_other00, _self02, _other01 * _self12));
        dest.put(destOffset + 3, Math.fma(_other00, _self03, _other01 * _self13));
        dest.put(destOffset + 4, Math.fma(_other10, _self00, _other11 * _self10));
        dest.put(destOffset + 5, Math.fma(_other10, _self01, _other11 * _self11));
        dest.put(destOffset + 6, Math.fma(_other10, _self02, _other11 * _self12));
        dest.put(destOffset + 7, Math.fma(_other10, _self03, _other11 * _self13));
        dest.put(destOffset + 8, _self20);
        dest.put(destOffset + 9, _self21);
        dest.put(destOffset + 10, _self22);
        dest.put(destOffset + 11, _self23);
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
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _other00 = other.get(otherOffset + 0);
        double _other10 = other.get(otherOffset + 1);
        double _other01 = other.get(otherOffset + 2);
        double _other11 = other.get(otherOffset + 3);
        double _other02 = other.get(otherOffset + 4);
        double _other12 = other.get(otherOffset + 5);
        dest.put(destOffset + 0, Math.fma(_other02, _self20, Math.fma(_other00, _self00, _other01 * _self10)));
        dest.put(destOffset + 1, Math.fma(_other02, _self21, Math.fma(_other00, _self01, _other01 * _self11)));
        dest.put(destOffset + 2, Math.fma(_other02, _self22, Math.fma(_other00, _self02, _other01 * _self12)));
        dest.put(destOffset + 3, Math.fma(_other02, _self23, Math.fma(_other00, _self03, _other01 * _self13)));
        dest.put(destOffset + 4, Math.fma(_other12, _self20, Math.fma(_other10, _self00, _other11 * _self10)));
        dest.put(destOffset + 5, Math.fma(_other12, _self21, Math.fma(_other10, _self01, _other11 * _self11)));
        dest.put(destOffset + 6, Math.fma(_other12, _self22, Math.fma(_other10, _self02, _other11 * _self12)));
        dest.put(destOffset + 7, Math.fma(_other12, _self23, Math.fma(_other10, _self03, _other11 * _self13)));
        dest.put(destOffset + 8, _self20);
        dest.put(destOffset + 9, _self21);
        dest.put(destOffset + 10, _self22);
        dest.put(destOffset + 11, _self23);
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
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _other00 = other.get(otherOffset + 0);
        double _other10 = other.get(otherOffset + 1);
        double _other20 = other.get(otherOffset + 2);
        double _other01 = other.get(otherOffset + 3);
        double _other11 = other.get(otherOffset + 4);
        double _other21 = other.get(otherOffset + 5);
        double _other02 = other.get(otherOffset + 6);
        double _other12 = other.get(otherOffset + 7);
        double _other22 = other.get(otherOffset + 8);
        dest.put(destOffset + 0, Math.fma(_other02, _self20, Math.fma(_other00, _self00, _other01 * _self10)));
        dest.put(destOffset + 1, Math.fma(_other02, _self21, Math.fma(_other00, _self01, _other01 * _self11)));
        dest.put(destOffset + 2, Math.fma(_other02, _self22, Math.fma(_other00, _self02, _other01 * _self12)));
        dest.put(destOffset + 3, Math.fma(_other02, _self23, Math.fma(_other00, _self03, _other01 * _self13)));
        dest.put(destOffset + 4, Math.fma(_other12, _self20, Math.fma(_other10, _self00, _other11 * _self10)));
        dest.put(destOffset + 5, Math.fma(_other12, _self21, Math.fma(_other10, _self01, _other11 * _self11)));
        dest.put(destOffset + 6, Math.fma(_other12, _self22, Math.fma(_other10, _self02, _other11 * _self12)));
        dest.put(destOffset + 7, Math.fma(_other12, _self23, Math.fma(_other10, _self03, _other11 * _self13)));
        dest.put(destOffset + 8, Math.fma(_other22, _self20, Math.fma(_other20, _self00, _other21 * _self10)));
        dest.put(destOffset + 9, Math.fma(_other22, _self21, Math.fma(_other20, _self01, _other21 * _self11)));
        dest.put(destOffset + 10, Math.fma(_other22, _self22, Math.fma(_other20, _self02, _other21 * _self12)));
        dest.put(destOffset + 11, Math.fma(_other22, _self23, Math.fma(_other20, _self03, _other21 * _self13)));
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
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _other00 = other.get(otherOffset + 0);
        double _other10 = other.get(otherOffset + 1);
        double _other20 = other.get(otherOffset + 2);
        double _other30 = other.get(otherOffset + 3);
        double _other01 = other.get(otherOffset + 4);
        double _other11 = other.get(otherOffset + 5);
        double _other21 = other.get(otherOffset + 6);
        double _other31 = other.get(otherOffset + 7);
        double _other02 = other.get(otherOffset + 8);
        double _other12 = other.get(otherOffset + 9);
        double _other22 = other.get(otherOffset + 10);
        double _other32 = other.get(otherOffset + 11);
        double _other03 = other.get(otherOffset + 12);
        double _other13 = other.get(otherOffset + 13);
        double _other23 = other.get(otherOffset + 14);
        double _other33 = other.get(otherOffset + 15);
        dest.put(destOffset + 0, Math.fma(_other02, _self20, Math.fma(_other00, _self00, _other01 * _self10)));
        dest.put(destOffset + 1, Math.fma(_other12, _self20, Math.fma(_other10, _self00, _other11 * _self10)));
        dest.put(destOffset + 2, Math.fma(_other22, _self20, Math.fma(_other20, _self00, _other21 * _self10)));
        dest.put(destOffset + 3, Math.fma(_other32, _self20, Math.fma(_other30, _self00, _other31 * _self10)));
        dest.put(destOffset + 4, Math.fma(_other02, _self21, Math.fma(_other00, _self01, _other01 * _self11)));
        dest.put(destOffset + 5, Math.fma(_other12, _self21, Math.fma(_other10, _self01, _other11 * _self11)));
        dest.put(destOffset + 6, Math.fma(_other22, _self21, Math.fma(_other20, _self01, _other21 * _self11)));
        dest.put(destOffset + 7, Math.fma(_other32, _self21, Math.fma(_other30, _self01, _other31 * _self11)));
        dest.put(destOffset + 8, Math.fma(_other02, _self22, Math.fma(_other00, _self02, _other01 * _self12)));
        dest.put(destOffset + 9, Math.fma(_other12, _self22, Math.fma(_other10, _self02, _other11 * _self12)));
        dest.put(destOffset + 10, Math.fma(_other22, _self22, Math.fma(_other20, _self02, _other21 * _self12)));
        dest.put(destOffset + 11, Math.fma(_other32, _self22, Math.fma(_other30, _self02, _other31 * _self12)));
        dest.put(destOffset + 12, Math.fma(_other00, _self03, Math.fma(_other01, _self13, Math.fma(_other02, _self23, _other03))));
        dest.put(destOffset + 13, Math.fma(_other10, _self03, Math.fma(_other11, _self13, Math.fma(_other12, _self23, _other13))));
        dest.put(destOffset + 14, Math.fma(_other20, _self03, Math.fma(_other21, _self13, Math.fma(_other22, _self23, _other23))));
        dest.put(destOffset + 15, Math.fma(_other30, _self03, Math.fma(_other31, _self13, Math.fma(_other32, _self23, _other33))));
        return dest;
    }

    public static java.nio.DoubleBuffer composeTRS_unsafe(java.nio.DoubleBuffer dest, int destOffset, double translationX, double translationY, double translationZ, double rotationX, double rotationY, double rotationZ, double rotationW, double scaleX, double scaleY, double scaleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.composeTRS_unsafe(_destBase, translationX, translationY, translationZ, rotationX, rotationY, rotationZ, rotationW, scaleX, scaleY, scaleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer composeTRS_api(java.nio.DoubleBuffer dest, int destOffset, double translationX, double translationY, double translationZ, double rotationX, double rotationY, double rotationZ, double rotationW, double scaleX, double scaleY, double scaleZ) {
        double _t0 = rotationZ * rotationZ;
        double _t1 = rotationZ * rotationW;
        double _t2 = rotationY * rotationW;
        dest.put(destOffset + 0, scaleX * Math.fma(-2.0, Math.fma(rotationY, rotationY, _t0), 1.0));
        dest.put(destOffset + 1, scaleY * 2.0 * Math.fma(rotationX, rotationY, -_t1));
        dest.put(destOffset + 2, scaleZ * 2.0 * Math.fma(rotationX, rotationZ, _t2));
        dest.put(destOffset + 3, translationX);
        dest.put(destOffset + 4, scaleX * 2.0 * Math.fma(rotationX, rotationY, _t1));
        dest.put(destOffset + 5, scaleY * Math.fma(-2.0, Math.fma(rotationX, rotationX, _t0), 1.0));
        dest.put(destOffset + 6, scaleZ * 2.0 * Math.fma(rotationY, rotationZ, -(rotationX * rotationW)));
        dest.put(destOffset + 7, translationY);
        dest.put(destOffset + 8, scaleX * 2.0 * Math.fma(rotationX, rotationZ, -_t2));
        dest.put(destOffset + 9, scaleY * 2.0 * Math.fma(rotationX, rotationW, rotationY * rotationZ));
        dest.put(destOffset + 10, scaleZ * Math.fma(-2.0, Math.fma(rotationX, rotationX, rotationY * rotationY), 1.0));
        dest.put(destOffset + 11, translationZ);
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
        double _translationx = translation.get(translationOffset + 0);
        double _translationy = translation.get(translationOffset + 1);
        double _translationz = translation.get(translationOffset + 2);
        double _rotationx = rotation.get(rotationOffset + 0);
        double _rotationy = rotation.get(rotationOffset + 1);
        double _rotationz = rotation.get(rotationOffset + 2);
        double _rotationw = rotation.get(rotationOffset + 3);
        double _scalex = scale.get(scaleOffset + 0);
        double _scaley = scale.get(scaleOffset + 1);
        double _scalez = scale.get(scaleOffset + 2);
        double _t0 = _rotationz * _rotationz;
        double _t1 = _rotationz * _rotationw;
        double _t2 = _rotationy * _rotationw;
        dest.put(destOffset + 0, _scalex * Math.fma(-2.0, Math.fma(_rotationy, _rotationy, _t0), 1.0));
        dest.put(destOffset + 1, _scaley * 2.0 * Math.fma(_rotationx, _rotationy, -_t1));
        dest.put(destOffset + 2, _scalez * 2.0 * Math.fma(_rotationx, _rotationz, _t2));
        dest.put(destOffset + 3, _translationx);
        dest.put(destOffset + 4, _scalex * 2.0 * Math.fma(_rotationx, _rotationy, _t1));
        dest.put(destOffset + 5, _scaley * Math.fma(-2.0, Math.fma(_rotationx, _rotationx, _t0), 1.0));
        dest.put(destOffset + 6, _scalez * 2.0 * Math.fma(_rotationy, _rotationz, -(_rotationx * _rotationw)));
        dest.put(destOffset + 7, _translationy);
        dest.put(destOffset + 8, _scalex * 2.0 * Math.fma(_rotationx, _rotationz, -_t2));
        dest.put(destOffset + 9, _scaley * 2.0 * Math.fma(_rotationx, _rotationw, _rotationy * _rotationz));
        dest.put(destOffset + 10, _scalez * Math.fma(-2.0, Math.fma(_rotationx, _rotationx, _rotationy * _rotationy), 1.0));
        dest.put(destOffset + 11, _translationz);
        return dest;
    }

    public static java.nio.DoubleBuffer composeTRSMul_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer m, int mOffset, double translationX, double translationY, double translationZ, double rotationX, double rotationY, double rotationZ, double rotationW, double scaleX, double scaleY, double scaleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _mBase = UnsafeOpsHolder.U.getLong(m, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) mOffset * 8L;
        Double3x4OpsKernelsAddress.composeTRSMul_unsafe(_destBase, _mBase, translationX, translationY, translationZ, rotationX, rotationY, rotationZ, rotationW, scaleX, scaleY, scaleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer composeTRSMul_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer m, int mOffset, double translationX, double translationY, double translationZ, double rotationX, double rotationY, double rotationZ, double rotationW, double scaleX, double scaleY, double scaleZ) {
        double _m00 = m.get(mOffset + 0);
        double _m01 = m.get(mOffset + 1);
        double _m02 = m.get(mOffset + 2);
        double _m03 = m.get(mOffset + 3);
        double _m10 = m.get(mOffset + 4);
        double _m11 = m.get(mOffset + 5);
        double _m12 = m.get(mOffset + 6);
        double _m13 = m.get(mOffset + 7);
        double _m20 = m.get(mOffset + 8);
        double _m21 = m.get(mOffset + 9);
        double _m22 = m.get(mOffset + 10);
        double _m23 = m.get(mOffset + 11);
        double _t0 = rotationY * rotationW;
        double _t1 = rotationZ * rotationZ;
        double _t2 = rotationZ * rotationW;
        double _t27 = scaleZ * 2.0 * Math.fma(rotationX, rotationZ, _t0);
        double _t28 = scaleX * 2.0 * Math.fma(rotationX, rotationY, _t2);
        double _t29 = scaleY * 2.0 * Math.fma(rotationX, rotationW, rotationY * rotationZ);
        double _t30 = scaleY * 2.0 * Math.fma(rotationX, rotationY, -_t2);
        double _t31 = scaleZ * 2.0 * Math.fma(rotationY, rotationZ, -(rotationX * rotationW));
        double _t32 = scaleX * 2.0 * Math.fma(rotationX, rotationZ, -_t0);
        double _t33 = scaleX * Math.fma(-2.0, Math.fma(rotationY, rotationY, _t1), 1.0);
        double _t34 = scaleY * Math.fma(-2.0, Math.fma(rotationX, rotationX, _t1), 1.0);
        double _t35 = scaleZ * Math.fma(-2.0, Math.fma(rotationX, rotationX, rotationY * rotationY), 1.0);
        dest.put(destOffset + 0, Math.fma(_m20, _t27, Math.fma(_m00, _t33, _m10 * _t30)));
        dest.put(destOffset + 1, Math.fma(_m21, _t27, Math.fma(_m01, _t33, _m11 * _t30)));
        dest.put(destOffset + 2, Math.fma(_m22, _t27, Math.fma(_m02, _t33, _m12 * _t30)));
        dest.put(destOffset + 3, Math.fma(_m03, _t33, Math.fma(_m13, _t30, Math.fma(_m23, _t27, translationX))));
        dest.put(destOffset + 4, Math.fma(_m20, _t31, Math.fma(_m00, _t28, _m10 * _t34)));
        dest.put(destOffset + 5, Math.fma(_m21, _t31, Math.fma(_m01, _t28, _m11 * _t34)));
        dest.put(destOffset + 6, Math.fma(_m22, _t31, Math.fma(_m02, _t28, _m12 * _t34)));
        dest.put(destOffset + 7, Math.fma(_m03, _t28, Math.fma(_m13, _t34, Math.fma(_m23, _t31, translationY))));
        dest.put(destOffset + 8, Math.fma(_m20, _t35, Math.fma(_m00, _t32, _m10 * _t29)));
        dest.put(destOffset + 9, Math.fma(_m21, _t35, Math.fma(_m01, _t32, _m11 * _t29)));
        dest.put(destOffset + 10, Math.fma(_m22, _t35, Math.fma(_m02, _t32, _m12 * _t29)));
        dest.put(destOffset + 11, Math.fma(_m03, _t32, Math.fma(_m13, _t29, Math.fma(_m23, _t35, translationZ))));
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
        double _translationx = translation.get(translationOffset + 0);
        double _translationy = translation.get(translationOffset + 1);
        double _translationz = translation.get(translationOffset + 2);
        double _rotationx = rotation.get(rotationOffset + 0);
        double _rotationy = rotation.get(rotationOffset + 1);
        double _rotationz = rotation.get(rotationOffset + 2);
        double _rotationw = rotation.get(rotationOffset + 3);
        double _scalex = scale.get(scaleOffset + 0);
        double _scaley = scale.get(scaleOffset + 1);
        double _scalez = scale.get(scaleOffset + 2);
        double _m00 = m.get(mOffset + 0);
        double _m01 = m.get(mOffset + 1);
        double _m02 = m.get(mOffset + 2);
        double _m03 = m.get(mOffset + 3);
        double _m10 = m.get(mOffset + 4);
        double _m11 = m.get(mOffset + 5);
        double _m12 = m.get(mOffset + 6);
        double _m13 = m.get(mOffset + 7);
        double _m20 = m.get(mOffset + 8);
        double _m21 = m.get(mOffset + 9);
        double _m22 = m.get(mOffset + 10);
        double _m23 = m.get(mOffset + 11);
        double _t0 = _rotationy * _rotationw;
        double _t1 = _rotationz * _rotationz;
        double _t2 = _rotationz * _rotationw;
        double _t27 = _scalez * 2.0 * Math.fma(_rotationx, _rotationz, _t0);
        double _t28 = _scalex * 2.0 * Math.fma(_rotationx, _rotationy, _t2);
        double _t29 = _scaley * 2.0 * Math.fma(_rotationx, _rotationw, _rotationy * _rotationz);
        double _t30 = _scaley * 2.0 * Math.fma(_rotationx, _rotationy, -_t2);
        double _t31 = _scalez * 2.0 * Math.fma(_rotationy, _rotationz, -(_rotationx * _rotationw));
        double _t32 = _scalex * 2.0 * Math.fma(_rotationx, _rotationz, -_t0);
        double _t33 = _scalex * Math.fma(-2.0, Math.fma(_rotationy, _rotationy, _t1), 1.0);
        double _t34 = _scaley * Math.fma(-2.0, Math.fma(_rotationx, _rotationx, _t1), 1.0);
        double _t35 = _scalez * Math.fma(-2.0, Math.fma(_rotationx, _rotationx, _rotationy * _rotationy), 1.0);
        dest.put(destOffset + 0, Math.fma(_m20, _t27, Math.fma(_m00, _t33, _m10 * _t30)));
        dest.put(destOffset + 1, Math.fma(_m21, _t27, Math.fma(_m01, _t33, _m11 * _t30)));
        dest.put(destOffset + 2, Math.fma(_m22, _t27, Math.fma(_m02, _t33, _m12 * _t30)));
        dest.put(destOffset + 3, Math.fma(_m03, _t33, Math.fma(_m13, _t30, Math.fma(_m23, _t27, _translationx))));
        dest.put(destOffset + 4, Math.fma(_m20, _t31, Math.fma(_m00, _t28, _m10 * _t34)));
        dest.put(destOffset + 5, Math.fma(_m21, _t31, Math.fma(_m01, _t28, _m11 * _t34)));
        dest.put(destOffset + 6, Math.fma(_m22, _t31, Math.fma(_m02, _t28, _m12 * _t34)));
        dest.put(destOffset + 7, Math.fma(_m03, _t28, Math.fma(_m13, _t34, Math.fma(_m23, _t31, _translationy))));
        dest.put(destOffset + 8, Math.fma(_m20, _t35, Math.fma(_m00, _t32, _m10 * _t29)));
        dest.put(destOffset + 9, Math.fma(_m21, _t35, Math.fma(_m01, _t32, _m11 * _t29)));
        dest.put(destOffset + 10, Math.fma(_m22, _t35, Math.fma(_m02, _t32, _m12 * _t29)));
        dest.put(destOffset + 11, Math.fma(_m03, _t32, Math.fma(_m13, _t29, Math.fma(_m23, _t35, _translationz))));
        return dest;
    }

    public static java.nio.DoubleBuffer lookAlong_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.lookAlong_unsafe(_destBase, _srcBase, dirX, dirY, dirZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.DoubleBuffer lookAlong_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7, _t8, _t9;
        if (_t2 > 0.0) {
            _t7 = dirY * _t3;
            _t8 = dirX * _t3;
            _t9 = dirZ * _t3;
        } else {
            _t7 = 0.0;
            _t8 = 0.0;
            _t9 = 0.0;
        }
        double _t16 = Math.fma(upX, _t7, -(upY * _t8));
        double _t17 = Math.fma(upY, _t9, -(upZ * _t7));
        double _t18 = Math.fma(upZ, _t8, -(upX * _t9));
        double _t21 = Math.fma(_t16, _t16, Math.fma(_t17, _t17, _t18 * _t18));
        double _t22 = (1.0 / Math.sqrt(_t21));
        double _t26, _t27, _t28;
        if (_t21 > 0.0) {
            _t26 = _t16 * _t22;
            _t27 = _t17 * _t22;
            _t28 = _t18 * _t22;
        } else {
            _t26 = 0.0;
            _t27 = 0.0;
            _t28 = 0.0;
        }
        double _t35 = Math.fma(_t8, _t28, -(_t7 * _t27));
        double _t36 = Math.fma(_t7, _t26, -(_t9 * _t28));
        double _t37 = Math.fma(_t9, _t27, -(_t8 * _t26));
        dest.put(destOffset + 0, Math.fma(_self02, _t26, Math.fma(_self00, _t27, _self01 * _t28)));
        dest.put(destOffset + 1, Math.fma(_self02, _t35, Math.fma(_self00, _t36, _self01 * _t37)));
        dest.put(destOffset + 2, Math.fma(_self02, _t9, Math.fma(_self00, _t8, _self01 * _t7)));
        dest.put(destOffset + 3, _self03);
        dest.put(destOffset + 4, Math.fma(_self12, _t26, Math.fma(_self10, _t27, _self11 * _t28)));
        dest.put(destOffset + 5, Math.fma(_self12, _t35, Math.fma(_self10, _t36, _self11 * _t37)));
        dest.put(destOffset + 6, Math.fma(_self12, _t9, Math.fma(_self10, _t8, _self11 * _t7)));
        dest.put(destOffset + 7, _self13);
        dest.put(destOffset + 8, Math.fma(_self22, _t26, Math.fma(_self20, _t27, _self21 * _t28)));
        dest.put(destOffset + 9, Math.fma(_self22, _t35, Math.fma(_self20, _t36, _self21 * _t37)));
        dest.put(destOffset + 10, Math.fma(_self22, _t9, Math.fma(_self20, _t8, _self21 * _t7)));
        dest.put(destOffset + 11, _self23);
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
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _dirx = dir.get(dirOffset + 0);
        double _diry = dir.get(dirOffset + 1);
        double _dirz = dir.get(dirOffset + 2);
        double _upx = up.get(upOffset + 0);
        double _upy = up.get(upOffset + 1);
        double _upz = up.get(upOffset + 2);
        double _t2 = Math.fma(_dirz, _dirz, Math.fma(_dirx, _dirx, _diry * _diry));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7, _t8, _t9;
        if (_t2 > 0.0) {
            _t7 = _diry * _t3;
            _t8 = _dirx * _t3;
            _t9 = _dirz * _t3;
        } else {
            _t7 = 0.0;
            _t8 = 0.0;
            _t9 = 0.0;
        }
        double _t16 = Math.fma(_upx, _t7, -(_upy * _t8));
        double _t17 = Math.fma(_upy, _t9, -(_upz * _t7));
        double _t18 = Math.fma(_upz, _t8, -(_upx * _t9));
        double _t21 = Math.fma(_t16, _t16, Math.fma(_t17, _t17, _t18 * _t18));
        double _t22 = (1.0 / Math.sqrt(_t21));
        double _t26, _t27, _t28;
        if (_t21 > 0.0) {
            _t26 = _t16 * _t22;
            _t27 = _t17 * _t22;
            _t28 = _t18 * _t22;
        } else {
            _t26 = 0.0;
            _t27 = 0.0;
            _t28 = 0.0;
        }
        double _t35 = Math.fma(_t8, _t28, -(_t7 * _t27));
        double _t36 = Math.fma(_t7, _t26, -(_t9 * _t28));
        double _t37 = Math.fma(_t9, _t27, -(_t8 * _t26));
        dest.put(destOffset + 0, Math.fma(_self02, _t26, Math.fma(_self00, _t27, _self01 * _t28)));
        dest.put(destOffset + 1, Math.fma(_self02, _t35, Math.fma(_self00, _t36, _self01 * _t37)));
        dest.put(destOffset + 2, Math.fma(_self02, _t9, Math.fma(_self00, _t8, _self01 * _t7)));
        dest.put(destOffset + 3, _self03);
        dest.put(destOffset + 4, Math.fma(_self12, _t26, Math.fma(_self10, _t27, _self11 * _t28)));
        dest.put(destOffset + 5, Math.fma(_self12, _t35, Math.fma(_self10, _t36, _self11 * _t37)));
        dest.put(destOffset + 6, Math.fma(_self12, _t9, Math.fma(_self10, _t8, _self11 * _t7)));
        dest.put(destOffset + 7, _self13);
        dest.put(destOffset + 8, Math.fma(_self22, _t26, Math.fma(_self20, _t27, _self21 * _t28)));
        dest.put(destOffset + 9, Math.fma(_self22, _t35, Math.fma(_self20, _t36, _self21 * _t37)));
        dest.put(destOffset + 10, Math.fma(_self22, _t9, Math.fma(_self20, _t8, _self21 * _t7)));
        dest.put(destOffset + 11, _self23);
        return dest;
    }

    public static java.nio.DoubleBuffer lookAt_lh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && dest.order() == java.nio.ByteOrder.nativeOrder() && src.isDirect() && src.order() == java.nio.ByteOrder.nativeOrder()) return Double3x4OpsKernelsTypedBuffer.lookAt_lh_unsafe(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return Double3x4OpsKernelsTypedBuffer.lookAt_lh_api(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
    }

    public static java.nio.DoubleBuffer lookAt_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.lookAt_lh_unsafe(_destBase, _srcBase, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.DoubleBuffer lookAt_lh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _t0 = centerZ - eyeZ;
        double _t1 = centerX - eyeX;
        double _t2 = centerY - eyeY;
        double _t5 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        double _t6 = (1.0 / Math.sqrt(_t5));
        double _t10, _t11, _t12;
        if (_t5 > 0.0) {
            _t10 = _t1 * _t6;
            _t11 = _t2 * _t6;
            _t12 = _t0 * _t6;
        } else {
            _t10 = 0.0;
            _t11 = 0.0;
            _t12 = 0.0;
        }
        double _t21 = Math.fma(upX, _t11, -(upY * _t10));
        double _t22 = Math.fma(upY, _t12, -(upZ * _t11));
        double _t23 = Math.fma(upZ, _t10, -(upX * _t12));
        double _t24 = Math.fma(eyeZ, _t12, Math.fma(eyeX, _t10, eyeY * _t11));
        double _t27 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        double _t28 = (1.0 / Math.sqrt(_t27));
        double _t32, _t33, _t34;
        if (_t27 > 0.0) {
            _t32 = _t22 * _t28;
            _t33 = _t21 * _t28;
            _t34 = _t23 * _t28;
        } else {
            _t32 = 0.0;
            _t33 = 0.0;
            _t34 = 0.0;
        }
        double _t43 = Math.fma(_t11, _t33, -(_t12 * _t34));
        double _t44 = Math.fma(_t12, _t32, -(_t10 * _t33));
        double _t45 = Math.fma(_t10, _t34, -(_t11 * _t32));
        double _t47 = Math.fma(eyeZ, _t33, Math.fma(eyeX, _t32, eyeY * _t34));
        double _t49 = Math.fma(eyeZ, _t45, Math.fma(eyeX, _t43, eyeY * _t44));
        dest.put(destOffset + 0, Math.fma(_self02, _t10, Math.fma(_self00, _t32, _self01 * _t43)));
        dest.put(destOffset + 1, Math.fma(_self02, _t11, Math.fma(_self00, _t34, _self01 * _t44)));
        dest.put(destOffset + 2, Math.fma(_self02, _t12, Math.fma(_self00, _t33, _self01 * _t45)));
        dest.put(destOffset + 3, Math.fma(-_self00, _t47, Math.fma(-_self01, _t49, Math.fma(-_self02, _t24, _self03))));
        dest.put(destOffset + 4, Math.fma(_self12, _t10, Math.fma(_self10, _t32, _self11 * _t43)));
        dest.put(destOffset + 5, Math.fma(_self12, _t11, Math.fma(_self10, _t34, _self11 * _t44)));
        dest.put(destOffset + 6, Math.fma(_self12, _t12, Math.fma(_self10, _t33, _self11 * _t45)));
        dest.put(destOffset + 7, Math.fma(-_self10, _t47, Math.fma(-_self11, _t49, Math.fma(-_self12, _t24, _self13))));
        dest.put(destOffset + 8, Math.fma(_self22, _t10, Math.fma(_self20, _t32, _self21 * _t43)));
        dest.put(destOffset + 9, Math.fma(_self22, _t11, Math.fma(_self20, _t34, _self21 * _t44)));
        dest.put(destOffset + 10, Math.fma(_self22, _t12, Math.fma(_self20, _t33, _self21 * _t45)));
        dest.put(destOffset + 11, Math.fma(-_self20, _t47, Math.fma(-_self21, _t49, Math.fma(-_self22, _t24, _self23))));
        return dest;
    }

    public static java.nio.DoubleBuffer lookAt_rh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && dest.order() == java.nio.ByteOrder.nativeOrder() && src.isDirect() && src.order() == java.nio.ByteOrder.nativeOrder()) return Double3x4OpsKernelsTypedBuffer.lookAt_rh_unsafe(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return Double3x4OpsKernelsTypedBuffer.lookAt_rh_api(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
    }

    public static java.nio.DoubleBuffer lookAt_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.lookAt_rh_unsafe(_destBase, _srcBase, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.DoubleBuffer lookAt_rh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _t0 = -_self02;
        double _t1 = -_self12;
        double _t2 = -_self22;
        double _t3 = centerZ - eyeZ;
        double _t4 = centerX - eyeX;
        double _t5 = centerY - eyeY;
        double _t8 = Math.fma(_t3, _t3, Math.fma(_t4, _t4, _t5 * _t5));
        double _t9 = (1.0 / Math.sqrt(_t8));
        double _t13, _t14, _t15;
        if (_t8 > 0.0) {
            _t13 = _t4 * _t9;
            _t14 = _t5 * _t9;
            _t15 = _t3 * _t9;
        } else {
            _t13 = 0.0;
            _t14 = 0.0;
            _t15 = 0.0;
        }
        double _t24 = Math.fma(upY, _t13, -(upX * _t14));
        double _t25 = Math.fma(upX, _t15, -(upZ * _t13));
        double _t26 = Math.fma(upZ, _t14, -(upY * _t15));
        double _t27 = Math.fma(eyeZ, _t15, Math.fma(eyeX, _t13, eyeY * _t14));
        double _t30 = Math.fma(_t24, _t24, Math.fma(_t25, _t25, _t26 * _t26));
        double _t31 = (1.0 / Math.sqrt(_t30));
        double _t35, _t36, _t37;
        if (_t30 > 0.0) {
            _t35 = _t26 * _t31;
            _t36 = _t25 * _t31;
            _t37 = _t24 * _t31;
        } else {
            _t35 = 0.0;
            _t36 = 0.0;
            _t37 = 0.0;
        }
        double _t46 = Math.fma(_t15, _t36, -(_t14 * _t37));
        double _t47 = Math.fma(_t13, _t37, -(_t15 * _t35));
        double _t48 = Math.fma(_t14, _t35, -(_t13 * _t36));
        double _t50 = Math.fma(eyeZ, _t37, Math.fma(eyeX, _t35, eyeY * _t36));
        double _t52 = Math.fma(eyeZ, _t48, Math.fma(eyeX, _t46, eyeY * _t47));
        dest.put(destOffset + 0, Math.fma(_t0, _t13, Math.fma(_self00, _t35, _self01 * _t46)));
        dest.put(destOffset + 1, Math.fma(_t0, _t14, Math.fma(_self00, _t36, _self01 * _t47)));
        dest.put(destOffset + 2, Math.fma(_t0, _t15, Math.fma(_self00, _t37, _self01 * _t48)));
        dest.put(destOffset + 3, Math.fma(-_self00, _t50, Math.fma(-_self01, _t52, Math.fma(_self02, _t27, _self03))));
        dest.put(destOffset + 4, Math.fma(_t1, _t13, Math.fma(_self10, _t35, _self11 * _t46)));
        dest.put(destOffset + 5, Math.fma(_t1, _t14, Math.fma(_self10, _t36, _self11 * _t47)));
        dest.put(destOffset + 6, Math.fma(_t1, _t15, Math.fma(_self10, _t37, _self11 * _t48)));
        dest.put(destOffset + 7, Math.fma(-_self10, _t50, Math.fma(-_self11, _t52, Math.fma(_self12, _t27, _self13))));
        dest.put(destOffset + 8, Math.fma(_t2, _t13, Math.fma(_self20, _t35, _self21 * _t46)));
        dest.put(destOffset + 9, Math.fma(_t2, _t14, Math.fma(_self20, _t36, _self21 * _t47)));
        dest.put(destOffset + 10, Math.fma(_t2, _t15, Math.fma(_self20, _t37, _self21 * _t48)));
        dest.put(destOffset + 11, Math.fma(-_self20, _t50, Math.fma(-_self21, _t52, Math.fma(_self22, _t27, _self23))));
        return dest;
    }

    public static java.nio.DoubleBuffer lookAt_lh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer center, int centerOffset, java.nio.DoubleBuffer up, int upOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && dest.order() == java.nio.ByteOrder.nativeOrder() && src.isDirect() && src.order() == java.nio.ByteOrder.nativeOrder() && eye.isDirect() && eye.order() == java.nio.ByteOrder.nativeOrder() && center.isDirect() && center.order() == java.nio.ByteOrder.nativeOrder() && up.isDirect() && up.order() == java.nio.ByteOrder.nativeOrder()) return Double3x4OpsKernelsTypedBuffer.lookAt_lh_unsafe(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
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
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _eyex = eye.get(eyeOffset + 0);
        double _eyey = eye.get(eyeOffset + 1);
        double _eyez = eye.get(eyeOffset + 2);
        double _centerx = center.get(centerOffset + 0);
        double _centery = center.get(centerOffset + 1);
        double _centerz = center.get(centerOffset + 2);
        double _upx = up.get(upOffset + 0);
        double _upy = up.get(upOffset + 1);
        double _upz = up.get(upOffset + 2);
        double _t0 = _centerz - _eyez;
        double _t1 = _centerx - _eyex;
        double _t2 = _centery - _eyey;
        double _t5 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        double _t6 = (1.0 / Math.sqrt(_t5));
        double _t10, _t11, _t12;
        if (_t5 > 0.0) {
            _t10 = _t1 * _t6;
            _t11 = _t2 * _t6;
            _t12 = _t0 * _t6;
        } else {
            _t10 = 0.0;
            _t11 = 0.0;
            _t12 = 0.0;
        }
        double _t21 = Math.fma(_upx, _t11, -(_upy * _t10));
        double _t22 = Math.fma(_upy, _t12, -(_upz * _t11));
        double _t23 = Math.fma(_upz, _t10, -(_upx * _t12));
        double _t24 = Math.fma(_eyez, _t12, Math.fma(_eyex, _t10, _eyey * _t11));
        double _t27 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        double _t28 = (1.0 / Math.sqrt(_t27));
        double _t32, _t33, _t34;
        if (_t27 > 0.0) {
            _t32 = _t22 * _t28;
            _t33 = _t21 * _t28;
            _t34 = _t23 * _t28;
        } else {
            _t32 = 0.0;
            _t33 = 0.0;
            _t34 = 0.0;
        }
        double _t43 = Math.fma(_t11, _t33, -(_t12 * _t34));
        double _t44 = Math.fma(_t12, _t32, -(_t10 * _t33));
        double _t45 = Math.fma(_t10, _t34, -(_t11 * _t32));
        double _t47 = Math.fma(_eyez, _t33, Math.fma(_eyex, _t32, _eyey * _t34));
        double _t49 = Math.fma(_eyez, _t45, Math.fma(_eyex, _t43, _eyey * _t44));
        dest.put(destOffset + 0, Math.fma(_self02, _t10, Math.fma(_self00, _t32, _self01 * _t43)));
        dest.put(destOffset + 1, Math.fma(_self02, _t11, Math.fma(_self00, _t34, _self01 * _t44)));
        dest.put(destOffset + 2, Math.fma(_self02, _t12, Math.fma(_self00, _t33, _self01 * _t45)));
        dest.put(destOffset + 3, Math.fma(-_self00, _t47, Math.fma(-_self01, _t49, Math.fma(-_self02, _t24, _self03))));
        dest.put(destOffset + 4, Math.fma(_self12, _t10, Math.fma(_self10, _t32, _self11 * _t43)));
        dest.put(destOffset + 5, Math.fma(_self12, _t11, Math.fma(_self10, _t34, _self11 * _t44)));
        dest.put(destOffset + 6, Math.fma(_self12, _t12, Math.fma(_self10, _t33, _self11 * _t45)));
        dest.put(destOffset + 7, Math.fma(-_self10, _t47, Math.fma(-_self11, _t49, Math.fma(-_self12, _t24, _self13))));
        dest.put(destOffset + 8, Math.fma(_self22, _t10, Math.fma(_self20, _t32, _self21 * _t43)));
        dest.put(destOffset + 9, Math.fma(_self22, _t11, Math.fma(_self20, _t34, _self21 * _t44)));
        dest.put(destOffset + 10, Math.fma(_self22, _t12, Math.fma(_self20, _t33, _self21 * _t45)));
        dest.put(destOffset + 11, Math.fma(-_self20, _t47, Math.fma(-_self21, _t49, Math.fma(-_self22, _t24, _self23))));
        return dest;
    }

    public static java.nio.DoubleBuffer lookAt_rh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer center, int centerOffset, java.nio.DoubleBuffer up, int upOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && dest.order() == java.nio.ByteOrder.nativeOrder() && src.isDirect() && src.order() == java.nio.ByteOrder.nativeOrder() && eye.isDirect() && eye.order() == java.nio.ByteOrder.nativeOrder() && center.isDirect() && center.order() == java.nio.ByteOrder.nativeOrder() && up.isDirect() && up.order() == java.nio.ByteOrder.nativeOrder()) return Double3x4OpsKernelsTypedBuffer.lookAt_rh_unsafe(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
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
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _eyex = eye.get(eyeOffset + 0);
        double _eyey = eye.get(eyeOffset + 1);
        double _eyez = eye.get(eyeOffset + 2);
        double _centerx = center.get(centerOffset + 0);
        double _centery = center.get(centerOffset + 1);
        double _centerz = center.get(centerOffset + 2);
        double _upx = up.get(upOffset + 0);
        double _upy = up.get(upOffset + 1);
        double _upz = up.get(upOffset + 2);
        double _t0 = -_self02;
        double _t1 = -_self12;
        double _t2 = -_self22;
        double _t3 = _centerz - _eyez;
        double _t4 = _centerx - _eyex;
        double _t5 = _centery - _eyey;
        double _t8 = Math.fma(_t3, _t3, Math.fma(_t4, _t4, _t5 * _t5));
        double _t9 = (1.0 / Math.sqrt(_t8));
        double _t13, _t14, _t15;
        if (_t8 > 0.0) {
            _t13 = _t4 * _t9;
            _t14 = _t5 * _t9;
            _t15 = _t3 * _t9;
        } else {
            _t13 = 0.0;
            _t14 = 0.0;
            _t15 = 0.0;
        }
        double _t24 = Math.fma(_upy, _t13, -(_upx * _t14));
        double _t25 = Math.fma(_upx, _t15, -(_upz * _t13));
        double _t26 = Math.fma(_upz, _t14, -(_upy * _t15));
        double _t27 = Math.fma(_eyez, _t15, Math.fma(_eyex, _t13, _eyey * _t14));
        double _t30 = Math.fma(_t24, _t24, Math.fma(_t25, _t25, _t26 * _t26));
        double _t31 = (1.0 / Math.sqrt(_t30));
        double _t35, _t36, _t37;
        if (_t30 > 0.0) {
            _t35 = _t26 * _t31;
            _t36 = _t25 * _t31;
            _t37 = _t24 * _t31;
        } else {
            _t35 = 0.0;
            _t36 = 0.0;
            _t37 = 0.0;
        }
        double _t46 = Math.fma(_t15, _t36, -(_t14 * _t37));
        double _t47 = Math.fma(_t13, _t37, -(_t15 * _t35));
        double _t48 = Math.fma(_t14, _t35, -(_t13 * _t36));
        double _t50 = Math.fma(_eyez, _t37, Math.fma(_eyex, _t35, _eyey * _t36));
        double _t52 = Math.fma(_eyez, _t48, Math.fma(_eyex, _t46, _eyey * _t47));
        dest.put(destOffset + 0, Math.fma(_t0, _t13, Math.fma(_self00, _t35, _self01 * _t46)));
        dest.put(destOffset + 1, Math.fma(_t0, _t14, Math.fma(_self00, _t36, _self01 * _t47)));
        dest.put(destOffset + 2, Math.fma(_t0, _t15, Math.fma(_self00, _t37, _self01 * _t48)));
        dest.put(destOffset + 3, Math.fma(-_self00, _t50, Math.fma(-_self01, _t52, Math.fma(_self02, _t27, _self03))));
        dest.put(destOffset + 4, Math.fma(_t1, _t13, Math.fma(_self10, _t35, _self11 * _t46)));
        dest.put(destOffset + 5, Math.fma(_t1, _t14, Math.fma(_self10, _t36, _self11 * _t47)));
        dest.put(destOffset + 6, Math.fma(_t1, _t15, Math.fma(_self10, _t37, _self11 * _t48)));
        dest.put(destOffset + 7, Math.fma(-_self10, _t50, Math.fma(-_self11, _t52, Math.fma(_self12, _t27, _self13))));
        dest.put(destOffset + 8, Math.fma(_t2, _t13, Math.fma(_self20, _t35, _self21 * _t46)));
        dest.put(destOffset + 9, Math.fma(_t2, _t14, Math.fma(_self20, _t36, _self21 * _t47)));
        dest.put(destOffset + 10, Math.fma(_t2, _t15, Math.fma(_self20, _t37, _self21 * _t48)));
        dest.put(destOffset + 11, Math.fma(-_self20, _t50, Math.fma(-_self21, _t52, Math.fma(_self22, _t27, _self23))));
        return dest;
    }

    public static java.nio.DoubleBuffer makeBillboardCylindrical_unsafe(java.nio.DoubleBuffer dest, int destOffset, double objPosX, double objPosY, double objPosZ, double targetPosX, double targetPosY, double targetPosZ, double upX, double upY, double upZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeBillboardCylindrical_unsafe(_destBase, objPosX, objPosY, objPosZ, targetPosX, targetPosY, targetPosZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeBillboardCylindrical_api(java.nio.DoubleBuffer dest, int destOffset, double objPosX, double objPosY, double objPosZ, double targetPosX, double targetPosY, double targetPosZ, double upX, double upY, double upZ) {
        double _t0 = targetPosY - objPosY;
        double _t1 = targetPosX - objPosX;
        double _t2 = targetPosZ - objPosZ;
        double _t9 = Math.fma(upX, _t0, -(upY * _t1));
        double _t10 = Math.fma(upY, _t2, -(upZ * _t0));
        double _t11 = Math.fma(upZ, _t1, -(upX * _t2));
        double _t14 = Math.fma(_t9, _t9, Math.fma(_t10, _t10, _t11 * _t11));
        double _t15 = (1.0 / Math.sqrt(_t14));
        double _t19, _t20, _t21;
        if (_t14 > 0.0) {
            _t19 = _t10 * _t15;
            _t20 = _t11 * _t15;
            _t21 = _t9 * _t15;
        } else {
            _t19 = 0.0;
            _t20 = 0.0;
            _t21 = 0.0;
        }
        double _t28 = Math.fma(upY, _t19, -(upX * _t20));
        double _t29 = Math.fma(upX, _t21, -(upZ * _t19));
        double _t30 = Math.fma(upZ, _t20, -(upY * _t21));
        double _t33 = Math.fma(_t28, _t28, Math.fma(_t29, _t29, _t30 * _t30));
        double _t34 = (1.0 / Math.sqrt(_t33));
        if (_t33 > 0.0) {
            dest.put(destOffset + 2, _t30 * _t34);
            dest.put(destOffset + 6, _t29 * _t34);
            dest.put(destOffset + 10, _t28 * _t34);
        } else {
            dest.put(destOffset + 2, 0.0);
            dest.put(destOffset + 6, 0.0);
            dest.put(destOffset + 10, 0.0);
        }
        dest.put(destOffset + 0, _t19);
        dest.put(destOffset + 1, upX);
        dest.put(destOffset + 3, objPosX);
        dest.put(destOffset + 4, _t20);
        dest.put(destOffset + 5, upY);
        dest.put(destOffset + 7, objPosY);
        dest.put(destOffset + 8, _t21);
        dest.put(destOffset + 9, upZ);
        dest.put(destOffset + 11, objPosZ);
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
        double _objPosx = objPos.get(objPosOffset + 0);
        double _objPosy = objPos.get(objPosOffset + 1);
        double _objPosz = objPos.get(objPosOffset + 2);
        double _targetPosx = targetPos.get(targetPosOffset + 0);
        double _targetPosy = targetPos.get(targetPosOffset + 1);
        double _targetPosz = targetPos.get(targetPosOffset + 2);
        double _upx = up.get(upOffset + 0);
        double _upy = up.get(upOffset + 1);
        double _upz = up.get(upOffset + 2);
        double _t0 = _targetPosy - _objPosy;
        double _t1 = _targetPosx - _objPosx;
        double _t2 = _targetPosz - _objPosz;
        double _t9 = Math.fma(_upx, _t0, -(_upy * _t1));
        double _t10 = Math.fma(_upy, _t2, -(_upz * _t0));
        double _t11 = Math.fma(_upz, _t1, -(_upx * _t2));
        double _t14 = Math.fma(_t9, _t9, Math.fma(_t10, _t10, _t11 * _t11));
        double _t15 = (1.0 / Math.sqrt(_t14));
        double _t19, _t20, _t21;
        if (_t14 > 0.0) {
            _t19 = _t10 * _t15;
            _t20 = _t11 * _t15;
            _t21 = _t9 * _t15;
        } else {
            _t19 = 0.0;
            _t20 = 0.0;
            _t21 = 0.0;
        }
        double _t28 = Math.fma(_upy, _t19, -(_upx * _t20));
        double _t29 = Math.fma(_upx, _t21, -(_upz * _t19));
        double _t30 = Math.fma(_upz, _t20, -(_upy * _t21));
        double _t33 = Math.fma(_t28, _t28, Math.fma(_t29, _t29, _t30 * _t30));
        double _t34 = (1.0 / Math.sqrt(_t33));
        if (_t33 > 0.0) {
            dest.put(destOffset + 2, _t30 * _t34);
            dest.put(destOffset + 6, _t29 * _t34);
            dest.put(destOffset + 10, _t28 * _t34);
        } else {
            dest.put(destOffset + 2, 0.0);
            dest.put(destOffset + 6, 0.0);
            dest.put(destOffset + 10, 0.0);
        }
        dest.put(destOffset + 0, _t19);
        dest.put(destOffset + 1, _upx);
        dest.put(destOffset + 3, _objPosx);
        dest.put(destOffset + 4, _t20);
        dest.put(destOffset + 5, _upy);
        dest.put(destOffset + 7, _objPosy);
        dest.put(destOffset + 8, _t21);
        dest.put(destOffset + 9, _upz);
        dest.put(destOffset + 11, _objPosz);
        return dest;
    }

    public static java.nio.DoubleBuffer makeBillboardSpherical_unsafe(java.nio.DoubleBuffer dest, int destOffset, double objPosX, double objPosY, double objPosZ, double targetPosX, double targetPosY, double targetPosZ, double upX, double upY, double upZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeBillboardSpherical_unsafe(_destBase, objPosX, objPosY, objPosZ, targetPosX, targetPosY, targetPosZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeBillboardSpherical_api(java.nio.DoubleBuffer dest, int destOffset, double objPosX, double objPosY, double objPosZ, double targetPosX, double targetPosY, double targetPosZ, double upX, double upY, double upZ) {
        double _t0 = targetPosZ - objPosZ;
        double _t1 = targetPosX - objPosX;
        double _t2 = targetPosY - objPosY;
        double _t5 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        double _t6 = (1.0 / Math.sqrt(_t5));
        double _t10, _t11, _t12;
        if (_t5 > 0.0) {
            _t10 = _t2 * _t6;
            _t11 = _t1 * _t6;
            _t12 = _t0 * _t6;
        } else {
            _t10 = 0.0;
            _t11 = 0.0;
            _t12 = 0.0;
        }
        double _t19 = Math.fma(upX, _t10, -(upY * _t11));
        double _t20 = Math.fma(upY, _t12, -(upZ * _t10));
        double _t21 = Math.fma(upZ, _t11, -(upX * _t12));
        double _t24 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        double _t25 = (1.0 / Math.sqrt(_t24));
        double _t29, _t30, _t31;
        if (_t24 > 0.0) {
            _t29 = _t20 * _t25;
            _t30 = _t19 * _t25;
            _t31 = _t21 * _t25;
        } else {
            _t29 = 0.0;
            _t30 = 0.0;
            _t31 = 0.0;
        }
        dest.put(destOffset + 0, _t29);
        dest.put(destOffset + 1, Math.fma(_t10, _t30, -(_t12 * _t31)));
        dest.put(destOffset + 2, _t11);
        dest.put(destOffset + 3, objPosX);
        dest.put(destOffset + 4, _t31);
        dest.put(destOffset + 5, Math.fma(_t12, _t29, -(_t11 * _t30)));
        dest.put(destOffset + 6, _t10);
        dest.put(destOffset + 7, objPosY);
        dest.put(destOffset + 8, _t30);
        dest.put(destOffset + 9, Math.fma(_t11, _t31, -(_t10 * _t29)));
        dest.put(destOffset + 10, _t12);
        dest.put(destOffset + 11, objPosZ);
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
        double _objPosx = objPos.get(objPosOffset + 0);
        double _objPosy = objPos.get(objPosOffset + 1);
        double _objPosz = objPos.get(objPosOffset + 2);
        double _targetPosx = targetPos.get(targetPosOffset + 0);
        double _targetPosy = targetPos.get(targetPosOffset + 1);
        double _targetPosz = targetPos.get(targetPosOffset + 2);
        double _upx = up.get(upOffset + 0);
        double _upy = up.get(upOffset + 1);
        double _upz = up.get(upOffset + 2);
        double _t0 = _targetPosz - _objPosz;
        double _t1 = _targetPosx - _objPosx;
        double _t2 = _targetPosy - _objPosy;
        double _t5 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        double _t6 = (1.0 / Math.sqrt(_t5));
        double _t10, _t11, _t12;
        if (_t5 > 0.0) {
            _t10 = _t2 * _t6;
            _t11 = _t1 * _t6;
            _t12 = _t0 * _t6;
        } else {
            _t10 = 0.0;
            _t11 = 0.0;
            _t12 = 0.0;
        }
        double _t19 = Math.fma(_upx, _t10, -(_upy * _t11));
        double _t20 = Math.fma(_upy, _t12, -(_upz * _t10));
        double _t21 = Math.fma(_upz, _t11, -(_upx * _t12));
        double _t24 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        double _t25 = (1.0 / Math.sqrt(_t24));
        double _t29, _t30, _t31;
        if (_t24 > 0.0) {
            _t29 = _t20 * _t25;
            _t30 = _t19 * _t25;
            _t31 = _t21 * _t25;
        } else {
            _t29 = 0.0;
            _t30 = 0.0;
            _t31 = 0.0;
        }
        dest.put(destOffset + 0, _t29);
        dest.put(destOffset + 1, Math.fma(_t10, _t30, -(_t12 * _t31)));
        dest.put(destOffset + 2, _t11);
        dest.put(destOffset + 3, _objPosx);
        dest.put(destOffset + 4, _t31);
        dest.put(destOffset + 5, Math.fma(_t12, _t29, -(_t11 * _t30)));
        dest.put(destOffset + 6, _t10);
        dest.put(destOffset + 7, _objPosy);
        dest.put(destOffset + 8, _t30);
        dest.put(destOffset + 9, Math.fma(_t11, _t31, -(_t10 * _t29)));
        dest.put(destOffset + 10, _t12);
        dest.put(destOffset + 11, _objPosz);
        return dest;
    }

    public static java.nio.DoubleBuffer makeBillboardSphericalShortest_unsafe(java.nio.DoubleBuffer dest, int destOffset, double objPosX, double objPosY, double objPosZ, double targetPosX, double targetPosY, double targetPosZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeBillboardSphericalShortest_unsafe(_destBase, objPosX, objPosY, objPosZ, targetPosX, targetPosY, targetPosZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeBillboardSphericalShortest_api(java.nio.DoubleBuffer dest, int destOffset, double objPosX, double objPosY, double objPosZ, double targetPosX, double targetPosY, double targetPosZ) {
        double _t0 = targetPosX - objPosX;
        double _t1 = targetPosZ - objPosZ;
        double _t2 = targetPosY - objPosY;
        double _t3 = objPosY - targetPosY;
        double _t10 = _t1 + Math.sqrt(Math.fma(_t1, _t1, Math.fma(_t0, _t0, _t2 * _t2)));
        double _t12 = (1.0 / Math.sqrt(Math.fma(_t10, _t10, Math.fma(_t3, _t3, _t0 * _t0))));
        double _t13 = _t0 * _t12;
        double _t14 = _t3 * _t12;
        double _t15 = 2.0 * _t13;
        double _t16 = 2.0 * _t14;
        double _t17 = -_t15;
        double _t19 = _t10 * _t12;
        double _t20 = _t16 * _t13;
        double _t21 = Math.fma(-_t16, _t14, 1.0);
        double _t22 = _t15 * _t19;
        double _t23 = _t16 * _t19;
        dest.put(destOffset + 0, Math.fma(_t17, _t13, 1.0));
        dest.put(destOffset + 1, _t20);
        dest.put(destOffset + 2, _t22);
        dest.put(destOffset + 3, objPosX);
        dest.put(destOffset + 4, _t20);
        dest.put(destOffset + 5, _t21);
        dest.put(destOffset + 6, -_t23);
        dest.put(destOffset + 7, objPosY);
        dest.put(destOffset + 8, -_t22);
        dest.put(destOffset + 9, _t23);
        dest.put(destOffset + 10, Math.fma(_t17, _t13, _t21));
        dest.put(destOffset + 11, objPosZ);
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
        double _objPosx = objPos.get(objPosOffset + 0);
        double _objPosy = objPos.get(objPosOffset + 1);
        double _objPosz = objPos.get(objPosOffset + 2);
        double _targetPosx = targetPos.get(targetPosOffset + 0);
        double _targetPosy = targetPos.get(targetPosOffset + 1);
        double _targetPosz = targetPos.get(targetPosOffset + 2);
        double _t0 = _targetPosx - _objPosx;
        double _t1 = _targetPosz - _objPosz;
        double _t2 = _targetPosy - _objPosy;
        double _t3 = _objPosy - _targetPosy;
        double _t10 = _t1 + Math.sqrt(Math.fma(_t1, _t1, Math.fma(_t0, _t0, _t2 * _t2)));
        double _t12 = (1.0 / Math.sqrt(Math.fma(_t10, _t10, Math.fma(_t3, _t3, _t0 * _t0))));
        double _t13 = _t0 * _t12;
        double _t14 = _t3 * _t12;
        double _t15 = 2.0 * _t13;
        double _t16 = 2.0 * _t14;
        double _t17 = -_t15;
        double _t19 = _t10 * _t12;
        double _t20 = _t16 * _t13;
        double _t21 = Math.fma(-_t16, _t14, 1.0);
        double _t22 = _t15 * _t19;
        double _t23 = _t16 * _t19;
        dest.put(destOffset + 0, Math.fma(_t17, _t13, 1.0));
        dest.put(destOffset + 1, _t20);
        dest.put(destOffset + 2, _t22);
        dest.put(destOffset + 3, _objPosx);
        dest.put(destOffset + 4, _t20);
        dest.put(destOffset + 5, _t21);
        dest.put(destOffset + 6, -_t23);
        dest.put(destOffset + 7, _objPosy);
        dest.put(destOffset + 8, -_t22);
        dest.put(destOffset + 9, _t23);
        dest.put(destOffset + 10, Math.fma(_t17, _t13, _t21));
        dest.put(destOffset + 11, _objPosz);
        return dest;
    }

    public static java.nio.DoubleBuffer makeFromDualQuat_unsafe(java.nio.DoubleBuffer dest, int destOffset, double dqRX, double dqRY, double dqRZ, double dqRW, double dqDX, double dqDY, double dqDZ, double dqDW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeFromDualQuat_unsafe(_destBase, dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW);
        return dest;
    }

    public static java.nio.DoubleBuffer makeFromDualQuat_api(java.nio.DoubleBuffer dest, int destOffset, double dqRX, double dqRY, double dqRZ, double dqRW, double dqDX, double dqDY, double dqDZ, double dqDW) {
        double _t0 = dqRY * dqRY;
        double _t2 = dqRZ * dqRW;
        double _t3 = dqRY * dqRW;
        double _t4 = dqRX * dqRX;
        double _t5 = dqRY * dqRZ;
        double _t6 = Math.fma(-2.0, dqRZ * dqRZ, 1.0);
        dest.put(destOffset + 0, Math.fma(-2.0, _t0, _t6));
        dest.put(destOffset + 1, Math.fma(-2.0, _t2, 2.0 * dqRX * dqRY));
        dest.put(destOffset + 2, 2.0 * Math.fma(dqRX, dqRZ, _t3));
        dest.put(destOffset + 3, 2.0 * (Math.fma(dqRY, dqDZ, -(dqRZ * dqDY)) + Math.fma(dqRW, dqDX, -(dqRX * dqDW))));
        dest.put(destOffset + 4, 2.0 * Math.fma(dqRX, dqRY, _t2));
        dest.put(destOffset + 5, Math.fma(-2.0, _t4, _t6));
        dest.put(destOffset + 6, Math.fma(-2.0, dqRX * dqRW, 2.0 * _t5));
        dest.put(destOffset + 7, 2.0 * (Math.fma(dqRZ, dqDX, -(dqRX * dqDZ)) + Math.fma(dqRW, dqDY, -(dqRY * dqDW))));
        dest.put(destOffset + 8, Math.fma(-2.0, _t3, 2.0 * dqRX * dqRZ));
        dest.put(destOffset + 9, 2.0 * Math.fma(dqRX, dqRW, _t5));
        dest.put(destOffset + 10, Math.fma(-2.0, _t4, Math.fma(-2.0, _t0, 1.0)));
        dest.put(destOffset + 11, 2.0 * (Math.fma(dqRX, dqDY, -(dqRY * dqDX)) + Math.fma(dqRW, dqDZ, -(dqRZ * dqDW))));
        return dest;
    }

    public static java.nio.DoubleBuffer makeLookAt_lh(java.nio.DoubleBuffer dest, int destOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && dest.order() == java.nio.ByteOrder.nativeOrder()) return Double3x4OpsKernelsTypedBuffer.makeLookAt_lh_unsafe(dest, destOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return Double3x4OpsKernelsTypedBuffer.makeLookAt_lh_api(dest, destOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
    }

    public static java.nio.DoubleBuffer makeLookAt_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeLookAt_lh_unsafe(_destBase, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeLookAt_lh_api(java.nio.DoubleBuffer dest, int destOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        double _t0 = centerZ - eyeZ;
        double _t1 = centerX - eyeX;
        double _t2 = centerY - eyeY;
        double _t5 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        double _t6 = (1.0 / Math.sqrt(_t5));
        double _t10, _t11, _t12;
        if (_t5 > 0.0) {
            _t10 = _t2 * _t6;
            _t11 = _t1 * _t6;
            _t12 = _t0 * _t6;
        } else {
            _t10 = 0.0;
            _t11 = 0.0;
            _t12 = 0.0;
        }
        double _t19 = Math.fma(upX, _t10, -(upY * _t11));
        double _t20 = Math.fma(upY, _t12, -(upZ * _t10));
        double _t21 = Math.fma(upZ, _t11, -(upX * _t12));
        double _t24 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        double _t25 = (1.0 / Math.sqrt(_t24));
        double _t29, _t30, _t31;
        if (_t24 > 0.0) {
            _t29 = _t20 * _t25;
            _t30 = _t21 * _t25;
            _t31 = _t19 * _t25;
        } else {
            _t29 = 0.0;
            _t30 = 0.0;
            _t31 = 0.0;
        }
        double _t38 = Math.fma(_t10, _t31, -(_t12 * _t30));
        double _t39 = Math.fma(_t12, _t29, -(_t11 * _t31));
        double _t40 = Math.fma(_t11, _t30, -(_t10 * _t29));
        dest.put(destOffset + 0, _t29);
        dest.put(destOffset + 1, _t30);
        dest.put(destOffset + 2, _t31);
        dest.put(destOffset + 3, -Math.fma(eyeZ, _t31, Math.fma(eyeX, _t29, eyeY * _t30)));
        dest.put(destOffset + 4, _t38);
        dest.put(destOffset + 5, _t39);
        dest.put(destOffset + 6, _t40);
        dest.put(destOffset + 7, -Math.fma(eyeZ, _t40, Math.fma(eyeX, _t38, eyeY * _t39)));
        dest.put(destOffset + 8, _t11);
        dest.put(destOffset + 9, _t10);
        dest.put(destOffset + 10, _t12);
        dest.put(destOffset + 11, -Math.fma(eyeZ, _t12, Math.fma(eyeX, _t11, eyeY * _t10)));
        return dest;
    }

    public static java.nio.DoubleBuffer makeLookAt_rh(java.nio.DoubleBuffer dest, int destOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && dest.order() == java.nio.ByteOrder.nativeOrder()) return Double3x4OpsKernelsTypedBuffer.makeLookAt_rh_unsafe(dest, destOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return Double3x4OpsKernelsTypedBuffer.makeLookAt_rh_api(dest, destOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
    }

    public static java.nio.DoubleBuffer makeLookAt_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeLookAt_rh_unsafe(_destBase, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeLookAt_rh_api(java.nio.DoubleBuffer dest, int destOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        double _t0 = centerZ - eyeZ;
        double _t1 = centerX - eyeX;
        double _t2 = centerY - eyeY;
        double _t5 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        double _t6 = (1.0 / Math.sqrt(_t5));
        double _t10, _t11, _t12;
        if (_t5 > 0.0) {
            _t10 = _t1 * _t6;
            _t11 = _t2 * _t6;
            _t12 = _t0 * _t6;
        } else {
            _t10 = 0.0;
            _t11 = 0.0;
            _t12 = 0.0;
        }
        double _t19 = Math.fma(upY, _t10, -(upX * _t11));
        double _t20 = Math.fma(upX, _t12, -(upZ * _t10));
        double _t21 = Math.fma(upZ, _t11, -(upY * _t12));
        double _t24 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        double _t25 = (1.0 / Math.sqrt(_t24));
        double _t29, _t30, _t31;
        if (_t24 > 0.0) {
            _t29 = _t21 * _t25;
            _t30 = _t20 * _t25;
            _t31 = _t19 * _t25;
        } else {
            _t29 = 0.0;
            _t30 = 0.0;
            _t31 = 0.0;
        }
        double _t38 = Math.fma(_t12, _t30, -(_t11 * _t31));
        double _t39 = Math.fma(_t10, _t31, -(_t12 * _t29));
        double _t40 = Math.fma(_t11, _t29, -(_t10 * _t30));
        dest.put(destOffset + 0, _t29);
        dest.put(destOffset + 1, _t30);
        dest.put(destOffset + 2, _t31);
        dest.put(destOffset + 3, -Math.fma(eyeZ, _t31, Math.fma(eyeX, _t29, eyeY * _t30)));
        dest.put(destOffset + 4, _t38);
        dest.put(destOffset + 5, _t39);
        dest.put(destOffset + 6, _t40);
        dest.put(destOffset + 7, -Math.fma(eyeZ, _t40, Math.fma(eyeX, _t38, eyeY * _t39)));
        dest.put(destOffset + 8, -_t10);
        dest.put(destOffset + 9, -_t11);
        dest.put(destOffset + 10, -_t12);
        dest.put(destOffset + 11, Math.fma(eyeZ, _t12, Math.fma(eyeX, _t10, eyeY * _t11)));
        return dest;
    }

    public static java.nio.DoubleBuffer makeLookAt_lh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer center, int centerOffset, java.nio.DoubleBuffer up, int upOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && dest.order() == java.nio.ByteOrder.nativeOrder() && eye.isDirect() && eye.order() == java.nio.ByteOrder.nativeOrder() && center.isDirect() && center.order() == java.nio.ByteOrder.nativeOrder() && up.isDirect() && up.order() == java.nio.ByteOrder.nativeOrder()) return Double3x4OpsKernelsTypedBuffer.makeLookAt_lh_unsafe(dest, destOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
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
        double _eyex = eye.get(eyeOffset + 0);
        double _eyey = eye.get(eyeOffset + 1);
        double _eyez = eye.get(eyeOffset + 2);
        double _centerx = center.get(centerOffset + 0);
        double _centery = center.get(centerOffset + 1);
        double _centerz = center.get(centerOffset + 2);
        double _upx = up.get(upOffset + 0);
        double _upy = up.get(upOffset + 1);
        double _upz = up.get(upOffset + 2);
        double _t0 = _centerz - _eyez;
        double _t1 = _centerx - _eyex;
        double _t2 = _centery - _eyey;
        double _t5 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        double _t6 = (1.0 / Math.sqrt(_t5));
        double _t10, _t11, _t12;
        if (_t5 > 0.0) {
            _t10 = _t2 * _t6;
            _t11 = _t1 * _t6;
            _t12 = _t0 * _t6;
        } else {
            _t10 = 0.0;
            _t11 = 0.0;
            _t12 = 0.0;
        }
        double _t19 = Math.fma(_upx, _t10, -(_upy * _t11));
        double _t20 = Math.fma(_upy, _t12, -(_upz * _t10));
        double _t21 = Math.fma(_upz, _t11, -(_upx * _t12));
        double _t24 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        double _t25 = (1.0 / Math.sqrt(_t24));
        double _t29, _t30, _t31;
        if (_t24 > 0.0) {
            _t29 = _t20 * _t25;
            _t30 = _t21 * _t25;
            _t31 = _t19 * _t25;
        } else {
            _t29 = 0.0;
            _t30 = 0.0;
            _t31 = 0.0;
        }
        double _t38 = Math.fma(_t10, _t31, -(_t12 * _t30));
        double _t39 = Math.fma(_t12, _t29, -(_t11 * _t31));
        double _t40 = Math.fma(_t11, _t30, -(_t10 * _t29));
        dest.put(destOffset + 0, _t29);
        dest.put(destOffset + 1, _t30);
        dest.put(destOffset + 2, _t31);
        dest.put(destOffset + 3, -Math.fma(_eyez, _t31, Math.fma(_eyex, _t29, _eyey * _t30)));
        dest.put(destOffset + 4, _t38);
        dest.put(destOffset + 5, _t39);
        dest.put(destOffset + 6, _t40);
        dest.put(destOffset + 7, -Math.fma(_eyez, _t40, Math.fma(_eyex, _t38, _eyey * _t39)));
        dest.put(destOffset + 8, _t11);
        dest.put(destOffset + 9, _t10);
        dest.put(destOffset + 10, _t12);
        dest.put(destOffset + 11, -Math.fma(_eyez, _t12, Math.fma(_eyex, _t11, _eyey * _t10)));
        return dest;
    }

    public static java.nio.DoubleBuffer makeLookAt_rh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer center, int centerOffset, java.nio.DoubleBuffer up, int upOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && dest.order() == java.nio.ByteOrder.nativeOrder() && eye.isDirect() && eye.order() == java.nio.ByteOrder.nativeOrder() && center.isDirect() && center.order() == java.nio.ByteOrder.nativeOrder() && up.isDirect() && up.order() == java.nio.ByteOrder.nativeOrder()) return Double3x4OpsKernelsTypedBuffer.makeLookAt_rh_unsafe(dest, destOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
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
        double _eyex = eye.get(eyeOffset + 0);
        double _eyey = eye.get(eyeOffset + 1);
        double _eyez = eye.get(eyeOffset + 2);
        double _centerx = center.get(centerOffset + 0);
        double _centery = center.get(centerOffset + 1);
        double _centerz = center.get(centerOffset + 2);
        double _upx = up.get(upOffset + 0);
        double _upy = up.get(upOffset + 1);
        double _upz = up.get(upOffset + 2);
        double _t0 = _centerz - _eyez;
        double _t1 = _centerx - _eyex;
        double _t2 = _centery - _eyey;
        double _t5 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        double _t6 = (1.0 / Math.sqrt(_t5));
        double _t10, _t11, _t12;
        if (_t5 > 0.0) {
            _t10 = _t1 * _t6;
            _t11 = _t2 * _t6;
            _t12 = _t0 * _t6;
        } else {
            _t10 = 0.0;
            _t11 = 0.0;
            _t12 = 0.0;
        }
        double _t19 = Math.fma(_upy, _t10, -(_upx * _t11));
        double _t20 = Math.fma(_upx, _t12, -(_upz * _t10));
        double _t21 = Math.fma(_upz, _t11, -(_upy * _t12));
        double _t24 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        double _t25 = (1.0 / Math.sqrt(_t24));
        double _t29, _t30, _t31;
        if (_t24 > 0.0) {
            _t29 = _t21 * _t25;
            _t30 = _t20 * _t25;
            _t31 = _t19 * _t25;
        } else {
            _t29 = 0.0;
            _t30 = 0.0;
            _t31 = 0.0;
        }
        double _t38 = Math.fma(_t12, _t30, -(_t11 * _t31));
        double _t39 = Math.fma(_t10, _t31, -(_t12 * _t29));
        double _t40 = Math.fma(_t11, _t29, -(_t10 * _t30));
        dest.put(destOffset + 0, _t29);
        dest.put(destOffset + 1, _t30);
        dest.put(destOffset + 2, _t31);
        dest.put(destOffset + 3, -Math.fma(_eyez, _t31, Math.fma(_eyex, _t29, _eyey * _t30)));
        dest.put(destOffset + 4, _t38);
        dest.put(destOffset + 5, _t39);
        dest.put(destOffset + 6, _t40);
        dest.put(destOffset + 7, -Math.fma(_eyez, _t40, Math.fma(_eyex, _t38, _eyey * _t39)));
        dest.put(destOffset + 8, -_t10);
        dest.put(destOffset + 9, -_t11);
        dest.put(destOffset + 10, -_t12);
        dest.put(destOffset + 11, Math.fma(_eyez, _t12, Math.fma(_eyex, _t10, _eyey * _t11)));
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXYZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingXYZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXYZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, 1.0);
        dest.put(destOffset + 1, 0.0);
        dest.put(destOffset + 2, 0.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 0.0);
        dest.put(destOffset + 5, 1.0);
        dest.put(destOffset + 6, 0.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 0.0);
        dest.put(destOffset + 9, 0.0);
        dest.put(destOffset + 10, 1.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXYnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingXYnZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXYnZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, 1.0);
        dest.put(destOffset + 1, 0.0);
        dest.put(destOffset + 2, 0.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 0.0);
        dest.put(destOffset + 5, 1.0);
        dest.put(destOffset + 6, 0.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 0.0);
        dest.put(destOffset + 9, 0.0);
        dest.put(destOffset + 10, -1.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXZY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingXZY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXZY_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, 1.0);
        dest.put(destOffset + 1, 0.0);
        dest.put(destOffset + 2, 0.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 0.0);
        dest.put(destOffset + 5, 0.0);
        dest.put(destOffset + 6, 1.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 0.0);
        dest.put(destOffset + 9, 1.0);
        dest.put(destOffset + 10, 0.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXZnY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingXZnY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXZnY_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, 1.0);
        dest.put(destOffset + 1, 0.0);
        dest.put(destOffset + 2, 0.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 0.0);
        dest.put(destOffset + 5, 0.0);
        dest.put(destOffset + 6, -1.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 0.0);
        dest.put(destOffset + 9, 1.0);
        dest.put(destOffset + 10, 0.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXnYZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingXnYZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXnYZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, 1.0);
        dest.put(destOffset + 1, 0.0);
        dest.put(destOffset + 2, 0.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 0.0);
        dest.put(destOffset + 5, -1.0);
        dest.put(destOffset + 6, 0.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 0.0);
        dest.put(destOffset + 9, 0.0);
        dest.put(destOffset + 10, 1.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXnYnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingXnYnZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXnYnZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, 1.0);
        dest.put(destOffset + 1, 0.0);
        dest.put(destOffset + 2, 0.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 0.0);
        dest.put(destOffset + 5, -1.0);
        dest.put(destOffset + 6, 0.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 0.0);
        dest.put(destOffset + 9, 0.0);
        dest.put(destOffset + 10, -1.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXnZY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingXnZY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXnZY_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, 1.0);
        dest.put(destOffset + 1, 0.0);
        dest.put(destOffset + 2, 0.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 0.0);
        dest.put(destOffset + 5, 0.0);
        dest.put(destOffset + 6, 1.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 0.0);
        dest.put(destOffset + 9, -1.0);
        dest.put(destOffset + 10, 0.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXnZnY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingXnZnY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXnZnY_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, 1.0);
        dest.put(destOffset + 1, 0.0);
        dest.put(destOffset + 2, 0.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 0.0);
        dest.put(destOffset + 5, 0.0);
        dest.put(destOffset + 6, -1.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 0.0);
        dest.put(destOffset + 9, -1.0);
        dest.put(destOffset + 10, 0.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYXZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingYXZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYXZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, 0.0);
        dest.put(destOffset + 1, 1.0);
        dest.put(destOffset + 2, 0.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 1.0);
        dest.put(destOffset + 5, 0.0);
        dest.put(destOffset + 6, 0.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 0.0);
        dest.put(destOffset + 9, 0.0);
        dest.put(destOffset + 10, 1.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYXnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingYXnZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYXnZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, 0.0);
        dest.put(destOffset + 1, 1.0);
        dest.put(destOffset + 2, 0.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 1.0);
        dest.put(destOffset + 5, 0.0);
        dest.put(destOffset + 6, 0.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 0.0);
        dest.put(destOffset + 9, 0.0);
        dest.put(destOffset + 10, -1.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYZX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingYZX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYZX_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, 0.0);
        dest.put(destOffset + 1, 0.0);
        dest.put(destOffset + 2, 1.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 1.0);
        dest.put(destOffset + 5, 0.0);
        dest.put(destOffset + 6, 0.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 0.0);
        dest.put(destOffset + 9, 1.0);
        dest.put(destOffset + 10, 0.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYZnX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingYZnX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYZnX_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, 0.0);
        dest.put(destOffset + 1, 0.0);
        dest.put(destOffset + 2, -1.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 1.0);
        dest.put(destOffset + 5, 0.0);
        dest.put(destOffset + 6, 0.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 0.0);
        dest.put(destOffset + 9, 1.0);
        dest.put(destOffset + 10, 0.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYnXZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingYnXZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYnXZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, 0.0);
        dest.put(destOffset + 1, -1.0);
        dest.put(destOffset + 2, 0.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 1.0);
        dest.put(destOffset + 5, 0.0);
        dest.put(destOffset + 6, 0.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 0.0);
        dest.put(destOffset + 9, 0.0);
        dest.put(destOffset + 10, 1.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYnXnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingYnXnZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYnXnZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, 0.0);
        dest.put(destOffset + 1, -1.0);
        dest.put(destOffset + 2, 0.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 1.0);
        dest.put(destOffset + 5, 0.0);
        dest.put(destOffset + 6, 0.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 0.0);
        dest.put(destOffset + 9, 0.0);
        dest.put(destOffset + 10, -1.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYnZX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingYnZX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYnZX_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, 0.0);
        dest.put(destOffset + 1, 0.0);
        dest.put(destOffset + 2, 1.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 1.0);
        dest.put(destOffset + 5, 0.0);
        dest.put(destOffset + 6, 0.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 0.0);
        dest.put(destOffset + 9, -1.0);
        dest.put(destOffset + 10, 0.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYnZnX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingYnZnX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYnZnX_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, 0.0);
        dest.put(destOffset + 1, 0.0);
        dest.put(destOffset + 2, -1.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 1.0);
        dest.put(destOffset + 5, 0.0);
        dest.put(destOffset + 6, 0.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 0.0);
        dest.put(destOffset + 9, -1.0);
        dest.put(destOffset + 10, 0.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZXY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingZXY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZXY_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, 0.0);
        dest.put(destOffset + 1, 1.0);
        dest.put(destOffset + 2, 0.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 0.0);
        dest.put(destOffset + 5, 0.0);
        dest.put(destOffset + 6, 1.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 1.0);
        dest.put(destOffset + 9, 0.0);
        dest.put(destOffset + 10, 0.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZXnY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingZXnY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZXnY_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, 0.0);
        dest.put(destOffset + 1, 1.0);
        dest.put(destOffset + 2, 0.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 0.0);
        dest.put(destOffset + 5, 0.0);
        dest.put(destOffset + 6, -1.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 1.0);
        dest.put(destOffset + 9, 0.0);
        dest.put(destOffset + 10, 0.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZYX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingZYX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZYX_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, 0.0);
        dest.put(destOffset + 1, 0.0);
        dest.put(destOffset + 2, 1.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 0.0);
        dest.put(destOffset + 5, 1.0);
        dest.put(destOffset + 6, 0.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 1.0);
        dest.put(destOffset + 9, 0.0);
        dest.put(destOffset + 10, 0.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZYnX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingZYnX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZYnX_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, 0.0);
        dest.put(destOffset + 1, 0.0);
        dest.put(destOffset + 2, -1.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 0.0);
        dest.put(destOffset + 5, 1.0);
        dest.put(destOffset + 6, 0.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 1.0);
        dest.put(destOffset + 9, 0.0);
        dest.put(destOffset + 10, 0.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZnXY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingZnXY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZnXY_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, 0.0);
        dest.put(destOffset + 1, -1.0);
        dest.put(destOffset + 2, 0.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 0.0);
        dest.put(destOffset + 5, 0.0);
        dest.put(destOffset + 6, 1.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 1.0);
        dest.put(destOffset + 9, 0.0);
        dest.put(destOffset + 10, 0.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZnXnY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingZnXnY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZnXnY_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, 0.0);
        dest.put(destOffset + 1, -1.0);
        dest.put(destOffset + 2, 0.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 0.0);
        dest.put(destOffset + 5, 0.0);
        dest.put(destOffset + 6, -1.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 1.0);
        dest.put(destOffset + 9, 0.0);
        dest.put(destOffset + 10, 0.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZnYX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingZnYX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZnYX_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, 0.0);
        dest.put(destOffset + 1, 0.0);
        dest.put(destOffset + 2, 1.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 0.0);
        dest.put(destOffset + 5, -1.0);
        dest.put(destOffset + 6, 0.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 1.0);
        dest.put(destOffset + 9, 0.0);
        dest.put(destOffset + 10, 0.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZnYnX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingZnYnX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZnYnX_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, 0.0);
        dest.put(destOffset + 1, 0.0);
        dest.put(destOffset + 2, -1.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 0.0);
        dest.put(destOffset + 5, -1.0);
        dest.put(destOffset + 6, 0.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 1.0);
        dest.put(destOffset + 9, 0.0);
        dest.put(destOffset + 10, 0.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXYZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnXYZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXYZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, -1.0);
        dest.put(destOffset + 1, 0.0);
        dest.put(destOffset + 2, 0.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 0.0);
        dest.put(destOffset + 5, 1.0);
        dest.put(destOffset + 6, 0.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 0.0);
        dest.put(destOffset + 9, 0.0);
        dest.put(destOffset + 10, 1.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXYnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnXYnZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXYnZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, -1.0);
        dest.put(destOffset + 1, 0.0);
        dest.put(destOffset + 2, 0.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 0.0);
        dest.put(destOffset + 5, 1.0);
        dest.put(destOffset + 6, 0.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 0.0);
        dest.put(destOffset + 9, 0.0);
        dest.put(destOffset + 10, -1.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXZY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnXZY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXZY_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, -1.0);
        dest.put(destOffset + 1, 0.0);
        dest.put(destOffset + 2, 0.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 0.0);
        dest.put(destOffset + 5, 0.0);
        dest.put(destOffset + 6, 1.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 0.0);
        dest.put(destOffset + 9, 1.0);
        dest.put(destOffset + 10, 0.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXZnY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnXZnY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXZnY_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, -1.0);
        dest.put(destOffset + 1, 0.0);
        dest.put(destOffset + 2, 0.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 0.0);
        dest.put(destOffset + 5, 0.0);
        dest.put(destOffset + 6, -1.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 0.0);
        dest.put(destOffset + 9, 1.0);
        dest.put(destOffset + 10, 0.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXnYZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnXnYZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXnYZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, -1.0);
        dest.put(destOffset + 1, 0.0);
        dest.put(destOffset + 2, 0.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 0.0);
        dest.put(destOffset + 5, -1.0);
        dest.put(destOffset + 6, 0.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 0.0);
        dest.put(destOffset + 9, 0.0);
        dest.put(destOffset + 10, 1.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXnYnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnXnYnZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXnYnZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, -1.0);
        dest.put(destOffset + 1, 0.0);
        dest.put(destOffset + 2, 0.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 0.0);
        dest.put(destOffset + 5, -1.0);
        dest.put(destOffset + 6, 0.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 0.0);
        dest.put(destOffset + 9, 0.0);
        dest.put(destOffset + 10, -1.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXnZY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnXnZY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXnZY_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, -1.0);
        dest.put(destOffset + 1, 0.0);
        dest.put(destOffset + 2, 0.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 0.0);
        dest.put(destOffset + 5, 0.0);
        dest.put(destOffset + 6, 1.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 0.0);
        dest.put(destOffset + 9, -1.0);
        dest.put(destOffset + 10, 0.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXnZnY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnXnZnY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXnZnY_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, -1.0);
        dest.put(destOffset + 1, 0.0);
        dest.put(destOffset + 2, 0.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 0.0);
        dest.put(destOffset + 5, 0.0);
        dest.put(destOffset + 6, -1.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 0.0);
        dest.put(destOffset + 9, -1.0);
        dest.put(destOffset + 10, 0.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYXZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnYXZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYXZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, 0.0);
        dest.put(destOffset + 1, 1.0);
        dest.put(destOffset + 2, 0.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, -1.0);
        dest.put(destOffset + 5, 0.0);
        dest.put(destOffset + 6, 0.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 0.0);
        dest.put(destOffset + 9, 0.0);
        dest.put(destOffset + 10, 1.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYXnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnYXnZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYXnZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, 0.0);
        dest.put(destOffset + 1, 1.0);
        dest.put(destOffset + 2, 0.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, -1.0);
        dest.put(destOffset + 5, 0.0);
        dest.put(destOffset + 6, 0.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 0.0);
        dest.put(destOffset + 9, 0.0);
        dest.put(destOffset + 10, -1.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYZX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnYZX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYZX_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, 0.0);
        dest.put(destOffset + 1, 0.0);
        dest.put(destOffset + 2, 1.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, -1.0);
        dest.put(destOffset + 5, 0.0);
        dest.put(destOffset + 6, 0.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 0.0);
        dest.put(destOffset + 9, 1.0);
        dest.put(destOffset + 10, 0.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYZnX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnYZnX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYZnX_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, 0.0);
        dest.put(destOffset + 1, 0.0);
        dest.put(destOffset + 2, -1.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, -1.0);
        dest.put(destOffset + 5, 0.0);
        dest.put(destOffset + 6, 0.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 0.0);
        dest.put(destOffset + 9, 1.0);
        dest.put(destOffset + 10, 0.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYnXZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnYnXZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYnXZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, 0.0);
        dest.put(destOffset + 1, -1.0);
        dest.put(destOffset + 2, 0.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, -1.0);
        dest.put(destOffset + 5, 0.0);
        dest.put(destOffset + 6, 0.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 0.0);
        dest.put(destOffset + 9, 0.0);
        dest.put(destOffset + 10, 1.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYnXnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnYnXnZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYnXnZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, 0.0);
        dest.put(destOffset + 1, -1.0);
        dest.put(destOffset + 2, 0.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, -1.0);
        dest.put(destOffset + 5, 0.0);
        dest.put(destOffset + 6, 0.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 0.0);
        dest.put(destOffset + 9, 0.0);
        dest.put(destOffset + 10, -1.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYnZX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnYnZX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYnZX_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, 0.0);
        dest.put(destOffset + 1, 0.0);
        dest.put(destOffset + 2, 1.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, -1.0);
        dest.put(destOffset + 5, 0.0);
        dest.put(destOffset + 6, 0.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 0.0);
        dest.put(destOffset + 9, -1.0);
        dest.put(destOffset + 10, 0.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYnZnX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnYnZnX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYnZnX_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, 0.0);
        dest.put(destOffset + 1, 0.0);
        dest.put(destOffset + 2, -1.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, -1.0);
        dest.put(destOffset + 5, 0.0);
        dest.put(destOffset + 6, 0.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 0.0);
        dest.put(destOffset + 9, -1.0);
        dest.put(destOffset + 10, 0.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZXY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnZXY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZXY_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, 0.0);
        dest.put(destOffset + 1, 1.0);
        dest.put(destOffset + 2, 0.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 0.0);
        dest.put(destOffset + 5, 0.0);
        dest.put(destOffset + 6, 1.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, -1.0);
        dest.put(destOffset + 9, 0.0);
        dest.put(destOffset + 10, 0.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZXnY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnZXnY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZXnY_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, 0.0);
        dest.put(destOffset + 1, 1.0);
        dest.put(destOffset + 2, 0.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 0.0);
        dest.put(destOffset + 5, 0.0);
        dest.put(destOffset + 6, -1.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, -1.0);
        dest.put(destOffset + 9, 0.0);
        dest.put(destOffset + 10, 0.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZYX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnZYX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZYX_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, 0.0);
        dest.put(destOffset + 1, 0.0);
        dest.put(destOffset + 2, 1.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 0.0);
        dest.put(destOffset + 5, 1.0);
        dest.put(destOffset + 6, 0.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, -1.0);
        dest.put(destOffset + 9, 0.0);
        dest.put(destOffset + 10, 0.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZYnX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnZYnX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZYnX_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, 0.0);
        dest.put(destOffset + 1, 0.0);
        dest.put(destOffset + 2, -1.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 0.0);
        dest.put(destOffset + 5, 1.0);
        dest.put(destOffset + 6, 0.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, -1.0);
        dest.put(destOffset + 9, 0.0);
        dest.put(destOffset + 10, 0.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZnXY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnZnXY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZnXY_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, 0.0);
        dest.put(destOffset + 1, -1.0);
        dest.put(destOffset + 2, 0.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 0.0);
        dest.put(destOffset + 5, 0.0);
        dest.put(destOffset + 6, 1.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, -1.0);
        dest.put(destOffset + 9, 0.0);
        dest.put(destOffset + 10, 0.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZnXnY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnZnXnY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZnXnY_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, 0.0);
        dest.put(destOffset + 1, -1.0);
        dest.put(destOffset + 2, 0.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 0.0);
        dest.put(destOffset + 5, 0.0);
        dest.put(destOffset + 6, -1.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, -1.0);
        dest.put(destOffset + 9, 0.0);
        dest.put(destOffset + 10, 0.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZnYX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnZnYX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZnYX_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, 0.0);
        dest.put(destOffset + 1, 0.0);
        dest.put(destOffset + 2, 1.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 0.0);
        dest.put(destOffset + 5, -1.0);
        dest.put(destOffset + 6, 0.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, -1.0);
        dest.put(destOffset + 9, 0.0);
        dest.put(destOffset + 10, 0.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZnYnX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnZnYnX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZnYnX_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, 0.0);
        dest.put(destOffset + 1, 0.0);
        dest.put(destOffset + 2, -1.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 0.0);
        dest.put(destOffset + 5, -1.0);
        dest.put(destOffset + 6, 0.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, -1.0);
        dest.put(destOffset + 9, 0.0);
        dest.put(destOffset + 10, 0.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeReflection_unsafe(java.nio.DoubleBuffer dest, int destOffset, double normalX, double normalY, double normalZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeReflection_unsafe(_destBase, normalX, normalY, normalZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeReflection_api(java.nio.DoubleBuffer dest, int destOffset, double normalX, double normalY, double normalZ) {
        double _t6 = -(2.0 * normalX * normalY);
        double _t7 = -(2.0 * normalX * normalZ);
        double _t8 = -(2.0 * normalY * normalZ);
        dest.put(destOffset + 0, Math.fma(-2.0, normalX * normalX, 1.0));
        dest.put(destOffset + 1, _t6);
        dest.put(destOffset + 2, _t7);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, _t6);
        dest.put(destOffset + 5, Math.fma(-2.0, normalY * normalY, 1.0));
        dest.put(destOffset + 6, _t8);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, _t7);
        dest.put(destOffset + 9, _t8);
        dest.put(destOffset + 10, Math.fma(-2.0, normalZ * normalZ, 1.0));
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeReflection_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer normal, int normalOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _normalBase = UnsafeOpsHolder.U.getLong(normal, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) normalOffset * 8L;
        Double3x4OpsKernelsAddress.makeReflection_unsafe(_destBase, _normalBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeReflection_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer normal, int normalOffset) {
        double _normalx = normal.get(normalOffset + 0);
        double _normaly = normal.get(normalOffset + 1);
        double _normalz = normal.get(normalOffset + 2);
        double _t6 = -(2.0 * _normalx * _normaly);
        double _t7 = -(2.0 * _normalx * _normalz);
        double _t8 = -(2.0 * _normaly * _normalz);
        dest.put(destOffset + 0, Math.fma(-2.0, _normalx * _normalx, 1.0));
        dest.put(destOffset + 1, _t6);
        dest.put(destOffset + 2, _t7);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, _t6);
        dest.put(destOffset + 5, Math.fma(-2.0, _normaly * _normaly, 1.0));
        dest.put(destOffset + 6, _t8);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, _t7);
        dest.put(destOffset + 9, _t8);
        dest.put(destOffset + 10, Math.fma(-2.0, _normalz * _normalz, 1.0));
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationAxis_unsafe(java.nio.DoubleBuffer dest, int destOffset, double angle, double axisX, double axisY, double axisZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeRotationAxis_unsafe(_destBase, angle, axisX, axisY, axisZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationAxis_api(java.nio.DoubleBuffer dest, int destOffset, double angle, double axisX, double axisY, double axisZ) {
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t2 = 1.0 - _t0;
        double _t3 = axisX * axisY;
        double _t4 = axisX * axisZ;
        double _t5 = axisY * axisZ;
        dest.put(destOffset + 0, Math.fma(_t2, axisX * axisX, _t0));
        dest.put(destOffset + 1, Math.fma(_t2, _t3, -(axisZ * _t1)));
        dest.put(destOffset + 2, Math.fma(axisY, _t1, _t2 * _t4));
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, Math.fma(axisZ, _t1, _t2 * _t3));
        dest.put(destOffset + 5, Math.fma(_t2, axisY * axisY, _t0));
        dest.put(destOffset + 6, Math.fma(_t2, _t5, -(axisX * _t1)));
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, Math.fma(_t2, _t4, -(axisY * _t1)));
        dest.put(destOffset + 9, Math.fma(axisX, _t1, _t2 * _t5));
        dest.put(destOffset + 10, Math.fma(_t2, axisZ * axisZ, _t0));
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationAxis_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer axis, int axisOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _axisBase = UnsafeOpsHolder.U.getLong(axis, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) axisOffset * 8L;
        Double3x4OpsKernelsAddress.makeRotationAxis_unsafe(_destBase, _axisBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationAxis_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer axis, int axisOffset, double angle) {
        double _axisx = axis.get(axisOffset + 0);
        double _axisy = axis.get(axisOffset + 1);
        double _axisz = axis.get(axisOffset + 2);
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t2 = 1.0 - _t0;
        double _t3 = _axisx * _axisy;
        double _t4 = _axisx * _axisz;
        double _t5 = _axisy * _axisz;
        dest.put(destOffset + 0, Math.fma(_t2, _axisx * _axisx, _t0));
        dest.put(destOffset + 1, Math.fma(_t2, _t3, -(_axisz * _t1)));
        dest.put(destOffset + 2, Math.fma(_axisy, _t1, _t2 * _t4));
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, Math.fma(_axisz, _t1, _t2 * _t3));
        dest.put(destOffset + 5, Math.fma(_t2, _axisy * _axisy, _t0));
        dest.put(destOffset + 6, Math.fma(_t2, _t5, -(_axisx * _t1)));
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, Math.fma(_t2, _t4, -(_axisy * _t1)));
        dest.put(destOffset + 9, Math.fma(_axisx, _t1, _t2 * _t5));
        dest.put(destOffset + 10, Math.fma(_t2, _axisz * _axisz, _t0));
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationLookAlong_unsafe(java.nio.DoubleBuffer dest, int destOffset, double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeRotationLookAlong_unsafe(_destBase, dirX, dirY, dirZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationLookAlong_api(java.nio.DoubleBuffer dest, int destOffset, double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        double _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7, _t8, _t9;
        if (_t2 > 0.0) {
            _t7 = dirY * _t3;
            _t8 = dirX * _t3;
            _t9 = dirZ * _t3;
        } else {
            _t7 = 0.0;
            _t8 = 0.0;
            _t9 = 0.0;
        }
        double _t16 = Math.fma(upX, _t7, -(upY * _t8));
        double _t17 = Math.fma(upY, _t9, -(upZ * _t7));
        double _t18 = Math.fma(upZ, _t8, -(upX * _t9));
        double _t21 = Math.fma(_t16, _t16, Math.fma(_t17, _t17, _t18 * _t18));
        double _t22 = (1.0 / Math.sqrt(_t21));
        double _t26, _t27, _t28;
        if (_t21 > 0.0) {
            _t26 = _t17 * _t22;
            _t27 = _t16 * _t22;
            _t28 = _t18 * _t22;
        } else {
            _t26 = 0.0;
            _t27 = 0.0;
            _t28 = 0.0;
        }
        dest.put(destOffset + 0, _t26);
        dest.put(destOffset + 1, Math.fma(_t7, _t27, -(_t9 * _t28)));
        dest.put(destOffset + 2, _t8);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, _t28);
        dest.put(destOffset + 5, Math.fma(_t9, _t26, -(_t8 * _t27)));
        dest.put(destOffset + 6, _t7);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, _t27);
        dest.put(destOffset + 9, Math.fma(_t8, _t28, -(_t7 * _t26)));
        dest.put(destOffset + 10, _t9);
        dest.put(destOffset + 11, 0.0);
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
        double _dirx = dir.get(dirOffset + 0);
        double _diry = dir.get(dirOffset + 1);
        double _dirz = dir.get(dirOffset + 2);
        double _upx = up.get(upOffset + 0);
        double _upy = up.get(upOffset + 1);
        double _upz = up.get(upOffset + 2);
        double _t2 = Math.fma(_dirz, _dirz, Math.fma(_dirx, _dirx, _diry * _diry));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7, _t8, _t9;
        if (_t2 > 0.0) {
            _t7 = _diry * _t3;
            _t8 = _dirx * _t3;
            _t9 = _dirz * _t3;
        } else {
            _t7 = 0.0;
            _t8 = 0.0;
            _t9 = 0.0;
        }
        double _t16 = Math.fma(_upx, _t7, -(_upy * _t8));
        double _t17 = Math.fma(_upy, _t9, -(_upz * _t7));
        double _t18 = Math.fma(_upz, _t8, -(_upx * _t9));
        double _t21 = Math.fma(_t16, _t16, Math.fma(_t17, _t17, _t18 * _t18));
        double _t22 = (1.0 / Math.sqrt(_t21));
        double _t26, _t27, _t28;
        if (_t21 > 0.0) {
            _t26 = _t17 * _t22;
            _t27 = _t16 * _t22;
            _t28 = _t18 * _t22;
        } else {
            _t26 = 0.0;
            _t27 = 0.0;
            _t28 = 0.0;
        }
        dest.put(destOffset + 0, _t26);
        dest.put(destOffset + 1, Math.fma(_t7, _t27, -(_t9 * _t28)));
        dest.put(destOffset + 2, _t8);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, _t28);
        dest.put(destOffset + 5, Math.fma(_t9, _t26, -(_t8 * _t27)));
        dest.put(destOffset + 6, _t7);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, _t27);
        dest.put(destOffset + 9, Math.fma(_t8, _t28, -(_t7 * _t26)));
        dest.put(destOffset + 10, _t9);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationQuat_unsafe(java.nio.DoubleBuffer dest, int destOffset, double qX, double qY, double qZ, double qW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeRotationQuat_unsafe(_destBase, qX, qY, qZ, qW);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationQuat_api(java.nio.DoubleBuffer dest, int destOffset, double qX, double qY, double qZ, double qW) {
        double _t0 = qZ * qZ;
        double _t1 = qZ * qW;
        double _t2 = qY * qW;
        dest.put(destOffset + 0, Math.fma(-2.0, Math.fma(qY, qY, _t0), 1.0));
        dest.put(destOffset + 1, 2.0 * Math.fma(qX, qY, -_t1));
        dest.put(destOffset + 2, 2.0 * Math.fma(qX, qZ, _t2));
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 2.0 * Math.fma(qX, qY, _t1));
        dest.put(destOffset + 5, Math.fma(-2.0, Math.fma(qX, qX, _t0), 1.0));
        dest.put(destOffset + 6, 2.0 * Math.fma(qY, qZ, -(qX * qW)));
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 2.0 * Math.fma(qX, qZ, -_t2));
        dest.put(destOffset + 9, 2.0 * Math.fma(qX, qW, qY * qZ));
        dest.put(destOffset + 10, Math.fma(-2.0, Math.fma(qX, qX, qY * qY), 1.0));
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationQuat_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer q, int qOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _qBase = UnsafeOpsHolder.U.getLong(q, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) qOffset * 8L;
        Double3x4OpsKernelsAddress.makeRotationQuat_unsafe(_destBase, _qBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationQuat_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer q, int qOffset) {
        double _qx = q.get(qOffset + 0);
        double _qy = q.get(qOffset + 1);
        double _qz = q.get(qOffset + 2);
        double _qw = q.get(qOffset + 3);
        double _t0 = _qz * _qz;
        double _t1 = _qz * _qw;
        double _t2 = _qy * _qw;
        dest.put(destOffset + 0, Math.fma(-2.0, Math.fma(_qy, _qy, _t0), 1.0));
        dest.put(destOffset + 1, 2.0 * Math.fma(_qx, _qy, -_t1));
        dest.put(destOffset + 2, 2.0 * Math.fma(_qx, _qz, _t2));
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 2.0 * Math.fma(_qx, _qy, _t1));
        dest.put(destOffset + 5, Math.fma(-2.0, Math.fma(_qx, _qx, _t0), 1.0));
        dest.put(destOffset + 6, 2.0 * Math.fma(_qy, _qz, -(_qx * _qw)));
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 2.0 * Math.fma(_qx, _qz, -_t2));
        dest.put(destOffset + 9, 2.0 * Math.fma(_qx, _qw, _qy * _qz));
        dest.put(destOffset + 10, Math.fma(-2.0, Math.fma(_qx, _qx, _qy * _qy), 1.0));
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationX_unsafe(java.nio.DoubleBuffer dest, int destOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeRotationX_unsafe(_destBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationX_api(java.nio.DoubleBuffer dest, int destOffset, double angle) {
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dest.put(destOffset + 0, 1.0);
        dest.put(destOffset + 1, 0.0);
        dest.put(destOffset + 2, 0.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 0.0);
        dest.put(destOffset + 5, _t0);
        dest.put(destOffset + 6, -_t1);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 0.0);
        dest.put(destOffset + 9, _t1);
        dest.put(destOffset + 10, _t0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationXYZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeRotationXYZ_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationXYZ_api(java.nio.DoubleBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleZ);
        double _t3 = Math.sin(angleY);
        double _t4 = Math.sin(angleX);
        double _t5 = Math.cos(angleX);
        double _t6 = _t4 * _t3;
        double _t7 = _t3 * _t5;
        dest.put(destOffset + 0, _t0 * _t1);
        dest.put(destOffset + 1, -(_t2 * _t0));
        dest.put(destOffset + 2, _t3);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, Math.fma(_t6, _t1, _t2 * _t5));
        dest.put(destOffset + 5, Math.fma(_t5, _t1, -(_t6 * _t2)));
        dest.put(destOffset + 6, -(_t4 * _t0));
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, Math.fma(_t4, _t2, -(_t7 * _t1)));
        dest.put(destOffset + 9, Math.fma(_t7, _t2, _t4 * _t1));
        dest.put(destOffset + 10, _t5 * _t0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationXZY_unsafe(java.nio.DoubleBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeRotationXZY_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationXZY_api(java.nio.DoubleBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleZ);
        double _t3 = Math.sin(angleY);
        double _t4 = Math.cos(angleX);
        double _t5 = Math.sin(angleX);
        double _t6 = _t2 * _t4;
        double _t7 = _t5 * _t2;
        dest.put(destOffset + 0, _t0 * _t1);
        dest.put(destOffset + 1, -_t2);
        dest.put(destOffset + 2, _t3 * _t1);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, Math.fma(_t6, _t0, _t5 * _t3));
        dest.put(destOffset + 5, _t4 * _t1);
        dest.put(destOffset + 6, Math.fma(_t6, _t3, -(_t5 * _t0)));
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, Math.fma(_t7, _t0, -(_t3 * _t4)));
        dest.put(destOffset + 9, _t5 * _t1);
        dest.put(destOffset + 10, Math.fma(_t7, _t3, _t4 * _t0));
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationY_unsafe(java.nio.DoubleBuffer dest, int destOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeRotationY_unsafe(_destBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationY_api(java.nio.DoubleBuffer dest, int destOffset, double angle) {
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dest.put(destOffset + 0, _t0);
        dest.put(destOffset + 1, 0.0);
        dest.put(destOffset + 2, _t1);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 0.0);
        dest.put(destOffset + 5, 1.0);
        dest.put(destOffset + 6, 0.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, -_t1);
        dest.put(destOffset + 9, 0.0);
        dest.put(destOffset + 10, _t0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationYXZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeRotationYXZ_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationYXZ_api(java.nio.DoubleBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        double _t0 = Math.sin(angleX);
        double _t1 = Math.sin(angleY);
        double _t2 = Math.sin(angleZ);
        double _t3 = Math.cos(angleY);
        double _t4 = Math.cos(angleZ);
        double _t5 = Math.cos(angleX);
        double _t6 = _t0 * _t1;
        double _t7 = _t0 * _t3;
        dest.put(destOffset + 0, Math.fma(_t6, _t2, _t3 * _t4));
        dest.put(destOffset + 1, Math.fma(_t6, _t4, -(_t2 * _t3)));
        dest.put(destOffset + 2, _t1 * _t5);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, _t2 * _t5);
        dest.put(destOffset + 5, _t5 * _t4);
        dest.put(destOffset + 6, -_t0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, Math.fma(_t7, _t2, -(_t1 * _t4)));
        dest.put(destOffset + 9, Math.fma(_t7, _t4, _t1 * _t2));
        dest.put(destOffset + 10, _t5 * _t3);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationYZX_unsafe(java.nio.DoubleBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeRotationYZX_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationYZX_api(java.nio.DoubleBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleX);
        double _t3 = Math.sin(angleY);
        double _t4 = Math.sin(angleZ);
        double _t5 = Math.cos(angleX);
        double _t6 = _t4 * _t0;
        double _t7 = _t3 * _t4;
        dest.put(destOffset + 0, _t0 * _t1);
        dest.put(destOffset + 1, Math.fma(_t2, _t3, -(_t6 * _t5)));
        dest.put(destOffset + 2, Math.fma(_t6, _t2, _t3 * _t5));
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, _t4);
        dest.put(destOffset + 5, _t5 * _t1);
        dest.put(destOffset + 6, -(_t2 * _t1));
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, -(_t3 * _t1));
        dest.put(destOffset + 9, Math.fma(_t7, _t5, _t2 * _t0));
        dest.put(destOffset + 10, Math.fma(_t5, _t0, -(_t7 * _t2)));
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeRotationZ_unsafe(_destBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationZ_api(java.nio.DoubleBuffer dest, int destOffset, double angle) {
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dest.put(destOffset + 0, _t0);
        dest.put(destOffset + 1, -_t1);
        dest.put(destOffset + 2, 0.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, _t1);
        dest.put(destOffset + 5, _t0);
        dest.put(destOffset + 6, 0.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 0.0);
        dest.put(destOffset + 9, 0.0);
        dest.put(destOffset + 10, 1.0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationZXY_unsafe(java.nio.DoubleBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeRotationZXY_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationZXY_api(java.nio.DoubleBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleX);
        double _t3 = Math.sin(angleZ);
        double _t4 = Math.sin(angleY);
        double _t5 = Math.cos(angleX);
        double _t6 = _t2 * _t3;
        double _t7 = _t2 * _t1;
        dest.put(destOffset + 0, Math.fma(_t0, _t1, -(_t6 * _t4)));
        dest.put(destOffset + 1, -(_t3 * _t5));
        dest.put(destOffset + 2, Math.fma(_t6, _t0, _t4 * _t1));
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, Math.fma(_t7, _t4, _t3 * _t0));
        dest.put(destOffset + 5, _t5 * _t1);
        dest.put(destOffset + 6, Math.fma(_t4, _t3, -(_t7 * _t0)));
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, -(_t4 * _t5));
        dest.put(destOffset + 9, _t2);
        dest.put(destOffset + 10, _t5 * _t0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationZYX_unsafe(java.nio.DoubleBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeRotationZYX_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationZYX_api(java.nio.DoubleBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleY);
        double _t3 = Math.sin(angleX);
        double _t4 = Math.sin(angleZ);
        double _t5 = Math.cos(angleX);
        double _t6 = _t2 * _t1;
        double _t7 = _t2 * _t4;
        dest.put(destOffset + 0, _t0 * _t1);
        dest.put(destOffset + 1, Math.fma(_t6, _t3, -(_t4 * _t5)));
        dest.put(destOffset + 2, Math.fma(_t6, _t5, _t3 * _t4));
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, _t4 * _t0);
        dest.put(destOffset + 5, Math.fma(_t7, _t3, _t5 * _t1));
        dest.put(destOffset + 6, Math.fma(_t7, _t5, -(_t3 * _t1)));
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, -_t2);
        dest.put(destOffset + 9, _t3 * _t0);
        dest.put(destOffset + 10, _t5 * _t0);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeScaling_unsafe(java.nio.DoubleBuffer dest, int destOffset, double vX, double vY, double vZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeScaling_unsafe(_destBase, vX, vY, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeScaling_api(java.nio.DoubleBuffer dest, int destOffset, double vX, double vY, double vZ) {
        dest.put(destOffset + 0, vX);
        dest.put(destOffset + 1, 0.0);
        dest.put(destOffset + 2, 0.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 0.0);
        dest.put(destOffset + 5, vY);
        dest.put(destOffset + 6, 0.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 0.0);
        dest.put(destOffset + 9, 0.0);
        dest.put(destOffset + 10, vZ);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeScaling_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 8L;
        Double3x4OpsKernelsAddress.makeScaling_unsafe(_destBase, _vBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeScaling_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer v, int vOffset) {
        double _vx = v.get(vOffset + 0);
        double _vy = v.get(vOffset + 1);
        double _vz = v.get(vOffset + 2);
        dest.put(destOffset + 0, _vx);
        dest.put(destOffset + 1, 0.0);
        dest.put(destOffset + 2, 0.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 0.0);
        dest.put(destOffset + 5, _vy);
        dest.put(destOffset + 6, 0.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 0.0);
        dest.put(destOffset + 9, 0.0);
        dest.put(destOffset + 10, _vz);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeScaling_unsafe(java.nio.DoubleBuffer dest, int destOffset, double s) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeScaling_unsafe(_destBase, s);
        return dest;
    }

    public static java.nio.DoubleBuffer makeScaling_api(java.nio.DoubleBuffer dest, int destOffset, double s) {
        dest.put(destOffset + 0, s);
        dest.put(destOffset + 1, 0.0);
        dest.put(destOffset + 2, 0.0);
        dest.put(destOffset + 3, 0.0);
        dest.put(destOffset + 4, 0.0);
        dest.put(destOffset + 5, s);
        dest.put(destOffset + 6, 0.0);
        dest.put(destOffset + 7, 0.0);
        dest.put(destOffset + 8, 0.0);
        dest.put(destOffset + 9, 0.0);
        dest.put(destOffset + 10, s);
        dest.put(destOffset + 11, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer makeTranslation_unsafe(java.nio.DoubleBuffer dest, int destOffset, double vX, double vY, double vZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeTranslation_unsafe(_destBase, vX, vY, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeTranslation_api(java.nio.DoubleBuffer dest, int destOffset, double vX, double vY, double vZ) {
        dest.put(destOffset + 0, 1.0);
        dest.put(destOffset + 1, 0.0);
        dest.put(destOffset + 2, 0.0);
        dest.put(destOffset + 3, vX);
        dest.put(destOffset + 4, 0.0);
        dest.put(destOffset + 5, 1.0);
        dest.put(destOffset + 6, 0.0);
        dest.put(destOffset + 7, vY);
        dest.put(destOffset + 8, 0.0);
        dest.put(destOffset + 9, 0.0);
        dest.put(destOffset + 10, 1.0);
        dest.put(destOffset + 11, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeTranslation_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 8L;
        Double3x4OpsKernelsAddress.makeTranslation_unsafe(_destBase, _vBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeTranslation_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer v, int vOffset) {
        double _vx = v.get(vOffset + 0);
        double _vy = v.get(vOffset + 1);
        double _vz = v.get(vOffset + 2);
        dest.put(destOffset + 0, 1.0);
        dest.put(destOffset + 1, 0.0);
        dest.put(destOffset + 2, 0.0);
        dest.put(destOffset + 3, _vx);
        dest.put(destOffset + 4, 0.0);
        dest.put(destOffset + 5, 1.0);
        dest.put(destOffset + 6, 0.0);
        dest.put(destOffset + 7, _vy);
        dest.put(destOffset + 8, 0.0);
        dest.put(destOffset + 9, 0.0);
        dest.put(destOffset + 10, 1.0);
        dest.put(destOffset + 11, _vz);
        return dest;
    }

    public static java.nio.DoubleBuffer mapXYZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapXYZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapXYZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _i = 0; _i < 12; _i++) {
            double _eself = src.get(srcOffset + _i);
            dest.put(destOffset + _i, _eself);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapXYnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapXYnZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapXYnZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, _eself0);
            dest.put(destOffset + _lo + 1, _eself1);
            dest.put(destOffset + _lo + 2, -_eself2);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapXZY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapXZY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapXZY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, _eself0);
            dest.put(destOffset + _lo + 1, _eself2);
            dest.put(destOffset + _lo + 2, _eself1);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapXZnY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapXZnY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapXZnY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, _eself0);
            dest.put(destOffset + _lo + 1, _eself2);
            dest.put(destOffset + _lo + 2, -_eself1);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapXnYZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapXnYZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapXnYZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, _eself0);
            dest.put(destOffset + _lo + 1, -_eself1);
            dest.put(destOffset + _lo + 2, _eself2);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapXnYnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapXnYnZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapXnYnZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, _eself0);
            dest.put(destOffset + _lo + 1, -_eself1);
            dest.put(destOffset + _lo + 2, -_eself2);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapXnZY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapXnZY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapXnZY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, _eself0);
            dest.put(destOffset + _lo + 1, -_eself2);
            dest.put(destOffset + _lo + 2, _eself1);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapXnZnY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapXnZnY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapXnZnY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, _eself0);
            dest.put(destOffset + _lo + 1, -_eself2);
            dest.put(destOffset + _lo + 2, -_eself1);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapYXZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapYXZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapYXZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, _eself1);
            dest.put(destOffset + _lo + 1, _eself0);
            dest.put(destOffset + _lo + 2, _eself2);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapYXnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapYXnZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapYXnZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, _eself1);
            dest.put(destOffset + _lo + 1, _eself0);
            dest.put(destOffset + _lo + 2, -_eself2);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapYZX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapYZX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapYZX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, _eself1);
            dest.put(destOffset + _lo + 1, _eself2);
            dest.put(destOffset + _lo + 2, _eself0);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapYZnX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapYZnX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapYZnX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, _eself1);
            dest.put(destOffset + _lo + 1, _eself2);
            dest.put(destOffset + _lo + 2, -_eself0);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapYnXZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapYnXZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapYnXZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, _eself1);
            dest.put(destOffset + _lo + 1, -_eself0);
            dest.put(destOffset + _lo + 2, _eself2);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapYnXnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapYnXnZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapYnXnZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, _eself1);
            dest.put(destOffset + _lo + 1, -_eself0);
            dest.put(destOffset + _lo + 2, -_eself2);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapYnZX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapYnZX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapYnZX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, _eself1);
            dest.put(destOffset + _lo + 1, -_eself2);
            dest.put(destOffset + _lo + 2, _eself0);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapYnZnX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapYnZnX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapYnZnX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, _eself1);
            dest.put(destOffset + _lo + 1, -_eself2);
            dest.put(destOffset + _lo + 2, -_eself0);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapZXY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapZXY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapZXY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, _eself2);
            dest.put(destOffset + _lo + 1, _eself0);
            dest.put(destOffset + _lo + 2, _eself1);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapZXnY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapZXnY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapZXnY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, _eself2);
            dest.put(destOffset + _lo + 1, _eself0);
            dest.put(destOffset + _lo + 2, -_eself1);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapZYX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapZYX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapZYX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, _eself2);
            dest.put(destOffset + _lo + 1, _eself1);
            dest.put(destOffset + _lo + 2, _eself0);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapZYnX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapZYnX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapZYnX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, _eself2);
            dest.put(destOffset + _lo + 1, _eself1);
            dest.put(destOffset + _lo + 2, -_eself0);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapZnXY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapZnXY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapZnXY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, _eself2);
            dest.put(destOffset + _lo + 1, -_eself0);
            dest.put(destOffset + _lo + 2, _eself1);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapZnXnY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapZnXnY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapZnXnY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, _eself2);
            dest.put(destOffset + _lo + 1, -_eself0);
            dest.put(destOffset + _lo + 2, -_eself1);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapZnYX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapZnYX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapZnYX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, _eself2);
            dest.put(destOffset + _lo + 1, -_eself1);
            dest.put(destOffset + _lo + 2, _eself0);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapZnYnX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapZnYnX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapZnYnX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, _eself2);
            dest.put(destOffset + _lo + 1, -_eself1);
            dest.put(destOffset + _lo + 2, -_eself0);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXYZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnXYZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXYZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, -_eself0);
            dest.put(destOffset + _lo + 1, _eself1);
            dest.put(destOffset + _lo + 2, _eself2);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXYnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnXYnZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXYnZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, -_eself0);
            dest.put(destOffset + _lo + 1, _eself1);
            dest.put(destOffset + _lo + 2, -_eself2);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXZY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnXZY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXZY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, -_eself0);
            dest.put(destOffset + _lo + 1, _eself2);
            dest.put(destOffset + _lo + 2, _eself1);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXZnY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnXZnY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXZnY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, -_eself0);
            dest.put(destOffset + _lo + 1, _eself2);
            dest.put(destOffset + _lo + 2, -_eself1);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXnYZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnXnYZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXnYZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, -_eself0);
            dest.put(destOffset + _lo + 1, -_eself1);
            dest.put(destOffset + _lo + 2, _eself2);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXnYnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnXnYnZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXnYnZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, -_eself0);
            dest.put(destOffset + _lo + 1, -_eself1);
            dest.put(destOffset + _lo + 2, -_eself2);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXnZY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnXnZY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXnZY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, -_eself0);
            dest.put(destOffset + _lo + 1, -_eself2);
            dest.put(destOffset + _lo + 2, _eself1);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXnZnY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnXnZnY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXnZnY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, -_eself0);
            dest.put(destOffset + _lo + 1, -_eself2);
            dest.put(destOffset + _lo + 2, -_eself1);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYXZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnYXZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYXZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, -_eself1);
            dest.put(destOffset + _lo + 1, _eself0);
            dest.put(destOffset + _lo + 2, _eself2);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYXnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnYXnZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYXnZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, -_eself1);
            dest.put(destOffset + _lo + 1, _eself0);
            dest.put(destOffset + _lo + 2, -_eself2);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYZX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnYZX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYZX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, -_eself1);
            dest.put(destOffset + _lo + 1, _eself2);
            dest.put(destOffset + _lo + 2, _eself0);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYZnX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnYZnX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYZnX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, -_eself1);
            dest.put(destOffset + _lo + 1, _eself2);
            dest.put(destOffset + _lo + 2, -_eself0);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYnXZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnYnXZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYnXZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, -_eself1);
            dest.put(destOffset + _lo + 1, -_eself0);
            dest.put(destOffset + _lo + 2, _eself2);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYnXnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnYnXnZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYnXnZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, -_eself1);
            dest.put(destOffset + _lo + 1, -_eself0);
            dest.put(destOffset + _lo + 2, -_eself2);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYnZX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnYnZX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYnZX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, -_eself1);
            dest.put(destOffset + _lo + 1, -_eself2);
            dest.put(destOffset + _lo + 2, _eself0);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYnZnX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnYnZnX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYnZnX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, -_eself1);
            dest.put(destOffset + _lo + 1, -_eself2);
            dest.put(destOffset + _lo + 2, -_eself0);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZXY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnZXY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZXY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, -_eself2);
            dest.put(destOffset + _lo + 1, _eself0);
            dest.put(destOffset + _lo + 2, _eself1);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZXnY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnZXnY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZXnY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, -_eself2);
            dest.put(destOffset + _lo + 1, _eself0);
            dest.put(destOffset + _lo + 2, -_eself1);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZYX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnZYX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZYX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, -_eself2);
            dest.put(destOffset + _lo + 1, _eself1);
            dest.put(destOffset + _lo + 2, _eself0);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZYnX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnZYnX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZYnX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, -_eself2);
            dest.put(destOffset + _lo + 1, _eself1);
            dest.put(destOffset + _lo + 2, -_eself0);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZnXY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnZnXY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZnXY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, -_eself2);
            dest.put(destOffset + _lo + 1, -_eself0);
            dest.put(destOffset + _lo + 2, _eself1);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZnXnY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnZnXnY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZnXnY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, -_eself2);
            dest.put(destOffset + _lo + 1, -_eself0);
            dest.put(destOffset + _lo + 2, -_eself1);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZnYX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnZnYX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZnYX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, -_eself2);
            dest.put(destOffset + _lo + 1, -_eself1);
            dest.put(destOffset + _lo + 2, _eself0);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZnYnX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnZnYnX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZnYnX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, -_eself2);
            dest.put(destOffset + _lo + 1, -_eself1);
            dest.put(destOffset + _lo + 2, -_eself0);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateAround_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.preRotateAround_unsafe(_destBase, _srcBase, rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateAround_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _t0 = -pivotZ;
        double _t1 = rotY * rotW;
        double _t2 = rotZ * rotZ;
        double _t3 = rotZ * rotW;
        double _t11 = Math.fma(rotY, rotY, _t2);
        double _t13 = Math.fma(rotX, rotX, _t2);
        double _t14 = Math.fma(rotX, rotX, rotY * rotY);
        double _t19 = 2.0 * Math.fma(rotX, rotZ, _t1);
        double _t20 = 2.0 * Math.fma(rotX, rotY, _t3);
        double _t21 = 2.0 * Math.fma(rotX, rotW, rotY * rotZ);
        double _t22 = 2.0 * Math.fma(rotX, rotY, -_t3);
        double _t23 = 2.0 * Math.fma(rotY, rotZ, -(rotX * rotW));
        double _t24 = 2.0 * Math.fma(rotX, rotZ, -_t1);
        double _t25 = Math.fma(-2.0, _t11, 1.0);
        double _t26 = Math.fma(-2.0, _t13, 1.0);
        double _t27 = Math.fma(-2.0, _t14, 1.0);
        dest.put(destOffset + 0, Math.fma(_self20, _t19, Math.fma(_self00, _t25, _self10 * _t22)));
        dest.put(destOffset + 1, Math.fma(_self21, _t19, Math.fma(_self01, _t25, _self11 * _t22)));
        dest.put(destOffset + 2, Math.fma(_self22, _t19, Math.fma(_self02, _t25, _self12 * _t22)));
        dest.put(destOffset + 3, Math.fma(_self23, _t19, Math.fma(_self03, _t25, _self13 * _t22)) + Math.fma(_t0, _t19, Math.fma(pivotX, 2.0 * _t11, -(pivotY * _t22))));
        dest.put(destOffset + 4, Math.fma(_self20, _t23, Math.fma(_self00, _t20, _self10 * _t26)));
        dest.put(destOffset + 5, Math.fma(_self21, _t23, Math.fma(_self01, _t20, _self11 * _t26)));
        dest.put(destOffset + 6, Math.fma(_self22, _t23, Math.fma(_self02, _t20, _self12 * _t26)));
        dest.put(destOffset + 7, Math.fma(_self23, _t23, Math.fma(_self03, _t20, _self13 * _t26)) + Math.fma(_t0, _t23, Math.fma(pivotY, 2.0 * _t13, -(pivotX * _t20))));
        dest.put(destOffset + 8, Math.fma(_self20, _t27, Math.fma(_self00, _t24, _self10 * _t21)));
        dest.put(destOffset + 9, Math.fma(_self21, _t27, Math.fma(_self01, _t24, _self11 * _t21)));
        dest.put(destOffset + 10, Math.fma(_self22, _t27, Math.fma(_self02, _t24, _self12 * _t21)));
        dest.put(destOffset + 11, Math.fma(_self23, _t27, Math.fma(_self03, _t24, _self13 * _t21)) + Math.fma(-pivotY, _t21, Math.fma(pivotZ, 2.0 * _t14, -(pivotX * _t24))));
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
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _rotx = rot.get(rotOffset + 0);
        double _roty = rot.get(rotOffset + 1);
        double _rotz = rot.get(rotOffset + 2);
        double _rotw = rot.get(rotOffset + 3);
        double _pivotx = pivot.get(pivotOffset + 0);
        double _pivoty = pivot.get(pivotOffset + 1);
        double _pivotz = pivot.get(pivotOffset + 2);
        double _t0 = -_pivotz;
        double _t1 = _roty * _rotw;
        double _t2 = _rotz * _rotz;
        double _t3 = _rotz * _rotw;
        double _t11 = Math.fma(_roty, _roty, _t2);
        double _t13 = Math.fma(_rotx, _rotx, _t2);
        double _t14 = Math.fma(_rotx, _rotx, _roty * _roty);
        double _t19 = 2.0 * Math.fma(_rotx, _rotz, _t1);
        double _t20 = 2.0 * Math.fma(_rotx, _roty, _t3);
        double _t21 = 2.0 * Math.fma(_rotx, _rotw, _roty * _rotz);
        double _t22 = 2.0 * Math.fma(_rotx, _roty, -_t3);
        double _t23 = 2.0 * Math.fma(_roty, _rotz, -(_rotx * _rotw));
        double _t24 = 2.0 * Math.fma(_rotx, _rotz, -_t1);
        double _t25 = Math.fma(-2.0, _t11, 1.0);
        double _t26 = Math.fma(-2.0, _t13, 1.0);
        double _t27 = Math.fma(-2.0, _t14, 1.0);
        dest.put(destOffset + 0, Math.fma(_self20, _t19, Math.fma(_self00, _t25, _self10 * _t22)));
        dest.put(destOffset + 1, Math.fma(_self21, _t19, Math.fma(_self01, _t25, _self11 * _t22)));
        dest.put(destOffset + 2, Math.fma(_self22, _t19, Math.fma(_self02, _t25, _self12 * _t22)));
        dest.put(destOffset + 3, Math.fma(_self23, _t19, Math.fma(_self03, _t25, _self13 * _t22)) + Math.fma(_t0, _t19, Math.fma(_pivotx, 2.0 * _t11, -(_pivoty * _t22))));
        dest.put(destOffset + 4, Math.fma(_self20, _t23, Math.fma(_self00, _t20, _self10 * _t26)));
        dest.put(destOffset + 5, Math.fma(_self21, _t23, Math.fma(_self01, _t20, _self11 * _t26)));
        dest.put(destOffset + 6, Math.fma(_self22, _t23, Math.fma(_self02, _t20, _self12 * _t26)));
        dest.put(destOffset + 7, Math.fma(_self23, _t23, Math.fma(_self03, _t20, _self13 * _t26)) + Math.fma(_t0, _t23, Math.fma(_pivoty, 2.0 * _t13, -(_pivotx * _t20))));
        dest.put(destOffset + 8, Math.fma(_self20, _t27, Math.fma(_self00, _t24, _self10 * _t21)));
        dest.put(destOffset + 9, Math.fma(_self21, _t27, Math.fma(_self01, _t24, _self11 * _t21)));
        dest.put(destOffset + 10, Math.fma(_self22, _t27, Math.fma(_self02, _t24, _self12 * _t21)));
        dest.put(destOffset + 11, Math.fma(_self23, _t27, Math.fma(_self03, _t24, _self13 * _t21)) + Math.fma(-_pivoty, _t21, Math.fma(_pivotz, 2.0 * _t14, -(_pivotx * _t24))));
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateAxis_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle, double axisX, double axisY, double axisZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.preRotateAxis_unsafe(_destBase, _srcBase, angle, axisX, axisY, axisZ);
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateAxis_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle, double axisX, double axisY, double axisZ) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _t0 = Math.sin(angle);
        double _t1 = Math.cos(angle);
        double _t2 = 1.0 - _t1;
        double _t3 = axisX * axisZ;
        double _t5 = axisX * axisY;
        double _t7 = axisY * axisZ;
        double _t18 = Math.fma(_t2, axisX * axisX, _t1);
        double _t19 = Math.fma(_t2, axisY * axisY, _t1);
        double _t20 = Math.fma(_t2, axisZ * axisZ, _t1);
        double _t21 = Math.fma(axisY, _t0, _t2 * _t3);
        double _t22 = Math.fma(axisZ, _t0, _t2 * _t5);
        double _t23 = Math.fma(axisX, _t0, _t2 * _t7);
        double _t24 = Math.fma(_t2, _t5, -(axisZ * _t0));
        double _t25 = Math.fma(_t2, _t7, -(axisX * _t0));
        double _t26 = Math.fma(_t2, _t3, -(axisY * _t0));
        dest.put(destOffset + 0, Math.fma(_self20, _t21, Math.fma(_self00, _t18, _self10 * _t24)));
        dest.put(destOffset + 1, Math.fma(_self21, _t21, Math.fma(_self01, _t18, _self11 * _t24)));
        dest.put(destOffset + 2, Math.fma(_self22, _t21, Math.fma(_self02, _t18, _self12 * _t24)));
        dest.put(destOffset + 3, Math.fma(_self23, _t21, Math.fma(_self03, _t18, _self13 * _t24)));
        dest.put(destOffset + 4, Math.fma(_self20, _t25, Math.fma(_self00, _t22, _self10 * _t19)));
        dest.put(destOffset + 5, Math.fma(_self21, _t25, Math.fma(_self01, _t22, _self11 * _t19)));
        dest.put(destOffset + 6, Math.fma(_self22, _t25, Math.fma(_self02, _t22, _self12 * _t19)));
        dest.put(destOffset + 7, Math.fma(_self23, _t25, Math.fma(_self03, _t22, _self13 * _t19)));
        dest.put(destOffset + 8, Math.fma(_self20, _t20, Math.fma(_self00, _t26, _self10 * _t23)));
        dest.put(destOffset + 9, Math.fma(_self21, _t20, Math.fma(_self01, _t26, _self11 * _t23)));
        dest.put(destOffset + 10, Math.fma(_self22, _t20, Math.fma(_self02, _t26, _self12 * _t23)));
        dest.put(destOffset + 11, Math.fma(_self23, _t20, Math.fma(_self03, _t26, _self13 * _t23)));
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
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _axisx = axis.get(axisOffset + 0);
        double _axisy = axis.get(axisOffset + 1);
        double _axisz = axis.get(axisOffset + 2);
        double _t0 = Math.sin(angle);
        double _t1 = Math.cos(angle);
        double _t2 = 1.0 - _t1;
        double _t3 = _axisx * _axisz;
        double _t5 = _axisx * _axisy;
        double _t7 = _axisy * _axisz;
        double _t18 = Math.fma(_t2, _axisx * _axisx, _t1);
        double _t19 = Math.fma(_t2, _axisy * _axisy, _t1);
        double _t20 = Math.fma(_t2, _axisz * _axisz, _t1);
        double _t21 = Math.fma(_axisy, _t0, _t2 * _t3);
        double _t22 = Math.fma(_axisz, _t0, _t2 * _t5);
        double _t23 = Math.fma(_axisx, _t0, _t2 * _t7);
        double _t24 = Math.fma(_t2, _t5, -(_axisz * _t0));
        double _t25 = Math.fma(_t2, _t7, -(_axisx * _t0));
        double _t26 = Math.fma(_t2, _t3, -(_axisy * _t0));
        dest.put(destOffset + 0, Math.fma(_self20, _t21, Math.fma(_self00, _t18, _self10 * _t24)));
        dest.put(destOffset + 1, Math.fma(_self21, _t21, Math.fma(_self01, _t18, _self11 * _t24)));
        dest.put(destOffset + 2, Math.fma(_self22, _t21, Math.fma(_self02, _t18, _self12 * _t24)));
        dest.put(destOffset + 3, Math.fma(_self23, _t21, Math.fma(_self03, _t18, _self13 * _t24)));
        dest.put(destOffset + 4, Math.fma(_self20, _t25, Math.fma(_self00, _t22, _self10 * _t19)));
        dest.put(destOffset + 5, Math.fma(_self21, _t25, Math.fma(_self01, _t22, _self11 * _t19)));
        dest.put(destOffset + 6, Math.fma(_self22, _t25, Math.fma(_self02, _t22, _self12 * _t19)));
        dest.put(destOffset + 7, Math.fma(_self23, _t25, Math.fma(_self03, _t22, _self13 * _t19)));
        dest.put(destOffset + 8, Math.fma(_self20, _t20, Math.fma(_self00, _t26, _self10 * _t23)));
        dest.put(destOffset + 9, Math.fma(_self21, _t20, Math.fma(_self01, _t26, _self11 * _t23)));
        dest.put(destOffset + 10, Math.fma(_self22, _t20, Math.fma(_self02, _t26, _self12 * _t23)));
        dest.put(destOffset + 11, Math.fma(_self23, _t20, Math.fma(_self03, _t26, _self13 * _t23)));
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateQuat_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double qX, double qY, double qZ, double qW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.preRotateQuat_unsafe(_destBase, _srcBase, qX, qY, qZ, qW);
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateQuat_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double qX, double qY, double qZ, double qW) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _t0 = qY * qW;
        double _t1 = qZ * qZ;
        double _t2 = qZ * qW;
        double _t18 = 2.0 * Math.fma(qX, qZ, _t0);
        double _t19 = 2.0 * Math.fma(qX, qY, _t2);
        double _t20 = 2.0 * Math.fma(qX, qW, qY * qZ);
        double _t21 = 2.0 * Math.fma(qX, qY, -_t2);
        double _t22 = 2.0 * Math.fma(qY, qZ, -(qX * qW));
        double _t23 = 2.0 * Math.fma(qX, qZ, -_t0);
        double _t24 = Math.fma(-2.0, Math.fma(qY, qY, _t1), 1.0);
        double _t25 = Math.fma(-2.0, Math.fma(qX, qX, _t1), 1.0);
        double _t26 = Math.fma(-2.0, Math.fma(qX, qX, qY * qY), 1.0);
        dest.put(destOffset + 0, Math.fma(_self20, _t18, Math.fma(_self00, _t24, _self10 * _t21)));
        dest.put(destOffset + 1, Math.fma(_self21, _t18, Math.fma(_self01, _t24, _self11 * _t21)));
        dest.put(destOffset + 2, Math.fma(_self22, _t18, Math.fma(_self02, _t24, _self12 * _t21)));
        dest.put(destOffset + 3, Math.fma(_self23, _t18, Math.fma(_self03, _t24, _self13 * _t21)));
        dest.put(destOffset + 4, Math.fma(_self20, _t22, Math.fma(_self00, _t19, _self10 * _t25)));
        dest.put(destOffset + 5, Math.fma(_self21, _t22, Math.fma(_self01, _t19, _self11 * _t25)));
        dest.put(destOffset + 6, Math.fma(_self22, _t22, Math.fma(_self02, _t19, _self12 * _t25)));
        dest.put(destOffset + 7, Math.fma(_self23, _t22, Math.fma(_self03, _t19, _self13 * _t25)));
        dest.put(destOffset + 8, Math.fma(_self20, _t26, Math.fma(_self00, _t23, _self10 * _t20)));
        dest.put(destOffset + 9, Math.fma(_self21, _t26, Math.fma(_self01, _t23, _self11 * _t20)));
        dest.put(destOffset + 10, Math.fma(_self22, _t26, Math.fma(_self02, _t23, _self12 * _t20)));
        dest.put(destOffset + 11, Math.fma(_self23, _t26, Math.fma(_self03, _t23, _self13 * _t20)));
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
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _qx = q.get(qOffset + 0);
        double _qy = q.get(qOffset + 1);
        double _qz = q.get(qOffset + 2);
        double _qw = q.get(qOffset + 3);
        double _t0 = _qy * _qw;
        double _t1 = _qz * _qz;
        double _t2 = _qz * _qw;
        double _t18 = 2.0 * Math.fma(_qx, _qz, _t0);
        double _t19 = 2.0 * Math.fma(_qx, _qy, _t2);
        double _t20 = 2.0 * Math.fma(_qx, _qw, _qy * _qz);
        double _t21 = 2.0 * Math.fma(_qx, _qy, -_t2);
        double _t22 = 2.0 * Math.fma(_qy, _qz, -(_qx * _qw));
        double _t23 = 2.0 * Math.fma(_qx, _qz, -_t0);
        double _t24 = Math.fma(-2.0, Math.fma(_qy, _qy, _t1), 1.0);
        double _t25 = Math.fma(-2.0, Math.fma(_qx, _qx, _t1), 1.0);
        double _t26 = Math.fma(-2.0, Math.fma(_qx, _qx, _qy * _qy), 1.0);
        dest.put(destOffset + 0, Math.fma(_self20, _t18, Math.fma(_self00, _t24, _self10 * _t21)));
        dest.put(destOffset + 1, Math.fma(_self21, _t18, Math.fma(_self01, _t24, _self11 * _t21)));
        dest.put(destOffset + 2, Math.fma(_self22, _t18, Math.fma(_self02, _t24, _self12 * _t21)));
        dest.put(destOffset + 3, Math.fma(_self23, _t18, Math.fma(_self03, _t24, _self13 * _t21)));
        dest.put(destOffset + 4, Math.fma(_self20, _t22, Math.fma(_self00, _t19, _self10 * _t25)));
        dest.put(destOffset + 5, Math.fma(_self21, _t22, Math.fma(_self01, _t19, _self11 * _t25)));
        dest.put(destOffset + 6, Math.fma(_self22, _t22, Math.fma(_self02, _t19, _self12 * _t25)));
        dest.put(destOffset + 7, Math.fma(_self23, _t22, Math.fma(_self03, _t19, _self13 * _t25)));
        dest.put(destOffset + 8, Math.fma(_self20, _t26, Math.fma(_self00, _t23, _self10 * _t20)));
        dest.put(destOffset + 9, Math.fma(_self21, _t26, Math.fma(_self01, _t23, _self11 * _t20)));
        dest.put(destOffset + 10, Math.fma(_self22, _t26, Math.fma(_self02, _t23, _self12 * _t20)));
        dest.put(destOffset + 11, Math.fma(_self23, _t26, Math.fma(_self03, _t23, _self13 * _t20)));
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.preRotateX_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dest.put(destOffset + 0, _self00);
        dest.put(destOffset + 1, _self01);
        dest.put(destOffset + 2, _self02);
        dest.put(destOffset + 3, _self03);
        dest.put(destOffset + 4, Math.fma(_self10, _t0, -(_self20 * _t1)));
        dest.put(destOffset + 5, Math.fma(_self11, _t0, -(_self21 * _t1)));
        dest.put(destOffset + 6, Math.fma(_self12, _t0, -(_self22 * _t1)));
        dest.put(destOffset + 7, Math.fma(_self13, _t0, -(_self23 * _t1)));
        dest.put(destOffset + 8, Math.fma(_self10, _t1, _self20 * _t0));
        dest.put(destOffset + 9, Math.fma(_self11, _t1, _self21 * _t0));
        dest.put(destOffset + 10, Math.fma(_self12, _t1, _self22 * _t0));
        dest.put(destOffset + 11, Math.fma(_self13, _t1, _self23 * _t0));
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.preRotateY_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dest.put(destOffset + 0, Math.fma(_self00, _t0, _self20 * _t1));
        dest.put(destOffset + 1, Math.fma(_self01, _t0, _self21 * _t1));
        dest.put(destOffset + 2, Math.fma(_self02, _t0, _self22 * _t1));
        dest.put(destOffset + 3, Math.fma(_self03, _t0, _self23 * _t1));
        dest.put(destOffset + 4, _self10);
        dest.put(destOffset + 5, _self11);
        dest.put(destOffset + 6, _self12);
        dest.put(destOffset + 7, _self13);
        dest.put(destOffset + 8, Math.fma(_self20, _t0, -(_self00 * _t1)));
        dest.put(destOffset + 9, Math.fma(_self21, _t0, -(_self01 * _t1)));
        dest.put(destOffset + 10, Math.fma(_self22, _t0, -(_self02 * _t1)));
        dest.put(destOffset + 11, Math.fma(_self23, _t0, -(_self03 * _t1)));
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.preRotateZ_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dest.put(destOffset + 0, Math.fma(_self00, _t0, -(_self10 * _t1)));
        dest.put(destOffset + 1, Math.fma(_self01, _t0, -(_self11 * _t1)));
        dest.put(destOffset + 2, Math.fma(_self02, _t0, -(_self12 * _t1)));
        dest.put(destOffset + 3, Math.fma(_self03, _t0, -(_self13 * _t1)));
        dest.put(destOffset + 4, Math.fma(_self00, _t1, _self10 * _t0));
        dest.put(destOffset + 5, Math.fma(_self01, _t1, _self11 * _t0));
        dest.put(destOffset + 6, Math.fma(_self02, _t1, _self12 * _t0));
        dest.put(destOffset + 7, Math.fma(_self03, _t1, _self13 * _t0));
        dest.put(destOffset + 8, _self20);
        dest.put(destOffset + 9, _self21);
        dest.put(destOffset + 10, _self22);
        dest.put(destOffset + 11, _self23);
        return dest;
    }

    public static java.nio.DoubleBuffer preScale_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.preScale_unsafe(_destBase, _srcBase, vX, vY, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer preScale_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        dest.put(destOffset + 0, _self00 * vX);
        dest.put(destOffset + 1, _self01 * vX);
        dest.put(destOffset + 2, _self02 * vX);
        dest.put(destOffset + 3, _self03 * vX);
        dest.put(destOffset + 4, _self10 * vY);
        dest.put(destOffset + 5, _self11 * vY);
        dest.put(destOffset + 6, _self12 * vY);
        dest.put(destOffset + 7, _self13 * vY);
        dest.put(destOffset + 8, _self20 * vZ);
        dest.put(destOffset + 9, _self21 * vZ);
        dest.put(destOffset + 10, _self22 * vZ);
        dest.put(destOffset + 11, _self23 * vZ);
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
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _vx = v.get(vOffset + 0);
        double _vy = v.get(vOffset + 1);
        double _vz = v.get(vOffset + 2);
        dest.put(destOffset + 0, _self00 * _vx);
        dest.put(destOffset + 1, _self01 * _vx);
        dest.put(destOffset + 2, _self02 * _vx);
        dest.put(destOffset + 3, _self03 * _vx);
        dest.put(destOffset + 4, _self10 * _vy);
        dest.put(destOffset + 5, _self11 * _vy);
        dest.put(destOffset + 6, _self12 * _vy);
        dest.put(destOffset + 7, _self13 * _vy);
        dest.put(destOffset + 8, _self20 * _vz);
        dest.put(destOffset + 9, _self21 * _vz);
        dest.put(destOffset + 10, _self22 * _vz);
        dest.put(destOffset + 11, _self23 * _vz);
        return dest;
    }

    public static java.nio.DoubleBuffer preScale_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double s) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.preScale_unsafe(_destBase, _srcBase, s);
        return dest;
    }

    public static java.nio.DoubleBuffer preScale_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double s) {
        for (int _i = 0; _i < 12; _i++) {
            double _eself = src.get(srcOffset + _i);
            dest.put(destOffset + _i, s * _eself);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer preScaleAround_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double s, double pivotX, double pivotY, double pivotZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.preScaleAround_unsafe(_destBase, _srcBase, s, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.DoubleBuffer preScaleAround_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double s, double pivotX, double pivotY, double pivotZ) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        dest.put(destOffset + 0, s * _self00);
        dest.put(destOffset + 1, s * _self01);
        dest.put(destOffset + 2, s * _self02);
        dest.put(destOffset + 3, Math.fma(-s, pivotX, Math.fma(s, _self03, pivotX)));
        dest.put(destOffset + 4, s * _self10);
        dest.put(destOffset + 5, s * _self11);
        dest.put(destOffset + 6, s * _self12);
        dest.put(destOffset + 7, Math.fma(-s, pivotY, Math.fma(s, _self13, pivotY)));
        dest.put(destOffset + 8, s * _self20);
        dest.put(destOffset + 9, s * _self21);
        dest.put(destOffset + 10, s * _self22);
        dest.put(destOffset + 11, Math.fma(-s, pivotZ, Math.fma(s, _self23, pivotZ)));
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
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _pivotx = pivot.get(pivotOffset + 0);
        double _pivoty = pivot.get(pivotOffset + 1);
        double _pivotz = pivot.get(pivotOffset + 2);
        dest.put(destOffset + 0, s * _self00);
        dest.put(destOffset + 1, s * _self01);
        dest.put(destOffset + 2, s * _self02);
        dest.put(destOffset + 3, Math.fma(-s, _pivotx, Math.fma(s, _self03, _pivotx)));
        dest.put(destOffset + 4, s * _self10);
        dest.put(destOffset + 5, s * _self11);
        dest.put(destOffset + 6, s * _self12);
        dest.put(destOffset + 7, Math.fma(-s, _pivoty, Math.fma(s, _self13, _pivoty)));
        dest.put(destOffset + 8, s * _self20);
        dest.put(destOffset + 9, s * _self21);
        dest.put(destOffset + 10, s * _self22);
        dest.put(destOffset + 11, Math.fma(-s, _pivotz, Math.fma(s, _self23, _pivotz)));
        return dest;
    }

    public static java.nio.DoubleBuffer preScaleAround_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.preScaleAround_unsafe(_destBase, _srcBase, sX, sY, sZ, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.DoubleBuffer preScaleAround_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        dest.put(destOffset + 0, sX * _self00);
        dest.put(destOffset + 1, sX * _self01);
        dest.put(destOffset + 2, sX * _self02);
        dest.put(destOffset + 3, Math.fma(-pivotX, sX, Math.fma(sX, _self03, pivotX)));
        dest.put(destOffset + 4, sY * _self10);
        dest.put(destOffset + 5, sY * _self11);
        dest.put(destOffset + 6, sY * _self12);
        dest.put(destOffset + 7, Math.fma(-pivotY, sY, Math.fma(sY, _self13, pivotY)));
        dest.put(destOffset + 8, sZ * _self20);
        dest.put(destOffset + 9, sZ * _self21);
        dest.put(destOffset + 10, sZ * _self22);
        dest.put(destOffset + 11, Math.fma(-pivotZ, sZ, Math.fma(sZ, _self23, pivotZ)));
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
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _sx = s.get(sOffset + 0);
        double _sy = s.get(sOffset + 1);
        double _sz = s.get(sOffset + 2);
        double _pivotx = pivot.get(pivotOffset + 0);
        double _pivoty = pivot.get(pivotOffset + 1);
        double _pivotz = pivot.get(pivotOffset + 2);
        dest.put(destOffset + 0, _sx * _self00);
        dest.put(destOffset + 1, _sx * _self01);
        dest.put(destOffset + 2, _sx * _self02);
        dest.put(destOffset + 3, Math.fma(-_pivotx, _sx, Math.fma(_sx, _self03, _pivotx)));
        dest.put(destOffset + 4, _sy * _self10);
        dest.put(destOffset + 5, _sy * _self11);
        dest.put(destOffset + 6, _sy * _self12);
        dest.put(destOffset + 7, Math.fma(-_pivoty, _sy, Math.fma(_sy, _self13, _pivoty)));
        dest.put(destOffset + 8, _sz * _self20);
        dest.put(destOffset + 9, _sz * _self21);
        dest.put(destOffset + 10, _sz * _self22);
        dest.put(destOffset + 11, Math.fma(-_pivotz, _sz, Math.fma(_sz, _self23, _pivotz)));
        return dest;
    }

    public static java.nio.DoubleBuffer preTranslate_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.preTranslate_unsafe(_destBase, _srcBase, vX, vY, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer preTranslate_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        dest.put(destOffset + 0, _self00);
        dest.put(destOffset + 1, _self01);
        dest.put(destOffset + 2, _self02);
        dest.put(destOffset + 3, _self03 + vX);
        dest.put(destOffset + 4, _self10);
        dest.put(destOffset + 5, _self11);
        dest.put(destOffset + 6, _self12);
        dest.put(destOffset + 7, _self13 + vY);
        dest.put(destOffset + 8, _self20);
        dest.put(destOffset + 9, _self21);
        dest.put(destOffset + 10, _self22);
        dest.put(destOffset + 11, _self23 + vZ);
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
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _vx = v.get(vOffset + 0);
        double _vy = v.get(vOffset + 1);
        double _vz = v.get(vOffset + 2);
        dest.put(destOffset + 0, _self00);
        dest.put(destOffset + 1, _self01);
        dest.put(destOffset + 2, _self02);
        dest.put(destOffset + 3, _self03 + _vx);
        dest.put(destOffset + 4, _self10);
        dest.put(destOffset + 5, _self11);
        dest.put(destOffset + 6, _self12);
        dest.put(destOffset + 7, _self13 + _vy);
        dest.put(destOffset + 8, _self20);
        dest.put(destOffset + 9, _self21);
        dest.put(destOffset + 10, _self22);
        dest.put(destOffset + 11, _self23 + _vz);
        return dest;
    }

    public static java.nio.DoubleBuffer reflect_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double normalX, double normalY, double normalZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.reflect_unsafe(_destBase, _srcBase, normalX, normalY, normalZ);
        return dest;
    }

    public static java.nio.DoubleBuffer reflect_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double normalX, double normalY, double normalZ) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _t0 = -_self02;
        double _t1 = -_self12;
        double _t2 = -_self22;
        double _t9 = 2.0 * normalX * normalZ;
        double _t10 = 2.0 * normalX * normalY;
        double _t11 = 2.0 * normalY * normalZ;
        double _t12 = Math.fma(-2.0, normalX * normalX, 1.0);
        double _t13 = Math.fma(-2.0, normalY * normalY, 1.0);
        double _t14 = Math.fma(-2.0, normalZ * normalZ, 1.0);
        dest.put(destOffset + 0, Math.fma(_t0, _t9, Math.fma(_self00, _t12, -(_self01 * _t10))));
        dest.put(destOffset + 1, Math.fma(_t0, _t11, Math.fma(_self01, _t13, -(_self00 * _t10))));
        dest.put(destOffset + 2, Math.fma(_self02, _t14, Math.fma(-_self01, _t11, -(_self00 * _t9))));
        dest.put(destOffset + 3, _self03);
        dest.put(destOffset + 4, Math.fma(_t1, _t9, Math.fma(_self10, _t12, -(_self11 * _t10))));
        dest.put(destOffset + 5, Math.fma(_t1, _t11, Math.fma(_self11, _t13, -(_self10 * _t10))));
        dest.put(destOffset + 6, Math.fma(_self12, _t14, Math.fma(-_self11, _t11, -(_self10 * _t9))));
        dest.put(destOffset + 7, _self13);
        dest.put(destOffset + 8, Math.fma(_t2, _t9, Math.fma(_self20, _t12, -(_self21 * _t10))));
        dest.put(destOffset + 9, Math.fma(_t2, _t11, Math.fma(_self21, _t13, -(_self20 * _t10))));
        dest.put(destOffset + 10, Math.fma(_self22, _t14, Math.fma(-_self21, _t11, -(_self20 * _t9))));
        dest.put(destOffset + 11, _self23);
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
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _normalx = normal.get(normalOffset + 0);
        double _normaly = normal.get(normalOffset + 1);
        double _normalz = normal.get(normalOffset + 2);
        double _t0 = -_self02;
        double _t1 = -_self12;
        double _t2 = -_self22;
        double _t9 = 2.0 * _normalx * _normalz;
        double _t10 = 2.0 * _normalx * _normaly;
        double _t11 = 2.0 * _normaly * _normalz;
        double _t12 = Math.fma(-2.0, _normalx * _normalx, 1.0);
        double _t13 = Math.fma(-2.0, _normaly * _normaly, 1.0);
        double _t14 = Math.fma(-2.0, _normalz * _normalz, 1.0);
        dest.put(destOffset + 0, Math.fma(_t0, _t9, Math.fma(_self00, _t12, -(_self01 * _t10))));
        dest.put(destOffset + 1, Math.fma(_t0, _t11, Math.fma(_self01, _t13, -(_self00 * _t10))));
        dest.put(destOffset + 2, Math.fma(_self02, _t14, Math.fma(-_self01, _t11, -(_self00 * _t9))));
        dest.put(destOffset + 3, _self03);
        dest.put(destOffset + 4, Math.fma(_t1, _t9, Math.fma(_self10, _t12, -(_self11 * _t10))));
        dest.put(destOffset + 5, Math.fma(_t1, _t11, Math.fma(_self11, _t13, -(_self10 * _t10))));
        dest.put(destOffset + 6, Math.fma(_self12, _t14, Math.fma(-_self11, _t11, -(_self10 * _t9))));
        dest.put(destOffset + 7, _self13);
        dest.put(destOffset + 8, Math.fma(_t2, _t9, Math.fma(_self20, _t12, -(_self21 * _t10))));
        dest.put(destOffset + 9, Math.fma(_t2, _t11, Math.fma(_self21, _t13, -(_self20 * _t10))));
        dest.put(destOffset + 10, Math.fma(_self22, _t14, Math.fma(-_self21, _t11, -(_self20 * _t9))));
        dest.put(destOffset + 11, _self23);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateAround_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.rotateAround_unsafe(_destBase, _srcBase, rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateAround_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _t0 = -pivotZ;
        double _t2 = rotY * rotW;
        double _t3 = rotZ * rotZ;
        double _t4 = rotZ * rotW;
        double _t11 = Math.fma(rotY, rotY, _t3);
        double _t14 = Math.fma(rotX, rotX, _t3);
        double _t15 = Math.fma(rotX, rotX, rotY * rotY);
        double _t20 = 2.0 * Math.fma(rotX, rotY, _t4);
        double _t21 = 2.0 * Math.fma(rotX, rotW, rotY * rotZ);
        double _t22 = 2.0 * Math.fma(rotX, rotZ, _t2);
        double _t26 = 2.0 * Math.fma(rotX, rotZ, -_t2);
        double _t27 = 2.0 * Math.fma(rotX, rotY, -_t4);
        double _t28 = 2.0 * Math.fma(rotY, rotZ, -(rotX * rotW));
        double _t29 = Math.fma(-2.0, _t11, 1.0);
        double _t30 = Math.fma(-2.0, _t14, 1.0);
        double _t31 = Math.fma(-2.0, _t15, 1.0);
        double _t41 = Math.fma(_t0, _t22, Math.fma(pivotX, 2.0 * _t11, -(pivotY * _t27)));
        double _t42 = Math.fma(_t0, _t28, Math.fma(pivotY, 2.0 * _t14, -(pivotX * _t20)));
        double _t43 = Math.fma(-pivotY, _t21, Math.fma(pivotZ, 2.0 * _t15, -(pivotX * _t26)));
        dest.put(destOffset + 0, Math.fma(_self02, _t26, Math.fma(_self00, _t29, _self01 * _t20)));
        dest.put(destOffset + 1, Math.fma(_self02, _t21, Math.fma(_self00, _t27, _self01 * _t30)));
        dest.put(destOffset + 2, Math.fma(_self02, _t31, Math.fma(_self00, _t22, _self01 * _t28)));
        dest.put(destOffset + 3, Math.fma(_self00, _t41, Math.fma(_self01, _t42, Math.fma(_self02, _t43, _self03))));
        dest.put(destOffset + 4, Math.fma(_self12, _t26, Math.fma(_self10, _t29, _self11 * _t20)));
        dest.put(destOffset + 5, Math.fma(_self12, _t21, Math.fma(_self10, _t27, _self11 * _t30)));
        dest.put(destOffset + 6, Math.fma(_self12, _t31, Math.fma(_self10, _t22, _self11 * _t28)));
        dest.put(destOffset + 7, Math.fma(_self10, _t41, Math.fma(_self11, _t42, Math.fma(_self12, _t43, _self13))));
        dest.put(destOffset + 8, Math.fma(_self22, _t26, Math.fma(_self20, _t29, _self21 * _t20)));
        dest.put(destOffset + 9, Math.fma(_self22, _t21, Math.fma(_self20, _t27, _self21 * _t30)));
        dest.put(destOffset + 10, Math.fma(_self22, _t31, Math.fma(_self20, _t22, _self21 * _t28)));
        dest.put(destOffset + 11, Math.fma(_self20, _t41, Math.fma(_self21, _t42, Math.fma(_self22, _t43, _self23))));
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
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _rotx = rot.get(rotOffset + 0);
        double _roty = rot.get(rotOffset + 1);
        double _rotz = rot.get(rotOffset + 2);
        double _rotw = rot.get(rotOffset + 3);
        double _pivotx = pivot.get(pivotOffset + 0);
        double _pivoty = pivot.get(pivotOffset + 1);
        double _pivotz = pivot.get(pivotOffset + 2);
        double _t0 = -_pivotz;
        double _t2 = _roty * _rotw;
        double _t3 = _rotz * _rotz;
        double _t4 = _rotz * _rotw;
        double _t11 = Math.fma(_roty, _roty, _t3);
        double _t14 = Math.fma(_rotx, _rotx, _t3);
        double _t15 = Math.fma(_rotx, _rotx, _roty * _roty);
        double _t20 = 2.0 * Math.fma(_rotx, _roty, _t4);
        double _t21 = 2.0 * Math.fma(_rotx, _rotw, _roty * _rotz);
        double _t22 = 2.0 * Math.fma(_rotx, _rotz, _t2);
        double _t26 = 2.0 * Math.fma(_rotx, _rotz, -_t2);
        double _t27 = 2.0 * Math.fma(_rotx, _roty, -_t4);
        double _t28 = 2.0 * Math.fma(_roty, _rotz, -(_rotx * _rotw));
        double _t29 = Math.fma(-2.0, _t11, 1.0);
        double _t30 = Math.fma(-2.0, _t14, 1.0);
        double _t31 = Math.fma(-2.0, _t15, 1.0);
        double _t41 = Math.fma(_t0, _t22, Math.fma(_pivotx, 2.0 * _t11, -(_pivoty * _t27)));
        double _t42 = Math.fma(_t0, _t28, Math.fma(_pivoty, 2.0 * _t14, -(_pivotx * _t20)));
        double _t43 = Math.fma(-_pivoty, _t21, Math.fma(_pivotz, 2.0 * _t15, -(_pivotx * _t26)));
        dest.put(destOffset + 0, Math.fma(_self02, _t26, Math.fma(_self00, _t29, _self01 * _t20)));
        dest.put(destOffset + 1, Math.fma(_self02, _t21, Math.fma(_self00, _t27, _self01 * _t30)));
        dest.put(destOffset + 2, Math.fma(_self02, _t31, Math.fma(_self00, _t22, _self01 * _t28)));
        dest.put(destOffset + 3, Math.fma(_self00, _t41, Math.fma(_self01, _t42, Math.fma(_self02, _t43, _self03))));
        dest.put(destOffset + 4, Math.fma(_self12, _t26, Math.fma(_self10, _t29, _self11 * _t20)));
        dest.put(destOffset + 5, Math.fma(_self12, _t21, Math.fma(_self10, _t27, _self11 * _t30)));
        dest.put(destOffset + 6, Math.fma(_self12, _t31, Math.fma(_self10, _t22, _self11 * _t28)));
        dest.put(destOffset + 7, Math.fma(_self10, _t41, Math.fma(_self11, _t42, Math.fma(_self12, _t43, _self13))));
        dest.put(destOffset + 8, Math.fma(_self22, _t26, Math.fma(_self20, _t29, _self21 * _t20)));
        dest.put(destOffset + 9, Math.fma(_self22, _t21, Math.fma(_self20, _t27, _self21 * _t30)));
        dest.put(destOffset + 10, Math.fma(_self22, _t31, Math.fma(_self20, _t22, _self21 * _t28)));
        dest.put(destOffset + 11, Math.fma(_self20, _t41, Math.fma(_self21, _t42, Math.fma(_self22, _t43, _self23))));
        return dest;
    }

    public static java.nio.DoubleBuffer rotateAxis_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle, double axisX, double axisY, double axisZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.rotateAxis_unsafe(_destBase, _srcBase, angle, axisX, axisY, axisZ);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateAxis_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle, double axisX, double axisY, double axisZ) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t2 = 1.0 - _t0;
        double _t3 = axisX * axisZ;
        double _t6 = axisX * axisY;
        double _t7 = axisY * axisZ;
        double _t18 = Math.fma(_t2, axisX * axisX, _t0);
        double _t19 = Math.fma(_t2, axisY * axisY, _t0);
        double _t20 = Math.fma(_t2, axisZ * axisZ, _t0);
        double _t21 = Math.fma(axisZ, _t1, _t2 * _t6);
        double _t22 = Math.fma(axisX, _t1, _t2 * _t7);
        double _t23 = Math.fma(axisY, _t1, _t2 * _t3);
        double _t24 = Math.fma(_t2, _t3, -(axisY * _t1));
        double _t25 = Math.fma(_t2, _t6, -(axisZ * _t1));
        double _t26 = Math.fma(_t2, _t7, -(axisX * _t1));
        dest.put(destOffset + 0, Math.fma(_self02, _t24, Math.fma(_self00, _t18, _self01 * _t21)));
        dest.put(destOffset + 1, Math.fma(_self02, _t22, Math.fma(_self00, _t25, _self01 * _t19)));
        dest.put(destOffset + 2, Math.fma(_self02, _t20, Math.fma(_self00, _t23, _self01 * _t26)));
        dest.put(destOffset + 3, _self03);
        dest.put(destOffset + 4, Math.fma(_self12, _t24, Math.fma(_self10, _t18, _self11 * _t21)));
        dest.put(destOffset + 5, Math.fma(_self12, _t22, Math.fma(_self10, _t25, _self11 * _t19)));
        dest.put(destOffset + 6, Math.fma(_self12, _t20, Math.fma(_self10, _t23, _self11 * _t26)));
        dest.put(destOffset + 7, _self13);
        dest.put(destOffset + 8, Math.fma(_self22, _t24, Math.fma(_self20, _t18, _self21 * _t21)));
        dest.put(destOffset + 9, Math.fma(_self22, _t22, Math.fma(_self20, _t25, _self21 * _t19)));
        dest.put(destOffset + 10, Math.fma(_self22, _t20, Math.fma(_self20, _t23, _self21 * _t26)));
        dest.put(destOffset + 11, _self23);
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
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _axisx = axis.get(axisOffset + 0);
        double _axisy = axis.get(axisOffset + 1);
        double _axisz = axis.get(axisOffset + 2);
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t2 = 1.0 - _t0;
        double _t3 = _axisx * _axisz;
        double _t6 = _axisx * _axisy;
        double _t7 = _axisy * _axisz;
        double _t18 = Math.fma(_t2, _axisx * _axisx, _t0);
        double _t19 = Math.fma(_t2, _axisy * _axisy, _t0);
        double _t20 = Math.fma(_t2, _axisz * _axisz, _t0);
        double _t21 = Math.fma(_axisz, _t1, _t2 * _t6);
        double _t22 = Math.fma(_axisx, _t1, _t2 * _t7);
        double _t23 = Math.fma(_axisy, _t1, _t2 * _t3);
        double _t24 = Math.fma(_t2, _t3, -(_axisy * _t1));
        double _t25 = Math.fma(_t2, _t6, -(_axisz * _t1));
        double _t26 = Math.fma(_t2, _t7, -(_axisx * _t1));
        dest.put(destOffset + 0, Math.fma(_self02, _t24, Math.fma(_self00, _t18, _self01 * _t21)));
        dest.put(destOffset + 1, Math.fma(_self02, _t22, Math.fma(_self00, _t25, _self01 * _t19)));
        dest.put(destOffset + 2, Math.fma(_self02, _t20, Math.fma(_self00, _t23, _self01 * _t26)));
        dest.put(destOffset + 3, _self03);
        dest.put(destOffset + 4, Math.fma(_self12, _t24, Math.fma(_self10, _t18, _self11 * _t21)));
        dest.put(destOffset + 5, Math.fma(_self12, _t22, Math.fma(_self10, _t25, _self11 * _t19)));
        dest.put(destOffset + 6, Math.fma(_self12, _t20, Math.fma(_self10, _t23, _self11 * _t26)));
        dest.put(destOffset + 7, _self13);
        dest.put(destOffset + 8, Math.fma(_self22, _t24, Math.fma(_self20, _t18, _self21 * _t21)));
        dest.put(destOffset + 9, Math.fma(_self22, _t22, Math.fma(_self20, _t25, _self21 * _t19)));
        dest.put(destOffset + 10, Math.fma(_self22, _t20, Math.fma(_self20, _t23, _self21 * _t26)));
        dest.put(destOffset + 11, _self23);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateQuat_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double qX, double qY, double qZ, double qW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.rotateQuat_unsafe(_destBase, _srcBase, qX, qY, qZ, qW);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateQuat_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double qX, double qY, double qZ, double qW) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _t0 = qY * qW;
        double _t1 = qZ * qZ;
        double _t2 = qZ * qW;
        double _t18 = 2.0 * Math.fma(qX, qY, _t2);
        double _t19 = 2.0 * Math.fma(qX, qW, qY * qZ);
        double _t20 = 2.0 * Math.fma(qX, qZ, _t0);
        double _t21 = 2.0 * Math.fma(qX, qZ, -_t0);
        double _t22 = 2.0 * Math.fma(qX, qY, -_t2);
        double _t23 = 2.0 * Math.fma(qY, qZ, -(qX * qW));
        double _t24 = Math.fma(-2.0, Math.fma(qY, qY, _t1), 1.0);
        double _t25 = Math.fma(-2.0, Math.fma(qX, qX, _t1), 1.0);
        double _t26 = Math.fma(-2.0, Math.fma(qX, qX, qY * qY), 1.0);
        dest.put(destOffset + 0, Math.fma(_self02, _t21, Math.fma(_self00, _t24, _self01 * _t18)));
        dest.put(destOffset + 1, Math.fma(_self02, _t19, Math.fma(_self00, _t22, _self01 * _t25)));
        dest.put(destOffset + 2, Math.fma(_self02, _t26, Math.fma(_self00, _t20, _self01 * _t23)));
        dest.put(destOffset + 3, _self03);
        dest.put(destOffset + 4, Math.fma(_self12, _t21, Math.fma(_self10, _t24, _self11 * _t18)));
        dest.put(destOffset + 5, Math.fma(_self12, _t19, Math.fma(_self10, _t22, _self11 * _t25)));
        dest.put(destOffset + 6, Math.fma(_self12, _t26, Math.fma(_self10, _t20, _self11 * _t23)));
        dest.put(destOffset + 7, _self13);
        dest.put(destOffset + 8, Math.fma(_self22, _t21, Math.fma(_self20, _t24, _self21 * _t18)));
        dest.put(destOffset + 9, Math.fma(_self22, _t19, Math.fma(_self20, _t22, _self21 * _t25)));
        dest.put(destOffset + 10, Math.fma(_self22, _t26, Math.fma(_self20, _t20, _self21 * _t23)));
        dest.put(destOffset + 11, _self23);
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
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _qx = q.get(qOffset + 0);
        double _qy = q.get(qOffset + 1);
        double _qz = q.get(qOffset + 2);
        double _qw = q.get(qOffset + 3);
        double _t0 = _qy * _qw;
        double _t1 = _qz * _qz;
        double _t2 = _qz * _qw;
        double _t18 = 2.0 * Math.fma(_qx, _qy, _t2);
        double _t19 = 2.0 * Math.fma(_qx, _qw, _qy * _qz);
        double _t20 = 2.0 * Math.fma(_qx, _qz, _t0);
        double _t21 = 2.0 * Math.fma(_qx, _qz, -_t0);
        double _t22 = 2.0 * Math.fma(_qx, _qy, -_t2);
        double _t23 = 2.0 * Math.fma(_qy, _qz, -(_qx * _qw));
        double _t24 = Math.fma(-2.0, Math.fma(_qy, _qy, _t1), 1.0);
        double _t25 = Math.fma(-2.0, Math.fma(_qx, _qx, _t1), 1.0);
        double _t26 = Math.fma(-2.0, Math.fma(_qx, _qx, _qy * _qy), 1.0);
        dest.put(destOffset + 0, Math.fma(_self02, _t21, Math.fma(_self00, _t24, _self01 * _t18)));
        dest.put(destOffset + 1, Math.fma(_self02, _t19, Math.fma(_self00, _t22, _self01 * _t25)));
        dest.put(destOffset + 2, Math.fma(_self02, _t26, Math.fma(_self00, _t20, _self01 * _t23)));
        dest.put(destOffset + 3, _self03);
        dest.put(destOffset + 4, Math.fma(_self12, _t21, Math.fma(_self10, _t24, _self11 * _t18)));
        dest.put(destOffset + 5, Math.fma(_self12, _t19, Math.fma(_self10, _t22, _self11 * _t25)));
        dest.put(destOffset + 6, Math.fma(_self12, _t26, Math.fma(_self10, _t20, _self11 * _t23)));
        dest.put(destOffset + 7, _self13);
        dest.put(destOffset + 8, Math.fma(_self22, _t21, Math.fma(_self20, _t24, _self21 * _t18)));
        dest.put(destOffset + 9, Math.fma(_self22, _t19, Math.fma(_self20, _t22, _self21 * _t25)));
        dest.put(destOffset + 10, Math.fma(_self22, _t26, Math.fma(_self20, _t20, _self21 * _t23)));
        dest.put(destOffset + 11, _self23);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.rotateX_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dest.put(destOffset + 0, _self00);
        dest.put(destOffset + 1, Math.fma(_self01, _t0, _self02 * _t1));
        dest.put(destOffset + 2, Math.fma(_self02, _t0, -(_self01 * _t1)));
        dest.put(destOffset + 3, _self03);
        dest.put(destOffset + 4, _self10);
        dest.put(destOffset + 5, Math.fma(_self11, _t0, _self12 * _t1));
        dest.put(destOffset + 6, Math.fma(_self12, _t0, -(_self11 * _t1)));
        dest.put(destOffset + 7, _self13);
        dest.put(destOffset + 8, _self20);
        dest.put(destOffset + 9, Math.fma(_self21, _t0, _self22 * _t1));
        dest.put(destOffset + 10, Math.fma(_self22, _t0, -(_self21 * _t1)));
        dest.put(destOffset + 11, _self23);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateXYZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.rotateXYZ_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateXYZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _t0 = Math.sin(angleX);
        double _t1 = Math.sin(angleZ);
        double _t2 = Math.sin(angleY);
        double _t3 = Math.cos(angleX);
        double _t4 = Math.cos(angleZ);
        double _t5 = Math.cos(angleY);
        double _t6 = _t2 * _t3;
        double _t7 = _t5 * _t4;
        double _t8 = _t0 * _t2;
        double _t11 = _t1 * _t5;
        double _t12 = _t3 * _t5;
        double _t13 = _t0 * _t5;
        double _t18 = Math.fma(_t8, _t4, _t1 * _t3);
        double _t19 = Math.fma(_t6, _t1, _t0 * _t4);
        double _t20 = Math.fma(_t0, _t1, -(_t6 * _t4));
        double _t21 = Math.fma(_t3, _t4, -(_t8 * _t1));
        dest.put(destOffset + 0, Math.fma(_self02, _t20, Math.fma(_self00, _t7, _self01 * _t18)));
        dest.put(destOffset + 1, Math.fma(_self02, _t19, Math.fma(_self01, _t21, -(_self00 * _t11))));
        dest.put(destOffset + 2, Math.fma(_self02, _t12, Math.fma(_self00, _t2, -(_self01 * _t13))));
        dest.put(destOffset + 3, _self03);
        dest.put(destOffset + 4, Math.fma(_self12, _t20, Math.fma(_self10, _t7, _self11 * _t18)));
        dest.put(destOffset + 5, Math.fma(_self12, _t19, Math.fma(_self11, _t21, -(_self10 * _t11))));
        dest.put(destOffset + 6, Math.fma(_self12, _t12, Math.fma(_self10, _t2, -(_self11 * _t13))));
        dest.put(destOffset + 7, _self13);
        dest.put(destOffset + 8, Math.fma(_self22, _t20, Math.fma(_self20, _t7, _self21 * _t18)));
        dest.put(destOffset + 9, Math.fma(_self22, _t19, Math.fma(_self21, _t21, -(_self20 * _t11))));
        dest.put(destOffset + 10, Math.fma(_self22, _t12, Math.fma(_self20, _t2, -(_self21 * _t13))));
        dest.put(destOffset + 11, _self23);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateXZY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.rotateXZY_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateXZY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _t0 = Math.sin(angleX);
        double _t1 = Math.sin(angleZ);
        double _t2 = Math.cos(angleY);
        double _t3 = Math.sin(angleY);
        double _t4 = Math.cos(angleX);
        double _t5 = Math.cos(angleZ);
        double _t6 = _t0 * _t1;
        double _t8 = _t2 * _t5;
        double _t9 = _t1 * _t4;
        double _t11 = _t0 * _t5;
        double _t12 = _t4 * _t5;
        double _t14 = _t3 * _t5;
        double _t18 = Math.fma(_t9, _t2, _t0 * _t3);
        double _t19 = Math.fma(_t6, _t3, _t4 * _t2);
        double _t20 = Math.fma(_t6, _t2, -(_t3 * _t4));
        double _t21 = Math.fma(_t9, _t3, -(_t0 * _t2));
        dest.put(destOffset + 0, Math.fma(_self02, _t20, Math.fma(_self00, _t8, _self01 * _t18)));
        dest.put(destOffset + 1, Math.fma(_self02, _t11, Math.fma(_self01, _t12, -(_self00 * _t1))));
        dest.put(destOffset + 2, Math.fma(_self02, _t19, Math.fma(_self00, _t14, _self01 * _t21)));
        dest.put(destOffset + 3, _self03);
        dest.put(destOffset + 4, Math.fma(_self12, _t20, Math.fma(_self10, _t8, _self11 * _t18)));
        dest.put(destOffset + 5, Math.fma(_self12, _t11, Math.fma(_self11, _t12, -(_self10 * _t1))));
        dest.put(destOffset + 6, Math.fma(_self12, _t19, Math.fma(_self10, _t14, _self11 * _t21)));
        dest.put(destOffset + 7, _self13);
        dest.put(destOffset + 8, Math.fma(_self22, _t20, Math.fma(_self20, _t8, _self21 * _t18)));
        dest.put(destOffset + 9, Math.fma(_self22, _t11, Math.fma(_self21, _t12, -(_self20 * _t1))));
        dest.put(destOffset + 10, Math.fma(_self22, _t19, Math.fma(_self20, _t14, _self21 * _t21)));
        dest.put(destOffset + 11, _self23);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.rotateY_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dest.put(destOffset + 0, Math.fma(_self00, _t0, -(_self02 * _t1)));
        dest.put(destOffset + 1, _self01);
        dest.put(destOffset + 2, Math.fma(_self00, _t1, _self02 * _t0));
        dest.put(destOffset + 3, _self03);
        dest.put(destOffset + 4, Math.fma(_self10, _t0, -(_self12 * _t1)));
        dest.put(destOffset + 5, _self11);
        dest.put(destOffset + 6, Math.fma(_self10, _t1, _self12 * _t0));
        dest.put(destOffset + 7, _self13);
        dest.put(destOffset + 8, Math.fma(_self20, _t0, -(_self22 * _t1)));
        dest.put(destOffset + 9, _self21);
        dest.put(destOffset + 10, Math.fma(_self20, _t1, _self22 * _t0));
        dest.put(destOffset + 11, _self23);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateYXZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.rotateYXZ_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateYXZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _t0 = Math.sin(angleX);
        double _t1 = Math.cos(angleY);
        double _t2 = Math.sin(angleZ);
        double _t3 = Math.sin(angleY);
        double _t4 = Math.cos(angleZ);
        double _t5 = Math.cos(angleX);
        double _t6 = _t0 * _t1;
        double _t8 = _t0 * _t3;
        double _t10 = _t2 * _t5;
        double _t13 = _t5 * _t4;
        double _t14 = _t5 * _t1;
        double _t15 = _t3 * _t5;
        double _t18 = Math.fma(_t8, _t2, _t1 * _t4);
        double _t19 = Math.fma(_t6, _t4, _t3 * _t2);
        double _t20 = Math.fma(_t6, _t2, -(_t3 * _t4));
        double _t21 = Math.fma(_t8, _t4, -(_t2 * _t1));
        dest.put(destOffset + 0, Math.fma(_self02, _t20, Math.fma(_self00, _t18, _self01 * _t10)));
        dest.put(destOffset + 1, Math.fma(_self02, _t19, Math.fma(_self00, _t21, _self01 * _t13)));
        dest.put(destOffset + 2, Math.fma(_self02, _t14, Math.fma(_self00, _t15, -(_self01 * _t0))));
        dest.put(destOffset + 3, _self03);
        dest.put(destOffset + 4, Math.fma(_self12, _t20, Math.fma(_self10, _t18, _self11 * _t10)));
        dest.put(destOffset + 5, Math.fma(_self12, _t19, Math.fma(_self10, _t21, _self11 * _t13)));
        dest.put(destOffset + 6, Math.fma(_self12, _t14, Math.fma(_self10, _t15, -(_self11 * _t0))));
        dest.put(destOffset + 7, _self13);
        dest.put(destOffset + 8, Math.fma(_self22, _t20, Math.fma(_self20, _t18, _self21 * _t10)));
        dest.put(destOffset + 9, Math.fma(_self22, _t19, Math.fma(_self20, _t21, _self21 * _t13)));
        dest.put(destOffset + 10, Math.fma(_self22, _t14, Math.fma(_self20, _t15, -(_self21 * _t0))));
        dest.put(destOffset + 11, _self23);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateYZX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.rotateYZX_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateYZX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _t0 = Math.sin(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.cos(angleY);
        double _t3 = Math.sin(angleZ);
        double _t4 = Math.cos(angleX);
        double _t5 = Math.sin(angleX);
        double _t6 = _t0 * _t1;
        double _t7 = _t2 * _t1;
        double _t8 = _t0 * _t3;
        double _t10 = _t3 * _t2;
        double _t11 = _t4 * _t1;
        double _t13 = _t5 * _t1;
        double _t18 = Math.fma(_t8, _t4, _t5 * _t2);
        double _t19 = Math.fma(_t10, _t5, _t0 * _t4);
        double _t20 = Math.fma(_t5, _t0, -(_t10 * _t4));
        double _t21 = Math.fma(_t4, _t2, -(_t8 * _t5));
        dest.put(destOffset + 0, Math.fma(-_self02, _t6, Math.fma(_self00, _t7, _self01 * _t3)));
        dest.put(destOffset + 1, Math.fma(_self02, _t18, Math.fma(_self00, _t20, _self01 * _t11)));
        dest.put(destOffset + 2, Math.fma(_self02, _t21, Math.fma(_self00, _t19, -(_self01 * _t13))));
        dest.put(destOffset + 3, _self03);
        dest.put(destOffset + 4, Math.fma(-_self12, _t6, Math.fma(_self10, _t7, _self11 * _t3)));
        dest.put(destOffset + 5, Math.fma(_self12, _t18, Math.fma(_self10, _t20, _self11 * _t11)));
        dest.put(destOffset + 6, Math.fma(_self12, _t21, Math.fma(_self10, _t19, -(_self11 * _t13))));
        dest.put(destOffset + 7, _self13);
        dest.put(destOffset + 8, Math.fma(-_self22, _t6, Math.fma(_self20, _t7, _self21 * _t3)));
        dest.put(destOffset + 9, Math.fma(_self22, _t18, Math.fma(_self20, _t20, _self21 * _t11)));
        dest.put(destOffset + 10, Math.fma(_self22, _t21, Math.fma(_self20, _t19, -(_self21 * _t13))));
        dest.put(destOffset + 11, _self23);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.rotateZ_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dest.put(destOffset + 0, Math.fma(_self00, _t0, _self01 * _t1));
        dest.put(destOffset + 1, Math.fma(_self01, _t0, -(_self00 * _t1)));
        dest.put(destOffset + 2, _self02);
        dest.put(destOffset + 3, _self03);
        dest.put(destOffset + 4, Math.fma(_self10, _t0, _self11 * _t1));
        dest.put(destOffset + 5, Math.fma(_self11, _t0, -(_self10 * _t1)));
        dest.put(destOffset + 6, _self12);
        dest.put(destOffset + 7, _self13);
        dest.put(destOffset + 8, Math.fma(_self20, _t0, _self21 * _t1));
        dest.put(destOffset + 9, Math.fma(_self21, _t0, -(_self20 * _t1)));
        dest.put(destOffset + 10, _self22);
        dest.put(destOffset + 11, _self23);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateZXY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.rotateZXY_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateZXY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _t0 = Math.sin(angleY);
        double _t1 = Math.cos(angleX);
        double _t2 = Math.cos(angleY);
        double _t3 = Math.cos(angleZ);
        double _t4 = Math.sin(angleX);
        double _t5 = Math.sin(angleZ);
        double _t6 = _t0 * _t1;
        double _t7 = _t4 * _t5;
        double _t8 = _t4 * _t3;
        double _t10 = _t1 * _t3;
        double _t11 = _t5 * _t1;
        double _t12 = _t1 * _t2;
        double _t18 = Math.fma(_t8, _t0, _t5 * _t2);
        double _t19 = Math.fma(_t7, _t2, _t0 * _t3);
        double _t20 = Math.fma(_t2, _t3, -(_t7 * _t0));
        double _t21 = Math.fma(_t0, _t5, -(_t8 * _t2));
        dest.put(destOffset + 0, Math.fma(-_self02, _t6, Math.fma(_self00, _t20, _self01 * _t18)));
        dest.put(destOffset + 1, Math.fma(_self02, _t4, Math.fma(_self01, _t10, -(_self00 * _t11))));
        dest.put(destOffset + 2, Math.fma(_self02, _t12, Math.fma(_self00, _t19, _self01 * _t21)));
        dest.put(destOffset + 3, _self03);
        dest.put(destOffset + 4, Math.fma(-_self12, _t6, Math.fma(_self10, _t20, _self11 * _t18)));
        dest.put(destOffset + 5, Math.fma(_self12, _t4, Math.fma(_self11, _t10, -(_self10 * _t11))));
        dest.put(destOffset + 6, Math.fma(_self12, _t12, Math.fma(_self10, _t19, _self11 * _t21)));
        dest.put(destOffset + 7, _self13);
        dest.put(destOffset + 8, Math.fma(-_self22, _t6, Math.fma(_self20, _t20, _self21 * _t18)));
        dest.put(destOffset + 9, Math.fma(_self22, _t4, Math.fma(_self21, _t10, -(_self20 * _t11))));
        dest.put(destOffset + 10, Math.fma(_self22, _t12, Math.fma(_self20, _t19, _self21 * _t21)));
        dest.put(destOffset + 11, _self23);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateZYX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.rotateZYX_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateZYX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _t0 = Math.sin(angleY);
        double _t1 = Math.cos(angleY);
        double _t2 = Math.cos(angleZ);
        double _t3 = Math.sin(angleZ);
        double _t4 = Math.sin(angleX);
        double _t5 = Math.cos(angleX);
        double _t6 = _t1 * _t2;
        double _t7 = _t3 * _t1;
        double _t8 = _t4 * _t1;
        double _t9 = _t0 * _t2;
        double _t11 = _t0 * _t3;
        double _t13 = _t5 * _t1;
        double _t18 = Math.fma(_t11, _t4, _t5 * _t2);
        double _t19 = Math.fma(_t9, _t5, _t4 * _t3);
        double _t20 = Math.fma(_t9, _t4, -(_t3 * _t5));
        double _t21 = Math.fma(_t11, _t5, -(_t4 * _t2));
        dest.put(destOffset + 0, Math.fma(-_self02, _t0, Math.fma(_self00, _t6, _self01 * _t7)));
        dest.put(destOffset + 1, Math.fma(_self02, _t8, Math.fma(_self00, _t20, _self01 * _t18)));
        dest.put(destOffset + 2, Math.fma(_self02, _t13, Math.fma(_self00, _t19, _self01 * _t21)));
        dest.put(destOffset + 3, _self03);
        dest.put(destOffset + 4, Math.fma(-_self12, _t0, Math.fma(_self10, _t6, _self11 * _t7)));
        dest.put(destOffset + 5, Math.fma(_self12, _t8, Math.fma(_self10, _t20, _self11 * _t18)));
        dest.put(destOffset + 6, Math.fma(_self12, _t13, Math.fma(_self10, _t19, _self11 * _t21)));
        dest.put(destOffset + 7, _self13);
        dest.put(destOffset + 8, Math.fma(-_self22, _t0, Math.fma(_self20, _t6, _self21 * _t7)));
        dest.put(destOffset + 9, Math.fma(_self22, _t8, Math.fma(_self20, _t20, _self21 * _t18)));
        dest.put(destOffset + 10, Math.fma(_self22, _t13, Math.fma(_self20, _t19, _self21 * _t21)));
        dest.put(destOffset + 11, _self23);
        return dest;
    }

    public static java.nio.DoubleBuffer scale_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.scale_unsafe(_destBase, _srcBase, vX, vY, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer scale_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, _eself0 * vX);
            dest.put(destOffset + _lo + 1, _eself1 * vY);
            dest.put(destOffset + _lo + 2, _eself2 * vZ);
            dest.put(destOffset + _lo + 3, _eself3);
        }
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
        double _vx = v.get(vOffset + 0);
        double _vy = v.get(vOffset + 1);
        double _vz = v.get(vOffset + 2);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, _eself0 * _vx);
            dest.put(destOffset + _lo + 1, _eself1 * _vy);
            dest.put(destOffset + _lo + 2, _eself2 * _vz);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer scale_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double s) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.scale_unsafe(_destBase, _srcBase, s);
        return dest;
    }

    public static java.nio.DoubleBuffer scale_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double s) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, s * _eself0);
            dest.put(destOffset + _lo + 1, s * _eself1);
            dest.put(destOffset + _lo + 2, s * _eself2);
            dest.put(destOffset + _lo + 3, _eself3);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer scaleAround_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double s, double pivotX, double pivotY, double pivotZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.scaleAround_unsafe(_destBase, _srcBase, s, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.DoubleBuffer scaleAround_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double s, double pivotX, double pivotY, double pivotZ) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _t0 = Math.fma(-s, pivotX, pivotX);
        double _t1 = Math.fma(-s, pivotY, pivotY);
        double _t2 = Math.fma(-s, pivotZ, pivotZ);
        dest.put(destOffset + 0, s * _self00);
        dest.put(destOffset + 1, s * _self01);
        dest.put(destOffset + 2, s * _self02);
        dest.put(destOffset + 3, Math.fma(_self00, _t0, Math.fma(_self01, _t1, Math.fma(_self02, _t2, _self03))));
        dest.put(destOffset + 4, s * _self10);
        dest.put(destOffset + 5, s * _self11);
        dest.put(destOffset + 6, s * _self12);
        dest.put(destOffset + 7, Math.fma(_self10, _t0, Math.fma(_self11, _t1, Math.fma(_self12, _t2, _self13))));
        dest.put(destOffset + 8, s * _self20);
        dest.put(destOffset + 9, s * _self21);
        dest.put(destOffset + 10, s * _self22);
        dest.put(destOffset + 11, Math.fma(_self20, _t0, Math.fma(_self21, _t1, Math.fma(_self22, _t2, _self23))));
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
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _pivotx = pivot.get(pivotOffset + 0);
        double _pivoty = pivot.get(pivotOffset + 1);
        double _pivotz = pivot.get(pivotOffset + 2);
        double _t0 = Math.fma(-s, _pivotx, _pivotx);
        double _t1 = Math.fma(-s, _pivoty, _pivoty);
        double _t2 = Math.fma(-s, _pivotz, _pivotz);
        dest.put(destOffset + 0, s * _self00);
        dest.put(destOffset + 1, s * _self01);
        dest.put(destOffset + 2, s * _self02);
        dest.put(destOffset + 3, Math.fma(_self00, _t0, Math.fma(_self01, _t1, Math.fma(_self02, _t2, _self03))));
        dest.put(destOffset + 4, s * _self10);
        dest.put(destOffset + 5, s * _self11);
        dest.put(destOffset + 6, s * _self12);
        dest.put(destOffset + 7, Math.fma(_self10, _t0, Math.fma(_self11, _t1, Math.fma(_self12, _t2, _self13))));
        dest.put(destOffset + 8, s * _self20);
        dest.put(destOffset + 9, s * _self21);
        dest.put(destOffset + 10, s * _self22);
        dest.put(destOffset + 11, Math.fma(_self20, _t0, Math.fma(_self21, _t1, Math.fma(_self22, _t2, _self23))));
        return dest;
    }

    public static java.nio.DoubleBuffer scaleAround_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.scaleAround_unsafe(_destBase, _srcBase, sX, sY, sZ, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.DoubleBuffer scaleAround_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _t3 = Math.fma(-pivotX, sX, pivotX);
        double _t4 = Math.fma(-pivotY, sY, pivotY);
        double _t5 = Math.fma(-pivotZ, sZ, pivotZ);
        dest.put(destOffset + 0, sX * _self00);
        dest.put(destOffset + 1, sY * _self01);
        dest.put(destOffset + 2, sZ * _self02);
        dest.put(destOffset + 3, Math.fma(_self00, _t3, Math.fma(_self01, _t4, Math.fma(_self02, _t5, _self03))));
        dest.put(destOffset + 4, sX * _self10);
        dest.put(destOffset + 5, sY * _self11);
        dest.put(destOffset + 6, sZ * _self12);
        dest.put(destOffset + 7, Math.fma(_self10, _t3, Math.fma(_self11, _t4, Math.fma(_self12, _t5, _self13))));
        dest.put(destOffset + 8, sX * _self20);
        dest.put(destOffset + 9, sY * _self21);
        dest.put(destOffset + 10, sZ * _self22);
        dest.put(destOffset + 11, Math.fma(_self20, _t3, Math.fma(_self21, _t4, Math.fma(_self22, _t5, _self23))));
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
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _sx = s.get(sOffset + 0);
        double _sy = s.get(sOffset + 1);
        double _sz = s.get(sOffset + 2);
        double _pivotx = pivot.get(pivotOffset + 0);
        double _pivoty = pivot.get(pivotOffset + 1);
        double _pivotz = pivot.get(pivotOffset + 2);
        double _t3 = Math.fma(-_pivotx, _sx, _pivotx);
        double _t4 = Math.fma(-_pivoty, _sy, _pivoty);
        double _t5 = Math.fma(-_pivotz, _sz, _pivotz);
        dest.put(destOffset + 0, _sx * _self00);
        dest.put(destOffset + 1, _sy * _self01);
        dest.put(destOffset + 2, _sz * _self02);
        dest.put(destOffset + 3, Math.fma(_self00, _t3, Math.fma(_self01, _t4, Math.fma(_self02, _t5, _self03))));
        dest.put(destOffset + 4, _sx * _self10);
        dest.put(destOffset + 5, _sy * _self11);
        dest.put(destOffset + 6, _sz * _self12);
        dest.put(destOffset + 7, Math.fma(_self10, _t3, Math.fma(_self11, _t4, Math.fma(_self12, _t5, _self13))));
        dest.put(destOffset + 8, _sx * _self20);
        dest.put(destOffset + 9, _sy * _self21);
        dest.put(destOffset + 10, _sz * _self22);
        dest.put(destOffset + 11, Math.fma(_self20, _t3, Math.fma(_self21, _t4, Math.fma(_self22, _t5, _self23))));
        return dest;
    }

    public static java.nio.DoubleBuffer translate_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.translate_unsafe(_destBase, _srcBase, vX, vY, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer translate_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, _eself0);
            dest.put(destOffset + _lo + 1, _eself1);
            dest.put(destOffset + _lo + 2, _eself2);
            dest.put(destOffset + _lo + 3, Math.fma(_eself0, vX, Math.fma(_eself1, vY, Math.fma(_eself2, vZ, _eself3))));
        }
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
        double _vx = v.get(vOffset + 0);
        double _vy = v.get(vOffset + 1);
        double _vz = v.get(vOffset + 2);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src.get(srcOffset + _lo);
            double _eself1 = src.get(srcOffset + _lo + 1);
            double _eself2 = src.get(srcOffset + _lo + 2);
            double _eself3 = src.get(srcOffset + _lo + 3);
            dest.put(destOffset + _lo, _eself0);
            dest.put(destOffset + _lo + 1, _eself1);
            dest.put(destOffset + _lo + 2, _eself2);
            dest.put(destOffset + _lo + 3, Math.fma(_eself0, _vx, Math.fma(_eself1, _vy, Math.fma(_eself2, _vz, _eself3))));
        }
        return dest;
    }

    public static java.nio.DoubleBuffer mulVec4_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ, double vW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mulVec4_unsafe(_destBase, _srcBase, vX, vY, vZ, vW);
        return dest;
    }

    public static java.nio.DoubleBuffer mulVec4_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ, double vW) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        dest.put(destOffset + 0, Math.fma(_self03, vW, Math.fma(_self02, vZ, Math.fma(_self00, vX, _self01 * vY))));
        dest.put(destOffset + 1, Math.fma(_self13, vW, Math.fma(_self12, vZ, Math.fma(_self10, vX, _self11 * vY))));
        dest.put(destOffset + 2, Math.fma(_self23, vW, Math.fma(_self22, vZ, Math.fma(_self20, vX, _self21 * vY))));
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
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _vx = v.get(vOffset + 0);
        double _vy = v.get(vOffset + 1);
        double _vz = v.get(vOffset + 2);
        double _vw = v.get(vOffset + 3);
        dest.put(destOffset + 0, Math.fma(_self03, _vw, Math.fma(_self02, _vz, Math.fma(_self00, _vx, _self01 * _vy))));
        dest.put(destOffset + 1, Math.fma(_self13, _vw, Math.fma(_self12, _vz, Math.fma(_self10, _vx, _self11 * _vy))));
        dest.put(destOffset + 2, Math.fma(_self23, _vw, Math.fma(_self22, _vz, Math.fma(_self20, _vx, _self21 * _vy))));
        return dest;
    }

    public static java.nio.DoubleBuffer transformAabb_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.transformAabb_unsafe(_destBase, _srcBase, minX, minY, minZ, maxX, maxY, maxZ);
        return dest;
    }

    public static java.nio.DoubleBuffer transformAabb_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _t0 = minX * _self00;
        double _t1 = maxX * _self00;
        double _t2 = minY * _self01;
        double _t3 = maxY * _self01;
        double _t4 = minZ * _self02;
        double _t5 = maxZ * _self02;
        double _t6 = minX * _self10;
        double _t7 = maxX * _self10;
        double _t8 = minY * _self11;
        double _t9 = maxY * _self11;
        double _t10 = minZ * _self12;
        double _t11 = maxZ * _self12;
        double _t12 = minX * _self20;
        double _t13 = maxX * _self20;
        double _t14 = minY * _self21;
        double _t15 = maxY * _self21;
        double _t16 = minZ * _self22;
        double _t17 = maxZ * _self22;
        dest.put(destOffset + 0, _self03 + Math.min(_t0, _t1) + Math.min(_t2, _t3) + Math.min(_t4, _t5));
        dest.put(destOffset + 1, _self13 + Math.min(_t6, _t7) + Math.min(_t8, _t9) + Math.min(_t10, _t11));
        dest.put(destOffset + 2, _self23 + Math.min(_t12, _t13) + Math.min(_t14, _t15) + Math.min(_t16, _t17));
        dest.put(destOffset + 3, _self03 + Math.max(_t0, _t1) + Math.max(_t2, _t3) + Math.max(_t4, _t5));
        dest.put(destOffset + 4, _self13 + Math.max(_t6, _t7) + Math.max(_t8, _t9) + Math.max(_t10, _t11));
        dest.put(destOffset + 5, _self23 + Math.max(_t12, _t13) + Math.max(_t14, _t15) + Math.max(_t16, _t17));
        return dest;
    }

    public static java.nio.DoubleBuffer transformDirection_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.transformDirection_unsafe(_destBase, _srcBase, vX, vY, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer transformDirection_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        dest.put(destOffset + 0, Math.fma(_self02, vZ, Math.fma(_self00, vX, _self01 * vY)));
        dest.put(destOffset + 1, Math.fma(_self12, vZ, Math.fma(_self10, vX, _self11 * vY)));
        dest.put(destOffset + 2, Math.fma(_self22, vZ, Math.fma(_self20, vX, _self21 * vY)));
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
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _vx = v.get(vOffset + 0);
        double _vy = v.get(vOffset + 1);
        double _vz = v.get(vOffset + 2);
        dest.put(destOffset + 0, Math.fma(_self02, _vz, Math.fma(_self00, _vx, _self01 * _vy)));
        dest.put(destOffset + 1, Math.fma(_self12, _vz, Math.fma(_self10, _vx, _self11 * _vy)));
        dest.put(destOffset + 2, Math.fma(_self22, _vz, Math.fma(_self20, _vx, _self21 * _vy)));
        return dest;
    }

    public static java.nio.DoubleBuffer transformPosition_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.transformPosition_unsafe(_destBase, _srcBase, vX, vY, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer transformPosition_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ) {
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        dest.put(destOffset + 0, Math.fma(_self00, vX, Math.fma(_self01, vY, Math.fma(_self02, vZ, _self03))));
        dest.put(destOffset + 1, Math.fma(_self10, vX, Math.fma(_self11, vY, Math.fma(_self12, vZ, _self13))));
        dest.put(destOffset + 2, Math.fma(_self20, vX, Math.fma(_self21, vY, Math.fma(_self22, vZ, _self23))));
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
        double _self00 = src.get(srcOffset + 0);
        double _self01 = src.get(srcOffset + 1);
        double _self02 = src.get(srcOffset + 2);
        double _self03 = src.get(srcOffset + 3);
        double _self10 = src.get(srcOffset + 4);
        double _self11 = src.get(srcOffset + 5);
        double _self12 = src.get(srcOffset + 6);
        double _self13 = src.get(srcOffset + 7);
        double _self20 = src.get(srcOffset + 8);
        double _self21 = src.get(srcOffset + 9);
        double _self22 = src.get(srcOffset + 10);
        double _self23 = src.get(srcOffset + 11);
        double _vx = v.get(vOffset + 0);
        double _vy = v.get(vOffset + 1);
        double _vz = v.get(vOffset + 2);
        dest.put(destOffset + 0, Math.fma(_self00, _vx, Math.fma(_self01, _vy, Math.fma(_self02, _vz, _self03))));
        dest.put(destOffset + 1, Math.fma(_self10, _vx, Math.fma(_self11, _vy, Math.fma(_self12, _vz, _self13))));
        dest.put(destOffset + 2, Math.fma(_self20, _vx, Math.fma(_self21, _vy, Math.fma(_self22, _vz, _self23))));
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

    public static java.nio.DoubleBuffer lerpComposeTRSMul_fmaUnsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer t1, int t1Offset, java.nio.DoubleBuffer t2, int t2Offset, java.nio.DoubleBuffer q1, int q1Offset, java.nio.DoubleBuffer q2, int q2Offset, java.nio.DoubleBuffer s1, int s1Offset, java.nio.DoubleBuffer s2, int s2Offset, java.nio.DoubleBuffer m, int mOffset, double alpha, int count) {
        long _t1Base = UnsafeOpsHolder.U.getLong(t1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) t1Offset * 8L;
        long _t2Base = UnsafeOpsHolder.U.getLong(t2, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) t2Offset * 8L;
        long _q1Base = UnsafeOpsHolder.U.getLong(q1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) q1Offset * 8L;
        long _q2Base = UnsafeOpsHolder.U.getLong(q2, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) q2Offset * 8L;
        long _s1Base = UnsafeOpsHolder.U.getLong(s1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) s1Offset * 8L;
        long _s2Base = UnsafeOpsHolder.U.getLong(s2, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) s2Offset * 8L;
        long _mBase = UnsafeOpsHolder.U.getLong(m, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) mOffset * 8L;
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.lerpComposeTRSMul_fmaUnsafe(_destBase, _t1Base, _t2Base, _q1Base, _q2Base, _s1Base, _s2Base, _mBase, alpha, count);
        return dest;
    }

    public static java.nio.DoubleBuffer lerpComposeTRSMul_mulAddUnsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer t1, int t1Offset, java.nio.DoubleBuffer t2, int t2Offset, java.nio.DoubleBuffer q1, int q1Offset, java.nio.DoubleBuffer q2, int q2Offset, java.nio.DoubleBuffer s1, int s1Offset, java.nio.DoubleBuffer s2, int s2Offset, java.nio.DoubleBuffer m, int mOffset, double alpha, int count) {
        long _t1Base = UnsafeOpsHolder.U.getLong(t1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) t1Offset * 8L;
        long _t2Base = UnsafeOpsHolder.U.getLong(t2, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) t2Offset * 8L;
        long _q1Base = UnsafeOpsHolder.U.getLong(q1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) q1Offset * 8L;
        long _q2Base = UnsafeOpsHolder.U.getLong(q2, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) q2Offset * 8L;
        long _s1Base = UnsafeOpsHolder.U.getLong(s1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) s1Offset * 8L;
        long _s2Base = UnsafeOpsHolder.U.getLong(s2, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) s2Offset * 8L;
        long _mBase = UnsafeOpsHolder.U.getLong(m, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) mOffset * 8L;
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.lerpComposeTRSMul_mulAddUnsafe(_destBase, _t1Base, _t2Base, _q1Base, _q2Base, _s1Base, _s2Base, _mBase, alpha, count);
        return dest;
    }

    public static java.nio.DoubleBuffer lerpComposeTRSMul_fmaApi(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer t1, int t1Offset, java.nio.DoubleBuffer t2, int t2Offset, java.nio.DoubleBuffer q1, int q1Offset, java.nio.DoubleBuffer q2, int q2Offset, java.nio.DoubleBuffer s1, int s1Offset, java.nio.DoubleBuffer s2, int s2Offset, java.nio.DoubleBuffer m, int mOffset, double alpha, int count) {
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
            double _tx = Math.fma(alpha, t2.get(_t2o + 0) - _ax, _ax);
            double _ty = Math.fma(alpha, t2.get(_t2o + 1) - _ay, _ay);
            double _tz = Math.fma(alpha, t2.get(_t2o + 2) - _az, _az);
            double _bx = s1.get(_s1o + 0), _by = s1.get(_s1o + 1), _bz = s1.get(_s1o + 2);
            double _sx = Math.fma(alpha, s2.get(_s2o + 0) - _bx, _bx);
            double _sy = Math.fma(alpha, s2.get(_s2o + 1) - _by, _by);
            double _sz = Math.fma(alpha, s2.get(_s2o + 2) - _bz, _bz);
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

    public static java.nio.DoubleBuffer lerpComposeTRSMul_mulAddApi(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer t1, int t1Offset, java.nio.DoubleBuffer t2, int t2Offset, java.nio.DoubleBuffer q1, int q1Offset, java.nio.DoubleBuffer q2, int q2Offset, java.nio.DoubleBuffer s1, int s1Offset, java.nio.DoubleBuffer s2, int s2Offset, java.nio.DoubleBuffer m, int mOffset, double alpha, int count) {
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
            double _tx = alpha * (t2.get(_t2o + 0) - _ax) + _ax;
            double _ty = alpha * (t2.get(_t2o + 1) - _ay) + _ay;
            double _tz = alpha * (t2.get(_t2o + 2) - _az) + _az;
            double _bx = s1.get(_s1o + 0), _by = s1.get(_s1o + 1), _bz = s1.get(_s1o + 2);
            double _sx = alpha * (s2.get(_s2o + 0) - _bx) + _bx;
            double _sy = alpha * (s2.get(_s2o + 1) - _by) + _by;
            double _sz = alpha * (s2.get(_s2o + 2) - _bz) + _bz;
            double _ux = q1.get(_q1o + 0), _uy = q1.get(_q1o + 1), _uz = q1.get(_q1o + 2), _uw = q1.get(_q1o + 3);
            double _vx = q2.get(_q2o + 0), _vy = q2.get(_q2o + 1), _vz = q2.get(_q2o + 2), _vw = q2.get(_q2o + 3);
            double _dot = _uw * _vw + (_uz * _vz + (_ux * _vx + (_uy * _vy)));
            if (_dot < 0.0) { _vx = -_vx; _vy = -_vy; _vz = -_vz; _vw = -_vw; }
            double _qx = alpha * (_vx - _ux) + _ux;
            double _qy = alpha * (_vy - _uy) + _uy;
            double _qz = alpha * (_vz - _uz) + _uz;
            double _qw = alpha * (_vw - _uw) + _uw;
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
            double _e00 = _t02 * _m20 + (_t01 * _m10 + (_t00 * _m00)), _e01 = _t02 * _m21 + (_t01 * _m11 + (_t00 * _m01)), _e02 = _t02 * _m22 + (_t01 * _m12 + (_t00 * _m02)), _e03 = (_t02 * _m23 + (_t01 * _m13 + (_t00 * _m03))) + _tx;
            double _e10 = _t12 * _m20 + (_t11 * _m10 + (_t10 * _m00)), _e11 = _t12 * _m21 + (_t11 * _m11 + (_t10 * _m01)), _e12 = _t12 * _m22 + (_t11 * _m12 + (_t10 * _m02)), _e13 = (_t12 * _m23 + (_t11 * _m13 + (_t10 * _m03))) + _ty;
            double _e20 = _t22 * _m20 + (_t21 * _m10 + (_t20 * _m00)), _e21 = _t22 * _m21 + (_t21 * _m11 + (_t20 * _m01)), _e22 = _t22 * _m22 + (_t21 * _m12 + (_t20 * _m02)), _e23 = (_t22 * _m23 + (_t21 * _m13 + (_t20 * _m03))) + _tz;
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

    public static java.nio.DoubleBuffer composeTRSMul_fmaUnsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer translation, int translationOffset, java.nio.DoubleBuffer rotation, int rotationOffset, java.nio.DoubleBuffer scale, int scaleOffset, java.nio.DoubleBuffer m, int mOffset, int count) {
        long _translationBase = UnsafeOpsHolder.U.getLong(translation, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) translationOffset * 8L;
        long _rotationBase = UnsafeOpsHolder.U.getLong(rotation, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rotationOffset * 8L;
        long _scaleBase = UnsafeOpsHolder.U.getLong(scale, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) scaleOffset * 8L;
        long _mBase = UnsafeOpsHolder.U.getLong(m, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) mOffset * 8L;
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.composeTRSMul_fmaUnsafe(_destBase, _translationBase, _rotationBase, _scaleBase, _mBase, count);
        return dest;
    }

    public static java.nio.DoubleBuffer composeTRSMul_mulAddUnsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer translation, int translationOffset, java.nio.DoubleBuffer rotation, int rotationOffset, java.nio.DoubleBuffer scale, int scaleOffset, java.nio.DoubleBuffer m, int mOffset, int count) {
        long _translationBase = UnsafeOpsHolder.U.getLong(translation, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) translationOffset * 8L;
        long _rotationBase = UnsafeOpsHolder.U.getLong(rotation, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rotationOffset * 8L;
        long _scaleBase = UnsafeOpsHolder.U.getLong(scale, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) scaleOffset * 8L;
        long _mBase = UnsafeOpsHolder.U.getLong(m, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) mOffset * 8L;
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.composeTRSMul_mulAddUnsafe(_destBase, _translationBase, _rotationBase, _scaleBase, _mBase, count);
        return dest;
    }

    public static java.nio.DoubleBuffer composeTRSMul_fmaApi(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer translation, int translationOffset, java.nio.DoubleBuffer rotation, int rotationOffset, java.nio.DoubleBuffer scale, int scaleOffset, java.nio.DoubleBuffer m, int mOffset, int count) {
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

    public static java.nio.DoubleBuffer composeTRSMul_mulAddApi(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer translation, int translationOffset, java.nio.DoubleBuffer rotation, int rotationOffset, java.nio.DoubleBuffer scale, int scaleOffset, java.nio.DoubleBuffer m, int mOffset, int count) {
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
            double _e00 = _t02 * _m20 + (_t01 * _m10 + (_t00 * _m00)), _e01 = _t02 * _m21 + (_t01 * _m11 + (_t00 * _m01)), _e02 = _t02 * _m22 + (_t01 * _m12 + (_t00 * _m02)), _e03 = (_t02 * _m23 + (_t01 * _m13 + (_t00 * _m03))) + _tx;
            double _e10 = _t12 * _m20 + (_t11 * _m10 + (_t10 * _m00)), _e11 = _t12 * _m21 + (_t11 * _m11 + (_t10 * _m01)), _e12 = _t12 * _m22 + (_t11 * _m12 + (_t10 * _m02)), _e13 = (_t12 * _m23 + (_t11 * _m13 + (_t10 * _m03))) + _ty;
            double _e20 = _t22 * _m20 + (_t21 * _m10 + (_t20 * _m00)), _e21 = _t22 * _m21 + (_t21 * _m11 + (_t20 * _m01)), _e22 = _t22 * _m22 + (_t21 * _m12 + (_t20 * _m02)), _e23 = (_t22 * _m23 + (_t21 * _m13 + (_t20 * _m03))) + _tz;
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

    public static java.nio.DoubleBuffer composeTRSMulPadded_fmaUnsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer translation, int translationOffset, java.nio.DoubleBuffer rotation, int rotationOffset, java.nio.DoubleBuffer scale, int scaleOffset, java.nio.DoubleBuffer m, int mOffset) {
        long _translationBase = UnsafeOpsHolder.U.getLong(translation, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) translationOffset * 8L;
        long _rotationBase = UnsafeOpsHolder.U.getLong(rotation, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rotationOffset * 8L;
        long _scaleBase = UnsafeOpsHolder.U.getLong(scale, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) scaleOffset * 8L;
        long _mBase = UnsafeOpsHolder.U.getLong(m, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) mOffset * 8L;
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.composeTRSMulPadded_fmaUnsafe(_destBase, _translationBase, _rotationBase, _scaleBase, _mBase);
        return dest;
    }

    public static java.nio.DoubleBuffer composeTRSMulPadded_mulAddUnsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer translation, int translationOffset, java.nio.DoubleBuffer rotation, int rotationOffset, java.nio.DoubleBuffer scale, int scaleOffset, java.nio.DoubleBuffer m, int mOffset) {
        long _translationBase = UnsafeOpsHolder.U.getLong(translation, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) translationOffset * 8L;
        long _rotationBase = UnsafeOpsHolder.U.getLong(rotation, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rotationOffset * 8L;
        long _scaleBase = UnsafeOpsHolder.U.getLong(scale, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) scaleOffset * 8L;
        long _mBase = UnsafeOpsHolder.U.getLong(m, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) mOffset * 8L;
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.composeTRSMulPadded_mulAddUnsafe(_destBase, _translationBase, _rotationBase, _scaleBase, _mBase);
        return dest;
    }

    public static java.nio.DoubleBuffer composeTRSMulPadded_fmaApi(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer translation, int translationOffset, java.nio.DoubleBuffer rotation, int rotationOffset, java.nio.DoubleBuffer scale, int scaleOffset, java.nio.DoubleBuffer m, int mOffset) {
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

    public static java.nio.DoubleBuffer composeTRSMulPadded_mulAddApi(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer translation, int translationOffset, java.nio.DoubleBuffer rotation, int rotationOffset, java.nio.DoubleBuffer scale, int scaleOffset, java.nio.DoubleBuffer m, int mOffset) {
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
        double _e00 = _t02 * _m20 + (_t01 * _m10 + (_t00 * _m00)), _e01 = _t02 * _m21 + (_t01 * _m11 + (_t00 * _m01)), _e02 = _t02 * _m22 + (_t01 * _m12 + (_t00 * _m02)), _e03 = (_t02 * _m23 + (_t01 * _m13 + (_t00 * _m03))) + _tx;
        double _e10 = _t12 * _m20 + (_t11 * _m10 + (_t10 * _m00)), _e11 = _t12 * _m21 + (_t11 * _m11 + (_t10 * _m01)), _e12 = _t12 * _m22 + (_t11 * _m12 + (_t10 * _m02)), _e13 = (_t12 * _m23 + (_t11 * _m13 + (_t10 * _m03))) + _ty;
        double _e20 = _t22 * _m20 + (_t21 * _m10 + (_t20 * _m00)), _e21 = _t22 * _m21 + (_t21 * _m11 + (_t20 * _m01)), _e22 = _t22 * _m22 + (_t21 * _m12 + (_t20 * _m02)), _e23 = (_t22 * _m23 + (_t21 * _m13 + (_t20 * _m03))) + _tz;
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
