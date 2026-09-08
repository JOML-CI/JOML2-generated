package org.joml2.internal.kernels;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.ops.*;
import org.joml2.internal.unsafe.*;
import org.joml2.internal.simd.*;

/**
 * Scalar/Unsafe kernel leaves of {@link Float4x4Ops} whose leading storage
 * parameter is a {@code float[]} array. Split into a sibling compilation unit purely
 * to keep generated sources IDE-sized; package-private, called only from
 * {@code Float4x4Ops} and its sibling kernel units. Not public API.
 */
public final class Float4x4OpsKernelsArray {
    private Float4x4OpsKernelsArray() {}

    public static float[] getNormalizedRotation_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
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
            dest[destOffset + 0] = 0.5f * _t36 * _t66;
            dest[destOffset + 1] = 0.5f * _t56 * _t66;
            dest[destOffset + 2] = 0.5f * _t57 * _t66;
            dest[destOffset + 3] = 0.5f * (float) Math.sqrt(_t62);
        } else {
            if (_t49 > _t37) {
                dest[destOffset + 0] = 0.5f * (float) Math.sqrt(_t63);
                dest[destOffset + 1] = 0.5f * _t53 * _t69;
                dest[destOffset + 2] = 0.5f * _t55 * _t69;
                dest[destOffset + 3] = 0.5f * _t36 * _t69;
            } else {
                if (_t23 > _t26) {
                    dest[destOffset + 0] = 0.5f * _t53 * _t67;
                    dest[destOffset + 1] = 0.5f * (float) Math.sqrt(_t64);
                    dest[destOffset + 2] = 0.5f * _t39 * _t67;
                    dest[destOffset + 3] = 0.5f * _t56 * _t67;
                } else {
                    dest[destOffset + 0] = 0.5f * _t55 * _t68;
                    dest[destOffset + 1] = 0.5f * _t39 * _t68;
                    dest[destOffset + 2] = 0.5f * (float) Math.sqrt(_t65);
                    dest[destOffset + 3] = 0.5f * _t57 * _t68;
                }
            }
        }
        return dest;
    }

    public static float[] getUnnormalizedRotation_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
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
            dest[destOffset + 0] = 0.5f * _t1 * _t18;
            dest[destOffset + 1] = 0.5f * _t7 * _t18;
            dest[destOffset + 2] = 0.5f * _t9 * _t18;
            dest[destOffset + 3] = 0.5f * (float) Math.sqrt(_t14);
        } else {
            if (_self00 > _t2) {
                dest[destOffset + 0] = 0.5f * (float) Math.sqrt(_t15);
                dest[destOffset + 1] = 0.5f * _t4 * _t21;
                dest[destOffset + 2] = 0.5f * _t6 * _t21;
                dest[destOffset + 3] = 0.5f * _t1 * _t21;
            } else {
                if (_self11 > _self22) {
                    dest[destOffset + 0] = 0.5f * _t4 * _t19;
                    dest[destOffset + 1] = 0.5f * (float) Math.sqrt(_t16);
                    dest[destOffset + 2] = 0.5f * _t8 * _t19;
                    dest[destOffset + 3] = 0.5f * _t7 * _t19;
                } else {
                    dest[destOffset + 0] = 0.5f * _t6 * _t20;
                    dest[destOffset + 1] = 0.5f * _t8 * _t20;
                    dest[destOffset + 2] = 0.5f * (float) Math.sqrt(_t17);
                    dest[destOffset + 3] = 0.5f * _t9 * _t20;
                }
            }
        }
        return dest;
    }

    public static float[] add_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset) {
        for (int _i = 0; _i < 16; _i++) {
            float _eself = src[srcOffset + _i];
            float _eother = other[otherOffset + _i];
            dest[destOffset + _i] = _eother + _eself;
        }
        return dest;
    }

    public static float[] negate_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        for (int _i = 0; _i < 16; _i++) {
            float _eself = src[srcOffset + _i];
            dest[destOffset + _i] = -_eself;
        }
        return dest;
    }

    public static float[] sub_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset) {
        for (int _i = 0; _i < 16; _i++) {
            float _eself = src[srcOffset + _i];
            float _eother = other[otherOffset + _i];
            dest[destOffset + _i] = _eself - _eother;
        }
        return dest;
    }

    public static float[] set_scalar(float[] dest, int destOffset, float[] v, int vOffset) {
        for (int _i = 0; _i < 16; _i++) {
            float _ev = v[vOffset + _i];
            dest[destOffset + _i] = _ev;
        }
        return dest;
    }

    public static float[] makeFromTransform_scalar(float[] dest, int destOffset, float tTX, float tTY, float tTZ, float tRX, float tRY, float tRZ, float tRW, float tSX, float tSY, float tSZ) {
        float _t0 = tRZ * tRZ;
        float _t1 = tRZ * tRW;
        float _t2 = tRY * tRW;
        dest[destOffset + 0] = tSX * Math.fma(-2.0f, Math.fma(tRY, tRY, _t0), 1.0f);
        dest[destOffset + 1] = tSX * 2.0f * Math.fma(tRX, tRY, _t1);
        dest[destOffset + 2] = tSX * 2.0f * Math.fma(tRX, tRZ, -_t2);
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = tSY * 2.0f * Math.fma(tRX, tRY, -_t1);
        dest[destOffset + 5] = tSY * Math.fma(-2.0f, Math.fma(tRX, tRX, _t0), 1.0f);
        dest[destOffset + 6] = tSY * 2.0f * Math.fma(tRX, tRW, tRY * tRZ);
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = tSZ * 2.0f * Math.fma(tRX, tRZ, _t2);
        dest[destOffset + 9] = tSZ * 2.0f * Math.fma(tRY, tRZ, -(tRX * tRW));
        dest[destOffset + 10] = tSZ * Math.fma(-2.0f, Math.fma(tRX, tRX, tRY * tRY), 1.0f);
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = tTX;
        dest[destOffset + 13] = tTY;
        dest[destOffset + 14] = tTZ;
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] decomposeRotation_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
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
            dest[destOffset + 0] = 0.5f * _t60 * _t90;
            dest[destOffset + 1] = 0.5f * _t81 * _t90;
            dest[destOffset + 2] = 0.5f * _t78 * _t90;
            dest[destOffset + 3] = 0.5f * (float) Math.sqrt(_t86);
        } else {
            if (_t73 > _t61) {
                dest[destOffset + 0] = 0.5f * (float) Math.sqrt(_t87);
                dest[destOffset + 1] = 0.5f * _t77 * _t93;
                dest[destOffset + 2] = 0.5f * _t80 * _t93;
                dest[destOffset + 3] = 0.5f * _t60 * _t93;
            } else {
                if (_t36 > _t56) {
                    dest[destOffset + 0] = 0.5f * _t77 * _t91;
                    dest[destOffset + 1] = 0.5f * (float) Math.sqrt(_t88);
                    dest[destOffset + 2] = 0.5f * _t63 * _t91;
                    dest[destOffset + 3] = 0.5f * _t81 * _t91;
                } else {
                    dest[destOffset + 0] = 0.5f * _t80 * _t92;
                    dest[destOffset + 1] = 0.5f * _t63 * _t92;
                    dest[destOffset + 2] = 0.5f * (float) Math.sqrt(_t89);
                    dest[destOffset + 3] = 0.5f * _t78 * _t92;
                }
            }
        }
        return dest;
    }

    public static float[] frustumAabb_no(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t1 = -_self01;
        float _t2 = -_self00;
        float _t3 = -_self10;
        float _t40 = Math.fma(_self22, _self33, -(_self23 * _self32));
        float _t41 = Math.fma(_self21, _self32, -(_self22 * _self31));
        float _t42 = Math.fma(_self21, _self33, -(_self23 * _self31));
        float _t43 = Math.fma(_self12, _self33, -(_self13 * _self32));
        float _t44 = Math.fma(_self11, _self33, -(_self13 * _self31));
        float _t45 = Math.fma(_self11, _self32, -(_self12 * _self31));
        float _t46 = Math.fma(_self12, _self23, -(_self13 * _self22));
        float _t47 = Math.fma(_self11, _self23, -(_self13 * _self21));
        float _t48 = Math.fma(_self11, _self22, -(_self12 * _self21));
        float _t49 = Math.fma(_self10, _self31, -(_self11 * _self30));
        float _t50 = Math.fma(_self10, _self32, -(_self12 * _self30));
        float _t51 = Math.fma(_self20, _self31, -(_self21 * _self30));
        float _t52 = Math.fma(_self20, _self32, -(_self22 * _self30));
        float _t53 = Math.fma(_self10, _self21, -(_self11 * _self20));
        float _t54 = Math.fma(_self10, _self22, -(_self12 * _self20));
        float _t55 = Math.fma(_self10, _self33, -(_self13 * _self30));
        float _t56 = Math.fma(_self20, _self33, -(_self23 * _self30));
        float _t57 = Math.fma(_self10, _self23, -(_self13 * _self20));
        float _t142 = Math.fma(_self01, _t40, Math.fma(_self03, _t41, -(_self02 * _t42)));
        float _t143 = Math.fma(_self00, _t45, Math.fma(_self02, _t49, -(_self01 * _t50)));
        float _t144 = Math.fma(_self10, _t41, Math.fma(_self12, _t51, -(_self11 * _t52)));
        float _t145 = Math.fma(_self00, _t48, Math.fma(_self02, _t53, -(_self01 * _t54)));
        float _t146 = Math.fma(_self11, _t40, Math.fma(_self13, _t41, -(_self12 * _t42)));
        float _t147 = Math.fma(_self00, _t41, Math.fma(_self02, _t51, -(_self01 * _t52)));
        float _t148 = Math.fma(_self01, _t43, Math.fma(_self03, _t45, -(_self02 * _t44)));
        float _t149 = Math.fma(_self00, _t43, Math.fma(_self03, _t50, -(_self02 * _t55)));
        float _t150 = Math.fma(_self10, _t40, Math.fma(_self13, _t52, -(_self12 * _t56)));
        float _t151 = Math.fma(_self00, _t46, Math.fma(_self03, _t54, -(_self02 * _t57)));
        float _t152 = Math.fma(_self00, _t40, Math.fma(_self03, _t52, -(_self02 * _t56)));
        float _t153 = Math.fma(_self00, _t42, Math.fma(_self03, _t51, -(_self01 * _t56)));
        float _t154 = Math.fma(_self10, _t42, Math.fma(_self13, _t51, -(_self11 * _t56)));
        float _t155 = Math.fma(_self00, _t44, Math.fma(_self03, _t49, -(_self01 * _t55)));
        float _t156 = Math.fma(-_self11, _t40, Math.fma(_self12, _t42, -(_self13 * _t41)));
        float _t158 = Math.fma(_t1, _t46, Math.fma(_self02, _t47, -(_self03 * _t48)));
        float _t159 = Math.fma(_t2, _t41, Math.fma(_self01, _t52, -(_self02 * _t51)));
        float _t160 = Math.fma(_t3, _t41, Math.fma(_self11, _t52, -(_self12 * _t51)));
        float _t161 = Math.fma(_t1, _t40, Math.fma(_self02, _t42, -(_self03 * _t41)));
        float _t162 = Math.fma(_t2, _t45, Math.fma(_self01, _t50, -(_self02 * _t49)));
        float _t163 = Math.fma(_t2, _t40, Math.fma(_self02, _t56, -(_self03 * _t52)));
        float _t164 = Math.fma(_t3, _t40, Math.fma(_self12, _t56, -(_self13 * _t52)));
        float _t165 = Math.fma(_t2, _t43, Math.fma(_self02, _t55, -(_self03 * _t50)));
        float _t166 = Math.fma(_t3, _t42, Math.fma(_self11, _t56, -(_self13 * _t51)));
        float _t168 = Math.fma(_t2, _t47, Math.fma(_self01, _t57, -(_self03 * _t53)));
        float _t169 = Math.fma(_t2, _t42, Math.fma(_self01, _t56, -(_self03 * _t51)));
        float _t171 = _t142 + _t146;
        float _t178 = _t145 + _t147;
        float _t184 = _t151 + _t152;
        float _t185 = _t153 + _t154;
        float _t189 = _t159 + _t145;
        float _t197 = _t163 + _t151;
        float _t206 = Math.fma(_t1, _t43, Math.fma(_self02, _t44, -(_self03 * _t45))) + _t158;
        float _t209 = _t159 + _t162;
        float _t210 = _t161 + _t158;
        float _t212 = _t163 + _t165;
        float _t214 = Math.fma(_t2, _t44, Math.fma(_self01, _t55, -(_self03 * _t49))) + _t168;
        float _t217 = _t169 + _t168;
        float _t218 = _t147 + _t144 + (_t143 + _t145);
        float _t218_inv = 1.0f / _t218;
        float _t220 = _t143 + _t144 + _t189;
        float _t220_inv = 1.0f / _t220;
        float _t221 = _t143 + _t147 + (_t160 + _t145);
        float _t221_inv = 1.0f / _t221;
        float _t223 = _t178 + (_t144 + _t162);
        float _t223_inv = 1.0f / _t223;
        float _t229 = _t143 + _t160 + _t189;
        float _t229_inv = 1.0f / _t229;
        float _t231 = _t145 + _t144 + _t209;
        float _t231_inv = 1.0f / _t231;
        float _t233 = _t178 + (_t160 + _t162);
        float _t233_inv = 1.0f / _t233;
        float _t242 = _t145 + _t160 + _t209;
        float _t242_inv = 1.0f / _t242;
        float _t250 = (_t152 + _t150 + (_t149 + _t151)) * _t218_inv;
        float _t251 = (_t149 + _t150 + _t197) * _t220_inv;
        float _t252 = (_t149 + _t152 + (_t164 + _t151)) * _t221_inv;
        float _t253 = (_t184 + (_t150 + _t165)) * _t223_inv;
        float _t254 = (_t142 + _t156 + _t206) * _t220_inv;
        float _t255 = (_t171 + _t206) * _t229_inv;
        float _t256 = (_t146 + _t161 + _t206) * _t221_inv;
        float _t257 = (_t156 + _t161 + _t206) * _t218_inv;
        float _t258 = (_t148 + _t142 + (_t156 + _t158)) * _t231_inv;
        float _t259 = (_t171 + (_t148 + _t158)) * _t242_inv;
        float _t260 = (_t148 + _t146 + _t210) * _t233_inv;
        float _t261 = (_t148 + _t156 + _t210) * _t223_inv;
        float _t262 = (_t149 + _t164 + _t197) * _t229_inv;
        float _t263 = (_t151 + _t150 + _t212) * _t231_inv;
        float _t264 = (_t184 + (_t164 + _t165)) * _t233_inv;
        float _t265 = (_t153 + _t166 + _t214) * _t220_inv;
        float _t266 = (_t185 + _t214) * _t229_inv;
        float _t267 = (_t154 + _t169 + _t214) * _t221_inv;
        float _t268 = (_t166 + _t169 + _t214) * _t218_inv;
        float _t269 = (_t155 + _t153 + (_t166 + _t168)) * _t231_inv;
        float _t270 = (_t185 + (_t155 + _t168)) * _t242_inv;
        float _t271 = (_t155 + _t154 + _t217) * _t233_inv;
        float _t272 = (_t155 + _t166 + _t217) * _t223_inv;
        float _t273 = (_t151 + _t164 + _t212) * _t242_inv;
        dest[destOffset + 0] = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t254, _t255), _t256), _t257), _t258), _t259), _t260), _t261);
        dest[destOffset + 1] = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t251, _t262), _t252), _t250), _t263), _t273), _t264), _t253);
        dest[destOffset + 2] = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t265, _t266), _t267), _t268), _t269), _t270), _t271), _t272);
        dest[destOffset + 3] = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t254, _t255), _t256), _t257), _t258), _t259), _t260), _t261);
        dest[destOffset + 4] = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t251, _t262), _t252), _t250), _t263), _t273), _t264), _t253);
        dest[destOffset + 5] = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t265, _t266), _t267), _t268), _t269), _t270), _t271), _t272);
        return dest;
    }

    public static float[] frustumAabb_zo(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = -_self01;
        float _t1 = -_self00;
        float _t2 = -_self10;
        float _t40 = Math.fma(_self22, _self33, -(_self23 * _self32));
        float _t41 = Math.fma(_self21, _self33, -(_self23 * _self31));
        float _t42 = Math.fma(_self21, _self32, -(_self22 * _self31));
        float _t43 = Math.fma(_self12, _self23, -(_self13 * _self22));
        float _t44 = Math.fma(_self11, _self23, -(_self13 * _self21));
        float _t45 = Math.fma(_self11, _self22, -(_self12 * _self21));
        float _t46 = Math.fma(_self10, _self22, -(_self12 * _self20));
        float _t47 = Math.fma(_self10, _self21, -(_self11 * _self20));
        float _t48 = Math.fma(_self20, _self31, -(_self21 * _self30));
        float _t49 = Math.fma(_self20, _self32, -(_self22 * _self30));
        float _t50 = Math.fma(_self12, _self33, -(_self13 * _self32));
        float _t51 = Math.fma(_self11, _self32, -(_self12 * _self31));
        float _t52 = Math.fma(_self11, _self33, -(_self13 * _self31));
        float _t53 = Math.fma(_self10, _self32, -(_self12 * _self30));
        float _t54 = Math.fma(_self10, _self31, -(_self11 * _self30));
        float _t55 = Math.fma(_self10, _self23, -(_self13 * _self20));
        float _t56 = Math.fma(_self20, _self33, -(_self23 * _self30));
        float _t57 = Math.fma(_self10, _self33, -(_self13 * _self30));
        float _t59 = _self11 * _t40;
        float _t63 = _self10 * _t42;
        float _t75 = _self10 * _t40;
        float _t83 = _self10 * _t41;
        float _t90 = -(_self02 * _t41);
        float _t91 = -_t59;
        float _t92 = -(_self13 * _t42);
        float _t94 = -(_self01 * _t46);
        float _t97 = -(_self12 * _t41);
        float _t102 = -(_self01 * _t49);
        float _t105 = -(_self02 * _t55);
        float _t110 = -(_self02 * _t56);
        float _t112 = -(_self01 * _t56);
        float _t113 = -_t83;
        float _t114 = -(_self13 * _t48);
        float _t116 = -(_self11 * _t56);
        float _t128 = Math.fma(_self01, _t40, _t90);
        float _t130 = Math.fma(_self12, _t41, _t92);
        float _t132 = Math.fma(_self00, _t45, _t94);
        float _t133 = Math.fma(_self12, _t48, -(_self11 * _t49));
        float _t135 = Math.fma(_self13, _t42, _t97);
        float _t137 = Math.fma(_self11, _t49, -(_self12 * _t48));
        float _t140 = Math.fma(_self02, _t41, -(_self03 * _t42));
        float _t141 = Math.fma(_self02, _t48, _t102);
        float _t148 = Math.fma(_self00, _t43, _t105);
        float _t149 = Math.fma(_self13, _t49, -(_self12 * _t56));
        float _t152 = Math.fma(_self12, _t56, -(_self13 * _t49));
        float _t153 = Math.fma(_self03, _t49, _t110);
        float _t157 = Math.fma(_self00, _t41, _t112);
        float _t159 = Math.fma(_self11, _t56, _t114);
        float _t161 = Math.fma(_self13, _t48, _t116);
        float _t164 = Math.fma(_self01, _t56, -(_self03 * _t48));
        float _t170 = Math.fma(_self00, _t45, Math.fma(_self02, _t47, _t94));
        float _t171 = Math.fma(_self01, _t50, Math.fma(_self03, _t51, -(_self02 * _t52)));
        float _t172 = Math.fma(_self01, _t40, Math.fma(_self03, _t42, _t90));
        float _t173 = Math.fma(_self10, _t42, _t133);
        float _t174 = Math.fma(_self11, _t40, _t135);
        float _t176 = Math.fma(_self00, _t43, Math.fma(_self03, _t46, _t105));
        float _t177 = Math.fma(_self10, _t40, _t149);
        float _t179 = Math.fma(_self00, _t52, Math.fma(_self03, _t54, -(_self01 * _t57)));
        float _t180 = Math.fma(_self00, _t41, Math.fma(_self03, _t48, _t112));
        float _t181 = Math.fma(_self10, _t41, _t161);
        float _t182 = Math.fma(_t0, _t43, Math.fma(_self02, _t44, -(_self03 * _t45)));
        float _t183 = Math.fma(_t1, _t42, Math.fma(_self01, _t49, -(_self02 * _t48)));
        float _t184 = Math.fma(_t2, _t42, _t137);
        float _t185 = Math.fma(-_self11, _t40, _t130);
        float _t186 = Math.fma(_t1, _t51, Math.fma(_self01, _t53, -(_self02 * _t54)));
        float _t188 = Math.fma(_t1, _t40, Math.fma(_self02, _t56, -(_self03 * _t49)));
        float _t189 = Math.fma(_t2, _t40, _t152);
        float _t190 = Math.fma(_t1, _t50, Math.fma(_self02, _t57, -(_self03 * _t53)));
        float _t191 = Math.fma(_t1, _t44, Math.fma(_self01, _t55, -(_self03 * _t47)));
        float _t192 = Math.fma(_t2, _t41, _t159);
        float _t216 = _t140 + _t182;
        float _t223 = _t164 + _t191;
        float _t228 = _t170 + Math.fma(_self00, _t42, _t141);
        float _t230 = _t176 + Math.fma(_self00, _t40, _t153);
        float _t243 = _t183 + _t186;
        float _t244 = Math.fma(_t0, _t40, _t140) + _t182;
        float _t246 = _t188 + _t190;
        float _t249 = Math.fma(_t1, _t41, _t164) + _t191;
        float _t250 = Math.fma(_self00, _t42, _t102) + Math.fma(_self02, _t48, _t63) + (_t133 + _t170);
        float _t250_inv = 1.0f / _t250;
        float _t252 = _t132 + Math.fma(_self02, _t47, _t63) + (_t133 + _t183);
        float _t252_inv = 1.0f / _t252;
        float _t254 = _t132 + Math.fma(_self02, _t47, _self00 * _t42) + (_t141 + _t184);
        float _t254_inv = 1.0f / _t254;
        float _t259 = _t132 + Math.fma(_self02, _t47, -_t63) + (_t137 + _t183);
        float _t259_inv = 1.0f / _t259;
        float _t267 = _t228 + (_t173 + _t186);
        float _t267_inv = 1.0f / _t267;
        float _t271 = _t170 + _t173 + _t243;
        float _t271_inv = 1.0f / _t271;
        float _t273 = _t228 + (_t184 + _t186);
        float _t273_inv = 1.0f / _t273;
        float _t278 = _t170 + _t184 + _t243;
        float _t278_inv = 1.0f / _t278;
        float _t282 = (Math.fma(_self00, _t40, _t110) + Math.fma(_self03, _t49, _t75) + (_t149 + _t176)) * _t250_inv;
        float _t283 = (_t148 + Math.fma(_self03, _t46, _t75) + (_t149 + _t188)) * _t252_inv;
        float _t284 = (_t148 + Math.fma(_self03, _t46, _self00 * _t40) + (_t153 + _t189)) * _t254_inv;
        float _t285 = (_t128 + Math.fma(_self03, _t42, _t91) + (_t130 + _t182)) * _t252_inv;
        float _t286 = (_t128 + Math.fma(_self03, _t42, _t59) + (_t135 + _t182)) * _t259_inv;
        float _t287 = (Math.fma(_self11, _t40, _t97) + Math.fma(_self13, _t42, -(_self01 * _t40)) + _t216) * _t254_inv;
        float _t288 = (Math.fma(_self12, _t41, _t91) + Math.fma(_t0, _t40, _t92) + _t216) * _t250_inv;
        float _t289 = (_t157 + Math.fma(_self03, _t48, _t113) + (_t159 + _t191)) * _t252_inv;
        float _t290 = (_t157 + Math.fma(_self03, _t48, _t83) + (_t161 + _t191)) * _t259_inv;
        float _t291 = (Math.fma(_self10, _t41, _t116) + Math.fma(_self13, _t48, -(_self00 * _t41)) + _t223) * _t254_inv;
        float _t292 = (Math.fma(_self11, _t56, _t113) + Math.fma(_t1, _t41, _t114) + _t223) * _t250_inv;
        float _t293 = (_t148 + Math.fma(_self03, _t46, -_t75) + (_t152 + _t188)) * _t259_inv;
        float _t294 = (_t230 + (_t177 + _t190)) * _t267_inv;
        float _t295 = (_t171 + _t172 + (_t185 + _t182)) * _t271_inv;
        float _t296 = (_t172 + _t174 + (_t171 + _t182)) * _t278_inv;
        float _t297 = (_t171 + _t174 + _t244) * _t273_inv;
        float _t298 = (_t171 + _t185 + _t244) * _t267_inv;
        float _t299 = (_t176 + _t177 + _t246) * _t271_inv;
        float _t300 = (_t230 + (_t189 + _t190)) * _t273_inv;
        float _t301 = (_t179 + _t180 + (_t192 + _t191)) * _t271_inv;
        float _t302 = (_t180 + _t181 + (_t179 + _t191)) * _t278_inv;
        float _t303 = (_t179 + _t181 + _t249) * _t273_inv;
        float _t304 = (_t179 + _t192 + _t249) * _t267_inv;
        float _t305 = (_t176 + _t189 + _t246) * _t278_inv;
        dest[destOffset + 0] = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t285, _t286), _t287), _t288), _t295), _t296), _t297), _t298);
        dest[destOffset + 1] = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t283, _t293), _t284), _t282), _t299), _t305), _t300), _t294);
        dest[destOffset + 2] = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t289, _t290), _t291), _t292), _t301), _t302), _t303), _t304);
        dest[destOffset + 3] = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t285, _t286), _t287), _t288), _t295), _t296), _t297), _t298);
        dest[destOffset + 4] = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t283, _t293), _t284), _t282), _t299), _t305), _t300), _t294);
        dest[destOffset + 5] = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t289, _t290), _t291), _t292), _t301), _t302), _t303), _t304);
        return dest;
    }

    public static float[] frustumCorner_no(float[] dest, int destOffset, float[] src, int srcOffset, FrustumCorner corner) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t1 = -_self01;
        float _t2 = -_self00;
        float _t3 = -_self10;
        float _t40 = Math.fma(_self22, _self33, -(_self23 * _self32));
        float _t41 = Math.fma(_self21, _self32, -(_self22 * _self31));
        float _t42 = Math.fma(_self21, _self33, -(_self23 * _self31));
        float _t43 = Math.fma(_self12, _self33, -(_self13 * _self32));
        float _t44 = Math.fma(_self11, _self33, -(_self13 * _self31));
        float _t45 = Math.fma(_self11, _self32, -(_self12 * _self31));
        float _t46 = Math.fma(_self12, _self23, -(_self13 * _self22));
        float _t47 = Math.fma(_self11, _self23, -(_self13 * _self21));
        float _t48 = Math.fma(_self11, _self22, -(_self12 * _self21));
        float _t49 = Math.fma(_self10, _self31, -(_self11 * _self30));
        float _t50 = Math.fma(_self10, _self32, -(_self12 * _self30));
        float _t51 = Math.fma(_self20, _self31, -(_self21 * _self30));
        float _t52 = Math.fma(_self20, _self32, -(_self22 * _self30));
        float _t53 = Math.fma(_self10, _self21, -(_self11 * _self20));
        float _t54 = Math.fma(_self10, _self22, -(_self12 * _self20));
        float _t55 = Math.fma(_self10, _self33, -(_self13 * _self30));
        float _t56 = Math.fma(_self20, _self33, -(_self23 * _self30));
        float _t57 = Math.fma(_self10, _self23, -(_self13 * _self20));
        float _t142 = Math.fma(_self01, _t40, Math.fma(_self03, _t41, -(_self02 * _t42)));
        float _t143 = Math.fma(_self00, _t45, Math.fma(_self02, _t49, -(_self01 * _t50)));
        float _t144 = Math.fma(_self10, _t41, Math.fma(_self12, _t51, -(_self11 * _t52)));
        float _t145 = Math.fma(_self00, _t48, Math.fma(_self02, _t53, -(_self01 * _t54)));
        float _t146 = Math.fma(_self11, _t40, Math.fma(_self13, _t41, -(_self12 * _t42)));
        float _t147 = Math.fma(_self00, _t41, Math.fma(_self02, _t51, -(_self01 * _t52)));
        float _t148 = Math.fma(_self01, _t43, Math.fma(_self03, _t45, -(_self02 * _t44)));
        float _t149 = Math.fma(_self00, _t43, Math.fma(_self03, _t50, -(_self02 * _t55)));
        float _t150 = Math.fma(_self10, _t40, Math.fma(_self13, _t52, -(_self12 * _t56)));
        float _t151 = Math.fma(_self00, _t46, Math.fma(_self03, _t54, -(_self02 * _t57)));
        float _t152 = Math.fma(_self00, _t40, Math.fma(_self03, _t52, -(_self02 * _t56)));
        float _t153 = Math.fma(_self00, _t42, Math.fma(_self03, _t51, -(_self01 * _t56)));
        float _t154 = Math.fma(_self10, _t42, Math.fma(_self13, _t51, -(_self11 * _t56)));
        float _t155 = Math.fma(_self00, _t44, Math.fma(_self03, _t49, -(_self01 * _t55)));
        float _t156 = Math.fma(-_self11, _t40, Math.fma(_self12, _t42, -(_self13 * _t41)));
        float _t158 = Math.fma(_t1, _t46, Math.fma(_self02, _t47, -(_self03 * _t48)));
        float _t159 = Math.fma(_t2, _t41, Math.fma(_self01, _t52, -(_self02 * _t51)));
        float _t160 = Math.fma(_t3, _t41, Math.fma(_self11, _t52, -(_self12 * _t51)));
        float _t161 = Math.fma(_t1, _t40, Math.fma(_self02, _t42, -(_self03 * _t41)));
        float _t162 = Math.fma(_t2, _t45, Math.fma(_self01, _t50, -(_self02 * _t49)));
        float _t163 = Math.fma(_t2, _t40, Math.fma(_self02, _t56, -(_self03 * _t52)));
        float _t164 = Math.fma(_t3, _t40, Math.fma(_self12, _t56, -(_self13 * _t52)));
        float _t165 = Math.fma(_t2, _t43, Math.fma(_self02, _t55, -(_self03 * _t50)));
        float _t166 = Math.fma(_t3, _t42, Math.fma(_self11, _t56, -(_self13 * _t51)));
        float _t168 = Math.fma(_t2, _t47, Math.fma(_self01, _t57, -(_self03 * _t53)));
        float _t169 = Math.fma(_t2, _t42, Math.fma(_self01, _t56, -(_self03 * _t51)));
        float _t171 = _t142 + _t146;
        float _t176 = _t145 + _t147;
        float _t177 = _t151 + _t152;
        float _t178 = _t153 + _t154;
        float _t179 = _t159 + _t145;
        float _t184 = _t163 + _t151;
        float _t185 = Math.fma(_t1, _t43, Math.fma(_self02, _t44, -(_self03 * _t45))) + _t158;
        float _t186 = _t159 + _t162;
        float _t187 = _t161 + _t158;
        float _t189 = _t163 + _t165;
        float _t190 = Math.fma(_t2, _t44, Math.fma(_self01, _t55, -(_self03 * _t49))) + _t168;
        float _t191 = _t169 + _t168;
        float _t192 = _t147 + _t144 + (_t143 + _t145);
        float _t192_inv = 1.0f / _t192;
        float _t193 = _t143 + _t144 + _t179;
        float _t193_inv = 1.0f / _t193;
        float _t194 = _t143 + _t147 + (_t160 + _t145);
        float _t194_inv = 1.0f / _t194;
        float _t195 = _t176 + (_t144 + _t162);
        float _t195_inv = 1.0f / _t195;
        float _t196 = _t143 + _t160 + _t179;
        float _t196_inv = 1.0f / _t196;
        float _t197 = _t145 + _t144 + _t186;
        float _t197_inv = 1.0f / _t197;
        float _t198 = _t176 + (_t160 + _t162);
        float _t198_inv = 1.0f / _t198;
        float _t199 = _t145 + _t160 + _t186;
        float _t199_inv = 1.0f / _t199;
        float _idxSw0;
        float _idxSw1;
        float _idxSw2;
        switch (corner) {
            case NXNYNZ: _idxSw0 = (_t142 + _t156 + _t185) * _t193_inv; _idxSw1 = (_t149 + _t150 + _t184) * _t193_inv; _idxSw2 = (_t153 + _t166 + _t190) * _t193_inv; break;
            case PXNYNZ: _idxSw0 = (_t171 + _t185) * _t196_inv; _idxSw1 = (_t149 + _t164 + _t184) * _t196_inv; _idxSw2 = (_t178 + _t190) * _t196_inv; break;
            case PXPYNZ: _idxSw0 = (_t146 + _t161 + _t185) * _t194_inv; _idxSw1 = (_t149 + _t152 + (_t164 + _t151)) * _t194_inv; _idxSw2 = (_t154 + _t169 + _t190) * _t194_inv; break;
            case NXPYNZ: _idxSw0 = (_t156 + _t161 + _t185) * _t192_inv; _idxSw1 = (_t152 + _t150 + (_t149 + _t151)) * _t192_inv; _idxSw2 = (_t166 + _t169 + _t190) * _t192_inv; break;
            case NXNYPZ: _idxSw0 = (_t148 + _t142 + (_t156 + _t158)) * _t197_inv; _idxSw1 = (_t151 + _t150 + _t189) * _t197_inv; _idxSw2 = (_t155 + _t153 + (_t166 + _t168)) * _t197_inv; break;
            case PXNYPZ: _idxSw0 = (_t171 + (_t148 + _t158)) * _t199_inv; _idxSw1 = (_t151 + _t164 + _t189) * _t199_inv; _idxSw2 = (_t178 + (_t155 + _t168)) * _t199_inv; break;
            case PXPYPZ: _idxSw0 = (_t148 + _t146 + _t187) * _t198_inv; _idxSw1 = (_t177 + (_t164 + _t165)) * _t198_inv; _idxSw2 = (_t155 + _t154 + _t191) * _t198_inv; break;
            case NXPYPZ: _idxSw0 = (_t148 + _t156 + _t187) * _t195_inv; _idxSw1 = (_t177 + (_t150 + _t165)) * _t195_inv; _idxSw2 = (_t155 + _t166 + _t191) * _t195_inv; break;
            default: throw new IllegalArgumentException("Unknown FrustumCorner: " + corner);
        }
        dest[destOffset + 0] = _idxSw0;
        dest[destOffset + 1] = _idxSw1;
        dest[destOffset + 2] = _idxSw2;
        return dest;
    }

    public static float[] frustumCorner_zo(float[] dest, int destOffset, float[] src, int srcOffset, FrustumCorner corner) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = -_self01;
        float _t1 = -_self00;
        float _t2 = -_self10;
        float _t40 = Math.fma(_self22, _self33, -(_self23 * _self32));
        float _t41 = Math.fma(_self21, _self33, -(_self23 * _self31));
        float _t42 = Math.fma(_self21, _self32, -(_self22 * _self31));
        float _t43 = Math.fma(_self12, _self23, -(_self13 * _self22));
        float _t44 = Math.fma(_self11, _self23, -(_self13 * _self21));
        float _t45 = Math.fma(_self11, _self22, -(_self12 * _self21));
        float _t46 = Math.fma(_self10, _self22, -(_self12 * _self20));
        float _t47 = Math.fma(_self10, _self21, -(_self11 * _self20));
        float _t48 = Math.fma(_self20, _self31, -(_self21 * _self30));
        float _t49 = Math.fma(_self20, _self32, -(_self22 * _self30));
        float _t50 = Math.fma(_self12, _self33, -(_self13 * _self32));
        float _t51 = Math.fma(_self11, _self32, -(_self12 * _self31));
        float _t52 = Math.fma(_self11, _self33, -(_self13 * _self31));
        float _t53 = Math.fma(_self10, _self32, -(_self12 * _self30));
        float _t54 = Math.fma(_self10, _self31, -(_self11 * _self30));
        float _t55 = Math.fma(_self10, _self23, -(_self13 * _self20));
        float _t56 = Math.fma(_self20, _self33, -(_self23 * _self30));
        float _t57 = Math.fma(_self10, _self33, -(_self13 * _self30));
        float _t59 = _self11 * _t40;
        float _t63 = _self10 * _t42;
        float _t74 = _self10 * _t40;
        float _t81 = _self10 * _t41;
        float _t87 = -(_self02 * _t41);
        float _t88 = -_t59;
        float _t89 = -(_self13 * _t42);
        float _t91 = -(_self01 * _t46);
        float _t94 = -(_self12 * _t41);
        float _t98 = -(_self01 * _t49);
        float _t101 = -(_self02 * _t55);
        float _t105 = -(_self02 * _t56);
        float _t107 = -(_self01 * _t56);
        float _t108 = -_t81;
        float _t109 = -(_self13 * _t48);
        float _t111 = -(_self11 * _t56);
        float _t117 = Math.fma(_self01, _t40, _t87);
        float _t118 = Math.fma(_self12, _t41, _t89);
        float _t120 = Math.fma(_self00, _t45, _t91);
        float _t121 = Math.fma(_self12, _t48, -(_self11 * _t49));
        float _t123 = Math.fma(_self13, _t42, _t94);
        float _t125 = Math.fma(_self11, _t49, -(_self12 * _t48));
        float _t126 = Math.fma(_self02, _t41, -(_self03 * _t42));
        float _t127 = Math.fma(_self02, _t48, _t98);
        float _t133 = Math.fma(_self00, _t43, _t101);
        float _t134 = Math.fma(_self13, _t49, -(_self12 * _t56));
        float _t136 = Math.fma(_self12, _t56, -(_self13 * _t49));
        float _t137 = Math.fma(_self03, _t49, _t105);
        float _t140 = Math.fma(_self00, _t41, _t107);
        float _t141 = Math.fma(_self11, _t56, _t109);
        float _t143 = Math.fma(_self13, _t48, _t111);
        float _t144 = Math.fma(_self01, _t56, -(_self03 * _t48));
        float _t147 = Math.fma(_self00, _t45, Math.fma(_self02, _t47, _t91));
        float _t148 = Math.fma(_self01, _t50, Math.fma(_self03, _t51, -(_self02 * _t52)));
        float _t149 = Math.fma(_self01, _t40, Math.fma(_self03, _t42, _t87));
        float _t150 = Math.fma(_self10, _t42, _t121);
        float _t151 = Math.fma(_self11, _t40, _t123);
        float _t153 = Math.fma(_self00, _t43, Math.fma(_self03, _t46, _t101));
        float _t154 = Math.fma(_self10, _t40, _t134);
        float _t156 = Math.fma(_self00, _t52, Math.fma(_self03, _t54, -(_self01 * _t57)));
        float _t157 = Math.fma(_self00, _t41, Math.fma(_self03, _t48, _t107));
        float _t158 = Math.fma(_self10, _t41, _t143);
        float _t159 = Math.fma(_t0, _t43, Math.fma(_self02, _t44, -(_self03 * _t45)));
        float _t160 = Math.fma(_t1, _t42, Math.fma(_self01, _t49, -(_self02 * _t48)));
        float _t161 = Math.fma(_t2, _t42, _t125);
        float _t162 = Math.fma(-_self11, _t40, _t118);
        float _t163 = Math.fma(_t1, _t51, Math.fma(_self01, _t53, -(_self02 * _t54)));
        float _t165 = Math.fma(_t1, _t40, Math.fma(_self02, _t56, -(_self03 * _t49)));
        float _t166 = Math.fma(_t2, _t40, _t136);
        float _t167 = Math.fma(_t1, _t50, Math.fma(_self02, _t57, -(_self03 * _t53)));
        float _t168 = Math.fma(_t1, _t44, Math.fma(_self01, _t55, -(_self03 * _t47)));
        float _t169 = Math.fma(_t2, _t41, _t141);
        float _t178 = _t126 + _t159;
        float _t180 = _t144 + _t168;
        float _t182 = _t147 + Math.fma(_self00, _t42, _t127);
        float _t183 = _t153 + Math.fma(_self00, _t40, _t137);
        float _t186 = _t160 + _t163;
        float _t187 = Math.fma(_t0, _t40, _t126) + _t159;
        float _t189 = _t165 + _t167;
        float _t190 = Math.fma(_t1, _t41, _t144) + _t168;
        float _t191 = Math.fma(_self00, _t42, _t98) + Math.fma(_self02, _t48, _t63) + (_t121 + _t147);
        float _t191_inv = 1.0f / _t191;
        float _t192 = _t120 + Math.fma(_self02, _t47, _t63) + (_t121 + _t160);
        float _t192_inv = 1.0f / _t192;
        float _t193 = _t120 + Math.fma(_self02, _t47, _self00 * _t42) + (_t127 + _t161);
        float _t193_inv = 1.0f / _t193;
        float _t194 = _t120 + Math.fma(_self02, _t47, -_t63) + (_t125 + _t160);
        float _t194_inv = 1.0f / _t194;
        float _t195 = _t182 + (_t150 + _t163);
        float _t195_inv = 1.0f / _t195;
        float _t196 = _t147 + _t150 + _t186;
        float _t196_inv = 1.0f / _t196;
        float _t197 = _t182 + (_t161 + _t163);
        float _t197_inv = 1.0f / _t197;
        float _t198 = _t147 + _t161 + _t186;
        float _t198_inv = 1.0f / _t198;
        float _idxSw0;
        float _idxSw1;
        float _idxSw2;
        switch (corner) {
            case NXNYNZ: _idxSw0 = (_t117 + Math.fma(_self03, _t42, _t88) + (_t118 + _t159)) * _t192_inv; _idxSw1 = (_t133 + Math.fma(_self03, _t46, _t74) + (_t134 + _t165)) * _t192_inv; _idxSw2 = (_t140 + Math.fma(_self03, _t48, _t108) + (_t141 + _t168)) * _t192_inv; break;
            case PXNYNZ: _idxSw0 = (_t117 + Math.fma(_self03, _t42, _t59) + (_t123 + _t159)) * _t194_inv; _idxSw1 = (_t133 + Math.fma(_self03, _t46, -_t74) + (_t136 + _t165)) * _t194_inv; _idxSw2 = (_t140 + Math.fma(_self03, _t48, _t81) + (_t143 + _t168)) * _t194_inv; break;
            case PXPYNZ: _idxSw0 = (Math.fma(_self11, _t40, _t94) + Math.fma(_self13, _t42, -(_self01 * _t40)) + _t178) * _t193_inv; _idxSw1 = (_t133 + Math.fma(_self03, _t46, _self00 * _t40) + (_t137 + _t166)) * _t193_inv; _idxSw2 = (Math.fma(_self10, _t41, _t111) + Math.fma(_self13, _t48, -(_self00 * _t41)) + _t180) * _t193_inv; break;
            case NXPYNZ: _idxSw0 = (Math.fma(_self12, _t41, _t88) + Math.fma(_t0, _t40, _t89) + _t178) * _t191_inv; _idxSw1 = (Math.fma(_self00, _t40, _t105) + Math.fma(_self03, _t49, _t74) + (_t134 + _t153)) * _t191_inv; _idxSw2 = (Math.fma(_self11, _t56, _t108) + Math.fma(_t1, _t41, _t109) + _t180) * _t191_inv; break;
            case NXNYPZ: _idxSw0 = (_t148 + _t149 + (_t162 + _t159)) * _t196_inv; _idxSw1 = (_t153 + _t154 + _t189) * _t196_inv; _idxSw2 = (_t156 + _t157 + (_t169 + _t168)) * _t196_inv; break;
            case PXNYPZ: _idxSw0 = (_t149 + _t151 + (_t148 + _t159)) * _t198_inv; _idxSw1 = (_t153 + _t166 + _t189) * _t198_inv; _idxSw2 = (_t157 + _t158 + (_t156 + _t168)) * _t198_inv; break;
            case PXPYPZ: _idxSw0 = (_t148 + _t151 + _t187) * _t197_inv; _idxSw1 = (_t183 + (_t166 + _t167)) * _t197_inv; _idxSw2 = (_t156 + _t158 + _t190) * _t197_inv; break;
            case NXPYPZ: _idxSw0 = (_t148 + _t162 + _t187) * _t195_inv; _idxSw1 = (_t183 + (_t154 + _t167)) * _t195_inv; _idxSw2 = (_t156 + _t169 + _t190) * _t195_inv; break;
            default: throw new IllegalArgumentException("Unknown FrustumCorner: " + corner);
        }
        dest[destOffset + 0] = _idxSw0;
        dest[destOffset + 1] = _idxSw1;
        dest[destOffset + 2] = _idxSw2;
        return dest;
    }

    public static float[] frustumPlane_no(float[] dest, int destOffset, float[] src, int srcOffset, FrustumPlane plane) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _idxSw0;
        float _idxSw1;
        float _idxSw2;
        float _idxSw3;
        switch (plane) {
            case NX: _idxSw0 = _self00 + _self30; _idxSw1 = _self01 + _self31; _idxSw2 = _self02 + _self32; _idxSw3 = _self03 + _self33; break;
            case PX: _idxSw0 = _self30 - _self00; _idxSw1 = _self31 - _self01; _idxSw2 = _self32 - _self02; _idxSw3 = _self33 - _self03; break;
            case NY: _idxSw0 = _self10 + _self30; _idxSw1 = _self11 + _self31; _idxSw2 = _self12 + _self32; _idxSw3 = _self13 + _self33; break;
            case PY: _idxSw0 = _self30 - _self10; _idxSw1 = _self31 - _self11; _idxSw2 = _self32 - _self12; _idxSw3 = _self33 - _self13; break;
            case NZ: _idxSw0 = _self20 + _self30; _idxSw1 = _self21 + _self31; _idxSw2 = _self22 + _self32; _idxSw3 = _self23 + _self33; break;
            case PZ: _idxSw0 = _self30 - _self20; _idxSw1 = _self31 - _self21; _idxSw2 = _self32 - _self22; _idxSw3 = _self33 - _self23; break;
            default: throw new IllegalArgumentException("Unknown FrustumPlane: " + plane);
        }
        dest[destOffset + 0] = _idxSw0;
        dest[destOffset + 1] = _idxSw1;
        dest[destOffset + 2] = _idxSw2;
        dest[destOffset + 3] = _idxSw3;
        return dest;
    }

    public static float[] frustumPlane_zo(float[] dest, int destOffset, float[] src, int srcOffset, FrustumPlane plane) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _idxSw0;
        float _idxSw1;
        float _idxSw2;
        float _idxSw3;
        switch (plane) {
            case NX: _idxSw0 = _self00 + _self30; _idxSw1 = _self01 + _self31; _idxSw2 = _self02 + _self32; _idxSw3 = _self03 + _self33; break;
            case PX: _idxSw0 = _self30 - _self00; _idxSw1 = _self31 - _self01; _idxSw2 = _self32 - _self02; _idxSw3 = _self33 - _self03; break;
            case NY: _idxSw0 = _self10 + _self30; _idxSw1 = _self11 + _self31; _idxSw2 = _self12 + _self32; _idxSw3 = _self13 + _self33; break;
            case PY: _idxSw0 = _self30 - _self10; _idxSw1 = _self31 - _self11; _idxSw2 = _self32 - _self12; _idxSw3 = _self33 - _self13; break;
            case NZ: _idxSw0 = _self20; _idxSw1 = _self21; _idxSw2 = _self22; _idxSw3 = _self23; break;
            case PZ: _idxSw0 = _self30 - _self20; _idxSw1 = _self31 - _self21; _idxSw2 = _self32 - _self22; _idxSw3 = _self33 - _self23; break;
            default: throw new IllegalArgumentException("Unknown FrustumPlane: " + plane);
        }
        dest[destOffset + 0] = _idxSw0;
        dest[destOffset + 1] = _idxSw1;
        dest[destOffset + 2] = _idxSw2;
        dest[destOffset + 3] = _idxSw3;
        return dest;
    }

    public static float[] frustumRayDir_no(float[] dest, int destOffset, float[] src, int srcOffset, float x, float y) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = -_self01;
        float _t1 = -_self00;
        float _t8 = Math.fma(2.0f, x, -1.0f);
        float _t10 = Math.fma(2.0f, y, -1.0f);
        float _t40 = Math.fma(_self12, _self33, -(_self13 * _self32));
        float _t41 = Math.fma(_self11, _self33, -(_self13 * _self31));
        float _t42 = Math.fma(_self11, _self32, -(_self12 * _self31));
        float _t43 = Math.fma(_self21, _self32, -(_self22 * _self31));
        float _t44 = Math.fma(_self22, _self33, -(_self23 * _self32));
        float _t45 = Math.fma(_self21, _self33, -(_self23 * _self31));
        float _t46 = Math.fma(_self12, _self23, -(_self13 * _self22));
        float _t47 = Math.fma(_self11, _self23, -(_self13 * _self21));
        float _t48 = Math.fma(_self11, _self22, -(_self12 * _self21));
        float _t49 = Math.fma(_self10, _self22, -(_self12 * _self20));
        float _t50 = Math.fma(_self10, _self21, -(_self11 * _self20));
        float _t51 = Math.fma(_self20, _self31, -(_self21 * _self30));
        float _t52 = Math.fma(_self20, _self32, -(_self22 * _self30));
        float _t53 = Math.fma(_self10, _self32, -(_self12 * _self30));
        float _t54 = Math.fma(_self10, _self31, -(_self11 * _self30));
        float _t55 = Math.fma(_self10, _self23, -(_self13 * _self20));
        float _t56 = Math.fma(_self20, _self33, -(_self23 * _self30));
        float _t57 = Math.fma(_self10, _self33, -(_self13 * _self30));
        float _t75 = -(_self01 * _t49);
        float _t80 = -(_self02 * _t55);
        float _t88 = Math.fma(_self02, _t47, -(_self03 * _t48));
        float _t99 = Math.fma(_self01, _t55, -(_self03 * _t50));
        float _t100 = Math.fma(_self13, _t43, Math.fma(_self11, _t44, -(_self12 * _t45)));
        float _t106 = Math.fma(_self13, _t51, Math.fma(_self10, _t45, -(_self11 * _t56)));
        float _t109 = Math.fma(_self02, _t51, Math.fma(_self00, _t43, -(_self01 * _t52))) * _t10;
        float _t111 = Math.fma(_self03, _t52, Math.fma(_self00, _t44, -(_self02 * _t56))) * _t10;
        float _t114 = -(Math.fma(_self03, _t43, Math.fma(_self01, _t44, -(_self02 * _t45))) * _t10);
        float _t115 = -(Math.fma(_self12, _t51, Math.fma(_self10, _t43, -(_self11 * _t52))) * _t8);
        float _t116 = -(Math.fma(_self13, _t52, Math.fma(_self10, _t44, -(_self12 * _t56))) * _t8);
        float _t117 = -(Math.fma(_self03, _t51, Math.fma(_self00, _t45, -(_self01 * _t56))) * _t10);
        float _t126 = Math.fma(_self00, _t42, -(_self01 * _t53)) + Math.fma(_self02, _t54, _t109) + (Math.fma(_self00, _t48, _t115) + Math.fma(_self02, _t50, _t75));
        float _t126_inv = 1.0f / _t126;
        float _t127 = Math.fma(_self00, _t48, _t75) + Math.fma(_self02, _t50, _t109) + (Math.fma(_t1, _t42, _t115) + Math.fma(_self01, _t53, -(_self02 * _t54)));
        float _t127_inv = 1.0f / _t127;
        dest[destOffset + 0] = (Math.fma(_self01, _t40, -(_self02 * _t41)) + Math.fma(_self03, _t42, _t100 * _t8) + (Math.fma(_t0, _t46, _t114) + _t88)) * _t127_inv - (Math.fma(_t100, _t8, _t114) + Math.fma(_self02, _t41, -(_self01 * _t40)) + (Math.fma(_t0, _t46, -(_self03 * _t42)) + _t88)) * _t126_inv;
        dest[destOffset + 1] = (Math.fma(_self00, _t46, _t80) + Math.fma(_self03, _t49, _t111) + (Math.fma(_t1, _t40, _t116) + Math.fma(_self02, _t57, -(_self03 * _t53)))) * _t127_inv - (Math.fma(_self00, _t40, -(_self02 * _t57)) + Math.fma(_self03, _t53, _t111) + (Math.fma(_self00, _t46, _t116) + Math.fma(_self03, _t49, _t80))) * _t126_inv;
        dest[destOffset + 2] = (Math.fma(_self00, _t41, -(_self01 * _t57)) + Math.fma(_self03, _t54, _t106 * _t8) + (Math.fma(_t1, _t47, _t117) + _t99)) * _t127_inv - (Math.fma(_t106, _t8, _t117) + Math.fma(_self01, _t57, -(_self00 * _t41)) + (Math.fma(_t1, _t47, -(_self03 * _t54)) + _t99)) * _t126_inv;
        return dest;
    }

    public static float[] frustumRayDir_zo(float[] dest, int destOffset, float[] src, int srcOffset, float x, float y) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = -_self00;
        float _t7 = Math.fma(2.0f, x, -1.0f);
        float _t9 = Math.fma(2.0f, y, -1.0f);
        float _t39 = Math.fma(_self12, _self33, -(_self13 * _self32));
        float _t40 = Math.fma(_self11, _self33, -(_self13 * _self31));
        float _t41 = Math.fma(_self11, _self32, -(_self12 * _self31));
        float _t42 = Math.fma(_self21, _self32, -(_self22 * _self31));
        float _t43 = Math.fma(_self22, _self33, -(_self23 * _self32));
        float _t44 = Math.fma(_self21, _self33, -(_self23 * _self31));
        float _t45 = Math.fma(_self12, _self23, -(_self13 * _self22));
        float _t46 = Math.fma(_self11, _self23, -(_self13 * _self21));
        float _t47 = Math.fma(_self11, _self22, -(_self12 * _self21));
        float _t48 = Math.fma(_self10, _self22, -(_self12 * _self20));
        float _t49 = Math.fma(_self10, _self21, -(_self11 * _self20));
        float _t50 = Math.fma(_self20, _self31, -(_self21 * _self30));
        float _t51 = Math.fma(_self20, _self32, -(_self22 * _self30));
        float _t52 = Math.fma(_self10, _self32, -(_self12 * _self30));
        float _t53 = Math.fma(_self10, _self31, -(_self11 * _self30));
        float _t54 = Math.fma(_self10, _self23, -(_self13 * _self20));
        float _t55 = Math.fma(_self20, _self33, -(_self23 * _self30));
        float _t56 = Math.fma(_self10, _self33, -(_self13 * _self30));
        float _t81 = Math.fma(_self00, _t47, -(_self01 * _t48));
        float _t85 = Math.fma(_self00, _t45, -(_self02 * _t54));
        float _t90 = Math.fma(_self13, _t42, Math.fma(_self11, _t43, -(_self12 * _t44)));
        float _t92 = Math.fma(_self02, _t50, Math.fma(_self00, _t42, -(_self01 * _t51)));
        float _t95 = Math.fma(_self03, _t51, Math.fma(_self00, _t43, -(_self02 * _t55)));
        float _t97 = Math.fma(_self13, _t50, Math.fma(_self10, _t44, -(_self11 * _t55)));
        float _t104 = -(Math.fma(_self03, _t42, Math.fma(_self01, _t43, -(_self02 * _t44))) * _t9);
        float _t105 = -(Math.fma(_self12, _t50, Math.fma(_self10, _t42, -(_self11 * _t51))) * _t7);
        float _t106 = -(Math.fma(_self13, _t51, Math.fma(_self10, _t43, -(_self12 * _t55))) * _t7);
        float _t107 = -(Math.fma(_self03, _t50, Math.fma(_self00, _t44, -(_self01 * _t55))) * _t9);
        float _t113 = Math.fma(_self02, _t49, _t81) + Math.fma(_t92, _t9, _t105);
        float _t113_inv = 1.0f / _t113;
        float _t114 = _t81 + Math.fma(_self02, _t49, _t92 * _t9) + (Math.fma(_t0, _t41, _t105) + Math.fma(_self01, _t52, -(_self02 * _t53)));
        float _t114_inv = 1.0f / _t114;
        dest[destOffset + 0] = (Math.fma(_self01, _t39, -(_self02 * _t40)) + Math.fma(_self03, _t41, _t90 * _t7) + (Math.fma(-_self01, _t45, _t104) + Math.fma(_self02, _t46, -(_self03 * _t47)))) * _t114_inv - (Math.fma(_t90, _t7, _t104) - Math.fma(_self03, _t47, Math.fma(_self01, _t45, -(_self02 * _t46)))) * _t113_inv;
        dest[destOffset + 1] = (_t85 + Math.fma(_self03, _t48, _t95 * _t9) + (Math.fma(_t0, _t39, _t106) + Math.fma(_self02, _t56, -(_self03 * _t52)))) * _t114_inv - (Math.fma(_self03, _t48, _t85) + Math.fma(_t95, _t9, _t106)) * _t113_inv;
        dest[destOffset + 2] = (Math.fma(_self00, _t40, -(_self01 * _t56)) + Math.fma(_self03, _t53, _t97 * _t7) + (Math.fma(_t0, _t46, _t107) + Math.fma(_self01, _t54, -(_self03 * _t49)))) * _t114_inv - (Math.fma(_t97, _t7, _t107) - Math.fma(_self03, _t49, Math.fma(_self00, _t46, -(_self01 * _t54)))) * _t113_inv;
        return dest;
    }

    public static float testAabb_no(float[] src, int srcOffset, float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = _self00 + _self30;
        float _t1 = _self01 + _self31;
        float _t2 = _self02 + _self32;
        float _t3 = _self30 - _self00;
        float _t4 = _self31 - _self01;
        float _t5 = _self32 - _self02;
        float _t6 = _self10 + _self30;
        float _t7 = _self11 + _self31;
        float _t8 = _self12 + _self32;
        float _t9 = _self30 - _self10;
        float _t10 = _self31 - _self11;
        float _t11 = _self32 - _self12;
        float _t12 = _self20 + _self30;
        float _t13 = _self21 + _self31;
        float _t14 = _self22 + _self32;
        float _t15 = _self30 - _self20;
        float _t16 = _self31 - _self21;
        float _t17 = _self32 - _self22;
        return Math.fma(_t0, _t0 >= 0.0f ? maxX : minX, Math.fma(_t1, _t1 >= 0.0f ? maxY : minY, Math.fma(_t2, _t2 >= 0.0f ? maxZ : minZ, _self03 + _self33))) < 0.0f ? 0.0f : Math.fma(_t3, _t3 >= 0.0f ? maxX : minX, Math.fma(_t4, _t4 >= 0.0f ? maxY : minY, Math.fma(_t5, _t5 >= 0.0f ? maxZ : minZ, _self33 - _self03))) < 0.0f ? 0.0f : Math.fma(_t6, _t6 >= 0.0f ? maxX : minX, Math.fma(_t7, _t7 >= 0.0f ? maxY : minY, Math.fma(_t8, _t8 >= 0.0f ? maxZ : minZ, _self13 + _self33))) < 0.0f ? 0.0f : Math.fma(_t9, _t9 >= 0.0f ? maxX : minX, Math.fma(_t10, _t10 >= 0.0f ? maxY : minY, Math.fma(_t11, _t11 >= 0.0f ? maxZ : minZ, _self33 - _self13))) < 0.0f ? 0.0f : Math.fma(_t12, _t12 >= 0.0f ? maxX : minX, Math.fma(_t13, _t13 >= 0.0f ? maxY : minY, Math.fma(_t14, _t14 >= 0.0f ? maxZ : minZ, _self23 + _self33))) < 0.0f ? 0.0f : Math.fma(_t15, _t15 >= 0.0f ? maxX : minX, Math.fma(_t16, _t16 >= 0.0f ? maxY : minY, Math.fma(_t17, _t17 >= 0.0f ? maxZ : minZ, _self33 - _self23))) < 0.0f ? 0.0f : 1.0f;
    }

    public static float testAabb_zo(float[] src, int srcOffset, float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = _self00 + _self30;
        float _t1 = _self01 + _self31;
        float _t2 = _self02 + _self32;
        float _t3 = _self30 - _self00;
        float _t4 = _self31 - _self01;
        float _t5 = _self32 - _self02;
        float _t6 = _self10 + _self30;
        float _t7 = _self11 + _self31;
        float _t8 = _self12 + _self32;
        float _t9 = _self30 - _self10;
        float _t10 = _self31 - _self11;
        float _t11 = _self32 - _self12;
        float _t12 = _self30 - _self20;
        float _t13 = _self31 - _self21;
        float _t14 = _self32 - _self22;
        return Math.fma(_t0, _t0 >= 0.0f ? maxX : minX, Math.fma(_t1, _t1 >= 0.0f ? maxY : minY, Math.fma(_t2, _t2 >= 0.0f ? maxZ : minZ, _self03 + _self33))) < 0.0f ? 0.0f : Math.fma(_t3, _t3 >= 0.0f ? maxX : minX, Math.fma(_t4, _t4 >= 0.0f ? maxY : minY, Math.fma(_t5, _t5 >= 0.0f ? maxZ : minZ, _self33 - _self03))) < 0.0f ? 0.0f : Math.fma(_t6, _t6 >= 0.0f ? maxX : minX, Math.fma(_t7, _t7 >= 0.0f ? maxY : minY, Math.fma(_t8, _t8 >= 0.0f ? maxZ : minZ, _self13 + _self33))) < 0.0f ? 0.0f : Math.fma(_t9, _t9 >= 0.0f ? maxX : minX, Math.fma(_t10, _t10 >= 0.0f ? maxY : minY, Math.fma(_t11, _t11 >= 0.0f ? maxZ : minZ, _self33 - _self13))) < 0.0f ? 0.0f : Math.fma(_self20, _self20 >= 0.0f ? maxX : minX, Math.fma(_self21, _self21 >= 0.0f ? maxY : minY, Math.fma(_self22, _self22 >= 0.0f ? maxZ : minZ, _self23))) < 0.0f ? 0.0f : Math.fma(_t12, _t12 >= 0.0f ? maxX : minX, Math.fma(_t13, _t13 >= 0.0f ? maxY : minY, Math.fma(_t14, _t14 >= 0.0f ? maxZ : minZ, _self33 - _self23))) < 0.0f ? 0.0f : 1.0f;
    }

    public static float testAabb_no(float[] src, int srcOffset, float[] min, int minOffset, float[] max, int maxOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _minx = min[minOffset + 0];
        float _miny = min[minOffset + 1];
        float _minz = min[minOffset + 2];
        float _maxx = max[maxOffset + 0];
        float _maxy = max[maxOffset + 1];
        float _maxz = max[maxOffset + 2];
        float _t0 = _self00 + _self30;
        float _t1 = _self01 + _self31;
        float _t2 = _self02 + _self32;
        float _t3 = _self30 - _self00;
        float _t4 = _self31 - _self01;
        float _t5 = _self32 - _self02;
        float _t6 = _self10 + _self30;
        float _t7 = _self11 + _self31;
        float _t8 = _self12 + _self32;
        float _t9 = _self30 - _self10;
        float _t10 = _self31 - _self11;
        float _t11 = _self32 - _self12;
        float _t12 = _self20 + _self30;
        float _t13 = _self21 + _self31;
        float _t14 = _self22 + _self32;
        float _t15 = _self30 - _self20;
        float _t16 = _self31 - _self21;
        float _t17 = _self32 - _self22;
        return Math.fma(_t0, _t0 >= 0.0f ? _maxx : _minx, Math.fma(_t1, _t1 >= 0.0f ? _maxy : _miny, Math.fma(_t2, _t2 >= 0.0f ? _maxz : _minz, _self03 + _self33))) < 0.0f ? 0.0f : Math.fma(_t3, _t3 >= 0.0f ? _maxx : _minx, Math.fma(_t4, _t4 >= 0.0f ? _maxy : _miny, Math.fma(_t5, _t5 >= 0.0f ? _maxz : _minz, _self33 - _self03))) < 0.0f ? 0.0f : Math.fma(_t6, _t6 >= 0.0f ? _maxx : _minx, Math.fma(_t7, _t7 >= 0.0f ? _maxy : _miny, Math.fma(_t8, _t8 >= 0.0f ? _maxz : _minz, _self13 + _self33))) < 0.0f ? 0.0f : Math.fma(_t9, _t9 >= 0.0f ? _maxx : _minx, Math.fma(_t10, _t10 >= 0.0f ? _maxy : _miny, Math.fma(_t11, _t11 >= 0.0f ? _maxz : _minz, _self33 - _self13))) < 0.0f ? 0.0f : Math.fma(_t12, _t12 >= 0.0f ? _maxx : _minx, Math.fma(_t13, _t13 >= 0.0f ? _maxy : _miny, Math.fma(_t14, _t14 >= 0.0f ? _maxz : _minz, _self23 + _self33))) < 0.0f ? 0.0f : Math.fma(_t15, _t15 >= 0.0f ? _maxx : _minx, Math.fma(_t16, _t16 >= 0.0f ? _maxy : _miny, Math.fma(_t17, _t17 >= 0.0f ? _maxz : _minz, _self33 - _self23))) < 0.0f ? 0.0f : 1.0f;
    }

    public static float testAabb_zo(float[] src, int srcOffset, float[] min, int minOffset, float[] max, int maxOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _minx = min[minOffset + 0];
        float _miny = min[minOffset + 1];
        float _minz = min[minOffset + 2];
        float _maxx = max[maxOffset + 0];
        float _maxy = max[maxOffset + 1];
        float _maxz = max[maxOffset + 2];
        float _t0 = _self00 + _self30;
        float _t1 = _self01 + _self31;
        float _t2 = _self02 + _self32;
        float _t3 = _self30 - _self00;
        float _t4 = _self31 - _self01;
        float _t5 = _self32 - _self02;
        float _t6 = _self10 + _self30;
        float _t7 = _self11 + _self31;
        float _t8 = _self12 + _self32;
        float _t9 = _self30 - _self10;
        float _t10 = _self31 - _self11;
        float _t11 = _self32 - _self12;
        float _t12 = _self30 - _self20;
        float _t13 = _self31 - _self21;
        float _t14 = _self32 - _self22;
        return Math.fma(_t0, _t0 >= 0.0f ? _maxx : _minx, Math.fma(_t1, _t1 >= 0.0f ? _maxy : _miny, Math.fma(_t2, _t2 >= 0.0f ? _maxz : _minz, _self03 + _self33))) < 0.0f ? 0.0f : Math.fma(_t3, _t3 >= 0.0f ? _maxx : _minx, Math.fma(_t4, _t4 >= 0.0f ? _maxy : _miny, Math.fma(_t5, _t5 >= 0.0f ? _maxz : _minz, _self33 - _self03))) < 0.0f ? 0.0f : Math.fma(_t6, _t6 >= 0.0f ? _maxx : _minx, Math.fma(_t7, _t7 >= 0.0f ? _maxy : _miny, Math.fma(_t8, _t8 >= 0.0f ? _maxz : _minz, _self13 + _self33))) < 0.0f ? 0.0f : Math.fma(_t9, _t9 >= 0.0f ? _maxx : _minx, Math.fma(_t10, _t10 >= 0.0f ? _maxy : _miny, Math.fma(_t11, _t11 >= 0.0f ? _maxz : _minz, _self33 - _self13))) < 0.0f ? 0.0f : Math.fma(_self20, _self20 >= 0.0f ? _maxx : _minx, Math.fma(_self21, _self21 >= 0.0f ? _maxy : _miny, Math.fma(_self22, _self22 >= 0.0f ? _maxz : _minz, _self23))) < 0.0f ? 0.0f : Math.fma(_t12, _t12 >= 0.0f ? _maxx : _minx, Math.fma(_t13, _t13 >= 0.0f ? _maxy : _miny, Math.fma(_t14, _t14 >= 0.0f ? _maxz : _minz, _self33 - _self23))) < 0.0f ? 0.0f : 1.0f;
    }

    public static float testPoint_no(float[] src, int srcOffset, float pointX, float pointY, float pointZ) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        return Math.fma(pointX, _self00 + _self30, Math.fma(pointY, _self01 + _self31, Math.fma(pointZ, _self02 + _self32, _self03 + _self33))) < 0.0f ? 0.0f : Math.fma(pointX, _self30 - _self00, Math.fma(pointY, _self31 - _self01, Math.fma(pointZ, _self32 - _self02, _self33 - _self03))) < 0.0f ? 0.0f : Math.fma(pointX, _self10 + _self30, Math.fma(pointY, _self11 + _self31, Math.fma(pointZ, _self12 + _self32, _self13 + _self33))) < 0.0f ? 0.0f : Math.fma(pointX, _self30 - _self10, Math.fma(pointY, _self31 - _self11, Math.fma(pointZ, _self32 - _self12, _self33 - _self13))) < 0.0f ? 0.0f : Math.fma(pointX, _self20 + _self30, Math.fma(pointY, _self21 + _self31, Math.fma(pointZ, _self22 + _self32, _self23 + _self33))) < 0.0f ? 0.0f : Math.fma(pointX, _self30 - _self20, Math.fma(pointY, _self31 - _self21, Math.fma(pointZ, _self32 - _self22, _self33 - _self23))) < 0.0f ? 0.0f : 1.0f;
    }

    public static float testPoint_zo(float[] src, int srcOffset, float pointX, float pointY, float pointZ) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        return Math.fma(pointX, _self00 + _self30, Math.fma(pointY, _self01 + _self31, Math.fma(pointZ, _self02 + _self32, _self03 + _self33))) < 0.0f ? 0.0f : Math.fma(pointX, _self30 - _self00, Math.fma(pointY, _self31 - _self01, Math.fma(pointZ, _self32 - _self02, _self33 - _self03))) < 0.0f ? 0.0f : Math.fma(pointX, _self10 + _self30, Math.fma(pointY, _self11 + _self31, Math.fma(pointZ, _self12 + _self32, _self13 + _self33))) < 0.0f ? 0.0f : Math.fma(pointX, _self30 - _self10, Math.fma(pointY, _self31 - _self11, Math.fma(pointZ, _self32 - _self12, _self33 - _self13))) < 0.0f ? 0.0f : Math.fma(pointX, _self20, Math.fma(pointY, _self21, Math.fma(pointZ, _self22, _self23))) < 0.0f ? 0.0f : Math.fma(pointX, _self30 - _self20, Math.fma(pointY, _self31 - _self21, Math.fma(pointZ, _self32 - _self22, _self33 - _self23))) < 0.0f ? 0.0f : 1.0f;
    }

    public static float testPoint_no(float[] src, int srcOffset, float[] point, int pointOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _pointx = point[pointOffset + 0];
        float _pointy = point[pointOffset + 1];
        float _pointz = point[pointOffset + 2];
        return Math.fma(_pointx, _self00 + _self30, Math.fma(_pointy, _self01 + _self31, Math.fma(_pointz, _self02 + _self32, _self03 + _self33))) < 0.0f ? 0.0f : Math.fma(_pointx, _self30 - _self00, Math.fma(_pointy, _self31 - _self01, Math.fma(_pointz, _self32 - _self02, _self33 - _self03))) < 0.0f ? 0.0f : Math.fma(_pointx, _self10 + _self30, Math.fma(_pointy, _self11 + _self31, Math.fma(_pointz, _self12 + _self32, _self13 + _self33))) < 0.0f ? 0.0f : Math.fma(_pointx, _self30 - _self10, Math.fma(_pointy, _self31 - _self11, Math.fma(_pointz, _self32 - _self12, _self33 - _self13))) < 0.0f ? 0.0f : Math.fma(_pointx, _self20 + _self30, Math.fma(_pointy, _self21 + _self31, Math.fma(_pointz, _self22 + _self32, _self23 + _self33))) < 0.0f ? 0.0f : Math.fma(_pointx, _self30 - _self20, Math.fma(_pointy, _self31 - _self21, Math.fma(_pointz, _self32 - _self22, _self33 - _self23))) < 0.0f ? 0.0f : 1.0f;
    }

    public static float testPoint_zo(float[] src, int srcOffset, float[] point, int pointOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _pointx = point[pointOffset + 0];
        float _pointy = point[pointOffset + 1];
        float _pointz = point[pointOffset + 2];
        return Math.fma(_pointx, _self00 + _self30, Math.fma(_pointy, _self01 + _self31, Math.fma(_pointz, _self02 + _self32, _self03 + _self33))) < 0.0f ? 0.0f : Math.fma(_pointx, _self30 - _self00, Math.fma(_pointy, _self31 - _self01, Math.fma(_pointz, _self32 - _self02, _self33 - _self03))) < 0.0f ? 0.0f : Math.fma(_pointx, _self10 + _self30, Math.fma(_pointy, _self11 + _self31, Math.fma(_pointz, _self12 + _self32, _self13 + _self33))) < 0.0f ? 0.0f : Math.fma(_pointx, _self30 - _self10, Math.fma(_pointy, _self31 - _self11, Math.fma(_pointz, _self32 - _self12, _self33 - _self13))) < 0.0f ? 0.0f : Math.fma(_pointx, _self20, Math.fma(_pointy, _self21, Math.fma(_pointz, _self22, _self23))) < 0.0f ? 0.0f : Math.fma(_pointx, _self30 - _self20, Math.fma(_pointy, _self31 - _self21, Math.fma(_pointz, _self32 - _self22, _self33 - _self23))) < 0.0f ? 0.0f : 1.0f;
    }

    public static float testSphere_no(float[] src, int srcOffset, float centerX, float centerY, float centerZ, float radius) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = radius * radius;
        float _t1 = _self00 + _self30;
        float _t2 = _self01 + _self31;
        float _t3 = _self02 + _self32;
        float _t5 = _self30 - _self00;
        float _t6 = _self31 - _self01;
        float _t7 = _self32 - _self02;
        float _t9 = _self10 + _self30;
        float _t10 = _self11 + _self31;
        float _t11 = _self12 + _self32;
        float _t13 = _self30 - _self10;
        float _t14 = _self31 - _self11;
        float _t15 = _self32 - _self12;
        float _t17 = _self20 + _self30;
        float _t18 = _self21 + _self31;
        float _t19 = _self22 + _self32;
        float _t21 = _self30 - _self20;
        float _t22 = _self31 - _self21;
        float _t23 = _self32 - _self22;
        float _t47 = Math.fma(centerX, _t1, Math.fma(centerY, _t2, Math.fma(centerZ, _t3, _self03 + _self33)));
        float _t48 = Math.fma(centerX, _t5, Math.fma(centerY, _t6, Math.fma(centerZ, _t7, _self33 - _self03)));
        float _t49 = Math.fma(centerX, _t9, Math.fma(centerY, _t10, Math.fma(centerZ, _t11, _self13 + _self33)));
        float _t50 = Math.fma(centerX, _t13, Math.fma(centerY, _t14, Math.fma(centerZ, _t15, _self33 - _self13)));
        float _t51 = Math.fma(centerX, _t17, Math.fma(centerY, _t18, Math.fma(centerZ, _t19, _self23 + _self33)));
        float _t52 = Math.fma(centerX, _t21, Math.fma(centerY, _t22, Math.fma(centerZ, _t23, _self33 - _self23)));
        float _t69 = _t52 < 0.0f ? _t52 * _t52 > Math.fma(_t23, _t23, Math.fma(_t21, _t21, _t22 * _t22)) * _t0 ? 0.0f : 1.0f : 1.0f;
        float _t71 = _t51 < 0.0f ? _t51 * _t51 > Math.fma(_t19, _t19, Math.fma(_t17, _t17, _t18 * _t18)) * _t0 ? 0.0f : _t69 : _t69;
        float _t73 = _t50 < 0.0f ? _t50 * _t50 > Math.fma(_t15, _t15, Math.fma(_t13, _t13, _t14 * _t14)) * _t0 ? 0.0f : _t71 : _t71;
        float _t75 = _t49 < 0.0f ? _t49 * _t49 > Math.fma(_t11, _t11, Math.fma(_t9, _t9, _t10 * _t10)) * _t0 ? 0.0f : _t73 : _t73;
        float _t77 = _t48 < 0.0f ? _t48 * _t48 > Math.fma(_t7, _t7, Math.fma(_t5, _t5, _t6 * _t6)) * _t0 ? 0.0f : _t75 : _t75;
        return _t47 < 0.0f ? _t47 * _t47 > Math.fma(_t3, _t3, Math.fma(_t1, _t1, _t2 * _t2)) * _t0 ? 0.0f : _t77 : _t77;
    }

    public static float testSphere_zo(float[] src, int srcOffset, float centerX, float centerY, float centerZ, float radius) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = radius * radius;
        float _t1 = _self00 + _self30;
        float _t2 = _self01 + _self31;
        float _t3 = _self02 + _self32;
        float _t5 = _self30 - _self00;
        float _t6 = _self31 - _self01;
        float _t7 = _self32 - _self02;
        float _t9 = _self10 + _self30;
        float _t10 = _self11 + _self31;
        float _t11 = _self12 + _self32;
        float _t13 = _self30 - _self10;
        float _t14 = _self31 - _self11;
        float _t15 = _self32 - _self12;
        float _t18 = _self30 - _self20;
        float _t19 = _self31 - _self21;
        float _t20 = _self32 - _self22;
        float _t35 = Math.fma(centerX, _self20, Math.fma(centerY, _self21, Math.fma(centerZ, _self22, _self23)));
        float _t46 = Math.fma(centerX, _t1, Math.fma(centerY, _t2, Math.fma(centerZ, _t3, _self03 + _self33)));
        float _t47 = Math.fma(centerX, _t5, Math.fma(centerY, _t6, Math.fma(centerZ, _t7, _self33 - _self03)));
        float _t48 = Math.fma(centerX, _t9, Math.fma(centerY, _t10, Math.fma(centerZ, _t11, _self13 + _self33)));
        float _t49 = Math.fma(centerX, _t13, Math.fma(centerY, _t14, Math.fma(centerZ, _t15, _self33 - _self13)));
        float _t50 = Math.fma(centerX, _t18, Math.fma(centerY, _t19, Math.fma(centerZ, _t20, _self33 - _self23)));
        float _t65 = _t50 < 0.0f ? _t50 * _t50 > Math.fma(_t20, _t20, Math.fma(_t18, _t18, _t19 * _t19)) * _t0 ? 0.0f : 1.0f : 1.0f;
        float _t67 = _t35 < 0.0f ? _t35 * _t35 > Math.fma(_self22, _self22, Math.fma(_self20, _self20, _self21 * _self21)) * _t0 ? 0.0f : _t65 : _t65;
        float _t69 = _t49 < 0.0f ? _t49 * _t49 > Math.fma(_t15, _t15, Math.fma(_t13, _t13, _t14 * _t14)) * _t0 ? 0.0f : _t67 : _t67;
        float _t71 = _t48 < 0.0f ? _t48 * _t48 > Math.fma(_t11, _t11, Math.fma(_t9, _t9, _t10 * _t10)) * _t0 ? 0.0f : _t69 : _t69;
        float _t73 = _t47 < 0.0f ? _t47 * _t47 > Math.fma(_t7, _t7, Math.fma(_t5, _t5, _t6 * _t6)) * _t0 ? 0.0f : _t71 : _t71;
        return _t46 < 0.0f ? _t46 * _t46 > Math.fma(_t3, _t3, Math.fma(_t1, _t1, _t2 * _t2)) * _t0 ? 0.0f : _t73 : _t73;
    }

    public static float testSphere_no(float[] src, int srcOffset, float[] center, int centerOffset, float radius) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _centerx = center[centerOffset + 0];
        float _centery = center[centerOffset + 1];
        float _centerz = center[centerOffset + 2];
        float _t0 = radius * radius;
        float _t1 = _self00 + _self30;
        float _t2 = _self01 + _self31;
        float _t3 = _self02 + _self32;
        float _t5 = _self30 - _self00;
        float _t6 = _self31 - _self01;
        float _t7 = _self32 - _self02;
        float _t9 = _self10 + _self30;
        float _t10 = _self11 + _self31;
        float _t11 = _self12 + _self32;
        float _t13 = _self30 - _self10;
        float _t14 = _self31 - _self11;
        float _t15 = _self32 - _self12;
        float _t17 = _self20 + _self30;
        float _t18 = _self21 + _self31;
        float _t19 = _self22 + _self32;
        float _t21 = _self30 - _self20;
        float _t22 = _self31 - _self21;
        float _t23 = _self32 - _self22;
        float _t47 = Math.fma(_centerx, _t1, Math.fma(_centery, _t2, Math.fma(_centerz, _t3, _self03 + _self33)));
        float _t48 = Math.fma(_centerx, _t5, Math.fma(_centery, _t6, Math.fma(_centerz, _t7, _self33 - _self03)));
        float _t49 = Math.fma(_centerx, _t9, Math.fma(_centery, _t10, Math.fma(_centerz, _t11, _self13 + _self33)));
        float _t50 = Math.fma(_centerx, _t13, Math.fma(_centery, _t14, Math.fma(_centerz, _t15, _self33 - _self13)));
        float _t51 = Math.fma(_centerx, _t17, Math.fma(_centery, _t18, Math.fma(_centerz, _t19, _self23 + _self33)));
        float _t52 = Math.fma(_centerx, _t21, Math.fma(_centery, _t22, Math.fma(_centerz, _t23, _self33 - _self23)));
        float _t69 = _t52 < 0.0f ? _t52 * _t52 > Math.fma(_t23, _t23, Math.fma(_t21, _t21, _t22 * _t22)) * _t0 ? 0.0f : 1.0f : 1.0f;
        float _t71 = _t51 < 0.0f ? _t51 * _t51 > Math.fma(_t19, _t19, Math.fma(_t17, _t17, _t18 * _t18)) * _t0 ? 0.0f : _t69 : _t69;
        float _t73 = _t50 < 0.0f ? _t50 * _t50 > Math.fma(_t15, _t15, Math.fma(_t13, _t13, _t14 * _t14)) * _t0 ? 0.0f : _t71 : _t71;
        float _t75 = _t49 < 0.0f ? _t49 * _t49 > Math.fma(_t11, _t11, Math.fma(_t9, _t9, _t10 * _t10)) * _t0 ? 0.0f : _t73 : _t73;
        float _t77 = _t48 < 0.0f ? _t48 * _t48 > Math.fma(_t7, _t7, Math.fma(_t5, _t5, _t6 * _t6)) * _t0 ? 0.0f : _t75 : _t75;
        return _t47 < 0.0f ? _t47 * _t47 > Math.fma(_t3, _t3, Math.fma(_t1, _t1, _t2 * _t2)) * _t0 ? 0.0f : _t77 : _t77;
    }

    public static float testSphere_zo(float[] src, int srcOffset, float[] center, int centerOffset, float radius) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _centerx = center[centerOffset + 0];
        float _centery = center[centerOffset + 1];
        float _centerz = center[centerOffset + 2];
        float _t0 = radius * radius;
        float _t1 = _self00 + _self30;
        float _t2 = _self01 + _self31;
        float _t3 = _self02 + _self32;
        float _t5 = _self30 - _self00;
        float _t6 = _self31 - _self01;
        float _t7 = _self32 - _self02;
        float _t9 = _self10 + _self30;
        float _t10 = _self11 + _self31;
        float _t11 = _self12 + _self32;
        float _t13 = _self30 - _self10;
        float _t14 = _self31 - _self11;
        float _t15 = _self32 - _self12;
        float _t18 = _self30 - _self20;
        float _t19 = _self31 - _self21;
        float _t20 = _self32 - _self22;
        float _t35 = Math.fma(_centerx, _self20, Math.fma(_centery, _self21, Math.fma(_centerz, _self22, _self23)));
        float _t46 = Math.fma(_centerx, _t1, Math.fma(_centery, _t2, Math.fma(_centerz, _t3, _self03 + _self33)));
        float _t47 = Math.fma(_centerx, _t5, Math.fma(_centery, _t6, Math.fma(_centerz, _t7, _self33 - _self03)));
        float _t48 = Math.fma(_centerx, _t9, Math.fma(_centery, _t10, Math.fma(_centerz, _t11, _self13 + _self33)));
        float _t49 = Math.fma(_centerx, _t13, Math.fma(_centery, _t14, Math.fma(_centerz, _t15, _self33 - _self13)));
        float _t50 = Math.fma(_centerx, _t18, Math.fma(_centery, _t19, Math.fma(_centerz, _t20, _self33 - _self23)));
        float _t65 = _t50 < 0.0f ? _t50 * _t50 > Math.fma(_t20, _t20, Math.fma(_t18, _t18, _t19 * _t19)) * _t0 ? 0.0f : 1.0f : 1.0f;
        float _t67 = _t35 < 0.0f ? _t35 * _t35 > Math.fma(_self22, _self22, Math.fma(_self20, _self20, _self21 * _self21)) * _t0 ? 0.0f : _t65 : _t65;
        float _t69 = _t49 < 0.0f ? _t49 * _t49 > Math.fma(_t15, _t15, Math.fma(_t13, _t13, _t14 * _t14)) * _t0 ? 0.0f : _t67 : _t67;
        float _t71 = _t48 < 0.0f ? _t48 * _t48 > Math.fma(_t11, _t11, Math.fma(_t9, _t9, _t10 * _t10)) * _t0 ? 0.0f : _t69 : _t69;
        float _t73 = _t47 < 0.0f ? _t47 * _t47 > Math.fma(_t7, _t7, Math.fma(_t5, _t5, _t6 * _t6)) * _t0 ? 0.0f : _t71 : _t71;
        return _t46 < 0.0f ? _t46 * _t46 > Math.fma(_t3, _t3, Math.fma(_t1, _t1, _t2 * _t2)) * _t0 ? 0.0f : _t73 : _t73;
    }

    public static float[] lerp_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset, float t) {
        for (int _i = 0; _i < 16; _i++) {
            float _eself = src[srcOffset + _i];
            float _eother = other[otherOffset + _i];
            dest[destOffset + _i] = Math.fma(t, _eother - _eself, _eself);
        }
        return dest;
    }

    public static float[] mul_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] right, int rightOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        for (int _l = 0; _l < 4; _l++) {
            int _lo = _l * 4;
            float _eright0 = right[rightOffset + _lo];
            float _eright1 = right[rightOffset + _lo + 1];
            float _eright2 = right[rightOffset + _lo + 2];
            float _eright3 = right[rightOffset + _lo + 3];
            dest[destOffset + _lo] = Math.fma(_eright3, _self03, Math.fma(_eright2, _self02, Math.fma(_eright0, _self00, _eright1 * _self01)));
            dest[destOffset + _lo + 1] = Math.fma(_eright3, _self13, Math.fma(_eright2, _self12, Math.fma(_eright0, _self10, _eright1 * _self11)));
            dest[destOffset + _lo + 2] = Math.fma(_eright3, _self23, Math.fma(_eright2, _self22, Math.fma(_eright0, _self20, _eright1 * _self21)));
            dest[destOffset + _lo + 3] = Math.fma(_eright3, _self33, Math.fma(_eright2, _self32, Math.fma(_eright0, _self30, _eright1 * _self31)));
        }
        return dest;
    }

    public static float[] mulMat2x2_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] right, int rightOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _right00 = right[rightOffset + 0];
        float _right10 = right[rightOffset + 1];
        float _right01 = right[rightOffset + 2];
        float _right11 = right[rightOffset + 3];
        dest[destOffset + 0] = Math.fma(_right00, _self00, _right10 * _self01);
        dest[destOffset + 1] = Math.fma(_right00, _self10, _right10 * _self11);
        dest[destOffset + 2] = Math.fma(_right00, _self20, _right10 * _self21);
        dest[destOffset + 3] = Math.fma(_right00, _self30, _right10 * _self31);
        dest[destOffset + 4] = Math.fma(_right01, _self00, _right11 * _self01);
        dest[destOffset + 5] = Math.fma(_right01, _self10, _right11 * _self11);
        dest[destOffset + 6] = Math.fma(_right01, _self20, _right11 * _self21);
        dest[destOffset + 7] = Math.fma(_right01, _self30, _right11 * _self31);
        dest[destOffset + 8] = _self02;
        dest[destOffset + 9] = _self12;
        dest[destOffset + 10] = _self22;
        dest[destOffset + 11] = _self32;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mulMat2x3_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] right, int rightOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _right00 = right[rightOffset + 0];
        float _right10 = right[rightOffset + 1];
        float _right01 = right[rightOffset + 2];
        float _right11 = right[rightOffset + 3];
        float _right02 = right[rightOffset + 4];
        float _right12 = right[rightOffset + 5];
        dest[destOffset + 0] = Math.fma(_right00, _self00, _right10 * _self01);
        dest[destOffset + 1] = Math.fma(_right00, _self10, _right10 * _self11);
        dest[destOffset + 2] = Math.fma(_right00, _self20, _right10 * _self21);
        dest[destOffset + 3] = Math.fma(_right00, _self30, _right10 * _self31);
        dest[destOffset + 4] = Math.fma(_right01, _self00, _right11 * _self01);
        dest[destOffset + 5] = Math.fma(_right01, _self10, _right11 * _self11);
        dest[destOffset + 6] = Math.fma(_right01, _self20, _right11 * _self21);
        dest[destOffset + 7] = Math.fma(_right01, _self30, _right11 * _self31);
        dest[destOffset + 8] = Math.fma(_right02, _self00, Math.fma(_right12, _self01, _self02));
        dest[destOffset + 9] = Math.fma(_right02, _self10, Math.fma(_right12, _self11, _self12));
        dest[destOffset + 10] = Math.fma(_right02, _self20, Math.fma(_right12, _self21, _self22));
        dest[destOffset + 11] = Math.fma(_right02, _self30, Math.fma(_right12, _self31, _self32));
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mulMat3x3_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] right, int rightOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _right00 = right[rightOffset + 0];
        float _right10 = right[rightOffset + 1];
        float _right20 = right[rightOffset + 2];
        float _right01 = right[rightOffset + 3];
        float _right11 = right[rightOffset + 4];
        float _right21 = right[rightOffset + 5];
        float _right02 = right[rightOffset + 6];
        float _right12 = right[rightOffset + 7];
        float _right22 = right[rightOffset + 8];
        dest[destOffset + 0] = Math.fma(_right20, _self02, Math.fma(_right00, _self00, _right10 * _self01));
        dest[destOffset + 1] = Math.fma(_right20, _self12, Math.fma(_right00, _self10, _right10 * _self11));
        dest[destOffset + 2] = Math.fma(_right20, _self22, Math.fma(_right00, _self20, _right10 * _self21));
        dest[destOffset + 3] = Math.fma(_right20, _self32, Math.fma(_right00, _self30, _right10 * _self31));
        dest[destOffset + 4] = Math.fma(_right21, _self02, Math.fma(_right01, _self00, _right11 * _self01));
        dest[destOffset + 5] = Math.fma(_right21, _self12, Math.fma(_right01, _self10, _right11 * _self11));
        dest[destOffset + 6] = Math.fma(_right21, _self22, Math.fma(_right01, _self20, _right11 * _self21));
        dest[destOffset + 7] = Math.fma(_right21, _self32, Math.fma(_right01, _self30, _right11 * _self31));
        dest[destOffset + 8] = Math.fma(_right22, _self02, Math.fma(_right02, _self00, _right12 * _self01));
        dest[destOffset + 9] = Math.fma(_right22, _self12, Math.fma(_right02, _self10, _right12 * _self11));
        dest[destOffset + 10] = Math.fma(_right22, _self22, Math.fma(_right02, _self20, _right12 * _self21));
        dest[destOffset + 11] = Math.fma(_right22, _self32, Math.fma(_right02, _self30, _right12 * _self31));
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mulMat3x4_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] right, int rightOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _right00 = right[rightOffset + 0];
        float _right01 = right[rightOffset + 1];
        float _right02 = right[rightOffset + 2];
        float _right03 = right[rightOffset + 3];
        float _right10 = right[rightOffset + 4];
        float _right11 = right[rightOffset + 5];
        float _right12 = right[rightOffset + 6];
        float _right13 = right[rightOffset + 7];
        float _right20 = right[rightOffset + 8];
        float _right21 = right[rightOffset + 9];
        float _right22 = right[rightOffset + 10];
        float _right23 = right[rightOffset + 11];
        dest[destOffset + 0] = Math.fma(_right20, _self02, Math.fma(_right00, _self00, _right10 * _self01));
        dest[destOffset + 1] = Math.fma(_right20, _self12, Math.fma(_right00, _self10, _right10 * _self11));
        dest[destOffset + 2] = Math.fma(_right20, _self22, Math.fma(_right00, _self20, _right10 * _self21));
        dest[destOffset + 3] = Math.fma(_right20, _self32, Math.fma(_right00, _self30, _right10 * _self31));
        dest[destOffset + 4] = Math.fma(_right21, _self02, Math.fma(_right01, _self00, _right11 * _self01));
        dest[destOffset + 5] = Math.fma(_right21, _self12, Math.fma(_right01, _self10, _right11 * _self11));
        dest[destOffset + 6] = Math.fma(_right21, _self22, Math.fma(_right01, _self20, _right11 * _self21));
        dest[destOffset + 7] = Math.fma(_right21, _self32, Math.fma(_right01, _self30, _right11 * _self31));
        dest[destOffset + 8] = Math.fma(_right22, _self02, Math.fma(_right02, _self00, _right12 * _self01));
        dest[destOffset + 9] = Math.fma(_right22, _self12, Math.fma(_right02, _self10, _right12 * _self11));
        dest[destOffset + 10] = Math.fma(_right22, _self22, Math.fma(_right02, _self20, _right12 * _self21));
        dest[destOffset + 11] = Math.fma(_right22, _self32, Math.fma(_right02, _self30, _right12 * _self31));
        dest[destOffset + 12] = Math.fma(_right03, _self00, Math.fma(_right13, _self01, Math.fma(_right23, _self02, _self03)));
        dest[destOffset + 13] = Math.fma(_right03, _self10, Math.fma(_right13, _self11, Math.fma(_right23, _self12, _self13)));
        dest[destOffset + 14] = Math.fma(_right03, _self20, Math.fma(_right13, _self21, Math.fma(_right23, _self22, _self23)));
        dest[destOffset + 15] = Math.fma(_right03, _self30, Math.fma(_right13, _self31, Math.fma(_right23, _self32, _self33)));
        return dest;
    }

    public static float[] preMul_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset) {
        float _other00 = other[otherOffset + 0];
        float _other10 = other[otherOffset + 1];
        float _other20 = other[otherOffset + 2];
        float _other30 = other[otherOffset + 3];
        float _other01 = other[otherOffset + 4];
        float _other11 = other[otherOffset + 5];
        float _other21 = other[otherOffset + 6];
        float _other31 = other[otherOffset + 7];
        float _other02 = other[otherOffset + 8];
        float _other12 = other[otherOffset + 9];
        float _other22 = other[otherOffset + 10];
        float _other32 = other[otherOffset + 11];
        float _other03 = other[otherOffset + 12];
        float _other13 = other[otherOffset + 13];
        float _other23 = other[otherOffset + 14];
        float _other33 = other[otherOffset + 15];
        for (int _l = 0; _l < 4; _l++) {
            int _lo = _l * 4;
            float _eself0 = src[srcOffset + _lo];
            float _eself1 = src[srcOffset + _lo + 1];
            float _eself2 = src[srcOffset + _lo + 2];
            float _eself3 = src[srcOffset + _lo + 3];
            dest[destOffset + _lo] = Math.fma(_other03, _eself3, Math.fma(_other02, _eself2, Math.fma(_other00, _eself0, _other01 * _eself1)));
            dest[destOffset + _lo + 1] = Math.fma(_other13, _eself3, Math.fma(_other12, _eself2, Math.fma(_other10, _eself0, _other11 * _eself1)));
            dest[destOffset + _lo + 2] = Math.fma(_other23, _eself3, Math.fma(_other22, _eself2, Math.fma(_other20, _eself0, _other21 * _eself1)));
            dest[destOffset + _lo + 3] = Math.fma(_other33, _eself3, Math.fma(_other32, _eself2, Math.fma(_other30, _eself0, _other31 * _eself1)));
        }
        return dest;
    }

    public static float[] makeOuterProduct_scalar(float[] dest, int destOffset, float[] col, int colOffset, float[] row, int rowOffset) {
        float _colx = col[colOffset + 0];
        float _coly = col[colOffset + 1];
        float _colz = col[colOffset + 2];
        float _colw = col[colOffset + 3];
        float _rowx = row[rowOffset + 0];
        float _rowy = row[rowOffset + 1];
        float _rowz = row[rowOffset + 2];
        float _roww = row[rowOffset + 3];
        dest[destOffset + 0] = _colx * _rowx;
        dest[destOffset + 1] = _coly * _rowx;
        dest[destOffset + 2] = _colz * _rowx;
        dest[destOffset + 3] = _colw * _rowx;
        dest[destOffset + 4] = _colx * _rowy;
        dest[destOffset + 5] = _coly * _rowy;
        dest[destOffset + 6] = _colz * _rowy;
        dest[destOffset + 7] = _colw * _rowy;
        dest[destOffset + 8] = _colx * _rowz;
        dest[destOffset + 9] = _coly * _rowz;
        dest[destOffset + 10] = _colz * _rowz;
        dest[destOffset + 11] = _colw * _rowz;
        dest[destOffset + 12] = _colx * _roww;
        dest[destOffset + 13] = _coly * _roww;
        dest[destOffset + 14] = _colz * _roww;
        dest[destOffset + 15] = _colw * _roww;
        return dest;
    }

    public static float[] arcball_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float radius, float centerX, float centerY, float centerZ, float angleX, float angleY) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
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
        dest[destOffset + 0] = Math.fma(-_self02, _t6, Math.fma(_self00, _t2, _self01 * _t7));
        dest[destOffset + 1] = Math.fma(-_self12, _t6, Math.fma(_self10, _t2, _self11 * _t7));
        dest[destOffset + 2] = Math.fma(-_self22, _t6, Math.fma(_self20, _t2, _self21 * _t7));
        dest[destOffset + 3] = Math.fma(-_self32, _t6, Math.fma(_self30, _t2, _self31 * _t7));
        dest[destOffset + 4] = Math.fma(_self01, _t1, _self02 * _t3);
        dest[destOffset + 5] = Math.fma(_self11, _t1, _self12 * _t3);
        dest[destOffset + 6] = Math.fma(_self21, _t1, _self22 * _t3);
        dest[destOffset + 7] = Math.fma(_self31, _t1, _self32 * _t3);
        dest[destOffset + 8] = Math.fma(_self02, _t8, Math.fma(_self00, _t0, -(_self01 * _t9)));
        dest[destOffset + 9] = Math.fma(_self12, _t8, Math.fma(_self10, _t0, -(_self11 * _t9)));
        dest[destOffset + 10] = Math.fma(_self22, _t8, Math.fma(_self20, _t0, -(_self21 * _t9)));
        dest[destOffset + 11] = Math.fma(_self32, _t8, Math.fma(_self30, _t0, -(_self31 * _t9)));
        dest[destOffset + 12] = Math.fma(_self00, _t15, Math.fma(_self01, _t18, Math.fma(_self02, _t19, _self03)));
        dest[destOffset + 13] = Math.fma(_self10, _t15, Math.fma(_self11, _t18, Math.fma(_self12, _t19, _self13)));
        dest[destOffset + 14] = Math.fma(_self20, _t15, Math.fma(_self21, _t18, Math.fma(_self22, _t19, _self23)));
        dest[destOffset + 15] = Math.fma(_self30, _t15, Math.fma(_self31, _t18, Math.fma(_self32, _t19, _self33)));
        return dest;
    }

    public static float[] arcball_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] center, int centerOffset, float radius, float angleX, float angleY) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _centerx = center[centerOffset + 0];
        float _centery = center[centerOffset + 1];
        float _centerz = center[centerOffset + 2];
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
        dest[destOffset + 0] = Math.fma(-_self02, _t6, Math.fma(_self00, _t2, _self01 * _t7));
        dest[destOffset + 1] = Math.fma(-_self12, _t6, Math.fma(_self10, _t2, _self11 * _t7));
        dest[destOffset + 2] = Math.fma(-_self22, _t6, Math.fma(_self20, _t2, _self21 * _t7));
        dest[destOffset + 3] = Math.fma(-_self32, _t6, Math.fma(_self30, _t2, _self31 * _t7));
        dest[destOffset + 4] = Math.fma(_self01, _t1, _self02 * _t3);
        dest[destOffset + 5] = Math.fma(_self11, _t1, _self12 * _t3);
        dest[destOffset + 6] = Math.fma(_self21, _t1, _self22 * _t3);
        dest[destOffset + 7] = Math.fma(_self31, _t1, _self32 * _t3);
        dest[destOffset + 8] = Math.fma(_self02, _t8, Math.fma(_self00, _t0, -(_self01 * _t9)));
        dest[destOffset + 9] = Math.fma(_self12, _t8, Math.fma(_self10, _t0, -(_self11 * _t9)));
        dest[destOffset + 10] = Math.fma(_self22, _t8, Math.fma(_self20, _t0, -(_self21 * _t9)));
        dest[destOffset + 11] = Math.fma(_self32, _t8, Math.fma(_self30, _t0, -(_self31 * _t9)));
        dest[destOffset + 12] = Math.fma(_self00, _t15, Math.fma(_self01, _t18, Math.fma(_self02, _t19, _self03)));
        dest[destOffset + 13] = Math.fma(_self10, _t15, Math.fma(_self11, _t18, Math.fma(_self12, _t19, _self13)));
        dest[destOffset + 14] = Math.fma(_self20, _t15, Math.fma(_self21, _t18, Math.fma(_self22, _t19, _self23)));
        dest[destOffset + 15] = Math.fma(_self30, _t15, Math.fma(_self31, _t18, Math.fma(_self32, _t19, _self33)));
        return dest;
    }

    public static float[] axonometricDimetric_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float alpha) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = (float) Math.cos(alpha);
        float _t1 = (float) Math.sqrt(2.0f);
        float _t2 = (float) Math.sin(alpha);
        float _t5 = _self00 * _t1;
        float _t6 = _self10 * _t1;
        float _t7 = _self20 * _t1;
        float _t8 = _self30 * _t1;
        float _t9 = 0.5f * _t0 * _t1;
        float _t10 = 0.5f * _t2 * _t1;
        dest[destOffset + 0] = Math.fma(-_self02, _t9, Math.fma(_self01, _t10, 0.5f * _t5));
        dest[destOffset + 1] = Math.fma(-_self12, _t9, Math.fma(_self11, _t10, 0.5f * _t6));
        dest[destOffset + 2] = Math.fma(-_self22, _t9, Math.fma(_self21, _t10, 0.5f * _t7));
        dest[destOffset + 3] = Math.fma(-_self32, _t9, Math.fma(_self31, _t10, 0.5f * _t8));
        dest[destOffset + 4] = Math.fma(_self01, _t0, _self02 * _t2);
        dest[destOffset + 5] = Math.fma(_self11, _t0, _self12 * _t2);
        dest[destOffset + 6] = Math.fma(_self21, _t0, _self22 * _t2);
        dest[destOffset + 7] = Math.fma(_self31, _t0, _self32 * _t2);
        dest[destOffset + 8] = Math.fma(_self02, _t9, Math.fma(0.5f, _t5, -(_self01 * _t10)));
        dest[destOffset + 9] = Math.fma(_self12, _t9, Math.fma(0.5f, _t6, -(_self11 * _t10)));
        dest[destOffset + 10] = Math.fma(_self22, _t9, Math.fma(0.5f, _t7, -(_self21 * _t10)));
        dest[destOffset + 11] = Math.fma(_self32, _t9, Math.fma(0.5f, _t8, -(_self31 * _t10)));
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] axonometricTrimetric_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float alphaX, float alphaY) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = (float) Math.sin(alphaY);
        float _t1 = (float) Math.cos(alphaX);
        float _t2 = (float) Math.cos(alphaY);
        float _t3 = (float) Math.sin(alphaX);
        float _t4 = _t0 * _t1;
        float _t5 = _t3 * _t0;
        float _t6 = _t1 * _t2;
        float _t7 = _t3 * _t2;
        dest[destOffset + 0] = Math.fma(-_self02, _t4, Math.fma(_self00, _t2, _self01 * _t5));
        dest[destOffset + 1] = Math.fma(-_self12, _t4, Math.fma(_self10, _t2, _self11 * _t5));
        dest[destOffset + 2] = Math.fma(-_self22, _t4, Math.fma(_self20, _t2, _self21 * _t5));
        dest[destOffset + 3] = Math.fma(-_self32, _t4, Math.fma(_self30, _t2, _self31 * _t5));
        dest[destOffset + 4] = Math.fma(_self01, _t1, _self02 * _t3);
        dest[destOffset + 5] = Math.fma(_self11, _t1, _self12 * _t3);
        dest[destOffset + 6] = Math.fma(_self21, _t1, _self22 * _t3);
        dest[destOffset + 7] = Math.fma(_self31, _t1, _self32 * _t3);
        dest[destOffset + 8] = Math.fma(_self02, _t6, Math.fma(_self00, _t0, -(_self01 * _t7)));
        dest[destOffset + 9] = Math.fma(_self12, _t6, Math.fma(_self10, _t0, -(_self11 * _t7)));
        dest[destOffset + 10] = Math.fma(_self22, _t6, Math.fma(_self20, _t0, -(_self21 * _t7)));
        dest[destOffset + 11] = Math.fma(_self32, _t6, Math.fma(_self30, _t0, -(_self31 * _t7)));
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] composeTRS_scalar(float[] dest, int destOffset, float translationX, float translationY, float translationZ, float rotationX, float rotationY, float rotationZ, float rotationW, float scaleX, float scaleY, float scaleZ) {
        float _t0 = rotationZ * rotationZ;
        float _t1 = rotationZ * rotationW;
        float _t2 = rotationY * rotationW;
        dest[destOffset + 0] = scaleX * Math.fma(-2.0f, Math.fma(rotationY, rotationY, _t0), 1.0f);
        dest[destOffset + 1] = scaleX * 2.0f * Math.fma(rotationX, rotationY, _t1);
        dest[destOffset + 2] = scaleX * 2.0f * Math.fma(rotationX, rotationZ, -_t2);
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = scaleY * 2.0f * Math.fma(rotationX, rotationY, -_t1);
        dest[destOffset + 5] = scaleY * Math.fma(-2.0f, Math.fma(rotationX, rotationX, _t0), 1.0f);
        dest[destOffset + 6] = scaleY * 2.0f * Math.fma(rotationX, rotationW, rotationY * rotationZ);
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = scaleZ * 2.0f * Math.fma(rotationX, rotationZ, _t2);
        dest[destOffset + 9] = scaleZ * 2.0f * Math.fma(rotationY, rotationZ, -(rotationX * rotationW));
        dest[destOffset + 10] = scaleZ * Math.fma(-2.0f, Math.fma(rotationX, rotationX, rotationY * rotationY), 1.0f);
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = translationX;
        dest[destOffset + 13] = translationY;
        dest[destOffset + 14] = translationZ;
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] composeTRS_scalar(float[] dest, int destOffset, float[] translation, int translationOffset, float[] rotation, int rotationOffset, float[] scale, int scaleOffset) {
        float _translationx = translation[translationOffset + 0];
        float _translationy = translation[translationOffset + 1];
        float _translationz = translation[translationOffset + 2];
        float _rotationx = rotation[rotationOffset + 0];
        float _rotationy = rotation[rotationOffset + 1];
        float _rotationz = rotation[rotationOffset + 2];
        float _rotationw = rotation[rotationOffset + 3];
        float _scalex = scale[scaleOffset + 0];
        float _scaley = scale[scaleOffset + 1];
        float _scalez = scale[scaleOffset + 2];
        float _t0 = _rotationz * _rotationz;
        float _t1 = _rotationz * _rotationw;
        float _t2 = _rotationy * _rotationw;
        dest[destOffset + 0] = _scalex * Math.fma(-2.0f, Math.fma(_rotationy, _rotationy, _t0), 1.0f);
        dest[destOffset + 1] = _scalex * 2.0f * Math.fma(_rotationx, _rotationy, _t1);
        dest[destOffset + 2] = _scalex * 2.0f * Math.fma(_rotationx, _rotationz, -_t2);
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = _scaley * 2.0f * Math.fma(_rotationx, _rotationy, -_t1);
        dest[destOffset + 5] = _scaley * Math.fma(-2.0f, Math.fma(_rotationx, _rotationx, _t0), 1.0f);
        dest[destOffset + 6] = _scaley * 2.0f * Math.fma(_rotationx, _rotationw, _rotationy * _rotationz);
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = _scalez * 2.0f * Math.fma(_rotationx, _rotationz, _t2);
        dest[destOffset + 9] = _scalez * 2.0f * Math.fma(_rotationy, _rotationz, -(_rotationx * _rotationw));
        dest[destOffset + 10] = _scalez * Math.fma(-2.0f, Math.fma(_rotationx, _rotationx, _rotationy * _rotationy), 1.0f);
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = _translationx;
        dest[destOffset + 13] = _translationy;
        dest[destOffset + 14] = _translationz;
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] frustum_no_lh(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (SimdSupport.VECTOR_API) return Float4x4OpsSimd.frustum_no_lh(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
        return Float4x4OpsKernelsArray.frustum_no_lh_scalar(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
    }

    public static float[] frustum_no_lh_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
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
        dest[destOffset + 0] = _self00 * _t0 * _t1_inv;
        dest[destOffset + 1] = _self10 * _t0 * _t1_inv;
        dest[destOffset + 2] = _self20 * _t0 * _t1_inv;
        dest[destOffset + 3] = _self30 * _t0 * _t1_inv;
        dest[destOffset + 4] = _self01 * _t0 * _t2_inv;
        dest[destOffset + 5] = _self11 * _t0 * _t2_inv;
        dest[destOffset + 6] = _self21 * _t0 * _t2_inv;
        dest[destOffset + 7] = _self31 * _t0 * _t2_inv;
        dest[destOffset + 8] = Math.fma(_self02, _t16, _self03 - _self00 * _t5 * _t1_inv - _self01 * _t6 * _t2_inv);
        dest[destOffset + 9] = Math.fma(_self12, _t16, _self13 - _self10 * _t5 * _t1_inv - _self11 * _t6 * _t2_inv);
        dest[destOffset + 10] = Math.fma(_self22, _t16, _self23 - _self20 * _t5 * _t1_inv - _self21 * _t6 * _t2_inv);
        dest[destOffset + 11] = Math.fma(_self32, _t16, _self33 - _self30 * _t5 * _t1_inv - _self31 * _t6 * _t2_inv);
        dest[destOffset + 12] = _self02 * _t17;
        dest[destOffset + 13] = _self12 * _t17;
        dest[destOffset + 14] = _self22 * _t17;
        dest[destOffset + 15] = _self32 * _t17;
        return dest;
    }

    public static float[] frustum_no_rh(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (SimdSupport.VECTOR_API) return Float4x4OpsSimd.frustum_no_rh(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
        return Float4x4OpsKernelsArray.frustum_no_rh_scalar(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
    }

    public static float[] frustum_no_rh_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
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
        dest[destOffset + 0] = _self00 * _t0 * _t1_inv;
        dest[destOffset + 1] = _self10 * _t0 * _t1_inv;
        dest[destOffset + 2] = _self20 * _t0 * _t1_inv;
        dest[destOffset + 3] = _self30 * _t0 * _t1_inv;
        dest[destOffset + 4] = _self01 * _t0 * _t2_inv;
        dest[destOffset + 5] = _self11 * _t0 * _t2_inv;
        dest[destOffset + 6] = _self21 * _t0 * _t2_inv;
        dest[destOffset + 7] = _self31 * _t0 * _t2_inv;
        dest[destOffset + 8] = Math.fma(_self02, _t14, _self00 * _t5 * _t1_inv + _self01 * _t6 * _t2_inv - _self03);
        dest[destOffset + 9] = Math.fma(_self12, _t14, _self10 * _t5 * _t1_inv + _self11 * _t6 * _t2_inv - _self13);
        dest[destOffset + 10] = Math.fma(_self22, _t14, _self20 * _t5 * _t1_inv + _self21 * _t6 * _t2_inv - _self23);
        dest[destOffset + 11] = Math.fma(_self32, _t14, _self30 * _t5 * _t1_inv + _self31 * _t6 * _t2_inv - _self33);
        dest[destOffset + 12] = _self02 * _t16;
        dest[destOffset + 13] = _self12 * _t16;
        dest[destOffset + 14] = _self22 * _t16;
        dest[destOffset + 15] = _self32 * _t16;
        return dest;
    }

    public static float[] frustum_no(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.frustum_no_lh(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar); }
            default -> { return Float4x4OpsKernelsArray.frustum_no_rh(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar); }
        }
    }

    public static float[] frustum_zo_lh(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (SimdSupport.VECTOR_API) return Float4x4OpsSimd.frustum_zo_lh(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
        return Float4x4OpsKernelsArray.frustum_zo_lh_scalar(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
    }

    public static float[] frustum_zo_lh_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
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
        dest[destOffset + 0] = _self00 * _t0 * _t1_inv;
        dest[destOffset + 1] = _self10 * _t0 * _t1_inv;
        dest[destOffset + 2] = _self20 * _t0 * _t1_inv;
        dest[destOffset + 3] = _self30 * _t0 * _t1_inv;
        dest[destOffset + 4] = _self01 * _t0 * _t2_inv;
        dest[destOffset + 5] = _self11 * _t0 * _t2_inv;
        dest[destOffset + 6] = _self21 * _t0 * _t2_inv;
        dest[destOffset + 7] = _self31 * _t0 * _t2_inv;
        dest[destOffset + 8] = Math.fma(_self02, _t12, _self03 - _self00 * _t4 * _t1_inv - _self01 * _t5 * _t2_inv);
        dest[destOffset + 9] = Math.fma(_self12, _t12, _self13 - _self10 * _t4 * _t1_inv - _self11 * _t5 * _t2_inv);
        dest[destOffset + 10] = Math.fma(_self22, _t12, _self23 - _self20 * _t4 * _t1_inv - _self21 * _t5 * _t2_inv);
        dest[destOffset + 11] = Math.fma(_self32, _t12, _self33 - _self30 * _t4 * _t1_inv - _self31 * _t5 * _t2_inv);
        dest[destOffset + 12] = _self02 * _t13;
        dest[destOffset + 13] = _self12 * _t13;
        dest[destOffset + 14] = _self22 * _t13;
        dest[destOffset + 15] = _self32 * _t13;
        return dest;
    }

    public static float[] frustum_zo_rh(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (SimdSupport.VECTOR_API) return Float4x4OpsSimd.frustum_zo_rh(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
        return Float4x4OpsKernelsArray.frustum_zo_rh_scalar(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
    }

    public static float[] frustum_zo_rh_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
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
        dest[destOffset + 0] = _self00 * _t0 * _t1_inv;
        dest[destOffset + 1] = _self10 * _t0 * _t1_inv;
        dest[destOffset + 2] = _self20 * _t0 * _t1_inv;
        dest[destOffset + 3] = _self30 * _t0 * _t1_inv;
        dest[destOffset + 4] = _self01 * _t0 * _t2_inv;
        dest[destOffset + 5] = _self11 * _t0 * _t2_inv;
        dest[destOffset + 6] = _self21 * _t0 * _t2_inv;
        dest[destOffset + 7] = _self31 * _t0 * _t2_inv;
        dest[destOffset + 8] = Math.fma(_self02, _t11, _self00 * _t4 * _t1_inv + _self01 * _t5 * _t2_inv - _self03);
        dest[destOffset + 9] = Math.fma(_self12, _t11, _self10 * _t4 * _t1_inv + _self11 * _t5 * _t2_inv - _self13);
        dest[destOffset + 10] = Math.fma(_self22, _t11, _self20 * _t4 * _t1_inv + _self21 * _t5 * _t2_inv - _self23);
        dest[destOffset + 11] = Math.fma(_self32, _t11, _self30 * _t4 * _t1_inv + _self31 * _t5 * _t2_inv - _self33);
        dest[destOffset + 12] = _self02 * _t12;
        dest[destOffset + 13] = _self12 * _t12;
        dest[destOffset + 14] = _self22 * _t12;
        dest[destOffset + 15] = _self32 * _t12;
        return dest;
    }

    public static float[] frustum_zo(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.frustum_zo_lh(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar); }
            default -> { return Float4x4OpsKernelsArray.frustum_zo_rh(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar); }
        }
    }

    public static float[] lookAlong_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
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
        dest[destOffset + 0] = Math.fma(_self02, _t26, Math.fma(_self00, _t27, _self01 * _t28));
        dest[destOffset + 1] = Math.fma(_self12, _t26, Math.fma(_self10, _t27, _self11 * _t28));
        dest[destOffset + 2] = Math.fma(_self22, _t26, Math.fma(_self20, _t27, _self21 * _t28));
        dest[destOffset + 3] = Math.fma(_self32, _t26, Math.fma(_self30, _t27, _self31 * _t28));
        dest[destOffset + 4] = Math.fma(_self02, _t35, Math.fma(_self00, _t36, _self01 * _t37));
        dest[destOffset + 5] = Math.fma(_self12, _t35, Math.fma(_self10, _t36, _self11 * _t37));
        dest[destOffset + 6] = Math.fma(_self22, _t35, Math.fma(_self20, _t36, _self21 * _t37));
        dest[destOffset + 7] = Math.fma(_self32, _t35, Math.fma(_self30, _t36, _self31 * _t37));
        dest[destOffset + 8] = Math.fma(_self02, _t9, Math.fma(_self00, _t8, _self01 * _t7));
        dest[destOffset + 9] = Math.fma(_self12, _t9, Math.fma(_self10, _t8, _self11 * _t7));
        dest[destOffset + 10] = Math.fma(_self22, _t9, Math.fma(_self20, _t8, _self21 * _t7));
        dest[destOffset + 11] = Math.fma(_self32, _t9, Math.fma(_self30, _t8, _self31 * _t7));
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] lookAlong_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] dir, int dirOffset, float[] up, int upOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _dirx = dir[dirOffset + 0];
        float _diry = dir[dirOffset + 1];
        float _dirz = dir[dirOffset + 2];
        float _upx = up[upOffset + 0];
        float _upy = up[upOffset + 1];
        float _upz = up[upOffset + 2];
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
        dest[destOffset + 0] = Math.fma(_self02, _t26, Math.fma(_self00, _t27, _self01 * _t28));
        dest[destOffset + 1] = Math.fma(_self12, _t26, Math.fma(_self10, _t27, _self11 * _t28));
        dest[destOffset + 2] = Math.fma(_self22, _t26, Math.fma(_self20, _t27, _self21 * _t28));
        dest[destOffset + 3] = Math.fma(_self32, _t26, Math.fma(_self30, _t27, _self31 * _t28));
        dest[destOffset + 4] = Math.fma(_self02, _t35, Math.fma(_self00, _t36, _self01 * _t37));
        dest[destOffset + 5] = Math.fma(_self12, _t35, Math.fma(_self10, _t36, _self11 * _t37));
        dest[destOffset + 6] = Math.fma(_self22, _t35, Math.fma(_self20, _t36, _self21 * _t37));
        dest[destOffset + 7] = Math.fma(_self32, _t35, Math.fma(_self30, _t36, _self31 * _t37));
        dest[destOffset + 8] = Math.fma(_self02, _t9, Math.fma(_self00, _t8, _self01 * _t7));
        dest[destOffset + 9] = Math.fma(_self12, _t9, Math.fma(_self10, _t8, _self11 * _t7));
        dest[destOffset + 10] = Math.fma(_self22, _t9, Math.fma(_self20, _t8, _self21 * _t7));
        dest[destOffset + 11] = Math.fma(_self32, _t9, Math.fma(_self30, _t8, _self31 * _t7));
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] lookAt_lh(float[] dest, int destOffset, float[] src, int srcOffset, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        if (SimdSupport.VECTOR_API) return Float4x4OpsSimd.lookAt_lh(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return Float4x4OpsKernelsArray.lookAt_lh_scalar(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
    }

    public static float[] lookAt_lh_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
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
        dest[destOffset + 0] = Math.fma(_self02, _t10, Math.fma(_self00, _t32, _self01 * _t43));
        dest[destOffset + 1] = Math.fma(_self12, _t10, Math.fma(_self10, _t32, _self11 * _t43));
        dest[destOffset + 2] = Math.fma(_self22, _t10, Math.fma(_self20, _t32, _self21 * _t43));
        dest[destOffset + 3] = Math.fma(_self32, _t10, Math.fma(_self30, _t32, _self31 * _t43));
        dest[destOffset + 4] = Math.fma(_self02, _t11, Math.fma(_self00, _t34, _self01 * _t44));
        dest[destOffset + 5] = Math.fma(_self12, _t11, Math.fma(_self10, _t34, _self11 * _t44));
        dest[destOffset + 6] = Math.fma(_self22, _t11, Math.fma(_self20, _t34, _self21 * _t44));
        dest[destOffset + 7] = Math.fma(_self32, _t11, Math.fma(_self30, _t34, _self31 * _t44));
        dest[destOffset + 8] = Math.fma(_self02, _t12, Math.fma(_self00, _t33, _self01 * _t45));
        dest[destOffset + 9] = Math.fma(_self12, _t12, Math.fma(_self10, _t33, _self11 * _t45));
        dest[destOffset + 10] = Math.fma(_self22, _t12, Math.fma(_self20, _t33, _self21 * _t45));
        dest[destOffset + 11] = Math.fma(_self32, _t12, Math.fma(_self30, _t33, _self31 * _t45));
        dest[destOffset + 12] = Math.fma(-_self00, _t47, Math.fma(-_self01, _t49, Math.fma(-_self02, _t24, _self03)));
        dest[destOffset + 13] = Math.fma(-_self10, _t47, Math.fma(-_self11, _t49, Math.fma(-_self12, _t24, _self13)));
        dest[destOffset + 14] = Math.fma(-_self20, _t47, Math.fma(-_self21, _t49, Math.fma(-_self22, _t24, _self23)));
        dest[destOffset + 15] = Math.fma(-_self30, _t47, Math.fma(-_self31, _t49, Math.fma(-_self32, _t24, _self33)));
        return dest;
    }

    public static float[] lookAt_rh(float[] dest, int destOffset, float[] src, int srcOffset, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        if (SimdSupport.VECTOR_API) return Float4x4OpsSimd.lookAt_rh(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return Float4x4OpsKernelsArray.lookAt_rh_scalar(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
    }

    public static float[] lookAt_rh_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
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
        dest[destOffset + 0] = Math.fma(_t0, _t14, Math.fma(_self00, _t36, _self01 * _t47));
        dest[destOffset + 1] = Math.fma(_t1, _t14, Math.fma(_self10, _t36, _self11 * _t47));
        dest[destOffset + 2] = Math.fma(_t2, _t14, Math.fma(_self20, _t36, _self21 * _t47));
        dest[destOffset + 3] = Math.fma(_t3, _t14, Math.fma(_self30, _t36, _self31 * _t47));
        dest[destOffset + 4] = Math.fma(_t0, _t15, Math.fma(_self00, _t37, _self01 * _t48));
        dest[destOffset + 5] = Math.fma(_t1, _t15, Math.fma(_self10, _t37, _self11 * _t48));
        dest[destOffset + 6] = Math.fma(_t2, _t15, Math.fma(_self20, _t37, _self21 * _t48));
        dest[destOffset + 7] = Math.fma(_t3, _t15, Math.fma(_self30, _t37, _self31 * _t48));
        dest[destOffset + 8] = Math.fma(_t0, _t16, Math.fma(_self00, _t38, _self01 * _t49));
        dest[destOffset + 9] = Math.fma(_t1, _t16, Math.fma(_self10, _t38, _self11 * _t49));
        dest[destOffset + 10] = Math.fma(_t2, _t16, Math.fma(_self20, _t38, _self21 * _t49));
        dest[destOffset + 11] = Math.fma(_t3, _t16, Math.fma(_self30, _t38, _self31 * _t49));
        dest[destOffset + 12] = Math.fma(-_self00, _t51, Math.fma(-_self01, _t53, Math.fma(_self02, _t28, _self03)));
        dest[destOffset + 13] = Math.fma(-_self10, _t51, Math.fma(-_self11, _t53, Math.fma(_self12, _t28, _self13)));
        dest[destOffset + 14] = Math.fma(-_self20, _t51, Math.fma(-_self21, _t53, Math.fma(_self22, _t28, _self23)));
        dest[destOffset + 15] = Math.fma(-_self30, _t51, Math.fma(-_self31, _t53, Math.fma(_self32, _t28, _self33)));
        return dest;
    }

    public static float[] lookAt_lh(float[] dest, int destOffset, float[] src, int srcOffset, float[] eye, int eyeOffset, float[] center, int centerOffset, float[] up, int upOffset) {
        if (SimdSupport.VECTOR_API) return Float4x4OpsSimd.lookAt_lh(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
        return Float4x4OpsKernelsArray.lookAt_lh_scalar(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
    }

    public static float[] lookAt_lh_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] eye, int eyeOffset, float[] center, int centerOffset, float[] up, int upOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _eyex = eye[eyeOffset + 0];
        float _eyey = eye[eyeOffset + 1];
        float _eyez = eye[eyeOffset + 2];
        float _centerx = center[centerOffset + 0];
        float _centery = center[centerOffset + 1];
        float _centerz = center[centerOffset + 2];
        float _upx = up[upOffset + 0];
        float _upy = up[upOffset + 1];
        float _upz = up[upOffset + 2];
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
        dest[destOffset + 0] = Math.fma(_self02, _t10, Math.fma(_self00, _t32, _self01 * _t43));
        dest[destOffset + 1] = Math.fma(_self12, _t10, Math.fma(_self10, _t32, _self11 * _t43));
        dest[destOffset + 2] = Math.fma(_self22, _t10, Math.fma(_self20, _t32, _self21 * _t43));
        dest[destOffset + 3] = Math.fma(_self32, _t10, Math.fma(_self30, _t32, _self31 * _t43));
        dest[destOffset + 4] = Math.fma(_self02, _t11, Math.fma(_self00, _t34, _self01 * _t44));
        dest[destOffset + 5] = Math.fma(_self12, _t11, Math.fma(_self10, _t34, _self11 * _t44));
        dest[destOffset + 6] = Math.fma(_self22, _t11, Math.fma(_self20, _t34, _self21 * _t44));
        dest[destOffset + 7] = Math.fma(_self32, _t11, Math.fma(_self30, _t34, _self31 * _t44));
        dest[destOffset + 8] = Math.fma(_self02, _t12, Math.fma(_self00, _t33, _self01 * _t45));
        dest[destOffset + 9] = Math.fma(_self12, _t12, Math.fma(_self10, _t33, _self11 * _t45));
        dest[destOffset + 10] = Math.fma(_self22, _t12, Math.fma(_self20, _t33, _self21 * _t45));
        dest[destOffset + 11] = Math.fma(_self32, _t12, Math.fma(_self30, _t33, _self31 * _t45));
        dest[destOffset + 12] = Math.fma(-_self00, _t47, Math.fma(-_self01, _t49, Math.fma(-_self02, _t24, _self03)));
        dest[destOffset + 13] = Math.fma(-_self10, _t47, Math.fma(-_self11, _t49, Math.fma(-_self12, _t24, _self13)));
        dest[destOffset + 14] = Math.fma(-_self20, _t47, Math.fma(-_self21, _t49, Math.fma(-_self22, _t24, _self23)));
        dest[destOffset + 15] = Math.fma(-_self30, _t47, Math.fma(-_self31, _t49, Math.fma(-_self32, _t24, _self33)));
        return dest;
    }

    public static float[] lookAt_rh(float[] dest, int destOffset, float[] src, int srcOffset, float[] eye, int eyeOffset, float[] center, int centerOffset, float[] up, int upOffset) {
        if (SimdSupport.VECTOR_API) return Float4x4OpsSimd.lookAt_rh(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
        return Float4x4OpsKernelsArray.lookAt_rh_scalar(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
    }

    public static float[] lookAt_rh_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] eye, int eyeOffset, float[] center, int centerOffset, float[] up, int upOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _eyex = eye[eyeOffset + 0];
        float _eyey = eye[eyeOffset + 1];
        float _eyez = eye[eyeOffset + 2];
        float _centerx = center[centerOffset + 0];
        float _centery = center[centerOffset + 1];
        float _centerz = center[centerOffset + 2];
        float _upx = up[upOffset + 0];
        float _upy = up[upOffset + 1];
        float _upz = up[upOffset + 2];
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
        dest[destOffset + 0] = Math.fma(_t0, _t14, Math.fma(_self00, _t36, _self01 * _t47));
        dest[destOffset + 1] = Math.fma(_t1, _t14, Math.fma(_self10, _t36, _self11 * _t47));
        dest[destOffset + 2] = Math.fma(_t2, _t14, Math.fma(_self20, _t36, _self21 * _t47));
        dest[destOffset + 3] = Math.fma(_t3, _t14, Math.fma(_self30, _t36, _self31 * _t47));
        dest[destOffset + 4] = Math.fma(_t0, _t15, Math.fma(_self00, _t37, _self01 * _t48));
        dest[destOffset + 5] = Math.fma(_t1, _t15, Math.fma(_self10, _t37, _self11 * _t48));
        dest[destOffset + 6] = Math.fma(_t2, _t15, Math.fma(_self20, _t37, _self21 * _t48));
        dest[destOffset + 7] = Math.fma(_t3, _t15, Math.fma(_self30, _t37, _self31 * _t48));
        dest[destOffset + 8] = Math.fma(_t0, _t16, Math.fma(_self00, _t38, _self01 * _t49));
        dest[destOffset + 9] = Math.fma(_t1, _t16, Math.fma(_self10, _t38, _self11 * _t49));
        dest[destOffset + 10] = Math.fma(_t2, _t16, Math.fma(_self20, _t38, _self21 * _t49));
        dest[destOffset + 11] = Math.fma(_t3, _t16, Math.fma(_self30, _t38, _self31 * _t49));
        dest[destOffset + 12] = Math.fma(-_self00, _t51, Math.fma(-_self01, _t53, Math.fma(_self02, _t28, _self03)));
        dest[destOffset + 13] = Math.fma(-_self10, _t51, Math.fma(-_self11, _t53, Math.fma(_self12, _t28, _self13)));
        dest[destOffset + 14] = Math.fma(-_self20, _t51, Math.fma(-_self21, _t53, Math.fma(_self22, _t28, _self23)));
        dest[destOffset + 15] = Math.fma(-_self30, _t51, Math.fma(-_self31, _t53, Math.fma(_self32, _t28, _self33)));
        return dest;
    }

    public static float[] makeFrustum_no_lh(float[] dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _t0 = 2.0f * zNear;
        float _t1 = right - left;
        float _t1_inv = 1.0f / _t1;
        float _t2 = top - bottom;
        float _t2_inv = 1.0f / _t2;
        float _t3 = zNear - zFar;
        float _t3_inv = 1.0f / _t3;
        if (zFar == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = 1.0f;
            dest[destOffset + 14] = -_t0;
        } else {
            if (zNear == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = -1.0f;
                dest[destOffset + 14] = 2.0f * zFar;
            } else {
                dest[destOffset + 10] = -((zFar + zNear) * _t3_inv);
                dest[destOffset + 14] = 2.0f * zFar * zNear * _t3_inv;
            }
        }
        dest[destOffset + 0] = _t0 * _t1_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = _t0 * _t2_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = -((left + right) * _t1_inv);
        dest[destOffset + 9] = -((bottom + top) * _t2_inv);
        dest[destOffset + 11] = 1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makeFrustum_no_rh(float[] dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _t0 = 2.0f * zNear;
        float _t1 = right - left;
        float _t1_inv = 1.0f / _t1;
        float _t2 = top - bottom;
        float _t2_inv = 1.0f / _t2;
        float _t3 = zNear - zFar;
        float _t3_inv = 1.0f / _t3;
        if (zFar == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = -1.0f;
            dest[destOffset + 14] = -_t0;
        } else {
            if (zNear == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = 1.0f;
                dest[destOffset + 14] = 2.0f * zFar;
            } else {
                dest[destOffset + 10] = (zFar + zNear) * _t3_inv;
                dest[destOffset + 14] = 2.0f * zFar * zNear * _t3_inv;
            }
        }
        dest[destOffset + 0] = _t0 * _t1_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = _t0 * _t2_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = (left + right) * _t1_inv;
        dest[destOffset + 9] = (bottom + top) * _t2_inv;
        dest[destOffset + 11] = -1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makeFrustum_no(float[] dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.makeFrustum_no_lh(dest, destOffset, left, right, bottom, top, zNear, zFar); }
            default -> { return Float4x4OpsKernelsArray.makeFrustum_no_rh(dest, destOffset, left, right, bottom, top, zNear, zFar); }
        }
    }

    public static float[] makeFrustum_zo_lh(float[] dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _t0 = 2.0f * zNear;
        float _t1 = right - left;
        float _t1_inv = 1.0f / _t1;
        float _t2 = top - bottom;
        float _t2_inv = 1.0f / _t2;
        float _t3 = zNear - zFar;
        float _t3_inv = 1.0f / _t3;
        if (zFar == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = 1.0f;
            dest[destOffset + 14] = -zNear;
        } else {
            if (zNear == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = 0.0f;
                dest[destOffset + 14] = zFar;
            } else {
                dest[destOffset + 10] = -(zFar * _t3_inv);
                dest[destOffset + 14] = zFar * zNear * _t3_inv;
            }
        }
        dest[destOffset + 0] = _t0 * _t1_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = _t0 * _t2_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = -((left + right) * _t1_inv);
        dest[destOffset + 9] = -((bottom + top) * _t2_inv);
        dest[destOffset + 11] = 1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makeFrustum_zo_rh(float[] dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _t0 = 2.0f * zNear;
        float _t1 = right - left;
        float _t1_inv = 1.0f / _t1;
        float _t2 = top - bottom;
        float _t2_inv = 1.0f / _t2;
        float _t3 = zNear - zFar;
        float _t3_inv = 1.0f / _t3;
        if (zFar == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = -1.0f;
            dest[destOffset + 14] = -zNear;
        } else {
            if (zNear == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = 0.0f;
                dest[destOffset + 14] = zFar;
            } else {
                dest[destOffset + 10] = zFar * _t3_inv;
                dest[destOffset + 14] = zFar * zNear * _t3_inv;
            }
        }
        dest[destOffset + 0] = _t0 * _t1_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = _t0 * _t2_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = (left + right) * _t1_inv;
        dest[destOffset + 9] = (bottom + top) * _t2_inv;
        dest[destOffset + 11] = -1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makeFrustum_zo(float[] dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.makeFrustum_zo_lh(dest, destOffset, left, right, bottom, top, zNear, zFar); }
            default -> { return Float4x4OpsKernelsArray.makeFrustum_zo_rh(dest, destOffset, left, right, bottom, top, zNear, zFar); }
        }
    }

    public static float[] makeLookAt_lh(float[] dest, int destOffset, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
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
        dest[destOffset + 0] = _t29;
        dest[destOffset + 1] = _t38;
        dest[destOffset + 2] = _t11;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = _t30;
        dest[destOffset + 5] = _t39;
        dest[destOffset + 6] = _t10;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = _t31;
        dest[destOffset + 9] = _t40;
        dest[destOffset + 10] = _t12;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -Math.fma(eyeZ, _t31, Math.fma(eyeX, _t29, eyeY * _t30));
        dest[destOffset + 13] = -Math.fma(eyeZ, _t40, Math.fma(eyeX, _t38, eyeY * _t39));
        dest[destOffset + 14] = -Math.fma(eyeZ, _t12, Math.fma(eyeX, _t11, eyeY * _t10));
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] makeLookAt_rh(float[] dest, int destOffset, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
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
        dest[destOffset + 0] = _t29;
        dest[destOffset + 1] = _t38;
        dest[destOffset + 2] = -_t10;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = _t30;
        dest[destOffset + 5] = _t39;
        dest[destOffset + 6] = -_t11;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = _t31;
        dest[destOffset + 9] = _t40;
        dest[destOffset + 10] = -_t12;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -Math.fma(eyeZ, _t31, Math.fma(eyeX, _t29, eyeY * _t30));
        dest[destOffset + 13] = -Math.fma(eyeZ, _t40, Math.fma(eyeX, _t38, eyeY * _t39));
        dest[destOffset + 14] = Math.fma(eyeZ, _t12, Math.fma(eyeX, _t10, eyeY * _t11));
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] makeLookAt_lh(float[] dest, int destOffset, float[] eye, int eyeOffset, float[] center, int centerOffset, float[] up, int upOffset) {
        float _eyex = eye[eyeOffset + 0];
        float _eyey = eye[eyeOffset + 1];
        float _eyez = eye[eyeOffset + 2];
        float _centerx = center[centerOffset + 0];
        float _centery = center[centerOffset + 1];
        float _centerz = center[centerOffset + 2];
        float _upx = up[upOffset + 0];
        float _upy = up[upOffset + 1];
        float _upz = up[upOffset + 2];
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
        dest[destOffset + 0] = _t29;
        dest[destOffset + 1] = _t38;
        dest[destOffset + 2] = _t11;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = _t30;
        dest[destOffset + 5] = _t39;
        dest[destOffset + 6] = _t10;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = _t31;
        dest[destOffset + 9] = _t40;
        dest[destOffset + 10] = _t12;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -Math.fma(_eyez, _t31, Math.fma(_eyex, _t29, _eyey * _t30));
        dest[destOffset + 13] = -Math.fma(_eyez, _t40, Math.fma(_eyex, _t38, _eyey * _t39));
        dest[destOffset + 14] = -Math.fma(_eyez, _t12, Math.fma(_eyex, _t11, _eyey * _t10));
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] makeLookAt_rh(float[] dest, int destOffset, float[] eye, int eyeOffset, float[] center, int centerOffset, float[] up, int upOffset) {
        float _eyex = eye[eyeOffset + 0];
        float _eyey = eye[eyeOffset + 1];
        float _eyez = eye[eyeOffset + 2];
        float _centerx = center[centerOffset + 0];
        float _centery = center[centerOffset + 1];
        float _centerz = center[centerOffset + 2];
        float _upx = up[upOffset + 0];
        float _upy = up[upOffset + 1];
        float _upz = up[upOffset + 2];
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
        dest[destOffset + 0] = _t29;
        dest[destOffset + 1] = _t38;
        dest[destOffset + 2] = -_t10;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = _t30;
        dest[destOffset + 5] = _t39;
        dest[destOffset + 6] = -_t11;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = _t31;
        dest[destOffset + 9] = _t40;
        dest[destOffset + 10] = -_t12;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -Math.fma(_eyez, _t31, Math.fma(_eyex, _t29, _eyey * _t30));
        dest[destOffset + 13] = -Math.fma(_eyez, _t40, Math.fma(_eyex, _t38, _eyey * _t39));
        dest[destOffset + 14] = Math.fma(_eyez, _t12, Math.fma(_eyex, _t10, _eyey * _t11));
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] makeOrtho_no_lh(float[] dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        float _t2 = zFar - zNear;
        float _t2_inv = 1.0f / _t2;
        dest[destOffset + 0] = 2.0f * _t0_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t1_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = 0.0f;
        dest[destOffset + 10] = 2.0f * _t2_inv;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -((left + right) * _t0_inv);
        dest[destOffset + 13] = -((bottom + top) * _t1_inv);
        dest[destOffset + 14] = -((zFar + zNear) * _t2_inv);
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] makeOrtho_no_rh(float[] dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        float _t2 = zFar - zNear;
        float _t2_inv = 1.0f / _t2;
        dest[destOffset + 0] = 2.0f * _t0_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t1_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = 0.0f;
        dest[destOffset + 10] = -2.0f * _t2_inv;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -((left + right) * _t0_inv);
        dest[destOffset + 13] = -((bottom + top) * _t1_inv);
        dest[destOffset + 14] = -((zFar + zNear) * _t2_inv);
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] makeOrtho_no(float[] dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.makeOrtho_no_lh(dest, destOffset, left, right, bottom, top, zNear, zFar); }
            default -> { return Float4x4OpsKernelsArray.makeOrtho_no_rh(dest, destOffset, left, right, bottom, top, zNear, zFar); }
        }
    }

    public static float[] makeOrtho_zo_lh(float[] dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        float _t2 = zFar - zNear;
        float _t2_inv = 1.0f / _t2;
        dest[destOffset + 0] = 2.0f * _t0_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t1_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = 0.0f;
        dest[destOffset + 10] = 1.0f * _t2_inv;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -((left + right) * _t0_inv);
        dest[destOffset + 13] = -((bottom + top) * _t1_inv);
        dest[destOffset + 14] = -(zNear * _t2_inv);
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] makeOrtho_zo_rh(float[] dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        float _t2 = zFar - zNear;
        float _t2_inv = 1.0f / _t2;
        dest[destOffset + 0] = 2.0f * _t0_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t1_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = 0.0f;
        dest[destOffset + 10] = -1.0f * _t2_inv;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -((left + right) * _t0_inv);
        dest[destOffset + 13] = -((bottom + top) * _t1_inv);
        dest[destOffset + 14] = -(zNear * _t2_inv);
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] makeOrtho_zo(float[] dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.makeOrtho_zo_lh(dest, destOffset, left, right, bottom, top, zNear, zFar); }
            default -> { return Float4x4OpsKernelsArray.makeOrtho_zo_rh(dest, destOffset, left, right, bottom, top, zNear, zFar); }
        }
    }

    public static float[] makeOrtho2D_no_lh(float[] dest, int destOffset, float left, float right, float bottom, float top) {
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        dest[destOffset + 0] = 2.0f * _t0_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t1_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = 0.0f;
        dest[destOffset + 10] = 1.0f;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -((left + right) * _t0_inv);
        dest[destOffset + 13] = -((bottom + top) * _t1_inv);
        dest[destOffset + 14] = 0.0f;
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] makeOrtho2D_no_rh(float[] dest, int destOffset, float left, float right, float bottom, float top) {
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        dest[destOffset + 0] = 2.0f * _t0_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t1_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = 0.0f;
        dest[destOffset + 10] = -1.0f;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -((left + right) * _t0_inv);
        dest[destOffset + 13] = -((bottom + top) * _t1_inv);
        dest[destOffset + 14] = 0.0f;
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] makeOrtho2D_no(float[] dest, int destOffset, float left, float right, float bottom, float top, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.makeOrtho2D_no_lh(dest, destOffset, left, right, bottom, top); }
            default -> { return Float4x4OpsKernelsArray.makeOrtho2D_no_rh(dest, destOffset, left, right, bottom, top); }
        }
    }

    public static float[] makeOrtho2D_zo_lh(float[] dest, int destOffset, float left, float right, float bottom, float top) {
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        dest[destOffset + 0] = 2.0f * _t0_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t1_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = 0.0f;
        dest[destOffset + 10] = 0.5f;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -((left + right) * _t0_inv);
        dest[destOffset + 13] = -((bottom + top) * _t1_inv);
        dest[destOffset + 14] = 0.5f;
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] makeOrtho2D_zo_rh(float[] dest, int destOffset, float left, float right, float bottom, float top) {
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        dest[destOffset + 0] = 2.0f * _t0_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t1_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = 0.0f;
        dest[destOffset + 10] = -0.5f;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -((left + right) * _t0_inv);
        dest[destOffset + 13] = -((bottom + top) * _t1_inv);
        dest[destOffset + 14] = 0.5f;
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] makeOrtho2D_zo(float[] dest, int destOffset, float left, float right, float bottom, float top, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.makeOrtho2D_zo_lh(dest, destOffset, left, right, bottom, top); }
            default -> { return Float4x4OpsKernelsArray.makeOrtho2D_zo_rh(dest, destOffset, left, right, bottom, top); }
        }
    }

    public static float[] makePerspective_no_lh(float[] dest, int destOffset, float fovy, float aspect, float near, float far) {
        float _t1 = near - far;
        float _t1_inv = 1.0f / _t1;
        float _t2 = (float) Math.tan(0.5f * fovy);
        if (far == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = 1.0f;
            dest[destOffset + 14] = -(2.0f * near);
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = -1.0f;
                dest[destOffset + 14] = 2.0f * far;
            } else {
                dest[destOffset + 10] = -((far + near) * _t1_inv);
                dest[destOffset + 14] = 2.0f * far * near * _t1_inv;
            }
        }
        dest[destOffset + 0] = 1.0f / (aspect * _t2);
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 1.0f / _t2;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = 0.0f;
        dest[destOffset + 11] = 1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makePerspective_no_rh(float[] dest, int destOffset, float fovy, float aspect, float near, float far) {
        float _t1 = near - far;
        float _t1_inv = 1.0f / _t1;
        float _t2 = (float) Math.tan(0.5f * fovy);
        if (far == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = -1.0f;
            dest[destOffset + 14] = -(2.0f * near);
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = 1.0f;
                dest[destOffset + 14] = 2.0f * far;
            } else {
                dest[destOffset + 10] = (far + near) * _t1_inv;
                dest[destOffset + 14] = 2.0f * far * near * _t1_inv;
            }
        }
        dest[destOffset + 0] = 1.0f / (aspect * _t2);
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 1.0f / _t2;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = 0.0f;
        dest[destOffset + 11] = -1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makePerspective_no(float[] dest, int destOffset, float fovy, float aspect, float near, float far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.makePerspective_no_lh(dest, destOffset, fovy, aspect, near, far); }
            default -> { return Float4x4OpsKernelsArray.makePerspective_no_rh(dest, destOffset, fovy, aspect, near, far); }
        }
    }

    public static float[] makePerspective_zo_lh(float[] dest, int destOffset, float fovy, float aspect, float near, float far) {
        float _t1 = near - far;
        float _t1_inv = 1.0f / _t1;
        float _t2 = (float) Math.tan(0.5f * fovy);
        if (far == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = 1.0f;
            dest[destOffset + 14] = -near;
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = 0.0f;
                dest[destOffset + 14] = far;
            } else {
                dest[destOffset + 10] = -(far * _t1_inv);
                dest[destOffset + 14] = far * near * _t1_inv;
            }
        }
        dest[destOffset + 0] = 1.0f / (aspect * _t2);
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 1.0f / _t2;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = 0.0f;
        dest[destOffset + 11] = 1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makePerspective_zo_rh(float[] dest, int destOffset, float fovy, float aspect, float near, float far) {
        float _t1 = near - far;
        float _t1_inv = 1.0f / _t1;
        float _t2 = (float) Math.tan(0.5f * fovy);
        if (far == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = -1.0f;
            dest[destOffset + 14] = -near;
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = 0.0f;
                dest[destOffset + 14] = far;
            } else {
                dest[destOffset + 10] = far * _t1_inv;
                dest[destOffset + 14] = far * near * _t1_inv;
            }
        }
        dest[destOffset + 0] = 1.0f / (aspect * _t2);
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 1.0f / _t2;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = 0.0f;
        dest[destOffset + 11] = -1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makePerspective_zo(float[] dest, int destOffset, float fovy, float aspect, float near, float far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.makePerspective_zo_lh(dest, destOffset, fovy, aspect, near, far); }
            default -> { return Float4x4OpsKernelsArray.makePerspective_zo_rh(dest, destOffset, fovy, aspect, near, far); }
        }
    }

    public static float[] makePerspectiveFovRange_no_lh(float[] dest, int destOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        float _t0 = (float) Math.tan(angleMax);
        float _t1 = (float) Math.tan(angleMin);
        float _t2 = near - far;
        float _t2_inv = 1.0f / _t2;
        float _t3 = _t0 - _t1;
        float _t3_inv = 1.0f / _t3;
        if (far == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = 1.0f;
            dest[destOffset + 14] = -(2.0f * near);
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = -1.0f;
                dest[destOffset + 14] = 2.0f * far;
            } else {
                dest[destOffset + 10] = -((far + near) * _t2_inv);
                dest[destOffset + 14] = 2.0f * far * near * _t2_inv;
            }
        }
        dest[destOffset + 0] = 2.0f / (aspect * _t3);
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t3_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = -((_t0 + _t1) * _t3_inv);
        dest[destOffset + 11] = 1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makePerspectiveFovRange_no_rh(float[] dest, int destOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        float _t0 = (float) Math.tan(angleMax);
        float _t1 = (float) Math.tan(angleMin);
        float _t2 = near - far;
        float _t2_inv = 1.0f / _t2;
        float _t3 = _t0 - _t1;
        float _t3_inv = 1.0f / _t3;
        if (far == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = -1.0f;
            dest[destOffset + 14] = -(2.0f * near);
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = 1.0f;
                dest[destOffset + 14] = 2.0f * far;
            } else {
                dest[destOffset + 10] = (far + near) * _t2_inv;
                dest[destOffset + 14] = 2.0f * far * near * _t2_inv;
            }
        }
        dest[destOffset + 0] = 2.0f / (aspect * _t3);
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t3_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = (_t0 + _t1) * _t3_inv;
        dest[destOffset + 11] = -1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makePerspectiveFovRange_no(float[] dest, int destOffset, float angleMin, float angleMax, float aspect, float near, float far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.makePerspectiveFovRange_no_lh(dest, destOffset, angleMin, angleMax, aspect, near, far); }
            default -> { return Float4x4OpsKernelsArray.makePerspectiveFovRange_no_rh(dest, destOffset, angleMin, angleMax, aspect, near, far); }
        }
    }

    public static float[] makePerspectiveFovRange_zo_lh(float[] dest, int destOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        float _t0 = (float) Math.tan(angleMax);
        float _t1 = (float) Math.tan(angleMin);
        float _t2 = near - far;
        float _t2_inv = 1.0f / _t2;
        float _t3 = _t0 - _t1;
        float _t3_inv = 1.0f / _t3;
        if (far == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = 1.0f;
            dest[destOffset + 14] = -near;
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = 0.0f;
                dest[destOffset + 14] = far;
            } else {
                dest[destOffset + 10] = -(far * _t2_inv);
                dest[destOffset + 14] = far * near * _t2_inv;
            }
        }
        dest[destOffset + 0] = 2.0f / (aspect * _t3);
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t3_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = -((_t0 + _t1) * _t3_inv);
        dest[destOffset + 11] = 1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makePerspectiveFovRange_zo_rh(float[] dest, int destOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        float _t0 = (float) Math.tan(angleMax);
        float _t1 = (float) Math.tan(angleMin);
        float _t2 = near - far;
        float _t2_inv = 1.0f / _t2;
        float _t3 = _t0 - _t1;
        float _t3_inv = 1.0f / _t3;
        if (far == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = -1.0f;
            dest[destOffset + 14] = -near;
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = 0.0f;
                dest[destOffset + 14] = far;
            } else {
                dest[destOffset + 10] = far * _t2_inv;
                dest[destOffset + 14] = far * near * _t2_inv;
            }
        }
        dest[destOffset + 0] = 2.0f / (aspect * _t3);
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t3_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = (_t0 + _t1) * _t3_inv;
        dest[destOffset + 11] = -1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makePerspectiveFovRange_zo(float[] dest, int destOffset, float angleMin, float angleMax, float aspect, float near, float far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.makePerspectiveFovRange_zo_lh(dest, destOffset, angleMin, angleMax, aspect, near, far); }
            default -> { return Float4x4OpsKernelsArray.makePerspectiveFovRange_zo_rh(dest, destOffset, angleMin, angleMax, aspect, near, far); }
        }
    }

    public static float[] makePerspectiveOffCenterFov_no_lh(float[] dest, int destOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        float _t0 = (float) Math.tan(angleRight);
        float _t1 = (float) Math.tan(angleLeft);
        float _t2 = (float) Math.tan(angleUp);
        float _t3 = (float) Math.tan(angleDown);
        float _t4 = near - far;
        float _t4_inv = 1.0f / _t4;
        float _t5 = _t0 - _t1;
        float _t5_inv = 1.0f / _t5;
        float _t6 = _t2 - _t3;
        float _t6_inv = 1.0f / _t6;
        if (far == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = 1.0f;
            dest[destOffset + 14] = -(2.0f * near);
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = -1.0f;
                dest[destOffset + 14] = 2.0f * far;
            } else {
                dest[destOffset + 10] = -((far + near) * _t4_inv);
                dest[destOffset + 14] = 2.0f * far * near * _t4_inv;
            }
        }
        dest[destOffset + 0] = 2.0f * _t5_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t6_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = -((_t1 + _t0) * _t5_inv);
        dest[destOffset + 9] = -((_t3 + _t2) * _t6_inv);
        dest[destOffset + 11] = 1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makePerspectiveOffCenterFov_no_rh(float[] dest, int destOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        float _t0 = (float) Math.tan(angleRight);
        float _t1 = (float) Math.tan(angleLeft);
        float _t2 = (float) Math.tan(angleUp);
        float _t3 = (float) Math.tan(angleDown);
        float _t4 = near - far;
        float _t4_inv = 1.0f / _t4;
        float _t5 = _t0 - _t1;
        float _t5_inv = 1.0f / _t5;
        float _t6 = _t2 - _t3;
        float _t6_inv = 1.0f / _t6;
        if (far == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = -1.0f;
            dest[destOffset + 14] = -(2.0f * near);
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = 1.0f;
                dest[destOffset + 14] = 2.0f * far;
            } else {
                dest[destOffset + 10] = (far + near) * _t4_inv;
                dest[destOffset + 14] = 2.0f * far * near * _t4_inv;
            }
        }
        dest[destOffset + 0] = 2.0f * _t5_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t6_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = (_t1 + _t0) * _t5_inv;
        dest[destOffset + 9] = (_t3 + _t2) * _t6_inv;
        dest[destOffset + 11] = -1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makePerspectiveOffCenterFov_no(float[] dest, int destOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.makePerspectiveOffCenterFov_no_lh(dest, destOffset, angleLeft, angleRight, angleDown, angleUp, near, far); }
            default -> { return Float4x4OpsKernelsArray.makePerspectiveOffCenterFov_no_rh(dest, destOffset, angleLeft, angleRight, angleDown, angleUp, near, far); }
        }
    }

    public static float[] makePerspectiveOffCenterFov_zo_lh(float[] dest, int destOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        float _t0 = (float) Math.tan(angleRight);
        float _t1 = (float) Math.tan(angleLeft);
        float _t2 = (float) Math.tan(angleUp);
        float _t3 = (float) Math.tan(angleDown);
        float _t4 = near - far;
        float _t4_inv = 1.0f / _t4;
        float _t5 = _t0 - _t1;
        float _t5_inv = 1.0f / _t5;
        float _t6 = _t2 - _t3;
        float _t6_inv = 1.0f / _t6;
        if (far == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = 1.0f;
            dest[destOffset + 14] = -near;
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = 0.0f;
                dest[destOffset + 14] = far;
            } else {
                dest[destOffset + 10] = -(far * _t4_inv);
                dest[destOffset + 14] = far * near * _t4_inv;
            }
        }
        dest[destOffset + 0] = 2.0f * _t5_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t6_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = -((_t1 + _t0) * _t5_inv);
        dest[destOffset + 9] = -((_t3 + _t2) * _t6_inv);
        dest[destOffset + 11] = 1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makePerspectiveOffCenterFov_zo_rh(float[] dest, int destOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        float _t0 = (float) Math.tan(angleRight);
        float _t1 = (float) Math.tan(angleLeft);
        float _t2 = (float) Math.tan(angleUp);
        float _t3 = (float) Math.tan(angleDown);
        float _t4 = near - far;
        float _t4_inv = 1.0f / _t4;
        float _t5 = _t0 - _t1;
        float _t5_inv = 1.0f / _t5;
        float _t6 = _t2 - _t3;
        float _t6_inv = 1.0f / _t6;
        if (far == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = -1.0f;
            dest[destOffset + 14] = -near;
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = 0.0f;
                dest[destOffset + 14] = far;
            } else {
                dest[destOffset + 10] = far * _t4_inv;
                dest[destOffset + 14] = far * near * _t4_inv;
            }
        }
        dest[destOffset + 0] = 2.0f * _t5_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t6_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = (_t1 + _t0) * _t5_inv;
        dest[destOffset + 9] = (_t3 + _t2) * _t6_inv;
        dest[destOffset + 11] = -1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makePerspectiveOffCenterFov_zo(float[] dest, int destOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.makePerspectiveOffCenterFov_zo_lh(dest, destOffset, angleLeft, angleRight, angleDown, angleUp, near, far); }
            default -> { return Float4x4OpsKernelsArray.makePerspectiveOffCenterFov_zo_rh(dest, destOffset, angleLeft, angleRight, angleDown, angleUp, near, far); }
        }
    }

    public static float[] makePerspectiveOffCenterRectangleProj_no_lh(float[] dest, int destOffset, float eyeX, float eyeY, float eyeZ, float pX, float pY, float pZ, float xX, float xY, float xZ, float yX, float yY, float yZ, float nearFarDist) {
        float _t0 = -eyeZ;
        float _t1 = -pY;
        float _t14 = Math.fma(xY, yX, -(xX * yY));
        float _t15 = Math.fma(xZ, yY, -(xY * yZ));
        float _t16 = Math.fma(xX, yZ, -(xZ * yX));
        float _t19 = Math.fma(pZ - eyeZ, _t14, Math.fma(pX - eyeX, _t15, (pY - eyeY) * _t16));
        float _t20 = _t19 >= 0.0f ? 1.0f : -1.0f;
        float _t21 = _t14 * _t20;
        float _t22 = _t16 * _t20;
        float _t23 = _t15 * _t20;
        float _t24 = Math.fma(_t14, _t20, eyeZ - eyeZ);
        float _t25 = Math.fma(_t15, _t20, eyeX - eyeX);
        float _t26 = Math.fma(_t16, _t20, eyeY - eyeY);
        float _t27 = _t19 * _t20;
        float _t34 = (1.0f / (float) Math.sqrt(Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23))));
        float _t35 = Math.fma(_t24, _t24, Math.fma(_t25, _t25, _t26 * _t26));
        float _t36 = (1.0f / (float) Math.sqrt(_t35));
        float _t40 = _t27 * _t34;
        float _t41 = Math.fma(_t27, _t34, nearFarDist);
        float _t42 = 2.0f * _t40;
        float _t44, _t45, _t46;
        if (_t35 > 0.0f) {
            _t44 = _t26 * _t36;
            _t45 = _t25 * _t36;
            _t46 = _t24 * _t36;
        } else {
            _t44 = 0.0f;
            _t45 = 0.0f;
            _t46 = 0.0f;
        }
        float _t53 = Math.fma(_t27, _t34, Math.fma(-_t27, _t34, -nearFarDist));
        float _t53_inv = 1.0f / _t53;
        float _t54 = Math.fma(yX, _t44, -(yY * _t45));
        float _t55 = Math.fma(yY, _t46, -(yZ * _t44));
        float _t56 = Math.fma(yZ, _t45, -(yX * _t46));
        float _t59 = Math.fma(_t54, _t54, Math.fma(_t55, _t55, _t56 * _t56));
        float _t60 = (1.0f / (float) Math.sqrt(_t59));
        float _t64, _t65, _t66;
        if (_t59 > 0.0f) {
            _t64 = _t55 * _t60;
            _t65 = _t56 * _t60;
            _t66 = _t54 * _t60;
        } else {
            _t64 = 0.0f;
            _t65 = 0.0f;
            _t66 = 0.0f;
        }
        float _t85 = Math.fma(pX, _t64, pY * _t65);
        float _t87 = Math.fma(pZ, _t66, -(eyeX * _t64));
        float _t89 = Math.fma(_t0, _t66, -(eyeY * _t65));
        float _t91 = Math.fma(_t44, _t66, -(_t46 * _t65));
        float _t92 = Math.fma(_t46, _t64, -(_t45 * _t66));
        float _t93 = Math.fma(_t45, _t65, -(_t44 * _t64));
        float _t110 = Math.fma(pX, _t91, pY * _t92);
        float _t112 = Math.fma(pZ, _t93, -(eyeX * _t91));
        float _t114 = Math.fma(_t0, _t93, -(eyeY * _t92));
        float _t117 = Math.fma(xX, _t64, Math.fma(xY, _t65, xZ * _t66)) + (_t85 + _t87);
        float _t122 = Math.fma(yX, _t91, Math.fma(yY, _t92, yZ * _t93)) + (_t110 + _t112);
        float _t123 = _t117 + (_t89 + Math.fma(_t1, _t65, -(pX * _t64)) + (Math.fma(eyeX, _t64, -(pZ * _t66)) + Math.fma(eyeY, _t65, eyeZ * _t66)));
        float _t123_inv = 1.0f / _t123;
        float _t125 = _t122 + (_t114 + Math.fma(_t1, _t92, -(pX * _t91)) + (Math.fma(eyeX, _t91, -(pZ * _t93)) + Math.fma(eyeY, _t92, eyeZ * _t93)));
        float _t125_inv = 1.0f / _t125;
        if (_t41 == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = 1.0f;
            dest[destOffset + 14] = -_t42;
        } else {
            if (_t40 == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = -1.0f;
                dest[destOffset + 14] = 2.0f * _t41;
            } else {
                dest[destOffset + 10] = -(Math.fma(_t27, _t34, _t41) * _t53_inv);
                dest[destOffset + 14] = 2.0f * _t41 * _t40 * _t53_inv;
            }
        }
        dest[destOffset + 0] = _t42 * _t123_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = _t42 * _t125_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = -((_t117 + (_t89 + _t85 + (_t87 + _t89))) * _t123_inv);
        dest[destOffset + 9] = -((_t122 + (_t114 + _t110 + (_t112 + _t114))) * _t125_inv);
        dest[destOffset + 11] = 1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makePerspectiveOffCenterRectangleProj_no_rh(float[] dest, int destOffset, float eyeX, float eyeY, float eyeZ, float pX, float pY, float pZ, float xX, float xY, float xZ, float yX, float yY, float yZ, float nearFarDist) {
        float _t0 = -eyeZ;
        float _t1 = -pY;
        float _t14 = Math.fma(xY, yX, -(xX * yY));
        float _t15 = Math.fma(xZ, yY, -(xY * yZ));
        float _t16 = Math.fma(xX, yZ, -(xZ * yX));
        float _t19 = Math.fma(pZ - eyeZ, _t14, Math.fma(pX - eyeX, _t15, (pY - eyeY) * _t16));
        float _t20 = _t19 >= 0.0f ? 1.0f : -1.0f;
        float _t21 = _t14 * _t20;
        float _t22 = _t16 * _t20;
        float _t23 = _t15 * _t20;
        float _t24 = Math.fma(_t14, _t20, eyeZ - eyeZ);
        float _t25 = Math.fma(_t15, _t20, eyeX - eyeX);
        float _t26 = Math.fma(_t16, _t20, eyeY - eyeY);
        float _t27 = _t19 * _t20;
        float _t34 = (1.0f / (float) Math.sqrt(Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23))));
        float _t35 = Math.fma(_t24, _t24, Math.fma(_t25, _t25, _t26 * _t26));
        float _t36 = (1.0f / (float) Math.sqrt(_t35));
        float _t40 = _t27 * _t34;
        float _t41 = Math.fma(_t27, _t34, nearFarDist);
        float _t42 = 2.0f * _t40;
        float _t44, _t45, _t46;
        if (_t35 > 0.0f) {
            _t44 = _t25 * _t36;
            _t45 = _t26 * _t36;
            _t46 = _t24 * _t36;
        } else {
            _t44 = 0.0f;
            _t45 = 0.0f;
            _t46 = 0.0f;
        }
        float _t53 = Math.fma(_t27, _t34, Math.fma(-_t27, _t34, -nearFarDist));
        float _t53_inv = 1.0f / _t53;
        float _t54 = Math.fma(yY, _t44, -(yX * _t45));
        float _t55 = Math.fma(yX, _t46, -(yZ * _t44));
        float _t56 = Math.fma(yZ, _t45, -(yY * _t46));
        float _t59 = Math.fma(_t54, _t54, Math.fma(_t55, _t55, _t56 * _t56));
        float _t60 = (1.0f / (float) Math.sqrt(_t59));
        float _t64, _t65, _t66;
        if (_t59 > 0.0f) {
            _t64 = _t56 * _t60;
            _t65 = _t55 * _t60;
            _t66 = _t54 * _t60;
        } else {
            _t64 = 0.0f;
            _t65 = 0.0f;
            _t66 = 0.0f;
        }
        float _t85 = Math.fma(pX, _t64, pY * _t65);
        float _t87 = Math.fma(pZ, _t66, -(eyeX * _t64));
        float _t89 = Math.fma(_t0, _t66, -(eyeY * _t65));
        float _t91 = Math.fma(_t46, _t65, -(_t45 * _t66));
        float _t92 = Math.fma(_t44, _t66, -(_t46 * _t64));
        float _t93 = Math.fma(_t45, _t64, -(_t44 * _t65));
        float _t110 = Math.fma(pX, _t91, pY * _t92);
        float _t112 = Math.fma(pZ, _t93, -(eyeX * _t91));
        float _t114 = Math.fma(_t0, _t93, -(eyeY * _t92));
        float _t117 = Math.fma(xX, _t64, Math.fma(xY, _t65, xZ * _t66)) + (_t85 + _t87);
        float _t122 = Math.fma(yX, _t91, Math.fma(yY, _t92, yZ * _t93)) + (_t110 + _t112);
        float _t123 = _t117 + (_t89 + Math.fma(_t1, _t65, -(pX * _t64)) + (Math.fma(eyeX, _t64, -(pZ * _t66)) + Math.fma(eyeY, _t65, eyeZ * _t66)));
        float _t123_inv = 1.0f / _t123;
        float _t125 = _t122 + (_t114 + Math.fma(_t1, _t92, -(pX * _t91)) + (Math.fma(eyeX, _t91, -(pZ * _t93)) + Math.fma(eyeY, _t92, eyeZ * _t93)));
        float _t125_inv = 1.0f / _t125;
        if (_t41 == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = -1.0f;
            dest[destOffset + 14] = -_t42;
        } else {
            if (_t40 == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = 1.0f;
                dest[destOffset + 14] = 2.0f * _t41;
            } else {
                dest[destOffset + 10] = Math.fma(_t27, _t34, _t41) * _t53_inv;
                dest[destOffset + 14] = 2.0f * _t41 * _t40 * _t53_inv;
            }
        }
        dest[destOffset + 0] = _t42 * _t123_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = _t42 * _t125_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = (_t117 + (_t89 + _t85 + (_t87 + _t89))) * _t123_inv;
        dest[destOffset + 9] = (_t122 + (_t114 + _t110 + (_t112 + _t114))) * _t125_inv;
        dest[destOffset + 11] = -1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makePerspectiveOffCenterRectangleProj_no(float[] dest, int destOffset, float eyeX, float eyeY, float eyeZ, float pX, float pY, float pZ, float xX, float xY, float xZ, float yX, float yY, float yZ, float nearFarDist, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.makePerspectiveOffCenterRectangleProj_no_lh(dest, destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist); }
            default -> { return Float4x4OpsKernelsArray.makePerspectiveOffCenterRectangleProj_no_rh(dest, destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist); }
        }
    }

    public static float[] makePerspectiveOffCenterRectangleProj_zo_lh(float[] dest, int destOffset, float eyeX, float eyeY, float eyeZ, float pX, float pY, float pZ, float xX, float xY, float xZ, float yX, float yY, float yZ, float nearFarDist) {
        float _t0 = -eyeZ;
        float _t1 = -pY;
        float _t14 = Math.fma(xY, yX, -(xX * yY));
        float _t15 = Math.fma(xZ, yY, -(xY * yZ));
        float _t16 = Math.fma(xX, yZ, -(xZ * yX));
        float _t19 = Math.fma(pZ - eyeZ, _t14, Math.fma(pX - eyeX, _t15, (pY - eyeY) * _t16));
        float _t20 = _t19 >= 0.0f ? 1.0f : -1.0f;
        float _t21 = _t14 * _t20;
        float _t22 = _t16 * _t20;
        float _t23 = _t15 * _t20;
        float _t24 = Math.fma(_t14, _t20, eyeZ - eyeZ);
        float _t25 = Math.fma(_t15, _t20, eyeX - eyeX);
        float _t26 = Math.fma(_t16, _t20, eyeY - eyeY);
        float _t27 = _t19 * _t20;
        float _t34 = (1.0f / (float) Math.sqrt(Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23))));
        float _t35 = Math.fma(_t24, _t24, Math.fma(_t25, _t25, _t26 * _t26));
        float _t36 = (1.0f / (float) Math.sqrt(_t35));
        float _t40 = _t27 * _t34;
        float _t41 = Math.fma(_t27, _t34, nearFarDist);
        float _t42 = 2.0f * _t40;
        float _t44, _t45, _t46;
        if (_t35 > 0.0f) {
            _t44 = _t26 * _t36;
            _t45 = _t25 * _t36;
            _t46 = _t24 * _t36;
        } else {
            _t44 = 0.0f;
            _t45 = 0.0f;
            _t46 = 0.0f;
        }
        float _t53 = Math.fma(_t27, _t34, Math.fma(-_t27, _t34, -nearFarDist));
        float _t53_inv = 1.0f / _t53;
        float _t54 = Math.fma(yX, _t44, -(yY * _t45));
        float _t55 = Math.fma(yY, _t46, -(yZ * _t44));
        float _t56 = Math.fma(yZ, _t45, -(yX * _t46));
        float _t59 = Math.fma(_t54, _t54, Math.fma(_t55, _t55, _t56 * _t56));
        float _t60 = (1.0f / (float) Math.sqrt(_t59));
        float _t64, _t65, _t66;
        if (_t59 > 0.0f) {
            _t64 = _t55 * _t60;
            _t65 = _t56 * _t60;
            _t66 = _t54 * _t60;
        } else {
            _t64 = 0.0f;
            _t65 = 0.0f;
            _t66 = 0.0f;
        }
        float _t85 = Math.fma(pX, _t64, pY * _t65);
        float _t87 = Math.fma(pZ, _t66, -(eyeX * _t64));
        float _t89 = Math.fma(_t0, _t66, -(eyeY * _t65));
        float _t91 = Math.fma(_t44, _t66, -(_t46 * _t65));
        float _t92 = Math.fma(_t46, _t64, -(_t45 * _t66));
        float _t93 = Math.fma(_t45, _t65, -(_t44 * _t64));
        float _t110 = Math.fma(pX, _t91, pY * _t92);
        float _t112 = Math.fma(pZ, _t93, -(eyeX * _t91));
        float _t114 = Math.fma(_t0, _t93, -(eyeY * _t92));
        float _t117 = Math.fma(xX, _t64, Math.fma(xY, _t65, xZ * _t66)) + (_t85 + _t87);
        float _t122 = Math.fma(yX, _t91, Math.fma(yY, _t92, yZ * _t93)) + (_t110 + _t112);
        float _t123 = _t117 + (_t89 + Math.fma(_t1, _t65, -(pX * _t64)) + (Math.fma(eyeX, _t64, -(pZ * _t66)) + Math.fma(eyeY, _t65, eyeZ * _t66)));
        float _t123_inv = 1.0f / _t123;
        float _t125 = _t122 + (_t114 + Math.fma(_t1, _t92, -(pX * _t91)) + (Math.fma(eyeX, _t91, -(pZ * _t93)) + Math.fma(eyeY, _t92, eyeZ * _t93)));
        float _t125_inv = 1.0f / _t125;
        if (_t41 == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = 1.0f;
            dest[destOffset + 14] = -_t40;
        } else {
            if (_t40 == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = 0.0f;
                dest[destOffset + 14] = _t41;
            } else {
                dest[destOffset + 10] = -(_t41 * _t53_inv);
                dest[destOffset + 14] = _t41 * _t40 * _t53_inv;
            }
        }
        dest[destOffset + 0] = _t42 * _t123_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = _t42 * _t125_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = -((_t117 + (_t89 + _t85 + (_t87 + _t89))) * _t123_inv);
        dest[destOffset + 9] = -((_t122 + (_t114 + _t110 + (_t112 + _t114))) * _t125_inv);
        dest[destOffset + 11] = 1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makePerspectiveOffCenterRectangleProj_zo_rh(float[] dest, int destOffset, float eyeX, float eyeY, float eyeZ, float pX, float pY, float pZ, float xX, float xY, float xZ, float yX, float yY, float yZ, float nearFarDist) {
        float _t0 = -eyeZ;
        float _t1 = -pY;
        float _t14 = Math.fma(xY, yX, -(xX * yY));
        float _t15 = Math.fma(xZ, yY, -(xY * yZ));
        float _t16 = Math.fma(xX, yZ, -(xZ * yX));
        float _t19 = Math.fma(pZ - eyeZ, _t14, Math.fma(pX - eyeX, _t15, (pY - eyeY) * _t16));
        float _t20 = _t19 >= 0.0f ? 1.0f : -1.0f;
        float _t21 = _t14 * _t20;
        float _t22 = _t16 * _t20;
        float _t23 = _t15 * _t20;
        float _t24 = Math.fma(_t14, _t20, eyeZ - eyeZ);
        float _t25 = Math.fma(_t15, _t20, eyeX - eyeX);
        float _t26 = Math.fma(_t16, _t20, eyeY - eyeY);
        float _t27 = _t19 * _t20;
        float _t34 = (1.0f / (float) Math.sqrt(Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23))));
        float _t35 = Math.fma(_t24, _t24, Math.fma(_t25, _t25, _t26 * _t26));
        float _t36 = (1.0f / (float) Math.sqrt(_t35));
        float _t40 = _t27 * _t34;
        float _t41 = Math.fma(_t27, _t34, nearFarDist);
        float _t42 = 2.0f * _t40;
        float _t44, _t45, _t46;
        if (_t35 > 0.0f) {
            _t44 = _t25 * _t36;
            _t45 = _t26 * _t36;
            _t46 = _t24 * _t36;
        } else {
            _t44 = 0.0f;
            _t45 = 0.0f;
            _t46 = 0.0f;
        }
        float _t53 = Math.fma(_t27, _t34, Math.fma(-_t27, _t34, -nearFarDist));
        float _t53_inv = 1.0f / _t53;
        float _t54 = Math.fma(yY, _t44, -(yX * _t45));
        float _t55 = Math.fma(yX, _t46, -(yZ * _t44));
        float _t56 = Math.fma(yZ, _t45, -(yY * _t46));
        float _t59 = Math.fma(_t54, _t54, Math.fma(_t55, _t55, _t56 * _t56));
        float _t60 = (1.0f / (float) Math.sqrt(_t59));
        float _t64, _t65, _t66;
        if (_t59 > 0.0f) {
            _t64 = _t56 * _t60;
            _t65 = _t55 * _t60;
            _t66 = _t54 * _t60;
        } else {
            _t64 = 0.0f;
            _t65 = 0.0f;
            _t66 = 0.0f;
        }
        float _t85 = Math.fma(pX, _t64, pY * _t65);
        float _t87 = Math.fma(pZ, _t66, -(eyeX * _t64));
        float _t89 = Math.fma(_t0, _t66, -(eyeY * _t65));
        float _t91 = Math.fma(_t46, _t65, -(_t45 * _t66));
        float _t92 = Math.fma(_t44, _t66, -(_t46 * _t64));
        float _t93 = Math.fma(_t45, _t64, -(_t44 * _t65));
        float _t110 = Math.fma(pX, _t91, pY * _t92);
        float _t112 = Math.fma(pZ, _t93, -(eyeX * _t91));
        float _t114 = Math.fma(_t0, _t93, -(eyeY * _t92));
        float _t117 = Math.fma(xX, _t64, Math.fma(xY, _t65, xZ * _t66)) + (_t85 + _t87);
        float _t122 = Math.fma(yX, _t91, Math.fma(yY, _t92, yZ * _t93)) + (_t110 + _t112);
        float _t123 = _t117 + (_t89 + Math.fma(_t1, _t65, -(pX * _t64)) + (Math.fma(eyeX, _t64, -(pZ * _t66)) + Math.fma(eyeY, _t65, eyeZ * _t66)));
        float _t123_inv = 1.0f / _t123;
        float _t125 = _t122 + (_t114 + Math.fma(_t1, _t92, -(pX * _t91)) + (Math.fma(eyeX, _t91, -(pZ * _t93)) + Math.fma(eyeY, _t92, eyeZ * _t93)));
        float _t125_inv = 1.0f / _t125;
        if (_t41 == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = -1.0f;
            dest[destOffset + 14] = -_t40;
        } else {
            if (_t40 == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = 0.0f;
                dest[destOffset + 14] = _t41;
            } else {
                dest[destOffset + 10] = _t41 * _t53_inv;
                dest[destOffset + 14] = _t41 * _t40 * _t53_inv;
            }
        }
        dest[destOffset + 0] = _t42 * _t123_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = _t42 * _t125_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = (_t117 + (_t89 + _t85 + (_t87 + _t89))) * _t123_inv;
        dest[destOffset + 9] = (_t122 + (_t114 + _t110 + (_t112 + _t114))) * _t125_inv;
        dest[destOffset + 11] = -1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makePerspectiveOffCenterRectangleProj_zo(float[] dest, int destOffset, float eyeX, float eyeY, float eyeZ, float pX, float pY, float pZ, float xX, float xY, float xZ, float yX, float yY, float yZ, float nearFarDist, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.makePerspectiveOffCenterRectangleProj_zo_lh(dest, destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist); }
            default -> { return Float4x4OpsKernelsArray.makePerspectiveOffCenterRectangleProj_zo_rh(dest, destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist); }
        }
    }

    public static float[] makePerspectiveOffCenterRectangleProj_no_lh(float[] dest, int destOffset, float[] eye, int eyeOffset, float[] p, int pOffset, float[] x, int xOffset, float[] y, int yOffset, float nearFarDist) {
        float _eyex = eye[eyeOffset + 0];
        float _eyey = eye[eyeOffset + 1];
        float _eyez = eye[eyeOffset + 2];
        float _px = p[pOffset + 0];
        float _py = p[pOffset + 1];
        float _pz = p[pOffset + 2];
        float _xx = x[xOffset + 0];
        float _xy = x[xOffset + 1];
        float _xz = x[xOffset + 2];
        float _yx = y[yOffset + 0];
        float _yy = y[yOffset + 1];
        float _yz = y[yOffset + 2];
        float _t0 = -_eyez;
        float _t1 = -_py;
        float _t14 = Math.fma(_xy, _yx, -(_xx * _yy));
        float _t15 = Math.fma(_xz, _yy, -(_xy * _yz));
        float _t16 = Math.fma(_xx, _yz, -(_xz * _yx));
        float _t19 = Math.fma(_pz - _eyez, _t14, Math.fma(_px - _eyex, _t15, (_py - _eyey) * _t16));
        float _t20 = _t19 >= 0.0f ? 1.0f : -1.0f;
        float _t21 = _t14 * _t20;
        float _t22 = _t16 * _t20;
        float _t23 = _t15 * _t20;
        float _t24 = Math.fma(_t14, _t20, _eyez - _eyez);
        float _t25 = Math.fma(_t15, _t20, _eyex - _eyex);
        float _t26 = Math.fma(_t16, _t20, _eyey - _eyey);
        float _t27 = _t19 * _t20;
        float _t34 = (1.0f / (float) Math.sqrt(Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23))));
        float _t35 = Math.fma(_t24, _t24, Math.fma(_t25, _t25, _t26 * _t26));
        float _t36 = (1.0f / (float) Math.sqrt(_t35));
        float _t40 = _t27 * _t34;
        float _t41 = Math.fma(_t27, _t34, nearFarDist);
        float _t42 = 2.0f * _t40;
        float _t44, _t45, _t46;
        if (_t35 > 0.0f) {
            _t44 = _t26 * _t36;
            _t45 = _t25 * _t36;
            _t46 = _t24 * _t36;
        } else {
            _t44 = 0.0f;
            _t45 = 0.0f;
            _t46 = 0.0f;
        }
        float _t53 = Math.fma(_t27, _t34, Math.fma(-_t27, _t34, -nearFarDist));
        float _t53_inv = 1.0f / _t53;
        float _t54 = Math.fma(_yx, _t44, -(_yy * _t45));
        float _t55 = Math.fma(_yy, _t46, -(_yz * _t44));
        float _t56 = Math.fma(_yz, _t45, -(_yx * _t46));
        float _t59 = Math.fma(_t54, _t54, Math.fma(_t55, _t55, _t56 * _t56));
        float _t60 = (1.0f / (float) Math.sqrt(_t59));
        float _t64, _t65, _t66;
        if (_t59 > 0.0f) {
            _t64 = _t55 * _t60;
            _t65 = _t56 * _t60;
            _t66 = _t54 * _t60;
        } else {
            _t64 = 0.0f;
            _t65 = 0.0f;
            _t66 = 0.0f;
        }
        float _t85 = Math.fma(_px, _t64, _py * _t65);
        float _t87 = Math.fma(_pz, _t66, -(_eyex * _t64));
        float _t89 = Math.fma(_t0, _t66, -(_eyey * _t65));
        float _t91 = Math.fma(_t44, _t66, -(_t46 * _t65));
        float _t92 = Math.fma(_t46, _t64, -(_t45 * _t66));
        float _t93 = Math.fma(_t45, _t65, -(_t44 * _t64));
        float _t110 = Math.fma(_px, _t91, _py * _t92);
        float _t112 = Math.fma(_pz, _t93, -(_eyex * _t91));
        float _t114 = Math.fma(_t0, _t93, -(_eyey * _t92));
        float _t117 = Math.fma(_xx, _t64, Math.fma(_xy, _t65, _xz * _t66)) + (_t85 + _t87);
        float _t122 = Math.fma(_yx, _t91, Math.fma(_yy, _t92, _yz * _t93)) + (_t110 + _t112);
        float _t123 = _t117 + (_t89 + Math.fma(_t1, _t65, -(_px * _t64)) + (Math.fma(_eyex, _t64, -(_pz * _t66)) + Math.fma(_eyey, _t65, _eyez * _t66)));
        float _t123_inv = 1.0f / _t123;
        float _t125 = _t122 + (_t114 + Math.fma(_t1, _t92, -(_px * _t91)) + (Math.fma(_eyex, _t91, -(_pz * _t93)) + Math.fma(_eyey, _t92, _eyez * _t93)));
        float _t125_inv = 1.0f / _t125;
        if (_t41 == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = 1.0f;
            dest[destOffset + 14] = -_t42;
        } else {
            if (_t40 == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = -1.0f;
                dest[destOffset + 14] = 2.0f * _t41;
            } else {
                dest[destOffset + 10] = -(Math.fma(_t27, _t34, _t41) * _t53_inv);
                dest[destOffset + 14] = 2.0f * _t41 * _t40 * _t53_inv;
            }
        }
        dest[destOffset + 0] = _t42 * _t123_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = _t42 * _t125_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = -((_t117 + (_t89 + _t85 + (_t87 + _t89))) * _t123_inv);
        dest[destOffset + 9] = -((_t122 + (_t114 + _t110 + (_t112 + _t114))) * _t125_inv);
        dest[destOffset + 11] = 1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makePerspectiveOffCenterRectangleProj_no_rh(float[] dest, int destOffset, float[] eye, int eyeOffset, float[] p, int pOffset, float[] x, int xOffset, float[] y, int yOffset, float nearFarDist) {
        float _eyex = eye[eyeOffset + 0];
        float _eyey = eye[eyeOffset + 1];
        float _eyez = eye[eyeOffset + 2];
        float _px = p[pOffset + 0];
        float _py = p[pOffset + 1];
        float _pz = p[pOffset + 2];
        float _xx = x[xOffset + 0];
        float _xy = x[xOffset + 1];
        float _xz = x[xOffset + 2];
        float _yx = y[yOffset + 0];
        float _yy = y[yOffset + 1];
        float _yz = y[yOffset + 2];
        float _t0 = -_eyez;
        float _t1 = -_py;
        float _t14 = Math.fma(_xy, _yx, -(_xx * _yy));
        float _t15 = Math.fma(_xz, _yy, -(_xy * _yz));
        float _t16 = Math.fma(_xx, _yz, -(_xz * _yx));
        float _t19 = Math.fma(_pz - _eyez, _t14, Math.fma(_px - _eyex, _t15, (_py - _eyey) * _t16));
        float _t20 = _t19 >= 0.0f ? 1.0f : -1.0f;
        float _t21 = _t14 * _t20;
        float _t22 = _t16 * _t20;
        float _t23 = _t15 * _t20;
        float _t24 = Math.fma(_t14, _t20, _eyez - _eyez);
        float _t25 = Math.fma(_t15, _t20, _eyex - _eyex);
        float _t26 = Math.fma(_t16, _t20, _eyey - _eyey);
        float _t27 = _t19 * _t20;
        float _t34 = (1.0f / (float) Math.sqrt(Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23))));
        float _t35 = Math.fma(_t24, _t24, Math.fma(_t25, _t25, _t26 * _t26));
        float _t36 = (1.0f / (float) Math.sqrt(_t35));
        float _t40 = _t27 * _t34;
        float _t41 = Math.fma(_t27, _t34, nearFarDist);
        float _t42 = 2.0f * _t40;
        float _t44, _t45, _t46;
        if (_t35 > 0.0f) {
            _t44 = _t25 * _t36;
            _t45 = _t26 * _t36;
            _t46 = _t24 * _t36;
        } else {
            _t44 = 0.0f;
            _t45 = 0.0f;
            _t46 = 0.0f;
        }
        float _t53 = Math.fma(_t27, _t34, Math.fma(-_t27, _t34, -nearFarDist));
        float _t53_inv = 1.0f / _t53;
        float _t54 = Math.fma(_yy, _t44, -(_yx * _t45));
        float _t55 = Math.fma(_yx, _t46, -(_yz * _t44));
        float _t56 = Math.fma(_yz, _t45, -(_yy * _t46));
        float _t59 = Math.fma(_t54, _t54, Math.fma(_t55, _t55, _t56 * _t56));
        float _t60 = (1.0f / (float) Math.sqrt(_t59));
        float _t64, _t65, _t66;
        if (_t59 > 0.0f) {
            _t64 = _t56 * _t60;
            _t65 = _t55 * _t60;
            _t66 = _t54 * _t60;
        } else {
            _t64 = 0.0f;
            _t65 = 0.0f;
            _t66 = 0.0f;
        }
        float _t85 = Math.fma(_px, _t64, _py * _t65);
        float _t87 = Math.fma(_pz, _t66, -(_eyex * _t64));
        float _t89 = Math.fma(_t0, _t66, -(_eyey * _t65));
        float _t91 = Math.fma(_t46, _t65, -(_t45 * _t66));
        float _t92 = Math.fma(_t44, _t66, -(_t46 * _t64));
        float _t93 = Math.fma(_t45, _t64, -(_t44 * _t65));
        float _t110 = Math.fma(_px, _t91, _py * _t92);
        float _t112 = Math.fma(_pz, _t93, -(_eyex * _t91));
        float _t114 = Math.fma(_t0, _t93, -(_eyey * _t92));
        float _t117 = Math.fma(_xx, _t64, Math.fma(_xy, _t65, _xz * _t66)) + (_t85 + _t87);
        float _t122 = Math.fma(_yx, _t91, Math.fma(_yy, _t92, _yz * _t93)) + (_t110 + _t112);
        float _t123 = _t117 + (_t89 + Math.fma(_t1, _t65, -(_px * _t64)) + (Math.fma(_eyex, _t64, -(_pz * _t66)) + Math.fma(_eyey, _t65, _eyez * _t66)));
        float _t123_inv = 1.0f / _t123;
        float _t125 = _t122 + (_t114 + Math.fma(_t1, _t92, -(_px * _t91)) + (Math.fma(_eyex, _t91, -(_pz * _t93)) + Math.fma(_eyey, _t92, _eyez * _t93)));
        float _t125_inv = 1.0f / _t125;
        if (_t41 == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = -1.0f;
            dest[destOffset + 14] = -_t42;
        } else {
            if (_t40 == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = 1.0f;
                dest[destOffset + 14] = 2.0f * _t41;
            } else {
                dest[destOffset + 10] = Math.fma(_t27, _t34, _t41) * _t53_inv;
                dest[destOffset + 14] = 2.0f * _t41 * _t40 * _t53_inv;
            }
        }
        dest[destOffset + 0] = _t42 * _t123_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = _t42 * _t125_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = (_t117 + (_t89 + _t85 + (_t87 + _t89))) * _t123_inv;
        dest[destOffset + 9] = (_t122 + (_t114 + _t110 + (_t112 + _t114))) * _t125_inv;
        dest[destOffset + 11] = -1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makePerspectiveOffCenterRectangleProj_no(float[] dest, int destOffset, float[] eye, int eyeOffset, float[] p, int pOffset, float[] x, int xOffset, float[] y, int yOffset, float nearFarDist, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.makePerspectiveOffCenterRectangleProj_no_lh(dest, destOffset, eye, eyeOffset, p, pOffset, x, xOffset, y, yOffset, nearFarDist); }
            default -> { return Float4x4OpsKernelsArray.makePerspectiveOffCenterRectangleProj_no_rh(dest, destOffset, eye, eyeOffset, p, pOffset, x, xOffset, y, yOffset, nearFarDist); }
        }
    }

    public static float[] makePerspectiveOffCenterRectangleProj_zo_lh(float[] dest, int destOffset, float[] eye, int eyeOffset, float[] p, int pOffset, float[] x, int xOffset, float[] y, int yOffset, float nearFarDist) {
        float _eyex = eye[eyeOffset + 0];
        float _eyey = eye[eyeOffset + 1];
        float _eyez = eye[eyeOffset + 2];
        float _px = p[pOffset + 0];
        float _py = p[pOffset + 1];
        float _pz = p[pOffset + 2];
        float _xx = x[xOffset + 0];
        float _xy = x[xOffset + 1];
        float _xz = x[xOffset + 2];
        float _yx = y[yOffset + 0];
        float _yy = y[yOffset + 1];
        float _yz = y[yOffset + 2];
        float _t0 = -_eyez;
        float _t1 = -_py;
        float _t14 = Math.fma(_xy, _yx, -(_xx * _yy));
        float _t15 = Math.fma(_xz, _yy, -(_xy * _yz));
        float _t16 = Math.fma(_xx, _yz, -(_xz * _yx));
        float _t19 = Math.fma(_pz - _eyez, _t14, Math.fma(_px - _eyex, _t15, (_py - _eyey) * _t16));
        float _t20 = _t19 >= 0.0f ? 1.0f : -1.0f;
        float _t21 = _t14 * _t20;
        float _t22 = _t16 * _t20;
        float _t23 = _t15 * _t20;
        float _t24 = Math.fma(_t14, _t20, _eyez - _eyez);
        float _t25 = Math.fma(_t15, _t20, _eyex - _eyex);
        float _t26 = Math.fma(_t16, _t20, _eyey - _eyey);
        float _t27 = _t19 * _t20;
        float _t34 = (1.0f / (float) Math.sqrt(Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23))));
        float _t35 = Math.fma(_t24, _t24, Math.fma(_t25, _t25, _t26 * _t26));
        float _t36 = (1.0f / (float) Math.sqrt(_t35));
        float _t40 = _t27 * _t34;
        float _t41 = Math.fma(_t27, _t34, nearFarDist);
        float _t42 = 2.0f * _t40;
        float _t44, _t45, _t46;
        if (_t35 > 0.0f) {
            _t44 = _t26 * _t36;
            _t45 = _t25 * _t36;
            _t46 = _t24 * _t36;
        } else {
            _t44 = 0.0f;
            _t45 = 0.0f;
            _t46 = 0.0f;
        }
        float _t53 = Math.fma(_t27, _t34, Math.fma(-_t27, _t34, -nearFarDist));
        float _t53_inv = 1.0f / _t53;
        float _t54 = Math.fma(_yx, _t44, -(_yy * _t45));
        float _t55 = Math.fma(_yy, _t46, -(_yz * _t44));
        float _t56 = Math.fma(_yz, _t45, -(_yx * _t46));
        float _t59 = Math.fma(_t54, _t54, Math.fma(_t55, _t55, _t56 * _t56));
        float _t60 = (1.0f / (float) Math.sqrt(_t59));
        float _t64, _t65, _t66;
        if (_t59 > 0.0f) {
            _t64 = _t55 * _t60;
            _t65 = _t56 * _t60;
            _t66 = _t54 * _t60;
        } else {
            _t64 = 0.0f;
            _t65 = 0.0f;
            _t66 = 0.0f;
        }
        float _t85 = Math.fma(_px, _t64, _py * _t65);
        float _t87 = Math.fma(_pz, _t66, -(_eyex * _t64));
        float _t89 = Math.fma(_t0, _t66, -(_eyey * _t65));
        float _t91 = Math.fma(_t44, _t66, -(_t46 * _t65));
        float _t92 = Math.fma(_t46, _t64, -(_t45 * _t66));
        float _t93 = Math.fma(_t45, _t65, -(_t44 * _t64));
        float _t110 = Math.fma(_px, _t91, _py * _t92);
        float _t112 = Math.fma(_pz, _t93, -(_eyex * _t91));
        float _t114 = Math.fma(_t0, _t93, -(_eyey * _t92));
        float _t117 = Math.fma(_xx, _t64, Math.fma(_xy, _t65, _xz * _t66)) + (_t85 + _t87);
        float _t122 = Math.fma(_yx, _t91, Math.fma(_yy, _t92, _yz * _t93)) + (_t110 + _t112);
        float _t123 = _t117 + (_t89 + Math.fma(_t1, _t65, -(_px * _t64)) + (Math.fma(_eyex, _t64, -(_pz * _t66)) + Math.fma(_eyey, _t65, _eyez * _t66)));
        float _t123_inv = 1.0f / _t123;
        float _t125 = _t122 + (_t114 + Math.fma(_t1, _t92, -(_px * _t91)) + (Math.fma(_eyex, _t91, -(_pz * _t93)) + Math.fma(_eyey, _t92, _eyez * _t93)));
        float _t125_inv = 1.0f / _t125;
        if (_t41 == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = 1.0f;
            dest[destOffset + 14] = -_t40;
        } else {
            if (_t40 == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = 0.0f;
                dest[destOffset + 14] = _t41;
            } else {
                dest[destOffset + 10] = -(_t41 * _t53_inv);
                dest[destOffset + 14] = _t41 * _t40 * _t53_inv;
            }
        }
        dest[destOffset + 0] = _t42 * _t123_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = _t42 * _t125_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = -((_t117 + (_t89 + _t85 + (_t87 + _t89))) * _t123_inv);
        dest[destOffset + 9] = -((_t122 + (_t114 + _t110 + (_t112 + _t114))) * _t125_inv);
        dest[destOffset + 11] = 1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makePerspectiveOffCenterRectangleProj_zo_rh(float[] dest, int destOffset, float[] eye, int eyeOffset, float[] p, int pOffset, float[] x, int xOffset, float[] y, int yOffset, float nearFarDist) {
        float _eyex = eye[eyeOffset + 0];
        float _eyey = eye[eyeOffset + 1];
        float _eyez = eye[eyeOffset + 2];
        float _px = p[pOffset + 0];
        float _py = p[pOffset + 1];
        float _pz = p[pOffset + 2];
        float _xx = x[xOffset + 0];
        float _xy = x[xOffset + 1];
        float _xz = x[xOffset + 2];
        float _yx = y[yOffset + 0];
        float _yy = y[yOffset + 1];
        float _yz = y[yOffset + 2];
        float _t0 = -_eyez;
        float _t1 = -_py;
        float _t14 = Math.fma(_xy, _yx, -(_xx * _yy));
        float _t15 = Math.fma(_xz, _yy, -(_xy * _yz));
        float _t16 = Math.fma(_xx, _yz, -(_xz * _yx));
        float _t19 = Math.fma(_pz - _eyez, _t14, Math.fma(_px - _eyex, _t15, (_py - _eyey) * _t16));
        float _t20 = _t19 >= 0.0f ? 1.0f : -1.0f;
        float _t21 = _t14 * _t20;
        float _t22 = _t16 * _t20;
        float _t23 = _t15 * _t20;
        float _t24 = Math.fma(_t14, _t20, _eyez - _eyez);
        float _t25 = Math.fma(_t15, _t20, _eyex - _eyex);
        float _t26 = Math.fma(_t16, _t20, _eyey - _eyey);
        float _t27 = _t19 * _t20;
        float _t34 = (1.0f / (float) Math.sqrt(Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23))));
        float _t35 = Math.fma(_t24, _t24, Math.fma(_t25, _t25, _t26 * _t26));
        float _t36 = (1.0f / (float) Math.sqrt(_t35));
        float _t40 = _t27 * _t34;
        float _t41 = Math.fma(_t27, _t34, nearFarDist);
        float _t42 = 2.0f * _t40;
        float _t44, _t45, _t46;
        if (_t35 > 0.0f) {
            _t44 = _t25 * _t36;
            _t45 = _t26 * _t36;
            _t46 = _t24 * _t36;
        } else {
            _t44 = 0.0f;
            _t45 = 0.0f;
            _t46 = 0.0f;
        }
        float _t53 = Math.fma(_t27, _t34, Math.fma(-_t27, _t34, -nearFarDist));
        float _t53_inv = 1.0f / _t53;
        float _t54 = Math.fma(_yy, _t44, -(_yx * _t45));
        float _t55 = Math.fma(_yx, _t46, -(_yz * _t44));
        float _t56 = Math.fma(_yz, _t45, -(_yy * _t46));
        float _t59 = Math.fma(_t54, _t54, Math.fma(_t55, _t55, _t56 * _t56));
        float _t60 = (1.0f / (float) Math.sqrt(_t59));
        float _t64, _t65, _t66;
        if (_t59 > 0.0f) {
            _t64 = _t56 * _t60;
            _t65 = _t55 * _t60;
            _t66 = _t54 * _t60;
        } else {
            _t64 = 0.0f;
            _t65 = 0.0f;
            _t66 = 0.0f;
        }
        float _t85 = Math.fma(_px, _t64, _py * _t65);
        float _t87 = Math.fma(_pz, _t66, -(_eyex * _t64));
        float _t89 = Math.fma(_t0, _t66, -(_eyey * _t65));
        float _t91 = Math.fma(_t46, _t65, -(_t45 * _t66));
        float _t92 = Math.fma(_t44, _t66, -(_t46 * _t64));
        float _t93 = Math.fma(_t45, _t64, -(_t44 * _t65));
        float _t110 = Math.fma(_px, _t91, _py * _t92);
        float _t112 = Math.fma(_pz, _t93, -(_eyex * _t91));
        float _t114 = Math.fma(_t0, _t93, -(_eyey * _t92));
        float _t117 = Math.fma(_xx, _t64, Math.fma(_xy, _t65, _xz * _t66)) + (_t85 + _t87);
        float _t122 = Math.fma(_yx, _t91, Math.fma(_yy, _t92, _yz * _t93)) + (_t110 + _t112);
        float _t123 = _t117 + (_t89 + Math.fma(_t1, _t65, -(_px * _t64)) + (Math.fma(_eyex, _t64, -(_pz * _t66)) + Math.fma(_eyey, _t65, _eyez * _t66)));
        float _t123_inv = 1.0f / _t123;
        float _t125 = _t122 + (_t114 + Math.fma(_t1, _t92, -(_px * _t91)) + (Math.fma(_eyex, _t91, -(_pz * _t93)) + Math.fma(_eyey, _t92, _eyez * _t93)));
        float _t125_inv = 1.0f / _t125;
        if (_t41 == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = -1.0f;
            dest[destOffset + 14] = -_t40;
        } else {
            if (_t40 == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = 0.0f;
                dest[destOffset + 14] = _t41;
            } else {
                dest[destOffset + 10] = _t41 * _t53_inv;
                dest[destOffset + 14] = _t41 * _t40 * _t53_inv;
            }
        }
        dest[destOffset + 0] = _t42 * _t123_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = _t42 * _t125_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = (_t117 + (_t89 + _t85 + (_t87 + _t89))) * _t123_inv;
        dest[destOffset + 9] = (_t122 + (_t114 + _t110 + (_t112 + _t114))) * _t125_inv;
        dest[destOffset + 11] = -1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makePerspectiveOffCenterRectangleProj_zo(float[] dest, int destOffset, float[] eye, int eyeOffset, float[] p, int pOffset, float[] x, int xOffset, float[] y, int yOffset, float nearFarDist, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.makePerspectiveOffCenterRectangleProj_zo_lh(dest, destOffset, eye, eyeOffset, p, pOffset, x, xOffset, y, yOffset, nearFarDist); }
            default -> { return Float4x4OpsKernelsArray.makePerspectiveOffCenterRectangleProj_zo_rh(dest, destOffset, eye, eyeOffset, p, pOffset, x, xOffset, y, yOffset, nearFarDist); }
        }
    }

    public static float[] makePerspectiveOffCenterRectangleView_lh(float[] dest, int destOffset, float eyeX, float eyeY, float eyeZ, float pX, float pY, float pZ, float xX, float xY, float xZ, float yX, float yY, float yZ) {
        float _t12 = Math.fma(xY, yX, -(xX * yY));
        float _t13 = Math.fma(xZ, yY, -(xY * yZ));
        float _t14 = Math.fma(xX, yZ, -(xZ * yX));
        float _t18 = Math.fma(pZ - eyeZ, _t12, Math.fma(pX - eyeX, _t13, (pY - eyeY) * _t14)) >= 0.0f ? 1.0f : -1.0f;
        float _t19 = Math.fma(_t12, _t18, eyeZ - eyeZ);
        float _t20 = Math.fma(_t13, _t18, eyeX - eyeX);
        float _t21 = Math.fma(_t14, _t18, eyeY - eyeY);
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
        float _t38 = Math.fma(yX, _t29, -(yY * _t30));
        float _t39 = Math.fma(yY, _t31, -(yZ * _t29));
        float _t40 = Math.fma(yZ, _t30, -(yX * _t31));
        float _t43 = Math.fma(_t38, _t38, Math.fma(_t39, _t39, _t40 * _t40));
        float _t44 = (1.0f / (float) Math.sqrt(_t43));
        float _t48, _t49, _t50;
        if (_t43 > 0.0f) {
            _t48 = _t39 * _t44;
            _t49 = _t40 * _t44;
            _t50 = _t38 * _t44;
        } else {
            _t48 = 0.0f;
            _t49 = 0.0f;
            _t50 = 0.0f;
        }
        float _t57 = Math.fma(_t29, _t50, -(_t31 * _t49));
        float _t58 = Math.fma(_t31, _t48, -(_t30 * _t50));
        float _t59 = Math.fma(_t30, _t49, -(_t29 * _t48));
        dest[destOffset + 0] = _t48;
        dest[destOffset + 1] = _t57;
        dest[destOffset + 2] = _t30;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = _t49;
        dest[destOffset + 5] = _t58;
        dest[destOffset + 6] = _t29;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = _t50;
        dest[destOffset + 9] = _t59;
        dest[destOffset + 10] = _t31;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -Math.fma(eyeZ, _t50, Math.fma(eyeX, _t48, eyeY * _t49));
        dest[destOffset + 13] = -Math.fma(eyeZ, _t59, Math.fma(eyeX, _t57, eyeY * _t58));
        dest[destOffset + 14] = -Math.fma(eyeZ, _t31, Math.fma(eyeX, _t30, eyeY * _t29));
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] makePerspectiveOffCenterRectangleView_rh(float[] dest, int destOffset, float eyeX, float eyeY, float eyeZ, float pX, float pY, float pZ, float xX, float xY, float xZ, float yX, float yY, float yZ) {
        float _t12 = Math.fma(xY, yX, -(xX * yY));
        float _t13 = Math.fma(xZ, yY, -(xY * yZ));
        float _t14 = Math.fma(xX, yZ, -(xZ * yX));
        float _t18 = Math.fma(pZ - eyeZ, _t12, Math.fma(pX - eyeX, _t13, (pY - eyeY) * _t14)) >= 0.0f ? 1.0f : -1.0f;
        float _t19 = Math.fma(_t12, _t18, eyeZ - eyeZ);
        float _t20 = Math.fma(_t13, _t18, eyeX - eyeX);
        float _t21 = Math.fma(_t14, _t18, eyeY - eyeY);
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
        float _t38 = Math.fma(yY, _t29, -(yX * _t30));
        float _t39 = Math.fma(yX, _t31, -(yZ * _t29));
        float _t40 = Math.fma(yZ, _t30, -(yY * _t31));
        float _t43 = Math.fma(_t38, _t38, Math.fma(_t39, _t39, _t40 * _t40));
        float _t44 = (1.0f / (float) Math.sqrt(_t43));
        float _t48, _t49, _t50;
        if (_t43 > 0.0f) {
            _t48 = _t40 * _t44;
            _t49 = _t39 * _t44;
            _t50 = _t38 * _t44;
        } else {
            _t48 = 0.0f;
            _t49 = 0.0f;
            _t50 = 0.0f;
        }
        float _t57 = Math.fma(_t31, _t49, -(_t30 * _t50));
        float _t58 = Math.fma(_t29, _t50, -(_t31 * _t48));
        float _t59 = Math.fma(_t30, _t48, -(_t29 * _t49));
        dest[destOffset + 0] = _t48;
        dest[destOffset + 1] = _t57;
        dest[destOffset + 2] = -_t29;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = _t49;
        dest[destOffset + 5] = _t58;
        dest[destOffset + 6] = -_t30;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = _t50;
        dest[destOffset + 9] = _t59;
        dest[destOffset + 10] = -_t31;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -Math.fma(eyeZ, _t50, Math.fma(eyeX, _t48, eyeY * _t49));
        dest[destOffset + 13] = -Math.fma(eyeZ, _t59, Math.fma(eyeX, _t57, eyeY * _t58));
        dest[destOffset + 14] = Math.fma(eyeZ, _t31, Math.fma(eyeX, _t29, eyeY * _t30));
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] makePerspectiveOffCenterRectangleView_lh(float[] dest, int destOffset, float[] eye, int eyeOffset, float[] p, int pOffset, float[] x, int xOffset, float[] y, int yOffset) {
        float _eyex = eye[eyeOffset + 0];
        float _eyey = eye[eyeOffset + 1];
        float _eyez = eye[eyeOffset + 2];
        float _px = p[pOffset + 0];
        float _py = p[pOffset + 1];
        float _pz = p[pOffset + 2];
        float _xx = x[xOffset + 0];
        float _xy = x[xOffset + 1];
        float _xz = x[xOffset + 2];
        float _yx = y[yOffset + 0];
        float _yy = y[yOffset + 1];
        float _yz = y[yOffset + 2];
        float _t12 = Math.fma(_xy, _yx, -(_xx * _yy));
        float _t13 = Math.fma(_xz, _yy, -(_xy * _yz));
        float _t14 = Math.fma(_xx, _yz, -(_xz * _yx));
        float _t18 = Math.fma(_pz - _eyez, _t12, Math.fma(_px - _eyex, _t13, (_py - _eyey) * _t14)) >= 0.0f ? 1.0f : -1.0f;
        float _t19 = Math.fma(_t12, _t18, _eyez - _eyez);
        float _t20 = Math.fma(_t13, _t18, _eyex - _eyex);
        float _t21 = Math.fma(_t14, _t18, _eyey - _eyey);
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
        float _t38 = Math.fma(_yx, _t29, -(_yy * _t30));
        float _t39 = Math.fma(_yy, _t31, -(_yz * _t29));
        float _t40 = Math.fma(_yz, _t30, -(_yx * _t31));
        float _t43 = Math.fma(_t38, _t38, Math.fma(_t39, _t39, _t40 * _t40));
        float _t44 = (1.0f / (float) Math.sqrt(_t43));
        float _t48, _t49, _t50;
        if (_t43 > 0.0f) {
            _t48 = _t39 * _t44;
            _t49 = _t40 * _t44;
            _t50 = _t38 * _t44;
        } else {
            _t48 = 0.0f;
            _t49 = 0.0f;
            _t50 = 0.0f;
        }
        float _t57 = Math.fma(_t29, _t50, -(_t31 * _t49));
        float _t58 = Math.fma(_t31, _t48, -(_t30 * _t50));
        float _t59 = Math.fma(_t30, _t49, -(_t29 * _t48));
        dest[destOffset + 0] = _t48;
        dest[destOffset + 1] = _t57;
        dest[destOffset + 2] = _t30;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = _t49;
        dest[destOffset + 5] = _t58;
        dest[destOffset + 6] = _t29;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = _t50;
        dest[destOffset + 9] = _t59;
        dest[destOffset + 10] = _t31;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -Math.fma(_eyez, _t50, Math.fma(_eyex, _t48, _eyey * _t49));
        dest[destOffset + 13] = -Math.fma(_eyez, _t59, Math.fma(_eyex, _t57, _eyey * _t58));
        dest[destOffset + 14] = -Math.fma(_eyez, _t31, Math.fma(_eyex, _t30, _eyey * _t29));
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] makePerspectiveOffCenterRectangleView_rh(float[] dest, int destOffset, float[] eye, int eyeOffset, float[] p, int pOffset, float[] x, int xOffset, float[] y, int yOffset) {
        float _eyex = eye[eyeOffset + 0];
        float _eyey = eye[eyeOffset + 1];
        float _eyez = eye[eyeOffset + 2];
        float _px = p[pOffset + 0];
        float _py = p[pOffset + 1];
        float _pz = p[pOffset + 2];
        float _xx = x[xOffset + 0];
        float _xy = x[xOffset + 1];
        float _xz = x[xOffset + 2];
        float _yx = y[yOffset + 0];
        float _yy = y[yOffset + 1];
        float _yz = y[yOffset + 2];
        float _t12 = Math.fma(_xy, _yx, -(_xx * _yy));
        float _t13 = Math.fma(_xz, _yy, -(_xy * _yz));
        float _t14 = Math.fma(_xx, _yz, -(_xz * _yx));
        float _t18 = Math.fma(_pz - _eyez, _t12, Math.fma(_px - _eyex, _t13, (_py - _eyey) * _t14)) >= 0.0f ? 1.0f : -1.0f;
        float _t19 = Math.fma(_t12, _t18, _eyez - _eyez);
        float _t20 = Math.fma(_t13, _t18, _eyex - _eyex);
        float _t21 = Math.fma(_t14, _t18, _eyey - _eyey);
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
        float _t38 = Math.fma(_yy, _t29, -(_yx * _t30));
        float _t39 = Math.fma(_yx, _t31, -(_yz * _t29));
        float _t40 = Math.fma(_yz, _t30, -(_yy * _t31));
        float _t43 = Math.fma(_t38, _t38, Math.fma(_t39, _t39, _t40 * _t40));
        float _t44 = (1.0f / (float) Math.sqrt(_t43));
        float _t48, _t49, _t50;
        if (_t43 > 0.0f) {
            _t48 = _t40 * _t44;
            _t49 = _t39 * _t44;
            _t50 = _t38 * _t44;
        } else {
            _t48 = 0.0f;
            _t49 = 0.0f;
            _t50 = 0.0f;
        }
        float _t57 = Math.fma(_t31, _t49, -(_t30 * _t50));
        float _t58 = Math.fma(_t29, _t50, -(_t31 * _t48));
        float _t59 = Math.fma(_t30, _t48, -(_t29 * _t49));
        dest[destOffset + 0] = _t48;
        dest[destOffset + 1] = _t57;
        dest[destOffset + 2] = -_t29;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = _t49;
        dest[destOffset + 5] = _t58;
        dest[destOffset + 6] = -_t30;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = _t50;
        dest[destOffset + 9] = _t59;
        dest[destOffset + 10] = -_t31;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -Math.fma(_eyez, _t50, Math.fma(_eyex, _t48, _eyey * _t49));
        dest[destOffset + 13] = -Math.fma(_eyez, _t59, Math.fma(_eyex, _t57, _eyey * _t58));
        dest[destOffset + 14] = Math.fma(_eyez, _t31, Math.fma(_eyex, _t29, _eyey * _t30));
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] mapXYZ_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        for (int _i = 0; _i < 16; _i++) {
            float _eself = src[srcOffset + _i];
            dest[destOffset + _i] = _eself;
        }
        return dest;
    }

    public static float[] mapXYnZ_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = _self00;
        dest[destOffset + 1] = _self10;
        dest[destOffset + 2] = _self20;
        dest[destOffset + 3] = _self30;
        dest[destOffset + 4] = _self01;
        dest[destOffset + 5] = _self11;
        dest[destOffset + 6] = _self21;
        dest[destOffset + 7] = _self31;
        dest[destOffset + 8] = -_self02;
        dest[destOffset + 9] = -_self12;
        dest[destOffset + 10] = -_self22;
        dest[destOffset + 11] = -_self32;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapXZY_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = _self00;
        dest[destOffset + 1] = _self10;
        dest[destOffset + 2] = _self20;
        dest[destOffset + 3] = _self30;
        dest[destOffset + 4] = _self02;
        dest[destOffset + 5] = _self12;
        dest[destOffset + 6] = _self22;
        dest[destOffset + 7] = _self32;
        dest[destOffset + 8] = _self01;
        dest[destOffset + 9] = _self11;
        dest[destOffset + 10] = _self21;
        dest[destOffset + 11] = _self31;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapXZnY_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = _self00;
        dest[destOffset + 1] = _self10;
        dest[destOffset + 2] = _self20;
        dest[destOffset + 3] = _self30;
        dest[destOffset + 4] = _self02;
        dest[destOffset + 5] = _self12;
        dest[destOffset + 6] = _self22;
        dest[destOffset + 7] = _self32;
        dest[destOffset + 8] = -_self01;
        dest[destOffset + 9] = -_self11;
        dest[destOffset + 10] = -_self21;
        dest[destOffset + 11] = -_self31;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapXnYZ_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = _self00;
        dest[destOffset + 1] = _self10;
        dest[destOffset + 2] = _self20;
        dest[destOffset + 3] = _self30;
        dest[destOffset + 4] = -_self01;
        dest[destOffset + 5] = -_self11;
        dest[destOffset + 6] = -_self21;
        dest[destOffset + 7] = -_self31;
        dest[destOffset + 8] = _self02;
        dest[destOffset + 9] = _self12;
        dest[destOffset + 10] = _self22;
        dest[destOffset + 11] = _self32;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapXnYnZ_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = _self00;
        dest[destOffset + 1] = _self10;
        dest[destOffset + 2] = _self20;
        dest[destOffset + 3] = _self30;
        dest[destOffset + 4] = -_self01;
        dest[destOffset + 5] = -_self11;
        dest[destOffset + 6] = -_self21;
        dest[destOffset + 7] = -_self31;
        dest[destOffset + 8] = -_self02;
        dest[destOffset + 9] = -_self12;
        dest[destOffset + 10] = -_self22;
        dest[destOffset + 11] = -_self32;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapXnZY_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = _self00;
        dest[destOffset + 1] = _self10;
        dest[destOffset + 2] = _self20;
        dest[destOffset + 3] = _self30;
        dest[destOffset + 4] = -_self02;
        dest[destOffset + 5] = -_self12;
        dest[destOffset + 6] = -_self22;
        dest[destOffset + 7] = -_self32;
        dest[destOffset + 8] = _self01;
        dest[destOffset + 9] = _self11;
        dest[destOffset + 10] = _self21;
        dest[destOffset + 11] = _self31;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapXnZnY_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = _self00;
        dest[destOffset + 1] = _self10;
        dest[destOffset + 2] = _self20;
        dest[destOffset + 3] = _self30;
        dest[destOffset + 4] = -_self02;
        dest[destOffset + 5] = -_self12;
        dest[destOffset + 6] = -_self22;
        dest[destOffset + 7] = -_self32;
        dest[destOffset + 8] = -_self01;
        dest[destOffset + 9] = -_self11;
        dest[destOffset + 10] = -_self21;
        dest[destOffset + 11] = -_self31;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapYXZ_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = _self01;
        dest[destOffset + 1] = _self11;
        dest[destOffset + 2] = _self21;
        dest[destOffset + 3] = _self31;
        dest[destOffset + 4] = _self00;
        dest[destOffset + 5] = _self10;
        dest[destOffset + 6] = _self20;
        dest[destOffset + 7] = _self30;
        dest[destOffset + 8] = _self02;
        dest[destOffset + 9] = _self12;
        dest[destOffset + 10] = _self22;
        dest[destOffset + 11] = _self32;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapYXnZ_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = _self01;
        dest[destOffset + 1] = _self11;
        dest[destOffset + 2] = _self21;
        dest[destOffset + 3] = _self31;
        dest[destOffset + 4] = _self00;
        dest[destOffset + 5] = _self10;
        dest[destOffset + 6] = _self20;
        dest[destOffset + 7] = _self30;
        dest[destOffset + 8] = -_self02;
        dest[destOffset + 9] = -_self12;
        dest[destOffset + 10] = -_self22;
        dest[destOffset + 11] = -_self32;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapYZX_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = _self01;
        dest[destOffset + 1] = _self11;
        dest[destOffset + 2] = _self21;
        dest[destOffset + 3] = _self31;
        dest[destOffset + 4] = _self02;
        dest[destOffset + 5] = _self12;
        dest[destOffset + 6] = _self22;
        dest[destOffset + 7] = _self32;
        dest[destOffset + 8] = _self00;
        dest[destOffset + 9] = _self10;
        dest[destOffset + 10] = _self20;
        dest[destOffset + 11] = _self30;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapYZnX_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = _self01;
        dest[destOffset + 1] = _self11;
        dest[destOffset + 2] = _self21;
        dest[destOffset + 3] = _self31;
        dest[destOffset + 4] = _self02;
        dest[destOffset + 5] = _self12;
        dest[destOffset + 6] = _self22;
        dest[destOffset + 7] = _self32;
        dest[destOffset + 8] = -_self00;
        dest[destOffset + 9] = -_self10;
        dest[destOffset + 10] = -_self20;
        dest[destOffset + 11] = -_self30;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapYnXZ_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = _self01;
        dest[destOffset + 1] = _self11;
        dest[destOffset + 2] = _self21;
        dest[destOffset + 3] = _self31;
        dest[destOffset + 4] = -_self00;
        dest[destOffset + 5] = -_self10;
        dest[destOffset + 6] = -_self20;
        dest[destOffset + 7] = -_self30;
        dest[destOffset + 8] = _self02;
        dest[destOffset + 9] = _self12;
        dest[destOffset + 10] = _self22;
        dest[destOffset + 11] = _self32;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapYnXnZ_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = _self01;
        dest[destOffset + 1] = _self11;
        dest[destOffset + 2] = _self21;
        dest[destOffset + 3] = _self31;
        dest[destOffset + 4] = -_self00;
        dest[destOffset + 5] = -_self10;
        dest[destOffset + 6] = -_self20;
        dest[destOffset + 7] = -_self30;
        dest[destOffset + 8] = -_self02;
        dest[destOffset + 9] = -_self12;
        dest[destOffset + 10] = -_self22;
        dest[destOffset + 11] = -_self32;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapYnZX_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = _self01;
        dest[destOffset + 1] = _self11;
        dest[destOffset + 2] = _self21;
        dest[destOffset + 3] = _self31;
        dest[destOffset + 4] = -_self02;
        dest[destOffset + 5] = -_self12;
        dest[destOffset + 6] = -_self22;
        dest[destOffset + 7] = -_self32;
        dest[destOffset + 8] = _self00;
        dest[destOffset + 9] = _self10;
        dest[destOffset + 10] = _self20;
        dest[destOffset + 11] = _self30;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapYnZnX_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = _self01;
        dest[destOffset + 1] = _self11;
        dest[destOffset + 2] = _self21;
        dest[destOffset + 3] = _self31;
        dest[destOffset + 4] = -_self02;
        dest[destOffset + 5] = -_self12;
        dest[destOffset + 6] = -_self22;
        dest[destOffset + 7] = -_self32;
        dest[destOffset + 8] = -_self00;
        dest[destOffset + 9] = -_self10;
        dest[destOffset + 10] = -_self20;
        dest[destOffset + 11] = -_self30;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapZXY_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = _self02;
        dest[destOffset + 1] = _self12;
        dest[destOffset + 2] = _self22;
        dest[destOffset + 3] = _self32;
        dest[destOffset + 4] = _self00;
        dest[destOffset + 5] = _self10;
        dest[destOffset + 6] = _self20;
        dest[destOffset + 7] = _self30;
        dest[destOffset + 8] = _self01;
        dest[destOffset + 9] = _self11;
        dest[destOffset + 10] = _self21;
        dest[destOffset + 11] = _self31;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapZXnY_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = _self02;
        dest[destOffset + 1] = _self12;
        dest[destOffset + 2] = _self22;
        dest[destOffset + 3] = _self32;
        dest[destOffset + 4] = _self00;
        dest[destOffset + 5] = _self10;
        dest[destOffset + 6] = _self20;
        dest[destOffset + 7] = _self30;
        dest[destOffset + 8] = -_self01;
        dest[destOffset + 9] = -_self11;
        dest[destOffset + 10] = -_self21;
        dest[destOffset + 11] = -_self31;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapZYX_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = _self02;
        dest[destOffset + 1] = _self12;
        dest[destOffset + 2] = _self22;
        dest[destOffset + 3] = _self32;
        dest[destOffset + 4] = _self01;
        dest[destOffset + 5] = _self11;
        dest[destOffset + 6] = _self21;
        dest[destOffset + 7] = _self31;
        dest[destOffset + 8] = _self00;
        dest[destOffset + 9] = _self10;
        dest[destOffset + 10] = _self20;
        dest[destOffset + 11] = _self30;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapZYnX_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = _self02;
        dest[destOffset + 1] = _self12;
        dest[destOffset + 2] = _self22;
        dest[destOffset + 3] = _self32;
        dest[destOffset + 4] = _self01;
        dest[destOffset + 5] = _self11;
        dest[destOffset + 6] = _self21;
        dest[destOffset + 7] = _self31;
        dest[destOffset + 8] = -_self00;
        dest[destOffset + 9] = -_self10;
        dest[destOffset + 10] = -_self20;
        dest[destOffset + 11] = -_self30;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapZnXY_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = _self02;
        dest[destOffset + 1] = _self12;
        dest[destOffset + 2] = _self22;
        dest[destOffset + 3] = _self32;
        dest[destOffset + 4] = -_self00;
        dest[destOffset + 5] = -_self10;
        dest[destOffset + 6] = -_self20;
        dest[destOffset + 7] = -_self30;
        dest[destOffset + 8] = _self01;
        dest[destOffset + 9] = _self11;
        dest[destOffset + 10] = _self21;
        dest[destOffset + 11] = _self31;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapZnXnY_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = _self02;
        dest[destOffset + 1] = _self12;
        dest[destOffset + 2] = _self22;
        dest[destOffset + 3] = _self32;
        dest[destOffset + 4] = -_self00;
        dest[destOffset + 5] = -_self10;
        dest[destOffset + 6] = -_self20;
        dest[destOffset + 7] = -_self30;
        dest[destOffset + 8] = -_self01;
        dest[destOffset + 9] = -_self11;
        dest[destOffset + 10] = -_self21;
        dest[destOffset + 11] = -_self31;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapZnYX_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = _self02;
        dest[destOffset + 1] = _self12;
        dest[destOffset + 2] = _self22;
        dest[destOffset + 3] = _self32;
        dest[destOffset + 4] = -_self01;
        dest[destOffset + 5] = -_self11;
        dest[destOffset + 6] = -_self21;
        dest[destOffset + 7] = -_self31;
        dest[destOffset + 8] = _self00;
        dest[destOffset + 9] = _self10;
        dest[destOffset + 10] = _self20;
        dest[destOffset + 11] = _self30;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapZnYnX_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = _self02;
        dest[destOffset + 1] = _self12;
        dest[destOffset + 2] = _self22;
        dest[destOffset + 3] = _self32;
        dest[destOffset + 4] = -_self01;
        dest[destOffset + 5] = -_self11;
        dest[destOffset + 6] = -_self21;
        dest[destOffset + 7] = -_self31;
        dest[destOffset + 8] = -_self00;
        dest[destOffset + 9] = -_self10;
        dest[destOffset + 10] = -_self20;
        dest[destOffset + 11] = -_self30;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapnXYZ_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = -_self00;
        dest[destOffset + 1] = -_self10;
        dest[destOffset + 2] = -_self20;
        dest[destOffset + 3] = -_self30;
        dest[destOffset + 4] = _self01;
        dest[destOffset + 5] = _self11;
        dest[destOffset + 6] = _self21;
        dest[destOffset + 7] = _self31;
        dest[destOffset + 8] = _self02;
        dest[destOffset + 9] = _self12;
        dest[destOffset + 10] = _self22;
        dest[destOffset + 11] = _self32;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapnXYnZ_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = -_self00;
        dest[destOffset + 1] = -_self10;
        dest[destOffset + 2] = -_self20;
        dest[destOffset + 3] = -_self30;
        dest[destOffset + 4] = _self01;
        dest[destOffset + 5] = _self11;
        dest[destOffset + 6] = _self21;
        dest[destOffset + 7] = _self31;
        dest[destOffset + 8] = -_self02;
        dest[destOffset + 9] = -_self12;
        dest[destOffset + 10] = -_self22;
        dest[destOffset + 11] = -_self32;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapnXZY_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = -_self00;
        dest[destOffset + 1] = -_self10;
        dest[destOffset + 2] = -_self20;
        dest[destOffset + 3] = -_self30;
        dest[destOffset + 4] = _self02;
        dest[destOffset + 5] = _self12;
        dest[destOffset + 6] = _self22;
        dest[destOffset + 7] = _self32;
        dest[destOffset + 8] = _self01;
        dest[destOffset + 9] = _self11;
        dest[destOffset + 10] = _self21;
        dest[destOffset + 11] = _self31;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapnXZnY_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = -_self00;
        dest[destOffset + 1] = -_self10;
        dest[destOffset + 2] = -_self20;
        dest[destOffset + 3] = -_self30;
        dest[destOffset + 4] = _self02;
        dest[destOffset + 5] = _self12;
        dest[destOffset + 6] = _self22;
        dest[destOffset + 7] = _self32;
        dest[destOffset + 8] = -_self01;
        dest[destOffset + 9] = -_self11;
        dest[destOffset + 10] = -_self21;
        dest[destOffset + 11] = -_self31;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapnXnYZ_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = -_self00;
        dest[destOffset + 1] = -_self10;
        dest[destOffset + 2] = -_self20;
        dest[destOffset + 3] = -_self30;
        dest[destOffset + 4] = -_self01;
        dest[destOffset + 5] = -_self11;
        dest[destOffset + 6] = -_self21;
        dest[destOffset + 7] = -_self31;
        dest[destOffset + 8] = _self02;
        dest[destOffset + 9] = _self12;
        dest[destOffset + 10] = _self22;
        dest[destOffset + 11] = _self32;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapnXnYnZ_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = -_self00;
        dest[destOffset + 1] = -_self10;
        dest[destOffset + 2] = -_self20;
        dest[destOffset + 3] = -_self30;
        dest[destOffset + 4] = -_self01;
        dest[destOffset + 5] = -_self11;
        dest[destOffset + 6] = -_self21;
        dest[destOffset + 7] = -_self31;
        dest[destOffset + 8] = -_self02;
        dest[destOffset + 9] = -_self12;
        dest[destOffset + 10] = -_self22;
        dest[destOffset + 11] = -_self32;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapnXnZY_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = -_self00;
        dest[destOffset + 1] = -_self10;
        dest[destOffset + 2] = -_self20;
        dest[destOffset + 3] = -_self30;
        dest[destOffset + 4] = -_self02;
        dest[destOffset + 5] = -_self12;
        dest[destOffset + 6] = -_self22;
        dest[destOffset + 7] = -_self32;
        dest[destOffset + 8] = _self01;
        dest[destOffset + 9] = _self11;
        dest[destOffset + 10] = _self21;
        dest[destOffset + 11] = _self31;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapnXnZnY_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = -_self00;
        dest[destOffset + 1] = -_self10;
        dest[destOffset + 2] = -_self20;
        dest[destOffset + 3] = -_self30;
        dest[destOffset + 4] = -_self02;
        dest[destOffset + 5] = -_self12;
        dest[destOffset + 6] = -_self22;
        dest[destOffset + 7] = -_self32;
        dest[destOffset + 8] = -_self01;
        dest[destOffset + 9] = -_self11;
        dest[destOffset + 10] = -_self21;
        dest[destOffset + 11] = -_self31;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapnYXZ_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = -_self01;
        dest[destOffset + 1] = -_self11;
        dest[destOffset + 2] = -_self21;
        dest[destOffset + 3] = -_self31;
        dest[destOffset + 4] = _self00;
        dest[destOffset + 5] = _self10;
        dest[destOffset + 6] = _self20;
        dest[destOffset + 7] = _self30;
        dest[destOffset + 8] = _self02;
        dest[destOffset + 9] = _self12;
        dest[destOffset + 10] = _self22;
        dest[destOffset + 11] = _self32;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapnYXnZ_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = -_self01;
        dest[destOffset + 1] = -_self11;
        dest[destOffset + 2] = -_self21;
        dest[destOffset + 3] = -_self31;
        dest[destOffset + 4] = _self00;
        dest[destOffset + 5] = _self10;
        dest[destOffset + 6] = _self20;
        dest[destOffset + 7] = _self30;
        dest[destOffset + 8] = -_self02;
        dest[destOffset + 9] = -_self12;
        dest[destOffset + 10] = -_self22;
        dest[destOffset + 11] = -_self32;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapnYZX_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = -_self01;
        dest[destOffset + 1] = -_self11;
        dest[destOffset + 2] = -_self21;
        dest[destOffset + 3] = -_self31;
        dest[destOffset + 4] = _self02;
        dest[destOffset + 5] = _self12;
        dest[destOffset + 6] = _self22;
        dest[destOffset + 7] = _self32;
        dest[destOffset + 8] = _self00;
        dest[destOffset + 9] = _self10;
        dest[destOffset + 10] = _self20;
        dest[destOffset + 11] = _self30;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapnYZnX_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = -_self01;
        dest[destOffset + 1] = -_self11;
        dest[destOffset + 2] = -_self21;
        dest[destOffset + 3] = -_self31;
        dest[destOffset + 4] = _self02;
        dest[destOffset + 5] = _self12;
        dest[destOffset + 6] = _self22;
        dest[destOffset + 7] = _self32;
        dest[destOffset + 8] = -_self00;
        dest[destOffset + 9] = -_self10;
        dest[destOffset + 10] = -_self20;
        dest[destOffset + 11] = -_self30;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapnYnXZ_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = -_self01;
        dest[destOffset + 1] = -_self11;
        dest[destOffset + 2] = -_self21;
        dest[destOffset + 3] = -_self31;
        dest[destOffset + 4] = -_self00;
        dest[destOffset + 5] = -_self10;
        dest[destOffset + 6] = -_self20;
        dest[destOffset + 7] = -_self30;
        dest[destOffset + 8] = _self02;
        dest[destOffset + 9] = _self12;
        dest[destOffset + 10] = _self22;
        dest[destOffset + 11] = _self32;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapnYnXnZ_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = -_self01;
        dest[destOffset + 1] = -_self11;
        dest[destOffset + 2] = -_self21;
        dest[destOffset + 3] = -_self31;
        dest[destOffset + 4] = -_self00;
        dest[destOffset + 5] = -_self10;
        dest[destOffset + 6] = -_self20;
        dest[destOffset + 7] = -_self30;
        dest[destOffset + 8] = -_self02;
        dest[destOffset + 9] = -_self12;
        dest[destOffset + 10] = -_self22;
        dest[destOffset + 11] = -_self32;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapnYnZX_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = -_self01;
        dest[destOffset + 1] = -_self11;
        dest[destOffset + 2] = -_self21;
        dest[destOffset + 3] = -_self31;
        dest[destOffset + 4] = -_self02;
        dest[destOffset + 5] = -_self12;
        dest[destOffset + 6] = -_self22;
        dest[destOffset + 7] = -_self32;
        dest[destOffset + 8] = _self00;
        dest[destOffset + 9] = _self10;
        dest[destOffset + 10] = _self20;
        dest[destOffset + 11] = _self30;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapnYnZnX_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = -_self01;
        dest[destOffset + 1] = -_self11;
        dest[destOffset + 2] = -_self21;
        dest[destOffset + 3] = -_self31;
        dest[destOffset + 4] = -_self02;
        dest[destOffset + 5] = -_self12;
        dest[destOffset + 6] = -_self22;
        dest[destOffset + 7] = -_self32;
        dest[destOffset + 8] = -_self00;
        dest[destOffset + 9] = -_self10;
        dest[destOffset + 10] = -_self20;
        dest[destOffset + 11] = -_self30;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapnZXY_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = -_self02;
        dest[destOffset + 1] = -_self12;
        dest[destOffset + 2] = -_self22;
        dest[destOffset + 3] = -_self32;
        dest[destOffset + 4] = _self00;
        dest[destOffset + 5] = _self10;
        dest[destOffset + 6] = _self20;
        dest[destOffset + 7] = _self30;
        dest[destOffset + 8] = _self01;
        dest[destOffset + 9] = _self11;
        dest[destOffset + 10] = _self21;
        dest[destOffset + 11] = _self31;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapnZXnY_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = -_self02;
        dest[destOffset + 1] = -_self12;
        dest[destOffset + 2] = -_self22;
        dest[destOffset + 3] = -_self32;
        dest[destOffset + 4] = _self00;
        dest[destOffset + 5] = _self10;
        dest[destOffset + 6] = _self20;
        dest[destOffset + 7] = _self30;
        dest[destOffset + 8] = -_self01;
        dest[destOffset + 9] = -_self11;
        dest[destOffset + 10] = -_self21;
        dest[destOffset + 11] = -_self31;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapnZYX_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = -_self02;
        dest[destOffset + 1] = -_self12;
        dest[destOffset + 2] = -_self22;
        dest[destOffset + 3] = -_self32;
        dest[destOffset + 4] = _self01;
        dest[destOffset + 5] = _self11;
        dest[destOffset + 6] = _self21;
        dest[destOffset + 7] = _self31;
        dest[destOffset + 8] = _self00;
        dest[destOffset + 9] = _self10;
        dest[destOffset + 10] = _self20;
        dest[destOffset + 11] = _self30;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapnZYnX_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = -_self02;
        dest[destOffset + 1] = -_self12;
        dest[destOffset + 2] = -_self22;
        dest[destOffset + 3] = -_self32;
        dest[destOffset + 4] = _self01;
        dest[destOffset + 5] = _self11;
        dest[destOffset + 6] = _self21;
        dest[destOffset + 7] = _self31;
        dest[destOffset + 8] = -_self00;
        dest[destOffset + 9] = -_self10;
        dest[destOffset + 10] = -_self20;
        dest[destOffset + 11] = -_self30;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapnZnXY_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = -_self02;
        dest[destOffset + 1] = -_self12;
        dest[destOffset + 2] = -_self22;
        dest[destOffset + 3] = -_self32;
        dest[destOffset + 4] = -_self00;
        dest[destOffset + 5] = -_self10;
        dest[destOffset + 6] = -_self20;
        dest[destOffset + 7] = -_self30;
        dest[destOffset + 8] = _self01;
        dest[destOffset + 9] = _self11;
        dest[destOffset + 10] = _self21;
        dest[destOffset + 11] = _self31;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapnZnXnY_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = -_self02;
        dest[destOffset + 1] = -_self12;
        dest[destOffset + 2] = -_self22;
        dest[destOffset + 3] = -_self32;
        dest[destOffset + 4] = -_self00;
        dest[destOffset + 5] = -_self10;
        dest[destOffset + 6] = -_self20;
        dest[destOffset + 7] = -_self30;
        dest[destOffset + 8] = -_self01;
        dest[destOffset + 9] = -_self11;
        dest[destOffset + 10] = -_self21;
        dest[destOffset + 11] = -_self31;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapnZnYX_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = -_self02;
        dest[destOffset + 1] = -_self12;
        dest[destOffset + 2] = -_self22;
        dest[destOffset + 3] = -_self32;
        dest[destOffset + 4] = -_self01;
        dest[destOffset + 5] = -_self11;
        dest[destOffset + 6] = -_self21;
        dest[destOffset + 7] = -_self31;
        dest[destOffset + 8] = _self00;
        dest[destOffset + 9] = _self10;
        dest[destOffset + 10] = _self20;
        dest[destOffset + 11] = _self30;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] mapnZnYnX_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = -_self02;
        dest[destOffset + 1] = -_self12;
        dest[destOffset + 2] = -_self22;
        dest[destOffset + 3] = -_self32;
        dest[destOffset + 4] = -_self01;
        dest[destOffset + 5] = -_self11;
        dest[destOffset + 6] = -_self21;
        dest[destOffset + 7] = -_self31;
        dest[destOffset + 8] = -_self00;
        dest[destOffset + 9] = -_self10;
        dest[destOffset + 10] = -_self20;
        dest[destOffset + 11] = -_self30;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] obliqueCabinet_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float angle) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t2 = 0.5f * (float) Math.cos(angle);
        float _t3 = 0.5f * (float) Math.sin(angle);
        dest[destOffset + 0] = _self00;
        dest[destOffset + 1] = _self10;
        dest[destOffset + 2] = _self20;
        dest[destOffset + 3] = _self30;
        dest[destOffset + 4] = _self01;
        dest[destOffset + 5] = _self11;
        dest[destOffset + 6] = _self21;
        dest[destOffset + 7] = _self31;
        dest[destOffset + 8] = Math.fma(-_self00, _t2, Math.fma(-_self01, _t3, _self02));
        dest[destOffset + 9] = Math.fma(-_self10, _t2, Math.fma(-_self11, _t3, _self12));
        dest[destOffset + 10] = Math.fma(-_self20, _t2, Math.fma(-_self21, _t3, _self22));
        dest[destOffset + 11] = Math.fma(-_self30, _t2, Math.fma(-_self31, _t3, _self32));
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] obliqueCavalier_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float angle) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        dest[destOffset + 0] = _self00;
        dest[destOffset + 1] = _self10;
        dest[destOffset + 2] = _self20;
        dest[destOffset + 3] = _self30;
        dest[destOffset + 4] = _self01;
        dest[destOffset + 5] = _self11;
        dest[destOffset + 6] = _self21;
        dest[destOffset + 7] = _self31;
        dest[destOffset + 8] = Math.fma(-_self00, _t0, Math.fma(-_self01, _t1, _self02));
        dest[destOffset + 9] = Math.fma(-_self10, _t0, Math.fma(-_self11, _t1, _self12));
        dest[destOffset + 10] = Math.fma(-_self20, _t0, Math.fma(-_self21, _t1, _self22));
        dest[destOffset + 11] = Math.fma(-_self30, _t0, Math.fma(-_self31, _t1, _self32));
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] obliqueMilitary_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float angle) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        dest[destOffset + 0] = _self00;
        dest[destOffset + 1] = _self10;
        dest[destOffset + 2] = _self20;
        dest[destOffset + 3] = _self30;
        dest[destOffset + 4] = Math.fma(_self00, _t0, Math.fma(_self01, _t1, -_self02));
        dest[destOffset + 5] = Math.fma(_self10, _t0, Math.fma(_self11, _t1, -_self12));
        dest[destOffset + 6] = Math.fma(_self20, _t0, Math.fma(_self21, _t1, -_self22));
        dest[destOffset + 7] = Math.fma(_self30, _t0, Math.fma(_self31, _t1, -_self32));
        dest[destOffset + 8] = _self01;
        dest[destOffset + 9] = _self11;
        dest[destOffset + 10] = _self21;
        dest[destOffset + 11] = _self31;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] obliqueZ_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float planeX, float planeY, float planeZ, float planeW) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = 2.0f * _self23;
        float _t15 = Math.fma(planeW, 1.0f + _self22, _self23 * (planeX * (_self02 + (planeX < 0.0f ? -1.0f : planeX > 0.0f ? 1.0f : 0.0f)) / _self00 + planeY * (_self12 + (planeY < 0.0f ? -1.0f : planeY > 0.0f ? 1.0f : 0.0f)) / _self11 - planeZ));
        float _t15_inv = 1.0f / _t15;
        dest[destOffset + 0] = _self00;
        dest[destOffset + 1] = _self10;
        dest[destOffset + 2] = planeX * _t0 * _t15_inv - _self30;
        dest[destOffset + 3] = _self30;
        dest[destOffset + 4] = _self01;
        dest[destOffset + 5] = _self11;
        dest[destOffset + 6] = planeY * _t0 * _t15_inv - _self31;
        dest[destOffset + 7] = _self31;
        dest[destOffset + 8] = _self02;
        dest[destOffset + 9] = _self12;
        dest[destOffset + 10] = planeZ * _t0 * _t15_inv - _self32;
        dest[destOffset + 11] = _self32;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = planeW * _t0 * _t15_inv - _self33;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] obliqueZ_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] plane, int planeOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _planex = plane[planeOffset + 0];
        float _planey = plane[planeOffset + 1];
        float _planez = plane[planeOffset + 2];
        float _planew = plane[planeOffset + 3];
        float _t0 = 2.0f * _self23;
        float _t15 = Math.fma(_planew, 1.0f + _self22, _self23 * (_planex * (_self02 + (_planex < 0.0f ? -1.0f : _planex > 0.0f ? 1.0f : 0.0f)) / _self00 + _planey * (_self12 + (_planey < 0.0f ? -1.0f : _planey > 0.0f ? 1.0f : 0.0f)) / _self11 - _planez));
        float _t15_inv = 1.0f / _t15;
        dest[destOffset + 0] = _self00;
        dest[destOffset + 1] = _self10;
        dest[destOffset + 2] = _planex * _t0 * _t15_inv - _self30;
        dest[destOffset + 3] = _self30;
        dest[destOffset + 4] = _self01;
        dest[destOffset + 5] = _self11;
        dest[destOffset + 6] = _planey * _t0 * _t15_inv - _self31;
        dest[destOffset + 7] = _self31;
        dest[destOffset + 8] = _self02;
        dest[destOffset + 9] = _self12;
        dest[destOffset + 10] = _planez * _t0 * _t15_inv - _self32;
        dest[destOffset + 11] = _self32;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _planew * _t0 * _t15_inv - _self33;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] ortho_no_lh(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (SimdSupport.VECTOR_API) return Float4x4OpsSimd.ortho_no_lh(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
        return Float4x4OpsKernelsArray.ortho_no_lh_scalar(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
    }

    public static float[] ortho_no_lh_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        float _t2 = zFar - zNear;
        float _t2_inv = 1.0f / _t2;
        float _t3 = left + right;
        float _t4 = bottom + top;
        float _t5 = zFar + zNear;
        dest[destOffset + 0] = 2.0f * _self00 * _t0_inv;
        dest[destOffset + 1] = 2.0f * _self10 * _t0_inv;
        dest[destOffset + 2] = 2.0f * _self20 * _t0_inv;
        dest[destOffset + 3] = 2.0f * _self30 * _t0_inv;
        dest[destOffset + 4] = 2.0f * _self01 * _t1_inv;
        dest[destOffset + 5] = 2.0f * _self11 * _t1_inv;
        dest[destOffset + 6] = 2.0f * _self21 * _t1_inv;
        dest[destOffset + 7] = 2.0f * _self31 * _t1_inv;
        dest[destOffset + 8] = 2.0f * _self02 * _t2_inv;
        dest[destOffset + 9] = 2.0f * _self12 * _t2_inv;
        dest[destOffset + 10] = 2.0f * _self22 * _t2_inv;
        dest[destOffset + 11] = 2.0f * _self32 * _t2_inv;
        dest[destOffset + 12] = _self03 + (-(_self00 * _t3 * _t0_inv) - _self01 * _t4 * _t1_inv - _self02 * _t5 * _t2_inv);
        dest[destOffset + 13] = _self13 + (-(_self10 * _t3 * _t0_inv) - _self11 * _t4 * _t1_inv - _self12 * _t5 * _t2_inv);
        dest[destOffset + 14] = _self23 + (-(_self20 * _t3 * _t0_inv) - _self21 * _t4 * _t1_inv - _self22 * _t5 * _t2_inv);
        dest[destOffset + 15] = _self33 + (-(_self30 * _t3 * _t0_inv) - _self31 * _t4 * _t1_inv - _self32 * _t5 * _t2_inv);
        return dest;
    }

    public static float[] ortho_no_rh(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (SimdSupport.VECTOR_API) return Float4x4OpsSimd.ortho_no_rh(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
        return Float4x4OpsKernelsArray.ortho_no_rh_scalar(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
    }

    public static float[] ortho_no_rh_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        float _t2 = zFar - zNear;
        float _t2_inv = 1.0f / _t2;
        float _t3 = left + right;
        float _t4 = bottom + top;
        float _t5 = zFar + zNear;
        dest[destOffset + 0] = 2.0f * _self00 * _t0_inv;
        dest[destOffset + 1] = 2.0f * _self10 * _t0_inv;
        dest[destOffset + 2] = 2.0f * _self20 * _t0_inv;
        dest[destOffset + 3] = 2.0f * _self30 * _t0_inv;
        dest[destOffset + 4] = 2.0f * _self01 * _t1_inv;
        dest[destOffset + 5] = 2.0f * _self11 * _t1_inv;
        dest[destOffset + 6] = 2.0f * _self21 * _t1_inv;
        dest[destOffset + 7] = 2.0f * _self31 * _t1_inv;
        dest[destOffset + 8] = -2.0f * _self02 * _t2_inv;
        dest[destOffset + 9] = -2.0f * _self12 * _t2_inv;
        dest[destOffset + 10] = -2.0f * _self22 * _t2_inv;
        dest[destOffset + 11] = -2.0f * _self32 * _t2_inv;
        dest[destOffset + 12] = _self03 + (-(_self00 * _t3 * _t0_inv) - _self01 * _t4 * _t1_inv - _self02 * _t5 * _t2_inv);
        dest[destOffset + 13] = _self13 + (-(_self10 * _t3 * _t0_inv) - _self11 * _t4 * _t1_inv - _self12 * _t5 * _t2_inv);
        dest[destOffset + 14] = _self23 + (-(_self20 * _t3 * _t0_inv) - _self21 * _t4 * _t1_inv - _self22 * _t5 * _t2_inv);
        dest[destOffset + 15] = _self33 + (-(_self30 * _t3 * _t0_inv) - _self31 * _t4 * _t1_inv - _self32 * _t5 * _t2_inv);
        return dest;
    }

    public static float[] ortho_no(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.ortho_no_lh(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar); }
            default -> { return Float4x4OpsKernelsArray.ortho_no_rh(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar); }
        }
    }

    public static float[] ortho_zo_lh(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (SimdSupport.VECTOR_API) return Float4x4OpsSimd.ortho_zo_lh(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
        return Float4x4OpsKernelsArray.ortho_zo_lh_scalar(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
    }

    public static float[] ortho_zo_lh_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        float _t2 = zFar - zNear;
        float _t2_inv = 1.0f / _t2;
        float _t3 = left + right;
        float _t4 = bottom + top;
        dest[destOffset + 0] = 2.0f * _self00 * _t0_inv;
        dest[destOffset + 1] = 2.0f * _self10 * _t0_inv;
        dest[destOffset + 2] = 2.0f * _self20 * _t0_inv;
        dest[destOffset + 3] = 2.0f * _self30 * _t0_inv;
        dest[destOffset + 4] = 2.0f * _self01 * _t1_inv;
        dest[destOffset + 5] = 2.0f * _self11 * _t1_inv;
        dest[destOffset + 6] = 2.0f * _self21 * _t1_inv;
        dest[destOffset + 7] = 2.0f * _self31 * _t1_inv;
        dest[destOffset + 8] = _self02 * _t2_inv;
        dest[destOffset + 9] = _self12 * _t2_inv;
        dest[destOffset + 10] = _self22 * _t2_inv;
        dest[destOffset + 11] = _self32 * _t2_inv;
        dest[destOffset + 12] = _self03 + (-(_self00 * _t3 * _t0_inv) - _self01 * _t4 * _t1_inv - zNear * _self02 * _t2_inv);
        dest[destOffset + 13] = _self13 + (-(_self10 * _t3 * _t0_inv) - _self11 * _t4 * _t1_inv - zNear * _self12 * _t2_inv);
        dest[destOffset + 14] = _self23 + (-(_self20 * _t3 * _t0_inv) - _self21 * _t4 * _t1_inv - zNear * _self22 * _t2_inv);
        dest[destOffset + 15] = _self33 + (-(_self30 * _t3 * _t0_inv) - _self31 * _t4 * _t1_inv - zNear * _self32 * _t2_inv);
        return dest;
    }

    public static float[] ortho_zo_rh(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (SimdSupport.VECTOR_API) return Float4x4OpsSimd.ortho_zo_rh(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
        return Float4x4OpsKernelsArray.ortho_zo_rh_scalar(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
    }

    public static float[] ortho_zo_rh_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        float _t2 = zFar - zNear;
        float _t2_inv = 1.0f / _t2;
        float _t3 = left + right;
        float _t4 = bottom + top;
        dest[destOffset + 0] = 2.0f * _self00 * _t0_inv;
        dest[destOffset + 1] = 2.0f * _self10 * _t0_inv;
        dest[destOffset + 2] = 2.0f * _self20 * _t0_inv;
        dest[destOffset + 3] = 2.0f * _self30 * _t0_inv;
        dest[destOffset + 4] = 2.0f * _self01 * _t1_inv;
        dest[destOffset + 5] = 2.0f * _self11 * _t1_inv;
        dest[destOffset + 6] = 2.0f * _self21 * _t1_inv;
        dest[destOffset + 7] = 2.0f * _self31 * _t1_inv;
        dest[destOffset + 8] = -(_self02 * _t2_inv);
        dest[destOffset + 9] = -(_self12 * _t2_inv);
        dest[destOffset + 10] = -(_self22 * _t2_inv);
        dest[destOffset + 11] = -(_self32 * _t2_inv);
        dest[destOffset + 12] = _self03 + (-(_self00 * _t3 * _t0_inv) - _self01 * _t4 * _t1_inv - zNear * _self02 * _t2_inv);
        dest[destOffset + 13] = _self13 + (-(_self10 * _t3 * _t0_inv) - _self11 * _t4 * _t1_inv - zNear * _self12 * _t2_inv);
        dest[destOffset + 14] = _self23 + (-(_self20 * _t3 * _t0_inv) - _self21 * _t4 * _t1_inv - zNear * _self22 * _t2_inv);
        dest[destOffset + 15] = _self33 + (-(_self30 * _t3 * _t0_inv) - _self31 * _t4 * _t1_inv - zNear * _self32 * _t2_inv);
        return dest;
    }

    public static float[] ortho_zo(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.ortho_zo_lh(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar); }
            default -> { return Float4x4OpsKernelsArray.ortho_zo_rh(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar); }
        }
    }

    public static float[] ortho2D_no_lh(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top) {
        if (SimdSupport.VECTOR_API) return Float4x4OpsSimd.ortho2D_no_lh(dest, destOffset, src, srcOffset, left, right, bottom, top);
        return Float4x4OpsKernelsArray.ortho2D_no_lh_scalar(dest, destOffset, src, srcOffset, left, right, bottom, top);
    }

    public static float[] ortho2D_no_lh_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        float _t2 = left + right;
        float _t3 = bottom + top;
        dest[destOffset + 0] = 2.0f * _self00 * _t0_inv;
        dest[destOffset + 1] = 2.0f * _self10 * _t0_inv;
        dest[destOffset + 2] = 2.0f * _self20 * _t0_inv;
        dest[destOffset + 3] = 2.0f * _self30 * _t0_inv;
        dest[destOffset + 4] = 2.0f * _self01 * _t1_inv;
        dest[destOffset + 5] = 2.0f * _self11 * _t1_inv;
        dest[destOffset + 6] = 2.0f * _self21 * _t1_inv;
        dest[destOffset + 7] = 2.0f * _self31 * _t1_inv;
        dest[destOffset + 8] = _self02;
        dest[destOffset + 9] = _self12;
        dest[destOffset + 10] = _self22;
        dest[destOffset + 11] = _self32;
        dest[destOffset + 12] = _self03 + (-(_self00 * _t2 * _t0_inv) - _self01 * _t3 * _t1_inv);
        dest[destOffset + 13] = _self13 + (-(_self10 * _t2 * _t0_inv) - _self11 * _t3 * _t1_inv);
        dest[destOffset + 14] = _self23 + (-(_self20 * _t2 * _t0_inv) - _self21 * _t3 * _t1_inv);
        dest[destOffset + 15] = _self33 + (-(_self30 * _t2 * _t0_inv) - _self31 * _t3 * _t1_inv);
        return dest;
    }

    public static float[] ortho2D_no_rh(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top) {
        if (SimdSupport.VECTOR_API) return Float4x4OpsSimd.ortho2D_no_rh(dest, destOffset, src, srcOffset, left, right, bottom, top);
        return Float4x4OpsKernelsArray.ortho2D_no_rh_scalar(dest, destOffset, src, srcOffset, left, right, bottom, top);
    }

    public static float[] ortho2D_no_rh_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        float _t2 = left + right;
        float _t3 = bottom + top;
        dest[destOffset + 0] = 2.0f * _self00 * _t0_inv;
        dest[destOffset + 1] = 2.0f * _self10 * _t0_inv;
        dest[destOffset + 2] = 2.0f * _self20 * _t0_inv;
        dest[destOffset + 3] = 2.0f * _self30 * _t0_inv;
        dest[destOffset + 4] = 2.0f * _self01 * _t1_inv;
        dest[destOffset + 5] = 2.0f * _self11 * _t1_inv;
        dest[destOffset + 6] = 2.0f * _self21 * _t1_inv;
        dest[destOffset + 7] = 2.0f * _self31 * _t1_inv;
        dest[destOffset + 8] = -_self02;
        dest[destOffset + 9] = -_self12;
        dest[destOffset + 10] = -_self22;
        dest[destOffset + 11] = -_self32;
        dest[destOffset + 12] = _self03 + (-(_self00 * _t2 * _t0_inv) - _self01 * _t3 * _t1_inv);
        dest[destOffset + 13] = _self13 + (-(_self10 * _t2 * _t0_inv) - _self11 * _t3 * _t1_inv);
        dest[destOffset + 14] = _self23 + (-(_self20 * _t2 * _t0_inv) - _self21 * _t3 * _t1_inv);
        dest[destOffset + 15] = _self33 + (-(_self30 * _t2 * _t0_inv) - _self31 * _t3 * _t1_inv);
        return dest;
    }

    public static float[] ortho2D_no(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.ortho2D_no_lh(dest, destOffset, src, srcOffset, left, right, bottom, top); }
            default -> { return Float4x4OpsKernelsArray.ortho2D_no_rh(dest, destOffset, src, srcOffset, left, right, bottom, top); }
        }
    }

    public static float[] ortho2D_zo_lh(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top) {
        if (SimdSupport.VECTOR_API) return Float4x4OpsSimd.ortho2D_zo_lh(dest, destOffset, src, srcOffset, left, right, bottom, top);
        return Float4x4OpsKernelsArray.ortho2D_zo_lh_scalar(dest, destOffset, src, srcOffset, left, right, bottom, top);
    }

    public static float[] ortho2D_zo_lh_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        float _t2 = left + right;
        float _t3 = bottom + top;
        dest[destOffset + 0] = 2.0f * _self00 * _t0_inv;
        dest[destOffset + 1] = 2.0f * _self10 * _t0_inv;
        dest[destOffset + 2] = 2.0f * _self20 * _t0_inv;
        dest[destOffset + 3] = 2.0f * _self30 * _t0_inv;
        dest[destOffset + 4] = 2.0f * _self01 * _t1_inv;
        dest[destOffset + 5] = 2.0f * _self11 * _t1_inv;
        dest[destOffset + 6] = 2.0f * _self21 * _t1_inv;
        dest[destOffset + 7] = 2.0f * _self31 * _t1_inv;
        dest[destOffset + 8] = 0.5f * _self02;
        dest[destOffset + 9] = 0.5f * _self12;
        dest[destOffset + 10] = 0.5f * _self22;
        dest[destOffset + 11] = 0.5f * _self32;
        dest[destOffset + 12] = Math.fma(0.5f, _self02, _self03 - _self00 * _t2 * _t0_inv - _self01 * _t3 * _t1_inv);
        dest[destOffset + 13] = Math.fma(0.5f, _self12, _self13 - _self10 * _t2 * _t0_inv - _self11 * _t3 * _t1_inv);
        dest[destOffset + 14] = Math.fma(0.5f, _self22, _self23 - _self20 * _t2 * _t0_inv - _self21 * _t3 * _t1_inv);
        dest[destOffset + 15] = Math.fma(0.5f, _self32, _self33 - _self30 * _t2 * _t0_inv - _self31 * _t3 * _t1_inv);
        return dest;
    }

    public static float[] ortho2D_zo_rh(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top) {
        if (SimdSupport.VECTOR_API) return Float4x4OpsSimd.ortho2D_zo_rh(dest, destOffset, src, srcOffset, left, right, bottom, top);
        return Float4x4OpsKernelsArray.ortho2D_zo_rh_scalar(dest, destOffset, src, srcOffset, left, right, bottom, top);
    }

    public static float[] ortho2D_zo_rh_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        float _t2 = left + right;
        float _t3 = bottom + top;
        dest[destOffset + 0] = 2.0f * _self00 * _t0_inv;
        dest[destOffset + 1] = 2.0f * _self10 * _t0_inv;
        dest[destOffset + 2] = 2.0f * _self20 * _t0_inv;
        dest[destOffset + 3] = 2.0f * _self30 * _t0_inv;
        dest[destOffset + 4] = 2.0f * _self01 * _t1_inv;
        dest[destOffset + 5] = 2.0f * _self11 * _t1_inv;
        dest[destOffset + 6] = 2.0f * _self21 * _t1_inv;
        dest[destOffset + 7] = 2.0f * _self31 * _t1_inv;
        dest[destOffset + 8] = -0.5f * _self02;
        dest[destOffset + 9] = -0.5f * _self12;
        dest[destOffset + 10] = -0.5f * _self22;
        dest[destOffset + 11] = -0.5f * _self32;
        dest[destOffset + 12] = Math.fma(0.5f, _self02, _self03 - _self00 * _t2 * _t0_inv - _self01 * _t3 * _t1_inv);
        dest[destOffset + 13] = Math.fma(0.5f, _self12, _self13 - _self10 * _t2 * _t0_inv - _self11 * _t3 * _t1_inv);
        dest[destOffset + 14] = Math.fma(0.5f, _self22, _self23 - _self20 * _t2 * _t0_inv - _self21 * _t3 * _t1_inv);
        dest[destOffset + 15] = Math.fma(0.5f, _self32, _self33 - _self30 * _t2 * _t0_inv - _self31 * _t3 * _t1_inv);
        return dest;
    }

    public static float[] ortho2D_zo(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.ortho2D_zo_lh(dest, destOffset, src, srcOffset, left, right, bottom, top); }
            default -> { return Float4x4OpsKernelsArray.ortho2D_zo_rh(dest, destOffset, src, srcOffset, left, right, bottom, top); }
        }
    }

    public static float[] orthoCrop_no_lh(float[] dest, int destOffset, float[] src, int srcOffset, float[] view, int viewOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _view00 = view[viewOffset + 0];
        float _view10 = view[viewOffset + 1];
        float _view20 = view[viewOffset + 2];
        float _view01 = view[viewOffset + 4];
        float _view11 = view[viewOffset + 5];
        float _view21 = view[viewOffset + 6];
        float _view02 = view[viewOffset + 8];
        float _view12 = view[viewOffset + 9];
        float _view22 = view[viewOffset + 10];
        float _view03 = view[viewOffset + 12];
        float _view13 = view[viewOffset + 13];
        float _view23 = view[viewOffset + 14];
        float _t4 = _self20 - _self21;
        float _t5 = _self00 - _self01;
        float _t6 = _self10 - _self11;
        float _t7 = _self30 - _self31;
        float _t8 = _self21 - _self20;
        float _t9 = _self01 - _self00;
        float _t10 = _self11 - _self10;
        float _t11 = _self31 - _self30;
        float _t12 = _self20 + _self21;
        float _t13 = _self00 + _self01;
        float _t14 = _self10 + _self11;
        float _t15 = _self30 + _self31;
        float _t16 = -_self20 - _self21;
        float _t17 = -_self00 - _self01;
        float _t18 = -_self10 - _self11;
        float _t19 = -_self30 - _self31;
        float _t52 = _self23 + (_t4 - _self22);
        float _t53 = _self03 + (_t5 - _self02);
        float _t54 = _self13 + (_t6 - _self12);
        float _t55 = _self33 + (_t7 - _self32);
        float _t55_inv = 1.0f / _t55;
        float _t56 = _self23 + (_t8 - _self22);
        float _t57 = _self03 + (_t9 - _self02);
        float _t58 = _self13 + (_t10 - _self12);
        float _t59 = _self33 + (_t11 - _self32);
        float _t59_inv = 1.0f / _t59;
        float _t60 = _self23 + (_t12 - _self22);
        float _t61 = _self03 + (_t13 - _self02);
        float _t62 = _self13 + (_t14 - _self12);
        float _t63 = _self33 + (_t15 - _self32);
        float _t63_inv = 1.0f / _t63;
        float _t64 = _self23 + (_self22 + _t4);
        float _t65 = _self03 + (_self02 + _t5);
        float _t66 = _self13 + (_self12 + _t6);
        float _t67 = _self33 + (_self32 + _t7);
        float _t67_inv = 1.0f / _t67;
        float _t68 = _self23 + (_self22 + _t8);
        float _t69 = _self03 + (_self02 + _t9);
        float _t70 = _self13 + (_self12 + _t10);
        float _t71 = _self33 + (_self32 + _t11);
        float _t71_inv = 1.0f / _t71;
        float _t72 = _self23 + (_self22 + _t12);
        float _t73 = _self03 + (_self02 + _t13);
        float _t74 = _self13 + (_self12 + _t14);
        float _t75 = _self33 + (_self32 + _t15);
        float _t75_inv = 1.0f / _t75;
        float _t76 = _self23 + (_t16 - _self22);
        float _t77 = _self03 + (_t17 - _self02);
        float _t78 = _self13 + (_t18 - _self12);
        float _t79 = _self33 + (_t19 - _self32);
        float _t79_inv = 1.0f / _t79;
        float _t80 = _self23 + (_self22 + _t16);
        float _t81 = _self03 + (_self02 + _t17);
        float _t82 = _self13 + (_self12 + _t18);
        float _t83 = _self33 + (_self32 + _t19);
        float _t83_inv = 1.0f / _t83;
        float _t174 = _view03 + Math.fma(_view02, _t52, Math.fma(_view00, _t53, _view01 * _t54)) * _t55_inv;
        float _t175 = _view03 + Math.fma(_view02, _t56, Math.fma(_view00, _t57, _view01 * _t58)) * _t59_inv;
        float _t176 = _view03 + Math.fma(_view02, _t60, Math.fma(_view00, _t61, _view01 * _t62)) * _t63_inv;
        float _t177 = _view03 + Math.fma(_view02, _t64, Math.fma(_view00, _t65, _view01 * _t66)) * _t67_inv;
        float _t178 = _view03 + Math.fma(_view02, _t68, Math.fma(_view00, _t69, _view01 * _t70)) * _t71_inv;
        float _t179 = _view03 + Math.fma(_view02, _t72, Math.fma(_view00, _t73, _view01 * _t74)) * _t75_inv;
        float _t180 = _view13 + Math.fma(_view12, _t52, Math.fma(_view10, _t53, _view11 * _t54)) * _t55_inv;
        float _t181 = _view13 + Math.fma(_view12, _t56, Math.fma(_view10, _t57, _view11 * _t58)) * _t59_inv;
        float _t182 = _view13 + Math.fma(_view12, _t60, Math.fma(_view10, _t61, _view11 * _t62)) * _t63_inv;
        float _t183 = _view13 + Math.fma(_view12, _t64, Math.fma(_view10, _t65, _view11 * _t66)) * _t67_inv;
        float _t184 = _view13 + Math.fma(_view12, _t68, Math.fma(_view10, _t69, _view11 * _t70)) * _t71_inv;
        float _t185 = _view13 + Math.fma(_view12, _t72, Math.fma(_view10, _t73, _view11 * _t74)) * _t75_inv;
        float _t186 = _view23 + Math.fma(_view22, _t52, Math.fma(_view20, _t53, _view21 * _t54)) * _t55_inv;
        float _t187 = _view23 + Math.fma(_view22, _t56, Math.fma(_view20, _t57, _view21 * _t58)) * _t59_inv;
        float _t188 = _view23 + Math.fma(_view22, _t60, Math.fma(_view20, _t61, _view21 * _t62)) * _t63_inv;
        float _t189 = _view23 + Math.fma(_view22, _t64, Math.fma(_view20, _t65, _view21 * _t66)) * _t67_inv;
        float _t190 = _view23 + Math.fma(_view22, _t68, Math.fma(_view20, _t69, _view21 * _t70)) * _t71_inv;
        float _t191 = _view23 + Math.fma(_view22, _t72, Math.fma(_view20, _t73, _view21 * _t74)) * _t75_inv;
        float _t198 = _view03 + Math.fma(_view02, _t76, Math.fma(_view00, _t77, _view01 * _t78)) * _t79_inv;
        float _t199 = _view03 + Math.fma(_view02, _t80, Math.fma(_view00, _t81, _view01 * _t82)) * _t83_inv;
        float _t200 = _view13 + Math.fma(_view12, _t76, Math.fma(_view10, _t77, _view11 * _t78)) * _t79_inv;
        float _t201 = _view13 + Math.fma(_view12, _t80, Math.fma(_view10, _t81, _view11 * _t82)) * _t83_inv;
        float _t202 = _view23 + Math.fma(_view22, _t76, Math.fma(_view20, _t77, _view21 * _t78)) * _t79_inv;
        float _t203 = _view23 + Math.fma(_view22, _t80, Math.fma(_view20, _t81, _view21 * _t82)) * _t83_inv;
        float _t240 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t198, _t174), _t175), _t176), _t199), _t177), _t178), _t179);
        float _t241 = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t198, _t174), _t175), _t176), _t199), _t177), _t178), _t179);
        float _t242 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t200, _t180), _t181), _t182), _t201), _t183), _t184), _t185);
        float _t243 = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t200, _t180), _t181), _t182), _t201), _t183), _t184), _t185);
        float _t244 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t202, _t186), _t187), _t188), _t203), _t189), _t190), _t191);
        float _t245 = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t202, _t186), _t187), _t188), _t203), _t189), _t190), _t191);
        float _t246 = _t240 - _t241;
        float _t246_inv = 1.0f / _t246;
        float _t247 = _t242 - _t243;
        float _t247_inv = 1.0f / _t247;
        float _t248 = _t244 - _t245;
        float _t248_inv = 1.0f / _t248;
        dest[destOffset + 0] = 2.0f * _t246_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t247_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = 0.0f;
        dest[destOffset + 10] = 2.0f * _t248_inv;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -((_t241 + _t240) * _t246_inv);
        dest[destOffset + 13] = -((_t243 + _t242) * _t247_inv);
        dest[destOffset + 14] = -((_t245 + _t244) * _t248_inv);
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] orthoCrop_no_rh(float[] dest, int destOffset, float[] src, int srcOffset, float[] view, int viewOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _view00 = view[viewOffset + 0];
        float _view10 = view[viewOffset + 1];
        float _view20 = view[viewOffset + 2];
        float _view01 = view[viewOffset + 4];
        float _view11 = view[viewOffset + 5];
        float _view21 = view[viewOffset + 6];
        float _view02 = view[viewOffset + 8];
        float _view12 = view[viewOffset + 9];
        float _view22 = view[viewOffset + 10];
        float _view03 = view[viewOffset + 12];
        float _view13 = view[viewOffset + 13];
        float _view23 = view[viewOffset + 14];
        float _t4 = _self20 - _self21;
        float _t5 = _self00 - _self01;
        float _t6 = _self10 - _self11;
        float _t7 = _self30 - _self31;
        float _t8 = _self21 - _self20;
        float _t9 = _self01 - _self00;
        float _t10 = _self11 - _self10;
        float _t11 = _self31 - _self30;
        float _t12 = _self20 + _self21;
        float _t13 = _self00 + _self01;
        float _t14 = _self10 + _self11;
        float _t15 = _self30 + _self31;
        float _t16 = -_self20 - _self21;
        float _t17 = -_self00 - _self01;
        float _t18 = -_self10 - _self11;
        float _t19 = -_self30 - _self31;
        float _t52 = _self23 + (_t4 - _self22);
        float _t53 = _self03 + (_t5 - _self02);
        float _t54 = _self13 + (_t6 - _self12);
        float _t55 = _self33 + (_t7 - _self32);
        float _t55_inv = 1.0f / _t55;
        float _t56 = _self23 + (_t8 - _self22);
        float _t57 = _self03 + (_t9 - _self02);
        float _t58 = _self13 + (_t10 - _self12);
        float _t59 = _self33 + (_t11 - _self32);
        float _t59_inv = 1.0f / _t59;
        float _t60 = _self23 + (_t12 - _self22);
        float _t61 = _self03 + (_t13 - _self02);
        float _t62 = _self13 + (_t14 - _self12);
        float _t63 = _self33 + (_t15 - _self32);
        float _t63_inv = 1.0f / _t63;
        float _t64 = _self23 + (_self22 + _t4);
        float _t65 = _self03 + (_self02 + _t5);
        float _t66 = _self13 + (_self12 + _t6);
        float _t67 = _self33 + (_self32 + _t7);
        float _t67_inv = 1.0f / _t67;
        float _t68 = _self23 + (_self22 + _t8);
        float _t69 = _self03 + (_self02 + _t9);
        float _t70 = _self13 + (_self12 + _t10);
        float _t71 = _self33 + (_self32 + _t11);
        float _t71_inv = 1.0f / _t71;
        float _t72 = _self23 + (_self22 + _t12);
        float _t73 = _self03 + (_self02 + _t13);
        float _t74 = _self13 + (_self12 + _t14);
        float _t75 = _self33 + (_self32 + _t15);
        float _t75_inv = 1.0f / _t75;
        float _t76 = _self23 + (_t16 - _self22);
        float _t77 = _self03 + (_t17 - _self02);
        float _t78 = _self13 + (_t18 - _self12);
        float _t79 = _self33 + (_t19 - _self32);
        float _t79_inv = 1.0f / _t79;
        float _t80 = _self23 + (_self22 + _t16);
        float _t81 = _self03 + (_self02 + _t17);
        float _t82 = _self13 + (_self12 + _t18);
        float _t83 = _self33 + (_self32 + _t19);
        float _t83_inv = 1.0f / _t83;
        float _t174 = _view03 + Math.fma(_view02, _t52, Math.fma(_view00, _t53, _view01 * _t54)) * _t55_inv;
        float _t175 = _view03 + Math.fma(_view02, _t56, Math.fma(_view00, _t57, _view01 * _t58)) * _t59_inv;
        float _t176 = _view03 + Math.fma(_view02, _t60, Math.fma(_view00, _t61, _view01 * _t62)) * _t63_inv;
        float _t177 = _view03 + Math.fma(_view02, _t64, Math.fma(_view00, _t65, _view01 * _t66)) * _t67_inv;
        float _t178 = _view03 + Math.fma(_view02, _t68, Math.fma(_view00, _t69, _view01 * _t70)) * _t71_inv;
        float _t179 = _view03 + Math.fma(_view02, _t72, Math.fma(_view00, _t73, _view01 * _t74)) * _t75_inv;
        float _t180 = _view13 + Math.fma(_view12, _t52, Math.fma(_view10, _t53, _view11 * _t54)) * _t55_inv;
        float _t181 = _view13 + Math.fma(_view12, _t56, Math.fma(_view10, _t57, _view11 * _t58)) * _t59_inv;
        float _t182 = _view13 + Math.fma(_view12, _t60, Math.fma(_view10, _t61, _view11 * _t62)) * _t63_inv;
        float _t183 = _view13 + Math.fma(_view12, _t64, Math.fma(_view10, _t65, _view11 * _t66)) * _t67_inv;
        float _t184 = _view13 + Math.fma(_view12, _t68, Math.fma(_view10, _t69, _view11 * _t70)) * _t71_inv;
        float _t185 = _view13 + Math.fma(_view12, _t72, Math.fma(_view10, _t73, _view11 * _t74)) * _t75_inv;
        float _t186 = _view23 + Math.fma(_view22, _t52, Math.fma(_view20, _t53, _view21 * _t54)) * _t55_inv;
        float _t187 = _view23 + Math.fma(_view22, _t56, Math.fma(_view20, _t57, _view21 * _t58)) * _t59_inv;
        float _t188 = _view23 + Math.fma(_view22, _t60, Math.fma(_view20, _t61, _view21 * _t62)) * _t63_inv;
        float _t189 = _view23 + Math.fma(_view22, _t64, Math.fma(_view20, _t65, _view21 * _t66)) * _t67_inv;
        float _t190 = _view23 + Math.fma(_view22, _t68, Math.fma(_view20, _t69, _view21 * _t70)) * _t71_inv;
        float _t191 = _view23 + Math.fma(_view22, _t72, Math.fma(_view20, _t73, _view21 * _t74)) * _t75_inv;
        float _t198 = _view03 + Math.fma(_view02, _t76, Math.fma(_view00, _t77, _view01 * _t78)) * _t79_inv;
        float _t199 = _view03 + Math.fma(_view02, _t80, Math.fma(_view00, _t81, _view01 * _t82)) * _t83_inv;
        float _t200 = _view13 + Math.fma(_view12, _t76, Math.fma(_view10, _t77, _view11 * _t78)) * _t79_inv;
        float _t201 = _view13 + Math.fma(_view12, _t80, Math.fma(_view10, _t81, _view11 * _t82)) * _t83_inv;
        float _t202 = _view23 + Math.fma(_view22, _t76, Math.fma(_view20, _t77, _view21 * _t78)) * _t79_inv;
        float _t203 = _view23 + Math.fma(_view22, _t80, Math.fma(_view20, _t81, _view21 * _t82)) * _t83_inv;
        float _t240 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t198, _t174), _t175), _t176), _t199), _t177), _t178), _t179);
        float _t241 = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t198, _t174), _t175), _t176), _t199), _t177), _t178), _t179);
        float _t242 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t200, _t180), _t181), _t182), _t201), _t183), _t184), _t185);
        float _t243 = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t200, _t180), _t181), _t182), _t201), _t183), _t184), _t185);
        float _t244 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t202, _t186), _t187), _t188), _t203), _t189), _t190), _t191);
        float _t245 = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t202, _t186), _t187), _t188), _t203), _t189), _t190), _t191);
        float _t246 = _t240 - _t241;
        float _t246_inv = 1.0f / _t246;
        float _t247 = _t242 - _t243;
        float _t247_inv = 1.0f / _t247;
        float _t248 = _t244 - _t245;
        float _t248_inv = 1.0f / _t248;
        dest[destOffset + 0] = 2.0f * _t246_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t247_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = 0.0f;
        dest[destOffset + 10] = -2.0f * _t248_inv;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -((_t241 + _t240) * _t246_inv);
        dest[destOffset + 13] = -((_t243 + _t242) * _t247_inv);
        dest[destOffset + 14] = -((-_t245 - _t244) * _t248_inv);
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] orthoCrop_no(float[] dest, int destOffset, float[] src, int srcOffset, float[] view, int viewOffset, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.orthoCrop_no_lh(dest, destOffset, src, srcOffset, view, viewOffset); }
            default -> { return Float4x4OpsKernelsArray.orthoCrop_no_rh(dest, destOffset, src, srcOffset, view, viewOffset); }
        }
    }

    public static float[] orthoCrop_zo_lh(float[] dest, int destOffset, float[] src, int srcOffset, float[] view, int viewOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _view00 = view[viewOffset + 0];
        float _view10 = view[viewOffset + 1];
        float _view20 = view[viewOffset + 2];
        float _view01 = view[viewOffset + 4];
        float _view11 = view[viewOffset + 5];
        float _view21 = view[viewOffset + 6];
        float _view02 = view[viewOffset + 8];
        float _view12 = view[viewOffset + 9];
        float _view22 = view[viewOffset + 10];
        float _view03 = view[viewOffset + 12];
        float _view13 = view[viewOffset + 13];
        float _view23 = view[viewOffset + 14];
        float _t4 = _self20 - _self21;
        float _t5 = _self00 - _self01;
        float _t6 = _self10 - _self11;
        float _t7 = _self30 - _self31;
        float _t8 = _self21 - _self20;
        float _t9 = _self01 - _self00;
        float _t10 = _self11 - _self10;
        float _t11 = _self31 - _self30;
        float _t12 = _self20 + _self21;
        float _t13 = _self00 + _self01;
        float _t14 = _self10 + _self11;
        float _t15 = _self30 + _self31;
        float _t16 = -_self20 - _self21;
        float _t17 = -_self00 - _self01;
        float _t18 = -_self10 - _self11;
        float _t19 = -_self30 - _self31;
        float _t20 = _self23 + _t4;
        float _t21 = _self03 + _t5;
        float _t22 = _self13 + _t6;
        float _t23 = _self33 + _t7;
        float _t23_inv = 1.0f / _t23;
        float _t24 = _self23 + _t8;
        float _t25 = _self03 + _t9;
        float _t26 = _self13 + _t10;
        float _t27 = _self33 + _t11;
        float _t27_inv = 1.0f / _t27;
        float _t28 = _self23 + _t12;
        float _t29 = _self03 + _t13;
        float _t30 = _self13 + _t14;
        float _t31 = _self33 + _t15;
        float _t31_inv = 1.0f / _t31;
        float _t44 = _self23 + _t16;
        float _t45 = _self03 + _t17;
        float _t46 = _self13 + _t18;
        float _t47 = _self33 + _t19;
        float _t47_inv = 1.0f / _t47;
        float _t55 = _self23 + (_self22 + _t4);
        float _t56 = _self03 + (_self02 + _t5);
        float _t57 = _self13 + (_self12 + _t6);
        float _t58 = _self33 + (_self32 + _t7);
        float _t58_inv = 1.0f / _t58;
        float _t59 = _self23 + (_self22 + _t8);
        float _t60 = _self03 + (_self02 + _t9);
        float _t61 = _self13 + (_self12 + _t10);
        float _t62 = _self33 + (_self32 + _t11);
        float _t62_inv = 1.0f / _t62;
        float _t63 = _self23 + (_self22 + _t12);
        float _t64 = _self03 + (_self02 + _t13);
        float _t65 = _self13 + (_self12 + _t14);
        float _t66 = _self33 + (_self32 + _t15);
        float _t66_inv = 1.0f / _t66;
        float _t74 = _self23 + (_self22 + _t16);
        float _t75 = _self03 + (_self02 + _t17);
        float _t76 = _self13 + (_self12 + _t18);
        float _t77 = _self33 + (_self32 + _t19);
        float _t77_inv = 1.0f / _t77;
        float _t146 = _view03 + Math.fma(_view02, _t20, Math.fma(_view00, _t21, _view01 * _t22)) * _t23_inv;
        float _t147 = _view03 + Math.fma(_view02, _t24, Math.fma(_view00, _t25, _view01 * _t26)) * _t27_inv;
        float _t148 = _view03 + Math.fma(_view02, _t28, Math.fma(_view00, _t29, _view01 * _t30)) * _t31_inv;
        float _t150 = _view13 + Math.fma(_view12, _t20, Math.fma(_view10, _t21, _view11 * _t22)) * _t23_inv;
        float _t151 = _view13 + Math.fma(_view12, _t24, Math.fma(_view10, _t25, _view11 * _t26)) * _t27_inv;
        float _t152 = _view13 + Math.fma(_view12, _t28, Math.fma(_view10, _t29, _view11 * _t30)) * _t31_inv;
        float _t154 = _view23 + Math.fma(_view22, _t20, Math.fma(_view20, _t21, _view21 * _t22)) * _t23_inv;
        float _t155 = _view23 + Math.fma(_view22, _t24, Math.fma(_view20, _t25, _view21 * _t26)) * _t27_inv;
        float _t156 = _view23 + Math.fma(_view22, _t28, Math.fma(_view20, _t29, _view21 * _t30)) * _t31_inv;
        float _t161 = _view03 + Math.fma(_view02, _t44, Math.fma(_view00, _t45, _view01 * _t46)) * _t47_inv;
        float _t162 = _view13 + Math.fma(_view12, _t44, Math.fma(_view10, _t45, _view11 * _t46)) * _t47_inv;
        float _t163 = _view23 + Math.fma(_view22, _t44, Math.fma(_view20, _t45, _view21 * _t46)) * _t47_inv;
        float _t173 = _view03 + Math.fma(_view02, _t55, Math.fma(_view00, _t56, _view01 * _t57)) * _t58_inv;
        float _t174 = _view03 + Math.fma(_view02, _t59, Math.fma(_view00, _t60, _view01 * _t61)) * _t62_inv;
        float _t175 = _view03 + Math.fma(_view02, _t63, Math.fma(_view00, _t64, _view01 * _t65)) * _t66_inv;
        float _t176 = _view13 + Math.fma(_view12, _t55, Math.fma(_view10, _t56, _view11 * _t57)) * _t58_inv;
        float _t177 = _view13 + Math.fma(_view12, _t59, Math.fma(_view10, _t60, _view11 * _t61)) * _t62_inv;
        float _t178 = _view13 + Math.fma(_view12, _t63, Math.fma(_view10, _t64, _view11 * _t65)) * _t66_inv;
        float _t179 = _view23 + Math.fma(_view22, _t55, Math.fma(_view20, _t56, _view21 * _t57)) * _t58_inv;
        float _t180 = _view23 + Math.fma(_view22, _t59, Math.fma(_view20, _t60, _view21 * _t61)) * _t62_inv;
        float _t181 = _view23 + Math.fma(_view22, _t63, Math.fma(_view20, _t64, _view21 * _t65)) * _t66_inv;
        float _t185 = _view03 + Math.fma(_view02, _t74, Math.fma(_view00, _t75, _view01 * _t76)) * _t77_inv;
        float _t186 = _view13 + Math.fma(_view12, _t74, Math.fma(_view10, _t75, _view11 * _t76)) * _t77_inv;
        float _t187 = _view23 + Math.fma(_view22, _t74, Math.fma(_view20, _t75, _view21 * _t76)) * _t77_inv;
        float _t224 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t161, _t146), _t147), _t148), _t185), _t173), _t174), _t175);
        float _t225 = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t161, _t146), _t147), _t148), _t185), _t173), _t174), _t175);
        float _t226 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t162, _t150), _t151), _t152), _t186), _t176), _t177), _t178);
        float _t227 = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t162, _t150), _t151), _t152), _t186), _t176), _t177), _t178);
        float _t229 = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t163, _t154), _t155), _t156), _t187), _t179), _t180), _t181);
        float _t230 = _t224 - _t225;
        float _t230_inv = 1.0f / _t230;
        float _t231 = _t226 - _t227;
        float _t231_inv = 1.0f / _t231;
        float _t232 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t163, _t154), _t155), _t156), _t187), _t179), _t180), _t181) - _t229;
        float _t232_inv = 1.0f / _t232;
        dest[destOffset + 0] = 2.0f * _t230_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t231_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = 0.0f;
        dest[destOffset + 10] = 1.0f * _t232_inv;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -((_t225 + _t224) * _t230_inv);
        dest[destOffset + 13] = -((_t227 + _t226) * _t231_inv);
        dest[destOffset + 14] = -(_t229 * _t232_inv);
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] orthoCrop_zo_rh(float[] dest, int destOffset, float[] src, int srcOffset, float[] view, int viewOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _view00 = view[viewOffset + 0];
        float _view10 = view[viewOffset + 1];
        float _view20 = view[viewOffset + 2];
        float _view01 = view[viewOffset + 4];
        float _view11 = view[viewOffset + 5];
        float _view21 = view[viewOffset + 6];
        float _view02 = view[viewOffset + 8];
        float _view12 = view[viewOffset + 9];
        float _view22 = view[viewOffset + 10];
        float _view03 = view[viewOffset + 12];
        float _view13 = view[viewOffset + 13];
        float _view23 = view[viewOffset + 14];
        float _t4 = _self20 - _self21;
        float _t5 = _self00 - _self01;
        float _t6 = _self10 - _self11;
        float _t7 = _self30 - _self31;
        float _t8 = _self21 - _self20;
        float _t9 = _self01 - _self00;
        float _t10 = _self11 - _self10;
        float _t11 = _self31 - _self30;
        float _t12 = _self20 + _self21;
        float _t13 = _self00 + _self01;
        float _t14 = _self10 + _self11;
        float _t15 = _self30 + _self31;
        float _t16 = -_self20 - _self21;
        float _t17 = -_self00 - _self01;
        float _t18 = -_self10 - _self11;
        float _t19 = -_self30 - _self31;
        float _t20 = _self23 + _t4;
        float _t21 = _self03 + _t5;
        float _t22 = _self13 + _t6;
        float _t23 = _self33 + _t7;
        float _t23_inv = 1.0f / _t23;
        float _t24 = _self23 + _t8;
        float _t25 = _self03 + _t9;
        float _t26 = _self13 + _t10;
        float _t27 = _self33 + _t11;
        float _t27_inv = 1.0f / _t27;
        float _t28 = _self23 + _t12;
        float _t29 = _self03 + _t13;
        float _t30 = _self13 + _t14;
        float _t31 = _self33 + _t15;
        float _t31_inv = 1.0f / _t31;
        float _t44 = _self23 + _t16;
        float _t45 = _self03 + _t17;
        float _t46 = _self13 + _t18;
        float _t47 = _self33 + _t19;
        float _t47_inv = 1.0f / _t47;
        float _t55 = _self23 + (_self22 + _t4);
        float _t56 = _self03 + (_self02 + _t5);
        float _t57 = _self13 + (_self12 + _t6);
        float _t58 = _self33 + (_self32 + _t7);
        float _t58_inv = 1.0f / _t58;
        float _t59 = _self23 + (_self22 + _t8);
        float _t60 = _self03 + (_self02 + _t9);
        float _t61 = _self13 + (_self12 + _t10);
        float _t62 = _self33 + (_self32 + _t11);
        float _t62_inv = 1.0f / _t62;
        float _t63 = _self23 + (_self22 + _t12);
        float _t64 = _self03 + (_self02 + _t13);
        float _t65 = _self13 + (_self12 + _t14);
        float _t66 = _self33 + (_self32 + _t15);
        float _t66_inv = 1.0f / _t66;
        float _t74 = _self23 + (_self22 + _t16);
        float _t75 = _self03 + (_self02 + _t17);
        float _t76 = _self13 + (_self12 + _t18);
        float _t77 = _self33 + (_self32 + _t19);
        float _t77_inv = 1.0f / _t77;
        float _t146 = _view03 + Math.fma(_view02, _t20, Math.fma(_view00, _t21, _view01 * _t22)) * _t23_inv;
        float _t147 = _view03 + Math.fma(_view02, _t24, Math.fma(_view00, _t25, _view01 * _t26)) * _t27_inv;
        float _t148 = _view03 + Math.fma(_view02, _t28, Math.fma(_view00, _t29, _view01 * _t30)) * _t31_inv;
        float _t150 = _view13 + Math.fma(_view12, _t20, Math.fma(_view10, _t21, _view11 * _t22)) * _t23_inv;
        float _t151 = _view13 + Math.fma(_view12, _t24, Math.fma(_view10, _t25, _view11 * _t26)) * _t27_inv;
        float _t152 = _view13 + Math.fma(_view12, _t28, Math.fma(_view10, _t29, _view11 * _t30)) * _t31_inv;
        float _t154 = _view23 + Math.fma(_view22, _t20, Math.fma(_view20, _t21, _view21 * _t22)) * _t23_inv;
        float _t155 = _view23 + Math.fma(_view22, _t24, Math.fma(_view20, _t25, _view21 * _t26)) * _t27_inv;
        float _t156 = _view23 + Math.fma(_view22, _t28, Math.fma(_view20, _t29, _view21 * _t30)) * _t31_inv;
        float _t161 = _view03 + Math.fma(_view02, _t44, Math.fma(_view00, _t45, _view01 * _t46)) * _t47_inv;
        float _t162 = _view13 + Math.fma(_view12, _t44, Math.fma(_view10, _t45, _view11 * _t46)) * _t47_inv;
        float _t163 = _view23 + Math.fma(_view22, _t44, Math.fma(_view20, _t45, _view21 * _t46)) * _t47_inv;
        float _t173 = _view03 + Math.fma(_view02, _t55, Math.fma(_view00, _t56, _view01 * _t57)) * _t58_inv;
        float _t174 = _view03 + Math.fma(_view02, _t59, Math.fma(_view00, _t60, _view01 * _t61)) * _t62_inv;
        float _t175 = _view03 + Math.fma(_view02, _t63, Math.fma(_view00, _t64, _view01 * _t65)) * _t66_inv;
        float _t176 = _view13 + Math.fma(_view12, _t55, Math.fma(_view10, _t56, _view11 * _t57)) * _t58_inv;
        float _t177 = _view13 + Math.fma(_view12, _t59, Math.fma(_view10, _t60, _view11 * _t61)) * _t62_inv;
        float _t178 = _view13 + Math.fma(_view12, _t63, Math.fma(_view10, _t64, _view11 * _t65)) * _t66_inv;
        float _t179 = _view23 + Math.fma(_view22, _t55, Math.fma(_view20, _t56, _view21 * _t57)) * _t58_inv;
        float _t180 = _view23 + Math.fma(_view22, _t59, Math.fma(_view20, _t60, _view21 * _t61)) * _t62_inv;
        float _t181 = _view23 + Math.fma(_view22, _t63, Math.fma(_view20, _t64, _view21 * _t65)) * _t66_inv;
        float _t185 = _view03 + Math.fma(_view02, _t74, Math.fma(_view00, _t75, _view01 * _t76)) * _t77_inv;
        float _t186 = _view13 + Math.fma(_view12, _t74, Math.fma(_view10, _t75, _view11 * _t76)) * _t77_inv;
        float _t187 = _view23 + Math.fma(_view22, _t74, Math.fma(_view20, _t75, _view21 * _t76)) * _t77_inv;
        float _t224 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t161, _t146), _t147), _t148), _t185), _t173), _t174), _t175);
        float _t225 = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t161, _t146), _t147), _t148), _t185), _t173), _t174), _t175);
        float _t226 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t162, _t150), _t151), _t152), _t186), _t176), _t177), _t178);
        float _t227 = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t162, _t150), _t151), _t152), _t186), _t176), _t177), _t178);
        float _t228 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t163, _t154), _t155), _t156), _t187), _t179), _t180), _t181);
        float _t230 = _t224 - _t225;
        float _t230_inv = 1.0f / _t230;
        float _t231 = _t226 - _t227;
        float _t231_inv = 1.0f / _t231;
        float _t232 = _t228 - Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t163, _t154), _t155), _t156), _t187), _t179), _t180), _t181);
        float _t232_inv = 1.0f / _t232;
        dest[destOffset + 0] = 2.0f * _t230_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t231_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = 0.0f;
        dest[destOffset + 10] = -1.0f * _t232_inv;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -((_t225 + _t224) * _t230_inv);
        dest[destOffset + 13] = -((_t227 + _t226) * _t231_inv);
        dest[destOffset + 14] = _t228 * _t232_inv;
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] orthoCrop_zo(float[] dest, int destOffset, float[] src, int srcOffset, float[] view, int viewOffset, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.orthoCrop_zo_lh(dest, destOffset, src, srcOffset, view, viewOffset); }
            default -> { return Float4x4OpsKernelsArray.orthoCrop_zo_rh(dest, destOffset, src, srcOffset, view, viewOffset); }
        }
    }

    public static float[] orthoCrop_no_lh(float[] dest, int destOffset, float[] src, int srcOffset, float[] view, int viewOffset, float minZ, float maxZ) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _view00 = view[viewOffset + 0];
        float _view10 = view[viewOffset + 1];
        float _view20 = view[viewOffset + 2];
        float _view01 = view[viewOffset + 4];
        float _view11 = view[viewOffset + 5];
        float _view21 = view[viewOffset + 6];
        float _view02 = view[viewOffset + 8];
        float _view12 = view[viewOffset + 9];
        float _view22 = view[viewOffset + 10];
        float _view03 = view[viewOffset + 12];
        float _view13 = view[viewOffset + 13];
        float _view23 = view[viewOffset + 14];
        float _t4 = _self23 + _self20;
        float _t5 = _self03 + _self00;
        float _t6 = _self13 + _self10;
        float _t7 = _self33 + _self30;
        float _t12 = _self23 - _self20 - _self21;
        float _t13 = _self03 - _self00 - _self01;
        float _t14 = _self13 - _self10 - _self11;
        float _t15 = _self33 - _self30 - _self31;
        float _t16 = _t4 - _self21;
        float _t17 = _t5 - _self01;
        float _t18 = _t6 - _self11;
        float _t19 = _t7 - _self31;
        float _t20 = _self23 + _self21 - _self20;
        float _t21 = _self03 + _self01 - _self00;
        float _t22 = _self13 + _self11 - _self10;
        float _t23 = _self33 + _self31 - _self30;
        float _t24 = _t4 + _self21;
        float _t25 = _t5 + _self01;
        float _t26 = _t6 + _self11;
        float _t27 = _t7 + _self31;
        float _t28 = Math.fma(minZ, _self22, _t12);
        float _t29 = Math.fma(minZ, _self02, _t13);
        float _t30 = Math.fma(minZ, _self12, _t14);
        float _t31 = Math.fma(minZ, _self32, _t15);
        float _t31_inv = 1.0f / _t31;
        float _t32 = Math.fma(minZ, _self22, _t16);
        float _t33 = Math.fma(minZ, _self02, _t17);
        float _t34 = Math.fma(minZ, _self12, _t18);
        float _t35 = Math.fma(minZ, _self32, _t19);
        float _t35_inv = 1.0f / _t35;
        float _t36 = Math.fma(minZ, _self22, _t20);
        float _t37 = Math.fma(minZ, _self02, _t21);
        float _t38 = Math.fma(minZ, _self12, _t22);
        float _t39 = Math.fma(minZ, _self32, _t23);
        float _t39_inv = 1.0f / _t39;
        float _t40 = Math.fma(minZ, _self22, _t24);
        float _t41 = Math.fma(minZ, _self02, _t25);
        float _t42 = Math.fma(minZ, _self12, _t26);
        float _t43 = Math.fma(minZ, _self32, _t27);
        float _t43_inv = 1.0f / _t43;
        float _t44 = Math.fma(maxZ, _self22, _t12);
        float _t45 = Math.fma(maxZ, _self02, _t13);
        float _t46 = Math.fma(maxZ, _self12, _t14);
        float _t47 = Math.fma(maxZ, _self32, _t15);
        float _t47_inv = 1.0f / _t47;
        float _t48 = Math.fma(maxZ, _self22, _t16);
        float _t49 = Math.fma(maxZ, _self02, _t17);
        float _t50 = Math.fma(maxZ, _self12, _t18);
        float _t51 = Math.fma(maxZ, _self32, _t19);
        float _t51_inv = 1.0f / _t51;
        float _t52 = Math.fma(maxZ, _self22, _t20);
        float _t53 = Math.fma(maxZ, _self02, _t21);
        float _t54 = Math.fma(maxZ, _self12, _t22);
        float _t55 = Math.fma(maxZ, _self32, _t23);
        float _t55_inv = 1.0f / _t55;
        float _t56 = Math.fma(maxZ, _self22, _t24);
        float _t57 = Math.fma(maxZ, _self02, _t25);
        float _t58 = Math.fma(maxZ, _self12, _t26);
        float _t59 = Math.fma(maxZ, _self32, _t27);
        float _t59_inv = 1.0f / _t59;
        float _t156 = _view03 + Math.fma(_view02, _t28, Math.fma(_view00, _t29, _view01 * _t30)) * _t31_inv;
        float _t157 = _view03 + Math.fma(_view02, _t32, Math.fma(_view00, _t33, _view01 * _t34)) * _t35_inv;
        float _t158 = _view03 + Math.fma(_view02, _t36, Math.fma(_view00, _t37, _view01 * _t38)) * _t39_inv;
        float _t159 = _view03 + Math.fma(_view02, _t40, Math.fma(_view00, _t41, _view01 * _t42)) * _t43_inv;
        float _t160 = _view03 + Math.fma(_view02, _t44, Math.fma(_view00, _t45, _view01 * _t46)) * _t47_inv;
        float _t161 = _view03 + Math.fma(_view02, _t48, Math.fma(_view00, _t49, _view01 * _t50)) * _t51_inv;
        float _t162 = _view03 + Math.fma(_view02, _t52, Math.fma(_view00, _t53, _view01 * _t54)) * _t55_inv;
        float _t163 = _view03 + Math.fma(_view02, _t56, Math.fma(_view00, _t57, _view01 * _t58)) * _t59_inv;
        float _t164 = _view13 + Math.fma(_view12, _t28, Math.fma(_view10, _t29, _view11 * _t30)) * _t31_inv;
        float _t165 = _view13 + Math.fma(_view12, _t32, Math.fma(_view10, _t33, _view11 * _t34)) * _t35_inv;
        float _t166 = _view13 + Math.fma(_view12, _t36, Math.fma(_view10, _t37, _view11 * _t38)) * _t39_inv;
        float _t167 = _view13 + Math.fma(_view12, _t40, Math.fma(_view10, _t41, _view11 * _t42)) * _t43_inv;
        float _t168 = _view13 + Math.fma(_view12, _t44, Math.fma(_view10, _t45, _view11 * _t46)) * _t47_inv;
        float _t169 = _view13 + Math.fma(_view12, _t48, Math.fma(_view10, _t49, _view11 * _t50)) * _t51_inv;
        float _t170 = _view13 + Math.fma(_view12, _t52, Math.fma(_view10, _t53, _view11 * _t54)) * _t55_inv;
        float _t171 = _view13 + Math.fma(_view12, _t56, Math.fma(_view10, _t57, _view11 * _t58)) * _t59_inv;
        float _t172 = _view23 + Math.fma(_view22, _t28, Math.fma(_view20, _t29, _view21 * _t30)) * _t31_inv;
        float _t173 = _view23 + Math.fma(_view22, _t32, Math.fma(_view20, _t33, _view21 * _t34)) * _t35_inv;
        float _t174 = _view23 + Math.fma(_view22, _t36, Math.fma(_view20, _t37, _view21 * _t38)) * _t39_inv;
        float _t175 = _view23 + Math.fma(_view22, _t40, Math.fma(_view20, _t41, _view21 * _t42)) * _t43_inv;
        float _t176 = _view23 + Math.fma(_view22, _t44, Math.fma(_view20, _t45, _view21 * _t46)) * _t47_inv;
        float _t177 = _view23 + Math.fma(_view22, _t48, Math.fma(_view20, _t49, _view21 * _t50)) * _t51_inv;
        float _t178 = _view23 + Math.fma(_view22, _t52, Math.fma(_view20, _t53, _view21 * _t54)) * _t55_inv;
        float _t179 = _view23 + Math.fma(_view22, _t56, Math.fma(_view20, _t57, _view21 * _t58)) * _t59_inv;
        float _t216 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t156, _t157), _t158), _t159), _t160), _t161), _t162), _t163);
        float _t217 = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t156, _t157), _t158), _t159), _t160), _t161), _t162), _t163);
        float _t218 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t164, _t165), _t166), _t167), _t168), _t169), _t170), _t171);
        float _t219 = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t164, _t165), _t166), _t167), _t168), _t169), _t170), _t171);
        float _t220 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t172, _t173), _t174), _t175), _t176), _t177), _t178), _t179);
        float _t221 = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t172, _t173), _t174), _t175), _t176), _t177), _t178), _t179);
        float _t222 = _t216 - _t217;
        float _t222_inv = 1.0f / _t222;
        float _t223 = _t218 - _t219;
        float _t223_inv = 1.0f / _t223;
        float _t224 = _t220 - _t221;
        float _t224_inv = 1.0f / _t224;
        dest[destOffset + 0] = 2.0f * _t222_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t223_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = 0.0f;
        dest[destOffset + 10] = 2.0f * _t224_inv;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -((_t217 + _t216) * _t222_inv);
        dest[destOffset + 13] = -((_t219 + _t218) * _t223_inv);
        dest[destOffset + 14] = -((_t221 + _t220) * _t224_inv);
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] orthoCrop_no_rh(float[] dest, int destOffset, float[] src, int srcOffset, float[] view, int viewOffset, float minZ, float maxZ) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _view00 = view[viewOffset + 0];
        float _view10 = view[viewOffset + 1];
        float _view20 = view[viewOffset + 2];
        float _view01 = view[viewOffset + 4];
        float _view11 = view[viewOffset + 5];
        float _view21 = view[viewOffset + 6];
        float _view02 = view[viewOffset + 8];
        float _view12 = view[viewOffset + 9];
        float _view22 = view[viewOffset + 10];
        float _view03 = view[viewOffset + 12];
        float _view13 = view[viewOffset + 13];
        float _view23 = view[viewOffset + 14];
        float _t4 = _self23 + _self20;
        float _t5 = _self03 + _self00;
        float _t6 = _self13 + _self10;
        float _t7 = _self33 + _self30;
        float _t12 = _self23 - _self20 - _self21;
        float _t13 = _self03 - _self00 - _self01;
        float _t14 = _self13 - _self10 - _self11;
        float _t15 = _self33 - _self30 - _self31;
        float _t16 = _t4 - _self21;
        float _t17 = _t5 - _self01;
        float _t18 = _t6 - _self11;
        float _t19 = _t7 - _self31;
        float _t20 = _self23 + _self21 - _self20;
        float _t21 = _self03 + _self01 - _self00;
        float _t22 = _self13 + _self11 - _self10;
        float _t23 = _self33 + _self31 - _self30;
        float _t24 = _t4 + _self21;
        float _t25 = _t5 + _self01;
        float _t26 = _t6 + _self11;
        float _t27 = _t7 + _self31;
        float _t28 = Math.fma(minZ, _self22, _t12);
        float _t29 = Math.fma(minZ, _self02, _t13);
        float _t30 = Math.fma(minZ, _self12, _t14);
        float _t31 = Math.fma(minZ, _self32, _t15);
        float _t31_inv = 1.0f / _t31;
        float _t32 = Math.fma(minZ, _self22, _t16);
        float _t33 = Math.fma(minZ, _self02, _t17);
        float _t34 = Math.fma(minZ, _self12, _t18);
        float _t35 = Math.fma(minZ, _self32, _t19);
        float _t35_inv = 1.0f / _t35;
        float _t36 = Math.fma(minZ, _self22, _t20);
        float _t37 = Math.fma(minZ, _self02, _t21);
        float _t38 = Math.fma(minZ, _self12, _t22);
        float _t39 = Math.fma(minZ, _self32, _t23);
        float _t39_inv = 1.0f / _t39;
        float _t40 = Math.fma(minZ, _self22, _t24);
        float _t41 = Math.fma(minZ, _self02, _t25);
        float _t42 = Math.fma(minZ, _self12, _t26);
        float _t43 = Math.fma(minZ, _self32, _t27);
        float _t43_inv = 1.0f / _t43;
        float _t44 = Math.fma(maxZ, _self22, _t12);
        float _t45 = Math.fma(maxZ, _self02, _t13);
        float _t46 = Math.fma(maxZ, _self12, _t14);
        float _t47 = Math.fma(maxZ, _self32, _t15);
        float _t47_inv = 1.0f / _t47;
        float _t48 = Math.fma(maxZ, _self22, _t16);
        float _t49 = Math.fma(maxZ, _self02, _t17);
        float _t50 = Math.fma(maxZ, _self12, _t18);
        float _t51 = Math.fma(maxZ, _self32, _t19);
        float _t51_inv = 1.0f / _t51;
        float _t52 = Math.fma(maxZ, _self22, _t20);
        float _t53 = Math.fma(maxZ, _self02, _t21);
        float _t54 = Math.fma(maxZ, _self12, _t22);
        float _t55 = Math.fma(maxZ, _self32, _t23);
        float _t55_inv = 1.0f / _t55;
        float _t56 = Math.fma(maxZ, _self22, _t24);
        float _t57 = Math.fma(maxZ, _self02, _t25);
        float _t58 = Math.fma(maxZ, _self12, _t26);
        float _t59 = Math.fma(maxZ, _self32, _t27);
        float _t59_inv = 1.0f / _t59;
        float _t156 = _view03 + Math.fma(_view02, _t28, Math.fma(_view00, _t29, _view01 * _t30)) * _t31_inv;
        float _t157 = _view03 + Math.fma(_view02, _t32, Math.fma(_view00, _t33, _view01 * _t34)) * _t35_inv;
        float _t158 = _view03 + Math.fma(_view02, _t36, Math.fma(_view00, _t37, _view01 * _t38)) * _t39_inv;
        float _t159 = _view03 + Math.fma(_view02, _t40, Math.fma(_view00, _t41, _view01 * _t42)) * _t43_inv;
        float _t160 = _view03 + Math.fma(_view02, _t44, Math.fma(_view00, _t45, _view01 * _t46)) * _t47_inv;
        float _t161 = _view03 + Math.fma(_view02, _t48, Math.fma(_view00, _t49, _view01 * _t50)) * _t51_inv;
        float _t162 = _view03 + Math.fma(_view02, _t52, Math.fma(_view00, _t53, _view01 * _t54)) * _t55_inv;
        float _t163 = _view03 + Math.fma(_view02, _t56, Math.fma(_view00, _t57, _view01 * _t58)) * _t59_inv;
        float _t164 = _view13 + Math.fma(_view12, _t28, Math.fma(_view10, _t29, _view11 * _t30)) * _t31_inv;
        float _t165 = _view13 + Math.fma(_view12, _t32, Math.fma(_view10, _t33, _view11 * _t34)) * _t35_inv;
        float _t166 = _view13 + Math.fma(_view12, _t36, Math.fma(_view10, _t37, _view11 * _t38)) * _t39_inv;
        float _t167 = _view13 + Math.fma(_view12, _t40, Math.fma(_view10, _t41, _view11 * _t42)) * _t43_inv;
        float _t168 = _view13 + Math.fma(_view12, _t44, Math.fma(_view10, _t45, _view11 * _t46)) * _t47_inv;
        float _t169 = _view13 + Math.fma(_view12, _t48, Math.fma(_view10, _t49, _view11 * _t50)) * _t51_inv;
        float _t170 = _view13 + Math.fma(_view12, _t52, Math.fma(_view10, _t53, _view11 * _t54)) * _t55_inv;
        float _t171 = _view13 + Math.fma(_view12, _t56, Math.fma(_view10, _t57, _view11 * _t58)) * _t59_inv;
        float _t172 = _view23 + Math.fma(_view22, _t28, Math.fma(_view20, _t29, _view21 * _t30)) * _t31_inv;
        float _t173 = _view23 + Math.fma(_view22, _t32, Math.fma(_view20, _t33, _view21 * _t34)) * _t35_inv;
        float _t174 = _view23 + Math.fma(_view22, _t36, Math.fma(_view20, _t37, _view21 * _t38)) * _t39_inv;
        float _t175 = _view23 + Math.fma(_view22, _t40, Math.fma(_view20, _t41, _view21 * _t42)) * _t43_inv;
        float _t176 = _view23 + Math.fma(_view22, _t44, Math.fma(_view20, _t45, _view21 * _t46)) * _t47_inv;
        float _t177 = _view23 + Math.fma(_view22, _t48, Math.fma(_view20, _t49, _view21 * _t50)) * _t51_inv;
        float _t178 = _view23 + Math.fma(_view22, _t52, Math.fma(_view20, _t53, _view21 * _t54)) * _t55_inv;
        float _t179 = _view23 + Math.fma(_view22, _t56, Math.fma(_view20, _t57, _view21 * _t58)) * _t59_inv;
        float _t216 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t156, _t157), _t158), _t159), _t160), _t161), _t162), _t163);
        float _t217 = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t156, _t157), _t158), _t159), _t160), _t161), _t162), _t163);
        float _t218 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t164, _t165), _t166), _t167), _t168), _t169), _t170), _t171);
        float _t219 = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t164, _t165), _t166), _t167), _t168), _t169), _t170), _t171);
        float _t220 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t172, _t173), _t174), _t175), _t176), _t177), _t178), _t179);
        float _t221 = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t172, _t173), _t174), _t175), _t176), _t177), _t178), _t179);
        float _t222 = _t216 - _t217;
        float _t222_inv = 1.0f / _t222;
        float _t223 = _t218 - _t219;
        float _t223_inv = 1.0f / _t223;
        float _t224 = _t220 - _t221;
        float _t224_inv = 1.0f / _t224;
        dest[destOffset + 0] = 2.0f * _t222_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t223_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = 0.0f;
        dest[destOffset + 10] = -2.0f * _t224_inv;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -((_t217 + _t216) * _t222_inv);
        dest[destOffset + 13] = -((_t219 + _t218) * _t223_inv);
        dest[destOffset + 14] = -((-_t221 - _t220) * _t224_inv);
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] orthoCrop_no(float[] dest, int destOffset, float[] src, int srcOffset, float[] view, int viewOffset, float minZ, float maxZ, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.orthoCrop_no_lh(dest, destOffset, src, srcOffset, view, viewOffset, minZ, maxZ); }
            default -> { return Float4x4OpsKernelsArray.orthoCrop_no_rh(dest, destOffset, src, srcOffset, view, viewOffset, minZ, maxZ); }
        }
    }

    public static float[] orthoCrop_zo_lh(float[] dest, int destOffset, float[] src, int srcOffset, float[] view, int viewOffset, float minZ, float maxZ) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _view00 = view[viewOffset + 0];
        float _view10 = view[viewOffset + 1];
        float _view20 = view[viewOffset + 2];
        float _view01 = view[viewOffset + 4];
        float _view11 = view[viewOffset + 5];
        float _view21 = view[viewOffset + 6];
        float _view02 = view[viewOffset + 8];
        float _view12 = view[viewOffset + 9];
        float _view22 = view[viewOffset + 10];
        float _view03 = view[viewOffset + 12];
        float _view13 = view[viewOffset + 13];
        float _view23 = view[viewOffset + 14];
        float _t4 = _self23 + _self20;
        float _t5 = _self03 + _self00;
        float _t6 = _self13 + _self10;
        float _t7 = _self33 + _self30;
        float _t12 = _self23 - _self20 - _self21;
        float _t13 = _self03 - _self00 - _self01;
        float _t14 = _self13 - _self10 - _self11;
        float _t15 = _self33 - _self30 - _self31;
        float _t16 = _t4 - _self21;
        float _t17 = _t5 - _self01;
        float _t18 = _t6 - _self11;
        float _t19 = _t7 - _self31;
        float _t20 = _self23 + _self21 - _self20;
        float _t21 = _self03 + _self01 - _self00;
        float _t22 = _self13 + _self11 - _self10;
        float _t23 = _self33 + _self31 - _self30;
        float _t24 = _t4 + _self21;
        float _t25 = _t5 + _self01;
        float _t26 = _t6 + _self11;
        float _t27 = _t7 + _self31;
        float _t28 = Math.fma(minZ, _self22, _t12);
        float _t29 = Math.fma(minZ, _self02, _t13);
        float _t30 = Math.fma(minZ, _self12, _t14);
        float _t31 = Math.fma(minZ, _self32, _t15);
        float _t31_inv = 1.0f / _t31;
        float _t32 = Math.fma(minZ, _self22, _t16);
        float _t33 = Math.fma(minZ, _self02, _t17);
        float _t34 = Math.fma(minZ, _self12, _t18);
        float _t35 = Math.fma(minZ, _self32, _t19);
        float _t35_inv = 1.0f / _t35;
        float _t36 = Math.fma(minZ, _self22, _t20);
        float _t37 = Math.fma(minZ, _self02, _t21);
        float _t38 = Math.fma(minZ, _self12, _t22);
        float _t39 = Math.fma(minZ, _self32, _t23);
        float _t39_inv = 1.0f / _t39;
        float _t40 = Math.fma(minZ, _self22, _t24);
        float _t41 = Math.fma(minZ, _self02, _t25);
        float _t42 = Math.fma(minZ, _self12, _t26);
        float _t43 = Math.fma(minZ, _self32, _t27);
        float _t43_inv = 1.0f / _t43;
        float _t44 = Math.fma(maxZ, _self22, _t12);
        float _t45 = Math.fma(maxZ, _self02, _t13);
        float _t46 = Math.fma(maxZ, _self12, _t14);
        float _t47 = Math.fma(maxZ, _self32, _t15);
        float _t47_inv = 1.0f / _t47;
        float _t48 = Math.fma(maxZ, _self22, _t16);
        float _t49 = Math.fma(maxZ, _self02, _t17);
        float _t50 = Math.fma(maxZ, _self12, _t18);
        float _t51 = Math.fma(maxZ, _self32, _t19);
        float _t51_inv = 1.0f / _t51;
        float _t52 = Math.fma(maxZ, _self22, _t20);
        float _t53 = Math.fma(maxZ, _self02, _t21);
        float _t54 = Math.fma(maxZ, _self12, _t22);
        float _t55 = Math.fma(maxZ, _self32, _t23);
        float _t55_inv = 1.0f / _t55;
        float _t56 = Math.fma(maxZ, _self22, _t24);
        float _t57 = Math.fma(maxZ, _self02, _t25);
        float _t58 = Math.fma(maxZ, _self12, _t26);
        float _t59 = Math.fma(maxZ, _self32, _t27);
        float _t59_inv = 1.0f / _t59;
        float _t156 = _view03 + Math.fma(_view02, _t28, Math.fma(_view00, _t29, _view01 * _t30)) * _t31_inv;
        float _t157 = _view03 + Math.fma(_view02, _t32, Math.fma(_view00, _t33, _view01 * _t34)) * _t35_inv;
        float _t158 = _view03 + Math.fma(_view02, _t36, Math.fma(_view00, _t37, _view01 * _t38)) * _t39_inv;
        float _t159 = _view03 + Math.fma(_view02, _t40, Math.fma(_view00, _t41, _view01 * _t42)) * _t43_inv;
        float _t160 = _view03 + Math.fma(_view02, _t44, Math.fma(_view00, _t45, _view01 * _t46)) * _t47_inv;
        float _t161 = _view03 + Math.fma(_view02, _t48, Math.fma(_view00, _t49, _view01 * _t50)) * _t51_inv;
        float _t162 = _view03 + Math.fma(_view02, _t52, Math.fma(_view00, _t53, _view01 * _t54)) * _t55_inv;
        float _t163 = _view03 + Math.fma(_view02, _t56, Math.fma(_view00, _t57, _view01 * _t58)) * _t59_inv;
        float _t164 = _view13 + Math.fma(_view12, _t28, Math.fma(_view10, _t29, _view11 * _t30)) * _t31_inv;
        float _t165 = _view13 + Math.fma(_view12, _t32, Math.fma(_view10, _t33, _view11 * _t34)) * _t35_inv;
        float _t166 = _view13 + Math.fma(_view12, _t36, Math.fma(_view10, _t37, _view11 * _t38)) * _t39_inv;
        float _t167 = _view13 + Math.fma(_view12, _t40, Math.fma(_view10, _t41, _view11 * _t42)) * _t43_inv;
        float _t168 = _view13 + Math.fma(_view12, _t44, Math.fma(_view10, _t45, _view11 * _t46)) * _t47_inv;
        float _t169 = _view13 + Math.fma(_view12, _t48, Math.fma(_view10, _t49, _view11 * _t50)) * _t51_inv;
        float _t170 = _view13 + Math.fma(_view12, _t52, Math.fma(_view10, _t53, _view11 * _t54)) * _t55_inv;
        float _t171 = _view13 + Math.fma(_view12, _t56, Math.fma(_view10, _t57, _view11 * _t58)) * _t59_inv;
        float _t172 = _view23 + Math.fma(_view22, _t28, Math.fma(_view20, _t29, _view21 * _t30)) * _t31_inv;
        float _t173 = _view23 + Math.fma(_view22, _t32, Math.fma(_view20, _t33, _view21 * _t34)) * _t35_inv;
        float _t174 = _view23 + Math.fma(_view22, _t36, Math.fma(_view20, _t37, _view21 * _t38)) * _t39_inv;
        float _t175 = _view23 + Math.fma(_view22, _t40, Math.fma(_view20, _t41, _view21 * _t42)) * _t43_inv;
        float _t176 = _view23 + Math.fma(_view22, _t44, Math.fma(_view20, _t45, _view21 * _t46)) * _t47_inv;
        float _t177 = _view23 + Math.fma(_view22, _t48, Math.fma(_view20, _t49, _view21 * _t50)) * _t51_inv;
        float _t178 = _view23 + Math.fma(_view22, _t52, Math.fma(_view20, _t53, _view21 * _t54)) * _t55_inv;
        float _t179 = _view23 + Math.fma(_view22, _t56, Math.fma(_view20, _t57, _view21 * _t58)) * _t59_inv;
        float _t216 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t156, _t157), _t158), _t159), _t160), _t161), _t162), _t163);
        float _t217 = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t156, _t157), _t158), _t159), _t160), _t161), _t162), _t163);
        float _t218 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t164, _t165), _t166), _t167), _t168), _t169), _t170), _t171);
        float _t219 = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t164, _t165), _t166), _t167), _t168), _t169), _t170), _t171);
        float _t221 = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t172, _t173), _t174), _t175), _t176), _t177), _t178), _t179);
        float _t222 = _t216 - _t217;
        float _t222_inv = 1.0f / _t222;
        float _t223 = _t218 - _t219;
        float _t223_inv = 1.0f / _t223;
        float _t224 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t172, _t173), _t174), _t175), _t176), _t177), _t178), _t179) - _t221;
        float _t224_inv = 1.0f / _t224;
        dest[destOffset + 0] = 2.0f * _t222_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t223_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = 0.0f;
        dest[destOffset + 10] = 1.0f * _t224_inv;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -((_t217 + _t216) * _t222_inv);
        dest[destOffset + 13] = -((_t219 + _t218) * _t223_inv);
        dest[destOffset + 14] = -(_t221 * _t224_inv);
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] orthoCrop_zo_rh(float[] dest, int destOffset, float[] src, int srcOffset, float[] view, int viewOffset, float minZ, float maxZ) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _view00 = view[viewOffset + 0];
        float _view10 = view[viewOffset + 1];
        float _view20 = view[viewOffset + 2];
        float _view01 = view[viewOffset + 4];
        float _view11 = view[viewOffset + 5];
        float _view21 = view[viewOffset + 6];
        float _view02 = view[viewOffset + 8];
        float _view12 = view[viewOffset + 9];
        float _view22 = view[viewOffset + 10];
        float _view03 = view[viewOffset + 12];
        float _view13 = view[viewOffset + 13];
        float _view23 = view[viewOffset + 14];
        float _t4 = _self23 + _self20;
        float _t5 = _self03 + _self00;
        float _t6 = _self13 + _self10;
        float _t7 = _self33 + _self30;
        float _t12 = _self23 - _self20 - _self21;
        float _t13 = _self03 - _self00 - _self01;
        float _t14 = _self13 - _self10 - _self11;
        float _t15 = _self33 - _self30 - _self31;
        float _t16 = _t4 - _self21;
        float _t17 = _t5 - _self01;
        float _t18 = _t6 - _self11;
        float _t19 = _t7 - _self31;
        float _t20 = _self23 + _self21 - _self20;
        float _t21 = _self03 + _self01 - _self00;
        float _t22 = _self13 + _self11 - _self10;
        float _t23 = _self33 + _self31 - _self30;
        float _t24 = _t4 + _self21;
        float _t25 = _t5 + _self01;
        float _t26 = _t6 + _self11;
        float _t27 = _t7 + _self31;
        float _t28 = Math.fma(minZ, _self22, _t12);
        float _t29 = Math.fma(minZ, _self02, _t13);
        float _t30 = Math.fma(minZ, _self12, _t14);
        float _t31 = Math.fma(minZ, _self32, _t15);
        float _t31_inv = 1.0f / _t31;
        float _t32 = Math.fma(minZ, _self22, _t16);
        float _t33 = Math.fma(minZ, _self02, _t17);
        float _t34 = Math.fma(minZ, _self12, _t18);
        float _t35 = Math.fma(minZ, _self32, _t19);
        float _t35_inv = 1.0f / _t35;
        float _t36 = Math.fma(minZ, _self22, _t20);
        float _t37 = Math.fma(minZ, _self02, _t21);
        float _t38 = Math.fma(minZ, _self12, _t22);
        float _t39 = Math.fma(minZ, _self32, _t23);
        float _t39_inv = 1.0f / _t39;
        float _t40 = Math.fma(minZ, _self22, _t24);
        float _t41 = Math.fma(minZ, _self02, _t25);
        float _t42 = Math.fma(minZ, _self12, _t26);
        float _t43 = Math.fma(minZ, _self32, _t27);
        float _t43_inv = 1.0f / _t43;
        float _t44 = Math.fma(maxZ, _self22, _t12);
        float _t45 = Math.fma(maxZ, _self02, _t13);
        float _t46 = Math.fma(maxZ, _self12, _t14);
        float _t47 = Math.fma(maxZ, _self32, _t15);
        float _t47_inv = 1.0f / _t47;
        float _t48 = Math.fma(maxZ, _self22, _t16);
        float _t49 = Math.fma(maxZ, _self02, _t17);
        float _t50 = Math.fma(maxZ, _self12, _t18);
        float _t51 = Math.fma(maxZ, _self32, _t19);
        float _t51_inv = 1.0f / _t51;
        float _t52 = Math.fma(maxZ, _self22, _t20);
        float _t53 = Math.fma(maxZ, _self02, _t21);
        float _t54 = Math.fma(maxZ, _self12, _t22);
        float _t55 = Math.fma(maxZ, _self32, _t23);
        float _t55_inv = 1.0f / _t55;
        float _t56 = Math.fma(maxZ, _self22, _t24);
        float _t57 = Math.fma(maxZ, _self02, _t25);
        float _t58 = Math.fma(maxZ, _self12, _t26);
        float _t59 = Math.fma(maxZ, _self32, _t27);
        float _t59_inv = 1.0f / _t59;
        float _t156 = _view03 + Math.fma(_view02, _t28, Math.fma(_view00, _t29, _view01 * _t30)) * _t31_inv;
        float _t157 = _view03 + Math.fma(_view02, _t32, Math.fma(_view00, _t33, _view01 * _t34)) * _t35_inv;
        float _t158 = _view03 + Math.fma(_view02, _t36, Math.fma(_view00, _t37, _view01 * _t38)) * _t39_inv;
        float _t159 = _view03 + Math.fma(_view02, _t40, Math.fma(_view00, _t41, _view01 * _t42)) * _t43_inv;
        float _t160 = _view03 + Math.fma(_view02, _t44, Math.fma(_view00, _t45, _view01 * _t46)) * _t47_inv;
        float _t161 = _view03 + Math.fma(_view02, _t48, Math.fma(_view00, _t49, _view01 * _t50)) * _t51_inv;
        float _t162 = _view03 + Math.fma(_view02, _t52, Math.fma(_view00, _t53, _view01 * _t54)) * _t55_inv;
        float _t163 = _view03 + Math.fma(_view02, _t56, Math.fma(_view00, _t57, _view01 * _t58)) * _t59_inv;
        float _t164 = _view13 + Math.fma(_view12, _t28, Math.fma(_view10, _t29, _view11 * _t30)) * _t31_inv;
        float _t165 = _view13 + Math.fma(_view12, _t32, Math.fma(_view10, _t33, _view11 * _t34)) * _t35_inv;
        float _t166 = _view13 + Math.fma(_view12, _t36, Math.fma(_view10, _t37, _view11 * _t38)) * _t39_inv;
        float _t167 = _view13 + Math.fma(_view12, _t40, Math.fma(_view10, _t41, _view11 * _t42)) * _t43_inv;
        float _t168 = _view13 + Math.fma(_view12, _t44, Math.fma(_view10, _t45, _view11 * _t46)) * _t47_inv;
        float _t169 = _view13 + Math.fma(_view12, _t48, Math.fma(_view10, _t49, _view11 * _t50)) * _t51_inv;
        float _t170 = _view13 + Math.fma(_view12, _t52, Math.fma(_view10, _t53, _view11 * _t54)) * _t55_inv;
        float _t171 = _view13 + Math.fma(_view12, _t56, Math.fma(_view10, _t57, _view11 * _t58)) * _t59_inv;
        float _t172 = _view23 + Math.fma(_view22, _t28, Math.fma(_view20, _t29, _view21 * _t30)) * _t31_inv;
        float _t173 = _view23 + Math.fma(_view22, _t32, Math.fma(_view20, _t33, _view21 * _t34)) * _t35_inv;
        float _t174 = _view23 + Math.fma(_view22, _t36, Math.fma(_view20, _t37, _view21 * _t38)) * _t39_inv;
        float _t175 = _view23 + Math.fma(_view22, _t40, Math.fma(_view20, _t41, _view21 * _t42)) * _t43_inv;
        float _t176 = _view23 + Math.fma(_view22, _t44, Math.fma(_view20, _t45, _view21 * _t46)) * _t47_inv;
        float _t177 = _view23 + Math.fma(_view22, _t48, Math.fma(_view20, _t49, _view21 * _t50)) * _t51_inv;
        float _t178 = _view23 + Math.fma(_view22, _t52, Math.fma(_view20, _t53, _view21 * _t54)) * _t55_inv;
        float _t179 = _view23 + Math.fma(_view22, _t56, Math.fma(_view20, _t57, _view21 * _t58)) * _t59_inv;
        float _t216 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t156, _t157), _t158), _t159), _t160), _t161), _t162), _t163);
        float _t217 = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t156, _t157), _t158), _t159), _t160), _t161), _t162), _t163);
        float _t218 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t164, _t165), _t166), _t167), _t168), _t169), _t170), _t171);
        float _t219 = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t164, _t165), _t166), _t167), _t168), _t169), _t170), _t171);
        float _t220 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t172, _t173), _t174), _t175), _t176), _t177), _t178), _t179);
        float _t222 = _t216 - _t217;
        float _t222_inv = 1.0f / _t222;
        float _t223 = _t218 - _t219;
        float _t223_inv = 1.0f / _t223;
        float _t224 = _t220 - Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t172, _t173), _t174), _t175), _t176), _t177), _t178), _t179);
        float _t224_inv = 1.0f / _t224;
        dest[destOffset + 0] = 2.0f * _t222_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t223_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = 0.0f;
        dest[destOffset + 10] = -1.0f * _t224_inv;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -((_t217 + _t216) * _t222_inv);
        dest[destOffset + 13] = -((_t219 + _t218) * _t223_inv);
        dest[destOffset + 14] = _t220 * _t224_inv;
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] orthoCrop_zo(float[] dest, int destOffset, float[] src, int srcOffset, float[] view, int viewOffset, float minZ, float maxZ, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.orthoCrop_zo_lh(dest, destOffset, src, srcOffset, view, viewOffset, minZ, maxZ); }
            default -> { return Float4x4OpsKernelsArray.orthoCrop_zo_rh(dest, destOffset, src, srcOffset, view, viewOffset, minZ, maxZ); }
        }
    }

    public static float[] perspective_no_lh(float[] dest, int destOffset, float[] src, int srcOffset, float fovy, float aspect, float near, float far) {
        if (SimdSupport.VECTOR_API) return Float4x4OpsSimd.perspective_no_lh(dest, destOffset, src, srcOffset, fovy, aspect, near, far);
        return Float4x4OpsKernelsArray.perspective_no_lh_scalar(dest, destOffset, src, srcOffset, fovy, aspect, near, far);
    }

    public static float[] perspective_no_lh_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float fovy, float aspect, float near, float far) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
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
        dest[destOffset + 0] = _self00 * _t9_inv;
        dest[destOffset + 1] = _self10 * _t9_inv;
        dest[destOffset + 2] = _self20 * _t9_inv;
        dest[destOffset + 3] = _self30 * _t9_inv;
        dest[destOffset + 4] = _self01 * _t6_inv;
        dest[destOffset + 5] = _self11 * _t6_inv;
        dest[destOffset + 6] = _self21 * _t6_inv;
        dest[destOffset + 7] = _self31 * _t6_inv;
        dest[destOffset + 8] = Math.fma(_self02, _t15, _self03);
        dest[destOffset + 9] = Math.fma(_self12, _t15, _self13);
        dest[destOffset + 10] = Math.fma(_self22, _t15, _self23);
        dest[destOffset + 11] = Math.fma(_self32, _t15, _self33);
        dest[destOffset + 12] = _self02 * _t16;
        dest[destOffset + 13] = _self12 * _t16;
        dest[destOffset + 14] = _self22 * _t16;
        dest[destOffset + 15] = _self32 * _t16;
        return dest;
    }

    public static float[] perspective_no_rh(float[] dest, int destOffset, float[] src, int srcOffset, float fovy, float aspect, float near, float far) {
        if (SimdSupport.VECTOR_API) return Float4x4OpsSimd.perspective_no_rh(dest, destOffset, src, srcOffset, fovy, aspect, near, far);
        return Float4x4OpsKernelsArray.perspective_no_rh_scalar(dest, destOffset, src, srcOffset, fovy, aspect, near, far);
    }

    public static float[] perspective_no_rh_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float fovy, float aspect, float near, float far) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
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
        dest[destOffset + 0] = _self00 * _t9_inv;
        dest[destOffset + 1] = _self10 * _t9_inv;
        dest[destOffset + 2] = _self20 * _t9_inv;
        dest[destOffset + 3] = _self30 * _t9_inv;
        dest[destOffset + 4] = _self01 * _t6_inv;
        dest[destOffset + 5] = _self11 * _t6_inv;
        dest[destOffset + 6] = _self21 * _t6_inv;
        dest[destOffset + 7] = _self31 * _t6_inv;
        dest[destOffset + 8] = Math.fma(_self02, _t13, -_self03);
        dest[destOffset + 9] = Math.fma(_self12, _t13, -_self13);
        dest[destOffset + 10] = Math.fma(_self22, _t13, -_self23);
        dest[destOffset + 11] = Math.fma(_self32, _t13, -_self33);
        dest[destOffset + 12] = _self02 * _t15;
        dest[destOffset + 13] = _self12 * _t15;
        dest[destOffset + 14] = _self22 * _t15;
        dest[destOffset + 15] = _self32 * _t15;
        return dest;
    }

    public static float[] perspective_no(float[] dest, int destOffset, float[] src, int srcOffset, float fovy, float aspect, float near, float far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.perspective_no_lh(dest, destOffset, src, srcOffset, fovy, aspect, near, far); }
            default -> { return Float4x4OpsKernelsArray.perspective_no_rh(dest, destOffset, src, srcOffset, fovy, aspect, near, far); }
        }
    }

    public static float[] perspective_zo_lh(float[] dest, int destOffset, float[] src, int srcOffset, float fovy, float aspect, float near, float far) {
        if (SimdSupport.VECTOR_API) return Float4x4OpsSimd.perspective_zo_lh(dest, destOffset, src, srcOffset, fovy, aspect, near, far);
        return Float4x4OpsKernelsArray.perspective_zo_lh_scalar(dest, destOffset, src, srcOffset, fovy, aspect, near, far);
    }

    public static float[] perspective_zo_lh_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float fovy, float aspect, float near, float far) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
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
        dest[destOffset + 0] = _self00 * _t5_inv;
        dest[destOffset + 1] = _self10 * _t5_inv;
        dest[destOffset + 2] = _self20 * _t5_inv;
        dest[destOffset + 3] = _self30 * _t5_inv;
        dest[destOffset + 4] = _self01 * _t3_inv;
        dest[destOffset + 5] = _self11 * _t3_inv;
        dest[destOffset + 6] = _self21 * _t3_inv;
        dest[destOffset + 7] = _self31 * _t3_inv;
        dest[destOffset + 8] = Math.fma(_self02, _t10, _self03);
        dest[destOffset + 9] = Math.fma(_self12, _t10, _self13);
        dest[destOffset + 10] = Math.fma(_self22, _t10, _self23);
        dest[destOffset + 11] = Math.fma(_self32, _t10, _self33);
        dest[destOffset + 12] = _self02 * _t11;
        dest[destOffset + 13] = _self12 * _t11;
        dest[destOffset + 14] = _self22 * _t11;
        dest[destOffset + 15] = _self32 * _t11;
        return dest;
    }

    public static float[] perspective_zo_rh(float[] dest, int destOffset, float[] src, int srcOffset, float fovy, float aspect, float near, float far) {
        if (SimdSupport.VECTOR_API) return Float4x4OpsSimd.perspective_zo_rh(dest, destOffset, src, srcOffset, fovy, aspect, near, far);
        return Float4x4OpsKernelsArray.perspective_zo_rh_scalar(dest, destOffset, src, srcOffset, fovy, aspect, near, far);
    }

    public static float[] perspective_zo_rh_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float fovy, float aspect, float near, float far) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
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
        dest[destOffset + 0] = _self00 * _t5_inv;
        dest[destOffset + 1] = _self10 * _t5_inv;
        dest[destOffset + 2] = _self20 * _t5_inv;
        dest[destOffset + 3] = _self30 * _t5_inv;
        dest[destOffset + 4] = _self01 * _t3_inv;
        dest[destOffset + 5] = _self11 * _t3_inv;
        dest[destOffset + 6] = _self21 * _t3_inv;
        dest[destOffset + 7] = _self31 * _t3_inv;
        dest[destOffset + 8] = Math.fma(_self02, _t9, -_self03);
        dest[destOffset + 9] = Math.fma(_self12, _t9, -_self13);
        dest[destOffset + 10] = Math.fma(_self22, _t9, -_self23);
        dest[destOffset + 11] = Math.fma(_self32, _t9, -_self33);
        dest[destOffset + 12] = _self02 * _t10;
        dest[destOffset + 13] = _self12 * _t10;
        dest[destOffset + 14] = _self22 * _t10;
        dest[destOffset + 15] = _self32 * _t10;
        return dest;
    }

    public static float[] perspective_zo(float[] dest, int destOffset, float[] src, int srcOffset, float fovy, float aspect, float near, float far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.perspective_zo_lh(dest, destOffset, src, srcOffset, fovy, aspect, near, far); }
            default -> { return Float4x4OpsKernelsArray.perspective_zo_rh(dest, destOffset, src, srcOffset, fovy, aspect, near, far); }
        }
    }

    public static float[] perspectiveFovRange_no_lh(float[] dest, int destOffset, float[] src, int srcOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        if (SimdSupport.VECTOR_API) return Float4x4OpsSimd.perspectiveFovRange_no_lh(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far);
        return Float4x4OpsKernelsArray.perspectiveFovRange_no_lh_scalar(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far);
    }

    public static float[] perspectiveFovRange_no_lh_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
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
        dest[destOffset + 0] = 2.0f * _self00 * _t11_inv;
        dest[destOffset + 1] = 2.0f * _self10 * _t11_inv;
        dest[destOffset + 2] = 2.0f * _self20 * _t11_inv;
        dest[destOffset + 3] = 2.0f * _self30 * _t11_inv;
        dest[destOffset + 4] = 2.0f * _self01 * _t8_inv;
        dest[destOffset + 5] = 2.0f * _self11 * _t8_inv;
        dest[destOffset + 6] = 2.0f * _self21 * _t8_inv;
        dest[destOffset + 7] = 2.0f * _self31 * _t8_inv;
        dest[destOffset + 8] = Math.fma(_self02, _t17, _self03 - _self01 * _t9 * _t8_inv);
        dest[destOffset + 9] = Math.fma(_self12, _t17, _self13 - _self11 * _t9 * _t8_inv);
        dest[destOffset + 10] = Math.fma(_self22, _t17, _self23 - _self21 * _t9 * _t8_inv);
        dest[destOffset + 11] = Math.fma(_self32, _t17, _self33 - _self31 * _t9 * _t8_inv);
        dest[destOffset + 12] = _self02 * _t18;
        dest[destOffset + 13] = _self12 * _t18;
        dest[destOffset + 14] = _self22 * _t18;
        dest[destOffset + 15] = _self32 * _t18;
        return dest;
    }

    public static float[] perspectiveFovRange_no_rh(float[] dest, int destOffset, float[] src, int srcOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        if (SimdSupport.VECTOR_API) return Float4x4OpsSimd.perspectiveFovRange_no_rh(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far);
        return Float4x4OpsKernelsArray.perspectiveFovRange_no_rh_scalar(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far);
    }

    public static float[] perspectiveFovRange_no_rh_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
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
        dest[destOffset + 0] = 2.0f * _self00 * _t11_inv;
        dest[destOffset + 1] = 2.0f * _self10 * _t11_inv;
        dest[destOffset + 2] = 2.0f * _self20 * _t11_inv;
        dest[destOffset + 3] = 2.0f * _self30 * _t11_inv;
        dest[destOffset + 4] = 2.0f * _self01 * _t8_inv;
        dest[destOffset + 5] = 2.0f * _self11 * _t8_inv;
        dest[destOffset + 6] = 2.0f * _self21 * _t8_inv;
        dest[destOffset + 7] = 2.0f * _self31 * _t8_inv;
        dest[destOffset + 8] = Math.fma(_self02, _t15, _self01 * _t9 * _t8_inv - _self03);
        dest[destOffset + 9] = Math.fma(_self12, _t15, _self11 * _t9 * _t8_inv - _self13);
        dest[destOffset + 10] = Math.fma(_self22, _t15, _self21 * _t9 * _t8_inv - _self23);
        dest[destOffset + 11] = Math.fma(_self32, _t15, _self31 * _t9 * _t8_inv - _self33);
        dest[destOffset + 12] = _self02 * _t17;
        dest[destOffset + 13] = _self12 * _t17;
        dest[destOffset + 14] = _self22 * _t17;
        dest[destOffset + 15] = _self32 * _t17;
        return dest;
    }

    public static float[] perspectiveFovRange_no(float[] dest, int destOffset, float[] src, int srcOffset, float angleMin, float angleMax, float aspect, float near, float far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.perspectiveFovRange_no_lh(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far); }
            default -> { return Float4x4OpsKernelsArray.perspectiveFovRange_no_rh(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far); }
        }
    }

    public static float[] perspectiveFovRange_zo_lh(float[] dest, int destOffset, float[] src, int srcOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        if (SimdSupport.VECTOR_API) return Float4x4OpsSimd.perspectiveFovRange_zo_lh(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far);
        return Float4x4OpsKernelsArray.perspectiveFovRange_zo_lh_scalar(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far);
    }

    public static float[] perspectiveFovRange_zo_lh_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
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
        dest[destOffset + 0] = 2.0f * _self00 * _t8_inv;
        dest[destOffset + 1] = 2.0f * _self10 * _t8_inv;
        dest[destOffset + 2] = 2.0f * _self20 * _t8_inv;
        dest[destOffset + 3] = 2.0f * _self30 * _t8_inv;
        dest[destOffset + 4] = 2.0f * _self01 * _t4_inv;
        dest[destOffset + 5] = 2.0f * _self11 * _t4_inv;
        dest[destOffset + 6] = 2.0f * _self21 * _t4_inv;
        dest[destOffset + 7] = 2.0f * _self31 * _t4_inv;
        dest[destOffset + 8] = Math.fma(_self02, _t12, _self03 - _self01 * _t6 * _t4_inv);
        dest[destOffset + 9] = Math.fma(_self12, _t12, _self13 - _self11 * _t6 * _t4_inv);
        dest[destOffset + 10] = Math.fma(_self22, _t12, _self23 - _self21 * _t6 * _t4_inv);
        dest[destOffset + 11] = Math.fma(_self32, _t12, _self33 - _self31 * _t6 * _t4_inv);
        dest[destOffset + 12] = _self02 * _t13;
        dest[destOffset + 13] = _self12 * _t13;
        dest[destOffset + 14] = _self22 * _t13;
        dest[destOffset + 15] = _self32 * _t13;
        return dest;
    }

    public static float[] perspectiveFovRange_zo_rh(float[] dest, int destOffset, float[] src, int srcOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        if (SimdSupport.VECTOR_API) return Float4x4OpsSimd.perspectiveFovRange_zo_rh(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far);
        return Float4x4OpsKernelsArray.perspectiveFovRange_zo_rh_scalar(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far);
    }

    public static float[] perspectiveFovRange_zo_rh_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
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
        dest[destOffset + 0] = 2.0f * _self00 * _t7_inv;
        dest[destOffset + 1] = 2.0f * _self10 * _t7_inv;
        dest[destOffset + 2] = 2.0f * _self20 * _t7_inv;
        dest[destOffset + 3] = 2.0f * _self30 * _t7_inv;
        dest[destOffset + 4] = 2.0f * _self01 * _t4_inv;
        dest[destOffset + 5] = 2.0f * _self11 * _t4_inv;
        dest[destOffset + 6] = 2.0f * _self21 * _t4_inv;
        dest[destOffset + 7] = 2.0f * _self31 * _t4_inv;
        dest[destOffset + 8] = Math.fma(_self02, _t11, _self01 * _t6 * _t4_inv - _self03);
        dest[destOffset + 9] = Math.fma(_self12, _t11, _self11 * _t6 * _t4_inv - _self13);
        dest[destOffset + 10] = Math.fma(_self22, _t11, _self21 * _t6 * _t4_inv - _self23);
        dest[destOffset + 11] = Math.fma(_self32, _t11, _self31 * _t6 * _t4_inv - _self33);
        dest[destOffset + 12] = _self02 * _t12;
        dest[destOffset + 13] = _self12 * _t12;
        dest[destOffset + 14] = _self22 * _t12;
        dest[destOffset + 15] = _self32 * _t12;
        return dest;
    }

    public static float[] perspectiveFovRange_zo(float[] dest, int destOffset, float[] src, int srcOffset, float angleMin, float angleMax, float aspect, float near, float far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.perspectiveFovRange_zo_lh(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far); }
            default -> { return Float4x4OpsKernelsArray.perspectiveFovRange_zo_rh(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far); }
        }
    }

    public static float[] perspectiveFrustumSlice_no_lh(float[] dest, int destOffset, float[] src, int srcOffset, float near, float far) {
        if (SimdSupport.VECTOR_API) return Float4x4OpsSimd.perspectiveFrustumSlice_no_lh(dest, destOffset, src, srcOffset, near, far);
        return Float4x4OpsKernelsArray.perspectiveFrustumSlice_no_lh_scalar(dest, destOffset, src, srcOffset, near, far);
    }

    public static float[] perspectiveFrustumSlice_no_lh_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float near, float far) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self33 = src[srcOffset + 15];
        float _t0 = near - far;
        float _t0_inv = 1.0f / _t0;
        if (far == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = 1.0f;
            dest[destOffset + 14] = -(2.0f * near);
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = -1.0f;
                dest[destOffset + 14] = 2.0f * far;
            } else {
                dest[destOffset + 10] = -((far + near) * _t0_inv);
                dest[destOffset + 14] = 2.0f * far * near * _t0_inv;
            }
        }
        dest[destOffset + 0] = _self00;
        dest[destOffset + 1] = _self10;
        dest[destOffset + 2] = _self20;
        dest[destOffset + 3] = _self30;
        dest[destOffset + 4] = _self01;
        dest[destOffset + 5] = _self11;
        dest[destOffset + 6] = _self21;
        dest[destOffset + 7] = _self31;
        dest[destOffset + 8] = _self02;
        dest[destOffset + 9] = _self12;
        dest[destOffset + 11] = _self32;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] perspectiveFrustumSlice_no_rh(float[] dest, int destOffset, float[] src, int srcOffset, float near, float far) {
        if (SimdSupport.VECTOR_API) return Float4x4OpsSimd.perspectiveFrustumSlice_no_rh(dest, destOffset, src, srcOffset, near, far);
        return Float4x4OpsKernelsArray.perspectiveFrustumSlice_no_rh_scalar(dest, destOffset, src, srcOffset, near, far);
    }

    public static float[] perspectiveFrustumSlice_no_rh_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float near, float far) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self33 = src[srcOffset + 15];
        float _t0 = near - far;
        float _t0_inv = 1.0f / _t0;
        if (far == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = -1.0f;
            dest[destOffset + 14] = -(2.0f * near);
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = 1.0f;
                dest[destOffset + 14] = 2.0f * far;
            } else {
                dest[destOffset + 10] = (far + near) * _t0_inv;
                dest[destOffset + 14] = 2.0f * far * near * _t0_inv;
            }
        }
        dest[destOffset + 0] = _self00;
        dest[destOffset + 1] = _self10;
        dest[destOffset + 2] = _self20;
        dest[destOffset + 3] = _self30;
        dest[destOffset + 4] = _self01;
        dest[destOffset + 5] = _self11;
        dest[destOffset + 6] = _self21;
        dest[destOffset + 7] = _self31;
        dest[destOffset + 8] = _self02;
        dest[destOffset + 9] = _self12;
        dest[destOffset + 11] = _self32;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] perspectiveFrustumSlice_no(float[] dest, int destOffset, float[] src, int srcOffset, float near, float far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.perspectiveFrustumSlice_no_lh(dest, destOffset, src, srcOffset, near, far); }
            default -> { return Float4x4OpsKernelsArray.perspectiveFrustumSlice_no_rh(dest, destOffset, src, srcOffset, near, far); }
        }
    }

    public static float[] perspectiveFrustumSlice_zo_lh(float[] dest, int destOffset, float[] src, int srcOffset, float near, float far) {
        if (SimdSupport.VECTOR_API) return Float4x4OpsSimd.perspectiveFrustumSlice_zo_lh(dest, destOffset, src, srcOffset, near, far);
        return Float4x4OpsKernelsArray.perspectiveFrustumSlice_zo_lh_scalar(dest, destOffset, src, srcOffset, near, far);
    }

    public static float[] perspectiveFrustumSlice_zo_lh_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float near, float far) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self33 = src[srcOffset + 15];
        float _t0 = near - far;
        float _t0_inv = 1.0f / _t0;
        if (far == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = 1.0f;
            dest[destOffset + 14] = -near;
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = 0.0f;
                dest[destOffset + 14] = far;
            } else {
                dest[destOffset + 10] = -(far * _t0_inv);
                dest[destOffset + 14] = far * near * _t0_inv;
            }
        }
        dest[destOffset + 0] = _self00;
        dest[destOffset + 1] = _self10;
        dest[destOffset + 2] = _self20;
        dest[destOffset + 3] = _self30;
        dest[destOffset + 4] = _self01;
        dest[destOffset + 5] = _self11;
        dest[destOffset + 6] = _self21;
        dest[destOffset + 7] = _self31;
        dest[destOffset + 8] = _self02;
        dest[destOffset + 9] = _self12;
        dest[destOffset + 11] = _self32;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] perspectiveFrustumSlice_zo_rh(float[] dest, int destOffset, float[] src, int srcOffset, float near, float far) {
        if (SimdSupport.VECTOR_API) return Float4x4OpsSimd.perspectiveFrustumSlice_zo_rh(dest, destOffset, src, srcOffset, near, far);
        return Float4x4OpsKernelsArray.perspectiveFrustumSlice_zo_rh_scalar(dest, destOffset, src, srcOffset, near, far);
    }

    public static float[] perspectiveFrustumSlice_zo_rh_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float near, float far) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self33 = src[srcOffset + 15];
        float _t0 = near - far;
        float _t0_inv = 1.0f / _t0;
        if (far == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = -1.0f;
            dest[destOffset + 14] = -near;
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = 0.0f;
                dest[destOffset + 14] = far;
            } else {
                dest[destOffset + 10] = far * _t0_inv;
                dest[destOffset + 14] = far * near * _t0_inv;
            }
        }
        dest[destOffset + 0] = _self00;
        dest[destOffset + 1] = _self10;
        dest[destOffset + 2] = _self20;
        dest[destOffset + 3] = _self30;
        dest[destOffset + 4] = _self01;
        dest[destOffset + 5] = _self11;
        dest[destOffset + 6] = _self21;
        dest[destOffset + 7] = _self31;
        dest[destOffset + 8] = _self02;
        dest[destOffset + 9] = _self12;
        dest[destOffset + 11] = _self32;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] perspectiveFrustumSlice_zo(float[] dest, int destOffset, float[] src, int srcOffset, float near, float far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.perspectiveFrustumSlice_zo_lh(dest, destOffset, src, srcOffset, near, far); }
            default -> { return Float4x4OpsKernelsArray.perspectiveFrustumSlice_zo_rh(dest, destOffset, src, srcOffset, near, far); }
        }
    }

    public static float[] perspectiveOffCenterFov_no_lh(float[] dest, int destOffset, float[] src, int srcOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        if (SimdSupport.VECTOR_API) return Float4x4OpsSimd.perspectiveOffCenterFov_no_lh(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
        return Float4x4OpsKernelsArray.perspectiveOffCenterFov_no_lh_scalar(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
    }

    public static float[] perspectiveOffCenterFov_no_lh_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
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
        dest[destOffset + 0] = 2.0f * _self00 * _t10_inv;
        dest[destOffset + 1] = 2.0f * _self10 * _t10_inv;
        dest[destOffset + 2] = 2.0f * _self20 * _t10_inv;
        dest[destOffset + 3] = 2.0f * _self30 * _t10_inv;
        dest[destOffset + 4] = 2.0f * _self01 * _t11_inv;
        dest[destOffset + 5] = 2.0f * _self11 * _t11_inv;
        dest[destOffset + 6] = 2.0f * _self21 * _t11_inv;
        dest[destOffset + 7] = 2.0f * _self31 * _t11_inv;
        dest[destOffset + 8] = Math.fma(_self02, _t20, _self03 - _self00 * _t12 * _t10_inv - _self01 * _t13 * _t11_inv);
        dest[destOffset + 9] = Math.fma(_self12, _t20, _self13 - _self10 * _t12 * _t10_inv - _self11 * _t13 * _t11_inv);
        dest[destOffset + 10] = Math.fma(_self22, _t20, _self23 - _self20 * _t12 * _t10_inv - _self21 * _t13 * _t11_inv);
        dest[destOffset + 11] = Math.fma(_self32, _t20, _self33 - _self30 * _t12 * _t10_inv - _self31 * _t13 * _t11_inv);
        dest[destOffset + 12] = _self02 * _t21;
        dest[destOffset + 13] = _self12 * _t21;
        dest[destOffset + 14] = _self22 * _t21;
        dest[destOffset + 15] = _self32 * _t21;
        return dest;
    }

    public static float[] perspectiveOffCenterFov_no_rh(float[] dest, int destOffset, float[] src, int srcOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        if (SimdSupport.VECTOR_API) return Float4x4OpsSimd.perspectiveOffCenterFov_no_rh(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
        return Float4x4OpsKernelsArray.perspectiveOffCenterFov_no_rh_scalar(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
    }

    public static float[] perspectiveOffCenterFov_no_rh_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
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
        dest[destOffset + 0] = 2.0f * _self00 * _t10_inv;
        dest[destOffset + 1] = 2.0f * _self10 * _t10_inv;
        dest[destOffset + 2] = 2.0f * _self20 * _t10_inv;
        dest[destOffset + 3] = 2.0f * _self30 * _t10_inv;
        dest[destOffset + 4] = 2.0f * _self01 * _t11_inv;
        dest[destOffset + 5] = 2.0f * _self11 * _t11_inv;
        dest[destOffset + 6] = 2.0f * _self21 * _t11_inv;
        dest[destOffset + 7] = 2.0f * _self31 * _t11_inv;
        dest[destOffset + 8] = Math.fma(_self02, _t18, _self00 * _t12 * _t10_inv + _self01 * _t13 * _t11_inv - _self03);
        dest[destOffset + 9] = Math.fma(_self12, _t18, _self10 * _t12 * _t10_inv + _self11 * _t13 * _t11_inv - _self13);
        dest[destOffset + 10] = Math.fma(_self22, _t18, _self20 * _t12 * _t10_inv + _self21 * _t13 * _t11_inv - _self23);
        dest[destOffset + 11] = Math.fma(_self32, _t18, _self30 * _t12 * _t10_inv + _self31 * _t13 * _t11_inv - _self33);
        dest[destOffset + 12] = _self02 * _t20;
        dest[destOffset + 13] = _self12 * _t20;
        dest[destOffset + 14] = _self22 * _t20;
        dest[destOffset + 15] = _self32 * _t20;
        return dest;
    }

    public static float[] perspectiveOffCenterFov_no(float[] dest, int destOffset, float[] src, int srcOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.perspectiveOffCenterFov_no_lh(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far); }
            default -> { return Float4x4OpsKernelsArray.perspectiveOffCenterFov_no_rh(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far); }
        }
    }

    public static float[] perspectiveOffCenterFov_zo_lh(float[] dest, int destOffset, float[] src, int srcOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        if (SimdSupport.VECTOR_API) return Float4x4OpsSimd.perspectiveOffCenterFov_zo_lh(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
        return Float4x4OpsKernelsArray.perspectiveOffCenterFov_zo_lh_scalar(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
    }

    public static float[] perspectiveOffCenterFov_zo_lh_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
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
        dest[destOffset + 0] = 2.0f * _self00 * _t6_inv;
        dest[destOffset + 1] = 2.0f * _self10 * _t6_inv;
        dest[destOffset + 2] = 2.0f * _self20 * _t6_inv;
        dest[destOffset + 3] = 2.0f * _self30 * _t6_inv;
        dest[destOffset + 4] = 2.0f * _self01 * _t7_inv;
        dest[destOffset + 5] = 2.0f * _self11 * _t7_inv;
        dest[destOffset + 6] = 2.0f * _self21 * _t7_inv;
        dest[destOffset + 7] = 2.0f * _self31 * _t7_inv;
        dest[destOffset + 8] = Math.fma(_self02, _t15, _self03 - _self00 * _t9 * _t6_inv - _self01 * _t10 * _t7_inv);
        dest[destOffset + 9] = Math.fma(_self12, _t15, _self13 - _self10 * _t9 * _t6_inv - _self11 * _t10 * _t7_inv);
        dest[destOffset + 10] = Math.fma(_self22, _t15, _self23 - _self20 * _t9 * _t6_inv - _self21 * _t10 * _t7_inv);
        dest[destOffset + 11] = Math.fma(_self32, _t15, _self33 - _self30 * _t9 * _t6_inv - _self31 * _t10 * _t7_inv);
        dest[destOffset + 12] = _self02 * _t16;
        dest[destOffset + 13] = _self12 * _t16;
        dest[destOffset + 14] = _self22 * _t16;
        dest[destOffset + 15] = _self32 * _t16;
        return dest;
    }

    public static float[] perspectiveOffCenterFov_zo_rh(float[] dest, int destOffset, float[] src, int srcOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        if (SimdSupport.VECTOR_API) return Float4x4OpsSimd.perspectiveOffCenterFov_zo_rh(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
        return Float4x4OpsKernelsArray.perspectiveOffCenterFov_zo_rh_scalar(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
    }

    public static float[] perspectiveOffCenterFov_zo_rh_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
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
        dest[destOffset + 0] = 2.0f * _self00 * _t6_inv;
        dest[destOffset + 1] = 2.0f * _self10 * _t6_inv;
        dest[destOffset + 2] = 2.0f * _self20 * _t6_inv;
        dest[destOffset + 3] = 2.0f * _self30 * _t6_inv;
        dest[destOffset + 4] = 2.0f * _self01 * _t7_inv;
        dest[destOffset + 5] = 2.0f * _self11 * _t7_inv;
        dest[destOffset + 6] = 2.0f * _self21 * _t7_inv;
        dest[destOffset + 7] = 2.0f * _self31 * _t7_inv;
        dest[destOffset + 8] = Math.fma(_self02, _t14, _self00 * _t9 * _t6_inv + _self01 * _t10 * _t7_inv - _self03);
        dest[destOffset + 9] = Math.fma(_self12, _t14, _self10 * _t9 * _t6_inv + _self11 * _t10 * _t7_inv - _self13);
        dest[destOffset + 10] = Math.fma(_self22, _t14, _self20 * _t9 * _t6_inv + _self21 * _t10 * _t7_inv - _self23);
        dest[destOffset + 11] = Math.fma(_self32, _t14, _self30 * _t9 * _t6_inv + _self31 * _t10 * _t7_inv - _self33);
        dest[destOffset + 12] = _self02 * _t15;
        dest[destOffset + 13] = _self12 * _t15;
        dest[destOffset + 14] = _self22 * _t15;
        dest[destOffset + 15] = _self32 * _t15;
        return dest;
    }

    public static float[] perspectiveOffCenterFov_zo(float[] dest, int destOffset, float[] src, int srcOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.perspectiveOffCenterFov_zo_lh(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far); }
            default -> { return Float4x4OpsKernelsArray.perspectiveOffCenterFov_zo_rh(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far); }
        }
    }

    public static float[] pickMatrix_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float centerX, float centerY, float deltaX, float deltaY, float vpX, float vpY, float vpW, float vpH) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _rcp0 = 1.0f / deltaX;
        float _rcp1 = 1.0f / deltaY;
        float _t2 = Math.fma(-2.0f, centerX - vpX, vpW);
        float _t3 = Math.fma(-2.0f, centerY - vpY, vpH);
        dest[destOffset + 0] = vpW * _self00 * _rcp0;
        dest[destOffset + 1] = vpW * _self10 * _rcp0;
        dest[destOffset + 2] = vpW * _self20 * _rcp0;
        dest[destOffset + 3] = vpW * _self30 * _rcp0;
        dest[destOffset + 4] = vpH * _self01 * _rcp1;
        dest[destOffset + 5] = vpH * _self11 * _rcp1;
        dest[destOffset + 6] = vpH * _self21 * _rcp1;
        dest[destOffset + 7] = vpH * _self31 * _rcp1;
        dest[destOffset + 8] = _self02;
        dest[destOffset + 9] = _self12;
        dest[destOffset + 10] = _self22;
        dest[destOffset + 11] = _self32;
        dest[destOffset + 12] = _self03 + (_self00 * _t2 * _rcp0 + _self01 * _t3 * _rcp1);
        dest[destOffset + 13] = _self13 + (_self10 * _t2 * _rcp0 + _self11 * _t3 * _rcp1);
        dest[destOffset + 14] = _self23 + (_self20 * _t2 * _rcp0 + _self21 * _t3 * _rcp1);
        dest[destOffset + 15] = _self33 + (_self30 * _t2 * _rcp0 + _self31 * _t3 * _rcp1);
        return dest;
    }

    public static float[] preScale_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float vX, float vY, float vZ) {
        for (int _l = 0; _l < 4; _l++) {
            int _lo = _l * 4;
            float _eself0 = src[srcOffset + _lo];
            float _eself1 = src[srcOffset + _lo + 1];
            float _eself2 = src[srcOffset + _lo + 2];
            float _eself3 = src[srcOffset + _lo + 3];
            dest[destOffset + _lo] = _eself0 * vX;
            dest[destOffset + _lo + 1] = _eself1 * vY;
            dest[destOffset + _lo + 2] = _eself2 * vZ;
            dest[destOffset + _lo + 3] = _eself3;
        }
        return dest;
    }

    public static float[] preScale_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] v, int vOffset) {
        float _vx = v[vOffset + 0];
        float _vy = v[vOffset + 1];
        float _vz = v[vOffset + 2];
        for (int _l = 0; _l < 4; _l++) {
            int _lo = _l * 4;
            float _eself0 = src[srcOffset + _lo];
            float _eself1 = src[srcOffset + _lo + 1];
            float _eself2 = src[srcOffset + _lo + 2];
            float _eself3 = src[srcOffset + _lo + 3];
            dest[destOffset + _lo] = _eself0 * _vx;
            dest[destOffset + _lo + 1] = _eself1 * _vy;
            dest[destOffset + _lo + 2] = _eself2 * _vz;
            dest[destOffset + _lo + 3] = _eself3;
        }
        return dest;
    }

    public static float[] preScale_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float s) {
        for (int _l = 0; _l < 4; _l++) {
            int _lo = _l * 4;
            float _eself0 = src[srcOffset + _lo];
            float _eself1 = src[srcOffset + _lo + 1];
            float _eself2 = src[srcOffset + _lo + 2];
            float _eself3 = src[srcOffset + _lo + 3];
            dest[destOffset + _lo] = s * _eself0;
            dest[destOffset + _lo + 1] = s * _eself1;
            dest[destOffset + _lo + 2] = s * _eself2;
            dest[destOffset + _lo + 3] = _eself3;
        }
        return dest;
    }

    public static float[] preScaleAround_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float s, float pivotX, float pivotY, float pivotZ) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = Math.fma(-s, pivotX, pivotX);
        float _t1 = Math.fma(-s, pivotY, pivotY);
        float _t2 = Math.fma(-s, pivotZ, pivotZ);
        dest[destOffset + 0] = Math.fma(s, _self00, _self30 * _t0);
        dest[destOffset + 1] = Math.fma(s, _self10, _self30 * _t1);
        dest[destOffset + 2] = Math.fma(s, _self20, _self30 * _t2);
        dest[destOffset + 3] = _self30;
        dest[destOffset + 4] = Math.fma(s, _self01, _self31 * _t0);
        dest[destOffset + 5] = Math.fma(s, _self11, _self31 * _t1);
        dest[destOffset + 6] = Math.fma(s, _self21, _self31 * _t2);
        dest[destOffset + 7] = _self31;
        dest[destOffset + 8] = Math.fma(s, _self02, _self32 * _t0);
        dest[destOffset + 9] = Math.fma(s, _self12, _self32 * _t1);
        dest[destOffset + 10] = Math.fma(s, _self22, _self32 * _t2);
        dest[destOffset + 11] = _self32;
        dest[destOffset + 12] = Math.fma(s, _self03, _self33 * _t0);
        dest[destOffset + 13] = Math.fma(s, _self13, _self33 * _t1);
        dest[destOffset + 14] = Math.fma(s, _self23, _self33 * _t2);
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] preScaleAround_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] pivot, int pivotOffset, float s) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _pivotx = pivot[pivotOffset + 0];
        float _pivoty = pivot[pivotOffset + 1];
        float _pivotz = pivot[pivotOffset + 2];
        float _t0 = Math.fma(-s, _pivotx, _pivotx);
        float _t1 = Math.fma(-s, _pivoty, _pivoty);
        float _t2 = Math.fma(-s, _pivotz, _pivotz);
        dest[destOffset + 0] = Math.fma(s, _self00, _self30 * _t0);
        dest[destOffset + 1] = Math.fma(s, _self10, _self30 * _t1);
        dest[destOffset + 2] = Math.fma(s, _self20, _self30 * _t2);
        dest[destOffset + 3] = _self30;
        dest[destOffset + 4] = Math.fma(s, _self01, _self31 * _t0);
        dest[destOffset + 5] = Math.fma(s, _self11, _self31 * _t1);
        dest[destOffset + 6] = Math.fma(s, _self21, _self31 * _t2);
        dest[destOffset + 7] = _self31;
        dest[destOffset + 8] = Math.fma(s, _self02, _self32 * _t0);
        dest[destOffset + 9] = Math.fma(s, _self12, _self32 * _t1);
        dest[destOffset + 10] = Math.fma(s, _self22, _self32 * _t2);
        dest[destOffset + 11] = _self32;
        dest[destOffset + 12] = Math.fma(s, _self03, _self33 * _t0);
        dest[destOffset + 13] = Math.fma(s, _self13, _self33 * _t1);
        dest[destOffset + 14] = Math.fma(s, _self23, _self33 * _t2);
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] preTranslate_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float vX, float vY, float vZ) {
        for (int _l = 0; _l < 4; _l++) {
            int _lo = _l * 4;
            float _eself0 = src[srcOffset + _lo];
            float _eself1 = src[srcOffset + _lo + 1];
            float _eself2 = src[srcOffset + _lo + 2];
            float _eself3 = src[srcOffset + _lo + 3];
            dest[destOffset + _lo] = Math.fma(_eself3, vX, _eself0);
            dest[destOffset + _lo + 1] = Math.fma(_eself3, vY, _eself1);
            dest[destOffset + _lo + 2] = Math.fma(_eself3, vZ, _eself2);
            dest[destOffset + _lo + 3] = _eself3;
        }
        return dest;
    }

    public static float[] preTranslate_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] v, int vOffset) {
        float _vx = v[vOffset + 0];
        float _vy = v[vOffset + 1];
        float _vz = v[vOffset + 2];
        for (int _l = 0; _l < 4; _l++) {
            int _lo = _l * 4;
            float _eself0 = src[srcOffset + _lo];
            float _eself1 = src[srcOffset + _lo + 1];
            float _eself2 = src[srcOffset + _lo + 2];
            float _eself3 = src[srcOffset + _lo + 3];
            dest[destOffset + _lo] = Math.fma(_eself3, _vx, _eself0);
            dest[destOffset + _lo + 1] = Math.fma(_eself3, _vy, _eself1);
            dest[destOffset + _lo + 2] = Math.fma(_eself3, _vz, _eself2);
            dest[destOffset + _lo + 3] = _eself3;
        }
        return dest;
    }

    public static float[] reflect_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float normalX, float normalY, float normalZ) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
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
        dest[destOffset + 0] = Math.fma(_t0, _t10, Math.fma(_self00, _t13, -(_self01 * _t11)));
        dest[destOffset + 1] = Math.fma(_t1, _t10, Math.fma(_self10, _t13, -(_self11 * _t11)));
        dest[destOffset + 2] = Math.fma(_t2, _t10, Math.fma(_self20, _t13, -(_self21 * _t11)));
        dest[destOffset + 3] = Math.fma(_t3, _t10, Math.fma(_self30, _t13, -(_self31 * _t11)));
        dest[destOffset + 4] = Math.fma(_t0, _t12, Math.fma(_self01, _t14, -(_self00 * _t11)));
        dest[destOffset + 5] = Math.fma(_t1, _t12, Math.fma(_self11, _t14, -(_self10 * _t11)));
        dest[destOffset + 6] = Math.fma(_t2, _t12, Math.fma(_self21, _t14, -(_self20 * _t11)));
        dest[destOffset + 7] = Math.fma(_t3, _t12, Math.fma(_self31, _t14, -(_self30 * _t11)));
        dest[destOffset + 8] = Math.fma(_self02, _t15, Math.fma(-_self01, _t12, -(_self00 * _t10)));
        dest[destOffset + 9] = Math.fma(_self12, _t15, Math.fma(-_self11, _t12, -(_self10 * _t10)));
        dest[destOffset + 10] = Math.fma(_self22, _t15, Math.fma(-_self21, _t12, -(_self20 * _t10)));
        dest[destOffset + 11] = Math.fma(_self32, _t15, Math.fma(-_self31, _t12, -(_self30 * _t10)));
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] reflect_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] normal, int normalOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _normalx = normal[normalOffset + 0];
        float _normaly = normal[normalOffset + 1];
        float _normalz = normal[normalOffset + 2];
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
        dest[destOffset + 0] = Math.fma(_t0, _t10, Math.fma(_self00, _t13, -(_self01 * _t11)));
        dest[destOffset + 1] = Math.fma(_t1, _t10, Math.fma(_self10, _t13, -(_self11 * _t11)));
        dest[destOffset + 2] = Math.fma(_t2, _t10, Math.fma(_self20, _t13, -(_self21 * _t11)));
        dest[destOffset + 3] = Math.fma(_t3, _t10, Math.fma(_self30, _t13, -(_self31 * _t11)));
        dest[destOffset + 4] = Math.fma(_t0, _t12, Math.fma(_self01, _t14, -(_self00 * _t11)));
        dest[destOffset + 5] = Math.fma(_t1, _t12, Math.fma(_self11, _t14, -(_self10 * _t11)));
        dest[destOffset + 6] = Math.fma(_t2, _t12, Math.fma(_self21, _t14, -(_self20 * _t11)));
        dest[destOffset + 7] = Math.fma(_t3, _t12, Math.fma(_self31, _t14, -(_self30 * _t11)));
        dest[destOffset + 8] = Math.fma(_self02, _t15, Math.fma(-_self01, _t12, -(_self00 * _t10)));
        dest[destOffset + 9] = Math.fma(_self12, _t15, Math.fma(-_self11, _t12, -(_self10 * _t10)));
        dest[destOffset + 10] = Math.fma(_self22, _t15, Math.fma(-_self21, _t12, -(_self20 * _t10)));
        dest[destOffset + 11] = Math.fma(_self32, _t15, Math.fma(-_self31, _t12, -(_self30 * _t10)));
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] rotateAround_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float rotX, float rotY, float rotZ, float rotW, float pivotX, float pivotY, float pivotZ) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
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
        dest[destOffset + 0] = Math.fma(_self02, _t24, Math.fma(_self00, _t27, _self01 * _t21));
        dest[destOffset + 1] = Math.fma(_self12, _t24, Math.fma(_self10, _t27, _self11 * _t21));
        dest[destOffset + 2] = Math.fma(_self22, _t24, Math.fma(_self20, _t27, _self21 * _t21));
        dest[destOffset + 3] = Math.fma(_self32, _t24, Math.fma(_self30, _t27, _self31 * _t21));
        dest[destOffset + 4] = Math.fma(_self02, _t22, Math.fma(_self00, _t25, _self01 * _t28));
        dest[destOffset + 5] = Math.fma(_self12, _t22, Math.fma(_self10, _t25, _self11 * _t28));
        dest[destOffset + 6] = Math.fma(_self22, _t22, Math.fma(_self20, _t25, _self21 * _t28));
        dest[destOffset + 7] = Math.fma(_self32, _t22, Math.fma(_self30, _t25, _self31 * _t28));
        dest[destOffset + 8] = Math.fma(_self02, _t29, Math.fma(_self00, _t23, _self01 * _t26));
        dest[destOffset + 9] = Math.fma(_self12, _t29, Math.fma(_self10, _t23, _self11 * _t26));
        dest[destOffset + 10] = Math.fma(_self22, _t29, Math.fma(_self20, _t23, _self21 * _t26));
        dest[destOffset + 11] = Math.fma(_self32, _t29, Math.fma(_self30, _t23, _self31 * _t26));
        dest[destOffset + 12] = Math.fma(_self00, _t36, Math.fma(_self01, _t37, Math.fma(_self02, _t38, _self03)));
        dest[destOffset + 13] = Math.fma(_self10, _t36, Math.fma(_self11, _t37, Math.fma(_self12, _t38, _self13)));
        dest[destOffset + 14] = Math.fma(_self20, _t36, Math.fma(_self21, _t37, Math.fma(_self22, _t38, _self23)));
        dest[destOffset + 15] = Math.fma(_self30, _t36, Math.fma(_self31, _t37, Math.fma(_self32, _t38, _self33)));
        return dest;
    }

    public static float[] rotateAround_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] rot, int rotOffset, float[] pivot, int pivotOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _rotx = rot[rotOffset + 0];
        float _roty = rot[rotOffset + 1];
        float _rotz = rot[rotOffset + 2];
        float _rotw = rot[rotOffset + 3];
        float _pivotx = pivot[pivotOffset + 0];
        float _pivoty = pivot[pivotOffset + 1];
        float _pivotz = pivot[pivotOffset + 2];
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
        dest[destOffset + 0] = Math.fma(_self02, _t24, Math.fma(_self00, _t27, _self01 * _t21));
        dest[destOffset + 1] = Math.fma(_self12, _t24, Math.fma(_self10, _t27, _self11 * _t21));
        dest[destOffset + 2] = Math.fma(_self22, _t24, Math.fma(_self20, _t27, _self21 * _t21));
        dest[destOffset + 3] = Math.fma(_self32, _t24, Math.fma(_self30, _t27, _self31 * _t21));
        dest[destOffset + 4] = Math.fma(_self02, _t22, Math.fma(_self00, _t25, _self01 * _t28));
        dest[destOffset + 5] = Math.fma(_self12, _t22, Math.fma(_self10, _t25, _self11 * _t28));
        dest[destOffset + 6] = Math.fma(_self22, _t22, Math.fma(_self20, _t25, _self21 * _t28));
        dest[destOffset + 7] = Math.fma(_self32, _t22, Math.fma(_self30, _t25, _self31 * _t28));
        dest[destOffset + 8] = Math.fma(_self02, _t29, Math.fma(_self00, _t23, _self01 * _t26));
        dest[destOffset + 9] = Math.fma(_self12, _t29, Math.fma(_self10, _t23, _self11 * _t26));
        dest[destOffset + 10] = Math.fma(_self22, _t29, Math.fma(_self20, _t23, _self21 * _t26));
        dest[destOffset + 11] = Math.fma(_self32, _t29, Math.fma(_self30, _t23, _self31 * _t26));
        dest[destOffset + 12] = Math.fma(_self00, _t36, Math.fma(_self01, _t37, Math.fma(_self02, _t38, _self03)));
        dest[destOffset + 13] = Math.fma(_self10, _t36, Math.fma(_self11, _t37, Math.fma(_self12, _t38, _self13)));
        dest[destOffset + 14] = Math.fma(_self20, _t36, Math.fma(_self21, _t37, Math.fma(_self22, _t38, _self23)));
        dest[destOffset + 15] = Math.fma(_self30, _t36, Math.fma(_self31, _t37, Math.fma(_self32, _t38, _self33)));
        return dest;
    }

    public static float[] rotateAxis_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float angle, float axisX, float axisY, float axisZ) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
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
        dest[destOffset + 0] = Math.fma(_self02, _t24, Math.fma(_self00, _t18, _self01 * _t21));
        dest[destOffset + 1] = Math.fma(_self12, _t24, Math.fma(_self10, _t18, _self11 * _t21));
        dest[destOffset + 2] = Math.fma(_self22, _t24, Math.fma(_self20, _t18, _self21 * _t21));
        dest[destOffset + 3] = Math.fma(_self32, _t24, Math.fma(_self30, _t18, _self31 * _t21));
        dest[destOffset + 4] = Math.fma(_self02, _t22, Math.fma(_self00, _t25, _self01 * _t19));
        dest[destOffset + 5] = Math.fma(_self12, _t22, Math.fma(_self10, _t25, _self11 * _t19));
        dest[destOffset + 6] = Math.fma(_self22, _t22, Math.fma(_self20, _t25, _self21 * _t19));
        dest[destOffset + 7] = Math.fma(_self32, _t22, Math.fma(_self30, _t25, _self31 * _t19));
        dest[destOffset + 8] = Math.fma(_self02, _t20, Math.fma(_self00, _t23, _self01 * _t26));
        dest[destOffset + 9] = Math.fma(_self12, _t20, Math.fma(_self10, _t23, _self11 * _t26));
        dest[destOffset + 10] = Math.fma(_self22, _t20, Math.fma(_self20, _t23, _self21 * _t26));
        dest[destOffset + 11] = Math.fma(_self32, _t20, Math.fma(_self30, _t23, _self31 * _t26));
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] rotateAxis_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] axis, int axisOffset, float angle) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _axisx = axis[axisOffset + 0];
        float _axisy = axis[axisOffset + 1];
        float _axisz = axis[axisOffset + 2];
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
        dest[destOffset + 0] = Math.fma(_self02, _t24, Math.fma(_self00, _t18, _self01 * _t21));
        dest[destOffset + 1] = Math.fma(_self12, _t24, Math.fma(_self10, _t18, _self11 * _t21));
        dest[destOffset + 2] = Math.fma(_self22, _t24, Math.fma(_self20, _t18, _self21 * _t21));
        dest[destOffset + 3] = Math.fma(_self32, _t24, Math.fma(_self30, _t18, _self31 * _t21));
        dest[destOffset + 4] = Math.fma(_self02, _t22, Math.fma(_self00, _t25, _self01 * _t19));
        dest[destOffset + 5] = Math.fma(_self12, _t22, Math.fma(_self10, _t25, _self11 * _t19));
        dest[destOffset + 6] = Math.fma(_self22, _t22, Math.fma(_self20, _t25, _self21 * _t19));
        dest[destOffset + 7] = Math.fma(_self32, _t22, Math.fma(_self30, _t25, _self31 * _t19));
        dest[destOffset + 8] = Math.fma(_self02, _t20, Math.fma(_self00, _t23, _self01 * _t26));
        dest[destOffset + 9] = Math.fma(_self12, _t20, Math.fma(_self10, _t23, _self11 * _t26));
        dest[destOffset + 10] = Math.fma(_self22, _t20, Math.fma(_self20, _t23, _self21 * _t26));
        dest[destOffset + 11] = Math.fma(_self32, _t20, Math.fma(_self30, _t23, _self31 * _t26));
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] rotateQuat_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float qX, float qY, float qZ, float qW) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
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
        dest[destOffset + 0] = Math.fma(_self02, _t21, Math.fma(_self00, _t24, _self01 * _t18));
        dest[destOffset + 1] = Math.fma(_self12, _t21, Math.fma(_self10, _t24, _self11 * _t18));
        dest[destOffset + 2] = Math.fma(_self22, _t21, Math.fma(_self20, _t24, _self21 * _t18));
        dest[destOffset + 3] = Math.fma(_self32, _t21, Math.fma(_self30, _t24, _self31 * _t18));
        dest[destOffset + 4] = Math.fma(_self02, _t19, Math.fma(_self00, _t22, _self01 * _t25));
        dest[destOffset + 5] = Math.fma(_self12, _t19, Math.fma(_self10, _t22, _self11 * _t25));
        dest[destOffset + 6] = Math.fma(_self22, _t19, Math.fma(_self20, _t22, _self21 * _t25));
        dest[destOffset + 7] = Math.fma(_self32, _t19, Math.fma(_self30, _t22, _self31 * _t25));
        dest[destOffset + 8] = Math.fma(_self02, _t26, Math.fma(_self00, _t20, _self01 * _t23));
        dest[destOffset + 9] = Math.fma(_self12, _t26, Math.fma(_self10, _t20, _self11 * _t23));
        dest[destOffset + 10] = Math.fma(_self22, _t26, Math.fma(_self20, _t20, _self21 * _t23));
        dest[destOffset + 11] = Math.fma(_self32, _t26, Math.fma(_self30, _t20, _self31 * _t23));
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] rotateQuat_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] q, int qOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _qx = q[qOffset + 0];
        float _qy = q[qOffset + 1];
        float _qz = q[qOffset + 2];
        float _qw = q[qOffset + 3];
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
        dest[destOffset + 0] = Math.fma(_self02, _t21, Math.fma(_self00, _t24, _self01 * _t18));
        dest[destOffset + 1] = Math.fma(_self12, _t21, Math.fma(_self10, _t24, _self11 * _t18));
        dest[destOffset + 2] = Math.fma(_self22, _t21, Math.fma(_self20, _t24, _self21 * _t18));
        dest[destOffset + 3] = Math.fma(_self32, _t21, Math.fma(_self30, _t24, _self31 * _t18));
        dest[destOffset + 4] = Math.fma(_self02, _t19, Math.fma(_self00, _t22, _self01 * _t25));
        dest[destOffset + 5] = Math.fma(_self12, _t19, Math.fma(_self10, _t22, _self11 * _t25));
        dest[destOffset + 6] = Math.fma(_self22, _t19, Math.fma(_self20, _t22, _self21 * _t25));
        dest[destOffset + 7] = Math.fma(_self32, _t19, Math.fma(_self30, _t22, _self31 * _t25));
        dest[destOffset + 8] = Math.fma(_self02, _t26, Math.fma(_self00, _t20, _self01 * _t23));
        dest[destOffset + 9] = Math.fma(_self12, _t26, Math.fma(_self10, _t20, _self11 * _t23));
        dest[destOffset + 10] = Math.fma(_self22, _t26, Math.fma(_self20, _t20, _self21 * _t23));
        dest[destOffset + 11] = Math.fma(_self32, _t26, Math.fma(_self30, _t20, _self31 * _t23));
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] rotateX_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float angle) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        dest[destOffset + 0] = _self00;
        dest[destOffset + 1] = _self10;
        dest[destOffset + 2] = _self20;
        dest[destOffset + 3] = _self30;
        dest[destOffset + 4] = Math.fma(_self01, _t0, _self02 * _t1);
        dest[destOffset + 5] = Math.fma(_self11, _t0, _self12 * _t1);
        dest[destOffset + 6] = Math.fma(_self21, _t0, _self22 * _t1);
        dest[destOffset + 7] = Math.fma(_self31, _t0, _self32 * _t1);
        dest[destOffset + 8] = Math.fma(_self02, _t0, -(_self01 * _t1));
        dest[destOffset + 9] = Math.fma(_self12, _t0, -(_self11 * _t1));
        dest[destOffset + 10] = Math.fma(_self22, _t0, -(_self21 * _t1));
        dest[destOffset + 11] = Math.fma(_self32, _t0, -(_self31 * _t1));
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] rotateXYZ_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float angleX, float angleY, float angleZ) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
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
        dest[destOffset + 0] = Math.fma(_self02, _t20, Math.fma(_self00, _t7, _self01 * _t18));
        dest[destOffset + 1] = Math.fma(_self12, _t20, Math.fma(_self10, _t7, _self11 * _t18));
        dest[destOffset + 2] = Math.fma(_self22, _t20, Math.fma(_self20, _t7, _self21 * _t18));
        dest[destOffset + 3] = Math.fma(_self32, _t20, Math.fma(_self30, _t7, _self31 * _t18));
        dest[destOffset + 4] = Math.fma(_self02, _t19, Math.fma(_self01, _t21, -(_self00 * _t11)));
        dest[destOffset + 5] = Math.fma(_self12, _t19, Math.fma(_self11, _t21, -(_self10 * _t11)));
        dest[destOffset + 6] = Math.fma(_self22, _t19, Math.fma(_self21, _t21, -(_self20 * _t11)));
        dest[destOffset + 7] = Math.fma(_self32, _t19, Math.fma(_self31, _t21, -(_self30 * _t11)));
        dest[destOffset + 8] = Math.fma(_self02, _t12, Math.fma(_self00, _t2, -(_self01 * _t13)));
        dest[destOffset + 9] = Math.fma(_self12, _t12, Math.fma(_self10, _t2, -(_self11 * _t13)));
        dest[destOffset + 10] = Math.fma(_self22, _t12, Math.fma(_self20, _t2, -(_self21 * _t13)));
        dest[destOffset + 11] = Math.fma(_self32, _t12, Math.fma(_self30, _t2, -(_self31 * _t13)));
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] rotateXZY_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float angleX, float angleY, float angleZ) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
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
        dest[destOffset + 0] = Math.fma(_self02, _t20, Math.fma(_self00, _t8, _self01 * _t18));
        dest[destOffset + 1] = Math.fma(_self12, _t20, Math.fma(_self10, _t8, _self11 * _t18));
        dest[destOffset + 2] = Math.fma(_self22, _t20, Math.fma(_self20, _t8, _self21 * _t18));
        dest[destOffset + 3] = Math.fma(_self32, _t20, Math.fma(_self30, _t8, _self31 * _t18));
        dest[destOffset + 4] = Math.fma(_self02, _t11, Math.fma(_self01, _t12, -(_self00 * _t1)));
        dest[destOffset + 5] = Math.fma(_self12, _t11, Math.fma(_self11, _t12, -(_self10 * _t1)));
        dest[destOffset + 6] = Math.fma(_self22, _t11, Math.fma(_self21, _t12, -(_self20 * _t1)));
        dest[destOffset + 7] = Math.fma(_self32, _t11, Math.fma(_self31, _t12, -(_self30 * _t1)));
        dest[destOffset + 8] = Math.fma(_self02, _t19, Math.fma(_self00, _t14, _self01 * _t21));
        dest[destOffset + 9] = Math.fma(_self12, _t19, Math.fma(_self10, _t14, _self11 * _t21));
        dest[destOffset + 10] = Math.fma(_self22, _t19, Math.fma(_self20, _t14, _self21 * _t21));
        dest[destOffset + 11] = Math.fma(_self32, _t19, Math.fma(_self30, _t14, _self31 * _t21));
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] rotateY_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float angle) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        dest[destOffset + 0] = Math.fma(_self00, _t0, -(_self02 * _t1));
        dest[destOffset + 1] = Math.fma(_self10, _t0, -(_self12 * _t1));
        dest[destOffset + 2] = Math.fma(_self20, _t0, -(_self22 * _t1));
        dest[destOffset + 3] = Math.fma(_self30, _t0, -(_self32 * _t1));
        dest[destOffset + 4] = _self01;
        dest[destOffset + 5] = _self11;
        dest[destOffset + 6] = _self21;
        dest[destOffset + 7] = _self31;
        dest[destOffset + 8] = Math.fma(_self00, _t1, _self02 * _t0);
        dest[destOffset + 9] = Math.fma(_self10, _t1, _self12 * _t0);
        dest[destOffset + 10] = Math.fma(_self20, _t1, _self22 * _t0);
        dest[destOffset + 11] = Math.fma(_self30, _t1, _self32 * _t0);
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] rotateYXZ_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float angleX, float angleY, float angleZ) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
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
        dest[destOffset + 0] = Math.fma(_self02, _t20, Math.fma(_self00, _t18, _self01 * _t10));
        dest[destOffset + 1] = Math.fma(_self12, _t20, Math.fma(_self10, _t18, _self11 * _t10));
        dest[destOffset + 2] = Math.fma(_self22, _t20, Math.fma(_self20, _t18, _self21 * _t10));
        dest[destOffset + 3] = Math.fma(_self32, _t20, Math.fma(_self30, _t18, _self31 * _t10));
        dest[destOffset + 4] = Math.fma(_self02, _t19, Math.fma(_self00, _t21, _self01 * _t13));
        dest[destOffset + 5] = Math.fma(_self12, _t19, Math.fma(_self10, _t21, _self11 * _t13));
        dest[destOffset + 6] = Math.fma(_self22, _t19, Math.fma(_self20, _t21, _self21 * _t13));
        dest[destOffset + 7] = Math.fma(_self32, _t19, Math.fma(_self30, _t21, _self31 * _t13));
        dest[destOffset + 8] = Math.fma(_self02, _t14, Math.fma(_self00, _t15, -(_self01 * _t0)));
        dest[destOffset + 9] = Math.fma(_self12, _t14, Math.fma(_self10, _t15, -(_self11 * _t0)));
        dest[destOffset + 10] = Math.fma(_self22, _t14, Math.fma(_self20, _t15, -(_self21 * _t0)));
        dest[destOffset + 11] = Math.fma(_self32, _t14, Math.fma(_self30, _t15, -(_self31 * _t0)));
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] rotateYZX_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float angleX, float angleY, float angleZ) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
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
        dest[destOffset + 0] = Math.fma(-_self02, _t6, Math.fma(_self00, _t7, _self01 * _t3));
        dest[destOffset + 1] = Math.fma(-_self12, _t6, Math.fma(_self10, _t7, _self11 * _t3));
        dest[destOffset + 2] = Math.fma(-_self22, _t6, Math.fma(_self20, _t7, _self21 * _t3));
        dest[destOffset + 3] = Math.fma(-_self32, _t6, Math.fma(_self30, _t7, _self31 * _t3));
        dest[destOffset + 4] = Math.fma(_self02, _t18, Math.fma(_self00, _t20, _self01 * _t11));
        dest[destOffset + 5] = Math.fma(_self12, _t18, Math.fma(_self10, _t20, _self11 * _t11));
        dest[destOffset + 6] = Math.fma(_self22, _t18, Math.fma(_self20, _t20, _self21 * _t11));
        dest[destOffset + 7] = Math.fma(_self32, _t18, Math.fma(_self30, _t20, _self31 * _t11));
        dest[destOffset + 8] = Math.fma(_self02, _t21, Math.fma(_self00, _t19, -(_self01 * _t13)));
        dest[destOffset + 9] = Math.fma(_self12, _t21, Math.fma(_self10, _t19, -(_self11 * _t13)));
        dest[destOffset + 10] = Math.fma(_self22, _t21, Math.fma(_self20, _t19, -(_self21 * _t13)));
        dest[destOffset + 11] = Math.fma(_self32, _t21, Math.fma(_self30, _t19, -(_self31 * _t13)));
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] rotateZ_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float angle) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        dest[destOffset + 0] = Math.fma(_self00, _t0, _self01 * _t1);
        dest[destOffset + 1] = Math.fma(_self10, _t0, _self11 * _t1);
        dest[destOffset + 2] = Math.fma(_self20, _t0, _self21 * _t1);
        dest[destOffset + 3] = Math.fma(_self30, _t0, _self31 * _t1);
        dest[destOffset + 4] = Math.fma(_self01, _t0, -(_self00 * _t1));
        dest[destOffset + 5] = Math.fma(_self11, _t0, -(_self10 * _t1));
        dest[destOffset + 6] = Math.fma(_self21, _t0, -(_self20 * _t1));
        dest[destOffset + 7] = Math.fma(_self31, _t0, -(_self30 * _t1));
        dest[destOffset + 8] = _self02;
        dest[destOffset + 9] = _self12;
        dest[destOffset + 10] = _self22;
        dest[destOffset + 11] = _self32;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] rotateZXY_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float angleX, float angleY, float angleZ) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
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
        dest[destOffset + 0] = Math.fma(-_self02, _t6, Math.fma(_self00, _t20, _self01 * _t18));
        dest[destOffset + 1] = Math.fma(-_self12, _t6, Math.fma(_self10, _t20, _self11 * _t18));
        dest[destOffset + 2] = Math.fma(-_self22, _t6, Math.fma(_self20, _t20, _self21 * _t18));
        dest[destOffset + 3] = Math.fma(-_self32, _t6, Math.fma(_self30, _t20, _self31 * _t18));
        dest[destOffset + 4] = Math.fma(_self02, _t4, Math.fma(_self01, _t10, -(_self00 * _t11)));
        dest[destOffset + 5] = Math.fma(_self12, _t4, Math.fma(_self11, _t10, -(_self10 * _t11)));
        dest[destOffset + 6] = Math.fma(_self22, _t4, Math.fma(_self21, _t10, -(_self20 * _t11)));
        dest[destOffset + 7] = Math.fma(_self32, _t4, Math.fma(_self31, _t10, -(_self30 * _t11)));
        dest[destOffset + 8] = Math.fma(_self02, _t12, Math.fma(_self00, _t19, _self01 * _t21));
        dest[destOffset + 9] = Math.fma(_self12, _t12, Math.fma(_self10, _t19, _self11 * _t21));
        dest[destOffset + 10] = Math.fma(_self22, _t12, Math.fma(_self20, _t19, _self21 * _t21));
        dest[destOffset + 11] = Math.fma(_self32, _t12, Math.fma(_self30, _t19, _self31 * _t21));
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] rotateZYX_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float angleX, float angleY, float angleZ) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
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
        dest[destOffset + 0] = Math.fma(-_self02, _t0, Math.fma(_self00, _t6, _self01 * _t7));
        dest[destOffset + 1] = Math.fma(-_self12, _t0, Math.fma(_self10, _t6, _self11 * _t7));
        dest[destOffset + 2] = Math.fma(-_self22, _t0, Math.fma(_self20, _t6, _self21 * _t7));
        dest[destOffset + 3] = Math.fma(-_self32, _t0, Math.fma(_self30, _t6, _self31 * _t7));
        dest[destOffset + 4] = Math.fma(_self02, _t8, Math.fma(_self00, _t20, _self01 * _t18));
        dest[destOffset + 5] = Math.fma(_self12, _t8, Math.fma(_self10, _t20, _self11 * _t18));
        dest[destOffset + 6] = Math.fma(_self22, _t8, Math.fma(_self20, _t20, _self21 * _t18));
        dest[destOffset + 7] = Math.fma(_self32, _t8, Math.fma(_self30, _t20, _self31 * _t18));
        dest[destOffset + 8] = Math.fma(_self02, _t13, Math.fma(_self00, _t19, _self01 * _t21));
        dest[destOffset + 9] = Math.fma(_self12, _t13, Math.fma(_self10, _t19, _self11 * _t21));
        dest[destOffset + 10] = Math.fma(_self22, _t13, Math.fma(_self20, _t19, _self21 * _t21));
        dest[destOffset + 11] = Math.fma(_self32, _t13, Math.fma(_self30, _t19, _self31 * _t21));
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] scale_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float vX, float vY, float vZ) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = _self00 * vX;
        dest[destOffset + 1] = _self10 * vX;
        dest[destOffset + 2] = _self20 * vX;
        dest[destOffset + 3] = _self30 * vX;
        dest[destOffset + 4] = _self01 * vY;
        dest[destOffset + 5] = _self11 * vY;
        dest[destOffset + 6] = _self21 * vY;
        dest[destOffset + 7] = _self31 * vY;
        dest[destOffset + 8] = _self02 * vZ;
        dest[destOffset + 9] = _self12 * vZ;
        dest[destOffset + 10] = _self22 * vZ;
        dest[destOffset + 11] = _self32 * vZ;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] scale_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] v, int vOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _vx = v[vOffset + 0];
        float _vy = v[vOffset + 1];
        float _vz = v[vOffset + 2];
        dest[destOffset + 0] = _self00 * _vx;
        dest[destOffset + 1] = _self10 * _vx;
        dest[destOffset + 2] = _self20 * _vx;
        dest[destOffset + 3] = _self30 * _vx;
        dest[destOffset + 4] = _self01 * _vy;
        dest[destOffset + 5] = _self11 * _vy;
        dest[destOffset + 6] = _self21 * _vy;
        dest[destOffset + 7] = _self31 * _vy;
        dest[destOffset + 8] = _self02 * _vz;
        dest[destOffset + 9] = _self12 * _vz;
        dest[destOffset + 10] = _self22 * _vz;
        dest[destOffset + 11] = _self32 * _vz;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] scale_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float s) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = s * _self00;
        dest[destOffset + 1] = s * _self10;
        dest[destOffset + 2] = s * _self20;
        dest[destOffset + 3] = s * _self30;
        dest[destOffset + 4] = s * _self01;
        dest[destOffset + 5] = s * _self11;
        dest[destOffset + 6] = s * _self21;
        dest[destOffset + 7] = s * _self31;
        dest[destOffset + 8] = s * _self02;
        dest[destOffset + 9] = s * _self12;
        dest[destOffset + 10] = s * _self22;
        dest[destOffset + 11] = s * _self32;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] scaleAround_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float s, float pivotX, float pivotY, float pivotZ) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = Math.fma(-s, pivotX, pivotX);
        float _t1 = Math.fma(-s, pivotY, pivotY);
        float _t2 = Math.fma(-s, pivotZ, pivotZ);
        dest[destOffset + 0] = s * _self00;
        dest[destOffset + 1] = s * _self10;
        dest[destOffset + 2] = s * _self20;
        dest[destOffset + 3] = s * _self30;
        dest[destOffset + 4] = s * _self01;
        dest[destOffset + 5] = s * _self11;
        dest[destOffset + 6] = s * _self21;
        dest[destOffset + 7] = s * _self31;
        dest[destOffset + 8] = s * _self02;
        dest[destOffset + 9] = s * _self12;
        dest[destOffset + 10] = s * _self22;
        dest[destOffset + 11] = s * _self32;
        dest[destOffset + 12] = Math.fma(_self00, _t0, Math.fma(_self01, _t1, Math.fma(_self02, _t2, _self03)));
        dest[destOffset + 13] = Math.fma(_self10, _t0, Math.fma(_self11, _t1, Math.fma(_self12, _t2, _self13)));
        dest[destOffset + 14] = Math.fma(_self20, _t0, Math.fma(_self21, _t1, Math.fma(_self22, _t2, _self23)));
        dest[destOffset + 15] = Math.fma(_self30, _t0, Math.fma(_self31, _t1, Math.fma(_self32, _t2, _self33)));
        return dest;
    }

    public static float[] scaleAround_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] pivot, int pivotOffset, float s) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _pivotx = pivot[pivotOffset + 0];
        float _pivoty = pivot[pivotOffset + 1];
        float _pivotz = pivot[pivotOffset + 2];
        float _t0 = Math.fma(-s, _pivotx, _pivotx);
        float _t1 = Math.fma(-s, _pivoty, _pivoty);
        float _t2 = Math.fma(-s, _pivotz, _pivotz);
        dest[destOffset + 0] = s * _self00;
        dest[destOffset + 1] = s * _self10;
        dest[destOffset + 2] = s * _self20;
        dest[destOffset + 3] = s * _self30;
        dest[destOffset + 4] = s * _self01;
        dest[destOffset + 5] = s * _self11;
        dest[destOffset + 6] = s * _self21;
        dest[destOffset + 7] = s * _self31;
        dest[destOffset + 8] = s * _self02;
        dest[destOffset + 9] = s * _self12;
        dest[destOffset + 10] = s * _self22;
        dest[destOffset + 11] = s * _self32;
        dest[destOffset + 12] = Math.fma(_self00, _t0, Math.fma(_self01, _t1, Math.fma(_self02, _t2, _self03)));
        dest[destOffset + 13] = Math.fma(_self10, _t0, Math.fma(_self11, _t1, Math.fma(_self12, _t2, _self13)));
        dest[destOffset + 14] = Math.fma(_self20, _t0, Math.fma(_self21, _t1, Math.fma(_self22, _t2, _self23)));
        dest[destOffset + 15] = Math.fma(_self30, _t0, Math.fma(_self31, _t1, Math.fma(_self32, _t2, _self33)));
        return dest;
    }

    public static float[] scaleAround_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float sX, float sY, float sZ, float pivotX, float pivotY, float pivotZ) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t3 = Math.fma(-pivotX, sX, pivotX);
        float _t4 = Math.fma(-pivotY, sY, pivotY);
        float _t5 = Math.fma(-pivotZ, sZ, pivotZ);
        dest[destOffset + 0] = sX * _self00;
        dest[destOffset + 1] = sX * _self10;
        dest[destOffset + 2] = sX * _self20;
        dest[destOffset + 3] = sX * _self30;
        dest[destOffset + 4] = sY * _self01;
        dest[destOffset + 5] = sY * _self11;
        dest[destOffset + 6] = sY * _self21;
        dest[destOffset + 7] = sY * _self31;
        dest[destOffset + 8] = sZ * _self02;
        dest[destOffset + 9] = sZ * _self12;
        dest[destOffset + 10] = sZ * _self22;
        dest[destOffset + 11] = sZ * _self32;
        dest[destOffset + 12] = Math.fma(_self00, _t3, Math.fma(_self01, _t4, Math.fma(_self02, _t5, _self03)));
        dest[destOffset + 13] = Math.fma(_self10, _t3, Math.fma(_self11, _t4, Math.fma(_self12, _t5, _self13)));
        dest[destOffset + 14] = Math.fma(_self20, _t3, Math.fma(_self21, _t4, Math.fma(_self22, _t5, _self23)));
        dest[destOffset + 15] = Math.fma(_self30, _t3, Math.fma(_self31, _t4, Math.fma(_self32, _t5, _self33)));
        return dest;
    }

    public static float[] scaleAround_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] s, int sOffset, float[] pivot, int pivotOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _sx = s[sOffset + 0];
        float _sy = s[sOffset + 1];
        float _sz = s[sOffset + 2];
        float _pivotx = pivot[pivotOffset + 0];
        float _pivoty = pivot[pivotOffset + 1];
        float _pivotz = pivot[pivotOffset + 2];
        float _t3 = Math.fma(-_pivotx, _sx, _pivotx);
        float _t4 = Math.fma(-_pivoty, _sy, _pivoty);
        float _t5 = Math.fma(-_pivotz, _sz, _pivotz);
        dest[destOffset + 0] = _sx * _self00;
        dest[destOffset + 1] = _sx * _self10;
        dest[destOffset + 2] = _sx * _self20;
        dest[destOffset + 3] = _sx * _self30;
        dest[destOffset + 4] = _sy * _self01;
        dest[destOffset + 5] = _sy * _self11;
        dest[destOffset + 6] = _sy * _self21;
        dest[destOffset + 7] = _sy * _self31;
        dest[destOffset + 8] = _sz * _self02;
        dest[destOffset + 9] = _sz * _self12;
        dest[destOffset + 10] = _sz * _self22;
        dest[destOffset + 11] = _sz * _self32;
        dest[destOffset + 12] = Math.fma(_self00, _t3, Math.fma(_self01, _t4, Math.fma(_self02, _t5, _self03)));
        dest[destOffset + 13] = Math.fma(_self10, _t3, Math.fma(_self11, _t4, Math.fma(_self12, _t5, _self13)));
        dest[destOffset + 14] = Math.fma(_self20, _t3, Math.fma(_self21, _t4, Math.fma(_self22, _t5, _self23)));
        dest[destOffset + 15] = Math.fma(_self30, _t3, Math.fma(_self31, _t4, Math.fma(_self32, _t5, _self33)));
        return dest;
    }

    public static float[] shadow_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float lightX, float lightY, float lightZ, float lightW, float planeX, float planeY, float planeZ, float planeW) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
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
        dest[destOffset + 0] = Math.fma(_t0, _t16, Math.fma(_t1, _t17, Math.fma(_self00, _t33, -(_self01 * _t20))));
        dest[destOffset + 1] = Math.fma(_t7, _t16, Math.fma(_t8, _t17, Math.fma(_self10, _t33, -(_self11 * _t20))));
        dest[destOffset + 2] = Math.fma(_t10, _t16, Math.fma(_t11, _t17, Math.fma(_self20, _t33, -(_self21 * _t20))));
        dest[destOffset + 3] = Math.fma(_t13, _t16, Math.fma(_t14, _t17, Math.fma(_self30, _t33, -(_self31 * _t20))));
        dest[destOffset + 4] = Math.fma(_t0, _t21, Math.fma(_t1, _t22, Math.fma(_self01, _t34, -(_self00 * _t23))));
        dest[destOffset + 5] = Math.fma(_t7, _t21, Math.fma(_t8, _t22, Math.fma(_self11, _t34, -(_self10 * _t23))));
        dest[destOffset + 6] = Math.fma(_t10, _t21, Math.fma(_t11, _t22, Math.fma(_self21, _t34, -(_self20 * _t23))));
        dest[destOffset + 7] = Math.fma(_t13, _t21, Math.fma(_t14, _t22, Math.fma(_self31, _t34, -(_self30 * _t23))));
        dest[destOffset + 8] = Math.fma(_t0, _t24, Math.fma(_self02, _t35, Math.fma(_t5, _t25, -(_self00 * _t26))));
        dest[destOffset + 9] = Math.fma(_t7, _t24, Math.fma(_self12, _t35, Math.fma(_t9, _t25, -(_self10 * _t26))));
        dest[destOffset + 10] = Math.fma(_t10, _t24, Math.fma(_self22, _t35, Math.fma(_t12, _t25, -(_self20 * _t26))));
        dest[destOffset + 11] = Math.fma(_t13, _t24, Math.fma(_self32, _t35, Math.fma(_t15, _t25, -(_self30 * _t26))));
        dest[destOffset + 12] = Math.fma(_self03, _t36, Math.fma(_t1, _t27, Math.fma(_t5, _t28, -(_self00 * _t29))));
        dest[destOffset + 13] = Math.fma(_self13, _t36, Math.fma(_t8, _t27, Math.fma(_t9, _t28, -(_self10 * _t29))));
        dest[destOffset + 14] = Math.fma(_self23, _t36, Math.fma(_t11, _t27, Math.fma(_t12, _t28, -(_self20 * _t29))));
        dest[destOffset + 15] = Math.fma(_self33, _t36, Math.fma(_t14, _t27, Math.fma(_t15, _t28, -(_self30 * _t29))));
        return dest;
    }

    public static float[] shadow_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] light, int lightOffset, float[] plane, int planeOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _lightx = light[lightOffset + 0];
        float _lighty = light[lightOffset + 1];
        float _lightz = light[lightOffset + 2];
        float _lightw = light[lightOffset + 3];
        float _planex = plane[planeOffset + 0];
        float _planey = plane[planeOffset + 1];
        float _planez = plane[planeOffset + 2];
        float _planew = plane[planeOffset + 3];
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
        dest[destOffset + 0] = Math.fma(_t0, _t16, Math.fma(_t1, _t17, Math.fma(_self00, _t33, -(_self01 * _t20))));
        dest[destOffset + 1] = Math.fma(_t7, _t16, Math.fma(_t8, _t17, Math.fma(_self10, _t33, -(_self11 * _t20))));
        dest[destOffset + 2] = Math.fma(_t10, _t16, Math.fma(_t11, _t17, Math.fma(_self20, _t33, -(_self21 * _t20))));
        dest[destOffset + 3] = Math.fma(_t13, _t16, Math.fma(_t14, _t17, Math.fma(_self30, _t33, -(_self31 * _t20))));
        dest[destOffset + 4] = Math.fma(_t0, _t21, Math.fma(_t1, _t22, Math.fma(_self01, _t34, -(_self00 * _t23))));
        dest[destOffset + 5] = Math.fma(_t7, _t21, Math.fma(_t8, _t22, Math.fma(_self11, _t34, -(_self10 * _t23))));
        dest[destOffset + 6] = Math.fma(_t10, _t21, Math.fma(_t11, _t22, Math.fma(_self21, _t34, -(_self20 * _t23))));
        dest[destOffset + 7] = Math.fma(_t13, _t21, Math.fma(_t14, _t22, Math.fma(_self31, _t34, -(_self30 * _t23))));
        dest[destOffset + 8] = Math.fma(_t0, _t24, Math.fma(_self02, _t35, Math.fma(_t5, _t25, -(_self00 * _t26))));
        dest[destOffset + 9] = Math.fma(_t7, _t24, Math.fma(_self12, _t35, Math.fma(_t9, _t25, -(_self10 * _t26))));
        dest[destOffset + 10] = Math.fma(_t10, _t24, Math.fma(_self22, _t35, Math.fma(_t12, _t25, -(_self20 * _t26))));
        dest[destOffset + 11] = Math.fma(_t13, _t24, Math.fma(_self32, _t35, Math.fma(_t15, _t25, -(_self30 * _t26))));
        dest[destOffset + 12] = Math.fma(_self03, _t36, Math.fma(_t1, _t27, Math.fma(_t5, _t28, -(_self00 * _t29))));
        dest[destOffset + 13] = Math.fma(_self13, _t36, Math.fma(_t8, _t27, Math.fma(_t9, _t28, -(_self10 * _t29))));
        dest[destOffset + 14] = Math.fma(_self23, _t36, Math.fma(_t11, _t27, Math.fma(_t12, _t28, -(_self20 * _t29))));
        dest[destOffset + 15] = Math.fma(_self33, _t36, Math.fma(_t14, _t27, Math.fma(_t15, _t28, -(_self30 * _t29))));
        return dest;
    }

    public static float[] shear_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float xy, float xz, float yx, float yz, float zx, float zy) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = Math.fma(yx, _self01, Math.fma(zx, _self02, _self00));
        dest[destOffset + 1] = Math.fma(yx, _self11, Math.fma(zx, _self12, _self10));
        dest[destOffset + 2] = Math.fma(yx, _self21, Math.fma(zx, _self22, _self20));
        dest[destOffset + 3] = Math.fma(yx, _self31, Math.fma(zx, _self32, _self30));
        dest[destOffset + 4] = Math.fma(xy, _self00, Math.fma(zy, _self02, _self01));
        dest[destOffset + 5] = Math.fma(xy, _self10, Math.fma(zy, _self12, _self11));
        dest[destOffset + 6] = Math.fma(xy, _self20, Math.fma(zy, _self22, _self21));
        dest[destOffset + 7] = Math.fma(xy, _self30, Math.fma(zy, _self32, _self31));
        dest[destOffset + 8] = Math.fma(xz, _self00, Math.fma(yz, _self01, _self02));
        dest[destOffset + 9] = Math.fma(xz, _self10, Math.fma(yz, _self11, _self12));
        dest[destOffset + 10] = Math.fma(xz, _self20, Math.fma(yz, _self21, _self22));
        dest[destOffset + 11] = Math.fma(xz, _self30, Math.fma(yz, _self31, _self32));
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _self23;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] tile_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float x, float y, float w, float h) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t2 = Math.fma(-2.0f, x, w - 1.0f);
        float _t3 = Math.fma(-2.0f, y, h - 1.0f);
        dest[destOffset + 0] = w * _self00;
        dest[destOffset + 1] = w * _self10;
        dest[destOffset + 2] = w * _self20;
        dest[destOffset + 3] = w * _self30;
        dest[destOffset + 4] = h * _self01;
        dest[destOffset + 5] = h * _self11;
        dest[destOffset + 6] = h * _self21;
        dest[destOffset + 7] = h * _self31;
        dest[destOffset + 8] = _self02;
        dest[destOffset + 9] = _self12;
        dest[destOffset + 10] = _self22;
        dest[destOffset + 11] = _self32;
        dest[destOffset + 12] = Math.fma(_self00, _t2, Math.fma(_self01, _t3, _self03));
        dest[destOffset + 13] = Math.fma(_self10, _t2, Math.fma(_self11, _t3, _self13));
        dest[destOffset + 14] = Math.fma(_self20, _t2, Math.fma(_self21, _t3, _self23));
        dest[destOffset + 15] = Math.fma(_self30, _t2, Math.fma(_self31, _t3, _self33));
        return dest;
    }

    public static float[] translate_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float vX, float vY, float vZ) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = _self00;
        dest[destOffset + 1] = _self10;
        dest[destOffset + 2] = _self20;
        dest[destOffset + 3] = _self30;
        dest[destOffset + 4] = _self01;
        dest[destOffset + 5] = _self11;
        dest[destOffset + 6] = _self21;
        dest[destOffset + 7] = _self31;
        dest[destOffset + 8] = _self02;
        dest[destOffset + 9] = _self12;
        dest[destOffset + 10] = _self22;
        dest[destOffset + 11] = _self32;
        dest[destOffset + 12] = Math.fma(_self00, vX, Math.fma(_self01, vY, Math.fma(_self02, vZ, _self03)));
        dest[destOffset + 13] = Math.fma(_self10, vX, Math.fma(_self11, vY, Math.fma(_self12, vZ, _self13)));
        dest[destOffset + 14] = Math.fma(_self20, vX, Math.fma(_self21, vY, Math.fma(_self22, vZ, _self23)));
        dest[destOffset + 15] = Math.fma(_self30, vX, Math.fma(_self31, vY, Math.fma(_self32, vZ, _self33)));
        return dest;
    }

    public static float[] translate_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] v, int vOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _vx = v[vOffset + 0];
        float _vy = v[vOffset + 1];
        float _vz = v[vOffset + 2];
        dest[destOffset + 0] = _self00;
        dest[destOffset + 1] = _self10;
        dest[destOffset + 2] = _self20;
        dest[destOffset + 3] = _self30;
        dest[destOffset + 4] = _self01;
        dest[destOffset + 5] = _self11;
        dest[destOffset + 6] = _self21;
        dest[destOffset + 7] = _self31;
        dest[destOffset + 8] = _self02;
        dest[destOffset + 9] = _self12;
        dest[destOffset + 10] = _self22;
        dest[destOffset + 11] = _self32;
        dest[destOffset + 12] = Math.fma(_self00, _vx, Math.fma(_self01, _vy, Math.fma(_self02, _vz, _self03)));
        dest[destOffset + 13] = Math.fma(_self10, _vx, Math.fma(_self11, _vy, Math.fma(_self12, _vz, _self13)));
        dest[destOffset + 14] = Math.fma(_self20, _vx, Math.fma(_self21, _vy, Math.fma(_self22, _vz, _self23)));
        dest[destOffset + 15] = Math.fma(_self30, _vx, Math.fma(_self31, _vy, Math.fma(_self32, _vz, _self33)));
        return dest;
    }

    public static float[] mulVec4_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float vX, float vY, float vZ, float vW) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        dest[destOffset + 0] = Math.fma(_self03, vW, Math.fma(_self02, vZ, Math.fma(_self00, vX, _self01 * vY)));
        dest[destOffset + 1] = Math.fma(_self13, vW, Math.fma(_self12, vZ, Math.fma(_self10, vX, _self11 * vY)));
        dest[destOffset + 2] = Math.fma(_self23, vW, Math.fma(_self22, vZ, Math.fma(_self20, vX, _self21 * vY)));
        dest[destOffset + 3] = Math.fma(_self33, vW, Math.fma(_self32, vZ, Math.fma(_self30, vX, _self31 * vY)));
        return dest;
    }

    public static float[] mulVec4_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] v, int vOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _vx = v[vOffset + 0];
        float _vy = v[vOffset + 1];
        float _vz = v[vOffset + 2];
        float _vw = v[vOffset + 3];
        dest[destOffset + 0] = Math.fma(_self03, _vw, Math.fma(_self02, _vz, Math.fma(_self00, _vx, _self01 * _vy)));
        dest[destOffset + 1] = Math.fma(_self13, _vw, Math.fma(_self12, _vz, Math.fma(_self10, _vx, _self11 * _vy)));
        dest[destOffset + 2] = Math.fma(_self23, _vw, Math.fma(_self22, _vz, Math.fma(_self20, _vx, _self21 * _vy)));
        dest[destOffset + 3] = Math.fma(_self33, _vw, Math.fma(_self32, _vz, Math.fma(_self30, _vx, _self31 * _vy)));
        return dest;
    }

}
