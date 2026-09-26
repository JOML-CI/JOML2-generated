// Copyright (c) 2015-2026 JOML
// SPDX-License-Identifier: MIT
package org.joml2.internal.kernels;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.ops.*;
import org.joml2.internal.unsafe.*;

/**
 * Scalar/Unsafe kernel leaves of {@link Float2Ops} whose leading storage
 * parameter is a {@code float[]} array. Split into a sibling compilation unit purely
 * to keep generated sources IDE-sized; package-private, called only from
 * {@code Float2Ops} and its sibling kernel units. Not public API.
 */
public final class Float2OpsKernelsArray {
    private Float2OpsKernelsArray() {}

    public static float[] slerp_degenerate(float[] dest, int destOffset, float[] src, int srcOffset, float otherX, float otherY, float t) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _t0 = unitScale(otherX, otherY, otherX);
        float _t1 = unitScale(_selfx, _selfy, _selfx);
        float _t6 = otherX * _t0;
        float _t7 = otherY * _t0;
        float _t8 = _selfx * _t1;
        float _t9 = _selfy * _t1;
        float _t12 = Math.fma(_t6, _t6, _t7 * _t7);
        float _t13 = Math.fma(_t8, _t8, _t9 * _t9);
        float _t16 = (1.0f / (float) Math.sqrt(_t12));
        float _t17 = (1.0f / (float) Math.sqrt(_t13));
        float _t19 = (float) Math.sqrt(_t13) / _t1;
        float _t21 = _t17 * _t8;
        float _t23 = _t17 * _t9;
        float _t24 = _t12 * _t13;
        float _t27 = Math.fma(t, (float) Math.sqrt(_t12) / _t0 - _t19, _t19);
        float _t28 = Math.fma(_t16 * _t6, _t21, _t16 * _t7 * _t23);
        float _t33 = Math.fma(_t16, _t6, -(_t28 * _t21));
        float _t34 = Math.fma(_t16, _t7, -(_t28 * _t23));
        float _t37 = -Math.fma(_t33, _t21, _t34 * _t23);
        float _t38 = Math.fma(_t37, _t21, _t33);
        float _t39 = Math.fma(_t37, _t23, _t34);
        float _t40 = unitScale(_t38, _t39, _t38);
        float _t45 = _t38 * _t40;
        float _t46 = _t39 * _t40;
        float _t48 = Math.fma(_t45, _t45, _t46 * _t46);
        float _t50 = (1.0f / (float) Math.sqrt(_t48));
        float _t52 = t * (float) Math.atan2((float) Math.sqrt(_t48), _t28 * _t40);
        float _t53 = (float) Math.sin(_t52);
        float _t54 = _t27 * _t53;
        float _t56 = _t27 * (float) Math.cosFromSin(_t53, _t52);
        if (_t24 > 0.0f) {
            if (_t48 > 0.0f) {
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

    public static float[] slerp_degenerate(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset, float t) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _otherx = other[otherOffset + 0];
        float _othery = other[otherOffset + 1];
        float _t0 = unitScale(_otherx, _othery, _otherx);
        float _t1 = unitScale(_selfx, _selfy, _selfx);
        float _t6 = _otherx * _t0;
        float _t7 = _othery * _t0;
        float _t8 = _selfx * _t1;
        float _t9 = _selfy * _t1;
        float _t12 = Math.fma(_t6, _t6, _t7 * _t7);
        float _t13 = Math.fma(_t8, _t8, _t9 * _t9);
        float _t16 = (1.0f / (float) Math.sqrt(_t12));
        float _t17 = (1.0f / (float) Math.sqrt(_t13));
        float _t19 = (float) Math.sqrt(_t13) / _t1;
        float _t21 = _t17 * _t8;
        float _t23 = _t17 * _t9;
        float _t24 = _t12 * _t13;
        float _t27 = Math.fma(t, (float) Math.sqrt(_t12) / _t0 - _t19, _t19);
        float _t28 = Math.fma(_t16 * _t6, _t21, _t16 * _t7 * _t23);
        float _t33 = Math.fma(_t16, _t6, -(_t28 * _t21));
        float _t34 = Math.fma(_t16, _t7, -(_t28 * _t23));
        float _t37 = -Math.fma(_t33, _t21, _t34 * _t23);
        float _t38 = Math.fma(_t37, _t21, _t33);
        float _t39 = Math.fma(_t37, _t23, _t34);
        float _t40 = unitScale(_t38, _t39, _t38);
        float _t45 = _t38 * _t40;
        float _t46 = _t39 * _t40;
        float _t48 = Math.fma(_t45, _t45, _t46 * _t46);
        float _t50 = (1.0f / (float) Math.sqrt(_t48));
        float _t52 = t * (float) Math.atan2((float) Math.sqrt(_t48), _t28 * _t40);
        float _t53 = (float) Math.sin(_t52);
        float _t54 = _t27 * _t53;
        float _t56 = _t27 * (float) Math.cosFromSin(_t53, _t52);
        if (_t24 > 0.0f) {
            if (_t48 > 0.0f) {
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
