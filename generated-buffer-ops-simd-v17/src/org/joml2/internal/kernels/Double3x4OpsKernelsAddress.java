package org.joml2.internal.kernels;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.ops.*;
import org.joml2.internal.unsafe.*;
import org.joml2.internal.simd.*;

/**
 * Scalar/Unsafe kernel leaves of {@link Double3x4Ops} whose leading storage
 * parameter is a raw {@code long} native address (the shared Unsafe kernels). Split into a sibling compilation unit purely
 * to keep generated sources IDE-sized; package-private, called only from
 * {@code Double3x4Ops} and its sibling kernel units. Not public API.
 */
public final class Double3x4OpsKernelsAddress {
    private Double3x4OpsKernelsAddress() {}

    public static long getColumn_unsafe(long dest, long src, int col) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
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
        UnsafeOpsHolder.U.putDouble(dest + 0L, _idxSw0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _idxSw1);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _idxSw2);
        return dest;
    }

    public static long getEulerAnglesXYZ_unsafe(long dest, long src) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _t1 = Math.fma(_self12, _self12, _self22 * _self22);
        double _t3 = Math.fma(_self02, _self02, _t1) * 1.0E-15;
        if (_t1 < _t3) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, Math.atan2(_self21, _self11));
            UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, Math.atan2(-_self12, _self22));
            UnsafeOpsHolder.U.putDouble(dest + 16L, Math.atan2(-_self01, _self00));
        }
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.asin(Math.min(1.0, Math.max(-1.0, _self02))));
        return dest;
    }

    public static long getEulerAnglesXZY_unsafe(long dest, long src) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _t1 = Math.fma(_self11, _self11, _self21 * _self21);
        double _t3 = Math.fma(_self01, _self01, _t1) * 1.0E-15;
        if (_t1 < _t3) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, Math.atan2(-_self12, _self22));
            UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, Math.atan2(_self21, _self11));
            UnsafeOpsHolder.U.putDouble(dest + 8L, Math.atan2(_self02, _self00));
        }
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.asin(Math.min(1.0, Math.max(-1.0, -_self01))));
        return dest;
    }

    public static long getEulerAnglesYXZ_unsafe(long dest, long src) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _t1 = Math.fma(_self02, _self02, _self22 * _self22);
        double _t3 = Math.fma(_self12, _self12, _t1) * 1.0E-15;
        if (_t1 < _t3) {
            UnsafeOpsHolder.U.putDouble(dest + 8L, Math.atan2(-_self20, _self00));
            UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 8L, Math.atan2(_self02, _self22));
            UnsafeOpsHolder.U.putDouble(dest + 16L, Math.atan2(_self10, _self11));
        }
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.asin(Math.min(1.0, Math.max(-1.0, -_self12))));
        return dest;
    }

    public static long getEulerAnglesYZX_unsafe(long dest, long src) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _t1 = Math.fma(_self11, _self11, _self12 * _self12);
        double _t3 = Math.fma(_self10, _self10, _t1) * 1.0E-15;
        if (_t1 < _t3) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, Math.atan2(_self02, _self22));
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, Math.atan2(-_self12, _self11));
            UnsafeOpsHolder.U.putDouble(dest + 8L, Math.atan2(-_self20, _self00));
        }
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.asin(Math.min(1.0, Math.max(-1.0, _self10))));
        return dest;
    }

    public static long getEulerAnglesZXY_unsafe(long dest, long src) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _t1 = Math.fma(_self01, _self01, _self11 * _self11);
        double _t3 = Math.fma(_self21, _self21, _t1) * 1.0E-15;
        if (_t1 < _t3) {
            UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 16L, Math.atan2(_self10, _self00));
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 8L, Math.atan2(-_self20, _self22));
            UnsafeOpsHolder.U.putDouble(dest + 16L, Math.atan2(-_self01, _self11));
        }
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.asin(Math.min(1.0, Math.max(-1.0, _self21))));
        return dest;
    }

    public static long getEulerAnglesZYX_unsafe(long dest, long src) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _t1 = Math.fma(_self21, _self21, _self22 * _self22);
        double _t3 = Math.fma(_self20, _self20, _t1) * 1.0E-15;
        if (_t1 < _t3) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 16L, Math.atan2(-_self01, _self11));
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, Math.atan2(_self21, _self22));
            UnsafeOpsHolder.U.putDouble(dest + 16L, Math.atan2(_self10, _self00));
        }
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.asin(Math.min(1.0, Math.max(-1.0, -_self20))));
        return dest;
    }

    public static long getNormalizedRotation_unsafe(long dest, long src) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
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
            UnsafeOpsHolder.U.putDouble(dest + 0L, 0.5 * _t36 * _t66);
            UnsafeOpsHolder.U.putDouble(dest + 8L, 0.5 * _t56 * _t66);
            UnsafeOpsHolder.U.putDouble(dest + 16L, 0.5 * _t57 * _t66);
            UnsafeOpsHolder.U.putDouble(dest + 24L, 0.5 * Math.sqrt(_t62));
        } else {
            if (_t49 > _t37) {
                UnsafeOpsHolder.U.putDouble(dest + 0L, 0.5 * Math.sqrt(_t63));
                UnsafeOpsHolder.U.putDouble(dest + 8L, 0.5 * _t53 * _t69);
                UnsafeOpsHolder.U.putDouble(dest + 16L, 0.5 * _t55 * _t69);
                UnsafeOpsHolder.U.putDouble(dest + 24L, 0.5 * _t36 * _t69);
            } else {
                if (_t23 > _t26) {
                    UnsafeOpsHolder.U.putDouble(dest + 0L, 0.5 * _t53 * _t67);
                    UnsafeOpsHolder.U.putDouble(dest + 8L, 0.5 * Math.sqrt(_t64));
                    UnsafeOpsHolder.U.putDouble(dest + 16L, 0.5 * _t39 * _t67);
                    UnsafeOpsHolder.U.putDouble(dest + 24L, 0.5 * _t56 * _t67);
                } else {
                    UnsafeOpsHolder.U.putDouble(dest + 0L, 0.5 * _t55 * _t68);
                    UnsafeOpsHolder.U.putDouble(dest + 8L, 0.5 * _t39 * _t68);
                    UnsafeOpsHolder.U.putDouble(dest + 16L, 0.5 * Math.sqrt(_t65));
                    UnsafeOpsHolder.U.putDouble(dest + 24L, 0.5 * _t57 * _t68);
                }
            }
        }
        return dest;
    }

    public static long getRow_unsafe(long dest, long src, int row) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
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
        UnsafeOpsHolder.U.putDouble(dest + 0L, _idxSw0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _idxSw1);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _idxSw2);
        UnsafeOpsHolder.U.putDouble(dest + 24L, _idxSw3);
        return dest;
    }

    public static long getScale_unsafe(long dest, long src) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.sqrt(Math.fma(_self20, _self20, Math.fma(_self00, _self00, _self10 * _self10))));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.sqrt(Math.fma(_self21, _self21, Math.fma(_self01, _self01, _self11 * _self11))));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.sqrt(Math.fma(_self22, _self22, Math.fma(_self02, _self02, _self12 * _self12))));
        return dest;
    }

    public static long getTranslation_unsafe(long dest, long src) {
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, _self03);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _self13);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _self23);
        return dest;
    }

    public static long getUnnormalizedRotation_unsafe(long dest, long src) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
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
            UnsafeOpsHolder.U.putDouble(dest + 0L, 0.5 * _t1 * _t18);
            UnsafeOpsHolder.U.putDouble(dest + 8L, 0.5 * _t7 * _t18);
            UnsafeOpsHolder.U.putDouble(dest + 16L, 0.5 * _t9 * _t18);
            UnsafeOpsHolder.U.putDouble(dest + 24L, 0.5 * Math.sqrt(_t14));
        } else {
            if (_self00 > _t2) {
                UnsafeOpsHolder.U.putDouble(dest + 0L, 0.5 * Math.sqrt(_t15));
                UnsafeOpsHolder.U.putDouble(dest + 8L, 0.5 * _t4 * _t21);
                UnsafeOpsHolder.U.putDouble(dest + 16L, 0.5 * _t6 * _t21);
                UnsafeOpsHolder.U.putDouble(dest + 24L, 0.5 * _t1 * _t21);
            } else {
                if (_self11 > _self22) {
                    UnsafeOpsHolder.U.putDouble(dest + 0L, 0.5 * _t4 * _t19);
                    UnsafeOpsHolder.U.putDouble(dest + 8L, 0.5 * Math.sqrt(_t16));
                    UnsafeOpsHolder.U.putDouble(dest + 16L, 0.5 * _t8 * _t19);
                    UnsafeOpsHolder.U.putDouble(dest + 24L, 0.5 * _t7 * _t19);
                } else {
                    UnsafeOpsHolder.U.putDouble(dest + 0L, 0.5 * _t6 * _t20);
                    UnsafeOpsHolder.U.putDouble(dest + 8L, 0.5 * _t8 * _t20);
                    UnsafeOpsHolder.U.putDouble(dest + 16L, 0.5 * Math.sqrt(_t17));
                    UnsafeOpsHolder.U.putDouble(dest + 24L, 0.5 * _t9 * _t20);
                }
            }
        }
        return dest;
    }

    public static long invNegativeX_unsafe(long dest, long src) {
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _t6 = Math.fma(_self10, _self21, -(_self11 * _self20));
        double _t7 = Math.fma(_self11, _self22, -(_self12 * _self21));
        double _t8 = Math.fma(_self12, _self20, -(_self10 * _self22));
        double _t11 = Math.fma(_t6, _t6, Math.fma(_t7, _t7, _t8 * _t8));
        double _t12 = (1.0 / Math.sqrt(_t11));
        if (_t11 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, -(_t7 * _t12));
            UnsafeOpsHolder.U.putDouble(dest + 8L, -(_t8 * _t12));
            UnsafeOpsHolder.U.putDouble(dest + 16L, -(_t6 * _t12));
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, -0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, -0.0);
            UnsafeOpsHolder.U.putDouble(dest + 16L, -0.0);
        }
        return dest;
    }

    public static long invNegativeY_unsafe(long dest, long src) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _t6 = Math.fma(_self01, _self20, -(_self00 * _self21));
        double _t7 = Math.fma(_self00, _self22, -(_self02 * _self20));
        double _t8 = Math.fma(_self02, _self21, -(_self01 * _self22));
        double _t11 = Math.fma(_t6, _t6, Math.fma(_t7, _t7, _t8 * _t8));
        double _t12 = (1.0 / Math.sqrt(_t11));
        if (_t11 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, -(_t8 * _t12));
            UnsafeOpsHolder.U.putDouble(dest + 8L, -(_t7 * _t12));
            UnsafeOpsHolder.U.putDouble(dest + 16L, -(_t6 * _t12));
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, -0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, -0.0);
            UnsafeOpsHolder.U.putDouble(dest + 16L, -0.0);
        }
        return dest;
    }

    public static long invNegativeZ_unsafe(long dest, long src) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _t6 = Math.fma(_self00, _self11, -(_self01 * _self10));
        double _t7 = Math.fma(_self01, _self12, -(_self02 * _self11));
        double _t8 = Math.fma(_self02, _self10, -(_self00 * _self12));
        double _t11 = Math.fma(_t6, _t6, Math.fma(_t7, _t7, _t8 * _t8));
        double _t12 = (1.0 / Math.sqrt(_t11));
        if (_t11 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, -(_t7 * _t12));
            UnsafeOpsHolder.U.putDouble(dest + 8L, -(_t8 * _t12));
            UnsafeOpsHolder.U.putDouble(dest + 16L, -(_t6 * _t12));
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, -0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, -0.0);
            UnsafeOpsHolder.U.putDouble(dest + 16L, -0.0);
        }
        return dest;
    }

    public static long invNormalizedNegativeX_unsafe(long dest, long src) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, -_self00);
        UnsafeOpsHolder.U.putDouble(dest + 8L, -_self01);
        UnsafeOpsHolder.U.putDouble(dest + 16L, -_self02);
        return dest;
    }

    public static long invNormalizedNegativeY_unsafe(long dest, long src) {
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, -_self10);
        UnsafeOpsHolder.U.putDouble(dest + 8L, -_self11);
        UnsafeOpsHolder.U.putDouble(dest + 16L, -_self12);
        return dest;
    }

    public static long invNormalizedNegativeZ_unsafe(long dest, long src) {
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, -_self20);
        UnsafeOpsHolder.U.putDouble(dest + 8L, -_self21);
        UnsafeOpsHolder.U.putDouble(dest + 16L, -_self22);
        return dest;
    }

    public static long invNormalizedPositiveX_unsafe(long dest, long src) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, _self00);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _self01);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _self02);
        return dest;
    }

    public static long invNormalizedPositiveY_unsafe(long dest, long src) {
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, _self10);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _self11);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _self12);
        return dest;
    }

    public static long invNormalizedPositiveZ_unsafe(long dest, long src) {
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, _self20);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _self21);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _self22);
        return dest;
    }

    public static long invPositiveX_unsafe(long dest, long src) {
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _t6 = Math.fma(_self10, _self21, -(_self11 * _self20));
        double _t7 = Math.fma(_self11, _self22, -(_self12 * _self21));
        double _t8 = Math.fma(_self12, _self20, -(_self10 * _self22));
        double _t11 = Math.fma(_t6, _t6, Math.fma(_t7, _t7, _t8 * _t8));
        double _t12 = (1.0 / Math.sqrt(_t11));
        if (_t11 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, _t7 * _t12);
            UnsafeOpsHolder.U.putDouble(dest + 8L, _t8 * _t12);
            UnsafeOpsHolder.U.putDouble(dest + 16L, _t6 * _t12);
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        }
        return dest;
    }

    public static long invPositiveY_unsafe(long dest, long src) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _t6 = Math.fma(_self01, _self20, -(_self00 * _self21));
        double _t7 = Math.fma(_self00, _self22, -(_self02 * _self20));
        double _t8 = Math.fma(_self02, _self21, -(_self01 * _self22));
        double _t11 = Math.fma(_t6, _t6, Math.fma(_t7, _t7, _t8 * _t8));
        double _t12 = (1.0 / Math.sqrt(_t11));
        if (_t11 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, _t8 * _t12);
            UnsafeOpsHolder.U.putDouble(dest + 8L, _t7 * _t12);
            UnsafeOpsHolder.U.putDouble(dest + 16L, _t6 * _t12);
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        }
        return dest;
    }

    public static long invPositiveZ_unsafe(long dest, long src) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _t6 = Math.fma(_self00, _self11, -(_self01 * _self10));
        double _t7 = Math.fma(_self01, _self12, -(_self02 * _self11));
        double _t8 = Math.fma(_self02, _self10, -(_self00 * _self12));
        double _t11 = Math.fma(_t6, _t6, Math.fma(_t7, _t7, _t8 * _t8));
        double _t12 = (1.0 / Math.sqrt(_t11));
        if (_t11 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, _t7 * _t12);
            UnsafeOpsHolder.U.putDouble(dest + 8L, _t8 * _t12);
            UnsafeOpsHolder.U.putDouble(dest + 16L, _t6 * _t12);
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        }
        return dest;
    }

    public static long negativeX_unsafe(long dest, long src) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _t2 = Math.fma(_self20, _self20, Math.fma(_self00, _self00, _self10 * _self10));
        double _t3 = (1.0 / Math.sqrt(_t2));
        if (_t2 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, -(_self00 * _t3));
            UnsafeOpsHolder.U.putDouble(dest + 8L, -(_self10 * _t3));
            UnsafeOpsHolder.U.putDouble(dest + 16L, -(_self20 * _t3));
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, -0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, -0.0);
            UnsafeOpsHolder.U.putDouble(dest + 16L, -0.0);
        }
        return dest;
    }

    public static long negativeY_unsafe(long dest, long src) {
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _t2 = Math.fma(_self21, _self21, Math.fma(_self01, _self01, _self11 * _self11));
        double _t3 = (1.0 / Math.sqrt(_t2));
        if (_t2 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, -(_self01 * _t3));
            UnsafeOpsHolder.U.putDouble(dest + 8L, -(_self11 * _t3));
            UnsafeOpsHolder.U.putDouble(dest + 16L, -(_self21 * _t3));
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, -0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, -0.0);
            UnsafeOpsHolder.U.putDouble(dest + 16L, -0.0);
        }
        return dest;
    }

    public static long negativeZ_unsafe(long dest, long src) {
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _t2 = Math.fma(_self22, _self22, Math.fma(_self02, _self02, _self12 * _self12));
        double _t3 = (1.0 / Math.sqrt(_t2));
        if (_t2 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, -(_self02 * _t3));
            UnsafeOpsHolder.U.putDouble(dest + 8L, -(_self12 * _t3));
            UnsafeOpsHolder.U.putDouble(dest + 16L, -(_self22 * _t3));
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, -0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, -0.0);
            UnsafeOpsHolder.U.putDouble(dest + 16L, -0.0);
        }
        return dest;
    }

    public static long normalizedNegativeX_unsafe(long dest, long src) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, -_self00);
        UnsafeOpsHolder.U.putDouble(dest + 8L, -_self10);
        UnsafeOpsHolder.U.putDouble(dest + 16L, -_self20);
        return dest;
    }

    public static long normalizedNegativeY_unsafe(long dest, long src) {
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, -_self01);
        UnsafeOpsHolder.U.putDouble(dest + 8L, -_self11);
        UnsafeOpsHolder.U.putDouble(dest + 16L, -_self21);
        return dest;
    }

    public static long normalizedNegativeZ_unsafe(long dest, long src) {
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, -_self02);
        UnsafeOpsHolder.U.putDouble(dest + 8L, -_self12);
        UnsafeOpsHolder.U.putDouble(dest + 16L, -_self22);
        return dest;
    }

    public static long normalizedPositiveX_unsafe(long dest, long src) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, _self00);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _self10);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _self20);
        return dest;
    }

    public static long normalizedPositiveY_unsafe(long dest, long src) {
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, _self01);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _self11);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _self21);
        return dest;
    }

    public static long normalizedPositiveZ_unsafe(long dest, long src) {
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, _self02);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _self12);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _self22);
        return dest;
    }

    public static long origin_unsafe(long dest, long src) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, -Math.fma(_self20, _self23, Math.fma(_self00, _self03, _self10 * _self13)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, -Math.fma(_self21, _self23, Math.fma(_self01, _self03, _self11 * _self13)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, -Math.fma(_self22, _self23, Math.fma(_self02, _self03, _self12 * _self13)));
        return dest;
    }

    public static long positiveX_unsafe(long dest, long src) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _t2 = Math.fma(_self20, _self20, Math.fma(_self00, _self00, _self10 * _self10));
        double _t3 = (1.0 / Math.sqrt(_t2));
        if (_t2 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, _self00 * _t3);
            UnsafeOpsHolder.U.putDouble(dest + 8L, _self10 * _t3);
            UnsafeOpsHolder.U.putDouble(dest + 16L, _self20 * _t3);
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        }
        return dest;
    }

    public static long positiveY_unsafe(long dest, long src) {
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _t2 = Math.fma(_self21, _self21, Math.fma(_self01, _self01, _self11 * _self11));
        double _t3 = (1.0 / Math.sqrt(_t2));
        if (_t2 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, _self01 * _t3);
            UnsafeOpsHolder.U.putDouble(dest + 8L, _self11 * _t3);
            UnsafeOpsHolder.U.putDouble(dest + 16L, _self21 * _t3);
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        }
        return dest;
    }

    public static long positiveZ_unsafe(long dest, long src) {
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _t2 = Math.fma(_self22, _self22, Math.fma(_self02, _self02, _self12 * _self12));
        double _t3 = (1.0 / Math.sqrt(_t2));
        if (_t2 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, _self02 * _t3);
            UnsafeOpsHolder.U.putDouble(dest + 8L, _self12 * _t3);
            UnsafeOpsHolder.U.putDouble(dest + 16L, _self22 * _t3);
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        }
        return dest;
    }

    public static double determinant_unsafe(long src) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        return Math.fma(_self02, Math.fma(_self10, _self21, -(_self11 * _self20)), Math.fma(_self00, Math.fma(_self11, _self22, -(_self12 * _self21)), -(_self01 * Math.fma(_self10, _self22, -(_self12 * _self20)))));
    }

    public static double frobeniusNorm_unsafe(long src) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        return Math.sqrt(Math.fma(_self00, _self00, Math.fma(_self01, _self01, _self02 * _self02)) + Math.fma(_self03, _self03, Math.fma(_self10, _self10, _self11 * _self11)) + (Math.fma(_self12, _self12, Math.fma(_self13, _self13, _self20 * _self20)) + Math.fma(_self21, _self21, Math.fma(_self22, _self22, _self23 * _self23))));
    }

    public static long invert_unsafe(long dest, long src) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
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
        UnsafeOpsHolder.U.putDouble(dest + 0L, _t20 * _t33_inv);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _t23 * _t33_inv);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _t24 * _t33_inv);
        UnsafeOpsHolder.U.putDouble(dest + 24L, -(Math.fma(_self23, _t24, Math.fma(_self03, _t20, _self13 * _t23)) * _t33_inv));
        UnsafeOpsHolder.U.putDouble(dest + 32L, _t25 * _t33_inv);
        UnsafeOpsHolder.U.putDouble(dest + 40L, _t26 * _t33_inv);
        UnsafeOpsHolder.U.putDouble(dest + 48L, _t27 * _t33_inv);
        UnsafeOpsHolder.U.putDouble(dest + 56L, -(Math.fma(_self23, _t27, Math.fma(_self03, _t25, _self13 * _t26)) * _t33_inv));
        UnsafeOpsHolder.U.putDouble(dest + 64L, _t21 * _t33_inv);
        UnsafeOpsHolder.U.putDouble(dest + 72L, _t28 * _t33_inv);
        UnsafeOpsHolder.U.putDouble(dest + 80L, _t29 * _t33_inv);
        UnsafeOpsHolder.U.putDouble(dest + 88L, -(Math.fma(_self23, _t29, Math.fma(_self03, _t21, _self13 * _t28)) * _t33_inv));
        return dest;
    }

    public static long invertProduct_unsafe(long dest, long src, long other) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        double _other00 = UnsafeOpsHolder.U.getDouble(other + 0L);
        double _other01 = UnsafeOpsHolder.U.getDouble(other + 8L);
        double _other02 = UnsafeOpsHolder.U.getDouble(other + 16L);
        double _other03 = UnsafeOpsHolder.U.getDouble(other + 24L);
        double _other10 = UnsafeOpsHolder.U.getDouble(other + 32L);
        double _other11 = UnsafeOpsHolder.U.getDouble(other + 40L);
        double _other12 = UnsafeOpsHolder.U.getDouble(other + 48L);
        double _other13 = UnsafeOpsHolder.U.getDouble(other + 56L);
        double _other20 = UnsafeOpsHolder.U.getDouble(other + 64L);
        double _other21 = UnsafeOpsHolder.U.getDouble(other + 72L);
        double _other22 = UnsafeOpsHolder.U.getDouble(other + 80L);
        double _other23 = UnsafeOpsHolder.U.getDouble(other + 88L);
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
        UnsafeOpsHolder.U.putDouble(dest + 0L, _t56 * _t69_inv);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _t59 * _t69_inv);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _t60 * _t69_inv);
        UnsafeOpsHolder.U.putDouble(dest + 24L, -(Math.fma(_t33, _t60, Math.fma(_t34, _t56, _t35 * _t59)) * _t69_inv));
        UnsafeOpsHolder.U.putDouble(dest + 32L, _t61 * _t69_inv);
        UnsafeOpsHolder.U.putDouble(dest + 40L, _t62 * _t69_inv);
        UnsafeOpsHolder.U.putDouble(dest + 48L, _t63 * _t69_inv);
        UnsafeOpsHolder.U.putDouble(dest + 56L, -(Math.fma(_t33, _t63, Math.fma(_t34, _t61, _t35 * _t62)) * _t69_inv));
        UnsafeOpsHolder.U.putDouble(dest + 64L, _t57 * _t69_inv);
        UnsafeOpsHolder.U.putDouble(dest + 72L, _t64 * _t69_inv);
        UnsafeOpsHolder.U.putDouble(dest + 80L, _t65 * _t69_inv);
        UnsafeOpsHolder.U.putDouble(dest + 88L, -(Math.fma(_t33, _t65, Math.fma(_t34, _t57, _t35 * _t64)) * _t69_inv));
        return dest;
    }

    public static long transpose_unsafe(long dest, long src) {
        for (int _i = 0; _i < 12; _i++) {
            double _eself = UnsafeOpsHolder.U.getDouble(src + _i * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _i * 8L, _eself);
        }
        return dest;
    }

    public static long add_unsafe(long dest, long src, long other) {
        for (int _i = 0; _i < 12; _i++) {
            double _eself = UnsafeOpsHolder.U.getDouble(src + _i * 8L);
            double _eother = UnsafeOpsHolder.U.getDouble(other + _i * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _i * 8L, _eother + _eself);
        }
        return dest;
    }

    public static long negate_unsafe(long dest, long src) {
        for (int _i = 0; _i < 12; _i++) {
            double _eself = UnsafeOpsHolder.U.getDouble(src + _i * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _i * 8L, -_eself);
        }
        return dest;
    }

    public static long sub_unsafe(long dest, long src, long other) {
        for (int _i = 0; _i < 12; _i++) {
            double _eself = UnsafeOpsHolder.U.getDouble(src + _i * 8L);
            double _eother = UnsafeOpsHolder.U.getDouble(other + _i * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _i * 8L, _eself - _eother);
        }
        return dest;
    }

    public static long set_unsafe(long dest, long v) {
        for (int _i = 0; _i < 12; _i++) {
            double _ev = UnsafeOpsHolder.U.getDouble(v + _i * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _i * 8L, _ev);
        }
        return dest;
    }

    public static long setMat3x3_unsafe(long dest, long m) {
        double _m00 = UnsafeOpsHolder.U.getDouble(m + 0L);
        double _m10 = UnsafeOpsHolder.U.getDouble(m + 8L);
        double _m20 = UnsafeOpsHolder.U.getDouble(m + 16L);
        double _m01 = UnsafeOpsHolder.U.getDouble(m + 24L);
        double _m11 = UnsafeOpsHolder.U.getDouble(m + 32L);
        double _m21 = UnsafeOpsHolder.U.getDouble(m + 40L);
        double _m02 = UnsafeOpsHolder.U.getDouble(m + 48L);
        double _m12 = UnsafeOpsHolder.U.getDouble(m + 56L);
        double _m22 = UnsafeOpsHolder.U.getDouble(m + 64L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, _m00);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _m01);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _m02);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, _m10);
        UnsafeOpsHolder.U.putDouble(dest + 40L, _m11);
        UnsafeOpsHolder.U.putDouble(dest + 48L, _m12);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, _m20);
        UnsafeOpsHolder.U.putDouble(dest + 72L, _m21);
        UnsafeOpsHolder.U.putDouble(dest + 80L, _m22);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long setMat4x4_unsafe(long dest, long m) {
        double _m00 = UnsafeOpsHolder.U.getDouble(m + 0L);
        double _m10 = UnsafeOpsHolder.U.getDouble(m + 8L);
        double _m20 = UnsafeOpsHolder.U.getDouble(m + 16L);
        double _m01 = UnsafeOpsHolder.U.getDouble(m + 32L);
        double _m11 = UnsafeOpsHolder.U.getDouble(m + 40L);
        double _m21 = UnsafeOpsHolder.U.getDouble(m + 48L);
        double _m02 = UnsafeOpsHolder.U.getDouble(m + 64L);
        double _m12 = UnsafeOpsHolder.U.getDouble(m + 72L);
        double _m22 = UnsafeOpsHolder.U.getDouble(m + 80L);
        double _m03 = UnsafeOpsHolder.U.getDouble(m + 96L);
        double _m13 = UnsafeOpsHolder.U.getDouble(m + 104L);
        double _m23 = UnsafeOpsHolder.U.getDouble(m + 112L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, _m00);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _m01);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _m02);
        UnsafeOpsHolder.U.putDouble(dest + 24L, _m03);
        UnsafeOpsHolder.U.putDouble(dest + 32L, _m10);
        UnsafeOpsHolder.U.putDouble(dest + 40L, _m11);
        UnsafeOpsHolder.U.putDouble(dest + 48L, _m12);
        UnsafeOpsHolder.U.putDouble(dest + 56L, _m13);
        UnsafeOpsHolder.U.putDouble(dest + 64L, _m20);
        UnsafeOpsHolder.U.putDouble(dest + 72L, _m21);
        UnsafeOpsHolder.U.putDouble(dest + 80L, _m22);
        UnsafeOpsHolder.U.putDouble(dest + 88L, _m23);
        return dest;
    }

    public static long withTranslation_unsafe(long dest, long src, double tX, double tY, double tZ) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, _self00);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _self01);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _self02);
        UnsafeOpsHolder.U.putDouble(dest + 24L, tX);
        UnsafeOpsHolder.U.putDouble(dest + 32L, _self10);
        UnsafeOpsHolder.U.putDouble(dest + 40L, _self11);
        UnsafeOpsHolder.U.putDouble(dest + 48L, _self12);
        UnsafeOpsHolder.U.putDouble(dest + 56L, tY);
        UnsafeOpsHolder.U.putDouble(dest + 64L, _self20);
        UnsafeOpsHolder.U.putDouble(dest + 72L, _self21);
        UnsafeOpsHolder.U.putDouble(dest + 80L, _self22);
        UnsafeOpsHolder.U.putDouble(dest + 88L, tZ);
        return dest;
    }

    public static long withTranslation_unsafe(long dest, long src, long t) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _tx = UnsafeOpsHolder.U.getDouble(t + 0L);
        double _ty = UnsafeOpsHolder.U.getDouble(t + 8L);
        double _tz = UnsafeOpsHolder.U.getDouble(t + 16L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, _self00);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _self01);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _self02);
        UnsafeOpsHolder.U.putDouble(dest + 24L, _tx);
        UnsafeOpsHolder.U.putDouble(dest + 32L, _self10);
        UnsafeOpsHolder.U.putDouble(dest + 40L, _self11);
        UnsafeOpsHolder.U.putDouble(dest + 48L, _self12);
        UnsafeOpsHolder.U.putDouble(dest + 56L, _ty);
        UnsafeOpsHolder.U.putDouble(dest + 64L, _self20);
        UnsafeOpsHolder.U.putDouble(dest + 72L, _self21);
        UnsafeOpsHolder.U.putDouble(dest + 80L, _self22);
        UnsafeOpsHolder.U.putDouble(dest + 88L, _tz);
        return dest;
    }

    public static long makeFromRigid_unsafe(long dest, double rTX, double rTY, double rTZ, double rRX, double rRY, double rRZ, double rRW) {
        double _t0 = rRZ * rRZ;
        double _t1 = rRZ * rRW;
        double _t2 = rRY * rRW;
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(-2.0, Math.fma(rRY, rRY, _t0), 1.0));
        UnsafeOpsHolder.U.putDouble(dest + 8L, 2.0 * Math.fma(rRX, rRY, -_t1));
        UnsafeOpsHolder.U.putDouble(dest + 16L, 2.0 * Math.fma(rRX, rRZ, _t2));
        UnsafeOpsHolder.U.putDouble(dest + 24L, rTX);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 2.0 * Math.fma(rRX, rRY, _t1));
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(-2.0, Math.fma(rRX, rRX, _t0), 1.0));
        UnsafeOpsHolder.U.putDouble(dest + 48L, 2.0 * Math.fma(rRY, rRZ, -(rRX * rRW)));
        UnsafeOpsHolder.U.putDouble(dest + 56L, rTY);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 2.0 * Math.fma(rRX, rRZ, -_t2));
        UnsafeOpsHolder.U.putDouble(dest + 72L, 2.0 * Math.fma(rRX, rRW, rRY * rRZ));
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(-2.0, Math.fma(rRX, rRX, rRY * rRY), 1.0));
        UnsafeOpsHolder.U.putDouble(dest + 88L, rTZ);
        return dest;
    }

    public static long makeFromTransform_unsafe(long dest, double tTX, double tTY, double tTZ, double tRX, double tRY, double tRZ, double tRW, double tSX, double tSY, double tSZ) {
        double _t0 = tRZ * tRZ;
        double _t1 = tRZ * tRW;
        double _t2 = tRY * tRW;
        UnsafeOpsHolder.U.putDouble(dest + 0L, tSX * Math.fma(-2.0, Math.fma(tRY, tRY, _t0), 1.0));
        UnsafeOpsHolder.U.putDouble(dest + 8L, tSY * 2.0 * Math.fma(tRX, tRY, -_t1));
        UnsafeOpsHolder.U.putDouble(dest + 16L, tSZ * 2.0 * Math.fma(tRX, tRZ, _t2));
        UnsafeOpsHolder.U.putDouble(dest + 24L, tTX);
        UnsafeOpsHolder.U.putDouble(dest + 32L, tSX * 2.0 * Math.fma(tRX, tRY, _t1));
        UnsafeOpsHolder.U.putDouble(dest + 40L, tSY * Math.fma(-2.0, Math.fma(tRX, tRX, _t0), 1.0));
        UnsafeOpsHolder.U.putDouble(dest + 48L, tSZ * 2.0 * Math.fma(tRY, tRZ, -(tRX * tRW)));
        UnsafeOpsHolder.U.putDouble(dest + 56L, tTY);
        UnsafeOpsHolder.U.putDouble(dest + 64L, tSX * 2.0 * Math.fma(tRX, tRZ, -_t2));
        UnsafeOpsHolder.U.putDouble(dest + 72L, tSY * 2.0 * Math.fma(tRX, tRW, tRY * tRZ));
        UnsafeOpsHolder.U.putDouble(dest + 80L, tSZ * Math.fma(-2.0, Math.fma(tRX, tRX, tRY * tRY), 1.0));
        UnsafeOpsHolder.U.putDouble(dest + 88L, tTZ);
        return dest;
    }

    public static long to3x3_unsafe(long dest, long src) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, _self00);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _self10);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _self20);
        UnsafeOpsHolder.U.putDouble(dest + 24L, _self01);
        UnsafeOpsHolder.U.putDouble(dest + 32L, _self11);
        UnsafeOpsHolder.U.putDouble(dest + 40L, _self21);
        UnsafeOpsHolder.U.putDouble(dest + 48L, _self02);
        UnsafeOpsHolder.U.putDouble(dest + 56L, _self12);
        UnsafeOpsHolder.U.putDouble(dest + 64L, _self22);
        return dest;
    }

    public static long to4x4_unsafe(long dest, long src) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, _self00);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _self10);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _self20);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, _self01);
        UnsafeOpsHolder.U.putDouble(dest + 40L, _self11);
        UnsafeOpsHolder.U.putDouble(dest + 48L, _self21);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, _self02);
        UnsafeOpsHolder.U.putDouble(dest + 72L, _self12);
        UnsafeOpsHolder.U.putDouble(dest + 80L, _self22);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 96L, _self03);
        UnsafeOpsHolder.U.putDouble(dest + 104L, _self13);
        UnsafeOpsHolder.U.putDouble(dest + 112L, _self23);
        UnsafeOpsHolder.U.putDouble(dest + 120L, 1.0);
        return dest;
    }

    public static long toDualQuat_unsafe(long dest, long src) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
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
        UnsafeOpsHolder.U.putDouble(dest + 0L, _t63);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _t64);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _t65);
        UnsafeOpsHolder.U.putDouble(dest + 24L, _t66);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 0.5 * Math.fma(_t0, _t64, Math.fma(_self03, _t66, _self13 * _t65)));
        UnsafeOpsHolder.U.putDouble(dest + 40L, 0.5 * Math.fma(_self23, _t63, Math.fma(_self13, _t66, -(_self03 * _t65))));
        UnsafeOpsHolder.U.putDouble(dest + 48L, 0.5 * Math.fma(_self23, _t66, Math.fma(_self03, _t64, -(_self13 * _t63))));
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.5 * Math.fma(_t0, _t65, Math.fma(-_self13, _t64, -(_self03 * _t63))));
        return dest;
    }

    public static long toRigid_unsafe(long dest, long src) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
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
            UnsafeOpsHolder.U.putDouble(dest + 24L, 0.5 * _t32 * _t61);
            UnsafeOpsHolder.U.putDouble(dest + 32L, 0.5 * _t53 * _t61);
            UnsafeOpsHolder.U.putDouble(dest + 40L, 0.5 * _t54 * _t61);
            UnsafeOpsHolder.U.putDouble(dest + 48L, 0.5 * Math.sqrt(_t60));
        } else {
            if (_t44 > _t33) {
                UnsafeOpsHolder.U.putDouble(dest + 24L, 0.5 * Math.sqrt(_t64));
                UnsafeOpsHolder.U.putDouble(dest + 32L, 0.5 * _t51 * _t67);
                UnsafeOpsHolder.U.putDouble(dest + 40L, 0.5 * _t52 * _t67);
                UnsafeOpsHolder.U.putDouble(dest + 48L, 0.5 * _t32 * _t67);
            } else {
                if (_t21 > _t16) {
                    UnsafeOpsHolder.U.putDouble(dest + 24L, 0.5 * _t51 * _t65);
                    UnsafeOpsHolder.U.putDouble(dest + 32L, 0.5 * Math.sqrt(_t62));
                    UnsafeOpsHolder.U.putDouble(dest + 40L, 0.5 * _t28 * _t65);
                    UnsafeOpsHolder.U.putDouble(dest + 48L, 0.5 * _t53 * _t65);
                } else {
                    UnsafeOpsHolder.U.putDouble(dest + 24L, 0.5 * _t52 * _t66);
                    UnsafeOpsHolder.U.putDouble(dest + 32L, 0.5 * _t28 * _t66);
                    UnsafeOpsHolder.U.putDouble(dest + 40L, 0.5 * Math.sqrt(_t63));
                    UnsafeOpsHolder.U.putDouble(dest + 48L, 0.5 * _t54 * _t66);
                }
            }
        }
        UnsafeOpsHolder.U.putDouble(dest + 0L, _self03);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _self13);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _self23);
        return dest;
    }

    public static long toTransform_unsafe(long dest, long src) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
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
        UnsafeOpsHolder.U.putDouble(dest + 0L, _self03);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _self13);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _self23);
        UnsafeOpsHolder.U.putDouble(dest + 24L, _t60 > 0.0 ? 0.5 * _t33 * _t62 : _t45 > _t34 ? 0.5 * Math.sqrt(_t65) : _t22 > _t17 ? 0.5 * _t52 * _t66 : 0.5 * _t53 * _t67);
        UnsafeOpsHolder.U.putDouble(dest + 32L, _t60 > 0.0 ? 0.5 * _t54 * _t62 : _t45 > _t34 ? 0.5 * _t52 * _t68 : _t22 > _t17 ? 0.5 * Math.sqrt(_t63) : 0.5 * _t29 * _t67);
        UnsafeOpsHolder.U.putDouble(dest + 40L, _t60 > 0.0 ? 0.5 * _t55 * _t62 : _t45 > _t34 ? 0.5 * _t53 * _t68 : _t22 > _t17 ? 0.5 * _t29 * _t66 : 0.5 * Math.sqrt(_t64));
        UnsafeOpsHolder.U.putDouble(dest + 48L, _t60 > 0.0 ? 0.5 * Math.sqrt(_t61) : _t45 > _t34 ? 0.5 * _t33 * _t68 : _t22 > _t17 ? 0.5 * _t54 * _t66 : 0.5 * _t55 * _t67);
        UnsafeOpsHolder.U.putDouble(dest + 56L, _t44 < 0.0 ? -_t15 : _t15);
        UnsafeOpsHolder.U.putDouble(dest + 64L, Math.sqrt(_t9));
        UnsafeOpsHolder.U.putDouble(dest + 72L, Math.sqrt(_t10));
        return dest;
    }

    public static long decomposeRotation_unsafe(long dest, long src) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
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
            UnsafeOpsHolder.U.putDouble(dest + 0L, 0.5 * _t60 * _t90);
            UnsafeOpsHolder.U.putDouble(dest + 8L, 0.5 * _t81 * _t90);
            UnsafeOpsHolder.U.putDouble(dest + 16L, 0.5 * _t78 * _t90);
            UnsafeOpsHolder.U.putDouble(dest + 24L, 0.5 * Math.sqrt(_t86));
        } else {
            if (_t73 > _t61) {
                UnsafeOpsHolder.U.putDouble(dest + 0L, 0.5 * Math.sqrt(_t87));
                UnsafeOpsHolder.U.putDouble(dest + 8L, 0.5 * _t77 * _t93);
                UnsafeOpsHolder.U.putDouble(dest + 16L, 0.5 * _t80 * _t93);
                UnsafeOpsHolder.U.putDouble(dest + 24L, 0.5 * _t60 * _t93);
            } else {
                if (_t36 > _t56) {
                    UnsafeOpsHolder.U.putDouble(dest + 0L, 0.5 * _t77 * _t91);
                    UnsafeOpsHolder.U.putDouble(dest + 8L, 0.5 * Math.sqrt(_t88));
                    UnsafeOpsHolder.U.putDouble(dest + 16L, 0.5 * _t63 * _t91);
                    UnsafeOpsHolder.U.putDouble(dest + 24L, 0.5 * _t81 * _t91);
                } else {
                    UnsafeOpsHolder.U.putDouble(dest + 0L, 0.5 * _t80 * _t92);
                    UnsafeOpsHolder.U.putDouble(dest + 8L, 0.5 * _t63 * _t92);
                    UnsafeOpsHolder.U.putDouble(dest + 16L, 0.5 * Math.sqrt(_t89));
                    UnsafeOpsHolder.U.putDouble(dest + 24L, 0.5 * _t78 * _t92);
                }
            }
        }
        return dest;
    }

    public static long decomposeScale_unsafe(long dest, long src) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
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
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(Math.fma(_t32, _t52, -(_t34 * _t53)), _t8, Math.fma(Math.fma(_t34, _t54, -(_t33 * _t52)), _t9, Math.fma(_t33, _t53, -(_t32 * _t54)) * _t10)) < 0.0 ? -_t4 : _t4);
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.sqrt(_t27));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.sqrt(_t47));
        return dest;
    }

    public static long decomposeSkew_unsafe(long dest, long src) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
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
            UnsafeOpsHolder.U.putDouble(dest + 8L, -_t49);
            UnsafeOpsHolder.U.putDouble(dest + 16L, -_t28);
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 8L, _t49);
            UnsafeOpsHolder.U.putDouble(dest + 16L, _t28);
        }
        UnsafeOpsHolder.U.putDouble(dest + 0L, _t37 * _t48);
        return dest;
    }

    public static long decomposeTRS_unsafe(long translation, long rotation, long scale, long src) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
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
        UnsafeOpsHolder.U.putDouble(translation + 0L, _self03);
        UnsafeOpsHolder.U.putDouble(translation + 8L, _self13);
        UnsafeOpsHolder.U.putDouble(translation + 16L, _self23);
        if (_t83 > 0.0) {
            UnsafeOpsHolder.U.putDouble(rotation + 0L, 0.5 * _t61 * _t91);
            UnsafeOpsHolder.U.putDouble(rotation + 8L, 0.5 * _t82 * _t91);
            UnsafeOpsHolder.U.putDouble(rotation + 16L, 0.5 * _t79 * _t91);
            UnsafeOpsHolder.U.putDouble(rotation + 24L, 0.5 * Math.sqrt(_t87));
        } else {
            if (_t74 > _t62) {
                UnsafeOpsHolder.U.putDouble(rotation + 0L, 0.5 * Math.sqrt(_t88));
                UnsafeOpsHolder.U.putDouble(rotation + 8L, 0.5 * _t78 * _t94);
                UnsafeOpsHolder.U.putDouble(rotation + 16L, 0.5 * _t81 * _t94);
                UnsafeOpsHolder.U.putDouble(rotation + 24L, 0.5 * _t61 * _t94);
            } else {
                if (_t37 > _t57) {
                    UnsafeOpsHolder.U.putDouble(rotation + 0L, 0.5 * _t78 * _t92);
                    UnsafeOpsHolder.U.putDouble(rotation + 8L, 0.5 * Math.sqrt(_t89));
                    UnsafeOpsHolder.U.putDouble(rotation + 16L, 0.5 * _t64 * _t92);
                    UnsafeOpsHolder.U.putDouble(rotation + 24L, 0.5 * _t82 * _t92);
                } else {
                    UnsafeOpsHolder.U.putDouble(rotation + 0L, 0.5 * _t81 * _t93);
                    UnsafeOpsHolder.U.putDouble(rotation + 8L, 0.5 * _t64 * _t93);
                    UnsafeOpsHolder.U.putDouble(rotation + 16L, 0.5 * Math.sqrt(_t90));
                    UnsafeOpsHolder.U.putDouble(rotation + 24L, 0.5 * _t79 * _t93);
                }
            }
        }
        UnsafeOpsHolder.U.putDouble(scale + 0L, _t73 < 0.0 ? -_t4 : _t4);
        UnsafeOpsHolder.U.putDouble(scale + 8L, Math.sqrt(_t30));
        UnsafeOpsHolder.U.putDouble(scale + 16L, Math.sqrt(_t50));
        return translation;
    }

    public static long makeIdentity_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long lerp_unsafe(long dest, long src, long other, double t) {
        for (int _i = 0; _i < 12; _i++) {
            double _eself = UnsafeOpsHolder.U.getDouble(src + _i * 8L);
            double _eother = UnsafeOpsHolder.U.getDouble(other + _i * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _i * 8L, Math.fma(t, _eother - _eself, _eself));
        }
        return dest;
    }

    public static long mul_unsafe(long dest, long src, long right) {
        double _right00 = UnsafeOpsHolder.U.getDouble(right + 0L);
        double _right01 = UnsafeOpsHolder.U.getDouble(right + 8L);
        double _right02 = UnsafeOpsHolder.U.getDouble(right + 16L);
        double _right03 = UnsafeOpsHolder.U.getDouble(right + 24L);
        double _right10 = UnsafeOpsHolder.U.getDouble(right + 32L);
        double _right11 = UnsafeOpsHolder.U.getDouble(right + 40L);
        double _right12 = UnsafeOpsHolder.U.getDouble(right + 48L);
        double _right13 = UnsafeOpsHolder.U.getDouble(right + 56L);
        double _right20 = UnsafeOpsHolder.U.getDouble(right + 64L);
        double _right21 = UnsafeOpsHolder.U.getDouble(right + 72L);
        double _right22 = UnsafeOpsHolder.U.getDouble(right + 80L);
        double _right23 = UnsafeOpsHolder.U.getDouble(right + 88L);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, Math.fma(_right20, _eself2, Math.fma(_right00, _eself0, _right10 * _eself1)));
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, Math.fma(_right21, _eself2, Math.fma(_right01, _eself0, _right11 * _eself1)));
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, Math.fma(_right22, _eself2, Math.fma(_right02, _eself0, _right12 * _eself1)));
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, Math.fma(_right03, _eself0, Math.fma(_right13, _eself1, Math.fma(_right23, _eself2, _eself3))));
        }
        return dest;
    }

    public static long mulMat2x2_unsafe(long dest, long src, long right) {
        double _right00 = UnsafeOpsHolder.U.getDouble(right + 0L);
        double _right10 = UnsafeOpsHolder.U.getDouble(right + 8L);
        double _right01 = UnsafeOpsHolder.U.getDouble(right + 16L);
        double _right11 = UnsafeOpsHolder.U.getDouble(right + 24L);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, Math.fma(_right00, _eself0, _right10 * _eself1));
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, Math.fma(_right01, _eself0, _right11 * _eself1));
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, _eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mulMat2x3_unsafe(long dest, long src, long right) {
        double _right00 = UnsafeOpsHolder.U.getDouble(right + 0L);
        double _right10 = UnsafeOpsHolder.U.getDouble(right + 8L);
        double _right01 = UnsafeOpsHolder.U.getDouble(right + 16L);
        double _right11 = UnsafeOpsHolder.U.getDouble(right + 24L);
        double _right02 = UnsafeOpsHolder.U.getDouble(right + 32L);
        double _right12 = UnsafeOpsHolder.U.getDouble(right + 40L);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, Math.fma(_right00, _eself0, _right10 * _eself1));
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, Math.fma(_right01, _eself0, _right11 * _eself1));
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, Math.fma(_right02, _eself0, Math.fma(_right12, _eself1, _eself2)));
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mulMat3x3_unsafe(long dest, long src, long right) {
        double _right00 = UnsafeOpsHolder.U.getDouble(right + 0L);
        double _right10 = UnsafeOpsHolder.U.getDouble(right + 8L);
        double _right20 = UnsafeOpsHolder.U.getDouble(right + 16L);
        double _right01 = UnsafeOpsHolder.U.getDouble(right + 24L);
        double _right11 = UnsafeOpsHolder.U.getDouble(right + 32L);
        double _right21 = UnsafeOpsHolder.U.getDouble(right + 40L);
        double _right02 = UnsafeOpsHolder.U.getDouble(right + 48L);
        double _right12 = UnsafeOpsHolder.U.getDouble(right + 56L);
        double _right22 = UnsafeOpsHolder.U.getDouble(right + 64L);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, Math.fma(_right20, _eself2, Math.fma(_right00, _eself0, _right10 * _eself1)));
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, Math.fma(_right21, _eself2, Math.fma(_right01, _eself0, _right11 * _eself1)));
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, Math.fma(_right22, _eself2, Math.fma(_right02, _eself0, _right12 * _eself1)));
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mulMat4x4_unsafe(long dest, long src, long right) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        for (int _l = 0; _l < 4; _l++) {
            int _lo = _l * 4;
            double _eright0 = UnsafeOpsHolder.U.getDouble(right + _lo * 8L);
            double _eright1 = UnsafeOpsHolder.U.getDouble(right + (_lo + 1) * 8L);
            double _eright2 = UnsafeOpsHolder.U.getDouble(right + (_lo + 2) * 8L);
            double _eright3 = UnsafeOpsHolder.U.getDouble(right + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, Math.fma(_eright3, _self03, Math.fma(_eright2, _self02, Math.fma(_eright0, _self00, _eright1 * _self01))));
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, Math.fma(_eright3, _self13, Math.fma(_eright2, _self12, Math.fma(_eright0, _self10, _eright1 * _self11))));
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, Math.fma(_eright3, _self23, Math.fma(_eright2, _self22, Math.fma(_eright0, _self20, _eright1 * _self21))));
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eright3);
        }
        return dest;
    }

    public static long preMul_unsafe(long dest, long src, long other) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eother0 = UnsafeOpsHolder.U.getDouble(other + _lo * 8L);
            double _eother1 = UnsafeOpsHolder.U.getDouble(other + (_lo + 1) * 8L);
            double _eother2 = UnsafeOpsHolder.U.getDouble(other + (_lo + 2) * 8L);
            double _eother3 = UnsafeOpsHolder.U.getDouble(other + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, Math.fma(_eother2, _self20, Math.fma(_eother0, _self00, _eother1 * _self10)));
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, Math.fma(_eother2, _self21, Math.fma(_eother0, _self01, _eother1 * _self11)));
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, Math.fma(_eother2, _self22, Math.fma(_eother0, _self02, _eother1 * _self12)));
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, Math.fma(_eother0, _self03, Math.fma(_eother1, _self13, Math.fma(_eother2, _self23, _eother3))));
        }
        return dest;
    }

    public static long preMulMat2x2_unsafe(long dest, long src, long other) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        double _other00 = UnsafeOpsHolder.U.getDouble(other + 0L);
        double _other10 = UnsafeOpsHolder.U.getDouble(other + 8L);
        double _other01 = UnsafeOpsHolder.U.getDouble(other + 16L);
        double _other11 = UnsafeOpsHolder.U.getDouble(other + 24L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_other00, _self00, _other01 * _self10));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_other00, _self01, _other01 * _self11));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_other00, _self02, _other01 * _self12));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(_other00, _self03, _other01 * _self13));
        UnsafeOpsHolder.U.putDouble(dest + 32L, Math.fma(_other10, _self00, _other11 * _self10));
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(_other10, _self01, _other11 * _self11));
        UnsafeOpsHolder.U.putDouble(dest + 48L, Math.fma(_other10, _self02, _other11 * _self12));
        UnsafeOpsHolder.U.putDouble(dest + 56L, Math.fma(_other10, _self03, _other11 * _self13));
        UnsafeOpsHolder.U.putDouble(dest + 64L, _self20);
        UnsafeOpsHolder.U.putDouble(dest + 72L, _self21);
        UnsafeOpsHolder.U.putDouble(dest + 80L, _self22);
        UnsafeOpsHolder.U.putDouble(dest + 88L, _self23);
        return dest;
    }

    public static long preMulMat2x3_unsafe(long dest, long src, long other) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        double _other00 = UnsafeOpsHolder.U.getDouble(other + 0L);
        double _other10 = UnsafeOpsHolder.U.getDouble(other + 8L);
        double _other01 = UnsafeOpsHolder.U.getDouble(other + 16L);
        double _other11 = UnsafeOpsHolder.U.getDouble(other + 24L);
        double _other02 = UnsafeOpsHolder.U.getDouble(other + 32L);
        double _other12 = UnsafeOpsHolder.U.getDouble(other + 40L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_other02, _self20, Math.fma(_other00, _self00, _other01 * _self10)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_other02, _self21, Math.fma(_other00, _self01, _other01 * _self11)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_other02, _self22, Math.fma(_other00, _self02, _other01 * _self12)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(_other02, _self23, Math.fma(_other00, _self03, _other01 * _self13)));
        UnsafeOpsHolder.U.putDouble(dest + 32L, Math.fma(_other12, _self20, Math.fma(_other10, _self00, _other11 * _self10)));
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(_other12, _self21, Math.fma(_other10, _self01, _other11 * _self11)));
        UnsafeOpsHolder.U.putDouble(dest + 48L, Math.fma(_other12, _self22, Math.fma(_other10, _self02, _other11 * _self12)));
        UnsafeOpsHolder.U.putDouble(dest + 56L, Math.fma(_other12, _self23, Math.fma(_other10, _self03, _other11 * _self13)));
        UnsafeOpsHolder.U.putDouble(dest + 64L, _self20);
        UnsafeOpsHolder.U.putDouble(dest + 72L, _self21);
        UnsafeOpsHolder.U.putDouble(dest + 80L, _self22);
        UnsafeOpsHolder.U.putDouble(dest + 88L, _self23);
        return dest;
    }

    public static long preMulMat3x3_unsafe(long dest, long src, long other) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        double _other00 = UnsafeOpsHolder.U.getDouble(other + 0L);
        double _other10 = UnsafeOpsHolder.U.getDouble(other + 8L);
        double _other20 = UnsafeOpsHolder.U.getDouble(other + 16L);
        double _other01 = UnsafeOpsHolder.U.getDouble(other + 24L);
        double _other11 = UnsafeOpsHolder.U.getDouble(other + 32L);
        double _other21 = UnsafeOpsHolder.U.getDouble(other + 40L);
        double _other02 = UnsafeOpsHolder.U.getDouble(other + 48L);
        double _other12 = UnsafeOpsHolder.U.getDouble(other + 56L);
        double _other22 = UnsafeOpsHolder.U.getDouble(other + 64L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_other02, _self20, Math.fma(_other00, _self00, _other01 * _self10)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_other02, _self21, Math.fma(_other00, _self01, _other01 * _self11)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_other02, _self22, Math.fma(_other00, _self02, _other01 * _self12)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(_other02, _self23, Math.fma(_other00, _self03, _other01 * _self13)));
        UnsafeOpsHolder.U.putDouble(dest + 32L, Math.fma(_other12, _self20, Math.fma(_other10, _self00, _other11 * _self10)));
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(_other12, _self21, Math.fma(_other10, _self01, _other11 * _self11)));
        UnsafeOpsHolder.U.putDouble(dest + 48L, Math.fma(_other12, _self22, Math.fma(_other10, _self02, _other11 * _self12)));
        UnsafeOpsHolder.U.putDouble(dest + 56L, Math.fma(_other12, _self23, Math.fma(_other10, _self03, _other11 * _self13)));
        UnsafeOpsHolder.U.putDouble(dest + 64L, Math.fma(_other22, _self20, Math.fma(_other20, _self00, _other21 * _self10)));
        UnsafeOpsHolder.U.putDouble(dest + 72L, Math.fma(_other22, _self21, Math.fma(_other20, _self01, _other21 * _self11)));
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(_other22, _self22, Math.fma(_other20, _self02, _other21 * _self12)));
        UnsafeOpsHolder.U.putDouble(dest + 88L, Math.fma(_other22, _self23, Math.fma(_other20, _self03, _other21 * _self13)));
        return dest;
    }

    public static long preMulMat4x4_unsafe(long dest, long src, long other) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        double _other00 = UnsafeOpsHolder.U.getDouble(other + 0L);
        double _other10 = UnsafeOpsHolder.U.getDouble(other + 8L);
        double _other20 = UnsafeOpsHolder.U.getDouble(other + 16L);
        double _other30 = UnsafeOpsHolder.U.getDouble(other + 24L);
        double _other01 = UnsafeOpsHolder.U.getDouble(other + 32L);
        double _other11 = UnsafeOpsHolder.U.getDouble(other + 40L);
        double _other21 = UnsafeOpsHolder.U.getDouble(other + 48L);
        double _other31 = UnsafeOpsHolder.U.getDouble(other + 56L);
        double _other02 = UnsafeOpsHolder.U.getDouble(other + 64L);
        double _other12 = UnsafeOpsHolder.U.getDouble(other + 72L);
        double _other22 = UnsafeOpsHolder.U.getDouble(other + 80L);
        double _other32 = UnsafeOpsHolder.U.getDouble(other + 88L);
        double _other03 = UnsafeOpsHolder.U.getDouble(other + 96L);
        double _other13 = UnsafeOpsHolder.U.getDouble(other + 104L);
        double _other23 = UnsafeOpsHolder.U.getDouble(other + 112L);
        double _other33 = UnsafeOpsHolder.U.getDouble(other + 120L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_other02, _self20, Math.fma(_other00, _self00, _other01 * _self10)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_other12, _self20, Math.fma(_other10, _self00, _other11 * _self10)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_other22, _self20, Math.fma(_other20, _self00, _other21 * _self10)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(_other32, _self20, Math.fma(_other30, _self00, _other31 * _self10)));
        UnsafeOpsHolder.U.putDouble(dest + 32L, Math.fma(_other02, _self21, Math.fma(_other00, _self01, _other01 * _self11)));
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(_other12, _self21, Math.fma(_other10, _self01, _other11 * _self11)));
        UnsafeOpsHolder.U.putDouble(dest + 48L, Math.fma(_other22, _self21, Math.fma(_other20, _self01, _other21 * _self11)));
        UnsafeOpsHolder.U.putDouble(dest + 56L, Math.fma(_other32, _self21, Math.fma(_other30, _self01, _other31 * _self11)));
        UnsafeOpsHolder.U.putDouble(dest + 64L, Math.fma(_other02, _self22, Math.fma(_other00, _self02, _other01 * _self12)));
        UnsafeOpsHolder.U.putDouble(dest + 72L, Math.fma(_other12, _self22, Math.fma(_other10, _self02, _other11 * _self12)));
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(_other22, _self22, Math.fma(_other20, _self02, _other21 * _self12)));
        UnsafeOpsHolder.U.putDouble(dest + 88L, Math.fma(_other32, _self22, Math.fma(_other30, _self02, _other31 * _self12)));
        UnsafeOpsHolder.U.putDouble(dest + 96L, Math.fma(_other00, _self03, Math.fma(_other01, _self13, Math.fma(_other02, _self23, _other03))));
        UnsafeOpsHolder.U.putDouble(dest + 104L, Math.fma(_other10, _self03, Math.fma(_other11, _self13, Math.fma(_other12, _self23, _other13))));
        UnsafeOpsHolder.U.putDouble(dest + 112L, Math.fma(_other20, _self03, Math.fma(_other21, _self13, Math.fma(_other22, _self23, _other23))));
        UnsafeOpsHolder.U.putDouble(dest + 120L, Math.fma(_other30, _self03, Math.fma(_other31, _self13, Math.fma(_other32, _self23, _other33))));
        return dest;
    }

    public static long composeTRS_unsafe(long dest, double translationX, double translationY, double translationZ, double rotationX, double rotationY, double rotationZ, double rotationW, double scaleX, double scaleY, double scaleZ) {
        double _t0 = rotationZ * rotationZ;
        double _t1 = rotationZ * rotationW;
        double _t2 = rotationY * rotationW;
        UnsafeOpsHolder.U.putDouble(dest + 0L, scaleX * Math.fma(-2.0, Math.fma(rotationY, rotationY, _t0), 1.0));
        UnsafeOpsHolder.U.putDouble(dest + 8L, scaleY * 2.0 * Math.fma(rotationX, rotationY, -_t1));
        UnsafeOpsHolder.U.putDouble(dest + 16L, scaleZ * 2.0 * Math.fma(rotationX, rotationZ, _t2));
        UnsafeOpsHolder.U.putDouble(dest + 24L, translationX);
        UnsafeOpsHolder.U.putDouble(dest + 32L, scaleX * 2.0 * Math.fma(rotationX, rotationY, _t1));
        UnsafeOpsHolder.U.putDouble(dest + 40L, scaleY * Math.fma(-2.0, Math.fma(rotationX, rotationX, _t0), 1.0));
        UnsafeOpsHolder.U.putDouble(dest + 48L, scaleZ * 2.0 * Math.fma(rotationY, rotationZ, -(rotationX * rotationW)));
        UnsafeOpsHolder.U.putDouble(dest + 56L, translationY);
        UnsafeOpsHolder.U.putDouble(dest + 64L, scaleX * 2.0 * Math.fma(rotationX, rotationZ, -_t2));
        UnsafeOpsHolder.U.putDouble(dest + 72L, scaleY * 2.0 * Math.fma(rotationX, rotationW, rotationY * rotationZ));
        UnsafeOpsHolder.U.putDouble(dest + 80L, scaleZ * Math.fma(-2.0, Math.fma(rotationX, rotationX, rotationY * rotationY), 1.0));
        UnsafeOpsHolder.U.putDouble(dest + 88L, translationZ);
        return dest;
    }

    public static long composeTRS_unsafe(long dest, long translation, long rotation, long scale) {
        double _translationx = UnsafeOpsHolder.U.getDouble(translation + 0L);
        double _translationy = UnsafeOpsHolder.U.getDouble(translation + 8L);
        double _translationz = UnsafeOpsHolder.U.getDouble(translation + 16L);
        double _rotationx = UnsafeOpsHolder.U.getDouble(rotation + 0L);
        double _rotationy = UnsafeOpsHolder.U.getDouble(rotation + 8L);
        double _rotationz = UnsafeOpsHolder.U.getDouble(rotation + 16L);
        double _rotationw = UnsafeOpsHolder.U.getDouble(rotation + 24L);
        double _scalex = UnsafeOpsHolder.U.getDouble(scale + 0L);
        double _scaley = UnsafeOpsHolder.U.getDouble(scale + 8L);
        double _scalez = UnsafeOpsHolder.U.getDouble(scale + 16L);
        double _t0 = _rotationz * _rotationz;
        double _t1 = _rotationz * _rotationw;
        double _t2 = _rotationy * _rotationw;
        UnsafeOpsHolder.U.putDouble(dest + 0L, _scalex * Math.fma(-2.0, Math.fma(_rotationy, _rotationy, _t0), 1.0));
        UnsafeOpsHolder.U.putDouble(dest + 8L, _scaley * 2.0 * Math.fma(_rotationx, _rotationy, -_t1));
        UnsafeOpsHolder.U.putDouble(dest + 16L, _scalez * 2.0 * Math.fma(_rotationx, _rotationz, _t2));
        UnsafeOpsHolder.U.putDouble(dest + 24L, _translationx);
        UnsafeOpsHolder.U.putDouble(dest + 32L, _scalex * 2.0 * Math.fma(_rotationx, _rotationy, _t1));
        UnsafeOpsHolder.U.putDouble(dest + 40L, _scaley * Math.fma(-2.0, Math.fma(_rotationx, _rotationx, _t0), 1.0));
        UnsafeOpsHolder.U.putDouble(dest + 48L, _scalez * 2.0 * Math.fma(_rotationy, _rotationz, -(_rotationx * _rotationw)));
        UnsafeOpsHolder.U.putDouble(dest + 56L, _translationy);
        UnsafeOpsHolder.U.putDouble(dest + 64L, _scalex * 2.0 * Math.fma(_rotationx, _rotationz, -_t2));
        UnsafeOpsHolder.U.putDouble(dest + 72L, _scaley * 2.0 * Math.fma(_rotationx, _rotationw, _rotationy * _rotationz));
        UnsafeOpsHolder.U.putDouble(dest + 80L, _scalez * Math.fma(-2.0, Math.fma(_rotationx, _rotationx, _rotationy * _rotationy), 1.0));
        UnsafeOpsHolder.U.putDouble(dest + 88L, _translationz);
        return dest;
    }

    public static long composeTRSMul_unsafe(long dest, long m, double translationX, double translationY, double translationZ, double rotationX, double rotationY, double rotationZ, double rotationW, double scaleX, double scaleY, double scaleZ) {
        double _m00 = UnsafeOpsHolder.U.getDouble(m + 0L);
        double _m01 = UnsafeOpsHolder.U.getDouble(m + 8L);
        double _m02 = UnsafeOpsHolder.U.getDouble(m + 16L);
        double _m03 = UnsafeOpsHolder.U.getDouble(m + 24L);
        double _m10 = UnsafeOpsHolder.U.getDouble(m + 32L);
        double _m11 = UnsafeOpsHolder.U.getDouble(m + 40L);
        double _m12 = UnsafeOpsHolder.U.getDouble(m + 48L);
        double _m13 = UnsafeOpsHolder.U.getDouble(m + 56L);
        double _m20 = UnsafeOpsHolder.U.getDouble(m + 64L);
        double _m21 = UnsafeOpsHolder.U.getDouble(m + 72L);
        double _m22 = UnsafeOpsHolder.U.getDouble(m + 80L);
        double _m23 = UnsafeOpsHolder.U.getDouble(m + 88L);
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
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_m20, _t27, Math.fma(_m00, _t33, _m10 * _t30)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_m21, _t27, Math.fma(_m01, _t33, _m11 * _t30)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_m22, _t27, Math.fma(_m02, _t33, _m12 * _t30)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(_m03, _t33, Math.fma(_m13, _t30, Math.fma(_m23, _t27, translationX))));
        UnsafeOpsHolder.U.putDouble(dest + 32L, Math.fma(_m20, _t31, Math.fma(_m00, _t28, _m10 * _t34)));
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(_m21, _t31, Math.fma(_m01, _t28, _m11 * _t34)));
        UnsafeOpsHolder.U.putDouble(dest + 48L, Math.fma(_m22, _t31, Math.fma(_m02, _t28, _m12 * _t34)));
        UnsafeOpsHolder.U.putDouble(dest + 56L, Math.fma(_m03, _t28, Math.fma(_m13, _t34, Math.fma(_m23, _t31, translationY))));
        UnsafeOpsHolder.U.putDouble(dest + 64L, Math.fma(_m20, _t35, Math.fma(_m00, _t32, _m10 * _t29)));
        UnsafeOpsHolder.U.putDouble(dest + 72L, Math.fma(_m21, _t35, Math.fma(_m01, _t32, _m11 * _t29)));
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(_m22, _t35, Math.fma(_m02, _t32, _m12 * _t29)));
        UnsafeOpsHolder.U.putDouble(dest + 88L, Math.fma(_m03, _t32, Math.fma(_m13, _t29, Math.fma(_m23, _t35, translationZ))));
        return dest;
    }

    public static long composeTRSMul_unsafe(long dest, long translation, long rotation, long scale, long m) {
        double _translationx = UnsafeOpsHolder.U.getDouble(translation + 0L);
        double _translationy = UnsafeOpsHolder.U.getDouble(translation + 8L);
        double _translationz = UnsafeOpsHolder.U.getDouble(translation + 16L);
        double _rotationx = UnsafeOpsHolder.U.getDouble(rotation + 0L);
        double _rotationy = UnsafeOpsHolder.U.getDouble(rotation + 8L);
        double _rotationz = UnsafeOpsHolder.U.getDouble(rotation + 16L);
        double _rotationw = UnsafeOpsHolder.U.getDouble(rotation + 24L);
        double _scalex = UnsafeOpsHolder.U.getDouble(scale + 0L);
        double _scaley = UnsafeOpsHolder.U.getDouble(scale + 8L);
        double _scalez = UnsafeOpsHolder.U.getDouble(scale + 16L);
        double _m00 = UnsafeOpsHolder.U.getDouble(m + 0L);
        double _m01 = UnsafeOpsHolder.U.getDouble(m + 8L);
        double _m02 = UnsafeOpsHolder.U.getDouble(m + 16L);
        double _m03 = UnsafeOpsHolder.U.getDouble(m + 24L);
        double _m10 = UnsafeOpsHolder.U.getDouble(m + 32L);
        double _m11 = UnsafeOpsHolder.U.getDouble(m + 40L);
        double _m12 = UnsafeOpsHolder.U.getDouble(m + 48L);
        double _m13 = UnsafeOpsHolder.U.getDouble(m + 56L);
        double _m20 = UnsafeOpsHolder.U.getDouble(m + 64L);
        double _m21 = UnsafeOpsHolder.U.getDouble(m + 72L);
        double _m22 = UnsafeOpsHolder.U.getDouble(m + 80L);
        double _m23 = UnsafeOpsHolder.U.getDouble(m + 88L);
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
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_m20, _t27, Math.fma(_m00, _t33, _m10 * _t30)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_m21, _t27, Math.fma(_m01, _t33, _m11 * _t30)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_m22, _t27, Math.fma(_m02, _t33, _m12 * _t30)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(_m03, _t33, Math.fma(_m13, _t30, Math.fma(_m23, _t27, _translationx))));
        UnsafeOpsHolder.U.putDouble(dest + 32L, Math.fma(_m20, _t31, Math.fma(_m00, _t28, _m10 * _t34)));
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(_m21, _t31, Math.fma(_m01, _t28, _m11 * _t34)));
        UnsafeOpsHolder.U.putDouble(dest + 48L, Math.fma(_m22, _t31, Math.fma(_m02, _t28, _m12 * _t34)));
        UnsafeOpsHolder.U.putDouble(dest + 56L, Math.fma(_m03, _t28, Math.fma(_m13, _t34, Math.fma(_m23, _t31, _translationy))));
        UnsafeOpsHolder.U.putDouble(dest + 64L, Math.fma(_m20, _t35, Math.fma(_m00, _t32, _m10 * _t29)));
        UnsafeOpsHolder.U.putDouble(dest + 72L, Math.fma(_m21, _t35, Math.fma(_m01, _t32, _m11 * _t29)));
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(_m22, _t35, Math.fma(_m02, _t32, _m12 * _t29)));
        UnsafeOpsHolder.U.putDouble(dest + 88L, Math.fma(_m03, _t32, Math.fma(_m13, _t29, Math.fma(_m23, _t35, _translationz))));
        return dest;
    }

    public static long lookAlong_unsafe(long dest, long src, double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
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
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_self02, _t26, Math.fma(_self00, _t27, _self01 * _t28)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_self02, _t35, Math.fma(_self00, _t36, _self01 * _t37)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_self02, _t9, Math.fma(_self00, _t8, _self01 * _t7)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, _self03);
        UnsafeOpsHolder.U.putDouble(dest + 32L, Math.fma(_self12, _t26, Math.fma(_self10, _t27, _self11 * _t28)));
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(_self12, _t35, Math.fma(_self10, _t36, _self11 * _t37)));
        UnsafeOpsHolder.U.putDouble(dest + 48L, Math.fma(_self12, _t9, Math.fma(_self10, _t8, _self11 * _t7)));
        UnsafeOpsHolder.U.putDouble(dest + 56L, _self13);
        UnsafeOpsHolder.U.putDouble(dest + 64L, Math.fma(_self22, _t26, Math.fma(_self20, _t27, _self21 * _t28)));
        UnsafeOpsHolder.U.putDouble(dest + 72L, Math.fma(_self22, _t35, Math.fma(_self20, _t36, _self21 * _t37)));
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(_self22, _t9, Math.fma(_self20, _t8, _self21 * _t7)));
        UnsafeOpsHolder.U.putDouble(dest + 88L, _self23);
        return dest;
    }

    public static long lookAlong_unsafe(long dest, long src, long dir, long up) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        double _dirx = UnsafeOpsHolder.U.getDouble(dir + 0L);
        double _diry = UnsafeOpsHolder.U.getDouble(dir + 8L);
        double _dirz = UnsafeOpsHolder.U.getDouble(dir + 16L);
        double _upx = UnsafeOpsHolder.U.getDouble(up + 0L);
        double _upy = UnsafeOpsHolder.U.getDouble(up + 8L);
        double _upz = UnsafeOpsHolder.U.getDouble(up + 16L);
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
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_self02, _t26, Math.fma(_self00, _t27, _self01 * _t28)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_self02, _t35, Math.fma(_self00, _t36, _self01 * _t37)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_self02, _t9, Math.fma(_self00, _t8, _self01 * _t7)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, _self03);
        UnsafeOpsHolder.U.putDouble(dest + 32L, Math.fma(_self12, _t26, Math.fma(_self10, _t27, _self11 * _t28)));
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(_self12, _t35, Math.fma(_self10, _t36, _self11 * _t37)));
        UnsafeOpsHolder.U.putDouble(dest + 48L, Math.fma(_self12, _t9, Math.fma(_self10, _t8, _self11 * _t7)));
        UnsafeOpsHolder.U.putDouble(dest + 56L, _self13);
        UnsafeOpsHolder.U.putDouble(dest + 64L, Math.fma(_self22, _t26, Math.fma(_self20, _t27, _self21 * _t28)));
        UnsafeOpsHolder.U.putDouble(dest + 72L, Math.fma(_self22, _t35, Math.fma(_self20, _t36, _self21 * _t37)));
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(_self22, _t9, Math.fma(_self20, _t8, _self21 * _t7)));
        UnsafeOpsHolder.U.putDouble(dest + 88L, _self23);
        return dest;
    }

    public static long lookAt_lh(long dest, long src, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return Double3x4OpsKernelsAddress.lookAt_lh_unsafe(dest, src, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        throw new UnsupportedOperationException("raw long address transform requires storeLoadBackend=UNSAFE");
    }

    public static long lookAt_lh_unsafe(long dest, long src, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
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
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_self02, _t10, Math.fma(_self00, _t32, _self01 * _t43)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_self02, _t11, Math.fma(_self00, _t34, _self01 * _t44)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_self02, _t12, Math.fma(_self00, _t33, _self01 * _t45)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(-_self00, _t47, Math.fma(-_self01, _t49, Math.fma(-_self02, _t24, _self03))));
        UnsafeOpsHolder.U.putDouble(dest + 32L, Math.fma(_self12, _t10, Math.fma(_self10, _t32, _self11 * _t43)));
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(_self12, _t11, Math.fma(_self10, _t34, _self11 * _t44)));
        UnsafeOpsHolder.U.putDouble(dest + 48L, Math.fma(_self12, _t12, Math.fma(_self10, _t33, _self11 * _t45)));
        UnsafeOpsHolder.U.putDouble(dest + 56L, Math.fma(-_self10, _t47, Math.fma(-_self11, _t49, Math.fma(-_self12, _t24, _self13))));
        UnsafeOpsHolder.U.putDouble(dest + 64L, Math.fma(_self22, _t10, Math.fma(_self20, _t32, _self21 * _t43)));
        UnsafeOpsHolder.U.putDouble(dest + 72L, Math.fma(_self22, _t11, Math.fma(_self20, _t34, _self21 * _t44)));
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(_self22, _t12, Math.fma(_self20, _t33, _self21 * _t45)));
        UnsafeOpsHolder.U.putDouble(dest + 88L, Math.fma(-_self20, _t47, Math.fma(-_self21, _t49, Math.fma(-_self22, _t24, _self23))));
        return dest;
    }

    public static long lookAt_rh(long dest, long src, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return Double3x4OpsKernelsAddress.lookAt_rh_unsafe(dest, src, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        throw new UnsupportedOperationException("raw long address transform requires storeLoadBackend=UNSAFE");
    }

    public static long lookAt_rh_unsafe(long dest, long src, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
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
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_t0, _t13, Math.fma(_self00, _t35, _self01 * _t46)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_t0, _t14, Math.fma(_self00, _t36, _self01 * _t47)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_t0, _t15, Math.fma(_self00, _t37, _self01 * _t48)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(-_self00, _t50, Math.fma(-_self01, _t52, Math.fma(_self02, _t27, _self03))));
        UnsafeOpsHolder.U.putDouble(dest + 32L, Math.fma(_t1, _t13, Math.fma(_self10, _t35, _self11 * _t46)));
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(_t1, _t14, Math.fma(_self10, _t36, _self11 * _t47)));
        UnsafeOpsHolder.U.putDouble(dest + 48L, Math.fma(_t1, _t15, Math.fma(_self10, _t37, _self11 * _t48)));
        UnsafeOpsHolder.U.putDouble(dest + 56L, Math.fma(-_self10, _t50, Math.fma(-_self11, _t52, Math.fma(_self12, _t27, _self13))));
        UnsafeOpsHolder.U.putDouble(dest + 64L, Math.fma(_t2, _t13, Math.fma(_self20, _t35, _self21 * _t46)));
        UnsafeOpsHolder.U.putDouble(dest + 72L, Math.fma(_t2, _t14, Math.fma(_self20, _t36, _self21 * _t47)));
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(_t2, _t15, Math.fma(_self20, _t37, _self21 * _t48)));
        UnsafeOpsHolder.U.putDouble(dest + 88L, Math.fma(-_self20, _t50, Math.fma(-_self21, _t52, Math.fma(_self22, _t27, _self23))));
        return dest;
    }

    public static long lookAt_lh(long dest, long src, long eye, long center, long up) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return Double3x4OpsKernelsAddress.lookAt_lh_unsafe(dest, src, eye, center, up);
        throw new UnsupportedOperationException("raw long address transform requires storeLoadBackend=UNSAFE");
    }

    public static long lookAt_lh_unsafe(long dest, long src, long eye, long center, long up) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        double _eyex = UnsafeOpsHolder.U.getDouble(eye + 0L);
        double _eyey = UnsafeOpsHolder.U.getDouble(eye + 8L);
        double _eyez = UnsafeOpsHolder.U.getDouble(eye + 16L);
        double _centerx = UnsafeOpsHolder.U.getDouble(center + 0L);
        double _centery = UnsafeOpsHolder.U.getDouble(center + 8L);
        double _centerz = UnsafeOpsHolder.U.getDouble(center + 16L);
        double _upx = UnsafeOpsHolder.U.getDouble(up + 0L);
        double _upy = UnsafeOpsHolder.U.getDouble(up + 8L);
        double _upz = UnsafeOpsHolder.U.getDouble(up + 16L);
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
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_self02, _t10, Math.fma(_self00, _t32, _self01 * _t43)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_self02, _t11, Math.fma(_self00, _t34, _self01 * _t44)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_self02, _t12, Math.fma(_self00, _t33, _self01 * _t45)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(-_self00, _t47, Math.fma(-_self01, _t49, Math.fma(-_self02, _t24, _self03))));
        UnsafeOpsHolder.U.putDouble(dest + 32L, Math.fma(_self12, _t10, Math.fma(_self10, _t32, _self11 * _t43)));
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(_self12, _t11, Math.fma(_self10, _t34, _self11 * _t44)));
        UnsafeOpsHolder.U.putDouble(dest + 48L, Math.fma(_self12, _t12, Math.fma(_self10, _t33, _self11 * _t45)));
        UnsafeOpsHolder.U.putDouble(dest + 56L, Math.fma(-_self10, _t47, Math.fma(-_self11, _t49, Math.fma(-_self12, _t24, _self13))));
        UnsafeOpsHolder.U.putDouble(dest + 64L, Math.fma(_self22, _t10, Math.fma(_self20, _t32, _self21 * _t43)));
        UnsafeOpsHolder.U.putDouble(dest + 72L, Math.fma(_self22, _t11, Math.fma(_self20, _t34, _self21 * _t44)));
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(_self22, _t12, Math.fma(_self20, _t33, _self21 * _t45)));
        UnsafeOpsHolder.U.putDouble(dest + 88L, Math.fma(-_self20, _t47, Math.fma(-_self21, _t49, Math.fma(-_self22, _t24, _self23))));
        return dest;
    }

    public static long lookAt_rh(long dest, long src, long eye, long center, long up) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return Double3x4OpsKernelsAddress.lookAt_rh_unsafe(dest, src, eye, center, up);
        throw new UnsupportedOperationException("raw long address transform requires storeLoadBackend=UNSAFE");
    }

    public static long lookAt_rh_unsafe(long dest, long src, long eye, long center, long up) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        double _eyex = UnsafeOpsHolder.U.getDouble(eye + 0L);
        double _eyey = UnsafeOpsHolder.U.getDouble(eye + 8L);
        double _eyez = UnsafeOpsHolder.U.getDouble(eye + 16L);
        double _centerx = UnsafeOpsHolder.U.getDouble(center + 0L);
        double _centery = UnsafeOpsHolder.U.getDouble(center + 8L);
        double _centerz = UnsafeOpsHolder.U.getDouble(center + 16L);
        double _upx = UnsafeOpsHolder.U.getDouble(up + 0L);
        double _upy = UnsafeOpsHolder.U.getDouble(up + 8L);
        double _upz = UnsafeOpsHolder.U.getDouble(up + 16L);
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
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_t0, _t13, Math.fma(_self00, _t35, _self01 * _t46)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_t0, _t14, Math.fma(_self00, _t36, _self01 * _t47)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_t0, _t15, Math.fma(_self00, _t37, _self01 * _t48)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(-_self00, _t50, Math.fma(-_self01, _t52, Math.fma(_self02, _t27, _self03))));
        UnsafeOpsHolder.U.putDouble(dest + 32L, Math.fma(_t1, _t13, Math.fma(_self10, _t35, _self11 * _t46)));
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(_t1, _t14, Math.fma(_self10, _t36, _self11 * _t47)));
        UnsafeOpsHolder.U.putDouble(dest + 48L, Math.fma(_t1, _t15, Math.fma(_self10, _t37, _self11 * _t48)));
        UnsafeOpsHolder.U.putDouble(dest + 56L, Math.fma(-_self10, _t50, Math.fma(-_self11, _t52, Math.fma(_self12, _t27, _self13))));
        UnsafeOpsHolder.U.putDouble(dest + 64L, Math.fma(_t2, _t13, Math.fma(_self20, _t35, _self21 * _t46)));
        UnsafeOpsHolder.U.putDouble(dest + 72L, Math.fma(_t2, _t14, Math.fma(_self20, _t36, _self21 * _t47)));
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(_t2, _t15, Math.fma(_self20, _t37, _self21 * _t48)));
        UnsafeOpsHolder.U.putDouble(dest + 88L, Math.fma(-_self20, _t50, Math.fma(-_self21, _t52, Math.fma(_self22, _t27, _self23))));
        return dest;
    }

    public static long makeBillboardCylindrical_unsafe(long dest, double objPosX, double objPosY, double objPosZ, double targetPosX, double targetPosY, double targetPosZ, double upX, double upY, double upZ) {
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
            UnsafeOpsHolder.U.putDouble(dest + 16L, _t30 * _t34);
            UnsafeOpsHolder.U.putDouble(dest + 48L, _t29 * _t34);
            UnsafeOpsHolder.U.putDouble(dest + 80L, _t28 * _t34);
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 48L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 80L, 0.0);
        }
        UnsafeOpsHolder.U.putDouble(dest + 0L, _t19);
        UnsafeOpsHolder.U.putDouble(dest + 8L, upX);
        UnsafeOpsHolder.U.putDouble(dest + 24L, objPosX);
        UnsafeOpsHolder.U.putDouble(dest + 32L, _t20);
        UnsafeOpsHolder.U.putDouble(dest + 40L, upY);
        UnsafeOpsHolder.U.putDouble(dest + 56L, objPosY);
        UnsafeOpsHolder.U.putDouble(dest + 64L, _t21);
        UnsafeOpsHolder.U.putDouble(dest + 72L, upZ);
        UnsafeOpsHolder.U.putDouble(dest + 88L, objPosZ);
        return dest;
    }

    public static long makeBillboardCylindrical_unsafe(long dest, long objPos, long targetPos, long up) {
        double _objPosx = UnsafeOpsHolder.U.getDouble(objPos + 0L);
        double _objPosy = UnsafeOpsHolder.U.getDouble(objPos + 8L);
        double _objPosz = UnsafeOpsHolder.U.getDouble(objPos + 16L);
        double _targetPosx = UnsafeOpsHolder.U.getDouble(targetPos + 0L);
        double _targetPosy = UnsafeOpsHolder.U.getDouble(targetPos + 8L);
        double _targetPosz = UnsafeOpsHolder.U.getDouble(targetPos + 16L);
        double _upx = UnsafeOpsHolder.U.getDouble(up + 0L);
        double _upy = UnsafeOpsHolder.U.getDouble(up + 8L);
        double _upz = UnsafeOpsHolder.U.getDouble(up + 16L);
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
            UnsafeOpsHolder.U.putDouble(dest + 16L, _t30 * _t34);
            UnsafeOpsHolder.U.putDouble(dest + 48L, _t29 * _t34);
            UnsafeOpsHolder.U.putDouble(dest + 80L, _t28 * _t34);
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 48L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 80L, 0.0);
        }
        UnsafeOpsHolder.U.putDouble(dest + 0L, _t19);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _upx);
        UnsafeOpsHolder.U.putDouble(dest + 24L, _objPosx);
        UnsafeOpsHolder.U.putDouble(dest + 32L, _t20);
        UnsafeOpsHolder.U.putDouble(dest + 40L, _upy);
        UnsafeOpsHolder.U.putDouble(dest + 56L, _objPosy);
        UnsafeOpsHolder.U.putDouble(dest + 64L, _t21);
        UnsafeOpsHolder.U.putDouble(dest + 72L, _upz);
        UnsafeOpsHolder.U.putDouble(dest + 88L, _objPosz);
        return dest;
    }

    public static long makeBillboardSpherical_unsafe(long dest, double objPosX, double objPosY, double objPosZ, double targetPosX, double targetPosY, double targetPosZ, double upX, double upY, double upZ) {
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
        UnsafeOpsHolder.U.putDouble(dest + 0L, _t29);
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_t10, _t30, -(_t12 * _t31)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, _t11);
        UnsafeOpsHolder.U.putDouble(dest + 24L, objPosX);
        UnsafeOpsHolder.U.putDouble(dest + 32L, _t31);
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(_t12, _t29, -(_t11 * _t30)));
        UnsafeOpsHolder.U.putDouble(dest + 48L, _t10);
        UnsafeOpsHolder.U.putDouble(dest + 56L, objPosY);
        UnsafeOpsHolder.U.putDouble(dest + 64L, _t30);
        UnsafeOpsHolder.U.putDouble(dest + 72L, Math.fma(_t11, _t31, -(_t10 * _t29)));
        UnsafeOpsHolder.U.putDouble(dest + 80L, _t12);
        UnsafeOpsHolder.U.putDouble(dest + 88L, objPosZ);
        return dest;
    }

    public static long makeBillboardSpherical_unsafe(long dest, long objPos, long targetPos, long up) {
        double _objPosx = UnsafeOpsHolder.U.getDouble(objPos + 0L);
        double _objPosy = UnsafeOpsHolder.U.getDouble(objPos + 8L);
        double _objPosz = UnsafeOpsHolder.U.getDouble(objPos + 16L);
        double _targetPosx = UnsafeOpsHolder.U.getDouble(targetPos + 0L);
        double _targetPosy = UnsafeOpsHolder.U.getDouble(targetPos + 8L);
        double _targetPosz = UnsafeOpsHolder.U.getDouble(targetPos + 16L);
        double _upx = UnsafeOpsHolder.U.getDouble(up + 0L);
        double _upy = UnsafeOpsHolder.U.getDouble(up + 8L);
        double _upz = UnsafeOpsHolder.U.getDouble(up + 16L);
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
        UnsafeOpsHolder.U.putDouble(dest + 0L, _t29);
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_t10, _t30, -(_t12 * _t31)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, _t11);
        UnsafeOpsHolder.U.putDouble(dest + 24L, _objPosx);
        UnsafeOpsHolder.U.putDouble(dest + 32L, _t31);
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(_t12, _t29, -(_t11 * _t30)));
        UnsafeOpsHolder.U.putDouble(dest + 48L, _t10);
        UnsafeOpsHolder.U.putDouble(dest + 56L, _objPosy);
        UnsafeOpsHolder.U.putDouble(dest + 64L, _t30);
        UnsafeOpsHolder.U.putDouble(dest + 72L, Math.fma(_t11, _t31, -(_t10 * _t29)));
        UnsafeOpsHolder.U.putDouble(dest + 80L, _t12);
        UnsafeOpsHolder.U.putDouble(dest + 88L, _objPosz);
        return dest;
    }

    public static long makeBillboardSphericalShortest_unsafe(long dest, double objPosX, double objPosY, double objPosZ, double targetPosX, double targetPosY, double targetPosZ) {
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
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_t17, _t13, 1.0));
        UnsafeOpsHolder.U.putDouble(dest + 8L, _t20);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _t22);
        UnsafeOpsHolder.U.putDouble(dest + 24L, objPosX);
        UnsafeOpsHolder.U.putDouble(dest + 32L, _t20);
        UnsafeOpsHolder.U.putDouble(dest + 40L, _t21);
        UnsafeOpsHolder.U.putDouble(dest + 48L, -_t23);
        UnsafeOpsHolder.U.putDouble(dest + 56L, objPosY);
        UnsafeOpsHolder.U.putDouble(dest + 64L, -_t22);
        UnsafeOpsHolder.U.putDouble(dest + 72L, _t23);
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(_t17, _t13, _t21));
        UnsafeOpsHolder.U.putDouble(dest + 88L, objPosZ);
        return dest;
    }

    public static long makeBillboardSphericalShortest_unsafe(long dest, long objPos, long targetPos) {
        double _objPosx = UnsafeOpsHolder.U.getDouble(objPos + 0L);
        double _objPosy = UnsafeOpsHolder.U.getDouble(objPos + 8L);
        double _objPosz = UnsafeOpsHolder.U.getDouble(objPos + 16L);
        double _targetPosx = UnsafeOpsHolder.U.getDouble(targetPos + 0L);
        double _targetPosy = UnsafeOpsHolder.U.getDouble(targetPos + 8L);
        double _targetPosz = UnsafeOpsHolder.U.getDouble(targetPos + 16L);
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
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_t17, _t13, 1.0));
        UnsafeOpsHolder.U.putDouble(dest + 8L, _t20);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _t22);
        UnsafeOpsHolder.U.putDouble(dest + 24L, _objPosx);
        UnsafeOpsHolder.U.putDouble(dest + 32L, _t20);
        UnsafeOpsHolder.U.putDouble(dest + 40L, _t21);
        UnsafeOpsHolder.U.putDouble(dest + 48L, -_t23);
        UnsafeOpsHolder.U.putDouble(dest + 56L, _objPosy);
        UnsafeOpsHolder.U.putDouble(dest + 64L, -_t22);
        UnsafeOpsHolder.U.putDouble(dest + 72L, _t23);
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(_t17, _t13, _t21));
        UnsafeOpsHolder.U.putDouble(dest + 88L, _objPosz);
        return dest;
    }

    public static long makeFromDualQuat_unsafe(long dest, double dqRX, double dqRY, double dqRZ, double dqRW, double dqDX, double dqDY, double dqDZ, double dqDW) {
        double _t0 = dqRY * dqRY;
        double _t2 = dqRZ * dqRW;
        double _t3 = dqRY * dqRW;
        double _t4 = dqRX * dqRX;
        double _t5 = dqRY * dqRZ;
        double _t6 = Math.fma(-2.0, dqRZ * dqRZ, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(-2.0, _t0, _t6));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(-2.0, _t2, 2.0 * dqRX * dqRY));
        UnsafeOpsHolder.U.putDouble(dest + 16L, 2.0 * Math.fma(dqRX, dqRZ, _t3));
        UnsafeOpsHolder.U.putDouble(dest + 24L, 2.0 * (Math.fma(dqRY, dqDZ, -(dqRZ * dqDY)) + Math.fma(dqRW, dqDX, -(dqRX * dqDW))));
        UnsafeOpsHolder.U.putDouble(dest + 32L, 2.0 * Math.fma(dqRX, dqRY, _t2));
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(-2.0, _t4, _t6));
        UnsafeOpsHolder.U.putDouble(dest + 48L, Math.fma(-2.0, dqRX * dqRW, 2.0 * _t5));
        UnsafeOpsHolder.U.putDouble(dest + 56L, 2.0 * (Math.fma(dqRZ, dqDX, -(dqRX * dqDZ)) + Math.fma(dqRW, dqDY, -(dqRY * dqDW))));
        UnsafeOpsHolder.U.putDouble(dest + 64L, Math.fma(-2.0, _t3, 2.0 * dqRX * dqRZ));
        UnsafeOpsHolder.U.putDouble(dest + 72L, 2.0 * Math.fma(dqRX, dqRW, _t5));
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(-2.0, _t4, Math.fma(-2.0, _t0, 1.0)));
        UnsafeOpsHolder.U.putDouble(dest + 88L, 2.0 * (Math.fma(dqRX, dqDY, -(dqRY * dqDX)) + Math.fma(dqRW, dqDZ, -(dqRZ * dqDW))));
        return dest;
    }

    public static long makeLookAt_lh(long dest, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return Double3x4OpsKernelsAddress.makeLookAt_lh_unsafe(dest, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        throw new UnsupportedOperationException("raw long address transform requires storeLoadBackend=UNSAFE");
    }

    public static long makeLookAt_lh_unsafe(long dest, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
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
        UnsafeOpsHolder.U.putDouble(dest + 0L, _t29);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _t30);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _t31);
        UnsafeOpsHolder.U.putDouble(dest + 24L, -Math.fma(eyeZ, _t31, Math.fma(eyeX, _t29, eyeY * _t30)));
        UnsafeOpsHolder.U.putDouble(dest + 32L, _t38);
        UnsafeOpsHolder.U.putDouble(dest + 40L, _t39);
        UnsafeOpsHolder.U.putDouble(dest + 48L, _t40);
        UnsafeOpsHolder.U.putDouble(dest + 56L, -Math.fma(eyeZ, _t40, Math.fma(eyeX, _t38, eyeY * _t39)));
        UnsafeOpsHolder.U.putDouble(dest + 64L, _t11);
        UnsafeOpsHolder.U.putDouble(dest + 72L, _t10);
        UnsafeOpsHolder.U.putDouble(dest + 80L, _t12);
        UnsafeOpsHolder.U.putDouble(dest + 88L, -Math.fma(eyeZ, _t12, Math.fma(eyeX, _t11, eyeY * _t10)));
        return dest;
    }

    public static long makeLookAt_rh(long dest, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return Double3x4OpsKernelsAddress.makeLookAt_rh_unsafe(dest, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        throw new UnsupportedOperationException("raw long address transform requires storeLoadBackend=UNSAFE");
    }

    public static long makeLookAt_rh_unsafe(long dest, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
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
        UnsafeOpsHolder.U.putDouble(dest + 0L, _t29);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _t30);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _t31);
        UnsafeOpsHolder.U.putDouble(dest + 24L, -Math.fma(eyeZ, _t31, Math.fma(eyeX, _t29, eyeY * _t30)));
        UnsafeOpsHolder.U.putDouble(dest + 32L, _t38);
        UnsafeOpsHolder.U.putDouble(dest + 40L, _t39);
        UnsafeOpsHolder.U.putDouble(dest + 48L, _t40);
        UnsafeOpsHolder.U.putDouble(dest + 56L, -Math.fma(eyeZ, _t40, Math.fma(eyeX, _t38, eyeY * _t39)));
        UnsafeOpsHolder.U.putDouble(dest + 64L, -_t10);
        UnsafeOpsHolder.U.putDouble(dest + 72L, -_t11);
        UnsafeOpsHolder.U.putDouble(dest + 80L, -_t12);
        UnsafeOpsHolder.U.putDouble(dest + 88L, Math.fma(eyeZ, _t12, Math.fma(eyeX, _t10, eyeY * _t11)));
        return dest;
    }

    public static long makeLookAt_lh(long dest, long eye, long center, long up) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return Double3x4OpsKernelsAddress.makeLookAt_lh_unsafe(dest, eye, center, up);
        throw new UnsupportedOperationException("raw long address transform requires storeLoadBackend=UNSAFE");
    }

    public static long makeLookAt_lh_unsafe(long dest, long eye, long center, long up) {
        double _eyex = UnsafeOpsHolder.U.getDouble(eye + 0L);
        double _eyey = UnsafeOpsHolder.U.getDouble(eye + 8L);
        double _eyez = UnsafeOpsHolder.U.getDouble(eye + 16L);
        double _centerx = UnsafeOpsHolder.U.getDouble(center + 0L);
        double _centery = UnsafeOpsHolder.U.getDouble(center + 8L);
        double _centerz = UnsafeOpsHolder.U.getDouble(center + 16L);
        double _upx = UnsafeOpsHolder.U.getDouble(up + 0L);
        double _upy = UnsafeOpsHolder.U.getDouble(up + 8L);
        double _upz = UnsafeOpsHolder.U.getDouble(up + 16L);
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
        UnsafeOpsHolder.U.putDouble(dest + 0L, _t29);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _t30);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _t31);
        UnsafeOpsHolder.U.putDouble(dest + 24L, -Math.fma(_eyez, _t31, Math.fma(_eyex, _t29, _eyey * _t30)));
        UnsafeOpsHolder.U.putDouble(dest + 32L, _t38);
        UnsafeOpsHolder.U.putDouble(dest + 40L, _t39);
        UnsafeOpsHolder.U.putDouble(dest + 48L, _t40);
        UnsafeOpsHolder.U.putDouble(dest + 56L, -Math.fma(_eyez, _t40, Math.fma(_eyex, _t38, _eyey * _t39)));
        UnsafeOpsHolder.U.putDouble(dest + 64L, _t11);
        UnsafeOpsHolder.U.putDouble(dest + 72L, _t10);
        UnsafeOpsHolder.U.putDouble(dest + 80L, _t12);
        UnsafeOpsHolder.U.putDouble(dest + 88L, -Math.fma(_eyez, _t12, Math.fma(_eyex, _t11, _eyey * _t10)));
        return dest;
    }

    public static long makeLookAt_rh(long dest, long eye, long center, long up) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return Double3x4OpsKernelsAddress.makeLookAt_rh_unsafe(dest, eye, center, up);
        throw new UnsupportedOperationException("raw long address transform requires storeLoadBackend=UNSAFE");
    }

    public static long makeLookAt_rh_unsafe(long dest, long eye, long center, long up) {
        double _eyex = UnsafeOpsHolder.U.getDouble(eye + 0L);
        double _eyey = UnsafeOpsHolder.U.getDouble(eye + 8L);
        double _eyez = UnsafeOpsHolder.U.getDouble(eye + 16L);
        double _centerx = UnsafeOpsHolder.U.getDouble(center + 0L);
        double _centery = UnsafeOpsHolder.U.getDouble(center + 8L);
        double _centerz = UnsafeOpsHolder.U.getDouble(center + 16L);
        double _upx = UnsafeOpsHolder.U.getDouble(up + 0L);
        double _upy = UnsafeOpsHolder.U.getDouble(up + 8L);
        double _upz = UnsafeOpsHolder.U.getDouble(up + 16L);
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
        UnsafeOpsHolder.U.putDouble(dest + 0L, _t29);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _t30);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _t31);
        UnsafeOpsHolder.U.putDouble(dest + 24L, -Math.fma(_eyez, _t31, Math.fma(_eyex, _t29, _eyey * _t30)));
        UnsafeOpsHolder.U.putDouble(dest + 32L, _t38);
        UnsafeOpsHolder.U.putDouble(dest + 40L, _t39);
        UnsafeOpsHolder.U.putDouble(dest + 48L, _t40);
        UnsafeOpsHolder.U.putDouble(dest + 56L, -Math.fma(_eyez, _t40, Math.fma(_eyex, _t38, _eyey * _t39)));
        UnsafeOpsHolder.U.putDouble(dest + 64L, -_t10);
        UnsafeOpsHolder.U.putDouble(dest + 72L, -_t11);
        UnsafeOpsHolder.U.putDouble(dest + 80L, -_t12);
        UnsafeOpsHolder.U.putDouble(dest + 88L, Math.fma(_eyez, _t12, Math.fma(_eyex, _t10, _eyey * _t11)));
        return dest;
    }

    public static long makeMappingXYZ_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingXYnZ_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingXZY_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingXZnY_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingXnYZ_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingXnYnZ_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingXnZY_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingXnZnY_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingYXZ_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingYXnZ_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingYZX_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingYZnX_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingYnXZ_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingYnXnZ_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingYnZX_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingYnZnX_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingZXY_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingZXnY_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingZYX_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingZYnX_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingZnXY_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingZnXnY_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingZnYX_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingZnYnX_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingnXYZ_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingnXYnZ_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingnXZY_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingnXZnY_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingnXnYZ_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingnXnYnZ_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingnXnZY_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingnXnZnY_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingnYXZ_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingnYXnZ_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingnYZX_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingnYZnX_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingnYnXZ_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingnYnXnZ_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingnYnZX_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingnYnZnX_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingnZXY_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingnZXnY_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingnZYX_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingnZYnX_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingnZnXY_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingnZnXnY_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingnZnYX_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeMappingnZnYnX_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, -1.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeReflection_unsafe(long dest, double normalX, double normalY, double normalZ) {
        double _t6 = -(2.0 * normalX * normalY);
        double _t7 = -(2.0 * normalX * normalZ);
        double _t8 = -(2.0 * normalY * normalZ);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(-2.0, normalX * normalX, 1.0));
        UnsafeOpsHolder.U.putDouble(dest + 8L, _t6);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _t7);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, _t6);
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(-2.0, normalY * normalY, 1.0));
        UnsafeOpsHolder.U.putDouble(dest + 48L, _t8);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, _t7);
        UnsafeOpsHolder.U.putDouble(dest + 72L, _t8);
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(-2.0, normalZ * normalZ, 1.0));
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeReflection_unsafe(long dest, long normal) {
        double _normalx = UnsafeOpsHolder.U.getDouble(normal + 0L);
        double _normaly = UnsafeOpsHolder.U.getDouble(normal + 8L);
        double _normalz = UnsafeOpsHolder.U.getDouble(normal + 16L);
        double _t6 = -(2.0 * _normalx * _normaly);
        double _t7 = -(2.0 * _normalx * _normalz);
        double _t8 = -(2.0 * _normaly * _normalz);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(-2.0, _normalx * _normalx, 1.0));
        UnsafeOpsHolder.U.putDouble(dest + 8L, _t6);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _t7);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, _t6);
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(-2.0, _normaly * _normaly, 1.0));
        UnsafeOpsHolder.U.putDouble(dest + 48L, _t8);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, _t7);
        UnsafeOpsHolder.U.putDouble(dest + 72L, _t8);
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(-2.0, _normalz * _normalz, 1.0));
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeRotationAxis_unsafe(long dest, double angle, double axisX, double axisY, double axisZ) {
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t2 = 1.0 - _t0;
        double _t3 = axisX * axisY;
        double _t4 = axisX * axisZ;
        double _t5 = axisY * axisZ;
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_t2, axisX * axisX, _t0));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_t2, _t3, -(axisZ * _t1)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(axisY, _t1, _t2 * _t4));
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, Math.fma(axisZ, _t1, _t2 * _t3));
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(_t2, axisY * axisY, _t0));
        UnsafeOpsHolder.U.putDouble(dest + 48L, Math.fma(_t2, _t5, -(axisX * _t1)));
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, Math.fma(_t2, _t4, -(axisY * _t1)));
        UnsafeOpsHolder.U.putDouble(dest + 72L, Math.fma(axisX, _t1, _t2 * _t5));
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(_t2, axisZ * axisZ, _t0));
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeRotationAxis_unsafe(long dest, long axis, double angle) {
        double _axisx = UnsafeOpsHolder.U.getDouble(axis + 0L);
        double _axisy = UnsafeOpsHolder.U.getDouble(axis + 8L);
        double _axisz = UnsafeOpsHolder.U.getDouble(axis + 16L);
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t2 = 1.0 - _t0;
        double _t3 = _axisx * _axisy;
        double _t4 = _axisx * _axisz;
        double _t5 = _axisy * _axisz;
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_t2, _axisx * _axisx, _t0));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_t2, _t3, -(_axisz * _t1)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_axisy, _t1, _t2 * _t4));
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, Math.fma(_axisz, _t1, _t2 * _t3));
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(_t2, _axisy * _axisy, _t0));
        UnsafeOpsHolder.U.putDouble(dest + 48L, Math.fma(_t2, _t5, -(_axisx * _t1)));
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, Math.fma(_t2, _t4, -(_axisy * _t1)));
        UnsafeOpsHolder.U.putDouble(dest + 72L, Math.fma(_axisx, _t1, _t2 * _t5));
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(_t2, _axisz * _axisz, _t0));
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeRotationLookAlong_unsafe(long dest, double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
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
        UnsafeOpsHolder.U.putDouble(dest + 0L, _t26);
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_t7, _t27, -(_t9 * _t28)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, _t8);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, _t28);
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(_t9, _t26, -(_t8 * _t27)));
        UnsafeOpsHolder.U.putDouble(dest + 48L, _t7);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, _t27);
        UnsafeOpsHolder.U.putDouble(dest + 72L, Math.fma(_t8, _t28, -(_t7 * _t26)));
        UnsafeOpsHolder.U.putDouble(dest + 80L, _t9);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeRotationLookAlong_unsafe(long dest, long dir, long up) {
        double _dirx = UnsafeOpsHolder.U.getDouble(dir + 0L);
        double _diry = UnsafeOpsHolder.U.getDouble(dir + 8L);
        double _dirz = UnsafeOpsHolder.U.getDouble(dir + 16L);
        double _upx = UnsafeOpsHolder.U.getDouble(up + 0L);
        double _upy = UnsafeOpsHolder.U.getDouble(up + 8L);
        double _upz = UnsafeOpsHolder.U.getDouble(up + 16L);
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
        UnsafeOpsHolder.U.putDouble(dest + 0L, _t26);
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_t7, _t27, -(_t9 * _t28)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, _t8);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, _t28);
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(_t9, _t26, -(_t8 * _t27)));
        UnsafeOpsHolder.U.putDouble(dest + 48L, _t7);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, _t27);
        UnsafeOpsHolder.U.putDouble(dest + 72L, Math.fma(_t8, _t28, -(_t7 * _t26)));
        UnsafeOpsHolder.U.putDouble(dest + 80L, _t9);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeRotationQuat_unsafe(long dest, double qX, double qY, double qZ, double qW) {
        double _t0 = qZ * qZ;
        double _t1 = qZ * qW;
        double _t2 = qY * qW;
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(-2.0, Math.fma(qY, qY, _t0), 1.0));
        UnsafeOpsHolder.U.putDouble(dest + 8L, 2.0 * Math.fma(qX, qY, -_t1));
        UnsafeOpsHolder.U.putDouble(dest + 16L, 2.0 * Math.fma(qX, qZ, _t2));
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 2.0 * Math.fma(qX, qY, _t1));
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(-2.0, Math.fma(qX, qX, _t0), 1.0));
        UnsafeOpsHolder.U.putDouble(dest + 48L, 2.0 * Math.fma(qY, qZ, -(qX * qW)));
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 2.0 * Math.fma(qX, qZ, -_t2));
        UnsafeOpsHolder.U.putDouble(dest + 72L, 2.0 * Math.fma(qX, qW, qY * qZ));
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(-2.0, Math.fma(qX, qX, qY * qY), 1.0));
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeRotationQuat_unsafe(long dest, long q) {
        double _qx = UnsafeOpsHolder.U.getDouble(q + 0L);
        double _qy = UnsafeOpsHolder.U.getDouble(q + 8L);
        double _qz = UnsafeOpsHolder.U.getDouble(q + 16L);
        double _qw = UnsafeOpsHolder.U.getDouble(q + 24L);
        double _t0 = _qz * _qz;
        double _t1 = _qz * _qw;
        double _t2 = _qy * _qw;
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(-2.0, Math.fma(_qy, _qy, _t0), 1.0));
        UnsafeOpsHolder.U.putDouble(dest + 8L, 2.0 * Math.fma(_qx, _qy, -_t1));
        UnsafeOpsHolder.U.putDouble(dest + 16L, 2.0 * Math.fma(_qx, _qz, _t2));
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 2.0 * Math.fma(_qx, _qy, _t1));
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(-2.0, Math.fma(_qx, _qx, _t0), 1.0));
        UnsafeOpsHolder.U.putDouble(dest + 48L, 2.0 * Math.fma(_qy, _qz, -(_qx * _qw)));
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 2.0 * Math.fma(_qx, _qz, -_t2));
        UnsafeOpsHolder.U.putDouble(dest + 72L, 2.0 * Math.fma(_qx, _qw, _qy * _qz));
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(-2.0, Math.fma(_qx, _qx, _qy * _qy), 1.0));
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeRotationX_unsafe(long dest, double angle) {
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        UnsafeOpsHolder.U.putDouble(dest + 0L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, _t0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, -_t1);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, _t1);
        UnsafeOpsHolder.U.putDouble(dest + 80L, _t0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeRotationXYZ_unsafe(long dest, double angleX, double angleY, double angleZ) {
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleZ);
        double _t3 = Math.sin(angleY);
        double _t4 = Math.sin(angleX);
        double _t5 = Math.cos(angleX);
        double _t6 = _t4 * _t3;
        double _t7 = _t3 * _t5;
        UnsafeOpsHolder.U.putDouble(dest + 0L, _t0 * _t1);
        UnsafeOpsHolder.U.putDouble(dest + 8L, -(_t2 * _t0));
        UnsafeOpsHolder.U.putDouble(dest + 16L, _t3);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, Math.fma(_t6, _t1, _t2 * _t5));
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(_t5, _t1, -(_t6 * _t2)));
        UnsafeOpsHolder.U.putDouble(dest + 48L, -(_t4 * _t0));
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, Math.fma(_t4, _t2, -(_t7 * _t1)));
        UnsafeOpsHolder.U.putDouble(dest + 72L, Math.fma(_t7, _t2, _t4 * _t1));
        UnsafeOpsHolder.U.putDouble(dest + 80L, _t5 * _t0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeRotationXZY_unsafe(long dest, double angleX, double angleY, double angleZ) {
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleZ);
        double _t3 = Math.sin(angleY);
        double _t4 = Math.cos(angleX);
        double _t5 = Math.sin(angleX);
        double _t6 = _t2 * _t4;
        double _t7 = _t5 * _t2;
        UnsafeOpsHolder.U.putDouble(dest + 0L, _t0 * _t1);
        UnsafeOpsHolder.U.putDouble(dest + 8L, -_t2);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _t3 * _t1);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, Math.fma(_t6, _t0, _t5 * _t3));
        UnsafeOpsHolder.U.putDouble(dest + 40L, _t4 * _t1);
        UnsafeOpsHolder.U.putDouble(dest + 48L, Math.fma(_t6, _t3, -(_t5 * _t0)));
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, Math.fma(_t7, _t0, -(_t3 * _t4)));
        UnsafeOpsHolder.U.putDouble(dest + 72L, _t5 * _t1);
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(_t7, _t3, _t4 * _t0));
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeRotationY_unsafe(long dest, double angle) {
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        UnsafeOpsHolder.U.putDouble(dest + 0L, _t0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _t1);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, -_t1);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, _t0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeRotationYXZ_unsafe(long dest, double angleX, double angleY, double angleZ) {
        double _t0 = Math.sin(angleX);
        double _t1 = Math.sin(angleY);
        double _t2 = Math.sin(angleZ);
        double _t3 = Math.cos(angleY);
        double _t4 = Math.cos(angleZ);
        double _t5 = Math.cos(angleX);
        double _t6 = _t0 * _t1;
        double _t7 = _t0 * _t3;
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_t6, _t2, _t3 * _t4));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_t6, _t4, -(_t2 * _t3)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, _t1 * _t5);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, _t2 * _t5);
        UnsafeOpsHolder.U.putDouble(dest + 40L, _t5 * _t4);
        UnsafeOpsHolder.U.putDouble(dest + 48L, -_t0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, Math.fma(_t7, _t2, -(_t1 * _t4)));
        UnsafeOpsHolder.U.putDouble(dest + 72L, Math.fma(_t7, _t4, _t1 * _t2));
        UnsafeOpsHolder.U.putDouble(dest + 80L, _t5 * _t3);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeRotationYZX_unsafe(long dest, double angleX, double angleY, double angleZ) {
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleX);
        double _t3 = Math.sin(angleY);
        double _t4 = Math.sin(angleZ);
        double _t5 = Math.cos(angleX);
        double _t6 = _t4 * _t0;
        double _t7 = _t3 * _t4;
        UnsafeOpsHolder.U.putDouble(dest + 0L, _t0 * _t1);
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_t2, _t3, -(_t6 * _t5)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_t6, _t2, _t3 * _t5));
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, _t4);
        UnsafeOpsHolder.U.putDouble(dest + 40L, _t5 * _t1);
        UnsafeOpsHolder.U.putDouble(dest + 48L, -(_t2 * _t1));
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, -(_t3 * _t1));
        UnsafeOpsHolder.U.putDouble(dest + 72L, Math.fma(_t7, _t5, _t2 * _t0));
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(_t5, _t0, -(_t7 * _t2)));
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeRotationZ_unsafe(long dest, double angle) {
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        UnsafeOpsHolder.U.putDouble(dest + 0L, _t0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, -_t1);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, _t1);
        UnsafeOpsHolder.U.putDouble(dest + 40L, _t0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeRotationZXY_unsafe(long dest, double angleX, double angleY, double angleZ) {
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleX);
        double _t3 = Math.sin(angleZ);
        double _t4 = Math.sin(angleY);
        double _t5 = Math.cos(angleX);
        double _t6 = _t2 * _t3;
        double _t7 = _t2 * _t1;
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_t0, _t1, -(_t6 * _t4)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, -(_t3 * _t5));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_t6, _t0, _t4 * _t1));
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, Math.fma(_t7, _t4, _t3 * _t0));
        UnsafeOpsHolder.U.putDouble(dest + 40L, _t5 * _t1);
        UnsafeOpsHolder.U.putDouble(dest + 48L, Math.fma(_t4, _t3, -(_t7 * _t0)));
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, -(_t4 * _t5));
        UnsafeOpsHolder.U.putDouble(dest + 72L, _t2);
        UnsafeOpsHolder.U.putDouble(dest + 80L, _t5 * _t0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeRotationZYX_unsafe(long dest, double angleX, double angleY, double angleZ) {
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleY);
        double _t3 = Math.sin(angleX);
        double _t4 = Math.sin(angleZ);
        double _t5 = Math.cos(angleX);
        double _t6 = _t2 * _t1;
        double _t7 = _t2 * _t4;
        UnsafeOpsHolder.U.putDouble(dest + 0L, _t0 * _t1);
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_t6, _t3, -(_t4 * _t5)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_t6, _t5, _t3 * _t4));
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, _t4 * _t0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(_t7, _t3, _t5 * _t1));
        UnsafeOpsHolder.U.putDouble(dest + 48L, Math.fma(_t7, _t5, -(_t3 * _t1)));
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, -_t2);
        UnsafeOpsHolder.U.putDouble(dest + 72L, _t3 * _t0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, _t5 * _t0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeScaling_unsafe(long dest, double vX, double vY, double vZ) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, vX);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, vY);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, vZ);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeScaling_unsafe(long dest, long v) {
        double _vx = UnsafeOpsHolder.U.getDouble(v + 0L);
        double _vy = UnsafeOpsHolder.U.getDouble(v + 8L);
        double _vz = UnsafeOpsHolder.U.getDouble(v + 16L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, _vx);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, _vy);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, _vz);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeScaling_unsafe(long dest, double s) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, s);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, s);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, s);
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long makeTranslation_unsafe(long dest, double vX, double vY, double vZ) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, vX);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, vY);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, vZ);
        return dest;
    }

    public static long makeTranslation_unsafe(long dest, long v) {
        double _vx = UnsafeOpsHolder.U.getDouble(v + 0L);
        double _vy = UnsafeOpsHolder.U.getDouble(v + 8L);
        double _vz = UnsafeOpsHolder.U.getDouble(v + 16L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, _vx);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, _vy);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 72L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 80L, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 88L, _vz);
        return dest;
    }

    public static long mapXYZ_unsafe(long dest, long src) {
        for (int _i = 0; _i < 12; _i++) {
            double _eself = UnsafeOpsHolder.U.getDouble(src + _i * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _i * 8L, _eself);
        }
        return dest;
    }

    public static long mapXYnZ_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, _eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, _eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, -_eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapXZY_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, _eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, _eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, _eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapXZnY_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, _eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, _eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, -_eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapXnYZ_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, _eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, -_eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, _eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapXnYnZ_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, _eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, -_eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, -_eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapXnZY_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, _eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, -_eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, _eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapXnZnY_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, _eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, -_eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, -_eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapYXZ_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, _eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, _eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, _eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapYXnZ_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, _eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, _eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, -_eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapYZX_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, _eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, _eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, _eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapYZnX_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, _eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, _eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, -_eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapYnXZ_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, _eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, -_eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, _eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapYnXnZ_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, _eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, -_eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, -_eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapYnZX_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, _eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, -_eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, _eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapYnZnX_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, _eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, -_eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, -_eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapZXY_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, _eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, _eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, _eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapZXnY_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, _eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, _eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, -_eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapZYX_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, _eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, _eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, _eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapZYnX_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, _eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, _eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, -_eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapZnXY_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, _eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, -_eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, _eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapZnXnY_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, _eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, -_eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, -_eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapZnYX_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, _eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, -_eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, _eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapZnYnX_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, _eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, -_eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, -_eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapnXYZ_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, -_eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, _eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, _eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapnXYnZ_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, -_eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, _eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, -_eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapnXZY_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, -_eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, _eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, _eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapnXZnY_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, -_eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, _eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, -_eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapnXnYZ_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, -_eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, -_eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, _eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapnXnYnZ_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, -_eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, -_eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, -_eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapnXnZY_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, -_eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, -_eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, _eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapnXnZnY_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, -_eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, -_eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, -_eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapnYXZ_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, -_eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, _eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, _eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapnYXnZ_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, -_eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, _eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, -_eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapnYZX_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, -_eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, _eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, _eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapnYZnX_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, -_eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, _eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, -_eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapnYnXZ_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, -_eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, -_eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, _eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapnYnXnZ_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, -_eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, -_eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, -_eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapnYnZX_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, -_eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, -_eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, _eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapnYnZnX_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, -_eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, -_eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, -_eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapnZXY_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, -_eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, _eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, _eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapnZXnY_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, -_eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, _eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, -_eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapnZYX_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, -_eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, _eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, _eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapnZYnX_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, -_eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, _eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, -_eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapnZnXY_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, -_eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, -_eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, _eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapnZnXnY_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, -_eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, -_eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, -_eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapnZnYX_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, -_eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, -_eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, _eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long mapnZnYnX_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, -_eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, -_eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, -_eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long preRotateAround_unsafe(long dest, long src, double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        double _t0 = -pivotX;
        double _t1 = -pivotY;
        double _t2 = -pivotZ;
        double _t3 = rotY * rotW;
        double _t4 = rotZ * rotZ;
        double _t5 = rotZ * rotW;
        double _t21 = 2.0 * Math.fma(rotX, rotZ, _t3);
        double _t22 = 2.0 * Math.fma(rotX, rotY, _t5);
        double _t23 = 2.0 * Math.fma(rotX, rotW, rotY * rotZ);
        double _t24 = 2.0 * Math.fma(rotX, rotY, -_t5);
        double _t25 = 2.0 * Math.fma(rotY, rotZ, -(rotX * rotW));
        double _t26 = 2.0 * Math.fma(rotX, rotZ, -_t3);
        double _t27 = Math.fma(-2.0, Math.fma(rotY, rotY, _t4), 1.0);
        double _t28 = Math.fma(-2.0, Math.fma(rotX, rotX, _t4), 1.0);
        double _t29 = Math.fma(-2.0, Math.fma(rotX, rotX, rotY * rotY), 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_self20, _t21, Math.fma(_self00, _t27, _self10 * _t24)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_self21, _t21, Math.fma(_self01, _t27, _self11 * _t24)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_self22, _t21, Math.fma(_self02, _t27, _self12 * _t24)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(_t0, _t27, Math.fma(_t1, _t24, Math.fma(_t2, _t21, Math.fma(_self03, _t27, Math.fma(_self13, _t24, Math.fma(_self23, _t21, pivotX)))))));
        UnsafeOpsHolder.U.putDouble(dest + 32L, Math.fma(_self20, _t25, Math.fma(_self00, _t22, _self10 * _t28)));
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(_self21, _t25, Math.fma(_self01, _t22, _self11 * _t28)));
        UnsafeOpsHolder.U.putDouble(dest + 48L, Math.fma(_self22, _t25, Math.fma(_self02, _t22, _self12 * _t28)));
        UnsafeOpsHolder.U.putDouble(dest + 56L, Math.fma(_t0, _t22, Math.fma(_t1, _t28, Math.fma(_t2, _t25, Math.fma(_self03, _t22, Math.fma(_self13, _t28, Math.fma(_self23, _t25, pivotY)))))));
        UnsafeOpsHolder.U.putDouble(dest + 64L, Math.fma(_self20, _t29, Math.fma(_self00, _t26, _self10 * _t23)));
        UnsafeOpsHolder.U.putDouble(dest + 72L, Math.fma(_self21, _t29, Math.fma(_self01, _t26, _self11 * _t23)));
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(_self22, _t29, Math.fma(_self02, _t26, _self12 * _t23)));
        UnsafeOpsHolder.U.putDouble(dest + 88L, Math.fma(_t0, _t26, Math.fma(_t1, _t23, Math.fma(_t2, _t29, Math.fma(_self03, _t26, Math.fma(_self13, _t23, Math.fma(_self23, _t29, pivotZ)))))));
        return dest;
    }

    public static long preRotateAround_unsafe(long dest, long src, long rot, long pivot) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        double _rotx = UnsafeOpsHolder.U.getDouble(rot + 0L);
        double _roty = UnsafeOpsHolder.U.getDouble(rot + 8L);
        double _rotz = UnsafeOpsHolder.U.getDouble(rot + 16L);
        double _rotw = UnsafeOpsHolder.U.getDouble(rot + 24L);
        double _pivotx = UnsafeOpsHolder.U.getDouble(pivot + 0L);
        double _pivoty = UnsafeOpsHolder.U.getDouble(pivot + 8L);
        double _pivotz = UnsafeOpsHolder.U.getDouble(pivot + 16L);
        double _t0 = -_pivotx;
        double _t1 = -_pivoty;
        double _t2 = -_pivotz;
        double _t3 = _roty * _rotw;
        double _t4 = _rotz * _rotz;
        double _t5 = _rotz * _rotw;
        double _t21 = 2.0 * Math.fma(_rotx, _rotz, _t3);
        double _t22 = 2.0 * Math.fma(_rotx, _roty, _t5);
        double _t23 = 2.0 * Math.fma(_rotx, _rotw, _roty * _rotz);
        double _t24 = 2.0 * Math.fma(_rotx, _roty, -_t5);
        double _t25 = 2.0 * Math.fma(_roty, _rotz, -(_rotx * _rotw));
        double _t26 = 2.0 * Math.fma(_rotx, _rotz, -_t3);
        double _t27 = Math.fma(-2.0, Math.fma(_roty, _roty, _t4), 1.0);
        double _t28 = Math.fma(-2.0, Math.fma(_rotx, _rotx, _t4), 1.0);
        double _t29 = Math.fma(-2.0, Math.fma(_rotx, _rotx, _roty * _roty), 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_self20, _t21, Math.fma(_self00, _t27, _self10 * _t24)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_self21, _t21, Math.fma(_self01, _t27, _self11 * _t24)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_self22, _t21, Math.fma(_self02, _t27, _self12 * _t24)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(_t0, _t27, Math.fma(_t1, _t24, Math.fma(_t2, _t21, Math.fma(_self03, _t27, Math.fma(_self13, _t24, Math.fma(_self23, _t21, _pivotx)))))));
        UnsafeOpsHolder.U.putDouble(dest + 32L, Math.fma(_self20, _t25, Math.fma(_self00, _t22, _self10 * _t28)));
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(_self21, _t25, Math.fma(_self01, _t22, _self11 * _t28)));
        UnsafeOpsHolder.U.putDouble(dest + 48L, Math.fma(_self22, _t25, Math.fma(_self02, _t22, _self12 * _t28)));
        UnsafeOpsHolder.U.putDouble(dest + 56L, Math.fma(_t0, _t22, Math.fma(_t1, _t28, Math.fma(_t2, _t25, Math.fma(_self03, _t22, Math.fma(_self13, _t28, Math.fma(_self23, _t25, _pivoty)))))));
        UnsafeOpsHolder.U.putDouble(dest + 64L, Math.fma(_self20, _t29, Math.fma(_self00, _t26, _self10 * _t23)));
        UnsafeOpsHolder.U.putDouble(dest + 72L, Math.fma(_self21, _t29, Math.fma(_self01, _t26, _self11 * _t23)));
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(_self22, _t29, Math.fma(_self02, _t26, _self12 * _t23)));
        UnsafeOpsHolder.U.putDouble(dest + 88L, Math.fma(_t0, _t26, Math.fma(_t1, _t23, Math.fma(_t2, _t29, Math.fma(_self03, _t26, Math.fma(_self13, _t23, Math.fma(_self23, _t29, _pivotz)))))));
        return dest;
    }

    public static long preRotateAxis_unsafe(long dest, long src, double angle, double axisX, double axisY, double axisZ) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
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
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_self20, _t21, Math.fma(_self00, _t18, _self10 * _t24)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_self21, _t21, Math.fma(_self01, _t18, _self11 * _t24)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_self22, _t21, Math.fma(_self02, _t18, _self12 * _t24)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(_self23, _t21, Math.fma(_self03, _t18, _self13 * _t24)));
        UnsafeOpsHolder.U.putDouble(dest + 32L, Math.fma(_self20, _t25, Math.fma(_self00, _t22, _self10 * _t19)));
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(_self21, _t25, Math.fma(_self01, _t22, _self11 * _t19)));
        UnsafeOpsHolder.U.putDouble(dest + 48L, Math.fma(_self22, _t25, Math.fma(_self02, _t22, _self12 * _t19)));
        UnsafeOpsHolder.U.putDouble(dest + 56L, Math.fma(_self23, _t25, Math.fma(_self03, _t22, _self13 * _t19)));
        UnsafeOpsHolder.U.putDouble(dest + 64L, Math.fma(_self20, _t20, Math.fma(_self00, _t26, _self10 * _t23)));
        UnsafeOpsHolder.U.putDouble(dest + 72L, Math.fma(_self21, _t20, Math.fma(_self01, _t26, _self11 * _t23)));
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(_self22, _t20, Math.fma(_self02, _t26, _self12 * _t23)));
        UnsafeOpsHolder.U.putDouble(dest + 88L, Math.fma(_self23, _t20, Math.fma(_self03, _t26, _self13 * _t23)));
        return dest;
    }

    public static long preRotateAxis_unsafe(long dest, long src, long axis, double angle) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        double _axisx = UnsafeOpsHolder.U.getDouble(axis + 0L);
        double _axisy = UnsafeOpsHolder.U.getDouble(axis + 8L);
        double _axisz = UnsafeOpsHolder.U.getDouble(axis + 16L);
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
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_self20, _t21, Math.fma(_self00, _t18, _self10 * _t24)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_self21, _t21, Math.fma(_self01, _t18, _self11 * _t24)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_self22, _t21, Math.fma(_self02, _t18, _self12 * _t24)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(_self23, _t21, Math.fma(_self03, _t18, _self13 * _t24)));
        UnsafeOpsHolder.U.putDouble(dest + 32L, Math.fma(_self20, _t25, Math.fma(_self00, _t22, _self10 * _t19)));
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(_self21, _t25, Math.fma(_self01, _t22, _self11 * _t19)));
        UnsafeOpsHolder.U.putDouble(dest + 48L, Math.fma(_self22, _t25, Math.fma(_self02, _t22, _self12 * _t19)));
        UnsafeOpsHolder.U.putDouble(dest + 56L, Math.fma(_self23, _t25, Math.fma(_self03, _t22, _self13 * _t19)));
        UnsafeOpsHolder.U.putDouble(dest + 64L, Math.fma(_self20, _t20, Math.fma(_self00, _t26, _self10 * _t23)));
        UnsafeOpsHolder.U.putDouble(dest + 72L, Math.fma(_self21, _t20, Math.fma(_self01, _t26, _self11 * _t23)));
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(_self22, _t20, Math.fma(_self02, _t26, _self12 * _t23)));
        UnsafeOpsHolder.U.putDouble(dest + 88L, Math.fma(_self23, _t20, Math.fma(_self03, _t26, _self13 * _t23)));
        return dest;
    }

    public static long preRotateQuat_unsafe(long dest, long src, double qX, double qY, double qZ, double qW) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
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
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_self20, _t18, Math.fma(_self00, _t24, _self10 * _t21)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_self21, _t18, Math.fma(_self01, _t24, _self11 * _t21)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_self22, _t18, Math.fma(_self02, _t24, _self12 * _t21)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(_self23, _t18, Math.fma(_self03, _t24, _self13 * _t21)));
        UnsafeOpsHolder.U.putDouble(dest + 32L, Math.fma(_self20, _t22, Math.fma(_self00, _t19, _self10 * _t25)));
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(_self21, _t22, Math.fma(_self01, _t19, _self11 * _t25)));
        UnsafeOpsHolder.U.putDouble(dest + 48L, Math.fma(_self22, _t22, Math.fma(_self02, _t19, _self12 * _t25)));
        UnsafeOpsHolder.U.putDouble(dest + 56L, Math.fma(_self23, _t22, Math.fma(_self03, _t19, _self13 * _t25)));
        UnsafeOpsHolder.U.putDouble(dest + 64L, Math.fma(_self20, _t26, Math.fma(_self00, _t23, _self10 * _t20)));
        UnsafeOpsHolder.U.putDouble(dest + 72L, Math.fma(_self21, _t26, Math.fma(_self01, _t23, _self11 * _t20)));
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(_self22, _t26, Math.fma(_self02, _t23, _self12 * _t20)));
        UnsafeOpsHolder.U.putDouble(dest + 88L, Math.fma(_self23, _t26, Math.fma(_self03, _t23, _self13 * _t20)));
        return dest;
    }

    public static long preRotateQuat_unsafe(long dest, long src, long q) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        double _qx = UnsafeOpsHolder.U.getDouble(q + 0L);
        double _qy = UnsafeOpsHolder.U.getDouble(q + 8L);
        double _qz = UnsafeOpsHolder.U.getDouble(q + 16L);
        double _qw = UnsafeOpsHolder.U.getDouble(q + 24L);
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
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_self20, _t18, Math.fma(_self00, _t24, _self10 * _t21)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_self21, _t18, Math.fma(_self01, _t24, _self11 * _t21)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_self22, _t18, Math.fma(_self02, _t24, _self12 * _t21)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(_self23, _t18, Math.fma(_self03, _t24, _self13 * _t21)));
        UnsafeOpsHolder.U.putDouble(dest + 32L, Math.fma(_self20, _t22, Math.fma(_self00, _t19, _self10 * _t25)));
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(_self21, _t22, Math.fma(_self01, _t19, _self11 * _t25)));
        UnsafeOpsHolder.U.putDouble(dest + 48L, Math.fma(_self22, _t22, Math.fma(_self02, _t19, _self12 * _t25)));
        UnsafeOpsHolder.U.putDouble(dest + 56L, Math.fma(_self23, _t22, Math.fma(_self03, _t19, _self13 * _t25)));
        UnsafeOpsHolder.U.putDouble(dest + 64L, Math.fma(_self20, _t26, Math.fma(_self00, _t23, _self10 * _t20)));
        UnsafeOpsHolder.U.putDouble(dest + 72L, Math.fma(_self21, _t26, Math.fma(_self01, _t23, _self11 * _t20)));
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(_self22, _t26, Math.fma(_self02, _t23, _self12 * _t20)));
        UnsafeOpsHolder.U.putDouble(dest + 88L, Math.fma(_self23, _t26, Math.fma(_self03, _t23, _self13 * _t20)));
        return dest;
    }

    public static long preRotateX_unsafe(long dest, long src, double angle) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        UnsafeOpsHolder.U.putDouble(dest + 0L, _self00);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _self01);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _self02);
        UnsafeOpsHolder.U.putDouble(dest + 24L, _self03);
        UnsafeOpsHolder.U.putDouble(dest + 32L, Math.fma(_self10, _t0, -(_self20 * _t1)));
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(_self11, _t0, -(_self21 * _t1)));
        UnsafeOpsHolder.U.putDouble(dest + 48L, Math.fma(_self12, _t0, -(_self22 * _t1)));
        UnsafeOpsHolder.U.putDouble(dest + 56L, Math.fma(_self13, _t0, -(_self23 * _t1)));
        UnsafeOpsHolder.U.putDouble(dest + 64L, Math.fma(_self10, _t1, _self20 * _t0));
        UnsafeOpsHolder.U.putDouble(dest + 72L, Math.fma(_self11, _t1, _self21 * _t0));
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(_self12, _t1, _self22 * _t0));
        UnsafeOpsHolder.U.putDouble(dest + 88L, Math.fma(_self13, _t1, _self23 * _t0));
        return dest;
    }

    public static long preRotateY_unsafe(long dest, long src, double angle) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_self00, _t0, _self20 * _t1));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_self01, _t0, _self21 * _t1));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_self02, _t0, _self22 * _t1));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(_self03, _t0, _self23 * _t1));
        UnsafeOpsHolder.U.putDouble(dest + 32L, _self10);
        UnsafeOpsHolder.U.putDouble(dest + 40L, _self11);
        UnsafeOpsHolder.U.putDouble(dest + 48L, _self12);
        UnsafeOpsHolder.U.putDouble(dest + 56L, _self13);
        UnsafeOpsHolder.U.putDouble(dest + 64L, Math.fma(_self20, _t0, -(_self00 * _t1)));
        UnsafeOpsHolder.U.putDouble(dest + 72L, Math.fma(_self21, _t0, -(_self01 * _t1)));
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(_self22, _t0, -(_self02 * _t1)));
        UnsafeOpsHolder.U.putDouble(dest + 88L, Math.fma(_self23, _t0, -(_self03 * _t1)));
        return dest;
    }

    public static long preRotateZ_unsafe(long dest, long src, double angle) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_self00, _t0, -(_self10 * _t1)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_self01, _t0, -(_self11 * _t1)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_self02, _t0, -(_self12 * _t1)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(_self03, _t0, -(_self13 * _t1)));
        UnsafeOpsHolder.U.putDouble(dest + 32L, Math.fma(_self00, _t1, _self10 * _t0));
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(_self01, _t1, _self11 * _t0));
        UnsafeOpsHolder.U.putDouble(dest + 48L, Math.fma(_self02, _t1, _self12 * _t0));
        UnsafeOpsHolder.U.putDouble(dest + 56L, Math.fma(_self03, _t1, _self13 * _t0));
        UnsafeOpsHolder.U.putDouble(dest + 64L, _self20);
        UnsafeOpsHolder.U.putDouble(dest + 72L, _self21);
        UnsafeOpsHolder.U.putDouble(dest + 80L, _self22);
        UnsafeOpsHolder.U.putDouble(dest + 88L, _self23);
        return dest;
    }

    public static long preScale_unsafe(long dest, long src, double vX, double vY, double vZ) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, _self00 * vX);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _self01 * vX);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _self02 * vX);
        UnsafeOpsHolder.U.putDouble(dest + 24L, _self03 * vX);
        UnsafeOpsHolder.U.putDouble(dest + 32L, _self10 * vY);
        UnsafeOpsHolder.U.putDouble(dest + 40L, _self11 * vY);
        UnsafeOpsHolder.U.putDouble(dest + 48L, _self12 * vY);
        UnsafeOpsHolder.U.putDouble(dest + 56L, _self13 * vY);
        UnsafeOpsHolder.U.putDouble(dest + 64L, _self20 * vZ);
        UnsafeOpsHolder.U.putDouble(dest + 72L, _self21 * vZ);
        UnsafeOpsHolder.U.putDouble(dest + 80L, _self22 * vZ);
        UnsafeOpsHolder.U.putDouble(dest + 88L, _self23 * vZ);
        return dest;
    }

    public static long preScale_unsafe(long dest, long src, long v) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        double _vx = UnsafeOpsHolder.U.getDouble(v + 0L);
        double _vy = UnsafeOpsHolder.U.getDouble(v + 8L);
        double _vz = UnsafeOpsHolder.U.getDouble(v + 16L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, _self00 * _vx);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _self01 * _vx);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _self02 * _vx);
        UnsafeOpsHolder.U.putDouble(dest + 24L, _self03 * _vx);
        UnsafeOpsHolder.U.putDouble(dest + 32L, _self10 * _vy);
        UnsafeOpsHolder.U.putDouble(dest + 40L, _self11 * _vy);
        UnsafeOpsHolder.U.putDouble(dest + 48L, _self12 * _vy);
        UnsafeOpsHolder.U.putDouble(dest + 56L, _self13 * _vy);
        UnsafeOpsHolder.U.putDouble(dest + 64L, _self20 * _vz);
        UnsafeOpsHolder.U.putDouble(dest + 72L, _self21 * _vz);
        UnsafeOpsHolder.U.putDouble(dest + 80L, _self22 * _vz);
        UnsafeOpsHolder.U.putDouble(dest + 88L, _self23 * _vz);
        return dest;
    }

    public static long preScale_unsafe(long dest, long src, double s) {
        for (int _i = 0; _i < 12; _i++) {
            double _eself = UnsafeOpsHolder.U.getDouble(src + _i * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _i * 8L, s * _eself);
        }
        return dest;
    }

    public static long preScaleAround_unsafe(long dest, long src, double s, double pivotX, double pivotY, double pivotZ) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, s * _self00);
        UnsafeOpsHolder.U.putDouble(dest + 8L, s * _self01);
        UnsafeOpsHolder.U.putDouble(dest + 16L, s * _self02);
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(-s, pivotX, Math.fma(s, _self03, pivotX)));
        UnsafeOpsHolder.U.putDouble(dest + 32L, s * _self10);
        UnsafeOpsHolder.U.putDouble(dest + 40L, s * _self11);
        UnsafeOpsHolder.U.putDouble(dest + 48L, s * _self12);
        UnsafeOpsHolder.U.putDouble(dest + 56L, Math.fma(-s, pivotY, Math.fma(s, _self13, pivotY)));
        UnsafeOpsHolder.U.putDouble(dest + 64L, s * _self20);
        UnsafeOpsHolder.U.putDouble(dest + 72L, s * _self21);
        UnsafeOpsHolder.U.putDouble(dest + 80L, s * _self22);
        UnsafeOpsHolder.U.putDouble(dest + 88L, Math.fma(-s, pivotZ, Math.fma(s, _self23, pivotZ)));
        return dest;
    }

    public static long preScaleAround_unsafe(long dest, long src, long pivot, double s) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        double _pivotx = UnsafeOpsHolder.U.getDouble(pivot + 0L);
        double _pivoty = UnsafeOpsHolder.U.getDouble(pivot + 8L);
        double _pivotz = UnsafeOpsHolder.U.getDouble(pivot + 16L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, s * _self00);
        UnsafeOpsHolder.U.putDouble(dest + 8L, s * _self01);
        UnsafeOpsHolder.U.putDouble(dest + 16L, s * _self02);
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(-s, _pivotx, Math.fma(s, _self03, _pivotx)));
        UnsafeOpsHolder.U.putDouble(dest + 32L, s * _self10);
        UnsafeOpsHolder.U.putDouble(dest + 40L, s * _self11);
        UnsafeOpsHolder.U.putDouble(dest + 48L, s * _self12);
        UnsafeOpsHolder.U.putDouble(dest + 56L, Math.fma(-s, _pivoty, Math.fma(s, _self13, _pivoty)));
        UnsafeOpsHolder.U.putDouble(dest + 64L, s * _self20);
        UnsafeOpsHolder.U.putDouble(dest + 72L, s * _self21);
        UnsafeOpsHolder.U.putDouble(dest + 80L, s * _self22);
        UnsafeOpsHolder.U.putDouble(dest + 88L, Math.fma(-s, _pivotz, Math.fma(s, _self23, _pivotz)));
        return dest;
    }

    public static long preScaleAround_unsafe(long dest, long src, double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, sX * _self00);
        UnsafeOpsHolder.U.putDouble(dest + 8L, sX * _self01);
        UnsafeOpsHolder.U.putDouble(dest + 16L, sX * _self02);
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(-pivotX, sX, Math.fma(sX, _self03, pivotX)));
        UnsafeOpsHolder.U.putDouble(dest + 32L, sY * _self10);
        UnsafeOpsHolder.U.putDouble(dest + 40L, sY * _self11);
        UnsafeOpsHolder.U.putDouble(dest + 48L, sY * _self12);
        UnsafeOpsHolder.U.putDouble(dest + 56L, Math.fma(-pivotY, sY, Math.fma(sY, _self13, pivotY)));
        UnsafeOpsHolder.U.putDouble(dest + 64L, sZ * _self20);
        UnsafeOpsHolder.U.putDouble(dest + 72L, sZ * _self21);
        UnsafeOpsHolder.U.putDouble(dest + 80L, sZ * _self22);
        UnsafeOpsHolder.U.putDouble(dest + 88L, Math.fma(-pivotZ, sZ, Math.fma(sZ, _self23, pivotZ)));
        return dest;
    }

    public static long preScaleAround_unsafe(long dest, long src, long s, long pivot) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        double _sx = UnsafeOpsHolder.U.getDouble(s + 0L);
        double _sy = UnsafeOpsHolder.U.getDouble(s + 8L);
        double _sz = UnsafeOpsHolder.U.getDouble(s + 16L);
        double _pivotx = UnsafeOpsHolder.U.getDouble(pivot + 0L);
        double _pivoty = UnsafeOpsHolder.U.getDouble(pivot + 8L);
        double _pivotz = UnsafeOpsHolder.U.getDouble(pivot + 16L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, _sx * _self00);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _sx * _self01);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _sx * _self02);
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(-_pivotx, _sx, Math.fma(_sx, _self03, _pivotx)));
        UnsafeOpsHolder.U.putDouble(dest + 32L, _sy * _self10);
        UnsafeOpsHolder.U.putDouble(dest + 40L, _sy * _self11);
        UnsafeOpsHolder.U.putDouble(dest + 48L, _sy * _self12);
        UnsafeOpsHolder.U.putDouble(dest + 56L, Math.fma(-_pivoty, _sy, Math.fma(_sy, _self13, _pivoty)));
        UnsafeOpsHolder.U.putDouble(dest + 64L, _sz * _self20);
        UnsafeOpsHolder.U.putDouble(dest + 72L, _sz * _self21);
        UnsafeOpsHolder.U.putDouble(dest + 80L, _sz * _self22);
        UnsafeOpsHolder.U.putDouble(dest + 88L, Math.fma(-_pivotz, _sz, Math.fma(_sz, _self23, _pivotz)));
        return dest;
    }

    public static long preTranslate_unsafe(long dest, long src, double vX, double vY, double vZ) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, _self00);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _self01);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _self02);
        UnsafeOpsHolder.U.putDouble(dest + 24L, _self03 + vX);
        UnsafeOpsHolder.U.putDouble(dest + 32L, _self10);
        UnsafeOpsHolder.U.putDouble(dest + 40L, _self11);
        UnsafeOpsHolder.U.putDouble(dest + 48L, _self12);
        UnsafeOpsHolder.U.putDouble(dest + 56L, _self13 + vY);
        UnsafeOpsHolder.U.putDouble(dest + 64L, _self20);
        UnsafeOpsHolder.U.putDouble(dest + 72L, _self21);
        UnsafeOpsHolder.U.putDouble(dest + 80L, _self22);
        UnsafeOpsHolder.U.putDouble(dest + 88L, _self23 + vZ);
        return dest;
    }

    public static long preTranslate_unsafe(long dest, long src, long v) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        double _vx = UnsafeOpsHolder.U.getDouble(v + 0L);
        double _vy = UnsafeOpsHolder.U.getDouble(v + 8L);
        double _vz = UnsafeOpsHolder.U.getDouble(v + 16L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, _self00);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _self01);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _self02);
        UnsafeOpsHolder.U.putDouble(dest + 24L, _self03 + _vx);
        UnsafeOpsHolder.U.putDouble(dest + 32L, _self10);
        UnsafeOpsHolder.U.putDouble(dest + 40L, _self11);
        UnsafeOpsHolder.U.putDouble(dest + 48L, _self12);
        UnsafeOpsHolder.U.putDouble(dest + 56L, _self13 + _vy);
        UnsafeOpsHolder.U.putDouble(dest + 64L, _self20);
        UnsafeOpsHolder.U.putDouble(dest + 72L, _self21);
        UnsafeOpsHolder.U.putDouble(dest + 80L, _self22);
        UnsafeOpsHolder.U.putDouble(dest + 88L, _self23 + _vz);
        return dest;
    }

    public static long reflect_unsafe(long dest, long src, double normalX, double normalY, double normalZ) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        double _t0 = -_self02;
        double _t1 = -_self12;
        double _t2 = -_self22;
        double _t9 = 2.0 * normalX * normalZ;
        double _t10 = 2.0 * normalX * normalY;
        double _t11 = 2.0 * normalY * normalZ;
        double _t12 = Math.fma(-2.0, normalX * normalX, 1.0);
        double _t13 = Math.fma(-2.0, normalY * normalY, 1.0);
        double _t14 = Math.fma(-2.0, normalZ * normalZ, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_t0, _t9, Math.fma(_self00, _t12, -(_self01 * _t10))));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_t0, _t11, Math.fma(_self01, _t13, -(_self00 * _t10))));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_self02, _t14, Math.fma(-_self01, _t11, -(_self00 * _t9))));
        UnsafeOpsHolder.U.putDouble(dest + 24L, _self03);
        UnsafeOpsHolder.U.putDouble(dest + 32L, Math.fma(_t1, _t9, Math.fma(_self10, _t12, -(_self11 * _t10))));
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(_t1, _t11, Math.fma(_self11, _t13, -(_self10 * _t10))));
        UnsafeOpsHolder.U.putDouble(dest + 48L, Math.fma(_self12, _t14, Math.fma(-_self11, _t11, -(_self10 * _t9))));
        UnsafeOpsHolder.U.putDouble(dest + 56L, _self13);
        UnsafeOpsHolder.U.putDouble(dest + 64L, Math.fma(_t2, _t9, Math.fma(_self20, _t12, -(_self21 * _t10))));
        UnsafeOpsHolder.U.putDouble(dest + 72L, Math.fma(_t2, _t11, Math.fma(_self21, _t13, -(_self20 * _t10))));
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(_self22, _t14, Math.fma(-_self21, _t11, -(_self20 * _t9))));
        UnsafeOpsHolder.U.putDouble(dest + 88L, _self23);
        return dest;
    }

    public static long reflect_unsafe(long dest, long src, long normal) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        double _normalx = UnsafeOpsHolder.U.getDouble(normal + 0L);
        double _normaly = UnsafeOpsHolder.U.getDouble(normal + 8L);
        double _normalz = UnsafeOpsHolder.U.getDouble(normal + 16L);
        double _t0 = -_self02;
        double _t1 = -_self12;
        double _t2 = -_self22;
        double _t9 = 2.0 * _normalx * _normalz;
        double _t10 = 2.0 * _normalx * _normaly;
        double _t11 = 2.0 * _normaly * _normalz;
        double _t12 = Math.fma(-2.0, _normalx * _normalx, 1.0);
        double _t13 = Math.fma(-2.0, _normaly * _normaly, 1.0);
        double _t14 = Math.fma(-2.0, _normalz * _normalz, 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_t0, _t9, Math.fma(_self00, _t12, -(_self01 * _t10))));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_t0, _t11, Math.fma(_self01, _t13, -(_self00 * _t10))));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_self02, _t14, Math.fma(-_self01, _t11, -(_self00 * _t9))));
        UnsafeOpsHolder.U.putDouble(dest + 24L, _self03);
        UnsafeOpsHolder.U.putDouble(dest + 32L, Math.fma(_t1, _t9, Math.fma(_self10, _t12, -(_self11 * _t10))));
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(_t1, _t11, Math.fma(_self11, _t13, -(_self10 * _t10))));
        UnsafeOpsHolder.U.putDouble(dest + 48L, Math.fma(_self12, _t14, Math.fma(-_self11, _t11, -(_self10 * _t9))));
        UnsafeOpsHolder.U.putDouble(dest + 56L, _self13);
        UnsafeOpsHolder.U.putDouble(dest + 64L, Math.fma(_t2, _t9, Math.fma(_self20, _t12, -(_self21 * _t10))));
        UnsafeOpsHolder.U.putDouble(dest + 72L, Math.fma(_t2, _t11, Math.fma(_self21, _t13, -(_self20 * _t10))));
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(_self22, _t14, Math.fma(-_self21, _t11, -(_self20 * _t9))));
        UnsafeOpsHolder.U.putDouble(dest + 88L, _self23);
        return dest;
    }

    public static long rotateAround_unsafe(long dest, long src, double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        double _t0 = -pivotX;
        double _t1 = -pivotY;
        double _t2 = -pivotZ;
        double _t3 = rotY * rotW;
        double _t4 = rotZ * rotZ;
        double _t5 = rotZ * rotW;
        double _t21 = 2.0 * Math.fma(rotX, rotY, _t5);
        double _t22 = 2.0 * Math.fma(rotX, rotW, rotY * rotZ);
        double _t23 = 2.0 * Math.fma(rotX, rotZ, _t3);
        double _t24 = 2.0 * Math.fma(rotX, rotZ, -_t3);
        double _t25 = 2.0 * Math.fma(rotX, rotY, -_t5);
        double _t26 = 2.0 * Math.fma(rotY, rotZ, -(rotX * rotW));
        double _t27 = Math.fma(-2.0, Math.fma(rotY, rotY, _t4), 1.0);
        double _t28 = Math.fma(-2.0, Math.fma(rotX, rotX, _t4), 1.0);
        double _t29 = Math.fma(-2.0, Math.fma(rotX, rotX, rotY * rotY), 1.0);
        double _t36 = Math.fma(_t0, _t27, Math.fma(_t1, _t25, Math.fma(_t2, _t23, pivotX)));
        double _t37 = Math.fma(_t0, _t21, Math.fma(_t1, _t28, Math.fma(_t2, _t26, pivotY)));
        double _t38 = Math.fma(_t0, _t24, Math.fma(_t1, _t22, Math.fma(_t2, _t29, pivotZ)));
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_self02, _t24, Math.fma(_self00, _t27, _self01 * _t21)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_self02, _t22, Math.fma(_self00, _t25, _self01 * _t28)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_self02, _t29, Math.fma(_self00, _t23, _self01 * _t26)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(_self00, _t36, Math.fma(_self01, _t37, Math.fma(_self02, _t38, _self03))));
        UnsafeOpsHolder.U.putDouble(dest + 32L, Math.fma(_self12, _t24, Math.fma(_self10, _t27, _self11 * _t21)));
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(_self12, _t22, Math.fma(_self10, _t25, _self11 * _t28)));
        UnsafeOpsHolder.U.putDouble(dest + 48L, Math.fma(_self12, _t29, Math.fma(_self10, _t23, _self11 * _t26)));
        UnsafeOpsHolder.U.putDouble(dest + 56L, Math.fma(_self10, _t36, Math.fma(_self11, _t37, Math.fma(_self12, _t38, _self13))));
        UnsafeOpsHolder.U.putDouble(dest + 64L, Math.fma(_self22, _t24, Math.fma(_self20, _t27, _self21 * _t21)));
        UnsafeOpsHolder.U.putDouble(dest + 72L, Math.fma(_self22, _t22, Math.fma(_self20, _t25, _self21 * _t28)));
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(_self22, _t29, Math.fma(_self20, _t23, _self21 * _t26)));
        UnsafeOpsHolder.U.putDouble(dest + 88L, Math.fma(_self20, _t36, Math.fma(_self21, _t37, Math.fma(_self22, _t38, _self23))));
        return dest;
    }

    public static long rotateAround_unsafe(long dest, long src, long rot, long pivot) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        double _rotx = UnsafeOpsHolder.U.getDouble(rot + 0L);
        double _roty = UnsafeOpsHolder.U.getDouble(rot + 8L);
        double _rotz = UnsafeOpsHolder.U.getDouble(rot + 16L);
        double _rotw = UnsafeOpsHolder.U.getDouble(rot + 24L);
        double _pivotx = UnsafeOpsHolder.U.getDouble(pivot + 0L);
        double _pivoty = UnsafeOpsHolder.U.getDouble(pivot + 8L);
        double _pivotz = UnsafeOpsHolder.U.getDouble(pivot + 16L);
        double _t0 = -_pivotx;
        double _t1 = -_pivoty;
        double _t2 = -_pivotz;
        double _t3 = _roty * _rotw;
        double _t4 = _rotz * _rotz;
        double _t5 = _rotz * _rotw;
        double _t21 = 2.0 * Math.fma(_rotx, _roty, _t5);
        double _t22 = 2.0 * Math.fma(_rotx, _rotw, _roty * _rotz);
        double _t23 = 2.0 * Math.fma(_rotx, _rotz, _t3);
        double _t24 = 2.0 * Math.fma(_rotx, _rotz, -_t3);
        double _t25 = 2.0 * Math.fma(_rotx, _roty, -_t5);
        double _t26 = 2.0 * Math.fma(_roty, _rotz, -(_rotx * _rotw));
        double _t27 = Math.fma(-2.0, Math.fma(_roty, _roty, _t4), 1.0);
        double _t28 = Math.fma(-2.0, Math.fma(_rotx, _rotx, _t4), 1.0);
        double _t29 = Math.fma(-2.0, Math.fma(_rotx, _rotx, _roty * _roty), 1.0);
        double _t36 = Math.fma(_t0, _t27, Math.fma(_t1, _t25, Math.fma(_t2, _t23, _pivotx)));
        double _t37 = Math.fma(_t0, _t21, Math.fma(_t1, _t28, Math.fma(_t2, _t26, _pivoty)));
        double _t38 = Math.fma(_t0, _t24, Math.fma(_t1, _t22, Math.fma(_t2, _t29, _pivotz)));
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_self02, _t24, Math.fma(_self00, _t27, _self01 * _t21)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_self02, _t22, Math.fma(_self00, _t25, _self01 * _t28)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_self02, _t29, Math.fma(_self00, _t23, _self01 * _t26)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(_self00, _t36, Math.fma(_self01, _t37, Math.fma(_self02, _t38, _self03))));
        UnsafeOpsHolder.U.putDouble(dest + 32L, Math.fma(_self12, _t24, Math.fma(_self10, _t27, _self11 * _t21)));
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(_self12, _t22, Math.fma(_self10, _t25, _self11 * _t28)));
        UnsafeOpsHolder.U.putDouble(dest + 48L, Math.fma(_self12, _t29, Math.fma(_self10, _t23, _self11 * _t26)));
        UnsafeOpsHolder.U.putDouble(dest + 56L, Math.fma(_self10, _t36, Math.fma(_self11, _t37, Math.fma(_self12, _t38, _self13))));
        UnsafeOpsHolder.U.putDouble(dest + 64L, Math.fma(_self22, _t24, Math.fma(_self20, _t27, _self21 * _t21)));
        UnsafeOpsHolder.U.putDouble(dest + 72L, Math.fma(_self22, _t22, Math.fma(_self20, _t25, _self21 * _t28)));
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(_self22, _t29, Math.fma(_self20, _t23, _self21 * _t26)));
        UnsafeOpsHolder.U.putDouble(dest + 88L, Math.fma(_self20, _t36, Math.fma(_self21, _t37, Math.fma(_self22, _t38, _self23))));
        return dest;
    }

    public static long rotateAxis_unsafe(long dest, long src, double angle, double axisX, double axisY, double axisZ) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
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
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_self02, _t24, Math.fma(_self00, _t18, _self01 * _t21)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_self02, _t22, Math.fma(_self00, _t25, _self01 * _t19)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_self02, _t20, Math.fma(_self00, _t23, _self01 * _t26)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, _self03);
        UnsafeOpsHolder.U.putDouble(dest + 32L, Math.fma(_self12, _t24, Math.fma(_self10, _t18, _self11 * _t21)));
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(_self12, _t22, Math.fma(_self10, _t25, _self11 * _t19)));
        UnsafeOpsHolder.U.putDouble(dest + 48L, Math.fma(_self12, _t20, Math.fma(_self10, _t23, _self11 * _t26)));
        UnsafeOpsHolder.U.putDouble(dest + 56L, _self13);
        UnsafeOpsHolder.U.putDouble(dest + 64L, Math.fma(_self22, _t24, Math.fma(_self20, _t18, _self21 * _t21)));
        UnsafeOpsHolder.U.putDouble(dest + 72L, Math.fma(_self22, _t22, Math.fma(_self20, _t25, _self21 * _t19)));
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(_self22, _t20, Math.fma(_self20, _t23, _self21 * _t26)));
        UnsafeOpsHolder.U.putDouble(dest + 88L, _self23);
        return dest;
    }

    public static long rotateAxis_unsafe(long dest, long src, long axis, double angle) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        double _axisx = UnsafeOpsHolder.U.getDouble(axis + 0L);
        double _axisy = UnsafeOpsHolder.U.getDouble(axis + 8L);
        double _axisz = UnsafeOpsHolder.U.getDouble(axis + 16L);
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
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_self02, _t24, Math.fma(_self00, _t18, _self01 * _t21)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_self02, _t22, Math.fma(_self00, _t25, _self01 * _t19)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_self02, _t20, Math.fma(_self00, _t23, _self01 * _t26)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, _self03);
        UnsafeOpsHolder.U.putDouble(dest + 32L, Math.fma(_self12, _t24, Math.fma(_self10, _t18, _self11 * _t21)));
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(_self12, _t22, Math.fma(_self10, _t25, _self11 * _t19)));
        UnsafeOpsHolder.U.putDouble(dest + 48L, Math.fma(_self12, _t20, Math.fma(_self10, _t23, _self11 * _t26)));
        UnsafeOpsHolder.U.putDouble(dest + 56L, _self13);
        UnsafeOpsHolder.U.putDouble(dest + 64L, Math.fma(_self22, _t24, Math.fma(_self20, _t18, _self21 * _t21)));
        UnsafeOpsHolder.U.putDouble(dest + 72L, Math.fma(_self22, _t22, Math.fma(_self20, _t25, _self21 * _t19)));
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(_self22, _t20, Math.fma(_self20, _t23, _self21 * _t26)));
        UnsafeOpsHolder.U.putDouble(dest + 88L, _self23);
        return dest;
    }

    public static long rotateQuat_unsafe(long dest, long src, double qX, double qY, double qZ, double qW) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
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
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_self02, _t21, Math.fma(_self00, _t24, _self01 * _t18)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_self02, _t19, Math.fma(_self00, _t22, _self01 * _t25)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_self02, _t26, Math.fma(_self00, _t20, _self01 * _t23)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, _self03);
        UnsafeOpsHolder.U.putDouble(dest + 32L, Math.fma(_self12, _t21, Math.fma(_self10, _t24, _self11 * _t18)));
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(_self12, _t19, Math.fma(_self10, _t22, _self11 * _t25)));
        UnsafeOpsHolder.U.putDouble(dest + 48L, Math.fma(_self12, _t26, Math.fma(_self10, _t20, _self11 * _t23)));
        UnsafeOpsHolder.U.putDouble(dest + 56L, _self13);
        UnsafeOpsHolder.U.putDouble(dest + 64L, Math.fma(_self22, _t21, Math.fma(_self20, _t24, _self21 * _t18)));
        UnsafeOpsHolder.U.putDouble(dest + 72L, Math.fma(_self22, _t19, Math.fma(_self20, _t22, _self21 * _t25)));
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(_self22, _t26, Math.fma(_self20, _t20, _self21 * _t23)));
        UnsafeOpsHolder.U.putDouble(dest + 88L, _self23);
        return dest;
    }

    public static long rotateQuat_unsafe(long dest, long src, long q) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        double _qx = UnsafeOpsHolder.U.getDouble(q + 0L);
        double _qy = UnsafeOpsHolder.U.getDouble(q + 8L);
        double _qz = UnsafeOpsHolder.U.getDouble(q + 16L);
        double _qw = UnsafeOpsHolder.U.getDouble(q + 24L);
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
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_self02, _t21, Math.fma(_self00, _t24, _self01 * _t18)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_self02, _t19, Math.fma(_self00, _t22, _self01 * _t25)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_self02, _t26, Math.fma(_self00, _t20, _self01 * _t23)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, _self03);
        UnsafeOpsHolder.U.putDouble(dest + 32L, Math.fma(_self12, _t21, Math.fma(_self10, _t24, _self11 * _t18)));
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(_self12, _t19, Math.fma(_self10, _t22, _self11 * _t25)));
        UnsafeOpsHolder.U.putDouble(dest + 48L, Math.fma(_self12, _t26, Math.fma(_self10, _t20, _self11 * _t23)));
        UnsafeOpsHolder.U.putDouble(dest + 56L, _self13);
        UnsafeOpsHolder.U.putDouble(dest + 64L, Math.fma(_self22, _t21, Math.fma(_self20, _t24, _self21 * _t18)));
        UnsafeOpsHolder.U.putDouble(dest + 72L, Math.fma(_self22, _t19, Math.fma(_self20, _t22, _self21 * _t25)));
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(_self22, _t26, Math.fma(_self20, _t20, _self21 * _t23)));
        UnsafeOpsHolder.U.putDouble(dest + 88L, _self23);
        return dest;
    }

    public static long rotateX_unsafe(long dest, long src, double angle) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        UnsafeOpsHolder.U.putDouble(dest + 0L, _self00);
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_self01, _t0, _self02 * _t1));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_self02, _t0, -(_self01 * _t1)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, _self03);
        UnsafeOpsHolder.U.putDouble(dest + 32L, _self10);
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(_self11, _t0, _self12 * _t1));
        UnsafeOpsHolder.U.putDouble(dest + 48L, Math.fma(_self12, _t0, -(_self11 * _t1)));
        UnsafeOpsHolder.U.putDouble(dest + 56L, _self13);
        UnsafeOpsHolder.U.putDouble(dest + 64L, _self20);
        UnsafeOpsHolder.U.putDouble(dest + 72L, Math.fma(_self21, _t0, _self22 * _t1));
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(_self22, _t0, -(_self21 * _t1)));
        UnsafeOpsHolder.U.putDouble(dest + 88L, _self23);
        return dest;
    }

    public static long rotateXYZ_unsafe(long dest, long src, double angleX, double angleY, double angleZ) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
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
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_self02, _t20, Math.fma(_self00, _t7, _self01 * _t18)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_self02, _t19, Math.fma(_self01, _t21, -(_self00 * _t11))));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_self02, _t12, Math.fma(_self00, _t2, -(_self01 * _t13))));
        UnsafeOpsHolder.U.putDouble(dest + 24L, _self03);
        UnsafeOpsHolder.U.putDouble(dest + 32L, Math.fma(_self12, _t20, Math.fma(_self10, _t7, _self11 * _t18)));
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(_self12, _t19, Math.fma(_self11, _t21, -(_self10 * _t11))));
        UnsafeOpsHolder.U.putDouble(dest + 48L, Math.fma(_self12, _t12, Math.fma(_self10, _t2, -(_self11 * _t13))));
        UnsafeOpsHolder.U.putDouble(dest + 56L, _self13);
        UnsafeOpsHolder.U.putDouble(dest + 64L, Math.fma(_self22, _t20, Math.fma(_self20, _t7, _self21 * _t18)));
        UnsafeOpsHolder.U.putDouble(dest + 72L, Math.fma(_self22, _t19, Math.fma(_self21, _t21, -(_self20 * _t11))));
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(_self22, _t12, Math.fma(_self20, _t2, -(_self21 * _t13))));
        UnsafeOpsHolder.U.putDouble(dest + 88L, _self23);
        return dest;
    }

    public static long rotateXZY_unsafe(long dest, long src, double angleX, double angleY, double angleZ) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
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
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_self02, _t20, Math.fma(_self00, _t8, _self01 * _t18)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_self02, _t11, Math.fma(_self01, _t12, -(_self00 * _t1))));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_self02, _t19, Math.fma(_self00, _t14, _self01 * _t21)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, _self03);
        UnsafeOpsHolder.U.putDouble(dest + 32L, Math.fma(_self12, _t20, Math.fma(_self10, _t8, _self11 * _t18)));
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(_self12, _t11, Math.fma(_self11, _t12, -(_self10 * _t1))));
        UnsafeOpsHolder.U.putDouble(dest + 48L, Math.fma(_self12, _t19, Math.fma(_self10, _t14, _self11 * _t21)));
        UnsafeOpsHolder.U.putDouble(dest + 56L, _self13);
        UnsafeOpsHolder.U.putDouble(dest + 64L, Math.fma(_self22, _t20, Math.fma(_self20, _t8, _self21 * _t18)));
        UnsafeOpsHolder.U.putDouble(dest + 72L, Math.fma(_self22, _t11, Math.fma(_self21, _t12, -(_self20 * _t1))));
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(_self22, _t19, Math.fma(_self20, _t14, _self21 * _t21)));
        UnsafeOpsHolder.U.putDouble(dest + 88L, _self23);
        return dest;
    }

    public static long rotateY_unsafe(long dest, long src, double angle) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_self00, _t0, -(_self02 * _t1)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, _self01);
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_self00, _t1, _self02 * _t0));
        UnsafeOpsHolder.U.putDouble(dest + 24L, _self03);
        UnsafeOpsHolder.U.putDouble(dest + 32L, Math.fma(_self10, _t0, -(_self12 * _t1)));
        UnsafeOpsHolder.U.putDouble(dest + 40L, _self11);
        UnsafeOpsHolder.U.putDouble(dest + 48L, Math.fma(_self10, _t1, _self12 * _t0));
        UnsafeOpsHolder.U.putDouble(dest + 56L, _self13);
        UnsafeOpsHolder.U.putDouble(dest + 64L, Math.fma(_self20, _t0, -(_self22 * _t1)));
        UnsafeOpsHolder.U.putDouble(dest + 72L, _self21);
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(_self20, _t1, _self22 * _t0));
        UnsafeOpsHolder.U.putDouble(dest + 88L, _self23);
        return dest;
    }

    public static long rotateYXZ_unsafe(long dest, long src, double angleX, double angleY, double angleZ) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
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
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_self02, _t20, Math.fma(_self00, _t18, _self01 * _t10)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_self02, _t19, Math.fma(_self00, _t21, _self01 * _t13)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_self02, _t14, Math.fma(_self00, _t15, -(_self01 * _t0))));
        UnsafeOpsHolder.U.putDouble(dest + 24L, _self03);
        UnsafeOpsHolder.U.putDouble(dest + 32L, Math.fma(_self12, _t20, Math.fma(_self10, _t18, _self11 * _t10)));
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(_self12, _t19, Math.fma(_self10, _t21, _self11 * _t13)));
        UnsafeOpsHolder.U.putDouble(dest + 48L, Math.fma(_self12, _t14, Math.fma(_self10, _t15, -(_self11 * _t0))));
        UnsafeOpsHolder.U.putDouble(dest + 56L, _self13);
        UnsafeOpsHolder.U.putDouble(dest + 64L, Math.fma(_self22, _t20, Math.fma(_self20, _t18, _self21 * _t10)));
        UnsafeOpsHolder.U.putDouble(dest + 72L, Math.fma(_self22, _t19, Math.fma(_self20, _t21, _self21 * _t13)));
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(_self22, _t14, Math.fma(_self20, _t15, -(_self21 * _t0))));
        UnsafeOpsHolder.U.putDouble(dest + 88L, _self23);
        return dest;
    }

    public static long rotateYZX_unsafe(long dest, long src, double angleX, double angleY, double angleZ) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
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
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(-_self02, _t6, Math.fma(_self00, _t7, _self01 * _t3)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_self02, _t18, Math.fma(_self00, _t20, _self01 * _t11)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_self02, _t21, Math.fma(_self00, _t19, -(_self01 * _t13))));
        UnsafeOpsHolder.U.putDouble(dest + 24L, _self03);
        UnsafeOpsHolder.U.putDouble(dest + 32L, Math.fma(-_self12, _t6, Math.fma(_self10, _t7, _self11 * _t3)));
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(_self12, _t18, Math.fma(_self10, _t20, _self11 * _t11)));
        UnsafeOpsHolder.U.putDouble(dest + 48L, Math.fma(_self12, _t21, Math.fma(_self10, _t19, -(_self11 * _t13))));
        UnsafeOpsHolder.U.putDouble(dest + 56L, _self13);
        UnsafeOpsHolder.U.putDouble(dest + 64L, Math.fma(-_self22, _t6, Math.fma(_self20, _t7, _self21 * _t3)));
        UnsafeOpsHolder.U.putDouble(dest + 72L, Math.fma(_self22, _t18, Math.fma(_self20, _t20, _self21 * _t11)));
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(_self22, _t21, Math.fma(_self20, _t19, -(_self21 * _t13))));
        UnsafeOpsHolder.U.putDouble(dest + 88L, _self23);
        return dest;
    }

    public static long rotateZ_unsafe(long dest, long src, double angle) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_self00, _t0, _self01 * _t1));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_self01, _t0, -(_self00 * _t1)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, _self02);
        UnsafeOpsHolder.U.putDouble(dest + 24L, _self03);
        UnsafeOpsHolder.U.putDouble(dest + 32L, Math.fma(_self10, _t0, _self11 * _t1));
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(_self11, _t0, -(_self10 * _t1)));
        UnsafeOpsHolder.U.putDouble(dest + 48L, _self12);
        UnsafeOpsHolder.U.putDouble(dest + 56L, _self13);
        UnsafeOpsHolder.U.putDouble(dest + 64L, Math.fma(_self20, _t0, _self21 * _t1));
        UnsafeOpsHolder.U.putDouble(dest + 72L, Math.fma(_self21, _t0, -(_self20 * _t1)));
        UnsafeOpsHolder.U.putDouble(dest + 80L, _self22);
        UnsafeOpsHolder.U.putDouble(dest + 88L, _self23);
        return dest;
    }

    public static long rotateZXY_unsafe(long dest, long src, double angleX, double angleY, double angleZ) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
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
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(-_self02, _t6, Math.fma(_self00, _t20, _self01 * _t18)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_self02, _t4, Math.fma(_self01, _t10, -(_self00 * _t11))));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_self02, _t12, Math.fma(_self00, _t19, _self01 * _t21)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, _self03);
        UnsafeOpsHolder.U.putDouble(dest + 32L, Math.fma(-_self12, _t6, Math.fma(_self10, _t20, _self11 * _t18)));
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(_self12, _t4, Math.fma(_self11, _t10, -(_self10 * _t11))));
        UnsafeOpsHolder.U.putDouble(dest + 48L, Math.fma(_self12, _t12, Math.fma(_self10, _t19, _self11 * _t21)));
        UnsafeOpsHolder.U.putDouble(dest + 56L, _self13);
        UnsafeOpsHolder.U.putDouble(dest + 64L, Math.fma(-_self22, _t6, Math.fma(_self20, _t20, _self21 * _t18)));
        UnsafeOpsHolder.U.putDouble(dest + 72L, Math.fma(_self22, _t4, Math.fma(_self21, _t10, -(_self20 * _t11))));
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(_self22, _t12, Math.fma(_self20, _t19, _self21 * _t21)));
        UnsafeOpsHolder.U.putDouble(dest + 88L, _self23);
        return dest;
    }

    public static long rotateZYX_unsafe(long dest, long src, double angleX, double angleY, double angleZ) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
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
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(-_self02, _t0, Math.fma(_self00, _t6, _self01 * _t7)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_self02, _t8, Math.fma(_self00, _t20, _self01 * _t18)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_self02, _t13, Math.fma(_self00, _t19, _self01 * _t21)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, _self03);
        UnsafeOpsHolder.U.putDouble(dest + 32L, Math.fma(-_self12, _t0, Math.fma(_self10, _t6, _self11 * _t7)));
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(_self12, _t8, Math.fma(_self10, _t20, _self11 * _t18)));
        UnsafeOpsHolder.U.putDouble(dest + 48L, Math.fma(_self12, _t13, Math.fma(_self10, _t19, _self11 * _t21)));
        UnsafeOpsHolder.U.putDouble(dest + 56L, _self13);
        UnsafeOpsHolder.U.putDouble(dest + 64L, Math.fma(-_self22, _t0, Math.fma(_self20, _t6, _self21 * _t7)));
        UnsafeOpsHolder.U.putDouble(dest + 72L, Math.fma(_self22, _t8, Math.fma(_self20, _t20, _self21 * _t18)));
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(_self22, _t13, Math.fma(_self20, _t19, _self21 * _t21)));
        UnsafeOpsHolder.U.putDouble(dest + 88L, _self23);
        return dest;
    }

    public static long scale_unsafe(long dest, long src, double vX, double vY, double vZ) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, _eself0 * vX);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, _eself1 * vY);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, _eself2 * vZ);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long scale_unsafe(long dest, long src, long v) {
        double _vx = UnsafeOpsHolder.U.getDouble(v + 0L);
        double _vy = UnsafeOpsHolder.U.getDouble(v + 8L);
        double _vz = UnsafeOpsHolder.U.getDouble(v + 16L);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, _eself0 * _vx);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, _eself1 * _vy);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, _eself2 * _vz);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long scale_unsafe(long dest, long src, double s) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, s * _eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, s * _eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, s * _eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, _eself3);
        }
        return dest;
    }

    public static long scaleAround_unsafe(long dest, long src, double s, double pivotX, double pivotY, double pivotZ) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        double _t0 = Math.fma(-s, pivotX, pivotX);
        double _t1 = Math.fma(-s, pivotY, pivotY);
        double _t2 = Math.fma(-s, pivotZ, pivotZ);
        UnsafeOpsHolder.U.putDouble(dest + 0L, s * _self00);
        UnsafeOpsHolder.U.putDouble(dest + 8L, s * _self01);
        UnsafeOpsHolder.U.putDouble(dest + 16L, s * _self02);
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(_self00, _t0, Math.fma(_self01, _t1, Math.fma(_self02, _t2, _self03))));
        UnsafeOpsHolder.U.putDouble(dest + 32L, s * _self10);
        UnsafeOpsHolder.U.putDouble(dest + 40L, s * _self11);
        UnsafeOpsHolder.U.putDouble(dest + 48L, s * _self12);
        UnsafeOpsHolder.U.putDouble(dest + 56L, Math.fma(_self10, _t0, Math.fma(_self11, _t1, Math.fma(_self12, _t2, _self13))));
        UnsafeOpsHolder.U.putDouble(dest + 64L, s * _self20);
        UnsafeOpsHolder.U.putDouble(dest + 72L, s * _self21);
        UnsafeOpsHolder.U.putDouble(dest + 80L, s * _self22);
        UnsafeOpsHolder.U.putDouble(dest + 88L, Math.fma(_self20, _t0, Math.fma(_self21, _t1, Math.fma(_self22, _t2, _self23))));
        return dest;
    }

    public static long scaleAround_unsafe(long dest, long src, long pivot, double s) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        double _pivotx = UnsafeOpsHolder.U.getDouble(pivot + 0L);
        double _pivoty = UnsafeOpsHolder.U.getDouble(pivot + 8L);
        double _pivotz = UnsafeOpsHolder.U.getDouble(pivot + 16L);
        double _t0 = Math.fma(-s, _pivotx, _pivotx);
        double _t1 = Math.fma(-s, _pivoty, _pivoty);
        double _t2 = Math.fma(-s, _pivotz, _pivotz);
        UnsafeOpsHolder.U.putDouble(dest + 0L, s * _self00);
        UnsafeOpsHolder.U.putDouble(dest + 8L, s * _self01);
        UnsafeOpsHolder.U.putDouble(dest + 16L, s * _self02);
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(_self00, _t0, Math.fma(_self01, _t1, Math.fma(_self02, _t2, _self03))));
        UnsafeOpsHolder.U.putDouble(dest + 32L, s * _self10);
        UnsafeOpsHolder.U.putDouble(dest + 40L, s * _self11);
        UnsafeOpsHolder.U.putDouble(dest + 48L, s * _self12);
        UnsafeOpsHolder.U.putDouble(dest + 56L, Math.fma(_self10, _t0, Math.fma(_self11, _t1, Math.fma(_self12, _t2, _self13))));
        UnsafeOpsHolder.U.putDouble(dest + 64L, s * _self20);
        UnsafeOpsHolder.U.putDouble(dest + 72L, s * _self21);
        UnsafeOpsHolder.U.putDouble(dest + 80L, s * _self22);
        UnsafeOpsHolder.U.putDouble(dest + 88L, Math.fma(_self20, _t0, Math.fma(_self21, _t1, Math.fma(_self22, _t2, _self23))));
        return dest;
    }

    public static long scaleAround_unsafe(long dest, long src, double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        double _t3 = Math.fma(-pivotX, sX, pivotX);
        double _t4 = Math.fma(-pivotY, sY, pivotY);
        double _t5 = Math.fma(-pivotZ, sZ, pivotZ);
        UnsafeOpsHolder.U.putDouble(dest + 0L, sX * _self00);
        UnsafeOpsHolder.U.putDouble(dest + 8L, sY * _self01);
        UnsafeOpsHolder.U.putDouble(dest + 16L, sZ * _self02);
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(_self00, _t3, Math.fma(_self01, _t4, Math.fma(_self02, _t5, _self03))));
        UnsafeOpsHolder.U.putDouble(dest + 32L, sX * _self10);
        UnsafeOpsHolder.U.putDouble(dest + 40L, sY * _self11);
        UnsafeOpsHolder.U.putDouble(dest + 48L, sZ * _self12);
        UnsafeOpsHolder.U.putDouble(dest + 56L, Math.fma(_self10, _t3, Math.fma(_self11, _t4, Math.fma(_self12, _t5, _self13))));
        UnsafeOpsHolder.U.putDouble(dest + 64L, sX * _self20);
        UnsafeOpsHolder.U.putDouble(dest + 72L, sY * _self21);
        UnsafeOpsHolder.U.putDouble(dest + 80L, sZ * _self22);
        UnsafeOpsHolder.U.putDouble(dest + 88L, Math.fma(_self20, _t3, Math.fma(_self21, _t4, Math.fma(_self22, _t5, _self23))));
        return dest;
    }

    public static long scaleAround_unsafe(long dest, long src, long s, long pivot) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        double _sx = UnsafeOpsHolder.U.getDouble(s + 0L);
        double _sy = UnsafeOpsHolder.U.getDouble(s + 8L);
        double _sz = UnsafeOpsHolder.U.getDouble(s + 16L);
        double _pivotx = UnsafeOpsHolder.U.getDouble(pivot + 0L);
        double _pivoty = UnsafeOpsHolder.U.getDouble(pivot + 8L);
        double _pivotz = UnsafeOpsHolder.U.getDouble(pivot + 16L);
        double _t3 = Math.fma(-_pivotx, _sx, _pivotx);
        double _t4 = Math.fma(-_pivoty, _sy, _pivoty);
        double _t5 = Math.fma(-_pivotz, _sz, _pivotz);
        UnsafeOpsHolder.U.putDouble(dest + 0L, _sx * _self00);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _sy * _self01);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _sz * _self02);
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(_self00, _t3, Math.fma(_self01, _t4, Math.fma(_self02, _t5, _self03))));
        UnsafeOpsHolder.U.putDouble(dest + 32L, _sx * _self10);
        UnsafeOpsHolder.U.putDouble(dest + 40L, _sy * _self11);
        UnsafeOpsHolder.U.putDouble(dest + 48L, _sz * _self12);
        UnsafeOpsHolder.U.putDouble(dest + 56L, Math.fma(_self10, _t3, Math.fma(_self11, _t4, Math.fma(_self12, _t5, _self13))));
        UnsafeOpsHolder.U.putDouble(dest + 64L, _sx * _self20);
        UnsafeOpsHolder.U.putDouble(dest + 72L, _sy * _self21);
        UnsafeOpsHolder.U.putDouble(dest + 80L, _sz * _self22);
        UnsafeOpsHolder.U.putDouble(dest + 88L, Math.fma(_self20, _t3, Math.fma(_self21, _t4, Math.fma(_self22, _t5, _self23))));
        return dest;
    }

    public static long translate_unsafe(long dest, long src, double vX, double vY, double vZ) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, _eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, _eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, _eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, Math.fma(_eself0, vX, Math.fma(_eself1, vY, Math.fma(_eself2, vZ, _eself3))));
        }
        return dest;
    }

    public static long translate_unsafe(long dest, long src, long v) {
        double _vx = UnsafeOpsHolder.U.getDouble(v + 0L);
        double _vy = UnsafeOpsHolder.U.getDouble(v + 8L);
        double _vz = UnsafeOpsHolder.U.getDouble(v + 16L);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = UnsafeOpsHolder.U.getDouble(src + _lo * 8L);
            double _eself1 = UnsafeOpsHolder.U.getDouble(src + (_lo + 1) * 8L);
            double _eself2 = UnsafeOpsHolder.U.getDouble(src + (_lo + 2) * 8L);
            double _eself3 = UnsafeOpsHolder.U.getDouble(src + (_lo + 3) * 8L);
            UnsafeOpsHolder.U.putDouble(dest + _lo * 8L, _eself0);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 1) * 8L, _eself1);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 2) * 8L, _eself2);
            UnsafeOpsHolder.U.putDouble(dest + (_lo + 3) * 8L, Math.fma(_eself0, _vx, Math.fma(_eself1, _vy, Math.fma(_eself2, _vz, _eself3))));
        }
        return dest;
    }

    public static long mulVec4_unsafe(long dest, long src, double vX, double vY, double vZ, double vW) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_self03, vW, Math.fma(_self02, vZ, Math.fma(_self00, vX, _self01 * vY))));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_self13, vW, Math.fma(_self12, vZ, Math.fma(_self10, vX, _self11 * vY))));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_self23, vW, Math.fma(_self22, vZ, Math.fma(_self20, vX, _self21 * vY))));
        return dest;
    }

    public static long mulVec4_unsafe(long dest, long src, long v) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        double _vx = UnsafeOpsHolder.U.getDouble(v + 0L);
        double _vy = UnsafeOpsHolder.U.getDouble(v + 8L);
        double _vz = UnsafeOpsHolder.U.getDouble(v + 16L);
        double _vw = UnsafeOpsHolder.U.getDouble(v + 24L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_self03, _vw, Math.fma(_self02, _vz, Math.fma(_self00, _vx, _self01 * _vy))));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_self13, _vw, Math.fma(_self12, _vz, Math.fma(_self10, _vx, _self11 * _vy))));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_self23, _vw, Math.fma(_self22, _vz, Math.fma(_self20, _vx, _self21 * _vy))));
        return dest;
    }

    public static long transformAabb_unsafe(long dest, long src, double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
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
        UnsafeOpsHolder.U.putDouble(dest + 0L, _self03 + Math.min(_t0, _t1) + Math.min(_t2, _t3) + Math.min(_t4, _t5));
        UnsafeOpsHolder.U.putDouble(dest + 8L, _self13 + Math.min(_t6, _t7) + Math.min(_t8, _t9) + Math.min(_t10, _t11));
        UnsafeOpsHolder.U.putDouble(dest + 16L, _self23 + Math.min(_t12, _t13) + Math.min(_t14, _t15) + Math.min(_t16, _t17));
        UnsafeOpsHolder.U.putDouble(dest + 24L, _self03 + Math.max(_t0, _t1) + Math.max(_t2, _t3) + Math.max(_t4, _t5));
        UnsafeOpsHolder.U.putDouble(dest + 32L, _self13 + Math.max(_t6, _t7) + Math.max(_t8, _t9) + Math.max(_t10, _t11));
        UnsafeOpsHolder.U.putDouble(dest + 40L, _self23 + Math.max(_t12, _t13) + Math.max(_t14, _t15) + Math.max(_t16, _t17));
        return dest;
    }

    public static long transformDirection_unsafe(long dest, long src, double vX, double vY, double vZ) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_self02, vZ, Math.fma(_self00, vX, _self01 * vY)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_self12, vZ, Math.fma(_self10, vX, _self11 * vY)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_self22, vZ, Math.fma(_self20, vX, _self21 * vY)));
        return dest;
    }

    public static long transformDirection_unsafe(long dest, long src, long v) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _vx = UnsafeOpsHolder.U.getDouble(v + 0L);
        double _vy = UnsafeOpsHolder.U.getDouble(v + 8L);
        double _vz = UnsafeOpsHolder.U.getDouble(v + 16L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_self02, _vz, Math.fma(_self00, _vx, _self01 * _vy)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_self12, _vz, Math.fma(_self10, _vx, _self11 * _vy)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_self22, _vz, Math.fma(_self20, _vx, _self21 * _vy)));
        return dest;
    }

    public static long transformPosition_unsafe(long dest, long src, double vX, double vY, double vZ) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_self00, vX, Math.fma(_self01, vY, Math.fma(_self02, vZ, _self03))));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_self10, vX, Math.fma(_self11, vY, Math.fma(_self12, vZ, _self13))));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_self20, vX, Math.fma(_self21, vY, Math.fma(_self22, vZ, _self23))));
        return dest;
    }

    public static long transformPosition_unsafe(long dest, long src, long v) {
        double _self00 = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _self03 = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _self10 = UnsafeOpsHolder.U.getDouble(src + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(src + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(src + 48L);
        double _self13 = UnsafeOpsHolder.U.getDouble(src + 56L);
        double _self20 = UnsafeOpsHolder.U.getDouble(src + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(src + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(src + 80L);
        double _self23 = UnsafeOpsHolder.U.getDouble(src + 88L);
        double _vx = UnsafeOpsHolder.U.getDouble(v + 0L);
        double _vy = UnsafeOpsHolder.U.getDouble(v + 8L);
        double _vz = UnsafeOpsHolder.U.getDouble(v + 16L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_self00, _vx, Math.fma(_self01, _vy, Math.fma(_self02, _vz, _self03))));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_self10, _vx, Math.fma(_self11, _vy, Math.fma(_self12, _vz, _self13))));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_self20, _vx, Math.fma(_self21, _vy, Math.fma(_self22, _vz, _self23))));
        return dest;
    }

    public static void transformPosition_unsafe(long _destBase, long _matrixBase, long _pointsBase, int count) {
        double _m00 = UnsafeOpsHolder.U.getDouble(_matrixBase + 0L);
        double _m01 = UnsafeOpsHolder.U.getDouble(_matrixBase + 8L);
        double _m02 = UnsafeOpsHolder.U.getDouble(_matrixBase + 16L);
        double _m03 = UnsafeOpsHolder.U.getDouble(_matrixBase + 24L);
        double _m10 = UnsafeOpsHolder.U.getDouble(_matrixBase + 32L);
        double _m11 = UnsafeOpsHolder.U.getDouble(_matrixBase + 40L);
        double _m12 = UnsafeOpsHolder.U.getDouble(_matrixBase + 48L);
        double _m13 = UnsafeOpsHolder.U.getDouble(_matrixBase + 56L);
        double _m20 = UnsafeOpsHolder.U.getDouble(_matrixBase + 64L);
        double _m21 = UnsafeOpsHolder.U.getDouble(_matrixBase + 72L);
        double _m22 = UnsafeOpsHolder.U.getDouble(_matrixBase + 80L);
        double _m23 = UnsafeOpsHolder.U.getDouble(_matrixBase + 88L);
        for (int _i = 0; _i < count; _i++) {
            long _pb = _pointsBase + _i * 24L;
            long _db = _destBase + _i * 24L;
            double px = UnsafeOpsHolder.U.getDouble(_pb + 0L), py = UnsafeOpsHolder.U.getDouble(_pb + 8L), pz = UnsafeOpsHolder.U.getDouble(_pb + 16L);
            UnsafeOpsHolder.U.putDouble(_db + 0L, Math.fma(_m00, px, Math.fma(_m01, py, Math.fma(_m02, pz, _m03))));
            UnsafeOpsHolder.U.putDouble(_db + 8L, Math.fma(_m10, px, Math.fma(_m11, py, Math.fma(_m12, pz, _m13))));
            UnsafeOpsHolder.U.putDouble(_db + 16L, Math.fma(_m20, px, Math.fma(_m21, py, Math.fma(_m22, pz, _m23))));
        }
    }

    public static void transformDirection_unsafe(long _destBase, long _matrixBase, long _pointsBase, int count) {
        double _m00 = UnsafeOpsHolder.U.getDouble(_matrixBase + 0L);
        double _m01 = UnsafeOpsHolder.U.getDouble(_matrixBase + 8L);
        double _m02 = UnsafeOpsHolder.U.getDouble(_matrixBase + 16L);
        double _m10 = UnsafeOpsHolder.U.getDouble(_matrixBase + 32L);
        double _m11 = UnsafeOpsHolder.U.getDouble(_matrixBase + 40L);
        double _m12 = UnsafeOpsHolder.U.getDouble(_matrixBase + 48L);
        double _m20 = UnsafeOpsHolder.U.getDouble(_matrixBase + 64L);
        double _m21 = UnsafeOpsHolder.U.getDouble(_matrixBase + 72L);
        double _m22 = UnsafeOpsHolder.U.getDouble(_matrixBase + 80L);
        for (int _i = 0; _i < count; _i++) {
            long _pb = _pointsBase + _i * 24L;
            long _db = _destBase + _i * 24L;
            double px = UnsafeOpsHolder.U.getDouble(_pb + 0L), py = UnsafeOpsHolder.U.getDouble(_pb + 8L), pz = UnsafeOpsHolder.U.getDouble(_pb + 16L);
            UnsafeOpsHolder.U.putDouble(_db + 0L, Math.fma(_m02, pz, Math.fma(_m00, px, _m01 * py)));
            UnsafeOpsHolder.U.putDouble(_db + 8L, Math.fma(_m12, pz, Math.fma(_m10, px, _m11 * py)));
            UnsafeOpsHolder.U.putDouble(_db + 16L, Math.fma(_m22, pz, Math.fma(_m20, px, _m21 * py)));
        }
    }

    public static void lerpComposeTRSMul_fmaUnsafe(long _destBase, long _t1Base, long _t2Base, long _q1Base, long _q2Base, long _s1Base, long _s2Base, long _mBase, double alpha, int count) {
        for (int _i = 0; _i < count; _i++) {
            long _t1o = _t1Base + _i * 24L;
            long _t2o = _t2Base + _i * 24L;
            long _q1o = _q1Base + _i * 32L;
            long _q2o = _q2Base + _i * 32L;
            long _s1o = _s1Base + _i * 24L;
            long _s2o = _s2Base + _i * 24L;
            long _mo = _mBase + _i * 96L;
            long _do = _destBase + _i * 96L;
            double _ax = UnsafeOpsHolder.U.getDouble(_t1o + 0L), _ay = UnsafeOpsHolder.U.getDouble(_t1o + 8L), _az = UnsafeOpsHolder.U.getDouble(_t1o + 16L);
            double _tx = Math.fma(alpha, (UnsafeOpsHolder.U.getDouble(_t2o + 0L)) - _ax, _ax);
            double _ty = Math.fma(alpha, (UnsafeOpsHolder.U.getDouble(_t2o + 8L)) - _ay, _ay);
            double _tz = Math.fma(alpha, (UnsafeOpsHolder.U.getDouble(_t2o + 16L)) - _az, _az);
            double _bx = UnsafeOpsHolder.U.getDouble(_s1o + 0L), _by = UnsafeOpsHolder.U.getDouble(_s1o + 8L), _bz = UnsafeOpsHolder.U.getDouble(_s1o + 16L);
            double _sx = Math.fma(alpha, (UnsafeOpsHolder.U.getDouble(_s2o + 0L)) - _bx, _bx);
            double _sy = Math.fma(alpha, (UnsafeOpsHolder.U.getDouble(_s2o + 8L)) - _by, _by);
            double _sz = Math.fma(alpha, (UnsafeOpsHolder.U.getDouble(_s2o + 16L)) - _bz, _bz);
            double _ux = UnsafeOpsHolder.U.getDouble(_q1o + 0L), _uy = UnsafeOpsHolder.U.getDouble(_q1o + 8L), _uz = UnsafeOpsHolder.U.getDouble(_q1o + 16L), _uw = UnsafeOpsHolder.U.getDouble(_q1o + 24L);
            double _vx = UnsafeOpsHolder.U.getDouble(_q2o + 0L), _vy = UnsafeOpsHolder.U.getDouble(_q2o + 8L), _vz = UnsafeOpsHolder.U.getDouble(_q2o + 16L), _vw = UnsafeOpsHolder.U.getDouble(_q2o + 24L);
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
            double _m00 = UnsafeOpsHolder.U.getDouble(_mo + 0L), _m01 = UnsafeOpsHolder.U.getDouble(_mo + 8L), _m02 = UnsafeOpsHolder.U.getDouble(_mo + 16L), _m03 = UnsafeOpsHolder.U.getDouble(_mo + 24L);
            double _m10 = UnsafeOpsHolder.U.getDouble(_mo + 32L), _m11 = UnsafeOpsHolder.U.getDouble(_mo + 40L), _m12 = UnsafeOpsHolder.U.getDouble(_mo + 48L), _m13 = UnsafeOpsHolder.U.getDouble(_mo + 56L);
            double _m20 = UnsafeOpsHolder.U.getDouble(_mo + 64L), _m21 = UnsafeOpsHolder.U.getDouble(_mo + 72L), _m22 = UnsafeOpsHolder.U.getDouble(_mo + 80L), _m23 = UnsafeOpsHolder.U.getDouble(_mo + 88L);
            double _e00 = Math.fma(_t02, _m20, Math.fma(_t01, _m10, _t00 * _m00)), _e01 = Math.fma(_t02, _m21, Math.fma(_t01, _m11, _t00 * _m01)), _e02 = Math.fma(_t02, _m22, Math.fma(_t01, _m12, _t00 * _m02)), _e03 = (Math.fma(_t02, _m23, Math.fma(_t01, _m13, _t00 * _m03))) + _tx;
            double _e10 = Math.fma(_t12, _m20, Math.fma(_t11, _m10, _t10 * _m00)), _e11 = Math.fma(_t12, _m21, Math.fma(_t11, _m11, _t10 * _m01)), _e12 = Math.fma(_t12, _m22, Math.fma(_t11, _m12, _t10 * _m02)), _e13 = (Math.fma(_t12, _m23, Math.fma(_t11, _m13, _t10 * _m03))) + _ty;
            double _e20 = Math.fma(_t22, _m20, Math.fma(_t21, _m10, _t20 * _m00)), _e21 = Math.fma(_t22, _m21, Math.fma(_t21, _m11, _t20 * _m01)), _e22 = Math.fma(_t22, _m22, Math.fma(_t21, _m12, _t20 * _m02)), _e23 = (Math.fma(_t22, _m23, Math.fma(_t21, _m13, _t20 * _m03))) + _tz;
            UnsafeOpsHolder.U.putDouble(_do + 0L, _e00);
            UnsafeOpsHolder.U.putDouble(_do + 8L, _e01);
            UnsafeOpsHolder.U.putDouble(_do + 16L, _e02);
            UnsafeOpsHolder.U.putDouble(_do + 24L, _e03);
            UnsafeOpsHolder.U.putDouble(_do + 32L, _e10);
            UnsafeOpsHolder.U.putDouble(_do + 40L, _e11);
            UnsafeOpsHolder.U.putDouble(_do + 48L, _e12);
            UnsafeOpsHolder.U.putDouble(_do + 56L, _e13);
            UnsafeOpsHolder.U.putDouble(_do + 64L, _e20);
            UnsafeOpsHolder.U.putDouble(_do + 72L, _e21);
            UnsafeOpsHolder.U.putDouble(_do + 80L, _e22);
            UnsafeOpsHolder.U.putDouble(_do + 88L, _e23);
        }
    }

    public static void lerpComposeTRSMul_mulAddUnsafe(long _destBase, long _t1Base, long _t2Base, long _q1Base, long _q2Base, long _s1Base, long _s2Base, long _mBase, double alpha, int count) {
        for (int _i = 0; _i < count; _i++) {
            long _t1o = _t1Base + _i * 24L;
            long _t2o = _t2Base + _i * 24L;
            long _q1o = _q1Base + _i * 32L;
            long _q2o = _q2Base + _i * 32L;
            long _s1o = _s1Base + _i * 24L;
            long _s2o = _s2Base + _i * 24L;
            long _mo = _mBase + _i * 96L;
            long _do = _destBase + _i * 96L;
            double _ax = UnsafeOpsHolder.U.getDouble(_t1o + 0L), _ay = UnsafeOpsHolder.U.getDouble(_t1o + 8L), _az = UnsafeOpsHolder.U.getDouble(_t1o + 16L);
            double _tx = alpha * (UnsafeOpsHolder.U.getDouble(_t2o + 0L)) - _ax + (_ax);
            double _ty = alpha * (UnsafeOpsHolder.U.getDouble(_t2o + 8L)) - _ay + (_ay);
            double _tz = alpha * (UnsafeOpsHolder.U.getDouble(_t2o + 16L)) - _az + (_az);
            double _bx = UnsafeOpsHolder.U.getDouble(_s1o + 0L), _by = UnsafeOpsHolder.U.getDouble(_s1o + 8L), _bz = UnsafeOpsHolder.U.getDouble(_s1o + 16L);
            double _sx = alpha * (UnsafeOpsHolder.U.getDouble(_s2o + 0L)) - _bx + (_bx);
            double _sy = alpha * (UnsafeOpsHolder.U.getDouble(_s2o + 8L)) - _by + (_by);
            double _sz = alpha * (UnsafeOpsHolder.U.getDouble(_s2o + 16L)) - _bz + (_bz);
            double _ux = UnsafeOpsHolder.U.getDouble(_q1o + 0L), _uy = UnsafeOpsHolder.U.getDouble(_q1o + 8L), _uz = UnsafeOpsHolder.U.getDouble(_q1o + 16L), _uw = UnsafeOpsHolder.U.getDouble(_q1o + 24L);
            double _vx = UnsafeOpsHolder.U.getDouble(_q2o + 0L), _vy = UnsafeOpsHolder.U.getDouble(_q2o + 8L), _vz = UnsafeOpsHolder.U.getDouble(_q2o + 16L), _vw = UnsafeOpsHolder.U.getDouble(_q2o + 24L);
            double _dot = _uw * _vw + (_uz * _vz + (_ux * _vx + (_uy * _vy)));
            if (_dot < 0.0) { _vx = -_vx; _vy = -_vy; _vz = -_vz; _vw = -_vw; }
            double _qx = alpha * _vx - _ux + (_ux);
            double _qy = alpha * _vy - _uy + (_uy);
            double _qz = alpha * _vz - _uz + (_uz);
            double _qw = alpha * _vw - _uw + (_uw);
            double _len2 = (_qx * _qx + _qy * _qy) + (_qz * _qz + _qw * _qw);
            double _ninv = _len2 > 0.0 ? 1.0 / Math.sqrt(_len2) : 0.0;
            _qx *= _ninv; _qy *= _ninv; _qz *= _ninv; _qw *= _ninv;
            double _xx = _qx * _qx, _yy = _qy * _qy, _zz = _qz * _qz;
            double _xy = _qx * _qy, _xz = _qx * _qz, _yz = _qy * _qz, _xw = _qx * _qw, _yw = _qy * _qw, _zw = _qz * _qw;
            double _t00 = (1 - 2 * (_yy + _zz)) * _sx, _t01 = (2 * (_xy - _zw)) * _sy, _t02 = (2 * (_xz + _yw)) * _sz;
            double _t10 = (2 * (_xy + _zw)) * _sx, _t11 = (1 - 2 * (_xx + _zz)) * _sy, _t12 = (2 * (_yz - _xw)) * _sz;
            double _t20 = (2 * (_xz - _yw)) * _sx, _t21 = (2 * (_yz + _xw)) * _sy, _t22 = (1 - 2 * (_xx + _yy)) * _sz;
            double _m00 = UnsafeOpsHolder.U.getDouble(_mo + 0L), _m01 = UnsafeOpsHolder.U.getDouble(_mo + 8L), _m02 = UnsafeOpsHolder.U.getDouble(_mo + 16L), _m03 = UnsafeOpsHolder.U.getDouble(_mo + 24L);
            double _m10 = UnsafeOpsHolder.U.getDouble(_mo + 32L), _m11 = UnsafeOpsHolder.U.getDouble(_mo + 40L), _m12 = UnsafeOpsHolder.U.getDouble(_mo + 48L), _m13 = UnsafeOpsHolder.U.getDouble(_mo + 56L);
            double _m20 = UnsafeOpsHolder.U.getDouble(_mo + 64L), _m21 = UnsafeOpsHolder.U.getDouble(_mo + 72L), _m22 = UnsafeOpsHolder.U.getDouble(_mo + 80L), _m23 = UnsafeOpsHolder.U.getDouble(_mo + 88L);
            double _e00 = _t02 * _m20 + (_t01 * _m10 + (_t00 * _m00)), _e01 = _t02 * _m21 + (_t01 * _m11 + (_t00 * _m01)), _e02 = _t02 * _m22 + (_t01 * _m12 + (_t00 * _m02)), _e03 = (_t02 * _m23 + (_t01 * _m13 + (_t00 * _m03))) + _tx;
            double _e10 = _t12 * _m20 + (_t11 * _m10 + (_t10 * _m00)), _e11 = _t12 * _m21 + (_t11 * _m11 + (_t10 * _m01)), _e12 = _t12 * _m22 + (_t11 * _m12 + (_t10 * _m02)), _e13 = (_t12 * _m23 + (_t11 * _m13 + (_t10 * _m03))) + _ty;
            double _e20 = _t22 * _m20 + (_t21 * _m10 + (_t20 * _m00)), _e21 = _t22 * _m21 + (_t21 * _m11 + (_t20 * _m01)), _e22 = _t22 * _m22 + (_t21 * _m12 + (_t20 * _m02)), _e23 = (_t22 * _m23 + (_t21 * _m13 + (_t20 * _m03))) + _tz;
            UnsafeOpsHolder.U.putDouble(_do + 0L, _e00);
            UnsafeOpsHolder.U.putDouble(_do + 8L, _e01);
            UnsafeOpsHolder.U.putDouble(_do + 16L, _e02);
            UnsafeOpsHolder.U.putDouble(_do + 24L, _e03);
            UnsafeOpsHolder.U.putDouble(_do + 32L, _e10);
            UnsafeOpsHolder.U.putDouble(_do + 40L, _e11);
            UnsafeOpsHolder.U.putDouble(_do + 48L, _e12);
            UnsafeOpsHolder.U.putDouble(_do + 56L, _e13);
            UnsafeOpsHolder.U.putDouble(_do + 64L, _e20);
            UnsafeOpsHolder.U.putDouble(_do + 72L, _e21);
            UnsafeOpsHolder.U.putDouble(_do + 80L, _e22);
            UnsafeOpsHolder.U.putDouble(_do + 88L, _e23);
        }
    }

    public static void composeTRSMul_fmaUnsafe(long _destBase, long _translationBase, long _rotationBase, long _scaleBase, long _mBase, int count) {
        for (int _i = 0; _i < count; _i++) {
            long _translationo = _translationBase + _i * 24L;
            long _rotationo = _rotationBase + _i * 32L;
            long _scaleo = _scaleBase + _i * 24L;
            long _mo = _mBase + _i * 96L;
            long _do = _destBase + _i * 96L;
            double _tx = UnsafeOpsHolder.U.getDouble(_translationo + 0L), _ty = UnsafeOpsHolder.U.getDouble(_translationo + 8L), _tz = UnsafeOpsHolder.U.getDouble(_translationo + 16L);
            double _sx = UnsafeOpsHolder.U.getDouble(_scaleo + 0L), _sy = UnsafeOpsHolder.U.getDouble(_scaleo + 8L), _sz = UnsafeOpsHolder.U.getDouble(_scaleo + 16L);
            double _qx = UnsafeOpsHolder.U.getDouble(_rotationo + 0L), _qy = UnsafeOpsHolder.U.getDouble(_rotationo + 8L), _qz = UnsafeOpsHolder.U.getDouble(_rotationo + 16L), _qw = UnsafeOpsHolder.U.getDouble(_rotationo + 24L);
            double _xx = _qx * _qx, _yy = _qy * _qy, _zz = _qz * _qz;
            double _xy = _qx * _qy, _xz = _qx * _qz, _yz = _qy * _qz, _xw = _qx * _qw, _yw = _qy * _qw, _zw = _qz * _qw;
            double _t00 = (1 - 2 * (_yy + _zz)) * _sx, _t01 = (2 * (_xy - _zw)) * _sy, _t02 = (2 * (_xz + _yw)) * _sz;
            double _t10 = (2 * (_xy + _zw)) * _sx, _t11 = (1 - 2 * (_xx + _zz)) * _sy, _t12 = (2 * (_yz - _xw)) * _sz;
            double _t20 = (2 * (_xz - _yw)) * _sx, _t21 = (2 * (_yz + _xw)) * _sy, _t22 = (1 - 2 * (_xx + _yy)) * _sz;
            double _m00 = UnsafeOpsHolder.U.getDouble(_mo + 0L), _m01 = UnsafeOpsHolder.U.getDouble(_mo + 8L), _m02 = UnsafeOpsHolder.U.getDouble(_mo + 16L), _m03 = UnsafeOpsHolder.U.getDouble(_mo + 24L);
            double _m10 = UnsafeOpsHolder.U.getDouble(_mo + 32L), _m11 = UnsafeOpsHolder.U.getDouble(_mo + 40L), _m12 = UnsafeOpsHolder.U.getDouble(_mo + 48L), _m13 = UnsafeOpsHolder.U.getDouble(_mo + 56L);
            double _m20 = UnsafeOpsHolder.U.getDouble(_mo + 64L), _m21 = UnsafeOpsHolder.U.getDouble(_mo + 72L), _m22 = UnsafeOpsHolder.U.getDouble(_mo + 80L), _m23 = UnsafeOpsHolder.U.getDouble(_mo + 88L);
            double _e00 = Math.fma(_t02, _m20, Math.fma(_t01, _m10, _t00 * _m00)), _e01 = Math.fma(_t02, _m21, Math.fma(_t01, _m11, _t00 * _m01)), _e02 = Math.fma(_t02, _m22, Math.fma(_t01, _m12, _t00 * _m02)), _e03 = (Math.fma(_t02, _m23, Math.fma(_t01, _m13, _t00 * _m03))) + _tx;
            double _e10 = Math.fma(_t12, _m20, Math.fma(_t11, _m10, _t10 * _m00)), _e11 = Math.fma(_t12, _m21, Math.fma(_t11, _m11, _t10 * _m01)), _e12 = Math.fma(_t12, _m22, Math.fma(_t11, _m12, _t10 * _m02)), _e13 = (Math.fma(_t12, _m23, Math.fma(_t11, _m13, _t10 * _m03))) + _ty;
            double _e20 = Math.fma(_t22, _m20, Math.fma(_t21, _m10, _t20 * _m00)), _e21 = Math.fma(_t22, _m21, Math.fma(_t21, _m11, _t20 * _m01)), _e22 = Math.fma(_t22, _m22, Math.fma(_t21, _m12, _t20 * _m02)), _e23 = (Math.fma(_t22, _m23, Math.fma(_t21, _m13, _t20 * _m03))) + _tz;
            UnsafeOpsHolder.U.putDouble(_do + 0L, _e00);
            UnsafeOpsHolder.U.putDouble(_do + 8L, _e01);
            UnsafeOpsHolder.U.putDouble(_do + 16L, _e02);
            UnsafeOpsHolder.U.putDouble(_do + 24L, _e03);
            UnsafeOpsHolder.U.putDouble(_do + 32L, _e10);
            UnsafeOpsHolder.U.putDouble(_do + 40L, _e11);
            UnsafeOpsHolder.U.putDouble(_do + 48L, _e12);
            UnsafeOpsHolder.U.putDouble(_do + 56L, _e13);
            UnsafeOpsHolder.U.putDouble(_do + 64L, _e20);
            UnsafeOpsHolder.U.putDouble(_do + 72L, _e21);
            UnsafeOpsHolder.U.putDouble(_do + 80L, _e22);
            UnsafeOpsHolder.U.putDouble(_do + 88L, _e23);
        }
    }

    public static void composeTRSMul_mulAddUnsafe(long _destBase, long _translationBase, long _rotationBase, long _scaleBase, long _mBase, int count) {
        for (int _i = 0; _i < count; _i++) {
            long _translationo = _translationBase + _i * 24L;
            long _rotationo = _rotationBase + _i * 32L;
            long _scaleo = _scaleBase + _i * 24L;
            long _mo = _mBase + _i * 96L;
            long _do = _destBase + _i * 96L;
            double _tx = UnsafeOpsHolder.U.getDouble(_translationo + 0L), _ty = UnsafeOpsHolder.U.getDouble(_translationo + 8L), _tz = UnsafeOpsHolder.U.getDouble(_translationo + 16L);
            double _sx = UnsafeOpsHolder.U.getDouble(_scaleo + 0L), _sy = UnsafeOpsHolder.U.getDouble(_scaleo + 8L), _sz = UnsafeOpsHolder.U.getDouble(_scaleo + 16L);
            double _qx = UnsafeOpsHolder.U.getDouble(_rotationo + 0L), _qy = UnsafeOpsHolder.U.getDouble(_rotationo + 8L), _qz = UnsafeOpsHolder.U.getDouble(_rotationo + 16L), _qw = UnsafeOpsHolder.U.getDouble(_rotationo + 24L);
            double _xx = _qx * _qx, _yy = _qy * _qy, _zz = _qz * _qz;
            double _xy = _qx * _qy, _xz = _qx * _qz, _yz = _qy * _qz, _xw = _qx * _qw, _yw = _qy * _qw, _zw = _qz * _qw;
            double _t00 = (1 - 2 * (_yy + _zz)) * _sx, _t01 = (2 * (_xy - _zw)) * _sy, _t02 = (2 * (_xz + _yw)) * _sz;
            double _t10 = (2 * (_xy + _zw)) * _sx, _t11 = (1 - 2 * (_xx + _zz)) * _sy, _t12 = (2 * (_yz - _xw)) * _sz;
            double _t20 = (2 * (_xz - _yw)) * _sx, _t21 = (2 * (_yz + _xw)) * _sy, _t22 = (1 - 2 * (_xx + _yy)) * _sz;
            double _m00 = UnsafeOpsHolder.U.getDouble(_mo + 0L), _m01 = UnsafeOpsHolder.U.getDouble(_mo + 8L), _m02 = UnsafeOpsHolder.U.getDouble(_mo + 16L), _m03 = UnsafeOpsHolder.U.getDouble(_mo + 24L);
            double _m10 = UnsafeOpsHolder.U.getDouble(_mo + 32L), _m11 = UnsafeOpsHolder.U.getDouble(_mo + 40L), _m12 = UnsafeOpsHolder.U.getDouble(_mo + 48L), _m13 = UnsafeOpsHolder.U.getDouble(_mo + 56L);
            double _m20 = UnsafeOpsHolder.U.getDouble(_mo + 64L), _m21 = UnsafeOpsHolder.U.getDouble(_mo + 72L), _m22 = UnsafeOpsHolder.U.getDouble(_mo + 80L), _m23 = UnsafeOpsHolder.U.getDouble(_mo + 88L);
            double _e00 = _t02 * _m20 + (_t01 * _m10 + (_t00 * _m00)), _e01 = _t02 * _m21 + (_t01 * _m11 + (_t00 * _m01)), _e02 = _t02 * _m22 + (_t01 * _m12 + (_t00 * _m02)), _e03 = (_t02 * _m23 + (_t01 * _m13 + (_t00 * _m03))) + _tx;
            double _e10 = _t12 * _m20 + (_t11 * _m10 + (_t10 * _m00)), _e11 = _t12 * _m21 + (_t11 * _m11 + (_t10 * _m01)), _e12 = _t12 * _m22 + (_t11 * _m12 + (_t10 * _m02)), _e13 = (_t12 * _m23 + (_t11 * _m13 + (_t10 * _m03))) + _ty;
            double _e20 = _t22 * _m20 + (_t21 * _m10 + (_t20 * _m00)), _e21 = _t22 * _m21 + (_t21 * _m11 + (_t20 * _m01)), _e22 = _t22 * _m22 + (_t21 * _m12 + (_t20 * _m02)), _e23 = (_t22 * _m23 + (_t21 * _m13 + (_t20 * _m03))) + _tz;
            UnsafeOpsHolder.U.putDouble(_do + 0L, _e00);
            UnsafeOpsHolder.U.putDouble(_do + 8L, _e01);
            UnsafeOpsHolder.U.putDouble(_do + 16L, _e02);
            UnsafeOpsHolder.U.putDouble(_do + 24L, _e03);
            UnsafeOpsHolder.U.putDouble(_do + 32L, _e10);
            UnsafeOpsHolder.U.putDouble(_do + 40L, _e11);
            UnsafeOpsHolder.U.putDouble(_do + 48L, _e12);
            UnsafeOpsHolder.U.putDouble(_do + 56L, _e13);
            UnsafeOpsHolder.U.putDouble(_do + 64L, _e20);
            UnsafeOpsHolder.U.putDouble(_do + 72L, _e21);
            UnsafeOpsHolder.U.putDouble(_do + 80L, _e22);
            UnsafeOpsHolder.U.putDouble(_do + 88L, _e23);
        }
    }

    public static void composeTRSMulPadded_fmaUnsafe(long _destBase, long _translationBase, long _rotationBase, long _scaleBase, long _mBase) {
        double _qx = UnsafeOpsHolder.U.getDouble(_rotationBase + 0L), _qy = UnsafeOpsHolder.U.getDouble(_rotationBase + 8L), _qz = UnsafeOpsHolder.U.getDouble(_rotationBase + 16L), _qw = UnsafeOpsHolder.U.getDouble(_rotationBase + 24L);
        double _tx = UnsafeOpsHolder.U.getDouble(_translationBase + 0L), _ty = UnsafeOpsHolder.U.getDouble(_translationBase + 8L), _tz = UnsafeOpsHolder.U.getDouble(_translationBase + 16L);
        double _sx = UnsafeOpsHolder.U.getDouble(_scaleBase + 0L), _sy = UnsafeOpsHolder.U.getDouble(_scaleBase + 8L), _sz = UnsafeOpsHolder.U.getDouble(_scaleBase + 16L);
        double _m00 = UnsafeOpsHolder.U.getDouble(_mBase + 0L), _m01 = UnsafeOpsHolder.U.getDouble(_mBase + 8L), _m02 = UnsafeOpsHolder.U.getDouble(_mBase + 16L), _m03 = UnsafeOpsHolder.U.getDouble(_mBase + 24L);
        double _m10 = UnsafeOpsHolder.U.getDouble(_mBase + 32L), _m11 = UnsafeOpsHolder.U.getDouble(_mBase + 40L), _m12 = UnsafeOpsHolder.U.getDouble(_mBase + 48L), _m13 = UnsafeOpsHolder.U.getDouble(_mBase + 56L);
        double _m20 = UnsafeOpsHolder.U.getDouble(_mBase + 64L), _m21 = UnsafeOpsHolder.U.getDouble(_mBase + 72L), _m22 = UnsafeOpsHolder.U.getDouble(_mBase + 80L), _m23 = UnsafeOpsHolder.U.getDouble(_mBase + 88L);
        double _xx = _qx * _qx, _yy = _qy * _qy, _zz = _qz * _qz;
        double _xy = _qx * _qy, _xz = _qx * _qz, _yz = _qy * _qz, _xw = _qx * _qw, _yw = _qy * _qw, _zw = _qz * _qw;
        double _t00 = (1 - 2 * (_yy + _zz)) * _sx, _t01 = (2 * (_xy - _zw)) * _sy, _t02 = (2 * (_xz + _yw)) * _sz;
        double _t10 = (2 * (_xy + _zw)) * _sx, _t11 = (1 - 2 * (_xx + _zz)) * _sy, _t12 = (2 * (_yz - _xw)) * _sz;
        double _t20 = (2 * (_xz - _yw)) * _sx, _t21 = (2 * (_yz + _xw)) * _sy, _t22 = (1 - 2 * (_xx + _yy)) * _sz;
        double _e00 = Math.fma(_t02, _m20, Math.fma(_t01, _m10, _t00 * _m00)), _e01 = Math.fma(_t02, _m21, Math.fma(_t01, _m11, _t00 * _m01)), _e02 = Math.fma(_t02, _m22, Math.fma(_t01, _m12, _t00 * _m02)), _e03 = (Math.fma(_t02, _m23, Math.fma(_t01, _m13, _t00 * _m03))) + _tx;
        double _e10 = Math.fma(_t12, _m20, Math.fma(_t11, _m10, _t10 * _m00)), _e11 = Math.fma(_t12, _m21, Math.fma(_t11, _m11, _t10 * _m01)), _e12 = Math.fma(_t12, _m22, Math.fma(_t11, _m12, _t10 * _m02)), _e13 = (Math.fma(_t12, _m23, Math.fma(_t11, _m13, _t10 * _m03))) + _ty;
        double _e20 = Math.fma(_t22, _m20, Math.fma(_t21, _m10, _t20 * _m00)), _e21 = Math.fma(_t22, _m21, Math.fma(_t21, _m11, _t20 * _m01)), _e22 = Math.fma(_t22, _m22, Math.fma(_t21, _m12, _t20 * _m02)), _e23 = (Math.fma(_t22, _m23, Math.fma(_t21, _m13, _t20 * _m03))) + _tz;
        UnsafeOpsHolder.U.putDouble(_destBase + 0L, _e00);
        UnsafeOpsHolder.U.putDouble(_destBase + 8L, _e01);
        UnsafeOpsHolder.U.putDouble(_destBase + 16L, _e02);
        UnsafeOpsHolder.U.putDouble(_destBase + 24L, _e03);
        UnsafeOpsHolder.U.putDouble(_destBase + 32L, _e10);
        UnsafeOpsHolder.U.putDouble(_destBase + 40L, _e11);
        UnsafeOpsHolder.U.putDouble(_destBase + 48L, _e12);
        UnsafeOpsHolder.U.putDouble(_destBase + 56L, _e13);
        UnsafeOpsHolder.U.putDouble(_destBase + 64L, _e20);
        UnsafeOpsHolder.U.putDouble(_destBase + 72L, _e21);
        UnsafeOpsHolder.U.putDouble(_destBase + 80L, _e22);
        UnsafeOpsHolder.U.putDouble(_destBase + 88L, _e23);
    }

    public static void composeTRSMulPadded_mulAddUnsafe(long _destBase, long _translationBase, long _rotationBase, long _scaleBase, long _mBase) {
        double _qx = UnsafeOpsHolder.U.getDouble(_rotationBase + 0L), _qy = UnsafeOpsHolder.U.getDouble(_rotationBase + 8L), _qz = UnsafeOpsHolder.U.getDouble(_rotationBase + 16L), _qw = UnsafeOpsHolder.U.getDouble(_rotationBase + 24L);
        double _tx = UnsafeOpsHolder.U.getDouble(_translationBase + 0L), _ty = UnsafeOpsHolder.U.getDouble(_translationBase + 8L), _tz = UnsafeOpsHolder.U.getDouble(_translationBase + 16L);
        double _sx = UnsafeOpsHolder.U.getDouble(_scaleBase + 0L), _sy = UnsafeOpsHolder.U.getDouble(_scaleBase + 8L), _sz = UnsafeOpsHolder.U.getDouble(_scaleBase + 16L);
        double _m00 = UnsafeOpsHolder.U.getDouble(_mBase + 0L), _m01 = UnsafeOpsHolder.U.getDouble(_mBase + 8L), _m02 = UnsafeOpsHolder.U.getDouble(_mBase + 16L), _m03 = UnsafeOpsHolder.U.getDouble(_mBase + 24L);
        double _m10 = UnsafeOpsHolder.U.getDouble(_mBase + 32L), _m11 = UnsafeOpsHolder.U.getDouble(_mBase + 40L), _m12 = UnsafeOpsHolder.U.getDouble(_mBase + 48L), _m13 = UnsafeOpsHolder.U.getDouble(_mBase + 56L);
        double _m20 = UnsafeOpsHolder.U.getDouble(_mBase + 64L), _m21 = UnsafeOpsHolder.U.getDouble(_mBase + 72L), _m22 = UnsafeOpsHolder.U.getDouble(_mBase + 80L), _m23 = UnsafeOpsHolder.U.getDouble(_mBase + 88L);
        double _xx = _qx * _qx, _yy = _qy * _qy, _zz = _qz * _qz;
        double _xy = _qx * _qy, _xz = _qx * _qz, _yz = _qy * _qz, _xw = _qx * _qw, _yw = _qy * _qw, _zw = _qz * _qw;
        double _t00 = (1 - 2 * (_yy + _zz)) * _sx, _t01 = (2 * (_xy - _zw)) * _sy, _t02 = (2 * (_xz + _yw)) * _sz;
        double _t10 = (2 * (_xy + _zw)) * _sx, _t11 = (1 - 2 * (_xx + _zz)) * _sy, _t12 = (2 * (_yz - _xw)) * _sz;
        double _t20 = (2 * (_xz - _yw)) * _sx, _t21 = (2 * (_yz + _xw)) * _sy, _t22 = (1 - 2 * (_xx + _yy)) * _sz;
        double _e00 = _t02 * _m20 + (_t01 * _m10 + (_t00 * _m00)), _e01 = _t02 * _m21 + (_t01 * _m11 + (_t00 * _m01)), _e02 = _t02 * _m22 + (_t01 * _m12 + (_t00 * _m02)), _e03 = (_t02 * _m23 + (_t01 * _m13 + (_t00 * _m03))) + _tx;
        double _e10 = _t12 * _m20 + (_t11 * _m10 + (_t10 * _m00)), _e11 = _t12 * _m21 + (_t11 * _m11 + (_t10 * _m01)), _e12 = _t12 * _m22 + (_t11 * _m12 + (_t10 * _m02)), _e13 = (_t12 * _m23 + (_t11 * _m13 + (_t10 * _m03))) + _ty;
        double _e20 = _t22 * _m20 + (_t21 * _m10 + (_t20 * _m00)), _e21 = _t22 * _m21 + (_t21 * _m11 + (_t20 * _m01)), _e22 = _t22 * _m22 + (_t21 * _m12 + (_t20 * _m02)), _e23 = (_t22 * _m23 + (_t21 * _m13 + (_t20 * _m03))) + _tz;
        UnsafeOpsHolder.U.putDouble(_destBase + 0L, _e00);
        UnsafeOpsHolder.U.putDouble(_destBase + 8L, _e01);
        UnsafeOpsHolder.U.putDouble(_destBase + 16L, _e02);
        UnsafeOpsHolder.U.putDouble(_destBase + 24L, _e03);
        UnsafeOpsHolder.U.putDouble(_destBase + 32L, _e10);
        UnsafeOpsHolder.U.putDouble(_destBase + 40L, _e11);
        UnsafeOpsHolder.U.putDouble(_destBase + 48L, _e12);
        UnsafeOpsHolder.U.putDouble(_destBase + 56L, _e13);
        UnsafeOpsHolder.U.putDouble(_destBase + 64L, _e20);
        UnsafeOpsHolder.U.putDouble(_destBase + 72L, _e21);
        UnsafeOpsHolder.U.putDouble(_destBase + 80L, _e22);
        UnsafeOpsHolder.U.putDouble(_destBase + 88L, _e23);
    }

}
