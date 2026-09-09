package org.joml2.internal.kernels;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.ops.*;
import org.joml2.internal.unsafe.*;
import org.joml2.internal.simd.*;

/**
 * Scalar/Unsafe kernel leaves of {@link Double3x4Ops} whose leading storage
 * parameter is a {@code double[]} array. Split into a sibling compilation unit purely
 * to keep generated sources IDE-sized; package-private, called only from
 * {@code Double3x4Ops} and its sibling kernel units. Not public API.
 */
public final class Double3x4OpsKernelsArray {
    private Double3x4OpsKernelsArray() {}

    public static double[] getNormalizedRotation_scalar(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
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
            dest[destOffset + 0] = 0.5 * _t36 * _t66;
            dest[destOffset + 1] = 0.5 * _t56 * _t66;
            dest[destOffset + 2] = 0.5 * _t57 * _t66;
            dest[destOffset + 3] = 0.5 * Math.sqrt(_t62);
        } else {
            if (_t49 > _t37) {
                dest[destOffset + 0] = 0.5 * Math.sqrt(_t63);
                dest[destOffset + 1] = 0.5 * _t53 * _t69;
                dest[destOffset + 2] = 0.5 * _t55 * _t69;
                dest[destOffset + 3] = 0.5 * _t36 * _t69;
            } else {
                if (_t23 > _t26) {
                    dest[destOffset + 0] = 0.5 * _t53 * _t67;
                    dest[destOffset + 1] = 0.5 * Math.sqrt(_t64);
                    dest[destOffset + 2] = 0.5 * _t39 * _t67;
                    dest[destOffset + 3] = 0.5 * _t56 * _t67;
                } else {
                    dest[destOffset + 0] = 0.5 * _t55 * _t68;
                    dest[destOffset + 1] = 0.5 * _t39 * _t68;
                    dest[destOffset + 2] = 0.5 * Math.sqrt(_t65);
                    dest[destOffset + 3] = 0.5 * _t57 * _t68;
                }
            }
        }
        return dest;
    }

    public static double[] getUnnormalizedRotation_scalar(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
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
            dest[destOffset + 0] = 0.5 * _t1 * _t18;
            dest[destOffset + 1] = 0.5 * _t7 * _t18;
            dest[destOffset + 2] = 0.5 * _t9 * _t18;
            dest[destOffset + 3] = 0.5 * Math.sqrt(_t14);
        } else {
            if (_self00 > _t2) {
                dest[destOffset + 0] = 0.5 * Math.sqrt(_t15);
                dest[destOffset + 1] = 0.5 * _t4 * _t21;
                dest[destOffset + 2] = 0.5 * _t6 * _t21;
                dest[destOffset + 3] = 0.5 * _t1 * _t21;
            } else {
                if (_self11 > _self22) {
                    dest[destOffset + 0] = 0.5 * _t4 * _t19;
                    dest[destOffset + 1] = 0.5 * Math.sqrt(_t16);
                    dest[destOffset + 2] = 0.5 * _t8 * _t19;
                    dest[destOffset + 3] = 0.5 * _t7 * _t19;
                } else {
                    dest[destOffset + 0] = 0.5 * _t6 * _t20;
                    dest[destOffset + 1] = 0.5 * _t8 * _t20;
                    dest[destOffset + 2] = 0.5 * Math.sqrt(_t17);
                    dest[destOffset + 3] = 0.5 * _t9 * _t20;
                }
            }
        }
        return dest;
    }

    public static double[] invert_scalar(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self03 = src[srcOffset + 3];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self13 = src[srcOffset + 7];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _self23 = src[srcOffset + 11];
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
        dest[destOffset + 0] = _t20 * _t33_inv;
        dest[destOffset + 1] = _t23 * _t33_inv;
        dest[destOffset + 2] = _t24 * _t33_inv;
        dest[destOffset + 3] = -(Math.fma(_self23, _t24, Math.fma(_self03, _t20, _self13 * _t23)) * _t33_inv);
        dest[destOffset + 4] = _t25 * _t33_inv;
        dest[destOffset + 5] = _t26 * _t33_inv;
        dest[destOffset + 6] = _t27 * _t33_inv;
        dest[destOffset + 7] = -(Math.fma(_self23, _t27, Math.fma(_self03, _t25, _self13 * _t26)) * _t33_inv);
        dest[destOffset + 8] = _t21 * _t33_inv;
        dest[destOffset + 9] = _t28 * _t33_inv;
        dest[destOffset + 10] = _t29 * _t33_inv;
        dest[destOffset + 11] = -(Math.fma(_self23, _t29, Math.fma(_self03, _t21, _self13 * _t28)) * _t33_inv);
        return dest;
    }

    public static double[] invertProduct_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self03 = src[srcOffset + 3];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self13 = src[srcOffset + 7];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _self23 = src[srcOffset + 11];
        double _other00 = other[otherOffset + 0];
        double _other01 = other[otherOffset + 1];
        double _other02 = other[otherOffset + 2];
        double _other03 = other[otherOffset + 3];
        double _other10 = other[otherOffset + 4];
        double _other11 = other[otherOffset + 5];
        double _other12 = other[otherOffset + 6];
        double _other13 = other[otherOffset + 7];
        double _other20 = other[otherOffset + 8];
        double _other21 = other[otherOffset + 9];
        double _other22 = other[otherOffset + 10];
        double _other23 = other[otherOffset + 11];
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
        dest[destOffset + 0] = _t56 * _t69_inv;
        dest[destOffset + 1] = _t59 * _t69_inv;
        dest[destOffset + 2] = _t60 * _t69_inv;
        dest[destOffset + 3] = -(Math.fma(_t33, _t60, Math.fma(_t34, _t56, _t35 * _t59)) * _t69_inv);
        dest[destOffset + 4] = _t61 * _t69_inv;
        dest[destOffset + 5] = _t62 * _t69_inv;
        dest[destOffset + 6] = _t63 * _t69_inv;
        dest[destOffset + 7] = -(Math.fma(_t33, _t63, Math.fma(_t34, _t61, _t35 * _t62)) * _t69_inv);
        dest[destOffset + 8] = _t57 * _t69_inv;
        dest[destOffset + 9] = _t64 * _t69_inv;
        dest[destOffset + 10] = _t65 * _t69_inv;
        dest[destOffset + 11] = -(Math.fma(_t33, _t65, Math.fma(_t34, _t57, _t35 * _t64)) * _t69_inv);
        return dest;
    }

    public static double[] transpose_scalar(double[] dest, int destOffset, double[] src, int srcOffset) {
        for (int _i = 0; _i < 12; _i++) {
            double _eself = src[srcOffset + _i];
            dest[destOffset + _i] = _eself;
        }
        return dest;
    }

    public static double[] add_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        for (int _i = 0; _i < 12; _i++) {
            double _eself = src[srcOffset + _i];
            double _eother = other[otherOffset + _i];
            dest[destOffset + _i] = _eother + _eself;
        }
        return dest;
    }

    public static double[] negate_scalar(double[] dest, int destOffset, double[] src, int srcOffset) {
        for (int _i = 0; _i < 12; _i++) {
            double _eself = src[srcOffset + _i];
            dest[destOffset + _i] = -_eself;
        }
        return dest;
    }

    public static double[] sub_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        for (int _i = 0; _i < 12; _i++) {
            double _eself = src[srcOffset + _i];
            double _eother = other[otherOffset + _i];
            dest[destOffset + _i] = _eself - _eother;
        }
        return dest;
    }

    public static double[] set_scalar(double[] dest, int destOffset, double[] v, int vOffset) {
        for (int _i = 0; _i < 12; _i++) {
            double _ev = v[vOffset + _i];
            dest[destOffset + _i] = _ev;
        }
        return dest;
    }

    public static double[] withTranslation_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double tX, double tY, double tZ) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        dest[destOffset + 0] = _self00;
        dest[destOffset + 1] = _self01;
        dest[destOffset + 2] = _self02;
        dest[destOffset + 3] = tX;
        dest[destOffset + 4] = _self10;
        dest[destOffset + 5] = _self11;
        dest[destOffset + 6] = _self12;
        dest[destOffset + 7] = tY;
        dest[destOffset + 8] = _self20;
        dest[destOffset + 9] = _self21;
        dest[destOffset + 10] = _self22;
        dest[destOffset + 11] = tZ;
        return dest;
    }

    public static double[] withTranslation_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double[] t, int tOffset) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _tx = t[tOffset + 0];
        double _ty = t[tOffset + 1];
        double _tz = t[tOffset + 2];
        dest[destOffset + 0] = _self00;
        dest[destOffset + 1] = _self01;
        dest[destOffset + 2] = _self02;
        dest[destOffset + 3] = _tx;
        dest[destOffset + 4] = _self10;
        dest[destOffset + 5] = _self11;
        dest[destOffset + 6] = _self12;
        dest[destOffset + 7] = _ty;
        dest[destOffset + 8] = _self20;
        dest[destOffset + 9] = _self21;
        dest[destOffset + 10] = _self22;
        dest[destOffset + 11] = _tz;
        return dest;
    }

    public static double[] makeFromTransform_scalar(double[] dest, int destOffset, double tTX, double tTY, double tTZ, double tRX, double tRY, double tRZ, double tRW, double tSX, double tSY, double tSZ) {
        double _t0 = tRZ * tRZ;
        double _t1 = tRZ * tRW;
        double _t2 = tRY * tRW;
        dest[destOffset + 0] = tSX * Math.fma(-2.0, Math.fma(tRY, tRY, _t0), 1.0);
        dest[destOffset + 1] = tSY * 2.0 * Math.fma(tRX, tRY, -_t1);
        dest[destOffset + 2] = tSZ * 2.0 * Math.fma(tRX, tRZ, _t2);
        dest[destOffset + 3] = tTX;
        dest[destOffset + 4] = tSX * 2.0 * Math.fma(tRX, tRY, _t1);
        dest[destOffset + 5] = tSY * Math.fma(-2.0, Math.fma(tRX, tRX, _t0), 1.0);
        dest[destOffset + 6] = tSZ * 2.0 * Math.fma(tRY, tRZ, -(tRX * tRW));
        dest[destOffset + 7] = tTY;
        dest[destOffset + 8] = tSX * 2.0 * Math.fma(tRX, tRZ, -_t2);
        dest[destOffset + 9] = tSY * 2.0 * Math.fma(tRX, tRW, tRY * tRZ);
        dest[destOffset + 10] = tSZ * Math.fma(-2.0, Math.fma(tRX, tRX, tRY * tRY), 1.0);
        dest[destOffset + 11] = tTZ;
        return dest;
    }

    public static double[] decomposeRotation_scalar(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
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
            dest[destOffset + 0] = 0.5 * _t60 * _t90;
            dest[destOffset + 1] = 0.5 * _t81 * _t90;
            dest[destOffset + 2] = 0.5 * _t78 * _t90;
            dest[destOffset + 3] = 0.5 * Math.sqrt(_t86);
        } else {
            if (_t73 > _t61) {
                dest[destOffset + 0] = 0.5 * Math.sqrt(_t87);
                dest[destOffset + 1] = 0.5 * _t77 * _t93;
                dest[destOffset + 2] = 0.5 * _t80 * _t93;
                dest[destOffset + 3] = 0.5 * _t60 * _t93;
            } else {
                if (_t36 > _t56) {
                    dest[destOffset + 0] = 0.5 * _t77 * _t91;
                    dest[destOffset + 1] = 0.5 * Math.sqrt(_t88);
                    dest[destOffset + 2] = 0.5 * _t63 * _t91;
                    dest[destOffset + 3] = 0.5 * _t81 * _t91;
                } else {
                    dest[destOffset + 0] = 0.5 * _t80 * _t92;
                    dest[destOffset + 1] = 0.5 * _t63 * _t92;
                    dest[destOffset + 2] = 0.5 * Math.sqrt(_t89);
                    dest[destOffset + 3] = 0.5 * _t78 * _t92;
                }
            }
        }
        return dest;
    }

    public static double[] lerp_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset, double t) {
        for (int _i = 0; _i < 12; _i++) {
            double _eself = src[srcOffset + _i];
            double _eother = other[otherOffset + _i];
            dest[destOffset + _i] = Math.fma(t, _eother - _eself, _eself);
        }
        return dest;
    }

    public static double[] mul_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double[] right, int rightOffset) {
        double _right00 = right[rightOffset + 0];
        double _right01 = right[rightOffset + 1];
        double _right02 = right[rightOffset + 2];
        double _right03 = right[rightOffset + 3];
        double _right10 = right[rightOffset + 4];
        double _right11 = right[rightOffset + 5];
        double _right12 = right[rightOffset + 6];
        double _right13 = right[rightOffset + 7];
        double _right20 = right[rightOffset + 8];
        double _right21 = right[rightOffset + 9];
        double _right22 = right[rightOffset + 10];
        double _right23 = right[rightOffset + 11];
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src[srcOffset + _lo];
            double _eself1 = src[srcOffset + _lo + 1];
            double _eself2 = src[srcOffset + _lo + 2];
            double _eself3 = src[srcOffset + _lo + 3];
            dest[destOffset + _lo] = Math.fma(_right20, _eself2, Math.fma(_right00, _eself0, _right10 * _eself1));
            dest[destOffset + _lo + 1] = Math.fma(_right21, _eself2, Math.fma(_right01, _eself0, _right11 * _eself1));
            dest[destOffset + _lo + 2] = Math.fma(_right22, _eself2, Math.fma(_right02, _eself0, _right12 * _eself1));
            dest[destOffset + _lo + 3] = Math.fma(_right03, _eself0, Math.fma(_right13, _eself1, Math.fma(_right23, _eself2, _eself3)));
        }
        return dest;
    }

    public static double[] mulMat2x3_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double[] right, int rightOffset) {
        double _right00 = right[rightOffset + 0];
        double _right10 = right[rightOffset + 1];
        double _right01 = right[rightOffset + 2];
        double _right11 = right[rightOffset + 3];
        double _right02 = right[rightOffset + 4];
        double _right12 = right[rightOffset + 5];
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src[srcOffset + _lo];
            double _eself1 = src[srcOffset + _lo + 1];
            double _eself2 = src[srcOffset + _lo + 2];
            double _eself3 = src[srcOffset + _lo + 3];
            dest[destOffset + _lo] = Math.fma(_right00, _eself0, _right10 * _eself1);
            dest[destOffset + _lo + 1] = Math.fma(_right01, _eself0, _right11 * _eself1);
            dest[destOffset + _lo + 2] = Math.fma(_right02, _eself0, Math.fma(_right12, _eself1, _eself2));
            dest[destOffset + _lo + 3] = _eself3;
        }
        return dest;
    }

    public static double[] preMul_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self03 = src[srcOffset + 3];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self13 = src[srcOffset + 7];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _self23 = src[srcOffset + 11];
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eother0 = other[otherOffset + _lo];
            double _eother1 = other[otherOffset + _lo + 1];
            double _eother2 = other[otherOffset + _lo + 2];
            double _eother3 = other[otherOffset + _lo + 3];
            dest[destOffset + _lo] = Math.fma(_eother2, _self20, Math.fma(_eother0, _self00, _eother1 * _self10));
            dest[destOffset + _lo + 1] = Math.fma(_eother2, _self21, Math.fma(_eother0, _self01, _eother1 * _self11));
            dest[destOffset + _lo + 2] = Math.fma(_eother2, _self22, Math.fma(_eother0, _self02, _eother1 * _self12));
            dest[destOffset + _lo + 3] = Math.fma(_eother0, _self03, Math.fma(_eother1, _self13, Math.fma(_eother2, _self23, _eother3)));
        }
        return dest;
    }

    public static double[] preMulMat2x2_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self03 = src[srcOffset + 3];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self13 = src[srcOffset + 7];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _self23 = src[srcOffset + 11];
        double _other00 = other[otherOffset + 0];
        double _other10 = other[otherOffset + 1];
        double _other01 = other[otherOffset + 2];
        double _other11 = other[otherOffset + 3];
        dest[destOffset + 0] = Math.fma(_other00, _self00, _other01 * _self10);
        dest[destOffset + 1] = Math.fma(_other00, _self01, _other01 * _self11);
        dest[destOffset + 2] = Math.fma(_other00, _self02, _other01 * _self12);
        dest[destOffset + 3] = Math.fma(_other00, _self03, _other01 * _self13);
        dest[destOffset + 4] = Math.fma(_other10, _self00, _other11 * _self10);
        dest[destOffset + 5] = Math.fma(_other10, _self01, _other11 * _self11);
        dest[destOffset + 6] = Math.fma(_other10, _self02, _other11 * _self12);
        dest[destOffset + 7] = Math.fma(_other10, _self03, _other11 * _self13);
        dest[destOffset + 8] = _self20;
        dest[destOffset + 9] = _self21;
        dest[destOffset + 10] = _self22;
        dest[destOffset + 11] = _self23;
        return dest;
    }

    public static double[] preMulMat2x3_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self03 = src[srcOffset + 3];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self13 = src[srcOffset + 7];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _self23 = src[srcOffset + 11];
        double _other00 = other[otherOffset + 0];
        double _other10 = other[otherOffset + 1];
        double _other01 = other[otherOffset + 2];
        double _other11 = other[otherOffset + 3];
        double _other02 = other[otherOffset + 4];
        double _other12 = other[otherOffset + 5];
        dest[destOffset + 0] = Math.fma(_other02, _self20, Math.fma(_other00, _self00, _other01 * _self10));
        dest[destOffset + 1] = Math.fma(_other02, _self21, Math.fma(_other00, _self01, _other01 * _self11));
        dest[destOffset + 2] = Math.fma(_other02, _self22, Math.fma(_other00, _self02, _other01 * _self12));
        dest[destOffset + 3] = Math.fma(_other02, _self23, Math.fma(_other00, _self03, _other01 * _self13));
        dest[destOffset + 4] = Math.fma(_other12, _self20, Math.fma(_other10, _self00, _other11 * _self10));
        dest[destOffset + 5] = Math.fma(_other12, _self21, Math.fma(_other10, _self01, _other11 * _self11));
        dest[destOffset + 6] = Math.fma(_other12, _self22, Math.fma(_other10, _self02, _other11 * _self12));
        dest[destOffset + 7] = Math.fma(_other12, _self23, Math.fma(_other10, _self03, _other11 * _self13));
        dest[destOffset + 8] = _self20;
        dest[destOffset + 9] = _self21;
        dest[destOffset + 10] = _self22;
        dest[destOffset + 11] = _self23;
        return dest;
    }

    public static double[] preMulMat3x3_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self03 = src[srcOffset + 3];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self13 = src[srcOffset + 7];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _self23 = src[srcOffset + 11];
        double _other00 = other[otherOffset + 0];
        double _other10 = other[otherOffset + 1];
        double _other20 = other[otherOffset + 2];
        double _other01 = other[otherOffset + 3];
        double _other11 = other[otherOffset + 4];
        double _other21 = other[otherOffset + 5];
        double _other02 = other[otherOffset + 6];
        double _other12 = other[otherOffset + 7];
        double _other22 = other[otherOffset + 8];
        dest[destOffset + 0] = Math.fma(_other02, _self20, Math.fma(_other00, _self00, _other01 * _self10));
        dest[destOffset + 1] = Math.fma(_other02, _self21, Math.fma(_other00, _self01, _other01 * _self11));
        dest[destOffset + 2] = Math.fma(_other02, _self22, Math.fma(_other00, _self02, _other01 * _self12));
        dest[destOffset + 3] = Math.fma(_other02, _self23, Math.fma(_other00, _self03, _other01 * _self13));
        dest[destOffset + 4] = Math.fma(_other12, _self20, Math.fma(_other10, _self00, _other11 * _self10));
        dest[destOffset + 5] = Math.fma(_other12, _self21, Math.fma(_other10, _self01, _other11 * _self11));
        dest[destOffset + 6] = Math.fma(_other12, _self22, Math.fma(_other10, _self02, _other11 * _self12));
        dest[destOffset + 7] = Math.fma(_other12, _self23, Math.fma(_other10, _self03, _other11 * _self13));
        dest[destOffset + 8] = Math.fma(_other22, _self20, Math.fma(_other20, _self00, _other21 * _self10));
        dest[destOffset + 9] = Math.fma(_other22, _self21, Math.fma(_other20, _self01, _other21 * _self11));
        dest[destOffset + 10] = Math.fma(_other22, _self22, Math.fma(_other20, _self02, _other21 * _self12));
        dest[destOffset + 11] = Math.fma(_other22, _self23, Math.fma(_other20, _self03, _other21 * _self13));
        return dest;
    }

    public static double[] preMulMat4x4_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self03 = src[srcOffset + 3];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self13 = src[srcOffset + 7];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _self23 = src[srcOffset + 11];
        double _other00 = other[otherOffset + 0];
        double _other10 = other[otherOffset + 1];
        double _other20 = other[otherOffset + 2];
        double _other30 = other[otherOffset + 3];
        double _other01 = other[otherOffset + 4];
        double _other11 = other[otherOffset + 5];
        double _other21 = other[otherOffset + 6];
        double _other31 = other[otherOffset + 7];
        double _other02 = other[otherOffset + 8];
        double _other12 = other[otherOffset + 9];
        double _other22 = other[otherOffset + 10];
        double _other32 = other[otherOffset + 11];
        double _other03 = other[otherOffset + 12];
        double _other13 = other[otherOffset + 13];
        double _other23 = other[otherOffset + 14];
        double _other33 = other[otherOffset + 15];
        dest[destOffset + 0] = Math.fma(_other02, _self20, Math.fma(_other00, _self00, _other01 * _self10));
        dest[destOffset + 1] = Math.fma(_other12, _self20, Math.fma(_other10, _self00, _other11 * _self10));
        dest[destOffset + 2] = Math.fma(_other22, _self20, Math.fma(_other20, _self00, _other21 * _self10));
        dest[destOffset + 3] = Math.fma(_other32, _self20, Math.fma(_other30, _self00, _other31 * _self10));
        dest[destOffset + 4] = Math.fma(_other02, _self21, Math.fma(_other00, _self01, _other01 * _self11));
        dest[destOffset + 5] = Math.fma(_other12, _self21, Math.fma(_other10, _self01, _other11 * _self11));
        dest[destOffset + 6] = Math.fma(_other22, _self21, Math.fma(_other20, _self01, _other21 * _self11));
        dest[destOffset + 7] = Math.fma(_other32, _self21, Math.fma(_other30, _self01, _other31 * _self11));
        dest[destOffset + 8] = Math.fma(_other02, _self22, Math.fma(_other00, _self02, _other01 * _self12));
        dest[destOffset + 9] = Math.fma(_other12, _self22, Math.fma(_other10, _self02, _other11 * _self12));
        dest[destOffset + 10] = Math.fma(_other22, _self22, Math.fma(_other20, _self02, _other21 * _self12));
        dest[destOffset + 11] = Math.fma(_other32, _self22, Math.fma(_other30, _self02, _other31 * _self12));
        dest[destOffset + 12] = Math.fma(_other00, _self03, Math.fma(_other01, _self13, Math.fma(_other02, _self23, _other03)));
        dest[destOffset + 13] = Math.fma(_other10, _self03, Math.fma(_other11, _self13, Math.fma(_other12, _self23, _other13)));
        dest[destOffset + 14] = Math.fma(_other20, _self03, Math.fma(_other21, _self13, Math.fma(_other22, _self23, _other23)));
        dest[destOffset + 15] = Math.fma(_other30, _self03, Math.fma(_other31, _self13, Math.fma(_other32, _self23, _other33)));
        return dest;
    }

    public static double[] composeTRS_scalar(double[] dest, int destOffset, double translationX, double translationY, double translationZ, double rotationX, double rotationY, double rotationZ, double rotationW, double scaleX, double scaleY, double scaleZ) {
        double _t0 = rotationZ * rotationZ;
        double _t1 = rotationZ * rotationW;
        double _t2 = rotationY * rotationW;
        dest[destOffset + 0] = scaleX * Math.fma(-2.0, Math.fma(rotationY, rotationY, _t0), 1.0);
        dest[destOffset + 1] = scaleY * 2.0 * Math.fma(rotationX, rotationY, -_t1);
        dest[destOffset + 2] = scaleZ * 2.0 * Math.fma(rotationX, rotationZ, _t2);
        dest[destOffset + 3] = translationX;
        dest[destOffset + 4] = scaleX * 2.0 * Math.fma(rotationX, rotationY, _t1);
        dest[destOffset + 5] = scaleY * Math.fma(-2.0, Math.fma(rotationX, rotationX, _t0), 1.0);
        dest[destOffset + 6] = scaleZ * 2.0 * Math.fma(rotationY, rotationZ, -(rotationX * rotationW));
        dest[destOffset + 7] = translationY;
        dest[destOffset + 8] = scaleX * 2.0 * Math.fma(rotationX, rotationZ, -_t2);
        dest[destOffset + 9] = scaleY * 2.0 * Math.fma(rotationX, rotationW, rotationY * rotationZ);
        dest[destOffset + 10] = scaleZ * Math.fma(-2.0, Math.fma(rotationX, rotationX, rotationY * rotationY), 1.0);
        dest[destOffset + 11] = translationZ;
        return dest;
    }

    public static double[] composeTRS_scalar(double[] dest, int destOffset, double[] translation, int translationOffset, double[] rotation, int rotationOffset, double[] scale, int scaleOffset) {
        double _translationx = translation[translationOffset + 0];
        double _translationy = translation[translationOffset + 1];
        double _translationz = translation[translationOffset + 2];
        double _rotationx = rotation[rotationOffset + 0];
        double _rotationy = rotation[rotationOffset + 1];
        double _rotationz = rotation[rotationOffset + 2];
        double _rotationw = rotation[rotationOffset + 3];
        double _scalex = scale[scaleOffset + 0];
        double _scaley = scale[scaleOffset + 1];
        double _scalez = scale[scaleOffset + 2];
        double _t0 = _rotationz * _rotationz;
        double _t1 = _rotationz * _rotationw;
        double _t2 = _rotationy * _rotationw;
        dest[destOffset + 0] = _scalex * Math.fma(-2.0, Math.fma(_rotationy, _rotationy, _t0), 1.0);
        dest[destOffset + 1] = _scaley * 2.0 * Math.fma(_rotationx, _rotationy, -_t1);
        dest[destOffset + 2] = _scalez * 2.0 * Math.fma(_rotationx, _rotationz, _t2);
        dest[destOffset + 3] = _translationx;
        dest[destOffset + 4] = _scalex * 2.0 * Math.fma(_rotationx, _rotationy, _t1);
        dest[destOffset + 5] = _scaley * Math.fma(-2.0, Math.fma(_rotationx, _rotationx, _t0), 1.0);
        dest[destOffset + 6] = _scalez * 2.0 * Math.fma(_rotationy, _rotationz, -(_rotationx * _rotationw));
        dest[destOffset + 7] = _translationy;
        dest[destOffset + 8] = _scalex * 2.0 * Math.fma(_rotationx, _rotationz, -_t2);
        dest[destOffset + 9] = _scaley * 2.0 * Math.fma(_rotationx, _rotationw, _rotationy * _rotationz);
        dest[destOffset + 10] = _scalez * Math.fma(-2.0, Math.fma(_rotationx, _rotationx, _rotationy * _rotationy), 1.0);
        dest[destOffset + 11] = _translationz;
        return dest;
    }

    public static double[] composeTRSMul_scalar(double[] dest, int destOffset, double[] m, int mOffset, double translationX, double translationY, double translationZ, double rotationX, double rotationY, double rotationZ, double rotationW, double scaleX, double scaleY, double scaleZ) {
        double _m00 = m[mOffset + 0];
        double _m01 = m[mOffset + 1];
        double _m02 = m[mOffset + 2];
        double _m03 = m[mOffset + 3];
        double _m10 = m[mOffset + 4];
        double _m11 = m[mOffset + 5];
        double _m12 = m[mOffset + 6];
        double _m13 = m[mOffset + 7];
        double _m20 = m[mOffset + 8];
        double _m21 = m[mOffset + 9];
        double _m22 = m[mOffset + 10];
        double _m23 = m[mOffset + 11];
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
        dest[destOffset + 0] = Math.fma(_m20, _t27, Math.fma(_m00, _t33, _m10 * _t30));
        dest[destOffset + 1] = Math.fma(_m21, _t27, Math.fma(_m01, _t33, _m11 * _t30));
        dest[destOffset + 2] = Math.fma(_m22, _t27, Math.fma(_m02, _t33, _m12 * _t30));
        dest[destOffset + 3] = Math.fma(_m03, _t33, Math.fma(_m13, _t30, Math.fma(_m23, _t27, translationX)));
        dest[destOffset + 4] = Math.fma(_m20, _t31, Math.fma(_m00, _t28, _m10 * _t34));
        dest[destOffset + 5] = Math.fma(_m21, _t31, Math.fma(_m01, _t28, _m11 * _t34));
        dest[destOffset + 6] = Math.fma(_m22, _t31, Math.fma(_m02, _t28, _m12 * _t34));
        dest[destOffset + 7] = Math.fma(_m03, _t28, Math.fma(_m13, _t34, Math.fma(_m23, _t31, translationY)));
        dest[destOffset + 8] = Math.fma(_m20, _t35, Math.fma(_m00, _t32, _m10 * _t29));
        dest[destOffset + 9] = Math.fma(_m21, _t35, Math.fma(_m01, _t32, _m11 * _t29));
        dest[destOffset + 10] = Math.fma(_m22, _t35, Math.fma(_m02, _t32, _m12 * _t29));
        dest[destOffset + 11] = Math.fma(_m03, _t32, Math.fma(_m13, _t29, Math.fma(_m23, _t35, translationZ)));
        return dest;
    }

    public static double[] composeTRSMul_scalar(double[] dest, int destOffset, double[] translation, int translationOffset, double[] rotation, int rotationOffset, double[] scale, int scaleOffset, double[] m, int mOffset) {
        double _translationx = translation[translationOffset + 0];
        double _translationy = translation[translationOffset + 1];
        double _translationz = translation[translationOffset + 2];
        double _rotationx = rotation[rotationOffset + 0];
        double _rotationy = rotation[rotationOffset + 1];
        double _rotationz = rotation[rotationOffset + 2];
        double _rotationw = rotation[rotationOffset + 3];
        double _scalex = scale[scaleOffset + 0];
        double _scaley = scale[scaleOffset + 1];
        double _scalez = scale[scaleOffset + 2];
        double _m00 = m[mOffset + 0];
        double _m01 = m[mOffset + 1];
        double _m02 = m[mOffset + 2];
        double _m03 = m[mOffset + 3];
        double _m10 = m[mOffset + 4];
        double _m11 = m[mOffset + 5];
        double _m12 = m[mOffset + 6];
        double _m13 = m[mOffset + 7];
        double _m20 = m[mOffset + 8];
        double _m21 = m[mOffset + 9];
        double _m22 = m[mOffset + 10];
        double _m23 = m[mOffset + 11];
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
        dest[destOffset + 0] = Math.fma(_m20, _t27, Math.fma(_m00, _t33, _m10 * _t30));
        dest[destOffset + 1] = Math.fma(_m21, _t27, Math.fma(_m01, _t33, _m11 * _t30));
        dest[destOffset + 2] = Math.fma(_m22, _t27, Math.fma(_m02, _t33, _m12 * _t30));
        dest[destOffset + 3] = Math.fma(_m03, _t33, Math.fma(_m13, _t30, Math.fma(_m23, _t27, _translationx)));
        dest[destOffset + 4] = Math.fma(_m20, _t31, Math.fma(_m00, _t28, _m10 * _t34));
        dest[destOffset + 5] = Math.fma(_m21, _t31, Math.fma(_m01, _t28, _m11 * _t34));
        dest[destOffset + 6] = Math.fma(_m22, _t31, Math.fma(_m02, _t28, _m12 * _t34));
        dest[destOffset + 7] = Math.fma(_m03, _t28, Math.fma(_m13, _t34, Math.fma(_m23, _t31, _translationy)));
        dest[destOffset + 8] = Math.fma(_m20, _t35, Math.fma(_m00, _t32, _m10 * _t29));
        dest[destOffset + 9] = Math.fma(_m21, _t35, Math.fma(_m01, _t32, _m11 * _t29));
        dest[destOffset + 10] = Math.fma(_m22, _t35, Math.fma(_m02, _t32, _m12 * _t29));
        dest[destOffset + 11] = Math.fma(_m03, _t32, Math.fma(_m13, _t29, Math.fma(_m23, _t35, _translationz)));
        return dest;
    }

    public static double[] lookAt_lh(double[] dest, int destOffset, double[] src, int srcOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        if (SimdSupport.VECTOR_API) return Double3x4OpsSimd.lookAt_lh(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return Double3x4OpsKernelsArray.lookAt_lh_scalar(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
    }

    public static double[] lookAt_lh_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self03 = src[srcOffset + 3];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self13 = src[srcOffset + 7];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _self23 = src[srcOffset + 11];
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
        dest[destOffset + 0] = Math.fma(_self02, _t10, Math.fma(_self00, _t32, _self01 * _t43));
        dest[destOffset + 1] = Math.fma(_self02, _t11, Math.fma(_self00, _t34, _self01 * _t44));
        dest[destOffset + 2] = Math.fma(_self02, _t12, Math.fma(_self00, _t33, _self01 * _t45));
        dest[destOffset + 3] = Math.fma(-_self00, _t47, Math.fma(-_self01, _t49, Math.fma(-_self02, _t24, _self03)));
        dest[destOffset + 4] = Math.fma(_self12, _t10, Math.fma(_self10, _t32, _self11 * _t43));
        dest[destOffset + 5] = Math.fma(_self12, _t11, Math.fma(_self10, _t34, _self11 * _t44));
        dest[destOffset + 6] = Math.fma(_self12, _t12, Math.fma(_self10, _t33, _self11 * _t45));
        dest[destOffset + 7] = Math.fma(-_self10, _t47, Math.fma(-_self11, _t49, Math.fma(-_self12, _t24, _self13)));
        dest[destOffset + 8] = Math.fma(_self22, _t10, Math.fma(_self20, _t32, _self21 * _t43));
        dest[destOffset + 9] = Math.fma(_self22, _t11, Math.fma(_self20, _t34, _self21 * _t44));
        dest[destOffset + 10] = Math.fma(_self22, _t12, Math.fma(_self20, _t33, _self21 * _t45));
        dest[destOffset + 11] = Math.fma(-_self20, _t47, Math.fma(-_self21, _t49, Math.fma(-_self22, _t24, _self23)));
        return dest;
    }

    public static double[] lookAt_rh(double[] dest, int destOffset, double[] src, int srcOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        if (SimdSupport.VECTOR_API) return Double3x4OpsSimd.lookAt_rh(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return Double3x4OpsKernelsArray.lookAt_rh_scalar(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
    }

    public static double[] lookAt_rh_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self03 = src[srcOffset + 3];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self13 = src[srcOffset + 7];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _self23 = src[srcOffset + 11];
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
        dest[destOffset + 0] = Math.fma(_t0, _t13, Math.fma(_self00, _t35, _self01 * _t46));
        dest[destOffset + 1] = Math.fma(_t0, _t14, Math.fma(_self00, _t36, _self01 * _t47));
        dest[destOffset + 2] = Math.fma(_t0, _t15, Math.fma(_self00, _t37, _self01 * _t48));
        dest[destOffset + 3] = Math.fma(-_self00, _t50, Math.fma(-_self01, _t52, Math.fma(_self02, _t27, _self03)));
        dest[destOffset + 4] = Math.fma(_t1, _t13, Math.fma(_self10, _t35, _self11 * _t46));
        dest[destOffset + 5] = Math.fma(_t1, _t14, Math.fma(_self10, _t36, _self11 * _t47));
        dest[destOffset + 6] = Math.fma(_t1, _t15, Math.fma(_self10, _t37, _self11 * _t48));
        dest[destOffset + 7] = Math.fma(-_self10, _t50, Math.fma(-_self11, _t52, Math.fma(_self12, _t27, _self13)));
        dest[destOffset + 8] = Math.fma(_t2, _t13, Math.fma(_self20, _t35, _self21 * _t46));
        dest[destOffset + 9] = Math.fma(_t2, _t14, Math.fma(_self20, _t36, _self21 * _t47));
        dest[destOffset + 10] = Math.fma(_t2, _t15, Math.fma(_self20, _t37, _self21 * _t48));
        dest[destOffset + 11] = Math.fma(-_self20, _t50, Math.fma(-_self21, _t52, Math.fma(_self22, _t27, _self23)));
        return dest;
    }

    public static double[] lookAt_lh(double[] dest, int destOffset, double[] src, int srcOffset, double[] eye, int eyeOffset, double[] center, int centerOffset, double[] up, int upOffset) {
        if (SimdSupport.VECTOR_API) return Double3x4OpsSimd.lookAt_lh(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
        return Double3x4OpsKernelsArray.lookAt_lh_scalar(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
    }

    public static double[] lookAt_lh_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double[] eye, int eyeOffset, double[] center, int centerOffset, double[] up, int upOffset) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self03 = src[srcOffset + 3];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self13 = src[srcOffset + 7];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _self23 = src[srcOffset + 11];
        double _eyex = eye[eyeOffset + 0];
        double _eyey = eye[eyeOffset + 1];
        double _eyez = eye[eyeOffset + 2];
        double _centerx = center[centerOffset + 0];
        double _centery = center[centerOffset + 1];
        double _centerz = center[centerOffset + 2];
        double _upx = up[upOffset + 0];
        double _upy = up[upOffset + 1];
        double _upz = up[upOffset + 2];
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
        dest[destOffset + 0] = Math.fma(_self02, _t10, Math.fma(_self00, _t32, _self01 * _t43));
        dest[destOffset + 1] = Math.fma(_self02, _t11, Math.fma(_self00, _t34, _self01 * _t44));
        dest[destOffset + 2] = Math.fma(_self02, _t12, Math.fma(_self00, _t33, _self01 * _t45));
        dest[destOffset + 3] = Math.fma(-_self00, _t47, Math.fma(-_self01, _t49, Math.fma(-_self02, _t24, _self03)));
        dest[destOffset + 4] = Math.fma(_self12, _t10, Math.fma(_self10, _t32, _self11 * _t43));
        dest[destOffset + 5] = Math.fma(_self12, _t11, Math.fma(_self10, _t34, _self11 * _t44));
        dest[destOffset + 6] = Math.fma(_self12, _t12, Math.fma(_self10, _t33, _self11 * _t45));
        dest[destOffset + 7] = Math.fma(-_self10, _t47, Math.fma(-_self11, _t49, Math.fma(-_self12, _t24, _self13)));
        dest[destOffset + 8] = Math.fma(_self22, _t10, Math.fma(_self20, _t32, _self21 * _t43));
        dest[destOffset + 9] = Math.fma(_self22, _t11, Math.fma(_self20, _t34, _self21 * _t44));
        dest[destOffset + 10] = Math.fma(_self22, _t12, Math.fma(_self20, _t33, _self21 * _t45));
        dest[destOffset + 11] = Math.fma(-_self20, _t47, Math.fma(-_self21, _t49, Math.fma(-_self22, _t24, _self23)));
        return dest;
    }

    public static double[] lookAt_rh(double[] dest, int destOffset, double[] src, int srcOffset, double[] eye, int eyeOffset, double[] center, int centerOffset, double[] up, int upOffset) {
        if (SimdSupport.VECTOR_API) return Double3x4OpsSimd.lookAt_rh(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
        return Double3x4OpsKernelsArray.lookAt_rh_scalar(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
    }

    public static double[] lookAt_rh_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double[] eye, int eyeOffset, double[] center, int centerOffset, double[] up, int upOffset) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self03 = src[srcOffset + 3];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self13 = src[srcOffset + 7];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _self23 = src[srcOffset + 11];
        double _eyex = eye[eyeOffset + 0];
        double _eyey = eye[eyeOffset + 1];
        double _eyez = eye[eyeOffset + 2];
        double _centerx = center[centerOffset + 0];
        double _centery = center[centerOffset + 1];
        double _centerz = center[centerOffset + 2];
        double _upx = up[upOffset + 0];
        double _upy = up[upOffset + 1];
        double _upz = up[upOffset + 2];
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
        dest[destOffset + 0] = Math.fma(_t0, _t13, Math.fma(_self00, _t35, _self01 * _t46));
        dest[destOffset + 1] = Math.fma(_t0, _t14, Math.fma(_self00, _t36, _self01 * _t47));
        dest[destOffset + 2] = Math.fma(_t0, _t15, Math.fma(_self00, _t37, _self01 * _t48));
        dest[destOffset + 3] = Math.fma(-_self00, _t50, Math.fma(-_self01, _t52, Math.fma(_self02, _t27, _self03)));
        dest[destOffset + 4] = Math.fma(_t1, _t13, Math.fma(_self10, _t35, _self11 * _t46));
        dest[destOffset + 5] = Math.fma(_t1, _t14, Math.fma(_self10, _t36, _self11 * _t47));
        dest[destOffset + 6] = Math.fma(_t1, _t15, Math.fma(_self10, _t37, _self11 * _t48));
        dest[destOffset + 7] = Math.fma(-_self10, _t50, Math.fma(-_self11, _t52, Math.fma(_self12, _t27, _self13)));
        dest[destOffset + 8] = Math.fma(_t2, _t13, Math.fma(_self20, _t35, _self21 * _t46));
        dest[destOffset + 9] = Math.fma(_t2, _t14, Math.fma(_self20, _t36, _self21 * _t47));
        dest[destOffset + 10] = Math.fma(_t2, _t15, Math.fma(_self20, _t37, _self21 * _t48));
        dest[destOffset + 11] = Math.fma(-_self20, _t50, Math.fma(-_self21, _t52, Math.fma(_self22, _t27, _self23)));
        return dest;
    }

    public static double[] makeLookAt_lh(double[] dest, int destOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
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
        dest[destOffset + 0] = _t29;
        dest[destOffset + 1] = _t30;
        dest[destOffset + 2] = _t31;
        dest[destOffset + 3] = -Math.fma(eyeZ, _t31, Math.fma(eyeX, _t29, eyeY * _t30));
        dest[destOffset + 4] = _t38;
        dest[destOffset + 5] = _t39;
        dest[destOffset + 6] = _t40;
        dest[destOffset + 7] = -Math.fma(eyeZ, _t40, Math.fma(eyeX, _t38, eyeY * _t39));
        dest[destOffset + 8] = _t11;
        dest[destOffset + 9] = _t10;
        dest[destOffset + 10] = _t12;
        dest[destOffset + 11] = -Math.fma(eyeZ, _t12, Math.fma(eyeX, _t11, eyeY * _t10));
        return dest;
    }

    public static double[] makeLookAt_rh(double[] dest, int destOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
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
        dest[destOffset + 0] = _t29;
        dest[destOffset + 1] = _t30;
        dest[destOffset + 2] = _t31;
        dest[destOffset + 3] = -Math.fma(eyeZ, _t31, Math.fma(eyeX, _t29, eyeY * _t30));
        dest[destOffset + 4] = _t38;
        dest[destOffset + 5] = _t39;
        dest[destOffset + 6] = _t40;
        dest[destOffset + 7] = -Math.fma(eyeZ, _t40, Math.fma(eyeX, _t38, eyeY * _t39));
        dest[destOffset + 8] = -_t10;
        dest[destOffset + 9] = -_t11;
        dest[destOffset + 10] = -_t12;
        dest[destOffset + 11] = Math.fma(eyeZ, _t12, Math.fma(eyeX, _t10, eyeY * _t11));
        return dest;
    }

    public static double[] makeLookAt_lh(double[] dest, int destOffset, double[] eye, int eyeOffset, double[] center, int centerOffset, double[] up, int upOffset) {
        double _eyex = eye[eyeOffset + 0];
        double _eyey = eye[eyeOffset + 1];
        double _eyez = eye[eyeOffset + 2];
        double _centerx = center[centerOffset + 0];
        double _centery = center[centerOffset + 1];
        double _centerz = center[centerOffset + 2];
        double _upx = up[upOffset + 0];
        double _upy = up[upOffset + 1];
        double _upz = up[upOffset + 2];
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
        dest[destOffset + 0] = _t29;
        dest[destOffset + 1] = _t30;
        dest[destOffset + 2] = _t31;
        dest[destOffset + 3] = -Math.fma(_eyez, _t31, Math.fma(_eyex, _t29, _eyey * _t30));
        dest[destOffset + 4] = _t38;
        dest[destOffset + 5] = _t39;
        dest[destOffset + 6] = _t40;
        dest[destOffset + 7] = -Math.fma(_eyez, _t40, Math.fma(_eyex, _t38, _eyey * _t39));
        dest[destOffset + 8] = _t11;
        dest[destOffset + 9] = _t10;
        dest[destOffset + 10] = _t12;
        dest[destOffset + 11] = -Math.fma(_eyez, _t12, Math.fma(_eyex, _t11, _eyey * _t10));
        return dest;
    }

    public static double[] makeLookAt_rh(double[] dest, int destOffset, double[] eye, int eyeOffset, double[] center, int centerOffset, double[] up, int upOffset) {
        double _eyex = eye[eyeOffset + 0];
        double _eyey = eye[eyeOffset + 1];
        double _eyez = eye[eyeOffset + 2];
        double _centerx = center[centerOffset + 0];
        double _centery = center[centerOffset + 1];
        double _centerz = center[centerOffset + 2];
        double _upx = up[upOffset + 0];
        double _upy = up[upOffset + 1];
        double _upz = up[upOffset + 2];
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
        dest[destOffset + 0] = _t29;
        dest[destOffset + 1] = _t30;
        dest[destOffset + 2] = _t31;
        dest[destOffset + 3] = -Math.fma(_eyez, _t31, Math.fma(_eyex, _t29, _eyey * _t30));
        dest[destOffset + 4] = _t38;
        dest[destOffset + 5] = _t39;
        dest[destOffset + 6] = _t40;
        dest[destOffset + 7] = -Math.fma(_eyez, _t40, Math.fma(_eyex, _t38, _eyey * _t39));
        dest[destOffset + 8] = -_t10;
        dest[destOffset + 9] = -_t11;
        dest[destOffset + 10] = -_t12;
        dest[destOffset + 11] = Math.fma(_eyez, _t12, Math.fma(_eyex, _t10, _eyey * _t11));
        return dest;
    }

    public static double[] mapXYZ_scalar(double[] dest, int destOffset, double[] src, int srcOffset) {
        for (int _i = 0; _i < 12; _i++) {
            double _eself = src[srcOffset + _i];
            dest[destOffset + _i] = _eself;
        }
        return dest;
    }

    public static double[] mapXYnZ_scalar(double[] dest, int destOffset, double[] src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src[srcOffset + _lo];
            double _eself1 = src[srcOffset + _lo + 1];
            double _eself2 = src[srcOffset + _lo + 2];
            double _eself3 = src[srcOffset + _lo + 3];
            dest[destOffset + _lo] = _eself0;
            dest[destOffset + _lo + 1] = _eself1;
            dest[destOffset + _lo + 2] = -_eself2;
            dest[destOffset + _lo + 3] = _eself3;
        }
        return dest;
    }

    public static double[] mapXnYZ_scalar(double[] dest, int destOffset, double[] src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src[srcOffset + _lo];
            double _eself1 = src[srcOffset + _lo + 1];
            double _eself2 = src[srcOffset + _lo + 2];
            double _eself3 = src[srcOffset + _lo + 3];
            dest[destOffset + _lo] = _eself0;
            dest[destOffset + _lo + 1] = -_eself1;
            dest[destOffset + _lo + 2] = _eself2;
            dest[destOffset + _lo + 3] = _eself3;
        }
        return dest;
    }

    public static double[] preRotateAround_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self03 = src[srcOffset + 3];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self13 = src[srcOffset + 7];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _self23 = src[srcOffset + 11];
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
        dest[destOffset + 0] = Math.fma(_self20, _t21, Math.fma(_self00, _t27, _self10 * _t24));
        dest[destOffset + 1] = Math.fma(_self21, _t21, Math.fma(_self01, _t27, _self11 * _t24));
        dest[destOffset + 2] = Math.fma(_self22, _t21, Math.fma(_self02, _t27, _self12 * _t24));
        dest[destOffset + 3] = Math.fma(_t0, _t27, Math.fma(_t1, _t24, Math.fma(_t2, _t21, Math.fma(_self03, _t27, Math.fma(_self13, _t24, Math.fma(_self23, _t21, pivotX))))));
        dest[destOffset + 4] = Math.fma(_self20, _t25, Math.fma(_self00, _t22, _self10 * _t28));
        dest[destOffset + 5] = Math.fma(_self21, _t25, Math.fma(_self01, _t22, _self11 * _t28));
        dest[destOffset + 6] = Math.fma(_self22, _t25, Math.fma(_self02, _t22, _self12 * _t28));
        dest[destOffset + 7] = Math.fma(_t0, _t22, Math.fma(_t1, _t28, Math.fma(_t2, _t25, Math.fma(_self03, _t22, Math.fma(_self13, _t28, Math.fma(_self23, _t25, pivotY))))));
        dest[destOffset + 8] = Math.fma(_self20, _t29, Math.fma(_self00, _t26, _self10 * _t23));
        dest[destOffset + 9] = Math.fma(_self21, _t29, Math.fma(_self01, _t26, _self11 * _t23));
        dest[destOffset + 10] = Math.fma(_self22, _t29, Math.fma(_self02, _t26, _self12 * _t23));
        dest[destOffset + 11] = Math.fma(_t0, _t26, Math.fma(_t1, _t23, Math.fma(_t2, _t29, Math.fma(_self03, _t26, Math.fma(_self13, _t23, Math.fma(_self23, _t29, pivotZ))))));
        return dest;
    }

    public static double[] preRotateAround_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double[] rot, int rotOffset, double[] pivot, int pivotOffset) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self03 = src[srcOffset + 3];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self13 = src[srcOffset + 7];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _self23 = src[srcOffset + 11];
        double _rotx = rot[rotOffset + 0];
        double _roty = rot[rotOffset + 1];
        double _rotz = rot[rotOffset + 2];
        double _rotw = rot[rotOffset + 3];
        double _pivotx = pivot[pivotOffset + 0];
        double _pivoty = pivot[pivotOffset + 1];
        double _pivotz = pivot[pivotOffset + 2];
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
        dest[destOffset + 0] = Math.fma(_self20, _t21, Math.fma(_self00, _t27, _self10 * _t24));
        dest[destOffset + 1] = Math.fma(_self21, _t21, Math.fma(_self01, _t27, _self11 * _t24));
        dest[destOffset + 2] = Math.fma(_self22, _t21, Math.fma(_self02, _t27, _self12 * _t24));
        dest[destOffset + 3] = Math.fma(_t0, _t27, Math.fma(_t1, _t24, Math.fma(_t2, _t21, Math.fma(_self03, _t27, Math.fma(_self13, _t24, Math.fma(_self23, _t21, _pivotx))))));
        dest[destOffset + 4] = Math.fma(_self20, _t25, Math.fma(_self00, _t22, _self10 * _t28));
        dest[destOffset + 5] = Math.fma(_self21, _t25, Math.fma(_self01, _t22, _self11 * _t28));
        dest[destOffset + 6] = Math.fma(_self22, _t25, Math.fma(_self02, _t22, _self12 * _t28));
        dest[destOffset + 7] = Math.fma(_t0, _t22, Math.fma(_t1, _t28, Math.fma(_t2, _t25, Math.fma(_self03, _t22, Math.fma(_self13, _t28, Math.fma(_self23, _t25, _pivoty))))));
        dest[destOffset + 8] = Math.fma(_self20, _t29, Math.fma(_self00, _t26, _self10 * _t23));
        dest[destOffset + 9] = Math.fma(_self21, _t29, Math.fma(_self01, _t26, _self11 * _t23));
        dest[destOffset + 10] = Math.fma(_self22, _t29, Math.fma(_self02, _t26, _self12 * _t23));
        dest[destOffset + 11] = Math.fma(_t0, _t26, Math.fma(_t1, _t23, Math.fma(_t2, _t29, Math.fma(_self03, _t26, Math.fma(_self13, _t23, Math.fma(_self23, _t29, _pivotz))))));
        return dest;
    }

    public static double[] preRotateAxis_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double angle, double axisX, double axisY, double axisZ) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self03 = src[srcOffset + 3];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self13 = src[srcOffset + 7];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _self23 = src[srcOffset + 11];
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
        dest[destOffset + 0] = Math.fma(_self20, _t21, Math.fma(_self00, _t18, _self10 * _t24));
        dest[destOffset + 1] = Math.fma(_self21, _t21, Math.fma(_self01, _t18, _self11 * _t24));
        dest[destOffset + 2] = Math.fma(_self22, _t21, Math.fma(_self02, _t18, _self12 * _t24));
        dest[destOffset + 3] = Math.fma(_self23, _t21, Math.fma(_self03, _t18, _self13 * _t24));
        dest[destOffset + 4] = Math.fma(_self20, _t25, Math.fma(_self00, _t22, _self10 * _t19));
        dest[destOffset + 5] = Math.fma(_self21, _t25, Math.fma(_self01, _t22, _self11 * _t19));
        dest[destOffset + 6] = Math.fma(_self22, _t25, Math.fma(_self02, _t22, _self12 * _t19));
        dest[destOffset + 7] = Math.fma(_self23, _t25, Math.fma(_self03, _t22, _self13 * _t19));
        dest[destOffset + 8] = Math.fma(_self20, _t20, Math.fma(_self00, _t26, _self10 * _t23));
        dest[destOffset + 9] = Math.fma(_self21, _t20, Math.fma(_self01, _t26, _self11 * _t23));
        dest[destOffset + 10] = Math.fma(_self22, _t20, Math.fma(_self02, _t26, _self12 * _t23));
        dest[destOffset + 11] = Math.fma(_self23, _t20, Math.fma(_self03, _t26, _self13 * _t23));
        return dest;
    }

    public static double[] preRotateAxis_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double[] axis, int axisOffset, double angle) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self03 = src[srcOffset + 3];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self13 = src[srcOffset + 7];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _self23 = src[srcOffset + 11];
        double _axisx = axis[axisOffset + 0];
        double _axisy = axis[axisOffset + 1];
        double _axisz = axis[axisOffset + 2];
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
        dest[destOffset + 0] = Math.fma(_self20, _t21, Math.fma(_self00, _t18, _self10 * _t24));
        dest[destOffset + 1] = Math.fma(_self21, _t21, Math.fma(_self01, _t18, _self11 * _t24));
        dest[destOffset + 2] = Math.fma(_self22, _t21, Math.fma(_self02, _t18, _self12 * _t24));
        dest[destOffset + 3] = Math.fma(_self23, _t21, Math.fma(_self03, _t18, _self13 * _t24));
        dest[destOffset + 4] = Math.fma(_self20, _t25, Math.fma(_self00, _t22, _self10 * _t19));
        dest[destOffset + 5] = Math.fma(_self21, _t25, Math.fma(_self01, _t22, _self11 * _t19));
        dest[destOffset + 6] = Math.fma(_self22, _t25, Math.fma(_self02, _t22, _self12 * _t19));
        dest[destOffset + 7] = Math.fma(_self23, _t25, Math.fma(_self03, _t22, _self13 * _t19));
        dest[destOffset + 8] = Math.fma(_self20, _t20, Math.fma(_self00, _t26, _self10 * _t23));
        dest[destOffset + 9] = Math.fma(_self21, _t20, Math.fma(_self01, _t26, _self11 * _t23));
        dest[destOffset + 10] = Math.fma(_self22, _t20, Math.fma(_self02, _t26, _self12 * _t23));
        dest[destOffset + 11] = Math.fma(_self23, _t20, Math.fma(_self03, _t26, _self13 * _t23));
        return dest;
    }

    public static double[] preRotateQuat_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double qX, double qY, double qZ, double qW) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self03 = src[srcOffset + 3];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self13 = src[srcOffset + 7];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _self23 = src[srcOffset + 11];
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
        dest[destOffset + 0] = Math.fma(_self20, _t18, Math.fma(_self00, _t24, _self10 * _t21));
        dest[destOffset + 1] = Math.fma(_self21, _t18, Math.fma(_self01, _t24, _self11 * _t21));
        dest[destOffset + 2] = Math.fma(_self22, _t18, Math.fma(_self02, _t24, _self12 * _t21));
        dest[destOffset + 3] = Math.fma(_self23, _t18, Math.fma(_self03, _t24, _self13 * _t21));
        dest[destOffset + 4] = Math.fma(_self20, _t22, Math.fma(_self00, _t19, _self10 * _t25));
        dest[destOffset + 5] = Math.fma(_self21, _t22, Math.fma(_self01, _t19, _self11 * _t25));
        dest[destOffset + 6] = Math.fma(_self22, _t22, Math.fma(_self02, _t19, _self12 * _t25));
        dest[destOffset + 7] = Math.fma(_self23, _t22, Math.fma(_self03, _t19, _self13 * _t25));
        dest[destOffset + 8] = Math.fma(_self20, _t26, Math.fma(_self00, _t23, _self10 * _t20));
        dest[destOffset + 9] = Math.fma(_self21, _t26, Math.fma(_self01, _t23, _self11 * _t20));
        dest[destOffset + 10] = Math.fma(_self22, _t26, Math.fma(_self02, _t23, _self12 * _t20));
        dest[destOffset + 11] = Math.fma(_self23, _t26, Math.fma(_self03, _t23, _self13 * _t20));
        return dest;
    }

    public static double[] preRotateQuat_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double[] q, int qOffset) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self03 = src[srcOffset + 3];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self13 = src[srcOffset + 7];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _self23 = src[srcOffset + 11];
        double _qx = q[qOffset + 0];
        double _qy = q[qOffset + 1];
        double _qz = q[qOffset + 2];
        double _qw = q[qOffset + 3];
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
        dest[destOffset + 0] = Math.fma(_self20, _t18, Math.fma(_self00, _t24, _self10 * _t21));
        dest[destOffset + 1] = Math.fma(_self21, _t18, Math.fma(_self01, _t24, _self11 * _t21));
        dest[destOffset + 2] = Math.fma(_self22, _t18, Math.fma(_self02, _t24, _self12 * _t21));
        dest[destOffset + 3] = Math.fma(_self23, _t18, Math.fma(_self03, _t24, _self13 * _t21));
        dest[destOffset + 4] = Math.fma(_self20, _t22, Math.fma(_self00, _t19, _self10 * _t25));
        dest[destOffset + 5] = Math.fma(_self21, _t22, Math.fma(_self01, _t19, _self11 * _t25));
        dest[destOffset + 6] = Math.fma(_self22, _t22, Math.fma(_self02, _t19, _self12 * _t25));
        dest[destOffset + 7] = Math.fma(_self23, _t22, Math.fma(_self03, _t19, _self13 * _t25));
        dest[destOffset + 8] = Math.fma(_self20, _t26, Math.fma(_self00, _t23, _self10 * _t20));
        dest[destOffset + 9] = Math.fma(_self21, _t26, Math.fma(_self01, _t23, _self11 * _t20));
        dest[destOffset + 10] = Math.fma(_self22, _t26, Math.fma(_self02, _t23, _self12 * _t20));
        dest[destOffset + 11] = Math.fma(_self23, _t26, Math.fma(_self03, _t23, _self13 * _t20));
        return dest;
    }

    public static double[] preRotateX_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double angle) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self03 = src[srcOffset + 3];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self13 = src[srcOffset + 7];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _self23 = src[srcOffset + 11];
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dest[destOffset + 0] = _self00;
        dest[destOffset + 1] = _self01;
        dest[destOffset + 2] = _self02;
        dest[destOffset + 3] = _self03;
        dest[destOffset + 4] = Math.fma(_self10, _t0, -(_self20 * _t1));
        dest[destOffset + 5] = Math.fma(_self11, _t0, -(_self21 * _t1));
        dest[destOffset + 6] = Math.fma(_self12, _t0, -(_self22 * _t1));
        dest[destOffset + 7] = Math.fma(_self13, _t0, -(_self23 * _t1));
        dest[destOffset + 8] = Math.fma(_self10, _t1, _self20 * _t0);
        dest[destOffset + 9] = Math.fma(_self11, _t1, _self21 * _t0);
        dest[destOffset + 10] = Math.fma(_self12, _t1, _self22 * _t0);
        dest[destOffset + 11] = Math.fma(_self13, _t1, _self23 * _t0);
        return dest;
    }

    public static double[] preRotateY_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double angle) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self03 = src[srcOffset + 3];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self13 = src[srcOffset + 7];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _self23 = src[srcOffset + 11];
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dest[destOffset + 0] = Math.fma(_self00, _t0, _self20 * _t1);
        dest[destOffset + 1] = Math.fma(_self01, _t0, _self21 * _t1);
        dest[destOffset + 2] = Math.fma(_self02, _t0, _self22 * _t1);
        dest[destOffset + 3] = Math.fma(_self03, _t0, _self23 * _t1);
        dest[destOffset + 4] = _self10;
        dest[destOffset + 5] = _self11;
        dest[destOffset + 6] = _self12;
        dest[destOffset + 7] = _self13;
        dest[destOffset + 8] = Math.fma(_self20, _t0, -(_self00 * _t1));
        dest[destOffset + 9] = Math.fma(_self21, _t0, -(_self01 * _t1));
        dest[destOffset + 10] = Math.fma(_self22, _t0, -(_self02 * _t1));
        dest[destOffset + 11] = Math.fma(_self23, _t0, -(_self03 * _t1));
        return dest;
    }

    public static double[] preRotateZ_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double angle) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self03 = src[srcOffset + 3];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self13 = src[srcOffset + 7];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _self23 = src[srcOffset + 11];
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dest[destOffset + 0] = Math.fma(_self00, _t0, -(_self10 * _t1));
        dest[destOffset + 1] = Math.fma(_self01, _t0, -(_self11 * _t1));
        dest[destOffset + 2] = Math.fma(_self02, _t0, -(_self12 * _t1));
        dest[destOffset + 3] = Math.fma(_self03, _t0, -(_self13 * _t1));
        dest[destOffset + 4] = Math.fma(_self00, _t1, _self10 * _t0);
        dest[destOffset + 5] = Math.fma(_self01, _t1, _self11 * _t0);
        dest[destOffset + 6] = Math.fma(_self02, _t1, _self12 * _t0);
        dest[destOffset + 7] = Math.fma(_self03, _t1, _self13 * _t0);
        dest[destOffset + 8] = _self20;
        dest[destOffset + 9] = _self21;
        dest[destOffset + 10] = _self22;
        dest[destOffset + 11] = _self23;
        return dest;
    }

    public static double[] preScale_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double vX, double vY, double vZ) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self03 = src[srcOffset + 3];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self13 = src[srcOffset + 7];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _self23 = src[srcOffset + 11];
        dest[destOffset + 0] = _self00 * vX;
        dest[destOffset + 1] = _self01 * vX;
        dest[destOffset + 2] = _self02 * vX;
        dest[destOffset + 3] = _self03 * vX;
        dest[destOffset + 4] = _self10 * vY;
        dest[destOffset + 5] = _self11 * vY;
        dest[destOffset + 6] = _self12 * vY;
        dest[destOffset + 7] = _self13 * vY;
        dest[destOffset + 8] = _self20 * vZ;
        dest[destOffset + 9] = _self21 * vZ;
        dest[destOffset + 10] = _self22 * vZ;
        dest[destOffset + 11] = _self23 * vZ;
        return dest;
    }

    public static double[] preScale_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double[] v, int vOffset) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self03 = src[srcOffset + 3];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self13 = src[srcOffset + 7];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _self23 = src[srcOffset + 11];
        double _vx = v[vOffset + 0];
        double _vy = v[vOffset + 1];
        double _vz = v[vOffset + 2];
        dest[destOffset + 0] = _self00 * _vx;
        dest[destOffset + 1] = _self01 * _vx;
        dest[destOffset + 2] = _self02 * _vx;
        dest[destOffset + 3] = _self03 * _vx;
        dest[destOffset + 4] = _self10 * _vy;
        dest[destOffset + 5] = _self11 * _vy;
        dest[destOffset + 6] = _self12 * _vy;
        dest[destOffset + 7] = _self13 * _vy;
        dest[destOffset + 8] = _self20 * _vz;
        dest[destOffset + 9] = _self21 * _vz;
        dest[destOffset + 10] = _self22 * _vz;
        dest[destOffset + 11] = _self23 * _vz;
        return dest;
    }

    public static double[] preScale_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double s) {
        for (int _i = 0; _i < 12; _i++) {
            double _eself = src[srcOffset + _i];
            dest[destOffset + _i] = s * _eself;
        }
        return dest;
    }

    public static double[] preScaleAround_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double s, double pivotX, double pivotY, double pivotZ) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self03 = src[srcOffset + 3];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self13 = src[srcOffset + 7];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _self23 = src[srcOffset + 11];
        dest[destOffset + 0] = s * _self00;
        dest[destOffset + 1] = s * _self01;
        dest[destOffset + 2] = s * _self02;
        dest[destOffset + 3] = Math.fma(-s, pivotX, Math.fma(s, _self03, pivotX));
        dest[destOffset + 4] = s * _self10;
        dest[destOffset + 5] = s * _self11;
        dest[destOffset + 6] = s * _self12;
        dest[destOffset + 7] = Math.fma(-s, pivotY, Math.fma(s, _self13, pivotY));
        dest[destOffset + 8] = s * _self20;
        dest[destOffset + 9] = s * _self21;
        dest[destOffset + 10] = s * _self22;
        dest[destOffset + 11] = Math.fma(-s, pivotZ, Math.fma(s, _self23, pivotZ));
        return dest;
    }

    public static double[] preScaleAround_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double[] pivot, int pivotOffset, double s) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self03 = src[srcOffset + 3];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self13 = src[srcOffset + 7];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _self23 = src[srcOffset + 11];
        double _pivotx = pivot[pivotOffset + 0];
        double _pivoty = pivot[pivotOffset + 1];
        double _pivotz = pivot[pivotOffset + 2];
        dest[destOffset + 0] = s * _self00;
        dest[destOffset + 1] = s * _self01;
        dest[destOffset + 2] = s * _self02;
        dest[destOffset + 3] = Math.fma(-s, _pivotx, Math.fma(s, _self03, _pivotx));
        dest[destOffset + 4] = s * _self10;
        dest[destOffset + 5] = s * _self11;
        dest[destOffset + 6] = s * _self12;
        dest[destOffset + 7] = Math.fma(-s, _pivoty, Math.fma(s, _self13, _pivoty));
        dest[destOffset + 8] = s * _self20;
        dest[destOffset + 9] = s * _self21;
        dest[destOffset + 10] = s * _self22;
        dest[destOffset + 11] = Math.fma(-s, _pivotz, Math.fma(s, _self23, _pivotz));
        return dest;
    }

    public static double[] preScaleAround_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self03 = src[srcOffset + 3];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self13 = src[srcOffset + 7];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _self23 = src[srcOffset + 11];
        dest[destOffset + 0] = sX * _self00;
        dest[destOffset + 1] = sX * _self01;
        dest[destOffset + 2] = sX * _self02;
        dest[destOffset + 3] = Math.fma(-pivotX, sX, Math.fma(sX, _self03, pivotX));
        dest[destOffset + 4] = sY * _self10;
        dest[destOffset + 5] = sY * _self11;
        dest[destOffset + 6] = sY * _self12;
        dest[destOffset + 7] = Math.fma(-pivotY, sY, Math.fma(sY, _self13, pivotY));
        dest[destOffset + 8] = sZ * _self20;
        dest[destOffset + 9] = sZ * _self21;
        dest[destOffset + 10] = sZ * _self22;
        dest[destOffset + 11] = Math.fma(-pivotZ, sZ, Math.fma(sZ, _self23, pivotZ));
        return dest;
    }

    public static double[] preScaleAround_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double[] s, int sOffset, double[] pivot, int pivotOffset) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self03 = src[srcOffset + 3];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self13 = src[srcOffset + 7];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _self23 = src[srcOffset + 11];
        double _sx = s[sOffset + 0];
        double _sy = s[sOffset + 1];
        double _sz = s[sOffset + 2];
        double _pivotx = pivot[pivotOffset + 0];
        double _pivoty = pivot[pivotOffset + 1];
        double _pivotz = pivot[pivotOffset + 2];
        dest[destOffset + 0] = _sx * _self00;
        dest[destOffset + 1] = _sx * _self01;
        dest[destOffset + 2] = _sx * _self02;
        dest[destOffset + 3] = Math.fma(-_pivotx, _sx, Math.fma(_sx, _self03, _pivotx));
        dest[destOffset + 4] = _sy * _self10;
        dest[destOffset + 5] = _sy * _self11;
        dest[destOffset + 6] = _sy * _self12;
        dest[destOffset + 7] = Math.fma(-_pivoty, _sy, Math.fma(_sy, _self13, _pivoty));
        dest[destOffset + 8] = _sz * _self20;
        dest[destOffset + 9] = _sz * _self21;
        dest[destOffset + 10] = _sz * _self22;
        dest[destOffset + 11] = Math.fma(-_pivotz, _sz, Math.fma(_sz, _self23, _pivotz));
        return dest;
    }

    public static double[] preTranslate_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double vX, double vY, double vZ) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self03 = src[srcOffset + 3];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self13 = src[srcOffset + 7];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _self23 = src[srcOffset + 11];
        dest[destOffset + 0] = _self00;
        dest[destOffset + 1] = _self01;
        dest[destOffset + 2] = _self02;
        dest[destOffset + 3] = _self03 + vX;
        dest[destOffset + 4] = _self10;
        dest[destOffset + 5] = _self11;
        dest[destOffset + 6] = _self12;
        dest[destOffset + 7] = _self13 + vY;
        dest[destOffset + 8] = _self20;
        dest[destOffset + 9] = _self21;
        dest[destOffset + 10] = _self22;
        dest[destOffset + 11] = _self23 + vZ;
        return dest;
    }

    public static double[] preTranslate_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double[] v, int vOffset) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self03 = src[srcOffset + 3];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self13 = src[srcOffset + 7];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _self23 = src[srcOffset + 11];
        double _vx = v[vOffset + 0];
        double _vy = v[vOffset + 1];
        double _vz = v[vOffset + 2];
        dest[destOffset + 0] = _self00;
        dest[destOffset + 1] = _self01;
        dest[destOffset + 2] = _self02;
        dest[destOffset + 3] = _self03 + _vx;
        dest[destOffset + 4] = _self10;
        dest[destOffset + 5] = _self11;
        dest[destOffset + 6] = _self12;
        dest[destOffset + 7] = _self13 + _vy;
        dest[destOffset + 8] = _self20;
        dest[destOffset + 9] = _self21;
        dest[destOffset + 10] = _self22;
        dest[destOffset + 11] = _self23 + _vz;
        return dest;
    }

    public static double[] reflect_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double normalX, double normalY, double normalZ) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self03 = src[srcOffset + 3];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self13 = src[srcOffset + 7];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _self23 = src[srcOffset + 11];
        double _t0 = -_self02;
        double _t1 = -_self12;
        double _t2 = -_self22;
        double _t9 = 2.0 * normalX * normalZ;
        double _t10 = 2.0 * normalX * normalY;
        double _t11 = 2.0 * normalY * normalZ;
        double _t12 = Math.fma(-2.0, normalX * normalX, 1.0);
        double _t13 = Math.fma(-2.0, normalY * normalY, 1.0);
        double _t14 = Math.fma(-2.0, normalZ * normalZ, 1.0);
        dest[destOffset + 0] = Math.fma(_t0, _t9, Math.fma(_self00, _t12, -(_self01 * _t10)));
        dest[destOffset + 1] = Math.fma(_t0, _t11, Math.fma(_self01, _t13, -(_self00 * _t10)));
        dest[destOffset + 2] = Math.fma(_self02, _t14, Math.fma(-_self01, _t11, -(_self00 * _t9)));
        dest[destOffset + 3] = _self03;
        dest[destOffset + 4] = Math.fma(_t1, _t9, Math.fma(_self10, _t12, -(_self11 * _t10)));
        dest[destOffset + 5] = Math.fma(_t1, _t11, Math.fma(_self11, _t13, -(_self10 * _t10)));
        dest[destOffset + 6] = Math.fma(_self12, _t14, Math.fma(-_self11, _t11, -(_self10 * _t9)));
        dest[destOffset + 7] = _self13;
        dest[destOffset + 8] = Math.fma(_t2, _t9, Math.fma(_self20, _t12, -(_self21 * _t10)));
        dest[destOffset + 9] = Math.fma(_t2, _t11, Math.fma(_self21, _t13, -(_self20 * _t10)));
        dest[destOffset + 10] = Math.fma(_self22, _t14, Math.fma(-_self21, _t11, -(_self20 * _t9)));
        dest[destOffset + 11] = _self23;
        return dest;
    }

    public static double[] reflect_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double[] normal, int normalOffset) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self03 = src[srcOffset + 3];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self13 = src[srcOffset + 7];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _self23 = src[srcOffset + 11];
        double _normalx = normal[normalOffset + 0];
        double _normaly = normal[normalOffset + 1];
        double _normalz = normal[normalOffset + 2];
        double _t0 = -_self02;
        double _t1 = -_self12;
        double _t2 = -_self22;
        double _t9 = 2.0 * _normalx * _normalz;
        double _t10 = 2.0 * _normalx * _normaly;
        double _t11 = 2.0 * _normaly * _normalz;
        double _t12 = Math.fma(-2.0, _normalx * _normalx, 1.0);
        double _t13 = Math.fma(-2.0, _normaly * _normaly, 1.0);
        double _t14 = Math.fma(-2.0, _normalz * _normalz, 1.0);
        dest[destOffset + 0] = Math.fma(_t0, _t9, Math.fma(_self00, _t12, -(_self01 * _t10)));
        dest[destOffset + 1] = Math.fma(_t0, _t11, Math.fma(_self01, _t13, -(_self00 * _t10)));
        dest[destOffset + 2] = Math.fma(_self02, _t14, Math.fma(-_self01, _t11, -(_self00 * _t9)));
        dest[destOffset + 3] = _self03;
        dest[destOffset + 4] = Math.fma(_t1, _t9, Math.fma(_self10, _t12, -(_self11 * _t10)));
        dest[destOffset + 5] = Math.fma(_t1, _t11, Math.fma(_self11, _t13, -(_self10 * _t10)));
        dest[destOffset + 6] = Math.fma(_self12, _t14, Math.fma(-_self11, _t11, -(_self10 * _t9)));
        dest[destOffset + 7] = _self13;
        dest[destOffset + 8] = Math.fma(_t2, _t9, Math.fma(_self20, _t12, -(_self21 * _t10)));
        dest[destOffset + 9] = Math.fma(_t2, _t11, Math.fma(_self21, _t13, -(_self20 * _t10)));
        dest[destOffset + 10] = Math.fma(_self22, _t14, Math.fma(-_self21, _t11, -(_self20 * _t9)));
        dest[destOffset + 11] = _self23;
        return dest;
    }

    public static double[] rotateAround_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self03 = src[srcOffset + 3];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self13 = src[srcOffset + 7];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _self23 = src[srcOffset + 11];
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
        dest[destOffset + 0] = Math.fma(_self02, _t24, Math.fma(_self00, _t27, _self01 * _t21));
        dest[destOffset + 1] = Math.fma(_self02, _t22, Math.fma(_self00, _t25, _self01 * _t28));
        dest[destOffset + 2] = Math.fma(_self02, _t29, Math.fma(_self00, _t23, _self01 * _t26));
        dest[destOffset + 3] = Math.fma(_self00, _t36, Math.fma(_self01, _t37, Math.fma(_self02, _t38, _self03)));
        dest[destOffset + 4] = Math.fma(_self12, _t24, Math.fma(_self10, _t27, _self11 * _t21));
        dest[destOffset + 5] = Math.fma(_self12, _t22, Math.fma(_self10, _t25, _self11 * _t28));
        dest[destOffset + 6] = Math.fma(_self12, _t29, Math.fma(_self10, _t23, _self11 * _t26));
        dest[destOffset + 7] = Math.fma(_self10, _t36, Math.fma(_self11, _t37, Math.fma(_self12, _t38, _self13)));
        dest[destOffset + 8] = Math.fma(_self22, _t24, Math.fma(_self20, _t27, _self21 * _t21));
        dest[destOffset + 9] = Math.fma(_self22, _t22, Math.fma(_self20, _t25, _self21 * _t28));
        dest[destOffset + 10] = Math.fma(_self22, _t29, Math.fma(_self20, _t23, _self21 * _t26));
        dest[destOffset + 11] = Math.fma(_self20, _t36, Math.fma(_self21, _t37, Math.fma(_self22, _t38, _self23)));
        return dest;
    }

    public static double[] rotateAround_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double[] rot, int rotOffset, double[] pivot, int pivotOffset) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self03 = src[srcOffset + 3];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self13 = src[srcOffset + 7];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _self23 = src[srcOffset + 11];
        double _rotx = rot[rotOffset + 0];
        double _roty = rot[rotOffset + 1];
        double _rotz = rot[rotOffset + 2];
        double _rotw = rot[rotOffset + 3];
        double _pivotx = pivot[pivotOffset + 0];
        double _pivoty = pivot[pivotOffset + 1];
        double _pivotz = pivot[pivotOffset + 2];
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
        dest[destOffset + 0] = Math.fma(_self02, _t24, Math.fma(_self00, _t27, _self01 * _t21));
        dest[destOffset + 1] = Math.fma(_self02, _t22, Math.fma(_self00, _t25, _self01 * _t28));
        dest[destOffset + 2] = Math.fma(_self02, _t29, Math.fma(_self00, _t23, _self01 * _t26));
        dest[destOffset + 3] = Math.fma(_self00, _t36, Math.fma(_self01, _t37, Math.fma(_self02, _t38, _self03)));
        dest[destOffset + 4] = Math.fma(_self12, _t24, Math.fma(_self10, _t27, _self11 * _t21));
        dest[destOffset + 5] = Math.fma(_self12, _t22, Math.fma(_self10, _t25, _self11 * _t28));
        dest[destOffset + 6] = Math.fma(_self12, _t29, Math.fma(_self10, _t23, _self11 * _t26));
        dest[destOffset + 7] = Math.fma(_self10, _t36, Math.fma(_self11, _t37, Math.fma(_self12, _t38, _self13)));
        dest[destOffset + 8] = Math.fma(_self22, _t24, Math.fma(_self20, _t27, _self21 * _t21));
        dest[destOffset + 9] = Math.fma(_self22, _t22, Math.fma(_self20, _t25, _self21 * _t28));
        dest[destOffset + 10] = Math.fma(_self22, _t29, Math.fma(_self20, _t23, _self21 * _t26));
        dest[destOffset + 11] = Math.fma(_self20, _t36, Math.fma(_self21, _t37, Math.fma(_self22, _t38, _self23)));
        return dest;
    }

    public static double[] rotateYXZ_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double angleX, double angleY, double angleZ) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self03 = src[srcOffset + 3];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self13 = src[srcOffset + 7];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _self23 = src[srcOffset + 11];
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
        dest[destOffset + 0] = Math.fma(_self02, _t20, Math.fma(_self00, _t18, _self01 * _t10));
        dest[destOffset + 1] = Math.fma(_self02, _t19, Math.fma(_self00, _t21, _self01 * _t13));
        dest[destOffset + 2] = Math.fma(_self02, _t14, Math.fma(_self00, _t15, -(_self01 * _t0)));
        dest[destOffset + 3] = _self03;
        dest[destOffset + 4] = Math.fma(_self12, _t20, Math.fma(_self10, _t18, _self11 * _t10));
        dest[destOffset + 5] = Math.fma(_self12, _t19, Math.fma(_self10, _t21, _self11 * _t13));
        dest[destOffset + 6] = Math.fma(_self12, _t14, Math.fma(_self10, _t15, -(_self11 * _t0)));
        dest[destOffset + 7] = _self13;
        dest[destOffset + 8] = Math.fma(_self22, _t20, Math.fma(_self20, _t18, _self21 * _t10));
        dest[destOffset + 9] = Math.fma(_self22, _t19, Math.fma(_self20, _t21, _self21 * _t13));
        dest[destOffset + 10] = Math.fma(_self22, _t14, Math.fma(_self20, _t15, -(_self21 * _t0)));
        dest[destOffset + 11] = _self23;
        return dest;
    }

    public static double[] scale_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double vX, double vY, double vZ) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src[srcOffset + _lo];
            double _eself1 = src[srcOffset + _lo + 1];
            double _eself2 = src[srcOffset + _lo + 2];
            double _eself3 = src[srcOffset + _lo + 3];
            dest[destOffset + _lo] = _eself0 * vX;
            dest[destOffset + _lo + 1] = _eself1 * vY;
            dest[destOffset + _lo + 2] = _eself2 * vZ;
            dest[destOffset + _lo + 3] = _eself3;
        }
        return dest;
    }

    public static double[] scale_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double[] v, int vOffset) {
        double _vx = v[vOffset + 0];
        double _vy = v[vOffset + 1];
        double _vz = v[vOffset + 2];
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src[srcOffset + _lo];
            double _eself1 = src[srcOffset + _lo + 1];
            double _eself2 = src[srcOffset + _lo + 2];
            double _eself3 = src[srcOffset + _lo + 3];
            dest[destOffset + _lo] = _eself0 * _vx;
            dest[destOffset + _lo + 1] = _eself1 * _vy;
            dest[destOffset + _lo + 2] = _eself2 * _vz;
            dest[destOffset + _lo + 3] = _eself3;
        }
        return dest;
    }

    public static double[] scale_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double s) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src[srcOffset + _lo];
            double _eself1 = src[srcOffset + _lo + 1];
            double _eself2 = src[srcOffset + _lo + 2];
            double _eself3 = src[srcOffset + _lo + 3];
            dest[destOffset + _lo] = s * _eself0;
            dest[destOffset + _lo + 1] = s * _eself1;
            dest[destOffset + _lo + 2] = s * _eself2;
            dest[destOffset + _lo + 3] = _eself3;
        }
        return dest;
    }

    public static double[] scaleAround_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double s, double pivotX, double pivotY, double pivotZ) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self03 = src[srcOffset + 3];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self13 = src[srcOffset + 7];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _self23 = src[srcOffset + 11];
        double _t0 = Math.fma(-s, pivotX, pivotX);
        double _t1 = Math.fma(-s, pivotY, pivotY);
        double _t2 = Math.fma(-s, pivotZ, pivotZ);
        dest[destOffset + 0] = s * _self00;
        dest[destOffset + 1] = s * _self01;
        dest[destOffset + 2] = s * _self02;
        dest[destOffset + 3] = Math.fma(_self00, _t0, Math.fma(_self01, _t1, Math.fma(_self02, _t2, _self03)));
        dest[destOffset + 4] = s * _self10;
        dest[destOffset + 5] = s * _self11;
        dest[destOffset + 6] = s * _self12;
        dest[destOffset + 7] = Math.fma(_self10, _t0, Math.fma(_self11, _t1, Math.fma(_self12, _t2, _self13)));
        dest[destOffset + 8] = s * _self20;
        dest[destOffset + 9] = s * _self21;
        dest[destOffset + 10] = s * _self22;
        dest[destOffset + 11] = Math.fma(_self20, _t0, Math.fma(_self21, _t1, Math.fma(_self22, _t2, _self23)));
        return dest;
    }

    public static double[] scaleAround_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double[] pivot, int pivotOffset, double s) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self03 = src[srcOffset + 3];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self13 = src[srcOffset + 7];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _self23 = src[srcOffset + 11];
        double _pivotx = pivot[pivotOffset + 0];
        double _pivoty = pivot[pivotOffset + 1];
        double _pivotz = pivot[pivotOffset + 2];
        double _t0 = Math.fma(-s, _pivotx, _pivotx);
        double _t1 = Math.fma(-s, _pivoty, _pivoty);
        double _t2 = Math.fma(-s, _pivotz, _pivotz);
        dest[destOffset + 0] = s * _self00;
        dest[destOffset + 1] = s * _self01;
        dest[destOffset + 2] = s * _self02;
        dest[destOffset + 3] = Math.fma(_self00, _t0, Math.fma(_self01, _t1, Math.fma(_self02, _t2, _self03)));
        dest[destOffset + 4] = s * _self10;
        dest[destOffset + 5] = s * _self11;
        dest[destOffset + 6] = s * _self12;
        dest[destOffset + 7] = Math.fma(_self10, _t0, Math.fma(_self11, _t1, Math.fma(_self12, _t2, _self13)));
        dest[destOffset + 8] = s * _self20;
        dest[destOffset + 9] = s * _self21;
        dest[destOffset + 10] = s * _self22;
        dest[destOffset + 11] = Math.fma(_self20, _t0, Math.fma(_self21, _t1, Math.fma(_self22, _t2, _self23)));
        return dest;
    }

    public static double[] scaleAround_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self03 = src[srcOffset + 3];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self13 = src[srcOffset + 7];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _self23 = src[srcOffset + 11];
        double _t3 = Math.fma(-pivotX, sX, pivotX);
        double _t4 = Math.fma(-pivotY, sY, pivotY);
        double _t5 = Math.fma(-pivotZ, sZ, pivotZ);
        dest[destOffset + 0] = sX * _self00;
        dest[destOffset + 1] = sY * _self01;
        dest[destOffset + 2] = sZ * _self02;
        dest[destOffset + 3] = Math.fma(_self00, _t3, Math.fma(_self01, _t4, Math.fma(_self02, _t5, _self03)));
        dest[destOffset + 4] = sX * _self10;
        dest[destOffset + 5] = sY * _self11;
        dest[destOffset + 6] = sZ * _self12;
        dest[destOffset + 7] = Math.fma(_self10, _t3, Math.fma(_self11, _t4, Math.fma(_self12, _t5, _self13)));
        dest[destOffset + 8] = sX * _self20;
        dest[destOffset + 9] = sY * _self21;
        dest[destOffset + 10] = sZ * _self22;
        dest[destOffset + 11] = Math.fma(_self20, _t3, Math.fma(_self21, _t4, Math.fma(_self22, _t5, _self23)));
        return dest;
    }

    public static double[] scaleAround_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double[] s, int sOffset, double[] pivot, int pivotOffset) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self03 = src[srcOffset + 3];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self13 = src[srcOffset + 7];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _self23 = src[srcOffset + 11];
        double _sx = s[sOffset + 0];
        double _sy = s[sOffset + 1];
        double _sz = s[sOffset + 2];
        double _pivotx = pivot[pivotOffset + 0];
        double _pivoty = pivot[pivotOffset + 1];
        double _pivotz = pivot[pivotOffset + 2];
        double _t3 = Math.fma(-_pivotx, _sx, _pivotx);
        double _t4 = Math.fma(-_pivoty, _sy, _pivoty);
        double _t5 = Math.fma(-_pivotz, _sz, _pivotz);
        dest[destOffset + 0] = _sx * _self00;
        dest[destOffset + 1] = _sy * _self01;
        dest[destOffset + 2] = _sz * _self02;
        dest[destOffset + 3] = Math.fma(_self00, _t3, Math.fma(_self01, _t4, Math.fma(_self02, _t5, _self03)));
        dest[destOffset + 4] = _sx * _self10;
        dest[destOffset + 5] = _sy * _self11;
        dest[destOffset + 6] = _sz * _self12;
        dest[destOffset + 7] = Math.fma(_self10, _t3, Math.fma(_self11, _t4, Math.fma(_self12, _t5, _self13)));
        dest[destOffset + 8] = _sx * _self20;
        dest[destOffset + 9] = _sy * _self21;
        dest[destOffset + 10] = _sz * _self22;
        dest[destOffset + 11] = Math.fma(_self20, _t3, Math.fma(_self21, _t4, Math.fma(_self22, _t5, _self23)));
        return dest;
    }

    public static double[] translate_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double vX, double vY, double vZ) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src[srcOffset + _lo];
            double _eself1 = src[srcOffset + _lo + 1];
            double _eself2 = src[srcOffset + _lo + 2];
            double _eself3 = src[srcOffset + _lo + 3];
            dest[destOffset + _lo] = _eself0;
            dest[destOffset + _lo + 1] = _eself1;
            dest[destOffset + _lo + 2] = _eself2;
            dest[destOffset + _lo + 3] = Math.fma(_eself0, vX, Math.fma(_eself1, vY, Math.fma(_eself2, vZ, _eself3)));
        }
        return dest;
    }

    public static double[] translate_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double[] v, int vOffset) {
        double _vx = v[vOffset + 0];
        double _vy = v[vOffset + 1];
        double _vz = v[vOffset + 2];
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 4;
            double _eself0 = src[srcOffset + _lo];
            double _eself1 = src[srcOffset + _lo + 1];
            double _eself2 = src[srcOffset + _lo + 2];
            double _eself3 = src[srcOffset + _lo + 3];
            dest[destOffset + _lo] = _eself0;
            dest[destOffset + _lo + 1] = _eself1;
            dest[destOffset + _lo + 2] = _eself2;
            dest[destOffset + _lo + 3] = Math.fma(_eself0, _vx, Math.fma(_eself1, _vy, Math.fma(_eself2, _vz, _eself3)));
        }
        return dest;
    }

    public static double[] lerpComposeTRSMul_fma(double[] dest, int destOffset, double[] t1, int t1Offset, double[] t2, int t2Offset, double[] q1, int q1Offset, double[] q2, int q2Offset, double[] s1, int s1Offset, double[] s2, int s2Offset, double[] m, int mOffset, double alpha, int count) {
        for (int _i = 0; _i < count; _i++) {
            int _t1o = t1Offset + _i * 3;
            int _t2o = t2Offset + _i * 3;
            int _q1o = q1Offset + _i * 4;
            int _q2o = q2Offset + _i * 4;
            int _s1o = s1Offset + _i * 3;
            int _s2o = s2Offset + _i * 3;
            int _mo = mOffset + _i * 12;
            int _do = destOffset + _i * 12;
            double _ax = t1[_t1o + 0], _ay = t1[_t1o + 1], _az = t1[_t1o + 2];
            double _tx = Math.fma(alpha, t2[_t2o + 0] - _ax, _ax);
            double _ty = Math.fma(alpha, t2[_t2o + 1] - _ay, _ay);
            double _tz = Math.fma(alpha, t2[_t2o + 2] - _az, _az);
            double _bx = s1[_s1o + 0], _by = s1[_s1o + 1], _bz = s1[_s1o + 2];
            double _sx = Math.fma(alpha, s2[_s2o + 0] - _bx, _bx);
            double _sy = Math.fma(alpha, s2[_s2o + 1] - _by, _by);
            double _sz = Math.fma(alpha, s2[_s2o + 2] - _bz, _bz);
            double _ux = q1[_q1o + 0], _uy = q1[_q1o + 1], _uz = q1[_q1o + 2], _uw = q1[_q1o + 3];
            double _vx = q2[_q2o + 0], _vy = q2[_q2o + 1], _vz = q2[_q2o + 2], _vw = q2[_q2o + 3];
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
            double _m00 = m[_mo + 0], _m01 = m[_mo + 1], _m02 = m[_mo + 2], _m03 = m[_mo + 3];
            double _m10 = m[_mo + 4], _m11 = m[_mo + 5], _m12 = m[_mo + 6], _m13 = m[_mo + 7];
            double _m20 = m[_mo + 8], _m21 = m[_mo + 9], _m22 = m[_mo + 10], _m23 = m[_mo + 11];
            double _e00 = Math.fma(_t02, _m20, Math.fma(_t01, _m10, _t00 * _m00)), _e01 = Math.fma(_t02, _m21, Math.fma(_t01, _m11, _t00 * _m01)), _e02 = Math.fma(_t02, _m22, Math.fma(_t01, _m12, _t00 * _m02)), _e03 = (Math.fma(_t02, _m23, Math.fma(_t01, _m13, _t00 * _m03))) + _tx;
            double _e10 = Math.fma(_t12, _m20, Math.fma(_t11, _m10, _t10 * _m00)), _e11 = Math.fma(_t12, _m21, Math.fma(_t11, _m11, _t10 * _m01)), _e12 = Math.fma(_t12, _m22, Math.fma(_t11, _m12, _t10 * _m02)), _e13 = (Math.fma(_t12, _m23, Math.fma(_t11, _m13, _t10 * _m03))) + _ty;
            double _e20 = Math.fma(_t22, _m20, Math.fma(_t21, _m10, _t20 * _m00)), _e21 = Math.fma(_t22, _m21, Math.fma(_t21, _m11, _t20 * _m01)), _e22 = Math.fma(_t22, _m22, Math.fma(_t21, _m12, _t20 * _m02)), _e23 = (Math.fma(_t22, _m23, Math.fma(_t21, _m13, _t20 * _m03))) + _tz;
            dest[_do + 0] = _e00;
            dest[_do + 1] = _e01;
            dest[_do + 2] = _e02;
            dest[_do + 3] = _e03;
            dest[_do + 4] = _e10;
            dest[_do + 5] = _e11;
            dest[_do + 6] = _e12;
            dest[_do + 7] = _e13;
            dest[_do + 8] = _e20;
            dest[_do + 9] = _e21;
            dest[_do + 10] = _e22;
            dest[_do + 11] = _e23;
        }
        return dest;
    }

    public static double[] lerpComposeTRSMul_mulAdd(double[] dest, int destOffset, double[] t1, int t1Offset, double[] t2, int t2Offset, double[] q1, int q1Offset, double[] q2, int q2Offset, double[] s1, int s1Offset, double[] s2, int s2Offset, double[] m, int mOffset, double alpha, int count) {
        for (int _i = 0; _i < count; _i++) {
            int _t1o = t1Offset + _i * 3;
            int _t2o = t2Offset + _i * 3;
            int _q1o = q1Offset + _i * 4;
            int _q2o = q2Offset + _i * 4;
            int _s1o = s1Offset + _i * 3;
            int _s2o = s2Offset + _i * 3;
            int _mo = mOffset + _i * 12;
            int _do = destOffset + _i * 12;
            double _ax = t1[_t1o + 0], _ay = t1[_t1o + 1], _az = t1[_t1o + 2];
            double _tx = alpha * (t2[_t2o + 0] - _ax) + _ax;
            double _ty = alpha * (t2[_t2o + 1] - _ay) + _ay;
            double _tz = alpha * (t2[_t2o + 2] - _az) + _az;
            double _bx = s1[_s1o + 0], _by = s1[_s1o + 1], _bz = s1[_s1o + 2];
            double _sx = alpha * (s2[_s2o + 0] - _bx) + _bx;
            double _sy = alpha * (s2[_s2o + 1] - _by) + _by;
            double _sz = alpha * (s2[_s2o + 2] - _bz) + _bz;
            double _ux = q1[_q1o + 0], _uy = q1[_q1o + 1], _uz = q1[_q1o + 2], _uw = q1[_q1o + 3];
            double _vx = q2[_q2o + 0], _vy = q2[_q2o + 1], _vz = q2[_q2o + 2], _vw = q2[_q2o + 3];
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
            double _m00 = m[_mo + 0], _m01 = m[_mo + 1], _m02 = m[_mo + 2], _m03 = m[_mo + 3];
            double _m10 = m[_mo + 4], _m11 = m[_mo + 5], _m12 = m[_mo + 6], _m13 = m[_mo + 7];
            double _m20 = m[_mo + 8], _m21 = m[_mo + 9], _m22 = m[_mo + 10], _m23 = m[_mo + 11];
            double _e00 = _t02 * _m20 + (_t01 * _m10 + (_t00 * _m00)), _e01 = _t02 * _m21 + (_t01 * _m11 + (_t00 * _m01)), _e02 = _t02 * _m22 + (_t01 * _m12 + (_t00 * _m02)), _e03 = (_t02 * _m23 + (_t01 * _m13 + (_t00 * _m03))) + _tx;
            double _e10 = _t12 * _m20 + (_t11 * _m10 + (_t10 * _m00)), _e11 = _t12 * _m21 + (_t11 * _m11 + (_t10 * _m01)), _e12 = _t12 * _m22 + (_t11 * _m12 + (_t10 * _m02)), _e13 = (_t12 * _m23 + (_t11 * _m13 + (_t10 * _m03))) + _ty;
            double _e20 = _t22 * _m20 + (_t21 * _m10 + (_t20 * _m00)), _e21 = _t22 * _m21 + (_t21 * _m11 + (_t20 * _m01)), _e22 = _t22 * _m22 + (_t21 * _m12 + (_t20 * _m02)), _e23 = (_t22 * _m23 + (_t21 * _m13 + (_t20 * _m03))) + _tz;
            dest[_do + 0] = _e00;
            dest[_do + 1] = _e01;
            dest[_do + 2] = _e02;
            dest[_do + 3] = _e03;
            dest[_do + 4] = _e10;
            dest[_do + 5] = _e11;
            dest[_do + 6] = _e12;
            dest[_do + 7] = _e13;
            dest[_do + 8] = _e20;
            dest[_do + 9] = _e21;
            dest[_do + 10] = _e22;
            dest[_do + 11] = _e23;
        }
        return dest;
    }

    public static double[] composeTRSMul_fma(double[] dest, int destOffset, double[] translation, int translationOffset, double[] rotation, int rotationOffset, double[] scale, int scaleOffset, double[] m, int mOffset, int count) {
        for (int _i = 0; _i < count; _i++) {
            int _translationo = translationOffset + _i * 3;
            int _rotationo = rotationOffset + _i * 4;
            int _scaleo = scaleOffset + _i * 3;
            int _mo = mOffset + _i * 12;
            int _do = destOffset + _i * 12;
            double _tx = translation[_translationo + 0], _ty = translation[_translationo + 1], _tz = translation[_translationo + 2];
            double _sx = scale[_scaleo + 0], _sy = scale[_scaleo + 1], _sz = scale[_scaleo + 2];
            double _qx = rotation[_rotationo + 0], _qy = rotation[_rotationo + 1], _qz = rotation[_rotationo + 2], _qw = rotation[_rotationo + 3];
            double _xx = _qx * _qx, _yy = _qy * _qy, _zz = _qz * _qz;
            double _xy = _qx * _qy, _xz = _qx * _qz, _yz = _qy * _qz, _xw = _qx * _qw, _yw = _qy * _qw, _zw = _qz * _qw;
            double _t00 = (1 - 2 * (_yy + _zz)) * _sx, _t01 = (2 * (_xy - _zw)) * _sy, _t02 = (2 * (_xz + _yw)) * _sz;
            double _t10 = (2 * (_xy + _zw)) * _sx, _t11 = (1 - 2 * (_xx + _zz)) * _sy, _t12 = (2 * (_yz - _xw)) * _sz;
            double _t20 = (2 * (_xz - _yw)) * _sx, _t21 = (2 * (_yz + _xw)) * _sy, _t22 = (1 - 2 * (_xx + _yy)) * _sz;
            double _m00 = m[_mo + 0], _m01 = m[_mo + 1], _m02 = m[_mo + 2], _m03 = m[_mo + 3];
            double _m10 = m[_mo + 4], _m11 = m[_mo + 5], _m12 = m[_mo + 6], _m13 = m[_mo + 7];
            double _m20 = m[_mo + 8], _m21 = m[_mo + 9], _m22 = m[_mo + 10], _m23 = m[_mo + 11];
            double _e00 = Math.fma(_t02, _m20, Math.fma(_t01, _m10, _t00 * _m00)), _e01 = Math.fma(_t02, _m21, Math.fma(_t01, _m11, _t00 * _m01)), _e02 = Math.fma(_t02, _m22, Math.fma(_t01, _m12, _t00 * _m02)), _e03 = (Math.fma(_t02, _m23, Math.fma(_t01, _m13, _t00 * _m03))) + _tx;
            double _e10 = Math.fma(_t12, _m20, Math.fma(_t11, _m10, _t10 * _m00)), _e11 = Math.fma(_t12, _m21, Math.fma(_t11, _m11, _t10 * _m01)), _e12 = Math.fma(_t12, _m22, Math.fma(_t11, _m12, _t10 * _m02)), _e13 = (Math.fma(_t12, _m23, Math.fma(_t11, _m13, _t10 * _m03))) + _ty;
            double _e20 = Math.fma(_t22, _m20, Math.fma(_t21, _m10, _t20 * _m00)), _e21 = Math.fma(_t22, _m21, Math.fma(_t21, _m11, _t20 * _m01)), _e22 = Math.fma(_t22, _m22, Math.fma(_t21, _m12, _t20 * _m02)), _e23 = (Math.fma(_t22, _m23, Math.fma(_t21, _m13, _t20 * _m03))) + _tz;
            dest[_do + 0] = _e00;
            dest[_do + 1] = _e01;
            dest[_do + 2] = _e02;
            dest[_do + 3] = _e03;
            dest[_do + 4] = _e10;
            dest[_do + 5] = _e11;
            dest[_do + 6] = _e12;
            dest[_do + 7] = _e13;
            dest[_do + 8] = _e20;
            dest[_do + 9] = _e21;
            dest[_do + 10] = _e22;
            dest[_do + 11] = _e23;
        }
        return dest;
    }

    public static double[] composeTRSMul_mulAdd(double[] dest, int destOffset, double[] translation, int translationOffset, double[] rotation, int rotationOffset, double[] scale, int scaleOffset, double[] m, int mOffset, int count) {
        for (int _i = 0; _i < count; _i++) {
            int _translationo = translationOffset + _i * 3;
            int _rotationo = rotationOffset + _i * 4;
            int _scaleo = scaleOffset + _i * 3;
            int _mo = mOffset + _i * 12;
            int _do = destOffset + _i * 12;
            double _tx = translation[_translationo + 0], _ty = translation[_translationo + 1], _tz = translation[_translationo + 2];
            double _sx = scale[_scaleo + 0], _sy = scale[_scaleo + 1], _sz = scale[_scaleo + 2];
            double _qx = rotation[_rotationo + 0], _qy = rotation[_rotationo + 1], _qz = rotation[_rotationo + 2], _qw = rotation[_rotationo + 3];
            double _xx = _qx * _qx, _yy = _qy * _qy, _zz = _qz * _qz;
            double _xy = _qx * _qy, _xz = _qx * _qz, _yz = _qy * _qz, _xw = _qx * _qw, _yw = _qy * _qw, _zw = _qz * _qw;
            double _t00 = (1 - 2 * (_yy + _zz)) * _sx, _t01 = (2 * (_xy - _zw)) * _sy, _t02 = (2 * (_xz + _yw)) * _sz;
            double _t10 = (2 * (_xy + _zw)) * _sx, _t11 = (1 - 2 * (_xx + _zz)) * _sy, _t12 = (2 * (_yz - _xw)) * _sz;
            double _t20 = (2 * (_xz - _yw)) * _sx, _t21 = (2 * (_yz + _xw)) * _sy, _t22 = (1 - 2 * (_xx + _yy)) * _sz;
            double _m00 = m[_mo + 0], _m01 = m[_mo + 1], _m02 = m[_mo + 2], _m03 = m[_mo + 3];
            double _m10 = m[_mo + 4], _m11 = m[_mo + 5], _m12 = m[_mo + 6], _m13 = m[_mo + 7];
            double _m20 = m[_mo + 8], _m21 = m[_mo + 9], _m22 = m[_mo + 10], _m23 = m[_mo + 11];
            double _e00 = _t02 * _m20 + (_t01 * _m10 + (_t00 * _m00)), _e01 = _t02 * _m21 + (_t01 * _m11 + (_t00 * _m01)), _e02 = _t02 * _m22 + (_t01 * _m12 + (_t00 * _m02)), _e03 = (_t02 * _m23 + (_t01 * _m13 + (_t00 * _m03))) + _tx;
            double _e10 = _t12 * _m20 + (_t11 * _m10 + (_t10 * _m00)), _e11 = _t12 * _m21 + (_t11 * _m11 + (_t10 * _m01)), _e12 = _t12 * _m22 + (_t11 * _m12 + (_t10 * _m02)), _e13 = (_t12 * _m23 + (_t11 * _m13 + (_t10 * _m03))) + _ty;
            double _e20 = _t22 * _m20 + (_t21 * _m10 + (_t20 * _m00)), _e21 = _t22 * _m21 + (_t21 * _m11 + (_t20 * _m01)), _e22 = _t22 * _m22 + (_t21 * _m12 + (_t20 * _m02)), _e23 = (_t22 * _m23 + (_t21 * _m13 + (_t20 * _m03))) + _tz;
            dest[_do + 0] = _e00;
            dest[_do + 1] = _e01;
            dest[_do + 2] = _e02;
            dest[_do + 3] = _e03;
            dest[_do + 4] = _e10;
            dest[_do + 5] = _e11;
            dest[_do + 6] = _e12;
            dest[_do + 7] = _e13;
            dest[_do + 8] = _e20;
            dest[_do + 9] = _e21;
            dest[_do + 10] = _e22;
            dest[_do + 11] = _e23;
        }
        return dest;
    }

    public static double[] composeTRSMulPadded_fma(double[] dest, int destOffset, double[] translation, int translationOffset, double[] rotation, int rotationOffset, double[] scale, int scaleOffset, double[] m, int mOffset) {
        double _qx = rotation[rotationOffset + 0], _qy = rotation[rotationOffset + 1], _qz = rotation[rotationOffset + 2], _qw = rotation[rotationOffset + 3];
        double _tx = translation[translationOffset + 0], _ty = translation[translationOffset + 1], _tz = translation[translationOffset + 2];
        double _sx = scale[scaleOffset + 0], _sy = scale[scaleOffset + 1], _sz = scale[scaleOffset + 2];
        double _m00 = m[mOffset + 0], _m01 = m[mOffset + 1], _m02 = m[mOffset + 2], _m03 = m[mOffset + 3];
        double _m10 = m[mOffset + 4], _m11 = m[mOffset + 5], _m12 = m[mOffset + 6], _m13 = m[mOffset + 7];
        double _m20 = m[mOffset + 8], _m21 = m[mOffset + 9], _m22 = m[mOffset + 10], _m23 = m[mOffset + 11];
        double _xx = _qx * _qx, _yy = _qy * _qy, _zz = _qz * _qz;
        double _xy = _qx * _qy, _xz = _qx * _qz, _yz = _qy * _qz, _xw = _qx * _qw, _yw = _qy * _qw, _zw = _qz * _qw;
        double _t00 = (1 - 2 * (_yy + _zz)) * _sx, _t01 = (2 * (_xy - _zw)) * _sy, _t02 = (2 * (_xz + _yw)) * _sz;
        double _t10 = (2 * (_xy + _zw)) * _sx, _t11 = (1 - 2 * (_xx + _zz)) * _sy, _t12 = (2 * (_yz - _xw)) * _sz;
        double _t20 = (2 * (_xz - _yw)) * _sx, _t21 = (2 * (_yz + _xw)) * _sy, _t22 = (1 - 2 * (_xx + _yy)) * _sz;
        double _e00 = Math.fma(_t02, _m20, Math.fma(_t01, _m10, _t00 * _m00)), _e01 = Math.fma(_t02, _m21, Math.fma(_t01, _m11, _t00 * _m01)), _e02 = Math.fma(_t02, _m22, Math.fma(_t01, _m12, _t00 * _m02)), _e03 = (Math.fma(_t02, _m23, Math.fma(_t01, _m13, _t00 * _m03))) + _tx;
        double _e10 = Math.fma(_t12, _m20, Math.fma(_t11, _m10, _t10 * _m00)), _e11 = Math.fma(_t12, _m21, Math.fma(_t11, _m11, _t10 * _m01)), _e12 = Math.fma(_t12, _m22, Math.fma(_t11, _m12, _t10 * _m02)), _e13 = (Math.fma(_t12, _m23, Math.fma(_t11, _m13, _t10 * _m03))) + _ty;
        double _e20 = Math.fma(_t22, _m20, Math.fma(_t21, _m10, _t20 * _m00)), _e21 = Math.fma(_t22, _m21, Math.fma(_t21, _m11, _t20 * _m01)), _e22 = Math.fma(_t22, _m22, Math.fma(_t21, _m12, _t20 * _m02)), _e23 = (Math.fma(_t22, _m23, Math.fma(_t21, _m13, _t20 * _m03))) + _tz;
        dest[destOffset + 0] = _e00;
        dest[destOffset + 1] = _e01;
        dest[destOffset + 2] = _e02;
        dest[destOffset + 3] = _e03;
        dest[destOffset + 4] = _e10;
        dest[destOffset + 5] = _e11;
        dest[destOffset + 6] = _e12;
        dest[destOffset + 7] = _e13;
        dest[destOffset + 8] = _e20;
        dest[destOffset + 9] = _e21;
        dest[destOffset + 10] = _e22;
        dest[destOffset + 11] = _e23;
        return dest;
    }

    public static double[] composeTRSMulPadded_mulAdd(double[] dest, int destOffset, double[] translation, int translationOffset, double[] rotation, int rotationOffset, double[] scale, int scaleOffset, double[] m, int mOffset) {
        double _qx = rotation[rotationOffset + 0], _qy = rotation[rotationOffset + 1], _qz = rotation[rotationOffset + 2], _qw = rotation[rotationOffset + 3];
        double _tx = translation[translationOffset + 0], _ty = translation[translationOffset + 1], _tz = translation[translationOffset + 2];
        double _sx = scale[scaleOffset + 0], _sy = scale[scaleOffset + 1], _sz = scale[scaleOffset + 2];
        double _m00 = m[mOffset + 0], _m01 = m[mOffset + 1], _m02 = m[mOffset + 2], _m03 = m[mOffset + 3];
        double _m10 = m[mOffset + 4], _m11 = m[mOffset + 5], _m12 = m[mOffset + 6], _m13 = m[mOffset + 7];
        double _m20 = m[mOffset + 8], _m21 = m[mOffset + 9], _m22 = m[mOffset + 10], _m23 = m[mOffset + 11];
        double _xx = _qx * _qx, _yy = _qy * _qy, _zz = _qz * _qz;
        double _xy = _qx * _qy, _xz = _qx * _qz, _yz = _qy * _qz, _xw = _qx * _qw, _yw = _qy * _qw, _zw = _qz * _qw;
        double _t00 = (1 - 2 * (_yy + _zz)) * _sx, _t01 = (2 * (_xy - _zw)) * _sy, _t02 = (2 * (_xz + _yw)) * _sz;
        double _t10 = (2 * (_xy + _zw)) * _sx, _t11 = (1 - 2 * (_xx + _zz)) * _sy, _t12 = (2 * (_yz - _xw)) * _sz;
        double _t20 = (2 * (_xz - _yw)) * _sx, _t21 = (2 * (_yz + _xw)) * _sy, _t22 = (1 - 2 * (_xx + _yy)) * _sz;
        double _e00 = _t02 * _m20 + (_t01 * _m10 + (_t00 * _m00)), _e01 = _t02 * _m21 + (_t01 * _m11 + (_t00 * _m01)), _e02 = _t02 * _m22 + (_t01 * _m12 + (_t00 * _m02)), _e03 = (_t02 * _m23 + (_t01 * _m13 + (_t00 * _m03))) + _tx;
        double _e10 = _t12 * _m20 + (_t11 * _m10 + (_t10 * _m00)), _e11 = _t12 * _m21 + (_t11 * _m11 + (_t10 * _m01)), _e12 = _t12 * _m22 + (_t11 * _m12 + (_t10 * _m02)), _e13 = (_t12 * _m23 + (_t11 * _m13 + (_t10 * _m03))) + _ty;
        double _e20 = _t22 * _m20 + (_t21 * _m10 + (_t20 * _m00)), _e21 = _t22 * _m21 + (_t21 * _m11 + (_t20 * _m01)), _e22 = _t22 * _m22 + (_t21 * _m12 + (_t20 * _m02)), _e23 = (_t22 * _m23 + (_t21 * _m13 + (_t20 * _m03))) + _tz;
        dest[destOffset + 0] = _e00;
        dest[destOffset + 1] = _e01;
        dest[destOffset + 2] = _e02;
        dest[destOffset + 3] = _e03;
        dest[destOffset + 4] = _e10;
        dest[destOffset + 5] = _e11;
        dest[destOffset + 6] = _e12;
        dest[destOffset + 7] = _e13;
        dest[destOffset + 8] = _e20;
        dest[destOffset + 9] = _e21;
        dest[destOffset + 10] = _e22;
        dest[destOffset + 11] = _e23;
        return dest;
    }

}
