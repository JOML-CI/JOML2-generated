package org.joml2.internal.kernels;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.ops.*;
import org.joml2.internal.unsafe.*;

/**
 * Scalar/Unsafe kernel leaves of {@link Double3x4Ops} whose leading storage
 * parameter is a {@code double[]} array. Split into a sibling compilation unit purely
 * to keep generated sources IDE-sized; package-private, called only from
 * {@code Double3x4Ops} and its sibling kernel units. Not public API.
 */
public final class Double3x4OpsKernelsArray {
    private Double3x4OpsKernelsArray() {}

    public static double[] lookAt_lh(double[] dest, int destOffset, double[] src, int srcOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
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

}
