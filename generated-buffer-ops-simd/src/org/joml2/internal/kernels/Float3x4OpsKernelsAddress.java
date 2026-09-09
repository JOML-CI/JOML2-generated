package org.joml2.internal.kernels;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.ops.*;
import org.joml2.internal.unsafe.*;
import org.joml2.internal.simd.*;

/**
 * Scalar/Unsafe kernel leaves of {@link Float3x4Ops} whose leading storage
 * parameter is a raw {@code long} native address (the shared Unsafe kernels). Split into a sibling compilation unit purely
 * to keep generated sources IDE-sized; package-private, called only from
 * {@code Float3x4Ops} and its sibling kernel units. Not public API.
 */
public final class Float3x4OpsKernelsAddress {
    private Float3x4OpsKernelsAddress() {}

    public static long getColumn_unsafe(long dest, long src, int col) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        float _idxSw0;
        float _idxSw1;
        float _idxSw2;
        switch (col) {
            case 0: _idxSw0 = _self00; _idxSw1 = _self10; _idxSw2 = _self20; break;
            case 1: _idxSw0 = _self01; _idxSw1 = _self11; _idxSw2 = _self21; break;
            case 2: _idxSw0 = _self02; _idxSw1 = _self12; _idxSw2 = _self22; break;
            case 3: _idxSw0 = _self03; _idxSw1 = _self13; _idxSw2 = _self23; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + col);
        }
        UnsafeOpsHolder.U.putFloat(dest + 0L, _idxSw0);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _idxSw1);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _idxSw2);
        return dest;
    }

    public static long getEulerAnglesXYZ_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _t1 = Math.fma(_self12, _self12, _self22 * _self22);
        float _t3 = Math.fma(_self02, _self02, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.atan2(_self21, _self11));
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.atan2(-_self12, _self22));
            UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.atan2(-_self01, _self00));
        }
        UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _self02))));
        return dest;
    }

    public static long getEulerAnglesXZY_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _t1 = Math.fma(_self11, _self11, _self21 * _self21);
        float _t3 = Math.fma(_self01, _self01, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.atan2(-_self12, _self22));
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.atan2(_self21, _self11));
            UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.atan2(_self02, _self00));
        }
        UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, -_self01))));
        return dest;
    }

    public static long getEulerAnglesYXZ_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _t1 = Math.fma(_self02, _self02, _self22 * _self22);
        float _t3 = Math.fma(_self12, _self12, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.atan2(-_self20, _self00));
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.atan2(_self02, _self22));
            UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.atan2(_self10, _self11));
        }
        UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, -_self12))));
        return dest;
    }

    public static long getEulerAnglesYZX_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _t1 = Math.fma(_self11, _self11, _self12 * _self12);
        float _t3 = Math.fma(_self10, _self10, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.atan2(_self02, _self22));
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.atan2(-_self12, _self11));
            UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.atan2(-_self20, _self00));
        }
        UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _self10))));
        return dest;
    }

    public static long getEulerAnglesZXY_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _t1 = Math.fma(_self01, _self01, _self11 * _self11);
        float _t3 = Math.fma(_self21, _self21, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.atan2(_self10, _self00));
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.atan2(-_self20, _self22));
            UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.atan2(-_self01, _self11));
        }
        UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _self21))));
        return dest;
    }

    public static long getEulerAnglesZYX_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _t1 = Math.fma(_self21, _self21, _self22 * _self22);
        float _t3 = Math.fma(_self20, _self20, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.atan2(-_self01, _self11));
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.atan2(_self21, _self22));
            UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.atan2(_self10, _self00));
        }
        UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, -_self20))));
        return dest;
    }

    public static long getNormalizedRotation_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
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
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        float _idxSw0;
        float _idxSw1;
        float _idxSw2;
        float _idxSw3;
        switch (row) {
            case 0: _idxSw0 = _self00; _idxSw1 = _self01; _idxSw2 = _self02; _idxSw3 = _self03; break;
            case 1: _idxSw0 = _self10; _idxSw1 = _self11; _idxSw2 = _self12; _idxSw3 = _self13; break;
            case 2: _idxSw0 = _self20; _idxSw1 = _self21; _idxSw2 = _self22; _idxSw3 = _self23; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + row);
        }
        UnsafeOpsHolder.U.putFloat(dest + 0L, _idxSw0);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _idxSw1);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _idxSw2);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _idxSw3);
        return dest;
    }

    public static long getScale_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.sqrt(Math.fma(_self20, _self20, Math.fma(_self00, _self00, _self10 * _self10))));
        UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.sqrt(Math.fma(_self21, _self21, Math.fma(_self01, _self01, _self11 * _self11))));
        UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.sqrt(Math.fma(_self22, _self22, Math.fma(_self02, _self02, _self12 * _self12))));
        return dest;
    }

    public static long getTranslation_unsafe(long dest, long src) {
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self03);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self13);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self23);
        return dest;
    }

    public static long getUnnormalizedRotation_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
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

    public static long invNegativeX_unsafe(long dest, long src) {
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _t6 = Math.fma(_self10, _self21, -(_self11 * _self20));
        float _t7 = Math.fma(_self11, _self22, -(_self12 * _self21));
        float _t8 = Math.fma(_self12, _self20, -(_self10 * _self22));
        float _t11 = Math.fma(_t6, _t6, Math.fma(_t7, _t7, _t8 * _t8));
        float _t12 = (1.0f / (float) Math.sqrt(_t11));
        if (_t11 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, -(_t7 * _t12));
            UnsafeOpsHolder.U.putFloat(dest + 4L, -(_t8 * _t12));
            UnsafeOpsHolder.U.putFloat(dest + 8L, -(_t6 * _t12));
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, -0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, -0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, -0.0f);
        }
        return dest;
    }

    public static long invNegativeY_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _t6 = Math.fma(_self01, _self20, -(_self00 * _self21));
        float _t7 = Math.fma(_self00, _self22, -(_self02 * _self20));
        float _t8 = Math.fma(_self02, _self21, -(_self01 * _self22));
        float _t11 = Math.fma(_t6, _t6, Math.fma(_t7, _t7, _t8 * _t8));
        float _t12 = (1.0f / (float) Math.sqrt(_t11));
        if (_t11 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, -(_t8 * _t12));
            UnsafeOpsHolder.U.putFloat(dest + 4L, -(_t7 * _t12));
            UnsafeOpsHolder.U.putFloat(dest + 8L, -(_t6 * _t12));
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, -0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, -0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, -0.0f);
        }
        return dest;
    }

    public static long invNegativeZ_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _t6 = Math.fma(_self00, _self11, -(_self01 * _self10));
        float _t7 = Math.fma(_self01, _self12, -(_self02 * _self11));
        float _t8 = Math.fma(_self02, _self10, -(_self00 * _self12));
        float _t11 = Math.fma(_t6, _t6, Math.fma(_t7, _t7, _t8 * _t8));
        float _t12 = (1.0f / (float) Math.sqrt(_t11));
        if (_t11 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, -(_t7 * _t12));
            UnsafeOpsHolder.U.putFloat(dest + 4L, -(_t8 * _t12));
            UnsafeOpsHolder.U.putFloat(dest + 8L, -(_t6 * _t12));
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, -0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, -0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, -0.0f);
        }
        return dest;
    }

    public static long invNormalizedNegativeX_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, -_self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, -_self01);
        UnsafeOpsHolder.U.putFloat(dest + 8L, -_self02);
        return dest;
    }

    public static long invNormalizedNegativeY_unsafe(long dest, long src) {
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, -_self10);
        UnsafeOpsHolder.U.putFloat(dest + 4L, -_self11);
        UnsafeOpsHolder.U.putFloat(dest + 8L, -_self12);
        return dest;
    }

    public static long invNormalizedNegativeZ_unsafe(long dest, long src) {
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, -_self20);
        UnsafeOpsHolder.U.putFloat(dest + 4L, -_self21);
        UnsafeOpsHolder.U.putFloat(dest + 8L, -_self22);
        return dest;
    }

    public static long invNormalizedPositiveX_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self01);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self02);
        return dest;
    }

    public static long invNormalizedPositiveY_unsafe(long dest, long src) {
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self10);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self11);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self12);
        return dest;
    }

    public static long invNormalizedPositiveZ_unsafe(long dest, long src) {
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self20);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self21);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self22);
        return dest;
    }

    public static long invPositiveX_unsafe(long dest, long src) {
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _t6 = Math.fma(_self10, _self21, -(_self11 * _self20));
        float _t7 = Math.fma(_self11, _self22, -(_self12 * _self21));
        float _t8 = Math.fma(_self12, _self20, -(_self10 * _self22));
        float _t11 = Math.fma(_t6, _t6, Math.fma(_t7, _t7, _t8 * _t8));
        float _t12 = (1.0f / (float) Math.sqrt(_t11));
        if (_t11 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, _t7 * _t12);
            UnsafeOpsHolder.U.putFloat(dest + 4L, _t8 * _t12);
            UnsafeOpsHolder.U.putFloat(dest + 8L, _t6 * _t12);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        }
        return dest;
    }

    public static long invPositiveY_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _t6 = Math.fma(_self01, _self20, -(_self00 * _self21));
        float _t7 = Math.fma(_self00, _self22, -(_self02 * _self20));
        float _t8 = Math.fma(_self02, _self21, -(_self01 * _self22));
        float _t11 = Math.fma(_t6, _t6, Math.fma(_t7, _t7, _t8 * _t8));
        float _t12 = (1.0f / (float) Math.sqrt(_t11));
        if (_t11 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, _t8 * _t12);
            UnsafeOpsHolder.U.putFloat(dest + 4L, _t7 * _t12);
            UnsafeOpsHolder.U.putFloat(dest + 8L, _t6 * _t12);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        }
        return dest;
    }

    public static long invPositiveZ_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _t6 = Math.fma(_self00, _self11, -(_self01 * _self10));
        float _t7 = Math.fma(_self01, _self12, -(_self02 * _self11));
        float _t8 = Math.fma(_self02, _self10, -(_self00 * _self12));
        float _t11 = Math.fma(_t6, _t6, Math.fma(_t7, _t7, _t8 * _t8));
        float _t12 = (1.0f / (float) Math.sqrt(_t11));
        if (_t11 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, _t7 * _t12);
            UnsafeOpsHolder.U.putFloat(dest + 4L, _t8 * _t12);
            UnsafeOpsHolder.U.putFloat(dest + 8L, _t6 * _t12);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        }
        return dest;
    }

    public static long negativeX_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _t2 = Math.fma(_self20, _self20, Math.fma(_self00, _self00, _self10 * _self10));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        if (_t2 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, -(_self00 * _t3));
            UnsafeOpsHolder.U.putFloat(dest + 4L, -(_self10 * _t3));
            UnsafeOpsHolder.U.putFloat(dest + 8L, -(_self20 * _t3));
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, -0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, -0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, -0.0f);
        }
        return dest;
    }

    public static long negativeY_unsafe(long dest, long src) {
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _t2 = Math.fma(_self21, _self21, Math.fma(_self01, _self01, _self11 * _self11));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        if (_t2 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, -(_self01 * _t3));
            UnsafeOpsHolder.U.putFloat(dest + 4L, -(_self11 * _t3));
            UnsafeOpsHolder.U.putFloat(dest + 8L, -(_self21 * _t3));
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, -0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, -0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, -0.0f);
        }
        return dest;
    }

    public static long negativeZ_unsafe(long dest, long src) {
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _t2 = Math.fma(_self22, _self22, Math.fma(_self02, _self02, _self12 * _self12));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        if (_t2 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, -(_self02 * _t3));
            UnsafeOpsHolder.U.putFloat(dest + 4L, -(_self12 * _t3));
            UnsafeOpsHolder.U.putFloat(dest + 8L, -(_self22 * _t3));
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, -0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, -0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, -0.0f);
        }
        return dest;
    }

    public static long normalizedNegativeX_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, -_self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, -_self10);
        UnsafeOpsHolder.U.putFloat(dest + 8L, -_self20);
        return dest;
    }

    public static long normalizedNegativeY_unsafe(long dest, long src) {
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, -_self01);
        UnsafeOpsHolder.U.putFloat(dest + 4L, -_self11);
        UnsafeOpsHolder.U.putFloat(dest + 8L, -_self21);
        return dest;
    }

    public static long normalizedNegativeZ_unsafe(long dest, long src) {
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, -_self02);
        UnsafeOpsHolder.U.putFloat(dest + 4L, -_self12);
        UnsafeOpsHolder.U.putFloat(dest + 8L, -_self22);
        return dest;
    }

    public static long normalizedPositiveX_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self10);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self20);
        return dest;
    }

    public static long normalizedPositiveY_unsafe(long dest, long src) {
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self01);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self11);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self21);
        return dest;
    }

    public static long normalizedPositiveZ_unsafe(long dest, long src) {
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self02);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self12);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self22);
        return dest;
    }

    public static long origin_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, -Math.fma(_self20, _self23, Math.fma(_self00, _self03, _self10 * _self13)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, -Math.fma(_self21, _self23, Math.fma(_self01, _self03, _self11 * _self13)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, -Math.fma(_self22, _self23, Math.fma(_self02, _self03, _self12 * _self13)));
        return dest;
    }

    public static long positiveX_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _t2 = Math.fma(_self20, _self20, Math.fma(_self00, _self00, _self10 * _self10));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        if (_t2 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, _self00 * _t3);
            UnsafeOpsHolder.U.putFloat(dest + 4L, _self10 * _t3);
            UnsafeOpsHolder.U.putFloat(dest + 8L, _self20 * _t3);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        }
        return dest;
    }

    public static long positiveY_unsafe(long dest, long src) {
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _t2 = Math.fma(_self21, _self21, Math.fma(_self01, _self01, _self11 * _self11));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        if (_t2 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, _self01 * _t3);
            UnsafeOpsHolder.U.putFloat(dest + 4L, _self11 * _t3);
            UnsafeOpsHolder.U.putFloat(dest + 8L, _self21 * _t3);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        }
        return dest;
    }

    public static long positiveZ_unsafe(long dest, long src) {
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _t2 = Math.fma(_self22, _self22, Math.fma(_self02, _self02, _self12 * _self12));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        if (_t2 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, _self02 * _t3);
            UnsafeOpsHolder.U.putFloat(dest + 4L, _self12 * _t3);
            UnsafeOpsHolder.U.putFloat(dest + 8L, _self22 * _t3);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        }
        return dest;
    }

    public static float determinant_unsafe(long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        return Math.fma(_self02, Math.fma(_self10, _self21, -(_self11 * _self20)), Math.fma(_self00, Math.fma(_self11, _self22, -(_self12 * _self21)), -(_self01 * Math.fma(_self10, _self22, -(_self12 * _self20)))));
    }

    public static float frobeniusNorm_unsafe(long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        return (float) Math.sqrt(Math.fma(_self00, _self00, Math.fma(_self01, _self01, _self02 * _self02)) + Math.fma(_self03, _self03, Math.fma(_self10, _self10, _self11 * _self11)) + (Math.fma(_self12, _self12, Math.fma(_self13, _self13, _self20 * _self20)) + Math.fma(_self21, _self21, Math.fma(_self22, _self22, _self23 * _self23))));
    }

    public static long invert_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        float _t20 = Math.fma(_self11, _self22, -(_self12 * _self21));
        float _t21 = Math.fma(_self10, _self21, -(_self11 * _self20));
        float _t23 = Math.fma(_self02, _self21, -(_self01 * _self22));
        float _t24 = Math.fma(_self01, _self12, -(_self02 * _self11));
        float _t25 = Math.fma(_self12, _self20, -(_self10 * _self22));
        float _t26 = Math.fma(_self00, _self22, -(_self02 * _self20));
        float _t27 = Math.fma(_self02, _self10, -(_self00 * _self12));
        float _t28 = Math.fma(_self01, _self20, -(_self00 * _self21));
        float _t29 = Math.fma(_self00, _self11, -(_self01 * _self10));
        float _t33 = Math.fma(_self02, _t21, Math.fma(_self00, _t20, -(_self01 * Math.fma(_self10, _self22, -(_self12 * _self20)))));
        float _t33_inv = 1.0f / _t33;
        UnsafeOpsHolder.U.putFloat(dest + 0L, _t20 * _t33_inv);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _t23 * _t33_inv);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _t24 * _t33_inv);
        UnsafeOpsHolder.U.putFloat(dest + 12L, -(Math.fma(_self23, _t24, Math.fma(_self03, _t20, _self13 * _t23)) * _t33_inv));
        UnsafeOpsHolder.U.putFloat(dest + 16L, _t25 * _t33_inv);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _t26 * _t33_inv);
        UnsafeOpsHolder.U.putFloat(dest + 24L, _t27 * _t33_inv);
        UnsafeOpsHolder.U.putFloat(dest + 28L, -(Math.fma(_self23, _t27, Math.fma(_self03, _t25, _self13 * _t26)) * _t33_inv));
        UnsafeOpsHolder.U.putFloat(dest + 32L, _t21 * _t33_inv);
        UnsafeOpsHolder.U.putFloat(dest + 36L, _t28 * _t33_inv);
        UnsafeOpsHolder.U.putFloat(dest + 40L, _t29 * _t33_inv);
        UnsafeOpsHolder.U.putFloat(dest + 44L, -(Math.fma(_self23, _t29, Math.fma(_self03, _t21, _self13 * _t28)) * _t33_inv));
        return dest;
    }

    public static long invertProduct_unsafe(long dest, long src, long other) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        float _other00 = UnsafeOpsHolder.U.getFloat(other + 0L);
        float _other01 = UnsafeOpsHolder.U.getFloat(other + 4L);
        float _other02 = UnsafeOpsHolder.U.getFloat(other + 8L);
        float _other03 = UnsafeOpsHolder.U.getFloat(other + 12L);
        float _other10 = UnsafeOpsHolder.U.getFloat(other + 16L);
        float _other11 = UnsafeOpsHolder.U.getFloat(other + 20L);
        float _other12 = UnsafeOpsHolder.U.getFloat(other + 24L);
        float _other13 = UnsafeOpsHolder.U.getFloat(other + 28L);
        float _other20 = UnsafeOpsHolder.U.getFloat(other + 32L);
        float _other21 = UnsafeOpsHolder.U.getFloat(other + 36L);
        float _other22 = UnsafeOpsHolder.U.getFloat(other + 40L);
        float _other23 = UnsafeOpsHolder.U.getFloat(other + 44L);
        float _t24 = Math.fma(_other21, _self12, Math.fma(_other01, _self10, _other11 * _self11));
        float _t25 = Math.fma(_other22, _self22, Math.fma(_other02, _self20, _other12 * _self21));
        float _t26 = Math.fma(_other21, _self22, Math.fma(_other01, _self20, _other11 * _self21));
        float _t27 = Math.fma(_other22, _self12, Math.fma(_other02, _self10, _other12 * _self11));
        float _t28 = Math.fma(_other22, _self02, Math.fma(_other02, _self00, _other12 * _self01));
        float _t29 = Math.fma(_other20, _self12, Math.fma(_other00, _self10, _other10 * _self11));
        float _t30 = Math.fma(_other20, _self22, Math.fma(_other00, _self20, _other10 * _self21));
        float _t31 = Math.fma(_other20, _self02, Math.fma(_other00, _self00, _other10 * _self01));
        float _t32 = Math.fma(_other21, _self02, Math.fma(_other01, _self00, _other11 * _self01));
        float _t33 = Math.fma(_other03, _self20, Math.fma(_other13, _self21, Math.fma(_other23, _self22, _self23)));
        float _t34 = Math.fma(_other03, _self00, Math.fma(_other13, _self01, Math.fma(_other23, _self02, _self03)));
        float _t35 = Math.fma(_other03, _self10, Math.fma(_other13, _self11, Math.fma(_other23, _self12, _self13)));
        float _t56 = Math.fma(_t24, _t25, -(_t26 * _t27));
        float _t57 = Math.fma(_t29, _t26, -(_t30 * _t24));
        float _t59 = Math.fma(_t26, _t28, -(_t32 * _t25));
        float _t60 = Math.fma(_t32, _t27, -(_t24 * _t28));
        float _t61 = Math.fma(_t30, _t27, -(_t29 * _t25));
        float _t62 = Math.fma(_t31, _t25, -(_t30 * _t28));
        float _t63 = Math.fma(_t29, _t28, -(_t31 * _t27));
        float _t64 = Math.fma(_t30, _t32, -(_t31 * _t26));
        float _t65 = Math.fma(_t31, _t24, -(_t29 * _t32));
        float _t69 = Math.fma(_t28, _t57, Math.fma(_t31, _t56, -(_t32 * Math.fma(_t29, _t25, -(_t30 * _t27)))));
        float _t69_inv = 1.0f / _t69;
        UnsafeOpsHolder.U.putFloat(dest + 0L, _t56 * _t69_inv);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _t59 * _t69_inv);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _t60 * _t69_inv);
        UnsafeOpsHolder.U.putFloat(dest + 12L, -(Math.fma(_t33, _t60, Math.fma(_t34, _t56, _t35 * _t59)) * _t69_inv));
        UnsafeOpsHolder.U.putFloat(dest + 16L, _t61 * _t69_inv);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _t62 * _t69_inv);
        UnsafeOpsHolder.U.putFloat(dest + 24L, _t63 * _t69_inv);
        UnsafeOpsHolder.U.putFloat(dest + 28L, -(Math.fma(_t33, _t63, Math.fma(_t34, _t61, _t35 * _t62)) * _t69_inv));
        UnsafeOpsHolder.U.putFloat(dest + 32L, _t57 * _t69_inv);
        UnsafeOpsHolder.U.putFloat(dest + 36L, _t64 * _t69_inv);
        UnsafeOpsHolder.U.putFloat(dest + 40L, _t65 * _t69_inv);
        UnsafeOpsHolder.U.putFloat(dest + 44L, -(Math.fma(_t33, _t65, Math.fma(_t34, _t57, _t35 * _t64)) * _t69_inv));
        return dest;
    }

    public static long transpose_unsafe(long dest, long src) {
        for (int _i = 0; _i < 12; _i++) {
            float _eself = UnsafeOpsHolder.U.getFloat(src + _i * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _i * 4L, _eself);
        }
        return dest;
    }

    public static long add_unsafe(long dest, long src, long other) {
        for (int _i = 0; _i < 12; _i++) {
            float _eself = UnsafeOpsHolder.U.getFloat(src + _i * 4L);
            float _eother = UnsafeOpsHolder.U.getFloat(other + _i * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _i * 4L, _eother + _eself);
        }
        return dest;
    }

    public static long negate_unsafe(long dest, long src) {
        for (int _i = 0; _i < 12; _i++) {
            float _eself = UnsafeOpsHolder.U.getFloat(src + _i * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _i * 4L, -_eself);
        }
        return dest;
    }

    public static long sub_unsafe(long dest, long src, long other) {
        for (int _i = 0; _i < 12; _i++) {
            float _eself = UnsafeOpsHolder.U.getFloat(src + _i * 4L);
            float _eother = UnsafeOpsHolder.U.getFloat(other + _i * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _i * 4L, _eself - _eother);
        }
        return dest;
    }

    public static long set_unsafe(long dest, long v) {
        for (int _i = 0; _i < 12; _i++) {
            float _ev = UnsafeOpsHolder.U.getFloat(v + _i * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _i * 4L, _ev);
        }
        return dest;
    }

    public static long setMat3x3_unsafe(long dest, long m) {
        float _m00 = UnsafeOpsHolder.U.getFloat(m + 0L);
        float _m10 = UnsafeOpsHolder.U.getFloat(m + 4L);
        float _m20 = UnsafeOpsHolder.U.getFloat(m + 8L);
        float _m01 = UnsafeOpsHolder.U.getFloat(m + 12L);
        float _m11 = UnsafeOpsHolder.U.getFloat(m + 16L);
        float _m21 = UnsafeOpsHolder.U.getFloat(m + 20L);
        float _m02 = UnsafeOpsHolder.U.getFloat(m + 24L);
        float _m12 = UnsafeOpsHolder.U.getFloat(m + 28L);
        float _m22 = UnsafeOpsHolder.U.getFloat(m + 32L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _m00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _m01);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _m02);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _m10);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _m11);
        UnsafeOpsHolder.U.putFloat(dest + 24L, _m12);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, _m20);
        UnsafeOpsHolder.U.putFloat(dest + 36L, _m21);
        UnsafeOpsHolder.U.putFloat(dest + 40L, _m22);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long setMat4x4_unsafe(long dest, long m) {
        float _m00 = UnsafeOpsHolder.U.getFloat(m + 0L);
        float _m10 = UnsafeOpsHolder.U.getFloat(m + 4L);
        float _m20 = UnsafeOpsHolder.U.getFloat(m + 8L);
        float _m01 = UnsafeOpsHolder.U.getFloat(m + 16L);
        float _m11 = UnsafeOpsHolder.U.getFloat(m + 20L);
        float _m21 = UnsafeOpsHolder.U.getFloat(m + 24L);
        float _m02 = UnsafeOpsHolder.U.getFloat(m + 32L);
        float _m12 = UnsafeOpsHolder.U.getFloat(m + 36L);
        float _m22 = UnsafeOpsHolder.U.getFloat(m + 40L);
        float _m03 = UnsafeOpsHolder.U.getFloat(m + 48L);
        float _m13 = UnsafeOpsHolder.U.getFloat(m + 52L);
        float _m23 = UnsafeOpsHolder.U.getFloat(m + 56L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _m00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _m01);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _m02);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _m03);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _m10);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _m11);
        UnsafeOpsHolder.U.putFloat(dest + 24L, _m12);
        UnsafeOpsHolder.U.putFloat(dest + 28L, _m13);
        UnsafeOpsHolder.U.putFloat(dest + 32L, _m20);
        UnsafeOpsHolder.U.putFloat(dest + 36L, _m21);
        UnsafeOpsHolder.U.putFloat(dest + 40L, _m22);
        UnsafeOpsHolder.U.putFloat(dest + 44L, _m23);
        return dest;
    }

    public static long withTranslation_unsafe(long dest, long src, float tX, float tY, float tZ) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self01);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self02);
        UnsafeOpsHolder.U.putFloat(dest + 12L, tX);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _self10);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _self11);
        UnsafeOpsHolder.U.putFloat(dest + 24L, _self12);
        UnsafeOpsHolder.U.putFloat(dest + 28L, tY);
        UnsafeOpsHolder.U.putFloat(dest + 32L, _self20);
        UnsafeOpsHolder.U.putFloat(dest + 36L, _self21);
        UnsafeOpsHolder.U.putFloat(dest + 40L, _self22);
        UnsafeOpsHolder.U.putFloat(dest + 44L, tZ);
        return dest;
    }

    public static long withTranslation_unsafe(long dest, long src, long t) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _tx = UnsafeOpsHolder.U.getFloat(t + 0L);
        float _ty = UnsafeOpsHolder.U.getFloat(t + 4L);
        float _tz = UnsafeOpsHolder.U.getFloat(t + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self01);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self02);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _tx);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _self10);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _self11);
        UnsafeOpsHolder.U.putFloat(dest + 24L, _self12);
        UnsafeOpsHolder.U.putFloat(dest + 28L, _ty);
        UnsafeOpsHolder.U.putFloat(dest + 32L, _self20);
        UnsafeOpsHolder.U.putFloat(dest + 36L, _self21);
        UnsafeOpsHolder.U.putFloat(dest + 40L, _self22);
        UnsafeOpsHolder.U.putFloat(dest + 44L, _tz);
        return dest;
    }

    public static long makeFromRigid_unsafe(long dest, float rTX, float rTY, float rTZ, float rRX, float rRY, float rRZ, float rRW) {
        float _t0 = rRZ * rRZ;
        float _t1 = rRZ * rRW;
        float _t2 = rRY * rRW;
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(-2.0f, Math.fma(rRY, rRY, _t0), 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 4L, 2.0f * Math.fma(rRX, rRY, -_t1));
        UnsafeOpsHolder.U.putFloat(dest + 8L, 2.0f * Math.fma(rRX, rRZ, _t2));
        UnsafeOpsHolder.U.putFloat(dest + 12L, rTX);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 2.0f * Math.fma(rRX, rRY, _t1));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(-2.0f, Math.fma(rRX, rRX, _t0), 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 24L, 2.0f * Math.fma(rRY, rRZ, -(rRX * rRW)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, rTY);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 2.0f * Math.fma(rRX, rRZ, -_t2));
        UnsafeOpsHolder.U.putFloat(dest + 36L, 2.0f * Math.fma(rRX, rRW, rRY * rRZ));
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(-2.0f, Math.fma(rRX, rRX, rRY * rRY), 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 44L, rTZ);
        return dest;
    }

    public static long makeFromTransform_unsafe(long dest, float tTX, float tTY, float tTZ, float tRX, float tRY, float tRZ, float tRW, float tSX, float tSY, float tSZ) {
        float _t0 = tRZ * tRZ;
        float _t1 = tRZ * tRW;
        float _t2 = tRY * tRW;
        UnsafeOpsHolder.U.putFloat(dest + 0L, tSX * Math.fma(-2.0f, Math.fma(tRY, tRY, _t0), 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 4L, tSY * 2.0f * Math.fma(tRX, tRY, -_t1));
        UnsafeOpsHolder.U.putFloat(dest + 8L, tSZ * 2.0f * Math.fma(tRX, tRZ, _t2));
        UnsafeOpsHolder.U.putFloat(dest + 12L, tTX);
        UnsafeOpsHolder.U.putFloat(dest + 16L, tSX * 2.0f * Math.fma(tRX, tRY, _t1));
        UnsafeOpsHolder.U.putFloat(dest + 20L, tSY * Math.fma(-2.0f, Math.fma(tRX, tRX, _t0), 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 24L, tSZ * 2.0f * Math.fma(tRY, tRZ, -(tRX * tRW)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, tTY);
        UnsafeOpsHolder.U.putFloat(dest + 32L, tSX * 2.0f * Math.fma(tRX, tRZ, -_t2));
        UnsafeOpsHolder.U.putFloat(dest + 36L, tSY * 2.0f * Math.fma(tRX, tRW, tRY * tRZ));
        UnsafeOpsHolder.U.putFloat(dest + 40L, tSZ * Math.fma(-2.0f, Math.fma(tRX, tRX, tRY * tRY), 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 44L, tTZ);
        return dest;
    }

    public static long to3x3_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self10);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self20);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self01);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _self11);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _self21);
        UnsafeOpsHolder.U.putFloat(dest + 24L, _self02);
        UnsafeOpsHolder.U.putFloat(dest + 28L, _self12);
        UnsafeOpsHolder.U.putFloat(dest + 32L, _self22);
        return dest;
    }

    public static long to4x4_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
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
        UnsafeOpsHolder.U.putFloat(dest + 48L, _self03);
        UnsafeOpsHolder.U.putFloat(dest + 52L, _self13);
        UnsafeOpsHolder.U.putFloat(dest + 56L, _self23);
        UnsafeOpsHolder.U.putFloat(dest + 60L, 1.0f);
        return dest;
    }

    public static long toDualQuat_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        float _t0 = -_self23;
        float _t2 = 1.0f - _self00;
        float _t4 = _self21 - _self12;
        float _t5 = Math.max(_self11, _self22);
        float _t6 = _self01 + _self10;
        float _t7 = _self02 + _self20;
        float _t8 = _self02 - _self20;
        float _t9 = _self12 + _self21;
        float _t10 = _self10 - _self01;
        float _t14 = _self22 + (_self00 + _self11);
        float _t15 = 1.0f + _t14;
        float _t16 = _self00 + (1.0f - _self11 - _self22);
        float _t17 = _self11 + (_t2 - _self22);
        float _t18 = _self22 + (_t2 - _self11);
        float _t19 = (1.0f / (float) Math.sqrt(_t15));
        float _t21 = (1.0f / (float) Math.sqrt(_t17));
        float _t22 = (1.0f / (float) Math.sqrt(_t18));
        float _t23 = (1.0f / (float) Math.sqrt(_t16));
        float _t63, _t64, _t65, _t66;
        if (_t14 > 0.0f) {
            _t63 = 0.5f * _t4 * _t19;
            _t64 = 0.5f * _t8 * _t19;
            _t65 = 0.5f * _t10 * _t19;
            _t66 = 0.5f * (float) Math.sqrt(_t15);
        } else {
            if (_self00 > _t5) {
                _t63 = 0.5f * (float) Math.sqrt(_t16);
                _t64 = 0.5f * _t6 * _t23;
                _t65 = 0.5f * _t7 * _t23;
                _t66 = 0.5f * _t4 * _t23;
            } else {
                if (_self11 > _self22) {
                    _t63 = 0.5f * _t6 * _t21;
                    _t64 = 0.5f * (float) Math.sqrt(_t17);
                    _t65 = 0.5f * _t9 * _t21;
                    _t66 = 0.5f * _t8 * _t21;
                } else {
                    _t63 = 0.5f * _t7 * _t22;
                    _t64 = 0.5f * _t9 * _t22;
                    _t65 = 0.5f * (float) Math.sqrt(_t18);
                    _t66 = 0.5f * _t10 * _t22;
                }
            }
        }
        UnsafeOpsHolder.U.putFloat(dest + 0L, _t63);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _t64);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _t65);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _t66);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 0.5f * Math.fma(_t0, _t64, Math.fma(_self03, _t66, _self13 * _t65)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.5f * Math.fma(_self23, _t63, Math.fma(_self13, _t66, -(_self03 * _t65))));
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.5f * Math.fma(_self23, _t66, Math.fma(_self03, _t64, -(_self13 * _t63))));
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.5f * Math.fma(_t0, _t65, Math.fma(-_self13, _t64, -(_self03 * _t63))));
        return dest;
    }

    public static long toRigid_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
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
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self03);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self13);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self23);
        return dest;
    }

    public static long toTransform_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
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
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self03);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self13);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self23);
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
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
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
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
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
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
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

    public static long decomposeTRS_unsafe(long translation, long rotation, long scale, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
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
        float _t20 = -Math.fma(_self21, _t8, Math.fma(_self01, _t9, _self11 * _t10));
        float _t21 = -Math.fma(_self22, _t8, Math.fma(_self02, _t9, _self12 * _t10));
        float _t22 = Math.fma(_t20, _t8, _self21);
        float _t23 = Math.fma(_t20, _t9, _self01);
        float _t24 = Math.fma(_t20, _t10, _self11);
        float _t30 = Math.fma(_t22, _t22, Math.fma(_t23, _t23, _t24 * _t24));
        float _t31 = (1.0f / (float) Math.sqrt(_t30));
        float _t35, _t36, _t37;
        if (_t30 > 0.0f) {
            _t35 = _t23 * _t31;
            _t36 = _t22 * _t31;
            _t37 = _t24 * _t31;
        } else {
            _t35 = 0.0f;
            _t36 = 0.0f;
            _t37 = 0.0f;
        }
        float _t41 = -Math.fma(Math.fma(_t21, _t8, _self22), _t36, Math.fma(Math.fma(_t21, _t9, _self02), _t35, Math.fma(_t21, _t10, _self12) * _t37));
        float _t45 = Math.fma(_t21, _t8, Math.fma(_t41, _t36, _self22));
        float _t46 = Math.fma(_t21, _t9, Math.fma(_t41, _t35, _self02));
        float _t47 = Math.fma(_t21, _t10, Math.fma(_t41, _t37, _self12));
        float _t50 = Math.fma(_t45, _t45, Math.fma(_t46, _t46, _t47 * _t47));
        float _t51 = (1.0f / (float) Math.sqrt(_t50));
        float _t55, _t56, _t57;
        if (_t50 > 0.0f) {
            _t55 = _t47 * _t51;
            _t56 = _t46 * _t51;
            _t57 = _t45 * _t51;
        } else {
            _t55 = 0.0f;
            _t56 = 0.0f;
            _t57 = 0.0f;
        }
        float _t61 = _t36 - _t55;
        float _t62 = Math.max(_t37, _t57);
        float _t64 = _t36 + _t55;
        float _t73 = Math.fma(Math.fma(_t35, _t55, -(_t37 * _t56)), _t8, Math.fma(Math.fma(_t37, _t57, -(_t36 * _t55)), _t9, Math.fma(_t36, _t56, -(_t35 * _t57)) * _t10));
        float _t74, _t75, _t76;
        if (_t73 < 0.0f) {
            _t74 = -_t9;
            _t75 = -_t10;
            _t76 = -_t8;
        } else {
            _t74 = _t9;
            _t75 = _t10;
            _t76 = _t8;
        }
        float _t77 = _t74 + _t37;
        float _t78 = _t75 + _t35;
        float _t79 = _t75 - _t35;
        float _t81 = _t76 + _t56;
        float _t82 = _t56 - _t76;
        float _t83 = _t77 + _t57;
        float _t87 = 1.0f + _t83;
        float _t88 = 1.0f + (_t74 - (_t37 + _t57));
        float _t89 = 1.0f + (_t37 - (_t74 + _t57));
        float _t90 = 1.0f + (_t57 - _t77);
        float _t91 = (1.0f / (float) Math.sqrt(_t87));
        float _t92 = (1.0f / (float) Math.sqrt(_t89));
        float _t93 = (1.0f / (float) Math.sqrt(_t90));
        float _t94 = (1.0f / (float) Math.sqrt(_t88));
        UnsafeOpsHolder.U.putFloat(translation + 0L, _self03);
        UnsafeOpsHolder.U.putFloat(translation + 4L, _self13);
        UnsafeOpsHolder.U.putFloat(translation + 8L, _self23);
        if (_t83 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(rotation + 0L, 0.5f * _t61 * _t91);
            UnsafeOpsHolder.U.putFloat(rotation + 4L, 0.5f * _t82 * _t91);
            UnsafeOpsHolder.U.putFloat(rotation + 8L, 0.5f * _t79 * _t91);
            UnsafeOpsHolder.U.putFloat(rotation + 12L, 0.5f * (float) Math.sqrt(_t87));
        } else {
            if (_t74 > _t62) {
                UnsafeOpsHolder.U.putFloat(rotation + 0L, 0.5f * (float) Math.sqrt(_t88));
                UnsafeOpsHolder.U.putFloat(rotation + 4L, 0.5f * _t78 * _t94);
                UnsafeOpsHolder.U.putFloat(rotation + 8L, 0.5f * _t81 * _t94);
                UnsafeOpsHolder.U.putFloat(rotation + 12L, 0.5f * _t61 * _t94);
            } else {
                if (_t37 > _t57) {
                    UnsafeOpsHolder.U.putFloat(rotation + 0L, 0.5f * _t78 * _t92);
                    UnsafeOpsHolder.U.putFloat(rotation + 4L, 0.5f * (float) Math.sqrt(_t89));
                    UnsafeOpsHolder.U.putFloat(rotation + 8L, 0.5f * _t64 * _t92);
                    UnsafeOpsHolder.U.putFloat(rotation + 12L, 0.5f * _t82 * _t92);
                } else {
                    UnsafeOpsHolder.U.putFloat(rotation + 0L, 0.5f * _t81 * _t93);
                    UnsafeOpsHolder.U.putFloat(rotation + 4L, 0.5f * _t64 * _t93);
                    UnsafeOpsHolder.U.putFloat(rotation + 8L, 0.5f * (float) Math.sqrt(_t90));
                    UnsafeOpsHolder.U.putFloat(rotation + 12L, 0.5f * _t79 * _t93);
                }
            }
        }
        UnsafeOpsHolder.U.putFloat(scale + 0L, _t73 < 0.0f ? -_t4 : _t4);
        UnsafeOpsHolder.U.putFloat(scale + 4L, (float) Math.sqrt(_t30));
        UnsafeOpsHolder.U.putFloat(scale + 8L, (float) Math.sqrt(_t50));
        return translation;
    }

    public static long makeIdentity_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long lerp_unsafe(long dest, long src, long other, float t) {
        for (int _i = 0; _i < 12; _i++) {
            float _eself = UnsafeOpsHolder.U.getFloat(src + _i * 4L);
            float _eother = UnsafeOpsHolder.U.getFloat(other + _i * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _i * 4L, Math.fma(t, _eother - _eself, _eself));
        }
        return dest;
    }

    public static long mul_unsafe(long dest, long src, long right) {
        float _right00 = UnsafeOpsHolder.U.getFloat(right + 0L);
        float _right01 = UnsafeOpsHolder.U.getFloat(right + 4L);
        float _right02 = UnsafeOpsHolder.U.getFloat(right + 8L);
        float _right03 = UnsafeOpsHolder.U.getFloat(right + 12L);
        float _right10 = UnsafeOpsHolder.U.getFloat(right + 16L);
        float _right11 = UnsafeOpsHolder.U.getFloat(right + 20L);
        float _right12 = UnsafeOpsHolder.U.getFloat(right + 24L);
        float _right13 = UnsafeOpsHolder.U.getFloat(right + 28L);
        float _right20 = UnsafeOpsHolder.U.getFloat(right + 32L);
        float _right21 = UnsafeOpsHolder.U.getFloat(right + 36L);
        float _right22 = UnsafeOpsHolder.U.getFloat(right + 40L);
        float _right23 = UnsafeOpsHolder.U.getFloat(right + 44L);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, Math.fma(_right20, _eself2, Math.fma(_right00, _eself0, _right10 * _eself1)));
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, Math.fma(_right21, _eself2, Math.fma(_right01, _eself0, _right11 * _eself1)));
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, Math.fma(_right22, _eself2, Math.fma(_right02, _eself0, _right12 * _eself1)));
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, Math.fma(_right03, _eself0, Math.fma(_right13, _eself1, Math.fma(_right23, _eself2, _eself3))));
        }
        return dest;
    }

    public static long mulMat2x2_unsafe(long dest, long src, long right) {
        float _right00 = UnsafeOpsHolder.U.getFloat(right + 0L);
        float _right10 = UnsafeOpsHolder.U.getFloat(right + 4L);
        float _right01 = UnsafeOpsHolder.U.getFloat(right + 8L);
        float _right11 = UnsafeOpsHolder.U.getFloat(right + 12L);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, Math.fma(_right00, _eself0, _right10 * _eself1));
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, Math.fma(_right01, _eself0, _right11 * _eself1));
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, _eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mulMat2x3_unsafe(long dest, long src, long right) {
        float _right00 = UnsafeOpsHolder.U.getFloat(right + 0L);
        float _right10 = UnsafeOpsHolder.U.getFloat(right + 4L);
        float _right01 = UnsafeOpsHolder.U.getFloat(right + 8L);
        float _right11 = UnsafeOpsHolder.U.getFloat(right + 12L);
        float _right02 = UnsafeOpsHolder.U.getFloat(right + 16L);
        float _right12 = UnsafeOpsHolder.U.getFloat(right + 20L);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, Math.fma(_right00, _eself0, _right10 * _eself1));
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, Math.fma(_right01, _eself0, _right11 * _eself1));
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, Math.fma(_right02, _eself0, Math.fma(_right12, _eself1, _eself2)));
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mulMat3x3_unsafe(long dest, long src, long right) {
        float _right00 = UnsafeOpsHolder.U.getFloat(right + 0L);
        float _right10 = UnsafeOpsHolder.U.getFloat(right + 4L);
        float _right20 = UnsafeOpsHolder.U.getFloat(right + 8L);
        float _right01 = UnsafeOpsHolder.U.getFloat(right + 12L);
        float _right11 = UnsafeOpsHolder.U.getFloat(right + 16L);
        float _right21 = UnsafeOpsHolder.U.getFloat(right + 20L);
        float _right02 = UnsafeOpsHolder.U.getFloat(right + 24L);
        float _right12 = UnsafeOpsHolder.U.getFloat(right + 28L);
        float _right22 = UnsafeOpsHolder.U.getFloat(right + 32L);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, Math.fma(_right20, _eself2, Math.fma(_right00, _eself0, _right10 * _eself1)));
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, Math.fma(_right21, _eself2, Math.fma(_right01, _eself0, _right11 * _eself1)));
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, Math.fma(_right22, _eself2, Math.fma(_right02, _eself0, _right12 * _eself1)));
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mulMat4x4_unsafe(long dest, long src, long right) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        for (int _l = 0; _l < 4; _l++) {
            int _lo = _l * 4;
            float _eright0 = UnsafeOpsHolder.U.getFloat(right + _lo * 4L);
            float _eright1 = UnsafeOpsHolder.U.getFloat(right + (_lo + 1) * 4L);
            float _eright2 = UnsafeOpsHolder.U.getFloat(right + (_lo + 2) * 4L);
            float _eright3 = UnsafeOpsHolder.U.getFloat(right + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, Math.fma(_eright3, _self03, Math.fma(_eright2, _self02, Math.fma(_eright0, _self00, _eright1 * _self01))));
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, Math.fma(_eright3, _self13, Math.fma(_eright2, _self12, Math.fma(_eright0, _self10, _eright1 * _self11))));
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, Math.fma(_eright3, _self23, Math.fma(_eright2, _self22, Math.fma(_eright0, _self20, _eright1 * _self21))));
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eright3);
        }
        return dest;
    }

    public static long preMul_unsafe(long dest, long src, long other) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eother0 = UnsafeOpsHolder.U.getFloat(other + _lo * 4L);
            float _eother1 = UnsafeOpsHolder.U.getFloat(other + (_lo + 1) * 4L);
            float _eother2 = UnsafeOpsHolder.U.getFloat(other + (_lo + 2) * 4L);
            float _eother3 = UnsafeOpsHolder.U.getFloat(other + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, Math.fma(_eother2, _self20, Math.fma(_eother0, _self00, _eother1 * _self10)));
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, Math.fma(_eother2, _self21, Math.fma(_eother0, _self01, _eother1 * _self11)));
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, Math.fma(_eother2, _self22, Math.fma(_eother0, _self02, _eother1 * _self12)));
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, Math.fma(_eother0, _self03, Math.fma(_eother1, _self13, Math.fma(_eother2, _self23, _eother3))));
        }
        return dest;
    }

    public static long preMulMat2x2_unsafe(long dest, long src, long other) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        float _other00 = UnsafeOpsHolder.U.getFloat(other + 0L);
        float _other10 = UnsafeOpsHolder.U.getFloat(other + 4L);
        float _other01 = UnsafeOpsHolder.U.getFloat(other + 8L);
        float _other11 = UnsafeOpsHolder.U.getFloat(other + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_other00, _self00, _other01 * _self10));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_other00, _self01, _other01 * _self11));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_other00, _self02, _other01 * _self12));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_other00, _self03, _other01 * _self13));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_other10, _self00, _other11 * _self10));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_other10, _self01, _other11 * _self11));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_other10, _self02, _other11 * _self12));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_other10, _self03, _other11 * _self13));
        UnsafeOpsHolder.U.putFloat(dest + 32L, _self20);
        UnsafeOpsHolder.U.putFloat(dest + 36L, _self21);
        UnsafeOpsHolder.U.putFloat(dest + 40L, _self22);
        UnsafeOpsHolder.U.putFloat(dest + 44L, _self23);
        return dest;
    }

    public static long preMulMat2x3_unsafe(long dest, long src, long other) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        float _other00 = UnsafeOpsHolder.U.getFloat(other + 0L);
        float _other10 = UnsafeOpsHolder.U.getFloat(other + 4L);
        float _other01 = UnsafeOpsHolder.U.getFloat(other + 8L);
        float _other11 = UnsafeOpsHolder.U.getFloat(other + 12L);
        float _other02 = UnsafeOpsHolder.U.getFloat(other + 16L);
        float _other12 = UnsafeOpsHolder.U.getFloat(other + 20L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_other02, _self20, Math.fma(_other00, _self00, _other01 * _self10)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_other02, _self21, Math.fma(_other00, _self01, _other01 * _self11)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_other02, _self22, Math.fma(_other00, _self02, _other01 * _self12)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_other02, _self23, Math.fma(_other00, _self03, _other01 * _self13)));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_other12, _self20, Math.fma(_other10, _self00, _other11 * _self10)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_other12, _self21, Math.fma(_other10, _self01, _other11 * _self11)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_other12, _self22, Math.fma(_other10, _self02, _other11 * _self12)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_other12, _self23, Math.fma(_other10, _self03, _other11 * _self13)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, _self20);
        UnsafeOpsHolder.U.putFloat(dest + 36L, _self21);
        UnsafeOpsHolder.U.putFloat(dest + 40L, _self22);
        UnsafeOpsHolder.U.putFloat(dest + 44L, _self23);
        return dest;
    }

    public static long preMulMat3x3_unsafe(long dest, long src, long other) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        float _other00 = UnsafeOpsHolder.U.getFloat(other + 0L);
        float _other10 = UnsafeOpsHolder.U.getFloat(other + 4L);
        float _other20 = UnsafeOpsHolder.U.getFloat(other + 8L);
        float _other01 = UnsafeOpsHolder.U.getFloat(other + 12L);
        float _other11 = UnsafeOpsHolder.U.getFloat(other + 16L);
        float _other21 = UnsafeOpsHolder.U.getFloat(other + 20L);
        float _other02 = UnsafeOpsHolder.U.getFloat(other + 24L);
        float _other12 = UnsafeOpsHolder.U.getFloat(other + 28L);
        float _other22 = UnsafeOpsHolder.U.getFloat(other + 32L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_other02, _self20, Math.fma(_other00, _self00, _other01 * _self10)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_other02, _self21, Math.fma(_other00, _self01, _other01 * _self11)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_other02, _self22, Math.fma(_other00, _self02, _other01 * _self12)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_other02, _self23, Math.fma(_other00, _self03, _other01 * _self13)));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_other12, _self20, Math.fma(_other10, _self00, _other11 * _self10)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_other12, _self21, Math.fma(_other10, _self01, _other11 * _self11)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_other12, _self22, Math.fma(_other10, _self02, _other11 * _self12)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_other12, _self23, Math.fma(_other10, _self03, _other11 * _self13)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_other22, _self20, Math.fma(_other20, _self00, _other21 * _self10)));
        UnsafeOpsHolder.U.putFloat(dest + 36L, Math.fma(_other22, _self21, Math.fma(_other20, _self01, _other21 * _self11)));
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(_other22, _self22, Math.fma(_other20, _self02, _other21 * _self12)));
        UnsafeOpsHolder.U.putFloat(dest + 44L, Math.fma(_other22, _self23, Math.fma(_other20, _self03, _other21 * _self13)));
        return dest;
    }

    public static long preMulMat4x4_unsafe(long dest, long src, long other) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        float _other00 = UnsafeOpsHolder.U.getFloat(other + 0L);
        float _other10 = UnsafeOpsHolder.U.getFloat(other + 4L);
        float _other20 = UnsafeOpsHolder.U.getFloat(other + 8L);
        float _other30 = UnsafeOpsHolder.U.getFloat(other + 12L);
        float _other01 = UnsafeOpsHolder.U.getFloat(other + 16L);
        float _other11 = UnsafeOpsHolder.U.getFloat(other + 20L);
        float _other21 = UnsafeOpsHolder.U.getFloat(other + 24L);
        float _other31 = UnsafeOpsHolder.U.getFloat(other + 28L);
        float _other02 = UnsafeOpsHolder.U.getFloat(other + 32L);
        float _other12 = UnsafeOpsHolder.U.getFloat(other + 36L);
        float _other22 = UnsafeOpsHolder.U.getFloat(other + 40L);
        float _other32 = UnsafeOpsHolder.U.getFloat(other + 44L);
        float _other03 = UnsafeOpsHolder.U.getFloat(other + 48L);
        float _other13 = UnsafeOpsHolder.U.getFloat(other + 52L);
        float _other23 = UnsafeOpsHolder.U.getFloat(other + 56L);
        float _other33 = UnsafeOpsHolder.U.getFloat(other + 60L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_other02, _self20, Math.fma(_other00, _self00, _other01 * _self10)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_other12, _self20, Math.fma(_other10, _self00, _other11 * _self10)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_other22, _self20, Math.fma(_other20, _self00, _other21 * _self10)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_other32, _self20, Math.fma(_other30, _self00, _other31 * _self10)));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_other02, _self21, Math.fma(_other00, _self01, _other01 * _self11)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_other12, _self21, Math.fma(_other10, _self01, _other11 * _self11)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_other22, _self21, Math.fma(_other20, _self01, _other21 * _self11)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_other32, _self21, Math.fma(_other30, _self01, _other31 * _self11)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_other02, _self22, Math.fma(_other00, _self02, _other01 * _self12)));
        UnsafeOpsHolder.U.putFloat(dest + 36L, Math.fma(_other12, _self22, Math.fma(_other10, _self02, _other11 * _self12)));
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(_other22, _self22, Math.fma(_other20, _self02, _other21 * _self12)));
        UnsafeOpsHolder.U.putFloat(dest + 44L, Math.fma(_other32, _self22, Math.fma(_other30, _self02, _other31 * _self12)));
        UnsafeOpsHolder.U.putFloat(dest + 48L, Math.fma(_other00, _self03, Math.fma(_other01, _self13, Math.fma(_other02, _self23, _other03))));
        UnsafeOpsHolder.U.putFloat(dest + 52L, Math.fma(_other10, _self03, Math.fma(_other11, _self13, Math.fma(_other12, _self23, _other13))));
        UnsafeOpsHolder.U.putFloat(dest + 56L, Math.fma(_other20, _self03, Math.fma(_other21, _self13, Math.fma(_other22, _self23, _other23))));
        UnsafeOpsHolder.U.putFloat(dest + 60L, Math.fma(_other30, _self03, Math.fma(_other31, _self13, Math.fma(_other32, _self23, _other33))));
        return dest;
    }

    public static long composeTRS_unsafe(long dest, float translationX, float translationY, float translationZ, float rotationX, float rotationY, float rotationZ, float rotationW, float scaleX, float scaleY, float scaleZ) {
        float _t0 = rotationZ * rotationZ;
        float _t1 = rotationZ * rotationW;
        float _t2 = rotationY * rotationW;
        UnsafeOpsHolder.U.putFloat(dest + 0L, scaleX * Math.fma(-2.0f, Math.fma(rotationY, rotationY, _t0), 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 4L, scaleY * 2.0f * Math.fma(rotationX, rotationY, -_t1));
        UnsafeOpsHolder.U.putFloat(dest + 8L, scaleZ * 2.0f * Math.fma(rotationX, rotationZ, _t2));
        UnsafeOpsHolder.U.putFloat(dest + 12L, translationX);
        UnsafeOpsHolder.U.putFloat(dest + 16L, scaleX * 2.0f * Math.fma(rotationX, rotationY, _t1));
        UnsafeOpsHolder.U.putFloat(dest + 20L, scaleY * Math.fma(-2.0f, Math.fma(rotationX, rotationX, _t0), 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 24L, scaleZ * 2.0f * Math.fma(rotationY, rotationZ, -(rotationX * rotationW)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, translationY);
        UnsafeOpsHolder.U.putFloat(dest + 32L, scaleX * 2.0f * Math.fma(rotationX, rotationZ, -_t2));
        UnsafeOpsHolder.U.putFloat(dest + 36L, scaleY * 2.0f * Math.fma(rotationX, rotationW, rotationY * rotationZ));
        UnsafeOpsHolder.U.putFloat(dest + 40L, scaleZ * Math.fma(-2.0f, Math.fma(rotationX, rotationX, rotationY * rotationY), 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 44L, translationZ);
        return dest;
    }

    public static long composeTRS_unsafe(long dest, long translation, long rotation, long scale) {
        float _translationx = UnsafeOpsHolder.U.getFloat(translation + 0L);
        float _translationy = UnsafeOpsHolder.U.getFloat(translation + 4L);
        float _translationz = UnsafeOpsHolder.U.getFloat(translation + 8L);
        float _rotationx = UnsafeOpsHolder.U.getFloat(rotation + 0L);
        float _rotationy = UnsafeOpsHolder.U.getFloat(rotation + 4L);
        float _rotationz = UnsafeOpsHolder.U.getFloat(rotation + 8L);
        float _rotationw = UnsafeOpsHolder.U.getFloat(rotation + 12L);
        float _scalex = UnsafeOpsHolder.U.getFloat(scale + 0L);
        float _scaley = UnsafeOpsHolder.U.getFloat(scale + 4L);
        float _scalez = UnsafeOpsHolder.U.getFloat(scale + 8L);
        float _t0 = _rotationz * _rotationz;
        float _t1 = _rotationz * _rotationw;
        float _t2 = _rotationy * _rotationw;
        UnsafeOpsHolder.U.putFloat(dest + 0L, _scalex * Math.fma(-2.0f, Math.fma(_rotationy, _rotationy, _t0), 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 4L, _scaley * 2.0f * Math.fma(_rotationx, _rotationy, -_t1));
        UnsafeOpsHolder.U.putFloat(dest + 8L, _scalez * 2.0f * Math.fma(_rotationx, _rotationz, _t2));
        UnsafeOpsHolder.U.putFloat(dest + 12L, _translationx);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _scalex * 2.0f * Math.fma(_rotationx, _rotationy, _t1));
        UnsafeOpsHolder.U.putFloat(dest + 20L, _scaley * Math.fma(-2.0f, Math.fma(_rotationx, _rotationx, _t0), 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 24L, _scalez * 2.0f * Math.fma(_rotationy, _rotationz, -(_rotationx * _rotationw)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, _translationy);
        UnsafeOpsHolder.U.putFloat(dest + 32L, _scalex * 2.0f * Math.fma(_rotationx, _rotationz, -_t2));
        UnsafeOpsHolder.U.putFloat(dest + 36L, _scaley * 2.0f * Math.fma(_rotationx, _rotationw, _rotationy * _rotationz));
        UnsafeOpsHolder.U.putFloat(dest + 40L, _scalez * Math.fma(-2.0f, Math.fma(_rotationx, _rotationx, _rotationy * _rotationy), 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 44L, _translationz);
        return dest;
    }

    public static long composeTRSMul_unsafe(long dest, long m, float translationX, float translationY, float translationZ, float rotationX, float rotationY, float rotationZ, float rotationW, float scaleX, float scaleY, float scaleZ) {
        float _m00 = UnsafeOpsHolder.U.getFloat(m + 0L);
        float _m01 = UnsafeOpsHolder.U.getFloat(m + 4L);
        float _m02 = UnsafeOpsHolder.U.getFloat(m + 8L);
        float _m03 = UnsafeOpsHolder.U.getFloat(m + 12L);
        float _m10 = UnsafeOpsHolder.U.getFloat(m + 16L);
        float _m11 = UnsafeOpsHolder.U.getFloat(m + 20L);
        float _m12 = UnsafeOpsHolder.U.getFloat(m + 24L);
        float _m13 = UnsafeOpsHolder.U.getFloat(m + 28L);
        float _m20 = UnsafeOpsHolder.U.getFloat(m + 32L);
        float _m21 = UnsafeOpsHolder.U.getFloat(m + 36L);
        float _m22 = UnsafeOpsHolder.U.getFloat(m + 40L);
        float _m23 = UnsafeOpsHolder.U.getFloat(m + 44L);
        float _t0 = rotationY * rotationW;
        float _t1 = rotationZ * rotationZ;
        float _t2 = rotationZ * rotationW;
        float _t27 = scaleZ * 2.0f * Math.fma(rotationX, rotationZ, _t0);
        float _t28 = scaleX * 2.0f * Math.fma(rotationX, rotationY, _t2);
        float _t29 = scaleY * 2.0f * Math.fma(rotationX, rotationW, rotationY * rotationZ);
        float _t30 = scaleY * 2.0f * Math.fma(rotationX, rotationY, -_t2);
        float _t31 = scaleZ * 2.0f * Math.fma(rotationY, rotationZ, -(rotationX * rotationW));
        float _t32 = scaleX * 2.0f * Math.fma(rotationX, rotationZ, -_t0);
        float _t33 = scaleX * Math.fma(-2.0f, Math.fma(rotationY, rotationY, _t1), 1.0f);
        float _t34 = scaleY * Math.fma(-2.0f, Math.fma(rotationX, rotationX, _t1), 1.0f);
        float _t35 = scaleZ * Math.fma(-2.0f, Math.fma(rotationX, rotationX, rotationY * rotationY), 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_m20, _t27, Math.fma(_m00, _t33, _m10 * _t30)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_m21, _t27, Math.fma(_m01, _t33, _m11 * _t30)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_m22, _t27, Math.fma(_m02, _t33, _m12 * _t30)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_m03, _t33, Math.fma(_m13, _t30, Math.fma(_m23, _t27, translationX))));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_m20, _t31, Math.fma(_m00, _t28, _m10 * _t34)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_m21, _t31, Math.fma(_m01, _t28, _m11 * _t34)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_m22, _t31, Math.fma(_m02, _t28, _m12 * _t34)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_m03, _t28, Math.fma(_m13, _t34, Math.fma(_m23, _t31, translationY))));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_m20, _t35, Math.fma(_m00, _t32, _m10 * _t29)));
        UnsafeOpsHolder.U.putFloat(dest + 36L, Math.fma(_m21, _t35, Math.fma(_m01, _t32, _m11 * _t29)));
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(_m22, _t35, Math.fma(_m02, _t32, _m12 * _t29)));
        UnsafeOpsHolder.U.putFloat(dest + 44L, Math.fma(_m03, _t32, Math.fma(_m13, _t29, Math.fma(_m23, _t35, translationZ))));
        return dest;
    }

    public static long composeTRSMul_unsafe(long dest, long translation, long rotation, long scale, long m) {
        float _translationx = UnsafeOpsHolder.U.getFloat(translation + 0L);
        float _translationy = UnsafeOpsHolder.U.getFloat(translation + 4L);
        float _translationz = UnsafeOpsHolder.U.getFloat(translation + 8L);
        float _rotationx = UnsafeOpsHolder.U.getFloat(rotation + 0L);
        float _rotationy = UnsafeOpsHolder.U.getFloat(rotation + 4L);
        float _rotationz = UnsafeOpsHolder.U.getFloat(rotation + 8L);
        float _rotationw = UnsafeOpsHolder.U.getFloat(rotation + 12L);
        float _scalex = UnsafeOpsHolder.U.getFloat(scale + 0L);
        float _scaley = UnsafeOpsHolder.U.getFloat(scale + 4L);
        float _scalez = UnsafeOpsHolder.U.getFloat(scale + 8L);
        float _m00 = UnsafeOpsHolder.U.getFloat(m + 0L);
        float _m01 = UnsafeOpsHolder.U.getFloat(m + 4L);
        float _m02 = UnsafeOpsHolder.U.getFloat(m + 8L);
        float _m03 = UnsafeOpsHolder.U.getFloat(m + 12L);
        float _m10 = UnsafeOpsHolder.U.getFloat(m + 16L);
        float _m11 = UnsafeOpsHolder.U.getFloat(m + 20L);
        float _m12 = UnsafeOpsHolder.U.getFloat(m + 24L);
        float _m13 = UnsafeOpsHolder.U.getFloat(m + 28L);
        float _m20 = UnsafeOpsHolder.U.getFloat(m + 32L);
        float _m21 = UnsafeOpsHolder.U.getFloat(m + 36L);
        float _m22 = UnsafeOpsHolder.U.getFloat(m + 40L);
        float _m23 = UnsafeOpsHolder.U.getFloat(m + 44L);
        float _t0 = _rotationy * _rotationw;
        float _t1 = _rotationz * _rotationz;
        float _t2 = _rotationz * _rotationw;
        float _t27 = _scalez * 2.0f * Math.fma(_rotationx, _rotationz, _t0);
        float _t28 = _scalex * 2.0f * Math.fma(_rotationx, _rotationy, _t2);
        float _t29 = _scaley * 2.0f * Math.fma(_rotationx, _rotationw, _rotationy * _rotationz);
        float _t30 = _scaley * 2.0f * Math.fma(_rotationx, _rotationy, -_t2);
        float _t31 = _scalez * 2.0f * Math.fma(_rotationy, _rotationz, -(_rotationx * _rotationw));
        float _t32 = _scalex * 2.0f * Math.fma(_rotationx, _rotationz, -_t0);
        float _t33 = _scalex * Math.fma(-2.0f, Math.fma(_rotationy, _rotationy, _t1), 1.0f);
        float _t34 = _scaley * Math.fma(-2.0f, Math.fma(_rotationx, _rotationx, _t1), 1.0f);
        float _t35 = _scalez * Math.fma(-2.0f, Math.fma(_rotationx, _rotationx, _rotationy * _rotationy), 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_m20, _t27, Math.fma(_m00, _t33, _m10 * _t30)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_m21, _t27, Math.fma(_m01, _t33, _m11 * _t30)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_m22, _t27, Math.fma(_m02, _t33, _m12 * _t30)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_m03, _t33, Math.fma(_m13, _t30, Math.fma(_m23, _t27, _translationx))));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_m20, _t31, Math.fma(_m00, _t28, _m10 * _t34)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_m21, _t31, Math.fma(_m01, _t28, _m11 * _t34)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_m22, _t31, Math.fma(_m02, _t28, _m12 * _t34)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_m03, _t28, Math.fma(_m13, _t34, Math.fma(_m23, _t31, _translationy))));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_m20, _t35, Math.fma(_m00, _t32, _m10 * _t29)));
        UnsafeOpsHolder.U.putFloat(dest + 36L, Math.fma(_m21, _t35, Math.fma(_m01, _t32, _m11 * _t29)));
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(_m22, _t35, Math.fma(_m02, _t32, _m12 * _t29)));
        UnsafeOpsHolder.U.putFloat(dest + 44L, Math.fma(_m03, _t32, Math.fma(_m13, _t29, Math.fma(_m23, _t35, _translationz))));
        return dest;
    }

    public static long lookAlong_unsafe(long dest, long src, float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
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
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self02, _t35, Math.fma(_self00, _t36, _self01 * _t37)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self02, _t9, Math.fma(_self00, _t8, _self01 * _t7)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self03);
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self12, _t26, Math.fma(_self10, _t27, _self11 * _t28)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self12, _t35, Math.fma(_self10, _t36, _self11 * _t37)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self12, _t9, Math.fma(_self10, _t8, _self11 * _t7)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, _self13);
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self22, _t26, Math.fma(_self20, _t27, _self21 * _t28)));
        UnsafeOpsHolder.U.putFloat(dest + 36L, Math.fma(_self22, _t35, Math.fma(_self20, _t36, _self21 * _t37)));
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(_self22, _t9, Math.fma(_self20, _t8, _self21 * _t7)));
        UnsafeOpsHolder.U.putFloat(dest + 44L, _self23);
        return dest;
    }

    public static long lookAlong_unsafe(long dest, long src, long dir, long up) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
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
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self02, _t35, Math.fma(_self00, _t36, _self01 * _t37)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self02, _t9, Math.fma(_self00, _t8, _self01 * _t7)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self03);
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self12, _t26, Math.fma(_self10, _t27, _self11 * _t28)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self12, _t35, Math.fma(_self10, _t36, _self11 * _t37)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self12, _t9, Math.fma(_self10, _t8, _self11 * _t7)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, _self13);
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self22, _t26, Math.fma(_self20, _t27, _self21 * _t28)));
        UnsafeOpsHolder.U.putFloat(dest + 36L, Math.fma(_self22, _t35, Math.fma(_self20, _t36, _self21 * _t37)));
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(_self22, _t9, Math.fma(_self20, _t8, _self21 * _t7)));
        UnsafeOpsHolder.U.putFloat(dest + 44L, _self23);
        return dest;
    }

    public static long lookAt_lh(long dest, long src, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return Float3x4OpsKernelsAddress.lookAt_lh_unsafe(dest, src, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        Float3x4OpsKernelsSegment.lookAt_lh(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 48L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 48L), 0L, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return dest;
    }

    public static long lookAt_lh_unsafe(long dest, long src, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
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
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_self02, _t10, Math.fma(_self00, _t32, _self01 * _t43)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self02, _t11, Math.fma(_self00, _t34, _self01 * _t44)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self02, _t12, Math.fma(_self00, _t33, _self01 * _t45)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(-_self00, _t47, Math.fma(-_self01, _t49, Math.fma(-_self02, _t24, _self03))));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self12, _t10, Math.fma(_self10, _t32, _self11 * _t43)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self12, _t11, Math.fma(_self10, _t34, _self11 * _t44)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self12, _t12, Math.fma(_self10, _t33, _self11 * _t45)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(-_self10, _t47, Math.fma(-_self11, _t49, Math.fma(-_self12, _t24, _self13))));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self22, _t10, Math.fma(_self20, _t32, _self21 * _t43)));
        UnsafeOpsHolder.U.putFloat(dest + 36L, Math.fma(_self22, _t11, Math.fma(_self20, _t34, _self21 * _t44)));
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(_self22, _t12, Math.fma(_self20, _t33, _self21 * _t45)));
        UnsafeOpsHolder.U.putFloat(dest + 44L, Math.fma(-_self20, _t47, Math.fma(-_self21, _t49, Math.fma(-_self22, _t24, _self23))));
        return dest;
    }

    public static long lookAt_rh(long dest, long src, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return Float3x4OpsKernelsAddress.lookAt_rh_unsafe(dest, src, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        Float3x4OpsKernelsSegment.lookAt_rh(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 48L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 48L), 0L, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return dest;
    }

    public static long lookAt_rh_unsafe(long dest, long src, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        float _t0 = -_self02;
        float _t1 = -_self12;
        float _t2 = -_self22;
        float _t3 = centerZ - eyeZ;
        float _t4 = centerX - eyeX;
        float _t5 = centerY - eyeY;
        float _t8 = Math.fma(_t3, _t3, Math.fma(_t4, _t4, _t5 * _t5));
        float _t9 = (1.0f / (float) Math.sqrt(_t8));
        float _t13, _t14, _t15;
        if (_t8 > 0.0f) {
            _t13 = _t4 * _t9;
            _t14 = _t5 * _t9;
            _t15 = _t3 * _t9;
        } else {
            _t13 = 0.0f;
            _t14 = 0.0f;
            _t15 = 0.0f;
        }
        float _t24 = Math.fma(upY, _t13, -(upX * _t14));
        float _t25 = Math.fma(upX, _t15, -(upZ * _t13));
        float _t26 = Math.fma(upZ, _t14, -(upY * _t15));
        float _t27 = Math.fma(eyeZ, _t15, Math.fma(eyeX, _t13, eyeY * _t14));
        float _t30 = Math.fma(_t24, _t24, Math.fma(_t25, _t25, _t26 * _t26));
        float _t31 = (1.0f / (float) Math.sqrt(_t30));
        float _t35, _t36, _t37;
        if (_t30 > 0.0f) {
            _t35 = _t26 * _t31;
            _t36 = _t25 * _t31;
            _t37 = _t24 * _t31;
        } else {
            _t35 = 0.0f;
            _t36 = 0.0f;
            _t37 = 0.0f;
        }
        float _t46 = Math.fma(_t15, _t36, -(_t14 * _t37));
        float _t47 = Math.fma(_t13, _t37, -(_t15 * _t35));
        float _t48 = Math.fma(_t14, _t35, -(_t13 * _t36));
        float _t50 = Math.fma(eyeZ, _t37, Math.fma(eyeX, _t35, eyeY * _t36));
        float _t52 = Math.fma(eyeZ, _t48, Math.fma(eyeX, _t46, eyeY * _t47));
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_t0, _t13, Math.fma(_self00, _t35, _self01 * _t46)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_t0, _t14, Math.fma(_self00, _t36, _self01 * _t47)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_t0, _t15, Math.fma(_self00, _t37, _self01 * _t48)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(-_self00, _t50, Math.fma(-_self01, _t52, Math.fma(_self02, _t27, _self03))));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_t1, _t13, Math.fma(_self10, _t35, _self11 * _t46)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_t1, _t14, Math.fma(_self10, _t36, _self11 * _t47)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_t1, _t15, Math.fma(_self10, _t37, _self11 * _t48)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(-_self10, _t50, Math.fma(-_self11, _t52, Math.fma(_self12, _t27, _self13))));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_t2, _t13, Math.fma(_self20, _t35, _self21 * _t46)));
        UnsafeOpsHolder.U.putFloat(dest + 36L, Math.fma(_t2, _t14, Math.fma(_self20, _t36, _self21 * _t47)));
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(_t2, _t15, Math.fma(_self20, _t37, _self21 * _t48)));
        UnsafeOpsHolder.U.putFloat(dest + 44L, Math.fma(-_self20, _t50, Math.fma(-_self21, _t52, Math.fma(_self22, _t27, _self23))));
        return dest;
    }

    public static long lookAt_lh(long dest, long src, long eye, long center, long up) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return Float3x4OpsKernelsAddress.lookAt_lh_unsafe(dest, src, eye, center, up);
        Float3x4OpsKernelsSegment.lookAt_lh(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 48L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 48L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(eye, 12L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(center, 12L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(up, 12L), 0L);
        return dest;
    }

    public static long lookAt_lh_unsafe(long dest, long src, long eye, long center, long up) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        float _eyex = UnsafeOpsHolder.U.getFloat(eye + 0L);
        float _eyey = UnsafeOpsHolder.U.getFloat(eye + 4L);
        float _eyez = UnsafeOpsHolder.U.getFloat(eye + 8L);
        float _centerx = UnsafeOpsHolder.U.getFloat(center + 0L);
        float _centery = UnsafeOpsHolder.U.getFloat(center + 4L);
        float _centerz = UnsafeOpsHolder.U.getFloat(center + 8L);
        float _upx = UnsafeOpsHolder.U.getFloat(up + 0L);
        float _upy = UnsafeOpsHolder.U.getFloat(up + 4L);
        float _upz = UnsafeOpsHolder.U.getFloat(up + 8L);
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
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_self02, _t10, Math.fma(_self00, _t32, _self01 * _t43)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self02, _t11, Math.fma(_self00, _t34, _self01 * _t44)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self02, _t12, Math.fma(_self00, _t33, _self01 * _t45)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(-_self00, _t47, Math.fma(-_self01, _t49, Math.fma(-_self02, _t24, _self03))));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self12, _t10, Math.fma(_self10, _t32, _self11 * _t43)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self12, _t11, Math.fma(_self10, _t34, _self11 * _t44)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self12, _t12, Math.fma(_self10, _t33, _self11 * _t45)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(-_self10, _t47, Math.fma(-_self11, _t49, Math.fma(-_self12, _t24, _self13))));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self22, _t10, Math.fma(_self20, _t32, _self21 * _t43)));
        UnsafeOpsHolder.U.putFloat(dest + 36L, Math.fma(_self22, _t11, Math.fma(_self20, _t34, _self21 * _t44)));
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(_self22, _t12, Math.fma(_self20, _t33, _self21 * _t45)));
        UnsafeOpsHolder.U.putFloat(dest + 44L, Math.fma(-_self20, _t47, Math.fma(-_self21, _t49, Math.fma(-_self22, _t24, _self23))));
        return dest;
    }

    public static long lookAt_rh(long dest, long src, long eye, long center, long up) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return Float3x4OpsKernelsAddress.lookAt_rh_unsafe(dest, src, eye, center, up);
        Float3x4OpsKernelsSegment.lookAt_rh(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 48L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 48L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(eye, 12L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(center, 12L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(up, 12L), 0L);
        return dest;
    }

    public static long lookAt_rh_unsafe(long dest, long src, long eye, long center, long up) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        float _eyex = UnsafeOpsHolder.U.getFloat(eye + 0L);
        float _eyey = UnsafeOpsHolder.U.getFloat(eye + 4L);
        float _eyez = UnsafeOpsHolder.U.getFloat(eye + 8L);
        float _centerx = UnsafeOpsHolder.U.getFloat(center + 0L);
        float _centery = UnsafeOpsHolder.U.getFloat(center + 4L);
        float _centerz = UnsafeOpsHolder.U.getFloat(center + 8L);
        float _upx = UnsafeOpsHolder.U.getFloat(up + 0L);
        float _upy = UnsafeOpsHolder.U.getFloat(up + 4L);
        float _upz = UnsafeOpsHolder.U.getFloat(up + 8L);
        float _t0 = -_self02;
        float _t1 = -_self12;
        float _t2 = -_self22;
        float _t3 = _centerz - _eyez;
        float _t4 = _centerx - _eyex;
        float _t5 = _centery - _eyey;
        float _t8 = Math.fma(_t3, _t3, Math.fma(_t4, _t4, _t5 * _t5));
        float _t9 = (1.0f / (float) Math.sqrt(_t8));
        float _t13, _t14, _t15;
        if (_t8 > 0.0f) {
            _t13 = _t4 * _t9;
            _t14 = _t5 * _t9;
            _t15 = _t3 * _t9;
        } else {
            _t13 = 0.0f;
            _t14 = 0.0f;
            _t15 = 0.0f;
        }
        float _t24 = Math.fma(_upy, _t13, -(_upx * _t14));
        float _t25 = Math.fma(_upx, _t15, -(_upz * _t13));
        float _t26 = Math.fma(_upz, _t14, -(_upy * _t15));
        float _t27 = Math.fma(_eyez, _t15, Math.fma(_eyex, _t13, _eyey * _t14));
        float _t30 = Math.fma(_t24, _t24, Math.fma(_t25, _t25, _t26 * _t26));
        float _t31 = (1.0f / (float) Math.sqrt(_t30));
        float _t35, _t36, _t37;
        if (_t30 > 0.0f) {
            _t35 = _t26 * _t31;
            _t36 = _t25 * _t31;
            _t37 = _t24 * _t31;
        } else {
            _t35 = 0.0f;
            _t36 = 0.0f;
            _t37 = 0.0f;
        }
        float _t46 = Math.fma(_t15, _t36, -(_t14 * _t37));
        float _t47 = Math.fma(_t13, _t37, -(_t15 * _t35));
        float _t48 = Math.fma(_t14, _t35, -(_t13 * _t36));
        float _t50 = Math.fma(_eyez, _t37, Math.fma(_eyex, _t35, _eyey * _t36));
        float _t52 = Math.fma(_eyez, _t48, Math.fma(_eyex, _t46, _eyey * _t47));
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_t0, _t13, Math.fma(_self00, _t35, _self01 * _t46)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_t0, _t14, Math.fma(_self00, _t36, _self01 * _t47)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_t0, _t15, Math.fma(_self00, _t37, _self01 * _t48)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(-_self00, _t50, Math.fma(-_self01, _t52, Math.fma(_self02, _t27, _self03))));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_t1, _t13, Math.fma(_self10, _t35, _self11 * _t46)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_t1, _t14, Math.fma(_self10, _t36, _self11 * _t47)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_t1, _t15, Math.fma(_self10, _t37, _self11 * _t48)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(-_self10, _t50, Math.fma(-_self11, _t52, Math.fma(_self12, _t27, _self13))));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_t2, _t13, Math.fma(_self20, _t35, _self21 * _t46)));
        UnsafeOpsHolder.U.putFloat(dest + 36L, Math.fma(_t2, _t14, Math.fma(_self20, _t36, _self21 * _t47)));
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(_t2, _t15, Math.fma(_self20, _t37, _self21 * _t48)));
        UnsafeOpsHolder.U.putFloat(dest + 44L, Math.fma(-_self20, _t50, Math.fma(-_self21, _t52, Math.fma(_self22, _t27, _self23))));
        return dest;
    }

    public static long makeBillboardCylindrical_unsafe(long dest, float objPosX, float objPosY, float objPosZ, float targetPosX, float targetPosY, float targetPosZ, float upX, float upY, float upZ) {
        float _t0 = targetPosY - objPosY;
        float _t1 = targetPosX - objPosX;
        float _t2 = targetPosZ - objPosZ;
        float _t9 = Math.fma(upX, _t0, -(upY * _t1));
        float _t10 = Math.fma(upY, _t2, -(upZ * _t0));
        float _t11 = Math.fma(upZ, _t1, -(upX * _t2));
        float _t14 = Math.fma(_t9, _t9, Math.fma(_t10, _t10, _t11 * _t11));
        float _t15 = (1.0f / (float) Math.sqrt(_t14));
        float _t19, _t20, _t21;
        if (_t14 > 0.0f) {
            _t19 = _t10 * _t15;
            _t20 = _t11 * _t15;
            _t21 = _t9 * _t15;
        } else {
            _t19 = 0.0f;
            _t20 = 0.0f;
            _t21 = 0.0f;
        }
        float _t28 = Math.fma(upY, _t19, -(upX * _t20));
        float _t29 = Math.fma(upX, _t21, -(upZ * _t19));
        float _t30 = Math.fma(upZ, _t20, -(upY * _t21));
        float _t33 = Math.fma(_t28, _t28, Math.fma(_t29, _t29, _t30 * _t30));
        float _t34 = (1.0f / (float) Math.sqrt(_t33));
        if (_t33 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 8L, _t30 * _t34);
            UnsafeOpsHolder.U.putFloat(dest + 24L, _t29 * _t34);
            UnsafeOpsHolder.U.putFloat(dest + 40L, _t28 * _t34);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 40L, 0.0f);
        }
        UnsafeOpsHolder.U.putFloat(dest + 0L, _t19);
        UnsafeOpsHolder.U.putFloat(dest + 4L, upX);
        UnsafeOpsHolder.U.putFloat(dest + 12L, objPosX);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _t20);
        UnsafeOpsHolder.U.putFloat(dest + 20L, upY);
        UnsafeOpsHolder.U.putFloat(dest + 28L, objPosY);
        UnsafeOpsHolder.U.putFloat(dest + 32L, _t21);
        UnsafeOpsHolder.U.putFloat(dest + 36L, upZ);
        UnsafeOpsHolder.U.putFloat(dest + 44L, objPosZ);
        return dest;
    }

    public static long makeBillboardCylindrical_unsafe(long dest, long objPos, long targetPos, long up) {
        float _objPosx = UnsafeOpsHolder.U.getFloat(objPos + 0L);
        float _objPosy = UnsafeOpsHolder.U.getFloat(objPos + 4L);
        float _objPosz = UnsafeOpsHolder.U.getFloat(objPos + 8L);
        float _targetPosx = UnsafeOpsHolder.U.getFloat(targetPos + 0L);
        float _targetPosy = UnsafeOpsHolder.U.getFloat(targetPos + 4L);
        float _targetPosz = UnsafeOpsHolder.U.getFloat(targetPos + 8L);
        float _upx = UnsafeOpsHolder.U.getFloat(up + 0L);
        float _upy = UnsafeOpsHolder.U.getFloat(up + 4L);
        float _upz = UnsafeOpsHolder.U.getFloat(up + 8L);
        float _t0 = _targetPosy - _objPosy;
        float _t1 = _targetPosx - _objPosx;
        float _t2 = _targetPosz - _objPosz;
        float _t9 = Math.fma(_upx, _t0, -(_upy * _t1));
        float _t10 = Math.fma(_upy, _t2, -(_upz * _t0));
        float _t11 = Math.fma(_upz, _t1, -(_upx * _t2));
        float _t14 = Math.fma(_t9, _t9, Math.fma(_t10, _t10, _t11 * _t11));
        float _t15 = (1.0f / (float) Math.sqrt(_t14));
        float _t19, _t20, _t21;
        if (_t14 > 0.0f) {
            _t19 = _t10 * _t15;
            _t20 = _t11 * _t15;
            _t21 = _t9 * _t15;
        } else {
            _t19 = 0.0f;
            _t20 = 0.0f;
            _t21 = 0.0f;
        }
        float _t28 = Math.fma(_upy, _t19, -(_upx * _t20));
        float _t29 = Math.fma(_upx, _t21, -(_upz * _t19));
        float _t30 = Math.fma(_upz, _t20, -(_upy * _t21));
        float _t33 = Math.fma(_t28, _t28, Math.fma(_t29, _t29, _t30 * _t30));
        float _t34 = (1.0f / (float) Math.sqrt(_t33));
        if (_t33 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 8L, _t30 * _t34);
            UnsafeOpsHolder.U.putFloat(dest + 24L, _t29 * _t34);
            UnsafeOpsHolder.U.putFloat(dest + 40L, _t28 * _t34);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 40L, 0.0f);
        }
        UnsafeOpsHolder.U.putFloat(dest + 0L, _t19);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _upx);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _objPosx);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _t20);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _upy);
        UnsafeOpsHolder.U.putFloat(dest + 28L, _objPosy);
        UnsafeOpsHolder.U.putFloat(dest + 32L, _t21);
        UnsafeOpsHolder.U.putFloat(dest + 36L, _upz);
        UnsafeOpsHolder.U.putFloat(dest + 44L, _objPosz);
        return dest;
    }

    public static long makeBillboardSpherical_unsafe(long dest, float objPosX, float objPosY, float objPosZ, float targetPosX, float targetPosY, float targetPosZ, float upX, float upY, float upZ) {
        float _t0 = targetPosZ - objPosZ;
        float _t1 = targetPosX - objPosX;
        float _t2 = targetPosY - objPosY;
        float _t5 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        float _t6 = (1.0f / (float) Math.sqrt(_t5));
        float _t10, _t11, _t12;
        if (_t5 > 0.0f) {
            _t10 = _t2 * _t6;
            _t11 = _t1 * _t6;
            _t12 = _t0 * _t6;
        } else {
            _t10 = 0.0f;
            _t11 = 0.0f;
            _t12 = 0.0f;
        }
        float _t19 = Math.fma(upX, _t10, -(upY * _t11));
        float _t20 = Math.fma(upY, _t12, -(upZ * _t10));
        float _t21 = Math.fma(upZ, _t11, -(upX * _t12));
        float _t24 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        float _t25 = (1.0f / (float) Math.sqrt(_t24));
        float _t29, _t30, _t31;
        if (_t24 > 0.0f) {
            _t29 = _t20 * _t25;
            _t30 = _t19 * _t25;
            _t31 = _t21 * _t25;
        } else {
            _t29 = 0.0f;
            _t30 = 0.0f;
            _t31 = 0.0f;
        }
        UnsafeOpsHolder.U.putFloat(dest + 0L, _t29);
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_t10, _t30, -(_t12 * _t31)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, _t11);
        UnsafeOpsHolder.U.putFloat(dest + 12L, objPosX);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _t31);
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_t12, _t29, -(_t11 * _t30)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, _t10);
        UnsafeOpsHolder.U.putFloat(dest + 28L, objPosY);
        UnsafeOpsHolder.U.putFloat(dest + 32L, _t30);
        UnsafeOpsHolder.U.putFloat(dest + 36L, Math.fma(_t11, _t31, -(_t10 * _t29)));
        UnsafeOpsHolder.U.putFloat(dest + 40L, _t12);
        UnsafeOpsHolder.U.putFloat(dest + 44L, objPosZ);
        return dest;
    }

    public static long makeBillboardSpherical_unsafe(long dest, long objPos, long targetPos, long up) {
        float _objPosx = UnsafeOpsHolder.U.getFloat(objPos + 0L);
        float _objPosy = UnsafeOpsHolder.U.getFloat(objPos + 4L);
        float _objPosz = UnsafeOpsHolder.U.getFloat(objPos + 8L);
        float _targetPosx = UnsafeOpsHolder.U.getFloat(targetPos + 0L);
        float _targetPosy = UnsafeOpsHolder.U.getFloat(targetPos + 4L);
        float _targetPosz = UnsafeOpsHolder.U.getFloat(targetPos + 8L);
        float _upx = UnsafeOpsHolder.U.getFloat(up + 0L);
        float _upy = UnsafeOpsHolder.U.getFloat(up + 4L);
        float _upz = UnsafeOpsHolder.U.getFloat(up + 8L);
        float _t0 = _targetPosz - _objPosz;
        float _t1 = _targetPosx - _objPosx;
        float _t2 = _targetPosy - _objPosy;
        float _t5 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        float _t6 = (1.0f / (float) Math.sqrt(_t5));
        float _t10, _t11, _t12;
        if (_t5 > 0.0f) {
            _t10 = _t2 * _t6;
            _t11 = _t1 * _t6;
            _t12 = _t0 * _t6;
        } else {
            _t10 = 0.0f;
            _t11 = 0.0f;
            _t12 = 0.0f;
        }
        float _t19 = Math.fma(_upx, _t10, -(_upy * _t11));
        float _t20 = Math.fma(_upy, _t12, -(_upz * _t10));
        float _t21 = Math.fma(_upz, _t11, -(_upx * _t12));
        float _t24 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        float _t25 = (1.0f / (float) Math.sqrt(_t24));
        float _t29, _t30, _t31;
        if (_t24 > 0.0f) {
            _t29 = _t20 * _t25;
            _t30 = _t19 * _t25;
            _t31 = _t21 * _t25;
        } else {
            _t29 = 0.0f;
            _t30 = 0.0f;
            _t31 = 0.0f;
        }
        UnsafeOpsHolder.U.putFloat(dest + 0L, _t29);
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_t10, _t30, -(_t12 * _t31)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, _t11);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _objPosx);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _t31);
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_t12, _t29, -(_t11 * _t30)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, _t10);
        UnsafeOpsHolder.U.putFloat(dest + 28L, _objPosy);
        UnsafeOpsHolder.U.putFloat(dest + 32L, _t30);
        UnsafeOpsHolder.U.putFloat(dest + 36L, Math.fma(_t11, _t31, -(_t10 * _t29)));
        UnsafeOpsHolder.U.putFloat(dest + 40L, _t12);
        UnsafeOpsHolder.U.putFloat(dest + 44L, _objPosz);
        return dest;
    }

    public static long makeBillboardSphericalShortest_unsafe(long dest, float objPosX, float objPosY, float objPosZ, float targetPosX, float targetPosY, float targetPosZ) {
        float _t0 = targetPosX - objPosX;
        float _t1 = targetPosZ - objPosZ;
        float _t2 = targetPosY - objPosY;
        float _t3 = objPosY - targetPosY;
        float _t10 = _t1 + (float) Math.sqrt(Math.fma(_t1, _t1, Math.fma(_t0, _t0, _t2 * _t2)));
        float _t12 = (1.0f / (float) Math.sqrt(Math.fma(_t10, _t10, Math.fma(_t3, _t3, _t0 * _t0))));
        float _t13 = _t0 * _t12;
        float _t14 = _t3 * _t12;
        float _t15 = 2.0f * _t13;
        float _t16 = 2.0f * _t14;
        float _t17 = -_t15;
        float _t19 = _t10 * _t12;
        float _t20 = _t16 * _t13;
        float _t21 = Math.fma(-_t16, _t14, 1.0f);
        float _t22 = _t15 * _t19;
        float _t23 = _t16 * _t19;
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_t17, _t13, 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 4L, _t20);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _t22);
        UnsafeOpsHolder.U.putFloat(dest + 12L, objPosX);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _t20);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _t21);
        UnsafeOpsHolder.U.putFloat(dest + 24L, -_t23);
        UnsafeOpsHolder.U.putFloat(dest + 28L, objPosY);
        UnsafeOpsHolder.U.putFloat(dest + 32L, -_t22);
        UnsafeOpsHolder.U.putFloat(dest + 36L, _t23);
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(_t17, _t13, _t21));
        UnsafeOpsHolder.U.putFloat(dest + 44L, objPosZ);
        return dest;
    }

    public static long makeBillboardSphericalShortest_unsafe(long dest, long objPos, long targetPos) {
        float _objPosx = UnsafeOpsHolder.U.getFloat(objPos + 0L);
        float _objPosy = UnsafeOpsHolder.U.getFloat(objPos + 4L);
        float _objPosz = UnsafeOpsHolder.U.getFloat(objPos + 8L);
        float _targetPosx = UnsafeOpsHolder.U.getFloat(targetPos + 0L);
        float _targetPosy = UnsafeOpsHolder.U.getFloat(targetPos + 4L);
        float _targetPosz = UnsafeOpsHolder.U.getFloat(targetPos + 8L);
        float _t0 = _targetPosx - _objPosx;
        float _t1 = _targetPosz - _objPosz;
        float _t2 = _targetPosy - _objPosy;
        float _t3 = _objPosy - _targetPosy;
        float _t10 = _t1 + (float) Math.sqrt(Math.fma(_t1, _t1, Math.fma(_t0, _t0, _t2 * _t2)));
        float _t12 = (1.0f / (float) Math.sqrt(Math.fma(_t10, _t10, Math.fma(_t3, _t3, _t0 * _t0))));
        float _t13 = _t0 * _t12;
        float _t14 = _t3 * _t12;
        float _t15 = 2.0f * _t13;
        float _t16 = 2.0f * _t14;
        float _t17 = -_t15;
        float _t19 = _t10 * _t12;
        float _t20 = _t16 * _t13;
        float _t21 = Math.fma(-_t16, _t14, 1.0f);
        float _t22 = _t15 * _t19;
        float _t23 = _t16 * _t19;
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_t17, _t13, 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 4L, _t20);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _t22);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _objPosx);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _t20);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _t21);
        UnsafeOpsHolder.U.putFloat(dest + 24L, -_t23);
        UnsafeOpsHolder.U.putFloat(dest + 28L, _objPosy);
        UnsafeOpsHolder.U.putFloat(dest + 32L, -_t22);
        UnsafeOpsHolder.U.putFloat(dest + 36L, _t23);
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(_t17, _t13, _t21));
        UnsafeOpsHolder.U.putFloat(dest + 44L, _objPosz);
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
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(-2.0f, _t2, 2.0f * dqRX * dqRY));
        UnsafeOpsHolder.U.putFloat(dest + 8L, 2.0f * Math.fma(dqRX, dqRZ, _t3));
        UnsafeOpsHolder.U.putFloat(dest + 12L, 2.0f * (Math.fma(dqRY, dqDZ, -(dqRZ * dqDY)) + Math.fma(dqRW, dqDX, -(dqRX * dqDW))));
        UnsafeOpsHolder.U.putFloat(dest + 16L, 2.0f * Math.fma(dqRX, dqRY, _t2));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(-2.0f, _t4, _t6));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(-2.0f, dqRX * dqRW, 2.0f * _t5));
        UnsafeOpsHolder.U.putFloat(dest + 28L, 2.0f * (Math.fma(dqRZ, dqDX, -(dqRX * dqDZ)) + Math.fma(dqRW, dqDY, -(dqRY * dqDW))));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(-2.0f, _t3, 2.0f * dqRX * dqRZ));
        UnsafeOpsHolder.U.putFloat(dest + 36L, 2.0f * Math.fma(dqRX, dqRW, _t5));
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(-2.0f, _t4, Math.fma(-2.0f, _t0, 1.0f)));
        UnsafeOpsHolder.U.putFloat(dest + 44L, 2.0f * (Math.fma(dqRX, dqDY, -(dqRY * dqDX)) + Math.fma(dqRW, dqDZ, -(dqRZ * dqDW))));
        return dest;
    }

    public static long makeLookAt_lh(long dest, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return Float3x4OpsKernelsAddress.makeLookAt_lh_unsafe(dest, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        Float3x4OpsKernelsSegment.makeLookAt_lh(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 48L), 0L, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return dest;
    }

    public static long makeLookAt_lh_unsafe(long dest, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        float _t0 = centerZ - eyeZ;
        float _t1 = centerX - eyeX;
        float _t2 = centerY - eyeY;
        float _t5 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        float _t6 = (1.0f / (float) Math.sqrt(_t5));
        float _t10, _t11, _t12;
        if (_t5 > 0.0f) {
            _t10 = _t2 * _t6;
            _t11 = _t1 * _t6;
            _t12 = _t0 * _t6;
        } else {
            _t10 = 0.0f;
            _t11 = 0.0f;
            _t12 = 0.0f;
        }
        float _t19 = Math.fma(upX, _t10, -(upY * _t11));
        float _t20 = Math.fma(upY, _t12, -(upZ * _t10));
        float _t21 = Math.fma(upZ, _t11, -(upX * _t12));
        float _t24 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        float _t25 = (1.0f / (float) Math.sqrt(_t24));
        float _t29, _t30, _t31;
        if (_t24 > 0.0f) {
            _t29 = _t20 * _t25;
            _t30 = _t21 * _t25;
            _t31 = _t19 * _t25;
        } else {
            _t29 = 0.0f;
            _t30 = 0.0f;
            _t31 = 0.0f;
        }
        float _t38 = Math.fma(_t10, _t31, -(_t12 * _t30));
        float _t39 = Math.fma(_t12, _t29, -(_t11 * _t31));
        float _t40 = Math.fma(_t11, _t30, -(_t10 * _t29));
        UnsafeOpsHolder.U.putFloat(dest + 0L, _t29);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _t30);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _t31);
        UnsafeOpsHolder.U.putFloat(dest + 12L, -Math.fma(eyeZ, _t31, Math.fma(eyeX, _t29, eyeY * _t30)));
        UnsafeOpsHolder.U.putFloat(dest + 16L, _t38);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _t39);
        UnsafeOpsHolder.U.putFloat(dest + 24L, _t40);
        UnsafeOpsHolder.U.putFloat(dest + 28L, -Math.fma(eyeZ, _t40, Math.fma(eyeX, _t38, eyeY * _t39)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, _t11);
        UnsafeOpsHolder.U.putFloat(dest + 36L, _t10);
        UnsafeOpsHolder.U.putFloat(dest + 40L, _t12);
        UnsafeOpsHolder.U.putFloat(dest + 44L, -Math.fma(eyeZ, _t12, Math.fma(eyeX, _t11, eyeY * _t10)));
        return dest;
    }

    public static long makeLookAt_rh(long dest, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return Float3x4OpsKernelsAddress.makeLookAt_rh_unsafe(dest, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        Float3x4OpsKernelsSegment.makeLookAt_rh(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 48L), 0L, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return dest;
    }

    public static long makeLookAt_rh_unsafe(long dest, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
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
        float _t19 = Math.fma(upY, _t10, -(upX * _t11));
        float _t20 = Math.fma(upX, _t12, -(upZ * _t10));
        float _t21 = Math.fma(upZ, _t11, -(upY * _t12));
        float _t24 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        float _t25 = (1.0f / (float) Math.sqrt(_t24));
        float _t29, _t30, _t31;
        if (_t24 > 0.0f) {
            _t29 = _t21 * _t25;
            _t30 = _t20 * _t25;
            _t31 = _t19 * _t25;
        } else {
            _t29 = 0.0f;
            _t30 = 0.0f;
            _t31 = 0.0f;
        }
        float _t38 = Math.fma(_t12, _t30, -(_t11 * _t31));
        float _t39 = Math.fma(_t10, _t31, -(_t12 * _t29));
        float _t40 = Math.fma(_t11, _t29, -(_t10 * _t30));
        UnsafeOpsHolder.U.putFloat(dest + 0L, _t29);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _t30);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _t31);
        UnsafeOpsHolder.U.putFloat(dest + 12L, -Math.fma(eyeZ, _t31, Math.fma(eyeX, _t29, eyeY * _t30)));
        UnsafeOpsHolder.U.putFloat(dest + 16L, _t38);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _t39);
        UnsafeOpsHolder.U.putFloat(dest + 24L, _t40);
        UnsafeOpsHolder.U.putFloat(dest + 28L, -Math.fma(eyeZ, _t40, Math.fma(eyeX, _t38, eyeY * _t39)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, -_t10);
        UnsafeOpsHolder.U.putFloat(dest + 36L, -_t11);
        UnsafeOpsHolder.U.putFloat(dest + 40L, -_t12);
        UnsafeOpsHolder.U.putFloat(dest + 44L, Math.fma(eyeZ, _t12, Math.fma(eyeX, _t10, eyeY * _t11)));
        return dest;
    }

    public static long makeLookAt_lh(long dest, long eye, long center, long up) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return Float3x4OpsKernelsAddress.makeLookAt_lh_unsafe(dest, eye, center, up);
        Float3x4OpsKernelsSegment.makeLookAt_lh(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 48L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(eye, 12L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(center, 12L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(up, 12L), 0L);
        return dest;
    }

    public static long makeLookAt_lh_unsafe(long dest, long eye, long center, long up) {
        float _eyex = UnsafeOpsHolder.U.getFloat(eye + 0L);
        float _eyey = UnsafeOpsHolder.U.getFloat(eye + 4L);
        float _eyez = UnsafeOpsHolder.U.getFloat(eye + 8L);
        float _centerx = UnsafeOpsHolder.U.getFloat(center + 0L);
        float _centery = UnsafeOpsHolder.U.getFloat(center + 4L);
        float _centerz = UnsafeOpsHolder.U.getFloat(center + 8L);
        float _upx = UnsafeOpsHolder.U.getFloat(up + 0L);
        float _upy = UnsafeOpsHolder.U.getFloat(up + 4L);
        float _upz = UnsafeOpsHolder.U.getFloat(up + 8L);
        float _t0 = _centerz - _eyez;
        float _t1 = _centerx - _eyex;
        float _t2 = _centery - _eyey;
        float _t5 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        float _t6 = (1.0f / (float) Math.sqrt(_t5));
        float _t10, _t11, _t12;
        if (_t5 > 0.0f) {
            _t10 = _t2 * _t6;
            _t11 = _t1 * _t6;
            _t12 = _t0 * _t6;
        } else {
            _t10 = 0.0f;
            _t11 = 0.0f;
            _t12 = 0.0f;
        }
        float _t19 = Math.fma(_upx, _t10, -(_upy * _t11));
        float _t20 = Math.fma(_upy, _t12, -(_upz * _t10));
        float _t21 = Math.fma(_upz, _t11, -(_upx * _t12));
        float _t24 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        float _t25 = (1.0f / (float) Math.sqrt(_t24));
        float _t29, _t30, _t31;
        if (_t24 > 0.0f) {
            _t29 = _t20 * _t25;
            _t30 = _t21 * _t25;
            _t31 = _t19 * _t25;
        } else {
            _t29 = 0.0f;
            _t30 = 0.0f;
            _t31 = 0.0f;
        }
        float _t38 = Math.fma(_t10, _t31, -(_t12 * _t30));
        float _t39 = Math.fma(_t12, _t29, -(_t11 * _t31));
        float _t40 = Math.fma(_t11, _t30, -(_t10 * _t29));
        UnsafeOpsHolder.U.putFloat(dest + 0L, _t29);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _t30);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _t31);
        UnsafeOpsHolder.U.putFloat(dest + 12L, -Math.fma(_eyez, _t31, Math.fma(_eyex, _t29, _eyey * _t30)));
        UnsafeOpsHolder.U.putFloat(dest + 16L, _t38);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _t39);
        UnsafeOpsHolder.U.putFloat(dest + 24L, _t40);
        UnsafeOpsHolder.U.putFloat(dest + 28L, -Math.fma(_eyez, _t40, Math.fma(_eyex, _t38, _eyey * _t39)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, _t11);
        UnsafeOpsHolder.U.putFloat(dest + 36L, _t10);
        UnsafeOpsHolder.U.putFloat(dest + 40L, _t12);
        UnsafeOpsHolder.U.putFloat(dest + 44L, -Math.fma(_eyez, _t12, Math.fma(_eyex, _t11, _eyey * _t10)));
        return dest;
    }

    public static long makeLookAt_rh(long dest, long eye, long center, long up) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return Float3x4OpsKernelsAddress.makeLookAt_rh_unsafe(dest, eye, center, up);
        Float3x4OpsKernelsSegment.makeLookAt_rh(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 48L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(eye, 12L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(center, 12L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(up, 12L), 0L);
        return dest;
    }

    public static long makeLookAt_rh_unsafe(long dest, long eye, long center, long up) {
        float _eyex = UnsafeOpsHolder.U.getFloat(eye + 0L);
        float _eyey = UnsafeOpsHolder.U.getFloat(eye + 4L);
        float _eyez = UnsafeOpsHolder.U.getFloat(eye + 8L);
        float _centerx = UnsafeOpsHolder.U.getFloat(center + 0L);
        float _centery = UnsafeOpsHolder.U.getFloat(center + 4L);
        float _centerz = UnsafeOpsHolder.U.getFloat(center + 8L);
        float _upx = UnsafeOpsHolder.U.getFloat(up + 0L);
        float _upy = UnsafeOpsHolder.U.getFloat(up + 4L);
        float _upz = UnsafeOpsHolder.U.getFloat(up + 8L);
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
        float _t19 = Math.fma(_upy, _t10, -(_upx * _t11));
        float _t20 = Math.fma(_upx, _t12, -(_upz * _t10));
        float _t21 = Math.fma(_upz, _t11, -(_upy * _t12));
        float _t24 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        float _t25 = (1.0f / (float) Math.sqrt(_t24));
        float _t29, _t30, _t31;
        if (_t24 > 0.0f) {
            _t29 = _t21 * _t25;
            _t30 = _t20 * _t25;
            _t31 = _t19 * _t25;
        } else {
            _t29 = 0.0f;
            _t30 = 0.0f;
            _t31 = 0.0f;
        }
        float _t38 = Math.fma(_t12, _t30, -(_t11 * _t31));
        float _t39 = Math.fma(_t10, _t31, -(_t12 * _t29));
        float _t40 = Math.fma(_t11, _t29, -(_t10 * _t30));
        UnsafeOpsHolder.U.putFloat(dest + 0L, _t29);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _t30);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _t31);
        UnsafeOpsHolder.U.putFloat(dest + 12L, -Math.fma(_eyez, _t31, Math.fma(_eyex, _t29, _eyey * _t30)));
        UnsafeOpsHolder.U.putFloat(dest + 16L, _t38);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _t39);
        UnsafeOpsHolder.U.putFloat(dest + 24L, _t40);
        UnsafeOpsHolder.U.putFloat(dest + 28L, -Math.fma(_eyez, _t40, Math.fma(_eyex, _t38, _eyey * _t39)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, -_t10);
        UnsafeOpsHolder.U.putFloat(dest + 36L, -_t11);
        UnsafeOpsHolder.U.putFloat(dest + 40L, -_t12);
        UnsafeOpsHolder.U.putFloat(dest + 44L, Math.fma(_eyez, _t12, Math.fma(_eyex, _t10, _eyey * _t11)));
        return dest;
    }

    public static long makeMappingXYZ_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingXYnZ_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingXZY_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingXZnY_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingXnYZ_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingXnYnZ_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingXnZY_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingXnZnY_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingYXZ_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingYXnZ_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingYZX_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingYZnX_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingYnXZ_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingYnXnZ_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingYnZX_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingYnZnX_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingZXY_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingZXnY_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingZYX_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingZYnX_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingZnXY_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingZnXnY_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingZnYX_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingZnYnX_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingnXYZ_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingnXYnZ_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingnXZY_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingnXZnY_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingnXnYZ_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingnXnYnZ_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingnXnZY_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingnXnZnY_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingnYXZ_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingnYXnZ_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingnYZX_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingnYZnX_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingnYnXZ_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingnYnXnZ_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingnYnZX_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingnYnZnX_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingnZXY_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingnZXnY_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingnZYX_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingnZYnX_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingnZnXY_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingnZnXnY_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingnZnYX_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeMappingnZnYnX_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, -1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeReflection_unsafe(long dest, float normalX, float normalY, float normalZ) {
        float _t6 = -(2.0f * normalX * normalY);
        float _t7 = -(2.0f * normalX * normalZ);
        float _t8 = -(2.0f * normalY * normalZ);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(-2.0f, normalX * normalX, 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 4L, _t6);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _t7);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _t6);
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(-2.0f, normalY * normalY, 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 24L, _t8);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, _t7);
        UnsafeOpsHolder.U.putFloat(dest + 36L, _t8);
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(-2.0f, normalZ * normalZ, 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeReflection_unsafe(long dest, long normal) {
        float _normalx = UnsafeOpsHolder.U.getFloat(normal + 0L);
        float _normaly = UnsafeOpsHolder.U.getFloat(normal + 4L);
        float _normalz = UnsafeOpsHolder.U.getFloat(normal + 8L);
        float _t6 = -(2.0f * _normalx * _normaly);
        float _t7 = -(2.0f * _normalx * _normalz);
        float _t8 = -(2.0f * _normaly * _normalz);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(-2.0f, _normalx * _normalx, 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 4L, _t6);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _t7);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _t6);
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(-2.0f, _normaly * _normaly, 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 24L, _t8);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, _t7);
        UnsafeOpsHolder.U.putFloat(dest + 36L, _t8);
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(-2.0f, _normalz * _normalz, 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
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
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_t2, _t3, -(axisZ * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(axisY, _t1, _t2 * _t4));
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(axisZ, _t1, _t2 * _t3));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_t2, axisY * axisY, _t0));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_t2, _t5, -(axisX * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_t2, _t4, -(axisY * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 36L, Math.fma(axisX, _t1, _t2 * _t5));
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(_t2, axisZ * axisZ, _t0));
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
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
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_t2, _t3, -(_axisz * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_axisy, _t1, _t2 * _t4));
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_axisz, _t1, _t2 * _t3));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_t2, _axisy * _axisy, _t0));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_t2, _t5, -(_axisx * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_t2, _t4, -(_axisy * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 36L, Math.fma(_axisx, _t1, _t2 * _t5));
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(_t2, _axisz * _axisz, _t0));
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
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
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_t7, _t27, -(_t9 * _t28)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, _t8);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _t28);
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_t9, _t26, -(_t8 * _t27)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, _t7);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, _t27);
        UnsafeOpsHolder.U.putFloat(dest + 36L, Math.fma(_t8, _t28, -(_t7 * _t26)));
        UnsafeOpsHolder.U.putFloat(dest + 40L, _t9);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
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
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_t7, _t27, -(_t9 * _t28)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, _t8);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _t28);
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_t9, _t26, -(_t8 * _t27)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, _t7);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, _t27);
        UnsafeOpsHolder.U.putFloat(dest + 36L, Math.fma(_t8, _t28, -(_t7 * _t26)));
        UnsafeOpsHolder.U.putFloat(dest + 40L, _t9);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeRotationQuat_unsafe(long dest, float qX, float qY, float qZ, float qW) {
        float _t0 = qZ * qZ;
        float _t1 = qZ * qW;
        float _t2 = qY * qW;
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(-2.0f, Math.fma(qY, qY, _t0), 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 4L, 2.0f * Math.fma(qX, qY, -_t1));
        UnsafeOpsHolder.U.putFloat(dest + 8L, 2.0f * Math.fma(qX, qZ, _t2));
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 2.0f * Math.fma(qX, qY, _t1));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(-2.0f, Math.fma(qX, qX, _t0), 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 24L, 2.0f * Math.fma(qY, qZ, -(qX * qW)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 2.0f * Math.fma(qX, qZ, -_t2));
        UnsafeOpsHolder.U.putFloat(dest + 36L, 2.0f * Math.fma(qX, qW, qY * qZ));
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(-2.0f, Math.fma(qX, qX, qY * qY), 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
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
        UnsafeOpsHolder.U.putFloat(dest + 4L, 2.0f * Math.fma(_qx, _qy, -_t1));
        UnsafeOpsHolder.U.putFloat(dest + 8L, 2.0f * Math.fma(_qx, _qz, _t2));
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 2.0f * Math.fma(_qx, _qy, _t1));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(-2.0f, Math.fma(_qx, _qx, _t0), 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 24L, 2.0f * Math.fma(_qy, _qz, -(_qx * _qw)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 2.0f * Math.fma(_qx, _qz, -_t2));
        UnsafeOpsHolder.U.putFloat(dest + 36L, 2.0f * Math.fma(_qx, _qw, _qy * _qz));
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(-2.0f, Math.fma(_qx, _qx, _qy * _qy), 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeRotationX_unsafe(long dest, float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        UnsafeOpsHolder.U.putFloat(dest + 0L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _t0);
        UnsafeOpsHolder.U.putFloat(dest + 24L, -_t1);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, _t1);
        UnsafeOpsHolder.U.putFloat(dest + 40L, _t0);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
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
        UnsafeOpsHolder.U.putFloat(dest + 4L, -(_t2 * _t0));
        UnsafeOpsHolder.U.putFloat(dest + 8L, _t3);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_t6, _t1, _t2 * _t5));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_t5, _t1, -(_t6 * _t2)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, -(_t4 * _t0));
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_t4, _t2, -(_t7 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 36L, Math.fma(_t7, _t2, _t4 * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 40L, _t5 * _t0);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
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
        UnsafeOpsHolder.U.putFloat(dest + 4L, -_t2);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _t3 * _t1);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_t6, _t0, _t5 * _t3));
        UnsafeOpsHolder.U.putFloat(dest + 20L, _t4 * _t1);
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_t6, _t3, -(_t5 * _t0)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_t7, _t0, -(_t3 * _t4)));
        UnsafeOpsHolder.U.putFloat(dest + 36L, _t5 * _t1);
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(_t7, _t3, _t4 * _t0));
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeRotationY_unsafe(long dest, float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _t0);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _t1);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, -_t1);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, _t0);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
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
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_t6, _t4, -(_t2 * _t3)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, _t1 * _t5);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _t2 * _t5);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _t5 * _t4);
        UnsafeOpsHolder.U.putFloat(dest + 24L, -_t0);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_t7, _t2, -(_t1 * _t4)));
        UnsafeOpsHolder.U.putFloat(dest + 36L, Math.fma(_t7, _t4, _t1 * _t2));
        UnsafeOpsHolder.U.putFloat(dest + 40L, _t5 * _t3);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
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
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_t2, _t3, -(_t6 * _t5)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_t6, _t2, _t3 * _t5));
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _t4);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _t5 * _t1);
        UnsafeOpsHolder.U.putFloat(dest + 24L, -(_t2 * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, -(_t3 * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 36L, Math.fma(_t7, _t5, _t2 * _t0));
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(_t5, _t0, -(_t7 * _t2)));
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeRotationZ_unsafe(long dest, float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _t0);
        UnsafeOpsHolder.U.putFloat(dest + 4L, -_t1);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _t1);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _t0);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
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
        UnsafeOpsHolder.U.putFloat(dest + 4L, -(_t3 * _t5));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_t6, _t0, _t4 * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_t7, _t4, _t3 * _t0));
        UnsafeOpsHolder.U.putFloat(dest + 20L, _t5 * _t1);
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_t4, _t3, -(_t7 * _t0)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, -(_t4 * _t5));
        UnsafeOpsHolder.U.putFloat(dest + 36L, _t2);
        UnsafeOpsHolder.U.putFloat(dest + 40L, _t5 * _t0);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
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
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_t6, _t3, -(_t4 * _t5)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_t6, _t5, _t3 * _t4));
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _t4 * _t0);
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_t7, _t3, _t5 * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_t7, _t5, -(_t3 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, -_t2);
        UnsafeOpsHolder.U.putFloat(dest + 36L, _t3 * _t0);
        UnsafeOpsHolder.U.putFloat(dest + 40L, _t5 * _t0);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeScaling_unsafe(long dest, float vX, float vY, float vZ) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, vX);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, vY);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, vZ);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeScaling_unsafe(long dest, long v) {
        float _vx = UnsafeOpsHolder.U.getFloat(v + 0L);
        float _vy = UnsafeOpsHolder.U.getFloat(v + 4L);
        float _vz = UnsafeOpsHolder.U.getFloat(v + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _vx);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _vy);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, _vz);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeScaling_unsafe(long dest, float s) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, s);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, s);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, s);
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long makeTranslation_unsafe(long dest, float vX, float vY, float vZ) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, vX);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, vY);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, vZ);
        return dest;
    }

    public static long makeTranslation_unsafe(long dest, long v) {
        float _vx = UnsafeOpsHolder.U.getFloat(v + 0L);
        float _vy = UnsafeOpsHolder.U.getFloat(v + 4L);
        float _vz = UnsafeOpsHolder.U.getFloat(v + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _vx);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, _vy);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 36L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 40L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 44L, _vz);
        return dest;
    }

    public static long mapXYZ_unsafe(long dest, long src) {
        for (int _i = 0; _i < 12; _i++) {
            float _eself = UnsafeOpsHolder.U.getFloat(src + _i * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _i * 4L, _eself);
        }
        return dest;
    }

    public static long mapXYnZ_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, _eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, _eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, -_eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapXZY_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, _eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, _eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, _eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapXZnY_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, _eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, _eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, -_eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapXnYZ_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, _eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, -_eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, _eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapXnYnZ_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, _eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, -_eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, -_eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapXnZY_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, _eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, -_eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, _eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapXnZnY_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, _eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, -_eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, -_eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapYXZ_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, _eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, _eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, _eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapYXnZ_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, _eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, _eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, -_eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapYZX_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, _eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, _eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, _eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapYZnX_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, _eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, _eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, -_eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapYnXZ_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, _eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, -_eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, _eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapYnXnZ_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, _eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, -_eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, -_eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapYnZX_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, _eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, -_eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, _eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapYnZnX_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, _eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, -_eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, -_eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapZXY_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, _eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, _eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, _eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapZXnY_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, _eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, _eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, -_eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapZYX_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, _eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, _eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, _eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapZYnX_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, _eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, _eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, -_eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapZnXY_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, _eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, -_eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, _eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapZnXnY_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, _eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, -_eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, -_eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapZnYX_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, _eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, -_eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, _eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapZnYnX_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, _eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, -_eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, -_eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapnXYZ_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, -_eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, _eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, _eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapnXYnZ_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, -_eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, _eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, -_eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapnXZY_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, -_eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, _eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, _eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapnXZnY_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, -_eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, _eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, -_eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapnXnYZ_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, -_eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, -_eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, _eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapnXnYnZ_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, -_eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, -_eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, -_eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapnXnZY_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, -_eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, -_eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, _eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapnXnZnY_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, -_eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, -_eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, -_eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapnYXZ_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, -_eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, _eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, _eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapnYXnZ_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, -_eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, _eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, -_eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapnYZX_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, -_eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, _eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, _eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapnYZnX_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, -_eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, _eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, -_eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapnYnXZ_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, -_eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, -_eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, _eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapnYnXnZ_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, -_eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, -_eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, -_eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapnYnZX_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, -_eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, -_eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, _eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapnYnZnX_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, -_eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, -_eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, -_eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapnZXY_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, -_eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, _eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, _eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapnZXnY_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, -_eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, _eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, -_eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapnZYX_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, -_eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, _eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, _eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapnZYnX_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, -_eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, _eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, -_eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapnZnXY_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, -_eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, -_eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, _eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapnZnXnY_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, -_eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, -_eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, -_eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapnZnYX_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, -_eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, -_eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, _eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long mapnZnYnX_unsafe(long dest, long src) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, -_eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, -_eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, -_eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long preRotateAround_unsafe(long dest, long src, float rotX, float rotY, float rotZ, float rotW, float pivotX, float pivotY, float pivotZ) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        float _t0 = -pivotX;
        float _t1 = -pivotY;
        float _t2 = -pivotZ;
        float _t3 = rotY * rotW;
        float _t4 = rotZ * rotZ;
        float _t5 = rotZ * rotW;
        float _t21 = 2.0f * Math.fma(rotX, rotZ, _t3);
        float _t22 = 2.0f * Math.fma(rotX, rotY, _t5);
        float _t23 = 2.0f * Math.fma(rotX, rotW, rotY * rotZ);
        float _t24 = 2.0f * Math.fma(rotX, rotY, -_t5);
        float _t25 = 2.0f * Math.fma(rotY, rotZ, -(rotX * rotW));
        float _t26 = 2.0f * Math.fma(rotX, rotZ, -_t3);
        float _t27 = Math.fma(-2.0f, Math.fma(rotY, rotY, _t4), 1.0f);
        float _t28 = Math.fma(-2.0f, Math.fma(rotX, rotX, _t4), 1.0f);
        float _t29 = Math.fma(-2.0f, Math.fma(rotX, rotX, rotY * rotY), 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_self20, _t21, Math.fma(_self00, _t27, _self10 * _t24)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self21, _t21, Math.fma(_self01, _t27, _self11 * _t24)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self22, _t21, Math.fma(_self02, _t27, _self12 * _t24)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_t0, _t27, Math.fma(_t1, _t24, Math.fma(_t2, _t21, Math.fma(_self03, _t27, Math.fma(_self13, _t24, Math.fma(_self23, _t21, pivotX)))))));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self20, _t25, Math.fma(_self00, _t22, _self10 * _t28)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self21, _t25, Math.fma(_self01, _t22, _self11 * _t28)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self22, _t25, Math.fma(_self02, _t22, _self12 * _t28)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_t0, _t22, Math.fma(_t1, _t28, Math.fma(_t2, _t25, Math.fma(_self03, _t22, Math.fma(_self13, _t28, Math.fma(_self23, _t25, pivotY)))))));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self20, _t29, Math.fma(_self00, _t26, _self10 * _t23)));
        UnsafeOpsHolder.U.putFloat(dest + 36L, Math.fma(_self21, _t29, Math.fma(_self01, _t26, _self11 * _t23)));
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(_self22, _t29, Math.fma(_self02, _t26, _self12 * _t23)));
        UnsafeOpsHolder.U.putFloat(dest + 44L, Math.fma(_t0, _t26, Math.fma(_t1, _t23, Math.fma(_t2, _t29, Math.fma(_self03, _t26, Math.fma(_self13, _t23, Math.fma(_self23, _t29, pivotZ)))))));
        return dest;
    }

    public static long preRotateAround_unsafe(long dest, long src, long rot, long pivot) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        float _rotx = UnsafeOpsHolder.U.getFloat(rot + 0L);
        float _roty = UnsafeOpsHolder.U.getFloat(rot + 4L);
        float _rotz = UnsafeOpsHolder.U.getFloat(rot + 8L);
        float _rotw = UnsafeOpsHolder.U.getFloat(rot + 12L);
        float _pivotx = UnsafeOpsHolder.U.getFloat(pivot + 0L);
        float _pivoty = UnsafeOpsHolder.U.getFloat(pivot + 4L);
        float _pivotz = UnsafeOpsHolder.U.getFloat(pivot + 8L);
        float _t0 = -_pivotx;
        float _t1 = -_pivoty;
        float _t2 = -_pivotz;
        float _t3 = _roty * _rotw;
        float _t4 = _rotz * _rotz;
        float _t5 = _rotz * _rotw;
        float _t21 = 2.0f * Math.fma(_rotx, _rotz, _t3);
        float _t22 = 2.0f * Math.fma(_rotx, _roty, _t5);
        float _t23 = 2.0f * Math.fma(_rotx, _rotw, _roty * _rotz);
        float _t24 = 2.0f * Math.fma(_rotx, _roty, -_t5);
        float _t25 = 2.0f * Math.fma(_roty, _rotz, -(_rotx * _rotw));
        float _t26 = 2.0f * Math.fma(_rotx, _rotz, -_t3);
        float _t27 = Math.fma(-2.0f, Math.fma(_roty, _roty, _t4), 1.0f);
        float _t28 = Math.fma(-2.0f, Math.fma(_rotx, _rotx, _t4), 1.0f);
        float _t29 = Math.fma(-2.0f, Math.fma(_rotx, _rotx, _roty * _roty), 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_self20, _t21, Math.fma(_self00, _t27, _self10 * _t24)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self21, _t21, Math.fma(_self01, _t27, _self11 * _t24)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self22, _t21, Math.fma(_self02, _t27, _self12 * _t24)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_t0, _t27, Math.fma(_t1, _t24, Math.fma(_t2, _t21, Math.fma(_self03, _t27, Math.fma(_self13, _t24, Math.fma(_self23, _t21, _pivotx)))))));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self20, _t25, Math.fma(_self00, _t22, _self10 * _t28)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self21, _t25, Math.fma(_self01, _t22, _self11 * _t28)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self22, _t25, Math.fma(_self02, _t22, _self12 * _t28)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_t0, _t22, Math.fma(_t1, _t28, Math.fma(_t2, _t25, Math.fma(_self03, _t22, Math.fma(_self13, _t28, Math.fma(_self23, _t25, _pivoty)))))));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self20, _t29, Math.fma(_self00, _t26, _self10 * _t23)));
        UnsafeOpsHolder.U.putFloat(dest + 36L, Math.fma(_self21, _t29, Math.fma(_self01, _t26, _self11 * _t23)));
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(_self22, _t29, Math.fma(_self02, _t26, _self12 * _t23)));
        UnsafeOpsHolder.U.putFloat(dest + 44L, Math.fma(_t0, _t26, Math.fma(_t1, _t23, Math.fma(_t2, _t29, Math.fma(_self03, _t26, Math.fma(_self13, _t23, Math.fma(_self23, _t29, _pivotz)))))));
        return dest;
    }

    public static long preRotateAxis_unsafe(long dest, long src, float angle, float axisX, float axisY, float axisZ) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
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
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self21, _t21, Math.fma(_self01, _t18, _self11 * _t24)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self22, _t21, Math.fma(_self02, _t18, _self12 * _t24)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_self23, _t21, Math.fma(_self03, _t18, _self13 * _t24)));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self20, _t25, Math.fma(_self00, _t22, _self10 * _t19)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self21, _t25, Math.fma(_self01, _t22, _self11 * _t19)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self22, _t25, Math.fma(_self02, _t22, _self12 * _t19)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_self23, _t25, Math.fma(_self03, _t22, _self13 * _t19)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self20, _t20, Math.fma(_self00, _t26, _self10 * _t23)));
        UnsafeOpsHolder.U.putFloat(dest + 36L, Math.fma(_self21, _t20, Math.fma(_self01, _t26, _self11 * _t23)));
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(_self22, _t20, Math.fma(_self02, _t26, _self12 * _t23)));
        UnsafeOpsHolder.U.putFloat(dest + 44L, Math.fma(_self23, _t20, Math.fma(_self03, _t26, _self13 * _t23)));
        return dest;
    }

    public static long preRotateAxis_unsafe(long dest, long src, long axis, float angle) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
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
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self21, _t21, Math.fma(_self01, _t18, _self11 * _t24)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self22, _t21, Math.fma(_self02, _t18, _self12 * _t24)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_self23, _t21, Math.fma(_self03, _t18, _self13 * _t24)));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self20, _t25, Math.fma(_self00, _t22, _self10 * _t19)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self21, _t25, Math.fma(_self01, _t22, _self11 * _t19)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self22, _t25, Math.fma(_self02, _t22, _self12 * _t19)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_self23, _t25, Math.fma(_self03, _t22, _self13 * _t19)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self20, _t20, Math.fma(_self00, _t26, _self10 * _t23)));
        UnsafeOpsHolder.U.putFloat(dest + 36L, Math.fma(_self21, _t20, Math.fma(_self01, _t26, _self11 * _t23)));
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(_self22, _t20, Math.fma(_self02, _t26, _self12 * _t23)));
        UnsafeOpsHolder.U.putFloat(dest + 44L, Math.fma(_self23, _t20, Math.fma(_self03, _t26, _self13 * _t23)));
        return dest;
    }

    public static long preRotateQuat_unsafe(long dest, long src, float qX, float qY, float qZ, float qW) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        float _t0 = qY * qW;
        float _t1 = qZ * qZ;
        float _t2 = qZ * qW;
        float _t18 = 2.0f * Math.fma(qX, qZ, _t0);
        float _t19 = 2.0f * Math.fma(qX, qY, _t2);
        float _t20 = 2.0f * Math.fma(qX, qW, qY * qZ);
        float _t21 = 2.0f * Math.fma(qX, qY, -_t2);
        float _t22 = 2.0f * Math.fma(qY, qZ, -(qX * qW));
        float _t23 = 2.0f * Math.fma(qX, qZ, -_t0);
        float _t24 = Math.fma(-2.0f, Math.fma(qY, qY, _t1), 1.0f);
        float _t25 = Math.fma(-2.0f, Math.fma(qX, qX, _t1), 1.0f);
        float _t26 = Math.fma(-2.0f, Math.fma(qX, qX, qY * qY), 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_self20, _t18, Math.fma(_self00, _t24, _self10 * _t21)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self21, _t18, Math.fma(_self01, _t24, _self11 * _t21)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self22, _t18, Math.fma(_self02, _t24, _self12 * _t21)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_self23, _t18, Math.fma(_self03, _t24, _self13 * _t21)));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self20, _t22, Math.fma(_self00, _t19, _self10 * _t25)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self21, _t22, Math.fma(_self01, _t19, _self11 * _t25)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self22, _t22, Math.fma(_self02, _t19, _self12 * _t25)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_self23, _t22, Math.fma(_self03, _t19, _self13 * _t25)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self20, _t26, Math.fma(_self00, _t23, _self10 * _t20)));
        UnsafeOpsHolder.U.putFloat(dest + 36L, Math.fma(_self21, _t26, Math.fma(_self01, _t23, _self11 * _t20)));
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(_self22, _t26, Math.fma(_self02, _t23, _self12 * _t20)));
        UnsafeOpsHolder.U.putFloat(dest + 44L, Math.fma(_self23, _t26, Math.fma(_self03, _t23, _self13 * _t20)));
        return dest;
    }

    public static long preRotateQuat_unsafe(long dest, long src, long q) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        float _qx = UnsafeOpsHolder.U.getFloat(q + 0L);
        float _qy = UnsafeOpsHolder.U.getFloat(q + 4L);
        float _qz = UnsafeOpsHolder.U.getFloat(q + 8L);
        float _qw = UnsafeOpsHolder.U.getFloat(q + 12L);
        float _t0 = _qy * _qw;
        float _t1 = _qz * _qz;
        float _t2 = _qz * _qw;
        float _t18 = 2.0f * Math.fma(_qx, _qz, _t0);
        float _t19 = 2.0f * Math.fma(_qx, _qy, _t2);
        float _t20 = 2.0f * Math.fma(_qx, _qw, _qy * _qz);
        float _t21 = 2.0f * Math.fma(_qx, _qy, -_t2);
        float _t22 = 2.0f * Math.fma(_qy, _qz, -(_qx * _qw));
        float _t23 = 2.0f * Math.fma(_qx, _qz, -_t0);
        float _t24 = Math.fma(-2.0f, Math.fma(_qy, _qy, _t1), 1.0f);
        float _t25 = Math.fma(-2.0f, Math.fma(_qx, _qx, _t1), 1.0f);
        float _t26 = Math.fma(-2.0f, Math.fma(_qx, _qx, _qy * _qy), 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_self20, _t18, Math.fma(_self00, _t24, _self10 * _t21)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self21, _t18, Math.fma(_self01, _t24, _self11 * _t21)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self22, _t18, Math.fma(_self02, _t24, _self12 * _t21)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_self23, _t18, Math.fma(_self03, _t24, _self13 * _t21)));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self20, _t22, Math.fma(_self00, _t19, _self10 * _t25)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self21, _t22, Math.fma(_self01, _t19, _self11 * _t25)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self22, _t22, Math.fma(_self02, _t19, _self12 * _t25)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_self23, _t22, Math.fma(_self03, _t19, _self13 * _t25)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self20, _t26, Math.fma(_self00, _t23, _self10 * _t20)));
        UnsafeOpsHolder.U.putFloat(dest + 36L, Math.fma(_self21, _t26, Math.fma(_self01, _t23, _self11 * _t20)));
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(_self22, _t26, Math.fma(_self02, _t23, _self12 * _t20)));
        UnsafeOpsHolder.U.putFloat(dest + 44L, Math.fma(_self23, _t26, Math.fma(_self03, _t23, _self13 * _t20)));
        return dest;
    }

    public static long preRotateX_unsafe(long dest, long src, float angle) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self01);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self02);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self03);
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self10, _t0, -(_self20 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self11, _t0, -(_self21 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self12, _t0, -(_self22 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_self13, _t0, -(_self23 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self10, _t1, _self20 * _t0));
        UnsafeOpsHolder.U.putFloat(dest + 36L, Math.fma(_self11, _t1, _self21 * _t0));
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(_self12, _t1, _self22 * _t0));
        UnsafeOpsHolder.U.putFloat(dest + 44L, Math.fma(_self13, _t1, _self23 * _t0));
        return dest;
    }

    public static long preRotateY_unsafe(long dest, long src, float angle) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_self00, _t0, _self20 * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self01, _t0, _self21 * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self02, _t0, _self22 * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_self03, _t0, _self23 * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 16L, _self10);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _self11);
        UnsafeOpsHolder.U.putFloat(dest + 24L, _self12);
        UnsafeOpsHolder.U.putFloat(dest + 28L, _self13);
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self20, _t0, -(_self00 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 36L, Math.fma(_self21, _t0, -(_self01 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(_self22, _t0, -(_self02 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 44L, Math.fma(_self23, _t0, -(_self03 * _t1)));
        return dest;
    }

    public static long preRotateZ_unsafe(long dest, long src, float angle) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_self00, _t0, -(_self10 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self01, _t0, -(_self11 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self02, _t0, -(_self12 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_self03, _t0, -(_self13 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self00, _t1, _self10 * _t0));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self01, _t1, _self11 * _t0));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self02, _t1, _self12 * _t0));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_self03, _t1, _self13 * _t0));
        UnsafeOpsHolder.U.putFloat(dest + 32L, _self20);
        UnsafeOpsHolder.U.putFloat(dest + 36L, _self21);
        UnsafeOpsHolder.U.putFloat(dest + 40L, _self22);
        UnsafeOpsHolder.U.putFloat(dest + 44L, _self23);
        return dest;
    }

    public static long preScale_unsafe(long dest, long src, float vX, float vY, float vZ) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self00 * vX);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self01 * vX);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self02 * vX);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self03 * vX);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _self10 * vY);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _self11 * vY);
        UnsafeOpsHolder.U.putFloat(dest + 24L, _self12 * vY);
        UnsafeOpsHolder.U.putFloat(dest + 28L, _self13 * vY);
        UnsafeOpsHolder.U.putFloat(dest + 32L, _self20 * vZ);
        UnsafeOpsHolder.U.putFloat(dest + 36L, _self21 * vZ);
        UnsafeOpsHolder.U.putFloat(dest + 40L, _self22 * vZ);
        UnsafeOpsHolder.U.putFloat(dest + 44L, _self23 * vZ);
        return dest;
    }

    public static long preScale_unsafe(long dest, long src, long v) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        float _vx = UnsafeOpsHolder.U.getFloat(v + 0L);
        float _vy = UnsafeOpsHolder.U.getFloat(v + 4L);
        float _vz = UnsafeOpsHolder.U.getFloat(v + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self00 * _vx);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self01 * _vx);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self02 * _vx);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self03 * _vx);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _self10 * _vy);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _self11 * _vy);
        UnsafeOpsHolder.U.putFloat(dest + 24L, _self12 * _vy);
        UnsafeOpsHolder.U.putFloat(dest + 28L, _self13 * _vy);
        UnsafeOpsHolder.U.putFloat(dest + 32L, _self20 * _vz);
        UnsafeOpsHolder.U.putFloat(dest + 36L, _self21 * _vz);
        UnsafeOpsHolder.U.putFloat(dest + 40L, _self22 * _vz);
        UnsafeOpsHolder.U.putFloat(dest + 44L, _self23 * _vz);
        return dest;
    }

    public static long preScale_unsafe(long dest, long src, float s) {
        for (int _i = 0; _i < 12; _i++) {
            float _eself = UnsafeOpsHolder.U.getFloat(src + _i * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _i * 4L, s * _eself);
        }
        return dest;
    }

    public static long preScaleAround_unsafe(long dest, long src, float s, float pivotX, float pivotY, float pivotZ) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, s * _self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, s * _self01);
        UnsafeOpsHolder.U.putFloat(dest + 8L, s * _self02);
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(-s, pivotX, Math.fma(s, _self03, pivotX)));
        UnsafeOpsHolder.U.putFloat(dest + 16L, s * _self10);
        UnsafeOpsHolder.U.putFloat(dest + 20L, s * _self11);
        UnsafeOpsHolder.U.putFloat(dest + 24L, s * _self12);
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(-s, pivotY, Math.fma(s, _self13, pivotY)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, s * _self20);
        UnsafeOpsHolder.U.putFloat(dest + 36L, s * _self21);
        UnsafeOpsHolder.U.putFloat(dest + 40L, s * _self22);
        UnsafeOpsHolder.U.putFloat(dest + 44L, Math.fma(-s, pivotZ, Math.fma(s, _self23, pivotZ)));
        return dest;
    }

    public static long preScaleAround_unsafe(long dest, long src, long pivot, float s) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        float _pivotx = UnsafeOpsHolder.U.getFloat(pivot + 0L);
        float _pivoty = UnsafeOpsHolder.U.getFloat(pivot + 4L);
        float _pivotz = UnsafeOpsHolder.U.getFloat(pivot + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, s * _self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, s * _self01);
        UnsafeOpsHolder.U.putFloat(dest + 8L, s * _self02);
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(-s, _pivotx, Math.fma(s, _self03, _pivotx)));
        UnsafeOpsHolder.U.putFloat(dest + 16L, s * _self10);
        UnsafeOpsHolder.U.putFloat(dest + 20L, s * _self11);
        UnsafeOpsHolder.U.putFloat(dest + 24L, s * _self12);
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(-s, _pivoty, Math.fma(s, _self13, _pivoty)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, s * _self20);
        UnsafeOpsHolder.U.putFloat(dest + 36L, s * _self21);
        UnsafeOpsHolder.U.putFloat(dest + 40L, s * _self22);
        UnsafeOpsHolder.U.putFloat(dest + 44L, Math.fma(-s, _pivotz, Math.fma(s, _self23, _pivotz)));
        return dest;
    }

    public static long preScaleAround_unsafe(long dest, long src, float sX, float sY, float sZ, float pivotX, float pivotY, float pivotZ) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, sX * _self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, sX * _self01);
        UnsafeOpsHolder.U.putFloat(dest + 8L, sX * _self02);
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(-pivotX, sX, Math.fma(sX, _self03, pivotX)));
        UnsafeOpsHolder.U.putFloat(dest + 16L, sY * _self10);
        UnsafeOpsHolder.U.putFloat(dest + 20L, sY * _self11);
        UnsafeOpsHolder.U.putFloat(dest + 24L, sY * _self12);
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(-pivotY, sY, Math.fma(sY, _self13, pivotY)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, sZ * _self20);
        UnsafeOpsHolder.U.putFloat(dest + 36L, sZ * _self21);
        UnsafeOpsHolder.U.putFloat(dest + 40L, sZ * _self22);
        UnsafeOpsHolder.U.putFloat(dest + 44L, Math.fma(-pivotZ, sZ, Math.fma(sZ, _self23, pivotZ)));
        return dest;
    }

    public static long preScaleAround_unsafe(long dest, long src, long s, long pivot) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        float _sx = UnsafeOpsHolder.U.getFloat(s + 0L);
        float _sy = UnsafeOpsHolder.U.getFloat(s + 4L);
        float _sz = UnsafeOpsHolder.U.getFloat(s + 8L);
        float _pivotx = UnsafeOpsHolder.U.getFloat(pivot + 0L);
        float _pivoty = UnsafeOpsHolder.U.getFloat(pivot + 4L);
        float _pivotz = UnsafeOpsHolder.U.getFloat(pivot + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _sx * _self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _sx * _self01);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _sx * _self02);
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(-_pivotx, _sx, Math.fma(_sx, _self03, _pivotx)));
        UnsafeOpsHolder.U.putFloat(dest + 16L, _sy * _self10);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _sy * _self11);
        UnsafeOpsHolder.U.putFloat(dest + 24L, _sy * _self12);
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(-_pivoty, _sy, Math.fma(_sy, _self13, _pivoty)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, _sz * _self20);
        UnsafeOpsHolder.U.putFloat(dest + 36L, _sz * _self21);
        UnsafeOpsHolder.U.putFloat(dest + 40L, _sz * _self22);
        UnsafeOpsHolder.U.putFloat(dest + 44L, Math.fma(-_pivotz, _sz, Math.fma(_sz, _self23, _pivotz)));
        return dest;
    }

    public static long preTranslate_unsafe(long dest, long src, float vX, float vY, float vZ) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self01);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self02);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self03 + vX);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _self10);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _self11);
        UnsafeOpsHolder.U.putFloat(dest + 24L, _self12);
        UnsafeOpsHolder.U.putFloat(dest + 28L, _self13 + vY);
        UnsafeOpsHolder.U.putFloat(dest + 32L, _self20);
        UnsafeOpsHolder.U.putFloat(dest + 36L, _self21);
        UnsafeOpsHolder.U.putFloat(dest + 40L, _self22);
        UnsafeOpsHolder.U.putFloat(dest + 44L, _self23 + vZ);
        return dest;
    }

    public static long preTranslate_unsafe(long dest, long src, long v) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        float _vx = UnsafeOpsHolder.U.getFloat(v + 0L);
        float _vy = UnsafeOpsHolder.U.getFloat(v + 4L);
        float _vz = UnsafeOpsHolder.U.getFloat(v + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self01);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self02);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self03 + _vx);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _self10);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _self11);
        UnsafeOpsHolder.U.putFloat(dest + 24L, _self12);
        UnsafeOpsHolder.U.putFloat(dest + 28L, _self13 + _vy);
        UnsafeOpsHolder.U.putFloat(dest + 32L, _self20);
        UnsafeOpsHolder.U.putFloat(dest + 36L, _self21);
        UnsafeOpsHolder.U.putFloat(dest + 40L, _self22);
        UnsafeOpsHolder.U.putFloat(dest + 44L, _self23 + _vz);
        return dest;
    }

    public static long reflect_unsafe(long dest, long src, float normalX, float normalY, float normalZ) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        float _t0 = -_self02;
        float _t1 = -_self12;
        float _t2 = -_self22;
        float _t9 = 2.0f * normalX * normalZ;
        float _t10 = 2.0f * normalX * normalY;
        float _t11 = 2.0f * normalY * normalZ;
        float _t12 = Math.fma(-2.0f, normalX * normalX, 1.0f);
        float _t13 = Math.fma(-2.0f, normalY * normalY, 1.0f);
        float _t14 = Math.fma(-2.0f, normalZ * normalZ, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_t0, _t9, Math.fma(_self00, _t12, -(_self01 * _t10))));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_t0, _t11, Math.fma(_self01, _t13, -(_self00 * _t10))));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self02, _t14, Math.fma(-_self01, _t11, -(_self00 * _t9))));
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self03);
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_t1, _t9, Math.fma(_self10, _t12, -(_self11 * _t10))));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_t1, _t11, Math.fma(_self11, _t13, -(_self10 * _t10))));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self12, _t14, Math.fma(-_self11, _t11, -(_self10 * _t9))));
        UnsafeOpsHolder.U.putFloat(dest + 28L, _self13);
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_t2, _t9, Math.fma(_self20, _t12, -(_self21 * _t10))));
        UnsafeOpsHolder.U.putFloat(dest + 36L, Math.fma(_t2, _t11, Math.fma(_self21, _t13, -(_self20 * _t10))));
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(_self22, _t14, Math.fma(-_self21, _t11, -(_self20 * _t9))));
        UnsafeOpsHolder.U.putFloat(dest + 44L, _self23);
        return dest;
    }

    public static long reflect_unsafe(long dest, long src, long normal) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        float _normalx = UnsafeOpsHolder.U.getFloat(normal + 0L);
        float _normaly = UnsafeOpsHolder.U.getFloat(normal + 4L);
        float _normalz = UnsafeOpsHolder.U.getFloat(normal + 8L);
        float _t0 = -_self02;
        float _t1 = -_self12;
        float _t2 = -_self22;
        float _t9 = 2.0f * _normalx * _normalz;
        float _t10 = 2.0f * _normalx * _normaly;
        float _t11 = 2.0f * _normaly * _normalz;
        float _t12 = Math.fma(-2.0f, _normalx * _normalx, 1.0f);
        float _t13 = Math.fma(-2.0f, _normaly * _normaly, 1.0f);
        float _t14 = Math.fma(-2.0f, _normalz * _normalz, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_t0, _t9, Math.fma(_self00, _t12, -(_self01 * _t10))));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_t0, _t11, Math.fma(_self01, _t13, -(_self00 * _t10))));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self02, _t14, Math.fma(-_self01, _t11, -(_self00 * _t9))));
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self03);
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_t1, _t9, Math.fma(_self10, _t12, -(_self11 * _t10))));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_t1, _t11, Math.fma(_self11, _t13, -(_self10 * _t10))));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self12, _t14, Math.fma(-_self11, _t11, -(_self10 * _t9))));
        UnsafeOpsHolder.U.putFloat(dest + 28L, _self13);
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_t2, _t9, Math.fma(_self20, _t12, -(_self21 * _t10))));
        UnsafeOpsHolder.U.putFloat(dest + 36L, Math.fma(_t2, _t11, Math.fma(_self21, _t13, -(_self20 * _t10))));
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(_self22, _t14, Math.fma(-_self21, _t11, -(_self20 * _t9))));
        UnsafeOpsHolder.U.putFloat(dest + 44L, _self23);
        return dest;
    }

    public static long rotateAround_unsafe(long dest, long src, float rotX, float rotY, float rotZ, float rotW, float pivotX, float pivotY, float pivotZ) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
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
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_self02, _t24, Math.fma(_self00, _t27, _self01 * _t21)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self02, _t22, Math.fma(_self00, _t25, _self01 * _t28)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self02, _t29, Math.fma(_self00, _t23, _self01 * _t26)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_self00, _t36, Math.fma(_self01, _t37, Math.fma(_self02, _t38, _self03))));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self12, _t24, Math.fma(_self10, _t27, _self11 * _t21)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self12, _t22, Math.fma(_self10, _t25, _self11 * _t28)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self12, _t29, Math.fma(_self10, _t23, _self11 * _t26)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_self10, _t36, Math.fma(_self11, _t37, Math.fma(_self12, _t38, _self13))));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self22, _t24, Math.fma(_self20, _t27, _self21 * _t21)));
        UnsafeOpsHolder.U.putFloat(dest + 36L, Math.fma(_self22, _t22, Math.fma(_self20, _t25, _self21 * _t28)));
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(_self22, _t29, Math.fma(_self20, _t23, _self21 * _t26)));
        UnsafeOpsHolder.U.putFloat(dest + 44L, Math.fma(_self20, _t36, Math.fma(_self21, _t37, Math.fma(_self22, _t38, _self23))));
        return dest;
    }

    public static long rotateAround_unsafe(long dest, long src, long rot, long pivot) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        float _rotx = UnsafeOpsHolder.U.getFloat(rot + 0L);
        float _roty = UnsafeOpsHolder.U.getFloat(rot + 4L);
        float _rotz = UnsafeOpsHolder.U.getFloat(rot + 8L);
        float _rotw = UnsafeOpsHolder.U.getFloat(rot + 12L);
        float _pivotx = UnsafeOpsHolder.U.getFloat(pivot + 0L);
        float _pivoty = UnsafeOpsHolder.U.getFloat(pivot + 4L);
        float _pivotz = UnsafeOpsHolder.U.getFloat(pivot + 8L);
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
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_self02, _t24, Math.fma(_self00, _t27, _self01 * _t21)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self02, _t22, Math.fma(_self00, _t25, _self01 * _t28)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self02, _t29, Math.fma(_self00, _t23, _self01 * _t26)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_self00, _t36, Math.fma(_self01, _t37, Math.fma(_self02, _t38, _self03))));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self12, _t24, Math.fma(_self10, _t27, _self11 * _t21)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self12, _t22, Math.fma(_self10, _t25, _self11 * _t28)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self12, _t29, Math.fma(_self10, _t23, _self11 * _t26)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_self10, _t36, Math.fma(_self11, _t37, Math.fma(_self12, _t38, _self13))));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self22, _t24, Math.fma(_self20, _t27, _self21 * _t21)));
        UnsafeOpsHolder.U.putFloat(dest + 36L, Math.fma(_self22, _t22, Math.fma(_self20, _t25, _self21 * _t28)));
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(_self22, _t29, Math.fma(_self20, _t23, _self21 * _t26)));
        UnsafeOpsHolder.U.putFloat(dest + 44L, Math.fma(_self20, _t36, Math.fma(_self21, _t37, Math.fma(_self22, _t38, _self23))));
        return dest;
    }

    public static long rotateAxis_unsafe(long dest, long src, float angle, float axisX, float axisY, float axisZ) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
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
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self02, _t22, Math.fma(_self00, _t25, _self01 * _t19)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self02, _t20, Math.fma(_self00, _t23, _self01 * _t26)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self03);
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self12, _t24, Math.fma(_self10, _t18, _self11 * _t21)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self12, _t22, Math.fma(_self10, _t25, _self11 * _t19)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self12, _t20, Math.fma(_self10, _t23, _self11 * _t26)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, _self13);
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self22, _t24, Math.fma(_self20, _t18, _self21 * _t21)));
        UnsafeOpsHolder.U.putFloat(dest + 36L, Math.fma(_self22, _t22, Math.fma(_self20, _t25, _self21 * _t19)));
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(_self22, _t20, Math.fma(_self20, _t23, _self21 * _t26)));
        UnsafeOpsHolder.U.putFloat(dest + 44L, _self23);
        return dest;
    }

    public static long rotateAxis_unsafe(long dest, long src, long axis, float angle) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
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
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self02, _t22, Math.fma(_self00, _t25, _self01 * _t19)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self02, _t20, Math.fma(_self00, _t23, _self01 * _t26)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self03);
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self12, _t24, Math.fma(_self10, _t18, _self11 * _t21)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self12, _t22, Math.fma(_self10, _t25, _self11 * _t19)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self12, _t20, Math.fma(_self10, _t23, _self11 * _t26)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, _self13);
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self22, _t24, Math.fma(_self20, _t18, _self21 * _t21)));
        UnsafeOpsHolder.U.putFloat(dest + 36L, Math.fma(_self22, _t22, Math.fma(_self20, _t25, _self21 * _t19)));
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(_self22, _t20, Math.fma(_self20, _t23, _self21 * _t26)));
        UnsafeOpsHolder.U.putFloat(dest + 44L, _self23);
        return dest;
    }

    public static long rotateQuat_unsafe(long dest, long src, float qX, float qY, float qZ, float qW) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
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
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_self02, _t21, Math.fma(_self00, _t24, _self01 * _t18)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self02, _t19, Math.fma(_self00, _t22, _self01 * _t25)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self02, _t26, Math.fma(_self00, _t20, _self01 * _t23)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self03);
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self12, _t21, Math.fma(_self10, _t24, _self11 * _t18)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self12, _t19, Math.fma(_self10, _t22, _self11 * _t25)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self12, _t26, Math.fma(_self10, _t20, _self11 * _t23)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, _self13);
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self22, _t21, Math.fma(_self20, _t24, _self21 * _t18)));
        UnsafeOpsHolder.U.putFloat(dest + 36L, Math.fma(_self22, _t19, Math.fma(_self20, _t22, _self21 * _t25)));
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(_self22, _t26, Math.fma(_self20, _t20, _self21 * _t23)));
        UnsafeOpsHolder.U.putFloat(dest + 44L, _self23);
        return dest;
    }

    public static long rotateQuat_unsafe(long dest, long src, long q) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        float _qx = UnsafeOpsHolder.U.getFloat(q + 0L);
        float _qy = UnsafeOpsHolder.U.getFloat(q + 4L);
        float _qz = UnsafeOpsHolder.U.getFloat(q + 8L);
        float _qw = UnsafeOpsHolder.U.getFloat(q + 12L);
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
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_self02, _t21, Math.fma(_self00, _t24, _self01 * _t18)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self02, _t19, Math.fma(_self00, _t22, _self01 * _t25)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self02, _t26, Math.fma(_self00, _t20, _self01 * _t23)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self03);
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self12, _t21, Math.fma(_self10, _t24, _self11 * _t18)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self12, _t19, Math.fma(_self10, _t22, _self11 * _t25)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self12, _t26, Math.fma(_self10, _t20, _self11 * _t23)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, _self13);
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self22, _t21, Math.fma(_self20, _t24, _self21 * _t18)));
        UnsafeOpsHolder.U.putFloat(dest + 36L, Math.fma(_self22, _t19, Math.fma(_self20, _t22, _self21 * _t25)));
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(_self22, _t26, Math.fma(_self20, _t20, _self21 * _t23)));
        UnsafeOpsHolder.U.putFloat(dest + 44L, _self23);
        return dest;
    }

    public static long rotateX_unsafe(long dest, long src, float angle) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self01, _t0, _self02 * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self02, _t0, -(_self01 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self03);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _self10);
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self11, _t0, _self12 * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self12, _t0, -(_self11 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, _self13);
        UnsafeOpsHolder.U.putFloat(dest + 32L, _self20);
        UnsafeOpsHolder.U.putFloat(dest + 36L, Math.fma(_self21, _t0, _self22 * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(_self22, _t0, -(_self21 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 44L, _self23);
        return dest;
    }

    public static long rotateXYZ_unsafe(long dest, long src, float angleX, float angleY, float angleZ) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
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
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self02, _t19, Math.fma(_self01, _t21, -(_self00 * _t11))));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self02, _t12, Math.fma(_self00, _t2, -(_self01 * _t13))));
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self03);
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self12, _t20, Math.fma(_self10, _t7, _self11 * _t18)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self12, _t19, Math.fma(_self11, _t21, -(_self10 * _t11))));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self12, _t12, Math.fma(_self10, _t2, -(_self11 * _t13))));
        UnsafeOpsHolder.U.putFloat(dest + 28L, _self13);
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self22, _t20, Math.fma(_self20, _t7, _self21 * _t18)));
        UnsafeOpsHolder.U.putFloat(dest + 36L, Math.fma(_self22, _t19, Math.fma(_self21, _t21, -(_self20 * _t11))));
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(_self22, _t12, Math.fma(_self20, _t2, -(_self21 * _t13))));
        UnsafeOpsHolder.U.putFloat(dest + 44L, _self23);
        return dest;
    }

    public static long rotateXZY_unsafe(long dest, long src, float angleX, float angleY, float angleZ) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
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
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self02, _t11, Math.fma(_self01, _t12, -(_self00 * _t1))));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self02, _t19, Math.fma(_self00, _t14, _self01 * _t21)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self03);
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self12, _t20, Math.fma(_self10, _t8, _self11 * _t18)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self12, _t11, Math.fma(_self11, _t12, -(_self10 * _t1))));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self12, _t19, Math.fma(_self10, _t14, _self11 * _t21)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, _self13);
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self22, _t20, Math.fma(_self20, _t8, _self21 * _t18)));
        UnsafeOpsHolder.U.putFloat(dest + 36L, Math.fma(_self22, _t11, Math.fma(_self21, _t12, -(_self20 * _t1))));
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(_self22, _t19, Math.fma(_self20, _t14, _self21 * _t21)));
        UnsafeOpsHolder.U.putFloat(dest + 44L, _self23);
        return dest;
    }

    public static long rotateY_unsafe(long dest, long src, float angle) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_self00, _t0, -(_self02 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self01);
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self00, _t1, _self02 * _t0));
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self03);
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self10, _t0, -(_self12 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, _self11);
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self10, _t1, _self12 * _t0));
        UnsafeOpsHolder.U.putFloat(dest + 28L, _self13);
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self20, _t0, -(_self22 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 36L, _self21);
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(_self20, _t1, _self22 * _t0));
        UnsafeOpsHolder.U.putFloat(dest + 44L, _self23);
        return dest;
    }

    public static long rotateYXZ_unsafe(long dest, long src, float angleX, float angleY, float angleZ) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
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
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self02, _t19, Math.fma(_self00, _t21, _self01 * _t13)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self02, _t14, Math.fma(_self00, _t15, -(_self01 * _t0))));
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self03);
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self12, _t20, Math.fma(_self10, _t18, _self11 * _t10)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self12, _t19, Math.fma(_self10, _t21, _self11 * _t13)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self12, _t14, Math.fma(_self10, _t15, -(_self11 * _t0))));
        UnsafeOpsHolder.U.putFloat(dest + 28L, _self13);
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self22, _t20, Math.fma(_self20, _t18, _self21 * _t10)));
        UnsafeOpsHolder.U.putFloat(dest + 36L, Math.fma(_self22, _t19, Math.fma(_self20, _t21, _self21 * _t13)));
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(_self22, _t14, Math.fma(_self20, _t15, -(_self21 * _t0))));
        UnsafeOpsHolder.U.putFloat(dest + 44L, _self23);
        return dest;
    }

    public static long rotateYZX_unsafe(long dest, long src, float angleX, float angleY, float angleZ) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
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
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self02, _t18, Math.fma(_self00, _t20, _self01 * _t11)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self02, _t21, Math.fma(_self00, _t19, -(_self01 * _t13))));
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self03);
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(-_self12, _t6, Math.fma(_self10, _t7, _self11 * _t3)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self12, _t18, Math.fma(_self10, _t20, _self11 * _t11)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self12, _t21, Math.fma(_self10, _t19, -(_self11 * _t13))));
        UnsafeOpsHolder.U.putFloat(dest + 28L, _self13);
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(-_self22, _t6, Math.fma(_self20, _t7, _self21 * _t3)));
        UnsafeOpsHolder.U.putFloat(dest + 36L, Math.fma(_self22, _t18, Math.fma(_self20, _t20, _self21 * _t11)));
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(_self22, _t21, Math.fma(_self20, _t19, -(_self21 * _t13))));
        UnsafeOpsHolder.U.putFloat(dest + 44L, _self23);
        return dest;
    }

    public static long rotateZ_unsafe(long dest, long src, float angle) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_self00, _t0, _self01 * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self01, _t0, -(_self00 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self02);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self03);
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(_self10, _t0, _self11 * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self11, _t0, -(_self10 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, _self12);
        UnsafeOpsHolder.U.putFloat(dest + 28L, _self13);
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(_self20, _t0, _self21 * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 36L, Math.fma(_self21, _t0, -(_self20 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 40L, _self22);
        UnsafeOpsHolder.U.putFloat(dest + 44L, _self23);
        return dest;
    }

    public static long rotateZXY_unsafe(long dest, long src, float angleX, float angleY, float angleZ) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
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
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self02, _t4, Math.fma(_self01, _t10, -(_self00 * _t11))));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self02, _t12, Math.fma(_self00, _t19, _self01 * _t21)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self03);
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(-_self12, _t6, Math.fma(_self10, _t20, _self11 * _t18)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self12, _t4, Math.fma(_self11, _t10, -(_self10 * _t11))));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self12, _t12, Math.fma(_self10, _t19, _self11 * _t21)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, _self13);
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(-_self22, _t6, Math.fma(_self20, _t20, _self21 * _t18)));
        UnsafeOpsHolder.U.putFloat(dest + 36L, Math.fma(_self22, _t4, Math.fma(_self21, _t10, -(_self20 * _t11))));
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(_self22, _t12, Math.fma(_self20, _t19, _self21 * _t21)));
        UnsafeOpsHolder.U.putFloat(dest + 44L, _self23);
        return dest;
    }

    public static long rotateZYX_unsafe(long dest, long src, float angleX, float angleY, float angleZ) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
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
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self02, _t8, Math.fma(_self00, _t20, _self01 * _t18)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self02, _t13, Math.fma(_self00, _t19, _self01 * _t21)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self03);
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(-_self12, _t0, Math.fma(_self10, _t6, _self11 * _t7)));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(_self12, _t8, Math.fma(_self10, _t20, _self11 * _t18)));
        UnsafeOpsHolder.U.putFloat(dest + 24L, Math.fma(_self12, _t13, Math.fma(_self10, _t19, _self11 * _t21)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, _self13);
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(-_self22, _t0, Math.fma(_self20, _t6, _self21 * _t7)));
        UnsafeOpsHolder.U.putFloat(dest + 36L, Math.fma(_self22, _t8, Math.fma(_self20, _t20, _self21 * _t18)));
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(_self22, _t13, Math.fma(_self20, _t19, _self21 * _t21)));
        UnsafeOpsHolder.U.putFloat(dest + 44L, _self23);
        return dest;
    }

    public static long scale_unsafe(long dest, long src, float vX, float vY, float vZ) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, _eself0 * vX);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, _eself1 * vY);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, _eself2 * vZ);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long scale_unsafe(long dest, long src, long v) {
        float _vx = UnsafeOpsHolder.U.getFloat(v + 0L);
        float _vy = UnsafeOpsHolder.U.getFloat(v + 4L);
        float _vz = UnsafeOpsHolder.U.getFloat(v + 8L);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, _eself0 * _vx);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, _eself1 * _vy);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, _eself2 * _vz);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long scale_unsafe(long dest, long src, float s) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, s * _eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, s * _eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, s * _eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, _eself3);
        }
        return dest;
    }

    public static long scaleAround_unsafe(long dest, long src, float s, float pivotX, float pivotY, float pivotZ) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        float _t0 = Math.fma(-s, pivotX, pivotX);
        float _t1 = Math.fma(-s, pivotY, pivotY);
        float _t2 = Math.fma(-s, pivotZ, pivotZ);
        UnsafeOpsHolder.U.putFloat(dest + 0L, s * _self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, s * _self01);
        UnsafeOpsHolder.U.putFloat(dest + 8L, s * _self02);
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_self00, _t0, Math.fma(_self01, _t1, Math.fma(_self02, _t2, _self03))));
        UnsafeOpsHolder.U.putFloat(dest + 16L, s * _self10);
        UnsafeOpsHolder.U.putFloat(dest + 20L, s * _self11);
        UnsafeOpsHolder.U.putFloat(dest + 24L, s * _self12);
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_self10, _t0, Math.fma(_self11, _t1, Math.fma(_self12, _t2, _self13))));
        UnsafeOpsHolder.U.putFloat(dest + 32L, s * _self20);
        UnsafeOpsHolder.U.putFloat(dest + 36L, s * _self21);
        UnsafeOpsHolder.U.putFloat(dest + 40L, s * _self22);
        UnsafeOpsHolder.U.putFloat(dest + 44L, Math.fma(_self20, _t0, Math.fma(_self21, _t1, Math.fma(_self22, _t2, _self23))));
        return dest;
    }

    public static long scaleAround_unsafe(long dest, long src, long pivot, float s) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        float _pivotx = UnsafeOpsHolder.U.getFloat(pivot + 0L);
        float _pivoty = UnsafeOpsHolder.U.getFloat(pivot + 4L);
        float _pivotz = UnsafeOpsHolder.U.getFloat(pivot + 8L);
        float _t0 = Math.fma(-s, _pivotx, _pivotx);
        float _t1 = Math.fma(-s, _pivoty, _pivoty);
        float _t2 = Math.fma(-s, _pivotz, _pivotz);
        UnsafeOpsHolder.U.putFloat(dest + 0L, s * _self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, s * _self01);
        UnsafeOpsHolder.U.putFloat(dest + 8L, s * _self02);
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_self00, _t0, Math.fma(_self01, _t1, Math.fma(_self02, _t2, _self03))));
        UnsafeOpsHolder.U.putFloat(dest + 16L, s * _self10);
        UnsafeOpsHolder.U.putFloat(dest + 20L, s * _self11);
        UnsafeOpsHolder.U.putFloat(dest + 24L, s * _self12);
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_self10, _t0, Math.fma(_self11, _t1, Math.fma(_self12, _t2, _self13))));
        UnsafeOpsHolder.U.putFloat(dest + 32L, s * _self20);
        UnsafeOpsHolder.U.putFloat(dest + 36L, s * _self21);
        UnsafeOpsHolder.U.putFloat(dest + 40L, s * _self22);
        UnsafeOpsHolder.U.putFloat(dest + 44L, Math.fma(_self20, _t0, Math.fma(_self21, _t1, Math.fma(_self22, _t2, _self23))));
        return dest;
    }

    public static long scaleAround_unsafe(long dest, long src, float sX, float sY, float sZ, float pivotX, float pivotY, float pivotZ) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        float _t3 = Math.fma(-pivotX, sX, pivotX);
        float _t4 = Math.fma(-pivotY, sY, pivotY);
        float _t5 = Math.fma(-pivotZ, sZ, pivotZ);
        UnsafeOpsHolder.U.putFloat(dest + 0L, sX * _self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, sY * _self01);
        UnsafeOpsHolder.U.putFloat(dest + 8L, sZ * _self02);
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_self00, _t3, Math.fma(_self01, _t4, Math.fma(_self02, _t5, _self03))));
        UnsafeOpsHolder.U.putFloat(dest + 16L, sX * _self10);
        UnsafeOpsHolder.U.putFloat(dest + 20L, sY * _self11);
        UnsafeOpsHolder.U.putFloat(dest + 24L, sZ * _self12);
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_self10, _t3, Math.fma(_self11, _t4, Math.fma(_self12, _t5, _self13))));
        UnsafeOpsHolder.U.putFloat(dest + 32L, sX * _self20);
        UnsafeOpsHolder.U.putFloat(dest + 36L, sY * _self21);
        UnsafeOpsHolder.U.putFloat(dest + 40L, sZ * _self22);
        UnsafeOpsHolder.U.putFloat(dest + 44L, Math.fma(_self20, _t3, Math.fma(_self21, _t4, Math.fma(_self22, _t5, _self23))));
        return dest;
    }

    public static long scaleAround_unsafe(long dest, long src, long s, long pivot) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        float _sx = UnsafeOpsHolder.U.getFloat(s + 0L);
        float _sy = UnsafeOpsHolder.U.getFloat(s + 4L);
        float _sz = UnsafeOpsHolder.U.getFloat(s + 8L);
        float _pivotx = UnsafeOpsHolder.U.getFloat(pivot + 0L);
        float _pivoty = UnsafeOpsHolder.U.getFloat(pivot + 4L);
        float _pivotz = UnsafeOpsHolder.U.getFloat(pivot + 8L);
        float _t3 = Math.fma(-_pivotx, _sx, _pivotx);
        float _t4 = Math.fma(-_pivoty, _sy, _pivoty);
        float _t5 = Math.fma(-_pivotz, _sz, _pivotz);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _sx * _self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _sy * _self01);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _sz * _self02);
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_self00, _t3, Math.fma(_self01, _t4, Math.fma(_self02, _t5, _self03))));
        UnsafeOpsHolder.U.putFloat(dest + 16L, _sx * _self10);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _sy * _self11);
        UnsafeOpsHolder.U.putFloat(dest + 24L, _sz * _self12);
        UnsafeOpsHolder.U.putFloat(dest + 28L, Math.fma(_self10, _t3, Math.fma(_self11, _t4, Math.fma(_self12, _t5, _self13))));
        UnsafeOpsHolder.U.putFloat(dest + 32L, _sx * _self20);
        UnsafeOpsHolder.U.putFloat(dest + 36L, _sy * _self21);
        UnsafeOpsHolder.U.putFloat(dest + 40L, _sz * _self22);
        UnsafeOpsHolder.U.putFloat(dest + 44L, Math.fma(_self20, _t3, Math.fma(_self21, _t4, Math.fma(_self22, _t5, _self23))));
        return dest;
    }

    public static long translate_unsafe(long dest, long src, float vX, float vY, float vZ) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, _eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, _eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, _eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, Math.fma(_eself0, vX, Math.fma(_eself1, vY, Math.fma(_eself2, vZ, _eself3))));
        }
        return dest;
    }

    public static long translate_unsafe(long dest, long src, long v) {
        float _vx = UnsafeOpsHolder.U.getFloat(v + 0L);
        float _vy = UnsafeOpsHolder.U.getFloat(v + 4L);
        float _vz = UnsafeOpsHolder.U.getFloat(v + 8L);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            float _eself0 = UnsafeOpsHolder.U.getFloat(src + _lo * 4L);
            float _eself1 = UnsafeOpsHolder.U.getFloat(src + (_lo + 1) * 4L);
            float _eself2 = UnsafeOpsHolder.U.getFloat(src + (_lo + 2) * 4L);
            float _eself3 = UnsafeOpsHolder.U.getFloat(src + (_lo + 3) * 4L);
            UnsafeOpsHolder.U.putFloat(dest + _lo * 4L, _eself0);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 1) * 4L, _eself1);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 2) * 4L, _eself2);
            UnsafeOpsHolder.U.putFloat(dest + (_lo + 3) * 4L, Math.fma(_eself0, _vx, Math.fma(_eself1, _vy, Math.fma(_eself2, _vz, _eself3))));
        }
        return dest;
    }

    public static long mulVec4_unsafe(long dest, long src, float vX, float vY, float vZ, float vW) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_self03, vW, Math.fma(_self02, vZ, Math.fma(_self00, vX, _self01 * vY))));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self13, vW, Math.fma(_self12, vZ, Math.fma(_self10, vX, _self11 * vY))));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self23, vW, Math.fma(_self22, vZ, Math.fma(_self20, vX, _self21 * vY))));
        return dest;
    }

    public static long mulVec4_unsafe(long dest, long src, long v) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        float _vx = UnsafeOpsHolder.U.getFloat(v + 0L);
        float _vy = UnsafeOpsHolder.U.getFloat(v + 4L);
        float _vz = UnsafeOpsHolder.U.getFloat(v + 8L);
        float _vw = UnsafeOpsHolder.U.getFloat(v + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_self03, _vw, Math.fma(_self02, _vz, Math.fma(_self00, _vx, _self01 * _vy))));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self13, _vw, Math.fma(_self12, _vz, Math.fma(_self10, _vx, _self11 * _vy))));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self23, _vw, Math.fma(_self22, _vz, Math.fma(_self20, _vx, _self21 * _vy))));
        return dest;
    }

    public static long transformAabb_unsafe(long dest, long src, float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        float _t0 = minX * _self00;
        float _t1 = maxX * _self00;
        float _t2 = minY * _self01;
        float _t3 = maxY * _self01;
        float _t4 = minZ * _self02;
        float _t5 = maxZ * _self02;
        float _t6 = minX * _self10;
        float _t7 = maxX * _self10;
        float _t8 = minY * _self11;
        float _t9 = maxY * _self11;
        float _t10 = minZ * _self12;
        float _t11 = maxZ * _self12;
        float _t12 = minX * _self20;
        float _t13 = maxX * _self20;
        float _t14 = minY * _self21;
        float _t15 = maxY * _self21;
        float _t16 = minZ * _self22;
        float _t17 = maxZ * _self22;
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self03 + Math.min(_t0, _t1) + Math.min(_t2, _t3) + Math.min(_t4, _t5));
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self13 + Math.min(_t6, _t7) + Math.min(_t8, _t9) + Math.min(_t10, _t11));
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self23 + Math.min(_t12, _t13) + Math.min(_t14, _t15) + Math.min(_t16, _t17));
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self03 + Math.max(_t0, _t1) + Math.max(_t2, _t3) + Math.max(_t4, _t5));
        UnsafeOpsHolder.U.putFloat(dest + 16L, _self13 + Math.max(_t6, _t7) + Math.max(_t8, _t9) + Math.max(_t10, _t11));
        UnsafeOpsHolder.U.putFloat(dest + 20L, _self23 + Math.max(_t12, _t13) + Math.max(_t14, _t15) + Math.max(_t16, _t17));
        return dest;
    }

    public static long transformDirection_unsafe(long dest, long src, float vX, float vY, float vZ) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_self02, vZ, Math.fma(_self00, vX, _self01 * vY)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self12, vZ, Math.fma(_self10, vX, _self11 * vY)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self22, vZ, Math.fma(_self20, vX, _self21 * vY)));
        return dest;
    }

    public static long transformDirection_unsafe(long dest, long src, long v) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _vx = UnsafeOpsHolder.U.getFloat(v + 0L);
        float _vy = UnsafeOpsHolder.U.getFloat(v + 4L);
        float _vz = UnsafeOpsHolder.U.getFloat(v + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_self02, _vz, Math.fma(_self00, _vx, _self01 * _vy)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self12, _vz, Math.fma(_self10, _vx, _self11 * _vy)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self22, _vz, Math.fma(_self20, _vx, _self21 * _vy)));
        return dest;
    }

    public static long transformPosition_unsafe(long dest, long src, float vX, float vY, float vZ) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_self00, vX, Math.fma(_self01, vY, Math.fma(_self02, vZ, _self03))));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self10, vX, Math.fma(_self11, vY, Math.fma(_self12, vZ, _self13))));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self20, vX, Math.fma(_self21, vY, Math.fma(_self22, vZ, _self23))));
        return dest;
    }

    public static long transformPosition_unsafe(long dest, long src, long v) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self02 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self03 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 16L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 20L);
        float _self12 = UnsafeOpsHolder.U.getFloat(src + 24L);
        float _self13 = UnsafeOpsHolder.U.getFloat(src + 28L);
        float _self20 = UnsafeOpsHolder.U.getFloat(src + 32L);
        float _self21 = UnsafeOpsHolder.U.getFloat(src + 36L);
        float _self22 = UnsafeOpsHolder.U.getFloat(src + 40L);
        float _self23 = UnsafeOpsHolder.U.getFloat(src + 44L);
        float _vx = UnsafeOpsHolder.U.getFloat(v + 0L);
        float _vy = UnsafeOpsHolder.U.getFloat(v + 4L);
        float _vz = UnsafeOpsHolder.U.getFloat(v + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_self00, _vx, Math.fma(_self01, _vy, Math.fma(_self02, _vz, _self03))));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self10, _vx, Math.fma(_self11, _vy, Math.fma(_self12, _vz, _self13))));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self20, _vx, Math.fma(_self21, _vy, Math.fma(_self22, _vz, _self23))));
        return dest;
    }

    public static void transformPosition_unsafe(long _destBase, long _matrixBase, long _pointsBase, int count) {
        float _m00 = UnsafeOpsHolder.U.getFloat(_matrixBase + 0L);
        float _m01 = UnsafeOpsHolder.U.getFloat(_matrixBase + 4L);
        float _m02 = UnsafeOpsHolder.U.getFloat(_matrixBase + 8L);
        float _m03 = UnsafeOpsHolder.U.getFloat(_matrixBase + 12L);
        float _m10 = UnsafeOpsHolder.U.getFloat(_matrixBase + 16L);
        float _m11 = UnsafeOpsHolder.U.getFloat(_matrixBase + 20L);
        float _m12 = UnsafeOpsHolder.U.getFloat(_matrixBase + 24L);
        float _m13 = UnsafeOpsHolder.U.getFloat(_matrixBase + 28L);
        float _m20 = UnsafeOpsHolder.U.getFloat(_matrixBase + 32L);
        float _m21 = UnsafeOpsHolder.U.getFloat(_matrixBase + 36L);
        float _m22 = UnsafeOpsHolder.U.getFloat(_matrixBase + 40L);
        float _m23 = UnsafeOpsHolder.U.getFloat(_matrixBase + 44L);
        for (int _i = 0; _i < count; _i++) {
            long _pb = _pointsBase + _i * 12L;
            long _db = _destBase + _i * 12L;
            float px = UnsafeOpsHolder.U.getFloat(_pb + 0L), py = UnsafeOpsHolder.U.getFloat(_pb + 4L), pz = UnsafeOpsHolder.U.getFloat(_pb + 8L);
            UnsafeOpsHolder.U.putFloat(_db + 0L, Math.fma(_m00, px, Math.fma(_m01, py, Math.fma(_m02, pz, _m03))));
            UnsafeOpsHolder.U.putFloat(_db + 4L, Math.fma(_m10, px, Math.fma(_m11, py, Math.fma(_m12, pz, _m13))));
            UnsafeOpsHolder.U.putFloat(_db + 8L, Math.fma(_m20, px, Math.fma(_m21, py, Math.fma(_m22, pz, _m23))));
        }
    }

    public static void transformDirection_unsafe(long _destBase, long _matrixBase, long _pointsBase, int count) {
        float _m00 = UnsafeOpsHolder.U.getFloat(_matrixBase + 0L);
        float _m01 = UnsafeOpsHolder.U.getFloat(_matrixBase + 4L);
        float _m02 = UnsafeOpsHolder.U.getFloat(_matrixBase + 8L);
        float _m10 = UnsafeOpsHolder.U.getFloat(_matrixBase + 16L);
        float _m11 = UnsafeOpsHolder.U.getFloat(_matrixBase + 20L);
        float _m12 = UnsafeOpsHolder.U.getFloat(_matrixBase + 24L);
        float _m20 = UnsafeOpsHolder.U.getFloat(_matrixBase + 32L);
        float _m21 = UnsafeOpsHolder.U.getFloat(_matrixBase + 36L);
        float _m22 = UnsafeOpsHolder.U.getFloat(_matrixBase + 40L);
        for (int _i = 0; _i < count; _i++) {
            long _pb = _pointsBase + _i * 12L;
            long _db = _destBase + _i * 12L;
            float px = UnsafeOpsHolder.U.getFloat(_pb + 0L), py = UnsafeOpsHolder.U.getFloat(_pb + 4L), pz = UnsafeOpsHolder.U.getFloat(_pb + 8L);
            UnsafeOpsHolder.U.putFloat(_db + 0L, Math.fma(_m02, pz, Math.fma(_m00, px, _m01 * py)));
            UnsafeOpsHolder.U.putFloat(_db + 4L, Math.fma(_m12, pz, Math.fma(_m10, px, _m11 * py)));
            UnsafeOpsHolder.U.putFloat(_db + 8L, Math.fma(_m22, pz, Math.fma(_m20, px, _m21 * py)));
        }
    }

    public static void lerpComposeTRSMul_fmaUnsafe(long _destBase, long _t1Base, long _t2Base, long _q1Base, long _q2Base, long _s1Base, long _s2Base, long _mBase, float alpha, int count) {
        for (int _i = 0; _i < count; _i++) {
            long _t1o = _t1Base + _i * 12L;
            long _t2o = _t2Base + _i * 12L;
            long _q1o = _q1Base + _i * 16L;
            long _q2o = _q2Base + _i * 16L;
            long _s1o = _s1Base + _i * 12L;
            long _s2o = _s2Base + _i * 12L;
            long _mo = _mBase + _i * 48L;
            long _do = _destBase + _i * 48L;
            float _ax = UnsafeOpsHolder.U.getFloat(_t1o + 0L), _ay = UnsafeOpsHolder.U.getFloat(_t1o + 4L), _az = UnsafeOpsHolder.U.getFloat(_t1o + 8L);
            float _tx = Math.fma(alpha, (UnsafeOpsHolder.U.getFloat(_t2o + 0L)) - _ax, _ax);
            float _ty = Math.fma(alpha, (UnsafeOpsHolder.U.getFloat(_t2o + 4L)) - _ay, _ay);
            float _tz = Math.fma(alpha, (UnsafeOpsHolder.U.getFloat(_t2o + 8L)) - _az, _az);
            float _bx = UnsafeOpsHolder.U.getFloat(_s1o + 0L), _by = UnsafeOpsHolder.U.getFloat(_s1o + 4L), _bz = UnsafeOpsHolder.U.getFloat(_s1o + 8L);
            float _sx = Math.fma(alpha, (UnsafeOpsHolder.U.getFloat(_s2o + 0L)) - _bx, _bx);
            float _sy = Math.fma(alpha, (UnsafeOpsHolder.U.getFloat(_s2o + 4L)) - _by, _by);
            float _sz = Math.fma(alpha, (UnsafeOpsHolder.U.getFloat(_s2o + 8L)) - _bz, _bz);
            float _ux = UnsafeOpsHolder.U.getFloat(_q1o + 0L), _uy = UnsafeOpsHolder.U.getFloat(_q1o + 4L), _uz = UnsafeOpsHolder.U.getFloat(_q1o + 8L), _uw = UnsafeOpsHolder.U.getFloat(_q1o + 12L);
            float _vx = UnsafeOpsHolder.U.getFloat(_q2o + 0L), _vy = UnsafeOpsHolder.U.getFloat(_q2o + 4L), _vz = UnsafeOpsHolder.U.getFloat(_q2o + 8L), _vw = UnsafeOpsHolder.U.getFloat(_q2o + 12L);
            float _dot = Math.fma(_uw, _vw, Math.fma(_uz, _vz, Math.fma(_ux, _vx, _uy * _vy)));
            if (_dot < 0.0f) { _vx = -_vx; _vy = -_vy; _vz = -_vz; _vw = -_vw; }
            float _qx = Math.fma(alpha, _vx - _ux, _ux);
            float _qy = Math.fma(alpha, _vy - _uy, _uy);
            float _qz = Math.fma(alpha, _vz - _uz, _uz);
            float _qw = Math.fma(alpha, _vw - _uw, _uw);
            float _len2 = (_qx * _qx + _qy * _qy) + (_qz * _qz + _qw * _qw);
            float _ninv = _len2 > 0.0f ? 1.0f / (float) Math.sqrt(_len2) : 0.0f;
            _qx *= _ninv; _qy *= _ninv; _qz *= _ninv; _qw *= _ninv;
            float _xx = _qx * _qx, _yy = _qy * _qy, _zz = _qz * _qz;
            float _xy = _qx * _qy, _xz = _qx * _qz, _yz = _qy * _qz, _xw = _qx * _qw, _yw = _qy * _qw, _zw = _qz * _qw;
            float _t00 = (1 - 2 * (_yy + _zz)) * _sx, _t01 = (2 * (_xy - _zw)) * _sy, _t02 = (2 * (_xz + _yw)) * _sz;
            float _t10 = (2 * (_xy + _zw)) * _sx, _t11 = (1 - 2 * (_xx + _zz)) * _sy, _t12 = (2 * (_yz - _xw)) * _sz;
            float _t20 = (2 * (_xz - _yw)) * _sx, _t21 = (2 * (_yz + _xw)) * _sy, _t22 = (1 - 2 * (_xx + _yy)) * _sz;
            float _m00 = UnsafeOpsHolder.U.getFloat(_mo + 0L), _m01 = UnsafeOpsHolder.U.getFloat(_mo + 4L), _m02 = UnsafeOpsHolder.U.getFloat(_mo + 8L), _m03 = UnsafeOpsHolder.U.getFloat(_mo + 12L);
            float _m10 = UnsafeOpsHolder.U.getFloat(_mo + 16L), _m11 = UnsafeOpsHolder.U.getFloat(_mo + 20L), _m12 = UnsafeOpsHolder.U.getFloat(_mo + 24L), _m13 = UnsafeOpsHolder.U.getFloat(_mo + 28L);
            float _m20 = UnsafeOpsHolder.U.getFloat(_mo + 32L), _m21 = UnsafeOpsHolder.U.getFloat(_mo + 36L), _m22 = UnsafeOpsHolder.U.getFloat(_mo + 40L), _m23 = UnsafeOpsHolder.U.getFloat(_mo + 44L);
            float _e00 = Math.fma(_t02, _m20, Math.fma(_t01, _m10, _t00 * _m00)), _e01 = Math.fma(_t02, _m21, Math.fma(_t01, _m11, _t00 * _m01)), _e02 = Math.fma(_t02, _m22, Math.fma(_t01, _m12, _t00 * _m02)), _e03 = (Math.fma(_t02, _m23, Math.fma(_t01, _m13, _t00 * _m03))) + _tx;
            float _e10 = Math.fma(_t12, _m20, Math.fma(_t11, _m10, _t10 * _m00)), _e11 = Math.fma(_t12, _m21, Math.fma(_t11, _m11, _t10 * _m01)), _e12 = Math.fma(_t12, _m22, Math.fma(_t11, _m12, _t10 * _m02)), _e13 = (Math.fma(_t12, _m23, Math.fma(_t11, _m13, _t10 * _m03))) + _ty;
            float _e20 = Math.fma(_t22, _m20, Math.fma(_t21, _m10, _t20 * _m00)), _e21 = Math.fma(_t22, _m21, Math.fma(_t21, _m11, _t20 * _m01)), _e22 = Math.fma(_t22, _m22, Math.fma(_t21, _m12, _t20 * _m02)), _e23 = (Math.fma(_t22, _m23, Math.fma(_t21, _m13, _t20 * _m03))) + _tz;
            UnsafeOpsHolder.U.putFloat(_do + 0L, _e00);
            UnsafeOpsHolder.U.putFloat(_do + 4L, _e01);
            UnsafeOpsHolder.U.putFloat(_do + 8L, _e02);
            UnsafeOpsHolder.U.putFloat(_do + 12L, _e03);
            UnsafeOpsHolder.U.putFloat(_do + 16L, _e10);
            UnsafeOpsHolder.U.putFloat(_do + 20L, _e11);
            UnsafeOpsHolder.U.putFloat(_do + 24L, _e12);
            UnsafeOpsHolder.U.putFloat(_do + 28L, _e13);
            UnsafeOpsHolder.U.putFloat(_do + 32L, _e20);
            UnsafeOpsHolder.U.putFloat(_do + 36L, _e21);
            UnsafeOpsHolder.U.putFloat(_do + 40L, _e22);
            UnsafeOpsHolder.U.putFloat(_do + 44L, _e23);
        }
    }

    public static void lerpComposeTRSMul_mulAddUnsafe(long _destBase, long _t1Base, long _t2Base, long _q1Base, long _q2Base, long _s1Base, long _s2Base, long _mBase, float alpha, int count) {
        for (int _i = 0; _i < count; _i++) {
            long _t1o = _t1Base + _i * 12L;
            long _t2o = _t2Base + _i * 12L;
            long _q1o = _q1Base + _i * 16L;
            long _q2o = _q2Base + _i * 16L;
            long _s1o = _s1Base + _i * 12L;
            long _s2o = _s2Base + _i * 12L;
            long _mo = _mBase + _i * 48L;
            long _do = _destBase + _i * 48L;
            float _ax = UnsafeOpsHolder.U.getFloat(_t1o + 0L), _ay = UnsafeOpsHolder.U.getFloat(_t1o + 4L), _az = UnsafeOpsHolder.U.getFloat(_t1o + 8L);
            float _tx = (alpha) * ((UnsafeOpsHolder.U.getFloat(_t2o + 0L)) - _ax) + (_ax);
            float _ty = (alpha) * ((UnsafeOpsHolder.U.getFloat(_t2o + 4L)) - _ay) + (_ay);
            float _tz = (alpha) * ((UnsafeOpsHolder.U.getFloat(_t2o + 8L)) - _az) + (_az);
            float _bx = UnsafeOpsHolder.U.getFloat(_s1o + 0L), _by = UnsafeOpsHolder.U.getFloat(_s1o + 4L), _bz = UnsafeOpsHolder.U.getFloat(_s1o + 8L);
            float _sx = (alpha) * ((UnsafeOpsHolder.U.getFloat(_s2o + 0L)) - _bx) + (_bx);
            float _sy = (alpha) * ((UnsafeOpsHolder.U.getFloat(_s2o + 4L)) - _by) + (_by);
            float _sz = (alpha) * ((UnsafeOpsHolder.U.getFloat(_s2o + 8L)) - _bz) + (_bz);
            float _ux = UnsafeOpsHolder.U.getFloat(_q1o + 0L), _uy = UnsafeOpsHolder.U.getFloat(_q1o + 4L), _uz = UnsafeOpsHolder.U.getFloat(_q1o + 8L), _uw = UnsafeOpsHolder.U.getFloat(_q1o + 12L);
            float _vx = UnsafeOpsHolder.U.getFloat(_q2o + 0L), _vy = UnsafeOpsHolder.U.getFloat(_q2o + 4L), _vz = UnsafeOpsHolder.U.getFloat(_q2o + 8L), _vw = UnsafeOpsHolder.U.getFloat(_q2o + 12L);
            float _dot = (_uw) * (_vw) + ((_uz) * (_vz) + ((_ux) * (_vx) + (_uy * _vy)));
            if (_dot < 0.0f) { _vx = -_vx; _vy = -_vy; _vz = -_vz; _vw = -_vw; }
            float _qx = (alpha) * (_vx - _ux) + (_ux);
            float _qy = (alpha) * (_vy - _uy) + (_uy);
            float _qz = (alpha) * (_vz - _uz) + (_uz);
            float _qw = (alpha) * (_vw - _uw) + (_uw);
            float _len2 = (_qx * _qx + _qy * _qy) + (_qz * _qz + _qw * _qw);
            float _ninv = _len2 > 0.0f ? 1.0f / (float) Math.sqrt(_len2) : 0.0f;
            _qx *= _ninv; _qy *= _ninv; _qz *= _ninv; _qw *= _ninv;
            float _xx = _qx * _qx, _yy = _qy * _qy, _zz = _qz * _qz;
            float _xy = _qx * _qy, _xz = _qx * _qz, _yz = _qy * _qz, _xw = _qx * _qw, _yw = _qy * _qw, _zw = _qz * _qw;
            float _t00 = (1 - 2 * (_yy + _zz)) * _sx, _t01 = (2 * (_xy - _zw)) * _sy, _t02 = (2 * (_xz + _yw)) * _sz;
            float _t10 = (2 * (_xy + _zw)) * _sx, _t11 = (1 - 2 * (_xx + _zz)) * _sy, _t12 = (2 * (_yz - _xw)) * _sz;
            float _t20 = (2 * (_xz - _yw)) * _sx, _t21 = (2 * (_yz + _xw)) * _sy, _t22 = (1 - 2 * (_xx + _yy)) * _sz;
            float _m00 = UnsafeOpsHolder.U.getFloat(_mo + 0L), _m01 = UnsafeOpsHolder.U.getFloat(_mo + 4L), _m02 = UnsafeOpsHolder.U.getFloat(_mo + 8L), _m03 = UnsafeOpsHolder.U.getFloat(_mo + 12L);
            float _m10 = UnsafeOpsHolder.U.getFloat(_mo + 16L), _m11 = UnsafeOpsHolder.U.getFloat(_mo + 20L), _m12 = UnsafeOpsHolder.U.getFloat(_mo + 24L), _m13 = UnsafeOpsHolder.U.getFloat(_mo + 28L);
            float _m20 = UnsafeOpsHolder.U.getFloat(_mo + 32L), _m21 = UnsafeOpsHolder.U.getFloat(_mo + 36L), _m22 = UnsafeOpsHolder.U.getFloat(_mo + 40L), _m23 = UnsafeOpsHolder.U.getFloat(_mo + 44L);
            float _e00 = (_t02) * (_m20) + ((_t01) * (_m10) + (_t00 * _m00)), _e01 = (_t02) * (_m21) + ((_t01) * (_m11) + (_t00 * _m01)), _e02 = (_t02) * (_m22) + ((_t01) * (_m12) + (_t00 * _m02)), _e03 = ((_t02) * (_m23) + ((_t01) * (_m13) + (_t00 * _m03))) + _tx;
            float _e10 = (_t12) * (_m20) + ((_t11) * (_m10) + (_t10 * _m00)), _e11 = (_t12) * (_m21) + ((_t11) * (_m11) + (_t10 * _m01)), _e12 = (_t12) * (_m22) + ((_t11) * (_m12) + (_t10 * _m02)), _e13 = ((_t12) * (_m23) + ((_t11) * (_m13) + (_t10 * _m03))) + _ty;
            float _e20 = (_t22) * (_m20) + ((_t21) * (_m10) + (_t20 * _m00)), _e21 = (_t22) * (_m21) + ((_t21) * (_m11) + (_t20 * _m01)), _e22 = (_t22) * (_m22) + ((_t21) * (_m12) + (_t20 * _m02)), _e23 = ((_t22) * (_m23) + ((_t21) * (_m13) + (_t20 * _m03))) + _tz;
            UnsafeOpsHolder.U.putFloat(_do + 0L, _e00);
            UnsafeOpsHolder.U.putFloat(_do + 4L, _e01);
            UnsafeOpsHolder.U.putFloat(_do + 8L, _e02);
            UnsafeOpsHolder.U.putFloat(_do + 12L, _e03);
            UnsafeOpsHolder.U.putFloat(_do + 16L, _e10);
            UnsafeOpsHolder.U.putFloat(_do + 20L, _e11);
            UnsafeOpsHolder.U.putFloat(_do + 24L, _e12);
            UnsafeOpsHolder.U.putFloat(_do + 28L, _e13);
            UnsafeOpsHolder.U.putFloat(_do + 32L, _e20);
            UnsafeOpsHolder.U.putFloat(_do + 36L, _e21);
            UnsafeOpsHolder.U.putFloat(_do + 40L, _e22);
            UnsafeOpsHolder.U.putFloat(_do + 44L, _e23);
        }
    }

    public static void composeTRSMul_fmaUnsafe(long _destBase, long _translationBase, long _rotationBase, long _scaleBase, long _mBase, int count) {
        for (int _i = 0; _i < count; _i++) {
            long _translationo = _translationBase + _i * 12L;
            long _rotationo = _rotationBase + _i * 16L;
            long _scaleo = _scaleBase + _i * 12L;
            long _mo = _mBase + _i * 48L;
            long _do = _destBase + _i * 48L;
            float _tx = UnsafeOpsHolder.U.getFloat(_translationo + 0L), _ty = UnsafeOpsHolder.U.getFloat(_translationo + 4L), _tz = UnsafeOpsHolder.U.getFloat(_translationo + 8L);
            float _sx = UnsafeOpsHolder.U.getFloat(_scaleo + 0L), _sy = UnsafeOpsHolder.U.getFloat(_scaleo + 4L), _sz = UnsafeOpsHolder.U.getFloat(_scaleo + 8L);
            float _qx = UnsafeOpsHolder.U.getFloat(_rotationo + 0L), _qy = UnsafeOpsHolder.U.getFloat(_rotationo + 4L), _qz = UnsafeOpsHolder.U.getFloat(_rotationo + 8L), _qw = UnsafeOpsHolder.U.getFloat(_rotationo + 12L);
            float _xx = _qx * _qx, _yy = _qy * _qy, _zz = _qz * _qz;
            float _xy = _qx * _qy, _xz = _qx * _qz, _yz = _qy * _qz, _xw = _qx * _qw, _yw = _qy * _qw, _zw = _qz * _qw;
            float _t00 = (1 - 2 * (_yy + _zz)) * _sx, _t01 = (2 * (_xy - _zw)) * _sy, _t02 = (2 * (_xz + _yw)) * _sz;
            float _t10 = (2 * (_xy + _zw)) * _sx, _t11 = (1 - 2 * (_xx + _zz)) * _sy, _t12 = (2 * (_yz - _xw)) * _sz;
            float _t20 = (2 * (_xz - _yw)) * _sx, _t21 = (2 * (_yz + _xw)) * _sy, _t22 = (1 - 2 * (_xx + _yy)) * _sz;
            float _m00 = UnsafeOpsHolder.U.getFloat(_mo + 0L), _m01 = UnsafeOpsHolder.U.getFloat(_mo + 4L), _m02 = UnsafeOpsHolder.U.getFloat(_mo + 8L), _m03 = UnsafeOpsHolder.U.getFloat(_mo + 12L);
            float _m10 = UnsafeOpsHolder.U.getFloat(_mo + 16L), _m11 = UnsafeOpsHolder.U.getFloat(_mo + 20L), _m12 = UnsafeOpsHolder.U.getFloat(_mo + 24L), _m13 = UnsafeOpsHolder.U.getFloat(_mo + 28L);
            float _m20 = UnsafeOpsHolder.U.getFloat(_mo + 32L), _m21 = UnsafeOpsHolder.U.getFloat(_mo + 36L), _m22 = UnsafeOpsHolder.U.getFloat(_mo + 40L), _m23 = UnsafeOpsHolder.U.getFloat(_mo + 44L);
            float _e00 = Math.fma(_t02, _m20, Math.fma(_t01, _m10, _t00 * _m00)), _e01 = Math.fma(_t02, _m21, Math.fma(_t01, _m11, _t00 * _m01)), _e02 = Math.fma(_t02, _m22, Math.fma(_t01, _m12, _t00 * _m02)), _e03 = (Math.fma(_t02, _m23, Math.fma(_t01, _m13, _t00 * _m03))) + _tx;
            float _e10 = Math.fma(_t12, _m20, Math.fma(_t11, _m10, _t10 * _m00)), _e11 = Math.fma(_t12, _m21, Math.fma(_t11, _m11, _t10 * _m01)), _e12 = Math.fma(_t12, _m22, Math.fma(_t11, _m12, _t10 * _m02)), _e13 = (Math.fma(_t12, _m23, Math.fma(_t11, _m13, _t10 * _m03))) + _ty;
            float _e20 = Math.fma(_t22, _m20, Math.fma(_t21, _m10, _t20 * _m00)), _e21 = Math.fma(_t22, _m21, Math.fma(_t21, _m11, _t20 * _m01)), _e22 = Math.fma(_t22, _m22, Math.fma(_t21, _m12, _t20 * _m02)), _e23 = (Math.fma(_t22, _m23, Math.fma(_t21, _m13, _t20 * _m03))) + _tz;
            UnsafeOpsHolder.U.putFloat(_do + 0L, _e00);
            UnsafeOpsHolder.U.putFloat(_do + 4L, _e01);
            UnsafeOpsHolder.U.putFloat(_do + 8L, _e02);
            UnsafeOpsHolder.U.putFloat(_do + 12L, _e03);
            UnsafeOpsHolder.U.putFloat(_do + 16L, _e10);
            UnsafeOpsHolder.U.putFloat(_do + 20L, _e11);
            UnsafeOpsHolder.U.putFloat(_do + 24L, _e12);
            UnsafeOpsHolder.U.putFloat(_do + 28L, _e13);
            UnsafeOpsHolder.U.putFloat(_do + 32L, _e20);
            UnsafeOpsHolder.U.putFloat(_do + 36L, _e21);
            UnsafeOpsHolder.U.putFloat(_do + 40L, _e22);
            UnsafeOpsHolder.U.putFloat(_do + 44L, _e23);
        }
    }

    public static void composeTRSMul_mulAddUnsafe(long _destBase, long _translationBase, long _rotationBase, long _scaleBase, long _mBase, int count) {
        for (int _i = 0; _i < count; _i++) {
            long _translationo = _translationBase + _i * 12L;
            long _rotationo = _rotationBase + _i * 16L;
            long _scaleo = _scaleBase + _i * 12L;
            long _mo = _mBase + _i * 48L;
            long _do = _destBase + _i * 48L;
            float _tx = UnsafeOpsHolder.U.getFloat(_translationo + 0L), _ty = UnsafeOpsHolder.U.getFloat(_translationo + 4L), _tz = UnsafeOpsHolder.U.getFloat(_translationo + 8L);
            float _sx = UnsafeOpsHolder.U.getFloat(_scaleo + 0L), _sy = UnsafeOpsHolder.U.getFloat(_scaleo + 4L), _sz = UnsafeOpsHolder.U.getFloat(_scaleo + 8L);
            float _qx = UnsafeOpsHolder.U.getFloat(_rotationo + 0L), _qy = UnsafeOpsHolder.U.getFloat(_rotationo + 4L), _qz = UnsafeOpsHolder.U.getFloat(_rotationo + 8L), _qw = UnsafeOpsHolder.U.getFloat(_rotationo + 12L);
            float _xx = _qx * _qx, _yy = _qy * _qy, _zz = _qz * _qz;
            float _xy = _qx * _qy, _xz = _qx * _qz, _yz = _qy * _qz, _xw = _qx * _qw, _yw = _qy * _qw, _zw = _qz * _qw;
            float _t00 = (1 - 2 * (_yy + _zz)) * _sx, _t01 = (2 * (_xy - _zw)) * _sy, _t02 = (2 * (_xz + _yw)) * _sz;
            float _t10 = (2 * (_xy + _zw)) * _sx, _t11 = (1 - 2 * (_xx + _zz)) * _sy, _t12 = (2 * (_yz - _xw)) * _sz;
            float _t20 = (2 * (_xz - _yw)) * _sx, _t21 = (2 * (_yz + _xw)) * _sy, _t22 = (1 - 2 * (_xx + _yy)) * _sz;
            float _m00 = UnsafeOpsHolder.U.getFloat(_mo + 0L), _m01 = UnsafeOpsHolder.U.getFloat(_mo + 4L), _m02 = UnsafeOpsHolder.U.getFloat(_mo + 8L), _m03 = UnsafeOpsHolder.U.getFloat(_mo + 12L);
            float _m10 = UnsafeOpsHolder.U.getFloat(_mo + 16L), _m11 = UnsafeOpsHolder.U.getFloat(_mo + 20L), _m12 = UnsafeOpsHolder.U.getFloat(_mo + 24L), _m13 = UnsafeOpsHolder.U.getFloat(_mo + 28L);
            float _m20 = UnsafeOpsHolder.U.getFloat(_mo + 32L), _m21 = UnsafeOpsHolder.U.getFloat(_mo + 36L), _m22 = UnsafeOpsHolder.U.getFloat(_mo + 40L), _m23 = UnsafeOpsHolder.U.getFloat(_mo + 44L);
            float _e00 = (_t02) * (_m20) + ((_t01) * (_m10) + (_t00 * _m00)), _e01 = (_t02) * (_m21) + ((_t01) * (_m11) + (_t00 * _m01)), _e02 = (_t02) * (_m22) + ((_t01) * (_m12) + (_t00 * _m02)), _e03 = ((_t02) * (_m23) + ((_t01) * (_m13) + (_t00 * _m03))) + _tx;
            float _e10 = (_t12) * (_m20) + ((_t11) * (_m10) + (_t10 * _m00)), _e11 = (_t12) * (_m21) + ((_t11) * (_m11) + (_t10 * _m01)), _e12 = (_t12) * (_m22) + ((_t11) * (_m12) + (_t10 * _m02)), _e13 = ((_t12) * (_m23) + ((_t11) * (_m13) + (_t10 * _m03))) + _ty;
            float _e20 = (_t22) * (_m20) + ((_t21) * (_m10) + (_t20 * _m00)), _e21 = (_t22) * (_m21) + ((_t21) * (_m11) + (_t20 * _m01)), _e22 = (_t22) * (_m22) + ((_t21) * (_m12) + (_t20 * _m02)), _e23 = ((_t22) * (_m23) + ((_t21) * (_m13) + (_t20 * _m03))) + _tz;
            UnsafeOpsHolder.U.putFloat(_do + 0L, _e00);
            UnsafeOpsHolder.U.putFloat(_do + 4L, _e01);
            UnsafeOpsHolder.U.putFloat(_do + 8L, _e02);
            UnsafeOpsHolder.U.putFloat(_do + 12L, _e03);
            UnsafeOpsHolder.U.putFloat(_do + 16L, _e10);
            UnsafeOpsHolder.U.putFloat(_do + 20L, _e11);
            UnsafeOpsHolder.U.putFloat(_do + 24L, _e12);
            UnsafeOpsHolder.U.putFloat(_do + 28L, _e13);
            UnsafeOpsHolder.U.putFloat(_do + 32L, _e20);
            UnsafeOpsHolder.U.putFloat(_do + 36L, _e21);
            UnsafeOpsHolder.U.putFloat(_do + 40L, _e22);
            UnsafeOpsHolder.U.putFloat(_do + 44L, _e23);
        }
    }

    public static void composeTRSMulPadded_fmaUnsafe(long _destBase, long _translationBase, long _rotationBase, long _scaleBase, long _mBase) {
        float _qx = UnsafeOpsHolder.U.getFloat(_rotationBase + 0L), _qy = UnsafeOpsHolder.U.getFloat(_rotationBase + 4L), _qz = UnsafeOpsHolder.U.getFloat(_rotationBase + 8L), _qw = UnsafeOpsHolder.U.getFloat(_rotationBase + 12L);
        float _tx = UnsafeOpsHolder.U.getFloat(_translationBase + 0L), _ty = UnsafeOpsHolder.U.getFloat(_translationBase + 4L), _tz = UnsafeOpsHolder.U.getFloat(_translationBase + 8L);
        float _sx = UnsafeOpsHolder.U.getFloat(_scaleBase + 0L), _sy = UnsafeOpsHolder.U.getFloat(_scaleBase + 4L), _sz = UnsafeOpsHolder.U.getFloat(_scaleBase + 8L);
        float _m00 = UnsafeOpsHolder.U.getFloat(_mBase + 0L), _m01 = UnsafeOpsHolder.U.getFloat(_mBase + 4L), _m02 = UnsafeOpsHolder.U.getFloat(_mBase + 8L), _m03 = UnsafeOpsHolder.U.getFloat(_mBase + 12L);
        float _m10 = UnsafeOpsHolder.U.getFloat(_mBase + 16L), _m11 = UnsafeOpsHolder.U.getFloat(_mBase + 20L), _m12 = UnsafeOpsHolder.U.getFloat(_mBase + 24L), _m13 = UnsafeOpsHolder.U.getFloat(_mBase + 28L);
        float _m20 = UnsafeOpsHolder.U.getFloat(_mBase + 32L), _m21 = UnsafeOpsHolder.U.getFloat(_mBase + 36L), _m22 = UnsafeOpsHolder.U.getFloat(_mBase + 40L), _m23 = UnsafeOpsHolder.U.getFloat(_mBase + 44L);
        float _xx = _qx * _qx, _yy = _qy * _qy, _zz = _qz * _qz;
        float _xy = _qx * _qy, _xz = _qx * _qz, _yz = _qy * _qz, _xw = _qx * _qw, _yw = _qy * _qw, _zw = _qz * _qw;
        float _t00 = (1 - 2 * (_yy + _zz)) * _sx, _t01 = (2 * (_xy - _zw)) * _sy, _t02 = (2 * (_xz + _yw)) * _sz;
        float _t10 = (2 * (_xy + _zw)) * _sx, _t11 = (1 - 2 * (_xx + _zz)) * _sy, _t12 = (2 * (_yz - _xw)) * _sz;
        float _t20 = (2 * (_xz - _yw)) * _sx, _t21 = (2 * (_yz + _xw)) * _sy, _t22 = (1 - 2 * (_xx + _yy)) * _sz;
        float _e00 = Math.fma(_t02, _m20, Math.fma(_t01, _m10, _t00 * _m00)), _e01 = Math.fma(_t02, _m21, Math.fma(_t01, _m11, _t00 * _m01)), _e02 = Math.fma(_t02, _m22, Math.fma(_t01, _m12, _t00 * _m02)), _e03 = (Math.fma(_t02, _m23, Math.fma(_t01, _m13, _t00 * _m03))) + _tx;
        float _e10 = Math.fma(_t12, _m20, Math.fma(_t11, _m10, _t10 * _m00)), _e11 = Math.fma(_t12, _m21, Math.fma(_t11, _m11, _t10 * _m01)), _e12 = Math.fma(_t12, _m22, Math.fma(_t11, _m12, _t10 * _m02)), _e13 = (Math.fma(_t12, _m23, Math.fma(_t11, _m13, _t10 * _m03))) + _ty;
        float _e20 = Math.fma(_t22, _m20, Math.fma(_t21, _m10, _t20 * _m00)), _e21 = Math.fma(_t22, _m21, Math.fma(_t21, _m11, _t20 * _m01)), _e22 = Math.fma(_t22, _m22, Math.fma(_t21, _m12, _t20 * _m02)), _e23 = (Math.fma(_t22, _m23, Math.fma(_t21, _m13, _t20 * _m03))) + _tz;
        UnsafeOpsHolder.U.putFloat(_destBase + 0L, _e00);
        UnsafeOpsHolder.U.putFloat(_destBase + 4L, _e01);
        UnsafeOpsHolder.U.putFloat(_destBase + 8L, _e02);
        UnsafeOpsHolder.U.putFloat(_destBase + 12L, _e03);
        UnsafeOpsHolder.U.putFloat(_destBase + 16L, _e10);
        UnsafeOpsHolder.U.putFloat(_destBase + 20L, _e11);
        UnsafeOpsHolder.U.putFloat(_destBase + 24L, _e12);
        UnsafeOpsHolder.U.putFloat(_destBase + 28L, _e13);
        UnsafeOpsHolder.U.putFloat(_destBase + 32L, _e20);
        UnsafeOpsHolder.U.putFloat(_destBase + 36L, _e21);
        UnsafeOpsHolder.U.putFloat(_destBase + 40L, _e22);
        UnsafeOpsHolder.U.putFloat(_destBase + 44L, _e23);
    }

    public static void composeTRSMulPadded_mulAddUnsafe(long _destBase, long _translationBase, long _rotationBase, long _scaleBase, long _mBase) {
        float _qx = UnsafeOpsHolder.U.getFloat(_rotationBase + 0L), _qy = UnsafeOpsHolder.U.getFloat(_rotationBase + 4L), _qz = UnsafeOpsHolder.U.getFloat(_rotationBase + 8L), _qw = UnsafeOpsHolder.U.getFloat(_rotationBase + 12L);
        float _tx = UnsafeOpsHolder.U.getFloat(_translationBase + 0L), _ty = UnsafeOpsHolder.U.getFloat(_translationBase + 4L), _tz = UnsafeOpsHolder.U.getFloat(_translationBase + 8L);
        float _sx = UnsafeOpsHolder.U.getFloat(_scaleBase + 0L), _sy = UnsafeOpsHolder.U.getFloat(_scaleBase + 4L), _sz = UnsafeOpsHolder.U.getFloat(_scaleBase + 8L);
        float _m00 = UnsafeOpsHolder.U.getFloat(_mBase + 0L), _m01 = UnsafeOpsHolder.U.getFloat(_mBase + 4L), _m02 = UnsafeOpsHolder.U.getFloat(_mBase + 8L), _m03 = UnsafeOpsHolder.U.getFloat(_mBase + 12L);
        float _m10 = UnsafeOpsHolder.U.getFloat(_mBase + 16L), _m11 = UnsafeOpsHolder.U.getFloat(_mBase + 20L), _m12 = UnsafeOpsHolder.U.getFloat(_mBase + 24L), _m13 = UnsafeOpsHolder.U.getFloat(_mBase + 28L);
        float _m20 = UnsafeOpsHolder.U.getFloat(_mBase + 32L), _m21 = UnsafeOpsHolder.U.getFloat(_mBase + 36L), _m22 = UnsafeOpsHolder.U.getFloat(_mBase + 40L), _m23 = UnsafeOpsHolder.U.getFloat(_mBase + 44L);
        float _xx = _qx * _qx, _yy = _qy * _qy, _zz = _qz * _qz;
        float _xy = _qx * _qy, _xz = _qx * _qz, _yz = _qy * _qz, _xw = _qx * _qw, _yw = _qy * _qw, _zw = _qz * _qw;
        float _t00 = (1 - 2 * (_yy + _zz)) * _sx, _t01 = (2 * (_xy - _zw)) * _sy, _t02 = (2 * (_xz + _yw)) * _sz;
        float _t10 = (2 * (_xy + _zw)) * _sx, _t11 = (1 - 2 * (_xx + _zz)) * _sy, _t12 = (2 * (_yz - _xw)) * _sz;
        float _t20 = (2 * (_xz - _yw)) * _sx, _t21 = (2 * (_yz + _xw)) * _sy, _t22 = (1 - 2 * (_xx + _yy)) * _sz;
        float _e00 = (_t02) * (_m20) + ((_t01) * (_m10) + (_t00 * _m00)), _e01 = (_t02) * (_m21) + ((_t01) * (_m11) + (_t00 * _m01)), _e02 = (_t02) * (_m22) + ((_t01) * (_m12) + (_t00 * _m02)), _e03 = ((_t02) * (_m23) + ((_t01) * (_m13) + (_t00 * _m03))) + _tx;
        float _e10 = (_t12) * (_m20) + ((_t11) * (_m10) + (_t10 * _m00)), _e11 = (_t12) * (_m21) + ((_t11) * (_m11) + (_t10 * _m01)), _e12 = (_t12) * (_m22) + ((_t11) * (_m12) + (_t10 * _m02)), _e13 = ((_t12) * (_m23) + ((_t11) * (_m13) + (_t10 * _m03))) + _ty;
        float _e20 = (_t22) * (_m20) + ((_t21) * (_m10) + (_t20 * _m00)), _e21 = (_t22) * (_m21) + ((_t21) * (_m11) + (_t20 * _m01)), _e22 = (_t22) * (_m22) + ((_t21) * (_m12) + (_t20 * _m02)), _e23 = ((_t22) * (_m23) + ((_t21) * (_m13) + (_t20 * _m03))) + _tz;
        UnsafeOpsHolder.U.putFloat(_destBase + 0L, _e00);
        UnsafeOpsHolder.U.putFloat(_destBase + 4L, _e01);
        UnsafeOpsHolder.U.putFloat(_destBase + 8L, _e02);
        UnsafeOpsHolder.U.putFloat(_destBase + 12L, _e03);
        UnsafeOpsHolder.U.putFloat(_destBase + 16L, _e10);
        UnsafeOpsHolder.U.putFloat(_destBase + 20L, _e11);
        UnsafeOpsHolder.U.putFloat(_destBase + 24L, _e12);
        UnsafeOpsHolder.U.putFloat(_destBase + 28L, _e13);
        UnsafeOpsHolder.U.putFloat(_destBase + 32L, _e20);
        UnsafeOpsHolder.U.putFloat(_destBase + 36L, _e21);
        UnsafeOpsHolder.U.putFloat(_destBase + 40L, _e22);
        UnsafeOpsHolder.U.putFloat(_destBase + 44L, _e23);
    }

}
