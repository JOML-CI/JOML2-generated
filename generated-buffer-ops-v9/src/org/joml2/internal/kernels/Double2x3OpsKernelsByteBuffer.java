package org.joml2.internal.kernels;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.ops.*;
import org.joml2.internal.unsafe.*;

/**
 * Scalar/Unsafe kernel leaves of {@link Double2x3Ops} whose leading storage
 * parameter is a {@link java.nio.ByteBuffer}. Split into a sibling compilation unit purely
 * to keep generated sources IDE-sized; package-private, called only from
 * {@code Double2x3Ops} and its sibling kernel units. Not public API.
 */
public final class Double2x3OpsKernelsByteBuffer {
    private Double2x3OpsKernelsByteBuffer() {}

    public static java.nio.ByteBuffer getColumn_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, int col) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double2x3OpsKernelsAddress.getColumn_unsafe(_destBase, _srcBase, col);
        return dest;
    }

    public static java.nio.ByteBuffer getColumn_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, int col) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 24);
        double _self02 = src.getDouble(srcOffset + 32);
        double _self12 = src.getDouble(srcOffset + 40);
        double _idxSw0;
        double _idxSw1;
        switch (col) {
            case 0: _idxSw0 = _self00; _idxSw1 = _self10; break;
            case 1: _idxSw0 = _self01; _idxSw1 = _self11; break;
            case 2: _idxSw0 = _self02; _idxSw1 = _self12; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + col);
        }
        dest.putDouble(destOffset + 0, _idxSw0);
        dest.putDouble(destOffset + 8, _idxSw1);
        return dest;
    }

    public static double getRotationAngle_unsafe(java.nio.ByteBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        return Double2x3OpsKernelsAddress.getRotationAngle_unsafe(_srcBase);
    }

    public static double getRotationAngle_api(java.nio.ByteBuffer src, int srcOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        return Math.atan2(_self10, _self00);
    }

    public static java.nio.ByteBuffer getRow_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, int row) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double2x3OpsKernelsAddress.getRow_unsafe(_destBase, _srcBase, row);
        return dest;
    }

    public static java.nio.ByteBuffer getRow_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, int row) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 24);
        double _self02 = src.getDouble(srcOffset + 32);
        double _self12 = src.getDouble(srcOffset + 40);
        double _idxSw0;
        double _idxSw1;
        double _idxSw2;
        switch (row) {
            case 0: _idxSw0 = _self00; _idxSw1 = _self01; _idxSw2 = _self02; break;
            case 1: _idxSw0 = _self10; _idxSw1 = _self11; _idxSw2 = _self12; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + row);
        }
        dest.putDouble(destOffset + 0, _idxSw0);
        dest.putDouble(destOffset + 8, _idxSw1);
        dest.putDouble(destOffset + 16, _idxSw2);
        return dest;
    }

    public static java.nio.ByteBuffer getTranslation_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double2x3OpsKernelsAddress.getTranslation_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer getTranslation_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _self02 = src.getDouble(srcOffset + 32);
        double _self12 = src.getDouble(srcOffset + 40);
        dest.putDouble(destOffset + 0, _self02);
        dest.putDouble(destOffset + 8, _self12);
        return dest;
    }

    public static double determinant_unsafe(java.nio.ByteBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        return Double2x3OpsKernelsAddress.determinant_unsafe(_srcBase);
    }

    public static double determinant_api(java.nio.ByteBuffer src, int srcOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 24);
        return Math.fma(_self00, _self11, -(_self01 * _self10));
    }

    public static double frobeniusNorm_unsafe(java.nio.ByteBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        return Double2x3OpsKernelsAddress.frobeniusNorm_unsafe(_srcBase);
    }

    public static double frobeniusNorm_api(java.nio.ByteBuffer src, int srcOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 24);
        double _self02 = src.getDouble(srcOffset + 32);
        double _self12 = src.getDouble(srcOffset + 40);
        return Math.sqrt(Math.fma(_self12, _self12, Math.fma(_self11, _self11, Math.fma(_self10, _self10, Math.fma(_self02, _self02, Math.fma(_self00, _self00, _self01 * _self01))))));
    }

    public static java.nio.ByteBuffer invert_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double2x3OpsKernelsAddress.invert_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer invert_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 24);
        double _self02 = src.getDouble(srcOffset + 32);
        double _self12 = src.getDouble(srcOffset + 40);
        double _t2 = Math.fma(_self00, _self11, -(_self01 * _self10));
        double _t2_inv = 1.0 / _t2;
        dest.putDouble(destOffset + 0, _self11 * _t2_inv);
        dest.putDouble(destOffset + 8, -(_self10 * _t2_inv));
        dest.putDouble(destOffset + 16, -(_self01 * _t2_inv));
        dest.putDouble(destOffset + 24, _self00 * _t2_inv);
        dest.putDouble(destOffset + 32, -(Math.fma(_self02, _self11, -(_self01 * _self12)) * _t2_inv));
        dest.putDouble(destOffset + 40, -(Math.fma(_self00, _self12, -(_self02 * _self10)) * _t2_inv));
        return dest;
    }

    public static java.nio.ByteBuffer invertProduct_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + otherOffset;
        Double2x3OpsKernelsAddress.invertProduct_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.ByteBuffer invertProduct_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 24);
        double _self02 = src.getDouble(srcOffset + 32);
        double _self12 = src.getDouble(srcOffset + 40);
        double _other00 = other.getDouble(otherOffset + 0);
        double _other10 = other.getDouble(otherOffset + 8);
        double _other01 = other.getDouble(otherOffset + 16);
        double _other11 = other.getDouble(otherOffset + 24);
        double _other02 = other.getDouble(otherOffset + 32);
        double _other12 = other.getDouble(otherOffset + 40);
        double _t6 = Math.fma(_other01, _self10, _other11 * _self11);
        double _t7 = Math.fma(_other00, _self00, _other10 * _self01);
        double _t8 = Math.fma(_other00, _self10, _other10 * _self11);
        double _t9 = Math.fma(_other01, _self00, _other11 * _self01);
        double _t10 = Math.fma(_other02, _self00, Math.fma(_other12, _self01, _self02));
        double _t11 = Math.fma(_other02, _self10, Math.fma(_other12, _self11, _self12));
        double _t14 = Math.fma(_t7, _t6, -(_t8 * _t9));
        double _t14_inv = 1.0 / _t14;
        dest.putDouble(destOffset + 0, _t6 * _t14_inv);
        dest.putDouble(destOffset + 8, -(_t8 * _t14_inv));
        dest.putDouble(destOffset + 16, -(_t9 * _t14_inv));
        dest.putDouble(destOffset + 24, _t7 * _t14_inv);
        dest.putDouble(destOffset + 32, -(Math.fma(_t10, _t6, -(_t11 * _t9)) * _t14_inv));
        dest.putDouble(destOffset + 40, -(Math.fma(_t11, _t7, -(_t10 * _t8)) * _t14_inv));
        return dest;
    }

    public static java.nio.ByteBuffer transpose_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double2x3OpsKernelsAddress.transpose_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer transpose_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 24);
        double _self02 = src.getDouble(srcOffset + 32);
        double _self12 = src.getDouble(srcOffset + 40);
        dest.putDouble(destOffset + 0, _self00);
        dest.putDouble(destOffset + 8, _self01);
        dest.putDouble(destOffset + 16, _self02);
        dest.putDouble(destOffset + 24, _self10);
        dest.putDouble(destOffset + 32, _self11);
        dest.putDouble(destOffset + 40, _self12);
        return dest;
    }

    public static java.nio.ByteBuffer add_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + otherOffset;
        Double2x3OpsKernelsAddress.add_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.ByteBuffer add_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 2;
            double _eself0 = src.getDouble(srcOffset + _lo * 8);
            double _eself1 = src.getDouble(srcOffset + (_lo + 1) * 8);
            double _eother0 = other.getDouble(otherOffset + _lo * 8);
            double _eother1 = other.getDouble(otherOffset + (_lo + 1) * 8);
            dest.putDouble(destOffset + _lo * 8, _eother0 + _eself0);
            dest.putDouble(destOffset + (_lo + 1) * 8, _eother1 + _eself1);
        }
        return dest;
    }

    public static java.nio.ByteBuffer negate_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double2x3OpsKernelsAddress.negate_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer negate_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 2;
            double _eself0 = src.getDouble(srcOffset + _lo * 8);
            double _eself1 = src.getDouble(srcOffset + (_lo + 1) * 8);
            dest.putDouble(destOffset + _lo * 8, -_eself0);
            dest.putDouble(destOffset + (_lo + 1) * 8, -_eself1);
        }
        return dest;
    }

    public static java.nio.ByteBuffer sub_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + otherOffset;
        Double2x3OpsKernelsAddress.sub_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.ByteBuffer sub_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 2;
            double _eself0 = src.getDouble(srcOffset + _lo * 8);
            double _eself1 = src.getDouble(srcOffset + (_lo + 1) * 8);
            double _eother0 = other.getDouble(otherOffset + _lo * 8);
            double _eother1 = other.getDouble(otherOffset + (_lo + 1) * 8);
            dest.putDouble(destOffset + _lo * 8, _eself0 - _eother0);
            dest.putDouble(destOffset + (_lo + 1) * 8, _eself1 - _eother1);
        }
        return dest;
    }

    public static java.nio.ByteBuffer set_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + vOffset;
        Double2x3OpsKernelsAddress.set_unsafe(_destBase, _vBase);
        return dest;
    }

    public static java.nio.ByteBuffer set_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer v, int vOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 2;
            double _ev0 = v.getDouble(vOffset + _lo * 8);
            double _ev1 = v.getDouble(vOffset + (_lo + 1) * 8);
            dest.putDouble(destOffset + _lo * 8, _ev0);
            dest.putDouble(destOffset + (_lo + 1) * 8, _ev1);
        }
        return dest;
    }

    public static java.nio.ByteBuffer setMat2x2_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer m, int mOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _mBase = UnsafeOpsHolder.U.getLong(m, UnsafeCopy.BB_ADDRESS_OFFSET) + mOffset;
        Double2x3OpsKernelsAddress.setMat2x2_unsafe(_destBase, _mBase);
        return dest;
    }

    public static java.nio.ByteBuffer setMat2x2_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer m, int mOffset) {
        double _m00 = m.getDouble(mOffset + 0);
        double _m10 = m.getDouble(mOffset + 8);
        double _m01 = m.getDouble(mOffset + 16);
        double _m11 = m.getDouble(mOffset + 24);
        dest.putDouble(destOffset + 0, _m00);
        dest.putDouble(destOffset + 8, _m10);
        dest.putDouble(destOffset + 16, _m01);
        dest.putDouble(destOffset + 24, _m11);
        dest.putDouble(destOffset + 32, 0.0);
        dest.putDouble(destOffset + 40, 0.0);
        return dest;
    }

    public static java.nio.ByteBuffer setMat3x3_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer m, int mOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _mBase = UnsafeOpsHolder.U.getLong(m, UnsafeCopy.BB_ADDRESS_OFFSET) + mOffset;
        Double2x3OpsKernelsAddress.setMat3x3_unsafe(_destBase, _mBase);
        return dest;
    }

    public static java.nio.ByteBuffer setMat3x3_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer m, int mOffset) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 2;
            int _lom = _l * 3;
            double _em0 = m.getDouble(mOffset + _lom * 8);
            double _em1 = m.getDouble(mOffset + (_lom + 1) * 8);
            dest.putDouble(destOffset + _lo * 8, _em0);
            dest.putDouble(destOffset + (_lo + 1) * 8, _em1);
        }
        return dest;
    }

    public static java.nio.ByteBuffer withTranslation_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double tX, double tY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double2x3OpsKernelsAddress.withTranslation_unsafe(_destBase, _srcBase, tX, tY);
        return dest;
    }

    public static java.nio.ByteBuffer withTranslation_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double tX, double tY) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 24);
        dest.putDouble(destOffset + 0, _self00);
        dest.putDouble(destOffset + 8, _self10);
        dest.putDouble(destOffset + 16, _self01);
        dest.putDouble(destOffset + 24, _self11);
        dest.putDouble(destOffset + 32, tX);
        dest.putDouble(destOffset + 40, tY);
        return dest;
    }

    public static java.nio.ByteBuffer withTranslation_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer t, int tOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _tBase = UnsafeOpsHolder.U.getLong(t, UnsafeCopy.BB_ADDRESS_OFFSET) + tOffset;
        Double2x3OpsKernelsAddress.withTranslation_unsafe(_destBase, _srcBase, _tBase);
        return dest;
    }

    public static java.nio.ByteBuffer withTranslation_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer t, int tOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 24);
        double _tx = t.getDouble(tOffset + 0);
        double _ty = t.getDouble(tOffset + 8);
        dest.putDouble(destOffset + 0, _self00);
        dest.putDouble(destOffset + 8, _self10);
        dest.putDouble(destOffset + 16, _self01);
        dest.putDouble(destOffset + 24, _self11);
        dest.putDouble(destOffset + 32, _tx);
        dest.putDouble(destOffset + 40, _ty);
        return dest;
    }

    public static java.nio.ByteBuffer to2x2_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double2x3OpsKernelsAddress.to2x2_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer to2x2_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 24);
        dest.putDouble(destOffset + 0, _self00);
        dest.putDouble(destOffset + 8, _self10);
        dest.putDouble(destOffset + 16, _self01);
        dest.putDouble(destOffset + 24, _self11);
        return dest;
    }

    public static java.nio.ByteBuffer to3x3_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double2x3OpsKernelsAddress.to3x3_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer to3x3_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 24);
        double _self02 = src.getDouble(srcOffset + 32);
        double _self12 = src.getDouble(srcOffset + 40);
        dest.putDouble(destOffset + 0, _self00);
        dest.putDouble(destOffset + 8, _self10);
        dest.putDouble(destOffset + 16, 0.0);
        dest.putDouble(destOffset + 24, _self01);
        dest.putDouble(destOffset + 32, _self11);
        dest.putDouble(destOffset + 40, 0.0);
        dest.putDouble(destOffset + 48, _self02);
        dest.putDouble(destOffset + 56, _self12);
        dest.putDouble(destOffset + 64, 1.0);
        return dest;
    }

    public static java.nio.ByteBuffer makeIdentity_unsafe(java.nio.ByteBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Double2x3OpsKernelsAddress.makeIdentity_unsafe(_destBase);
        return dest;
    }

    public static java.nio.ByteBuffer makeIdentity_api(java.nio.ByteBuffer dest, int destOffset) {
        dest.putDouble(destOffset + 0, 1.0);
        dest.putDouble(destOffset + 8, 0.0);
        dest.putDouble(destOffset + 16, 0.0);
        dest.putDouble(destOffset + 24, 1.0);
        dest.putDouble(destOffset + 32, 0.0);
        dest.putDouble(destOffset + 40, 0.0);
        return dest;
    }

    public static java.nio.ByteBuffer lerp_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + otherOffset;
        Double2x3OpsKernelsAddress.lerp_unsafe(_destBase, _srcBase, _otherBase, t);
        return dest;
    }

    public static java.nio.ByteBuffer lerp_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset, double t) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 2;
            double _eself0 = src.getDouble(srcOffset + _lo * 8);
            double _eself1 = src.getDouble(srcOffset + (_lo + 1) * 8);
            double _eother0 = other.getDouble(otherOffset + _lo * 8);
            double _eother1 = other.getDouble(otherOffset + (_lo + 1) * 8);
            dest.putDouble(destOffset + _lo * 8, Math.fma(t, _eother0 - _eself0, _eself0));
            dest.putDouble(destOffset + (_lo + 1) * 8, Math.fma(t, _eother1 - _eself1, _eself1));
        }
        return dest;
    }

    public static java.nio.ByteBuffer mul_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer right, int rightOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _rightBase = UnsafeOpsHolder.U.getLong(right, UnsafeCopy.BB_ADDRESS_OFFSET) + rightOffset;
        Double2x3OpsKernelsAddress.mul_unsafe(_destBase, _srcBase, _rightBase);
        return dest;
    }

    public static java.nio.ByteBuffer mul_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer right, int rightOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 24);
        double _self02 = src.getDouble(srcOffset + 32);
        double _self12 = src.getDouble(srcOffset + 40);
        double _right00 = right.getDouble(rightOffset + 0);
        double _right10 = right.getDouble(rightOffset + 8);
        double _right01 = right.getDouble(rightOffset + 16);
        double _right11 = right.getDouble(rightOffset + 24);
        double _right02 = right.getDouble(rightOffset + 32);
        double _right12 = right.getDouble(rightOffset + 40);
        dest.putDouble(destOffset + 0, Math.fma(_right00, _self00, _right10 * _self01));
        dest.putDouble(destOffset + 8, Math.fma(_right00, _self10, _right10 * _self11));
        dest.putDouble(destOffset + 16, Math.fma(_right01, _self00, _right11 * _self01));
        dest.putDouble(destOffset + 24, Math.fma(_right01, _self10, _right11 * _self11));
        dest.putDouble(destOffset + 32, Math.fma(_right02, _self00, Math.fma(_right12, _self01, _self02)));
        dest.putDouble(destOffset + 40, Math.fma(_right02, _self10, Math.fma(_right12, _self11, _self12)));
        return dest;
    }

    public static java.nio.ByteBuffer mulMat2x2_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer right, int rightOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _rightBase = UnsafeOpsHolder.U.getLong(right, UnsafeCopy.BB_ADDRESS_OFFSET) + rightOffset;
        Double2x3OpsKernelsAddress.mulMat2x2_unsafe(_destBase, _srcBase, _rightBase);
        return dest;
    }

    public static java.nio.ByteBuffer mulMat2x2_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer right, int rightOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 24);
        double _self02 = src.getDouble(srcOffset + 32);
        double _self12 = src.getDouble(srcOffset + 40);
        double _right00 = right.getDouble(rightOffset + 0);
        double _right10 = right.getDouble(rightOffset + 8);
        double _right01 = right.getDouble(rightOffset + 16);
        double _right11 = right.getDouble(rightOffset + 24);
        dest.putDouble(destOffset + 0, Math.fma(_right00, _self00, _right10 * _self01));
        dest.putDouble(destOffset + 8, Math.fma(_right00, _self10, _right10 * _self11));
        dest.putDouble(destOffset + 16, Math.fma(_right01, _self00, _right11 * _self01));
        dest.putDouble(destOffset + 24, Math.fma(_right01, _self10, _right11 * _self11));
        dest.putDouble(destOffset + 32, _self02);
        dest.putDouble(destOffset + 40, _self12);
        return dest;
    }

    public static java.nio.ByteBuffer mulMat3x3_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer right, int rightOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _rightBase = UnsafeOpsHolder.U.getLong(right, UnsafeCopy.BB_ADDRESS_OFFSET) + rightOffset;
        Double2x3OpsKernelsAddress.mulMat3x3_unsafe(_destBase, _srcBase, _rightBase);
        return dest;
    }

    public static java.nio.ByteBuffer mulMat3x3_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer right, int rightOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 24);
        double _self02 = src.getDouble(srcOffset + 32);
        double _self12 = src.getDouble(srcOffset + 40);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 3;
            double _eright0 = right.getDouble(rightOffset + _lo * 8);
            double _eright1 = right.getDouble(rightOffset + (_lo + 1) * 8);
            double _eright2 = right.getDouble(rightOffset + (_lo + 2) * 8);
            dest.putDouble(destOffset + _lo * 8, Math.fma(_eright2, _self02, Math.fma(_eright0, _self00, _eright1 * _self01)));
            dest.putDouble(destOffset + (_lo + 1) * 8, Math.fma(_eright2, _self12, Math.fma(_eright0, _self10, _eright1 * _self11)));
            dest.putDouble(destOffset + (_lo + 2) * 8, _eright2);
        }
        return dest;
    }

    public static java.nio.ByteBuffer preMul_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + otherOffset;
        Double2x3OpsKernelsAddress.preMul_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.ByteBuffer preMul_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 24);
        double _self02 = src.getDouble(srcOffset + 32);
        double _self12 = src.getDouble(srcOffset + 40);
        double _other00 = other.getDouble(otherOffset + 0);
        double _other10 = other.getDouble(otherOffset + 8);
        double _other01 = other.getDouble(otherOffset + 16);
        double _other11 = other.getDouble(otherOffset + 24);
        double _other02 = other.getDouble(otherOffset + 32);
        double _other12 = other.getDouble(otherOffset + 40);
        dest.putDouble(destOffset + 0, Math.fma(_other00, _self00, _other01 * _self10));
        dest.putDouble(destOffset + 8, Math.fma(_other10, _self00, _other11 * _self10));
        dest.putDouble(destOffset + 16, Math.fma(_other00, _self01, _other01 * _self11));
        dest.putDouble(destOffset + 24, Math.fma(_other10, _self01, _other11 * _self11));
        dest.putDouble(destOffset + 32, Math.fma(_other00, _self02, Math.fma(_other01, _self12, _other02)));
        dest.putDouble(destOffset + 40, Math.fma(_other10, _self02, Math.fma(_other11, _self12, _other12)));
        return dest;
    }

    public static java.nio.ByteBuffer preMulMat2x2_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + otherOffset;
        Double2x3OpsKernelsAddress.preMulMat2x2_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.ByteBuffer preMulMat2x2_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        double _other00 = other.getDouble(otherOffset + 0);
        double _other10 = other.getDouble(otherOffset + 8);
        double _other01 = other.getDouble(otherOffset + 16);
        double _other11 = other.getDouble(otherOffset + 24);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 2;
            double _eself0 = src.getDouble(srcOffset + _lo * 8);
            double _eself1 = src.getDouble(srcOffset + (_lo + 1) * 8);
            dest.putDouble(destOffset + _lo * 8, Math.fma(_other00, _eself0, _other01 * _eself1));
            dest.putDouble(destOffset + (_lo + 1) * 8, Math.fma(_other10, _eself0, _other11 * _eself1));
        }
        return dest;
    }

    public static java.nio.ByteBuffer preMulMat3x3_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + otherOffset;
        Double2x3OpsKernelsAddress.preMulMat3x3_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.ByteBuffer preMulMat3x3_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 24);
        double _self02 = src.getDouble(srcOffset + 32);
        double _self12 = src.getDouble(srcOffset + 40);
        double _other00 = other.getDouble(otherOffset + 0);
        double _other10 = other.getDouble(otherOffset + 8);
        double _other20 = other.getDouble(otherOffset + 16);
        double _other01 = other.getDouble(otherOffset + 24);
        double _other11 = other.getDouble(otherOffset + 32);
        double _other21 = other.getDouble(otherOffset + 40);
        double _other02 = other.getDouble(otherOffset + 48);
        double _other12 = other.getDouble(otherOffset + 56);
        double _other22 = other.getDouble(otherOffset + 64);
        dest.putDouble(destOffset + 0, Math.fma(_other00, _self00, _other01 * _self10));
        dest.putDouble(destOffset + 8, Math.fma(_other10, _self00, _other11 * _self10));
        dest.putDouble(destOffset + 16, Math.fma(_other20, _self00, _other21 * _self10));
        dest.putDouble(destOffset + 24, Math.fma(_other00, _self01, _other01 * _self11));
        dest.putDouble(destOffset + 32, Math.fma(_other10, _self01, _other11 * _self11));
        dest.putDouble(destOffset + 40, Math.fma(_other20, _self01, _other21 * _self11));
        dest.putDouble(destOffset + 48, Math.fma(_other00, _self02, Math.fma(_other01, _self12, _other02)));
        dest.putDouble(destOffset + 56, Math.fma(_other10, _self02, Math.fma(_other11, _self12, _other12)));
        dest.putDouble(destOffset + 64, Math.fma(_other20, _self02, Math.fma(_other21, _self12, _other22)));
        return dest;
    }

    public static java.nio.ByteBuffer makeRotation_unsafe(java.nio.ByteBuffer dest, int destOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Double2x3OpsKernelsAddress.makeRotation_unsafe(_destBase, angle);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotation_api(java.nio.ByteBuffer dest, int destOffset, double angle) {
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dest.putDouble(destOffset + 0, _t0);
        dest.putDouble(destOffset + 8, _t1);
        dest.putDouble(destOffset + 16, -_t1);
        dest.putDouble(destOffset + 24, _t0);
        dest.putDouble(destOffset + 32, 0.0);
        dest.putDouble(destOffset + 40, 0.0);
        return dest;
    }

    public static java.nio.ByteBuffer makeScaling_unsafe(java.nio.ByteBuffer dest, int destOffset, double vX, double vY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Double2x3OpsKernelsAddress.makeScaling_unsafe(_destBase, vX, vY);
        return dest;
    }

    public static java.nio.ByteBuffer makeScaling_api(java.nio.ByteBuffer dest, int destOffset, double vX, double vY) {
        dest.putDouble(destOffset + 0, vX);
        dest.putDouble(destOffset + 8, 0.0);
        dest.putDouble(destOffset + 16, 0.0);
        dest.putDouble(destOffset + 24, vY);
        dest.putDouble(destOffset + 32, 0.0);
        dest.putDouble(destOffset + 40, 0.0);
        return dest;
    }

    public static java.nio.ByteBuffer makeScaling_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + vOffset;
        Double2x3OpsKernelsAddress.makeScaling_unsafe(_destBase, _vBase);
        return dest;
    }

    public static java.nio.ByteBuffer makeScaling_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer v, int vOffset) {
        double _vx = v.getDouble(vOffset + 0);
        double _vy = v.getDouble(vOffset + 8);
        dest.putDouble(destOffset + 0, _vx);
        dest.putDouble(destOffset + 8, 0.0);
        dest.putDouble(destOffset + 16, 0.0);
        dest.putDouble(destOffset + 24, _vy);
        dest.putDouble(destOffset + 32, 0.0);
        dest.putDouble(destOffset + 40, 0.0);
        return dest;
    }

    public static java.nio.ByteBuffer makeScaling_unsafe(java.nio.ByteBuffer dest, int destOffset, double s) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Double2x3OpsKernelsAddress.makeScaling_unsafe(_destBase, s);
        return dest;
    }

    public static java.nio.ByteBuffer makeScaling_api(java.nio.ByteBuffer dest, int destOffset, double s) {
        dest.putDouble(destOffset + 0, s);
        dest.putDouble(destOffset + 8, 0.0);
        dest.putDouble(destOffset + 16, 0.0);
        dest.putDouble(destOffset + 24, s);
        dest.putDouble(destOffset + 32, 0.0);
        dest.putDouble(destOffset + 40, 0.0);
        return dest;
    }

    public static java.nio.ByteBuffer makeTranslation_unsafe(java.nio.ByteBuffer dest, int destOffset, double vX, double vY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Double2x3OpsKernelsAddress.makeTranslation_unsafe(_destBase, vX, vY);
        return dest;
    }

    public static java.nio.ByteBuffer makeTranslation_api(java.nio.ByteBuffer dest, int destOffset, double vX, double vY) {
        dest.putDouble(destOffset + 0, 1.0);
        dest.putDouble(destOffset + 8, 0.0);
        dest.putDouble(destOffset + 16, 0.0);
        dest.putDouble(destOffset + 24, 1.0);
        dest.putDouble(destOffset + 32, vX);
        dest.putDouble(destOffset + 40, vY);
        return dest;
    }

    public static java.nio.ByteBuffer makeTranslation_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + vOffset;
        Double2x3OpsKernelsAddress.makeTranslation_unsafe(_destBase, _vBase);
        return dest;
    }

    public static java.nio.ByteBuffer makeTranslation_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer v, int vOffset) {
        double _vx = v.getDouble(vOffset + 0);
        double _vy = v.getDouble(vOffset + 8);
        dest.putDouble(destOffset + 0, 1.0);
        dest.putDouble(destOffset + 8, 0.0);
        dest.putDouble(destOffset + 16, 0.0);
        dest.putDouble(destOffset + 24, 1.0);
        dest.putDouble(destOffset + 32, _vx);
        dest.putDouble(destOffset + 40, _vy);
        return dest;
    }

    public static java.nio.ByteBuffer makeView_unsafe(java.nio.ByteBuffer dest, int destOffset, double left, double right, double bottom, double top) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        Double2x3OpsKernelsAddress.makeView_unsafe(_destBase, left, right, bottom, top);
        return dest;
    }

    public static java.nio.ByteBuffer makeView_api(java.nio.ByteBuffer dest, int destOffset, double left, double right, double bottom, double top) {
        double _t0 = right - left;
        double _t0_inv = 1.0 / _t0;
        double _t1 = top - bottom;
        double _t1_inv = 1.0 / _t1;
        dest.putDouble(destOffset + 0, 2.0 * _t0_inv);
        dest.putDouble(destOffset + 8, 0.0);
        dest.putDouble(destOffset + 16, 0.0);
        dest.putDouble(destOffset + 24, 2.0 * _t1_inv);
        dest.putDouble(destOffset + 32, -((left + right) * _t0_inv));
        dest.putDouble(destOffset + 40, -((bottom + top) * _t1_inv));
        return dest;
    }

    public static java.nio.ByteBuffer preRotate_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double2x3OpsKernelsAddress.preRotate_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.ByteBuffer preRotate_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 24);
        double _self02 = src.getDouble(srcOffset + 32);
        double _self12 = src.getDouble(srcOffset + 40);
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dest.putDouble(destOffset + 0, Math.fma(_self00, _t0, -(_self10 * _t1)));
        dest.putDouble(destOffset + 8, Math.fma(_self00, _t1, _self10 * _t0));
        dest.putDouble(destOffset + 16, Math.fma(_self01, _t0, -(_self11 * _t1)));
        dest.putDouble(destOffset + 24, Math.fma(_self01, _t1, _self11 * _t0));
        dest.putDouble(destOffset + 32, Math.fma(_self02, _t0, -(_self12 * _t1)));
        dest.putDouble(destOffset + 40, Math.fma(_self02, _t1, _self12 * _t0));
        return dest;
    }

    public static java.nio.ByteBuffer preRotateAround_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle, double pivotX, double pivotY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double2x3OpsKernelsAddress.preRotateAround_unsafe(_destBase, _srcBase, angle, pivotX, pivotY);
        return dest;
    }

    public static java.nio.ByteBuffer preRotateAround_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle, double pivotX, double pivotY) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 24);
        double _self02 = src.getDouble(srcOffset + 32);
        double _self12 = src.getDouble(srcOffset + 40);
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t2 = -pivotX;
        dest.putDouble(destOffset + 0, Math.fma(_self00, _t0, -(_self10 * _t1)));
        dest.putDouble(destOffset + 8, Math.fma(_self00, _t1, _self10 * _t0));
        dest.putDouble(destOffset + 16, Math.fma(_self01, _t0, -(_self11 * _t1)));
        dest.putDouble(destOffset + 24, Math.fma(_self01, _t1, _self11 * _t0));
        dest.putDouble(destOffset + 32, Math.fma(pivotY, _t1, Math.fma(_t2, _t0, Math.fma(_self02, _t0, Math.fma(-_self12, _t1, pivotX)))));
        dest.putDouble(destOffset + 40, Math.fma(_t2, _t1, Math.fma(-pivotY, _t0, Math.fma(_self02, _t1, Math.fma(_self12, _t0, pivotY)))));
        return dest;
    }

    public static java.nio.ByteBuffer preRotateAround_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer pivot, int pivotOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _pivotBase = UnsafeOpsHolder.U.getLong(pivot, UnsafeCopy.BB_ADDRESS_OFFSET) + pivotOffset;
        Double2x3OpsKernelsAddress.preRotateAround_unsafe(_destBase, _srcBase, _pivotBase, angle);
        return dest;
    }

    public static java.nio.ByteBuffer preRotateAround_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer pivot, int pivotOffset, double angle) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 24);
        double _self02 = src.getDouble(srcOffset + 32);
        double _self12 = src.getDouble(srcOffset + 40);
        double _pivotx = pivot.getDouble(pivotOffset + 0);
        double _pivoty = pivot.getDouble(pivotOffset + 8);
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t2 = -_pivotx;
        dest.putDouble(destOffset + 0, Math.fma(_self00, _t0, -(_self10 * _t1)));
        dest.putDouble(destOffset + 8, Math.fma(_self00, _t1, _self10 * _t0));
        dest.putDouble(destOffset + 16, Math.fma(_self01, _t0, -(_self11 * _t1)));
        dest.putDouble(destOffset + 24, Math.fma(_self01, _t1, _self11 * _t0));
        dest.putDouble(destOffset + 32, Math.fma(_pivoty, _t1, Math.fma(_t2, _t0, Math.fma(_self02, _t0, Math.fma(-_self12, _t1, _pivotx)))));
        dest.putDouble(destOffset + 40, Math.fma(_t2, _t1, Math.fma(-_pivoty, _t0, Math.fma(_self02, _t1, Math.fma(_self12, _t0, _pivoty)))));
        return dest;
    }

    public static java.nio.ByteBuffer preScale_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double vX, double vY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double2x3OpsKernelsAddress.preScale_unsafe(_destBase, _srcBase, vX, vY);
        return dest;
    }

    public static java.nio.ByteBuffer preScale_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double vX, double vY) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 2;
            double _eself0 = src.getDouble(srcOffset + _lo * 8);
            double _eself1 = src.getDouble(srcOffset + (_lo + 1) * 8);
            dest.putDouble(destOffset + _lo * 8, _eself0 * vX);
            dest.putDouble(destOffset + (_lo + 1) * 8, _eself1 * vY);
        }
        return dest;
    }

    public static java.nio.ByteBuffer preScale_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + vOffset;
        Double2x3OpsKernelsAddress.preScale_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.ByteBuffer preScale_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer v, int vOffset) {
        double _vx = v.getDouble(vOffset + 0);
        double _vy = v.getDouble(vOffset + 8);
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 2;
            double _eself0 = src.getDouble(srcOffset + _lo * 8);
            double _eself1 = src.getDouble(srcOffset + (_lo + 1) * 8);
            dest.putDouble(destOffset + _lo * 8, _eself0 * _vx);
            dest.putDouble(destOffset + (_lo + 1) * 8, _eself1 * _vy);
        }
        return dest;
    }

    public static java.nio.ByteBuffer preScale_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double s) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double2x3OpsKernelsAddress.preScale_unsafe(_destBase, _srcBase, s);
        return dest;
    }

    public static java.nio.ByteBuffer preScale_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double s) {
        for (int _l = 0; _l < 3; _l++) {
            int _lo = _l * 2;
            double _eself0 = src.getDouble(srcOffset + _lo * 8);
            double _eself1 = src.getDouble(srcOffset + (_lo + 1) * 8);
            dest.putDouble(destOffset + _lo * 8, s * _eself0);
            dest.putDouble(destOffset + (_lo + 1) * 8, s * _eself1);
        }
        return dest;
    }

    public static java.nio.ByteBuffer preScaleAround_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double s, double pivotX, double pivotY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double2x3OpsKernelsAddress.preScaleAround_unsafe(_destBase, _srcBase, s, pivotX, pivotY);
        return dest;
    }

    public static java.nio.ByteBuffer preScaleAround_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double s, double pivotX, double pivotY) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 24);
        double _self02 = src.getDouble(srcOffset + 32);
        double _self12 = src.getDouble(srcOffset + 40);
        dest.putDouble(destOffset + 0, s * _self00);
        dest.putDouble(destOffset + 8, s * _self10);
        dest.putDouble(destOffset + 16, s * _self01);
        dest.putDouble(destOffset + 24, s * _self11);
        dest.putDouble(destOffset + 32, Math.fma(-s, pivotX, Math.fma(s, _self02, pivotX)));
        dest.putDouble(destOffset + 40, Math.fma(-s, pivotY, Math.fma(s, _self12, pivotY)));
        return dest;
    }

    public static java.nio.ByteBuffer preScaleAround_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer pivot, int pivotOffset, double s) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _pivotBase = UnsafeOpsHolder.U.getLong(pivot, UnsafeCopy.BB_ADDRESS_OFFSET) + pivotOffset;
        Double2x3OpsKernelsAddress.preScaleAround_unsafe(_destBase, _srcBase, _pivotBase, s);
        return dest;
    }

    public static java.nio.ByteBuffer preScaleAround_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer pivot, int pivotOffset, double s) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 24);
        double _self02 = src.getDouble(srcOffset + 32);
        double _self12 = src.getDouble(srcOffset + 40);
        double _pivotx = pivot.getDouble(pivotOffset + 0);
        double _pivoty = pivot.getDouble(pivotOffset + 8);
        dest.putDouble(destOffset + 0, s * _self00);
        dest.putDouble(destOffset + 8, s * _self10);
        dest.putDouble(destOffset + 16, s * _self01);
        dest.putDouble(destOffset + 24, s * _self11);
        dest.putDouble(destOffset + 32, Math.fma(-s, _pivotx, Math.fma(s, _self02, _pivotx)));
        dest.putDouble(destOffset + 40, Math.fma(-s, _pivoty, Math.fma(s, _self12, _pivoty)));
        return dest;
    }

    public static java.nio.ByteBuffer preScaleAround_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double sX, double sY, double pivotX, double pivotY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double2x3OpsKernelsAddress.preScaleAround_unsafe(_destBase, _srcBase, sX, sY, pivotX, pivotY);
        return dest;
    }

    public static java.nio.ByteBuffer preScaleAround_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double sX, double sY, double pivotX, double pivotY) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 24);
        double _self02 = src.getDouble(srcOffset + 32);
        double _self12 = src.getDouble(srcOffset + 40);
        dest.putDouble(destOffset + 0, sX * _self00);
        dest.putDouble(destOffset + 8, sY * _self10);
        dest.putDouble(destOffset + 16, sX * _self01);
        dest.putDouble(destOffset + 24, sY * _self11);
        dest.putDouble(destOffset + 32, Math.fma(-pivotX, sX, Math.fma(sX, _self02, pivotX)));
        dest.putDouble(destOffset + 40, Math.fma(-pivotY, sY, Math.fma(sY, _self12, pivotY)));
        return dest;
    }

    public static java.nio.ByteBuffer preScaleAround_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer s, int sOffset, java.nio.ByteBuffer pivot, int pivotOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _sBase = UnsafeOpsHolder.U.getLong(s, UnsafeCopy.BB_ADDRESS_OFFSET) + sOffset;
        long _pivotBase = UnsafeOpsHolder.U.getLong(pivot, UnsafeCopy.BB_ADDRESS_OFFSET) + pivotOffset;
        Double2x3OpsKernelsAddress.preScaleAround_unsafe(_destBase, _srcBase, _sBase, _pivotBase);
        return dest;
    }

    public static java.nio.ByteBuffer preScaleAround_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer s, int sOffset, java.nio.ByteBuffer pivot, int pivotOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 24);
        double _self02 = src.getDouble(srcOffset + 32);
        double _self12 = src.getDouble(srcOffset + 40);
        double _sx = s.getDouble(sOffset + 0);
        double _sy = s.getDouble(sOffset + 8);
        double _pivotx = pivot.getDouble(pivotOffset + 0);
        double _pivoty = pivot.getDouble(pivotOffset + 8);
        dest.putDouble(destOffset + 0, _sx * _self00);
        dest.putDouble(destOffset + 8, _sy * _self10);
        dest.putDouble(destOffset + 16, _sx * _self01);
        dest.putDouble(destOffset + 24, _sy * _self11);
        dest.putDouble(destOffset + 32, Math.fma(-_pivotx, _sx, Math.fma(_sx, _self02, _pivotx)));
        dest.putDouble(destOffset + 40, Math.fma(-_pivoty, _sy, Math.fma(_sy, _self12, _pivoty)));
        return dest;
    }

    public static java.nio.ByteBuffer preTranslate_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double vX, double vY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double2x3OpsKernelsAddress.preTranslate_unsafe(_destBase, _srcBase, vX, vY);
        return dest;
    }

    public static java.nio.ByteBuffer preTranslate_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double vX, double vY) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 24);
        double _self02 = src.getDouble(srcOffset + 32);
        double _self12 = src.getDouble(srcOffset + 40);
        dest.putDouble(destOffset + 0, _self00);
        dest.putDouble(destOffset + 8, _self10);
        dest.putDouble(destOffset + 16, _self01);
        dest.putDouble(destOffset + 24, _self11);
        dest.putDouble(destOffset + 32, _self02 + vX);
        dest.putDouble(destOffset + 40, _self12 + vY);
        return dest;
    }

    public static java.nio.ByteBuffer preTranslate_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + vOffset;
        Double2x3OpsKernelsAddress.preTranslate_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.ByteBuffer preTranslate_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer v, int vOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 24);
        double _self02 = src.getDouble(srcOffset + 32);
        double _self12 = src.getDouble(srcOffset + 40);
        double _vx = v.getDouble(vOffset + 0);
        double _vy = v.getDouble(vOffset + 8);
        dest.putDouble(destOffset + 0, _self00);
        dest.putDouble(destOffset + 8, _self10);
        dest.putDouble(destOffset + 16, _self01);
        dest.putDouble(destOffset + 24, _self11);
        dest.putDouble(destOffset + 32, _self02 + _vx);
        dest.putDouble(destOffset + 40, _self12 + _vy);
        return dest;
    }

    public static java.nio.ByteBuffer rotate_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double2x3OpsKernelsAddress.rotate_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.ByteBuffer rotate_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 24);
        double _self02 = src.getDouble(srcOffset + 32);
        double _self12 = src.getDouble(srcOffset + 40);
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dest.putDouble(destOffset + 0, Math.fma(_self00, _t0, _self01 * _t1));
        dest.putDouble(destOffset + 8, Math.fma(_self10, _t0, _self11 * _t1));
        dest.putDouble(destOffset + 16, Math.fma(_self01, _t0, -(_self00 * _t1)));
        dest.putDouble(destOffset + 24, Math.fma(_self11, _t0, -(_self10 * _t1)));
        dest.putDouble(destOffset + 32, _self02);
        dest.putDouble(destOffset + 40, _self12);
        return dest;
    }

    public static java.nio.ByteBuffer rotateAround_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle, double pivotX, double pivotY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double2x3OpsKernelsAddress.rotateAround_unsafe(_destBase, _srcBase, angle, pivotX, pivotY);
        return dest;
    }

    public static java.nio.ByteBuffer rotateAround_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle, double pivotX, double pivotY) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 24);
        double _self02 = src.getDouble(srcOffset + 32);
        double _self12 = src.getDouble(srcOffset + 40);
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t2 = -pivotX;
        double _t6 = Math.fma(pivotY, _t1, Math.fma(_t2, _t0, pivotX));
        double _t7 = Math.fma(_t2, _t1, Math.fma(-pivotY, _t0, pivotY));
        dest.putDouble(destOffset + 0, Math.fma(_self00, _t0, _self01 * _t1));
        dest.putDouble(destOffset + 8, Math.fma(_self10, _t0, _self11 * _t1));
        dest.putDouble(destOffset + 16, Math.fma(_self01, _t0, -(_self00 * _t1)));
        dest.putDouble(destOffset + 24, Math.fma(_self11, _t0, -(_self10 * _t1)));
        dest.putDouble(destOffset + 32, Math.fma(_self00, _t6, Math.fma(_self01, _t7, _self02)));
        dest.putDouble(destOffset + 40, Math.fma(_self10, _t6, Math.fma(_self11, _t7, _self12)));
        return dest;
    }

    public static java.nio.ByteBuffer rotateAround_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer pivot, int pivotOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _pivotBase = UnsafeOpsHolder.U.getLong(pivot, UnsafeCopy.BB_ADDRESS_OFFSET) + pivotOffset;
        Double2x3OpsKernelsAddress.rotateAround_unsafe(_destBase, _srcBase, _pivotBase, angle);
        return dest;
    }

    public static java.nio.ByteBuffer rotateAround_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer pivot, int pivotOffset, double angle) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 24);
        double _self02 = src.getDouble(srcOffset + 32);
        double _self12 = src.getDouble(srcOffset + 40);
        double _pivotx = pivot.getDouble(pivotOffset + 0);
        double _pivoty = pivot.getDouble(pivotOffset + 8);
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t2 = -_pivotx;
        double _t6 = Math.fma(_pivoty, _t1, Math.fma(_t2, _t0, _pivotx));
        double _t7 = Math.fma(_t2, _t1, Math.fma(-_pivoty, _t0, _pivoty));
        dest.putDouble(destOffset + 0, Math.fma(_self00, _t0, _self01 * _t1));
        dest.putDouble(destOffset + 8, Math.fma(_self10, _t0, _self11 * _t1));
        dest.putDouble(destOffset + 16, Math.fma(_self01, _t0, -(_self00 * _t1)));
        dest.putDouble(destOffset + 24, Math.fma(_self11, _t0, -(_self10 * _t1)));
        dest.putDouble(destOffset + 32, Math.fma(_self00, _t6, Math.fma(_self01, _t7, _self02)));
        dest.putDouble(destOffset + 40, Math.fma(_self10, _t6, Math.fma(_self11, _t7, _self12)));
        return dest;
    }

    public static java.nio.ByteBuffer scale_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double vX, double vY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double2x3OpsKernelsAddress.scale_unsafe(_destBase, _srcBase, vX, vY);
        return dest;
    }

    public static java.nio.ByteBuffer scale_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double vX, double vY) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 24);
        double _self02 = src.getDouble(srcOffset + 32);
        double _self12 = src.getDouble(srcOffset + 40);
        dest.putDouble(destOffset + 0, _self00 * vX);
        dest.putDouble(destOffset + 8, _self10 * vX);
        dest.putDouble(destOffset + 16, _self01 * vY);
        dest.putDouble(destOffset + 24, _self11 * vY);
        dest.putDouble(destOffset + 32, _self02);
        dest.putDouble(destOffset + 40, _self12);
        return dest;
    }

    public static java.nio.ByteBuffer scale_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + vOffset;
        Double2x3OpsKernelsAddress.scale_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.ByteBuffer scale_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer v, int vOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 24);
        double _self02 = src.getDouble(srcOffset + 32);
        double _self12 = src.getDouble(srcOffset + 40);
        double _vx = v.getDouble(vOffset + 0);
        double _vy = v.getDouble(vOffset + 8);
        dest.putDouble(destOffset + 0, _self00 * _vx);
        dest.putDouble(destOffset + 8, _self10 * _vx);
        dest.putDouble(destOffset + 16, _self01 * _vy);
        dest.putDouble(destOffset + 24, _self11 * _vy);
        dest.putDouble(destOffset + 32, _self02);
        dest.putDouble(destOffset + 40, _self12);
        return dest;
    }

    public static java.nio.ByteBuffer scale_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double s) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double2x3OpsKernelsAddress.scale_unsafe(_destBase, _srcBase, s);
        return dest;
    }

    public static java.nio.ByteBuffer scale_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double s) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 24);
        double _self02 = src.getDouble(srcOffset + 32);
        double _self12 = src.getDouble(srcOffset + 40);
        dest.putDouble(destOffset + 0, s * _self00);
        dest.putDouble(destOffset + 8, s * _self10);
        dest.putDouble(destOffset + 16, s * _self01);
        dest.putDouble(destOffset + 24, s * _self11);
        dest.putDouble(destOffset + 32, _self02);
        dest.putDouble(destOffset + 40, _self12);
        return dest;
    }

    public static java.nio.ByteBuffer scaleAround_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double s, double pivotX, double pivotY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double2x3OpsKernelsAddress.scaleAround_unsafe(_destBase, _srcBase, s, pivotX, pivotY);
        return dest;
    }

    public static java.nio.ByteBuffer scaleAround_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double s, double pivotX, double pivotY) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 24);
        double _self02 = src.getDouble(srcOffset + 32);
        double _self12 = src.getDouble(srcOffset + 40);
        double _t0 = Math.fma(-s, pivotX, pivotX);
        double _t1 = Math.fma(-s, pivotY, pivotY);
        dest.putDouble(destOffset + 0, s * _self00);
        dest.putDouble(destOffset + 8, s * _self10);
        dest.putDouble(destOffset + 16, s * _self01);
        dest.putDouble(destOffset + 24, s * _self11);
        dest.putDouble(destOffset + 32, Math.fma(_self00, _t0, Math.fma(_self01, _t1, _self02)));
        dest.putDouble(destOffset + 40, Math.fma(_self10, _t0, Math.fma(_self11, _t1, _self12)));
        return dest;
    }

    public static java.nio.ByteBuffer scaleAround_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer pivot, int pivotOffset, double s) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _pivotBase = UnsafeOpsHolder.U.getLong(pivot, UnsafeCopy.BB_ADDRESS_OFFSET) + pivotOffset;
        Double2x3OpsKernelsAddress.scaleAround_unsafe(_destBase, _srcBase, _pivotBase, s);
        return dest;
    }

    public static java.nio.ByteBuffer scaleAround_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer pivot, int pivotOffset, double s) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 24);
        double _self02 = src.getDouble(srcOffset + 32);
        double _self12 = src.getDouble(srcOffset + 40);
        double _pivotx = pivot.getDouble(pivotOffset + 0);
        double _pivoty = pivot.getDouble(pivotOffset + 8);
        double _t0 = Math.fma(-s, _pivotx, _pivotx);
        double _t1 = Math.fma(-s, _pivoty, _pivoty);
        dest.putDouble(destOffset + 0, s * _self00);
        dest.putDouble(destOffset + 8, s * _self10);
        dest.putDouble(destOffset + 16, s * _self01);
        dest.putDouble(destOffset + 24, s * _self11);
        dest.putDouble(destOffset + 32, Math.fma(_self00, _t0, Math.fma(_self01, _t1, _self02)));
        dest.putDouble(destOffset + 40, Math.fma(_self10, _t0, Math.fma(_self11, _t1, _self12)));
        return dest;
    }

    public static java.nio.ByteBuffer scaleAround_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double sX, double sY, double pivotX, double pivotY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double2x3OpsKernelsAddress.scaleAround_unsafe(_destBase, _srcBase, sX, sY, pivotX, pivotY);
        return dest;
    }

    public static java.nio.ByteBuffer scaleAround_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double sX, double sY, double pivotX, double pivotY) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 24);
        double _self02 = src.getDouble(srcOffset + 32);
        double _self12 = src.getDouble(srcOffset + 40);
        double _t2 = Math.fma(-pivotX, sX, pivotX);
        double _t3 = Math.fma(-pivotY, sY, pivotY);
        dest.putDouble(destOffset + 0, sX * _self00);
        dest.putDouble(destOffset + 8, sX * _self10);
        dest.putDouble(destOffset + 16, sY * _self01);
        dest.putDouble(destOffset + 24, sY * _self11);
        dest.putDouble(destOffset + 32, Math.fma(_self00, _t2, Math.fma(_self01, _t3, _self02)));
        dest.putDouble(destOffset + 40, Math.fma(_self10, _t2, Math.fma(_self11, _t3, _self12)));
        return dest;
    }

    public static java.nio.ByteBuffer scaleAround_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer s, int sOffset, java.nio.ByteBuffer pivot, int pivotOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _sBase = UnsafeOpsHolder.U.getLong(s, UnsafeCopy.BB_ADDRESS_OFFSET) + sOffset;
        long _pivotBase = UnsafeOpsHolder.U.getLong(pivot, UnsafeCopy.BB_ADDRESS_OFFSET) + pivotOffset;
        Double2x3OpsKernelsAddress.scaleAround_unsafe(_destBase, _srcBase, _sBase, _pivotBase);
        return dest;
    }

    public static java.nio.ByteBuffer scaleAround_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer s, int sOffset, java.nio.ByteBuffer pivot, int pivotOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 24);
        double _self02 = src.getDouble(srcOffset + 32);
        double _self12 = src.getDouble(srcOffset + 40);
        double _sx = s.getDouble(sOffset + 0);
        double _sy = s.getDouble(sOffset + 8);
        double _pivotx = pivot.getDouble(pivotOffset + 0);
        double _pivoty = pivot.getDouble(pivotOffset + 8);
        double _t2 = Math.fma(-_pivotx, _sx, _pivotx);
        double _t3 = Math.fma(-_pivoty, _sy, _pivoty);
        dest.putDouble(destOffset + 0, _sx * _self00);
        dest.putDouble(destOffset + 8, _sx * _self10);
        dest.putDouble(destOffset + 16, _sy * _self01);
        dest.putDouble(destOffset + 24, _sy * _self11);
        dest.putDouble(destOffset + 32, Math.fma(_self00, _t2, Math.fma(_self01, _t3, _self02)));
        dest.putDouble(destOffset + 40, Math.fma(_self10, _t2, Math.fma(_self11, _t3, _self12)));
        return dest;
    }

    public static java.nio.ByteBuffer translate_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double vX, double vY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double2x3OpsKernelsAddress.translate_unsafe(_destBase, _srcBase, vX, vY);
        return dest;
    }

    public static java.nio.ByteBuffer translate_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double vX, double vY) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 24);
        double _self02 = src.getDouble(srcOffset + 32);
        double _self12 = src.getDouble(srcOffset + 40);
        dest.putDouble(destOffset + 0, _self00);
        dest.putDouble(destOffset + 8, _self10);
        dest.putDouble(destOffset + 16, _self01);
        dest.putDouble(destOffset + 24, _self11);
        dest.putDouble(destOffset + 32, Math.fma(_self00, vX, Math.fma(_self01, vY, _self02)));
        dest.putDouble(destOffset + 40, Math.fma(_self10, vX, Math.fma(_self11, vY, _self12)));
        return dest;
    }

    public static java.nio.ByteBuffer translate_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + vOffset;
        Double2x3OpsKernelsAddress.translate_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.ByteBuffer translate_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer v, int vOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 24);
        double _self02 = src.getDouble(srcOffset + 32);
        double _self12 = src.getDouble(srcOffset + 40);
        double _vx = v.getDouble(vOffset + 0);
        double _vy = v.getDouble(vOffset + 8);
        dest.putDouble(destOffset + 0, _self00);
        dest.putDouble(destOffset + 8, _self10);
        dest.putDouble(destOffset + 16, _self01);
        dest.putDouble(destOffset + 24, _self11);
        dest.putDouble(destOffset + 32, Math.fma(_self00, _vx, Math.fma(_self01, _vy, _self02)));
        dest.putDouble(destOffset + 40, Math.fma(_self10, _vx, Math.fma(_self11, _vy, _self12)));
        return dest;
    }

    public static java.nio.ByteBuffer view_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double left, double right, double bottom, double top) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double2x3OpsKernelsAddress.view_unsafe(_destBase, _srcBase, left, right, bottom, top);
        return dest;
    }

    public static java.nio.ByteBuffer view_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double left, double right, double bottom, double top) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 24);
        double _self02 = src.getDouble(srcOffset + 32);
        double _self12 = src.getDouble(srcOffset + 40);
        double _t0 = right - left;
        double _t0_inv = 1.0 / _t0;
        double _t1 = top - bottom;
        double _t1_inv = 1.0 / _t1;
        double _t2 = left + right;
        double _t3 = bottom + top;
        dest.putDouble(destOffset + 0, 2.0 * _self00 * _t0_inv);
        dest.putDouble(destOffset + 8, 2.0 * _self10 * _t0_inv);
        dest.putDouble(destOffset + 16, 2.0 * _self01 * _t1_inv);
        dest.putDouble(destOffset + 24, 2.0 * _self11 * _t1_inv);
        dest.putDouble(destOffset + 32, _self02 + (-(_self00 * _t2 * _t0_inv) - _self01 * _t3 * _t1_inv));
        dest.putDouble(destOffset + 40, _self12 + (-(_self10 * _t2 * _t0_inv) - _self11 * _t3 * _t1_inv));
        return dest;
    }

    public static java.nio.ByteBuffer mulVec3_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double vX, double vY, double vZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double2x3OpsKernelsAddress.mulVec3_unsafe(_destBase, _srcBase, vX, vY, vZ);
        return dest;
    }

    public static java.nio.ByteBuffer mulVec3_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double vX, double vY, double vZ) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 24);
        double _self02 = src.getDouble(srcOffset + 32);
        double _self12 = src.getDouble(srcOffset + 40);
        dest.putDouble(destOffset + 0, Math.fma(_self02, vZ, Math.fma(_self00, vX, _self01 * vY)));
        dest.putDouble(destOffset + 8, Math.fma(_self12, vZ, Math.fma(_self10, vX, _self11 * vY)));
        return dest;
    }

    public static java.nio.ByteBuffer mulVec3_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + vOffset;
        Double2x3OpsKernelsAddress.mulVec3_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.ByteBuffer mulVec3_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer v, int vOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 24);
        double _self02 = src.getDouble(srcOffset + 32);
        double _self12 = src.getDouble(srcOffset + 40);
        double _vx = v.getDouble(vOffset + 0);
        double _vy = v.getDouble(vOffset + 8);
        double _vz = v.getDouble(vOffset + 16);
        dest.putDouble(destOffset + 0, Math.fma(_self02, _vz, Math.fma(_self00, _vx, _self01 * _vy)));
        dest.putDouble(destOffset + 8, Math.fma(_self12, _vz, Math.fma(_self10, _vx, _self11 * _vy)));
        return dest;
    }

    public static java.nio.ByteBuffer transformDirection_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double vX, double vY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double2x3OpsKernelsAddress.transformDirection_unsafe(_destBase, _srcBase, vX, vY);
        return dest;
    }

    public static java.nio.ByteBuffer transformDirection_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double vX, double vY) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 24);
        dest.putDouble(destOffset + 0, Math.fma(_self00, vX, _self01 * vY));
        dest.putDouble(destOffset + 8, Math.fma(_self10, vX, _self11 * vY));
        return dest;
    }

    public static java.nio.ByteBuffer transformDirection_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + vOffset;
        Double2x3OpsKernelsAddress.transformDirection_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.ByteBuffer transformDirection_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer v, int vOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 24);
        double _vx = v.getDouble(vOffset + 0);
        double _vy = v.getDouble(vOffset + 8);
        dest.putDouble(destOffset + 0, Math.fma(_self00, _vx, _self01 * _vy));
        dest.putDouble(destOffset + 8, Math.fma(_self10, _vx, _self11 * _vy));
        return dest;
    }

    public static java.nio.ByteBuffer transformPosition_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double vX, double vY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        Double2x3OpsKernelsAddress.transformPosition_unsafe(_destBase, _srcBase, vX, vY);
        return dest;
    }

    public static java.nio.ByteBuffer transformPosition_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double vX, double vY) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 24);
        double _self02 = src.getDouble(srcOffset + 32);
        double _self12 = src.getDouble(srcOffset + 40);
        dest.putDouble(destOffset + 0, Math.fma(_self00, vX, Math.fma(_self01, vY, _self02)));
        dest.putDouble(destOffset + 8, Math.fma(_self10, vX, Math.fma(_self11, vY, _self12)));
        return dest;
    }

    public static java.nio.ByteBuffer transformPosition_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + vOffset;
        Double2x3OpsKernelsAddress.transformPosition_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.ByteBuffer transformPosition_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer v, int vOffset) {
        double _self00 = src.getDouble(srcOffset + 0);
        double _self10 = src.getDouble(srcOffset + 8);
        double _self01 = src.getDouble(srcOffset + 16);
        double _self11 = src.getDouble(srcOffset + 24);
        double _self02 = src.getDouble(srcOffset + 32);
        double _self12 = src.getDouble(srcOffset + 40);
        double _vx = v.getDouble(vOffset + 0);
        double _vy = v.getDouble(vOffset + 8);
        dest.putDouble(destOffset + 0, Math.fma(_self00, _vx, Math.fma(_self01, _vy, _self02)));
        dest.putDouble(destOffset + 8, Math.fma(_self10, _vx, Math.fma(_self11, _vy, _self12)));
        return dest;
    }

}
