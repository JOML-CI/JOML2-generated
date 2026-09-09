package org.joml2.internal.kernels;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.ops.*;
import org.joml2.internal.unsafe.*;
import org.joml2.internal.simd.*;

/**
 * Scalar/Unsafe kernel leaves of {@link Double3x3Ops} whose leading storage
 * parameter is a {@link java.nio.ByteBuffer}. Split into a sibling compilation unit purely
 * to keep generated sources IDE-sized; package-private, called only from
 * {@code Double3x3Ops} and its sibling kernel units. Not public API.
 */
public final class Double3x3OpsKernelsByteBuffer {
    private Double3x3OpsKernelsByteBuffer() {}

    public static java.nio.ByteBuffer getColumn_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, int col) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.getColumn_unsafe(_destBase, _srcBase, col);
        return dest;
    }

    public static java.nio.ByteBuffer getColumn_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, int col) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        double _idxSw0;
        double _idxSw1;
        double _idxSw2;
        switch (col) {
            case 0: _idxSw0 = _self00; _idxSw1 = _self10; _idxSw2 = _self20; break;
            case 1: _idxSw0 = _self01; _idxSw1 = _self11; _idxSw2 = _self21; break;
            case 2: _idxSw0 = _self02; _idxSw1 = _self12; _idxSw2 = _self22; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + col);
        }
        dest.putDouble(destOffset + 0, _idxSw0);
        dest.putDouble(destOffset + 8, _idxSw1);
        dest.putDouble(destOffset + 16, _idxSw2);
        return dest;
    }

    public static java.nio.ByteBuffer getEulerAnglesXYZ_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.getEulerAnglesXYZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer getEulerAnglesXYZ_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        double _t1 = Math.fma(_self12, _self12, _self22 * _self22);
        double _t3 = Math.fma(_self02, _self02, _t1) * 1.0E-15;
        if (_t1 < _t3) {
            dest.putDouble(destOffset + 0, Math.atan2(_self21, _self11));
            dest.putDouble(destOffset + 16, 0.0);
        } else {
            dest.putDouble(destOffset + 0, Math.atan2(-_self12, _self22));
            dest.putDouble(destOffset + 16, Math.atan2(-_self01, _self00));
        }
        dest.putDouble(destOffset + 8, Math.atan2(_self02, Math.sqrt(_t1)));
        return dest;
    }

    public static java.nio.ByteBuffer getEulerAnglesXZY_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.getEulerAnglesXZY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer getEulerAnglesXZY_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        double _t1 = Math.fma(_self11, _self11, _self21 * _self21);
        double _t3 = Math.fma(_self01, _self01, _t1) * 1.0E-15;
        if (_t1 < _t3) {
            dest.putDouble(destOffset + 0, Math.atan2(-_self12, _self22));
            dest.putDouble(destOffset + 8, 0.0);
        } else {
            dest.putDouble(destOffset + 0, Math.atan2(_self21, _self11));
            dest.putDouble(destOffset + 8, Math.atan2(_self02, _self00));
        }
        dest.putDouble(destOffset + 16, Math.atan2(-_self01, Math.sqrt(_t1)));
        return dest;
    }

    public static java.nio.ByteBuffer getEulerAnglesYXZ_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.getEulerAnglesYXZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer getEulerAnglesYXZ_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        double _t1 = Math.fma(_self02, _self02, _self22 * _self22);
        double _t3 = Math.fma(_self12, _self12, _t1) * 1.0E-15;
        if (_t1 < _t3) {
            dest.putDouble(destOffset + 8, Math.atan2(-_self20, _self00));
            dest.putDouble(destOffset + 16, 0.0);
        } else {
            dest.putDouble(destOffset + 8, Math.atan2(_self02, _self22));
            dest.putDouble(destOffset + 16, Math.atan2(_self10, _self11));
        }
        dest.putDouble(destOffset + 0, Math.atan2(-_self12, Math.sqrt(_t1)));
        return dest;
    }

    public static java.nio.ByteBuffer getEulerAnglesYZX_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.getEulerAnglesYZX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer getEulerAnglesYZX_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        double _t1 = Math.fma(_self11, _self11, _self12 * _self12);
        double _t3 = Math.fma(_self10, _self10, _t1) * 1.0E-15;
        if (_t1 < _t3) {
            dest.putDouble(destOffset + 0, 0.0);
            dest.putDouble(destOffset + 8, Math.atan2(_self02, _self22));
        } else {
            dest.putDouble(destOffset + 0, Math.atan2(-_self12, _self11));
            dest.putDouble(destOffset + 8, Math.atan2(-_self20, _self00));
        }
        dest.putDouble(destOffset + 16, Math.atan2(_self10, Math.sqrt(_t1)));
        return dest;
    }

    public static java.nio.ByteBuffer getEulerAnglesZXY_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.getEulerAnglesZXY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer getEulerAnglesZXY_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self22 = src.getDouble(srcOffset + 64);
        double _t1 = Math.fma(_self01, _self01, _self11 * _self11);
        double _t3 = Math.fma(_self21, _self21, _t1) * 1.0E-15;
        if (_t1 < _t3) {
            dest.putDouble(destOffset + 8, 0.0);
            dest.putDouble(destOffset + 16, Math.atan2(_self10, _self00));
        } else {
            dest.putDouble(destOffset + 8, Math.atan2(-_self20, _self22));
            dest.putDouble(destOffset + 16, Math.atan2(-_self01, _self11));
        }
        dest.putDouble(destOffset + 0, Math.atan2(_self21, Math.sqrt(_t1)));
        return dest;
    }

    public static java.nio.ByteBuffer getEulerAnglesZYX_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.getEulerAnglesZYX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer getEulerAnglesZYX_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self22 = src.getDouble(srcOffset + 64);
        double _t1 = Math.fma(_self21, _self21, _self22 * _self22);
        double _t3 = Math.fma(_self20, _self20, _t1) * 1.0E-15;
        if (_t1 < _t3) {
            dest.putDouble(destOffset + 0, 0.0);
            dest.putDouble(destOffset + 16, Math.atan2(-_self01, _self11));
        } else {
            dest.putDouble(destOffset + 0, Math.atan2(_self21, _self22));
            dest.putDouble(destOffset + 16, Math.atan2(_self10, _self00));
        }
        dest.putDouble(destOffset + 8, Math.atan2(-_self20, Math.sqrt(_t1)));
        return dest;
    }

    public static java.nio.ByteBuffer getNormalizedRotation_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.getNormalizedRotation_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer getNormalizedRotation_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
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
            dest.putDouble(destOffset + 0, 0.5 * _t36 * _t66);
            dest.putDouble(destOffset + 8, 0.5 * _t56 * _t66);
            dest.putDouble(destOffset + 16, 0.5 * _t57 * _t66);
            dest.putDouble(destOffset + 24, 0.5 * Math.sqrt(_t62));
        } else {
            if (_t49 > _t37) {
                dest.putDouble(destOffset + 0, 0.5 * Math.sqrt(_t63));
                dest.putDouble(destOffset + 8, 0.5 * _t53 * _t69);
                dest.putDouble(destOffset + 16, 0.5 * _t55 * _t69);
                dest.putDouble(destOffset + 24, 0.5 * _t36 * _t69);
            } else {
                if (_t23 > _t26) {
                    dest.putDouble(destOffset + 0, 0.5 * _t53 * _t67);
                    dest.putDouble(destOffset + 8, 0.5 * Math.sqrt(_t64));
                    dest.putDouble(destOffset + 16, 0.5 * _t39 * _t67);
                    dest.putDouble(destOffset + 24, 0.5 * _t56 * _t67);
                } else {
                    dest.putDouble(destOffset + 0, 0.5 * _t55 * _t68);
                    dest.putDouble(destOffset + 8, 0.5 * _t39 * _t68);
                    dest.putDouble(destOffset + 16, 0.5 * Math.sqrt(_t65));
                    dest.putDouble(destOffset + 24, 0.5 * _t57 * _t68);
                }
            }
        }
        return dest;
    }

    public static java.nio.ByteBuffer getRow_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, int row) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.getRow_unsafe(_destBase, _srcBase, row);
        return dest;
    }

    public static java.nio.ByteBuffer getRow_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, int row) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        double _idxSw0;
        double _idxSw1;
        double _idxSw2;
        switch (row) {
            case 0: _idxSw0 = _self00; _idxSw1 = _self01; _idxSw2 = _self02; break;
            case 1: _idxSw0 = _self10; _idxSw1 = _self11; _idxSw2 = _self12; break;
            case 2: _idxSw0 = _self20; _idxSw1 = _self21; _idxSw2 = _self22; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + row);
        }
        dest.putDouble(destOffset + 0, _idxSw0);
        dest.putDouble(destOffset + 8, _idxSw1);
        dest.putDouble(destOffset + 16, _idxSw2);
        return dest;
    }

    public static java.nio.ByteBuffer getScale_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.getScale_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer getScale_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        dest.putDouble(destOffset + 0, Math.sqrt(Math.fma(_self20, _self20, Math.fma(_self00, _self00, _self10 * _self10))));
        dest.putDouble(destOffset + 8, Math.sqrt(Math.fma(_self21, _self21, Math.fma(_self01, _self01, _self11 * _self11))));
        dest.putDouble(destOffset + 16, Math.sqrt(Math.fma(_self22, _self22, Math.fma(_self02, _self02, _self12 * _self12))));
        return dest;
    }

    public static java.nio.ByteBuffer getTranslation_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.getTranslation_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer getTranslation_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        dest.putDouble(destOffset + 0, _self02);
        dest.putDouble(destOffset + 8, _self12);
        return dest;
    }

    public static java.nio.ByteBuffer getUnnormalizedRotation_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.getUnnormalizedRotation_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer getUnnormalizedRotation_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
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
            dest.putDouble(destOffset + 0, 0.5 * _t1 * _t18);
            dest.putDouble(destOffset + 8, 0.5 * _t7 * _t18);
            dest.putDouble(destOffset + 16, 0.5 * _t9 * _t18);
            dest.putDouble(destOffset + 24, 0.5 * Math.sqrt(_t14));
        } else {
            if (_self00 > _t2) {
                dest.putDouble(destOffset + 0, 0.5 * Math.sqrt(_t15));
                dest.putDouble(destOffset + 8, 0.5 * _t4 * _t21);
                dest.putDouble(destOffset + 16, 0.5 * _t6 * _t21);
                dest.putDouble(destOffset + 24, 0.5 * _t1 * _t21);
            } else {
                if (_self11 > _self22) {
                    dest.putDouble(destOffset + 0, 0.5 * _t4 * _t19);
                    dest.putDouble(destOffset + 8, 0.5 * Math.sqrt(_t16));
                    dest.putDouble(destOffset + 16, 0.5 * _t8 * _t19);
                    dest.putDouble(destOffset + 24, 0.5 * _t7 * _t19);
                } else {
                    dest.putDouble(destOffset + 0, 0.5 * _t6 * _t20);
                    dest.putDouble(destOffset + 8, 0.5 * _t8 * _t20);
                    dest.putDouble(destOffset + 16, 0.5 * Math.sqrt(_t17));
                    dest.putDouble(destOffset + 24, 0.5 * _t9 * _t20);
                }
            }
        }
        return dest;
    }

    public static java.nio.ByteBuffer cofactor_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.cofactor_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer cofactor_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        dest.putDouble(destOffset + 0, Math.fma(_self11, _self22, -(_self12 * _self21)));
        dest.putDouble(destOffset + 8, Math.fma(_self02, _self21, -(_self01 * _self22)));
        dest.putDouble(destOffset + 16, Math.fma(_self01, _self12, -(_self02 * _self11)));
        dest.putDouble(destOffset + 24, Math.fma(_self12, _self20, -(_self10 * _self22)));
        dest.putDouble(destOffset + 32, Math.fma(_self00, _self22, -(_self02 * _self20)));
        dest.putDouble(destOffset + 40, Math.fma(_self02, _self10, -(_self00 * _self12)));
        dest.putDouble(destOffset + 48, Math.fma(_self10, _self21, -(_self11 * _self20)));
        dest.putDouble(destOffset + 56, Math.fma(_self01, _self20, -(_self00 * _self21)));
        dest.putDouble(destOffset + 64, Math.fma(_self00, _self11, -(_self01 * _self10)));
        return dest;
    }

    public static double determinant_unsafe(java.nio.ByteBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        return Double3x3OpsKernelsAddress.determinant_unsafe(_srcBase);
    }

    public static double determinant_api(java.nio.ByteBuffer src, int srcOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        return Math.fma(_self02, Math.fma(_self10, _self21, -(_self11 * _self20)), Math.fma(_self00, Math.fma(_self11, _self22, -(_self12 * _self21)), -(_self01 * Math.fma(_self10, _self22, -(_self12 * _self20)))));
    }

    public static double frobeniusNorm_unsafe(java.nio.ByteBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        return Double3x3OpsKernelsAddress.frobeniusNorm_unsafe(_srcBase);
    }

    public static double frobeniusNorm_api(java.nio.ByteBuffer src, int srcOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        return Math.sqrt(Math.fma(_self00, _self00, _self01 * _self01) + Math.fma(_self02, _self02, _self10 * _self10) + (Math.fma(_self11, _self11, _self12 * _self12) + Math.fma(_self20, _self20, Math.fma(_self21, _self21, _self22 * _self22))));
    }

    public static java.nio.ByteBuffer invert_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.invert_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer invert_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        double _t6 = Math.fma(_self11, _self22, -(_self12 * _self21));
        double _t7 = Math.fma(_self10, _self21, -(_self11 * _self20));
        double _t12 = Math.fma(_self02, _t7, Math.fma(_self00, _t6, -(_self01 * Math.fma(_self10, _self22, -(_self12 * _self20)))));
        double _t12_inv = 1.0 / _t12;
        dest.putDouble(destOffset + 0, _t6 * _t12_inv);
        dest.putDouble(destOffset + 8, Math.fma(_self12, _self20, -(_self10 * _self22)) * _t12_inv);
        dest.putDouble(destOffset + 16, _t7 * _t12_inv);
        dest.putDouble(destOffset + 24, Math.fma(_self02, _self21, -(_self01 * _self22)) * _t12_inv);
        dest.putDouble(destOffset + 32, Math.fma(_self00, _self22, -(_self02 * _self20)) * _t12_inv);
        dest.putDouble(destOffset + 40, Math.fma(_self01, _self20, -(_self00 * _self21)) * _t12_inv);
        dest.putDouble(destOffset + 48, Math.fma(_self01, _self12, -(_self02 * _self11)) * _t12_inv);
        dest.putDouble(destOffset + 56, Math.fma(_self02, _self10, -(_self00 * _self12)) * _t12_inv);
        dest.putDouble(destOffset + 64, Math.fma(_self00, _self11, -(_self01 * _self10)) * _t12_inv);
        return dest;
    }

    public static java.nio.ByteBuffer invertProduct_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + otherOffset;
        Double3x3OpsKernelsAddress.invertProduct_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.ByteBuffer invertProduct_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        double _other00 = other.getDouble(otherOffset + 0);
        double _other10 = other.getDouble(otherOffset + 8);
        double _other20 = other.getDouble(otherOffset + 16);
        double _other01 = other.getDouble(otherOffset + 24);
        double _other11 = other.getDouble(otherOffset + 32);
        double _other21 = other.getDouble(otherOffset + 40);
        double _other02 = other.getDouble(otherOffset + 48);
        double _other12 = other.getDouble(otherOffset + 56);
        double _other22 = other.getDouble(otherOffset + 64);
        double _t18 = Math.fma(_other21, _self12, Math.fma(_other01, _self10, _other11 * _self11));
        double _t19 = Math.fma(_other22, _self22, Math.fma(_other02, _self20, _other12 * _self21));
        double _t20 = Math.fma(_other21, _self22, Math.fma(_other01, _self20, _other11 * _self21));
        double _t21 = Math.fma(_other22, _self12, Math.fma(_other02, _self10, _other12 * _self11));
        double _t22 = Math.fma(_other22, _self02, Math.fma(_other02, _self00, _other12 * _self01));
        double _t23 = Math.fma(_other20, _self12, Math.fma(_other00, _self10, _other10 * _self11));
        double _t24 = Math.fma(_other20, _self22, Math.fma(_other00, _self20, _other10 * _self21));
        double _t25 = Math.fma(_other20, _self02, Math.fma(_other00, _self00, _other10 * _self01));
        double _t26 = Math.fma(_other21, _self02, Math.fma(_other01, _self00, _other11 * _self01));
        double _t33 = Math.fma(_t18, _t19, -(_t20 * _t21));
        double _t34 = Math.fma(_t23, _t20, -(_t24 * _t18));
        double _t39 = Math.fma(_t22, _t34, Math.fma(_t25, _t33, -(_t26 * Math.fma(_t23, _t19, -(_t24 * _t21)))));
        double _t39_inv = 1.0 / _t39;
        dest.putDouble(destOffset + 0, _t33 * _t39_inv);
        dest.putDouble(destOffset + 8, Math.fma(_t24, _t21, -(_t23 * _t19)) * _t39_inv);
        dest.putDouble(destOffset + 16, _t34 * _t39_inv);
        dest.putDouble(destOffset + 24, Math.fma(_t20, _t22, -(_t26 * _t19)) * _t39_inv);
        dest.putDouble(destOffset + 32, Math.fma(_t25, _t19, -(_t24 * _t22)) * _t39_inv);
        dest.putDouble(destOffset + 40, Math.fma(_t24, _t26, -(_t25 * _t20)) * _t39_inv);
        dest.putDouble(destOffset + 48, Math.fma(_t26, _t21, -(_t18 * _t22)) * _t39_inv);
        dest.putDouble(destOffset + 56, Math.fma(_t23, _t22, -(_t25 * _t21)) * _t39_inv);
        dest.putDouble(destOffset + 64, Math.fma(_t25, _t18, -(_t23 * _t26)) * _t39_inv);
        return dest;
    }

    public static java.nio.ByteBuffer normal_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.normal_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer normal_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        double _t6 = Math.fma(_self11, _self22, -(_self12 * _self21));
        double _t7 = Math.fma(_self10, _self21, -(_self11 * _self20));
        double _t12 = Math.fma(_self02, _t7, Math.fma(_self00, _t6, -(_self01 * Math.fma(_self10, _self22, -(_self12 * _self20)))));
        double _t12_inv = 1.0 / _t12;
        dest.putDouble(destOffset + 0, _t6 * _t12_inv);
        dest.putDouble(destOffset + 8, Math.fma(_self02, _self21, -(_self01 * _self22)) * _t12_inv);
        dest.putDouble(destOffset + 16, Math.fma(_self01, _self12, -(_self02 * _self11)) * _t12_inv);
        dest.putDouble(destOffset + 24, Math.fma(_self12, _self20, -(_self10 * _self22)) * _t12_inv);
        dest.putDouble(destOffset + 32, Math.fma(_self00, _self22, -(_self02 * _self20)) * _t12_inv);
        dest.putDouble(destOffset + 40, Math.fma(_self02, _self10, -(_self00 * _self12)) * _t12_inv);
        dest.putDouble(destOffset + 48, _t7 * _t12_inv);
        dest.putDouble(destOffset + 56, Math.fma(_self01, _self20, -(_self00 * _self21)) * _t12_inv);
        dest.putDouble(destOffset + 64, Math.fma(_self00, _self11, -(_self01 * _self10)) * _t12_inv);
        return dest;
    }

    public static double trace_unsafe(java.nio.ByteBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        return Double3x3OpsKernelsAddress.trace_unsafe(_srcBase);
    }

    public static double trace_api(java.nio.ByteBuffer src, int srcOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self22 = src.getDouble(srcOffset + 64);
        return _self22 + (_self00 + _self11);
    }

    public static java.nio.ByteBuffer transpose_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.transpose_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer transpose_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        dest.putDouble(destOffset + 0, _self00);
        dest.putDouble(destOffset + 8, _self01);
        dest.putDouble(destOffset + 16, _self02);
        dest.putDouble(destOffset + 24, _self10);
        dest.putDouble(destOffset + 32, _self11);
        dest.putDouble(destOffset + 40, _self12);
        dest.putDouble(destOffset + 48, _self20);
        dest.putDouble(destOffset + 56, _self21);
        dest.putDouble(destOffset + 64, _self22);
        return dest;
    }

    public static java.nio.ByteBuffer add_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + otherOffset;
        Double3x3OpsKernelsAddress.add_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.ByteBuffer add_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        for (int _i = 0; _i < 9; _i++) {
            double _eself = src.getDouble(srcOffset + _i * 8);
            double _eother = other.getDouble(otherOffset + _i * 8);
            dest.putDouble(destOffset + _i * 8, _eother + _eself);
        }
        return dest;
    }

    public static java.nio.ByteBuffer negate_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.negate_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer negate_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        for (int _i = 0; _i < 9; _i++) {
            double _eself = src.getDouble(srcOffset + _i * 8);
            dest.putDouble(destOffset + _i * 8, -_eself);
        }
        return dest;
    }

    public static java.nio.ByteBuffer sub_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + otherOffset;
        Double3x3OpsKernelsAddress.sub_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.ByteBuffer sub_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        for (int _i = 0; _i < 9; _i++) {
            double _eself = src.getDouble(srcOffset + _i * 8);
            double _eother = other.getDouble(otherOffset + _i * 8);
            dest.putDouble(destOffset + _i * 8, _eself - _eother);
        }
        return dest;
    }

    public static java.nio.ByteBuffer set_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + vOffset;
        Double3x3OpsKernelsAddress.set_unsafe(_destBase, _vBase);
        return dest;
    }

    public static java.nio.ByteBuffer set_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer v, int vOffset) {
        for (int _i = 0; _i < 9; _i++) {
            double _ev = v.getDouble(vOffset + _i * 8);
            dest.putDouble(destOffset + _i * 8, _ev);
        }
        return dest;
    }

    public static java.nio.ByteBuffer setMat2x2_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer m, int mOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _mBase = UnsafeOpsHolder.U.getLong(m, UnsafeCopy.BB_ADDRESS_OFFSET) + mOffset;
        Double3x3OpsKernelsAddress.setMat2x2_unsafe(_destBase, _mBase);
        return dest;
    }

    public static java.nio.ByteBuffer setMat2x2_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer m, int mOffset) {
        double _m00 = m.getDouble(mOffset + 0);
        double _m10 = m.getDouble(mOffset + 8);
        double _m01 = m.getDouble(mOffset + 16);
        double _m11 = m.getDouble(mOffset + 24);
        dest.putDouble(destOffset + 0, _m00);
        dest.putDouble(destOffset + 8, _m10);
        dest.putDouble(destOffset + 16, 0.0);
        dest.putDouble(destOffset + 24, _m01);
        dest.putDouble(destOffset + 32, _m11);
        dest.putDouble(destOffset + 40, 0.0);
        dest.putDouble(destOffset + 48, 0.0);
        dest.putDouble(destOffset + 56, 0.0);
        dest.putDouble(destOffset + 64, 1.0);
        return dest;
    }

    public static java.nio.ByteBuffer setMat2x3_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer m, int mOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _mBase = UnsafeOpsHolder.U.getLong(m, UnsafeCopy.BB_ADDRESS_OFFSET) + mOffset;
        Double3x3OpsKernelsAddress.setMat2x3_unsafe(_destBase, _mBase);
        return dest;
    }

    public static java.nio.ByteBuffer setMat2x3_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer m, int mOffset) {
        double _m00 = m.getDouble(mOffset + 0);
        double _m10 = m.getDouble(mOffset + 8);
        double _m01 = m.getDouble(mOffset + 16);
        double _m11 = m.getDouble(mOffset + 24);
        double _m02 = m.getDouble(mOffset + 32);
        double _m12 = m.getDouble(mOffset + 40);
        dest.putDouble(destOffset + 0, _m00);
        dest.putDouble(destOffset + 8, _m10);
        dest.putDouble(destOffset + 16, 0.0);
        dest.putDouble(destOffset + 24, _m01);
        dest.putDouble(destOffset + 32, _m11);
        dest.putDouble(destOffset + 40, 0.0);
        dest.putDouble(destOffset + 48, _m02);
        dest.putDouble(destOffset + 56, _m12);
        dest.putDouble(destOffset + 64, 1.0);
        return dest;
    }

    public static java.nio.ByteBuffer setMat3x4_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer m, int mOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _mBase = UnsafeOpsHolder.U.getLong(m, UnsafeCopy.BB_ADDRESS_OFFSET) + mOffset;
        Double3x3OpsKernelsAddress.setMat3x4_unsafe(_destBase, _mBase);
        return dest;
    }

    public static java.nio.ByteBuffer setMat3x4_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer m, int mOffset) {
        double _m00 = m.getDouble(mOffset + 0);
        double _m01 = m.getDouble(mOffset + 8);
        double _m02 = m.getDouble(mOffset + 16);
        double _m10 = m.getDouble(mOffset + 32);
        double _m11 = m.getDouble(mOffset + 40);
        double _m12 = m.getDouble(mOffset + 48);
        double _m20 = m.getDouble(mOffset + 64);
        double _m21 = m.getDouble(mOffset + 72);
        double _m22 = m.getDouble(mOffset + 80);
        dest.putDouble(destOffset + 0, _m00);
        dest.putDouble(destOffset + 8, _m10);
        dest.putDouble(destOffset + 16, _m20);
        dest.putDouble(destOffset + 24, _m01);
        dest.putDouble(destOffset + 32, _m11);
        dest.putDouble(destOffset + 40, _m21);
        dest.putDouble(destOffset + 48, _m02);
        dest.putDouble(destOffset + 56, _m12);
        dest.putDouble(destOffset + 64, _m22);
        return dest;
    }

    public static java.nio.ByteBuffer setMat4x4_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer m, int mOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _mBase = UnsafeOpsHolder.U.getLong(m, UnsafeCopy.BB_ADDRESS_OFFSET) + mOffset;
        Double3x3OpsKernelsAddress.setMat4x4_unsafe(_destBase, _mBase);
        return dest;
    }

    public static java.nio.ByteBuffer setMat4x4_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer m, int mOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 3;
            int _lom = _l * 4;
            double _em0 = m.getDouble(mOffset + _lom * 8);
            double _em1 = m.getDouble(mOffset + (_lom + 1) * 8);
            double _em2 = m.getDouble(mOffset + (_lom + 2) * 8);
            dest.putDouble(destOffset + _lo * 8, _em0);
            dest.putDouble(destOffset + (_lo + 1) * 8, _em1);
            dest.putDouble(destOffset + (_lo + 2) * 8, _em2);
        }
        return dest;
    }

    public static java.nio.ByteBuffer withTranslation_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double tX, double tY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.withTranslation_unsafe(_destBase, _srcBase, tX, tY);
        return dest;
    }

    public static java.nio.ByteBuffer withTranslation_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double tX, double tY) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self22 = src.getDouble(srcOffset + 64);
        dest.putDouble(destOffset + 0, _self00);
        dest.putDouble(destOffset + 8, _self10);
        dest.putDouble(destOffset + 16, _self20);
        dest.putDouble(destOffset + 24, _self01);
        dest.putDouble(destOffset + 32, _self11);
        dest.putDouble(destOffset + 40, _self21);
        dest.putDouble(destOffset + 48, tX);
        dest.putDouble(destOffset + 56, tY);
        dest.putDouble(destOffset + 64, _self22);
        return dest;
    }

    public static java.nio.ByteBuffer withTranslation_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer t, int tOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _tBase = UnsafeOpsHolder.U.getLong(t, UnsafeCopy.BB_ADDRESS_OFFSET) + tOffset;
        Double3x3OpsKernelsAddress.withTranslation_unsafe(_destBase, _srcBase, _tBase);
        return dest;
    }

    public static java.nio.ByteBuffer withTranslation_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer t, int tOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self22 = src.getDouble(srcOffset + 64);
        double _tx = t.getDouble(tOffset + 0);
        double _ty = t.getDouble(tOffset + 8);
        dest.putDouble(destOffset + 0, _self00);
        dest.putDouble(destOffset + 8, _self10);
        dest.putDouble(destOffset + 16, _self20);
        dest.putDouble(destOffset + 24, _self01);
        dest.putDouble(destOffset + 32, _self11);
        dest.putDouble(destOffset + 40, _self21);
        dest.putDouble(destOffset + 48, _tx);
        dest.putDouble(destOffset + 56, _ty);
        dest.putDouble(destOffset + 64, _self22);
        return dest;
    }

    public static java.nio.ByteBuffer makeFromRigid_unsafe(java.nio.ByteBuffer dest, int destOffset, double rTX, double rTY, double rTZ, double rRX, double rRY, double rRZ, double rRW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Double3x3OpsKernelsAddress.makeFromRigid_unsafe(_destBase, rTX, rTY, rTZ, rRX, rRY, rRZ, rRW);
        return dest;
    }

    public static java.nio.ByteBuffer makeFromRigid_api(java.nio.ByteBuffer dest, int destOffset, double rTX, double rTY, double rTZ, double rRX, double rRY, double rRZ, double rRW) {
        double _t0 = rRZ * rRZ;
        double _t1 = rRZ * rRW;
        double _t2 = rRY * rRW;
        dest.putDouble(destOffset + 0, Math.fma(-2.0, Math.fma(rRY, rRY, _t0), 1.0));
        dest.putDouble(destOffset + 8, 2.0 * Math.fma(rRX, rRY, _t1));
        dest.putDouble(destOffset + 16, 2.0 * Math.fma(rRX, rRZ, -_t2));
        dest.putDouble(destOffset + 24, 2.0 * Math.fma(rRX, rRY, -_t1));
        dest.putDouble(destOffset + 32, Math.fma(-2.0, Math.fma(rRX, rRX, _t0), 1.0));
        dest.putDouble(destOffset + 40, 2.0 * Math.fma(rRX, rRW, rRY * rRZ));
        dest.putDouble(destOffset + 48, 2.0 * Math.fma(rRX, rRZ, _t2));
        dest.putDouble(destOffset + 56, 2.0 * Math.fma(rRY, rRZ, -(rRX * rRW)));
        dest.putDouble(destOffset + 64, Math.fma(-2.0, Math.fma(rRX, rRX, rRY * rRY), 1.0));
        return dest;
    }

    public static java.nio.ByteBuffer makeFromTransform_unsafe(java.nio.ByteBuffer dest, int destOffset, double tTX, double tTY, double tTZ, double tRX, double tRY, double tRZ, double tRW, double tSX, double tSY, double tSZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Double3x3OpsKernelsAddress.makeFromTransform_unsafe(_destBase, tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ);
        return dest;
    }

    public static java.nio.ByteBuffer makeFromTransform_api(java.nio.ByteBuffer dest, int destOffset, double tTX, double tTY, double tTZ, double tRX, double tRY, double tRZ, double tRW, double tSX, double tSY, double tSZ) {
        double _t0 = tRZ * tRZ;
        double _t1 = tRZ * tRW;
        double _t2 = tRY * tRW;
        dest.putDouble(destOffset + 0, tSX * Math.fma(-2.0, Math.fma(tRY, tRY, _t0), 1.0));
        dest.putDouble(destOffset + 8, tSX * 2.0 * Math.fma(tRX, tRY, _t1));
        dest.putDouble(destOffset + 16, tSX * 2.0 * Math.fma(tRX, tRZ, -_t2));
        dest.putDouble(destOffset + 24, tSY * 2.0 * Math.fma(tRX, tRY, -_t1));
        dest.putDouble(destOffset + 32, tSY * Math.fma(-2.0, Math.fma(tRX, tRX, _t0), 1.0));
        dest.putDouble(destOffset + 40, tSY * 2.0 * Math.fma(tRX, tRW, tRY * tRZ));
        dest.putDouble(destOffset + 48, tSZ * 2.0 * Math.fma(tRX, tRZ, _t2));
        dest.putDouble(destOffset + 56, tSZ * 2.0 * Math.fma(tRY, tRZ, -(tRX * tRW)));
        dest.putDouble(destOffset + 64, tSZ * Math.fma(-2.0, Math.fma(tRX, tRX, tRY * tRY), 1.0));
        return dest;
    }

    public static java.nio.ByteBuffer to2x2_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.to2x2_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer to2x2_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        dest.putDouble(destOffset + 0, _self00);
        dest.putDouble(destOffset + 8, _self10);
        dest.putDouble(destOffset + 16, _self01);
        dest.putDouble(destOffset + 24, _self11);
        return dest;
    }

    public static java.nio.ByteBuffer to2x3_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.to2x3_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer to2x3_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 2;
            int _loself = _l * 3;
            double _eself0 = src.getDouble(srcOffset + _loself * 8);
            double _eself1 = src.getDouble(srcOffset + (_loself + 1) * 8);
            dest.putDouble(destOffset + _lo * 8, _eself0);
            dest.putDouble(destOffset + (_lo + 1) * 8, _eself1);
        }
        return dest;
    }

    public static java.nio.ByteBuffer to3x4_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.to3x4_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer to3x4_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        dest.putDouble(destOffset + 0, _self00);
        dest.putDouble(destOffset + 8, _self01);
        dest.putDouble(destOffset + 16, _self02);
        dest.putDouble(destOffset + 24, 0.0);
        dest.putDouble(destOffset + 32, _self10);
        dest.putDouble(destOffset + 40, _self11);
        dest.putDouble(destOffset + 48, _self12);
        dest.putDouble(destOffset + 56, 0.0);
        dest.putDouble(destOffset + 64, _self20);
        dest.putDouble(destOffset + 72, _self21);
        dest.putDouble(destOffset + 80, _self22);
        dest.putDouble(destOffset + 88, 0.0);
        return dest;
    }

    public static java.nio.ByteBuffer to4x4_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.to4x4_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer to4x4_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        dest.putDouble(destOffset + 0, _self00);
        dest.putDouble(destOffset + 8, _self10);
        dest.putDouble(destOffset + 16, _self20);
        dest.putDouble(destOffset + 24, 0.0);
        dest.putDouble(destOffset + 32, _self01);
        dest.putDouble(destOffset + 40, _self11);
        dest.putDouble(destOffset + 48, _self21);
        dest.putDouble(destOffset + 56, 0.0);
        dest.putDouble(destOffset + 64, _self02);
        dest.putDouble(destOffset + 72, _self12);
        dest.putDouble(destOffset + 80, _self22);
        dest.putDouble(destOffset + 88, 0.0);
        dest.putDouble(destOffset + 96, 0.0);
        dest.putDouble(destOffset + 104, 0.0);
        dest.putDouble(destOffset + 112, 0.0);
        dest.putDouble(destOffset + 120, 1.0);
        return dest;
    }

    public static java.nio.ByteBuffer toDualQuat_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.toDualQuat_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer toDualQuat_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        double _t1 = 1.0 - _self00;
        double _t3 = _self21 - _self12;
        double _t4 = Math.max(_self11, _self22);
        double _t5 = _self01 + _self10;
        double _t6 = _self02 + _self20;
        double _t7 = _self02 - _self20;
        double _t8 = _self12 + _self21;
        double _t9 = _self10 - _self01;
        double _t13 = _self22 + (_self00 + _self11);
        double _t14 = 1.0 + _t13;
        double _t15 = _self00 + (1.0 - _self11 - _self22);
        double _t16 = _self11 + (_t1 - _self22);
        double _t17 = _self22 + (_t1 - _self11);
        double _t18 = (1.0 / Math.sqrt(_t14));
        double _t19 = (1.0 / Math.sqrt(_t16));
        double _t20 = (1.0 / Math.sqrt(_t17));
        double _t21 = (1.0 / Math.sqrt(_t15));
        if (_t13 > 0.0) {
            dest.putDouble(destOffset + 0, 0.5 * _t3 * _t18);
            dest.putDouble(destOffset + 8, 0.5 * _t7 * _t18);
            dest.putDouble(destOffset + 16, 0.5 * _t9 * _t18);
            dest.putDouble(destOffset + 24, 0.5 * Math.sqrt(_t14));
        } else {
            if (_self00 > _t4) {
                dest.putDouble(destOffset + 0, 0.5 * Math.sqrt(_t15));
                dest.putDouble(destOffset + 8, 0.5 * _t5 * _t21);
                dest.putDouble(destOffset + 16, 0.5 * _t6 * _t21);
                dest.putDouble(destOffset + 24, 0.5 * _t3 * _t21);
            } else {
                if (_self11 > _self22) {
                    dest.putDouble(destOffset + 0, 0.5 * _t5 * _t19);
                    dest.putDouble(destOffset + 8, 0.5 * Math.sqrt(_t16));
                    dest.putDouble(destOffset + 16, 0.5 * _t8 * _t19);
                    dest.putDouble(destOffset + 24, 0.5 * _t7 * _t19);
                } else {
                    dest.putDouble(destOffset + 0, 0.5 * _t6 * _t20);
                    dest.putDouble(destOffset + 8, 0.5 * _t8 * _t20);
                    dest.putDouble(destOffset + 16, 0.5 * Math.sqrt(_t17));
                    dest.putDouble(destOffset + 24, 0.5 * _t9 * _t20);
                }
            }
        }
        dest.putDouble(destOffset + 32, 0.0);
        dest.putDouble(destOffset + 40, 0.0);
        dest.putDouble(destOffset + 48, 0.0);
        dest.putDouble(destOffset + 56, 0.0);
        return dest;
    }

    public static java.nio.ByteBuffer toRigid_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.toRigid_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer toRigid_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
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
            dest.putDouble(destOffset + 24, 0.5 * _t32 * _t61);
            dest.putDouble(destOffset + 32, 0.5 * _t53 * _t61);
            dest.putDouble(destOffset + 40, 0.5 * _t54 * _t61);
            dest.putDouble(destOffset + 48, 0.5 * Math.sqrt(_t60));
        } else {
            if (_t44 > _t33) {
                dest.putDouble(destOffset + 24, 0.5 * Math.sqrt(_t64));
                dest.putDouble(destOffset + 32, 0.5 * _t51 * _t67);
                dest.putDouble(destOffset + 40, 0.5 * _t52 * _t67);
                dest.putDouble(destOffset + 48, 0.5 * _t32 * _t67);
            } else {
                if (_t21 > _t16) {
                    dest.putDouble(destOffset + 24, 0.5 * _t51 * _t65);
                    dest.putDouble(destOffset + 32, 0.5 * Math.sqrt(_t62));
                    dest.putDouble(destOffset + 40, 0.5 * _t28 * _t65);
                    dest.putDouble(destOffset + 48, 0.5 * _t53 * _t65);
                } else {
                    dest.putDouble(destOffset + 24, 0.5 * _t52 * _t66);
                    dest.putDouble(destOffset + 32, 0.5 * _t28 * _t66);
                    dest.putDouble(destOffset + 40, 0.5 * Math.sqrt(_t63));
                    dest.putDouble(destOffset + 48, 0.5 * _t54 * _t66);
                }
            }
        }
        dest.putDouble(destOffset + 0, 0.0);
        dest.putDouble(destOffset + 8, 0.0);
        dest.putDouble(destOffset + 16, 0.0);
        return dest;
    }

    public static java.nio.ByteBuffer toTransform_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.toTransform_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer toTransform_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
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
        dest.putDouble(destOffset + 0, 0.0);
        dest.putDouble(destOffset + 8, 0.0);
        dest.putDouble(destOffset + 16, 0.0);
        dest.putDouble(destOffset + 24, _t60 > 0.0 ? 0.5 * _t33 * _t62 : _t45 > _t34 ? 0.5 * Math.sqrt(_t65) : _t22 > _t17 ? 0.5 * _t52 * _t66 : 0.5 * _t53 * _t67);
        dest.putDouble(destOffset + 32, _t60 > 0.0 ? 0.5 * _t54 * _t62 : _t45 > _t34 ? 0.5 * _t52 * _t68 : _t22 > _t17 ? 0.5 * Math.sqrt(_t63) : 0.5 * _t29 * _t67);
        dest.putDouble(destOffset + 40, _t60 > 0.0 ? 0.5 * _t55 * _t62 : _t45 > _t34 ? 0.5 * _t53 * _t68 : _t22 > _t17 ? 0.5 * _t29 * _t66 : 0.5 * Math.sqrt(_t64));
        dest.putDouble(destOffset + 48, _t60 > 0.0 ? 0.5 * Math.sqrt(_t61) : _t45 > _t34 ? 0.5 * _t33 * _t68 : _t22 > _t17 ? 0.5 * _t54 * _t66 : 0.5 * _t55 * _t67);
        dest.putDouble(destOffset + 56, _t44 < 0.0 ? -_t15 : _t15);
        dest.putDouble(destOffset + 64, Math.sqrt(_t9));
        dest.putDouble(destOffset + 72, Math.sqrt(_t10));
        return dest;
    }

    public static java.nio.ByteBuffer decomposeRotation_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.decomposeRotation_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer decomposeRotation_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
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
            dest.putDouble(destOffset + 0, 0.5 * _t60 * _t90);
            dest.putDouble(destOffset + 8, 0.5 * _t81 * _t90);
            dest.putDouble(destOffset + 16, 0.5 * _t78 * _t90);
            dest.putDouble(destOffset + 24, 0.5 * Math.sqrt(_t86));
        } else {
            if (_t73 > _t61) {
                dest.putDouble(destOffset + 0, 0.5 * Math.sqrt(_t87));
                dest.putDouble(destOffset + 8, 0.5 * _t77 * _t93);
                dest.putDouble(destOffset + 16, 0.5 * _t80 * _t93);
                dest.putDouble(destOffset + 24, 0.5 * _t60 * _t93);
            } else {
                if (_t36 > _t56) {
                    dest.putDouble(destOffset + 0, 0.5 * _t77 * _t91);
                    dest.putDouble(destOffset + 8, 0.5 * Math.sqrt(_t88));
                    dest.putDouble(destOffset + 16, 0.5 * _t63 * _t91);
                    dest.putDouble(destOffset + 24, 0.5 * _t81 * _t91);
                } else {
                    dest.putDouble(destOffset + 0, 0.5 * _t80 * _t92);
                    dest.putDouble(destOffset + 8, 0.5 * _t63 * _t92);
                    dest.putDouble(destOffset + 16, 0.5 * Math.sqrt(_t89));
                    dest.putDouble(destOffset + 24, 0.5 * _t78 * _t92);
                }
            }
        }
        return dest;
    }

    public static java.nio.ByteBuffer decomposeScale_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.decomposeScale_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer decomposeScale_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
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
        dest.putDouble(destOffset + 0, Math.fma(Math.fma(_t32, _t52, -(_t34 * _t53)), _t8, Math.fma(Math.fma(_t34, _t54, -(_t33 * _t52)), _t9, Math.fma(_t33, _t53, -(_t32 * _t54)) * _t10)) < 0.0 ? -_t4 : _t4);
        dest.putDouble(destOffset + 8, Math.sqrt(_t27));
        dest.putDouble(destOffset + 16, Math.sqrt(_t47));
        return dest;
    }

    public static java.nio.ByteBuffer decomposeSkew_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.decomposeSkew_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer decomposeSkew_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
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
            dest.putDouble(destOffset + 8, -_t49);
            dest.putDouble(destOffset + 16, -_t28);
        } else {
            dest.putDouble(destOffset + 8, _t49);
            dest.putDouble(destOffset + 16, _t28);
        }
        dest.putDouble(destOffset + 0, _t37 * _t48);
        return dest;
    }

    public static java.nio.ByteBuffer makeIdentity_unsafe(java.nio.ByteBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Double3x3OpsKernelsAddress.makeIdentity_unsafe(_destBase);
        return dest;
    }

    public static java.nio.ByteBuffer makeIdentity_api(java.nio.ByteBuffer dest, int destOffset) {
        dest.putDouble(destOffset + 0, 1.0);
        dest.putDouble(destOffset + 8, 0.0);
        dest.putDouble(destOffset + 16, 0.0);
        dest.putDouble(destOffset + 24, 0.0);
        dest.putDouble(destOffset + 32, 1.0);
        dest.putDouble(destOffset + 40, 0.0);
        dest.putDouble(destOffset + 48, 0.0);
        dest.putDouble(destOffset + 56, 0.0);
        dest.putDouble(destOffset + 64, 1.0);
        return dest;
    }

    public static java.nio.ByteBuffer lerp_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + otherOffset;
        Double3x3OpsKernelsAddress.lerp_unsafe(_destBase, _srcBase, _otherBase, t);
        return dest;
    }

    public static java.nio.ByteBuffer lerp_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset, double t) {
        for (int _i = 0; _i < 9; _i++) {
            double _eself = src.getDouble(srcOffset + _i * 8);
            double _eother = other.getDouble(otherOffset + _i * 8);
            dest.putDouble(destOffset + _i * 8, Math.fma(t, _eother - _eself, _eself));
        }
        return dest;
    }

    public static java.nio.ByteBuffer mul_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer right, int rightOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _rightBase = UnsafeOpsHolder.U.getLong(right, UnsafeCopy.BB_ADDRESS_OFFSET) + rightOffset;
        Double3x3OpsKernelsAddress.mul_unsafe(_destBase, _srcBase, _rightBase);
        return dest;
    }

    public static java.nio.ByteBuffer mul_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer right, int rightOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 3;
            double _eright0 = right.getDouble(rightOffset + _lo * 8);
            double _eright1 = right.getDouble(rightOffset + (_lo + 1) * 8);
            double _eright2 = right.getDouble(rightOffset + (_lo + 2) * 8);
            dest.putDouble(destOffset + _lo * 8, Math.fma(_eright2, _self02, Math.fma(_eright0, _self00, _eright1 * _self01)));
            dest.putDouble(destOffset + (_lo + 1) * 8, Math.fma(_eright2, _self12, Math.fma(_eright0, _self10, _eright1 * _self11)));
            dest.putDouble(destOffset + (_lo + 2) * 8, Math.fma(_eright2, _self22, Math.fma(_eright0, _self20, _eright1 * _self21)));
        }
        return dest;
    }

    public static java.nio.ByteBuffer mulMat2x2_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer right, int rightOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _rightBase = UnsafeOpsHolder.U.getLong(right, UnsafeCopy.BB_ADDRESS_OFFSET) + rightOffset;
        Double3x3OpsKernelsAddress.mulMat2x2_unsafe(_destBase, _srcBase, _rightBase);
        return dest;
    }

    public static java.nio.ByteBuffer mulMat2x2_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer right, int rightOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        double _right00 = right.getDouble(rightOffset + 0);
        double _right10 = right.getDouble(rightOffset + 8);
        double _right01 = right.getDouble(rightOffset + 16);
        double _right11 = right.getDouble(rightOffset + 24);
        dest.putDouble(destOffset + 0, Math.fma(_right00, _self00, _right10 * _self01));
        dest.putDouble(destOffset + 8, Math.fma(_right00, _self10, _right10 * _self11));
        dest.putDouble(destOffset + 16, Math.fma(_right00, _self20, _right10 * _self21));
        dest.putDouble(destOffset + 24, Math.fma(_right01, _self00, _right11 * _self01));
        dest.putDouble(destOffset + 32, Math.fma(_right01, _self10, _right11 * _self11));
        dest.putDouble(destOffset + 40, Math.fma(_right01, _self20, _right11 * _self21));
        dest.putDouble(destOffset + 48, _self02);
        dest.putDouble(destOffset + 56, _self12);
        dest.putDouble(destOffset + 64, _self22);
        return dest;
    }

    public static java.nio.ByteBuffer mulMat2x3_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer right, int rightOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _rightBase = UnsafeOpsHolder.U.getLong(right, UnsafeCopy.BB_ADDRESS_OFFSET) + rightOffset;
        Double3x3OpsKernelsAddress.mulMat2x3_unsafe(_destBase, _srcBase, _rightBase);
        return dest;
    }

    public static java.nio.ByteBuffer mulMat2x3_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer right, int rightOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        double _right00 = right.getDouble(rightOffset + 0);
        double _right10 = right.getDouble(rightOffset + 8);
        double _right01 = right.getDouble(rightOffset + 16);
        double _right11 = right.getDouble(rightOffset + 24);
        double _right02 = right.getDouble(rightOffset + 32);
        double _right12 = right.getDouble(rightOffset + 40);
        dest.putDouble(destOffset + 0, Math.fma(_right00, _self00, _right10 * _self01));
        dest.putDouble(destOffset + 8, Math.fma(_right00, _self10, _right10 * _self11));
        dest.putDouble(destOffset + 16, Math.fma(_right00, _self20, _right10 * _self21));
        dest.putDouble(destOffset + 24, Math.fma(_right01, _self00, _right11 * _self01));
        dest.putDouble(destOffset + 32, Math.fma(_right01, _self10, _right11 * _self11));
        dest.putDouble(destOffset + 40, Math.fma(_right01, _self20, _right11 * _self21));
        dest.putDouble(destOffset + 48, Math.fma(_right02, _self00, Math.fma(_right12, _self01, _self02)));
        dest.putDouble(destOffset + 56, Math.fma(_right02, _self10, Math.fma(_right12, _self11, _self12)));
        dest.putDouble(destOffset + 64, Math.fma(_right02, _self20, Math.fma(_right12, _self21, _self22)));
        return dest;
    }

    public static java.nio.ByteBuffer preMul_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + otherOffset;
        Double3x3OpsKernelsAddress.preMul_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.ByteBuffer preMul_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        double _other00 = other.getDouble(otherOffset + 0);
        double _other10 = other.getDouble(otherOffset + 8);
        double _other20 = other.getDouble(otherOffset + 16);
        double _other01 = other.getDouble(otherOffset + 24);
        double _other11 = other.getDouble(otherOffset + 32);
        double _other21 = other.getDouble(otherOffset + 40);
        double _other02 = other.getDouble(otherOffset + 48);
        double _other12 = other.getDouble(otherOffset + 56);
        double _other22 = other.getDouble(otherOffset + 64);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 3;
            double _eself0 = src.getDouble(srcOffset + _lo * 8);
            double _eself1 = src.getDouble(srcOffset + (_lo + 1) * 8);
            double _eself2 = src.getDouble(srcOffset + (_lo + 2) * 8);
            dest.putDouble(destOffset + _lo * 8, Math.fma(_other02, _eself2, Math.fma(_other00, _eself0, _other01 * _eself1)));
            dest.putDouble(destOffset + (_lo + 1) * 8, Math.fma(_other12, _eself2, Math.fma(_other10, _eself0, _other11 * _eself1)));
            dest.putDouble(destOffset + (_lo + 2) * 8, Math.fma(_other22, _eself2, Math.fma(_other20, _eself0, _other21 * _eself1)));
        }
        return dest;
    }

    public static java.nio.ByteBuffer preMulMat2x2_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + otherOffset;
        Double3x3OpsKernelsAddress.preMulMat2x2_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.ByteBuffer preMulMat2x2_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        double _other00 = other.getDouble(otherOffset + 0);
        double _other10 = other.getDouble(otherOffset + 8);
        double _other01 = other.getDouble(otherOffset + 16);
        double _other11 = other.getDouble(otherOffset + 24);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 3;
            double _eself0 = src.getDouble(srcOffset + _lo * 8);
            double _eself1 = src.getDouble(srcOffset + (_lo + 1) * 8);
            double _eself2 = src.getDouble(srcOffset + (_lo + 2) * 8);
            dest.putDouble(destOffset + _lo * 8, Math.fma(_other00, _eself0, _other01 * _eself1));
            dest.putDouble(destOffset + (_lo + 1) * 8, Math.fma(_other10, _eself0, _other11 * _eself1));
            dest.putDouble(destOffset + (_lo + 2) * 8, _eself2);
        }
        return dest;
    }

    public static java.nio.ByteBuffer preMulMat2x3_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + otherOffset;
        Double3x3OpsKernelsAddress.preMulMat2x3_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.ByteBuffer preMulMat2x3_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        double _other00 = other.getDouble(otherOffset + 0);
        double _other10 = other.getDouble(otherOffset + 8);
        double _other01 = other.getDouble(otherOffset + 16);
        double _other11 = other.getDouble(otherOffset + 24);
        double _other02 = other.getDouble(otherOffset + 32);
        double _other12 = other.getDouble(otherOffset + 40);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 3;
            double _eself0 = src.getDouble(srcOffset + _lo * 8);
            double _eself1 = src.getDouble(srcOffset + (_lo + 1) * 8);
            double _eself2 = src.getDouble(srcOffset + (_lo + 2) * 8);
            dest.putDouble(destOffset + _lo * 8, Math.fma(_other02, _eself2, Math.fma(_other00, _eself0, _other01 * _eself1)));
            dest.putDouble(destOffset + (_lo + 1) * 8, Math.fma(_other12, _eself2, Math.fma(_other10, _eself0, _other11 * _eself1)));
            dest.putDouble(destOffset + (_lo + 2) * 8, _eself2);
        }
        return dest;
    }

    public static java.nio.ByteBuffer makeOuterProduct_unsafe(java.nio.ByteBuffer dest, int destOffset, double colX, double colY, double colZ, double rowX, double rowY, double rowZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Double3x3OpsKernelsAddress.makeOuterProduct_unsafe(_destBase, colX, colY, colZ, rowX, rowY, rowZ);
        return dest;
    }

    public static java.nio.ByteBuffer makeOuterProduct_api(java.nio.ByteBuffer dest, int destOffset, double colX, double colY, double colZ, double rowX, double rowY, double rowZ) {
        dest.putDouble(destOffset + 0, colX * rowX);
        dest.putDouble(destOffset + 8, colY * rowX);
        dest.putDouble(destOffset + 16, colZ * rowX);
        dest.putDouble(destOffset + 24, colX * rowY);
        dest.putDouble(destOffset + 32, colY * rowY);
        dest.putDouble(destOffset + 40, colZ * rowY);
        dest.putDouble(destOffset + 48, colX * rowZ);
        dest.putDouble(destOffset + 56, colY * rowZ);
        dest.putDouble(destOffset + 64, colZ * rowZ);
        return dest;
    }

    public static java.nio.ByteBuffer makeOuterProduct_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer col, int colOffset, java.nio.ByteBuffer row, int rowOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _colBase = UnsafeOpsHolder.U.getLong(col, UnsafeCopy.BB_ADDRESS_OFFSET) + colOffset;
        long _rowBase = UnsafeOpsHolder.U.getLong(row, UnsafeCopy.BB_ADDRESS_OFFSET) + rowOffset;
        Double3x3OpsKernelsAddress.makeOuterProduct_unsafe(_destBase, _colBase, _rowBase);
        return dest;
    }

    public static java.nio.ByteBuffer makeOuterProduct_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer col, int colOffset, java.nio.ByteBuffer row, int rowOffset) {
        double _colx = col.getDouble(colOffset + 0);
        double _coly = col.getDouble(colOffset + 8);
        double _colz = col.getDouble(colOffset + 16);
        double _rowx = row.getDouble(rowOffset + 0);
        double _rowy = row.getDouble(rowOffset + 8);
        double _rowz = row.getDouble(rowOffset + 16);
        dest.putDouble(destOffset + 0, _colx * _rowx);
        dest.putDouble(destOffset + 8, _coly * _rowx);
        dest.putDouble(destOffset + 16, _colz * _rowx);
        dest.putDouble(destOffset + 24, _colx * _rowy);
        dest.putDouble(destOffset + 32, _coly * _rowy);
        dest.putDouble(destOffset + 40, _colz * _rowy);
        dest.putDouble(destOffset + 48, _colx * _rowz);
        dest.putDouble(destOffset + 56, _coly * _rowz);
        dest.putDouble(destOffset + 64, _colz * _rowz);
        return dest;
    }

    public static java.nio.ByteBuffer lookAlong_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.lookAlong_unsafe(_destBase, _srcBase, dirX, dirY, dirZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.ByteBuffer lookAlong_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
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
        dest.putDouble(destOffset + 0, Math.fma(_self02, _t26, Math.fma(_self00, _t27, _self01 * _t28)));
        dest.putDouble(destOffset + 8, Math.fma(_self12, _t26, Math.fma(_self10, _t27, _self11 * _t28)));
        dest.putDouble(destOffset + 16, Math.fma(_self22, _t26, Math.fma(_self20, _t27, _self21 * _t28)));
        dest.putDouble(destOffset + 24, Math.fma(_self02, _t35, Math.fma(_self00, _t36, _self01 * _t37)));
        dest.putDouble(destOffset + 32, Math.fma(_self12, _t35, Math.fma(_self10, _t36, _self11 * _t37)));
        dest.putDouble(destOffset + 40, Math.fma(_self22, _t35, Math.fma(_self20, _t36, _self21 * _t37)));
        dest.putDouble(destOffset + 48, Math.fma(_self02, _t9, Math.fma(_self00, _t8, _self01 * _t7)));
        dest.putDouble(destOffset + 56, Math.fma(_self12, _t9, Math.fma(_self10, _t8, _self11 * _t7)));
        dest.putDouble(destOffset + 64, Math.fma(_self22, _t9, Math.fma(_self20, _t8, _self21 * _t7)));
        return dest;
    }

    public static java.nio.ByteBuffer lookAlong_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer dir, int dirOffset, java.nio.ByteBuffer up, int upOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _dirBase = UnsafeOpsHolder.U.getLong(dir, UnsafeCopy.BB_ADDRESS_OFFSET) + dirOffset;
        long _upBase = UnsafeOpsHolder.U.getLong(up, UnsafeCopy.BB_ADDRESS_OFFSET) + upOffset;
        Double3x3OpsKernelsAddress.lookAlong_unsafe(_destBase, _srcBase, _dirBase, _upBase);
        return dest;
    }

    public static java.nio.ByteBuffer lookAlong_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer dir, int dirOffset, java.nio.ByteBuffer up, int upOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        double _dirx = dir.getDouble(dirOffset + 0);
        double _diry = dir.getDouble(dirOffset + 8);
        double _dirz = dir.getDouble(dirOffset + 16);
        double _upx = up.getDouble(upOffset + 0);
        double _upy = up.getDouble(upOffset + 8);
        double _upz = up.getDouble(upOffset + 16);
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
        dest.putDouble(destOffset + 0, Math.fma(_self02, _t26, Math.fma(_self00, _t27, _self01 * _t28)));
        dest.putDouble(destOffset + 8, Math.fma(_self12, _t26, Math.fma(_self10, _t27, _self11 * _t28)));
        dest.putDouble(destOffset + 16, Math.fma(_self22, _t26, Math.fma(_self20, _t27, _self21 * _t28)));
        dest.putDouble(destOffset + 24, Math.fma(_self02, _t35, Math.fma(_self00, _t36, _self01 * _t37)));
        dest.putDouble(destOffset + 32, Math.fma(_self12, _t35, Math.fma(_self10, _t36, _self11 * _t37)));
        dest.putDouble(destOffset + 40, Math.fma(_self22, _t35, Math.fma(_self20, _t36, _self21 * _t37)));
        dest.putDouble(destOffset + 48, Math.fma(_self02, _t9, Math.fma(_self00, _t8, _self01 * _t7)));
        dest.putDouble(destOffset + 56, Math.fma(_self12, _t9, Math.fma(_self10, _t8, _self11 * _t7)));
        dest.putDouble(destOffset + 64, Math.fma(_self22, _t9, Math.fma(_self20, _t8, _self21 * _t7)));
        return dest;
    }

    public static java.nio.ByteBuffer makeFromDualQuat_unsafe(java.nio.ByteBuffer dest, int destOffset, double dqRX, double dqRY, double dqRZ, double dqRW, double dqDX, double dqDY, double dqDZ, double dqDW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Double3x3OpsKernelsAddress.makeFromDualQuat_unsafe(_destBase, dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW);
        return dest;
    }

    public static java.nio.ByteBuffer makeFromDualQuat_api(java.nio.ByteBuffer dest, int destOffset, double dqRX, double dqRY, double dqRZ, double dqRW, double dqDX, double dqDY, double dqDZ, double dqDW) {
        double _t0 = dqRY * dqRY;
        double _t2 = dqRZ * dqRW;
        double _t3 = dqRY * dqRW;
        double _t4 = dqRX * dqRX;
        double _t5 = dqRY * dqRZ;
        double _t6 = Math.fma(-2.0, dqRZ * dqRZ, 1.0);
        dest.putDouble(destOffset + 0, Math.fma(-2.0, _t0, _t6));
        dest.putDouble(destOffset + 8, 2.0 * Math.fma(dqRX, dqRY, _t2));
        dest.putDouble(destOffset + 16, Math.fma(-2.0, _t3, 2.0 * dqRX * dqRZ));
        dest.putDouble(destOffset + 24, Math.fma(-2.0, _t2, 2.0 * dqRX * dqRY));
        dest.putDouble(destOffset + 32, Math.fma(-2.0, _t4, _t6));
        dest.putDouble(destOffset + 40, 2.0 * Math.fma(dqRX, dqRW, _t5));
        dest.putDouble(destOffset + 48, 2.0 * Math.fma(dqRX, dqRZ, _t3));
        dest.putDouble(destOffset + 56, Math.fma(-2.0, dqRX * dqRW, 2.0 * _t5));
        dest.putDouble(destOffset + 64, Math.fma(-2.0, _t4, Math.fma(-2.0, _t0, 1.0)));
        return dest;
    }

    public static java.nio.ByteBuffer makeRotation_unsafe(java.nio.ByteBuffer dest, int destOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Double3x3OpsKernelsAddress.makeRotation_unsafe(_destBase, angle);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotation_api(java.nio.ByteBuffer dest, int destOffset, double angle) {
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dest.putDouble(destOffset + 0, _t0);
        dest.putDouble(destOffset + 8, _t1);
        dest.putDouble(destOffset + 16, 0.0);
        dest.putDouble(destOffset + 24, -_t1);
        dest.putDouble(destOffset + 32, _t0);
        dest.putDouble(destOffset + 40, 0.0);
        dest.putDouble(destOffset + 48, 0.0);
        dest.putDouble(destOffset + 56, 0.0);
        dest.putDouble(destOffset + 64, 1.0);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationAxis_unsafe(java.nio.ByteBuffer dest, int destOffset, double angle, double axisX, double axisY, double axisZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Double3x3OpsKernelsAddress.makeRotationAxis_unsafe(_destBase, angle, axisX, axisY, axisZ);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationAxis_api(java.nio.ByteBuffer dest, int destOffset, double angle, double axisX, double axisY, double axisZ) {
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t2 = 1.0 - _t0;
        double _t3 = axisX * axisY;
        double _t4 = axisX * axisZ;
        double _t5 = axisY * axisZ;
        dest.putDouble(destOffset + 0, Math.fma(_t2, axisX * axisX, _t0));
        dest.putDouble(destOffset + 8, Math.fma(axisZ, _t1, _t2 * _t3));
        dest.putDouble(destOffset + 16, Math.fma(_t2, _t4, -(axisY * _t1)));
        dest.putDouble(destOffset + 24, Math.fma(_t2, _t3, -(axisZ * _t1)));
        dest.putDouble(destOffset + 32, Math.fma(_t2, axisY * axisY, _t0));
        dest.putDouble(destOffset + 40, Math.fma(axisX, _t1, _t2 * _t5));
        dest.putDouble(destOffset + 48, Math.fma(axisY, _t1, _t2 * _t4));
        dest.putDouble(destOffset + 56, Math.fma(_t2, _t5, -(axisX * _t1)));
        dest.putDouble(destOffset + 64, Math.fma(_t2, axisZ * axisZ, _t0));
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationAxis_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer axis, int axisOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _axisBase = UnsafeOpsHolder.U.getLong(axis, UnsafeCopy.BB_ADDRESS_OFFSET) + axisOffset;
        Double3x3OpsKernelsAddress.makeRotationAxis_unsafe(_destBase, _axisBase, angle);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationAxis_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer axis, int axisOffset, double angle) {
        double _axisx = axis.getDouble(axisOffset + 0);
        double _axisy = axis.getDouble(axisOffset + 8);
        double _axisz = axis.getDouble(axisOffset + 16);
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t2 = 1.0 - _t0;
        double _t3 = _axisx * _axisy;
        double _t4 = _axisx * _axisz;
        double _t5 = _axisy * _axisz;
        dest.putDouble(destOffset + 0, Math.fma(_t2, _axisx * _axisx, _t0));
        dest.putDouble(destOffset + 8, Math.fma(_axisz, _t1, _t2 * _t3));
        dest.putDouble(destOffset + 16, Math.fma(_t2, _t4, -(_axisy * _t1)));
        dest.putDouble(destOffset + 24, Math.fma(_t2, _t3, -(_axisz * _t1)));
        dest.putDouble(destOffset + 32, Math.fma(_t2, _axisy * _axisy, _t0));
        dest.putDouble(destOffset + 40, Math.fma(_axisx, _t1, _t2 * _t5));
        dest.putDouble(destOffset + 48, Math.fma(_axisy, _t1, _t2 * _t4));
        dest.putDouble(destOffset + 56, Math.fma(_t2, _t5, -(_axisx * _t1)));
        dest.putDouble(destOffset + 64, Math.fma(_t2, _axisz * _axisz, _t0));
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationLookAlong_unsafe(java.nio.ByteBuffer dest, int destOffset, double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Double3x3OpsKernelsAddress.makeRotationLookAlong_unsafe(_destBase, dirX, dirY, dirZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationLookAlong_api(java.nio.ByteBuffer dest, int destOffset, double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
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
        dest.putDouble(destOffset + 0, _t26);
        dest.putDouble(destOffset + 8, _t28);
        dest.putDouble(destOffset + 16, _t27);
        dest.putDouble(destOffset + 24, Math.fma(_t7, _t27, -(_t9 * _t28)));
        dest.putDouble(destOffset + 32, Math.fma(_t9, _t26, -(_t8 * _t27)));
        dest.putDouble(destOffset + 40, Math.fma(_t8, _t28, -(_t7 * _t26)));
        dest.putDouble(destOffset + 48, _t8);
        dest.putDouble(destOffset + 56, _t7);
        dest.putDouble(destOffset + 64, _t9);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationLookAlong_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer dir, int dirOffset, java.nio.ByteBuffer up, int upOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _dirBase = UnsafeOpsHolder.U.getLong(dir, UnsafeCopy.BB_ADDRESS_OFFSET) + dirOffset;
        long _upBase = UnsafeOpsHolder.U.getLong(up, UnsafeCopy.BB_ADDRESS_OFFSET) + upOffset;
        Double3x3OpsKernelsAddress.makeRotationLookAlong_unsafe(_destBase, _dirBase, _upBase);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationLookAlong_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer dir, int dirOffset, java.nio.ByteBuffer up, int upOffset) {
        double _dirx = dir.getDouble(dirOffset + 0);
        double _diry = dir.getDouble(dirOffset + 8);
        double _dirz = dir.getDouble(dirOffset + 16);
        double _upx = up.getDouble(upOffset + 0);
        double _upy = up.getDouble(upOffset + 8);
        double _upz = up.getDouble(upOffset + 16);
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
        dest.putDouble(destOffset + 0, _t26);
        dest.putDouble(destOffset + 8, _t28);
        dest.putDouble(destOffset + 16, _t27);
        dest.putDouble(destOffset + 24, Math.fma(_t7, _t27, -(_t9 * _t28)));
        dest.putDouble(destOffset + 32, Math.fma(_t9, _t26, -(_t8 * _t27)));
        dest.putDouble(destOffset + 40, Math.fma(_t8, _t28, -(_t7 * _t26)));
        dest.putDouble(destOffset + 48, _t8);
        dest.putDouble(destOffset + 56, _t7);
        dest.putDouble(destOffset + 64, _t9);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationQuat_unsafe(java.nio.ByteBuffer dest, int destOffset, double qX, double qY, double qZ, double qW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Double3x3OpsKernelsAddress.makeRotationQuat_unsafe(_destBase, qX, qY, qZ, qW);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationQuat_api(java.nio.ByteBuffer dest, int destOffset, double qX, double qY, double qZ, double qW) {
        double _t0 = qZ * qZ;
        double _t1 = qZ * qW;
        double _t2 = qY * qW;
        dest.putDouble(destOffset + 0, Math.fma(-2.0, Math.fma(qY, qY, _t0), 1.0));
        dest.putDouble(destOffset + 8, 2.0 * Math.fma(qX, qY, _t1));
        dest.putDouble(destOffset + 16, 2.0 * Math.fma(qX, qZ, -_t2));
        dest.putDouble(destOffset + 24, 2.0 * Math.fma(qX, qY, -_t1));
        dest.putDouble(destOffset + 32, Math.fma(-2.0, Math.fma(qX, qX, _t0), 1.0));
        dest.putDouble(destOffset + 40, 2.0 * Math.fma(qX, qW, qY * qZ));
        dest.putDouble(destOffset + 48, 2.0 * Math.fma(qX, qZ, _t2));
        dest.putDouble(destOffset + 56, 2.0 * Math.fma(qY, qZ, -(qX * qW)));
        dest.putDouble(destOffset + 64, Math.fma(-2.0, Math.fma(qX, qX, qY * qY), 1.0));
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationQuat_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer q, int qOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _qBase = UnsafeOpsHolder.U.getLong(q, UnsafeCopy.BB_ADDRESS_OFFSET) + qOffset;
        Double3x3OpsKernelsAddress.makeRotationQuat_unsafe(_destBase, _qBase);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationQuat_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer q, int qOffset) {
        double _qx = q.getDouble(qOffset + 0);
        double _qy = q.getDouble(qOffset + 8);
        double _qz = q.getDouble(qOffset + 16);
        double _qw = q.getDouble(qOffset + 24);
        double _t0 = _qz * _qz;
        double _t1 = _qz * _qw;
        double _t2 = _qy * _qw;
        dest.putDouble(destOffset + 0, Math.fma(-2.0, Math.fma(_qy, _qy, _t0), 1.0));
        dest.putDouble(destOffset + 8, 2.0 * Math.fma(_qx, _qy, _t1));
        dest.putDouble(destOffset + 16, 2.0 * Math.fma(_qx, _qz, -_t2));
        dest.putDouble(destOffset + 24, 2.0 * Math.fma(_qx, _qy, -_t1));
        dest.putDouble(destOffset + 32, Math.fma(-2.0, Math.fma(_qx, _qx, _t0), 1.0));
        dest.putDouble(destOffset + 40, 2.0 * Math.fma(_qx, _qw, _qy * _qz));
        dest.putDouble(destOffset + 48, 2.0 * Math.fma(_qx, _qz, _t2));
        dest.putDouble(destOffset + 56, 2.0 * Math.fma(_qy, _qz, -(_qx * _qw)));
        dest.putDouble(destOffset + 64, Math.fma(-2.0, Math.fma(_qx, _qx, _qy * _qy), 1.0));
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationX_unsafe(java.nio.ByteBuffer dest, int destOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Double3x3OpsKernelsAddress.makeRotationX_unsafe(_destBase, angle);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationX_api(java.nio.ByteBuffer dest, int destOffset, double angle) {
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dest.putDouble(destOffset + 0, 1.0);
        dest.putDouble(destOffset + 8, 0.0);
        dest.putDouble(destOffset + 16, 0.0);
        dest.putDouble(destOffset + 24, 0.0);
        dest.putDouble(destOffset + 32, _t0);
        dest.putDouble(destOffset + 40, _t1);
        dest.putDouble(destOffset + 48, 0.0);
        dest.putDouble(destOffset + 56, -_t1);
        dest.putDouble(destOffset + 64, _t0);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationXYZ_unsafe(java.nio.ByteBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Double3x3OpsKernelsAddress.makeRotationXYZ_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationXYZ_api(java.nio.ByteBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleZ);
        double _t3 = Math.sin(angleY);
        double _t4 = Math.sin(angleX);
        double _t5 = Math.cos(angleX);
        double _t6 = _t4 * _t3;
        double _t7 = _t3 * _t5;
        dest.putDouble(destOffset + 0, _t0 * _t1);
        dest.putDouble(destOffset + 8, Math.fma(_t6, _t1, _t2 * _t5));
        dest.putDouble(destOffset + 16, Math.fma(_t4, _t2, -(_t7 * _t1)));
        dest.putDouble(destOffset + 24, -(_t2 * _t0));
        dest.putDouble(destOffset + 32, Math.fma(_t5, _t1, -(_t6 * _t2)));
        dest.putDouble(destOffset + 40, Math.fma(_t7, _t2, _t4 * _t1));
        dest.putDouble(destOffset + 48, _t3);
        dest.putDouble(destOffset + 56, -(_t4 * _t0));
        dest.putDouble(destOffset + 64, _t5 * _t0);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationXZY_unsafe(java.nio.ByteBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Double3x3OpsKernelsAddress.makeRotationXZY_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationXZY_api(java.nio.ByteBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleZ);
        double _t3 = Math.sin(angleY);
        double _t4 = Math.cos(angleX);
        double _t5 = Math.sin(angleX);
        double _t6 = _t2 * _t4;
        double _t7 = _t5 * _t2;
        dest.putDouble(destOffset + 0, _t0 * _t1);
        dest.putDouble(destOffset + 8, Math.fma(_t6, _t0, _t5 * _t3));
        dest.putDouble(destOffset + 16, Math.fma(_t7, _t0, -(_t3 * _t4)));
        dest.putDouble(destOffset + 24, -_t2);
        dest.putDouble(destOffset + 32, _t4 * _t1);
        dest.putDouble(destOffset + 40, _t5 * _t1);
        dest.putDouble(destOffset + 48, _t3 * _t1);
        dest.putDouble(destOffset + 56, Math.fma(_t6, _t3, -(_t5 * _t0)));
        dest.putDouble(destOffset + 64, Math.fma(_t7, _t3, _t4 * _t0));
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationY_unsafe(java.nio.ByteBuffer dest, int destOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Double3x3OpsKernelsAddress.makeRotationY_unsafe(_destBase, angle);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationY_api(java.nio.ByteBuffer dest, int destOffset, double angle) {
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dest.putDouble(destOffset + 0, _t0);
        dest.putDouble(destOffset + 8, 0.0);
        dest.putDouble(destOffset + 16, -_t1);
        dest.putDouble(destOffset + 24, 0.0);
        dest.putDouble(destOffset + 32, 1.0);
        dest.putDouble(destOffset + 40, 0.0);
        dest.putDouble(destOffset + 48, _t1);
        dest.putDouble(destOffset + 56, 0.0);
        dest.putDouble(destOffset + 64, _t0);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationYXZ_unsafe(java.nio.ByteBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Double3x3OpsKernelsAddress.makeRotationYXZ_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationYXZ_api(java.nio.ByteBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        double _t0 = Math.sin(angleX);
        double _t1 = Math.sin(angleY);
        double _t2 = Math.sin(angleZ);
        double _t3 = Math.cos(angleY);
        double _t4 = Math.cos(angleZ);
        double _t5 = Math.cos(angleX);
        double _t6 = _t0 * _t1;
        double _t7 = _t0 * _t3;
        dest.putDouble(destOffset + 0, Math.fma(_t6, _t2, _t3 * _t4));
        dest.putDouble(destOffset + 8, _t2 * _t5);
        dest.putDouble(destOffset + 16, Math.fma(_t7, _t2, -(_t1 * _t4)));
        dest.putDouble(destOffset + 24, Math.fma(_t6, _t4, -(_t2 * _t3)));
        dest.putDouble(destOffset + 32, _t5 * _t4);
        dest.putDouble(destOffset + 40, Math.fma(_t7, _t4, _t1 * _t2));
        dest.putDouble(destOffset + 48, _t1 * _t5);
        dest.putDouble(destOffset + 56, -_t0);
        dest.putDouble(destOffset + 64, _t5 * _t3);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationYZX_unsafe(java.nio.ByteBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Double3x3OpsKernelsAddress.makeRotationYZX_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationYZX_api(java.nio.ByteBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleX);
        double _t3 = Math.sin(angleY);
        double _t4 = Math.sin(angleZ);
        double _t5 = Math.cos(angleX);
        double _t6 = _t4 * _t0;
        double _t7 = _t3 * _t4;
        dest.putDouble(destOffset + 0, _t0 * _t1);
        dest.putDouble(destOffset + 8, _t4);
        dest.putDouble(destOffset + 16, -(_t3 * _t1));
        dest.putDouble(destOffset + 24, Math.fma(_t2, _t3, -(_t6 * _t5)));
        dest.putDouble(destOffset + 32, _t5 * _t1);
        dest.putDouble(destOffset + 40, Math.fma(_t7, _t5, _t2 * _t0));
        dest.putDouble(destOffset + 48, Math.fma(_t6, _t2, _t3 * _t5));
        dest.putDouble(destOffset + 56, -(_t2 * _t1));
        dest.putDouble(destOffset + 64, Math.fma(_t5, _t0, -(_t7 * _t2)));
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationZXY_unsafe(java.nio.ByteBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Double3x3OpsKernelsAddress.makeRotationZXY_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationZXY_api(java.nio.ByteBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleX);
        double _t3 = Math.sin(angleZ);
        double _t4 = Math.sin(angleY);
        double _t5 = Math.cos(angleX);
        double _t6 = _t2 * _t3;
        double _t7 = _t2 * _t1;
        dest.putDouble(destOffset + 0, Math.fma(_t0, _t1, -(_t6 * _t4)));
        dest.putDouble(destOffset + 8, Math.fma(_t7, _t4, _t3 * _t0));
        dest.putDouble(destOffset + 16, -(_t4 * _t5));
        dest.putDouble(destOffset + 24, -(_t3 * _t5));
        dest.putDouble(destOffset + 32, _t5 * _t1);
        dest.putDouble(destOffset + 40, _t2);
        dest.putDouble(destOffset + 48, Math.fma(_t6, _t0, _t4 * _t1));
        dest.putDouble(destOffset + 56, Math.fma(_t4, _t3, -(_t7 * _t0)));
        dest.putDouble(destOffset + 64, _t5 * _t0);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationZYX_unsafe(java.nio.ByteBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Double3x3OpsKernelsAddress.makeRotationZYX_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationZYX_api(java.nio.ByteBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleY);
        double _t3 = Math.sin(angleX);
        double _t4 = Math.sin(angleZ);
        double _t5 = Math.cos(angleX);
        double _t6 = _t2 * _t1;
        double _t7 = _t2 * _t4;
        dest.putDouble(destOffset + 0, _t0 * _t1);
        dest.putDouble(destOffset + 8, _t4 * _t0);
        dest.putDouble(destOffset + 16, -_t2);
        dest.putDouble(destOffset + 24, Math.fma(_t6, _t3, -(_t4 * _t5)));
        dest.putDouble(destOffset + 32, Math.fma(_t7, _t3, _t5 * _t1));
        dest.putDouble(destOffset + 40, _t3 * _t0);
        dest.putDouble(destOffset + 48, Math.fma(_t6, _t5, _t3 * _t4));
        dest.putDouble(destOffset + 56, Math.fma(_t7, _t5, -(_t3 * _t1)));
        dest.putDouble(destOffset + 64, _t5 * _t0);
        return dest;
    }

    public static java.nio.ByteBuffer makeScaling_unsafe(java.nio.ByteBuffer dest, int destOffset, double vX, double vY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Double3x3OpsKernelsAddress.makeScaling_unsafe(_destBase, vX, vY);
        return dest;
    }

    public static java.nio.ByteBuffer makeScaling_api(java.nio.ByteBuffer dest, int destOffset, double vX, double vY) {
        dest.putDouble(destOffset + 0, vX);
        dest.putDouble(destOffset + 8, 0.0);
        dest.putDouble(destOffset + 16, 0.0);
        dest.putDouble(destOffset + 24, 0.0);
        dest.putDouble(destOffset + 32, vY);
        dest.putDouble(destOffset + 40, 0.0);
        dest.putDouble(destOffset + 48, 0.0);
        dest.putDouble(destOffset + 56, 0.0);
        dest.putDouble(destOffset + 64, 1.0);
        return dest;
    }

    public static java.nio.ByteBuffer makeScaling_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + vOffset;
        Double3x3OpsKernelsAddress.makeScaling_unsafe(_destBase, _vBase);
        return dest;
    }

    public static java.nio.ByteBuffer makeScaling_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer v, int vOffset) {
        double _vx = v.getDouble(vOffset + 0);
        double _vy = v.getDouble(vOffset + 8);
        dest.putDouble(destOffset + 0, _vx);
        dest.putDouble(destOffset + 8, 0.0);
        dest.putDouble(destOffset + 16, 0.0);
        dest.putDouble(destOffset + 24, 0.0);
        dest.putDouble(destOffset + 32, _vy);
        dest.putDouble(destOffset + 40, 0.0);
        dest.putDouble(destOffset + 48, 0.0);
        dest.putDouble(destOffset + 56, 0.0);
        dest.putDouble(destOffset + 64, 1.0);
        return dest;
    }

    public static java.nio.ByteBuffer makeScaling_unsafe(java.nio.ByteBuffer dest, int destOffset, double s) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Double3x3OpsKernelsAddress.makeScaling_unsafe(_destBase, s);
        return dest;
    }

    public static java.nio.ByteBuffer makeScaling_api(java.nio.ByteBuffer dest, int destOffset, double s) {
        dest.putDouble(destOffset + 0, s);
        dest.putDouble(destOffset + 8, 0.0);
        dest.putDouble(destOffset + 16, 0.0);
        dest.putDouble(destOffset + 24, 0.0);
        dest.putDouble(destOffset + 32, s);
        dest.putDouble(destOffset + 40, 0.0);
        dest.putDouble(destOffset + 48, 0.0);
        dest.putDouble(destOffset + 56, 0.0);
        dest.putDouble(destOffset + 64, 1.0);
        return dest;
    }

    public static java.nio.ByteBuffer makeTranslation_unsafe(java.nio.ByteBuffer dest, int destOffset, double vX, double vY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Double3x3OpsKernelsAddress.makeTranslation_unsafe(_destBase, vX, vY);
        return dest;
    }

    public static java.nio.ByteBuffer makeTranslation_api(java.nio.ByteBuffer dest, int destOffset, double vX, double vY) {
        dest.putDouble(destOffset + 0, 1.0);
        dest.putDouble(destOffset + 8, 0.0);
        dest.putDouble(destOffset + 16, 0.0);
        dest.putDouble(destOffset + 24, 0.0);
        dest.putDouble(destOffset + 32, 1.0);
        dest.putDouble(destOffset + 40, 0.0);
        dest.putDouble(destOffset + 48, vX);
        dest.putDouble(destOffset + 56, vY);
        dest.putDouble(destOffset + 64, 1.0);
        return dest;
    }

    public static java.nio.ByteBuffer makeTranslation_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + vOffset;
        Double3x3OpsKernelsAddress.makeTranslation_unsafe(_destBase, _vBase);
        return dest;
    }

    public static java.nio.ByteBuffer makeTranslation_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer v, int vOffset) {
        double _vx = v.getDouble(vOffset + 0);
        double _vy = v.getDouble(vOffset + 8);
        dest.putDouble(destOffset + 0, 1.0);
        dest.putDouble(destOffset + 8, 0.0);
        dest.putDouble(destOffset + 16, 0.0);
        dest.putDouble(destOffset + 24, 0.0);
        dest.putDouble(destOffset + 32, 1.0);
        dest.putDouble(destOffset + 40, 0.0);
        dest.putDouble(destOffset + 48, _vx);
        dest.putDouble(destOffset + 56, _vy);
        dest.putDouble(destOffset + 64, 1.0);
        return dest;
    }

    public static java.nio.ByteBuffer makeView_unsafe(java.nio.ByteBuffer dest, int destOffset, double left, double right, double bottom, double top) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Double3x3OpsKernelsAddress.makeView_unsafe(_destBase, left, right, bottom, top);
        return dest;
    }

    public static java.nio.ByteBuffer makeView_api(java.nio.ByteBuffer dest, int destOffset, double left, double right, double bottom, double top) {
        double _t0 = right - left;
        double _t0_inv = 1.0 / _t0;
        double _t1 = top - bottom;
        double _t1_inv = 1.0 / _t1;
        dest.putDouble(destOffset + 0, 2.0 * _t0_inv);
        dest.putDouble(destOffset + 8, 0.0);
        dest.putDouble(destOffset + 16, 0.0);
        dest.putDouble(destOffset + 24, 0.0);
        dest.putDouble(destOffset + 32, 2.0 * _t1_inv);
        dest.putDouble(destOffset + 40, 0.0);
        dest.putDouble(destOffset + 48, -((left + right) * _t0_inv));
        dest.putDouble(destOffset + 56, -((bottom + top) * _t1_inv));
        dest.putDouble(destOffset + 64, 1.0);
        return dest;
    }

    public static java.nio.ByteBuffer preRotate_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.preRotate_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.ByteBuffer preRotate_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dest.putDouble(destOffset + 0, Math.fma(_self00, _t0, -(_self10 * _t1)));
        dest.putDouble(destOffset + 8, Math.fma(_self00, _t1, _self10 * _t0));
        dest.putDouble(destOffset + 16, _self20);
        dest.putDouble(destOffset + 24, Math.fma(_self01, _t0, -(_self11 * _t1)));
        dest.putDouble(destOffset + 32, Math.fma(_self01, _t1, _self11 * _t0));
        dest.putDouble(destOffset + 40, _self21);
        dest.putDouble(destOffset + 48, Math.fma(_self02, _t0, -(_self12 * _t1)));
        dest.putDouble(destOffset + 56, Math.fma(_self02, _t1, _self12 * _t0));
        dest.putDouble(destOffset + 64, _self22);
        return dest;
    }

    public static java.nio.ByteBuffer preRotateAround_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle, double pivotX, double pivotY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.preRotateAround_unsafe(_destBase, _srcBase, angle, pivotX, pivotY);
        return dest;
    }

    public static java.nio.ByteBuffer preRotateAround_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle, double pivotX, double pivotY) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        double _t0 = Math.sin(angle);
        double _t1 = Math.cos(angle);
        double _t3 = Math.sin(0.5 * angle);
        double _t8 = 2.0 * _t3 * _t3;
        double _t9 = Math.fma(pivotX, _t8, pivotY * _t0);
        double _t10 = Math.fma(pivotY, _t8, -(pivotX * _t0));
        dest.putDouble(destOffset + 0, Math.fma(_self20, _t9, Math.fma(_self00, _t1, -(_self10 * _t0))));
        dest.putDouble(destOffset + 8, Math.fma(_self20, _t10, Math.fma(_self00, _t0, _self10 * _t1)));
        dest.putDouble(destOffset + 16, _self20);
        dest.putDouble(destOffset + 24, Math.fma(_self21, _t9, Math.fma(_self01, _t1, -(_self11 * _t0))));
        dest.putDouble(destOffset + 32, Math.fma(_self21, _t10, Math.fma(_self01, _t0, _self11 * _t1)));
        dest.putDouble(destOffset + 40, _self21);
        dest.putDouble(destOffset + 48, Math.fma(_self22, _t9, Math.fma(_self02, _t1, -(_self12 * _t0))));
        dest.putDouble(destOffset + 56, Math.fma(_self22, _t10, Math.fma(_self02, _t0, _self12 * _t1)));
        dest.putDouble(destOffset + 64, _self22);
        return dest;
    }

    public static java.nio.ByteBuffer preRotateAround_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer pivot, int pivotOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _pivotBase = UnsafeOpsHolder.U.getLong(pivot, UnsafeCopy.BB_ADDRESS_OFFSET) + pivotOffset;
        Double3x3OpsKernelsAddress.preRotateAround_unsafe(_destBase, _srcBase, _pivotBase, angle);
        return dest;
    }

    public static java.nio.ByteBuffer preRotateAround_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer pivot, int pivotOffset, double angle) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        double _pivotx = pivot.getDouble(pivotOffset + 0);
        double _pivoty = pivot.getDouble(pivotOffset + 8);
        double _t0 = Math.sin(angle);
        double _t1 = Math.cos(angle);
        double _t3 = Math.sin(0.5 * angle);
        double _t8 = 2.0 * _t3 * _t3;
        double _t9 = Math.fma(_pivotx, _t8, _pivoty * _t0);
        double _t10 = Math.fma(_pivoty, _t8, -(_pivotx * _t0));
        dest.putDouble(destOffset + 0, Math.fma(_self20, _t9, Math.fma(_self00, _t1, -(_self10 * _t0))));
        dest.putDouble(destOffset + 8, Math.fma(_self20, _t10, Math.fma(_self00, _t0, _self10 * _t1)));
        dest.putDouble(destOffset + 16, _self20);
        dest.putDouble(destOffset + 24, Math.fma(_self21, _t9, Math.fma(_self01, _t1, -(_self11 * _t0))));
        dest.putDouble(destOffset + 32, Math.fma(_self21, _t10, Math.fma(_self01, _t0, _self11 * _t1)));
        dest.putDouble(destOffset + 40, _self21);
        dest.putDouble(destOffset + 48, Math.fma(_self22, _t9, Math.fma(_self02, _t1, -(_self12 * _t0))));
        dest.putDouble(destOffset + 56, Math.fma(_self22, _t10, Math.fma(_self02, _t0, _self12 * _t1)));
        dest.putDouble(destOffset + 64, _self22);
        return dest;
    }

    public static java.nio.ByteBuffer preRotateAxis_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle, double axisX, double axisY, double axisZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.preRotateAxis_unsafe(_destBase, _srcBase, angle, axisX, axisY, axisZ);
        return dest;
    }

    public static java.nio.ByteBuffer preRotateAxis_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle, double axisX, double axisY, double axisZ) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
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
        dest.putDouble(destOffset + 0, Math.fma(_self20, _t21, Math.fma(_self00, _t18, _self10 * _t24)));
        dest.putDouble(destOffset + 8, Math.fma(_self20, _t25, Math.fma(_self00, _t22, _self10 * _t19)));
        dest.putDouble(destOffset + 16, Math.fma(_self20, _t20, Math.fma(_self00, _t26, _self10 * _t23)));
        dest.putDouble(destOffset + 24, Math.fma(_self21, _t21, Math.fma(_self01, _t18, _self11 * _t24)));
        dest.putDouble(destOffset + 32, Math.fma(_self21, _t25, Math.fma(_self01, _t22, _self11 * _t19)));
        dest.putDouble(destOffset + 40, Math.fma(_self21, _t20, Math.fma(_self01, _t26, _self11 * _t23)));
        dest.putDouble(destOffset + 48, Math.fma(_self22, _t21, Math.fma(_self02, _t18, _self12 * _t24)));
        dest.putDouble(destOffset + 56, Math.fma(_self22, _t25, Math.fma(_self02, _t22, _self12 * _t19)));
        dest.putDouble(destOffset + 64, Math.fma(_self22, _t20, Math.fma(_self02, _t26, _self12 * _t23)));
        return dest;
    }

    public static java.nio.ByteBuffer preRotateAxis_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer axis, int axisOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _axisBase = UnsafeOpsHolder.U.getLong(axis, UnsafeCopy.BB_ADDRESS_OFFSET) + axisOffset;
        Double3x3OpsKernelsAddress.preRotateAxis_unsafe(_destBase, _srcBase, _axisBase, angle);
        return dest;
    }

    public static java.nio.ByteBuffer preRotateAxis_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer axis, int axisOffset, double angle) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        double _axisx = axis.getDouble(axisOffset + 0);
        double _axisy = axis.getDouble(axisOffset + 8);
        double _axisz = axis.getDouble(axisOffset + 16);
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
        dest.putDouble(destOffset + 0, Math.fma(_self20, _t21, Math.fma(_self00, _t18, _self10 * _t24)));
        dest.putDouble(destOffset + 8, Math.fma(_self20, _t25, Math.fma(_self00, _t22, _self10 * _t19)));
        dest.putDouble(destOffset + 16, Math.fma(_self20, _t20, Math.fma(_self00, _t26, _self10 * _t23)));
        dest.putDouble(destOffset + 24, Math.fma(_self21, _t21, Math.fma(_self01, _t18, _self11 * _t24)));
        dest.putDouble(destOffset + 32, Math.fma(_self21, _t25, Math.fma(_self01, _t22, _self11 * _t19)));
        dest.putDouble(destOffset + 40, Math.fma(_self21, _t20, Math.fma(_self01, _t26, _self11 * _t23)));
        dest.putDouble(destOffset + 48, Math.fma(_self22, _t21, Math.fma(_self02, _t18, _self12 * _t24)));
        dest.putDouble(destOffset + 56, Math.fma(_self22, _t25, Math.fma(_self02, _t22, _self12 * _t19)));
        dest.putDouble(destOffset + 64, Math.fma(_self22, _t20, Math.fma(_self02, _t26, _self12 * _t23)));
        return dest;
    }

    public static java.nio.ByteBuffer preRotateX_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.preRotateX_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.ByteBuffer preRotateX_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dest.putDouble(destOffset + 0, _self00);
        dest.putDouble(destOffset + 8, Math.fma(_self10, _t0, -(_self20 * _t1)));
        dest.putDouble(destOffset + 16, Math.fma(_self10, _t1, _self20 * _t0));
        dest.putDouble(destOffset + 24, _self01);
        dest.putDouble(destOffset + 32, Math.fma(_self11, _t0, -(_self21 * _t1)));
        dest.putDouble(destOffset + 40, Math.fma(_self11, _t1, _self21 * _t0));
        dest.putDouble(destOffset + 48, _self02);
        dest.putDouble(destOffset + 56, Math.fma(_self12, _t0, -(_self22 * _t1)));
        dest.putDouble(destOffset + 64, Math.fma(_self12, _t1, _self22 * _t0));
        return dest;
    }

    public static java.nio.ByteBuffer preRotateY_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.preRotateY_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.ByteBuffer preRotateY_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dest.putDouble(destOffset + 0, Math.fma(_self00, _t0, _self20 * _t1));
        dest.putDouble(destOffset + 8, _self10);
        dest.putDouble(destOffset + 16, Math.fma(_self20, _t0, -(_self00 * _t1)));
        dest.putDouble(destOffset + 24, Math.fma(_self01, _t0, _self21 * _t1));
        dest.putDouble(destOffset + 32, _self11);
        dest.putDouble(destOffset + 40, Math.fma(_self21, _t0, -(_self01 * _t1)));
        dest.putDouble(destOffset + 48, Math.fma(_self02, _t0, _self22 * _t1));
        dest.putDouble(destOffset + 56, _self12);
        dest.putDouble(destOffset + 64, Math.fma(_self22, _t0, -(_self02 * _t1)));
        return dest;
    }

    public static java.nio.ByteBuffer preScale_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double vX, double vY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.preScale_unsafe(_destBase, _srcBase, vX, vY);
        return dest;
    }

    public static java.nio.ByteBuffer preScale_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double vX, double vY) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 3;
            double _eself0 = src.getDouble(srcOffset + _lo * 8);
            double _eself1 = src.getDouble(srcOffset + (_lo + 1) * 8);
            double _eself2 = src.getDouble(srcOffset + (_lo + 2) * 8);
            dest.putDouble(destOffset + _lo * 8, _eself0 * vX);
            dest.putDouble(destOffset + (_lo + 1) * 8, _eself1 * vY);
            dest.putDouble(destOffset + (_lo + 2) * 8, _eself2);
        }
        return dest;
    }

    public static java.nio.ByteBuffer preScale_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + vOffset;
        Double3x3OpsKernelsAddress.preScale_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.ByteBuffer preScale_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer v, int vOffset) {
        double _vx = v.getDouble(vOffset + 0);
        double _vy = v.getDouble(vOffset + 8);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 3;
            double _eself0 = src.getDouble(srcOffset + _lo * 8);
            double _eself1 = src.getDouble(srcOffset + (_lo + 1) * 8);
            double _eself2 = src.getDouble(srcOffset + (_lo + 2) * 8);
            dest.putDouble(destOffset + _lo * 8, _eself0 * _vx);
            dest.putDouble(destOffset + (_lo + 1) * 8, _eself1 * _vy);
            dest.putDouble(destOffset + (_lo + 2) * 8, _eself2);
        }
        return dest;
    }

    public static java.nio.ByteBuffer preScale_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double s) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.preScale_unsafe(_destBase, _srcBase, s);
        return dest;
    }

    public static java.nio.ByteBuffer preScale_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double s) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 3;
            double _eself0 = src.getDouble(srcOffset + _lo * 8);
            double _eself1 = src.getDouble(srcOffset + (_lo + 1) * 8);
            double _eself2 = src.getDouble(srcOffset + (_lo + 2) * 8);
            dest.putDouble(destOffset + _lo * 8, s * _eself0);
            dest.putDouble(destOffset + (_lo + 1) * 8, s * _eself1);
            dest.putDouble(destOffset + (_lo + 2) * 8, _eself2);
        }
        return dest;
    }

    public static java.nio.ByteBuffer preScaleAround_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double s, double pivotX, double pivotY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.preScaleAround_unsafe(_destBase, _srcBase, s, pivotX, pivotY);
        return dest;
    }

    public static java.nio.ByteBuffer preScaleAround_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double s, double pivotX, double pivotY) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        double _t0 = Math.fma(-s, pivotX, pivotX);
        double _t1 = Math.fma(-s, pivotY, pivotY);
        dest.putDouble(destOffset + 0, Math.fma(s, _self00, _self20 * _t0));
        dest.putDouble(destOffset + 8, Math.fma(s, _self10, _self20 * _t1));
        dest.putDouble(destOffset + 16, _self20);
        dest.putDouble(destOffset + 24, Math.fma(s, _self01, _self21 * _t0));
        dest.putDouble(destOffset + 32, Math.fma(s, _self11, _self21 * _t1));
        dest.putDouble(destOffset + 40, _self21);
        dest.putDouble(destOffset + 48, Math.fma(s, _self02, _self22 * _t0));
        dest.putDouble(destOffset + 56, Math.fma(s, _self12, _self22 * _t1));
        dest.putDouble(destOffset + 64, _self22);
        return dest;
    }

    public static java.nio.ByteBuffer preScaleAround_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer pivot, int pivotOffset, double s) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _pivotBase = UnsafeOpsHolder.U.getLong(pivot, UnsafeCopy.BB_ADDRESS_OFFSET) + pivotOffset;
        Double3x3OpsKernelsAddress.preScaleAround_unsafe(_destBase, _srcBase, _pivotBase, s);
        return dest;
    }

    public static java.nio.ByteBuffer preScaleAround_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer pivot, int pivotOffset, double s) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        double _pivotx = pivot.getDouble(pivotOffset + 0);
        double _pivoty = pivot.getDouble(pivotOffset + 8);
        double _t0 = Math.fma(-s, _pivotx, _pivotx);
        double _t1 = Math.fma(-s, _pivoty, _pivoty);
        dest.putDouble(destOffset + 0, Math.fma(s, _self00, _self20 * _t0));
        dest.putDouble(destOffset + 8, Math.fma(s, _self10, _self20 * _t1));
        dest.putDouble(destOffset + 16, _self20);
        dest.putDouble(destOffset + 24, Math.fma(s, _self01, _self21 * _t0));
        dest.putDouble(destOffset + 32, Math.fma(s, _self11, _self21 * _t1));
        dest.putDouble(destOffset + 40, _self21);
        dest.putDouble(destOffset + 48, Math.fma(s, _self02, _self22 * _t0));
        dest.putDouble(destOffset + 56, Math.fma(s, _self12, _self22 * _t1));
        dest.putDouble(destOffset + 64, _self22);
        return dest;
    }

    public static java.nio.ByteBuffer preScaleAround_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double sX, double sY, double pivotX, double pivotY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.preScaleAround_unsafe(_destBase, _srcBase, sX, sY, pivotX, pivotY);
        return dest;
    }

    public static java.nio.ByteBuffer preScaleAround_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double sX, double sY, double pivotX, double pivotY) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        double _t2 = Math.fma(-pivotX, sX, pivotX);
        double _t3 = Math.fma(-pivotY, sY, pivotY);
        dest.putDouble(destOffset + 0, Math.fma(sX, _self00, _self20 * _t2));
        dest.putDouble(destOffset + 8, Math.fma(sY, _self10, _self20 * _t3));
        dest.putDouble(destOffset + 16, _self20);
        dest.putDouble(destOffset + 24, Math.fma(sX, _self01, _self21 * _t2));
        dest.putDouble(destOffset + 32, Math.fma(sY, _self11, _self21 * _t3));
        dest.putDouble(destOffset + 40, _self21);
        dest.putDouble(destOffset + 48, Math.fma(sX, _self02, _self22 * _t2));
        dest.putDouble(destOffset + 56, Math.fma(sY, _self12, _self22 * _t3));
        dest.putDouble(destOffset + 64, _self22);
        return dest;
    }

    public static java.nio.ByteBuffer preScaleAround_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer s, int sOffset, java.nio.ByteBuffer pivot, int pivotOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _sBase = UnsafeOpsHolder.U.getLong(s, UnsafeCopy.BB_ADDRESS_OFFSET) + sOffset;
        long _pivotBase = UnsafeOpsHolder.U.getLong(pivot, UnsafeCopy.BB_ADDRESS_OFFSET) + pivotOffset;
        Double3x3OpsKernelsAddress.preScaleAround_unsafe(_destBase, _srcBase, _sBase, _pivotBase);
        return dest;
    }

    public static java.nio.ByteBuffer preScaleAround_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer s, int sOffset, java.nio.ByteBuffer pivot, int pivotOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        double _sx = s.getDouble(sOffset + 0);
        double _sy = s.getDouble(sOffset + 8);
        double _pivotx = pivot.getDouble(pivotOffset + 0);
        double _pivoty = pivot.getDouble(pivotOffset + 8);
        double _t2 = Math.fma(-_pivotx, _sx, _pivotx);
        double _t3 = Math.fma(-_pivoty, _sy, _pivoty);
        dest.putDouble(destOffset + 0, Math.fma(_sx, _self00, _self20 * _t2));
        dest.putDouble(destOffset + 8, Math.fma(_sy, _self10, _self20 * _t3));
        dest.putDouble(destOffset + 16, _self20);
        dest.putDouble(destOffset + 24, Math.fma(_sx, _self01, _self21 * _t2));
        dest.putDouble(destOffset + 32, Math.fma(_sy, _self11, _self21 * _t3));
        dest.putDouble(destOffset + 40, _self21);
        dest.putDouble(destOffset + 48, Math.fma(_sx, _self02, _self22 * _t2));
        dest.putDouble(destOffset + 56, Math.fma(_sy, _self12, _self22 * _t3));
        dest.putDouble(destOffset + 64, _self22);
        return dest;
    }

    public static java.nio.ByteBuffer preTranslate_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double vX, double vY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.preTranslate_unsafe(_destBase, _srcBase, vX, vY);
        return dest;
    }

    public static java.nio.ByteBuffer preTranslate_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double vX, double vY) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 3;
            double _eself0 = src.getDouble(srcOffset + _lo * 8);
            double _eself1 = src.getDouble(srcOffset + (_lo + 1) * 8);
            double _eself2 = src.getDouble(srcOffset + (_lo + 2) * 8);
            dest.putDouble(destOffset + _lo * 8, Math.fma(_eself2, vX, _eself0));
            dest.putDouble(destOffset + (_lo + 1) * 8, Math.fma(_eself2, vY, _eself1));
            dest.putDouble(destOffset + (_lo + 2) * 8, _eself2);
        }
        return dest;
    }

    public static java.nio.ByteBuffer preTranslate_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + vOffset;
        Double3x3OpsKernelsAddress.preTranslate_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.ByteBuffer preTranslate_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer v, int vOffset) {
        double _vx = v.getDouble(vOffset + 0);
        double _vy = v.getDouble(vOffset + 8);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 3;
            double _eself0 = src.getDouble(srcOffset + _lo * 8);
            double _eself1 = src.getDouble(srcOffset + (_lo + 1) * 8);
            double _eself2 = src.getDouble(srcOffset + (_lo + 2) * 8);
            dest.putDouble(destOffset + _lo * 8, Math.fma(_eself2, _vx, _eself0));
            dest.putDouble(destOffset + (_lo + 1) * 8, Math.fma(_eself2, _vy, _eself1));
            dest.putDouble(destOffset + (_lo + 2) * 8, _eself2);
        }
        return dest;
    }

    public static java.nio.ByteBuffer rotate_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.rotate_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.ByteBuffer rotate_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dest.putDouble(destOffset + 0, Math.fma(_self00, _t0, _self01 * _t1));
        dest.putDouble(destOffset + 8, Math.fma(_self10, _t0, _self11 * _t1));
        dest.putDouble(destOffset + 16, Math.fma(_self20, _t0, _self21 * _t1));
        dest.putDouble(destOffset + 24, Math.fma(_self01, _t0, -(_self00 * _t1)));
        dest.putDouble(destOffset + 32, Math.fma(_self11, _t0, -(_self10 * _t1)));
        dest.putDouble(destOffset + 40, Math.fma(_self21, _t0, -(_self20 * _t1)));
        dest.putDouble(destOffset + 48, _self02);
        dest.putDouble(destOffset + 56, _self12);
        dest.putDouble(destOffset + 64, _self22);
        return dest;
    }

    public static java.nio.ByteBuffer rotateAround_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle, double pivotX, double pivotY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.rotateAround_unsafe(_destBase, _srcBase, angle, pivotX, pivotY);
        return dest;
    }

    public static java.nio.ByteBuffer rotateAround_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle, double pivotX, double pivotY) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t3 = Math.sin(0.5 * angle);
        double _t8 = 2.0 * _t3 * _t3;
        double _t9 = Math.fma(pivotX, _t8, pivotY * _t1);
        double _t10 = Math.fma(pivotY, _t8, -(pivotX * _t1));
        dest.putDouble(destOffset + 0, Math.fma(_self00, _t0, _self01 * _t1));
        dest.putDouble(destOffset + 8, Math.fma(_self10, _t0, _self11 * _t1));
        dest.putDouble(destOffset + 16, Math.fma(_self20, _t0, _self21 * _t1));
        dest.putDouble(destOffset + 24, Math.fma(_self01, _t0, -(_self00 * _t1)));
        dest.putDouble(destOffset + 32, Math.fma(_self11, _t0, -(_self10 * _t1)));
        dest.putDouble(destOffset + 40, Math.fma(_self21, _t0, -(_self20 * _t1)));
        dest.putDouble(destOffset + 48, Math.fma(_self00, _t9, Math.fma(_self01, _t10, _self02)));
        dest.putDouble(destOffset + 56, Math.fma(_self10, _t9, Math.fma(_self11, _t10, _self12)));
        dest.putDouble(destOffset + 64, Math.fma(_self20, _t9, Math.fma(_self21, _t10, _self22)));
        return dest;
    }

    public static java.nio.ByteBuffer rotateAround_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer pivot, int pivotOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _pivotBase = UnsafeOpsHolder.U.getLong(pivot, UnsafeCopy.BB_ADDRESS_OFFSET) + pivotOffset;
        Double3x3OpsKernelsAddress.rotateAround_unsafe(_destBase, _srcBase, _pivotBase, angle);
        return dest;
    }

    public static java.nio.ByteBuffer rotateAround_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer pivot, int pivotOffset, double angle) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        double _pivotx = pivot.getDouble(pivotOffset + 0);
        double _pivoty = pivot.getDouble(pivotOffset + 8);
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t3 = Math.sin(0.5 * angle);
        double _t8 = 2.0 * _t3 * _t3;
        double _t9 = Math.fma(_pivotx, _t8, _pivoty * _t1);
        double _t10 = Math.fma(_pivoty, _t8, -(_pivotx * _t1));
        dest.putDouble(destOffset + 0, Math.fma(_self00, _t0, _self01 * _t1));
        dest.putDouble(destOffset + 8, Math.fma(_self10, _t0, _self11 * _t1));
        dest.putDouble(destOffset + 16, Math.fma(_self20, _t0, _self21 * _t1));
        dest.putDouble(destOffset + 24, Math.fma(_self01, _t0, -(_self00 * _t1)));
        dest.putDouble(destOffset + 32, Math.fma(_self11, _t0, -(_self10 * _t1)));
        dest.putDouble(destOffset + 40, Math.fma(_self21, _t0, -(_self20 * _t1)));
        dest.putDouble(destOffset + 48, Math.fma(_self00, _t9, Math.fma(_self01, _t10, _self02)));
        dest.putDouble(destOffset + 56, Math.fma(_self10, _t9, Math.fma(_self11, _t10, _self12)));
        dest.putDouble(destOffset + 64, Math.fma(_self20, _t9, Math.fma(_self21, _t10, _self22)));
        return dest;
    }

    public static java.nio.ByteBuffer rotateAxis_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle, double axisX, double axisY, double axisZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.rotateAxis_unsafe(_destBase, _srcBase, angle, axisX, axisY, axisZ);
        return dest;
    }

    public static java.nio.ByteBuffer rotateAxis_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle, double axisX, double axisY, double axisZ) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
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
        dest.putDouble(destOffset + 0, Math.fma(_self02, _t24, Math.fma(_self00, _t18, _self01 * _t21)));
        dest.putDouble(destOffset + 8, Math.fma(_self12, _t24, Math.fma(_self10, _t18, _self11 * _t21)));
        dest.putDouble(destOffset + 16, Math.fma(_self22, _t24, Math.fma(_self20, _t18, _self21 * _t21)));
        dest.putDouble(destOffset + 24, Math.fma(_self02, _t22, Math.fma(_self00, _t25, _self01 * _t19)));
        dest.putDouble(destOffset + 32, Math.fma(_self12, _t22, Math.fma(_self10, _t25, _self11 * _t19)));
        dest.putDouble(destOffset + 40, Math.fma(_self22, _t22, Math.fma(_self20, _t25, _self21 * _t19)));
        dest.putDouble(destOffset + 48, Math.fma(_self02, _t20, Math.fma(_self00, _t23, _self01 * _t26)));
        dest.putDouble(destOffset + 56, Math.fma(_self12, _t20, Math.fma(_self10, _t23, _self11 * _t26)));
        dest.putDouble(destOffset + 64, Math.fma(_self22, _t20, Math.fma(_self20, _t23, _self21 * _t26)));
        return dest;
    }

    public static java.nio.ByteBuffer rotateAxis_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer axis, int axisOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _axisBase = UnsafeOpsHolder.U.getLong(axis, UnsafeCopy.BB_ADDRESS_OFFSET) + axisOffset;
        Double3x3OpsKernelsAddress.rotateAxis_unsafe(_destBase, _srcBase, _axisBase, angle);
        return dest;
    }

    public static java.nio.ByteBuffer rotateAxis_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer axis, int axisOffset, double angle) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        double _axisx = axis.getDouble(axisOffset + 0);
        double _axisy = axis.getDouble(axisOffset + 8);
        double _axisz = axis.getDouble(axisOffset + 16);
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
        dest.putDouble(destOffset + 0, Math.fma(_self02, _t24, Math.fma(_self00, _t18, _self01 * _t21)));
        dest.putDouble(destOffset + 8, Math.fma(_self12, _t24, Math.fma(_self10, _t18, _self11 * _t21)));
        dest.putDouble(destOffset + 16, Math.fma(_self22, _t24, Math.fma(_self20, _t18, _self21 * _t21)));
        dest.putDouble(destOffset + 24, Math.fma(_self02, _t22, Math.fma(_self00, _t25, _self01 * _t19)));
        dest.putDouble(destOffset + 32, Math.fma(_self12, _t22, Math.fma(_self10, _t25, _self11 * _t19)));
        dest.putDouble(destOffset + 40, Math.fma(_self22, _t22, Math.fma(_self20, _t25, _self21 * _t19)));
        dest.putDouble(destOffset + 48, Math.fma(_self02, _t20, Math.fma(_self00, _t23, _self01 * _t26)));
        dest.putDouble(destOffset + 56, Math.fma(_self12, _t20, Math.fma(_self10, _t23, _self11 * _t26)));
        dest.putDouble(destOffset + 64, Math.fma(_self22, _t20, Math.fma(_self20, _t23, _self21 * _t26)));
        return dest;
    }

    public static java.nio.ByteBuffer rotateX_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.rotateX_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.ByteBuffer rotateX_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dest.putDouble(destOffset + 0, _self00);
        dest.putDouble(destOffset + 8, _self10);
        dest.putDouble(destOffset + 16, _self20);
        dest.putDouble(destOffset + 24, Math.fma(_self01, _t0, _self02 * _t1));
        dest.putDouble(destOffset + 32, Math.fma(_self11, _t0, _self12 * _t1));
        dest.putDouble(destOffset + 40, Math.fma(_self21, _t0, _self22 * _t1));
        dest.putDouble(destOffset + 48, Math.fma(_self02, _t0, -(_self01 * _t1)));
        dest.putDouble(destOffset + 56, Math.fma(_self12, _t0, -(_self11 * _t1)));
        dest.putDouble(destOffset + 64, Math.fma(_self22, _t0, -(_self21 * _t1)));
        return dest;
    }

    public static java.nio.ByteBuffer rotateX180_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.rotateX180_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer rotateX180_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        dest.putDouble(destOffset + 0, _self00);
        dest.putDouble(destOffset + 8, _self10);
        dest.putDouble(destOffset + 16, _self20);
        dest.putDouble(destOffset + 24, -_self01);
        dest.putDouble(destOffset + 32, -_self11);
        dest.putDouble(destOffset + 40, -_self21);
        dest.putDouble(destOffset + 48, -_self02);
        dest.putDouble(destOffset + 56, -_self12);
        dest.putDouble(destOffset + 64, -_self22);
        return dest;
    }

    public static java.nio.ByteBuffer rotateX270_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.rotateX270_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer rotateX270_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        dest.putDouble(destOffset + 0, _self00);
        dest.putDouble(destOffset + 8, _self10);
        dest.putDouble(destOffset + 16, _self20);
        dest.putDouble(destOffset + 24, -_self02);
        dest.putDouble(destOffset + 32, -_self12);
        dest.putDouble(destOffset + 40, -_self22);
        dest.putDouble(destOffset + 48, _self01);
        dest.putDouble(destOffset + 56, _self11);
        dest.putDouble(destOffset + 64, _self21);
        return dest;
    }

    public static java.nio.ByteBuffer rotateX90_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.rotateX90_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer rotateX90_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        dest.putDouble(destOffset + 0, _self00);
        dest.putDouble(destOffset + 8, _self10);
        dest.putDouble(destOffset + 16, _self20);
        dest.putDouble(destOffset + 24, _self02);
        dest.putDouble(destOffset + 32, _self12);
        dest.putDouble(destOffset + 40, _self22);
        dest.putDouble(destOffset + 48, -_self01);
        dest.putDouble(destOffset + 56, -_self11);
        dest.putDouble(destOffset + 64, -_self21);
        return dest;
    }

    public static java.nio.ByteBuffer rotateXYZ_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.rotateXYZ_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.ByteBuffer rotateXYZ_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
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
        dest.putDouble(destOffset + 0, Math.fma(_self02, _t20, Math.fma(_self00, _t7, _self01 * _t18)));
        dest.putDouble(destOffset + 8, Math.fma(_self12, _t20, Math.fma(_self10, _t7, _self11 * _t18)));
        dest.putDouble(destOffset + 16, Math.fma(_self22, _t20, Math.fma(_self20, _t7, _self21 * _t18)));
        dest.putDouble(destOffset + 24, Math.fma(_self02, _t19, Math.fma(_self01, _t21, -(_self00 * _t11))));
        dest.putDouble(destOffset + 32, Math.fma(_self12, _t19, Math.fma(_self11, _t21, -(_self10 * _t11))));
        dest.putDouble(destOffset + 40, Math.fma(_self22, _t19, Math.fma(_self21, _t21, -(_self20 * _t11))));
        dest.putDouble(destOffset + 48, Math.fma(_self02, _t12, Math.fma(_self00, _t2, -(_self01 * _t13))));
        dest.putDouble(destOffset + 56, Math.fma(_self12, _t12, Math.fma(_self10, _t2, -(_self11 * _t13))));
        dest.putDouble(destOffset + 64, Math.fma(_self22, _t12, Math.fma(_self20, _t2, -(_self21 * _t13))));
        return dest;
    }

    public static java.nio.ByteBuffer rotateXZY_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.rotateXZY_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.ByteBuffer rotateXZY_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
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
        dest.putDouble(destOffset + 0, Math.fma(_self02, _t20, Math.fma(_self00, _t8, _self01 * _t18)));
        dest.putDouble(destOffset + 8, Math.fma(_self12, _t20, Math.fma(_self10, _t8, _self11 * _t18)));
        dest.putDouble(destOffset + 16, Math.fma(_self22, _t20, Math.fma(_self20, _t8, _self21 * _t18)));
        dest.putDouble(destOffset + 24, Math.fma(_self02, _t11, Math.fma(_self01, _t12, -(_self00 * _t1))));
        dest.putDouble(destOffset + 32, Math.fma(_self12, _t11, Math.fma(_self11, _t12, -(_self10 * _t1))));
        dest.putDouble(destOffset + 40, Math.fma(_self22, _t11, Math.fma(_self21, _t12, -(_self20 * _t1))));
        dest.putDouble(destOffset + 48, Math.fma(_self02, _t19, Math.fma(_self00, _t14, _self01 * _t21)));
        dest.putDouble(destOffset + 56, Math.fma(_self12, _t19, Math.fma(_self10, _t14, _self11 * _t21)));
        dest.putDouble(destOffset + 64, Math.fma(_self22, _t19, Math.fma(_self20, _t14, _self21 * _t21)));
        return dest;
    }

    public static java.nio.ByteBuffer rotateY_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.rotateY_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.ByteBuffer rotateY_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dest.putDouble(destOffset + 0, Math.fma(_self00, _t0, -(_self02 * _t1)));
        dest.putDouble(destOffset + 8, Math.fma(_self10, _t0, -(_self12 * _t1)));
        dest.putDouble(destOffset + 16, Math.fma(_self20, _t0, -(_self22 * _t1)));
        dest.putDouble(destOffset + 24, _self01);
        dest.putDouble(destOffset + 32, _self11);
        dest.putDouble(destOffset + 40, _self21);
        dest.putDouble(destOffset + 48, Math.fma(_self00, _t1, _self02 * _t0));
        dest.putDouble(destOffset + 56, Math.fma(_self10, _t1, _self12 * _t0));
        dest.putDouble(destOffset + 64, Math.fma(_self20, _t1, _self22 * _t0));
        return dest;
    }

    public static java.nio.ByteBuffer rotateY180_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.rotateY180_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer rotateY180_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        dest.putDouble(destOffset + 0, -_self00);
        dest.putDouble(destOffset + 8, -_self10);
        dest.putDouble(destOffset + 16, -_self20);
        dest.putDouble(destOffset + 24, _self01);
        dest.putDouble(destOffset + 32, _self11);
        dest.putDouble(destOffset + 40, _self21);
        dest.putDouble(destOffset + 48, -_self02);
        dest.putDouble(destOffset + 56, -_self12);
        dest.putDouble(destOffset + 64, -_self22);
        return dest;
    }

    public static java.nio.ByteBuffer rotateY270_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.rotateY270_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer rotateY270_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        dest.putDouble(destOffset + 0, _self02);
        dest.putDouble(destOffset + 8, _self12);
        dest.putDouble(destOffset + 16, _self22);
        dest.putDouble(destOffset + 24, _self01);
        dest.putDouble(destOffset + 32, _self11);
        dest.putDouble(destOffset + 40, _self21);
        dest.putDouble(destOffset + 48, -_self00);
        dest.putDouble(destOffset + 56, -_self10);
        dest.putDouble(destOffset + 64, -_self20);
        return dest;
    }

    public static java.nio.ByteBuffer rotateY90_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.rotateY90_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer rotateY90_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        dest.putDouble(destOffset + 0, -_self02);
        dest.putDouble(destOffset + 8, -_self12);
        dest.putDouble(destOffset + 16, -_self22);
        dest.putDouble(destOffset + 24, _self01);
        dest.putDouble(destOffset + 32, _self11);
        dest.putDouble(destOffset + 40, _self21);
        dest.putDouble(destOffset + 48, _self00);
        dest.putDouble(destOffset + 56, _self10);
        dest.putDouble(destOffset + 64, _self20);
        return dest;
    }

    public static java.nio.ByteBuffer rotateYXZ_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.rotateYXZ_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.ByteBuffer rotateYXZ_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
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
        dest.putDouble(destOffset + 0, Math.fma(_self02, _t20, Math.fma(_self00, _t18, _self01 * _t10)));
        dest.putDouble(destOffset + 8, Math.fma(_self12, _t20, Math.fma(_self10, _t18, _self11 * _t10)));
        dest.putDouble(destOffset + 16, Math.fma(_self22, _t20, Math.fma(_self20, _t18, _self21 * _t10)));
        dest.putDouble(destOffset + 24, Math.fma(_self02, _t19, Math.fma(_self00, _t21, _self01 * _t13)));
        dest.putDouble(destOffset + 32, Math.fma(_self12, _t19, Math.fma(_self10, _t21, _self11 * _t13)));
        dest.putDouble(destOffset + 40, Math.fma(_self22, _t19, Math.fma(_self20, _t21, _self21 * _t13)));
        dest.putDouble(destOffset + 48, Math.fma(_self02, _t14, Math.fma(_self00, _t15, -(_self01 * _t0))));
        dest.putDouble(destOffset + 56, Math.fma(_self12, _t14, Math.fma(_self10, _t15, -(_self11 * _t0))));
        dest.putDouble(destOffset + 64, Math.fma(_self22, _t14, Math.fma(_self20, _t15, -(_self21 * _t0))));
        return dest;
    }

    public static java.nio.ByteBuffer rotateYZX_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.rotateYZX_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.ByteBuffer rotateYZX_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
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
        dest.putDouble(destOffset + 0, Math.fma(-_self02, _t6, Math.fma(_self00, _t7, _self01 * _t3)));
        dest.putDouble(destOffset + 8, Math.fma(-_self12, _t6, Math.fma(_self10, _t7, _self11 * _t3)));
        dest.putDouble(destOffset + 16, Math.fma(-_self22, _t6, Math.fma(_self20, _t7, _self21 * _t3)));
        dest.putDouble(destOffset + 24, Math.fma(_self02, _t18, Math.fma(_self00, _t20, _self01 * _t11)));
        dest.putDouble(destOffset + 32, Math.fma(_self12, _t18, Math.fma(_self10, _t20, _self11 * _t11)));
        dest.putDouble(destOffset + 40, Math.fma(_self22, _t18, Math.fma(_self20, _t20, _self21 * _t11)));
        dest.putDouble(destOffset + 48, Math.fma(_self02, _t21, Math.fma(_self00, _t19, -(_self01 * _t13))));
        dest.putDouble(destOffset + 56, Math.fma(_self12, _t21, Math.fma(_self10, _t19, -(_self11 * _t13))));
        dest.putDouble(destOffset + 64, Math.fma(_self22, _t21, Math.fma(_self20, _t19, -(_self21 * _t13))));
        return dest;
    }

    public static java.nio.ByteBuffer rotateZ180_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.rotateZ180_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer rotateZ180_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        dest.putDouble(destOffset + 0, -_self00);
        dest.putDouble(destOffset + 8, -_self10);
        dest.putDouble(destOffset + 16, -_self20);
        dest.putDouble(destOffset + 24, -_self01);
        dest.putDouble(destOffset + 32, -_self11);
        dest.putDouble(destOffset + 40, -_self21);
        dest.putDouble(destOffset + 48, _self02);
        dest.putDouble(destOffset + 56, _self12);
        dest.putDouble(destOffset + 64, _self22);
        return dest;
    }

    public static java.nio.ByteBuffer rotateZ270_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.rotateZ270_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer rotateZ270_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        dest.putDouble(destOffset + 0, -_self01);
        dest.putDouble(destOffset + 8, -_self11);
        dest.putDouble(destOffset + 16, -_self21);
        dest.putDouble(destOffset + 24, _self00);
        dest.putDouble(destOffset + 32, _self10);
        dest.putDouble(destOffset + 40, _self20);
        dest.putDouble(destOffset + 48, _self02);
        dest.putDouble(destOffset + 56, _self12);
        dest.putDouble(destOffset + 64, _self22);
        return dest;
    }

    public static java.nio.ByteBuffer rotateZ90_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.rotateZ90_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer rotateZ90_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        dest.putDouble(destOffset + 0, _self01);
        dest.putDouble(destOffset + 8, _self11);
        dest.putDouble(destOffset + 16, _self21);
        dest.putDouble(destOffset + 24, -_self00);
        dest.putDouble(destOffset + 32, -_self10);
        dest.putDouble(destOffset + 40, -_self20);
        dest.putDouble(destOffset + 48, _self02);
        dest.putDouble(destOffset + 56, _self12);
        dest.putDouble(destOffset + 64, _self22);
        return dest;
    }

    public static java.nio.ByteBuffer rotateZXY_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.rotateZXY_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.ByteBuffer rotateZXY_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
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
        dest.putDouble(destOffset + 0, Math.fma(-_self02, _t6, Math.fma(_self00, _t20, _self01 * _t18)));
        dest.putDouble(destOffset + 8, Math.fma(-_self12, _t6, Math.fma(_self10, _t20, _self11 * _t18)));
        dest.putDouble(destOffset + 16, Math.fma(-_self22, _t6, Math.fma(_self20, _t20, _self21 * _t18)));
        dest.putDouble(destOffset + 24, Math.fma(_self02, _t4, Math.fma(_self01, _t10, -(_self00 * _t11))));
        dest.putDouble(destOffset + 32, Math.fma(_self12, _t4, Math.fma(_self11, _t10, -(_self10 * _t11))));
        dest.putDouble(destOffset + 40, Math.fma(_self22, _t4, Math.fma(_self21, _t10, -(_self20 * _t11))));
        dest.putDouble(destOffset + 48, Math.fma(_self02, _t12, Math.fma(_self00, _t19, _self01 * _t21)));
        dest.putDouble(destOffset + 56, Math.fma(_self12, _t12, Math.fma(_self10, _t19, _self11 * _t21)));
        dest.putDouble(destOffset + 64, Math.fma(_self22, _t12, Math.fma(_self20, _t19, _self21 * _t21)));
        return dest;
    }

    public static java.nio.ByteBuffer rotateZYX_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.rotateZYX_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.ByteBuffer rotateZYX_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
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
        dest.putDouble(destOffset + 0, Math.fma(-_self02, _t0, Math.fma(_self00, _t6, _self01 * _t7)));
        dest.putDouble(destOffset + 8, Math.fma(-_self12, _t0, Math.fma(_self10, _t6, _self11 * _t7)));
        dest.putDouble(destOffset + 16, Math.fma(-_self22, _t0, Math.fma(_self20, _t6, _self21 * _t7)));
        dest.putDouble(destOffset + 24, Math.fma(_self02, _t8, Math.fma(_self00, _t20, _self01 * _t18)));
        dest.putDouble(destOffset + 32, Math.fma(_self12, _t8, Math.fma(_self10, _t20, _self11 * _t18)));
        dest.putDouble(destOffset + 40, Math.fma(_self22, _t8, Math.fma(_self20, _t20, _self21 * _t18)));
        dest.putDouble(destOffset + 48, Math.fma(_self02, _t13, Math.fma(_self00, _t19, _self01 * _t21)));
        dest.putDouble(destOffset + 56, Math.fma(_self12, _t13, Math.fma(_self10, _t19, _self11 * _t21)));
        dest.putDouble(destOffset + 64, Math.fma(_self22, _t13, Math.fma(_self20, _t19, _self21 * _t21)));
        return dest;
    }

    public static java.nio.ByteBuffer scale_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double vX, double vY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.scale_unsafe(_destBase, _srcBase, vX, vY);
        return dest;
    }

    public static java.nio.ByteBuffer scale_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double vX, double vY) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        dest.putDouble(destOffset + 0, _self00 * vX);
        dest.putDouble(destOffset + 8, _self10 * vX);
        dest.putDouble(destOffset + 16, _self20 * vX);
        dest.putDouble(destOffset + 24, _self01 * vY);
        dest.putDouble(destOffset + 32, _self11 * vY);
        dest.putDouble(destOffset + 40, _self21 * vY);
        dest.putDouble(destOffset + 48, _self02);
        dest.putDouble(destOffset + 56, _self12);
        dest.putDouble(destOffset + 64, _self22);
        return dest;
    }

    public static java.nio.ByteBuffer scale_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + vOffset;
        Double3x3OpsKernelsAddress.scale_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.ByteBuffer scale_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer v, int vOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        double _vx = v.getDouble(vOffset + 0);
        double _vy = v.getDouble(vOffset + 8);
        dest.putDouble(destOffset + 0, _self00 * _vx);
        dest.putDouble(destOffset + 8, _self10 * _vx);
        dest.putDouble(destOffset + 16, _self20 * _vx);
        dest.putDouble(destOffset + 24, _self01 * _vy);
        dest.putDouble(destOffset + 32, _self11 * _vy);
        dest.putDouble(destOffset + 40, _self21 * _vy);
        dest.putDouble(destOffset + 48, _self02);
        dest.putDouble(destOffset + 56, _self12);
        dest.putDouble(destOffset + 64, _self22);
        return dest;
    }

    public static java.nio.ByteBuffer scale_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double s) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.scale_unsafe(_destBase, _srcBase, s);
        return dest;
    }

    public static java.nio.ByteBuffer scale_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double s) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        dest.putDouble(destOffset + 0, s * _self00);
        dest.putDouble(destOffset + 8, s * _self10);
        dest.putDouble(destOffset + 16, s * _self20);
        dest.putDouble(destOffset + 24, s * _self01);
        dest.putDouble(destOffset + 32, s * _self11);
        dest.putDouble(destOffset + 40, s * _self21);
        dest.putDouble(destOffset + 48, _self02);
        dest.putDouble(destOffset + 56, _self12);
        dest.putDouble(destOffset + 64, _self22);
        return dest;
    }

    public static java.nio.ByteBuffer scaleAround_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double s, double pivotX, double pivotY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.scaleAround_unsafe(_destBase, _srcBase, s, pivotX, pivotY);
        return dest;
    }

    public static java.nio.ByteBuffer scaleAround_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double s, double pivotX, double pivotY) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        double _t0 = Math.fma(-s, pivotX, pivotX);
        double _t1 = Math.fma(-s, pivotY, pivotY);
        dest.putDouble(destOffset + 0, s * _self00);
        dest.putDouble(destOffset + 8, s * _self10);
        dest.putDouble(destOffset + 16, s * _self20);
        dest.putDouble(destOffset + 24, s * _self01);
        dest.putDouble(destOffset + 32, s * _self11);
        dest.putDouble(destOffset + 40, s * _self21);
        dest.putDouble(destOffset + 48, Math.fma(_self00, _t0, Math.fma(_self01, _t1, _self02)));
        dest.putDouble(destOffset + 56, Math.fma(_self10, _t0, Math.fma(_self11, _t1, _self12)));
        dest.putDouble(destOffset + 64, Math.fma(_self20, _t0, Math.fma(_self21, _t1, _self22)));
        return dest;
    }

    public static java.nio.ByteBuffer scaleAround_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer pivot, int pivotOffset, double s) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _pivotBase = UnsafeOpsHolder.U.getLong(pivot, UnsafeCopy.BB_ADDRESS_OFFSET) + pivotOffset;
        Double3x3OpsKernelsAddress.scaleAround_unsafe(_destBase, _srcBase, _pivotBase, s);
        return dest;
    }

    public static java.nio.ByteBuffer scaleAround_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer pivot, int pivotOffset, double s) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        double _pivotx = pivot.getDouble(pivotOffset + 0);
        double _pivoty = pivot.getDouble(pivotOffset + 8);
        double _t0 = Math.fma(-s, _pivotx, _pivotx);
        double _t1 = Math.fma(-s, _pivoty, _pivoty);
        dest.putDouble(destOffset + 0, s * _self00);
        dest.putDouble(destOffset + 8, s * _self10);
        dest.putDouble(destOffset + 16, s * _self20);
        dest.putDouble(destOffset + 24, s * _self01);
        dest.putDouble(destOffset + 32, s * _self11);
        dest.putDouble(destOffset + 40, s * _self21);
        dest.putDouble(destOffset + 48, Math.fma(_self00, _t0, Math.fma(_self01, _t1, _self02)));
        dest.putDouble(destOffset + 56, Math.fma(_self10, _t0, Math.fma(_self11, _t1, _self12)));
        dest.putDouble(destOffset + 64, Math.fma(_self20, _t0, Math.fma(_self21, _t1, _self22)));
        return dest;
    }

    public static java.nio.ByteBuffer scaleAround_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double sX, double sY, double pivotX, double pivotY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.scaleAround_unsafe(_destBase, _srcBase, sX, sY, pivotX, pivotY);
        return dest;
    }

    public static java.nio.ByteBuffer scaleAround_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double sX, double sY, double pivotX, double pivotY) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        double _t2 = Math.fma(-pivotX, sX, pivotX);
        double _t3 = Math.fma(-pivotY, sY, pivotY);
        dest.putDouble(destOffset + 0, sX * _self00);
        dest.putDouble(destOffset + 8, sX * _self10);
        dest.putDouble(destOffset + 16, sX * _self20);
        dest.putDouble(destOffset + 24, sY * _self01);
        dest.putDouble(destOffset + 32, sY * _self11);
        dest.putDouble(destOffset + 40, sY * _self21);
        dest.putDouble(destOffset + 48, Math.fma(_self00, _t2, Math.fma(_self01, _t3, _self02)));
        dest.putDouble(destOffset + 56, Math.fma(_self10, _t2, Math.fma(_self11, _t3, _self12)));
        dest.putDouble(destOffset + 64, Math.fma(_self20, _t2, Math.fma(_self21, _t3, _self22)));
        return dest;
    }

    public static java.nio.ByteBuffer scaleAround_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer s, int sOffset, java.nio.ByteBuffer pivot, int pivotOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _sBase = UnsafeOpsHolder.U.getLong(s, UnsafeCopy.BB_ADDRESS_OFFSET) + sOffset;
        long _pivotBase = UnsafeOpsHolder.U.getLong(pivot, UnsafeCopy.BB_ADDRESS_OFFSET) + pivotOffset;
        Double3x3OpsKernelsAddress.scaleAround_unsafe(_destBase, _srcBase, _sBase, _pivotBase);
        return dest;
    }

    public static java.nio.ByteBuffer scaleAround_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer s, int sOffset, java.nio.ByteBuffer pivot, int pivotOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        double _sx = s.getDouble(sOffset + 0);
        double _sy = s.getDouble(sOffset + 8);
        double _pivotx = pivot.getDouble(pivotOffset + 0);
        double _pivoty = pivot.getDouble(pivotOffset + 8);
        double _t2 = Math.fma(-_pivotx, _sx, _pivotx);
        double _t3 = Math.fma(-_pivoty, _sy, _pivoty);
        dest.putDouble(destOffset + 0, _sx * _self00);
        dest.putDouble(destOffset + 8, _sx * _self10);
        dest.putDouble(destOffset + 16, _sx * _self20);
        dest.putDouble(destOffset + 24, _sy * _self01);
        dest.putDouble(destOffset + 32, _sy * _self11);
        dest.putDouble(destOffset + 40, _sy * _self21);
        dest.putDouble(destOffset + 48, Math.fma(_self00, _t2, Math.fma(_self01, _t3, _self02)));
        dest.putDouble(destOffset + 56, Math.fma(_self10, _t2, Math.fma(_self11, _t3, _self12)));
        dest.putDouble(destOffset + 64, Math.fma(_self20, _t2, Math.fma(_self21, _t3, _self22)));
        return dest;
    }

    public static java.nio.ByteBuffer translate_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double vX, double vY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.translate_unsafe(_destBase, _srcBase, vX, vY);
        return dest;
    }

    public static java.nio.ByteBuffer translate_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double vX, double vY) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        dest.putDouble(destOffset + 0, _self00);
        dest.putDouble(destOffset + 8, _self10);
        dest.putDouble(destOffset + 16, _self20);
        dest.putDouble(destOffset + 24, _self01);
        dest.putDouble(destOffset + 32, _self11);
        dest.putDouble(destOffset + 40, _self21);
        dest.putDouble(destOffset + 48, Math.fma(_self00, vX, Math.fma(_self01, vY, _self02)));
        dest.putDouble(destOffset + 56, Math.fma(_self10, vX, Math.fma(_self11, vY, _self12)));
        dest.putDouble(destOffset + 64, Math.fma(_self20, vX, Math.fma(_self21, vY, _self22)));
        return dest;
    }

    public static java.nio.ByteBuffer translate_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + vOffset;
        Double3x3OpsKernelsAddress.translate_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.ByteBuffer translate_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer v, int vOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        double _vx = v.getDouble(vOffset + 0);
        double _vy = v.getDouble(vOffset + 8);
        dest.putDouble(destOffset + 0, _self00);
        dest.putDouble(destOffset + 8, _self10);
        dest.putDouble(destOffset + 16, _self20);
        dest.putDouble(destOffset + 24, _self01);
        dest.putDouble(destOffset + 32, _self11);
        dest.putDouble(destOffset + 40, _self21);
        dest.putDouble(destOffset + 48, Math.fma(_self00, _vx, Math.fma(_self01, _vy, _self02)));
        dest.putDouble(destOffset + 56, Math.fma(_self10, _vx, Math.fma(_self11, _vy, _self12)));
        dest.putDouble(destOffset + 64, Math.fma(_self20, _vx, Math.fma(_self21, _vy, _self22)));
        return dest;
    }

    public static java.nio.ByteBuffer view_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double left, double right, double bottom, double top) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.view_unsafe(_destBase, _srcBase, left, right, bottom, top);
        return dest;
    }

    public static java.nio.ByteBuffer view_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double left, double right, double bottom, double top) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        double _t0 = right - left;
        double _t0_inv = 1.0 / _t0;
        double _t1 = top - bottom;
        double _t1_inv = 1.0 / _t1;
        double _t2 = left + right;
        double _t3 = bottom + top;
        dest.putDouble(destOffset + 0, 2.0 * _self00 * _t0_inv);
        dest.putDouble(destOffset + 8, 2.0 * _self10 * _t0_inv);
        dest.putDouble(destOffset + 16, 2.0 * _self20 * _t0_inv);
        dest.putDouble(destOffset + 24, 2.0 * _self01 * _t1_inv);
        dest.putDouble(destOffset + 32, 2.0 * _self11 * _t1_inv);
        dest.putDouble(destOffset + 40, 2.0 * _self21 * _t1_inv);
        dest.putDouble(destOffset + 48, _self02 + (-(_self00 * _t2 * _t0_inv) - _self01 * _t3 * _t1_inv));
        dest.putDouble(destOffset + 56, _self12 + (-(_self10 * _t2 * _t0_inv) - _self11 * _t3 * _t1_inv));
        dest.putDouble(destOffset + 64, _self22 + (-(_self20 * _t2 * _t0_inv) - _self21 * _t3 * _t1_inv));
        return dest;
    }

    public static java.nio.ByteBuffer mulVec3_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double vX, double vY, double vZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double3x3OpsKernelsAddress.mulVec3_unsafe(_destBase, _srcBase, vX, vY, vZ);
        return dest;
    }

    public static java.nio.ByteBuffer mulVec3_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double vX, double vY, double vZ) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        dest.putDouble(destOffset + 0, Math.fma(_self02, vZ, Math.fma(_self00, vX, _self01 * vY)));
        dest.putDouble(destOffset + 8, Math.fma(_self12, vZ, Math.fma(_self10, vX, _self11 * vY)));
        dest.putDouble(destOffset + 16, Math.fma(_self22, vZ, Math.fma(_self20, vX, _self21 * vY)));
        return dest;
    }

    public static java.nio.ByteBuffer mulVec3_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + vOffset;
        Double3x3OpsKernelsAddress.mulVec3_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.ByteBuffer mulVec3_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer v, int vOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self20 = src.getDouble(srcOffset + 16);
        double _self01 = src.getDouble(srcOffset + 24);
        double _self11 = src.getDouble(srcOffset + 32);
        double _self21 = src.getDouble(srcOffset + 40);
        double _self02 = src.getDouble(srcOffset + 48);
        double _self12 = src.getDouble(srcOffset + 56);
        double _self22 = src.getDouble(srcOffset + 64);
        double _vx = v.getDouble(vOffset + 0);
        double _vy = v.getDouble(vOffset + 8);
        double _vz = v.getDouble(vOffset + 16);
        dest.putDouble(destOffset + 0, Math.fma(_self02, _vz, Math.fma(_self00, _vx, _self01 * _vy)));
        dest.putDouble(destOffset + 8, Math.fma(_self12, _vz, Math.fma(_self10, _vx, _self11 * _vy)));
        dest.putDouble(destOffset + 16, Math.fma(_self22, _vz, Math.fma(_self20, _vx, _self21 * _vy)));
        return dest;
    }

}
