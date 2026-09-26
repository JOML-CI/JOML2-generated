// Copyright (c) 2015-2026 JOML
// SPDX-License-Identifier: MIT
package org.joml2.internal.kernels;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.ops.*;
import org.joml2.internal.unsafe.*;

/**
 * Scalar/Unsafe kernel leaves of {@link Float3Ops} whose leading storage
 * parameter is a {@code float[]} array. Split into a sibling compilation unit purely
 * to keep generated sources IDE-sized; package-private, called only from
 * {@code Float3Ops} and its sibling kernel units. Not public API.
 */
public final class Float3OpsKernelsArray {
    private Float3OpsKernelsArray() {}

    public static float[] slerp_degenerate(float[] dest, int destOffset, float[] src, int srcOffset, float otherX, float otherY, float otherZ, float t) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _t0 = unitScale(otherX, otherY, otherZ);
        float _t1 = unitScale(_selfx, _selfy, _selfz);
        float _t8 = otherZ * _t0;
        float _t9 = otherX * _t0;
        float _t10 = otherY * _t0;
        float _t11 = _selfz * _t1;
        float _t12 = _selfx * _t1;
        float _t13 = _selfy * _t1;
        float _t18 = Math.fma(_t8, _t8, Math.fma(_t9, _t9, _t10 * _t10));
        float _t19 = Math.fma(_t11, _t11, Math.fma(_t12, _t12, _t13 * _t13));
        float _t22 = (1.0f / (float) Math.sqrt(_t18));
        float _t23 = (1.0f / (float) Math.sqrt(_t19));
        float _t25 = (float) Math.sqrt(_t19) / _t1;
        float _t27 = _t23 * _t11;
        float _t29 = _t23 * _t12;
        float _t31 = _t23 * _t13;
        float _t32 = Math.abs(_t27);
        float _t33 = Math.abs(_t29);
        float _t36 = _t18 * _t19;
        float _t39 = Math.fma(t, (float) Math.sqrt(_t18) / _t0 - _t25, _t25);
        float _t40, _t41, _t43;
        if (_t32 < _t33) {
            _t40 = _t31;
            _t41 = 0.0f;
            _t43 = -_t29;
        } else {
            _t40 = 0.0f;
            _t41 = -_t31;
            _t43 = _t27;
        }
        float _t44 = Math.fma(_t22 * _t8, _t27, Math.fma(_t22 * _t9, _t29, _t22 * _t10 * _t31));
        float _t52 = Math.fma(_t22, _t8, -(_t44 * _t27));
        float _t53 = Math.fma(_t22, _t9, -(_t44 * _t29));
        float _t54 = Math.fma(_t22, _t10, -(_t44 * _t31));
        float _t59 = (1.0f / (float) Math.sqrt(Math.fma(_t41, _t41, Math.fma(_t43, _t43, _t40 * _t40))));
        float _t61 = -Math.fma(_t52, _t27, Math.fma(_t53, _t29, _t54 * _t31));
        float _t62 = Math.fma(_t61, _t27, _t52);
        float _t63 = Math.fma(_t61, _t29, _t53);
        float _t64 = Math.fma(_t61, _t31, _t54);
        float _t65 = unitScale(_t63, _t64, _t62);
        float _t71 = _t62 * _t65;
        float _t72 = _t63 * _t65;
        float _t73 = _t64 * _t65;
        float _t76 = Math.fma(_t71, _t71, Math.fma(_t72, _t72, _t73 * _t73));
        float _t78 = (1.0f / (float) Math.sqrt(_t76));
        float _t80 = t * (float) Math.atan2((float) Math.sqrt(_t76), _t44 * _t65);
        float _t81 = (float) Math.sin(_t80);
        float _t82 = _t39 * _t81;
        float _t84 = _t39 * (float) Math.cosFromSin(_t81, _t80);
        if (_t36 > 0.0f) {
            if (_t76 > 0.0f) {
                dest[destOffset + 0] = Math.fma(_t82, _t78 * _t72, _t84 * _t29);
                dest[destOffset + 1] = Math.fma(_t82, _t78 * _t73, _t84 * _t31);
                dest[destOffset + 2] = Math.fma(_t82, _t78 * _t71, _t84 * _t27);
            } else {
                dest[destOffset + 0] = Math.fma(_t82, _t59 * _t40, _t84 * _t29);
                dest[destOffset + 1] = Math.fma(_t82, _t59 * _t43, _t84 * _t31);
                dest[destOffset + 2] = Math.fma(_t82, _t59 * _t41, _t84 * _t27);
            }
        } else {
            dest[destOffset + 0] = Math.fma(t, otherX - _selfx, _selfx);
            dest[destOffset + 1] = Math.fma(t, otherY - _selfy, _selfy);
            dest[destOffset + 2] = Math.fma(t, otherZ - _selfz, _selfz);
        }
        return dest;
    }

    public static float[] slerp_degenerate(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset, float t) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _otherx = other[otherOffset + 0];
        float _othery = other[otherOffset + 1];
        float _otherz = other[otherOffset + 2];
        float _t0 = unitScale(_otherx, _othery, _otherz);
        float _t1 = unitScale(_selfx, _selfy, _selfz);
        float _t8 = _otherz * _t0;
        float _t9 = _otherx * _t0;
        float _t10 = _othery * _t0;
        float _t11 = _selfz * _t1;
        float _t12 = _selfx * _t1;
        float _t13 = _selfy * _t1;
        float _t18 = Math.fma(_t8, _t8, Math.fma(_t9, _t9, _t10 * _t10));
        float _t19 = Math.fma(_t11, _t11, Math.fma(_t12, _t12, _t13 * _t13));
        float _t22 = (1.0f / (float) Math.sqrt(_t18));
        float _t23 = (1.0f / (float) Math.sqrt(_t19));
        float _t25 = (float) Math.sqrt(_t19) / _t1;
        float _t27 = _t23 * _t11;
        float _t29 = _t23 * _t12;
        float _t31 = _t23 * _t13;
        float _t32 = Math.abs(_t27);
        float _t33 = Math.abs(_t29);
        float _t36 = _t18 * _t19;
        float _t39 = Math.fma(t, (float) Math.sqrt(_t18) / _t0 - _t25, _t25);
        float _t40, _t41, _t43;
        if (_t32 < _t33) {
            _t40 = _t31;
            _t41 = 0.0f;
            _t43 = -_t29;
        } else {
            _t40 = 0.0f;
            _t41 = -_t31;
            _t43 = _t27;
        }
        float _t44 = Math.fma(_t22 * _t8, _t27, Math.fma(_t22 * _t9, _t29, _t22 * _t10 * _t31));
        float _t52 = Math.fma(_t22, _t8, -(_t44 * _t27));
        float _t53 = Math.fma(_t22, _t9, -(_t44 * _t29));
        float _t54 = Math.fma(_t22, _t10, -(_t44 * _t31));
        float _t59 = (1.0f / (float) Math.sqrt(Math.fma(_t41, _t41, Math.fma(_t43, _t43, _t40 * _t40))));
        float _t61 = -Math.fma(_t52, _t27, Math.fma(_t53, _t29, _t54 * _t31));
        float _t62 = Math.fma(_t61, _t27, _t52);
        float _t63 = Math.fma(_t61, _t29, _t53);
        float _t64 = Math.fma(_t61, _t31, _t54);
        float _t65 = unitScale(_t63, _t64, _t62);
        float _t71 = _t62 * _t65;
        float _t72 = _t63 * _t65;
        float _t73 = _t64 * _t65;
        float _t76 = Math.fma(_t71, _t71, Math.fma(_t72, _t72, _t73 * _t73));
        float _t78 = (1.0f / (float) Math.sqrt(_t76));
        float _t80 = t * (float) Math.atan2((float) Math.sqrt(_t76), _t44 * _t65);
        float _t81 = (float) Math.sin(_t80);
        float _t82 = _t39 * _t81;
        float _t84 = _t39 * (float) Math.cosFromSin(_t81, _t80);
        if (_t36 > 0.0f) {
            if (_t76 > 0.0f) {
                dest[destOffset + 0] = Math.fma(_t82, _t78 * _t72, _t84 * _t29);
                dest[destOffset + 1] = Math.fma(_t82, _t78 * _t73, _t84 * _t31);
                dest[destOffset + 2] = Math.fma(_t82, _t78 * _t71, _t84 * _t27);
            } else {
                dest[destOffset + 0] = Math.fma(_t82, _t59 * _t40, _t84 * _t29);
                dest[destOffset + 1] = Math.fma(_t82, _t59 * _t43, _t84 * _t31);
                dest[destOffset + 2] = Math.fma(_t82, _t59 * _t41, _t84 * _t27);
            }
        } else {
            dest[destOffset + 0] = Math.fma(t, _otherx - _selfx, _selfx);
            dest[destOffset + 1] = Math.fma(t, _othery - _selfy, _selfy);
            dest[destOffset + 2] = Math.fma(t, _otherz - _selfz, _selfz);
        }
        return dest;
    }

    public static float angleBetween_degenerate(float[] src, int srcOffset, float otherX, float otherY, float otherZ) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _t0 = unitScale(otherX, otherY, otherZ);
        float _t1 = unitScale(_selfx, _selfy, _selfz);
        float _t8 = otherZ * _t0;
        float _t9 = _selfy * _t1;
        float _t10 = otherY * _t0;
        float _t11 = _selfz * _t1;
        float _t12 = _selfx * _t1;
        float _t13 = otherX * _t0;
        float _t20 = Math.fma(_t8, _t9, -(_t10 * _t11));
        float _t21 = Math.fma(_t10, _t12, -(_t13 * _t9));
        float _t22 = Math.fma(_t8, _t12, -(_t13 * _t11));
        float _t23 = unitScale(_t21, _t22, _t20);
        float _t27 = _t20 * _t23;
        float _t28 = _t21 * _t23;
        float _t29 = _t22 * _t23;
        return (float) Math.atan2((float) Math.sqrt(Math.fma(_t27, _t27, Math.fma(_t28, _t28, _t29 * _t29))), Math.fma(_t8, _t11, Math.fma(_t13, _t12, _t10 * _t9)) * _t23);
    }

    public static float angleBetween_degenerate(float[] src, int srcOffset, float[] other, int otherOffset) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _otherx = other[otherOffset + 0];
        float _othery = other[otherOffset + 1];
        float _otherz = other[otherOffset + 2];
        float _t0 = unitScale(_otherx, _othery, _otherz);
        float _t1 = unitScale(_selfx, _selfy, _selfz);
        float _t8 = _otherz * _t0;
        float _t9 = _selfy * _t1;
        float _t10 = _othery * _t0;
        float _t11 = _selfz * _t1;
        float _t12 = _selfx * _t1;
        float _t13 = _otherx * _t0;
        float _t20 = Math.fma(_t8, _t9, -(_t10 * _t11));
        float _t21 = Math.fma(_t10, _t12, -(_t13 * _t9));
        float _t22 = Math.fma(_t8, _t12, -(_t13 * _t11));
        float _t23 = unitScale(_t21, _t22, _t20);
        float _t27 = _t20 * _t23;
        float _t28 = _t21 * _t23;
        float _t29 = _t22 * _t23;
        return (float) Math.atan2((float) Math.sqrt(Math.fma(_t27, _t27, Math.fma(_t28, _t28, _t29 * _t29))), Math.fma(_t8, _t11, Math.fma(_t13, _t12, _t10 * _t9)) * _t23);
    }

    public static float orientedAngle_degenerate(float[] src, int srcOffset, float otherX, float otherY, float otherZ, float normalX, float normalY, float normalZ) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _t0 = unitScale(normalX, normalY, normalZ);
        float _t1 = unitScale(otherX, otherY, otherZ);
        float _t2 = unitScale(_selfx, _selfy, _selfz);
        float _t9 = otherY * _t1;
        float _t10 = _selfx * _t2;
        float _t11 = otherX * _t1;
        float _t12 = _selfy * _t2;
        float _t13 = otherZ * _t1;
        float _t14 = _selfz * _t2;
        float _t23 = Math.fma(_t9, _t10, -(_t11 * _t12));
        float _t24 = Math.fma(_t13, _t12, -(_t9 * _t14));
        float _t25 = Math.fma(_t11, _t14, -(_t13 * _t10));
        float _t27 = unitScale(_t24, _t25, _t23);
        float _t31 = _t23 * _t27;
        float _t32 = _t24 * _t27;
        float _t33 = _t25 * _t27;
        float _t40 = (float) Math.atan2((float) Math.sqrt(Math.fma(_t31, _t31, Math.fma(_t33, _t33, _t32 * _t32))), Math.fma(_t13, _t14, Math.fma(_t11, _t10, _t9 * _t12)) * _t27);
        return Math.fma(normalZ * _t0, _t31, Math.fma(normalX * _t0, _t32, normalY * _t0 * _t33)) < 0.0f ? -_t40 : _t40;
    }

    public static float orientedAngle_degenerate(float[] src, int srcOffset, float[] other, int otherOffset, float[] normal, int normalOffset) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _otherx = other[otherOffset + 0];
        float _othery = other[otherOffset + 1];
        float _otherz = other[otherOffset + 2];
        float _normalx = normal[normalOffset + 0];
        float _normaly = normal[normalOffset + 1];
        float _normalz = normal[normalOffset + 2];
        float _t0 = unitScale(_normalx, _normaly, _normalz);
        float _t1 = unitScale(_otherx, _othery, _otherz);
        float _t2 = unitScale(_selfx, _selfy, _selfz);
        float _t9 = _othery * _t1;
        float _t10 = _selfx * _t2;
        float _t11 = _otherx * _t1;
        float _t12 = _selfy * _t2;
        float _t13 = _otherz * _t1;
        float _t14 = _selfz * _t2;
        float _t23 = Math.fma(_t9, _t10, -(_t11 * _t12));
        float _t24 = Math.fma(_t13, _t12, -(_t9 * _t14));
        float _t25 = Math.fma(_t11, _t14, -(_t13 * _t10));
        float _t27 = unitScale(_t24, _t25, _t23);
        float _t31 = _t23 * _t27;
        float _t32 = _t24 * _t27;
        float _t33 = _t25 * _t27;
        float _t40 = (float) Math.atan2((float) Math.sqrt(Math.fma(_t31, _t31, Math.fma(_t33, _t33, _t32 * _t32))), Math.fma(_t13, _t14, Math.fma(_t11, _t10, _t9 * _t12)) * _t27);
        return Math.fma(_normalz * _t0, _t31, Math.fma(_normalx * _t0, _t32, _normaly * _t0 * _t33)) < 0.0f ? -_t40 : _t40;
    }

    public static float[] triangleNormal_degenerate(float[] dest, int destOffset, float[] src, int srcOffset, float p1X, float p1Y, float p1Z, float p2X, float p2Y, float p2Z) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _t0 = p1X - _selfx;
        float _t1 = p1Y - _selfy;
        float _t2 = p1Z - _selfz;
        float _t3 = p2Y - _selfy;
        float _t4 = p2X - _selfx;
        float _t5 = p2Z - _selfz;
        float _t6 = unitScale(_t0, _t1, _t2);
        float _t7 = unitScale(_t4, _t3, _t5);
        float _t14 = _t0 * _t6;
        float _t15 = _t3 * _t7;
        float _t16 = _t1 * _t6;
        float _t17 = _t4 * _t7;
        float _t18 = _t5 * _t7;
        float _t19 = _t2 * _t6;
        float _t26 = Math.fma(_t14, _t15, -(_t16 * _t17));
        float _t27 = Math.fma(_t16, _t18, -(_t19 * _t15));
        float _t28 = Math.fma(_t19, _t17, -(_t14 * _t18));
        float _t29 = unitScale(_t27, _t28, _t26);
        float _t33 = _t26 * _t29;
        float _t34 = _t27 * _t29;
        float _t35 = _t28 * _t29;
        float _t38 = Math.fma(_t33, _t33, Math.fma(_t34, _t34, _t35 * _t35));
        float _t39 = (1.0f / (float) Math.sqrt(_t38));
        if (_t38 != 0.0f) {
            dest[destOffset + 0] = _t39 * _t34;
            dest[destOffset + 1] = _t39 * _t35;
            dest[destOffset + 2] = _t39 * _t33;
        } else {
            dest[destOffset + 0] = 0.0f;
            dest[destOffset + 1] = 0.0f;
            dest[destOffset + 2] = 0.0f;
        }
        return dest;
    }

    public static float[] triangleNormal_degenerate(float[] dest, int destOffset, float[] src, int srcOffset, float[] p1, int p1Offset, float[] p2, int p2Offset) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _p1x = p1[p1Offset + 0];
        float _p1y = p1[p1Offset + 1];
        float _p1z = p1[p1Offset + 2];
        float _p2x = p2[p2Offset + 0];
        float _p2y = p2[p2Offset + 1];
        float _p2z = p2[p2Offset + 2];
        float _t0 = _p1x - _selfx;
        float _t1 = _p1y - _selfy;
        float _t2 = _p1z - _selfz;
        float _t3 = _p2y - _selfy;
        float _t4 = _p2x - _selfx;
        float _t5 = _p2z - _selfz;
        float _t6 = unitScale(_t0, _t1, _t2);
        float _t7 = unitScale(_t4, _t3, _t5);
        float _t14 = _t0 * _t6;
        float _t15 = _t3 * _t7;
        float _t16 = _t1 * _t6;
        float _t17 = _t4 * _t7;
        float _t18 = _t5 * _t7;
        float _t19 = _t2 * _t6;
        float _t26 = Math.fma(_t14, _t15, -(_t16 * _t17));
        float _t27 = Math.fma(_t16, _t18, -(_t19 * _t15));
        float _t28 = Math.fma(_t19, _t17, -(_t14 * _t18));
        float _t29 = unitScale(_t27, _t28, _t26);
        float _t33 = _t26 * _t29;
        float _t34 = _t27 * _t29;
        float _t35 = _t28 * _t29;
        float _t38 = Math.fma(_t33, _t33, Math.fma(_t34, _t34, _t35 * _t35));
        float _t39 = (1.0f / (float) Math.sqrt(_t38));
        if (_t38 != 0.0f) {
            dest[destOffset + 0] = _t39 * _t34;
            dest[destOffset + 1] = _t39 * _t35;
            dest[destOffset + 2] = _t39 * _t33;
        } else {
            dest[destOffset + 0] = 0.0f;
            dest[destOffset + 1] = 0.0f;
            dest[destOffset + 2] = 0.0f;
        }
        return dest;
    }

    /**
     * The power of two that brings max(|a|, |b|, |c|) into [1, 2), from the largest exponent
     * field: multiplying by it is exact. Clamped to [2^-126, 2^126], so zero and subnormal
     * values scale up without overflow and the largest floats land in [2, 4).
     */
    private static float unitScale(float a, float b, float c) {
        int e = java.lang.Math.max(java.lang.Math.max(Float.floatToRawIntBits(a) & 0x7F800000,
                Float.floatToRawIntBits(b) & 0x7F800000), Float.floatToRawIntBits(c) & 0x7F800000);
        return Float.intBitsToFloat(0x7F000000 - java.lang.Math.min(java.lang.Math.max(e, 0x00800000), 0x7E800000));
    }

    /** Double-precision twin of {@link #unitScale(float, float, float)}. */
    private static double unitScale(double a, double b, double c) {
        long e = java.lang.Math.max(java.lang.Math.max(Double.doubleToRawLongBits(a) & 0x7FF0000000000000L,
                Double.doubleToRawLongBits(b) & 0x7FF0000000000000L), Double.doubleToRawLongBits(c) & 0x7FF0000000000000L);
        return Double.longBitsToDouble(0x7FE0000000000000L
                - java.lang.Math.min(java.lang.Math.max(e, 0x0010000000000000L), 0x7FD0000000000000L));
    }
}
