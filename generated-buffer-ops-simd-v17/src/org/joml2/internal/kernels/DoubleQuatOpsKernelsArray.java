package org.joml2.internal.kernels;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.ops.*;
import org.joml2.internal.unsafe.*;
import org.joml2.internal.simd.*;

/**
 * Scalar/Unsafe kernel leaves of {@link DoubleQuatOps} whose leading storage
 * parameter is a {@code double[]} array. Split into a sibling compilation unit purely
 * to keep generated sources IDE-sized; package-private, called only from
 * {@code DoubleQuatOps} and its sibling kernel units. Not public API.
 */
public final class DoubleQuatOpsKernelsArray {
    private DoubleQuatOpsKernelsArray() {}

    public static double[] add_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _otherx = other[otherOffset + 0];
        double _othery = other[otherOffset + 1];
        double _otherz = other[otherOffset + 2];
        double _otherw = other[otherOffset + 3];
        dest[destOffset + 0] = _otherx + _selfx;
        dest[destOffset + 1] = _othery + _selfy;
        dest[destOffset + 2] = _otherz + _selfz;
        dest[destOffset + 3] = _otherw + _selfw;
        return dest;
    }

    public static double[] negate_scalar(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        dest[destOffset + 0] = -_selfx;
        dest[destOffset + 1] = -_selfy;
        dest[destOffset + 2] = -_selfz;
        dest[destOffset + 3] = -_selfw;
        return dest;
    }

    public static double[] sub_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _otherx = other[otherOffset + 0];
        double _othery = other[otherOffset + 1];
        double _otherz = other[otherOffset + 2];
        double _otherw = other[otherOffset + 3];
        dest[destOffset + 0] = _selfx - _otherx;
        dest[destOffset + 1] = _selfy - _othery;
        dest[destOffset + 2] = _selfz - _otherz;
        dest[destOffset + 3] = _selfw - _otherw;
        return dest;
    }

    public static double[] set_scalar(double[] dest, int destOffset, double[] v, int vOffset) {
        double _vx = v[vOffset + 0];
        double _vy = v[vOffset + 1];
        double _vz = v[vOffset + 2];
        double _vw = v[vOffset + 3];
        dest[destOffset + 0] = _vx;
        dest[destOffset + 1] = _vy;
        dest[destOffset + 2] = _vz;
        dest[destOffset + 3] = _vw;
        return dest;
    }

    public static double[] makeFromMatrixMat3x3_scalar(double[] dest, int destOffset, double[] m, int mOffset) {
        double _m00 = m[mOffset + 0];
        double _m10 = m[mOffset + 1];
        double _m20 = m[mOffset + 2];
        double _m01 = m[mOffset + 3];
        double _m11 = m[mOffset + 4];
        double _m21 = m[mOffset + 5];
        double _m02 = m[mOffset + 6];
        double _m12 = m[mOffset + 7];
        double _m22 = m[mOffset + 8];
        double _t0 = _m00 + _m11;
        double _t1 = _m21 - _m12;
        double _t2 = Math.max(_m11, _m22);
        double _t4 = _m01 + _m10;
        double _t6 = _m02 + _m20;
        double _t7 = _m02 - _m20;
        double _t8 = _m12 + _m21;
        double _t9 = _m10 - _m01;
        double _t10 = _m22 + _t0;
        double _t14 = 1.0 + _t10;
        double _t15 = 1.0 + (_m00 - (_m11 + _m22));
        double _t16 = 1.0 + (_m11 - (_m00 + _m22));
        double _t17 = 1.0 + (_m22 - _t0);
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
            if (_m00 > _t2) {
                dest[destOffset + 0] = 0.5 * Math.sqrt(_t15);
                dest[destOffset + 1] = 0.5 * _t4 * _t21;
                dest[destOffset + 2] = 0.5 * _t6 * _t21;
                dest[destOffset + 3] = 0.5 * _t1 * _t21;
            } else {
                if (_m11 > _m22) {
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

    public static double[] makeFromMatrixMat3x4_scalar(double[] dest, int destOffset, double[] m, int mOffset) {
        double _m00 = m[mOffset + 0];
        double _m01 = m[mOffset + 1];
        double _m02 = m[mOffset + 2];
        double _m10 = m[mOffset + 4];
        double _m11 = m[mOffset + 5];
        double _m12 = m[mOffset + 6];
        double _m20 = m[mOffset + 8];
        double _m21 = m[mOffset + 9];
        double _m22 = m[mOffset + 10];
        double _t0 = _m00 + _m11;
        double _t1 = _m21 - _m12;
        double _t2 = Math.max(_m11, _m22);
        double _t4 = _m01 + _m10;
        double _t6 = _m02 + _m20;
        double _t7 = _m02 - _m20;
        double _t8 = _m12 + _m21;
        double _t9 = _m10 - _m01;
        double _t10 = _m22 + _t0;
        double _t14 = 1.0 + _t10;
        double _t15 = 1.0 + (_m00 - (_m11 + _m22));
        double _t16 = 1.0 + (_m11 - (_m00 + _m22));
        double _t17 = 1.0 + (_m22 - _t0);
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
            if (_m00 > _t2) {
                dest[destOffset + 0] = 0.5 * Math.sqrt(_t15);
                dest[destOffset + 1] = 0.5 * _t4 * _t21;
                dest[destOffset + 2] = 0.5 * _t6 * _t21;
                dest[destOffset + 3] = 0.5 * _t1 * _t21;
            } else {
                if (_m11 > _m22) {
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

    public static double[] makeFromMatrixMat4x4_scalar(double[] dest, int destOffset, double[] m, int mOffset) {
        double _m00 = m[mOffset + 0];
        double _m10 = m[mOffset + 1];
        double _m20 = m[mOffset + 2];
        double _m01 = m[mOffset + 4];
        double _m11 = m[mOffset + 5];
        double _m21 = m[mOffset + 6];
        double _m02 = m[mOffset + 8];
        double _m12 = m[mOffset + 9];
        double _m22 = m[mOffset + 10];
        double _t0 = _m00 + _m11;
        double _t1 = _m21 - _m12;
        double _t2 = Math.max(_m11, _m22);
        double _t4 = _m01 + _m10;
        double _t6 = _m02 + _m20;
        double _t7 = _m02 - _m20;
        double _t8 = _m12 + _m21;
        double _t9 = _m10 - _m01;
        double _t10 = _m22 + _t0;
        double _t14 = 1.0 + _t10;
        double _t15 = 1.0 + (_m00 - (_m11 + _m22));
        double _t16 = 1.0 + (_m11 - (_m00 + _m22));
        double _t17 = 1.0 + (_m22 - _t0);
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
            if (_m00 > _t2) {
                dest[destOffset + 0] = 0.5 * Math.sqrt(_t15);
                dest[destOffset + 1] = 0.5 * _t4 * _t21;
                dest[destOffset + 2] = 0.5 * _t6 * _t21;
                dest[destOffset + 3] = 0.5 * _t1 * _t21;
            } else {
                if (_m11 > _m22) {
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

    public static double[] makeZero_scalar(double[] dest, int destOffset) {
        dest[destOffset + 0] = 0.0;
        dest[destOffset + 1] = 0.0;
        dest[destOffset + 2] = 0.0;
        dest[destOffset + 3] = 0.0;
        return dest;
    }

    public static double[] lerp_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double otherX, double otherY, double otherZ, double otherW, double t) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        dest[destOffset + 0] = Math.fma(t, otherX - _selfx, _selfx);
        dest[destOffset + 1] = Math.fma(t, otherY - _selfy, _selfy);
        dest[destOffset + 2] = Math.fma(t, otherZ - _selfz, _selfz);
        dest[destOffset + 3] = Math.fma(t, otherW - _selfw, _selfw);
        return dest;
    }

    public static double[] lerp_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset, double t) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _otherx = other[otherOffset + 0];
        double _othery = other[otherOffset + 1];
        double _otherz = other[otherOffset + 2];
        double _otherw = other[otherOffset + 3];
        dest[destOffset + 0] = Math.fma(t, _otherx - _selfx, _selfx);
        dest[destOffset + 1] = Math.fma(t, _othery - _selfy, _selfy);
        dest[destOffset + 2] = Math.fma(t, _otherz - _selfz, _selfz);
        dest[destOffset + 3] = Math.fma(t, _otherw - _selfw, _selfw);
        return dest;
    }

    public static double[] nlerp_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double[] target, int targetOffset, double alpha) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _targetx = target[targetOffset + 0];
        double _targety = target[targetOffset + 1];
        double _targetz = target[targetOffset + 2];
        double _targetw = target[targetOffset + 3];
        double _t4 = Math.fma(alpha, _targetw - _selfw, _selfw);
        double _t5 = Math.fma(alpha, _targetz - _selfz, _selfz);
        double _t6 = Math.fma(alpha, _targetx - _selfx, _selfx);
        double _t7 = Math.fma(alpha, _targety - _selfy, _selfy);
        double _t11 = Math.fma(_t4, _t4, Math.fma(_t5, _t5, Math.fma(_t6, _t6, _t7 * _t7)));
        double _t12 = (1.0 / Math.sqrt(_t11));
        if (_t11 > 0.0) {
            dest[destOffset + 0] = _t6 * _t12;
            dest[destOffset + 1] = _t7 * _t12;
            dest[destOffset + 2] = _t5 * _t12;
            dest[destOffset + 3] = _t4 * _t12;
        } else {
            dest[destOffset + 0] = 0.0;
            dest[destOffset + 1] = 0.0;
            dest[destOffset + 2] = 0.0;
            dest[destOffset + 3] = 0.0;
        }
        return dest;
    }

    public static double[] nlerpShortest_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double[] target, int targetOffset, double alpha) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _targetx = target[targetOffset + 0];
        double _targety = target[targetOffset + 1];
        double _targetz = target[targetOffset + 2];
        double _targetw = target[targetOffset + 3];
        double _t8 = -Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)));
        double _t17, _t18, _t19, _t20;
        if (_t8 > 0.0) {
            _t17 = Math.fma(alpha, -_targetw - _selfw, _selfw);
            _t18 = Math.fma(alpha, -_targetz - _selfz, _selfz);
            _t19 = Math.fma(alpha, -_targetx - _selfx, _selfx);
            _t20 = Math.fma(alpha, -_targety - _selfy, _selfy);
        } else {
            _t17 = Math.fma(alpha, _targetw - _selfw, _selfw);
            _t18 = Math.fma(alpha, _targetz - _selfz, _selfz);
            _t19 = Math.fma(alpha, _targetx - _selfx, _selfx);
            _t20 = Math.fma(alpha, _targety - _selfy, _selfy);
        }
        double _t24 = Math.fma(_t17, _t17, Math.fma(_t18, _t18, Math.fma(_t19, _t19, _t20 * _t20)));
        double _t25 = (1.0 / Math.sqrt(_t24));
        if (_t24 > 0.0) {
            dest[destOffset + 0] = _t19 * _t25;
            dest[destOffset + 1] = _t20 * _t25;
            dest[destOffset + 2] = _t18 * _t25;
            dest[destOffset + 3] = _t17 * _t25;
        } else {
            dest[destOffset + 0] = 0.0;
            dest[destOffset + 1] = 0.0;
            dest[destOffset + 2] = 0.0;
            dest[destOffset + 3] = 0.0;
        }
        return dest;
    }

    public static double[] slerp_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double targetX, double targetY, double targetZ, double targetW, double alpha) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t0 = 1.0 - alpha;
        double _t7 = Math.acos(Math.min(1.0, Math.max(-1.0, Math.fma(_selfw, targetW, Math.fma(_selfz, targetZ, Math.fma(_selfx, targetX, _selfy * targetY))))));
        double _t8 = Math.sin(_t7);
        double _t8_inv = 1.0 / _t8;
        double _t9 = Math.abs(_t8);
        double _t11 = Math.sin(alpha * _t7);
        double _t13 = Math.sin(_t0 * _t7);
        if (_t9 > 1.0E-6) {
            dest[destOffset + 0] = Math.fma(_selfx, _t13, targetX * _t11) * _t8_inv;
            dest[destOffset + 1] = Math.fma(_selfy, _t13, targetY * _t11) * _t8_inv;
            dest[destOffset + 2] = Math.fma(_selfz, _t13, targetZ * _t11) * _t8_inv;
            dest[destOffset + 3] = Math.fma(_selfw, _t13, targetW * _t11) * _t8_inv;
        } else {
            dest[destOffset + 0] = Math.fma(alpha, targetX, _selfx * _t0);
            dest[destOffset + 1] = Math.fma(alpha, targetY, _selfy * _t0);
            dest[destOffset + 2] = Math.fma(alpha, targetZ, _selfz * _t0);
            dest[destOffset + 3] = Math.fma(alpha, targetW, _selfw * _t0);
        }
        return dest;
    }

    public static double[] slerp_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double[] target, int targetOffset, double alpha) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _targetx = target[targetOffset + 0];
        double _targety = target[targetOffset + 1];
        double _targetz = target[targetOffset + 2];
        double _targetw = target[targetOffset + 3];
        double _t0 = 1.0 - alpha;
        double _t7 = Math.acos(Math.min(1.0, Math.max(-1.0, Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety))))));
        double _t8 = Math.sin(_t7);
        double _t8_inv = 1.0 / _t8;
        double _t9 = Math.abs(_t8);
        double _t11 = Math.sin(alpha * _t7);
        double _t13 = Math.sin(_t0 * _t7);
        if (_t9 > 1.0E-6) {
            dest[destOffset + 0] = Math.fma(_selfx, _t13, _targetx * _t11) * _t8_inv;
            dest[destOffset + 1] = Math.fma(_selfy, _t13, _targety * _t11) * _t8_inv;
            dest[destOffset + 2] = Math.fma(_selfz, _t13, _targetz * _t11) * _t8_inv;
            dest[destOffset + 3] = Math.fma(_selfw, _t13, _targetw * _t11) * _t8_inv;
        } else {
            dest[destOffset + 0] = Math.fma(alpha, _targetx, _selfx * _t0);
            dest[destOffset + 1] = Math.fma(alpha, _targety, _selfy * _t0);
            dest[destOffset + 2] = Math.fma(alpha, _targetz, _selfz * _t0);
            dest[destOffset + 3] = Math.fma(alpha, _targetw, _selfw * _t0);
        }
        return dest;
    }

    public static double[] slerpShortest_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double[] target, int targetOffset, double alpha) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _targetx = target[targetOffset + 0];
        double _targety = target[targetOffset + 1];
        double _targetz = target[targetOffset + 2];
        double _targetw = target[targetOffset + 3];
        double _t0 = 1.0 - alpha;
        double _t12 = Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)));
        double _t14 = -_t12;
        double _t16 = Math.acos(Math.min(1.0, Math.abs(_t12)));
        double _t17 = Math.sin(_t16);
        double _t17_inv = 1.0 / _t17;
        double _t19 = Math.sin(alpha * _t16);
        double _t21, _t22, _t23, _t24;
        if (_t14 > 0.0) {
            _t21 = -_targetw;
            _t22 = -_targetz;
            _t23 = -_targetx;
            _t24 = -_targety;
        } else {
            _t21 = _targetw;
            _t22 = _targetz;
            _t23 = _targetx;
            _t24 = _targety;
        }
        double _t25 = Math.sin(_t0 * _t16);
        double _t42, _t43, _t44, _t45;
        if (_t17 > 0.0) {
            _t42 = Math.fma(_selfw, _t25, _t19 * _t21) * _t17_inv;
            _t43 = Math.fma(_selfz, _t25, _t19 * _t22) * _t17_inv;
            _t44 = Math.fma(_selfx, _t25, _t19 * _t23) * _t17_inv;
            _t45 = Math.fma(_selfy, _t25, _t19 * _t24) * _t17_inv;
        } else {
            _t42 = Math.fma(alpha, _t21, _selfw * _t0);
            _t43 = Math.fma(alpha, _t22, _selfz * _t0);
            _t44 = Math.fma(alpha, _t23, _selfx * _t0);
            _t45 = Math.fma(alpha, _t24, _selfy * _t0);
        }
        double _t49 = Math.fma(_t42, _t42, Math.fma(_t43, _t43, Math.fma(_t44, _t44, _t45 * _t45)));
        double _t50 = (1.0 / Math.sqrt(_t49));
        if (_t49 > 0.0) {
            dest[destOffset + 0] = _t50 * _t44;
            dest[destOffset + 1] = _t50 * _t45;
            dest[destOffset + 2] = _t50 * _t43;
            dest[destOffset + 3] = _t50 * _t42;
        } else {
            dest[destOffset + 0] = 0.0;
            dest[destOffset + 1] = 0.0;
            dest[destOffset + 2] = 0.0;
            dest[destOffset + 3] = 0.0;
        }
        return dest;
    }

    public static double[] calculateW_scalar(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        dest[destOffset + 0] = _selfx;
        dest[destOffset + 1] = _selfy;
        dest[destOffset + 2] = _selfz;
        dest[destOffset + 3] = Math.sqrt(Math.max(0.0, Math.fma(-_selfx, _selfx, Math.fma(-_selfy, _selfy, Math.fma(-_selfz, _selfz, 1.0)))));
        return dest;
    }

    public static double[] difference_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t3 = Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)));
        double _t3_inv = 1.0 / _t3;
        dest[destOffset + 0] = (Math.fma(otherX, _selfw, -(otherW * _selfx)) + Math.fma(otherY, _selfz, -(otherZ * _selfy))) * _t3_inv;
        dest[destOffset + 1] = -(otherW * _selfy * _t3_inv) - otherX * _selfz * _t3_inv + Math.fma(otherY, _selfw, otherZ * _selfx) * _t3_inv;
        dest[destOffset + 2] = (Math.fma(otherX, _selfy, -(otherW * _selfz)) + Math.fma(otherZ, _selfw, -(otherY * _selfx))) * _t3_inv;
        dest[destOffset + 3] = Math.fma(otherZ, _selfz, Math.fma(otherY, _selfy, Math.fma(otherX, _selfx, otherW * _selfw))) * _t3_inv;
        return dest;
    }

    public static double[] difference_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _otherx = other[otherOffset + 0];
        double _othery = other[otherOffset + 1];
        double _otherz = other[otherOffset + 2];
        double _otherw = other[otherOffset + 3];
        double _t3 = Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)));
        double _t3_inv = 1.0 / _t3;
        dest[destOffset + 0] = (Math.fma(_otherx, _selfw, -(_otherw * _selfx)) + Math.fma(_othery, _selfz, -(_otherz * _selfy))) * _t3_inv;
        dest[destOffset + 1] = -(_otherw * _selfy * _t3_inv) - _otherx * _selfz * _t3_inv + Math.fma(_othery, _selfw, _otherz * _selfx) * _t3_inv;
        dest[destOffset + 2] = (Math.fma(_otherx, _selfy, -(_otherw * _selfz)) + Math.fma(_otherz, _selfw, -(_othery * _selfx))) * _t3_inv;
        dest[destOffset + 3] = Math.fma(_otherz, _selfz, Math.fma(_othery, _selfy, Math.fma(_otherx, _selfx, _otherw * _selfw))) * _t3_inv;
        return dest;
    }

    public static double[] exp_scalar(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t0 = Math.exp(_selfw);
        double _t3 = Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy));
        double _t4 = Math.sqrt(_t3);
        double _t8 = Math.sin(_t4) * _t0 * (1.0 / Math.sqrt(_t3));
        if (_t3 > 0.0) {
            dest[destOffset + 0] = _selfx * _t8;
            dest[destOffset + 1] = _selfy * _t8;
            dest[destOffset + 2] = _selfz * _t8;
        } else {
            dest[destOffset + 0] = 0.0;
            dest[destOffset + 1] = 0.0;
            dest[destOffset + 2] = 0.0;
        }
        dest[destOffset + 3] = Math.cos(_t4) * _t0;
        return dest;
    }

    public static double[] log_scalar(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t2 = Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy));
        double _t4 = Math.fma(_selfw, _selfw, _t2);
        double _t8 = Math.acos(_selfw * (1.0 / Math.sqrt(_t4))) * (1.0 / Math.sqrt(_t2));
        if (_t2 > 0.0) {
            dest[destOffset + 0] = _selfx * _t8;
            dest[destOffset + 1] = _selfy * _t8;
            dest[destOffset + 2] = _selfz * _t8;
        } else {
            dest[destOffset + 0] = 0.0;
            dest[destOffset + 1] = 0.0;
            dest[destOffset + 2] = 0.0;
        }
        dest[destOffset + 3] = Math.log(Math.sqrt(_t4));
        return dest;
    }

    public static double[] normalize_scalar(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t3 = Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)));
        double _t4 = (1.0 / Math.sqrt(_t3));
        if (_t3 > 0.0) {
            dest[destOffset + 0] = _selfx * _t4;
            dest[destOffset + 1] = _selfy * _t4;
            dest[destOffset + 2] = _selfz * _t4;
            dest[destOffset + 3] = _selfw * _t4;
        } else {
            dest[destOffset + 0] = 0.0;
            dest[destOffset + 1] = 0.0;
            dest[destOffset + 2] = 0.0;
            dest[destOffset + 3] = 0.0;
        }
        return dest;
    }

    public static double[] pow_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double t) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t2 = Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy));
        double _t4 = Math.fma(_selfw, _selfw, _t2);
        double _t11 = Math.exp(t * Math.log(Math.sqrt(_t4)));
        double _t12 = Math.acos(_selfw * (1.0 / Math.sqrt(_t4))) * (1.0 / Math.sqrt(_t2));
        double _t19, _t20, _t21;
        if (_t2 > 0.0) {
            _t19 = t * _selfz * _t12;
            _t20 = t * _selfx * _t12;
            _t21 = t * _selfy * _t12;
        } else {
            _t19 = t * 0.0;
            _t20 = t * 0.0;
            _t21 = t * 0.0;
        }
        double _t24 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        double _t25 = Math.sqrt(_t24);
        double _t29 = Math.sin(_t25) * _t11 * (1.0 / Math.sqrt(_t24));
        if (_t24 > 0.0) {
            dest[destOffset + 0] = _t20 * _t29;
            dest[destOffset + 1] = _t21 * _t29;
            dest[destOffset + 2] = _t19 * _t29;
        } else {
            dest[destOffset + 0] = 0.0;
            dest[destOffset + 1] = 0.0;
            dest[destOffset + 2] = 0.0;
        }
        dest[destOffset + 3] = Math.cos(_t25) * _t11;
        return dest;
    }

    public static double[] rotateTowards_scalar(double[] dest, int destOffset, double[] src, int srcOffset, double[] target, int targetOffset, double step) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _targetx = target[targetOffset + 0];
        double _targety = target[targetOffset + 1];
        double _targetz = target[targetOffset + 2];
        double _targetw = target[targetOffset + 3];
        double _t7 = Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)));
        double _t9 = -_t7;
        double _t11 = Math.acos(Math.min(1.0, Math.abs(_t7)));
        double _t12 = Math.sin(_t11);
        double _t12_inv = 1.0 / _t12;
        double _t13 = 2.0 * _t11;
        double _t15, _t16, _t17, _t18;
        if (_t9 > 0.0) {
            _t15 = -_targetw;
            _t16 = -_targetz;
            _t17 = -_targetx;
            _t18 = -_targety;
        } else {
            _t15 = _targetw;
            _t16 = _targetz;
            _t17 = _targetx;
            _t18 = _targety;
        }
        double _t20 = _t13 > 0.0 ? Math.min(1.0, step / _t13) : 0.0;
        double _t21 = 1.0 - _t20;
        double _t23 = Math.sin(_t11 * _t20);
        double _t25 = Math.sin(_t21 * _t11);
        double _t46, _t47, _t48, _t49;
        if (_t12 > 0.0) {
            _t46 = Math.fma(_selfw, _t25, _t23 * _t15) * _t12_inv;
            _t47 = Math.fma(_selfz, _t25, _t23 * _t16) * _t12_inv;
            _t48 = Math.fma(_selfx, _t25, _t23 * _t17) * _t12_inv;
            _t49 = Math.fma(_selfy, _t25, _t23 * _t18) * _t12_inv;
        } else {
            _t46 = Math.fma(_selfw, _t21, _t15 * _t20);
            _t47 = Math.fma(_selfz, _t21, _t16 * _t20);
            _t48 = Math.fma(_selfx, _t21, _t17 * _t20);
            _t49 = Math.fma(_selfy, _t21, _t18 * _t20);
        }
        double _t53 = Math.fma(_t46, _t46, Math.fma(_t47, _t47, Math.fma(_t48, _t48, _t49 * _t49)));
        double _t54 = (1.0 / Math.sqrt(_t53));
        if (_t53 > 0.0) {
            dest[destOffset + 0] = _t54 * _t48;
            dest[destOffset + 1] = _t54 * _t49;
            dest[destOffset + 2] = _t54 * _t47;
            dest[destOffset + 3] = _t54 * _t46;
        } else {
            dest[destOffset + 0] = 0.0;
            dest[destOffset + 1] = 0.0;
            dest[destOffset + 2] = 0.0;
            dest[destOffset + 3] = 0.0;
        }
        return dest;
    }

    public static double[] makeRotationAxis_scalar(double[] dest, int destOffset, double angle, double axisX, double axisY, double axisZ) {
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        dest[destOffset + 0] = axisX * _t1;
        dest[destOffset + 1] = axisY * _t1;
        dest[destOffset + 2] = axisZ * _t1;
        dest[destOffset + 3] = Math.cos(_t0);
        return dest;
    }

    public static double[] makeRotationAxis_scalar(double[] dest, int destOffset, double[] axis, int axisOffset, double angle) {
        double _axisx = axis[axisOffset + 0];
        double _axisy = axis[axisOffset + 1];
        double _axisz = axis[axisOffset + 2];
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        dest[destOffset + 0] = _axisx * _t1;
        dest[destOffset + 1] = _axisy * _t1;
        dest[destOffset + 2] = _axisz * _t1;
        dest[destOffset + 3] = Math.cos(_t0);
        return dest;
    }

    public static double[] makeRotationLookAlong_scalar(double[] dest, int destOffset, double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        double _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7, _t8, _t9;
        if (_t2 > 0.0) {
            _t7 = dirZ * _t3;
            _t8 = dirY * _t3;
            _t9 = dirX * _t3;
        } else {
            _t7 = 0.0;
            _t8 = 0.0;
            _t9 = 0.0;
        }
        double _t10 = -_t9;
        double _t11 = -_t8;
        double _t12 = -_t7;
        double _t21 = Math.fma(upX, _t8, -(upY * _t9));
        double _t22 = Math.fma(upY, _t7, -(upZ * _t8));
        double _t23 = Math.fma(upZ, _t9, -(upX * _t7));
        double _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        double _t27 = (1.0 / Math.sqrt(_t26));
        double _t31, _t32, _t33;
        if (_t26 > 0.0) {
            _t31 = _t22 * _t27;
            _t32 = _t21 * _t27;
            _t33 = _t23 * _t27;
        } else {
            _t31 = 0.0;
            _t32 = 0.0;
            _t33 = 0.0;
        }
        double _t34 = 1.0 + _t31;
        double _t37 = _t9 + _t32;
        double _t38 = _t9 - _t32;
        double _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        double _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        double _t55 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        double _t56 = Math.max(_t49, _t7);
        double _t57 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        double _t58 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        double _t59 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7));
        double _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        double _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        double _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0 - _t7 - _t31));
        double _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0 + _t7 - _t31));
        double _t64 = (1.0 / Math.sqrt(_t60));
        double _t65 = (1.0 / Math.sqrt(_t62));
        double _t66 = (1.0 / Math.sqrt(_t63));
        double _t67 = (1.0 / Math.sqrt(_t61));
        if (_t59 > 0.0) {
            dest[destOffset + 0] = 0.5 * _t55 * _t64;
            dest[destOffset + 1] = 0.5 * _t38 * _t64;
            dest[destOffset + 2] = 0.5 * _t58 * _t64;
            dest[destOffset + 3] = 0.5 * Math.sqrt(_t60);
        } else {
            if (_t31 > _t56) {
                dest[destOffset + 0] = 0.5 * Math.sqrt(_t61);
                dest[destOffset + 1] = 0.5 * _t57 * _t67;
                dest[destOffset + 2] = 0.5 * _t37 * _t67;
                dest[destOffset + 3] = 0.5 * _t55 * _t67;
            } else {
                if (_t49 > _t7) {
                    dest[destOffset + 0] = 0.5 * _t57 * _t65;
                    dest[destOffset + 1] = 0.5 * Math.sqrt(_t62);
                    dest[destOffset + 2] = 0.5 * _t54 * _t65;
                    dest[destOffset + 3] = 0.5 * _t38 * _t65;
                } else {
                    dest[destOffset + 0] = 0.5 * _t37 * _t66;
                    dest[destOffset + 1] = 0.5 * _t54 * _t66;
                    dest[destOffset + 2] = 0.5 * Math.sqrt(_t63);
                    dest[destOffset + 3] = 0.5 * _t58 * _t66;
                }
            }
        }
        return dest;
    }

    public static double[] makeRotationLookAlong_scalar(double[] dest, int destOffset, double[] dir, int dirOffset, double[] up, int upOffset) {
        double _dirx = dir[dirOffset + 0];
        double _diry = dir[dirOffset + 1];
        double _dirz = dir[dirOffset + 2];
        double _upx = up[upOffset + 0];
        double _upy = up[upOffset + 1];
        double _upz = up[upOffset + 2];
        double _t2 = Math.fma(_dirz, _dirz, Math.fma(_dirx, _dirx, _diry * _diry));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7, _t8, _t9;
        if (_t2 > 0.0) {
            _t7 = _dirz * _t3;
            _t8 = _diry * _t3;
            _t9 = _dirx * _t3;
        } else {
            _t7 = 0.0;
            _t8 = 0.0;
            _t9 = 0.0;
        }
        double _t10 = -_t9;
        double _t11 = -_t8;
        double _t12 = -_t7;
        double _t21 = Math.fma(_upx, _t8, -(_upy * _t9));
        double _t22 = Math.fma(_upy, _t7, -(_upz * _t8));
        double _t23 = Math.fma(_upz, _t9, -(_upx * _t7));
        double _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        double _t27 = (1.0 / Math.sqrt(_t26));
        double _t31, _t32, _t33;
        if (_t26 > 0.0) {
            _t31 = _t22 * _t27;
            _t32 = _t21 * _t27;
            _t33 = _t23 * _t27;
        } else {
            _t31 = 0.0;
            _t32 = 0.0;
            _t33 = 0.0;
        }
        double _t34 = 1.0 + _t31;
        double _t37 = _t9 + _t32;
        double _t38 = _t9 - _t32;
        double _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        double _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        double _t55 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        double _t56 = Math.max(_t49, _t7);
        double _t57 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        double _t58 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        double _t59 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7));
        double _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        double _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        double _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0 - _t7 - _t31));
        double _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0 + _t7 - _t31));
        double _t64 = (1.0 / Math.sqrt(_t60));
        double _t65 = (1.0 / Math.sqrt(_t62));
        double _t66 = (1.0 / Math.sqrt(_t63));
        double _t67 = (1.0 / Math.sqrt(_t61));
        if (_t59 > 0.0) {
            dest[destOffset + 0] = 0.5 * _t55 * _t64;
            dest[destOffset + 1] = 0.5 * _t38 * _t64;
            dest[destOffset + 2] = 0.5 * _t58 * _t64;
            dest[destOffset + 3] = 0.5 * Math.sqrt(_t60);
        } else {
            if (_t31 > _t56) {
                dest[destOffset + 0] = 0.5 * Math.sqrt(_t61);
                dest[destOffset + 1] = 0.5 * _t57 * _t67;
                dest[destOffset + 2] = 0.5 * _t37 * _t67;
                dest[destOffset + 3] = 0.5 * _t55 * _t67;
            } else {
                if (_t49 > _t7) {
                    dest[destOffset + 0] = 0.5 * _t57 * _t65;
                    dest[destOffset + 1] = 0.5 * Math.sqrt(_t62);
                    dest[destOffset + 2] = 0.5 * _t54 * _t65;
                    dest[destOffset + 3] = 0.5 * _t38 * _t65;
                } else {
                    dest[destOffset + 0] = 0.5 * _t37 * _t66;
                    dest[destOffset + 1] = 0.5 * _t54 * _t66;
                    dest[destOffset + 2] = 0.5 * Math.sqrt(_t63);
                    dest[destOffset + 3] = 0.5 * _t58 * _t66;
                }
            }
        }
        return dest;
    }

    public static double[] makeRotationYXZ_scalar(double[] dest, int destOffset, double angleX, double angleY, double angleZ) {
        double _t0 = 0.5 * angleX;
        double _t1 = 0.5 * angleY;
        double _t2 = 0.5 * angleZ;
        double _t3 = Math.sin(_t0);
        double _t4 = Math.cos(_t1);
        double _t5 = Math.cos(_t2);
        double _t6 = Math.sin(_t1);
        double _t7 = Math.cos(_t0);
        double _t8 = Math.sin(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t7 * _t4;
        double _t12 = _t3 * _t6;
        dest[destOffset + 0] = Math.fma(_t9, _t5, _t10 * _t8);
        dest[destOffset + 1] = Math.fma(_t10, _t5, -(_t9 * _t8));
        dest[destOffset + 2] = Math.fma(_t11, _t8, -(_t12 * _t5));
        dest[destOffset + 3] = Math.fma(_t12, _t8, _t11 * _t5);
        return dest;
    }

}
