// Copyright (c) 2015-2026 JOML
// SPDX-License-Identifier: MIT
package org.joml2.internal.kernels;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.ops.*;
import org.joml2.internal.unsafe.*;

/**
 * Scalar/Unsafe kernel leaves of {@link Double2Ops} whose leading storage
 * parameter is a {@code double[]} array. Split into a sibling compilation unit purely
 * to keep generated sources IDE-sized; package-private, called only from
 * {@code Double2Ops} and its sibling kernel units. Not public API.
 */
public final class Double2OpsKernelsArray {
    private Double2OpsKernelsArray() {}

    public static double[] slerp_degenerate(double[] dest, int destOffset, double[] src, int srcOffset, double otherX, double otherY, double t) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _t0 = unitScale(otherX, otherY, otherX);
        double _t1 = unitScale(_selfx, _selfy, _selfx);
        double _t6 = otherX * _t0;
        double _t7 = otherY * _t0;
        double _t8 = _selfx * _t1;
        double _t9 = _selfy * _t1;
        double _t12 = Math.fma(_t6, _t6, _t7 * _t7);
        double _t13 = Math.fma(_t8, _t8, _t9 * _t9);
        double _t16 = (1.0 / Math.sqrt(_t12));
        double _t17 = (1.0 / Math.sqrt(_t13));
        double _t19 = Math.sqrt(_t13) / _t1;
        double _t21 = _t17 * _t8;
        double _t23 = _t17 * _t9;
        double _t24 = _t12 * _t13;
        double _t27 = Math.fma(t, Math.sqrt(_t12) / _t0 - _t19, _t19);
        double _t28 = Math.fma(_t16 * _t6, _t21, _t16 * _t7 * _t23);
        double _t33 = Math.fma(_t16, _t6, -(_t28 * _t21));
        double _t34 = Math.fma(_t16, _t7, -(_t28 * _t23));
        double _t37 = -Math.fma(_t33, _t21, _t34 * _t23);
        double _t38 = Math.fma(_t37, _t21, _t33);
        double _t39 = Math.fma(_t37, _t23, _t34);
        double _t40 = unitScale(_t38, _t39, _t38);
        double _t45 = _t38 * _t40;
        double _t46 = _t39 * _t40;
        double _t48 = Math.fma(_t45, _t45, _t46 * _t46);
        double _t50 = (1.0 / Math.sqrt(_t48));
        double _t52 = t * Math.atan2(Math.sqrt(_t48), _t28 * _t40);
        double _t53 = Math.sin(_t52);
        double _t54 = _t27 * _t53;
        double _t56 = _t27 * Math.cosFromSin(_t53, _t52);
        if (_t24 > 0.0) {
            if (_t48 > 0.0) {
                dest[destOffset + 0] = Math.fma(_t54, _t50 * _t45, _t56 * _t21);
                dest[destOffset + 1] = Math.fma(_t54, _t50 * _t46, _t56 * _t23);
            } else {
                dest[destOffset + 0] = Math.fma(_t54, -_t23, _t56 * _t21);
                dest[destOffset + 1] = Math.fma(_t54, _t21, _t56 * _t23);
            }
        } else {
            dest[destOffset + 0] = Math.fma(t, otherX - _selfx, _selfx);
            dest[destOffset + 1] = Math.fma(t, otherY - _selfy, _selfy);
        }
        return dest;
    }

    public static double[] slerp_degenerate(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset, double t) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _otherx = other[otherOffset + 0];
        double _othery = other[otherOffset + 1];
        double _t0 = unitScale(_otherx, _othery, _otherx);
        double _t1 = unitScale(_selfx, _selfy, _selfx);
        double _t6 = _otherx * _t0;
        double _t7 = _othery * _t0;
        double _t8 = _selfx * _t1;
        double _t9 = _selfy * _t1;
        double _t12 = Math.fma(_t6, _t6, _t7 * _t7);
        double _t13 = Math.fma(_t8, _t8, _t9 * _t9);
        double _t16 = (1.0 / Math.sqrt(_t12));
        double _t17 = (1.0 / Math.sqrt(_t13));
        double _t19 = Math.sqrt(_t13) / _t1;
        double _t21 = _t17 * _t8;
        double _t23 = _t17 * _t9;
        double _t24 = _t12 * _t13;
        double _t27 = Math.fma(t, Math.sqrt(_t12) / _t0 - _t19, _t19);
        double _t28 = Math.fma(_t16 * _t6, _t21, _t16 * _t7 * _t23);
        double _t33 = Math.fma(_t16, _t6, -(_t28 * _t21));
        double _t34 = Math.fma(_t16, _t7, -(_t28 * _t23));
        double _t37 = -Math.fma(_t33, _t21, _t34 * _t23);
        double _t38 = Math.fma(_t37, _t21, _t33);
        double _t39 = Math.fma(_t37, _t23, _t34);
        double _t40 = unitScale(_t38, _t39, _t38);
        double _t45 = _t38 * _t40;
        double _t46 = _t39 * _t40;
        double _t48 = Math.fma(_t45, _t45, _t46 * _t46);
        double _t50 = (1.0 / Math.sqrt(_t48));
        double _t52 = t * Math.atan2(Math.sqrt(_t48), _t28 * _t40);
        double _t53 = Math.sin(_t52);
        double _t54 = _t27 * _t53;
        double _t56 = _t27 * Math.cosFromSin(_t53, _t52);
        if (_t24 > 0.0) {
            if (_t48 > 0.0) {
                dest[destOffset + 0] = Math.fma(_t54, _t50 * _t45, _t56 * _t21);
                dest[destOffset + 1] = Math.fma(_t54, _t50 * _t46, _t56 * _t23);
            } else {
                dest[destOffset + 0] = Math.fma(_t54, -_t23, _t56 * _t21);
                dest[destOffset + 1] = Math.fma(_t54, _t21, _t56 * _t23);
            }
        } else {
            dest[destOffset + 0] = Math.fma(t, _otherx - _selfx, _selfx);
            dest[destOffset + 1] = Math.fma(t, _othery - _selfy, _selfy);
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
