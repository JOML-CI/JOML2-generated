package org.joml2.internal.kernels;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.ops.*;
import org.joml2.internal.unsafe.*;
import org.joml2.internal.simd.*;

/**
 * Scalar/Unsafe kernel leaves of {@link Float4Ops} whose leading storage
 * parameter is a {@code float[]} array. Split into a sibling compilation unit purely
 * to keep generated sources IDE-sized; package-private, called only from
 * {@code Float4Ops} and its sibling kernel units. Not public API.
 */
public final class Float4OpsKernelsArray {
    private Float4OpsKernelsArray() {}

    public static float[] add_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _selfw = src[srcOffset + 3];
        float _otherx = other[otherOffset + 0];
        float _othery = other[otherOffset + 1];
        float _otherz = other[otherOffset + 2];
        float _otherw = other[otherOffset + 3];
        dest[destOffset + 0] = _otherx + _selfx;
        dest[destOffset + 1] = _othery + _selfy;
        dest[destOffset + 2] = _otherz + _selfz;
        dest[destOffset + 3] = _otherw + _selfw;
        return dest;
    }

    public static float[] div_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float scalar) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _selfw = src[srcOffset + 3];
        float _rcp0 = 1.0f / scalar;
        dest[destOffset + 0] = _selfx * _rcp0;
        dest[destOffset + 1] = _selfy * _rcp0;
        dest[destOffset + 2] = _selfz * _rcp0;
        dest[destOffset + 3] = _selfw * _rcp0;
        return dest;
    }

    public static float[] div_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _selfw = src[srcOffset + 3];
        float _otherx = other[otherOffset + 0];
        float _othery = other[otherOffset + 1];
        float _otherz = other[otherOffset + 2];
        float _otherw = other[otherOffset + 3];
        dest[destOffset + 0] = _selfx / _otherx;
        dest[destOffset + 1] = _selfy / _othery;
        dest[destOffset + 2] = _selfz / _otherz;
        dest[destOffset + 3] = _selfw / _otherw;
        return dest;
    }

    public static float[] fma_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] c, int cOffset, float b) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _selfw = src[srcOffset + 3];
        float _cx = c[cOffset + 0];
        float _cy = c[cOffset + 1];
        float _cz = c[cOffset + 2];
        float _cw = c[cOffset + 3];
        dest[destOffset + 0] = Math.fma(_selfx, b, _cx);
        dest[destOffset + 1] = Math.fma(_selfy, b, _cy);
        dest[destOffset + 2] = Math.fma(_selfz, b, _cz);
        dest[destOffset + 3] = Math.fma(_selfw, b, _cw);
        return dest;
    }

    public static float[] fma_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] b, int bOffset, float[] c, int cOffset) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _selfw = src[srcOffset + 3];
        float _bx = b[bOffset + 0];
        float _by = b[bOffset + 1];
        float _bz = b[bOffset + 2];
        float _bw = b[bOffset + 3];
        float _cx = c[cOffset + 0];
        float _cy = c[cOffset + 1];
        float _cz = c[cOffset + 2];
        float _cw = c[cOffset + 3];
        dest[destOffset + 0] = Math.fma(_selfx, _bx, _cx);
        dest[destOffset + 1] = Math.fma(_selfy, _by, _cy);
        dest[destOffset + 2] = Math.fma(_selfz, _bz, _cz);
        dest[destOffset + 3] = Math.fma(_selfw, _bw, _cw);
        return dest;
    }

    public static float[] mul_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float scalar) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _selfw = src[srcOffset + 3];
        dest[destOffset + 0] = scalar * _selfx;
        dest[destOffset + 1] = scalar * _selfy;
        dest[destOffset + 2] = scalar * _selfz;
        dest[destOffset + 3] = scalar * _selfw;
        return dest;
    }

    public static float[] mul_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _selfw = src[srcOffset + 3];
        float _otherx = other[otherOffset + 0];
        float _othery = other[otherOffset + 1];
        float _otherz = other[otherOffset + 2];
        float _otherw = other[otherOffset + 3];
        dest[destOffset + 0] = _otherx * _selfx;
        dest[destOffset + 1] = _othery * _selfy;
        dest[destOffset + 2] = _otherz * _selfz;
        dest[destOffset + 3] = _otherw * _selfw;
        return dest;
    }

    public static float[] negate_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _selfw = src[srcOffset + 3];
        dest[destOffset + 0] = -_selfx;
        dest[destOffset + 1] = -_selfy;
        dest[destOffset + 2] = -_selfz;
        dest[destOffset + 3] = -_selfw;
        return dest;
    }

    public static float[] sub_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _selfw = src[srcOffset + 3];
        float _otherx = other[otherOffset + 0];
        float _othery = other[otherOffset + 1];
        float _otherz = other[otherOffset + 2];
        float _otherw = other[otherOffset + 3];
        dest[destOffset + 0] = _selfx - _otherx;
        dest[destOffset + 1] = _selfy - _othery;
        dest[destOffset + 2] = _selfz - _otherz;
        dest[destOffset + 3] = _selfw - _otherw;
        return dest;
    }

    public static float[] set_scalar(float[] dest, int destOffset, float[] v, int vOffset) {
        float _vx = v[vOffset + 0];
        float _vy = v[vOffset + 1];
        float _vz = v[vOffset + 2];
        float _vw = v[vOffset + 3];
        dest[destOffset + 0] = _vx;
        dest[destOffset + 1] = _vy;
        dest[destOffset + 2] = _vz;
        dest[destOffset + 3] = _vw;
        return dest;
    }

    public static float[] set_scalar(float[] dest, int destOffset, float s) {
        dest[destOffset + 0] = s;
        dest[destOffset + 1] = s;
        dest[destOffset + 2] = s;
        dest[destOffset + 3] = s;
        return dest;
    }

    public static float[] makeZero_scalar(float[] dest, int destOffset) {
        dest[destOffset + 0] = 0.0f;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        return dest;
    }

    public static float[] bezier_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] p1, int p1Offset, float[] p2, int p2Offset, float[] p3, int p3Offset, float t) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _selfw = src[srcOffset + 3];
        float _p1x = p1[p1Offset + 0];
        float _p1y = p1[p1Offset + 1];
        float _p1z = p1[p1Offset + 2];
        float _p1w = p1[p1Offset + 3];
        float _p2x = p2[p2Offset + 0];
        float _p2y = p2[p2Offset + 1];
        float _p2z = p2[p2Offset + 2];
        float _p2w = p2[p2Offset + 3];
        float _p3x = p3[p3Offset + 0];
        float _p3y = p3[p3Offset + 1];
        float _p3z = p3[p3Offset + 2];
        float _p3w = p3[p3Offset + 3];
        float _t0 = 1.0f - t;
        float _t1 = t * t;
        float _t2 = t * _t1;
        float _t3 = _t0 * _t0;
        float _t6 = 3.0f * _t0 * _t1;
        float _t7 = 3.0f * t * _t3;
        float _t8 = _t0 * _t3;
        dest[destOffset + 0] = Math.fma(_p1x, _t7, _selfx * _t8) + Math.fma(_p2x, _t6, _p3x * _t2);
        dest[destOffset + 1] = Math.fma(_p1y, _t7, _selfy * _t8) + Math.fma(_p2y, _t6, _p3y * _t2);
        dest[destOffset + 2] = Math.fma(_p1z, _t7, _selfz * _t8) + Math.fma(_p2z, _t6, _p3z * _t2);
        dest[destOffset + 3] = Math.fma(_p1w, _t7, _selfw * _t8) + Math.fma(_p2w, _t6, _p3w * _t2);
        return dest;
    }

    public static float[] bezier2_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] p1, int p1Offset, float[] p2, int p2Offset, float t) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _selfw = src[srcOffset + 3];
        float _p1x = p1[p1Offset + 0];
        float _p1y = p1[p1Offset + 1];
        float _p1z = p1[p1Offset + 2];
        float _p1w = p1[p1Offset + 3];
        float _p2x = p2[p2Offset + 0];
        float _p2y = p2[p2Offset + 1];
        float _p2z = p2[p2Offset + 2];
        float _p2w = p2[p2Offset + 3];
        float _t0 = t * t;
        float _t1 = 1.0f - t;
        float _t3 = 2.0f * t * _t1;
        float _t4 = _t1 * _t1;
        dest[destOffset + 0] = Math.fma(_p2x, _t0, Math.fma(_p1x, _t3, _selfx * _t4));
        dest[destOffset + 1] = Math.fma(_p2y, _t0, Math.fma(_p1y, _t3, _selfy * _t4));
        dest[destOffset + 2] = Math.fma(_p2z, _t0, Math.fma(_p1z, _t3, _selfz * _t4));
        dest[destOffset + 3] = Math.fma(_p2w, _t0, Math.fma(_p1w, _t3, _selfw * _t4));
        return dest;
    }

    public static float[] bezier2Tangent_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] p1, int p1Offset, float[] p2, int p2Offset, float t) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _selfw = src[srcOffset + 3];
        float _p1x = p1[p1Offset + 0];
        float _p1y = p1[p1Offset + 1];
        float _p1z = p1[p1Offset + 2];
        float _p1w = p1[p1Offset + 3];
        float _p2x = p2[p2Offset + 0];
        float _p2y = p2[p2Offset + 1];
        float _p2z = p2[p2Offset + 2];
        float _p2w = p2[p2Offset + 3];
        float _t1 = 2.0f * t;
        float _t2 = 2.0f * (1.0f - t);
        dest[destOffset + 0] = Math.fma(_p1x - _selfx, _t2, (_p2x - _p1x) * _t1);
        dest[destOffset + 1] = Math.fma(_p1y - _selfy, _t2, (_p2y - _p1y) * _t1);
        dest[destOffset + 2] = Math.fma(_p1z - _selfz, _t2, (_p2z - _p1z) * _t1);
        dest[destOffset + 3] = Math.fma(_p1w - _selfw, _t2, (_p2w - _p1w) * _t1);
        return dest;
    }

    public static float[] bezierTangent_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] p1, int p1Offset, float[] p2, int p2Offset, float[] p3, int p3Offset, float t) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _selfw = src[srcOffset + 3];
        float _p1x = p1[p1Offset + 0];
        float _p1y = p1[p1Offset + 1];
        float _p1z = p1[p1Offset + 2];
        float _p1w = p1[p1Offset + 3];
        float _p2x = p2[p2Offset + 0];
        float _p2y = p2[p2Offset + 1];
        float _p2z = p2[p2Offset + 2];
        float _p2w = p2[p2Offset + 3];
        float _p3x = p3[p3Offset + 0];
        float _p3y = p3[p3Offset + 1];
        float _p3z = p3[p3Offset + 2];
        float _p3w = p3[p3Offset + 3];
        float _t1 = 1.0f - t;
        float _t2 = 3.0f * t * t;
        float _t5 = 6.0f * t * _t1;
        float _t6 = 3.0f * _t1 * _t1;
        dest[destOffset + 0] = Math.fma(_p3x - _p2x, _t2, Math.fma(_p1x - _selfx, _t6, (_p2x - _p1x) * _t5));
        dest[destOffset + 1] = Math.fma(_p3y - _p2y, _t2, Math.fma(_p1y - _selfy, _t6, (_p2y - _p1y) * _t5));
        dest[destOffset + 2] = Math.fma(_p3z - _p2z, _t2, Math.fma(_p1z - _selfz, _t6, (_p2z - _p1z) * _t5));
        dest[destOffset + 3] = Math.fma(_p3w - _p2w, _t2, Math.fma(_p1w - _selfw, _t6, (_p2w - _p1w) * _t5));
        return dest;
    }

    public static float[] catmullRom_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] p1, int p1Offset, float[] p2, int p2Offset, float[] p3, int p3Offset, float t) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _selfw = src[srcOffset + 3];
        float _p1x = p1[p1Offset + 0];
        float _p1y = p1[p1Offset + 1];
        float _p1z = p1[p1Offset + 2];
        float _p1w = p1[p1Offset + 3];
        float _p2x = p2[p2Offset + 0];
        float _p2y = p2[p2Offset + 1];
        float _p2z = p2[p2Offset + 2];
        float _p2w = p2[p2Offset + 3];
        float _p3x = p3[p3Offset + 0];
        float _p3y = p3[p3Offset + 1];
        float _p3z = p3[p3Offset + 2];
        float _p3w = p3[p3Offset + 3];
        float _t0 = t * t;
        float _t1 = t * _t0;
        dest[destOffset + 0] = 0.5f * (Math.fma(2.0f, _p1x, t * (_p2x - _selfx)) + Math.fma(Math.fma(-5.0f, _p1x, Math.fma(2.0f, _selfx, Math.fma(4.0f, _p2x, -_p3x))), _t0, Math.fma(-3.0f, _p2x, Math.fma(3.0f, _p1x, _p3x - _selfx)) * _t1));
        dest[destOffset + 1] = 0.5f * (Math.fma(2.0f, _p1y, t * (_p2y - _selfy)) + Math.fma(Math.fma(-5.0f, _p1y, Math.fma(2.0f, _selfy, Math.fma(4.0f, _p2y, -_p3y))), _t0, Math.fma(-3.0f, _p2y, Math.fma(3.0f, _p1y, _p3y - _selfy)) * _t1));
        dest[destOffset + 2] = 0.5f * (Math.fma(2.0f, _p1z, t * (_p2z - _selfz)) + Math.fma(Math.fma(-5.0f, _p1z, Math.fma(2.0f, _selfz, Math.fma(4.0f, _p2z, -_p3z))), _t0, Math.fma(-3.0f, _p2z, Math.fma(3.0f, _p1z, _p3z - _selfz)) * _t1));
        dest[destOffset + 3] = 0.5f * (Math.fma(2.0f, _p1w, t * (_p2w - _selfw)) + Math.fma(Math.fma(-5.0f, _p1w, Math.fma(2.0f, _selfw, Math.fma(4.0f, _p2w, -_p3w))), _t0, Math.fma(-3.0f, _p2w, Math.fma(3.0f, _p1w, _p3w - _selfw)) * _t1));
        return dest;
    }

    public static float[] catmullRomTangent_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] p1, int p1Offset, float[] p2, int p2Offset, float[] p3, int p3Offset, float t) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _selfw = src[srcOffset + 3];
        float _p1x = p1[p1Offset + 0];
        float _p1y = p1[p1Offset + 1];
        float _p1z = p1[p1Offset + 2];
        float _p1w = p1[p1Offset + 3];
        float _p2x = p2[p2Offset + 0];
        float _p2y = p2[p2Offset + 1];
        float _p2z = p2[p2Offset + 2];
        float _p2w = p2[p2Offset + 3];
        float _p3x = p3[p3Offset + 0];
        float _p3y = p3[p3Offset + 1];
        float _p3z = p3[p3Offset + 2];
        float _p3w = p3[p3Offset + 3];
        float _t0 = t * t;
        dest[destOffset + 0] = 0.5f * Math.fma(t, 2.0f * Math.fma(-5.0f, _p1x, Math.fma(2.0f, _selfx, Math.fma(4.0f, _p2x, -_p3x))), Math.fma(3.0f * Math.fma(-3.0f, _p2x, Math.fma(3.0f, _p1x, _p3x - _selfx)), _t0, _p2x - _selfx));
        dest[destOffset + 1] = 0.5f * Math.fma(t, 2.0f * Math.fma(-5.0f, _p1y, Math.fma(2.0f, _selfy, Math.fma(4.0f, _p2y, -_p3y))), Math.fma(3.0f * Math.fma(-3.0f, _p2y, Math.fma(3.0f, _p1y, _p3y - _selfy)), _t0, _p2y - _selfy));
        dest[destOffset + 2] = 0.5f * Math.fma(t, 2.0f * Math.fma(-5.0f, _p1z, Math.fma(2.0f, _selfz, Math.fma(4.0f, _p2z, -_p3z))), Math.fma(3.0f * Math.fma(-3.0f, _p2z, Math.fma(3.0f, _p1z, _p3z - _selfz)), _t0, _p2z - _selfz));
        dest[destOffset + 3] = 0.5f * Math.fma(t, 2.0f * Math.fma(-5.0f, _p1w, Math.fma(2.0f, _selfw, Math.fma(4.0f, _p2w, -_p3w))), Math.fma(3.0f * Math.fma(-3.0f, _p2w, Math.fma(3.0f, _p1w, _p3w - _selfw)), _t0, _p2w - _selfw));
        return dest;
    }

    public static float[] hermite_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] t0, int t0Offset, float[] v1, int v1Offset, float[] t1, int t1Offset, float t) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _selfw = src[srcOffset + 3];
        float _t0x = t0[t0Offset + 0];
        float _t0y = t0[t0Offset + 1];
        float _t0z = t0[t0Offset + 2];
        float _t0w = t0[t0Offset + 3];
        float _v1x = v1[v1Offset + 0];
        float _v1y = v1[v1Offset + 1];
        float _v1z = v1[v1Offset + 2];
        float _v1w = v1[v1Offset + 3];
        float _t1x = t1[t1Offset + 0];
        float _t1y = t1[t1Offset + 1];
        float _t1z = t1[t1Offset + 2];
        float _t1w = t1[t1Offset + 3];
        float _t0 = t * t;
        float _t2 = t * _t0;
        float _t5 = t * Math.fma(t, t, -t);
        float _t7 = Math.fma(t - 2.0f, _t0, t);
        float _t9 = Math.fma(3.0f, _t0, -(2.0f * _t2));
        float _t10 = Math.fma(2.0f, _t2, Math.fma(-3.0f, _t0, 1.0f));
        dest[destOffset + 0] = Math.fma(_selfx, _t10, _t0x * _t7) + Math.fma(_t1x, _t5, _v1x * _t9);
        dest[destOffset + 1] = Math.fma(_selfy, _t10, _t0y * _t7) + Math.fma(_t1y, _t5, _v1y * _t9);
        dest[destOffset + 2] = Math.fma(_selfz, _t10, _t0z * _t7) + Math.fma(_t1z, _t5, _v1z * _t9);
        dest[destOffset + 3] = Math.fma(_selfw, _t10, _t0w * _t7) + Math.fma(_t1w, _t5, _v1w * _t9);
        return dest;
    }

    public static float[] hermiteTangent_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] t0, int t0Offset, float[] v1, int v1Offset, float[] t1, int t1Offset, float t) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _selfw = src[srcOffset + 3];
        float _t0x = t0[t0Offset + 0];
        float _t0y = t0[t0Offset + 1];
        float _t0z = t0[t0Offset + 2];
        float _t0w = t0[t0Offset + 3];
        float _v1x = v1[v1Offset + 0];
        float _v1y = v1[v1Offset + 1];
        float _v1z = v1[v1Offset + 2];
        float _v1w = v1[v1Offset + 3];
        float _t1x = t1[t1Offset + 0];
        float _t1y = t1[t1Offset + 1];
        float _t1z = t1[t1Offset + 2];
        float _t1w = t1[t1Offset + 3];
        float _t0 = t * t;
        float _t6 = 6.0f * Math.fma(t, t, -t);
        float _t7 = 6.0f * Math.fma(-t, t, t);
        float _t8 = Math.fma(3.0f, _t0, -(2.0f * t));
        float _t9 = Math.fma(3.0f, _t0, Math.fma(-4.0f, t, 1.0f));
        dest[destOffset + 0] = Math.fma(_selfx, _t6, _t0x * _t9) + Math.fma(_t1x, _t8, _v1x * _t7);
        dest[destOffset + 1] = Math.fma(_selfy, _t6, _t0y * _t9) + Math.fma(_t1y, _t8, _v1y * _t7);
        dest[destOffset + 2] = Math.fma(_selfz, _t6, _t0z * _t9) + Math.fma(_t1z, _t8, _v1z * _t7);
        dest[destOffset + 3] = Math.fma(_selfw, _t6, _t0w * _t9) + Math.fma(_t1w, _t8, _v1w * _t7);
        return dest;
    }

    public static float[] lerp_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float otherX, float otherY, float otherZ, float otherW, float t) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _selfw = src[srcOffset + 3];
        dest[destOffset + 0] = Math.fma(t, otherX - _selfx, _selfx);
        dest[destOffset + 1] = Math.fma(t, otherY - _selfy, _selfy);
        dest[destOffset + 2] = Math.fma(t, otherZ - _selfz, _selfz);
        dest[destOffset + 3] = Math.fma(t, otherW - _selfw, _selfw);
        return dest;
    }

    public static float[] lerp_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset, float t) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _selfw = src[srcOffset + 3];
        float _otherx = other[otherOffset + 0];
        float _othery = other[otherOffset + 1];
        float _otherz = other[otherOffset + 2];
        float _otherw = other[otherOffset + 3];
        dest[destOffset + 0] = Math.fma(t, _otherx - _selfx, _selfx);
        dest[destOffset + 1] = Math.fma(t, _othery - _selfy, _selfy);
        dest[destOffset + 2] = Math.fma(t, _otherz - _selfz, _selfz);
        dest[destOffset + 3] = Math.fma(t, _otherw - _selfw, _selfw);
        return dest;
    }

    public static float[] lerp_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset, float[] t, int tOffset) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _selfw = src[srcOffset + 3];
        float _otherx = other[otherOffset + 0];
        float _othery = other[otherOffset + 1];
        float _otherz = other[otherOffset + 2];
        float _otherw = other[otherOffset + 3];
        float _tx = t[tOffset + 0];
        float _ty = t[tOffset + 1];
        float _tz = t[tOffset + 2];
        float _tw = t[tOffset + 3];
        dest[destOffset + 0] = Math.fma(_tx, _otherx - _selfx, _selfx);
        dest[destOffset + 1] = Math.fma(_ty, _othery - _selfy, _selfy);
        dest[destOffset + 2] = Math.fma(_tz, _otherz - _selfz, _selfz);
        dest[destOffset + 3] = Math.fma(_tw, _otherw - _selfw, _selfw);
        return dest;
    }

    public static float[] absolute_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _selfw = src[srcOffset + 3];
        dest[destOffset + 0] = Math.abs(_selfx);
        dest[destOffset + 1] = Math.abs(_selfy);
        dest[destOffset + 2] = Math.abs(_selfz);
        dest[destOffset + 3] = Math.abs(_selfw);
        return dest;
    }

    public static float[] addScaled_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] b, int bOffset, float scalar) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _selfw = src[srcOffset + 3];
        float _bx = b[bOffset + 0];
        float _by = b[bOffset + 1];
        float _bz = b[bOffset + 2];
        float _bw = b[bOffset + 3];
        dest[destOffset + 0] = Math.fma(scalar, _bx, _selfx);
        dest[destOffset + 1] = Math.fma(scalar, _by, _selfy);
        dest[destOffset + 2] = Math.fma(scalar, _bz, _selfz);
        dest[destOffset + 3] = Math.fma(scalar, _bw, _selfw);
        return dest;
    }

    public static float[] addScaled_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] b, int bOffset, float[] c, int cOffset) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _selfw = src[srcOffset + 3];
        float _bx = b[bOffset + 0];
        float _by = b[bOffset + 1];
        float _bz = b[bOffset + 2];
        float _bw = b[bOffset + 3];
        float _cx = c[cOffset + 0];
        float _cy = c[cOffset + 1];
        float _cz = c[cOffset + 2];
        float _cw = c[cOffset + 3];
        dest[destOffset + 0] = Math.fma(_bx, _cx, _selfx);
        dest[destOffset + 1] = Math.fma(_by, _cy, _selfy);
        dest[destOffset + 2] = Math.fma(_bz, _cz, _selfz);
        dest[destOffset + 3] = Math.fma(_bw, _cw, _selfw);
        return dest;
    }

    public static float[] clamp_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float min, float max) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _selfw = src[srcOffset + 3];
        dest[destOffset + 0] = Math.min(Math.max(_selfx, min), max);
        dest[destOffset + 1] = Math.min(Math.max(_selfy, min), max);
        dest[destOffset + 2] = Math.min(Math.max(_selfz, min), max);
        dest[destOffset + 3] = Math.min(Math.max(_selfw, min), max);
        return dest;
    }

    public static float[] clamp_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] min, int minOffset, float[] max, int maxOffset) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _selfw = src[srcOffset + 3];
        float _minx = min[minOffset + 0];
        float _miny = min[minOffset + 1];
        float _minz = min[minOffset + 2];
        float _minw = min[minOffset + 3];
        float _maxx = max[maxOffset + 0];
        float _maxy = max[maxOffset + 1];
        float _maxz = max[maxOffset + 2];
        float _maxw = max[maxOffset + 3];
        dest[destOffset + 0] = Math.min(Math.max(_selfx, _minx), _maxx);
        dest[destOffset + 1] = Math.min(Math.max(_selfy, _miny), _maxy);
        dest[destOffset + 2] = Math.min(Math.max(_selfz, _minz), _maxz);
        dest[destOffset + 3] = Math.min(Math.max(_selfw, _minw), _maxw);
        return dest;
    }

    public static float[] faceforward_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float IX, float IY, float IZ, float IW, float NrefX, float NrefY, float NrefZ, float NrefW) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _selfw = src[srcOffset + 3];
        float _t3 = Math.fma(IW, NrefW, Math.fma(IZ, NrefZ, Math.fma(IX, NrefX, IY * NrefY)));
        if (_t3 < 0.0f) {
            dest[destOffset + 0] = _selfx;
            dest[destOffset + 1] = _selfy;
            dest[destOffset + 2] = _selfz;
            dest[destOffset + 3] = _selfw;
        } else {
            dest[destOffset + 0] = -_selfx;
            dest[destOffset + 1] = -_selfy;
            dest[destOffset + 2] = -_selfz;
            dest[destOffset + 3] = -_selfw;
        }
        return dest;
    }

    public static float[] faceforward_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] I, int IOffset, float[] Nref, int NrefOffset) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _selfw = src[srcOffset + 3];
        float _Ix = I[IOffset + 0];
        float _Iy = I[IOffset + 1];
        float _Iz = I[IOffset + 2];
        float _Iw = I[IOffset + 3];
        float _Nrefx = Nref[NrefOffset + 0];
        float _Nrefy = Nref[NrefOffset + 1];
        float _Nrefz = Nref[NrefOffset + 2];
        float _Nrefw = Nref[NrefOffset + 3];
        float _t3 = Math.fma(_Iw, _Nrefw, Math.fma(_Iz, _Nrefz, Math.fma(_Ix, _Nrefx, _Iy * _Nrefy)));
        if (_t3 < 0.0f) {
            dest[destOffset + 0] = _selfx;
            dest[destOffset + 1] = _selfy;
            dest[destOffset + 2] = _selfz;
            dest[destOffset + 3] = _selfw;
        } else {
            dest[destOffset + 0] = -_selfx;
            dest[destOffset + 1] = -_selfy;
            dest[destOffset + 2] = -_selfz;
            dest[destOffset + 3] = -_selfw;
        }
        return dest;
    }

    public static float[] inverse_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _selfw = src[srcOffset + 3];
        dest[destOffset + 0] = 1.0f / _selfx;
        dest[destOffset + 1] = 1.0f / _selfy;
        dest[destOffset + 2] = 1.0f / _selfz;
        dest[destOffset + 3] = 1.0f / _selfw;
        return dest;
    }

    public static float[] max_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float scalar) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _selfw = src[srcOffset + 3];
        dest[destOffset + 0] = Math.max(_selfx, scalar);
        dest[destOffset + 1] = Math.max(_selfy, scalar);
        dest[destOffset + 2] = Math.max(_selfz, scalar);
        dest[destOffset + 3] = Math.max(_selfw, scalar);
        return dest;
    }

    public static float[] max_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _selfw = src[srcOffset + 3];
        float _otherx = other[otherOffset + 0];
        float _othery = other[otherOffset + 1];
        float _otherz = other[otherOffset + 2];
        float _otherw = other[otherOffset + 3];
        dest[destOffset + 0] = Math.max(_selfx, _otherx);
        dest[destOffset + 1] = Math.max(_selfy, _othery);
        dest[destOffset + 2] = Math.max(_selfz, _otherz);
        dest[destOffset + 3] = Math.max(_selfw, _otherw);
        return dest;
    }

    public static float[] min_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float scalar) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _selfw = src[srcOffset + 3];
        dest[destOffset + 0] = Math.min(_selfx, scalar);
        dest[destOffset + 1] = Math.min(_selfy, scalar);
        dest[destOffset + 2] = Math.min(_selfz, scalar);
        dest[destOffset + 3] = Math.min(_selfw, scalar);
        return dest;
    }

    public static float[] min_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _selfw = src[srcOffset + 3];
        float _otherx = other[otherOffset + 0];
        float _othery = other[otherOffset + 1];
        float _otherz = other[otherOffset + 2];
        float _otherw = other[otherOffset + 3];
        dest[destOffset + 0] = Math.min(_selfx, _otherx);
        dest[destOffset + 1] = Math.min(_selfy, _othery);
        dest[destOffset + 2] = Math.min(_selfz, _otherz);
        dest[destOffset + 3] = Math.min(_selfw, _otherw);
        return dest;
    }

    public static float[] normalize_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _selfw = src[srcOffset + 3];
        float _t3 = Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)));
        float _t4 = (1.0f / (float) Math.sqrt(_t3));
        if (_t3 > 0.0f) {
            dest[destOffset + 0] = _selfx * _t4;
            dest[destOffset + 1] = _selfy * _t4;
            dest[destOffset + 2] = _selfz * _t4;
            dest[destOffset + 3] = _selfw * _t4;
        } else {
            dest[destOffset + 0] = 0.0f;
            dest[destOffset + 1] = 0.0f;
            dest[destOffset + 2] = 0.0f;
            dest[destOffset + 3] = 0.0f;
        }
        return dest;
    }

    public static float[] normalizeMul_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float length) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _selfw = src[srcOffset + 3];
        float _t3 = Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)));
        float _t5 = length * (1.0f / (float) Math.sqrt(_t3));
        if (_t3 > 0.0f) {
            dest[destOffset + 0] = _selfx * _t5;
            dest[destOffset + 1] = _selfy * _t5;
            dest[destOffset + 2] = _selfz * _t5;
            dest[destOffset + 3] = _selfw * _t5;
        } else {
            dest[destOffset + 0] = 0.0f;
            dest[destOffset + 1] = 0.0f;
            dest[destOffset + 2] = 0.0f;
            dest[destOffset + 3] = 0.0f;
        }
        return dest;
    }

    public static float[] outerProduct_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float rowX, float rowY, float rowZ, float rowW) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _selfw = src[srcOffset + 3];
        dest[destOffset + 0] = rowX * _selfx;
        dest[destOffset + 1] = rowX * _selfy;
        dest[destOffset + 2] = rowX * _selfz;
        dest[destOffset + 3] = rowX * _selfw;
        dest[destOffset + 4] = rowY * _selfx;
        dest[destOffset + 5] = rowY * _selfy;
        dest[destOffset + 6] = rowY * _selfz;
        dest[destOffset + 7] = rowY * _selfw;
        dest[destOffset + 8] = rowZ * _selfx;
        dest[destOffset + 9] = rowZ * _selfy;
        dest[destOffset + 10] = rowZ * _selfz;
        dest[destOffset + 11] = rowZ * _selfw;
        dest[destOffset + 12] = rowW * _selfx;
        dest[destOffset + 13] = rowW * _selfy;
        dest[destOffset + 14] = rowW * _selfz;
        dest[destOffset + 15] = rowW * _selfw;
        return dest;
    }

    public static float[] outerProduct_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] row, int rowOffset) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _selfw = src[srcOffset + 3];
        float _rowx = row[rowOffset + 0];
        float _rowy = row[rowOffset + 1];
        float _rowz = row[rowOffset + 2];
        float _roww = row[rowOffset + 3];
        dest[destOffset + 0] = _rowx * _selfx;
        dest[destOffset + 1] = _rowx * _selfy;
        dest[destOffset + 2] = _rowx * _selfz;
        dest[destOffset + 3] = _rowx * _selfw;
        dest[destOffset + 4] = _rowy * _selfx;
        dest[destOffset + 5] = _rowy * _selfy;
        dest[destOffset + 6] = _rowy * _selfz;
        dest[destOffset + 7] = _rowy * _selfw;
        dest[destOffset + 8] = _rowz * _selfx;
        dest[destOffset + 9] = _rowz * _selfy;
        dest[destOffset + 10] = _rowz * _selfz;
        dest[destOffset + 11] = _rowz * _selfw;
        dest[destOffset + 12] = _roww * _selfx;
        dest[destOffset + 13] = _roww * _selfy;
        dest[destOffset + 14] = _roww * _selfz;
        dest[destOffset + 15] = _roww * _selfw;
        return dest;
    }

    public static float[] project_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float ontoX, float ontoY, float ontoZ, float ontoW) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _selfw = src[srcOffset + 3];
        float _t6 = Math.fma(ontoW, _selfw, Math.fma(ontoZ, _selfz, Math.fma(ontoX, _selfx, ontoY * _selfy)));
        float _t7 = Math.fma(ontoW, ontoW, Math.fma(ontoZ, ontoZ, Math.fma(ontoX, ontoX, ontoY * ontoY)));
        float _t7_inv = 1.0f / _t7;
        dest[destOffset + 0] = ontoX * _t6 * _t7_inv;
        dest[destOffset + 1] = ontoY * _t6 * _t7_inv;
        dest[destOffset + 2] = ontoZ * _t6 * _t7_inv;
        dest[destOffset + 3] = ontoW * _t6 * _t7_inv;
        return dest;
    }

    public static float[] project_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] onto, int ontoOffset) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _selfw = src[srcOffset + 3];
        float _ontox = onto[ontoOffset + 0];
        float _ontoy = onto[ontoOffset + 1];
        float _ontoz = onto[ontoOffset + 2];
        float _ontow = onto[ontoOffset + 3];
        float _t6 = Math.fma(_ontow, _selfw, Math.fma(_ontoz, _selfz, Math.fma(_ontox, _selfx, _ontoy * _selfy)));
        float _t7 = Math.fma(_ontow, _ontow, Math.fma(_ontoz, _ontoz, Math.fma(_ontox, _ontox, _ontoy * _ontoy)));
        float _t7_inv = 1.0f / _t7;
        dest[destOffset + 0] = _ontox * _t6 * _t7_inv;
        dest[destOffset + 1] = _ontoy * _t6 * _t7_inv;
        dest[destOffset + 2] = _ontoz * _t6 * _t7_inv;
        dest[destOffset + 3] = _ontow * _t6 * _t7_inv;
        return dest;
    }

    public static float[] projectOnPlane_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] normal, int normalOffset) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _selfw = src[srcOffset + 3];
        float _normalx = normal[normalOffset + 0];
        float _normaly = normal[normalOffset + 1];
        float _normalz = normal[normalOffset + 2];
        float _normalw = normal[normalOffset + 3];
        float _t3 = Math.fma(_normalw, _selfw, Math.fma(_normalz, _selfz, Math.fma(_normalx, _selfx, _normaly * _selfy)));
        dest[destOffset + 0] = Math.fma(-_normalx, _t3, _selfx);
        dest[destOffset + 1] = Math.fma(-_normaly, _t3, _selfy);
        dest[destOffset + 2] = Math.fma(-_normalz, _t3, _selfz);
        dest[destOffset + 3] = Math.fma(-_normalw, _t3, _selfw);
        return dest;
    }

    public static float[] reflect_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] normal, int normalOffset) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _selfw = src[srcOffset + 3];
        float _normalx = normal[normalOffset + 0];
        float _normaly = normal[normalOffset + 1];
        float _normalz = normal[normalOffset + 2];
        float _normalw = normal[normalOffset + 3];
        float _t4 = 2.0f * Math.fma(_normalw, _selfw, Math.fma(_normalz, _selfz, Math.fma(_normalx, _selfx, _normaly * _selfy)));
        dest[destOffset + 0] = Math.fma(-_normalx, _t4, _selfx);
        dest[destOffset + 1] = Math.fma(-_normaly, _t4, _selfy);
        dest[destOffset + 2] = Math.fma(-_normalz, _t4, _selfz);
        dest[destOffset + 3] = Math.fma(-_normalw, _t4, _selfw);
        return dest;
    }

    public static float[] refract_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float normalX, float normalY, float normalZ, float normalW, float eta) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _selfw = src[srcOffset + 3];
        float _t4 = Math.fma(normalW, _selfw, Math.fma(normalZ, _selfz, Math.fma(normalX, _selfx, normalY * _selfy)));
        float _t8 = Math.fma(-Math.fma(-_t4, _t4, 1.0f), eta * eta, 1.0f);
        float _t11 = Math.fma(eta, _t4, (float) Math.sqrt(Math.max(0.0f, _t8)));
        if (_t8 >= 0.0f) {
            dest[destOffset + 0] = Math.fma(eta, _selfx, -(normalX * _t11));
            dest[destOffset + 1] = Math.fma(eta, _selfy, -(normalY * _t11));
            dest[destOffset + 2] = Math.fma(eta, _selfz, -(normalZ * _t11));
            dest[destOffset + 3] = Math.fma(eta, _selfw, -(normalW * _t11));
        } else {
            dest[destOffset + 0] = 0.0f;
            dest[destOffset + 1] = 0.0f;
            dest[destOffset + 2] = 0.0f;
            dest[destOffset + 3] = 0.0f;
        }
        return dest;
    }

    public static float[] refract_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] normal, int normalOffset, float eta) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _selfw = src[srcOffset + 3];
        float _normalx = normal[normalOffset + 0];
        float _normaly = normal[normalOffset + 1];
        float _normalz = normal[normalOffset + 2];
        float _normalw = normal[normalOffset + 3];
        float _t4 = Math.fma(_normalw, _selfw, Math.fma(_normalz, _selfz, Math.fma(_normalx, _selfx, _normaly * _selfy)));
        float _t8 = Math.fma(-Math.fma(-_t4, _t4, 1.0f), eta * eta, 1.0f);
        float _t11 = Math.fma(eta, _t4, (float) Math.sqrt(Math.max(0.0f, _t8)));
        if (_t8 >= 0.0f) {
            dest[destOffset + 0] = Math.fma(eta, _selfx, -(_normalx * _t11));
            dest[destOffset + 1] = Math.fma(eta, _selfy, -(_normaly * _t11));
            dest[destOffset + 2] = Math.fma(eta, _selfz, -(_normalz * _t11));
            dest[destOffset + 3] = Math.fma(eta, _selfw, -(_normalw * _t11));
        } else {
            dest[destOffset + 0] = 0.0f;
            dest[destOffset + 1] = 0.0f;
            dest[destOffset + 2] = 0.0f;
            dest[destOffset + 3] = 0.0f;
        }
        return dest;
    }

    public static float[] sqrt_scalar(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _selfw = src[srcOffset + 3];
        dest[destOffset + 0] = (float) Math.sqrt(_selfx);
        dest[destOffset + 1] = (float) Math.sqrt(_selfy);
        dest[destOffset + 2] = (float) Math.sqrt(_selfz);
        dest[destOffset + 3] = (float) Math.sqrt(_selfw);
        return dest;
    }

    public static float[] preMul_scalar(float[] dest, int destOffset, float[] src, int srcOffset, float[] mat, int matOffset) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _selfw = src[srcOffset + 3];
        float _mat00 = mat[matOffset + 0];
        float _mat10 = mat[matOffset + 1];
        float _mat20 = mat[matOffset + 2];
        float _mat30 = mat[matOffset + 3];
        float _mat01 = mat[matOffset + 4];
        float _mat11 = mat[matOffset + 5];
        float _mat21 = mat[matOffset + 6];
        float _mat31 = mat[matOffset + 7];
        float _mat02 = mat[matOffset + 8];
        float _mat12 = mat[matOffset + 9];
        float _mat22 = mat[matOffset + 10];
        float _mat32 = mat[matOffset + 11];
        float _mat03 = mat[matOffset + 12];
        float _mat13 = mat[matOffset + 13];
        float _mat23 = mat[matOffset + 14];
        float _mat33 = mat[matOffset + 15];
        dest[destOffset + 0] = Math.fma(_mat03, _selfw, Math.fma(_mat02, _selfz, Math.fma(_mat00, _selfx, _mat01 * _selfy)));
        dest[destOffset + 1] = Math.fma(_mat13, _selfw, Math.fma(_mat12, _selfz, Math.fma(_mat10, _selfx, _mat11 * _selfy)));
        dest[destOffset + 2] = Math.fma(_mat23, _selfw, Math.fma(_mat22, _selfz, Math.fma(_mat20, _selfx, _mat21 * _selfy)));
        dest[destOffset + 3] = Math.fma(_mat33, _selfw, Math.fma(_mat32, _selfz, Math.fma(_mat30, _selfx, _mat31 * _selfy)));
        return dest;
    }

}
