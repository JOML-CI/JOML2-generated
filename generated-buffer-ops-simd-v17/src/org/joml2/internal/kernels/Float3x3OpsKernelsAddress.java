package org.joml2.internal.kernels;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.ops.*;
import org.joml2.internal.unsafe.*;
import org.joml2.internal.simd.*;

/**
 * Scalar/Unsafe kernel leaves of {@link Float3x3Ops} whose leading storage
 * parameter is a raw {@code long} native address (the shared Unsafe kernels). Split into a sibling compilation unit purely
 * to keep generated sources IDE-sized; package-private, called only from
 * {@code Float3x3Ops} and its sibling kernel units. Not public API.
 */
public final class Float3x3OpsKernelsAddress {
    private Float3x3OpsKernelsAddress() {}

    public static long getColumn_unsafe(long dest, long src, int col) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _idxSw0;
        float _idxSw1;
        float _idxSw2;
        switch (col) {
            case 0: _idxSw0 = _self00; _idxSw1 = _self10; _idxSw2 = _self20; break;
            case 1: _idxSw0 = _self01; _idxSw1 = _self11; _idxSw2 = _self21; break;
            case 2: _idxSw0 = _self02; _idxSw1 = _self12; _idxSw2 = _self22; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + col);
        }
        UnsafeOpsHolder.U.putFloat(dest + 0L, _idxSw0);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _idxSw1);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _idxSw2);
        return dest;
    }

    public static long getEulerAnglesXYZ_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _t1 = Math.fma(_self12, _self12, _self22 * _self22);
        float _t3 = Math.fma(_self02, _self02, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.atan2(_self21, _self11));
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.atan2(-_self12, _self22));
            UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.atan2(-_self01, _self00));
        }
        UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.atan2(_self02, (float) Math.sqrt(_t1)));
        return dest;
    }

    public static long getEulerAnglesXZY_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _t1 = Math.fma(_self11, _self11, _self21 * _self21);
        float _t3 = Math.fma(_self01, _self01, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.atan2(-_self12, _self22));
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.atan2(_self21, _self11));
            UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.atan2(_self02, _self00));
        }
        UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.atan2(-_self01, (float) Math.sqrt(_t1)));
        return dest;
    }

    public static long getEulerAnglesYXZ_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _t1 = Math.fma(_self02, _self02, _self22 * _self22);
        float _t3 = Math.fma(_self12, _self12, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.atan2(-_self20, _self00));
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.atan2(_self02, _self22));
            UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.atan2(_self10, _self11));
        }
        UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.atan2(-_self12, (float) Math.sqrt(_t1)));
        return dest;
    }

    public static long getEulerAnglesYZX_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _t1 = Math.fma(_self11, _self11, _self12 * _self12);
        float _t3 = Math.fma(_self10, _self10, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.atan2(_self02, _self22));
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.atan2(-_self12, _self11));
            UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.atan2(-_self20, _self00));
        }
        UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.atan2(_self10, (float) Math.sqrt(_t1)));
        return dest;
    }

    public static long getEulerAnglesZXY_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _t1 = Math.fma(_self01, _self01, _self11 * _self11);
        float _t3 = Math.fma(_self21, _self21, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.atan2(_self10, _self00));
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.atan2(-_self20, _self22));
            UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.atan2(-_self01, _self11));
        }
        UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.atan2(_self21, (float) Math.sqrt(_t1)));
        return dest;
    }

    public static long getEulerAnglesZYX_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _t1 = Math.fma(_self21, _self21, _self22 * _self22);
        float _t3 = Math.fma(_self20, _self20, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.atan2(-_self01, _self11));
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.atan2(_self21, _self22));
            UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.atan2(_self10, _self00));
        }
        UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.atan2(-_self20, (float) Math.sqrt(_t1)));
        return dest;
    }

    public static long getNormalizedRotation_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
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
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.5f * _t36 * _t66);
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.5f * _t56 * _t66);
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.5f * _t57 * _t66);
            UnsafeOpsHolder.U.putFloat(dest + 12L, 0.5f * (float) Math.sqrt(_t62));
        } else {
            if (_t49 > _t37) {
                UnsafeOpsHolder.U.putFloat(dest + 0L, 0.5f * (float) Math.sqrt(_t63));
                UnsafeOpsHolder.U.putFloat(dest + 4L, 0.5f * _t53 * _t69);
                UnsafeOpsHolder.U.putFloat(dest + 8L, 0.5f * _t55 * _t69);
                UnsafeOpsHolder.U.putFloat(dest + 12L, 0.5f * _t36 * _t69);
            } else {
                if (_t23 > _t26) {
                    UnsafeOpsHolder.U.putFloat(dest + 0L, 0.5f * _t53 * _t67);
                    UnsafeOpsHolder.U.putFloat(dest + 4L, 0.5f * (float) Math.sqrt(_t64));
                    UnsafeOpsHolder.U.putFloat(dest + 8L, 0.5f * _t39 * _t67);
                    UnsafeOpsHolder.U.putFloat(dest + 12L, 0.5f * _t56 * _t67);
                } else {
                    UnsafeOpsHolder.U.putFloat(dest + 0L, 0.5f * _t55 * _t68);
                    UnsafeOpsHolder.U.putFloat(dest + 4L, 0.5f * _t39 * _t68);
                    UnsafeOpsHolder.U.putFloat(dest + 8L, 0.5f * (float) Math.sqrt(_t65));
                    UnsafeOpsHolder.U.putFloat(dest + 12L, 0.5f * _t57 * _t68);
                }
            }
        }
        return dest;
    }

    public static long getRow_unsafe(long dest, long src, int row) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _idxSw0;
        float _idxSw1;
        float _idxSw2;
        switch (row) {
            case 0: _idxSw0 = _self00; _idxSw1 = _self01; _idxSw2 = _self02; break;
            case 1: _idxSw0 = _self10; _idxSw1 = _self11; _idxSw2 = _self12; break;
            case 2: _idxSw0 = _self20; _idxSw1 = _self21; _idxSw2 = _self22; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + row);
        }
        UnsafeOpsHolder.U.putFloat(dest + 0L, _idxSw0);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _idxSw1);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _idxSw2);
        return dest;
    }

    public static long getScale_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.sqrt(Math.fma(_self20, _self20, Math.fma(_self00, _self00, _self10 * _self10))));
        UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.sqrt(Math.fma(_self21, _self21, Math.fma(_self01, _self01, _self11 * _self11))));
        UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.sqrt(Math.fma(_self22, _self22, Math.fma(_self02, _self02, _self12 * _self12))));
        return dest;
    }

    public static long getTranslation_unsafe(long dest, long src) {
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self02);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self12);
        return dest;
    }

    public static long getUnnormalizedRotation_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
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
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.5f * _t1 * _t18);
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.5f * _t7 * _t18);
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.5f * _t9 * _t18);
            UnsafeOpsHolder.U.putFloat(dest + 12L, 0.5f * (float) Math.sqrt(_t14));
        } else {
            if (_self00 > _t2) {
                UnsafeOpsHolder.U.putFloat(dest + 0L, 0.5f * (float) Math.sqrt(_t15));
                UnsafeOpsHolder.U.putFloat(dest + 4L, 0.5f * _t4 * _t21);
                UnsafeOpsHolder.U.putFloat(dest + 8L, 0.5f * _t6 * _t21);
                UnsafeOpsHolder.U.putFloat(dest + 12L, 0.5f * _t1 * _t21);
            } else {
                if (_self11 > _self22) {
                    UnsafeOpsHolder.U.putFloat(dest + 0L, 0.5f * _t4 * _t19);
                    UnsafeOpsHolder.U.putFloat(dest + 4L, 0.5f * (float) Math.sqrt(_t16));
                    UnsafeOpsHolder.U.putFloat(dest + 8L, 0.5f * _t8 * _t19);
                    UnsafeOpsHolder.U.putFloat(dest + 12L, 0.5f * _t7 * _t19);
                } else {
                    UnsafeOpsHolder.U.putFloat(dest + 0L, 0.5f * _t6 * _t20);
                    UnsafeOpsHolder.U.putFloat(dest + 4L, 0.5f * _t8 * _t20);
                    UnsafeOpsHolder.U.putFloat(dest + 8L, 0.5f * (float) Math.sqrt(_t17));
                    UnsafeOpsHolder.U.putFloat(dest + 12L, 0.5f * _t9 * _t20);
                }
            }
        }
        return dest;
    }

    public static long cofactor_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_self11, _self22, -(_self12 * _self21)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self02, _self21, -(_self01 * _self22)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self01, _self12, -(_self02 * _self11)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_self12, _self20, -(_self10 * _self22)));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self00, _self22, -(_self02 * _self20)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self02, _self10, -(_self00 * _self12)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self10, _self21, -(_self11 * _self20)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_self01, _self20, -(_self00 * _self21)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self00, _self11, -(_self01 * _self10)));
        return dest;
    }

    public static float determinant_unsafe(long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        return Math.fma(_self02, Math.fma(_self10, _self21, -(_self11 * _self20)), Math.fma(_self00, Math.fma(_self11, _self22, -(_self12 * _self21)), -(_self01 * Math.fma(_self10, _self22, -(_self12 * _self20)))));
    }

    public static float frobeniusNorm_unsafe(long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        return (float) Math.sqrt(Math.fma(_self00, _self00, _self01 * _self01) + Math.fma(_self02, _self02, _self10 * _self10) + (Math.fma(_self11, _self11, _self12 * _self12) + Math.fma(_self20, _self20, Math.fma(_self21, _self21, _self22 * _self22))));
    }

    public static long invert_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _t6 = Math.fma(_self11, _self22, -(_self12 * _self21));
        float _t7 = Math.fma(_self10, _self21, -(_self11 * _self20));
        float _t12 = Math.fma(_self02, _t7, Math.fma(_self00, _t6, -(_self01 * Math.fma(_self10, _self22, -(_self12 * _self20)))));
        float _t12_inv = 1.0f / _t12;
        UnsafeOpsHolder.U.putFloat(dest + 0L, _t6 * _t12_inv);
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self12, _self20, -(_self10 * _self22)) * _t12_inv);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _t7 * _t12_inv);
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_self02, _self21, -(_self01 * _self22)) * _t12_inv);
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self00, _self22, -(_self02 * _self20)) * _t12_inv);
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self01, _self20, -(_self00 * _self21)) * _t12_inv);
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self01, _self12, -(_self02 * _self11)) * _t12_inv);
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_self02, _self10, -(_self00 * _self12)) * _t12_inv);
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self00, _self11, -(_self01 * _self10)) * _t12_inv);
        return dest;
    }

    public static long invertProduct_unsafe(long dest, long src, long other) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _other00 = UnsafeOpsHolder.U.getFloat(other + 0L);
        float _other10 = UnsafeOpsHolder.U.getFloat(other + 4L);
        float _other20 = UnsafeOpsHolder.U.getFloat(other + 8L);
        float _other01 = UnsafeOpsHolder.U.getFloat(other + 12L);
        float _other11 = UnsafeOpsHolder.U.getFloat(other + 16L);
        float _other21 = UnsafeOpsHolder.U.getFloat(other + 20L);
        float _other02 = UnsafeOpsHolder.U.getFloat(other + 24L);
        float _other12 = UnsafeOpsHolder.U.getFloat(other + 28L);
        float _other22 = UnsafeOpsHolder.U.getFloat(other + 32L);
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
        UnsafeOpsHolder.U.putFloat(dest + 0L, _t33 * _t39_inv);
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_t24, _t21, -(_t23 * _t19)) * _t39_inv);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _t34 * _t39_inv);
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_t20, _t22, -(_t26 * _t19)) * _t39_inv);
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_t25, _t19, -(_t24 * _t22)) * _t39_inv);
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_t24, _t26, -(_t25 * _t20)) * _t39_inv);
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_t26, _t21, -(_t18 * _t22)) * _t39_inv);
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_t23, _t22, -(_t25 * _t21)) * _t39_inv);
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_t25, _t18, -(_t23 * _t26)) * _t39_inv);
        return dest;
    }

    public static long normal_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _t6 = Math.fma(_self11, _self22, -(_self12 * _self21));
        float _t7 = Math.fma(_self10, _self21, -(_self11 * _self20));
        float _t12 = Math.fma(_self02, _t7, Math.fma(_self00, _t6, -(_self01 * Math.fma(_self10, _self22, -(_self12 * _self20)))));
        float _t12_inv = 1.0f / _t12;
        UnsafeOpsHolder.U.putFloat(dest + 0L, _t6 * _t12_inv);
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self02, _self21, -(_self01 * _self22)) * _t12_inv);
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self01, _self12, -(_self02 * _self11)) * _t12_inv);
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_self12, _self20, -(_self10 * _self22)) * _t12_inv);
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self00, _self22, -(_self02 * _self20)) * _t12_inv);
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self02, _self10, -(_self00 * _self12)) * _t12_inv);
        UnsafeOpsHolder.U.putFloat(dest + 24L, _t7 * _t12_inv);
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_self01, _self20, -(_self00 * _self21)) * _t12_inv);
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self00, _self11, -(_self01 * _self10)) * _t12_inv);
        return dest;
    }

    public static float trace_unsafe(long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        return _self22 + (_self00 + _self11);
    }

    public static long transpose_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self01);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self02);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self10);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _self11);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _self12);
        UnsafeOpsHolder.U.putFloat(dest + 24L, _self20);
        UnsafeOpsHolder.U.putFloat(dest + 28L, _self21);
        UnsafeOpsHolder.U.putFloat(dest + 32L, _self22);
        return dest;
    }

    public static long add_unsafe(long dest, long src, long other) {
        for (int _i = 0; _i < 9; _i++) {
            float _eself = UnsafeOpsHolder.U.getFloat(src + _i * 4L);
            float _eother = UnsafeOpsHolder.U.getFloat(other + _i * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _i * 4L, _eother + _eself);
        }
        return dest;
    }

    public static long negate_unsafe(long dest, long src) {
        for (int _i = 0; _i < 9; _i++) {
            float _eself = UnsafeOpsHolder.U.getFloat(src + _i * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _i * 4L, -_eself);
        }
        return dest;
    }

    public static long sub_unsafe(long dest, long src, long other) {
        for (int _i = 0; _i < 9; _i++) {
            float _eself = UnsafeOpsHolder.U.getFloat(src + _i * 4L);
            float _eother = UnsafeOpsHolder.U.getFloat(other + _i * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _i * 4L, _eself - _eother);
        }
        return dest;
    }

    public static long set_unsafe(long dest, long v) {
        for (int _i = 0; _i < 9; _i++) {
            float _ev = UnsafeOpsHolder.U.getFloat(v + _i * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _i * 4L, _ev);
        }
        return dest;
    }

    public static long setMat2x2_unsafe(long dest, long m) {
        float _m00 = UnsafeOpsHolder.U.getFloat(m + 0L);
        float _m10 = UnsafeOpsHolder.U.getFloat(m + 4L);
        float _m01 = UnsafeOpsHolder.U.getFloat(m + 8L);
        float _m11 = UnsafeOpsHolder.U.getFloat(m + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _m00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _m10);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _m01);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _m11);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 1.0f);
        return dest;
    }

    public static long setMat2x3_unsafe(long dest, long m) {
        float _m00 = UnsafeOpsHolder.U.getFloat(m + 0L);
        float _m10 = UnsafeOpsHolder.U.getFloat(m + 4L);
        float _m01 = UnsafeOpsHolder.U.getFloat(m + 8L);
        float _m11 = UnsafeOpsHolder.U.getFloat(m + 12L);
        float _m02 = UnsafeOpsHolder.U.getFloat(m + 16L);
        float _m12 = UnsafeOpsHolder.U.getFloat(m + 20L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _m00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _m10);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _m01);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _m11);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, _m02);
        UnsafeOpsHolder.U.putFloat(dest + 28L, _m12);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 1.0f);
        return dest;
    }

    public static long setMat3x4_unsafe(long dest, long m) {
        float _m00 = UnsafeOpsHolder.U.getFloat(m + 0L);
        float _m01 = UnsafeOpsHolder.U.getFloat(m + 4L);
        float _m02 = UnsafeOpsHolder.U.getFloat(m + 8L);
        float _m10 = UnsafeOpsHolder.U.getFloat(m + 16L);
        float _m11 = UnsafeOpsHolder.U.getFloat(m + 20L);
        float _m12 = UnsafeOpsHolder.U.getFloat(m + 24L);
        float _m20 = UnsafeOpsHolder.U.getFloat(m + 32L);
        float _m21 = UnsafeOpsHolder.U.getFloat(m + 36L);
        float _m22 = UnsafeOpsHolder.U.getFloat(m + 40L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _m00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _m10);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _m20);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _m01);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _m11);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _m21);
        UnsafeOpsHolder.U.putFloat(dest + 24L, _m02);
        UnsafeOpsHolder.U.putFloat(dest + 28L, _m12);
        UnsafeOpsHolder.U.putFloat(dest + 32L, _m22);
        return dest;
    }

    public static long setMat4x4_unsafe(long dest, long m) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 3;
            int _lom = _l * 4;
            float _em0 = UnsafeOpsHolder.U.getFloat(m + _lom * 4L);
            float _em1 = UnsafeOpsHolder.U.getFloat(m + (_lom + 1) * 4L);
            float _em2 = UnsafeOpsHolder.U.getFloat(m + (_lom + 2) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, _em0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, _em1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, _em2);
        }
        return dest;
    }

    public static long withTranslation_unsafe(long dest, long src, float tX, float tY) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self10);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self20);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self01);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _self11);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _self21);
        UnsafeOpsHolder.U.putFloat(dest + 24L, tX);
        UnsafeOpsHolder.U.putFloat(dest + 28L, tY);
        UnsafeOpsHolder.U.putFloat(dest + 32L, _self22);
        return dest;
    }

    public static long withTranslation_unsafe(long dest, long src, long t) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _tx = UnsafeOpsHolder.U.getFloat(t + 0L);
        float _ty = UnsafeOpsHolder.U.getFloat(t + 4L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self10);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self20);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self01);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _self11);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _self21);
        UnsafeOpsHolder.U.putFloat(dest + 24L, _tx);
        UnsafeOpsHolder.U.putFloat(dest + 28L, _ty);
        UnsafeOpsHolder.U.putFloat(dest + 32L, _self22);
        return dest;
    }

    public static long makeFromRigid_unsafe(long dest, float rTX, float rTY, float rTZ, float rRX, float rRY, float rRZ, float rRW) {
        float _t0 = rRZ * rRZ;
        float _t1 = rRZ * rRW;
        float _t2 = rRY * rRW;
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(-2.0f, Math.fma(rRY, rRY, _t0), 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 4L, 2.0f * Math.fma(rRX, rRY, _t1));
        UnsafeOpsHolder.U.putFloat(dest + 8L, 2.0f * Math.fma(rRX, rRZ, -_t2));
        UnsafeOpsHolder.U.putFloat(dest + 12L, 2.0f * Math.fma(rRX, rRY, -_t1));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(-2.0f, Math.fma(rRX, rRX, _t0), 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 20L, 2.0f * Math.fma(rRX, rRW, rRY * rRZ));
        UnsafeOpsHolder.U.putFloat(dest + 24L, 2.0f * Math.fma(rRX, rRZ, _t2));
        UnsafeOpsHolder.U.putFloat(dest + 28L, 2.0f * Math.fma(rRY, rRZ, -(rRX * rRW)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(-2.0f, Math.fma(rRX, rRX, rRY * rRY), 1.0f));
        return dest;
    }

    public static long makeFromTransform_unsafe(long dest, float tTX, float tTY, float tTZ, float tRX, float tRY, float tRZ, float tRW, float tSX, float tSY, float tSZ) {
        float _t0 = tRZ * tRZ;
        float _t1 = tRZ * tRW;
        float _t2 = tRY * tRW;
        UnsafeOpsHolder.U.putFloat(dest + 0L, tSX * Math.fma(-2.0f, Math.fma(tRY, tRY, _t0), 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 4L, tSX * 2.0f * Math.fma(tRX, tRY, _t1));
        UnsafeOpsHolder.U.putFloat(dest + 8L, tSX * 2.0f * Math.fma(tRX, tRZ, -_t2));
        UnsafeOpsHolder.U.putFloat(dest + 12L, tSY * 2.0f * Math.fma(tRX, tRY, -_t1));
        UnsafeOpsHolder.U.putFloat(dest + 16L, tSY * Math.fma(-2.0f, Math.fma(tRX, tRX, _t0), 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 20L, tSY * 2.0f * Math.fma(tRX, tRW, tRY * tRZ));
        UnsafeOpsHolder.U.putFloat(dest + 24L, tSZ * 2.0f * Math.fma(tRX, tRZ, _t2));
        UnsafeOpsHolder.U.putFloat(dest + 28L, tSZ * 2.0f * Math.fma(tRY, tRZ, -(tRX * tRW)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, tSZ * Math.fma(-2.0f, Math.fma(tRX, tRX, tRY * tRY), 1.0f));
        return dest;
    }

    public static long to2x2_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self10);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self01);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self11);
        return dest;
    }

    public static long to2x3_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 2;
            int _loself = _l * 3;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _loself * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_loself + 1) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, _eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, _eself1);
        }
        return dest;
    }

    public static long to3x4_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self01);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self02);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _self10);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _self11);
        UnsafeOpsHolder.U.putFloat(dest + 24L, _self12);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, _self20);
        UnsafeOpsHolder.U.putFloat(dest + 36L, _self21);
        UnsafeOpsHolder.U.putFloat(dest + 40L, _self22);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long to4x4_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self10);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self20);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _self01);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _self11);
        UnsafeOpsHolder.U.putFloat(dest + 24L, _self21);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, _self02);
        UnsafeOpsHolder.U.putFloat(dest + 36L, _self12);
        UnsafeOpsHolder.U.putFloat(dest + 40L, _self22);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 48L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 52L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 56L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 60L, 1.0f);
        return dest;
    }

    public static long toDualQuat_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
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
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.5f * _t3 * _t18);
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.5f * _t7 * _t18);
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.5f * _t9 * _t18);
            UnsafeOpsHolder.U.putFloat(dest + 12L, 0.5f * (float) Math.sqrt(_t14));
        } else {
            if (_self00 > _t4) {
                UnsafeOpsHolder.U.putFloat(dest + 0L, 0.5f * (float) Math.sqrt(_t15));
                UnsafeOpsHolder.U.putFloat(dest + 4L, 0.5f * _t5 * _t21);
                UnsafeOpsHolder.U.putFloat(dest + 8L, 0.5f * _t6 * _t21);
                UnsafeOpsHolder.U.putFloat(dest + 12L, 0.5f * _t3 * _t21);
            } else {
                if (_self11 > _self22) {
                    UnsafeOpsHolder.U.putFloat(dest + 0L, 0.5f * _t5 * _t19);
                    UnsafeOpsHolder.U.putFloat(dest + 4L, 0.5f * (float) Math.sqrt(_t16));
                    UnsafeOpsHolder.U.putFloat(dest + 8L, 0.5f * _t8 * _t19);
                    UnsafeOpsHolder.U.putFloat(dest + 12L, 0.5f * _t7 * _t19);
                } else {
                    UnsafeOpsHolder.U.putFloat(dest + 0L, 0.5f * _t6 * _t20);
                    UnsafeOpsHolder.U.putFloat(dest + 4L, 0.5f * _t8 * _t20);
                    UnsafeOpsHolder.U.putFloat(dest + 8L, 0.5f * (float) Math.sqrt(_t17));
                    UnsafeOpsHolder.U.putFloat(dest + 12L, 0.5f * _t9 * _t20);
                }
            }
        }
        UnsafeOpsHolder.U.putFloat(dest + 16L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        return dest;
    }

    public static long toRigid_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
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
            UnsafeOpsHolder.U.putFloat(dest + 12L, 0.5f * _t32 * _t61);
            UnsafeOpsHolder.U.putFloat(dest + 16L, 0.5f * _t53 * _t61);
            UnsafeOpsHolder.U.putFloat(dest + 20L, 0.5f * _t54 * _t61);
            UnsafeOpsHolder.U.putFloat(dest + 24L, 0.5f * (float) Math.sqrt(_t60));
        } else {
            if (_t44 > _t33) {
                UnsafeOpsHolder.U.putFloat(dest + 12L, 0.5f * (float) Math.sqrt(_t64));
                UnsafeOpsHolder.U.putFloat(dest + 16L, 0.5f * _t51 * _t67);
                UnsafeOpsHolder.U.putFloat(dest + 20L, 0.5f * _t52 * _t67);
                UnsafeOpsHolder.U.putFloat(dest + 24L, 0.5f * _t32 * _t67);
            } else {
                if (_t21 > _t16) {
                    UnsafeOpsHolder.U.putFloat(dest + 12L, 0.5f * _t51 * _t65);
                    UnsafeOpsHolder.U.putFloat(dest + 16L, 0.5f * (float) Math.sqrt(_t62));
                    UnsafeOpsHolder.U.putFloat(dest + 20L, 0.5f * _t28 * _t65);
                    UnsafeOpsHolder.U.putFloat(dest + 24L, 0.5f * _t53 * _t65);
                } else {
                    UnsafeOpsHolder.U.putFloat(dest + 12L, 0.5f * _t52 * _t66);
                    UnsafeOpsHolder.U.putFloat(dest + 16L, 0.5f * _t28 * _t66);
                    UnsafeOpsHolder.U.putFloat(dest + 20L, 0.5f * (float) Math.sqrt(_t63));
                    UnsafeOpsHolder.U.putFloat(dest + 24L, 0.5f * _t54 * _t66);
                }
            }
        }
        UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        return dest;
    }

    public static long toTransform_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
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
        UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _t60 > 0.0f ? 0.5f * _t33 * _t62 : _t45 > _t34 ? 0.5f * (float) Math.sqrt(_t65) : _t22 > _t17 ? 0.5f * _t52 * _t66 : 0.5f * _t53 * _t67);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _t60 > 0.0f ? 0.5f * _t54 * _t62 : _t45 > _t34 ? 0.5f * _t52 * _t68 : _t22 > _t17 ? 0.5f * (float) Math.sqrt(_t63) : 0.5f * _t29 * _t67);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _t60 > 0.0f ? 0.5f * _t55 * _t62 : _t45 > _t34 ? 0.5f * _t53 * _t68 : _t22 > _t17 ? 0.5f * _t29 * _t66 : 0.5f * (float) Math.sqrt(_t64));
        UnsafeOpsHolder.U.putFloat(dest + 24L, _t60 > 0.0f ? 0.5f * (float) Math.sqrt(_t61) : _t45 > _t34 ? 0.5f * _t33 * _t68 : _t22 > _t17 ? 0.5f * _t54 * _t66 : 0.5f * _t55 * _t67);
        UnsafeOpsHolder.U.putFloat(dest + 28L, _t44 < 0.0f ? -_t15 : _t15);
        UnsafeOpsHolder.U.putFloat(dest + 32L, (float) Math.sqrt(_t9));
        UnsafeOpsHolder.U.putFloat(dest + 36L, (float) Math.sqrt(_t10));
        return dest;
    }

    public static long decomposeRotation_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
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
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.5f * _t60 * _t90);
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.5f * _t81 * _t90);
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.5f * _t78 * _t90);
            UnsafeOpsHolder.U.putFloat(dest + 12L, 0.5f * (float) Math.sqrt(_t86));
        } else {
            if (_t73 > _t61) {
                UnsafeOpsHolder.U.putFloat(dest + 0L, 0.5f * (float) Math.sqrt(_t87));
                UnsafeOpsHolder.U.putFloat(dest + 4L, 0.5f * _t77 * _t93);
                UnsafeOpsHolder.U.putFloat(dest + 8L, 0.5f * _t80 * _t93);
                UnsafeOpsHolder.U.putFloat(dest + 12L, 0.5f * _t60 * _t93);
            } else {
                if (_t36 > _t56) {
                    UnsafeOpsHolder.U.putFloat(dest + 0L, 0.5f * _t77 * _t91);
                    UnsafeOpsHolder.U.putFloat(dest + 4L, 0.5f * (float) Math.sqrt(_t88));
                    UnsafeOpsHolder.U.putFloat(dest + 8L, 0.5f * _t63 * _t91);
                    UnsafeOpsHolder.U.putFloat(dest + 12L, 0.5f * _t81 * _t91);
                } else {
                    UnsafeOpsHolder.U.putFloat(dest + 0L, 0.5f * _t80 * _t92);
                    UnsafeOpsHolder.U.putFloat(dest + 4L, 0.5f * _t63 * _t92);
                    UnsafeOpsHolder.U.putFloat(dest + 8L, 0.5f * (float) Math.sqrt(_t89));
                    UnsafeOpsHolder.U.putFloat(dest + 12L, 0.5f * _t78 * _t92);
                }
            }
        }
        return dest;
    }

    public static long decomposeScale_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
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
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(Math.fma(_t32, _t52, -(_t34 * _t53)), _t8, Math.fma(Math.fma(_t34, _t54, -(_t33 * _t52)), _t9, Math.fma(_t33, _t53, -(_t32 * _t54)) * _t10)) < 0.0f ? -_t4 : _t4);
        UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.sqrt(_t27));
        UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.sqrt(_t47));
        return dest;
    }

    public static long decomposeSkew_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
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
            UnsafeOpsHolder.U.putFloat(dest + 4L, -_t49);
            UnsafeOpsHolder.U.putFloat(dest + 8L, -_t28);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 4L, _t49);
            UnsafeOpsHolder.U.putFloat(dest + 8L, _t28);
        }
        UnsafeOpsHolder.U.putFloat(dest + 0L, _t37 * _t48);
        return dest;
    }

    public static long makeIdentity_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 1.0f);
        return dest;
    }

    public static long lerp_unsafe(long dest, long src, long other, float t) {
        for (int _i = 0; _i < 9; _i++) {
            float _eself = UnsafeOpsHolder.U.getFloat(src + _i * 4L);
            float _eother = UnsafeOpsHolder.U.getFloat(other + _i * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _i * 4L, Math.fma(t, _eother - _eself, _eself));
        }
        return dest;
    }

    public static long mul_unsafe(long dest, long src, long right) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 3;
            float _eright0 = UnsafeOpsHolder.U.getFloat(right + _lo * 4L);
            float _eright1 = UnsafeOpsHolder.U.getFloat(right + (_lo + 1) * 4L);
            float _eright2 = UnsafeOpsHolder.U.getFloat(right + (_lo + 2) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, Math.fma(_eright2, _self02, Math.fma(_eright0, _self00, _eright1 * _self01)));
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, Math.fma(_eright2, _self12, Math.fma(_eright0, _self10, _eright1 * _self11)));
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, Math.fma(_eright2, _self22, Math.fma(_eright0, _self20, _eright1 * _self21)));
        }
        return dest;
    }

    public static long mulMat2x2_unsafe(long dest, long src, long right) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _right00 = UnsafeOpsHolder.U.getFloat(right + 0L);
        float _right10 = UnsafeOpsHolder.U.getFloat(right + 4L);
        float _right01 = UnsafeOpsHolder.U.getFloat(right + 8L);
        float _right11 = UnsafeOpsHolder.U.getFloat(right + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_right00, _self00, _right10 * _self01));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_right00, _self10, _right10 * _self11));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_right00, _self20, _right10 * _self21));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_right01, _self00, _right11 * _self01));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_right01, _self10, _right11 * _self11));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_right01, _self20, _right11 * _self21));
        UnsafeOpsHolder.U.putFloat(dest + 24L, _self02);
        UnsafeOpsHolder.U.putFloat(dest + 28L, _self12);
        UnsafeOpsHolder.U.putFloat(dest + 32L, _self22);
        return dest;
    }

    public static long mulMat2x3_unsafe(long dest, long src, long right) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _right00 = UnsafeOpsHolder.U.getFloat(right + 0L);
        float _right10 = UnsafeOpsHolder.U.getFloat(right + 4L);
        float _right01 = UnsafeOpsHolder.U.getFloat(right + 8L);
        float _right11 = UnsafeOpsHolder.U.getFloat(right + 12L);
        float _right02 = UnsafeOpsHolder.U.getFloat(right + 16L);
        float _right12 = UnsafeOpsHolder.U.getFloat(right + 20L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_right00, _self00, _right10 * _self01));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_right00, _self10, _right10 * _self11));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_right00, _self20, _right10 * _self21));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_right01, _self00, _right11 * _self01));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_right01, _self10, _right11 * _self11));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_right01, _self20, _right11 * _self21));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_right02, _self00, Math.fma(_right12, _self01, _self02)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_right02, _self10, Math.fma(_right12, _self11, _self12)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_right02, _self20, Math.fma(_right12, _self21, _self22)));
        return dest;
    }

    public static long preMul_unsafe(long dest, long src, long other) {
        float _other00 = UnsafeOpsHolder.U.getFloat(other + 0L);
        float _other10 = UnsafeOpsHolder.U.getFloat(other + 4L);
        float _other20 = UnsafeOpsHolder.U.getFloat(other + 8L);
        float _other01 = UnsafeOpsHolder.U.getFloat(other + 12L);
        float _other11 = UnsafeOpsHolder.U.getFloat(other + 16L);
        float _other21 = UnsafeOpsHolder.U.getFloat(other + 20L);
        float _other02 = UnsafeOpsHolder.U.getFloat(other + 24L);
        float _other12 = UnsafeOpsHolder.U.getFloat(other + 28L);
        float _other22 = UnsafeOpsHolder.U.getFloat(other + 32L);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 3;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, Math.fma(_other02, _eself2, Math.fma(_other00, _eself0, _other01 * _eself1)));
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, Math.fma(_other12, _eself2, Math.fma(_other10, _eself0, _other11 * _eself1)));
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, Math.fma(_other22, _eself2, Math.fma(_other20, _eself0, _other21 * _eself1)));
        }
        return dest;
    }

    public static long preMulMat2x2_unsafe(long dest, long src, long other) {
        float _other00 = UnsafeOpsHolder.U.getFloat(other + 0L);
        float _other10 = UnsafeOpsHolder.U.getFloat(other + 4L);
        float _other01 = UnsafeOpsHolder.U.getFloat(other + 8L);
        float _other11 = UnsafeOpsHolder.U.getFloat(other + 12L);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 3;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, Math.fma(_other00, _eself0, _other01 * _eself1));
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, Math.fma(_other10, _eself0, _other11 * _eself1));
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, _eself2);
        }
        return dest;
    }

    public static long preMulMat2x3_unsafe(long dest, long src, long other) {
        float _other00 = UnsafeOpsHolder.U.getFloat(other + 0L);
        float _other10 = UnsafeOpsHolder.U.getFloat(other + 4L);
        float _other01 = UnsafeOpsHolder.U.getFloat(other + 8L);
        float _other11 = UnsafeOpsHolder.U.getFloat(other + 12L);
        float _other02 = UnsafeOpsHolder.U.getFloat(other + 16L);
        float _other12 = UnsafeOpsHolder.U.getFloat(other + 20L);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 3;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, Math.fma(_other02, _eself2, Math.fma(_other00, _eself0, _other01 * _eself1)));
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, Math.fma(_other12, _eself2, Math.fma(_other10, _eself0, _other11 * _eself1)));
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, _eself2);
        }
        return dest;
    }

    public static long makeOuterProduct_unsafe(long dest, float colX, float colY, float colZ, float rowX, float rowY, float rowZ) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, colX * rowX);
        UnsafeOpsHolder.U.putFloat(dest + 4L, colY * rowX);
        UnsafeOpsHolder.U.putFloat(dest + 8L, colZ * rowX);
        UnsafeOpsHolder.U.putFloat(dest + 12L, colX * rowY);
        UnsafeOpsHolder.U.putFloat(dest + 16L, colY * rowY);
        UnsafeOpsHolder.U.putFloat(dest + 20L, colZ * rowY);
        UnsafeOpsHolder.U.putFloat(dest + 24L, colX * rowZ);
        UnsafeOpsHolder.U.putFloat(dest + 28L, colY * rowZ);
        UnsafeOpsHolder.U.putFloat(dest + 32L, colZ * rowZ);
        return dest;
    }

    public static long makeOuterProduct_unsafe(long dest, long col, long row) {
        float _colx = UnsafeOpsHolder.U.getFloat(col + 0L);
        float _coly = UnsafeOpsHolder.U.getFloat(col + 4L);
        float _colz = UnsafeOpsHolder.U.getFloat(col + 8L);
        float _rowx = UnsafeOpsHolder.U.getFloat(row + 0L);
        float _rowy = UnsafeOpsHolder.U.getFloat(row + 4L);
        float _rowz = UnsafeOpsHolder.U.getFloat(row + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _colx * _rowx);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _coly * _rowx);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _colz * _rowx);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _colx * _rowy);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _coly * _rowy);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _colz * _rowy);
        UnsafeOpsHolder.U.putFloat(dest + 24L, _colx * _rowz);
        UnsafeOpsHolder.U.putFloat(dest + 28L, _coly * _rowz);
        UnsafeOpsHolder.U.putFloat(dest + 32L, _colz * _rowz);
        return dest;
    }

    public static long lookAlong_unsafe(long dest, long src, float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
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
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_self02, _t26, Math.fma(_self00, _t27, _self01 * _t28)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self12, _t26, Math.fma(_self10, _t27, _self11 * _t28)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self22, _t26, Math.fma(_self20, _t27, _self21 * _t28)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_self02, _t35, Math.fma(_self00, _t36, _self01 * _t37)));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self12, _t35, Math.fma(_self10, _t36, _self11 * _t37)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self22, _t35, Math.fma(_self20, _t36, _self21 * _t37)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self02, _t9, Math.fma(_self00, _t8, _self01 * _t7)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_self12, _t9, Math.fma(_self10, _t8, _self11 * _t7)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self22, _t9, Math.fma(_self20, _t8, _self21 * _t7)));
        return dest;
    }

    public static long lookAlong_unsafe(long dest, long src, long dir, long up) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _dirx = UnsafeOpsHolder.U.getFloat(dir + 0L);
        float _diry = UnsafeOpsHolder.U.getFloat(dir + 4L);
        float _dirz = UnsafeOpsHolder.U.getFloat(dir + 8L);
        float _upx = UnsafeOpsHolder.U.getFloat(up + 0L);
        float _upy = UnsafeOpsHolder.U.getFloat(up + 4L);
        float _upz = UnsafeOpsHolder.U.getFloat(up + 8L);
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
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_self02, _t26, Math.fma(_self00, _t27, _self01 * _t28)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self12, _t26, Math.fma(_self10, _t27, _self11 * _t28)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self22, _t26, Math.fma(_self20, _t27, _self21 * _t28)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_self02, _t35, Math.fma(_self00, _t36, _self01 * _t37)));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self12, _t35, Math.fma(_self10, _t36, _self11 * _t37)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self22, _t35, Math.fma(_self20, _t36, _self21 * _t37)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self02, _t9, Math.fma(_self00, _t8, _self01 * _t7)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_self12, _t9, Math.fma(_self10, _t8, _self11 * _t7)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self22, _t9, Math.fma(_self20, _t8, _self21 * _t7)));
        return dest;
    }

    public static long makeFromDualQuat_unsafe(long dest, float dqRX, float dqRY, float dqRZ, float dqRW, float dqDX, float dqDY, float dqDZ, float dqDW) {
        float _t0 = dqRY * dqRY;
        float _t2 = dqRZ * dqRW;
        float _t3 = dqRY * dqRW;
        float _t4 = dqRX * dqRX;
        float _t5 = dqRY * dqRZ;
        float _t6 = Math.fma(-2.0f, dqRZ * dqRZ, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(-2.0f, _t0, _t6));
        UnsafeOpsHolder.U.putFloat(dest + 4L, 2.0f * Math.fma(dqRX, dqRY, _t2));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(-2.0f, _t3, 2.0f * dqRX * dqRZ));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(-2.0f, _t2, 2.0f * dqRX * dqRY));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(-2.0f, _t4, _t6));
        UnsafeOpsHolder.U.putFloat(dest + 20L, 2.0f * Math.fma(dqRX, dqRW, _t5));
        UnsafeOpsHolder.U.putFloat(dest + 24L, 2.0f * Math.fma(dqRX, dqRZ, _t3));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(-2.0f, dqRX * dqRW, 2.0f * _t5));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(-2.0f, _t4, Math.fma(-2.0f, _t0, 1.0f)));
        return dest;
    }

    public static long makeRotation_unsafe(long dest, float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _t0);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _t1);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, -_t1);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _t0);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 1.0f);
        return dest;
    }

    public static long makeRotationAxis_unsafe(long dest, float angle, float axisX, float axisY, float axisZ) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = 1.0f - _t0;
        float _t3 = axisX * axisY;
        float _t4 = axisX * axisZ;
        float _t5 = axisY * axisZ;
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_t2, axisX * axisX, _t0));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(axisZ, _t1, _t2 * _t3));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_t2, _t4, -(axisY * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_t2, _t3, -(axisZ * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_t2, axisY * axisY, _t0));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(axisX, _t1, _t2 * _t5));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(axisY, _t1, _t2 * _t4));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_t2, _t5, -(axisX * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_t2, axisZ * axisZ, _t0));
        return dest;
    }

    public static long makeRotationAxis_unsafe(long dest, long axis, float angle) {
        float _axisx = UnsafeOpsHolder.U.getFloat(axis + 0L);
        float _axisy = UnsafeOpsHolder.U.getFloat(axis + 4L);
        float _axisz = UnsafeOpsHolder.U.getFloat(axis + 8L);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = 1.0f - _t0;
        float _t3 = _axisx * _axisy;
        float _t4 = _axisx * _axisz;
        float _t5 = _axisy * _axisz;
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_t2, _axisx * _axisx, _t0));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_axisz, _t1, _t2 * _t3));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_t2, _t4, -(_axisy * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_t2, _t3, -(_axisz * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_t2, _axisy * _axisy, _t0));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_axisx, _t1, _t2 * _t5));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_axisy, _t1, _t2 * _t4));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_t2, _t5, -(_axisx * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_t2, _axisz * _axisz, _t0));
        return dest;
    }

    public static long makeRotationLookAlong_unsafe(long dest, float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
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
        UnsafeOpsHolder.U.putFloat(dest + 0L, _t26);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _t28);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _t27);
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_t7, _t27, -(_t9 * _t28)));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_t9, _t26, -(_t8 * _t27)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_t8, _t28, -(_t7 * _t26)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, _t8);
        UnsafeOpsHolder.U.putFloat(dest + 28L, _t7);
        UnsafeOpsHolder.U.putFloat(dest + 32L, _t9);
        return dest;
    }

    public static long makeRotationLookAlong_unsafe(long dest, long dir, long up) {
        float _dirx = UnsafeOpsHolder.U.getFloat(dir + 0L);
        float _diry = UnsafeOpsHolder.U.getFloat(dir + 4L);
        float _dirz = UnsafeOpsHolder.U.getFloat(dir + 8L);
        float _upx = UnsafeOpsHolder.U.getFloat(up + 0L);
        float _upy = UnsafeOpsHolder.U.getFloat(up + 4L);
        float _upz = UnsafeOpsHolder.U.getFloat(up + 8L);
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
        UnsafeOpsHolder.U.putFloat(dest + 0L, _t26);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _t28);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _t27);
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_t7, _t27, -(_t9 * _t28)));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_t9, _t26, -(_t8 * _t27)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_t8, _t28, -(_t7 * _t26)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, _t8);
        UnsafeOpsHolder.U.putFloat(dest + 28L, _t7);
        UnsafeOpsHolder.U.putFloat(dest + 32L, _t9);
        return dest;
    }

    public static long makeRotationQuat_unsafe(long dest, float qX, float qY, float qZ, float qW) {
        float _t0 = qZ * qZ;
        float _t1 = qZ * qW;
        float _t2 = qY * qW;
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(-2.0f, Math.fma(qY, qY, _t0), 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 4L, 2.0f * Math.fma(qX, qY, _t1));
        UnsafeOpsHolder.U.putFloat(dest + 8L, 2.0f * Math.fma(qX, qZ, -_t2));
        UnsafeOpsHolder.U.putFloat(dest + 12L, 2.0f * Math.fma(qX, qY, -_t1));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(-2.0f, Math.fma(qX, qX, _t0), 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 20L, 2.0f * Math.fma(qX, qW, qY * qZ));
        UnsafeOpsHolder.U.putFloat(dest + 24L, 2.0f * Math.fma(qX, qZ, _t2));
        UnsafeOpsHolder.U.putFloat(dest + 28L, 2.0f * Math.fma(qY, qZ, -(qX * qW)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(-2.0f, Math.fma(qX, qX, qY * qY), 1.0f));
        return dest;
    }

    public static long makeRotationQuat_unsafe(long dest, long q) {
        float _qx = UnsafeOpsHolder.U.getFloat(q + 0L);
        float _qy = UnsafeOpsHolder.U.getFloat(q + 4L);
        float _qz = UnsafeOpsHolder.U.getFloat(q + 8L);
        float _qw = UnsafeOpsHolder.U.getFloat(q + 12L);
        float _t0 = _qz * _qz;
        float _t1 = _qz * _qw;
        float _t2 = _qy * _qw;
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(-2.0f, Math.fma(_qy, _qy, _t0), 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 4L, 2.0f * Math.fma(_qx, _qy, _t1));
        UnsafeOpsHolder.U.putFloat(dest + 8L, 2.0f * Math.fma(_qx, _qz, -_t2));
        UnsafeOpsHolder.U.putFloat(dest + 12L, 2.0f * Math.fma(_qx, _qy, -_t1));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(-2.0f, Math.fma(_qx, _qx, _t0), 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 20L, 2.0f * Math.fma(_qx, _qw, _qy * _qz));
        UnsafeOpsHolder.U.putFloat(dest + 24L, 2.0f * Math.fma(_qx, _qz, _t2));
        UnsafeOpsHolder.U.putFloat(dest + 28L, 2.0f * Math.fma(_qy, _qz, -(_qx * _qw)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(-2.0f, Math.fma(_qx, _qx, _qy * _qy), 1.0f));
        return dest;
    }

    public static long makeRotationX_unsafe(long dest, float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        UnsafeOpsHolder.U.putFloat(dest + 0L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _t0);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _t1);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, -_t1);
        UnsafeOpsHolder.U.putFloat(dest + 32L, _t0);
        return dest;
    }

    public static long makeRotationXYZ_unsafe(long dest, float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleZ);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.sin(angleX);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t4 * _t3;
        float _t7 = _t3 * _t5;
        UnsafeOpsHolder.U.putFloat(dest + 0L, _t0 * _t1);
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_t6, _t1, _t2 * _t5));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_t4, _t2, -(_t7 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, -(_t2 * _t0));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_t5, _t1, -(_t6 * _t2)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_t7, _t2, _t4 * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 24L, _t3);
        UnsafeOpsHolder.U.putFloat(dest + 28L, -(_t4 * _t0));
        UnsafeOpsHolder.U.putFloat(dest + 32L, _t5 * _t0);
        return dest;
    }

    public static long makeRotationXZY_unsafe(long dest, float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleZ);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.cos(angleX);
        float _t5 = (float) Math.sin(angleX);
        float _t6 = _t2 * _t4;
        float _t7 = _t5 * _t2;
        UnsafeOpsHolder.U.putFloat(dest + 0L, _t0 * _t1);
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_t6, _t0, _t5 * _t3));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_t7, _t0, -(_t3 * _t4)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, -_t2);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _t4 * _t1);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _t5 * _t1);
        UnsafeOpsHolder.U.putFloat(dest + 24L, _t3 * _t1);
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_t6, _t3, -(_t5 * _t0)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_t7, _t3, _t4 * _t0));
        return dest;
    }

    public static long makeRotationY_unsafe(long dest, float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _t0);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, -_t1);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, _t1);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, _t0);
        return dest;
    }

    public static long makeRotationYXZ_unsafe(long dest, float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.sin(angleX);
        float _t1 = (float) Math.sin(angleY);
        float _t2 = (float) Math.sin(angleZ);
        float _t3 = (float) Math.cos(angleY);
        float _t4 = (float) Math.cos(angleZ);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t0 * _t1;
        float _t7 = _t0 * _t3;
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_t6, _t2, _t3 * _t4));
        UnsafeOpsHolder.U.putFloat(dest + 4L, _t2 * _t5);
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_t7, _t2, -(_t1 * _t4)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_t6, _t4, -(_t2 * _t3)));
        UnsafeOpsHolder.U.putFloat(dest + 16L, _t5 * _t4);
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_t7, _t4, _t1 * _t2));
        UnsafeOpsHolder.U.putFloat(dest + 24L, _t1 * _t5);
        UnsafeOpsHolder.U.putFloat(dest + 28L, -_t0);
        UnsafeOpsHolder.U.putFloat(dest + 32L, _t5 * _t3);
        return dest;
    }

    public static long makeRotationYZX_unsafe(long dest, float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleX);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.sin(angleZ);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t4 * _t0;
        float _t7 = _t3 * _t4;
        UnsafeOpsHolder.U.putFloat(dest + 0L, _t0 * _t1);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _t4);
        UnsafeOpsHolder.U.putFloat(dest + 8L, -(_t3 * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_t2, _t3, -(_t6 * _t5)));
        UnsafeOpsHolder.U.putFloat(dest + 16L, _t5 * _t1);
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_t7, _t5, _t2 * _t0));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_t6, _t2, _t3 * _t5));
        UnsafeOpsHolder.U.putFloat(dest + 28L, -(_t2 * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_t5, _t0, -(_t7 * _t2)));
        return dest;
    }

    public static long makeRotationZXY_unsafe(long dest, float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleX);
        float _t3 = (float) Math.sin(angleZ);
        float _t4 = (float) Math.sin(angleY);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t2 * _t3;
        float _t7 = _t2 * _t1;
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_t0, _t1, -(_t6 * _t4)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_t7, _t4, _t3 * _t0));
        UnsafeOpsHolder.U.putFloat(dest + 8L, -(_t4 * _t5));
        UnsafeOpsHolder.U.putFloat(dest + 12L, -(_t3 * _t5));
        UnsafeOpsHolder.U.putFloat(dest + 16L, _t5 * _t1);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _t2);
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_t6, _t0, _t4 * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_t4, _t3, -(_t7 * _t0)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, _t5 * _t0);
        return dest;
    }

    public static long makeRotationZYX_unsafe(long dest, float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleY);
        float _t3 = (float) Math.sin(angleX);
        float _t4 = (float) Math.sin(angleZ);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t2 * _t1;
        float _t7 = _t2 * _t4;
        UnsafeOpsHolder.U.putFloat(dest + 0L, _t0 * _t1);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _t4 * _t0);
        UnsafeOpsHolder.U.putFloat(dest + 8L, -_t2);
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_t6, _t3, -(_t4 * _t5)));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_t7, _t3, _t5 * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 20L, _t3 * _t0);
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_t6, _t5, _t3 * _t4));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_t7, _t5, -(_t3 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, _t5 * _t0);
        return dest;
    }

    public static long makeScaling_unsafe(long dest, float vX, float vY) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, vX);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, vY);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 1.0f);
        return dest;
    }

    public static long makeScaling_unsafe(long dest, long v) {
        float _vx = UnsafeOpsHolder.U.getFloat(v + 0L);
        float _vy = UnsafeOpsHolder.U.getFloat(v + 4L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _vx);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _vy);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 1.0f);
        return dest;
    }

    public static long makeScaling_unsafe(long dest, float s) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, s);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, s);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 1.0f);
        return dest;
    }

    public static long makeTranslation_unsafe(long dest, float vX, float vY) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, vX);
        UnsafeOpsHolder.U.putFloat(dest + 28L, vY);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 1.0f);
        return dest;
    }

    public static long makeTranslation_unsafe(long dest, long v) {
        float _vx = UnsafeOpsHolder.U.getFloat(v + 0L);
        float _vy = UnsafeOpsHolder.U.getFloat(v + 4L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, _vx);
        UnsafeOpsHolder.U.putFloat(dest + 28L, _vy);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 1.0f);
        return dest;
    }

    public static long makeView_unsafe(long dest, float left, float right, float bottom, float top) {
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        UnsafeOpsHolder.U.putFloat(dest + 0L, 2.0f * _t0_inv);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 2.0f * _t1_inv);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, -((left + right) * _t0_inv));
        UnsafeOpsHolder.U.putFloat(dest + 28L, -((bottom + top) * _t1_inv));
        UnsafeOpsHolder.U.putFloat(dest + 32L, 1.0f);
        return dest;
    }

    public static long preRotate_unsafe(long dest, long src, float angle) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_self00, _t0, -(_self10 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self00, _t1, _self10 * _t0));
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self20);
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_self01, _t0, -(_self11 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self01, _t1, _self11 * _t0));
        UnsafeOpsHolder.U.putFloat(dest + 20L, _self21);
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self02, _t0, -(_self12 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_self02, _t1, _self12 * _t0));
        UnsafeOpsHolder.U.putFloat(dest + 32L, _self22);
        return dest;
    }

    public static long preRotateAround_unsafe(long dest, long src, float angle, float pivotX, float pivotY) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _t0 = (float) Math.sin(angle);
        float _t1 = (float) Math.cos(angle);
        float _t3 = (float) Math.sin(0.5f * angle);
        float _t8 = 2.0f * _t3 * _t3;
        float _t9 = Math.fma(pivotX, _t8, pivotY * _t0);
        float _t10 = Math.fma(pivotY, _t8, -(pivotX * _t0));
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_self20, _t9, Math.fma(_self00, _t1, -(_self10 * _t0))));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self20, _t10, Math.fma(_self00, _t0, _self10 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self20);
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_self21, _t9, Math.fma(_self01, _t1, -(_self11 * _t0))));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self21, _t10, Math.fma(_self01, _t0, _self11 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, _self21);
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self22, _t9, Math.fma(_self02, _t1, -(_self12 * _t0))));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_self22, _t10, Math.fma(_self02, _t0, _self12 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, _self22);
        return dest;
    }

    public static long preRotateAround_unsafe(long dest, long src, long pivot, float angle) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _pivotx = UnsafeOpsHolder.U.getFloat(pivot + 0L);
        float _pivoty = UnsafeOpsHolder.U.getFloat(pivot + 4L);
        float _t0 = (float) Math.sin(angle);
        float _t1 = (float) Math.cos(angle);
        float _t3 = (float) Math.sin(0.5f * angle);
        float _t8 = 2.0f * _t3 * _t3;
        float _t9 = Math.fma(_pivotx, _t8, _pivoty * _t0);
        float _t10 = Math.fma(_pivoty, _t8, -(_pivotx * _t0));
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_self20, _t9, Math.fma(_self00, _t1, -(_self10 * _t0))));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self20, _t10, Math.fma(_self00, _t0, _self10 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self20);
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_self21, _t9, Math.fma(_self01, _t1, -(_self11 * _t0))));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self21, _t10, Math.fma(_self01, _t0, _self11 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, _self21);
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self22, _t9, Math.fma(_self02, _t1, -(_self12 * _t0))));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_self22, _t10, Math.fma(_self02, _t0, _self12 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, _self22);
        return dest;
    }

    public static long preRotateAxis_unsafe(long dest, long src, float angle, float axisX, float axisY, float axisZ) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
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
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_self20, _t21, Math.fma(_self00, _t18, _self10 * _t24)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self20, _t25, Math.fma(_self00, _t22, _self10 * _t19)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self20, _t20, Math.fma(_self00, _t26, _self10 * _t23)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_self21, _t21, Math.fma(_self01, _t18, _self11 * _t24)));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self21, _t25, Math.fma(_self01, _t22, _self11 * _t19)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self21, _t20, Math.fma(_self01, _t26, _self11 * _t23)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self22, _t21, Math.fma(_self02, _t18, _self12 * _t24)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_self22, _t25, Math.fma(_self02, _t22, _self12 * _t19)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self22, _t20, Math.fma(_self02, _t26, _self12 * _t23)));
        return dest;
    }

    public static long preRotateAxis_unsafe(long dest, long src, long axis, float angle) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _axisx = UnsafeOpsHolder.U.getFloat(axis + 0L);
        float _axisy = UnsafeOpsHolder.U.getFloat(axis + 4L);
        float _axisz = UnsafeOpsHolder.U.getFloat(axis + 8L);
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
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_self20, _t21, Math.fma(_self00, _t18, _self10 * _t24)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self20, _t25, Math.fma(_self00, _t22, _self10 * _t19)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self20, _t20, Math.fma(_self00, _t26, _self10 * _t23)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_self21, _t21, Math.fma(_self01, _t18, _self11 * _t24)));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self21, _t25, Math.fma(_self01, _t22, _self11 * _t19)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self21, _t20, Math.fma(_self01, _t26, _self11 * _t23)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self22, _t21, Math.fma(_self02, _t18, _self12 * _t24)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_self22, _t25, Math.fma(_self02, _t22, _self12 * _t19)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self22, _t20, Math.fma(_self02, _t26, _self12 * _t23)));
        return dest;
    }

    public static long preRotateX_unsafe(long dest, long src, float angle) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self10, _t0, -(_self20 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self10, _t1, _self20 * _t0));
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self01);
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self11, _t0, -(_self21 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self11, _t1, _self21 * _t0));
        UnsafeOpsHolder.U.putFloat(dest + 24L, _self02);
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_self12, _t0, -(_self22 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self12, _t1, _self22 * _t0));
        return dest;
    }

    public static long preRotateY_unsafe(long dest, long src, float angle) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_self00, _t0, _self20 * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self10);
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self20, _t0, -(_self00 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_self01, _t0, _self21 * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 16L, _self11);
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self21, _t0, -(_self01 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self02, _t0, _self22 * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 28L, _self12);
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self22, _t0, -(_self02 * _t1)));
        return dest;
    }

    public static long preScale_unsafe(long dest, long src, float vX, float vY) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 3;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, _eself0 * vX);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, _eself1 * vY);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, _eself2);
        }
        return dest;
    }

    public static long preScale_unsafe(long dest, long src, long v) {
        float _vx = UnsafeOpsHolder.U.getFloat(v + 0L);
        float _vy = UnsafeOpsHolder.U.getFloat(v + 4L);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 3;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, _eself0 * _vx);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, _eself1 * _vy);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, _eself2);
        }
        return dest;
    }

    public static long preScale_unsafe(long dest, long src, float s) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 3;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, s * _eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, s * _eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, _eself2);
        }
        return dest;
    }

    public static long preScaleAround_unsafe(long dest, long src, float s, float pivotX, float pivotY) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _t0 = Math.fma(-s, pivotX, pivotX);
        float _t1 = Math.fma(-s, pivotY, pivotY);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(s, _self00, _self20 * _t0));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(s, _self10, _self20 * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self20);
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(s, _self01, _self21 * _t0));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(s, _self11, _self21 * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 20L, _self21);
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(s, _self02, _self22 * _t0));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(s, _self12, _self22 * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 32L, _self22);
        return dest;
    }

    public static long preScaleAround_unsafe(long dest, long src, long pivot, float s) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _pivotx = UnsafeOpsHolder.U.getFloat(pivot + 0L);
        float _pivoty = UnsafeOpsHolder.U.getFloat(pivot + 4L);
        float _t0 = Math.fma(-s, _pivotx, _pivotx);
        float _t1 = Math.fma(-s, _pivoty, _pivoty);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(s, _self00, _self20 * _t0));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(s, _self10, _self20 * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self20);
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(s, _self01, _self21 * _t0));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(s, _self11, _self21 * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 20L, _self21);
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(s, _self02, _self22 * _t0));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(s, _self12, _self22 * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 32L, _self22);
        return dest;
    }

    public static long preScaleAround_unsafe(long dest, long src, float sX, float sY, float pivotX, float pivotY) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _t2 = Math.fma(-pivotX, sX, pivotX);
        float _t3 = Math.fma(-pivotY, sY, pivotY);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(sX, _self00, _self20 * _t2));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(sY, _self10, _self20 * _t3));
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self20);
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(sX, _self01, _self21 * _t2));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(sY, _self11, _self21 * _t3));
        UnsafeOpsHolder.U.putFloat(dest + 20L, _self21);
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(sX, _self02, _self22 * _t2));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(sY, _self12, _self22 * _t3));
        UnsafeOpsHolder.U.putFloat(dest + 32L, _self22);
        return dest;
    }

    public static long preScaleAround_unsafe(long dest, long src, long s, long pivot) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _sx = UnsafeOpsHolder.U.getFloat(s + 0L);
        float _sy = UnsafeOpsHolder.U.getFloat(s + 4L);
        float _pivotx = UnsafeOpsHolder.U.getFloat(pivot + 0L);
        float _pivoty = UnsafeOpsHolder.U.getFloat(pivot + 4L);
        float _t2 = Math.fma(-_pivotx, _sx, _pivotx);
        float _t3 = Math.fma(-_pivoty, _sy, _pivoty);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_sx, _self00, _self20 * _t2));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_sy, _self10, _self20 * _t3));
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self20);
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_sx, _self01, _self21 * _t2));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_sy, _self11, _self21 * _t3));
        UnsafeOpsHolder.U.putFloat(dest + 20L, _self21);
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_sx, _self02, _self22 * _t2));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_sy, _self12, _self22 * _t3));
        UnsafeOpsHolder.U.putFloat(dest + 32L, _self22);
        return dest;
    }

    public static long preTranslate_unsafe(long dest, long src, float vX, float vY) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 3;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, Math.fma(_eself2, vX, _eself0));
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, Math.fma(_eself2, vY, _eself1));
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, _eself2);
        }
        return dest;
    }

    public static long preTranslate_unsafe(long dest, long src, long v) {
        float _vx = UnsafeOpsHolder.U.getFloat(v + 0L);
        float _vy = UnsafeOpsHolder.U.getFloat(v + 4L);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 3;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, Math.fma(_eself2, _vx, _eself0));
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, Math.fma(_eself2, _vy, _eself1));
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, _eself2);
        }
        return dest;
    }

    public static long rotate_unsafe(long dest, long src, float angle) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_self00, _t0, _self01 * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self10, _t0, _self11 * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self20, _t0, _self21 * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_self01, _t0, -(_self00 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self11, _t0, -(_self10 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self21, _t0, -(_self20 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, _self02);
        UnsafeOpsHolder.U.putFloat(dest + 28L, _self12);
        UnsafeOpsHolder.U.putFloat(dest + 32L, _self22);
        return dest;
    }

    public static long rotateAround_unsafe(long dest, long src, float angle, float pivotX, float pivotY) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t3 = (float) Math.sin(0.5f * angle);
        float _t8 = 2.0f * _t3 * _t3;
        float _t9 = Math.fma(pivotX, _t8, pivotY * _t1);
        float _t10 = Math.fma(pivotY, _t8, -(pivotX * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_self00, _t0, _self01 * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self10, _t0, _self11 * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self20, _t0, _self21 * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_self01, _t0, -(_self00 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self11, _t0, -(_self10 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self21, _t0, -(_self20 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self00, _t9, Math.fma(_self01, _t10, _self02)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_self10, _t9, Math.fma(_self11, _t10, _self12)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self20, _t9, Math.fma(_self21, _t10, _self22)));
        return dest;
    }

    public static long rotateAround_unsafe(long dest, long src, long pivot, float angle) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _pivotx = UnsafeOpsHolder.U.getFloat(pivot + 0L);
        float _pivoty = UnsafeOpsHolder.U.getFloat(pivot + 4L);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t3 = (float) Math.sin(0.5f * angle);
        float _t8 = 2.0f * _t3 * _t3;
        float _t9 = Math.fma(_pivotx, _t8, _pivoty * _t1);
        float _t10 = Math.fma(_pivoty, _t8, -(_pivotx * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_self00, _t0, _self01 * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self10, _t0, _self11 * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self20, _t0, _self21 * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_self01, _t0, -(_self00 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self11, _t0, -(_self10 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self21, _t0, -(_self20 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self00, _t9, Math.fma(_self01, _t10, _self02)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_self10, _t9, Math.fma(_self11, _t10, _self12)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self20, _t9, Math.fma(_self21, _t10, _self22)));
        return dest;
    }

    public static long rotateAxis_unsafe(long dest, long src, float angle, float axisX, float axisY, float axisZ) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
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
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_self02, _t24, Math.fma(_self00, _t18, _self01 * _t21)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self12, _t24, Math.fma(_self10, _t18, _self11 * _t21)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self22, _t24, Math.fma(_self20, _t18, _self21 * _t21)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_self02, _t22, Math.fma(_self00, _t25, _self01 * _t19)));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self12, _t22, Math.fma(_self10, _t25, _self11 * _t19)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self22, _t22, Math.fma(_self20, _t25, _self21 * _t19)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self02, _t20, Math.fma(_self00, _t23, _self01 * _t26)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_self12, _t20, Math.fma(_self10, _t23, _self11 * _t26)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self22, _t20, Math.fma(_self20, _t23, _self21 * _t26)));
        return dest;
    }

    public static long rotateAxis_unsafe(long dest, long src, long axis, float angle) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _axisx = UnsafeOpsHolder.U.getFloat(axis + 0L);
        float _axisy = UnsafeOpsHolder.U.getFloat(axis + 4L);
        float _axisz = UnsafeOpsHolder.U.getFloat(axis + 8L);
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
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_self02, _t24, Math.fma(_self00, _t18, _self01 * _t21)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self12, _t24, Math.fma(_self10, _t18, _self11 * _t21)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self22, _t24, Math.fma(_self20, _t18, _self21 * _t21)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_self02, _t22, Math.fma(_self00, _t25, _self01 * _t19)));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self12, _t22, Math.fma(_self10, _t25, _self11 * _t19)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self22, _t22, Math.fma(_self20, _t25, _self21 * _t19)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self02, _t20, Math.fma(_self00, _t23, _self01 * _t26)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_self12, _t20, Math.fma(_self10, _t23, _self11 * _t26)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self22, _t20, Math.fma(_self20, _t23, _self21 * _t26)));
        return dest;
    }

    public static long rotateX_unsafe(long dest, long src, float angle) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self10);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self20);
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_self01, _t0, _self02 * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self11, _t0, _self12 * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self21, _t0, _self22 * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self02, _t0, -(_self01 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_self12, _t0, -(_self11 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self22, _t0, -(_self21 * _t1)));
        return dest;
    }

    public static long rotateX180_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self10);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self20);
        UnsafeOpsHolder.U.putFloat(dest + 12L, -_self01);
        UnsafeOpsHolder.U.putFloat(dest + 16L, -_self11);
        UnsafeOpsHolder.U.putFloat(dest + 20L, -_self21);
        UnsafeOpsHolder.U.putFloat(dest + 24L, -_self02);
        UnsafeOpsHolder.U.putFloat(dest + 28L, -_self12);
        UnsafeOpsHolder.U.putFloat(dest + 32L, -_self22);
        return dest;
    }

    public static long rotateX270_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self10);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self20);
        UnsafeOpsHolder.U.putFloat(dest + 12L, -_self02);
        UnsafeOpsHolder.U.putFloat(dest + 16L, -_self12);
        UnsafeOpsHolder.U.putFloat(dest + 20L, -_self22);
        UnsafeOpsHolder.U.putFloat(dest + 24L, _self01);
        UnsafeOpsHolder.U.putFloat(dest + 28L, _self11);
        UnsafeOpsHolder.U.putFloat(dest + 32L, _self21);
        return dest;
    }

    public static long rotateX90_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self10);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self20);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self02);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _self12);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _self22);
        UnsafeOpsHolder.U.putFloat(dest + 24L, -_self01);
        UnsafeOpsHolder.U.putFloat(dest + 28L, -_self11);
        UnsafeOpsHolder.U.putFloat(dest + 32L, -_self21);
        return dest;
    }

    public static long rotateXYZ_unsafe(long dest, long src, float angleX, float angleY, float angleZ) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
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
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_self02, _t20, Math.fma(_self00, _t7, _self01 * _t18)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self12, _t20, Math.fma(_self10, _t7, _self11 * _t18)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self22, _t20, Math.fma(_self20, _t7, _self21 * _t18)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_self02, _t19, Math.fma(_self01, _t21, -(_self00 * _t11))));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self12, _t19, Math.fma(_self11, _t21, -(_self10 * _t11))));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self22, _t19, Math.fma(_self21, _t21, -(_self20 * _t11))));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self02, _t12, Math.fma(_self00, _t2, -(_self01 * _t13))));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_self12, _t12, Math.fma(_self10, _t2, -(_self11 * _t13))));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self22, _t12, Math.fma(_self20, _t2, -(_self21 * _t13))));
        return dest;
    }

    public static long rotateXZY_unsafe(long dest, long src, float angleX, float angleY, float angleZ) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
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
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_self02, _t20, Math.fma(_self00, _t8, _self01 * _t18)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self12, _t20, Math.fma(_self10, _t8, _self11 * _t18)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self22, _t20, Math.fma(_self20, _t8, _self21 * _t18)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_self02, _t11, Math.fma(_self01, _t12, -(_self00 * _t1))));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self12, _t11, Math.fma(_self11, _t12, -(_self10 * _t1))));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self22, _t11, Math.fma(_self21, _t12, -(_self20 * _t1))));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self02, _t19, Math.fma(_self00, _t14, _self01 * _t21)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_self12, _t19, Math.fma(_self10, _t14, _self11 * _t21)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self22, _t19, Math.fma(_self20, _t14, _self21 * _t21)));
        return dest;
    }

    public static long rotateY_unsafe(long dest, long src, float angle) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_self00, _t0, -(_self02 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self10, _t0, -(_self12 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self20, _t0, -(_self22 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self01);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _self11);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _self21);
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self00, _t1, _self02 * _t0));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_self10, _t1, _self12 * _t0));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self20, _t1, _self22 * _t0));
        return dest;
    }

    public static long rotateY180_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, -_self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, -_self10);
        UnsafeOpsHolder.U.putFloat(dest + 8L, -_self20);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self01);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _self11);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _self21);
        UnsafeOpsHolder.U.putFloat(dest + 24L, -_self02);
        UnsafeOpsHolder.U.putFloat(dest + 28L, -_self12);
        UnsafeOpsHolder.U.putFloat(dest + 32L, -_self22);
        return dest;
    }

    public static long rotateY270_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self02);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self12);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self22);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self01);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _self11);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _self21);
        UnsafeOpsHolder.U.putFloat(dest + 24L, -_self00);
        UnsafeOpsHolder.U.putFloat(dest + 28L, -_self10);
        UnsafeOpsHolder.U.putFloat(dest + 32L, -_self20);
        return dest;
    }

    public static long rotateY90_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, -_self02);
        UnsafeOpsHolder.U.putFloat(dest + 4L, -_self12);
        UnsafeOpsHolder.U.putFloat(dest + 8L, -_self22);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self01);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _self11);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _self21);
        UnsafeOpsHolder.U.putFloat(dest + 24L, _self00);
        UnsafeOpsHolder.U.putFloat(dest + 28L, _self10);
        UnsafeOpsHolder.U.putFloat(dest + 32L, _self20);
        return dest;
    }

    public static long rotateYXZ_unsafe(long dest, long src, float angleX, float angleY, float angleZ) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
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
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_self02, _t20, Math.fma(_self00, _t18, _self01 * _t10)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self12, _t20, Math.fma(_self10, _t18, _self11 * _t10)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self22, _t20, Math.fma(_self20, _t18, _self21 * _t10)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_self02, _t19, Math.fma(_self00, _t21, _self01 * _t13)));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self12, _t19, Math.fma(_self10, _t21, _self11 * _t13)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self22, _t19, Math.fma(_self20, _t21, _self21 * _t13)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self02, _t14, Math.fma(_self00, _t15, -(_self01 * _t0))));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_self12, _t14, Math.fma(_self10, _t15, -(_self11 * _t0))));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self22, _t14, Math.fma(_self20, _t15, -(_self21 * _t0))));
        return dest;
    }

    public static long rotateYZX_unsafe(long dest, long src, float angleX, float angleY, float angleZ) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
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
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(-_self02, _t6, Math.fma(_self00, _t7, _self01 * _t3)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(-_self12, _t6, Math.fma(_self10, _t7, _self11 * _t3)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(-_self22, _t6, Math.fma(_self20, _t7, _self21 * _t3)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_self02, _t18, Math.fma(_self00, _t20, _self01 * _t11)));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self12, _t18, Math.fma(_self10, _t20, _self11 * _t11)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self22, _t18, Math.fma(_self20, _t20, _self21 * _t11)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self02, _t21, Math.fma(_self00, _t19, -(_self01 * _t13))));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_self12, _t21, Math.fma(_self10, _t19, -(_self11 * _t13))));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self22, _t21, Math.fma(_self20, _t19, -(_self21 * _t13))));
        return dest;
    }

    public static long rotateZ180_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, -_self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, -_self10);
        UnsafeOpsHolder.U.putFloat(dest + 8L, -_self20);
        UnsafeOpsHolder.U.putFloat(dest + 12L, -_self01);
        UnsafeOpsHolder.U.putFloat(dest + 16L, -_self11);
        UnsafeOpsHolder.U.putFloat(dest + 20L, -_self21);
        UnsafeOpsHolder.U.putFloat(dest + 24L, _self02);
        UnsafeOpsHolder.U.putFloat(dest + 28L, _self12);
        UnsafeOpsHolder.U.putFloat(dest + 32L, _self22);
        return dest;
    }

    public static long rotateZ270_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, -_self01);
        UnsafeOpsHolder.U.putFloat(dest + 4L, -_self11);
        UnsafeOpsHolder.U.putFloat(dest + 8L, -_self21);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self00);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _self10);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _self20);
        UnsafeOpsHolder.U.putFloat(dest + 24L, _self02);
        UnsafeOpsHolder.U.putFloat(dest + 28L, _self12);
        UnsafeOpsHolder.U.putFloat(dest + 32L, _self22);
        return dest;
    }

    public static long rotateZ90_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self01);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self11);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self21);
        UnsafeOpsHolder.U.putFloat(dest + 12L, -_self00);
        UnsafeOpsHolder.U.putFloat(dest + 16L, -_self10);
        UnsafeOpsHolder.U.putFloat(dest + 20L, -_self20);
        UnsafeOpsHolder.U.putFloat(dest + 24L, _self02);
        UnsafeOpsHolder.U.putFloat(dest + 28L, _self12);
        UnsafeOpsHolder.U.putFloat(dest + 32L, _self22);
        return dest;
    }

    public static long rotateZXY_unsafe(long dest, long src, float angleX, float angleY, float angleZ) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
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
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(-_self02, _t6, Math.fma(_self00, _t20, _self01 * _t18)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(-_self12, _t6, Math.fma(_self10, _t20, _self11 * _t18)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(-_self22, _t6, Math.fma(_self20, _t20, _self21 * _t18)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_self02, _t4, Math.fma(_self01, _t10, -(_self00 * _t11))));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self12, _t4, Math.fma(_self11, _t10, -(_self10 * _t11))));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self22, _t4, Math.fma(_self21, _t10, -(_self20 * _t11))));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self02, _t12, Math.fma(_self00, _t19, _self01 * _t21)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_self12, _t12, Math.fma(_self10, _t19, _self11 * _t21)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self22, _t12, Math.fma(_self20, _t19, _self21 * _t21)));
        return dest;
    }

    public static long rotateZYX_unsafe(long dest, long src, float angleX, float angleY, float angleZ) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
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
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(-_self02, _t0, Math.fma(_self00, _t6, _self01 * _t7)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(-_self12, _t0, Math.fma(_self10, _t6, _self11 * _t7)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(-_self22, _t0, Math.fma(_self20, _t6, _self21 * _t7)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_self02, _t8, Math.fma(_self00, _t20, _self01 * _t18)));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self12, _t8, Math.fma(_self10, _t20, _self11 * _t18)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self22, _t8, Math.fma(_self20, _t20, _self21 * _t18)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self02, _t13, Math.fma(_self00, _t19, _self01 * _t21)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_self12, _t13, Math.fma(_self10, _t19, _self11 * _t21)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self22, _t13, Math.fma(_self20, _t19, _self21 * _t21)));
        return dest;
    }

    public static long scale_unsafe(long dest, long src, float vX, float vY) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self00 * vX);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self10 * vX);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self20 * vX);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self01 * vY);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _self11 * vY);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _self21 * vY);
        UnsafeOpsHolder.U.putFloat(dest + 24L, _self02);
        UnsafeOpsHolder.U.putFloat(dest + 28L, _self12);
        UnsafeOpsHolder.U.putFloat(dest + 32L, _self22);
        return dest;
    }

    public static long scale_unsafe(long dest, long src, long v) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _vx = UnsafeOpsHolder.U.getFloat(v + 0L);
        float _vy = UnsafeOpsHolder.U.getFloat(v + 4L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self00 * _vx);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self10 * _vx);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self20 * _vx);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self01 * _vy);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _self11 * _vy);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _self21 * _vy);
        UnsafeOpsHolder.U.putFloat(dest + 24L, _self02);
        UnsafeOpsHolder.U.putFloat(dest + 28L, _self12);
        UnsafeOpsHolder.U.putFloat(dest + 32L, _self22);
        return dest;
    }

    public static long scale_unsafe(long dest, long src, float s) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, s * _self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, s * _self10);
        UnsafeOpsHolder.U.putFloat(dest + 8L, s * _self20);
        UnsafeOpsHolder.U.putFloat(dest + 12L, s * _self01);
        UnsafeOpsHolder.U.putFloat(dest + 16L, s * _self11);
        UnsafeOpsHolder.U.putFloat(dest + 20L, s * _self21);
        UnsafeOpsHolder.U.putFloat(dest + 24L, _self02);
        UnsafeOpsHolder.U.putFloat(dest + 28L, _self12);
        UnsafeOpsHolder.U.putFloat(dest + 32L, _self22);
        return dest;
    }

    public static long scaleAround_unsafe(long dest, long src, float s, float pivotX, float pivotY) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _t0 = Math.fma(-s, pivotX, pivotX);
        float _t1 = Math.fma(-s, pivotY, pivotY);
        UnsafeOpsHolder.U.putFloat(dest + 0L, s * _self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, s * _self10);
        UnsafeOpsHolder.U.putFloat(dest + 8L, s * _self20);
        UnsafeOpsHolder.U.putFloat(dest + 12L, s * _self01);
        UnsafeOpsHolder.U.putFloat(dest + 16L, s * _self11);
        UnsafeOpsHolder.U.putFloat(dest + 20L, s * _self21);
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self00, _t0, Math.fma(_self01, _t1, _self02)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_self10, _t0, Math.fma(_self11, _t1, _self12)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self20, _t0, Math.fma(_self21, _t1, _self22)));
        return dest;
    }

    public static long scaleAround_unsafe(long dest, long src, long pivot, float s) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _pivotx = UnsafeOpsHolder.U.getFloat(pivot + 0L);
        float _pivoty = UnsafeOpsHolder.U.getFloat(pivot + 4L);
        float _t0 = Math.fma(-s, _pivotx, _pivotx);
        float _t1 = Math.fma(-s, _pivoty, _pivoty);
        UnsafeOpsHolder.U.putFloat(dest + 0L, s * _self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, s * _self10);
        UnsafeOpsHolder.U.putFloat(dest + 8L, s * _self20);
        UnsafeOpsHolder.U.putFloat(dest + 12L, s * _self01);
        UnsafeOpsHolder.U.putFloat(dest + 16L, s * _self11);
        UnsafeOpsHolder.U.putFloat(dest + 20L, s * _self21);
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self00, _t0, Math.fma(_self01, _t1, _self02)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_self10, _t0, Math.fma(_self11, _t1, _self12)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self20, _t0, Math.fma(_self21, _t1, _self22)));
        return dest;
    }

    public static long scaleAround_unsafe(long dest, long src, float sX, float sY, float pivotX, float pivotY) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _t2 = Math.fma(-pivotX, sX, pivotX);
        float _t3 = Math.fma(-pivotY, sY, pivotY);
        UnsafeOpsHolder.U.putFloat(dest + 0L, sX * _self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, sX * _self10);
        UnsafeOpsHolder.U.putFloat(dest + 8L, sX * _self20);
        UnsafeOpsHolder.U.putFloat(dest + 12L, sY * _self01);
        UnsafeOpsHolder.U.putFloat(dest + 16L, sY * _self11);
        UnsafeOpsHolder.U.putFloat(dest + 20L, sY * _self21);
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self00, _t2, Math.fma(_self01, _t3, _self02)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_self10, _t2, Math.fma(_self11, _t3, _self12)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self20, _t2, Math.fma(_self21, _t3, _self22)));
        return dest;
    }

    public static long scaleAround_unsafe(long dest, long src, long s, long pivot) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _sx = UnsafeOpsHolder.U.getFloat(s + 0L);
        float _sy = UnsafeOpsHolder.U.getFloat(s + 4L);
        float _pivotx = UnsafeOpsHolder.U.getFloat(pivot + 0L);
        float _pivoty = UnsafeOpsHolder.U.getFloat(pivot + 4L);
        float _t2 = Math.fma(-_pivotx, _sx, _pivotx);
        float _t3 = Math.fma(-_pivoty, _sy, _pivoty);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _sx * _self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _sx * _self10);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _sx * _self20);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _sy * _self01);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _sy * _self11);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _sy * _self21);
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self00, _t2, Math.fma(_self01, _t3, _self02)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_self10, _t2, Math.fma(_self11, _t3, _self12)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self20, _t2, Math.fma(_self21, _t3, _self22)));
        return dest;
    }

    public static long translate_unsafe(long dest, long src, float vX, float vY) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self10);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self20);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self01);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _self11);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _self21);
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self00, vX, Math.fma(_self01, vY, _self02)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_self10, vX, Math.fma(_self11, vY, _self12)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self20, vX, Math.fma(_self21, vY, _self22)));
        return dest;
    }

    public static long translate_unsafe(long dest, long src, long v) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _vx = UnsafeOpsHolder.U.getFloat(v + 0L);
        float _vy = UnsafeOpsHolder.U.getFloat(v + 4L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self10);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self20);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self01);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _self11);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _self21);
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self00, _vx, Math.fma(_self01, _vy, _self02)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_self10, _vx, Math.fma(_self11, _vy, _self12)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self20, _vx, Math.fma(_self21, _vy, _self22)));
        return dest;
    }

    public static long view_unsafe(long dest, long src, float left, float right, float bottom, float top) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        float _t2 = left + right;
        float _t3 = bottom + top;
        UnsafeOpsHolder.U.putFloat(dest + 0L, 2.0f * _self00 * _t0_inv);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 2.0f * _self10 * _t0_inv);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 2.0f * _self20 * _t0_inv);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 2.0f * _self01 * _t1_inv);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 2.0f * _self11 * _t1_inv);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 2.0f * _self21 * _t1_inv);
        UnsafeOpsHolder.U.putFloat(dest + 24L, _self02 + (-(_self00 * _t2 * _t0_inv) - _self01 * _t3 * _t1_inv));
        UnsafeOpsHolder.U.putFloat(dest + 28L, _self12 + (-(_self10 * _t2 * _t0_inv) - _self11 * _t3 * _t1_inv));
        UnsafeOpsHolder.U.putFloat(dest + 32L, _self22 + (-(_self20 * _t2 * _t0_inv) - _self21 * _t3 * _t1_inv));
        return dest;
    }

    public static long mulVec3_unsafe(long dest, long src, float vX, float vY, float vZ) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_self02, vZ, Math.fma(_self00, vX, _self01 * vY)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self12, vZ, Math.fma(_self10, vX, _self11 * vY)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self22, vZ, Math.fma(_self20, vX, _self21 * vY)));
        return dest;
    }

    public static long mulVec3_unsafe(long dest, long src, long v) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _vx = UnsafeOpsHolder.U.getFloat(v + 0L);
        float _vy = UnsafeOpsHolder.U.getFloat(v + 4L);
        float _vz = UnsafeOpsHolder.U.getFloat(v + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_self02, _vz, Math.fma(_self00, _vx, _self01 * _vy)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self12, _vz, Math.fma(_self10, _vx, _self11 * _vy)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self22, _vz, Math.fma(_self20, _vx, _self21 * _vy)));
        return dest;
    }

}
