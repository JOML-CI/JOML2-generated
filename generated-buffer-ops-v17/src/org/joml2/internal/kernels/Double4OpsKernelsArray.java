// Copyright (c) 2015-2026 JOML
// SPDX-License-Identifier: MIT
package org.joml2.internal.kernels;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.ops.*;
import org.joml2.internal.unsafe.*;

/**
 * Scalar/Unsafe kernel leaves of {@link Double4Ops} whose leading storage
 * parameter is a {@code double[]} array. Split into a sibling compilation unit purely
 * to keep generated sources IDE-sized; package-private, called only from
 * {@code Double4Ops} and its sibling kernel units. Not public API.
 */
public final class Double4OpsKernelsArray {
    private Double4OpsKernelsArray() {}

    public static double[] slerp_degenerate(double[] dest, int destOffset, double[] src, int srcOffset, double otherX, double otherY, double otherZ, double otherW, double t) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t6 = unitScale(otherZ, otherW, Math.max(Math.abs(otherX), Math.abs(otherY)));
        double _t7 = unitScale(_selfz, _selfw, Math.max(Math.abs(_selfx), Math.abs(_selfy)));
        double _t16 = otherW * _t6;
        double _t17 = otherZ * _t6;
        double _t18 = otherX * _t6;
        double _t19 = otherY * _t6;
        double _t20 = _selfw * _t7;
        double _t21 = _selfz * _t7;
        double _t22 = _selfx * _t7;
        double _t23 = _selfy * _t7;
        double _t30 = Math.fma(_t16, _t16, Math.fma(_t17, _t17, Math.fma(_t18, _t18, _t19 * _t19)));
        double _t31 = Math.fma(_t20, _t20, Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23)));
        double _t34 = (1.0 / Math.sqrt(_t30));
        double _t35 = (1.0 / Math.sqrt(_t31));
        double _t37 = Math.sqrt(_t31) / _t7;
        double _t39 = _t35 * _t20;
        double _t41 = _t35 * _t21;
        double _t43 = _t35 * _t22;
        double _t45 = _t35 * _t23;
        double _t46 = _t30 * _t31;
        double _t49 = Math.fma(t, Math.sqrt(_t30) / _t6 - _t37, _t37);
        double _t52 = Math.fma(_t34 * _t16, _t39, Math.fma(_t34 * _t17, _t41, Math.fma(_t34 * _t18, _t43, _t34 * _t19 * _t45)));
        double _t61 = Math.fma(_t34, _t16, -(_t52 * _t39));
        double _t62 = Math.fma(_t34, _t17, -(_t52 * _t41));
        double _t63 = Math.fma(_t34, _t18, -(_t52 * _t43));
        double _t64 = Math.fma(_t34, _t19, -(_t52 * _t45));
        double _t69 = -Math.fma(_t61, _t39, Math.fma(_t62, _t41, Math.fma(_t63, _t43, _t64 * _t45)));
        double _t70 = Math.fma(_t69, _t39, _t61);
        double _t71 = Math.fma(_t69, _t41, _t62);
        double _t72 = Math.fma(_t69, _t43, _t63);
        double _t73 = Math.fma(_t69, _t45, _t64);
        double _t77 = unitScale(_t71, _t70, Math.max(Math.abs(_t72), Math.abs(_t73)));
        double _t84 = _t70 * _t77;
        double _t85 = _t71 * _t77;
        double _t86 = _t72 * _t77;
        double _t87 = _t73 * _t77;
        double _t91 = Math.fma(_t84, _t84, Math.fma(_t85, _t85, Math.fma(_t86, _t86, _t87 * _t87)));
        double _t93 = (1.0 / Math.sqrt(_t91));
        double _t95 = t * Math.atan2(Math.sqrt(_t91), _t52 * _t77);
        double _t96 = Math.sin(_t95);
        double _t97 = _t49 * _t96;
        double _t99 = _t49 * Math.cosFromSin(_t96, _t95);
        if (_t46 > 0.0) {
            if (_t91 > 0.0) {
                dest[destOffset + 0] = Math.fma(_t97, _t93 * _t86, _t99 * _t43);
                dest[destOffset + 1] = Math.fma(_t97, _t93 * _t87, _t99 * _t45);
                dest[destOffset + 2] = Math.fma(_t97, _t93 * _t85, _t99 * _t41);
                dest[destOffset + 3] = Math.fma(_t97, _t93 * _t84, _t99 * _t39);
            } else {
                dest[destOffset + 0] = Math.fma(_t97, -_t45, _t99 * _t43);
                dest[destOffset + 1] = Math.fma(_t97, _t43, _t99 * _t45);
                dest[destOffset + 2] = Math.fma(_t97, -_t39, _t99 * _t41);
                dest[destOffset + 3] = Math.fma(_t97, _t41, _t99 * _t39);
            }
        } else {
            dest[destOffset + 0] = Math.fma(t, otherX - _selfx, _selfx);
            dest[destOffset + 1] = Math.fma(t, otherY - _selfy, _selfy);
            dest[destOffset + 2] = Math.fma(t, otherZ - _selfz, _selfz);
            dest[destOffset + 3] = Math.fma(t, otherW - _selfw, _selfw);
        }
        return dest;
    }

    public static double[] slerp_degenerate(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset, double t) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _otherx = other[otherOffset + 0];
        double _othery = other[otherOffset + 1];
        double _otherz = other[otherOffset + 2];
        double _otherw = other[otherOffset + 3];
        double _t6 = unitScale(_otherz, _otherw, Math.max(Math.abs(_otherx), Math.abs(_othery)));
        double _t7 = unitScale(_selfz, _selfw, Math.max(Math.abs(_selfx), Math.abs(_selfy)));
        double _t16 = _otherw * _t6;
        double _t17 = _otherz * _t6;
        double _t18 = _otherx * _t6;
        double _t19 = _othery * _t6;
        double _t20 = _selfw * _t7;
        double _t21 = _selfz * _t7;
        double _t22 = _selfx * _t7;
        double _t23 = _selfy * _t7;
        double _t30 = Math.fma(_t16, _t16, Math.fma(_t17, _t17, Math.fma(_t18, _t18, _t19 * _t19)));
        double _t31 = Math.fma(_t20, _t20, Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23)));
        double _t34 = (1.0 / Math.sqrt(_t30));
        double _t35 = (1.0 / Math.sqrt(_t31));
        double _t37 = Math.sqrt(_t31) / _t7;
        double _t39 = _t35 * _t20;
        double _t41 = _t35 * _t21;
        double _t43 = _t35 * _t22;
        double _t45 = _t35 * _t23;
        double _t46 = _t30 * _t31;
        double _t49 = Math.fma(t, Math.sqrt(_t30) / _t6 - _t37, _t37);
        double _t52 = Math.fma(_t34 * _t16, _t39, Math.fma(_t34 * _t17, _t41, Math.fma(_t34 * _t18, _t43, _t34 * _t19 * _t45)));
        double _t61 = Math.fma(_t34, _t16, -(_t52 * _t39));
        double _t62 = Math.fma(_t34, _t17, -(_t52 * _t41));
        double _t63 = Math.fma(_t34, _t18, -(_t52 * _t43));
        double _t64 = Math.fma(_t34, _t19, -(_t52 * _t45));
        double _t69 = -Math.fma(_t61, _t39, Math.fma(_t62, _t41, Math.fma(_t63, _t43, _t64 * _t45)));
        double _t70 = Math.fma(_t69, _t39, _t61);
        double _t71 = Math.fma(_t69, _t41, _t62);
        double _t72 = Math.fma(_t69, _t43, _t63);
        double _t73 = Math.fma(_t69, _t45, _t64);
        double _t77 = unitScale(_t71, _t70, Math.max(Math.abs(_t72), Math.abs(_t73)));
        double _t84 = _t70 * _t77;
        double _t85 = _t71 * _t77;
        double _t86 = _t72 * _t77;
        double _t87 = _t73 * _t77;
        double _t91 = Math.fma(_t84, _t84, Math.fma(_t85, _t85, Math.fma(_t86, _t86, _t87 * _t87)));
        double _t93 = (1.0 / Math.sqrt(_t91));
        double _t95 = t * Math.atan2(Math.sqrt(_t91), _t52 * _t77);
        double _t96 = Math.sin(_t95);
        double _t97 = _t49 * _t96;
        double _t99 = _t49 * Math.cosFromSin(_t96, _t95);
        if (_t46 > 0.0) {
            if (_t91 > 0.0) {
                dest[destOffset + 0] = Math.fma(_t97, _t93 * _t86, _t99 * _t43);
                dest[destOffset + 1] = Math.fma(_t97, _t93 * _t87, _t99 * _t45);
                dest[destOffset + 2] = Math.fma(_t97, _t93 * _t85, _t99 * _t41);
                dest[destOffset + 3] = Math.fma(_t97, _t93 * _t84, _t99 * _t39);
            } else {
                dest[destOffset + 0] = Math.fma(_t97, -_t45, _t99 * _t43);
                dest[destOffset + 1] = Math.fma(_t97, _t43, _t99 * _t45);
                dest[destOffset + 2] = Math.fma(_t97, -_t39, _t99 * _t41);
                dest[destOffset + 3] = Math.fma(_t97, _t41, _t99 * _t39);
            }
        } else {
            dest[destOffset + 0] = Math.fma(t, _otherx - _selfx, _selfx);
            dest[destOffset + 1] = Math.fma(t, _othery - _selfy, _selfy);
            dest[destOffset + 2] = Math.fma(t, _otherz - _selfz, _selfz);
            dest[destOffset + 3] = Math.fma(t, _otherw - _selfw, _selfw);
        }
        return dest;
    }

    public static double angleBetween_degenerate(double[] src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t6 = unitScale(otherZ, otherW, Math.max(Math.abs(otherX), Math.abs(otherY)));
        double _t7 = unitScale(_selfz, _selfw, Math.max(Math.abs(_selfx), Math.abs(_selfy)));
        double _t16 = otherW * _t6;
        double _t17 = _selfz * _t7;
        double _t18 = otherZ * _t6;
        double _t19 = _selfw * _t7;
        double _t20 = otherY * _t6;
        double _t21 = _selfx * _t7;
        double _t22 = otherX * _t6;
        double _t23 = _selfy * _t7;
        double _t36 = Math.fma(_t16, _t17, -(_t18 * _t19));
        double _t37 = Math.fma(_t20, _t21, -(_t22 * _t23));
        double _t38 = Math.fma(_t18, _t21, -(_t22 * _t17));
        double _t39 = Math.fma(_t16, _t21, -(_t22 * _t19));
        double _t40 = Math.fma(_t18, _t23, -(_t20 * _t17));
        double _t41 = Math.fma(_t16, _t23, -(_t20 * _t19));
        double _t51 = unitScale(Math.max(Math.abs(_t37), Math.abs(_t38)), Math.max(Math.abs(_t39), Math.abs(_t40)), Math.max(Math.abs(_t41), Math.abs(_t36)));
        double _t58 = _t36 * _t51;
        double _t59 = _t41 * _t51;
        double _t60 = _t40 * _t51;
        double _t61 = _t39 * _t51;
        double _t62 = _t37 * _t51;
        double _t63 = _t38 * _t51;
        return Math.atan2(Math.sqrt(Math.fma(_t58, _t58, Math.fma(_t59, _t59, Math.fma(_t60, _t60, Math.fma(_t61, _t61, Math.fma(_t62, _t62, _t63 * _t63)))))), Math.fma(_t16, _t19, Math.fma(_t18, _t17, Math.fma(_t22, _t21, _t20 * _t23))) * _t51);
    }

    public static double angleBetween_degenerate(double[] src, int srcOffset, double[] other, int otherOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _otherx = other[otherOffset + 0];
        double _othery = other[otherOffset + 1];
        double _otherz = other[otherOffset + 2];
        double _otherw = other[otherOffset + 3];
        double _t6 = unitScale(_otherz, _otherw, Math.max(Math.abs(_otherx), Math.abs(_othery)));
        double _t7 = unitScale(_selfz, _selfw, Math.max(Math.abs(_selfx), Math.abs(_selfy)));
        double _t16 = _otherw * _t6;
        double _t17 = _selfz * _t7;
        double _t18 = _otherz * _t6;
        double _t19 = _selfw * _t7;
        double _t20 = _othery * _t6;
        double _t21 = _selfx * _t7;
        double _t22 = _otherx * _t6;
        double _t23 = _selfy * _t7;
        double _t36 = Math.fma(_t16, _t17, -(_t18 * _t19));
        double _t37 = Math.fma(_t20, _t21, -(_t22 * _t23));
        double _t38 = Math.fma(_t18, _t21, -(_t22 * _t17));
        double _t39 = Math.fma(_t16, _t21, -(_t22 * _t19));
        double _t40 = Math.fma(_t18, _t23, -(_t20 * _t17));
        double _t41 = Math.fma(_t16, _t23, -(_t20 * _t19));
        double _t51 = unitScale(Math.max(Math.abs(_t37), Math.abs(_t38)), Math.max(Math.abs(_t39), Math.abs(_t40)), Math.max(Math.abs(_t41), Math.abs(_t36)));
        double _t58 = _t36 * _t51;
        double _t59 = _t41 * _t51;
        double _t60 = _t40 * _t51;
        double _t61 = _t39 * _t51;
        double _t62 = _t37 * _t51;
        double _t63 = _t38 * _t51;
        return Math.atan2(Math.sqrt(Math.fma(_t58, _t58, Math.fma(_t59, _t59, Math.fma(_t60, _t60, Math.fma(_t61, _t61, Math.fma(_t62, _t62, _t63 * _t63)))))), Math.fma(_t16, _t19, Math.fma(_t18, _t17, Math.fma(_t22, _t21, _t20 * _t23))) * _t51);
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
