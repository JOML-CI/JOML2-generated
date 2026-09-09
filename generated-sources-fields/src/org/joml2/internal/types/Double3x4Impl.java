package org.joml2.internal.types;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.storeload.*;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;

/**
 * Generated implementation of {@link Double3x4} backed by individual scalar fields.
 * <p>
 * Not part of the public API - obtain instances through the {@link Joml} factory methods.
 */
public class Double3x4Impl implements Double3x4 {

    public double m00;
    public double m01;
    public double m02;
    public double m03;
    public double m10;
    public double m11;
    public double m12;
    public double m13;
    public double m20;
    public double m21;
    public double m22;
    public double m23;
    public int properties;
    static final Double3x4SegOps SEG_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new Double3x4SegOpsUnsafe()
                    : new Double3x4SegOpsMS();
    static final Double3x4BbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new Double3x4BbOpsUnsafe()
                    : new Double3x4BbOpsApi();
    static final Double3x4RawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new Double3x4RawOpsUnsafe()
                    : new Double3x4RawOpsApi();

    public Double3x4Impl() {
        m00 = 1;
        m11 = 1;
        m22 = 1;
        properties = Joml.BIT_IDENTITY;
    }

    /**
     * Numerically determine the structural properties of this matrix (identity, translation,
     * affinity) and return them as property bits. This is a pure query.
     *
     * @return the determined property bits
     */
    public int determineProperties() {
        if (this.m00 != 1 || this.m01 != 0 || this.m02 != 0 || this.m10 != 0 || this.m11 != 1 || this.m12 != 0 || this.m20 != 0 || this.m21 != 0 || this.m22 != 1) return 1;
        if (this.m03 != 0 || this.m13 != 0 || this.m23 != 0) return 7;
        return 15;
    }

    /** {@return whether this matrix is known to be the identity} O(1) read of the cached property bits; conservative. */
    @Override public boolean isIdentity() { return (this.properties & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY; }
    /** {@return whether this matrix is known to be a pure translation} O(1) read of the cached property bits; conservative. */
    @Override public boolean isTranslation() { return (this.properties & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION; }
    /** {@return whether this matrix is known to be orthogonal, i.e. its upper-left block is orthonormal with positive determinant (a proper rotation; a reflection is affine, not orthogonal)} O(1) read of the cached property bits; conservative. */
    @Override public boolean isOrthogonal() { return (this.properties & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL; }
    /** {@return whether this matrix is affine} Always {@code true} for this shape. */
    @Override public boolean isAffine() { return true; }


    /**
     * Private body of {@code getColumn}, specialized by runtime matrix properties; reached only
     * through the public {@code getColumn} dispatcher.
     */
    private Double3 getColumn_identity(int col, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _idxSw0;
        double _idxSw1;
        double _idxSw2;
        switch (col) {
            case 0: _idxSw0 = 1.0; _idxSw1 = 0.0; _idxSw2 = 0.0; break;
            case 1: _idxSw0 = 0.0; _idxSw1 = 1.0; _idxSw2 = 0.0; break;
            case 2: _idxSw0 = 0.0; _idxSw1 = 0.0; _idxSw2 = 1.0; break;
            case 3: _idxSw0 = 0.0; _idxSw1 = 0.0; _idxSw2 = 0.0; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + col);
        }
        d.x = _idxSw0;
        d.y = _idxSw1;
        d.z = _idxSw2;
        return d;
    }


    /**
     * Private body of {@code getColumn}, specialized by runtime matrix properties; reached only
     * through the public {@code getColumn} dispatcher.
     */
    private Double3 getColumn_translation(int col, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _idxSw3;
        double _idxSw4;
        double _idxSw5;
        switch (col) {
            case 0: _idxSw3 = 1.0; _idxSw4 = 0.0; _idxSw5 = 0.0; break;
            case 1: _idxSw3 = 0.0; _idxSw4 = 1.0; _idxSw5 = 0.0; break;
            case 2: _idxSw3 = 0.0; _idxSw4 = 0.0; _idxSw5 = 1.0; break;
            case 3: _idxSw3 = this.m03; _idxSw4 = this.m13; _idxSw5 = this.m23; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + col);
        }
        d.x = _idxSw3;
        d.y = _idxSw4;
        d.z = _idxSw5;
        return d;
    }


    /**
     * Private body of {@code getColumn}, specialized by runtime matrix properties; reached only
     * through the public {@code getColumn} dispatcher.
     */
    private Double3 getColumn_general(int col, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _idxSw6;
        double _idxSw7;
        double _idxSw8;
        switch (col) {
            case 0: _idxSw6 = this.m00; _idxSw7 = this.m10; _idxSw8 = this.m20; break;
            case 1: _idxSw6 = this.m01; _idxSw7 = this.m11; _idxSw8 = this.m21; break;
            case 2: _idxSw6 = this.m02; _idxSw7 = this.m12; _idxSw8 = this.m22; break;
            case 3: _idxSw6 = this.m03; _idxSw7 = this.m13; _idxSw8 = this.m23; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + col);
        }
        d.x = _idxSw6;
        d.y = _idxSw7;
        d.z = _idxSw8;
        return d;
    }


    /**
     * Get the column at the given index of this matrix and store the result in {@code dest}.
     *
     * @param col the column index
     * @param dest will hold the result
     * @return dest
     * @throws IndexOutOfBoundsException if {@code col} is not in {@code [0, COLUMNS)}
     */
    public Double3 getColumn(int col, @Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return getColumn_identity(col, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getColumn_translation(col, dest);
        return getColumn_general(col, dest);
    }


    /**
     * Private body of {@code getEulerAnglesXYZ}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesXYZ} dispatcher.
     */
    private Double3 getEulerAnglesXYZ_identity(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = 0.0;
        d.y = 0.0;
        d.z = 0.0;
        return d;
    }


    /**
     * Private body of {@code getEulerAnglesXYZ}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesXYZ} dispatcher.
     */
    private Double3 getEulerAnglesXYZ_general(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t1 = Math.fma(this.m12, this.m12, this.m22 * this.m22);
        double _t3 = Math.fma(this.m02, this.m02, _t1) * 1.0E-15;
        if (_t1 < _t3) {
            double _buf0 = Math.atan2(this.m21, this.m11);
            d.z = 0.0;
            d.x = _buf0;
        } else {
            double _buf0 = Math.atan2(-this.m12, this.m22);
            d.z = Math.atan2(-this.m01, this.m00);
            d.x = _buf0;
        }
        d.y = Math.asin(Math.min(1.0, Math.max(-1.0, this.m02)));
        return d;
    }


    /**
     * Get the Euler angles in radians of this matrix, to be applied about the X, Y and Z axes, in
     * that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The upper-left 3x3 of this matrix must be a pure rotation (orthonormal, free of scaling and
     * shear): the angles are read from its raw elements, so a scaled matrix yields wrong angles
     * rather than the angles of its rotation part.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesXYZ(@Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getEulerAnglesXYZ_identity(dest);
        return getEulerAnglesXYZ_general(dest);
    }


    /**
     * Private body of {@code getEulerAnglesXZY}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesXZY} dispatcher.
     */
    private Double3 getEulerAnglesXZY_identity(@Mutated Double3 dest) {
        return getEulerAnglesXYZ_identity(dest);
    }


    /**
     * Private body of {@code getEulerAnglesXZY}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesXZY} dispatcher.
     */
    private Double3 getEulerAnglesXZY_general(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t1 = Math.fma(this.m11, this.m11, this.m21 * this.m21);
        double _t3 = Math.fma(this.m01, this.m01, _t1) * 1.0E-15;
        if (_t1 < _t3) {
            double _buf0 = Math.atan2(-this.m12, this.m22);
            double _buf1 = 0.0;
            d.x = _buf0;
            d.y = _buf1;
        } else {
            double _buf0 = Math.atan2(this.m21, this.m11);
            double _buf1 = Math.atan2(this.m02, this.m00);
            d.x = _buf0;
            d.y = _buf1;
        }
        d.z = Math.asin(Math.min(1.0, Math.max(-1.0, -this.m01)));
        return d;
    }


    /**
     * Get the Euler angles in radians of this matrix, to be applied about the X, Z and Y axes, in
     * that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The upper-left 3x3 of this matrix must be a pure rotation (orthonormal, free of scaling and
     * shear): the angles are read from its raw elements, so a scaled matrix yields wrong angles
     * rather than the angles of its rotation part.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesXZY(@Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getEulerAnglesXZY_identity(dest);
        return getEulerAnglesXZY_general(dest);
    }


    /**
     * Private body of {@code getEulerAnglesYXZ}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesYXZ} dispatcher.
     */
    private Double3 getEulerAnglesYXZ_identity(@Mutated Double3 dest) {
        return getEulerAnglesXYZ_identity(dest);
    }


    /**
     * Private body of {@code getEulerAnglesYXZ}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesYXZ} dispatcher.
     */
    private Double3 getEulerAnglesYXZ_general(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t1 = Math.fma(this.m02, this.m02, this.m22 * this.m22);
        double _t3 = Math.fma(this.m12, this.m12, _t1) * 1.0E-15;
        if (_t1 < _t3) {
            d.y = Math.atan2(-this.m20, this.m00);
            d.z = 0.0;
        } else {
            d.y = Math.atan2(this.m02, this.m22);
            d.z = Math.atan2(this.m10, this.m11);
        }
        d.x = Math.asin(Math.min(1.0, Math.max(-1.0, -this.m12)));
        return d;
    }


    /**
     * Get the Euler angles in radians of this matrix, to be applied about the Y, X and Z axes, in
     * that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The upper-left 3x3 of this matrix must be a pure rotation (orthonormal, free of scaling and
     * shear): the angles are read from its raw elements, so a scaled matrix yields wrong angles
     * rather than the angles of its rotation part.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesYXZ(@Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getEulerAnglesYXZ_identity(dest);
        return getEulerAnglesYXZ_general(dest);
    }


    /**
     * Private body of {@code getEulerAnglesYZX}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesYZX} dispatcher.
     */
    private Double3 getEulerAnglesYZX_identity(@Mutated Double3 dest) {
        return getEulerAnglesXYZ_identity(dest);
    }


    /**
     * Private body of {@code getEulerAnglesYZX}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesYZX} dispatcher.
     */
    private Double3 getEulerAnglesYZX_general(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t1 = Math.fma(this.m11, this.m11, this.m12 * this.m12);
        double _t3 = Math.fma(this.m10, this.m10, _t1) * 1.0E-15;
        if (_t1 < _t3) {
            double _buf0 = 0.0;
            d.y = Math.atan2(this.m02, this.m22);
            d.x = _buf0;
        } else {
            double _buf0 = Math.atan2(-this.m12, this.m11);
            d.y = Math.atan2(-this.m20, this.m00);
            d.x = _buf0;
        }
        d.z = Math.asin(Math.min(1.0, Math.max(-1.0, this.m10)));
        return d;
    }


    /**
     * Get the Euler angles in radians of this matrix, to be applied about the Y, Z and X axes, in
     * that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The upper-left 3x3 of this matrix must be a pure rotation (orthonormal, free of scaling and
     * shear): the angles are read from its raw elements, so a scaled matrix yields wrong angles
     * rather than the angles of its rotation part.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesYZX(@Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getEulerAnglesYZX_identity(dest);
        return getEulerAnglesYZX_general(dest);
    }


    /**
     * Private body of {@code getEulerAnglesZXY}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesZXY} dispatcher.
     */
    private Double3 getEulerAnglesZXY_identity(@Mutated Double3 dest) {
        return getEulerAnglesXYZ_identity(dest);
    }


    /**
     * Private body of {@code getEulerAnglesZXY}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesZXY} dispatcher.
     */
    private Double3 getEulerAnglesZXY_general(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t1 = Math.fma(this.m01, this.m01, this.m11 * this.m11);
        double _t3 = Math.fma(this.m21, this.m21, _t1) * 1.0E-15;
        if (_t1 < _t3) {
            double _buf0 = 0.0;
            d.z = Math.atan2(this.m10, this.m00);
            d.y = _buf0;
        } else {
            double _buf0 = Math.atan2(-this.m20, this.m22);
            d.z = Math.atan2(-this.m01, this.m11);
            d.y = _buf0;
        }
        d.x = Math.asin(Math.min(1.0, Math.max(-1.0, this.m21)));
        return d;
    }


    /**
     * Get the Euler angles in radians of this matrix, to be applied about the Z, X and Y axes, in
     * that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The upper-left 3x3 of this matrix must be a pure rotation (orthonormal, free of scaling and
     * shear): the angles are read from its raw elements, so a scaled matrix yields wrong angles
     * rather than the angles of its rotation part.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesZXY(@Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getEulerAnglesZXY_identity(dest);
        return getEulerAnglesZXY_general(dest);
    }


    /**
     * Private body of {@code getEulerAnglesZYX}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesZYX} dispatcher.
     */
    private Double3 getEulerAnglesZYX_identity(@Mutated Double3 dest) {
        return getEulerAnglesXYZ_identity(dest);
    }


    /**
     * Private body of {@code getEulerAnglesZYX}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesZYX} dispatcher.
     */
    private Double3 getEulerAnglesZYX_general(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t1 = Math.fma(this.m21, this.m21, this.m22 * this.m22);
        double _t3 = Math.fma(this.m20, this.m20, _t1) * 1.0E-15;
        if (_t1 < _t3) {
            double _buf0 = 0.0;
            d.z = Math.atan2(-this.m01, this.m11);
            d.x = _buf0;
        } else {
            double _buf0 = Math.atan2(this.m21, this.m22);
            d.z = Math.atan2(this.m10, this.m00);
            d.x = _buf0;
        }
        d.y = Math.asin(Math.min(1.0, Math.max(-1.0, -this.m20)));
        return d;
    }


    /**
     * Get the Euler angles in radians of this matrix, to be applied about the Z, Y and X axes, in
     * that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The upper-left 3x3 of this matrix must be a pure rotation (orthonormal, free of scaling and
     * shear): the angles are read from its raw elements, so a scaled matrix yields wrong angles
     * rather than the angles of its rotation part.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesZYX(@Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getEulerAnglesZYX_identity(dest);
        return getEulerAnglesZYX_general(dest);
    }


    /**
     * Private body of {@code getNormalizedRotation}, specialized by runtime matrix properties;
     * reached only through the public {@code getNormalizedRotation} dispatcher.
     */
    private DoubleQuat getNormalizedRotation_identity(@Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        d.x = 0.0;
        d.y = 0.0;
        d.z = 0.0;
        d.w = 1.0;
        return d;
    }


    /**
     * Private body of {@code getNormalizedRotation}, specialized by runtime matrix properties;
     * reached only through the public {@code getNormalizedRotation} dispatcher.
     */
    private DoubleQuat getNormalizedRotation_general(@Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _t6 = Math.fma(this.m21, this.m21, Math.fma(this.m01, this.m01, this.m11 * this.m11));
        double _t7 = Math.fma(this.m22, this.m22, Math.fma(this.m02, this.m02, this.m12 * this.m12));
        double _t8 = Math.fma(this.m20, this.m20, Math.fma(this.m00, this.m00, this.m10 * this.m10));
        double _t9 = (1.0 / Math.sqrt(_t6));
        double _t10 = (1.0 / Math.sqrt(_t7));
        double _t11 = (1.0 / Math.sqrt(_t8));
        double _t21, _t23, _t27;
        if (_t6 > 0.0) {
            _t21 = this.m01 * _t9;
            _t23 = this.m11 * _t9;
            _t27 = this.m21 * _t9;
        } else {
            _t21 = 0.0;
            _t23 = 0.0;
            _t27 = 0.0;
        }
        double _t22, _t24, _t26;
        if (_t7 > 0.0) {
            _t22 = this.m12 * _t10;
            _t24 = this.m02 * _t10;
            _t26 = this.m22 * _t10;
        } else {
            _t22 = 0.0;
            _t24 = 0.0;
            _t26 = 0.0;
        }
        double _t25, _t28, _t29;
        if (_t8 > 0.0) {
            _t25 = this.m20 * _t11;
            _t28 = this.m00 * _t11;
            _t29 = this.m10 * _t11;
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
            d.x = 0.5 * _t36 * _t66;
            d.y = 0.5 * _t56 * _t66;
            d.z = 0.5 * _t57 * _t66;
            d.w = 0.5 * Math.sqrt(_t62);
        } else {
            if (_t49 > _t37) {
                d.x = 0.5 * Math.sqrt(_t63);
                d.y = 0.5 * _t53 * _t69;
                d.z = 0.5 * _t55 * _t69;
                d.w = 0.5 * _t36 * _t69;
            } else {
                if (_t23 > _t26) {
                    d.x = 0.5 * _t53 * _t67;
                    d.y = 0.5 * Math.sqrt(_t64);
                    d.z = 0.5 * _t39 * _t67;
                    d.w = 0.5 * _t56 * _t67;
                } else {
                    d.x = 0.5 * _t55 * _t68;
                    d.y = 0.5 * _t39 * _t68;
                    d.z = 0.5 * Math.sqrt(_t65);
                    d.w = 0.5 * _t57 * _t68;
                }
            }
        }
        return d;
    }


    /**
     * Extract the rotation of this matrix as a quaternion, column-normalizing the linear block
     * first to strip scale (skew is not removed: a sheared block yields a quaternion that is not
     * unit length) and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat getNormalizedRotation(@Mutated DoubleQuat dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getNormalizedRotation_identity(dest);
        return getNormalizedRotation_general(dest);
    }


    /**
     * Private body of {@code getRow}, specialized by runtime matrix properties; reached only
     * through the public {@code getRow} dispatcher.
     */
    private Double4 getRow_identity(int row, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        double _idxSw0;
        double _idxSw1;
        double _idxSw2;
        switch (row) {
            case 0: _idxSw0 = 1.0; _idxSw1 = 0.0; _idxSw2 = 0.0; break;
            case 1: _idxSw0 = 0.0; _idxSw1 = 1.0; _idxSw2 = 0.0; break;
            case 2: _idxSw0 = 0.0; _idxSw1 = 0.0; _idxSw2 = 1.0; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + row);
        }
        d.x = _idxSw0;
        d.y = _idxSw1;
        d.z = _idxSw2;
        d.w = 0.0;
        return d;
    }


    /**
     * Private body of {@code getRow}, specialized by runtime matrix properties; reached only
     * through the public {@code getRow} dispatcher.
     */
    private Double4 getRow_translation(int row, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        double _idxSw3;
        double _idxSw4;
        double _idxSw5;
        double _idxSw6;
        switch (row) {
            case 0: _idxSw3 = 1.0; _idxSw4 = 0.0; _idxSw5 = 0.0; _idxSw6 = this.m03; break;
            case 1: _idxSw3 = 0.0; _idxSw4 = 1.0; _idxSw5 = 0.0; _idxSw6 = this.m13; break;
            case 2: _idxSw3 = 0.0; _idxSw4 = 0.0; _idxSw5 = 1.0; _idxSw6 = this.m23; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + row);
        }
        d.x = _idxSw3;
        d.y = _idxSw4;
        d.z = _idxSw5;
        d.w = _idxSw6;
        return d;
    }


    /**
     * Private body of {@code getRow}, specialized by runtime matrix properties; reached only
     * through the public {@code getRow} dispatcher.
     */
    private Double4 getRow_general(int row, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        double _idxSw7;
        double _idxSw8;
        double _idxSw9;
        double _idxSw10;
        switch (row) {
            case 0: _idxSw7 = this.m00; _idxSw8 = this.m01; _idxSw9 = this.m02; _idxSw10 = this.m03; break;
            case 1: _idxSw7 = this.m10; _idxSw8 = this.m11; _idxSw9 = this.m12; _idxSw10 = this.m13; break;
            case 2: _idxSw7 = this.m20; _idxSw8 = this.m21; _idxSw9 = this.m22; _idxSw10 = this.m23; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + row);
        }
        d.x = _idxSw7;
        d.y = _idxSw8;
        d.z = _idxSw9;
        d.w = _idxSw10;
        return d;
    }


    /**
     * Get the row at the given index of this matrix and store the result in {@code dest}.
     *
     * @param row the row index
     * @param dest will hold the result
     * @return dest
     * @throws IndexOutOfBoundsException if {@code row} is not in {@code [0, ROWS)}
     */
    public Double4 getRow(int row, @Mutated Double4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return getRow_identity(row, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getRow_translation(row, dest);
        return getRow_general(row, dest);
    }


    /**
     * Private body of {@code getScale}, specialized by runtime matrix properties; reached only
     * through the public {@code getScale} dispatcher.
     */
    private Double3 getScale_identity(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = 1.0;
        d.y = 1.0;
        d.z = 1.0;
        return d;
    }


    /**
     * Private body of {@code getScale}, specialized by runtime matrix properties; reached only
     * through the public {@code getScale} dispatcher.
     */
    private Double3 getScale_general(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = Math.sqrt(Math.fma(this.m20, this.m20, Math.fma(this.m00, this.m00, this.m10 * this.m10)));
        d.y = Math.sqrt(Math.fma(this.m21, this.m21, Math.fma(this.m01, this.m01, this.m11 * this.m11)));
        d.z = Math.sqrt(Math.fma(this.m22, this.m22, Math.fma(this.m02, this.m02, this.m12 * this.m12)));
        return d;
    }


    /**
     * Get the scaling factors of this matrix, as the lengths of its basis columns (always
     * non-negative; skew is ignored) and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getScale(@Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getScale_identity(dest);
        return getScale_general(dest);
    }


    /**
     * Private body of {@code getTranslation}, specialized by runtime matrix properties; reached
     * only through the public {@code getTranslation} dispatcher.
     */
    private Double3 getTranslation_identity(@Mutated Double3 dest) {
        return getEulerAnglesXYZ_identity(dest);
    }


    /**
     * Private body of {@code getTranslation}, specialized by runtime matrix properties; reached
     * only through the public {@code getTranslation} dispatcher.
     */
    private Double3 getTranslation_general(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = this.m03;
        d.y = this.m13;
        d.z = this.m23;
        return d;
    }


    /**
     * Get the translation of this matrix and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getTranslation(@Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return getTranslation_identity(dest);
        return getTranslation_general(dest);
    }


    /**
     * Private body of {@code getUnnormalizedRotation}, specialized by runtime matrix properties;
     * reached only through the public {@code getUnnormalizedRotation} dispatcher.
     */
    private DoubleQuat getUnnormalizedRotation_identity(@Mutated DoubleQuat dest) {
        return getNormalizedRotation_identity(dest);
    }


    /**
     * Private body of {@code getUnnormalizedRotation}, specialized by runtime matrix properties;
     * reached only through the public {@code getUnnormalizedRotation} dispatcher.
     */
    private DoubleQuat getUnnormalizedRotation_orthogonal(@Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _t0 = this.m00 + this.m11;
        double _t1 = this.m21 - this.m12;
        double _t2 = Math.max(this.m11, this.m22);
        double _t4 = this.m01 + this.m10;
        double _t6 = this.m02 + this.m20;
        double _t7 = this.m02 - this.m20;
        double _t8 = this.m12 + this.m21;
        double _t9 = this.m10 - this.m01;
        double _t10 = this.m22 + _t0;
        double _t14 = 1.0 + _t10;
        double _t15 = 1.0 + (this.m00 - (this.m11 + this.m22));
        double _t16 = 1.0 + (this.m11 - (this.m00 + this.m22));
        double _t17 = 1.0 + (this.m22 - _t0);
        double _t18 = (1.0 / Math.sqrt(_t14));
        double _t19 = (1.0 / Math.sqrt(_t16));
        double _t20 = (1.0 / Math.sqrt(_t17));
        double _t21 = (1.0 / Math.sqrt(_t15));
        if (_t10 > 0.0) {
            double _buf0 = 0.5 * _t1 * _t18;
            d.y = 0.5 * _t7 * _t18;
            d.z = 0.5 * _t9 * _t18;
            d.w = 0.5 * Math.sqrt(_t14);
            d.x = _buf0;
        } else {
            if (this.m00 > _t2) {
                double _buf0 = 0.5 * Math.sqrt(_t15);
                d.y = 0.5 * _t4 * _t21;
                d.z = 0.5 * _t6 * _t21;
                d.w = 0.5 * _t1 * _t21;
                d.x = _buf0;
            } else {
                if (this.m11 > this.m22) {
                    double _buf0 = 0.5 * _t4 * _t19;
                    d.y = 0.5 * Math.sqrt(_t16);
                    d.z = 0.5 * _t8 * _t19;
                    d.w = 0.5 * _t7 * _t19;
                    d.x = _buf0;
                } else {
                    double _buf0 = 0.5 * _t6 * _t20;
                    d.y = 0.5 * _t8 * _t20;
                    d.z = 0.5 * Math.sqrt(_t17);
                    d.w = 0.5 * _t9 * _t20;
                    d.x = _buf0;
                }
            }
        }
        return d;
    }


    /**
     * Private body of {@code getUnnormalizedRotation}, specialized by runtime matrix properties;
     * reached only through the public {@code getUnnormalizedRotation} dispatcher.
     */
    private DoubleQuat getUnnormalizedRotation_general(@Mutated DoubleQuat dest) {
        return getUnnormalizedRotation_orthogonal(dest);
    }


    /**
     * Extract the rotation of this matrix as a quaternion directly from the linear block without
     * normalizing it, assuming it is already orthonormal and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat getUnnormalizedRotation(@Mutated DoubleQuat dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getUnnormalizedRotation_identity(dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return getUnnormalizedRotation_orthogonal(dest);
        return getUnnormalizedRotation_general(dest);
    }


    /**
     * Private body of {@code invNegativeX}, specialized by runtime matrix properties; reached only
     * through the public {@code invNegativeX} dispatcher.
     */
    private Double3 invNegativeX_identity(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = -1.0;
        d.y = 0.0;
        d.z = 0.0;
        return d;
    }


    /**
     * Private body of {@code invNegativeX}, specialized by runtime matrix properties; reached only
     * through the public {@code invNegativeX} dispatcher.
     */
    private Double3 invNegativeX_general(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t6 = Math.fma(this.m10, this.m21, -(this.m11 * this.m20));
        double _t7 = Math.fma(this.m11, this.m22, -(this.m12 * this.m21));
        double _t8 = Math.fma(this.m12, this.m20, -(this.m10 * this.m22));
        double _t11 = Math.fma(_t6, _t6, Math.fma(_t7, _t7, _t8 * _t8));
        double _t12 = (1.0 / Math.sqrt(_t11));
        if (_t11 > 0.0) {
            d.x = -(_t7 * _t12);
            d.y = -(_t8 * _t12);
            d.z = -(_t6 * _t12);
        } else {
            d.x = -0.0;
            d.y = -0.0;
            d.z = -0.0;
        }
        return d;
    }


    /**
     * Obtain the direction of {@code -X} before the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invNegativeX(@Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invNegativeX_identity(dest);
        return invNegativeX_general(dest);
    }


    /**
     * Private body of {@code invNegativeY}, specialized by runtime matrix properties; reached only
     * through the public {@code invNegativeY} dispatcher.
     */
    private Double3 invNegativeY_identity(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = 0.0;
        d.y = -1.0;
        d.z = 0.0;
        return d;
    }


    /**
     * Private body of {@code invNegativeY}, specialized by runtime matrix properties; reached only
     * through the public {@code invNegativeY} dispatcher.
     */
    private Double3 invNegativeY_general(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t6 = Math.fma(this.m01, this.m20, -(this.m00 * this.m21));
        double _t7 = Math.fma(this.m00, this.m22, -(this.m02 * this.m20));
        double _t8 = Math.fma(this.m02, this.m21, -(this.m01 * this.m22));
        double _t11 = Math.fma(_t6, _t6, Math.fma(_t7, _t7, _t8 * _t8));
        double _t12 = (1.0 / Math.sqrt(_t11));
        if (_t11 > 0.0) {
            d.x = -(_t8 * _t12);
            d.y = -(_t7 * _t12);
            d.z = -(_t6 * _t12);
        } else {
            d.x = -0.0;
            d.y = -0.0;
            d.z = -0.0;
        }
        return d;
    }


    /**
     * Obtain the direction of {@code -Y} before the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invNegativeY(@Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invNegativeY_identity(dest);
        return invNegativeY_general(dest);
    }


    /**
     * Private body of {@code invNegativeZ}, specialized by runtime matrix properties; reached only
     * through the public {@code invNegativeZ} dispatcher.
     */
    private Double3 invNegativeZ_identity(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = 0.0;
        d.y = 0.0;
        d.z = -1.0;
        return d;
    }


    /**
     * Private body of {@code invNegativeZ}, specialized by runtime matrix properties; reached only
     * through the public {@code invNegativeZ} dispatcher.
     */
    private Double3 invNegativeZ_general(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t6 = Math.fma(this.m00, this.m11, -(this.m01 * this.m10));
        double _t7 = Math.fma(this.m01, this.m12, -(this.m02 * this.m11));
        double _t8 = Math.fma(this.m02, this.m10, -(this.m00 * this.m12));
        double _t11 = Math.fma(_t6, _t6, Math.fma(_t7, _t7, _t8 * _t8));
        double _t12 = (1.0 / Math.sqrt(_t11));
        if (_t11 > 0.0) {
            d.x = -(_t7 * _t12);
            d.y = -(_t8 * _t12);
            d.z = -(_t6 * _t12);
        } else {
            d.x = -0.0;
            d.y = -0.0;
            d.z = -0.0;
        }
        return d;
    }


    /**
     * Obtain the direction of {@code -Z} before the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invNegativeZ(@Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invNegativeZ_identity(dest);
        return invNegativeZ_general(dest);
    }


    /**
     * Private body of {@code invNormalizedNegativeX}, specialized by runtime matrix properties;
     * reached only through the public {@code invNormalizedNegativeX} dispatcher.
     */
    private Double3 invNormalizedNegativeX_identity(@Mutated Double3 dest) {
        return invNegativeX_identity(dest);
    }


    /**
     * Private body of {@code invNormalizedNegativeX}, specialized by runtime matrix properties;
     * reached only through the public {@code invNormalizedNegativeX} dispatcher.
     */
    private Double3 invNormalizedNegativeX_general(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = -this.m00;
        d.y = -this.m01;
        d.z = -this.m02;
        return d;
    }


    /**
     * Obtain the direction of {@code -X} before the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invNormalizedNegativeX(@Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invNormalizedNegativeX_identity(dest);
        return invNormalizedNegativeX_general(dest);
    }


    /**
     * Private body of {@code invNormalizedNegativeY}, specialized by runtime matrix properties;
     * reached only through the public {@code invNormalizedNegativeY} dispatcher.
     */
    private Double3 invNormalizedNegativeY_identity(@Mutated Double3 dest) {
        return invNegativeY_identity(dest);
    }


    /**
     * Private body of {@code invNormalizedNegativeY}, specialized by runtime matrix properties;
     * reached only through the public {@code invNormalizedNegativeY} dispatcher.
     */
    private Double3 invNormalizedNegativeY_general(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = -this.m10;
        d.y = -this.m11;
        d.z = -this.m12;
        return d;
    }


    /**
     * Obtain the direction of {@code -Y} before the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invNormalizedNegativeY(@Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invNormalizedNegativeY_identity(dest);
        return invNormalizedNegativeY_general(dest);
    }


    /**
     * Private body of {@code invNormalizedNegativeZ}, specialized by runtime matrix properties;
     * reached only through the public {@code invNormalizedNegativeZ} dispatcher.
     */
    private Double3 invNormalizedNegativeZ_identity(@Mutated Double3 dest) {
        return invNegativeZ_identity(dest);
    }


    /**
     * Private body of {@code invNormalizedNegativeZ}, specialized by runtime matrix properties;
     * reached only through the public {@code invNormalizedNegativeZ} dispatcher.
     */
    private Double3 invNormalizedNegativeZ_general(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = -this.m20;
        d.y = -this.m21;
        d.z = -this.m22;
        return d;
    }


    /**
     * Obtain the direction of {@code -Z} before the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invNormalizedNegativeZ(@Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invNormalizedNegativeZ_identity(dest);
        return invNormalizedNegativeZ_general(dest);
    }


    /**
     * Private body of {@code invNormalizedPositiveX}, specialized by runtime matrix properties;
     * reached only through the public {@code invNormalizedPositiveX} dispatcher.
     */
    private Double3 invNormalizedPositiveX_identity(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = 1.0;
        d.y = 0.0;
        d.z = 0.0;
        return d;
    }


    /**
     * Private body of {@code invNormalizedPositiveX}, specialized by runtime matrix properties;
     * reached only through the public {@code invNormalizedPositiveX} dispatcher.
     */
    private Double3 invNormalizedPositiveX_general(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = this.m00;
        d.y = this.m01;
        d.z = this.m02;
        return d;
    }


    /**
     * Obtain the direction of {@code +X} before the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invNormalizedPositiveX(@Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invNormalizedPositiveX_identity(dest);
        return invNormalizedPositiveX_general(dest);
    }


    /**
     * Private body of {@code invNormalizedPositiveY}, specialized by runtime matrix properties;
     * reached only through the public {@code invNormalizedPositiveY} dispatcher.
     */
    private Double3 invNormalizedPositiveY_identity(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = 0.0;
        d.y = 1.0;
        d.z = 0.0;
        return d;
    }


    /**
     * Private body of {@code invNormalizedPositiveY}, specialized by runtime matrix properties;
     * reached only through the public {@code invNormalizedPositiveY} dispatcher.
     */
    private Double3 invNormalizedPositiveY_general(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = this.m10;
        d.y = this.m11;
        d.z = this.m12;
        return d;
    }


    /**
     * Obtain the direction of {@code +Y} before the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invNormalizedPositiveY(@Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invNormalizedPositiveY_identity(dest);
        return invNormalizedPositiveY_general(dest);
    }


    /**
     * Private body of {@code invNormalizedPositiveZ}, specialized by runtime matrix properties;
     * reached only through the public {@code invNormalizedPositiveZ} dispatcher.
     */
    private Double3 invNormalizedPositiveZ_identity(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = 0.0;
        d.y = 0.0;
        d.z = 1.0;
        return d;
    }


    /**
     * Private body of {@code invNormalizedPositiveZ}, specialized by runtime matrix properties;
     * reached only through the public {@code invNormalizedPositiveZ} dispatcher.
     */
    private Double3 invNormalizedPositiveZ_general(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = this.m20;
        d.y = this.m21;
        d.z = this.m22;
        return d;
    }


    /**
     * Obtain the direction of {@code +Z} before the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invNormalizedPositiveZ(@Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invNormalizedPositiveZ_identity(dest);
        return invNormalizedPositiveZ_general(dest);
    }


    /**
     * Private body of {@code invPositiveX}, specialized by runtime matrix properties; reached only
     * through the public {@code invPositiveX} dispatcher.
     */
    private Double3 invPositiveX_identity(@Mutated Double3 dest) {
        return invNormalizedPositiveX_identity(dest);
    }


    /**
     * Private body of {@code invPositiveX}, specialized by runtime matrix properties; reached only
     * through the public {@code invPositiveX} dispatcher.
     */
    private Double3 invPositiveX_general(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t6 = Math.fma(this.m10, this.m21, -(this.m11 * this.m20));
        double _t7 = Math.fma(this.m11, this.m22, -(this.m12 * this.m21));
        double _t8 = Math.fma(this.m12, this.m20, -(this.m10 * this.m22));
        double _t11 = Math.fma(_t6, _t6, Math.fma(_t7, _t7, _t8 * _t8));
        double _t12 = (1.0 / Math.sqrt(_t11));
        if (_t11 > 0.0) {
            d.x = _t7 * _t12;
            d.y = _t8 * _t12;
            d.z = _t6 * _t12;
        } else {
            d.x = 0.0;
            d.y = 0.0;
            d.z = 0.0;
        }
        return d;
    }


    /**
     * Obtain the direction of {@code +X} before the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invPositiveX(@Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invPositiveX_identity(dest);
        return invPositiveX_general(dest);
    }


    /**
     * Private body of {@code invPositiveY}, specialized by runtime matrix properties; reached only
     * through the public {@code invPositiveY} dispatcher.
     */
    private Double3 invPositiveY_identity(@Mutated Double3 dest) {
        return invNormalizedPositiveY_identity(dest);
    }


    /**
     * Private body of {@code invPositiveY}, specialized by runtime matrix properties; reached only
     * through the public {@code invPositiveY} dispatcher.
     */
    private Double3 invPositiveY_general(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t6 = Math.fma(this.m01, this.m20, -(this.m00 * this.m21));
        double _t7 = Math.fma(this.m00, this.m22, -(this.m02 * this.m20));
        double _t8 = Math.fma(this.m02, this.m21, -(this.m01 * this.m22));
        double _t11 = Math.fma(_t6, _t6, Math.fma(_t7, _t7, _t8 * _t8));
        double _t12 = (1.0 / Math.sqrt(_t11));
        if (_t11 > 0.0) {
            d.x = _t8 * _t12;
            d.y = _t7 * _t12;
            d.z = _t6 * _t12;
        } else {
            d.x = 0.0;
            d.y = 0.0;
            d.z = 0.0;
        }
        return d;
    }


    /**
     * Obtain the direction of {@code +Y} before the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invPositiveY(@Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invPositiveY_identity(dest);
        return invPositiveY_general(dest);
    }


    /**
     * Private body of {@code invPositiveZ}, specialized by runtime matrix properties; reached only
     * through the public {@code invPositiveZ} dispatcher.
     */
    private Double3 invPositiveZ_identity(@Mutated Double3 dest) {
        return invNormalizedPositiveZ_identity(dest);
    }


    /**
     * Private body of {@code invPositiveZ}, specialized by runtime matrix properties; reached only
     * through the public {@code invPositiveZ} dispatcher.
     */
    private Double3 invPositiveZ_general(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t6 = Math.fma(this.m00, this.m11, -(this.m01 * this.m10));
        double _t7 = Math.fma(this.m01, this.m12, -(this.m02 * this.m11));
        double _t8 = Math.fma(this.m02, this.m10, -(this.m00 * this.m12));
        double _t11 = Math.fma(_t6, _t6, Math.fma(_t7, _t7, _t8 * _t8));
        double _t12 = (1.0 / Math.sqrt(_t11));
        if (_t11 > 0.0) {
            d.x = _t7 * _t12;
            d.y = _t8 * _t12;
            d.z = _t6 * _t12;
        } else {
            d.x = 0.0;
            d.y = 0.0;
            d.z = 0.0;
        }
        return d;
    }


    /**
     * Obtain the direction of {@code +Z} before the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invPositiveZ(@Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invPositiveZ_identity(dest);
        return invPositiveZ_general(dest);
    }


    /**
     * Private body of {@code negativeX}, specialized by runtime matrix properties; reached only
     * through the public {@code negativeX} dispatcher.
     */
    private Double3 negativeX_identity(@Mutated Double3 dest) {
        return invNegativeX_identity(dest);
    }


    /**
     * Private body of {@code negativeX}, specialized by runtime matrix properties; reached only
     * through the public {@code negativeX} dispatcher.
     */
    private Double3 negativeX_general(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t2 = Math.fma(this.m20, this.m20, Math.fma(this.m00, this.m00, this.m10 * this.m10));
        double _t3 = (1.0 / Math.sqrt(_t2));
        if (_t2 > 0.0) {
            d.x = -(this.m00 * _t3);
            d.y = -(this.m10 * _t3);
            d.z = -(this.m20 * _t3);
        } else {
            d.x = -0.0;
            d.y = -0.0;
            d.z = -0.0;
        }
        return d;
    }


    /**
     * Obtain the direction of {@code -X} after the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 negativeX(@Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return negativeX_identity(dest);
        return negativeX_general(dest);
    }


    /**
     * Private body of {@code negativeY}, specialized by runtime matrix properties; reached only
     * through the public {@code negativeY} dispatcher.
     */
    private Double3 negativeY_identity(@Mutated Double3 dest) {
        return invNegativeY_identity(dest);
    }


    /**
     * Private body of {@code negativeY}, specialized by runtime matrix properties; reached only
     * through the public {@code negativeY} dispatcher.
     */
    private Double3 negativeY_general(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t2 = Math.fma(this.m21, this.m21, Math.fma(this.m01, this.m01, this.m11 * this.m11));
        double _t3 = (1.0 / Math.sqrt(_t2));
        if (_t2 > 0.0) {
            d.x = -(this.m01 * _t3);
            d.y = -(this.m11 * _t3);
            d.z = -(this.m21 * _t3);
        } else {
            d.x = -0.0;
            d.y = -0.0;
            d.z = -0.0;
        }
        return d;
    }


    /**
     * Obtain the direction of {@code -Y} after the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 negativeY(@Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return negativeY_identity(dest);
        return negativeY_general(dest);
    }


    /**
     * Private body of {@code negativeZ}, specialized by runtime matrix properties; reached only
     * through the public {@code negativeZ} dispatcher.
     */
    private Double3 negativeZ_identity(@Mutated Double3 dest) {
        return invNegativeZ_identity(dest);
    }


    /**
     * Private body of {@code negativeZ}, specialized by runtime matrix properties; reached only
     * through the public {@code negativeZ} dispatcher.
     */
    private Double3 negativeZ_general(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t2 = Math.fma(this.m22, this.m22, Math.fma(this.m02, this.m02, this.m12 * this.m12));
        double _t3 = (1.0 / Math.sqrt(_t2));
        if (_t2 > 0.0) {
            d.x = -(this.m02 * _t3);
            d.y = -(this.m12 * _t3);
            d.z = -(this.m22 * _t3);
        } else {
            d.x = -0.0;
            d.y = -0.0;
            d.z = -0.0;
        }
        return d;
    }


    /**
     * Obtain the direction of {@code -Z} after the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 negativeZ(@Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return negativeZ_identity(dest);
        return negativeZ_general(dest);
    }


    /**
     * Private body of {@code normalizedNegativeX}, specialized by runtime matrix properties;
     * reached only through the public {@code normalizedNegativeX} dispatcher.
     */
    private Double3 normalizedNegativeX_identity(@Mutated Double3 dest) {
        return invNegativeX_identity(dest);
    }


    /**
     * Private body of {@code normalizedNegativeX}, specialized by runtime matrix properties;
     * reached only through the public {@code normalizedNegativeX} dispatcher.
     */
    private Double3 normalizedNegativeX_general(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = -this.m00;
        d.y = -this.m10;
        d.z = -this.m20;
        return d;
    }


    /**
     * Obtain the direction of {@code -X} after the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 normalizedNegativeX(@Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return normalizedNegativeX_identity(dest);
        return normalizedNegativeX_general(dest);
    }


    /**
     * Private body of {@code normalizedNegativeY}, specialized by runtime matrix properties;
     * reached only through the public {@code normalizedNegativeY} dispatcher.
     */
    private Double3 normalizedNegativeY_identity(@Mutated Double3 dest) {
        return invNegativeY_identity(dest);
    }


    /**
     * Private body of {@code normalizedNegativeY}, specialized by runtime matrix properties;
     * reached only through the public {@code normalizedNegativeY} dispatcher.
     */
    private Double3 normalizedNegativeY_general(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = -this.m01;
        d.y = -this.m11;
        d.z = -this.m21;
        return d;
    }


    /**
     * Obtain the direction of {@code -Y} after the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 normalizedNegativeY(@Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return normalizedNegativeY_identity(dest);
        return normalizedNegativeY_general(dest);
    }


    /**
     * Private body of {@code normalizedNegativeZ}, specialized by runtime matrix properties;
     * reached only through the public {@code normalizedNegativeZ} dispatcher.
     */
    private Double3 normalizedNegativeZ_identity(@Mutated Double3 dest) {
        return invNegativeZ_identity(dest);
    }


    /**
     * Private body of {@code normalizedNegativeZ}, specialized by runtime matrix properties;
     * reached only through the public {@code normalizedNegativeZ} dispatcher.
     */
    private Double3 normalizedNegativeZ_general(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = -this.m02;
        d.y = -this.m12;
        d.z = -this.m22;
        return d;
    }


    /**
     * Obtain the direction of {@code -Z} after the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 normalizedNegativeZ(@Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return normalizedNegativeZ_identity(dest);
        return normalizedNegativeZ_general(dest);
    }


    /**
     * Private body of {@code normalizedPositiveX}, specialized by runtime matrix properties;
     * reached only through the public {@code normalizedPositiveX} dispatcher.
     */
    private Double3 normalizedPositiveX_identity(@Mutated Double3 dest) {
        return invNormalizedPositiveX_identity(dest);
    }


    /**
     * Private body of {@code normalizedPositiveX}, specialized by runtime matrix properties;
     * reached only through the public {@code normalizedPositiveX} dispatcher.
     */
    private Double3 normalizedPositiveX_general(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = this.m00;
        d.y = this.m10;
        d.z = this.m20;
        return d;
    }


    /**
     * Obtain the direction of {@code +X} after the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 normalizedPositiveX(@Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return normalizedPositiveX_identity(dest);
        return normalizedPositiveX_general(dest);
    }


    /**
     * Private body of {@code normalizedPositiveY}, specialized by runtime matrix properties;
     * reached only through the public {@code normalizedPositiveY} dispatcher.
     */
    private Double3 normalizedPositiveY_identity(@Mutated Double3 dest) {
        return invNormalizedPositiveY_identity(dest);
    }


    /**
     * Private body of {@code normalizedPositiveY}, specialized by runtime matrix properties;
     * reached only through the public {@code normalizedPositiveY} dispatcher.
     */
    private Double3 normalizedPositiveY_general(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = this.m01;
        d.y = this.m11;
        d.z = this.m21;
        return d;
    }


    /**
     * Obtain the direction of {@code +Y} after the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 normalizedPositiveY(@Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return normalizedPositiveY_identity(dest);
        return normalizedPositiveY_general(dest);
    }


    /**
     * Private body of {@code normalizedPositiveZ}, specialized by runtime matrix properties;
     * reached only through the public {@code normalizedPositiveZ} dispatcher.
     */
    private Double3 normalizedPositiveZ_identity(@Mutated Double3 dest) {
        return invNormalizedPositiveZ_identity(dest);
    }


    /**
     * Private body of {@code normalizedPositiveZ}, specialized by runtime matrix properties;
     * reached only through the public {@code normalizedPositiveZ} dispatcher.
     */
    private Double3 normalizedPositiveZ_general(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = this.m02;
        d.y = this.m12;
        d.z = this.m22;
        return d;
    }


    /**
     * Obtain the direction of {@code +Z} after the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 normalizedPositiveZ(@Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return normalizedPositiveZ_identity(dest);
        return normalizedPositiveZ_general(dest);
    }


    /**
     * Private body of {@code origin}, specialized by runtime matrix properties; reached only
     * through the public {@code origin} dispatcher.
     */
    private Double3 origin_identity(@Mutated Double3 dest) {
        return getEulerAnglesXYZ_identity(dest);
    }


    /**
     * Private body of {@code origin}, specialized by runtime matrix properties; reached only
     * through the public {@code origin} dispatcher.
     */
    private Double3 origin_translation(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = -this.m03;
        d.y = -this.m13;
        d.z = -this.m23;
        return d;
    }


    /**
     * Private body of {@code origin}, specialized by runtime matrix properties; reached only
     * through the public {@code origin} dispatcher.
     */
    private Double3 origin_general(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = -Math.fma(this.m20, this.m23, Math.fma(this.m00, this.m03, this.m10 * this.m13));
        d.y = -Math.fma(this.m21, this.m23, Math.fma(this.m01, this.m03, this.m11 * this.m13));
        d.z = -Math.fma(this.m22, this.m23, Math.fma(this.m02, this.m03, this.m12 * this.m13));
        return d;
    }


    /**
     * Obtain the position that is transformed to the origin by this matrix, assuming its upper-left
     * 3x3 block is orthonormal (e.g. a rotation-translation or view matrix) and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 origin(@Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return origin_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return origin_translation(dest);
        return origin_general(dest);
    }


    /**
     * Private body of {@code positiveX}, specialized by runtime matrix properties; reached only
     * through the public {@code positiveX} dispatcher.
     */
    private Double3 positiveX_identity(@Mutated Double3 dest) {
        return invNormalizedPositiveX_identity(dest);
    }


    /**
     * Private body of {@code positiveX}, specialized by runtime matrix properties; reached only
     * through the public {@code positiveX} dispatcher.
     */
    private Double3 positiveX_general(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t2 = Math.fma(this.m20, this.m20, Math.fma(this.m00, this.m00, this.m10 * this.m10));
        double _t3 = (1.0 / Math.sqrt(_t2));
        if (_t2 > 0.0) {
            d.x = this.m00 * _t3;
            d.y = this.m10 * _t3;
            d.z = this.m20 * _t3;
        } else {
            d.x = 0.0;
            d.y = 0.0;
            d.z = 0.0;
        }
        return d;
    }


    /**
     * Obtain the direction of {@code +X} after the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 positiveX(@Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return positiveX_identity(dest);
        return positiveX_general(dest);
    }


    /**
     * Private body of {@code positiveY}, specialized by runtime matrix properties; reached only
     * through the public {@code positiveY} dispatcher.
     */
    private Double3 positiveY_identity(@Mutated Double3 dest) {
        return invNormalizedPositiveY_identity(dest);
    }


    /**
     * Private body of {@code positiveY}, specialized by runtime matrix properties; reached only
     * through the public {@code positiveY} dispatcher.
     */
    private Double3 positiveY_general(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t2 = Math.fma(this.m21, this.m21, Math.fma(this.m01, this.m01, this.m11 * this.m11));
        double _t3 = (1.0 / Math.sqrt(_t2));
        if (_t2 > 0.0) {
            d.x = this.m01 * _t3;
            d.y = this.m11 * _t3;
            d.z = this.m21 * _t3;
        } else {
            d.x = 0.0;
            d.y = 0.0;
            d.z = 0.0;
        }
        return d;
    }


    /**
     * Obtain the direction of {@code +Y} after the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 positiveY(@Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return positiveY_identity(dest);
        return positiveY_general(dest);
    }


    /**
     * Private body of {@code positiveZ}, specialized by runtime matrix properties; reached only
     * through the public {@code positiveZ} dispatcher.
     */
    private Double3 positiveZ_identity(@Mutated Double3 dest) {
        return invNormalizedPositiveZ_identity(dest);
    }


    /**
     * Private body of {@code positiveZ}, specialized by runtime matrix properties; reached only
     * through the public {@code positiveZ} dispatcher.
     */
    private Double3 positiveZ_general(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t2 = Math.fma(this.m22, this.m22, Math.fma(this.m02, this.m02, this.m12 * this.m12));
        double _t3 = (1.0 / Math.sqrt(_t2));
        if (_t2 > 0.0) {
            d.x = this.m02 * _t3;
            d.y = this.m12 * _t3;
            d.z = this.m22 * _t3;
        } else {
            d.x = 0.0;
            d.y = 0.0;
            d.z = 0.0;
        }
        return d;
    }


    /**
     * Obtain the direction of {@code +Z} after the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 positiveZ(@Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return positiveZ_identity(dest);
        return positiveZ_general(dest);
    }


    /**
     * Compute the determinant of the linear part (the upper-left square block) of this matrix.
     *
     * @return the determinant of the linear part (the upper-left square block) of this matrix
     */
    public double determinant() {
        return Math.fma(this.m02, Math.fma(this.m10, this.m21, -(this.m11 * this.m20)), Math.fma(this.m00, Math.fma(this.m11, this.m22, -(this.m12 * this.m21)), -(this.m01 * Math.fma(this.m10, this.m22, -(this.m12 * this.m20)))));
    }


    /**
     * Compute the Frobenius norm of this matrix.
     *
     * @return the Frobenius norm of this matrix
     */
    public double frobeniusNorm() {
        return Math.sqrt(Math.fma(this.m00, this.m00, Math.fma(this.m01, this.m01, this.m02 * this.m02)) + Math.fma(this.m03, this.m03, Math.fma(this.m10, this.m10, this.m11 * this.m11)) + (Math.fma(this.m12, this.m12, Math.fma(this.m13, this.m13, this.m20 * this.m20)) + Math.fma(this.m21, this.m21, Math.fma(this.m22, this.m22, this.m23 * this.m23))));
    }


    /**
     * Private body of {@code invert}, specialized by runtime matrix properties; reached only
     * through the public {@code invert} dispatcher.
     */
    private Double3x4 invert_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = 0.0;
        d.m10 = 0.0;
        d.m11 = 1.0;
        d.m12 = 0.0;
        d.m13 = 0.0;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 1.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_IDENTITY;
        return d;
    }


    /**
     * Private in-place self-form body of {@code invert}, specialized by runtime matrix properties;
     * reached only through the public {@code invert} dispatcher.
     */
    private Double3x4 invert_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.properties = Joml.BIT_IDENTITY;
        return d;
    }


    /**
     * Private body of {@code invert}, specialized by runtime matrix properties; reached only
     * through the public {@code invert} dispatcher.
     */
    private Double3x4 invert_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = -this.m03;
        d.m10 = 0.0;
        d.m11 = 1.0;
        d.m12 = 0.0;
        d.m13 = -this.m13;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 1.0;
        d.m23 = -this.m23;
        d.properties = Joml.BIT_TRANSLATION;
        return d;
    }


    /**
     * Private in-place self-form body of {@code invert}, specialized by runtime matrix properties;
     * reached only through the public {@code invert} dispatcher.
     */
    private Double3x4 invert_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m03 = -this.m03;
        d.m13 = -this.m13;
        d.m23 = -this.m23;
        d.properties = Joml.BIT_TRANSLATION;
        return d;
    }


    /**
     * Private body of {@code invert}, specialized by runtime matrix properties; reached only
     * through the public {@code invert} dispatcher.
     */
    private Double3x4 invert_orthogonal(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = this.m00;
        double _buf1 = this.m10;
        double _buf2 = this.m20;
        double _buf3 = Math.fma(-this.m20, this.m23, Math.fma(-this.m10, this.m13, -(this.m00 * this.m03)));
        d.m10 = this.m01;
        double _buf4 = this.m11;
        double _buf5 = this.m21;
        double _buf6 = Math.fma(-this.m21, this.m23, Math.fma(-this.m11, this.m13, -(this.m01 * this.m03)));
        d.m20 = this.m02;
        d.m21 = this.m12;
        double _buf7 = this.m22;
        d.m23 = Math.fma(-this.m22, this.m23, Math.fma(-this.m12, this.m13, -(this.m02 * this.m03)));
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.m03 = _buf3;
        d.m11 = _buf4;
        d.m12 = _buf5;
        d.m13 = _buf6;
        d.m22 = _buf7;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code invert}, specialized by runtime matrix properties; reached only
     * through the public {@code invert} dispatcher.
     */
    private Double3x4 invert_general(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t20 = Math.fma(this.m11, this.m22, -(this.m12 * this.m21));
        double _t21 = Math.fma(this.m10, this.m21, -(this.m11 * this.m20));
        double _t23 = Math.fma(this.m02, this.m21, -(this.m01 * this.m22));
        double _t24 = Math.fma(this.m01, this.m12, -(this.m02 * this.m11));
        double _t25 = Math.fma(this.m12, this.m20, -(this.m10 * this.m22));
        double _t26 = Math.fma(this.m00, this.m22, -(this.m02 * this.m20));
        double _t27 = Math.fma(this.m02, this.m10, -(this.m00 * this.m12));
        double _t28 = Math.fma(this.m01, this.m20, -(this.m00 * this.m21));
        double _t29 = Math.fma(this.m00, this.m11, -(this.m01 * this.m10));
        double _t33 = Math.fma(this.m02, _t21, Math.fma(this.m00, _t20, -(this.m01 * Math.fma(this.m10, this.m22, -(this.m12 * this.m20)))));
        double _t33_inv = 1.0 / _t33;
        d.m00 = _t20 * _t33_inv;
        d.m01 = _t23 * _t33_inv;
        d.m02 = _t24 * _t33_inv;
        double _buf0 = -(Math.fma(this.m23, _t24, Math.fma(this.m03, _t20, this.m13 * _t23)) * _t33_inv);
        d.m10 = _t25 * _t33_inv;
        d.m11 = _t26 * _t33_inv;
        d.m12 = _t27 * _t33_inv;
        double _buf1 = -(Math.fma(this.m23, _t27, Math.fma(this.m03, _t25, this.m13 * _t26)) * _t33_inv);
        d.m20 = _t21 * _t33_inv;
        d.m21 = _t28 * _t33_inv;
        d.m22 = _t29 * _t33_inv;
        d.m23 = -(Math.fma(this.m23, _t29, Math.fma(this.m03, _t21, this.m13 * _t28)) * _t33_inv);
        d.m03 = _buf0;
        d.m13 = _buf1;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Invert this affine matrix, i.e. compute the inverse of the implied square homogeneous matrix
     * and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 invert(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invert_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invert_translation(dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return invert_orthogonal(dest);
        return invert_general(dest);
    }


    /**
     * Invert this affine matrix, i.e. compute the inverse of the implied square homogeneous matrix.
     *
     * @return this
     */
    @Mutated public Double3x4 invert() {
        if (Joml.RETURN_NEW) return invert(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invert_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invert_translation_self(this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return invert_orthogonal(this);
        return invert_general(this);
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Double3x4 invertProduct_general(Double3x4R other, @Mutated Double3x4 dest, int _props) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t24 = Math.fma(other.m21(), this.m12, Math.fma(other.m01(), this.m10, other.m11() * this.m11));
        double _t25 = Math.fma(other.m22(), this.m22, Math.fma(other.m02(), this.m20, other.m12() * this.m21));
        double _t26 = Math.fma(other.m21(), this.m22, Math.fma(other.m01(), this.m20, other.m11() * this.m21));
        double _t27 = Math.fma(other.m22(), this.m12, Math.fma(other.m02(), this.m10, other.m12() * this.m11));
        double _t28 = Math.fma(other.m22(), this.m02, Math.fma(other.m02(), this.m00, other.m12() * this.m01));
        double _t29 = Math.fma(other.m20(), this.m12, Math.fma(other.m00(), this.m10, other.m10() * this.m11));
        double _t30 = Math.fma(other.m20(), this.m22, Math.fma(other.m00(), this.m20, other.m10() * this.m21));
        double _t31 = Math.fma(other.m20(), this.m02, Math.fma(other.m00(), this.m00, other.m10() * this.m01));
        double _t32 = Math.fma(other.m21(), this.m02, Math.fma(other.m01(), this.m00, other.m11() * this.m01));
        double _t33 = Math.fma(other.m03(), this.m20, Math.fma(other.m13(), this.m21, Math.fma(other.m23(), this.m22, this.m23)));
        double _t34 = Math.fma(other.m03(), this.m00, Math.fma(other.m13(), this.m01, Math.fma(other.m23(), this.m02, this.m03)));
        double _t35 = Math.fma(other.m03(), this.m10, Math.fma(other.m13(), this.m11, Math.fma(other.m23(), this.m12, this.m13)));
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
        d.m00 = _t56 * _t69_inv;
        d.m01 = _t59 * _t69_inv;
        d.m02 = _t60 * _t69_inv;
        d.m03 = -(Math.fma(_t33, _t60, Math.fma(_t34, _t56, _t35 * _t59)) * _t69_inv);
        d.m10 = _t61 * _t69_inv;
        d.m11 = _t62 * _t69_inv;
        d.m12 = _t63 * _t69_inv;
        d.m13 = -(Math.fma(_t33, _t63, Math.fma(_t34, _t61, _t35 * _t62)) * _t69_inv);
        d.m20 = _t57 * _t69_inv;
        d.m21 = _t64 * _t69_inv;
        d.m22 = _t65 * _t69_inv;
        d.m23 = -(Math.fma(_t33, _t65, Math.fma(_t34, _t57, _t35 * _t64)) * _t69_inv);
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Double3x4 invertProduct_identity(Double3x4R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t20 = Math.fma(other.m11(), other.m22(), -(other.m12() * other.m21()));
        double _t21 = Math.fma(other.m10(), other.m21(), -(other.m11() * other.m20()));
        double _t23 = Math.fma(other.m02(), other.m21(), -(other.m01() * other.m22()));
        double _t24 = Math.fma(other.m01(), other.m12(), -(other.m02() * other.m11()));
        double _t25 = Math.fma(other.m12(), other.m20(), -(other.m10() * other.m22()));
        double _t26 = Math.fma(other.m00(), other.m22(), -(other.m02() * other.m20()));
        double _t27 = Math.fma(other.m02(), other.m10(), -(other.m00() * other.m12()));
        double _t28 = Math.fma(other.m01(), other.m20(), -(other.m00() * other.m21()));
        double _t29 = Math.fma(other.m00(), other.m11(), -(other.m01() * other.m10()));
        double _t33 = Math.fma(other.m02(), _t21, Math.fma(other.m00(), _t20, -(other.m01() * Math.fma(other.m10(), other.m22(), -(other.m12() * other.m20())))));
        double _t33_inv = 1.0 / _t33;
        d.m00 = _t20 * _t33_inv;
        d.m01 = _t23 * _t33_inv;
        d.m02 = _t24 * _t33_inv;
        double _buf0 = -(Math.fma(other.m23(), _t24, Math.fma(other.m03(), _t20, other.m13() * _t23)) * _t33_inv);
        d.m10 = _t25 * _t33_inv;
        d.m11 = _t26 * _t33_inv;
        d.m12 = _t27 * _t33_inv;
        double _buf1 = -(Math.fma(other.m23(), _t27, Math.fma(other.m03(), _t25, other.m13() * _t26)) * _t33_inv);
        d.m20 = _t21 * _t33_inv;
        d.m21 = _t28 * _t33_inv;
        d.m22 = _t29 * _t33_inv;
        d.m23 = -(Math.fma(other.m23(), _t29, Math.fma(other.m03(), _t21, other.m13() * _t28)) * _t33_inv);
        d.m03 = _buf0;
        d.m13 = _buf1;
        d.properties = ((Double3x4Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Double3x4 invertProduct_translation(Double3x4R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t5 = other.m23() + this.m23;
        double _t6 = other.m03() + this.m03;
        double _t7 = other.m13() + this.m13;
        double _t23 = Math.fma(other.m11(), other.m22(), -(other.m12() * other.m21()));
        double _t24 = Math.fma(other.m10(), other.m21(), -(other.m11() * other.m20()));
        double _t26 = Math.fma(other.m02(), other.m21(), -(other.m01() * other.m22()));
        double _t27 = Math.fma(other.m01(), other.m12(), -(other.m02() * other.m11()));
        double _t28 = Math.fma(other.m12(), other.m20(), -(other.m10() * other.m22()));
        double _t29 = Math.fma(other.m00(), other.m22(), -(other.m02() * other.m20()));
        double _t30 = Math.fma(other.m02(), other.m10(), -(other.m00() * other.m12()));
        double _t31 = Math.fma(other.m01(), other.m20(), -(other.m00() * other.m21()));
        double _t32 = Math.fma(other.m00(), other.m11(), -(other.m01() * other.m10()));
        double _t36 = Math.fma(other.m02(), _t24, Math.fma(other.m00(), _t23, -(other.m01() * Math.fma(other.m10(), other.m22(), -(other.m12() * other.m20())))));
        double _t36_inv = 1.0 / _t36;
        d.m00 = _t23 * _t36_inv;
        d.m01 = _t26 * _t36_inv;
        d.m02 = _t27 * _t36_inv;
        d.m03 = -(Math.fma(_t5, _t27, Math.fma(_t6, _t23, _t7 * _t26)) * _t36_inv);
        d.m10 = _t28 * _t36_inv;
        d.m11 = _t29 * _t36_inv;
        d.m12 = _t30 * _t36_inv;
        d.m13 = -(Math.fma(_t5, _t30, Math.fma(_t6, _t28, _t7 * _t29)) * _t36_inv);
        d.m20 = _t24 * _t36_inv;
        d.m21 = _t31 * _t36_inv;
        d.m22 = _t32 * _t36_inv;
        d.m23 = -(Math.fma(_t5, _t32, Math.fma(_t6, _t24, _t7 * _t31)) * _t36_inv);
        d.properties = Joml.BIT_TRANSLATION & ((Double3x4Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Double3x4 invertProduct_identity_identity(Double3x4R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = 0.0;
        d.m10 = 0.0;
        d.m11 = 1.0;
        d.m12 = 0.0;
        d.m13 = 0.0;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 1.0;
        d.m23 = 0.0;
        d.properties = ((Double3x4Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Double3x4 invertProduct_identity_translation(Double3x4R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = -other.m03();
        d.m10 = 0.0;
        d.m11 = 1.0;
        d.m12 = 0.0;
        d.m13 = -other.m13();
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 1.0;
        d.m23 = -other.m23();
        d.properties = ((Double3x4Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Double3x4 invertProduct_translation_identity(Double3x4R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = -this.m03;
        d.m10 = 0.0;
        d.m11 = 1.0;
        d.m12 = 0.0;
        d.m13 = -this.m13;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 1.0;
        d.m23 = -this.m23;
        d.properties = Joml.BIT_TRANSLATION & ((Double3x4Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Double3x4 invertProduct_translation_translation(Double3x4R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = -(other.m03() + this.m03);
        d.m10 = 0.0;
        d.m11 = 1.0;
        d.m12 = 0.0;
        d.m13 = -(other.m13() + this.m13);
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 1.0;
        d.m23 = -(other.m23() + this.m23);
        d.properties = Joml.BIT_TRANSLATION & ((Double3x4Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Double3x4 invertProduct_orthogonal_identity(Double3x4R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = this.m00;
        double _buf1 = this.m10;
        double _buf2 = this.m20;
        double _buf3 = Math.fma(-this.m20, this.m23, Math.fma(-this.m10, this.m13, -(this.m00 * this.m03)));
        d.m10 = this.m01;
        double _buf4 = this.m11;
        double _buf5 = this.m21;
        double _buf6 = Math.fma(-this.m21, this.m23, Math.fma(-this.m11, this.m13, -(this.m01 * this.m03)));
        d.m20 = this.m02;
        d.m21 = this.m12;
        double _buf7 = this.m22;
        d.m23 = Math.fma(-this.m22, this.m23, Math.fma(-this.m12, this.m13, -(this.m02 * this.m03)));
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.m03 = _buf3;
        d.m11 = _buf4;
        d.m12 = _buf5;
        d.m13 = _buf6;
        d.m22 = _buf7;
        d.properties = Joml.BIT_ORTHOGONAL & ((Double3x4Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Double3x4 invertProduct_orthogonal_translation(Double3x4R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = this.m00;
        double _buf1 = this.m10;
        double _buf2 = this.m20;
        double _buf3 = Math.fma(-this.m00, this.m03, Math.fma(-this.m10, this.m13, Math.fma(-this.m20, this.m23, -other.m03())));
        d.m10 = this.m01;
        double _buf4 = this.m11;
        double _buf5 = this.m21;
        double _buf6 = Math.fma(-this.m01, this.m03, Math.fma(-this.m11, this.m13, Math.fma(-this.m21, this.m23, -other.m13())));
        d.m20 = this.m02;
        d.m21 = this.m12;
        double _buf7 = this.m22;
        d.m23 = Math.fma(-this.m02, this.m03, Math.fma(-this.m12, this.m13, Math.fma(-this.m22, this.m23, -other.m23())));
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.m03 = _buf3;
        d.m11 = _buf4;
        d.m12 = _buf5;
        d.m13 = _buf6;
        d.m22 = _buf7;
        d.properties = Joml.BIT_ORTHOGONAL & ((Double3x4Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Double3x4 invertProduct_general_identity(Double3x4R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t20 = Math.fma(this.m11, this.m22, -(this.m12 * this.m21));
        double _t21 = Math.fma(this.m10, this.m21, -(this.m11 * this.m20));
        double _t23 = Math.fma(this.m02, this.m21, -(this.m01 * this.m22));
        double _t24 = Math.fma(this.m01, this.m12, -(this.m02 * this.m11));
        double _t25 = Math.fma(this.m12, this.m20, -(this.m10 * this.m22));
        double _t26 = Math.fma(this.m00, this.m22, -(this.m02 * this.m20));
        double _t27 = Math.fma(this.m02, this.m10, -(this.m00 * this.m12));
        double _t28 = Math.fma(this.m01, this.m20, -(this.m00 * this.m21));
        double _t29 = Math.fma(this.m00, this.m11, -(this.m01 * this.m10));
        double _t33 = Math.fma(this.m02, _t21, Math.fma(this.m00, _t20, -(this.m01 * Math.fma(this.m10, this.m22, -(this.m12 * this.m20)))));
        double _t33_inv = 1.0 / _t33;
        d.m00 = _t20 * _t33_inv;
        d.m01 = _t23 * _t33_inv;
        d.m02 = _t24 * _t33_inv;
        double _buf0 = -(Math.fma(this.m23, _t24, Math.fma(this.m03, _t20, this.m13 * _t23)) * _t33_inv);
        d.m10 = _t25 * _t33_inv;
        d.m11 = _t26 * _t33_inv;
        d.m12 = _t27 * _t33_inv;
        double _buf1 = -(Math.fma(this.m23, _t27, Math.fma(this.m03, _t25, this.m13 * _t26)) * _t33_inv);
        d.m20 = _t21 * _t33_inv;
        d.m21 = _t28 * _t33_inv;
        d.m22 = _t29 * _t33_inv;
        d.m23 = -(Math.fma(this.m23, _t29, Math.fma(this.m03, _t21, this.m13 * _t28)) * _t33_inv);
        d.m03 = _buf0;
        d.m13 = _buf1;
        d.properties = Joml.BIT_AFFINE & ((Double3x4Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Double3x4 invertProduct_general_translation(Double3x4R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t23 = Math.fma(this.m11, this.m22, -(this.m12 * this.m21));
        double _t24 = Math.fma(this.m10, this.m21, -(this.m11 * this.m20));
        double _t26 = Math.fma(this.m02, this.m21, -(this.m01 * this.m22));
        double _t27 = Math.fma(this.m01, this.m12, -(this.m02 * this.m11));
        double _t28 = Math.fma(this.m12, this.m20, -(this.m10 * this.m22));
        double _t29 = Math.fma(this.m00, this.m22, -(this.m02 * this.m20));
        double _t30 = Math.fma(this.m02, this.m10, -(this.m00 * this.m12));
        double _t31 = Math.fma(this.m01, this.m20, -(this.m00 * this.m21));
        double _t32 = Math.fma(this.m00, this.m11, -(this.m01 * this.m10));
        double _t38 = Math.fma(other.m03(), this.m20, Math.fma(other.m13(), this.m21, Math.fma(other.m23(), this.m22, this.m23)));
        double _t39 = Math.fma(other.m03(), this.m00, Math.fma(other.m13(), this.m01, Math.fma(other.m23(), this.m02, this.m03)));
        double _t40 = Math.fma(other.m03(), this.m10, Math.fma(other.m13(), this.m11, Math.fma(other.m23(), this.m12, this.m13)));
        double _t42 = Math.fma(this.m02, _t24, Math.fma(this.m00, _t23, -(this.m01 * Math.fma(this.m10, this.m22, -(this.m12 * this.m20)))));
        double _t42_inv = 1.0 / _t42;
        d.m00 = _t23 * _t42_inv;
        d.m01 = _t26 * _t42_inv;
        d.m02 = _t27 * _t42_inv;
        d.m03 = -(Math.fma(_t38, _t27, Math.fma(_t39, _t23, _t40 * _t26)) * _t42_inv);
        d.m10 = _t28 * _t42_inv;
        d.m11 = _t29 * _t42_inv;
        d.m12 = _t30 * _t42_inv;
        d.m13 = -(Math.fma(_t38, _t30, Math.fma(_t39, _t28, _t40 * _t29)) * _t42_inv);
        d.m20 = _t24 * _t42_inv;
        d.m21 = _t31 * _t42_inv;
        d.m22 = _t32 * _t42_inv;
        d.m23 = -(Math.fma(_t38, _t32, Math.fma(_t39, _t24, _t40 * _t31)) * _t42_inv);
        d.properties = Joml.BIT_AFFINE & ((Double3x4Impl) other).properties;
        return d;
    }


    /**
     * Compute the inverse of the product of this matrix and {@code other}, i.e.
     * {@code (this * other)^-1} and store the result in {@code dest}.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 invertProduct(Double3x4R other, @Mutated Double3x4 dest) {
        int p = this.properties;
        int q = ((Double3x4Impl) other).properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invertProduct_identity_identity(other, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invertProduct_identity_translation(other, dest);
            return invertProduct_identity(other, dest);
        }
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invertProduct_translation_identity(other, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invertProduct_translation_translation(other, dest);
            return invertProduct_translation(other, dest);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invertProduct_orthogonal_identity(other, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invertProduct_orthogonal_translation(other, dest);
            return invertProduct_general(other, dest, Joml.BIT_ORTHOGONAL & q);
        }
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invertProduct_general_identity(other, dest);
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invertProduct_general_translation(other, dest);
        return invertProduct_general(other, dest, Joml.BIT_AFFINE & q);
    }


    /**
     * Compute the inverse of the product of this matrix and {@code other}, i.e.
     * {@code (this * other)^-1}.
     *
     * @param other the other matrix
     * @return this
     */
    @Mutated public Double3x4 invertProduct(Double3x4R other) {
        if (Joml.RETURN_NEW) return invertProduct(other, Joml.double3x4());
        int p = this.properties;
        int q = ((Double3x4Impl) other).properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invertProduct_identity_identity(other, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invertProduct_identity_translation(other, this);
            return invertProduct_identity(other, this);
        }
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invertProduct_translation_identity(other, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invertProduct_translation_translation(other, this);
            return invertProduct_translation(other, this);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invertProduct_orthogonal_identity(other, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invertProduct_orthogonal_translation(other, this);
            return invertProduct_general(other, this, Joml.BIT_ORTHOGONAL & q);
        }
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invertProduct_general_identity(other, this);
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invertProduct_general_translation(other, this);
        return invertProduct_general(other, this, Joml.BIT_AFFINE & q);
    }


    /**
     * Compute the inverse of the product of this matrix and ({@code m00}, {@code m01}, {@code m02},
     * {@code m03}, {@code m10}, {@code m11}, {@code m12}, {@code m13}, {@code m20}, {@code m21},
     * {@code m22}, {@code m23}) and store the result in {@code dest}.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m03 the element in row 0, column 3 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m13 the element in row 1, column 3 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @param m23 the element in row 2, column 3 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 invertProduct(double m00, double m01, double m02, double m03, double m10, double m11, double m12, double m13, double m20, double m21, double m22, double m23, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t24 = Math.fma(m21, this.m12, Math.fma(m01, this.m10, m11 * this.m11));
        double _t25 = Math.fma(m22, this.m22, Math.fma(m02, this.m20, m12 * this.m21));
        double _t26 = Math.fma(m21, this.m22, Math.fma(m01, this.m20, m11 * this.m21));
        double _t27 = Math.fma(m22, this.m12, Math.fma(m02, this.m10, m12 * this.m11));
        double _t28 = Math.fma(m22, this.m02, Math.fma(m02, this.m00, m12 * this.m01));
        double _t29 = Math.fma(m20, this.m12, Math.fma(m00, this.m10, m10 * this.m11));
        double _t30 = Math.fma(m20, this.m22, Math.fma(m00, this.m20, m10 * this.m21));
        double _t31 = Math.fma(m20, this.m02, Math.fma(m00, this.m00, m10 * this.m01));
        double _t32 = Math.fma(m21, this.m02, Math.fma(m01, this.m00, m11 * this.m01));
        double _t33 = Math.fma(m03, this.m20, Math.fma(m13, this.m21, Math.fma(m23, this.m22, this.m23)));
        double _t34 = Math.fma(m03, this.m00, Math.fma(m13, this.m01, Math.fma(m23, this.m02, this.m03)));
        double _t35 = Math.fma(m03, this.m10, Math.fma(m13, this.m11, Math.fma(m23, this.m12, this.m13)));
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
        d.m00 = _t56 * _t69_inv;
        d.m01 = _t59 * _t69_inv;
        d.m02 = _t60 * _t69_inv;
        d.m03 = -(Math.fma(_t33, _t60, Math.fma(_t34, _t56, _t35 * _t59)) * _t69_inv);
        d.m10 = _t61 * _t69_inv;
        d.m11 = _t62 * _t69_inv;
        d.m12 = _t63 * _t69_inv;
        d.m13 = -(Math.fma(_t33, _t63, Math.fma(_t34, _t61, _t35 * _t62)) * _t69_inv);
        d.m20 = _t57 * _t69_inv;
        d.m21 = _t64 * _t69_inv;
        d.m22 = _t65 * _t69_inv;
        d.m23 = -(Math.fma(_t33, _t65, Math.fma(_t34, _t57, _t35 * _t64)) * _t69_inv);
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code transpose}, specialized by runtime matrix properties; reached only
     * through the public {@code transpose} dispatcher.
     */
    private Double4x3 transpose_identity(@Mutated Double4x3 dest) {
        Double4x3Impl d = (Double4x3Impl) dest;
        d.m00 = 1.0;
        d.m10 = 0.0;
        d.m20 = 0.0;
        d.m30 = 0.0;
        d.m01 = 0.0;
        d.m11 = 1.0;
        d.m21 = 0.0;
        d.m31 = 0.0;
        d.m02 = 0.0;
        d.m12 = 0.0;
        d.m22 = 1.0;
        d.m32 = 0.0;
        return d;
    }


    /**
     * Private body of {@code transpose}, specialized by runtime matrix properties; reached only
     * through the public {@code transpose} dispatcher.
     */
    private Double4x3 transpose_translation(@Mutated Double4x3 dest) {
        Double4x3Impl d = (Double4x3Impl) dest;
        d.m00 = 1.0;
        double _buf0 = 0.0;
        d.m20 = 0.0;
        d.m30 = this.m03;
        d.m01 = 0.0;
        d.m11 = 1.0;
        double _buf1 = 0.0;
        d.m31 = this.m13;
        d.m02 = 0.0;
        d.m12 = 0.0;
        d.m22 = 1.0;
        d.m32 = this.m23;
        d.m10 = _buf0;
        d.m21 = _buf1;
        return d;
    }


    /**
     * Private body of {@code transpose}, specialized by runtime matrix properties; reached only
     * through the public {@code transpose} dispatcher.
     */
    private Double4x3 transpose_general(@Mutated Double4x3 dest) {
        Double4x3Impl d = (Double4x3Impl) dest;
        d.m00 = this.m00;
        double _buf0 = this.m01;
        double _buf1 = this.m02;
        double _buf2 = this.m03;
        d.m01 = this.m10;
        d.m11 = this.m11;
        double _buf3 = this.m12;
        double _buf4 = this.m13;
        d.m02 = this.m20;
        d.m12 = this.m21;
        d.m22 = this.m22;
        d.m32 = this.m23;
        d.m10 = _buf0;
        d.m20 = _buf1;
        d.m30 = _buf2;
        d.m21 = _buf3;
        d.m31 = _buf4;
        return d;
    }


    /**
     * Transpose this matrix and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4x3 transpose(@Mutated Double4x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return transpose_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return transpose_translation(dest);
        return transpose_general(dest);
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Double3x4 add_general(Double3x4R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = other.m00() + this.m00;
        d.m01 = other.m01() + this.m01;
        d.m02 = other.m02() + this.m02;
        d.m03 = other.m03() + this.m03;
        d.m10 = other.m10() + this.m10;
        d.m11 = other.m11() + this.m11;
        d.m12 = other.m12() + this.m12;
        d.m13 = other.m13() + this.m13;
        d.m20 = other.m20() + this.m20;
        d.m21 = other.m21() + this.m21;
        d.m22 = other.m22() + this.m22;
        d.m23 = other.m23() + this.m23;
        d.properties = Joml.BIT_AFFINE & ((Double3x4Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Double3x4 add_identity(Double3x4R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 1.0 + other.m00();
        d.m01 = other.m01();
        d.m02 = other.m02();
        d.m03 = other.m03();
        d.m10 = other.m10();
        d.m11 = 1.0 + other.m11();
        d.m12 = other.m12();
        d.m13 = other.m13();
        d.m20 = other.m20();
        d.m21 = other.m21();
        d.m22 = 1.0 + other.m22();
        d.m23 = other.m23();
        d.properties = Joml.BIT_AFFINE & ((Double3x4Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Double3x4 add_translation(Double3x4R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 1.0 + other.m00();
        d.m01 = other.m01();
        d.m02 = other.m02();
        d.m03 = other.m03() + this.m03;
        d.m10 = other.m10();
        d.m11 = 1.0 + other.m11();
        d.m12 = other.m12();
        d.m13 = other.m13() + this.m13;
        d.m20 = other.m20();
        d.m21 = other.m21();
        d.m22 = 1.0 + other.m22();
        d.m23 = other.m23() + this.m23;
        d.properties = Joml.BIT_AFFINE & ((Double3x4Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Double3x4 add_identity_identity(Double3x4R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 2.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = 0.0;
        d.m10 = 0.0;
        d.m11 = 2.0;
        d.m12 = 0.0;
        d.m13 = 0.0;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 2.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_AFFINE & ((Double3x4Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Double3x4 add_identity_translation(Double3x4R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 2.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = other.m03();
        d.m10 = 0.0;
        d.m11 = 2.0;
        d.m12 = 0.0;
        d.m13 = other.m13();
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 2.0;
        d.m23 = other.m23();
        d.properties = Joml.BIT_AFFINE & ((Double3x4Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Double3x4 add_translation_identity(Double3x4R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 2.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = this.m03;
        d.m10 = 0.0;
        d.m11 = 2.0;
        d.m12 = 0.0;
        d.m13 = this.m13;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 2.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE & ((Double3x4Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Double3x4 add_translation_translation(Double3x4R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 2.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = other.m03() + this.m03;
        d.m10 = 0.0;
        d.m11 = 2.0;
        d.m12 = 0.0;
        d.m13 = other.m13() + this.m13;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 2.0;
        d.m23 = other.m23() + this.m23;
        d.properties = Joml.BIT_AFFINE & ((Double3x4Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Double3x4 add_orthogonal_identity(Double3x4R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 1.0 + this.m00;
        d.m01 = this.m01;
        d.m02 = this.m02;
        d.m03 = this.m03;
        d.m10 = this.m10;
        d.m11 = 1.0 + this.m11;
        d.m12 = this.m12;
        d.m13 = this.m13;
        d.m20 = this.m20;
        d.m21 = this.m21;
        d.m22 = 1.0 + this.m22;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE & ((Double3x4Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Double3x4 add_orthogonal_translation(Double3x4R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 1.0 + this.m00;
        d.m01 = this.m01;
        d.m02 = this.m02;
        d.m03 = other.m03() + this.m03;
        d.m10 = this.m10;
        d.m11 = 1.0 + this.m11;
        d.m12 = this.m12;
        d.m13 = other.m13() + this.m13;
        d.m20 = this.m20;
        d.m21 = this.m21;
        d.m22 = 1.0 + this.m22;
        d.m23 = other.m23() + this.m23;
        d.properties = Joml.BIT_AFFINE & ((Double3x4Impl) other).properties;
        return d;
    }


    /**
     * Add {@code other} to this matrix and store the result in {@code dest}.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 add(Double3x4R other, @Mutated Double3x4 dest) {
        int p = this.properties;
        int q = ((Double3x4Impl) other).properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return add_identity_identity(other, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return add_identity_translation(other, dest);
            return add_identity(other, dest);
        }
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return add_translation_identity(other, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return add_translation_translation(other, dest);
            return add_translation(other, dest);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return add_orthogonal_identity(other, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return add_orthogonal_translation(other, dest);
            return add_general(other, dest);
        }
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return add_orthogonal_identity(other, dest);
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return add_orthogonal_translation(other, dest);
        return add_general(other, dest);
    }


    /**
     * Add {@code other} to this matrix.
     *
     * @param other the other matrix
     * @return this
     */
    @Mutated public Double3x4 add(Double3x4R other) {
        if (Joml.RETURN_NEW) return add(other, Joml.double3x4());
        int p = this.properties;
        int q = ((Double3x4Impl) other).properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return add_identity_identity(other, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return add_identity_translation(other, this);
            return add_identity(other, this);
        }
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return add_translation_identity(other, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return add_translation_translation(other, this);
            return add_translation(other, this);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return add_orthogonal_identity(other, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return add_orthogonal_translation(other, this);
            return add_general(other, this);
        }
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return add_orthogonal_identity(other, this);
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return add_orthogonal_translation(other, this);
        return add_general(other, this);
    }


    /**
     * Add ({@code m00}, {@code m01}, {@code m02}, {@code m03}, {@code m10}, {@code m11},
     * {@code m12}, {@code m13}, {@code m20}, {@code m21}, {@code m22}, {@code m23}) to this matrix
     * and store the result in {@code dest}.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m03 the element in row 0, column 3 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m13 the element in row 1, column 3 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @param m23 the element in row 2, column 3 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 add(double m00, double m01, double m02, double m03, double m10, double m11, double m12, double m13, double m20, double m21, double m22, double m23, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = m00 + this.m00;
        d.m01 = m01 + this.m01;
        d.m02 = m02 + this.m02;
        d.m03 = m03 + this.m03;
        d.m10 = m10 + this.m10;
        d.m11 = m11 + this.m11;
        d.m12 = m12 + this.m12;
        d.m13 = m13 + this.m13;
        d.m20 = m20 + this.m20;
        d.m21 = m21 + this.m21;
        d.m22 = m22 + this.m22;
        d.m23 = m23 + this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code negate}, specialized by runtime matrix properties; reached only
     * through the public {@code negate} dispatcher.
     */
    private Double3x4 negate_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = 0.0;
        d.m10 = 0.0;
        d.m11 = -1.0;
        d.m12 = 0.0;
        d.m13 = 0.0;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = -1.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code negate}, specialized by runtime matrix properties;
     * reached only through the public {@code negate} dispatcher.
     */
    private Double3x4 negate_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -1.0;
        d.m11 = -1.0;
        d.m22 = -1.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code negate}, specialized by runtime matrix properties; reached only
     * through the public {@code negate} dispatcher.
     */
    private Double3x4 negate_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = -this.m03;
        d.m10 = 0.0;
        d.m11 = -1.0;
        d.m12 = 0.0;
        d.m13 = -this.m13;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = -1.0;
        d.m23 = -this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code negate}, specialized by runtime matrix properties;
     * reached only through the public {@code negate} dispatcher.
     */
    private Double3x4 negate_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -1.0;
        d.m03 = -this.m03;
        d.m11 = -1.0;
        d.m13 = -this.m13;
        d.m22 = -1.0;
        d.m23 = -this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code negate}, specialized by runtime matrix properties; reached only
     * through the public {@code negate} dispatcher.
     */
    private Double3x4 negate_general(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -this.m00;
        d.m01 = -this.m01;
        d.m02 = -this.m02;
        d.m03 = -this.m03;
        d.m10 = -this.m10;
        d.m11 = -this.m11;
        d.m12 = -this.m12;
        d.m13 = -this.m13;
        d.m20 = -this.m20;
        d.m21 = -this.m21;
        d.m22 = -this.m22;
        d.m23 = -this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Negate this matrix and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 negate(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return negate_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return negate_translation(dest);
        return negate_general(dest);
    }


    /**
     * Negate this matrix.
     *
     * @return this
     */
    @Mutated public Double3x4 negate() {
        if (Joml.RETURN_NEW) return negate(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return negate_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return negate_translation_self(this);
        return negate_general(this);
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Double3x4 sub_general(Double3x4R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = this.m00 - other.m00();
        d.m01 = this.m01 - other.m01();
        d.m02 = this.m02 - other.m02();
        d.m03 = this.m03 - other.m03();
        d.m10 = this.m10 - other.m10();
        d.m11 = this.m11 - other.m11();
        d.m12 = this.m12 - other.m12();
        d.m13 = this.m13 - other.m13();
        d.m20 = this.m20 - other.m20();
        d.m21 = this.m21 - other.m21();
        d.m22 = this.m22 - other.m22();
        d.m23 = this.m23 - other.m23();
        d.properties = Joml.BIT_AFFINE & ((Double3x4Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Double3x4 sub_identity(Double3x4R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 1.0 - other.m00();
        d.m01 = -other.m01();
        d.m02 = -other.m02();
        d.m03 = -other.m03();
        d.m10 = -other.m10();
        d.m11 = 1.0 - other.m11();
        d.m12 = -other.m12();
        d.m13 = -other.m13();
        d.m20 = -other.m20();
        d.m21 = -other.m21();
        d.m22 = 1.0 - other.m22();
        d.m23 = -other.m23();
        d.properties = Joml.BIT_AFFINE & ((Double3x4Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Double3x4 sub_identity_identity(Double3x4R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = 0.0;
        d.m10 = 0.0;
        d.m11 = 0.0;
        d.m12 = 0.0;
        d.m13 = 0.0;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 0.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_AFFINE & ((Double3x4Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Double3x4 sub_identity_translation(Double3x4R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = -other.m03();
        d.m10 = 0.0;
        d.m11 = 0.0;
        d.m12 = 0.0;
        d.m13 = -other.m13();
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 0.0;
        d.m23 = -other.m23();
        d.properties = Joml.BIT_AFFINE & ((Double3x4Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Double3x4 sub_translation_identity(Double3x4R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = this.m03;
        d.m10 = 0.0;
        d.m11 = 0.0;
        d.m12 = 0.0;
        d.m13 = this.m13;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE & ((Double3x4Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Double3x4 sub_translation_translation(Double3x4R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = this.m03 - other.m03();
        d.m10 = 0.0;
        d.m11 = 0.0;
        d.m12 = 0.0;
        d.m13 = this.m13 - other.m13();
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 0.0;
        d.m23 = this.m23 - other.m23();
        d.properties = Joml.BIT_AFFINE & ((Double3x4Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Double3x4 sub_orthogonal_identity(Double3x4R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -1.0 + this.m00;
        d.m01 = this.m01;
        d.m02 = this.m02;
        d.m03 = this.m03;
        d.m10 = this.m10;
        d.m11 = -1.0 + this.m11;
        d.m12 = this.m12;
        d.m13 = this.m13;
        d.m20 = this.m20;
        d.m21 = this.m21;
        d.m22 = -1.0 + this.m22;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE & ((Double3x4Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Double3x4 sub_orthogonal_translation(Double3x4R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -1.0 + this.m00;
        d.m01 = this.m01;
        d.m02 = this.m02;
        d.m03 = this.m03 - other.m03();
        d.m10 = this.m10;
        d.m11 = -1.0 + this.m11;
        d.m12 = this.m12;
        d.m13 = this.m13 - other.m13();
        d.m20 = this.m20;
        d.m21 = this.m21;
        d.m22 = -1.0 + this.m22;
        d.m23 = this.m23 - other.m23();
        d.properties = Joml.BIT_AFFINE & ((Double3x4Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Double3x4 sub_general_identity(Double3x4R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = this.m00 - 1.0;
        d.m01 = this.m01;
        d.m02 = this.m02;
        d.m03 = this.m03;
        d.m10 = this.m10;
        d.m11 = this.m11 - 1.0;
        d.m12 = this.m12;
        d.m13 = this.m13;
        d.m20 = this.m20;
        d.m21 = this.m21;
        d.m22 = this.m22 - 1.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE & ((Double3x4Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Double3x4 sub_general_translation(Double3x4R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = this.m00 - 1.0;
        d.m01 = this.m01;
        d.m02 = this.m02;
        d.m03 = this.m03 - other.m03();
        d.m10 = this.m10;
        d.m11 = this.m11 - 1.0;
        d.m12 = this.m12;
        d.m13 = this.m13 - other.m13();
        d.m20 = this.m20;
        d.m21 = this.m21;
        d.m22 = this.m22 - 1.0;
        d.m23 = this.m23 - other.m23();
        d.properties = Joml.BIT_AFFINE & ((Double3x4Impl) other).properties;
        return d;
    }


    /**
     * Subtract {@code other} from this matrix and store the result in {@code dest}.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 sub(Double3x4R other, @Mutated Double3x4 dest) {
        int p = this.properties;
        int q = ((Double3x4Impl) other).properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return sub_identity_identity(other, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return sub_identity_translation(other, dest);
            return sub_identity(other, dest);
        }
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return sub_translation_identity(other, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return sub_translation_translation(other, dest);
            return sub_general(other, dest);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return sub_orthogonal_identity(other, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return sub_orthogonal_translation(other, dest);
            return sub_general(other, dest);
        }
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return sub_general_identity(other, dest);
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return sub_general_translation(other, dest);
        return sub_general(other, dest);
    }


    /**
     * Subtract {@code other} from this matrix.
     *
     * @param other the other matrix
     * @return this
     */
    @Mutated public Double3x4 sub(Double3x4R other) {
        if (Joml.RETURN_NEW) return sub(other, Joml.double3x4());
        int p = this.properties;
        int q = ((Double3x4Impl) other).properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return sub_identity_identity(other, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return sub_identity_translation(other, this);
            return sub_identity(other, this);
        }
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return sub_translation_identity(other, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return sub_translation_translation(other, this);
            return sub_general(other, this);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return sub_orthogonal_identity(other, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return sub_orthogonal_translation(other, this);
            return sub_general(other, this);
        }
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return sub_general_identity(other, this);
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return sub_general_translation(other, this);
        return sub_general(other, this);
    }


    /**
     * Subtract ({@code m00}, {@code m01}, {@code m02}, {@code m03}, {@code m10}, {@code m11},
     * {@code m12}, {@code m13}, {@code m20}, {@code m21}, {@code m22}, {@code m23}) from this
     * matrix and store the result in {@code dest}.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m03 the element in row 0, column 3 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m13 the element in row 1, column 3 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @param m23 the element in row 2, column 3 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 sub(double m00, double m01, double m02, double m03, double m10, double m11, double m12, double m13, double m20, double m21, double m22, double m23, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = this.m00 - m00;
        d.m01 = this.m01 - m01;
        d.m02 = this.m02 - m02;
        d.m03 = this.m03 - m03;
        d.m10 = this.m10 - m10;
        d.m11 = this.m11 - m11;
        d.m12 = this.m12 - m12;
        d.m13 = this.m13 - m13;
        d.m20 = this.m20 - m20;
        d.m21 = this.m21 - m21;
        d.m22 = this.m22 - m22;
        d.m23 = this.m23 - m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Set this matrix to the given values.
     *
     * @param v the matrix
     * @return this
     */
    @Mutated public Double3x4 set(Double3x4R v) {
        this.m00 = v.m00();
        this.m01 = v.m01();
        this.m02 = v.m02();
        this.m03 = v.m03();
        this.m10 = v.m10();
        this.m11 = v.m11();
        this.m12 = v.m12();
        this.m13 = v.m13();
        this.m20 = v.m20();
        this.m21 = v.m21();
        this.m22 = v.m22();
        this.m23 = v.m23();
        this.properties = ((Double3x4Impl) v).properties;
        return this;
    }


    /**
     * Set this matrix to the given values.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m03 the element in row 0, column 3 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m13 the element in row 1, column 3 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @param m23 the element in row 2, column 3 of the matrix
     * @return this
     */
    @Mutated public Double3x4 set(double m00, double m01, double m02, double m03, double m10, double m11, double m12, double m13, double m20, double m21, double m22, double m23) {
        this.m00 = m00;
        this.m01 = m01;
        this.m02 = m02;
        this.m03 = m03;
        this.m10 = m10;
        this.m11 = m11;
        this.m12 = m12;
        this.m13 = m13;
        this.m20 = m20;
        this.m21 = m21;
        this.m22 = m22;
        this.m23 = m23;
        this.properties = determineProperties();
        return this;
    }


    /**
     * Set this matrix to the given 3x3 matrix, copying the overlapping cells and filling the rest
     * with identity.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated public Double3x4 set(Double3x3R m) {
        this.m00 = m.m00();
        this.m01 = m.m01();
        this.m02 = m.m02();
        this.m03 = 0.0;
        this.m10 = m.m10();
        this.m11 = m.m11();
        this.m12 = m.m12();
        this.m13 = 0.0;
        this.m20 = m.m20();
        this.m21 = m.m21();
        this.m22 = m.m22();
        this.m23 = 0.0;
        this.properties = determineProperties();
        return this;
    }


    /**
     * Set this matrix to the given 4x4 matrix, copying the overlapping cells and dropping the rest.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated public Double3x4 set(Double4x4R m) {
        this.m00 = m.m00();
        this.m01 = m.m01();
        this.m02 = m.m02();
        this.m03 = m.m03();
        this.m10 = m.m10();
        this.m11 = m.m11();
        this.m12 = m.m12();
        this.m13 = m.m13();
        this.m20 = m.m20();
        this.m21 = m.m21();
        this.m22 = m.m22();
        this.m23 = m.m23();
        this.properties = determineProperties();
        return this;
    }


    /**
     * Set the translation of this matrix, leaving every other element untouched.
     * <p>
     * Only the first three elements of the last column are written, so a square matrix keeps the
     * projective element that sits below them. Unlike {@code translate}, this overwrites the
     * translation instead of composing a translation onto the existing transformation.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     *
     * @param t the translation offsets
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 withTranslation(Double3R t, @Mutated Double3x4 dest) {
        return withTranslation(t.x(), t.y(), t.z(), dest);
    }


    /**
     * Set the translation of this matrix, leaving every other element untouched.
     * <p>
     * Only the first three elements of the last column are written, so a square matrix keeps the
     * projective element that sits below them. Unlike {@code translate}, this overwrites the
     * translation instead of composing a translation onto the existing transformation.
     *
     * @param t the translation offsets
     * @return this
     */
    public @Mutated Double3x4 withTranslation(Double3R t) {
        return withTranslation(t.x(), t.y(), t.z());
    }


    /**
     * Private body of {@code withTranslation}, specialized by runtime matrix properties; reached
     * only through the public {@code withTranslation} dispatcher.
     */
    private Double3x4 withTranslation_identity(double tX, double tY, double tZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = tX;
        d.m10 = 0.0;
        d.m11 = 1.0;
        d.m12 = 0.0;
        d.m13 = tY;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 1.0;
        d.m23 = tZ;
        d.properties = Joml.BIT_TRANSLATION;
        return d;
    }


    /**
     * Private in-place self-form body of {@code withTranslation}, specialized by runtime matrix
     * properties; reached only through the public {@code withTranslation} dispatcher.
     */
    private Double3x4 withTranslation_identity_self(double tX, double tY, double tZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m03 = tX;
        d.m13 = tY;
        d.m23 = tZ;
        d.properties = Joml.BIT_TRANSLATION;
        return d;
    }


    /**
     * Private body of {@code withTranslation}, specialized by runtime matrix properties; reached
     * only through the public {@code withTranslation} dispatcher.
     */
    private Double3x4 withTranslation_orthogonal(double tX, double tY, double tZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = this.m00;
        d.m01 = this.m01;
        d.m02 = this.m02;
        d.m03 = tX;
        d.m10 = this.m10;
        d.m11 = this.m11;
        d.m12 = this.m12;
        d.m13 = tY;
        d.m20 = this.m20;
        d.m21 = this.m21;
        d.m22 = this.m22;
        d.m23 = tZ;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code withTranslation}, specialized by runtime matrix properties; reached
     * only through the public {@code withTranslation} dispatcher.
     */
    private Double3x4 withTranslation_general(double tX, double tY, double tZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = this.m00;
        d.m01 = this.m01;
        d.m02 = this.m02;
        d.m03 = tX;
        d.m10 = this.m10;
        d.m11 = this.m11;
        d.m12 = this.m12;
        d.m13 = tY;
        d.m20 = this.m20;
        d.m21 = this.m21;
        d.m22 = this.m22;
        d.m23 = tZ;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Set the translation of this matrix, leaving every other element untouched.
     * <p>
     * Only the first three elements of the last column are written, so a square matrix keeps the
     * projective element that sits below them. Unlike {@code translate}, this overwrites the
     * translation instead of composing a translation onto the existing transformation.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     *
     * @param tX the {@code x} component of the translation offsets {@code (tX, tY, tZ)}
     * @param tY the {@code y} component of the translation offsets {@code (tX, tY, tZ)}
     * @param tZ the {@code z} component of the translation offsets {@code (tX, tY, tZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 withTranslation(double tX, double tY, double tZ, @Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return withTranslation_identity(tX, tY, tZ, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return withTranslation_orthogonal(tX, tY, tZ, dest);
        return withTranslation_general(tX, tY, tZ, dest);
    }


    /**
     * Set the translation of this matrix, leaving every other element untouched.
     * <p>
     * Only the first three elements of the last column are written, so a square matrix keeps the
     * projective element that sits below them. Unlike {@code translate}, this overwrites the
     * translation instead of composing a translation onto the existing transformation.
     *
     * @param tX the {@code x} component of the translation offsets {@code (tX, tY, tZ)}
     * @param tY the {@code y} component of the translation offsets {@code (tX, tY, tZ)}
     * @param tZ the {@code z} component of the translation offsets {@code (tX, tY, tZ)}
     * @return this
     */
    @Mutated public Double3x4 withTranslation(double tX, double tY, double tZ) {
        if (Joml.RETURN_NEW) return withTranslation(tX, tY, tZ, Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return withTranslation_identity_self(tX, tY, tZ, this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return withTranslation_orthogonal(tX, tY, tZ, this);
        return withTranslation_general(tX, tY, tZ, this);
    }


    /**
     * Convert this matrix to {@code float} precision and store the result in {@code dest}.
     * <p>
     * The conversion may lose precision or range.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3x4 toFloat(@Mutated Float3x4 dest) {
        Float3x4Impl d = (Float3x4Impl) dest;
        d.m00 = (float) (this.m00);
        d.m01 = (float) (this.m01);
        d.m02 = (float) (this.m02);
        d.m03 = (float) (this.m03);
        d.m10 = (float) (this.m10);
        d.m11 = (float) (this.m11);
        d.m12 = (float) (this.m12);
        d.m13 = (float) (this.m13);
        d.m20 = (float) (this.m20);
        d.m21 = (float) (this.m21);
        d.m22 = (float) (this.m22);
        d.m23 = (float) (this.m23);
        d.properties = this.properties;
        return d;
    }


    /**
     * Set this matrix to the given rigid transform's {@code T * R} composition.
     *
     * @param r the rigid transform (whose rotation must be a unit quaternion)
     * @return this
     */
    public @Mutated Double3x4 makeFromRigid(DoubleRigidR r) {
        return makeFromRigid(r.tX(), r.tY(), r.tZ(), r.rX(), r.rY(), r.rZ(), r.rW());
    }


    /**
     * Set this matrix to the given rigid transform's {@code T * R} composition.
     *
     * @param rTX the {@code tX} component of the rigid transform
     *        {@code (rTX, rTY, rTZ, rRX, rRY, rRZ, rRW)}
     * @param rTY the {@code tY} component of the rigid transform
     *        {@code (rTX, rTY, rTZ, rRX, rRY, rRZ, rRW)}
     * @param rTZ the {@code tZ} component of the rigid transform
     *        {@code (rTX, rTY, rTZ, rRX, rRY, rRZ, rRW)}
     * @param rRX the {@code rX} component of the rigid transform
     *        {@code (rTX, rTY, rTZ, rRX, rRY, rRZ, rRW)} (the rotation quaternion must have unit
     *        length)
     * @param rRY the {@code rY} component of the rigid transform
     *        {@code (rTX, rTY, rTZ, rRX, rRY, rRZ, rRW)} (the rotation quaternion must have unit
     *        length)
     * @param rRZ the {@code rZ} component of the rigid transform
     *        {@code (rTX, rTY, rTZ, rRX, rRY, rRZ, rRW)} (the rotation quaternion must have unit
     *        length)
     * @param rRW the {@code rW} component of the rigid transform
     *        {@code (rTX, rTY, rTZ, rRX, rRY, rRZ, rRW)} (the rotation quaternion must have unit
     *        length)
     * @return this
     */
    @Mutated public Double3x4 makeFromRigid(double rTX, double rTY, double rTZ, double rRX, double rRY, double rRZ, double rRW) {
        double _t0 = rRZ * rRZ;
        double _t1 = rRZ * rRW;
        double _t2 = rRY * rRW;
        this.m00 = Math.fma(-2.0, Math.fma(rRY, rRY, _t0), 1.0);
        this.m01 = 2.0 * Math.fma(rRX, rRY, -_t1);
        this.m02 = 2.0 * Math.fma(rRX, rRZ, _t2);
        this.m03 = rTX;
        this.m10 = 2.0 * Math.fma(rRX, rRY, _t1);
        this.m11 = Math.fma(-2.0, Math.fma(rRX, rRX, _t0), 1.0);
        this.m12 = 2.0 * Math.fma(rRY, rRZ, -(rRX * rRW));
        this.m13 = rTY;
        this.m20 = 2.0 * Math.fma(rRX, rRZ, -_t2);
        this.m21 = 2.0 * Math.fma(rRX, rRW, rRY * rRZ);
        this.m22 = Math.fma(-2.0, Math.fma(rRX, rRX, rRY * rRY), 1.0);
        this.m23 = rTZ;
        this.properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Set this matrix to the given transform's {@code T * R * S} composition.
     *
     * @param t the transform
     * @return this
     */
    public @Mutated Double3x4 makeFromTransform(DoubleTransformR t) {
        return makeFromTransform(t.tX(), t.tY(), t.tZ(), t.rX(), t.rY(), t.rZ(), t.rW(), t.sX(), t.sY(), t.sZ());
    }


    /**
     * Set this matrix to the given transform's {@code T * R * S} composition.
     *
     * @param tTX the {@code tX} component of the transform
     *        {@code (tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ)}
     * @param tTY the {@code tY} component of the transform
     *        {@code (tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ)}
     * @param tTZ the {@code tZ} component of the transform
     *        {@code (tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ)}
     * @param tRX the {@code rX} component of the transform
     *        {@code (tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ)}
     * @param tRY the {@code rY} component of the transform
     *        {@code (tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ)}
     * @param tRZ the {@code rZ} component of the transform
     *        {@code (tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ)}
     * @param tRW the {@code rW} component of the transform
     *        {@code (tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ)}
     * @param tSX the {@code sX} component of the transform
     *        {@code (tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ)}
     * @param tSY the {@code sY} component of the transform
     *        {@code (tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ)}
     * @param tSZ the {@code sZ} component of the transform
     *        {@code (tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ)}
     * @return this
     */
    @Mutated public Double3x4 makeFromTransform(double tTX, double tTY, double tTZ, double tRX, double tRY, double tRZ, double tRW, double tSX, double tSY, double tSZ) {
        double _t0 = tRZ * tRZ;
        double _t1 = tRZ * tRW;
        double _t2 = tRY * tRW;
        this.m00 = tSX * Math.fma(-2.0, Math.fma(tRY, tRY, _t0), 1.0);
        this.m01 = tSY * 2.0 * Math.fma(tRX, tRY, -_t1);
        this.m02 = tSZ * 2.0 * Math.fma(tRX, tRZ, _t2);
        this.m03 = tTX;
        this.m10 = tSX * 2.0 * Math.fma(tRX, tRY, _t1);
        this.m11 = tSY * Math.fma(-2.0, Math.fma(tRX, tRX, _t0), 1.0);
        this.m12 = tSZ * 2.0 * Math.fma(tRY, tRZ, -(tRX * tRW));
        this.m13 = tTY;
        this.m20 = tSX * 2.0 * Math.fma(tRX, tRZ, -_t2);
        this.m21 = tSY * 2.0 * Math.fma(tRX, tRW, tRY * tRZ);
        this.m22 = tSZ * Math.fma(-2.0, Math.fma(tRX, tRX, tRY * tRY), 1.0);
        this.m23 = tTZ;
        this.properties = Joml.BIT_AFFINE;
        return this;
    }


    /**
     * Private body of {@code to3x3}, specialized by runtime matrix properties; reached only through
     * the public {@code to3x3} dispatcher.
     */
    private Double3x3 to3x3_identity(@Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        d.m00 = 1.0;
        d.m10 = 0.0;
        d.m20 = 0.0;
        d.m01 = 0.0;
        d.m11 = 1.0;
        d.m21 = 0.0;
        d.m02 = 0.0;
        d.m12 = 0.0;
        d.m22 = 1.0;
        d.properties = Joml.BIT_IDENTITY;
        return d;
    }


    /**
     * Private body of {@code to3x3}, specialized by runtime matrix properties; reached only through
     * the public {@code to3x3} dispatcher.
     */
    private Double3x3 to3x3_general(@Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        d.m00 = this.m00;
        d.m10 = this.m10;
        double _buf0 = this.m20;
        d.m01 = this.m01;
        d.m11 = this.m11;
        d.m21 = this.m21;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = this.m22;
        d.m20 = _buf0;
        d.properties = 0;
        return d;
    }


    /**
     * Extract the upper-left 3x3 block of this matrix (dropping the translation column) and store
     * the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 to3x3(@Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return to3x3_identity(dest);
        return to3x3_general(dest);
    }


    /**
     * Private body of {@code to4x4}, specialized by runtime matrix properties; reached only through
     * the public {@code to4x4} dispatcher.
     */
    private Double4x4 to4x4_orthogonal_general(@Mutated Double4x4 dest, int _props) {
        Double4x4Impl d = (Double4x4Impl) dest;
        d.m00 = this.m00;
        d.m10 = this.m10;
        d.m20 = this.m20;
        d.m30 = 0.0;
        d.m01 = this.m01;
        d.m11 = this.m11;
        d.m21 = this.m21;
        d.m31 = 0.0;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = this.m22;
        d.m32 = 0.0;
        d.m03 = this.m03;
        d.m13 = this.m13;
        d.m23 = this.m23;
        d.m33 = 1.0;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code to4x4}, specialized by runtime matrix properties; reached only through
     * the public {@code to4x4} dispatcher.
     */
    private Double4x4 to4x4_identity(@Mutated Double4x4 dest) {
        Double4x4Impl d = (Double4x4Impl) dest;
        d.m00 = 1.0;
        d.m10 = 0.0;
        d.m20 = 0.0;
        d.m30 = 0.0;
        d.m01 = 0.0;
        d.m11 = 1.0;
        d.m21 = 0.0;
        d.m31 = 0.0;
        d.m02 = 0.0;
        d.m12 = 0.0;
        d.m22 = 1.0;
        d.m32 = 0.0;
        d.m03 = 0.0;
        d.m13 = 0.0;
        d.m23 = 0.0;
        d.m33 = 1.0;
        d.properties = Joml.BIT_IDENTITY;
        return d;
    }


    /**
     * Private body of {@code to4x4}, specialized by runtime matrix properties; reached only through
     * the public {@code to4x4} dispatcher.
     */
    private Double4x4 to4x4_translation(@Mutated Double4x4 dest) {
        Double4x4Impl d = (Double4x4Impl) dest;
        d.m00 = 1.0;
        d.m10 = 0.0;
        d.m20 = 0.0;
        d.m30 = 0.0;
        d.m01 = 0.0;
        d.m11 = 1.0;
        d.m21 = 0.0;
        d.m31 = 0.0;
        d.m02 = 0.0;
        d.m12 = 0.0;
        d.m22 = 1.0;
        d.m32 = 0.0;
        d.m03 = this.m03;
        d.m13 = this.m13;
        d.m23 = this.m23;
        d.m33 = 1.0;
        d.properties = Joml.BIT_TRANSLATION;
        return d;
    }


    /**
     * Extend this matrix to a 4x4 matrix, filling the missing cells with identity and store the
     * result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4x4 to4x4(@Mutated Double4x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return to4x4_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return to4x4_translation(dest);
        return to4x4_orthogonal_general(dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code toDualQuat}, specialized by runtime matrix properties; reached only
     * through the public {@code toDualQuat} dispatcher.
     */
    private DoubleDualQuat toDualQuat_identity(@Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        d.rX = 0.0;
        d.rY = 0.0;
        d.rZ = 0.0;
        d.rW = 1.0;
        d.dX = 0.0;
        d.dY = 0.0;
        d.dZ = 0.0;
        d.dW = 0.0;
        return d;
    }


    /**
     * Private body of {@code toDualQuat}, specialized by runtime matrix properties; reached only
     * through the public {@code toDualQuat} dispatcher.
     */
    private DoubleDualQuat toDualQuat_translation(@Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        d.rX = 0.0;
        d.rY = 0.0;
        d.rZ = 0.0;
        double _buf0 = 1.0;
        d.dX = 0.5 * this.m03;
        d.dY = 0.5 * this.m13;
        d.dZ = 0.5 * this.m23;
        d.dW = 0.0;
        d.rW = _buf0;
        return d;
    }


    /**
     * Private body of {@code toDualQuat}, specialized by runtime matrix properties; reached only
     * through the public {@code toDualQuat} dispatcher.
     */
    private DoubleDualQuat toDualQuat_orthogonal(@Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        double _t0 = -this.m23;
        double _t2 = 1.0 - this.m00;
        double _t4 = this.m21 - this.m12;
        double _t5 = Math.max(this.m11, this.m22);
        double _t6 = this.m01 + this.m10;
        double _t7 = this.m02 + this.m20;
        double _t8 = this.m02 - this.m20;
        double _t9 = this.m12 + this.m21;
        double _t10 = this.m10 - this.m01;
        double _t14 = this.m22 + (this.m00 + this.m11);
        double _t15 = 1.0 + _t14;
        double _t16 = this.m00 + (1.0 - this.m11 - this.m22);
        double _t17 = this.m11 + (_t2 - this.m22);
        double _t18 = this.m22 + (_t2 - this.m11);
        double _t19 = (1.0 / Math.sqrt(_t15));
        double _t21 = (1.0 / Math.sqrt(_t17));
        double _t22 = (1.0 / Math.sqrt(_t18));
        double _t23 = (1.0 / Math.sqrt(_t16));
        double _t63, _t64, _t65, _t66;
        if (_t14 > 0.0) {
            _t63 = 0.5 * _t4 * _t19;
            _t64 = 0.5 * _t8 * _t19;
            _t65 = 0.5 * _t10 * _t19;
            _t66 = 0.5 * Math.sqrt(_t15);
        } else {
            if (this.m00 > _t5) {
                _t63 = 0.5 * Math.sqrt(_t16);
                _t64 = 0.5 * _t6 * _t23;
                _t65 = 0.5 * _t7 * _t23;
                _t66 = 0.5 * _t4 * _t23;
            } else {
                if (this.m11 > this.m22) {
                    _t63 = 0.5 * _t6 * _t21;
                    _t64 = 0.5 * Math.sqrt(_t17);
                    _t65 = 0.5 * _t9 * _t21;
                    _t66 = 0.5 * _t8 * _t21;
                } else {
                    _t63 = 0.5 * _t7 * _t22;
                    _t64 = 0.5 * _t9 * _t22;
                    _t65 = 0.5 * Math.sqrt(_t18);
                    _t66 = 0.5 * _t10 * _t22;
                }
            }
        }
        d.rX = _t63;
        d.rY = _t64;
        d.rZ = _t65;
        double _buf0 = _t66;
        d.dX = 0.5 * Math.fma(_t0, _t64, Math.fma(this.m03, _t66, this.m13 * _t65));
        d.dY = 0.5 * Math.fma(this.m23, _t63, Math.fma(this.m13, _t66, -(this.m03 * _t65)));
        d.dZ = 0.5 * Math.fma(this.m23, _t66, Math.fma(this.m03, _t64, -(this.m13 * _t63)));
        d.dW = 0.5 * Math.fma(_t0, _t65, Math.fma(-this.m13, _t64, -(this.m03 * _t63)));
        d.rW = _buf0;
        return d;
    }


    /**
     * Private body of {@code toDualQuat}, specialized by runtime matrix properties; reached only
     * through the public {@code toDualQuat} dispatcher.
     */
    private DoubleDualQuat toDualQuat_general(@Mutated DoubleDualQuat dest) {
        return toDualQuat_orthogonal(dest);
    }


    /**
     * Convert this matrix to a dual quaternion, assuming its upper-left 3x3 block is orthonormal (a
     * rigid transform) and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat toDualQuat(@Mutated DoubleDualQuat dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return toDualQuat_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return toDualQuat_translation(dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return toDualQuat_orthogonal(dest);
        return toDualQuat_general(dest);
    }


    /**
     * Private body of {@code toRigid}, specialized by runtime matrix properties; reached only
     * through the public {@code toRigid} dispatcher.
     */
    private DoubleRigid toRigid_identity(@Mutated DoubleRigid dest) {
        DoubleRigidImpl d = (DoubleRigidImpl) dest;
        d.tX = 0.0;
        d.tY = 0.0;
        d.tZ = 0.0;
        d.rX = 0.0;
        d.rY = 0.0;
        d.rZ = 0.0;
        d.rW = 1.0;
        return d;
    }


    /**
     * Private body of {@code toRigid}, specialized by runtime matrix properties; reached only
     * through the public {@code toRigid} dispatcher.
     */
    private DoubleRigid toRigid_translation(@Mutated DoubleRigid dest) {
        DoubleRigidImpl d = (DoubleRigidImpl) dest;
        d.tX = this.m03;
        d.tY = this.m13;
        d.tZ = this.m23;
        d.rX = 0.0;
        d.rY = 0.0;
        d.rZ = 0.0;
        d.rW = 1.0;
        return d;
    }


    /**
     * Private body of {@code toRigid}, specialized by runtime matrix properties; reached only
     * through the public {@code toRigid} dispatcher.
     */
    private DoubleRigid toRigid_general(@Mutated DoubleRigid dest) {
        DoubleRigidImpl d = (DoubleRigidImpl) dest;
        double _t0 = -this.m11;
        double _t1 = -this.m22;
        double _t12 = (1.0 / Math.sqrt(Math.fma(this.m21, this.m21, Math.fma(this.m01, this.m01, this.m11 * this.m11))));
        double _t13 = (1.0 / Math.sqrt(Math.fma(this.m22, this.m22, Math.fma(this.m02, this.m02, this.m12 * this.m12))));
        double _t14 = (1.0 / Math.sqrt(Math.fma(this.m20, this.m20, Math.fma(this.m00, this.m00, this.m10 * this.m10))));
        double _t15 = this.m10 * _t14;
        double _t16 = this.m22 * _t13;
        double _t17 = this.m12 * _t13;
        double _t18 = this.m20 * _t14;
        double _t20 = this.m21 * _t12;
        double _t21 = this.m11 * _t12;
        double _t23 = this.m00 * _t14;
        double _t28 = Math.fma(this.m12, _t13, _t20);
        double _t32 = Math.fma(this.m21, _t12, -_t17);
        double _t33 = Math.max(_t21, _t16);
        double _t43 = Math.fma(-Math.fma(_t15, _t16, -(_t17 * _t18)), this.m01 * _t12, Math.fma(Math.fma(_t15, _t20, -(_t21 * _t18)), this.m02 * _t13, Math.fma(_t21, _t16, -(_t17 * _t20)) * _t23));
        double _t44, _t45, _t46;
        if (_t43 < 0.0) {
            _t44 = -_t23;
            _t45 = -_t15;
            _t46 = -_t18;
        } else {
            _t44 = _t23;
            _t45 = _t15;
            _t46 = _t18;
        }
        double _t48 = 1.0 + _t44;
        double _t49 = 1.0 - _t44;
        double _t51 = Math.fma(this.m01, _t12, _t45);
        double _t52 = Math.fma(this.m02, _t13, _t46);
        double _t53 = Math.fma(this.m02, _t13, -_t46);
        double _t54 = Math.fma(-this.m01, _t12, _t45);
        double _t59 = Math.fma(this.m11, _t12, Math.fma(this.m22, _t13, _t44));
        double _t60 = Math.fma(this.m11, _t12, Math.fma(this.m22, _t13, _t48));
        double _t61 = (1.0 / Math.sqrt(_t60));
        double _t62 = Math.fma(this.m11, _t12, Math.fma(_t1, _t13, _t49));
        double _t63 = Math.fma(this.m22, _t13, Math.fma(_t0, _t12, _t49));
        double _t64 = Math.fma(_t0, _t12, Math.fma(_t1, _t13, _t48));
        double _t65 = (1.0 / Math.sqrt(_t62));
        double _t66 = (1.0 / Math.sqrt(_t63));
        double _t67 = (1.0 / Math.sqrt(_t64));
        if (_t59 > 0.0) {
            d.rX = 0.5 * _t32 * _t61;
            d.rY = 0.5 * _t53 * _t61;
            d.rZ = 0.5 * _t54 * _t61;
            d.rW = 0.5 * Math.sqrt(_t60);
        } else {
            if (_t44 > _t33) {
                d.rX = 0.5 * Math.sqrt(_t64);
                d.rY = 0.5 * _t51 * _t67;
                d.rZ = 0.5 * _t52 * _t67;
                d.rW = 0.5 * _t32 * _t67;
            } else {
                if (_t21 > _t16) {
                    d.rX = 0.5 * _t51 * _t65;
                    d.rY = 0.5 * Math.sqrt(_t62);
                    d.rZ = 0.5 * _t28 * _t65;
                    d.rW = 0.5 * _t53 * _t65;
                } else {
                    d.rX = 0.5 * _t52 * _t66;
                    d.rY = 0.5 * _t28 * _t66;
                    d.rZ = 0.5 * Math.sqrt(_t63);
                    d.rW = 0.5 * _t54 * _t66;
                }
            }
        }
        d.tX = this.m03;
        d.tY = this.m13;
        d.tZ = this.m23;
        return d;
    }


    /**
     * Decompose this matrix into a rigid transform: translation from the last column, rotation from
     * the column-normalized upper-left 3x3 block (scale is removed by normalizing the columns, but
     * shear is not removed: a sheared block yields a rotation quaternion that is not unit length)
     * and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRigid toRigid(@Mutated DoubleRigid dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return toRigid_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return toRigid_translation(dest);
        return toRigid_general(dest);
    }


    /**
     * Private body of {@code toTransform}, specialized by runtime matrix properties; reached only
     * through the public {@code toTransform} dispatcher.
     */
    private DoubleTransform toTransform_identity(@Mutated DoubleTransform dest) {
        DoubleTransformImpl d = (DoubleTransformImpl) dest;
        d.tX = 0.0;
        d.tY = 0.0;
        d.tZ = 0.0;
        d.rX = 0.0;
        d.rY = 0.0;
        d.rZ = 0.0;
        d.rW = 1.0;
        d.sX = 1.0;
        d.sY = 1.0;
        d.sZ = 1.0;
        return d;
    }


    /**
     * Private body of {@code toTransform}, specialized by runtime matrix properties; reached only
     * through the public {@code toTransform} dispatcher.
     */
    private DoubleTransform toTransform_translation(@Mutated DoubleTransform dest) {
        DoubleTransformImpl d = (DoubleTransformImpl) dest;
        d.tX = this.m03;
        d.tY = this.m13;
        d.tZ = this.m23;
        d.rX = 0.0;
        d.rY = 0.0;
        d.rZ = 0.0;
        d.rW = 1.0;
        d.sX = 1.0;
        d.sY = 1.0;
        d.sZ = 1.0;
        return d;
    }


    /**
     * Private body of {@code toTransform}, specialized by runtime matrix properties; reached only
     * through the public {@code toTransform} dispatcher.
     */
    private DoubleTransform toTransform_general(@Mutated DoubleTransform dest) {
        DoubleTransformImpl d = (DoubleTransformImpl) dest;
        double _t0 = -this.m11;
        double _t1 = -this.m22;
        double _t9 = Math.fma(this.m21, this.m21, Math.fma(this.m01, this.m01, this.m11 * this.m11));
        double _t10 = Math.fma(this.m22, this.m22, Math.fma(this.m02, this.m02, this.m12 * this.m12));
        double _t11 = Math.fma(this.m20, this.m20, Math.fma(this.m00, this.m00, this.m10 * this.m10));
        double _t12 = (1.0 / Math.sqrt(_t9));
        double _t13 = (1.0 / Math.sqrt(_t10));
        double _t14 = (1.0 / Math.sqrt(_t11));
        double _t15 = Math.sqrt(_t11);
        double _t16 = this.m10 * _t14;
        double _t17 = this.m22 * _t13;
        double _t18 = this.m12 * _t13;
        double _t19 = this.m20 * _t14;
        double _t21 = this.m21 * _t12;
        double _t22 = this.m11 * _t12;
        double _t24 = this.m00 * _t14;
        double _t29 = Math.fma(this.m12, _t13, _t21);
        double _t33 = Math.fma(this.m21, _t12, -_t18);
        double _t34 = Math.max(_t22, _t17);
        double _t44 = Math.fma(-Math.fma(_t16, _t17, -(_t18 * _t19)), this.m01 * _t12, Math.fma(Math.fma(_t16, _t21, -(_t22 * _t19)), this.m02 * _t13, Math.fma(_t22, _t17, -(_t18 * _t21)) * _t24));
        double _t45, _t46, _t47;
        if (_t44 < 0.0) {
            _t45 = -_t24;
            _t46 = -_t16;
            _t47 = -_t19;
        } else {
            _t45 = _t24;
            _t46 = _t16;
            _t47 = _t19;
        }
        double _t49 = 1.0 + _t45;
        double _t50 = 1.0 - _t45;
        double _t52 = Math.fma(this.m01, _t12, _t46);
        double _t53 = Math.fma(this.m02, _t13, _t47);
        double _t54 = Math.fma(this.m02, _t13, -_t47);
        double _t55 = Math.fma(-this.m01, _t12, _t46);
        double _t60 = Math.fma(this.m11, _t12, Math.fma(this.m22, _t13, _t45));
        double _t61 = Math.fma(this.m11, _t12, Math.fma(this.m22, _t13, _t49));
        double _t62 = (1.0 / Math.sqrt(_t61));
        double _t63 = Math.fma(this.m11, _t12, Math.fma(_t1, _t13, _t50));
        double _t64 = Math.fma(this.m22, _t13, Math.fma(_t0, _t12, _t50));
        double _t65 = Math.fma(_t0, _t12, Math.fma(_t1, _t13, _t49));
        double _t66 = (1.0 / Math.sqrt(_t63));
        double _t67 = (1.0 / Math.sqrt(_t64));
        double _t68 = (1.0 / Math.sqrt(_t65));
        d.tX = this.m03;
        d.tY = this.m13;
        d.tZ = this.m23;
        d.rX = _t60 > 0.0 ? 0.5 * _t33 * _t62 : _t45 > _t34 ? 0.5 * Math.sqrt(_t65) : _t22 > _t17 ? 0.5 * _t52 * _t66 : 0.5 * _t53 * _t67;
        d.rY = _t60 > 0.0 ? 0.5 * _t54 * _t62 : _t45 > _t34 ? 0.5 * _t52 * _t68 : _t22 > _t17 ? 0.5 * Math.sqrt(_t63) : 0.5 * _t29 * _t67;
        d.rZ = _t60 > 0.0 ? 0.5 * _t55 * _t62 : _t45 > _t34 ? 0.5 * _t53 * _t68 : _t22 > _t17 ? 0.5 * _t29 * _t66 : 0.5 * Math.sqrt(_t64);
        d.rW = _t60 > 0.0 ? 0.5 * Math.sqrt(_t61) : _t45 > _t34 ? 0.5 * _t33 * _t68 : _t22 > _t17 ? 0.5 * _t54 * _t66 : 0.5 * _t55 * _t67;
        d.sX = _t44 < 0.0 ? -_t15 : _t15;
        d.sY = Math.sqrt(_t9);
        d.sZ = Math.sqrt(_t10);
        return d;
    }


    /**
     * Decompose this matrix into a TRS transform: translation from the last column, scale from the
     * column lengths of the upper-left 3x3 block, rotation from the column-normalized block (scale
     * is removed by normalizing the columns, but shear is not removed: a sheared block yields a
     * rotation quaternion that is not unit length) and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTransform toTransform(@Mutated DoubleTransform dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return toTransform_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return toTransform_translation(dest);
        return toTransform_general(dest);
    }


    /**
     * Private body of {@code decomposeRotation}, specialized by runtime matrix properties; reached
     * only through the public {@code decomposeRotation} dispatcher.
     */
    private DoubleQuat decomposeRotation_identity(@Mutated DoubleQuat dest) {
        return getNormalizedRotation_identity(dest);
    }


    /**
     * Private body of {@code decomposeRotation}, specialized by runtime matrix properties; reached
     * only through the public {@code decomposeRotation} dispatcher.
     */
    private DoubleQuat decomposeRotation_general(@Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _t2 = Math.fma(this.m20, this.m20, Math.fma(this.m00, this.m00, this.m10 * this.m10));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7, _t8, _t9;
        if (_t2 > 0.0) {
            _t7 = this.m20 * _t3;
            _t8 = this.m00 * _t3;
            _t9 = this.m10 * _t3;
        } else {
            _t7 = 0.0;
            _t8 = 0.0;
            _t9 = 0.0;
        }
        double _t19 = -Math.fma(this.m21, _t7, Math.fma(this.m01, _t8, this.m11 * _t9));
        double _t20 = -Math.fma(this.m22, _t7, Math.fma(this.m02, _t8, this.m12 * _t9));
        double _t21 = Math.fma(_t19, _t7, this.m21);
        double _t22 = Math.fma(_t19, _t8, this.m01);
        double _t23 = Math.fma(_t19, _t9, this.m11);
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
        double _t40 = -Math.fma(Math.fma(_t20, _t7, this.m22), _t35, Math.fma(Math.fma(_t20, _t8, this.m02), _t34, Math.fma(_t20, _t9, this.m12) * _t36));
        double _t44 = Math.fma(_t20, _t7, Math.fma(_t40, _t35, this.m22));
        double _t45 = Math.fma(_t20, _t8, Math.fma(_t40, _t34, this.m02));
        double _t46 = Math.fma(_t20, _t9, Math.fma(_t40, _t36, this.m12));
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
            d.x = 0.5 * _t60 * _t90;
            d.y = 0.5 * _t81 * _t90;
            d.z = 0.5 * _t78 * _t90;
            d.w = 0.5 * Math.sqrt(_t86);
        } else {
            if (_t73 > _t61) {
                d.x = 0.5 * Math.sqrt(_t87);
                d.y = 0.5 * _t77 * _t93;
                d.z = 0.5 * _t80 * _t93;
                d.w = 0.5 * _t60 * _t93;
            } else {
                if (_t36 > _t56) {
                    d.x = 0.5 * _t77 * _t91;
                    d.y = 0.5 * Math.sqrt(_t88);
                    d.z = 0.5 * _t63 * _t91;
                    d.w = 0.5 * _t81 * _t91;
                } else {
                    d.x = 0.5 * _t80 * _t92;
                    d.y = 0.5 * _t63 * _t92;
                    d.z = 0.5 * Math.sqrt(_t89);
                    d.w = 0.5 * _t78 * _t92;
                }
            }
        }
        return d;
    }


    /**
     * Extract the rotation part of this matrix and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat decomposeRotation(@Mutated DoubleQuat dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return decomposeRotation_identity(dest);
        return decomposeRotation_general(dest);
    }


    /**
     * Private body of {@code decomposeScale}, specialized by runtime matrix properties; reached
     * only through the public {@code decomposeScale} dispatcher.
     */
    private Double3 decomposeScale_identity(@Mutated Double3 dest) {
        return getScale_identity(dest);
    }


    /**
     * Private body of {@code decomposeScale}, specialized by runtime matrix properties; reached
     * only through the public {@code decomposeScale} dispatcher.
     */
    private Double3 decomposeScale_general(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t2 = Math.fma(this.m20, this.m20, Math.fma(this.m00, this.m00, this.m10 * this.m10));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t4 = Math.sqrt(_t2);
        double _t8, _t9, _t10;
        if (_t2 > 0.0) {
            _t8 = this.m20 * _t3;
            _t9 = this.m00 * _t3;
            _t10 = this.m10 * _t3;
        } else {
            _t8 = 0.0;
            _t9 = 0.0;
            _t10 = 0.0;
        }
        double _t17 = -Math.fma(this.m21, _t8, Math.fma(this.m01, _t9, this.m11 * _t10));
        double _t18 = -Math.fma(this.m22, _t8, Math.fma(this.m02, _t9, this.m12 * _t10));
        double _t19 = Math.fma(_t17, _t8, this.m21);
        double _t20 = Math.fma(_t17, _t9, this.m01);
        double _t21 = Math.fma(_t17, _t10, this.m11);
        double _t27 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        double _t28 = (1.0 / Math.sqrt(_t27));
        double _t32, _t33, _t34;
        if (_t27 > 0.0) {
            _t32 = _t20 * _t28;
            _t33 = _t19 * _t28;
            _t34 = _t21 * _t28;
        } else {
            _t32 = 0.0;
            _t33 = 0.0;
            _t34 = 0.0;
        }
        double _t38 = -Math.fma(Math.fma(_t18, _t8, this.m22), _t33, Math.fma(Math.fma(_t18, _t9, this.m02), _t32, Math.fma(_t18, _t10, this.m12) * _t34));
        double _t42 = Math.fma(_t18, _t8, Math.fma(_t38, _t33, this.m22));
        double _t43 = Math.fma(_t18, _t9, Math.fma(_t38, _t32, this.m02));
        double _t44 = Math.fma(_t18, _t10, Math.fma(_t38, _t34, this.m12));
        double _t47 = Math.fma(_t42, _t42, Math.fma(_t43, _t43, _t44 * _t44));
        double _t48 = (1.0 / Math.sqrt(_t47));
        double _t52, _t53, _t54;
        if (_t47 > 0.0) {
            _t52 = _t44 * _t48;
            _t53 = _t43 * _t48;
            _t54 = _t42 * _t48;
        } else {
            _t52 = 0.0;
            _t53 = 0.0;
            _t54 = 0.0;
        }
        d.x = Math.fma(Math.fma(_t32, _t52, -(_t34 * _t53)), _t8, Math.fma(Math.fma(_t34, _t54, -(_t33 * _t52)), _t9, Math.fma(_t33, _t53, -(_t32 * _t54)) * _t10)) < 0.0 ? -_t4 : _t4;
        d.y = Math.sqrt(_t27);
        d.z = Math.sqrt(_t47);
        return d;
    }


    /**
     * Extract the scaling factors of this matrix via Gram-Schmidt orthogonalization (skew-aware;
     * the x factor carries the sign of a reflection when the determinant is negative) and store the
     * result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 decomposeScale(@Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return decomposeScale_identity(dest);
        return decomposeScale_general(dest);
    }


    /**
     * Private body of {@code decomposeSkew}, specialized by runtime matrix properties; reached only
     * through the public {@code decomposeSkew} dispatcher.
     */
    private Double3 decomposeSkew_identity(@Mutated Double3 dest) {
        return getEulerAnglesXYZ_identity(dest);
    }


    /**
     * Private body of {@code decomposeSkew}, specialized by runtime matrix properties; reached only
     * through the public {@code decomposeSkew} dispatcher.
     */
    private Double3 decomposeSkew_general(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t2 = Math.fma(this.m20, this.m20, Math.fma(this.m00, this.m00, this.m10 * this.m10));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7, _t8, _t9;
        if (_t2 > 0.0) {
            _t7 = this.m20 * _t3;
            _t8 = this.m00 * _t3;
            _t9 = this.m10 * _t3;
        } else {
            _t7 = 0.0;
            _t8 = 0.0;
            _t9 = 0.0;
        }
        double _t14 = Math.fma(this.m22, _t7, Math.fma(this.m02, _t8, this.m12 * _t9));
        double _t15 = Math.fma(this.m21, _t7, Math.fma(this.m01, _t8, this.m11 * _t9));
        double _t16 = -_t14;
        double _t17 = -_t15;
        double _t19 = Math.fma(_t17, _t7, this.m21);
        double _t20 = Math.fma(_t17, _t8, this.m01);
        double _t21 = Math.fma(_t17, _t9, this.m11);
        double _t26 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        double _t27 = (1.0 / Math.sqrt(_t26));
        double _t28 = _t15 * _t27;
        double _t32, _t33, _t34;
        if (_t26 > 0.0) {
            _t32 = _t19 * _t27;
            _t33 = _t20 * _t27;
            _t34 = _t21 * _t27;
        } else {
            _t32 = 0.0;
            _t33 = 0.0;
            _t34 = 0.0;
        }
        double _t37 = Math.fma(Math.fma(_t16, _t7, this.m22), _t32, Math.fma(Math.fma(_t16, _t8, this.m02), _t33, Math.fma(_t16, _t9, this.m12) * _t34));
        double _t38 = -_t37;
        double _t42 = Math.fma(_t16, _t7, Math.fma(_t38, _t32, this.m22));
        double _t43 = Math.fma(_t16, _t8, Math.fma(_t38, _t33, this.m02));
        double _t44 = Math.fma(_t16, _t9, Math.fma(_t38, _t34, this.m12));
        double _t47 = Math.fma(_t42, _t42, Math.fma(_t43, _t43, _t44 * _t44));
        double _t48 = (1.0 / Math.sqrt(_t47));
        double _t49 = _t14 * _t48;
        double _t53, _t54, _t55;
        if (_t47 > 0.0) {
            _t53 = _t44 * _t48;
            _t54 = _t43 * _t48;
            _t55 = _t42 * _t48;
        } else {
            _t53 = 0.0;
            _t54 = 0.0;
            _t55 = 0.0;
        }
        double _t67 = Math.fma(Math.fma(_t33, _t53, -(_t34 * _t54)), _t7, Math.fma(Math.fma(_t34, _t55, -(_t32 * _t53)), _t8, Math.fma(_t32, _t54, -(_t33 * _t55)) * _t9));
        if (_t67 < 0.0) {
            d.y = -_t49;
            d.z = -_t28;
        } else {
            d.y = _t49;
            d.z = _t28;
        }
        d.x = _t37 * _t48;
        return d;
    }


    /**
     * Extract the shear (skew) factors of this matrix via Gram-Schmidt orthogonalization, as
     * {@code (skewYZ, skewXZ, skewXY)} (all zero for a shear-free matrix) and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 decomposeSkew(@Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return decomposeSkew_identity(dest);
        return decomposeSkew_general(dest);
    }


    /**
     * Decompose this matrix into its translation, rotation and scale components, storing them in
     * {@code translation}, {@code rotation} and {@code scale} respectively.
     *
     * @param translation will hold the translation
     * @param rotation will hold the rotation
     * @param scale will hold the scale
     * @return this
     */
    public Double3x4 decomposeTRS(@Mutated Double3 translation, @Mutated DoubleQuat rotation, @Mutated Double3 scale) {
        Double3Impl d0 = (Double3Impl) translation;
        DoubleQuatImpl d1 = (DoubleQuatImpl) rotation;
        Double3Impl d2 = (Double3Impl) scale;
        double _t2 = Math.fma(this.m20, this.m20, Math.fma(this.m00, this.m00, this.m10 * this.m10));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t4 = Math.sqrt(_t2);
        double _t8, _t9, _t10;
        if (_t2 > 0.0) {
            _t8 = this.m20 * _t3;
            _t9 = this.m00 * _t3;
            _t10 = this.m10 * _t3;
        } else {
            _t8 = 0.0;
            _t9 = 0.0;
            _t10 = 0.0;
        }
        double _t20 = -Math.fma(this.m21, _t8, Math.fma(this.m01, _t9, this.m11 * _t10));
        double _t21 = -Math.fma(this.m22, _t8, Math.fma(this.m02, _t9, this.m12 * _t10));
        double _t22 = Math.fma(_t20, _t8, this.m21);
        double _t23 = Math.fma(_t20, _t9, this.m01);
        double _t24 = Math.fma(_t20, _t10, this.m11);
        double _t30 = Math.fma(_t22, _t22, Math.fma(_t23, _t23, _t24 * _t24));
        double _t31 = (1.0 / Math.sqrt(_t30));
        double _t35, _t36, _t37;
        if (_t30 > 0.0) {
            _t35 = _t23 * _t31;
            _t36 = _t22 * _t31;
            _t37 = _t24 * _t31;
        } else {
            _t35 = 0.0;
            _t36 = 0.0;
            _t37 = 0.0;
        }
        double _t41 = -Math.fma(Math.fma(_t21, _t8, this.m22), _t36, Math.fma(Math.fma(_t21, _t9, this.m02), _t35, Math.fma(_t21, _t10, this.m12) * _t37));
        double _t45 = Math.fma(_t21, _t8, Math.fma(_t41, _t36, this.m22));
        double _t46 = Math.fma(_t21, _t9, Math.fma(_t41, _t35, this.m02));
        double _t47 = Math.fma(_t21, _t10, Math.fma(_t41, _t37, this.m12));
        double _t50 = Math.fma(_t45, _t45, Math.fma(_t46, _t46, _t47 * _t47));
        double _t51 = (1.0 / Math.sqrt(_t50));
        double _t55, _t56, _t57;
        if (_t50 > 0.0) {
            _t55 = _t47 * _t51;
            _t56 = _t46 * _t51;
            _t57 = _t45 * _t51;
        } else {
            _t55 = 0.0;
            _t56 = 0.0;
            _t57 = 0.0;
        }
        double _t61 = _t36 - _t55;
        double _t62 = Math.max(_t37, _t57);
        double _t64 = _t36 + _t55;
        double _t73 = Math.fma(Math.fma(_t35, _t55, -(_t37 * _t56)), _t8, Math.fma(Math.fma(_t37, _t57, -(_t36 * _t55)), _t9, Math.fma(_t36, _t56, -(_t35 * _t57)) * _t10));
        double _t74, _t75, _t76;
        if (_t73 < 0.0) {
            _t74 = -_t9;
            _t75 = -_t10;
            _t76 = -_t8;
        } else {
            _t74 = _t9;
            _t75 = _t10;
            _t76 = _t8;
        }
        double _t77 = _t74 + _t37;
        double _t78 = _t75 + _t35;
        double _t79 = _t75 - _t35;
        double _t81 = _t76 + _t56;
        double _t82 = _t56 - _t76;
        double _t83 = _t77 + _t57;
        double _t87 = 1.0 + _t83;
        double _t88 = 1.0 + (_t74 - (_t37 + _t57));
        double _t89 = 1.0 + (_t37 - (_t74 + _t57));
        double _t90 = 1.0 + (_t57 - _t77);
        double _t91 = (1.0 / Math.sqrt(_t87));
        double _t92 = (1.0 / Math.sqrt(_t89));
        double _t93 = (1.0 / Math.sqrt(_t90));
        double _t94 = (1.0 / Math.sqrt(_t88));
        d0.x = this.m03;
        d0.y = this.m13;
        d0.z = this.m23;
        d1.x = _t83 > 0.0 ? 0.5 * _t61 * _t91 : _t74 > _t62 ? 0.5 * Math.sqrt(_t88) : _t37 > _t57 ? 0.5 * _t78 * _t92 : 0.5 * _t81 * _t93;
        d1.y = _t83 > 0.0 ? 0.5 * _t82 * _t91 : _t74 > _t62 ? 0.5 * _t78 * _t94 : _t37 > _t57 ? 0.5 * Math.sqrt(_t89) : 0.5 * _t64 * _t93;
        d1.z = _t83 > 0.0 ? 0.5 * _t79 * _t91 : _t74 > _t62 ? 0.5 * _t81 * _t94 : _t37 > _t57 ? 0.5 * _t64 * _t92 : 0.5 * Math.sqrt(_t90);
        d1.w = _t83 > 0.0 ? 0.5 * Math.sqrt(_t87) : _t74 > _t62 ? 0.5 * _t61 * _t94 : _t37 > _t57 ? 0.5 * _t82 * _t92 : 0.5 * _t79 * _t93;
        d2.x = _t73 < 0.0 ? -_t4 : _t4;
        d2.y = Math.sqrt(_t30);
        d2.z = Math.sqrt(_t50);
        return this;
    }


    /**
     * Set this matrix to the identity.
     *
     * @return this
     */
    @Mutated public Double3x4 makeIdentity() {
        this.m00 = 1.0;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = 1.0;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = 1.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_IDENTITY;
        return this;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Double3x4 lerp_general(Double3x4R other, double t, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = Math.fma(t, other.m00() - this.m00, this.m00);
        d.m01 = Math.fma(t, other.m01() - this.m01, this.m01);
        d.m02 = Math.fma(t, other.m02() - this.m02, this.m02);
        d.m03 = Math.fma(t, other.m03() - this.m03, this.m03);
        d.m10 = Math.fma(t, other.m10() - this.m10, this.m10);
        d.m11 = Math.fma(t, other.m11() - this.m11, this.m11);
        d.m12 = Math.fma(t, other.m12() - this.m12, this.m12);
        d.m13 = Math.fma(t, other.m13() - this.m13, this.m13);
        d.m20 = Math.fma(t, other.m20() - this.m20, this.m20);
        d.m21 = Math.fma(t, other.m21() - this.m21, this.m21);
        d.m22 = Math.fma(t, other.m22() - this.m22, this.m22);
        d.m23 = Math.fma(t, other.m23() - this.m23, this.m23);
        d.properties = Joml.BIT_AFFINE & ((Double3x4Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Double3x4 lerp_identity(Double3x4R other, double t, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = Math.fma(t, other.m00() - 1.0, 1.0);
        d.m01 = t * other.m01();
        d.m02 = t * other.m02();
        d.m03 = t * other.m03();
        d.m10 = t * other.m10();
        d.m11 = Math.fma(t, other.m11() - 1.0, 1.0);
        d.m12 = t * other.m12();
        d.m13 = t * other.m13();
        d.m20 = t * other.m20();
        d.m21 = t * other.m21();
        d.m22 = Math.fma(t, other.m22() - 1.0, 1.0);
        d.m23 = t * other.m23();
        d.properties = Joml.BIT_AFFINE & ((Double3x4Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Double3x4 lerp_translation(Double3x4R other, double t, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = Math.fma(t, other.m00() - 1.0, 1.0);
        d.m01 = t * other.m01();
        d.m02 = t * other.m02();
        d.m03 = Math.fma(t, other.m03() - this.m03, this.m03);
        d.m10 = t * other.m10();
        d.m11 = Math.fma(t, other.m11() - 1.0, 1.0);
        d.m12 = t * other.m12();
        d.m13 = Math.fma(t, other.m13() - this.m13, this.m13);
        d.m20 = t * other.m20();
        d.m21 = t * other.m21();
        d.m22 = Math.fma(t, other.m22() - 1.0, 1.0);
        d.m23 = Math.fma(t, other.m23() - this.m23, this.m23);
        d.properties = Joml.BIT_AFFINE & ((Double3x4Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Double3x4 lerp_identity_identity(Double3x4R other, double t, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = 0.0;
        d.m10 = 0.0;
        d.m11 = 1.0;
        d.m12 = 0.0;
        d.m13 = 0.0;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 1.0;
        d.m23 = 0.0;
        d.properties = ((Double3x4Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Double3x4 lerp_identity_translation(Double3x4R other, double t, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = t * other.m03();
        d.m10 = 0.0;
        d.m11 = 1.0;
        d.m12 = 0.0;
        d.m13 = t * other.m13();
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 1.0;
        d.m23 = t * other.m23();
        d.properties = Joml.BIT_TRANSLATION & ((Double3x4Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Double3x4 lerp_translation_identity(Double3x4R other, double t, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = Math.fma(-t, this.m03, this.m03);
        d.m10 = 0.0;
        d.m11 = 1.0;
        d.m12 = 0.0;
        d.m13 = Math.fma(-t, this.m13, this.m13);
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 1.0;
        d.m23 = Math.fma(-t, this.m23, this.m23);
        d.properties = Joml.BIT_TRANSLATION & ((Double3x4Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Double3x4 lerp_translation_translation(Double3x4R other, double t, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = Math.fma(t, other.m03() - this.m03, this.m03);
        d.m10 = 0.0;
        d.m11 = 1.0;
        d.m12 = 0.0;
        d.m13 = Math.fma(t, other.m13() - this.m13, this.m13);
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 1.0;
        d.m23 = Math.fma(t, other.m23() - this.m23, this.m23);
        d.properties = Joml.BIT_TRANSLATION & ((Double3x4Impl) other).properties;
        return d;
    }


    /**
     * Linearly interpolate between this matrix and {@code other} using the interpolation factor
     * {@code t} and store the result in {@code dest}.
     *
     * @param other the other matrix
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 lerp(Double3x4R other, double t, @Mutated Double3x4 dest) {
        int p = this.properties;
        int q = ((Double3x4Impl) other).properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return lerp_identity_identity(other, t, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return lerp_identity_translation(other, t, dest);
            return lerp_identity(other, t, dest);
        }
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return lerp_translation_identity(other, t, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return lerp_translation_translation(other, t, dest);
            return lerp_translation(other, t, dest);
        }
        return lerp_general(other, t, dest);
    }


    /**
     * Linearly interpolate between this matrix and {@code other} using the interpolation factor
     * {@code t}.
     *
     * @param other the other matrix
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated public Double3x4 lerp(Double3x4R other, double t) {
        if (Joml.RETURN_NEW) return lerp(other, t, Joml.double3x4());
        int p = this.properties;
        int q = ((Double3x4Impl) other).properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return lerp_identity_identity(other, t, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return lerp_identity_translation(other, t, this);
            return lerp_identity(other, t, this);
        }
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return lerp_translation_identity(other, t, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return lerp_translation_translation(other, t, this);
            return lerp_translation(other, t, this);
        }
        return lerp_general(other, t, this);
    }


    /**
     * Linearly interpolate between this matrix and ({@code m00}, {@code m01}, {@code m02},
     * {@code m03}, {@code m10}, {@code m11}, {@code m12}, {@code m13}, {@code m20}, {@code m21},
     * {@code m22}, {@code m23}) using the interpolation factor {@code t} and store the result in
     * {@code dest}.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m03 the element in row 0, column 3 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m13 the element in row 1, column 3 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @param m23 the element in row 2, column 3 of the matrix
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 lerp(double m00, double m01, double m02, double m03, double m10, double m11, double m12, double m13, double m20, double m21, double m22, double m23, double t, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = Math.fma(t, m00 - this.m00, this.m00);
        d.m01 = Math.fma(t, m01 - this.m01, this.m01);
        d.m02 = Math.fma(t, m02 - this.m02, this.m02);
        d.m03 = Math.fma(t, m03 - this.m03, this.m03);
        d.m10 = Math.fma(t, m10 - this.m10, this.m10);
        d.m11 = Math.fma(t, m11 - this.m11, this.m11);
        d.m12 = Math.fma(t, m12 - this.m12, this.m12);
        d.m13 = Math.fma(t, m13 - this.m13, this.m13);
        d.m20 = Math.fma(t, m20 - this.m20, this.m20);
        d.m21 = Math.fma(t, m21 - this.m21, this.m21);
        d.m22 = Math.fma(t, m22 - this.m22, this.m22);
        d.m23 = Math.fma(t, m23 - this.m23, this.m23);
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x4 mul_general(Double3x4R right, @Mutated Double3x4 dest, int _props) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = Math.fma(right.m20(), this.m02, Math.fma(right.m00(), this.m00, right.m10() * this.m01));
        double _buf1 = Math.fma(right.m21(), this.m02, Math.fma(right.m01(), this.m00, right.m11() * this.m01));
        double _buf2 = Math.fma(right.m22(), this.m02, Math.fma(right.m02(), this.m00, right.m12() * this.m01));
        double _buf3 = Math.fma(right.m03(), this.m00, Math.fma(right.m13(), this.m01, Math.fma(right.m23(), this.m02, this.m03)));
        double _buf4 = Math.fma(right.m20(), this.m12, Math.fma(right.m00(), this.m10, right.m10() * this.m11));
        double _buf5 = Math.fma(right.m21(), this.m12, Math.fma(right.m01(), this.m10, right.m11() * this.m11));
        double _buf6 = Math.fma(right.m22(), this.m12, Math.fma(right.m02(), this.m10, right.m12() * this.m11));
        double _buf7 = Math.fma(right.m03(), this.m10, Math.fma(right.m13(), this.m11, Math.fma(right.m23(), this.m12, this.m13)));
        double _buf8 = Math.fma(right.m20(), this.m22, Math.fma(right.m00(), this.m20, right.m10() * this.m21));
        double _buf9 = Math.fma(right.m21(), this.m22, Math.fma(right.m01(), this.m20, right.m11() * this.m21));
        double _buf10 = Math.fma(right.m22(), this.m22, Math.fma(right.m02(), this.m20, right.m12() * this.m21));
        d.m23 = Math.fma(right.m03(), this.m20, Math.fma(right.m13(), this.m21, Math.fma(right.m23(), this.m22, this.m23)));
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.m03 = _buf3;
        d.m10 = _buf4;
        d.m11 = _buf5;
        d.m12 = _buf6;
        d.m13 = _buf7;
        d.m20 = _buf8;
        d.m21 = _buf9;
        d.m22 = _buf10;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x4 mul_translation(Double3x4R right, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = right.m00();
        d.m01 = right.m01();
        d.m02 = right.m02();
        d.m03 = right.m03() + this.m03;
        d.m10 = right.m10();
        d.m11 = right.m11();
        d.m12 = right.m12();
        d.m13 = right.m13() + this.m13;
        d.m20 = right.m20();
        d.m21 = right.m21();
        d.m22 = right.m22();
        d.m23 = right.m23() + this.m23;
        d.properties = Joml.BIT_TRANSLATION & ((Double3x4Impl) right).properties;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x4 mul_translation_translation(Double3x4R right, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = right.m03() + this.m03;
        d.m10 = 0.0;
        d.m11 = 1.0;
        d.m12 = 0.0;
        d.m13 = right.m13() + this.m13;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 1.0;
        d.m23 = right.m23() + this.m23;
        d.properties = Joml.BIT_TRANSLATION & ((Double3x4Impl) right).properties;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x4 mul_orthogonal_translation(Double3x4R right, @Mutated Double3x4 dest, int _props) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = this.m00;
        double _buf1 = this.m01;
        double _buf2 = this.m02;
        double _buf3 = Math.fma(right.m03(), this.m00, Math.fma(right.m13(), this.m01, Math.fma(right.m23(), this.m02, this.m03)));
        double _buf4 = this.m10;
        double _buf5 = this.m11;
        double _buf6 = this.m12;
        double _buf7 = Math.fma(right.m03(), this.m10, Math.fma(right.m13(), this.m11, Math.fma(right.m23(), this.m12, this.m13)));
        double _buf8 = this.m20;
        double _buf9 = this.m21;
        double _buf10 = this.m22;
        d.m23 = Math.fma(right.m03(), this.m20, Math.fma(right.m13(), this.m21, Math.fma(right.m23(), this.m22, this.m23)));
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.m03 = _buf3;
        d.m10 = _buf4;
        d.m11 = _buf5;
        d.m12 = _buf6;
        d.m13 = _buf7;
        d.m20 = _buf8;
        d.m21 = _buf9;
        d.m22 = _buf10;
        d.properties = _props;
        return d;
    }


    /**
     * Multiply this matrix by {@code right} and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     * <p>
     * Both operands are identity-extended to this matrix's square size for the multiplication, and
     * the product is projected back onto this shape.
     *
     * @param right the right operand
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mul(Double3x4R right, @Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return dest.set(right);
        int q = ((Double3x4Impl) right).properties;
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return dest.set(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_translation_translation(right, dest);
            return mul_translation(right, dest);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_orthogonal_translation(right, dest, Joml.BIT_ORTHOGONAL & q);
            return mul_general(right, dest, Joml.BIT_ORTHOGONAL & q);
        }
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_orthogonal_translation(right, dest, Joml.BIT_AFFINE & q);
        return mul_general(right, dest, Joml.BIT_AFFINE & q);
    }


    /**
     * Multiply this matrix by {@code right}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     * <p>
     * Both operands are identity-extended to this matrix's square size for the multiplication, and
     * the product is projected back onto this shape.
     *
     * @param right the right operand
     * @return this
     */
    @Mutated public Double3x4 mul(Double3x4R right) {
        if (Joml.RETURN_NEW) return mul(right, Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return this.set(right);
        int q = ((Double3x4Impl) right).properties;
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return this;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_translation_translation(right, this);
            return mul_translation(right, this);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_orthogonal_translation(right, this, Joml.BIT_ORTHOGONAL & q);
            return mul_general(right, this, Joml.BIT_ORTHOGONAL & q);
        }
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_orthogonal_translation(right, this, Joml.BIT_AFFINE & q);
        return mul_general(right, this, Joml.BIT_AFFINE & q);
    }


    /**
     * Multiply this matrix by ({@code m00}, {@code m01}, {@code m02}, {@code m03}, {@code m10},
     * {@code m11}, {@code m12}, {@code m13}, {@code m20}, {@code m21}, {@code m22}, {@code m23})
     * and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     * <p>
     * Both operands are identity-extended to this matrix's square size for the multiplication, and
     * the product is projected back onto this shape.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m03 the element in row 0, column 3 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m13 the element in row 1, column 3 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @param m23 the element in row 2, column 3 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mul(double m00, double m01, double m02, double m03, double m10, double m11, double m12, double m13, double m20, double m21, double m22, double m23, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = Math.fma(m20, this.m02, Math.fma(m00, this.m00, m10 * this.m01));
        double _buf1 = Math.fma(m21, this.m02, Math.fma(m01, this.m00, m11 * this.m01));
        double _buf2 = Math.fma(m22, this.m02, Math.fma(m02, this.m00, m12 * this.m01));
        d.m03 = Math.fma(m03, this.m00, Math.fma(m13, this.m01, Math.fma(m23, this.m02, this.m03)));
        double _buf3 = Math.fma(m20, this.m12, Math.fma(m00, this.m10, m10 * this.m11));
        double _buf4 = Math.fma(m21, this.m12, Math.fma(m01, this.m10, m11 * this.m11));
        double _buf5 = Math.fma(m22, this.m12, Math.fma(m02, this.m10, m12 * this.m11));
        d.m13 = Math.fma(m03, this.m10, Math.fma(m13, this.m11, Math.fma(m23, this.m12, this.m13)));
        double _buf6 = Math.fma(m20, this.m22, Math.fma(m00, this.m20, m10 * this.m21));
        double _buf7 = Math.fma(m21, this.m22, Math.fma(m01, this.m20, m11 * this.m21));
        double _buf8 = Math.fma(m22, this.m22, Math.fma(m02, this.m20, m12 * this.m21));
        d.m23 = Math.fma(m03, this.m20, Math.fma(m13, this.m21, Math.fma(m23, this.m22, this.m23)));
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.m10 = _buf3;
        d.m11 = _buf4;
        d.m12 = _buf5;
        d.m20 = _buf6;
        d.m21 = _buf7;
        d.m22 = _buf8;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x4 mul_identity(Double2x2R right, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = right.m00();
        d.m01 = right.m01();
        d.m02 = 0.0;
        d.m03 = 0.0;
        d.m10 = right.m10();
        d.m11 = right.m11();
        d.m12 = 0.0;
        d.m13 = 0.0;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 1.0;
        d.m23 = 0.0;
        d.properties = (((Double2x2Impl) right).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_IDENTITY : Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mul}, specialized by runtime matrix properties;
     * reached only through the public {@code mul} dispatcher.
     */
    private Double3x4 mul_identity_self(Double2x2R right, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = right.m00();
        d.m01 = right.m01();
        d.m10 = right.m10();
        d.m11 = right.m11();
        d.properties = (((Double2x2Impl) right).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_IDENTITY : Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x4 mul_translation(Double2x2R right, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = right.m00();
        d.m01 = right.m01();
        d.m02 = 0.0;
        d.m03 = this.m03;
        d.m10 = right.m10();
        d.m11 = right.m11();
        d.m12 = 0.0;
        d.m13 = this.m13;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 1.0;
        d.m23 = this.m23;
        d.properties = (((Double2x2Impl) right).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_TRANSLATION : Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mul}, specialized by runtime matrix properties;
     * reached only through the public {@code mul} dispatcher.
     */
    private Double3x4 mul_translation_self(Double2x2R right, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = right.m00();
        d.m01 = right.m01();
        d.m03 = this.m03;
        d.m10 = right.m10();
        d.m11 = right.m11();
        d.m13 = this.m13;
        d.m23 = this.m23;
        d.properties = (((Double2x2Impl) right).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_TRANSLATION : Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x4 mul_orthogonal(Double2x2R right, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = Math.fma(right.m00(), this.m00, right.m10() * this.m01);
        d.m01 = Math.fma(right.m01(), this.m00, right.m11() * this.m01);
        d.m02 = this.m02;
        d.m03 = this.m03;
        double _buf1 = Math.fma(right.m00(), this.m10, right.m10() * this.m11);
        d.m11 = Math.fma(right.m01(), this.m10, right.m11() * this.m11);
        d.m12 = this.m12;
        d.m13 = this.m13;
        double _buf2 = Math.fma(right.m00(), this.m20, right.m10() * this.m21);
        d.m21 = Math.fma(right.m01(), this.m20, right.m11() * this.m21);
        d.m22 = this.m22;
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.properties = (((Double2x2Impl) right).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_ORTHOGONAL : Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x4 mul_general(Double2x2R right, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = Math.fma(right.m00(), this.m00, right.m10() * this.m01);
        d.m01 = Math.fma(right.m01(), this.m00, right.m11() * this.m01);
        d.m02 = this.m02;
        d.m03 = this.m03;
        double _buf1 = Math.fma(right.m00(), this.m10, right.m10() * this.m11);
        d.m11 = Math.fma(right.m01(), this.m10, right.m11() * this.m11);
        d.m12 = this.m12;
        d.m13 = this.m13;
        double _buf2 = Math.fma(right.m00(), this.m20, right.m10() * this.m21);
        d.m21 = Math.fma(right.m01(), this.m20, right.m11() * this.m21);
        d.m22 = this.m22;
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Multiply this matrix by {@code right} and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     *
     * @param right the right operand
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mul(Double2x2R right, @Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mul_identity(right, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_translation(right, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return mul_orthogonal(right, dest);
        return mul_general(right, dest);
    }


    /**
     * Multiply this matrix by {@code right}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     *
     * @param right the right operand
     * @return this
     */
    @Mutated public Double3x4 mul(Double2x2R right) {
        if (Joml.RETURN_NEW) return mul(right, Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mul_identity_self(right, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_translation_self(right, this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return mul_orthogonal(right, this);
        return mul_general(right, this);
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x4 mul_identity(Double2x3R right, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = right.m00();
        d.m01 = right.m01();
        d.m02 = right.m02();
        d.m03 = 0.0;
        d.m10 = right.m10();
        d.m11 = right.m11();
        d.m12 = right.m12();
        d.m13 = 0.0;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 1.0;
        d.m23 = 0.0;
        d.properties = (((Double2x3Impl) right).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_IDENTITY : Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mul}, specialized by runtime matrix properties;
     * reached only through the public {@code mul} dispatcher.
     */
    private Double3x4 mul_identity_self(Double2x3R right, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = right.m00();
        d.m01 = right.m01();
        d.m02 = right.m02();
        d.m10 = right.m10();
        d.m11 = right.m11();
        d.m12 = right.m12();
        d.properties = (((Double2x3Impl) right).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_IDENTITY : Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x4 mul_translation(Double2x3R right, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = right.m00();
        d.m01 = right.m01();
        d.m02 = right.m02();
        d.m03 = this.m03;
        d.m10 = right.m10();
        d.m11 = right.m11();
        d.m12 = right.m12();
        d.m13 = this.m13;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 1.0;
        d.m23 = this.m23;
        d.properties = (((Double2x3Impl) right).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_TRANSLATION : Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mul}, specialized by runtime matrix properties;
     * reached only through the public {@code mul} dispatcher.
     */
    private Double3x4 mul_translation_self(Double2x3R right, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = right.m00();
        d.m01 = right.m01();
        d.m02 = right.m02();
        d.m03 = this.m03;
        d.m10 = right.m10();
        d.m11 = right.m11();
        d.m12 = right.m12();
        d.m13 = this.m13;
        d.m23 = this.m23;
        d.properties = (((Double2x3Impl) right).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_TRANSLATION : Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x4 mul_orthogonal(Double2x3R right, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = Math.fma(right.m00(), this.m00, right.m10() * this.m01);
        double _buf1 = Math.fma(right.m01(), this.m00, right.m11() * this.m01);
        d.m02 = Math.fma(right.m02(), this.m00, Math.fma(right.m12(), this.m01, this.m02));
        d.m03 = this.m03;
        double _buf2 = Math.fma(right.m00(), this.m10, right.m10() * this.m11);
        double _buf3 = Math.fma(right.m01(), this.m10, right.m11() * this.m11);
        d.m12 = Math.fma(right.m02(), this.m10, Math.fma(right.m12(), this.m11, this.m12));
        d.m13 = this.m13;
        double _buf4 = Math.fma(right.m00(), this.m20, right.m10() * this.m21);
        double _buf5 = Math.fma(right.m01(), this.m20, right.m11() * this.m21);
        d.m22 = Math.fma(right.m02(), this.m20, Math.fma(right.m12(), this.m21, this.m22));
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m10 = _buf2;
        d.m11 = _buf3;
        d.m20 = _buf4;
        d.m21 = _buf5;
        d.properties = (((Double2x3Impl) right).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_ORTHOGONAL : Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x4 mul_general(Double2x3R right, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = Math.fma(right.m00(), this.m00, right.m10() * this.m01);
        double _buf1 = Math.fma(right.m01(), this.m00, right.m11() * this.m01);
        d.m02 = Math.fma(right.m02(), this.m00, Math.fma(right.m12(), this.m01, this.m02));
        d.m03 = this.m03;
        double _buf2 = Math.fma(right.m00(), this.m10, right.m10() * this.m11);
        double _buf3 = Math.fma(right.m01(), this.m10, right.m11() * this.m11);
        d.m12 = Math.fma(right.m02(), this.m10, Math.fma(right.m12(), this.m11, this.m12));
        d.m13 = this.m13;
        double _buf4 = Math.fma(right.m00(), this.m20, right.m10() * this.m21);
        double _buf5 = Math.fma(right.m01(), this.m20, right.m11() * this.m21);
        d.m22 = Math.fma(right.m02(), this.m20, Math.fma(right.m12(), this.m21, this.m22));
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m10 = _buf2;
        d.m11 = _buf3;
        d.m20 = _buf4;
        d.m21 = _buf5;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Multiply this matrix by {@code right} and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     *
     * @param right the right operand
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mul(Double2x3R right, @Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mul_identity(right, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_translation(right, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return mul_orthogonal(right, dest);
        return mul_general(right, dest);
    }


    /**
     * Multiply this matrix by {@code right}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     *
     * @param right the right operand
     * @return this
     */
    @Mutated public Double3x4 mul(Double2x3R right) {
        if (Joml.RETURN_NEW) return mul(right, Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mul_identity_self(right, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_translation_self(right, this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return mul_orthogonal(right, this);
        return mul_general(right, this);
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x4 mul_identity(Double3x3R right, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = right.m00();
        d.m01 = right.m01();
        d.m02 = right.m02();
        d.m03 = 0.0;
        d.m10 = right.m10();
        d.m11 = right.m11();
        d.m12 = right.m12();
        d.m13 = 0.0;
        d.m20 = right.m20();
        d.m21 = right.m21();
        d.m22 = right.m22();
        d.m23 = 0.0;
        d.properties = (((Double3x3Impl) right).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_IDENTITY : Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mul}, specialized by runtime matrix properties;
     * reached only through the public {@code mul} dispatcher.
     */
    private Double3x4 mul_identity_self(Double3x3R right, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = right.m00();
        d.m01 = right.m01();
        d.m02 = right.m02();
        d.m10 = right.m10();
        d.m11 = right.m11();
        d.m12 = right.m12();
        d.m20 = right.m20();
        d.m21 = right.m21();
        d.m22 = right.m22();
        d.properties = (((Double3x3Impl) right).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_IDENTITY : Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x4 mul_translation(Double3x3R right, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = right.m00();
        d.m01 = right.m01();
        d.m02 = right.m02();
        d.m03 = this.m03;
        d.m10 = right.m10();
        d.m11 = right.m11();
        d.m12 = right.m12();
        d.m13 = this.m13;
        d.m20 = right.m20();
        d.m21 = right.m21();
        d.m22 = right.m22();
        d.m23 = this.m23;
        d.properties = (((Double3x3Impl) right).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_TRANSLATION : Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x4 mul_orthogonal(Double3x3R right, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = Math.fma(right.m20(), this.m02, Math.fma(right.m00(), this.m00, right.m10() * this.m01));
        double _buf1 = Math.fma(right.m21(), this.m02, Math.fma(right.m01(), this.m00, right.m11() * this.m01));
        d.m02 = Math.fma(right.m22(), this.m02, Math.fma(right.m02(), this.m00, right.m12() * this.m01));
        d.m03 = this.m03;
        double _buf2 = Math.fma(right.m20(), this.m12, Math.fma(right.m00(), this.m10, right.m10() * this.m11));
        double _buf3 = Math.fma(right.m21(), this.m12, Math.fma(right.m01(), this.m10, right.m11() * this.m11));
        d.m12 = Math.fma(right.m22(), this.m12, Math.fma(right.m02(), this.m10, right.m12() * this.m11));
        d.m13 = this.m13;
        double _buf4 = Math.fma(right.m20(), this.m22, Math.fma(right.m00(), this.m20, right.m10() * this.m21));
        double _buf5 = Math.fma(right.m21(), this.m22, Math.fma(right.m01(), this.m20, right.m11() * this.m21));
        d.m22 = Math.fma(right.m22(), this.m22, Math.fma(right.m02(), this.m20, right.m12() * this.m21));
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m10 = _buf2;
        d.m11 = _buf3;
        d.m20 = _buf4;
        d.m21 = _buf5;
        d.properties = (((Double3x3Impl) right).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_ORTHOGONAL : Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x4 mul_general(Double3x3R right, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = Math.fma(right.m20(), this.m02, Math.fma(right.m00(), this.m00, right.m10() * this.m01));
        double _buf1 = Math.fma(right.m21(), this.m02, Math.fma(right.m01(), this.m00, right.m11() * this.m01));
        d.m02 = Math.fma(right.m22(), this.m02, Math.fma(right.m02(), this.m00, right.m12() * this.m01));
        d.m03 = this.m03;
        double _buf2 = Math.fma(right.m20(), this.m12, Math.fma(right.m00(), this.m10, right.m10() * this.m11));
        double _buf3 = Math.fma(right.m21(), this.m12, Math.fma(right.m01(), this.m10, right.m11() * this.m11));
        d.m12 = Math.fma(right.m22(), this.m12, Math.fma(right.m02(), this.m10, right.m12() * this.m11));
        d.m13 = this.m13;
        double _buf4 = Math.fma(right.m20(), this.m22, Math.fma(right.m00(), this.m20, right.m10() * this.m21));
        double _buf5 = Math.fma(right.m21(), this.m22, Math.fma(right.m01(), this.m20, right.m11() * this.m21));
        d.m22 = Math.fma(right.m22(), this.m22, Math.fma(right.m02(), this.m20, right.m12() * this.m21));
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m10 = _buf2;
        d.m11 = _buf3;
        d.m20 = _buf4;
        d.m21 = _buf5;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Multiply this matrix by {@code right} and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     *
     * @param right the right operand
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mul(Double3x3R right, @Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mul_identity(right, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_translation(right, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return mul_orthogonal(right, dest);
        return mul_general(right, dest);
    }


    /**
     * Multiply this matrix by {@code right}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     *
     * @param right the right operand
     * @return this
     */
    @Mutated public Double3x4 mul(Double3x3R right) {
        if (Joml.RETURN_NEW) return mul(right, Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mul_identity_self(right, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_translation(right, this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return mul_orthogonal(right, this);
        return mul_general(right, this);
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double4x4 mul_general(Double4x4R right, @Mutated Double4x4 dest, int _props) {
        Double4x4Impl d = (Double4x4Impl) dest;
        double _buf0 = Math.fma(right.m30(), this.m03, Math.fma(right.m20(), this.m02, Math.fma(right.m00(), this.m00, right.m10() * this.m01)));
        double _buf1 = Math.fma(right.m30(), this.m13, Math.fma(right.m20(), this.m12, Math.fma(right.m00(), this.m10, right.m10() * this.m11)));
        double _buf2 = Math.fma(right.m30(), this.m23, Math.fma(right.m20(), this.m22, Math.fma(right.m00(), this.m20, right.m10() * this.m21)));
        d.m30 = right.m30();
        double _buf3 = Math.fma(right.m31(), this.m03, Math.fma(right.m21(), this.m02, Math.fma(right.m01(), this.m00, right.m11() * this.m01)));
        double _buf4 = Math.fma(right.m31(), this.m13, Math.fma(right.m21(), this.m12, Math.fma(right.m01(), this.m10, right.m11() * this.m11)));
        double _buf5 = Math.fma(right.m31(), this.m23, Math.fma(right.m21(), this.m22, Math.fma(right.m01(), this.m20, right.m11() * this.m21)));
        d.m31 = right.m31();
        double _buf6 = Math.fma(right.m32(), this.m03, Math.fma(right.m22(), this.m02, Math.fma(right.m02(), this.m00, right.m12() * this.m01)));
        double _buf7 = Math.fma(right.m32(), this.m13, Math.fma(right.m22(), this.m12, Math.fma(right.m02(), this.m10, right.m12() * this.m11)));
        double _buf8 = Math.fma(right.m32(), this.m23, Math.fma(right.m22(), this.m22, Math.fma(right.m02(), this.m20, right.m12() * this.m21)));
        d.m32 = right.m32();
        double _buf9 = Math.fma(right.m33(), this.m03, Math.fma(right.m23(), this.m02, Math.fma(right.m03(), this.m00, right.m13() * this.m01)));
        double _buf10 = Math.fma(right.m33(), this.m13, Math.fma(right.m23(), this.m12, Math.fma(right.m03(), this.m10, right.m13() * this.m11)));
        d.m23 = Math.fma(right.m33(), this.m23, Math.fma(right.m23(), this.m22, Math.fma(right.m03(), this.m20, right.m13() * this.m21)));
        d.m33 = right.m33();
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.m02 = _buf6;
        d.m12 = _buf7;
        d.m22 = _buf8;
        d.m03 = _buf9;
        d.m13 = _buf10;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double4x4 mul_translation(Double4x4R right, @Mutated Double4x4 dest) {
        Double4x4Impl d = (Double4x4Impl) dest;
        d.m00 = Math.fma(right.m30(), this.m03, right.m00());
        d.m10 = Math.fma(right.m30(), this.m13, right.m10());
        d.m20 = Math.fma(right.m30(), this.m23, right.m20());
        d.m30 = right.m30();
        d.m01 = Math.fma(right.m31(), this.m03, right.m01());
        d.m11 = Math.fma(right.m31(), this.m13, right.m11());
        d.m21 = Math.fma(right.m31(), this.m23, right.m21());
        d.m31 = right.m31();
        d.m02 = Math.fma(right.m32(), this.m03, right.m02());
        d.m12 = Math.fma(right.m32(), this.m13, right.m12());
        d.m22 = Math.fma(right.m32(), this.m23, right.m22());
        d.m32 = right.m32();
        d.m03 = Math.fma(right.m33(), this.m03, right.m03());
        d.m13 = Math.fma(right.m33(), this.m13, right.m13());
        d.m23 = Math.fma(right.m33(), this.m23, right.m23());
        d.m33 = right.m33();
        d.properties = Joml.BIT_TRANSLATION & ((Double4x4Impl) right).properties;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double4x4 mul_translation_identity(Double4x4R right, @Mutated Double4x4 dest) {
        Double4x4Impl d = (Double4x4Impl) dest;
        d.m00 = 1.0;
        d.m10 = 0.0;
        d.m20 = 0.0;
        d.m30 = 0.0;
        d.m01 = 0.0;
        d.m11 = 1.0;
        d.m21 = 0.0;
        d.m31 = 0.0;
        d.m02 = 0.0;
        d.m12 = 0.0;
        d.m22 = 1.0;
        d.m32 = 0.0;
        d.m03 = this.m03;
        d.m13 = this.m13;
        d.m23 = this.m23;
        d.m33 = 1.0;
        d.properties = Joml.BIT_TRANSLATION & ((Double4x4Impl) right).properties;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double4x4 mul_translation_translation(Double4x4R right, @Mutated Double4x4 dest) {
        Double4x4Impl d = (Double4x4Impl) dest;
        d.m00 = 1.0;
        d.m10 = 0.0;
        d.m20 = 0.0;
        d.m30 = 0.0;
        d.m01 = 0.0;
        d.m11 = 1.0;
        d.m21 = 0.0;
        d.m31 = 0.0;
        d.m02 = 0.0;
        d.m12 = 0.0;
        d.m22 = 1.0;
        d.m32 = 0.0;
        d.m03 = right.m03() + this.m03;
        d.m13 = right.m13() + this.m13;
        d.m23 = right.m23() + this.m23;
        d.m33 = 1.0;
        d.properties = Joml.BIT_TRANSLATION & ((Double4x4Impl) right).properties;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double4x4 mul_orthogonal_identity(Double4x4R right, @Mutated Double4x4 dest, int _props) {
        Double4x4Impl d = (Double4x4Impl) dest;
        d.m00 = this.m00;
        d.m10 = this.m10;
        d.m20 = this.m20;
        d.m30 = 0.0;
        d.m01 = this.m01;
        d.m11 = this.m11;
        d.m21 = this.m21;
        d.m31 = 0.0;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = this.m22;
        d.m32 = 0.0;
        d.m03 = this.m03;
        d.m13 = this.m13;
        d.m23 = this.m23;
        d.m33 = 1.0;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double4x4 mul_orthogonal_translation(Double4x4R right, @Mutated Double4x4 dest, int _props) {
        Double4x4Impl d = (Double4x4Impl) dest;
        double _buf0 = this.m00;
        double _buf1 = this.m10;
        double _buf2 = this.m20;
        d.m30 = 0.0;
        double _buf3 = this.m01;
        double _buf4 = this.m11;
        double _buf5 = this.m21;
        d.m31 = 0.0;
        double _buf6 = this.m02;
        double _buf7 = this.m12;
        double _buf8 = this.m22;
        d.m32 = 0.0;
        double _buf9 = Math.fma(right.m03(), this.m00, Math.fma(right.m13(), this.m01, Math.fma(right.m23(), this.m02, this.m03)));
        double _buf10 = Math.fma(right.m03(), this.m10, Math.fma(right.m13(), this.m11, Math.fma(right.m23(), this.m12, this.m13)));
        d.m23 = Math.fma(right.m03(), this.m20, Math.fma(right.m13(), this.m21, Math.fma(right.m23(), this.m22, this.m23)));
        d.m33 = 1.0;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.m02 = _buf6;
        d.m12 = _buf7;
        d.m22 = _buf8;
        d.m03 = _buf9;
        d.m13 = _buf10;
        d.properties = _props;
        return d;
    }


    /**
     * Multiply this matrix by the given matrix and store the result in {@code dest}.
     *
     * @param right the right operand
     * @param dest will hold the result
     * @return dest
     */
    public Double4x4 mul(Double4x4R right, @Mutated Double4x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return dest.set(right);
        int q = ((Double4x4Impl) right).properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mul_translation_identity(right, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_translation_translation(right, dest);
            return mul_translation(right, dest);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mul_orthogonal_identity(right, dest, Joml.BIT_ORTHOGONAL & q);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_orthogonal_translation(right, dest, Joml.BIT_ORTHOGONAL & q);
            return mul_general(right, dest, Joml.BIT_ORTHOGONAL & q);
        }
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mul_orthogonal_identity(right, dest, Joml.BIT_AFFINE & q);
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_orthogonal_translation(right, dest, Joml.BIT_AFFINE & q);
        return mul_general(right, dest, 0);
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x4 preMul_general(Double3x4R other, @Mutated Double3x4 dest, int _props) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = Math.fma(other.m02(), this.m20, Math.fma(other.m00(), this.m00, other.m01() * this.m10));
        double _buf1 = Math.fma(other.m02(), this.m21, Math.fma(other.m00(), this.m01, other.m01() * this.m11));
        double _buf2 = Math.fma(other.m02(), this.m22, Math.fma(other.m00(), this.m02, other.m01() * this.m12));
        double _buf3 = Math.fma(other.m00(), this.m03, Math.fma(other.m01(), this.m13, Math.fma(other.m02(), this.m23, other.m03())));
        double _buf4 = Math.fma(other.m12(), this.m20, Math.fma(other.m10(), this.m00, other.m11() * this.m10));
        double _buf5 = Math.fma(other.m12(), this.m21, Math.fma(other.m10(), this.m01, other.m11() * this.m11));
        double _buf6 = Math.fma(other.m12(), this.m22, Math.fma(other.m10(), this.m02, other.m11() * this.m12));
        double _buf7 = Math.fma(other.m10(), this.m03, Math.fma(other.m11(), this.m13, Math.fma(other.m12(), this.m23, other.m13())));
        double _buf8 = Math.fma(other.m22(), this.m20, Math.fma(other.m20(), this.m00, other.m21() * this.m10));
        double _buf9 = Math.fma(other.m22(), this.m21, Math.fma(other.m20(), this.m01, other.m21() * this.m11));
        double _buf10 = Math.fma(other.m22(), this.m22, Math.fma(other.m20(), this.m02, other.m21() * this.m12));
        d.m23 = Math.fma(other.m20(), this.m03, Math.fma(other.m21(), this.m13, Math.fma(other.m22(), this.m23, other.m23())));
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.m03 = _buf3;
        d.m10 = _buf4;
        d.m11 = _buf5;
        d.m12 = _buf6;
        d.m13 = _buf7;
        d.m20 = _buf8;
        d.m21 = _buf9;
        d.m22 = _buf10;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x4 preMul_translation(Double3x4R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = other.m00();
        double _buf1 = other.m01();
        double _buf2 = other.m02();
        double _buf3 = Math.fma(other.m00(), this.m03, Math.fma(other.m01(), this.m13, Math.fma(other.m02(), this.m23, other.m03())));
        double _buf4 = other.m10();
        double _buf5 = other.m11();
        double _buf6 = other.m12();
        double _buf7 = Math.fma(other.m10(), this.m03, Math.fma(other.m11(), this.m13, Math.fma(other.m12(), this.m23, other.m13())));
        double _buf8 = other.m20();
        double _buf9 = other.m21();
        double _buf10 = other.m22();
        d.m23 = Math.fma(other.m20(), this.m03, Math.fma(other.m21(), this.m13, Math.fma(other.m22(), this.m23, other.m23())));
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.m03 = _buf3;
        d.m10 = _buf4;
        d.m11 = _buf5;
        d.m12 = _buf6;
        d.m13 = _buf7;
        d.m20 = _buf8;
        d.m21 = _buf9;
        d.m22 = _buf10;
        d.properties = Joml.BIT_TRANSLATION & ((Double3x4Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x4 preMul_translation_translation(Double3x4R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = other.m03() + this.m03;
        d.m10 = 0.0;
        d.m11 = 1.0;
        d.m12 = 0.0;
        d.m13 = other.m13() + this.m13;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 1.0;
        d.m23 = other.m23() + this.m23;
        d.properties = Joml.BIT_TRANSLATION & ((Double3x4Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x4 preMul_orthogonal_translation(Double3x4R other, @Mutated Double3x4 dest, int _props) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = this.m00;
        d.m01 = this.m01;
        d.m02 = this.m02;
        d.m03 = other.m03() + this.m03;
        d.m10 = this.m10;
        d.m11 = this.m11;
        d.m12 = this.m12;
        d.m13 = other.m13() + this.m13;
        d.m20 = this.m20;
        d.m21 = this.m21;
        d.m22 = this.m22;
        d.m23 = other.m23() + this.m23;
        d.properties = _props;
        return d;
    }


    /**
     * Pre-multiply the transformation {@code other} onto this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the given transformation matrix, then the
     * new matrix will be {@code T * M}. So when transforming a vector {@code v} with the new matrix
     * by using {@code T * M * v}, the given transformation will be applied last.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 preMul(Double3x4R other, @Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return dest.set(other);
        int q = ((Double3x4Impl) other).properties;
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return dest.set(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_translation_translation(other, dest);
            return preMul_translation(other, dest);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_orthogonal_translation(other, dest, Joml.BIT_ORTHOGONAL & q);
            return preMul_general(other, dest, Joml.BIT_ORTHOGONAL & q);
        }
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_orthogonal_translation(other, dest, Joml.BIT_AFFINE & q);
        return preMul_general(other, dest, Joml.BIT_AFFINE & q);
    }


    /**
     * Pre-multiply the transformation {@code other} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the given transformation matrix, then the
     * new matrix will be {@code T * M}. So when transforming a vector {@code v} with the new matrix
     * by using {@code T * M * v}, the given transformation will be applied last.
     *
     * @param other the other matrix
     * @return this
     */
    @Mutated public Double3x4 preMul(Double3x4R other) {
        if (Joml.RETURN_NEW) return preMul(other, Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return this.set(other);
        int q = ((Double3x4Impl) other).properties;
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return this;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_translation_translation(other, this);
            return preMul_translation(other, this);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_orthogonal_translation(other, this, Joml.BIT_ORTHOGONAL & q);
            return preMul_general(other, this, Joml.BIT_ORTHOGONAL & q);
        }
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_orthogonal_translation(other, this, Joml.BIT_AFFINE & q);
        return preMul_general(other, this, Joml.BIT_AFFINE & q);
    }


    /**
     * Pre-multiply the transformation ({@code m00}, {@code m01}, {@code m02}, {@code m03},
     * {@code m10}, {@code m11}, {@code m12}, {@code m13}, {@code m20}, {@code m21}, {@code m22},
     * {@code m23}) onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the given transformation matrix, then the
     * new matrix will be {@code T * M}. So when transforming a vector {@code v} with the new matrix
     * by using {@code T * M * v}, the given transformation will be applied last.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m03 the element in row 0, column 3 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m13 the element in row 1, column 3 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @param m23 the element in row 2, column 3 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 preMul(double m00, double m01, double m02, double m03, double m10, double m11, double m12, double m13, double m20, double m21, double m22, double m23, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = Math.fma(m02, this.m20, Math.fma(m00, this.m00, m01 * this.m10));
        double _buf1 = Math.fma(m02, this.m21, Math.fma(m00, this.m01, m01 * this.m11));
        double _buf2 = Math.fma(m02, this.m22, Math.fma(m00, this.m02, m01 * this.m12));
        double _buf3 = Math.fma(m00, this.m03, Math.fma(m01, this.m13, Math.fma(m02, this.m23, m03)));
        double _buf4 = Math.fma(m12, this.m20, Math.fma(m10, this.m00, m11 * this.m10));
        double _buf5 = Math.fma(m12, this.m21, Math.fma(m10, this.m01, m11 * this.m11));
        double _buf6 = Math.fma(m12, this.m22, Math.fma(m10, this.m02, m11 * this.m12));
        double _buf7 = Math.fma(m10, this.m03, Math.fma(m11, this.m13, Math.fma(m12, this.m23, m13)));
        d.m20 = Math.fma(m22, this.m20, Math.fma(m20, this.m00, m21 * this.m10));
        d.m21 = Math.fma(m22, this.m21, Math.fma(m20, this.m01, m21 * this.m11));
        d.m22 = Math.fma(m22, this.m22, Math.fma(m20, this.m02, m21 * this.m12));
        d.m23 = Math.fma(m20, this.m03, Math.fma(m21, this.m13, Math.fma(m22, this.m23, m23)));
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.m03 = _buf3;
        d.m10 = _buf4;
        d.m11 = _buf5;
        d.m12 = _buf6;
        d.m13 = _buf7;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x4 preMul_identity(Double2x2R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = other.m00();
        d.m01 = other.m01();
        d.m02 = 0.0;
        d.m03 = 0.0;
        d.m10 = other.m10();
        d.m11 = other.m11();
        d.m12 = 0.0;
        d.m13 = 0.0;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 1.0;
        d.m23 = 0.0;
        d.properties = (((Double2x2Impl) other).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_IDENTITY : Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preMul}, specialized by runtime matrix properties;
     * reached only through the public {@code preMul} dispatcher.
     */
    private Double3x4 preMul_identity_self(Double2x2R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = other.m00();
        d.m01 = other.m01();
        d.m10 = other.m10();
        d.m11 = other.m11();
        d.properties = (((Double2x2Impl) other).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_IDENTITY : Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x4 preMul_translation(Double2x2R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = other.m00();
        d.m01 = other.m01();
        d.m02 = 0.0;
        double _buf0 = Math.fma(other.m00(), this.m03, other.m01() * this.m13);
        d.m10 = other.m10();
        d.m11 = other.m11();
        d.m12 = 0.0;
        d.m13 = Math.fma(other.m10(), this.m03, other.m11() * this.m13);
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 1.0;
        d.m23 = this.m23;
        d.m03 = _buf0;
        d.properties = (((Double2x2Impl) other).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_TRANSLATION : Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preMul}, specialized by runtime matrix properties;
     * reached only through the public {@code preMul} dispatcher.
     */
    private Double3x4 preMul_translation_self(Double2x2R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = other.m00();
        d.m01 = other.m01();
        double _buf0 = Math.fma(other.m00(), this.m03, other.m01() * this.m13);
        d.m10 = other.m10();
        d.m11 = other.m11();
        d.m13 = Math.fma(other.m10(), this.m03, other.m11() * this.m13);
        d.m23 = this.m23;
        d.m03 = _buf0;
        d.properties = (((Double2x2Impl) other).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_TRANSLATION : Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x4 preMul_orthogonal(Double2x2R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = Math.fma(other.m00(), this.m00, other.m01() * this.m10);
        double _buf1 = Math.fma(other.m00(), this.m01, other.m01() * this.m11);
        double _buf2 = Math.fma(other.m00(), this.m02, other.m01() * this.m12);
        double _buf3 = Math.fma(other.m00(), this.m03, other.m01() * this.m13);
        d.m10 = Math.fma(other.m10(), this.m00, other.m11() * this.m10);
        d.m11 = Math.fma(other.m10(), this.m01, other.m11() * this.m11);
        d.m12 = Math.fma(other.m10(), this.m02, other.m11() * this.m12);
        d.m13 = Math.fma(other.m10(), this.m03, other.m11() * this.m13);
        d.m20 = this.m20;
        d.m21 = this.m21;
        d.m22 = this.m22;
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.m03 = _buf3;
        d.properties = (((Double2x2Impl) other).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_ORTHOGONAL : Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x4 preMul_general(Double2x2R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = Math.fma(other.m00(), this.m00, other.m01() * this.m10);
        double _buf1 = Math.fma(other.m00(), this.m01, other.m01() * this.m11);
        double _buf2 = Math.fma(other.m00(), this.m02, other.m01() * this.m12);
        double _buf3 = Math.fma(other.m00(), this.m03, other.m01() * this.m13);
        d.m10 = Math.fma(other.m10(), this.m00, other.m11() * this.m10);
        d.m11 = Math.fma(other.m10(), this.m01, other.m11() * this.m11);
        d.m12 = Math.fma(other.m10(), this.m02, other.m11() * this.m12);
        d.m13 = Math.fma(other.m10(), this.m03, other.m11() * this.m13);
        d.m20 = this.m20;
        d.m21 = this.m21;
        d.m22 = this.m22;
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.m03 = _buf3;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Pre-multiply {@code other} onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the transformation of the operand will be applied last.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 preMul(Double2x2R other, @Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preMul_identity(other, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_translation(other, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preMul_orthogonal(other, dest);
        return preMul_general(other, dest);
    }


    /**
     * Pre-multiply {@code other} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the transformation of the operand will be applied last.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     *
     * @param other the other matrix
     * @return this
     */
    @Mutated public Double3x4 preMul(Double2x2R other) {
        if (Joml.RETURN_NEW) return preMul(other, Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preMul_identity_self(other, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_translation_self(other, this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preMul_orthogonal(other, this);
        return preMul_general(other, this);
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x4 preMul_identity(Double2x3R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = other.m00();
        d.m01 = other.m01();
        d.m02 = other.m02();
        d.m03 = 0.0;
        d.m10 = other.m10();
        d.m11 = other.m11();
        d.m12 = other.m12();
        d.m13 = 0.0;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 1.0;
        d.m23 = 0.0;
        d.properties = (((Double2x3Impl) other).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_IDENTITY : Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preMul}, specialized by runtime matrix properties;
     * reached only through the public {@code preMul} dispatcher.
     */
    private Double3x4 preMul_identity_self(Double2x3R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = other.m00();
        d.m01 = other.m01();
        d.m02 = other.m02();
        d.m10 = other.m10();
        d.m11 = other.m11();
        d.m12 = other.m12();
        d.properties = (((Double2x3Impl) other).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_IDENTITY : Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x4 preMul_translation(Double2x3R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = other.m00();
        d.m01 = other.m01();
        d.m02 = other.m02();
        double _buf0 = Math.fma(other.m02(), this.m23, Math.fma(other.m00(), this.m03, other.m01() * this.m13));
        d.m10 = other.m10();
        d.m11 = other.m11();
        d.m12 = other.m12();
        d.m13 = Math.fma(other.m12(), this.m23, Math.fma(other.m10(), this.m03, other.m11() * this.m13));
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 1.0;
        d.m23 = this.m23;
        d.m03 = _buf0;
        d.properties = (((Double2x3Impl) other).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_TRANSLATION : Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preMul}, specialized by runtime matrix properties;
     * reached only through the public {@code preMul} dispatcher.
     */
    private Double3x4 preMul_translation_self(Double2x3R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = other.m00();
        d.m01 = other.m01();
        d.m02 = other.m02();
        double _buf0 = Math.fma(other.m02(), this.m23, Math.fma(other.m00(), this.m03, other.m01() * this.m13));
        d.m10 = other.m10();
        d.m11 = other.m11();
        d.m12 = other.m12();
        d.m13 = Math.fma(other.m12(), this.m23, Math.fma(other.m10(), this.m03, other.m11() * this.m13));
        d.m23 = this.m23;
        d.m03 = _buf0;
        d.properties = (((Double2x3Impl) other).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_TRANSLATION : Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x4 preMul_orthogonal(Double2x3R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = Math.fma(other.m02(), this.m20, Math.fma(other.m00(), this.m00, other.m01() * this.m10));
        double _buf1 = Math.fma(other.m02(), this.m21, Math.fma(other.m00(), this.m01, other.m01() * this.m11));
        double _buf2 = Math.fma(other.m02(), this.m22, Math.fma(other.m00(), this.m02, other.m01() * this.m12));
        double _buf3 = Math.fma(other.m02(), this.m23, Math.fma(other.m00(), this.m03, other.m01() * this.m13));
        d.m10 = Math.fma(other.m12(), this.m20, Math.fma(other.m10(), this.m00, other.m11() * this.m10));
        d.m11 = Math.fma(other.m12(), this.m21, Math.fma(other.m10(), this.m01, other.m11() * this.m11));
        d.m12 = Math.fma(other.m12(), this.m22, Math.fma(other.m10(), this.m02, other.m11() * this.m12));
        d.m13 = Math.fma(other.m12(), this.m23, Math.fma(other.m10(), this.m03, other.m11() * this.m13));
        d.m20 = this.m20;
        d.m21 = this.m21;
        d.m22 = this.m22;
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.m03 = _buf3;
        d.properties = (((Double2x3Impl) other).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_ORTHOGONAL : Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x4 preMul_general(Double2x3R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = Math.fma(other.m02(), this.m20, Math.fma(other.m00(), this.m00, other.m01() * this.m10));
        double _buf1 = Math.fma(other.m02(), this.m21, Math.fma(other.m00(), this.m01, other.m01() * this.m11));
        double _buf2 = Math.fma(other.m02(), this.m22, Math.fma(other.m00(), this.m02, other.m01() * this.m12));
        double _buf3 = Math.fma(other.m02(), this.m23, Math.fma(other.m00(), this.m03, other.m01() * this.m13));
        d.m10 = Math.fma(other.m12(), this.m20, Math.fma(other.m10(), this.m00, other.m11() * this.m10));
        d.m11 = Math.fma(other.m12(), this.m21, Math.fma(other.m10(), this.m01, other.m11() * this.m11));
        d.m12 = Math.fma(other.m12(), this.m22, Math.fma(other.m10(), this.m02, other.m11() * this.m12));
        d.m13 = Math.fma(other.m12(), this.m23, Math.fma(other.m10(), this.m03, other.m11() * this.m13));
        d.m20 = this.m20;
        d.m21 = this.m21;
        d.m22 = this.m22;
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.m03 = _buf3;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Pre-multiply {@code other} onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the transformation of the operand will be applied last.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 preMul(Double2x3R other, @Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preMul_identity(other, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_translation(other, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preMul_orthogonal(other, dest);
        return preMul_general(other, dest);
    }


    /**
     * Pre-multiply {@code other} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the transformation of the operand will be applied last.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     *
     * @param other the other matrix
     * @return this
     */
    @Mutated public Double3x4 preMul(Double2x3R other) {
        if (Joml.RETURN_NEW) return preMul(other, Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preMul_identity_self(other, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_translation_self(other, this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preMul_orthogonal(other, this);
        return preMul_general(other, this);
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x4 preMul_identity(Double3x3R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = other.m00();
        d.m01 = other.m01();
        d.m02 = other.m02();
        d.m03 = 0.0;
        d.m10 = other.m10();
        d.m11 = other.m11();
        d.m12 = other.m12();
        d.m13 = 0.0;
        d.m20 = other.m20();
        d.m21 = other.m21();
        d.m22 = other.m22();
        d.m23 = 0.0;
        d.properties = (((Double3x3Impl) other).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_IDENTITY : Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preMul}, specialized by runtime matrix properties;
     * reached only through the public {@code preMul} dispatcher.
     */
    private Double3x4 preMul_identity_self(Double3x3R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = other.m00();
        d.m01 = other.m01();
        d.m02 = other.m02();
        d.m10 = other.m10();
        d.m11 = other.m11();
        d.m12 = other.m12();
        d.m20 = other.m20();
        d.m21 = other.m21();
        d.m22 = other.m22();
        d.properties = (((Double3x3Impl) other).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_IDENTITY : Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x4 preMul_translation(Double3x3R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = other.m00();
        d.m01 = other.m01();
        d.m02 = other.m02();
        double _buf0 = Math.fma(other.m02(), this.m23, Math.fma(other.m00(), this.m03, other.m01() * this.m13));
        d.m10 = other.m10();
        d.m11 = other.m11();
        d.m12 = other.m12();
        double _buf1 = Math.fma(other.m12(), this.m23, Math.fma(other.m10(), this.m03, other.m11() * this.m13));
        d.m20 = other.m20();
        d.m21 = other.m21();
        d.m22 = other.m22();
        d.m23 = Math.fma(other.m22(), this.m23, Math.fma(other.m20(), this.m03, other.m21() * this.m13));
        d.m03 = _buf0;
        d.m13 = _buf1;
        d.properties = (((Double3x3Impl) other).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_TRANSLATION : Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x4 preMul_orthogonal(Double3x3R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = Math.fma(other.m02(), this.m20, Math.fma(other.m00(), this.m00, other.m01() * this.m10));
        double _buf1 = Math.fma(other.m02(), this.m21, Math.fma(other.m00(), this.m01, other.m01() * this.m11));
        double _buf2 = Math.fma(other.m02(), this.m22, Math.fma(other.m00(), this.m02, other.m01() * this.m12));
        double _buf3 = Math.fma(other.m02(), this.m23, Math.fma(other.m00(), this.m03, other.m01() * this.m13));
        double _buf4 = Math.fma(other.m12(), this.m20, Math.fma(other.m10(), this.m00, other.m11() * this.m10));
        double _buf5 = Math.fma(other.m12(), this.m21, Math.fma(other.m10(), this.m01, other.m11() * this.m11));
        double _buf6 = Math.fma(other.m12(), this.m22, Math.fma(other.m10(), this.m02, other.m11() * this.m12));
        double _buf7 = Math.fma(other.m12(), this.m23, Math.fma(other.m10(), this.m03, other.m11() * this.m13));
        d.m20 = Math.fma(other.m22(), this.m20, Math.fma(other.m20(), this.m00, other.m21() * this.m10));
        d.m21 = Math.fma(other.m22(), this.m21, Math.fma(other.m20(), this.m01, other.m21() * this.m11));
        d.m22 = Math.fma(other.m22(), this.m22, Math.fma(other.m20(), this.m02, other.m21() * this.m12));
        d.m23 = Math.fma(other.m22(), this.m23, Math.fma(other.m20(), this.m03, other.m21() * this.m13));
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.m03 = _buf3;
        d.m10 = _buf4;
        d.m11 = _buf5;
        d.m12 = _buf6;
        d.m13 = _buf7;
        d.properties = (((Double3x3Impl) other).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_ORTHOGONAL : Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x4 preMul_general(Double3x3R other, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = Math.fma(other.m02(), this.m20, Math.fma(other.m00(), this.m00, other.m01() * this.m10));
        double _buf1 = Math.fma(other.m02(), this.m21, Math.fma(other.m00(), this.m01, other.m01() * this.m11));
        double _buf2 = Math.fma(other.m02(), this.m22, Math.fma(other.m00(), this.m02, other.m01() * this.m12));
        double _buf3 = Math.fma(other.m02(), this.m23, Math.fma(other.m00(), this.m03, other.m01() * this.m13));
        double _buf4 = Math.fma(other.m12(), this.m20, Math.fma(other.m10(), this.m00, other.m11() * this.m10));
        double _buf5 = Math.fma(other.m12(), this.m21, Math.fma(other.m10(), this.m01, other.m11() * this.m11));
        double _buf6 = Math.fma(other.m12(), this.m22, Math.fma(other.m10(), this.m02, other.m11() * this.m12));
        double _buf7 = Math.fma(other.m12(), this.m23, Math.fma(other.m10(), this.m03, other.m11() * this.m13));
        d.m20 = Math.fma(other.m22(), this.m20, Math.fma(other.m20(), this.m00, other.m21() * this.m10));
        d.m21 = Math.fma(other.m22(), this.m21, Math.fma(other.m20(), this.m01, other.m21() * this.m11));
        d.m22 = Math.fma(other.m22(), this.m22, Math.fma(other.m20(), this.m02, other.m21() * this.m12));
        d.m23 = Math.fma(other.m22(), this.m23, Math.fma(other.m20(), this.m03, other.m21() * this.m13));
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.m03 = _buf3;
        d.m10 = _buf4;
        d.m11 = _buf5;
        d.m12 = _buf6;
        d.m13 = _buf7;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Pre-multiply {@code other} onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the transformation of the operand will be applied last.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 preMul(Double3x3R other, @Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preMul_identity(other, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_translation(other, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preMul_orthogonal(other, dest);
        return preMul_general(other, dest);
    }


    /**
     * Pre-multiply {@code other} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the transformation of the operand will be applied last.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     *
     * @param other the other matrix
     * @return this
     */
    @Mutated public Double3x4 preMul(Double3x3R other) {
        if (Joml.RETURN_NEW) return preMul(other, Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preMul_identity_self(other, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_translation(other, this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preMul_orthogonal(other, this);
        return preMul_general(other, this);
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double4x4 preMul_general(Double4x4R other, @Mutated Double4x4 dest, int _props) {
        Double4x4Impl d = (Double4x4Impl) dest;
        double _buf0 = Math.fma(other.m02(), this.m20, Math.fma(other.m00(), this.m00, other.m01() * this.m10));
        double _buf1 = Math.fma(other.m12(), this.m20, Math.fma(other.m10(), this.m00, other.m11() * this.m10));
        double _buf2 = Math.fma(other.m22(), this.m20, Math.fma(other.m20(), this.m00, other.m21() * this.m10));
        double _buf3 = Math.fma(other.m32(), this.m20, Math.fma(other.m30(), this.m00, other.m31() * this.m10));
        double _buf4 = Math.fma(other.m02(), this.m21, Math.fma(other.m00(), this.m01, other.m01() * this.m11));
        double _buf5 = Math.fma(other.m12(), this.m21, Math.fma(other.m10(), this.m01, other.m11() * this.m11));
        double _buf6 = Math.fma(other.m22(), this.m21, Math.fma(other.m20(), this.m01, other.m21() * this.m11));
        double _buf7 = Math.fma(other.m32(), this.m21, Math.fma(other.m30(), this.m01, other.m31() * this.m11));
        double _buf8 = Math.fma(other.m02(), this.m22, Math.fma(other.m00(), this.m02, other.m01() * this.m12));
        double _buf9 = Math.fma(other.m12(), this.m22, Math.fma(other.m10(), this.m02, other.m11() * this.m12));
        double _buf10 = Math.fma(other.m22(), this.m22, Math.fma(other.m20(), this.m02, other.m21() * this.m12));
        double _buf11 = Math.fma(other.m32(), this.m22, Math.fma(other.m30(), this.m02, other.m31() * this.m12));
        double _buf12 = Math.fma(other.m00(), this.m03, Math.fma(other.m01(), this.m13, Math.fma(other.m02(), this.m23, other.m03())));
        double _buf13 = Math.fma(other.m10(), this.m03, Math.fma(other.m11(), this.m13, Math.fma(other.m12(), this.m23, other.m13())));
        double _buf14 = Math.fma(other.m20(), this.m03, Math.fma(other.m21(), this.m13, Math.fma(other.m22(), this.m23, other.m23())));
        d.m33 = Math.fma(other.m30(), this.m03, Math.fma(other.m31(), this.m13, Math.fma(other.m32(), this.m23, other.m33())));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m30 = _buf3;
        d.m01 = _buf4;
        d.m11 = _buf5;
        d.m21 = _buf6;
        d.m31 = _buf7;
        d.m02 = _buf8;
        d.m12 = _buf9;
        d.m22 = _buf10;
        d.m32 = _buf11;
        d.m03 = _buf12;
        d.m13 = _buf13;
        d.m23 = _buf14;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double4x4 preMul_translation(Double4x4R other, @Mutated Double4x4 dest) {
        Double4x4Impl d = (Double4x4Impl) dest;
        double _buf0 = other.m00();
        double _buf1 = other.m10();
        double _buf2 = other.m20();
        double _buf3 = other.m30();
        double _buf4 = other.m01();
        double _buf5 = other.m11();
        double _buf6 = other.m21();
        double _buf7 = other.m31();
        double _buf8 = other.m02();
        double _buf9 = other.m12();
        double _buf10 = other.m22();
        double _buf11 = other.m32();
        double _buf12 = Math.fma(other.m00(), this.m03, Math.fma(other.m01(), this.m13, Math.fma(other.m02(), this.m23, other.m03())));
        double _buf13 = Math.fma(other.m10(), this.m03, Math.fma(other.m11(), this.m13, Math.fma(other.m12(), this.m23, other.m13())));
        double _buf14 = Math.fma(other.m20(), this.m03, Math.fma(other.m21(), this.m13, Math.fma(other.m22(), this.m23, other.m23())));
        d.m33 = Math.fma(other.m30(), this.m03, Math.fma(other.m31(), this.m13, Math.fma(other.m32(), this.m23, other.m33())));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m30 = _buf3;
        d.m01 = _buf4;
        d.m11 = _buf5;
        d.m21 = _buf6;
        d.m31 = _buf7;
        d.m02 = _buf8;
        d.m12 = _buf9;
        d.m22 = _buf10;
        d.m32 = _buf11;
        d.m03 = _buf12;
        d.m13 = _buf13;
        d.m23 = _buf14;
        d.properties = Joml.BIT_TRANSLATION & ((Double4x4Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double4x4 preMul_translation_identity(Double4x4R other, @Mutated Double4x4 dest) {
        Double4x4Impl d = (Double4x4Impl) dest;
        d.m00 = 1.0;
        d.m10 = 0.0;
        d.m20 = 0.0;
        d.m30 = 0.0;
        d.m01 = 0.0;
        d.m11 = 1.0;
        d.m21 = 0.0;
        d.m31 = 0.0;
        d.m02 = 0.0;
        d.m12 = 0.0;
        d.m22 = 1.0;
        d.m32 = 0.0;
        d.m03 = this.m03;
        d.m13 = this.m13;
        d.m23 = this.m23;
        d.m33 = 1.0;
        d.properties = Joml.BIT_TRANSLATION & ((Double4x4Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double4x4 preMul_translation_translation(Double4x4R other, @Mutated Double4x4 dest) {
        Double4x4Impl d = (Double4x4Impl) dest;
        d.m00 = 1.0;
        d.m10 = 0.0;
        d.m20 = 0.0;
        d.m30 = 0.0;
        d.m01 = 0.0;
        d.m11 = 1.0;
        d.m21 = 0.0;
        d.m31 = 0.0;
        d.m02 = 0.0;
        d.m12 = 0.0;
        d.m22 = 1.0;
        d.m32 = 0.0;
        d.m03 = other.m03() + this.m03;
        d.m13 = other.m13() + this.m13;
        d.m23 = other.m23() + this.m23;
        d.m33 = 1.0;
        d.properties = Joml.BIT_TRANSLATION & ((Double4x4Impl) other).properties;
        return d;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double4x4 preMul_orthogonal_identity(Double4x4R other, @Mutated Double4x4 dest, int _props) {
        Double4x4Impl d = (Double4x4Impl) dest;
        d.m00 = this.m00;
        d.m10 = this.m10;
        d.m20 = this.m20;
        d.m30 = 0.0;
        d.m01 = this.m01;
        d.m11 = this.m11;
        d.m21 = this.m21;
        d.m31 = 0.0;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = this.m22;
        d.m32 = 0.0;
        d.m03 = this.m03;
        d.m13 = this.m13;
        d.m23 = this.m23;
        d.m33 = 1.0;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double4x4 preMul_orthogonal_translation(Double4x4R other, @Mutated Double4x4 dest, int _props) {
        Double4x4Impl d = (Double4x4Impl) dest;
        d.m00 = this.m00;
        d.m10 = this.m10;
        d.m20 = this.m20;
        d.m30 = 0.0;
        d.m01 = this.m01;
        d.m11 = this.m11;
        d.m21 = this.m21;
        d.m31 = 0.0;
        d.m02 = this.m02;
        d.m12 = this.m12;
        d.m22 = this.m22;
        d.m32 = 0.0;
        d.m03 = other.m03() + this.m03;
        d.m13 = other.m13() + this.m13;
        d.m23 = other.m23() + this.m23;
        d.m33 = 1.0;
        d.properties = _props;
        return d;
    }


    /**
     * Pre-multiply the given matrix onto this matrix, i.e. compute {@code other * this} and store
     * the result in {@code dest}.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double4x4 preMul(Double4x4R other, @Mutated Double4x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return dest.set(other);
        int q = ((Double4x4Impl) other).properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preMul_translation_identity(other, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_translation_translation(other, dest);
            return preMul_translation(other, dest);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preMul_orthogonal_identity(other, dest, Joml.BIT_ORTHOGONAL & q);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_orthogonal_translation(other, dest, Joml.BIT_ORTHOGONAL & q);
            return preMul_general(other, dest, Joml.BIT_ORTHOGONAL & q);
        }
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preMul_orthogonal_identity(other, dest, Joml.BIT_AFFINE & q);
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_orthogonal_translation(other, dest, Joml.BIT_AFFINE & q);
        return preMul_general(other, dest, 0);
    }


    /**
     * Set this matrix to a transformation composed of the given translation, rotation and scale,
     * applied in scale-rotation-translation order.
     *
     * @param translation the vector
     * @param rotation the quaternion (must be a unit quaternion)
     * @param scale the scale factor
     * @return this
     */
    public @Mutated Double3x4 composeTRS(Double3R translation, DoubleQuatR rotation, Double3R scale) {
        return composeTRS(translation.x(), translation.y(), translation.z(), rotation.x(), rotation.y(), rotation.z(), rotation.w(), scale.x(), scale.y(), scale.z());
    }


    /**
     * Set this matrix to a transformation composed of the given translation, rotation and scale,
     * applied in scale-rotation-translation order.
     *
     * @param translationX the {@code x} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationY the {@code y} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationZ the {@code z} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param rotationX the {@code x} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)} (the quaternion must have unit
     *        length)
     * @param rotationY the {@code y} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)} (the quaternion must have unit
     *        length)
     * @param rotationZ the {@code z} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)} (the quaternion must have unit
     *        length)
     * @param rotationW the {@code w} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)} (the quaternion must have unit
     *        length)
     * @param scaleX the {@code x} component of the vector {@code (scaleX, scaleY, scaleZ)}
     * @param scaleY the {@code y} component of the vector {@code (scaleX, scaleY, scaleZ)}
     * @param scaleZ the {@code z} component of the vector {@code (scaleX, scaleY, scaleZ)}
     * @return this
     */
    @Mutated public Double3x4 composeTRS(double translationX, double translationY, double translationZ, double rotationX, double rotationY, double rotationZ, double rotationW, double scaleX, double scaleY, double scaleZ) {
        double _t0 = rotationZ * rotationZ;
        double _t1 = rotationZ * rotationW;
        double _t2 = rotationY * rotationW;
        this.m00 = scaleX * Math.fma(-2.0, Math.fma(rotationY, rotationY, _t0), 1.0);
        this.m01 = scaleY * 2.0 * Math.fma(rotationX, rotationY, -_t1);
        this.m02 = scaleZ * 2.0 * Math.fma(rotationX, rotationZ, _t2);
        this.m03 = translationX;
        this.m10 = scaleX * 2.0 * Math.fma(rotationX, rotationY, _t1);
        this.m11 = scaleY * Math.fma(-2.0, Math.fma(rotationX, rotationX, _t0), 1.0);
        this.m12 = scaleZ * 2.0 * Math.fma(rotationY, rotationZ, -(rotationX * rotationW));
        this.m13 = translationY;
        this.m20 = scaleX * 2.0 * Math.fma(rotationX, rotationZ, -_t2);
        this.m21 = scaleY * 2.0 * Math.fma(rotationX, rotationW, rotationY * rotationZ);
        this.m22 = scaleZ * Math.fma(-2.0, Math.fma(rotationX, rotationX, rotationY * rotationY), 1.0);
        this.m23 = translationZ;
        this.properties = Joml.BIT_AFFINE;
        return this;
    }


    /**
     * Set this matrix to a transformation composed of the given translation, rotation and scale
     * (applied in scale-rotation-translation order), post-multiplied by the given matrix.
     *
     * @param translation the vector
     * @param rotation the quaternion (must be a unit quaternion)
     * @param scale the scale factor
     * @param m the matrix
     * @return this
     */
    public @Mutated Double3x4 composeTRSMul(Double3R translation, DoubleQuatR rotation, Double3R scale, Double3x4R m) {
        return composeTRSMul(translation.x(), translation.y(), translation.z(), rotation.x(), rotation.y(), rotation.z(), rotation.w(), scale.x(), scale.y(), scale.z(), m);
    }


    /**
     * Set this matrix to a transformation composed of the given translation, rotation and scale
     * (applied in scale-rotation-translation order), post-multiplied by the given matrix.
     *
     * @param translationX the {@code x} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationY the {@code y} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationZ the {@code z} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param rotationX the {@code x} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)} (the quaternion must have unit
     *        length)
     * @param rotationY the {@code y} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)} (the quaternion must have unit
     *        length)
     * @param rotationZ the {@code z} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)} (the quaternion must have unit
     *        length)
     * @param rotationW the {@code w} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)} (the quaternion must have unit
     *        length)
     * @param scaleX the {@code x} component of the vector {@code (scaleX, scaleY, scaleZ)}
     * @param scaleY the {@code y} component of the vector {@code (scaleX, scaleY, scaleZ)}
     * @param scaleZ the {@code z} component of the vector {@code (scaleX, scaleY, scaleZ)}
     * @param m the matrix
     * @return this
     */
    @Mutated public Double3x4 composeTRSMul(double translationX, double translationY, double translationZ, double rotationX, double rotationY, double rotationZ, double rotationW, double scaleX, double scaleY, double scaleZ, Double3x4R m) {
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
        double _buf0 = Math.fma(m.m20(), _t27, Math.fma(m.m00(), _t33, m.m10() * _t30));
        double _buf1 = Math.fma(m.m21(), _t27, Math.fma(m.m01(), _t33, m.m11() * _t30));
        double _buf2 = Math.fma(m.m22(), _t27, Math.fma(m.m02(), _t33, m.m12() * _t30));
        double _buf3 = Math.fma(m.m03(), _t33, Math.fma(m.m13(), _t30, Math.fma(m.m23(), _t27, translationX)));
        double _buf4 = Math.fma(m.m20(), _t31, Math.fma(m.m00(), _t28, m.m10() * _t34));
        double _buf5 = Math.fma(m.m21(), _t31, Math.fma(m.m01(), _t28, m.m11() * _t34));
        double _buf6 = Math.fma(m.m22(), _t31, Math.fma(m.m02(), _t28, m.m12() * _t34));
        double _buf7 = Math.fma(m.m03(), _t28, Math.fma(m.m13(), _t34, Math.fma(m.m23(), _t31, translationY)));
        this.m20 = Math.fma(m.m20(), _t35, Math.fma(m.m00(), _t32, m.m10() * _t29));
        this.m21 = Math.fma(m.m21(), _t35, Math.fma(m.m01(), _t32, m.m11() * _t29));
        this.m22 = Math.fma(m.m22(), _t35, Math.fma(m.m02(), _t32, m.m12() * _t29));
        this.m23 = Math.fma(m.m03(), _t32, Math.fma(m.m13(), _t29, Math.fma(m.m23(), _t35, translationZ)));
        this.m00 = _buf0;
        this.m01 = _buf1;
        this.m02 = _buf2;
        this.m03 = _buf3;
        this.m10 = _buf4;
        this.m11 = _buf5;
        this.m12 = _buf6;
        this.m13 = _buf7;
        this.properties = Joml.BIT_AFFINE;
        return this;
    }


    /**
     * Apply a rotation transformation that makes {@code +z} point along {@code dir} to this matrix
     * and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code L} the "look along" matrix, then the new
     * matrix will be {@code M * L}. So when transforming a vector {@code v} with the new matrix by
     * using {@code M * L * v}, the "look along" will be applied first.
     *
     * @param dir the direction
     * @param up the direction of "up"
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 lookAlong(Double3R dir, Double3R up, @Mutated Double3x4 dest) {
        return lookAlong(dir.x(), dir.y(), dir.z(), up.x(), up.y(), up.z(), dest);
    }


    /**
     * Apply a rotation transformation that makes {@code +z} point along {@code dir} to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code L} the "look along" matrix, then the new
     * matrix will be {@code M * L}. So when transforming a vector {@code v} with the new matrix by
     * using {@code M * L * v}, the "look along" will be applied first.
     *
     * @param dir the direction
     * @param up the direction of "up"
     * @return this
     */
    public @Mutated Double3x4 lookAlong(Double3R dir, Double3R up) {
        return lookAlong(dir.x(), dir.y(), dir.z(), up.x(), up.y(), up.z());
    }


    /**
     * Private body of {@code lookAlong}, specialized by runtime matrix properties; reached only
     * through the public {@code lookAlong} dispatcher.
     */
    private Double3x4 lookAlong_identity(double dirX, double dirY, double dirZ, double upX, double upY, double upZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7, _t8, _t9;
        if (_t2 > 0.0) {
            _t7 = dirY * _t3;
            _t8 = dirX * _t3;
            _t9 = dirZ * _t3;
        } else {
            _t7 = 0.0;
            _t8 = 0.0;
            _t9 = 0.0;
        }
        double _t16 = Math.fma(upX, _t7, -(upY * _t8));
        double _t17 = Math.fma(upY, _t9, -(upZ * _t7));
        double _t18 = Math.fma(upZ, _t8, -(upX * _t9));
        double _t21 = Math.fma(_t16, _t16, Math.fma(_t17, _t17, _t18 * _t18));
        double _t22 = (1.0 / Math.sqrt(_t21));
        double _t26, _t27, _t28;
        if (_t21 > 0.0) {
            _t26 = _t17 * _t22;
            _t27 = _t16 * _t22;
            _t28 = _t18 * _t22;
        } else {
            _t26 = 0.0;
            _t27 = 0.0;
            _t28 = 0.0;
        }
        d.m00 = _t26;
        d.m01 = Math.fma(_t7, _t27, -(_t9 * _t28));
        d.m02 = _t8;
        d.m03 = 0.0;
        d.m10 = _t28;
        d.m11 = Math.fma(_t9, _t26, -(_t8 * _t27));
        d.m12 = _t7;
        d.m13 = 0.0;
        d.m20 = _t27;
        d.m21 = Math.fma(_t8, _t28, -(_t7 * _t26));
        d.m22 = _t9;
        d.m23 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code lookAlong}, specialized by runtime matrix
     * properties; reached only through the public {@code lookAlong} dispatcher.
     */
    private Double3x4 lookAlong_identity_self(double dirX, double dirY, double dirZ, double upX, double upY, double upZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7, _t8, _t9;
        if (_t2 > 0.0) {
            _t7 = dirY * _t3;
            _t8 = dirX * _t3;
            _t9 = dirZ * _t3;
        } else {
            _t7 = 0.0;
            _t8 = 0.0;
            _t9 = 0.0;
        }
        double _t16 = Math.fma(upX, _t7, -(upY * _t8));
        double _t17 = Math.fma(upY, _t9, -(upZ * _t7));
        double _t18 = Math.fma(upZ, _t8, -(upX * _t9));
        double _t21 = Math.fma(_t16, _t16, Math.fma(_t17, _t17, _t18 * _t18));
        double _t22 = (1.0 / Math.sqrt(_t21));
        double _t26, _t27, _t28;
        if (_t21 > 0.0) {
            _t26 = _t17 * _t22;
            _t27 = _t16 * _t22;
            _t28 = _t18 * _t22;
        } else {
            _t26 = 0.0;
            _t27 = 0.0;
            _t28 = 0.0;
        }
        d.m00 = _t26;
        d.m01 = Math.fma(_t7, _t27, -(_t9 * _t28));
        d.m02 = _t8;
        d.m10 = _t28;
        d.m11 = Math.fma(_t9, _t26, -(_t8 * _t27));
        d.m12 = _t7;
        d.m20 = _t27;
        d.m21 = Math.fma(_t8, _t28, -(_t7 * _t26));
        d.m22 = _t9;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code lookAlong}, specialized by runtime matrix properties; reached only
     * through the public {@code lookAlong} dispatcher.
     */
    private Double3x4 lookAlong_translation(double dirX, double dirY, double dirZ, double upX, double upY, double upZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7, _t8, _t9;
        if (_t2 > 0.0) {
            _t7 = dirY * _t3;
            _t8 = dirX * _t3;
            _t9 = dirZ * _t3;
        } else {
            _t7 = 0.0;
            _t8 = 0.0;
            _t9 = 0.0;
        }
        double _t16 = Math.fma(upX, _t7, -(upY * _t8));
        double _t17 = Math.fma(upY, _t9, -(upZ * _t7));
        double _t18 = Math.fma(upZ, _t8, -(upX * _t9));
        double _t21 = Math.fma(_t16, _t16, Math.fma(_t17, _t17, _t18 * _t18));
        double _t22 = (1.0 / Math.sqrt(_t21));
        double _t26, _t27, _t28;
        if (_t21 > 0.0) {
            _t26 = _t17 * _t22;
            _t27 = _t16 * _t22;
            _t28 = _t18 * _t22;
        } else {
            _t26 = 0.0;
            _t27 = 0.0;
            _t28 = 0.0;
        }
        d.m00 = _t26;
        d.m01 = Math.fma(_t7, _t27, -(_t9 * _t28));
        d.m02 = _t8;
        d.m03 = this.m03;
        d.m10 = _t28;
        d.m11 = Math.fma(_t9, _t26, -(_t8 * _t27));
        d.m12 = _t7;
        d.m13 = this.m13;
        d.m20 = _t27;
        d.m21 = Math.fma(_t8, _t28, -(_t7 * _t26));
        d.m22 = _t9;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code lookAlong}, specialized by runtime matrix properties; reached only
     * through the public {@code lookAlong} dispatcher.
     */
    private Double3x4 lookAlong_orthogonal(double dirX, double dirY, double dirZ, double upX, double upY, double upZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7, _t8, _t9;
        if (_t2 > 0.0) {
            _t7 = dirY * _t3;
            _t8 = dirX * _t3;
            _t9 = dirZ * _t3;
        } else {
            _t7 = 0.0;
            _t8 = 0.0;
            _t9 = 0.0;
        }
        double _t16 = Math.fma(upX, _t7, -(upY * _t8));
        double _t17 = Math.fma(upY, _t9, -(upZ * _t7));
        double _t18 = Math.fma(upZ, _t8, -(upX * _t9));
        double _t21 = Math.fma(_t16, _t16, Math.fma(_t17, _t17, _t18 * _t18));
        double _t22 = (1.0 / Math.sqrt(_t21));
        double _t26, _t27, _t28;
        if (_t21 > 0.0) {
            _t26 = _t16 * _t22;
            _t27 = _t17 * _t22;
            _t28 = _t18 * _t22;
        } else {
            _t26 = 0.0;
            _t27 = 0.0;
            _t28 = 0.0;
        }
        double _t35 = Math.fma(_t8, _t28, -(_t7 * _t27));
        double _t36 = Math.fma(_t7, _t26, -(_t9 * _t28));
        double _t37 = Math.fma(_t9, _t27, -(_t8 * _t26));
        double _buf0 = Math.fma(this.m02, _t26, Math.fma(this.m00, _t27, this.m01 * _t28));
        double _buf1 = Math.fma(this.m02, _t35, Math.fma(this.m00, _t36, this.m01 * _t37));
        d.m02 = Math.fma(this.m02, _t9, Math.fma(this.m00, _t8, this.m01 * _t7));
        d.m03 = this.m03;
        double _buf2 = Math.fma(this.m12, _t26, Math.fma(this.m10, _t27, this.m11 * _t28));
        double _buf3 = Math.fma(this.m12, _t35, Math.fma(this.m10, _t36, this.m11 * _t37));
        d.m12 = Math.fma(this.m12, _t9, Math.fma(this.m10, _t8, this.m11 * _t7));
        d.m13 = this.m13;
        double _buf4 = Math.fma(this.m22, _t26, Math.fma(this.m20, _t27, this.m21 * _t28));
        double _buf5 = Math.fma(this.m22, _t35, Math.fma(this.m20, _t36, this.m21 * _t37));
        d.m22 = Math.fma(this.m22, _t9, Math.fma(this.m20, _t8, this.m21 * _t7));
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m10 = _buf2;
        d.m11 = _buf3;
        d.m20 = _buf4;
        d.m21 = _buf5;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code lookAlong}, specialized by runtime matrix properties; reached only
     * through the public {@code lookAlong} dispatcher.
     */
    private Double3x4 lookAlong_general(double dirX, double dirY, double dirZ, double upX, double upY, double upZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7, _t8, _t9;
        if (_t2 > 0.0) {
            _t7 = dirY * _t3;
            _t8 = dirX * _t3;
            _t9 = dirZ * _t3;
        } else {
            _t7 = 0.0;
            _t8 = 0.0;
            _t9 = 0.0;
        }
        double _t16 = Math.fma(upX, _t7, -(upY * _t8));
        double _t17 = Math.fma(upY, _t9, -(upZ * _t7));
        double _t18 = Math.fma(upZ, _t8, -(upX * _t9));
        double _t21 = Math.fma(_t16, _t16, Math.fma(_t17, _t17, _t18 * _t18));
        double _t22 = (1.0 / Math.sqrt(_t21));
        double _t26, _t27, _t28;
        if (_t21 > 0.0) {
            _t26 = _t16 * _t22;
            _t27 = _t17 * _t22;
            _t28 = _t18 * _t22;
        } else {
            _t26 = 0.0;
            _t27 = 0.0;
            _t28 = 0.0;
        }
        double _t35 = Math.fma(_t8, _t28, -(_t7 * _t27));
        double _t36 = Math.fma(_t7, _t26, -(_t9 * _t28));
        double _t37 = Math.fma(_t9, _t27, -(_t8 * _t26));
        double _buf0 = Math.fma(this.m02, _t26, Math.fma(this.m00, _t27, this.m01 * _t28));
        double _buf1 = Math.fma(this.m02, _t35, Math.fma(this.m00, _t36, this.m01 * _t37));
        d.m02 = Math.fma(this.m02, _t9, Math.fma(this.m00, _t8, this.m01 * _t7));
        d.m03 = this.m03;
        double _buf2 = Math.fma(this.m12, _t26, Math.fma(this.m10, _t27, this.m11 * _t28));
        double _buf3 = Math.fma(this.m12, _t35, Math.fma(this.m10, _t36, this.m11 * _t37));
        d.m12 = Math.fma(this.m12, _t9, Math.fma(this.m10, _t8, this.m11 * _t7));
        d.m13 = this.m13;
        double _buf4 = Math.fma(this.m22, _t26, Math.fma(this.m20, _t27, this.m21 * _t28));
        double _buf5 = Math.fma(this.m22, _t35, Math.fma(this.m20, _t36, this.m21 * _t37));
        d.m22 = Math.fma(this.m22, _t9, Math.fma(this.m20, _t8, this.m21 * _t7));
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m10 = _buf2;
        d.m11 = _buf3;
        d.m20 = _buf4;
        d.m21 = _buf5;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Apply a rotation transformation that makes {@code +z} point along ({@code dirX},
     * {@code dirY}, {@code dirZ}) to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code L} the "look along" matrix, then the new
     * matrix will be {@code M * L}. So when transforming a vector {@code v} with the new matrix by
     * using {@code M * L * v}, the "look along" will be applied first.
     *
     * @param dirX the {@code x} component of the vector {@code (dirX, dirY, dirZ)}
     * @param dirY the {@code y} component of the vector {@code (dirX, dirY, dirZ)}
     * @param dirZ the {@code z} component of the vector {@code (dirX, dirY, dirZ)}
     * @param upX the {@code x} component of the vector {@code (upX, upY, upZ)}
     * @param upY the {@code y} component of the vector {@code (upX, upY, upZ)}
     * @param upZ the {@code z} component of the vector {@code (upX, upY, upZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 lookAlong(double dirX, double dirY, double dirZ, double upX, double upY, double upZ, @Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return lookAlong_identity(dirX, dirY, dirZ, upX, upY, upZ, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return lookAlong_translation(dirX, dirY, dirZ, upX, upY, upZ, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return lookAlong_orthogonal(dirX, dirY, dirZ, upX, upY, upZ, dest);
        return lookAlong_general(dirX, dirY, dirZ, upX, upY, upZ, dest);
    }


    /**
     * Apply a rotation transformation that makes {@code +z} point along ({@code dirX},
     * {@code dirY}, {@code dirZ}) to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code L} the "look along" matrix, then the new
     * matrix will be {@code M * L}. So when transforming a vector {@code v} with the new matrix by
     * using {@code M * L * v}, the "look along" will be applied first.
     *
     * @param dirX the {@code x} component of the vector {@code (dirX, dirY, dirZ)}
     * @param dirY the {@code y} component of the vector {@code (dirX, dirY, dirZ)}
     * @param dirZ the {@code z} component of the vector {@code (dirX, dirY, dirZ)}
     * @param upX the {@code x} component of the vector {@code (upX, upY, upZ)}
     * @param upY the {@code y} component of the vector {@code (upX, upY, upZ)}
     * @param upZ the {@code z} component of the vector {@code (upX, upY, upZ)}
     * @return this
     */
    @Mutated public Double3x4 lookAlong(double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        if (Joml.RETURN_NEW) return lookAlong(dirX, dirY, dirZ, upX, upY, upZ, Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return lookAlong_identity_self(dirX, dirY, dirZ, upX, upY, upZ, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return lookAlong_translation(dirX, dirY, dirZ, upX, upY, upZ, this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return lookAlong_orthogonal(dirX, dirY, dirZ, upX, upY, upZ, this);
        return lookAlong_general(dirX, dirY, dirZ, upX, upY, upZ, this);
    }


    /**
     * Private body of {@code lookAt} for {@code Handedness.LEFT_HANDED}; reached only through the
     * public {@code lookAt} dispatcher.
     */
    private Double3x4 lookAt_lh(Double3R eye, Double3R center, Double3R up, @Mutated Double3x4 dest) {
        return lookAt_lh(eye.x(), eye.y(), eye.z(), center.x(), center.y(), center.z(), up.x(), up.y(), up.z(), dest);
    }


    /**
     * Private body of {@code lookAt} for {@code Handedness.LEFT_HANDED}; reached only through the
     * public {@code lookAt} dispatcher.
     */
    private @Mutated Double3x4 lookAt_lh(Double3R eye, Double3R center, Double3R up) {
        return lookAt_lh(eye.x(), eye.y(), eye.z(), center.x(), center.y(), center.z(), up.x(), up.y(), up.z());
    }


    /**
     * Private body of {@code lookAt} for {@code Handedness.LEFT_HANDED}, specialized by runtime
     * matrix properties; reached only through the public {@code lookAt} dispatcher.
     */
    private Double3x4 lookAt_lh_identity(double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
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
        d.m00 = _t29;
        d.m01 = _t30;
        d.m02 = _t31;
        d.m03 = -Math.fma(eyeZ, _t31, Math.fma(eyeX, _t29, eyeY * _t30));
        d.m10 = _t38;
        d.m11 = _t39;
        d.m12 = _t40;
        d.m13 = -Math.fma(eyeZ, _t40, Math.fma(eyeX, _t38, eyeY * _t39));
        d.m20 = _t11;
        d.m21 = _t10;
        d.m22 = _t12;
        d.m23 = -Math.fma(eyeZ, _t12, Math.fma(eyeX, _t11, eyeY * _t10));
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code lookAt} for {@code Handedness.LEFT_HANDED}, specialized by runtime
     * matrix properties; reached only through the public {@code lookAt} dispatcher.
     */
    private Double3x4 lookAt_lh_translation(double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = -eyeX;
        double _t1 = -eyeY;
        double _t2 = -eyeZ;
        double _t3 = centerZ - eyeZ;
        double _t4 = centerX - eyeX;
        double _t5 = centerY - eyeY;
        double _t8 = Math.fma(_t3, _t3, Math.fma(_t4, _t4, _t5 * _t5));
        double _t9 = (1.0 / Math.sqrt(_t8));
        double _t13, _t14, _t15;
        if (_t8 > 0.0) {
            _t13 = _t5 * _t9;
            _t14 = _t4 * _t9;
            _t15 = _t3 * _t9;
        } else {
            _t13 = 0.0;
            _t14 = 0.0;
            _t15 = 0.0;
        }
        double _t22 = Math.fma(upX, _t13, -(upY * _t14));
        double _t23 = Math.fma(upY, _t15, -(upZ * _t13));
        double _t24 = Math.fma(upZ, _t14, -(upX * _t15));
        double _t27 = Math.fma(_t22, _t22, Math.fma(_t23, _t23, _t24 * _t24));
        double _t28 = (1.0 / Math.sqrt(_t27));
        double _t32, _t33, _t34;
        if (_t27 > 0.0) {
            _t32 = _t23 * _t28;
            _t33 = _t24 * _t28;
            _t34 = _t22 * _t28;
        } else {
            _t32 = 0.0;
            _t33 = 0.0;
            _t34 = 0.0;
        }
        double _t41 = Math.fma(_t13, _t34, -(_t15 * _t33));
        double _t42 = Math.fma(_t15, _t32, -(_t14 * _t34));
        double _t43 = Math.fma(_t14, _t33, -(_t13 * _t32));
        d.m00 = _t32;
        d.m01 = _t33;
        d.m02 = _t34;
        d.m03 = Math.fma(_t0, _t32, Math.fma(_t1, _t33, Math.fma(_t2, _t34, this.m03)));
        d.m10 = _t41;
        d.m11 = _t42;
        d.m12 = _t43;
        d.m13 = Math.fma(_t0, _t41, Math.fma(_t1, _t42, Math.fma(_t2, _t43, this.m13)));
        d.m20 = _t14;
        d.m21 = _t13;
        d.m22 = _t15;
        d.m23 = Math.fma(_t0, _t14, Math.fma(_t1, _t13, Math.fma(_t2, _t15, this.m23)));
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code lookAt} for {@code Handedness.LEFT_HANDED}, specialized by runtime
     * matrix properties; reached only through the public {@code lookAt} dispatcher.
     */
    private Double3x4 lookAt_lh_orthogonal(double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
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
        double _buf0 = Math.fma(this.m02, _t10, Math.fma(this.m00, _t32, this.m01 * _t43));
        double _buf1 = Math.fma(this.m02, _t11, Math.fma(this.m00, _t34, this.m01 * _t44));
        double _buf2 = Math.fma(this.m02, _t12, Math.fma(this.m00, _t33, this.m01 * _t45));
        d.m03 = Math.fma(-this.m00, _t47, Math.fma(-this.m01, _t49, Math.fma(-this.m02, _t24, this.m03)));
        double _buf3 = Math.fma(this.m12, _t10, Math.fma(this.m10, _t32, this.m11 * _t43));
        double _buf4 = Math.fma(this.m12, _t11, Math.fma(this.m10, _t34, this.m11 * _t44));
        double _buf5 = Math.fma(this.m12, _t12, Math.fma(this.m10, _t33, this.m11 * _t45));
        d.m13 = Math.fma(-this.m10, _t47, Math.fma(-this.m11, _t49, Math.fma(-this.m12, _t24, this.m13)));
        double _buf6 = Math.fma(this.m22, _t10, Math.fma(this.m20, _t32, this.m21 * _t43));
        double _buf7 = Math.fma(this.m22, _t11, Math.fma(this.m20, _t34, this.m21 * _t44));
        double _buf8 = Math.fma(this.m22, _t12, Math.fma(this.m20, _t33, this.m21 * _t45));
        d.m23 = Math.fma(-this.m20, _t47, Math.fma(-this.m21, _t49, Math.fma(-this.m22, _t24, this.m23)));
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.m10 = _buf3;
        d.m11 = _buf4;
        d.m12 = _buf5;
        d.m20 = _buf6;
        d.m21 = _buf7;
        d.m22 = _buf8;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code lookAt} for {@code Handedness.LEFT_HANDED}, specialized by runtime
     * matrix properties; reached only through the public {@code lookAt} dispatcher.
     */
    private Double3x4 lookAt_lh_general(double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
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
        double _buf0 = Math.fma(this.m02, _t10, Math.fma(this.m00, _t32, this.m01 * _t43));
        double _buf1 = Math.fma(this.m02, _t11, Math.fma(this.m00, _t34, this.m01 * _t44));
        double _buf2 = Math.fma(this.m02, _t12, Math.fma(this.m00, _t33, this.m01 * _t45));
        d.m03 = Math.fma(-this.m00, _t47, Math.fma(-this.m01, _t49, Math.fma(-this.m02, _t24, this.m03)));
        double _buf3 = Math.fma(this.m12, _t10, Math.fma(this.m10, _t32, this.m11 * _t43));
        double _buf4 = Math.fma(this.m12, _t11, Math.fma(this.m10, _t34, this.m11 * _t44));
        double _buf5 = Math.fma(this.m12, _t12, Math.fma(this.m10, _t33, this.m11 * _t45));
        d.m13 = Math.fma(-this.m10, _t47, Math.fma(-this.m11, _t49, Math.fma(-this.m12, _t24, this.m13)));
        double _buf6 = Math.fma(this.m22, _t10, Math.fma(this.m20, _t32, this.m21 * _t43));
        double _buf7 = Math.fma(this.m22, _t11, Math.fma(this.m20, _t34, this.m21 * _t44));
        double _buf8 = Math.fma(this.m22, _t12, Math.fma(this.m20, _t33, this.m21 * _t45));
        d.m23 = Math.fma(-this.m20, _t47, Math.fma(-this.m21, _t49, Math.fma(-this.m22, _t24, this.m23)));
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.m10 = _buf3;
        d.m11 = _buf4;
        d.m12 = _buf5;
        d.m20 = _buf6;
        d.m21 = _buf7;
        d.m22 = _buf8;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code lookAt} for {@code Handedness.LEFT_HANDED}; reached only through the
     * public {@code lookAt} dispatcher.
     */
    private Double3x4 lookAt_lh(double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ, @Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return lookAt_lh_identity(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return lookAt_lh_translation(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return lookAt_lh_orthogonal(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ, dest);
        return lookAt_lh_general(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ, dest);
    }


    /**
     * Private body of {@code lookAt} for {@code Handedness.LEFT_HANDED}; reached only through the
     * public {@code lookAt} dispatcher.
     */
    @Mutated private Double3x4 lookAt_lh(double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        if (Joml.RETURN_NEW) return lookAt_lh(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ, Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return lookAt_lh_identity(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return lookAt_lh_translation(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ, this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return lookAt_lh_orthogonal(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ, this);
        return lookAt_lh_general(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ, this);
    }


    /**
     * Private body of {@code lookAt} for {@code Handedness.RIGHT_HANDED}; reached only through the
     * public {@code lookAt} dispatcher.
     */
    private Double3x4 lookAt_rh(Double3R eye, Double3R center, Double3R up, @Mutated Double3x4 dest) {
        return lookAt_rh(eye.x(), eye.y(), eye.z(), center.x(), center.y(), center.z(), up.x(), up.y(), up.z(), dest);
    }


    /**
     * Private body of {@code lookAt} for {@code Handedness.RIGHT_HANDED}; reached only through the
     * public {@code lookAt} dispatcher.
     */
    private @Mutated Double3x4 lookAt_rh(Double3R eye, Double3R center, Double3R up) {
        return lookAt_rh(eye.x(), eye.y(), eye.z(), center.x(), center.y(), center.z(), up.x(), up.y(), up.z());
    }


    /**
     * Private body of {@code lookAt} for {@code Handedness.RIGHT_HANDED}, specialized by runtime
     * matrix properties; reached only through the public {@code lookAt} dispatcher.
     */
    private Double3x4 lookAt_rh_identity(double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
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
        d.m00 = _t29;
        d.m01 = _t30;
        d.m02 = _t31;
        d.m03 = -Math.fma(eyeZ, _t31, Math.fma(eyeX, _t29, eyeY * _t30));
        d.m10 = _t38;
        d.m11 = _t39;
        d.m12 = _t40;
        d.m13 = -Math.fma(eyeZ, _t40, Math.fma(eyeX, _t38, eyeY * _t39));
        d.m20 = -_t10;
        d.m21 = -_t11;
        d.m22 = -_t12;
        d.m23 = Math.fma(eyeZ, _t12, Math.fma(eyeX, _t10, eyeY * _t11));
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code lookAt} for {@code Handedness.RIGHT_HANDED}, specialized by runtime
     * matrix properties; reached only through the public {@code lookAt} dispatcher.
     */
    private Double3x4 lookAt_rh_translation(double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = -eyeX;
        double _t1 = -eyeY;
        double _t2 = -eyeZ;
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
        double _t22 = Math.fma(upY, _t13, -(upX * _t14));
        double _t23 = Math.fma(upX, _t15, -(upZ * _t13));
        double _t24 = Math.fma(upZ, _t14, -(upY * _t15));
        double _t27 = Math.fma(_t22, _t22, Math.fma(_t23, _t23, _t24 * _t24));
        double _t28 = (1.0 / Math.sqrt(_t27));
        double _t32, _t33, _t34;
        if (_t27 > 0.0) {
            _t32 = _t24 * _t28;
            _t33 = _t23 * _t28;
            _t34 = _t22 * _t28;
        } else {
            _t32 = 0.0;
            _t33 = 0.0;
            _t34 = 0.0;
        }
        double _t41 = Math.fma(_t15, _t33, -(_t14 * _t34));
        double _t42 = Math.fma(_t13, _t34, -(_t15 * _t32));
        double _t43 = Math.fma(_t14, _t32, -(_t13 * _t33));
        d.m00 = _t32;
        d.m01 = _t33;
        d.m02 = _t34;
        d.m03 = Math.fma(_t0, _t32, Math.fma(_t1, _t33, Math.fma(_t2, _t34, this.m03)));
        d.m10 = _t41;
        d.m11 = _t42;
        d.m12 = _t43;
        d.m13 = Math.fma(_t0, _t41, Math.fma(_t1, _t42, Math.fma(_t2, _t43, this.m13)));
        d.m20 = -_t13;
        d.m21 = -_t14;
        d.m22 = -_t15;
        d.m23 = Math.fma(eyeX, _t13, Math.fma(eyeY, _t14, Math.fma(eyeZ, _t15, this.m23)));
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code lookAt} for {@code Handedness.RIGHT_HANDED}, specialized by runtime
     * matrix properties; reached only through the public {@code lookAt} dispatcher.
     */
    private Double3x4 lookAt_rh_orthogonal(double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = -this.m02;
        double _t1 = -this.m12;
        double _t2 = -this.m22;
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
        double _buf0 = Math.fma(_t0, _t13, Math.fma(this.m00, _t35, this.m01 * _t46));
        double _buf1 = Math.fma(_t0, _t14, Math.fma(this.m00, _t36, this.m01 * _t47));
        double _buf2 = Math.fma(_t0, _t15, Math.fma(this.m00, _t37, this.m01 * _t48));
        d.m03 = Math.fma(-this.m00, _t50, Math.fma(-this.m01, _t52, Math.fma(this.m02, _t27, this.m03)));
        double _buf3 = Math.fma(_t1, _t13, Math.fma(this.m10, _t35, this.m11 * _t46));
        double _buf4 = Math.fma(_t1, _t14, Math.fma(this.m10, _t36, this.m11 * _t47));
        double _buf5 = Math.fma(_t1, _t15, Math.fma(this.m10, _t37, this.m11 * _t48));
        d.m13 = Math.fma(-this.m10, _t50, Math.fma(-this.m11, _t52, Math.fma(this.m12, _t27, this.m13)));
        double _buf6 = Math.fma(_t2, _t13, Math.fma(this.m20, _t35, this.m21 * _t46));
        double _buf7 = Math.fma(_t2, _t14, Math.fma(this.m20, _t36, this.m21 * _t47));
        double _buf8 = Math.fma(_t2, _t15, Math.fma(this.m20, _t37, this.m21 * _t48));
        d.m23 = Math.fma(-this.m20, _t50, Math.fma(-this.m21, _t52, Math.fma(this.m22, _t27, this.m23)));
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.m10 = _buf3;
        d.m11 = _buf4;
        d.m12 = _buf5;
        d.m20 = _buf6;
        d.m21 = _buf7;
        d.m22 = _buf8;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code lookAt} for {@code Handedness.RIGHT_HANDED}, specialized by runtime
     * matrix properties; reached only through the public {@code lookAt} dispatcher.
     */
    private Double3x4 lookAt_rh_general(double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = -this.m02;
        double _t1 = -this.m12;
        double _t2 = -this.m22;
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
        double _buf0 = Math.fma(_t0, _t13, Math.fma(this.m00, _t35, this.m01 * _t46));
        double _buf1 = Math.fma(_t0, _t14, Math.fma(this.m00, _t36, this.m01 * _t47));
        double _buf2 = Math.fma(_t0, _t15, Math.fma(this.m00, _t37, this.m01 * _t48));
        d.m03 = Math.fma(-this.m00, _t50, Math.fma(-this.m01, _t52, Math.fma(this.m02, _t27, this.m03)));
        double _buf3 = Math.fma(_t1, _t13, Math.fma(this.m10, _t35, this.m11 * _t46));
        double _buf4 = Math.fma(_t1, _t14, Math.fma(this.m10, _t36, this.m11 * _t47));
        double _buf5 = Math.fma(_t1, _t15, Math.fma(this.m10, _t37, this.m11 * _t48));
        d.m13 = Math.fma(-this.m10, _t50, Math.fma(-this.m11, _t52, Math.fma(this.m12, _t27, this.m13)));
        double _buf6 = Math.fma(_t2, _t13, Math.fma(this.m20, _t35, this.m21 * _t46));
        double _buf7 = Math.fma(_t2, _t14, Math.fma(this.m20, _t36, this.m21 * _t47));
        double _buf8 = Math.fma(_t2, _t15, Math.fma(this.m20, _t37, this.m21 * _t48));
        d.m23 = Math.fma(-this.m20, _t50, Math.fma(-this.m21, _t52, Math.fma(this.m22, _t27, this.m23)));
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.m10 = _buf3;
        d.m11 = _buf4;
        d.m12 = _buf5;
        d.m20 = _buf6;
        d.m21 = _buf7;
        d.m22 = _buf8;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code lookAt} for {@code Handedness.RIGHT_HANDED}; reached only through the
     * public {@code lookAt} dispatcher.
     */
    private Double3x4 lookAt_rh(double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ, @Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return lookAt_rh_identity(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return lookAt_rh_translation(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return lookAt_rh_orthogonal(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ, dest);
        return lookAt_rh_general(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ, dest);
    }


    /**
     * Private body of {@code lookAt} for {@code Handedness.RIGHT_HANDED}; reached only through the
     * public {@code lookAt} dispatcher.
     */
    @Mutated private Double3x4 lookAt_rh(double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        if (Joml.RETURN_NEW) return lookAt_rh(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ, Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return lookAt_rh_identity(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return lookAt_rh_translation(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ, this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return lookAt_rh_orthogonal(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ, this);
        return lookAt_rh_general(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ, this);
    }


    /**
     * Apply a "look at" view transformation with the eye at {@code eye} looking at {@code center}
     * to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code L} the "look at" matrix, then the new matrix
     * will be {@code M * L}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * L * v}, the "look at" will be applied first.
     *
     * @param eye the position of the camera
     * @param center the point in space to look at
     * @param up the direction of "up"
     * @param handedness the handedness of the coordinate system to map into
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 lookAt(Double3R eye, Double3R center, Double3R up, Handedness handedness, @Mutated Double3x4 dest) {
        switch (handedness) {
            case LEFT_HANDED -> { return lookAt_lh(eye, center, up, dest); }
            default -> { return lookAt_rh(eye, center, up, dest); }
        }
    }


    /**
     * Apply a "look at" view transformation with the eye at {@code eye} looking at {@code center}
     * to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code L} the "look at" matrix, then the new matrix
     * will be {@code M * L}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * L * v}, the "look at" will be applied first.
     *
     * @param eye the position of the camera
     * @param center the point in space to look at
     * @param up the direction of "up"
     * @param handedness the handedness of the coordinate system to map into
     * @return this
     */
    @Mutated public Double3x4 lookAt(Double3R eye, Double3R center, Double3R up, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return lookAt_lh(eye, center, up); }
            default -> { return lookAt_rh(eye, center, up); }
        }
    }


    /**
     * Apply a "look at" view transformation with the eye at ({@code eyeX}, {@code eyeY},
     * {@code eyeZ}) looking at ({@code centerX}, {@code centerY}, {@code centerZ}) to this matrix
     * and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code L} the "look at" matrix, then the new matrix
     * will be {@code M * L}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * L * v}, the "look at" will be applied first.
     *
     * @param eyeX the {@code x} component of the vector {@code (eyeX, eyeY, eyeZ)}
     * @param eyeY the {@code y} component of the vector {@code (eyeX, eyeY, eyeZ)}
     * @param eyeZ the {@code z} component of the vector {@code (eyeX, eyeY, eyeZ)}
     * @param centerX the {@code x} component of the vector {@code (centerX, centerY, centerZ)}
     * @param centerY the {@code y} component of the vector {@code (centerX, centerY, centerZ)}
     * @param centerZ the {@code z} component of the vector {@code (centerX, centerY, centerZ)}
     * @param upX the {@code x} component of the vector {@code (upX, upY, upZ)}
     * @param upY the {@code y} component of the vector {@code (upX, upY, upZ)}
     * @param upZ the {@code z} component of the vector {@code (upX, upY, upZ)}
     * @param handedness the handedness of the coordinate system to map into
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 lookAt(double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ, Handedness handedness, @Mutated Double3x4 dest) {
        switch (handedness) {
            case LEFT_HANDED -> { return lookAt_lh(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ, dest); }
            default -> { return lookAt_rh(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ, dest); }
        }
    }


    /**
     * Apply a "look at" view transformation with the eye at ({@code eyeX}, {@code eyeY},
     * {@code eyeZ}) looking at ({@code centerX}, {@code centerY}, {@code centerZ}) to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code L} the "look at" matrix, then the new matrix
     * will be {@code M * L}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * L * v}, the "look at" will be applied first.
     *
     * @param eyeX the {@code x} component of the vector {@code (eyeX, eyeY, eyeZ)}
     * @param eyeY the {@code y} component of the vector {@code (eyeX, eyeY, eyeZ)}
     * @param eyeZ the {@code z} component of the vector {@code (eyeX, eyeY, eyeZ)}
     * @param centerX the {@code x} component of the vector {@code (centerX, centerY, centerZ)}
     * @param centerY the {@code y} component of the vector {@code (centerX, centerY, centerZ)}
     * @param centerZ the {@code z} component of the vector {@code (centerX, centerY, centerZ)}
     * @param upX the {@code x} component of the vector {@code (upX, upY, upZ)}
     * @param upY the {@code y} component of the vector {@code (upX, upY, upZ)}
     * @param upZ the {@code z} component of the vector {@code (upX, upY, upZ)}
     * @param handedness the handedness of the coordinate system to map into
     * @return this
     */
    @Mutated public Double3x4 lookAt(double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return lookAt_lh(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ); }
            default -> { return lookAt_rh(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ); }
        }
    }


    /**
     * Apply a "look at" view transformation with the eye at {@code eye} looking at {@code center}
     * to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code L} the "look at" matrix, then the new matrix
     * will be {@code M * L}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * L * v}, the "look at" will be applied first.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness}.
     *
     * @param eye the position of the camera
     * @param center the point in space to look at
     * @param up the direction of "up"
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 lookAt(Double3R eye, Double3R center, Double3R up, @Mutated Double3x4 dest) { return lookAt(eye, center, up, Handedness.RIGHT_HANDED, dest); }


    /**
     * Apply a "look at" view transformation with the eye at {@code eye} looking at {@code center}
     * to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code L} the "look at" matrix, then the new matrix
     * will be {@code M * L}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * L * v}, the "look at" will be applied first.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness}.
     *
     * @param eye the position of the camera
     * @param center the point in space to look at
     * @param up the direction of "up"
     * @return this
     */
    @Mutated public Double3x4 lookAt(Double3R eye, Double3R center, Double3R up) { return lookAt(eye, center, up, Handedness.RIGHT_HANDED); }


    /**
     * Apply a "look at" view transformation with the eye at ({@code eyeX}, {@code eyeY},
     * {@code eyeZ}) looking at ({@code centerX}, {@code centerY}, {@code centerZ}) to this matrix
     * and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code L} the "look at" matrix, then the new matrix
     * will be {@code M * L}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * L * v}, the "look at" will be applied first.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness}.
     *
     * @param eyeX the {@code x} component of the vector {@code (eyeX, eyeY, eyeZ)}
     * @param eyeY the {@code y} component of the vector {@code (eyeX, eyeY, eyeZ)}
     * @param eyeZ the {@code z} component of the vector {@code (eyeX, eyeY, eyeZ)}
     * @param centerX the {@code x} component of the vector {@code (centerX, centerY, centerZ)}
     * @param centerY the {@code y} component of the vector {@code (centerX, centerY, centerZ)}
     * @param centerZ the {@code z} component of the vector {@code (centerX, centerY, centerZ)}
     * @param upX the {@code x} component of the vector {@code (upX, upY, upZ)}
     * @param upY the {@code y} component of the vector {@code (upX, upY, upZ)}
     * @param upZ the {@code z} component of the vector {@code (upX, upY, upZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 lookAt(double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ, @Mutated Double3x4 dest) { return lookAt(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ, Handedness.RIGHT_HANDED, dest); }


    /**
     * Apply a "look at" view transformation with the eye at ({@code eyeX}, {@code eyeY},
     * {@code eyeZ}) looking at ({@code centerX}, {@code centerY}, {@code centerZ}) to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code L} the "look at" matrix, then the new matrix
     * will be {@code M * L}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * L * v}, the "look at" will be applied first.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness}.
     *
     * @param eyeX the {@code x} component of the vector {@code (eyeX, eyeY, eyeZ)}
     * @param eyeY the {@code y} component of the vector {@code (eyeX, eyeY, eyeZ)}
     * @param eyeZ the {@code z} component of the vector {@code (eyeX, eyeY, eyeZ)}
     * @param centerX the {@code x} component of the vector {@code (centerX, centerY, centerZ)}
     * @param centerY the {@code y} component of the vector {@code (centerX, centerY, centerZ)}
     * @param centerZ the {@code z} component of the vector {@code (centerX, centerY, centerZ)}
     * @param upX the {@code x} component of the vector {@code (upX, upY, upZ)}
     * @param upY the {@code y} component of the vector {@code (upX, upY, upZ)}
     * @param upZ the {@code z} component of the vector {@code (upX, upY, upZ)}
     * @return this
     */
    @Mutated public Double3x4 lookAt(double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) { return lookAt(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ, Handedness.RIGHT_HANDED); }


    /**
     * Set this matrix to a cylindrical billboard transformation that rotates about the given axis
     * to face the camera.
     *
     * @param objPos the position of the object to orient
     * @param targetPos the position to face (e.g. the camera position)
     * @param up the direction of "up" (must be a unit vector)
     * @return this
     */
    public @Mutated Double3x4 makeBillboardCylindrical(Double3R objPos, Double3R targetPos, Double3R up) {
        return makeBillboardCylindrical(objPos.x(), objPos.y(), objPos.z(), targetPos.x(), targetPos.y(), targetPos.z(), up.x(), up.y(), up.z());
    }


    /**
     * Set this matrix to a cylindrical billboard transformation that rotates about the given axis
     * to face the camera.
     *
     * @param objPosX the {@code x} component of the vector {@code (objPosX, objPosY, objPosZ)}
     * @param objPosY the {@code y} component of the vector {@code (objPosX, objPosY, objPosZ)}
     * @param objPosZ the {@code z} component of the vector {@code (objPosX, objPosY, objPosZ)}
     * @param targetPosX the {@code x} component of the vector
     *        {@code (targetPosX, targetPosY, targetPosZ)}
     * @param targetPosY the {@code y} component of the vector
     *        {@code (targetPosX, targetPosY, targetPosZ)}
     * @param targetPosZ the {@code z} component of the vector
     *        {@code (targetPosX, targetPosY, targetPosZ)}
     * @param upX the {@code x} component of the vector {@code (upX, upY, upZ)} (the vector must
     *        have unit length)
     * @param upY the {@code y} component of the vector {@code (upX, upY, upZ)} (the vector must
     *        have unit length)
     * @param upZ the {@code z} component of the vector {@code (upX, upY, upZ)} (the vector must
     *        have unit length)
     * @return this
     */
    @Mutated public Double3x4 makeBillboardCylindrical(double objPosX, double objPosY, double objPosZ, double targetPosX, double targetPosY, double targetPosZ, double upX, double upY, double upZ) {
        double _t0 = targetPosY - objPosY;
        double _t1 = targetPosX - objPosX;
        double _t2 = targetPosZ - objPosZ;
        double _t9 = Math.fma(upX, _t0, -(upY * _t1));
        double _t10 = Math.fma(upY, _t2, -(upZ * _t0));
        double _t11 = Math.fma(upZ, _t1, -(upX * _t2));
        double _t14 = Math.fma(_t9, _t9, Math.fma(_t10, _t10, _t11 * _t11));
        double _t15 = (1.0 / Math.sqrt(_t14));
        double _t19, _t20, _t21;
        if (_t14 > 0.0) {
            _t19 = _t10 * _t15;
            _t20 = _t11 * _t15;
            _t21 = _t9 * _t15;
        } else {
            _t19 = 0.0;
            _t20 = 0.0;
            _t21 = 0.0;
        }
        double _t28 = Math.fma(upY, _t19, -(upX * _t20));
        double _t29 = Math.fma(upX, _t21, -(upZ * _t19));
        double _t30 = Math.fma(upZ, _t20, -(upY * _t21));
        double _t33 = Math.fma(_t28, _t28, Math.fma(_t29, _t29, _t30 * _t30));
        double _t34 = (1.0 / Math.sqrt(_t33));
        this.m00 = _t19;
        this.m01 = upX;
        this.m02 = _t33 > 0.0 ? _t30 * _t34 : 0.0;
        this.m03 = objPosX;
        this.m10 = _t20;
        this.m11 = upY;
        this.m12 = _t33 > 0.0 ? _t29 * _t34 : 0.0;
        this.m13 = objPosY;
        this.m20 = _t21;
        this.m21 = upZ;
        this.m22 = _t33 > 0.0 ? _t28 * _t34 : 0.0;
        this.m23 = objPosZ;
        this.properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Set this matrix to a spherical billboard transformation that faces the camera.
     *
     * @param objPos the position of the object to orient
     * @param targetPos the position to face (e.g. the camera position)
     * @param up the direction of "up"
     * @return this
     */
    public @Mutated Double3x4 makeBillboardSpherical(Double3R objPos, Double3R targetPos, Double3R up) {
        return makeBillboardSpherical(objPos.x(), objPos.y(), objPos.z(), targetPos.x(), targetPos.y(), targetPos.z(), up.x(), up.y(), up.z());
    }


    /**
     * Set this matrix to a spherical billboard transformation that faces the camera.
     *
     * @param objPosX the {@code x} component of the vector {@code (objPosX, objPosY, objPosZ)}
     * @param objPosY the {@code y} component of the vector {@code (objPosX, objPosY, objPosZ)}
     * @param objPosZ the {@code z} component of the vector {@code (objPosX, objPosY, objPosZ)}
     * @param targetPosX the {@code x} component of the vector
     *        {@code (targetPosX, targetPosY, targetPosZ)}
     * @param targetPosY the {@code y} component of the vector
     *        {@code (targetPosX, targetPosY, targetPosZ)}
     * @param targetPosZ the {@code z} component of the vector
     *        {@code (targetPosX, targetPosY, targetPosZ)}
     * @param upX the {@code x} component of the vector {@code (upX, upY, upZ)}
     * @param upY the {@code y} component of the vector {@code (upX, upY, upZ)}
     * @param upZ the {@code z} component of the vector {@code (upX, upY, upZ)}
     * @return this
     */
    @Mutated public Double3x4 makeBillboardSpherical(double objPosX, double objPosY, double objPosZ, double targetPosX, double targetPosY, double targetPosZ, double upX, double upY, double upZ) {
        double _t0 = targetPosZ - objPosZ;
        double _t1 = targetPosX - objPosX;
        double _t2 = targetPosY - objPosY;
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
            _t30 = _t19 * _t25;
            _t31 = _t21 * _t25;
        } else {
            _t29 = 0.0;
            _t30 = 0.0;
            _t31 = 0.0;
        }
        this.m00 = _t29;
        this.m01 = Math.fma(_t10, _t30, -(_t12 * _t31));
        this.m02 = _t11;
        this.m03 = objPosX;
        this.m10 = _t31;
        this.m11 = Math.fma(_t12, _t29, -(_t11 * _t30));
        this.m12 = _t10;
        this.m13 = objPosY;
        this.m20 = _t30;
        this.m21 = Math.fma(_t11, _t31, -(_t10 * _t29));
        this.m22 = _t12;
        this.m23 = objPosZ;
        this.properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Set this matrix to a spherical billboard transformation that faces the camera, using the
     * rotation of shortest arc.
     *
     * @param objPos the position of the object to orient
     * @param targetPos the position to face (e.g. the camera position)
     * @return this
     */
    public @Mutated Double3x4 makeBillboardSphericalShortest(Double3R objPos, Double3R targetPos) {
        return makeBillboardSphericalShortest(objPos.x(), objPos.y(), objPos.z(), targetPos.x(), targetPos.y(), targetPos.z());
    }


    /**
     * Set this matrix to a spherical billboard transformation that faces the camera, using the
     * rotation of shortest arc.
     *
     * @param objPosX the {@code x} component of the vector {@code (objPosX, objPosY, objPosZ)}
     * @param objPosY the {@code y} component of the vector {@code (objPosX, objPosY, objPosZ)}
     * @param objPosZ the {@code z} component of the vector {@code (objPosX, objPosY, objPosZ)}
     * @param targetPosX the {@code x} component of the vector
     *        {@code (targetPosX, targetPosY, targetPosZ)}
     * @param targetPosY the {@code y} component of the vector
     *        {@code (targetPosX, targetPosY, targetPosZ)}
     * @param targetPosZ the {@code z} component of the vector
     *        {@code (targetPosX, targetPosY, targetPosZ)}
     * @return this
     */
    @Mutated public Double3x4 makeBillboardSphericalShortest(double objPosX, double objPosY, double objPosZ, double targetPosX, double targetPosY, double targetPosZ) {
        double _t0 = targetPosX - objPosX;
        double _t1 = targetPosZ - objPosZ;
        double _t2 = targetPosY - objPosY;
        double _t3 = objPosY - targetPosY;
        double _t10 = _t1 + Math.sqrt(Math.fma(_t1, _t1, Math.fma(_t0, _t0, _t2 * _t2)));
        double _t12 = (1.0 / Math.sqrt(Math.fma(_t10, _t10, Math.fma(_t3, _t3, _t0 * _t0))));
        double _t13 = _t0 * _t12;
        double _t14 = _t3 * _t12;
        double _t15 = 2.0 * _t13;
        double _t16 = 2.0 * _t14;
        double _t17 = -_t15;
        double _t19 = _t10 * _t12;
        double _t20 = _t16 * _t13;
        double _t21 = Math.fma(-_t16, _t14, 1.0);
        double _t22 = _t15 * _t19;
        double _t23 = _t16 * _t19;
        this.m00 = Math.fma(_t17, _t13, 1.0);
        this.m01 = _t20;
        this.m02 = _t22;
        this.m03 = objPosX;
        this.m10 = _t20;
        this.m11 = _t21;
        this.m12 = -_t23;
        this.m13 = objPosY;
        this.m20 = -_t22;
        this.m21 = _t23;
        this.m22 = Math.fma(_t17, _t13, _t21);
        this.m23 = objPosZ;
        this.properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Set this matrix to the rigid transformation represented by the unit dual quaternion
     * {@code dq}.
     *
     * @param dq the dual quaternion (must be a unit dual quaternion)
     * @return this
     */
    public @Mutated Double3x4 makeFromDualQuat(DoubleDualQuatR dq) {
        return makeFromDualQuat(dq.rX(), dq.rY(), dq.rZ(), dq.rW(), dq.dX(), dq.dY(), dq.dZ(), dq.dW());
    }


    /**
     * Set this matrix to the rigid transformation represented by the unit dual quaternion
     * ({@code dqRX}, {@code dqRY}, {@code dqRZ}, {@code dqRW}, {@code dqDX}, {@code dqDY},
     * {@code dqDZ}, {@code dqDW}).
     *
     * @param dqRX the {@code rX} component of the dual quaternion
     *        {@code (dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW)} (the real part must have unit
     *        length)
     * @param dqRY the {@code rY} component of the dual quaternion
     *        {@code (dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW)} (the real part must have unit
     *        length)
     * @param dqRZ the {@code rZ} component of the dual quaternion
     *        {@code (dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW)} (the real part must have unit
     *        length)
     * @param dqRW the {@code rW} component of the dual quaternion
     *        {@code (dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW)} (the real part must have unit
     *        length)
     * @param dqDX the {@code dX} component of the dual quaternion
     *        {@code (dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW)}
     * @param dqDY the {@code dY} component of the dual quaternion
     *        {@code (dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW)}
     * @param dqDZ the {@code dZ} component of the dual quaternion
     *        {@code (dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW)}
     * @param dqDW the {@code dW} component of the dual quaternion
     *        {@code (dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW)}
     * @return this
     */
    @Mutated public Double3x4 makeFromDualQuat(double dqRX, double dqRY, double dqRZ, double dqRW, double dqDX, double dqDY, double dqDZ, double dqDW) {
        double _t0 = dqRY * dqRY;
        double _t2 = dqRZ * dqRW;
        double _t3 = dqRY * dqRW;
        double _t4 = dqRX * dqRX;
        double _t5 = dqRY * dqRZ;
        double _t6 = Math.fma(-2.0, dqRZ * dqRZ, 1.0);
        this.m00 = Math.fma(-2.0, _t0, _t6);
        this.m01 = Math.fma(-2.0, _t2, 2.0 * dqRX * dqRY);
        this.m02 = 2.0 * Math.fma(dqRX, dqRZ, _t3);
        this.m03 = 2.0 * (Math.fma(dqRY, dqDZ, -(dqRZ * dqDY)) + Math.fma(dqRW, dqDX, -(dqRX * dqDW)));
        this.m10 = 2.0 * Math.fma(dqRX, dqRY, _t2);
        this.m11 = Math.fma(-2.0, _t4, _t6);
        this.m12 = Math.fma(-2.0, dqRX * dqRW, 2.0 * _t5);
        this.m13 = 2.0 * (Math.fma(dqRZ, dqDX, -(dqRX * dqDZ)) + Math.fma(dqRW, dqDY, -(dqRY * dqDW)));
        this.m20 = Math.fma(-2.0, _t3, 2.0 * dqRX * dqRZ);
        this.m21 = 2.0 * Math.fma(dqRX, dqRW, _t5);
        this.m22 = Math.fma(-2.0, _t4, Math.fma(-2.0, _t0, 1.0));
        this.m23 = 2.0 * (Math.fma(dqRX, dqDY, -(dqRY * dqDX)) + Math.fma(dqRW, dqDZ, -(dqRZ * dqDW)));
        this.properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Private body of {@code makeLookAt} for {@code Handedness.LEFT_HANDED}; reached only through
     * the public {@code makeLookAt} dispatcher.
     */
    private @Mutated Double3x4 makeLookAt_lh(Double3R eye, Double3R center, Double3R up) {
        return makeLookAt_lh(eye.x(), eye.y(), eye.z(), center.x(), center.y(), center.z(), up.x(), up.y(), up.z());
    }


    /**
     * Private body of {@code makeLookAt} for {@code Handedness.LEFT_HANDED}; reached only through
     * the public {@code makeLookAt} dispatcher.
     */
    @Mutated private Double3x4 makeLookAt_lh(double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
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
        this.m00 = _t29;
        this.m01 = _t30;
        this.m02 = _t31;
        this.m03 = -Math.fma(eyeZ, _t31, Math.fma(eyeX, _t29, eyeY * _t30));
        this.m10 = _t38;
        this.m11 = _t39;
        this.m12 = _t40;
        this.m13 = -Math.fma(eyeZ, _t40, Math.fma(eyeX, _t38, eyeY * _t39));
        this.m20 = _t11;
        this.m21 = _t10;
        this.m22 = _t12;
        this.m23 = -Math.fma(eyeZ, _t12, Math.fma(eyeX, _t11, eyeY * _t10));
        this.properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Private body of {@code makeLookAt} for {@code Handedness.RIGHT_HANDED}; reached only through
     * the public {@code makeLookAt} dispatcher.
     */
    private @Mutated Double3x4 makeLookAt_rh(Double3R eye, Double3R center, Double3R up) {
        return makeLookAt_rh(eye.x(), eye.y(), eye.z(), center.x(), center.y(), center.z(), up.x(), up.y(), up.z());
    }


    /**
     * Private body of {@code makeLookAt} for {@code Handedness.RIGHT_HANDED}; reached only through
     * the public {@code makeLookAt} dispatcher.
     */
    @Mutated private Double3x4 makeLookAt_rh(double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
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
        this.m00 = _t29;
        this.m01 = _t30;
        this.m02 = _t31;
        this.m03 = -Math.fma(eyeZ, _t31, Math.fma(eyeX, _t29, eyeY * _t30));
        this.m10 = _t38;
        this.m11 = _t39;
        this.m12 = _t40;
        this.m13 = -Math.fma(eyeZ, _t40, Math.fma(eyeX, _t38, eyeY * _t39));
        this.m20 = -_t10;
        this.m21 = -_t11;
        this.m22 = -_t12;
        this.m23 = Math.fma(eyeZ, _t12, Math.fma(eyeX, _t10, eyeY * _t11));
        this.properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Set this matrix to a "look at" view transformation with the eye at {@code eye} looking at
     * {@code center}.
     *
     * @param eye the position of the camera
     * @param center the point in space to look at
     * @param up the direction of "up"
     * @param handedness the handedness of the coordinate system to map into
     * @return this
     */
    @Mutated public Double3x4 makeLookAt(Double3R eye, Double3R center, Double3R up, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return makeLookAt_lh(eye, center, up); }
            default -> { return makeLookAt_rh(eye, center, up); }
        }
    }


    /**
     * Set this matrix to a "look at" view transformation with the eye at ({@code eyeX},
     * {@code eyeY}, {@code eyeZ}) looking at ({@code centerX}, {@code centerY}, {@code centerZ}).
     *
     * @param eyeX the {@code x} component of the vector {@code (eyeX, eyeY, eyeZ)}
     * @param eyeY the {@code y} component of the vector {@code (eyeX, eyeY, eyeZ)}
     * @param eyeZ the {@code z} component of the vector {@code (eyeX, eyeY, eyeZ)}
     * @param centerX the {@code x} component of the vector {@code (centerX, centerY, centerZ)}
     * @param centerY the {@code y} component of the vector {@code (centerX, centerY, centerZ)}
     * @param centerZ the {@code z} component of the vector {@code (centerX, centerY, centerZ)}
     * @param upX the {@code x} component of the vector {@code (upX, upY, upZ)}
     * @param upY the {@code y} component of the vector {@code (upX, upY, upZ)}
     * @param upZ the {@code z} component of the vector {@code (upX, upY, upZ)}
     * @param handedness the handedness of the coordinate system to map into
     * @return this
     */
    @Mutated public Double3x4 makeLookAt(double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return makeLookAt_lh(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ); }
            default -> { return makeLookAt_rh(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ); }
        }
    }


    /**
     * Set this matrix to a "look at" view transformation with the eye at {@code eye} looking at
     * {@code center}.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness}.
     *
     * @param eye the position of the camera
     * @param center the point in space to look at
     * @param up the direction of "up"
     * @return this
     */
    @Mutated public Double3x4 makeLookAt(Double3R eye, Double3R center, Double3R up) { return makeLookAt(eye, center, up, Handedness.RIGHT_HANDED); }


    /**
     * Set this matrix to a "look at" view transformation with the eye at ({@code eyeX},
     * {@code eyeY}, {@code eyeZ}) looking at ({@code centerX}, {@code centerY}, {@code centerZ}).
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness}.
     *
     * @param eyeX the {@code x} component of the vector {@code (eyeX, eyeY, eyeZ)}
     * @param eyeY the {@code y} component of the vector {@code (eyeX, eyeY, eyeZ)}
     * @param eyeZ the {@code z} component of the vector {@code (eyeX, eyeY, eyeZ)}
     * @param centerX the {@code x} component of the vector {@code (centerX, centerY, centerZ)}
     * @param centerY the {@code y} component of the vector {@code (centerX, centerY, centerZ)}
     * @param centerZ the {@code z} component of the vector {@code (centerX, centerY, centerZ)}
     * @param upX the {@code x} component of the vector {@code (upX, upY, upZ)}
     * @param upY the {@code y} component of the vector {@code (upX, upY, upZ)}
     * @param upZ the {@code z} component of the vector {@code (upX, upY, upZ)}
     * @return this
     */
    @Mutated public Double3x4 makeLookAt(double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) { return makeLookAt(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ, Handedness.RIGHT_HANDED); }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+x, +y, +z)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingXYZ() {
        this.m00 = 1.0;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = 1.0;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = 1.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_IDENTITY;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+x, +y, -z)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingXYnZ() {
        this.m00 = 1.0;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = 1.0;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = -1.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_AFFINE;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+x, +z, +y)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingXZY() {
        this.m00 = 1.0;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = 0.0;
        this.m12 = 1.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = 1.0;
        this.m22 = 0.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_AFFINE;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+x, +z, -y)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingXZnY() {
        this.m00 = 1.0;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = 0.0;
        this.m12 = -1.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = 1.0;
        this.m22 = 0.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+x, -y, +z)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingXnYZ() {
        this.m00 = 1.0;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = -1.0;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = 1.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_AFFINE;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+x, -y, -z)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingXnYnZ() {
        this.m00 = 1.0;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = -1.0;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = -1.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+x, -z, +y)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingXnZY() {
        this.m00 = 1.0;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = 0.0;
        this.m12 = 1.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = -1.0;
        this.m22 = 0.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+x, -z, -y)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingXnZnY() {
        this.m00 = 1.0;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = 0.0;
        this.m12 = -1.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = -1.0;
        this.m22 = 0.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_AFFINE;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+y, +x, +z)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingYXZ() {
        this.m00 = 0.0;
        this.m01 = 1.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = 1.0;
        this.m11 = 0.0;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = 1.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_AFFINE;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+y, +x, -z)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingYXnZ() {
        this.m00 = 0.0;
        this.m01 = 1.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = 1.0;
        this.m11 = 0.0;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = -1.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+y, +z, +x)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingYZX() {
        this.m00 = 0.0;
        this.m01 = 0.0;
        this.m02 = 1.0;
        this.m03 = 0.0;
        this.m10 = 1.0;
        this.m11 = 0.0;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = 1.0;
        this.m22 = 0.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+y, +z, -x)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingYZnX() {
        this.m00 = 0.0;
        this.m01 = 0.0;
        this.m02 = -1.0;
        this.m03 = 0.0;
        this.m10 = 1.0;
        this.m11 = 0.0;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = 1.0;
        this.m22 = 0.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_AFFINE;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+y, -x, +z)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingYnXZ() {
        this.m00 = 0.0;
        this.m01 = -1.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = 1.0;
        this.m11 = 0.0;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = 1.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+y, -x, -z)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingYnXnZ() {
        this.m00 = 0.0;
        this.m01 = -1.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = 1.0;
        this.m11 = 0.0;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = -1.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_AFFINE;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+y, -z, +x)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingYnZX() {
        this.m00 = 0.0;
        this.m01 = 0.0;
        this.m02 = 1.0;
        this.m03 = 0.0;
        this.m10 = 1.0;
        this.m11 = 0.0;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = -1.0;
        this.m22 = 0.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_AFFINE;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+y, -z, -x)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingYnZnX() {
        this.m00 = 0.0;
        this.m01 = 0.0;
        this.m02 = -1.0;
        this.m03 = 0.0;
        this.m10 = 1.0;
        this.m11 = 0.0;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = -1.0;
        this.m22 = 0.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+z, +x, +y)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingZXY() {
        this.m00 = 0.0;
        this.m01 = 1.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = 0.0;
        this.m12 = 1.0;
        this.m13 = 0.0;
        this.m20 = 1.0;
        this.m21 = 0.0;
        this.m22 = 0.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+z, +x, -y)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingZXnY() {
        this.m00 = 0.0;
        this.m01 = 1.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = 0.0;
        this.m12 = -1.0;
        this.m13 = 0.0;
        this.m20 = 1.0;
        this.m21 = 0.0;
        this.m22 = 0.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_AFFINE;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+z, +y, +x)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingZYX() {
        this.m00 = 0.0;
        this.m01 = 0.0;
        this.m02 = 1.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = 1.0;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = 1.0;
        this.m21 = 0.0;
        this.m22 = 0.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_AFFINE;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+z, +y, -x)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingZYnX() {
        this.m00 = 0.0;
        this.m01 = 0.0;
        this.m02 = -1.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = 1.0;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = 1.0;
        this.m21 = 0.0;
        this.m22 = 0.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+z, -x, +y)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingZnXY() {
        this.m00 = 0.0;
        this.m01 = -1.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = 0.0;
        this.m12 = 1.0;
        this.m13 = 0.0;
        this.m20 = 1.0;
        this.m21 = 0.0;
        this.m22 = 0.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_AFFINE;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+z, -x, -y)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingZnXnY() {
        this.m00 = 0.0;
        this.m01 = -1.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = 0.0;
        this.m12 = -1.0;
        this.m13 = 0.0;
        this.m20 = 1.0;
        this.m21 = 0.0;
        this.m22 = 0.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+z, -y, +x)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingZnYX() {
        this.m00 = 0.0;
        this.m01 = 0.0;
        this.m02 = 1.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = -1.0;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = 1.0;
        this.m21 = 0.0;
        this.m22 = 0.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+z, -y, -x)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingZnYnX() {
        this.m00 = 0.0;
        this.m01 = 0.0;
        this.m02 = -1.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = -1.0;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = 1.0;
        this.m21 = 0.0;
        this.m22 = 0.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_AFFINE;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-x, +y, +z)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingnXYZ() {
        this.m00 = -1.0;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = 1.0;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = 1.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_AFFINE;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-x, +y, -z)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingnXYnZ() {
        this.m00 = -1.0;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = 1.0;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = -1.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-x, +z, +y)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingnXZY() {
        this.m00 = -1.0;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = 0.0;
        this.m12 = 1.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = 1.0;
        this.m22 = 0.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-x, +z, -y)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingnXZnY() {
        this.m00 = -1.0;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = 0.0;
        this.m12 = -1.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = 1.0;
        this.m22 = 0.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_AFFINE;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-x, -y, +z)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingnXnYZ() {
        this.m00 = -1.0;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = -1.0;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = 1.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-x, -y, -z)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingnXnYnZ() {
        this.m00 = -1.0;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = -1.0;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = -1.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_AFFINE;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-x, -z, +y)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingnXnZY() {
        this.m00 = -1.0;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = 0.0;
        this.m12 = 1.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = -1.0;
        this.m22 = 0.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_AFFINE;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-x, -z, -y)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingnXnZnY() {
        this.m00 = -1.0;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = 0.0;
        this.m12 = -1.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = -1.0;
        this.m22 = 0.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-y, +x, +z)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingnYXZ() {
        this.m00 = 0.0;
        this.m01 = 1.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = -1.0;
        this.m11 = 0.0;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = 1.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-y, +x, -z)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingnYXnZ() {
        this.m00 = 0.0;
        this.m01 = 1.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = -1.0;
        this.m11 = 0.0;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = -1.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_AFFINE;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-y, +z, +x)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingnYZX() {
        this.m00 = 0.0;
        this.m01 = 0.0;
        this.m02 = 1.0;
        this.m03 = 0.0;
        this.m10 = -1.0;
        this.m11 = 0.0;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = 1.0;
        this.m22 = 0.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_AFFINE;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-y, +z, -x)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingnYZnX() {
        this.m00 = 0.0;
        this.m01 = 0.0;
        this.m02 = -1.0;
        this.m03 = 0.0;
        this.m10 = -1.0;
        this.m11 = 0.0;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = 1.0;
        this.m22 = 0.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-y, -x, +z)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingnYnXZ() {
        this.m00 = 0.0;
        this.m01 = -1.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = -1.0;
        this.m11 = 0.0;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = 1.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_AFFINE;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-y, -x, -z)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingnYnXnZ() {
        this.m00 = 0.0;
        this.m01 = -1.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = -1.0;
        this.m11 = 0.0;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = -1.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-y, -z, +x)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingnYnZX() {
        this.m00 = 0.0;
        this.m01 = 0.0;
        this.m02 = 1.0;
        this.m03 = 0.0;
        this.m10 = -1.0;
        this.m11 = 0.0;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = -1.0;
        this.m22 = 0.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-y, -z, -x)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingnYnZnX() {
        this.m00 = 0.0;
        this.m01 = 0.0;
        this.m02 = -1.0;
        this.m03 = 0.0;
        this.m10 = -1.0;
        this.m11 = 0.0;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = -1.0;
        this.m22 = 0.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_AFFINE;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-z, +x, +y)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingnZXY() {
        this.m00 = 0.0;
        this.m01 = 1.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = 0.0;
        this.m12 = 1.0;
        this.m13 = 0.0;
        this.m20 = -1.0;
        this.m21 = 0.0;
        this.m22 = 0.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_AFFINE;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-z, +x, -y)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingnZXnY() {
        this.m00 = 0.0;
        this.m01 = 1.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = 0.0;
        this.m12 = -1.0;
        this.m13 = 0.0;
        this.m20 = -1.0;
        this.m21 = 0.0;
        this.m22 = 0.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-z, +y, +x)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingnZYX() {
        this.m00 = 0.0;
        this.m01 = 0.0;
        this.m02 = 1.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = 1.0;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = -1.0;
        this.m21 = 0.0;
        this.m22 = 0.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-z, +y, -x)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingnZYnX() {
        this.m00 = 0.0;
        this.m01 = 0.0;
        this.m02 = -1.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = 1.0;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = -1.0;
        this.m21 = 0.0;
        this.m22 = 0.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_AFFINE;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-z, -x, +y)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingnZnXY() {
        this.m00 = 0.0;
        this.m01 = -1.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = 0.0;
        this.m12 = 1.0;
        this.m13 = 0.0;
        this.m20 = -1.0;
        this.m21 = 0.0;
        this.m22 = 0.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-z, -x, -y)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingnZnXnY() {
        this.m00 = 0.0;
        this.m01 = -1.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = 0.0;
        this.m12 = -1.0;
        this.m13 = 0.0;
        this.m20 = -1.0;
        this.m21 = 0.0;
        this.m22 = 0.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_AFFINE;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-z, -y, +x)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingnZnYX() {
        this.m00 = 0.0;
        this.m01 = 0.0;
        this.m02 = 1.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = -1.0;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = -1.0;
        this.m21 = 0.0;
        this.m22 = 0.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_AFFINE;
        return this;
    }


    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-z, -y, -x)}.
     *
     * @return this
     */
    @Mutated public Double3x4 makeMappingnZnYnX() {
        this.m00 = 0.0;
        this.m01 = 0.0;
        this.m02 = -1.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = -1.0;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = -1.0;
        this.m21 = 0.0;
        this.m22 = 0.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Set this matrix to a reflection transformation about the plane through the origin with the
     * normal {@code normal}.
     *
     * @param normal the normal (must be a unit vector)
     * @return this
     */
    public @Mutated Double3x4 makeReflection(Double3R normal) {
        return makeReflection(normal.x(), normal.y(), normal.z());
    }


    /**
     * Set this matrix to a reflection transformation about the plane through the origin with the
     * normal ({@code normalX}, {@code normalY}, {@code normalZ}).
     *
     * @param normalX the {@code x} component of the vector {@code (normalX, normalY, normalZ)} (the
     *        vector must have unit length)
     * @param normalY the {@code y} component of the vector {@code (normalX, normalY, normalZ)} (the
     *        vector must have unit length)
     * @param normalZ the {@code z} component of the vector {@code (normalX, normalY, normalZ)} (the
     *        vector must have unit length)
     * @return this
     */
    @Mutated public Double3x4 makeReflection(double normalX, double normalY, double normalZ) {
        double _t6 = -(2.0 * normalX * normalY);
        double _t7 = -(2.0 * normalX * normalZ);
        double _t8 = -(2.0 * normalY * normalZ);
        this.m00 = Math.fma(-2.0, normalX * normalX, 1.0);
        this.m01 = _t6;
        this.m02 = _t7;
        this.m03 = 0.0;
        this.m10 = _t6;
        this.m11 = Math.fma(-2.0, normalY * normalY, 1.0);
        this.m12 = _t8;
        this.m13 = 0.0;
        this.m20 = _t7;
        this.m21 = _t8;
        this.m22 = Math.fma(-2.0, normalZ * normalZ, 1.0);
        this.m23 = 0.0;
        this.properties = Joml.BIT_AFFINE;
        return this;
    }


    /**
     * Set this matrix to a rotation of {@code angle} radians about the axis {@code axis}.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @return this
     */
    public @Mutated Double3x4 makeRotationAxis(double angle, Double3R axis) {
        return makeRotationAxis(angle, axis.x(), axis.y(), axis.z());
    }


    /**
     * Set this matrix to a rotation of {@code angle} radians about the axis ({@code axisX},
     * {@code axisY}, {@code axisZ}).
     *
     * @param angle the angle in radians
     * @param axisX the {@code x} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisY the {@code y} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisZ the {@code z} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @return this
     */
    @Mutated public Double3x4 makeRotationAxis(double angle, double axisX, double axisY, double axisZ) {
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t2 = 1.0 - _t0;
        double _t3 = axisX * axisY;
        double _t4 = axisX * axisZ;
        double _t5 = axisY * axisZ;
        this.m00 = Math.fma(_t2, axisX * axisX, _t0);
        this.m01 = Math.fma(_t2, _t3, -(axisZ * _t1));
        this.m02 = Math.fma(axisY, _t1, _t2 * _t4);
        this.m03 = 0.0;
        this.m10 = Math.fma(axisZ, _t1, _t2 * _t3);
        this.m11 = Math.fma(_t2, axisY * axisY, _t0);
        this.m12 = Math.fma(_t2, _t5, -(axisX * _t1));
        this.m13 = 0.0;
        this.m20 = Math.fma(_t2, _t4, -(axisY * _t1));
        this.m21 = Math.fma(axisX, _t1, _t2 * _t5);
        this.m22 = Math.fma(_t2, axisZ * axisZ, _t0);
        this.m23 = 0.0;
        this.properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Set this matrix to a rotation that makes {@code +z} point along {@code dir}.
     *
     * @param dir the direction
     * @param up the direction of "up"
     * @return this
     */
    public @Mutated Double3x4 makeRotationLookAlong(Double3R dir, Double3R up) {
        return makeRotationLookAlong(dir.x(), dir.y(), dir.z(), up.x(), up.y(), up.z());
    }


    /**
     * Set this matrix to a rotation that makes {@code +z} point along ({@code dirX}, {@code dirY},
     * {@code dirZ}).
     *
     * @param dirX the {@code x} component of the vector {@code (dirX, dirY, dirZ)}
     * @param dirY the {@code y} component of the vector {@code (dirX, dirY, dirZ)}
     * @param dirZ the {@code z} component of the vector {@code (dirX, dirY, dirZ)}
     * @param upX the {@code x} component of the vector {@code (upX, upY, upZ)}
     * @param upY the {@code y} component of the vector {@code (upX, upY, upZ)}
     * @param upZ the {@code z} component of the vector {@code (upX, upY, upZ)}
     * @return this
     */
    @Mutated public Double3x4 makeRotationLookAlong(double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        double _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7, _t8, _t9;
        if (_t2 > 0.0) {
            _t7 = dirY * _t3;
            _t8 = dirX * _t3;
            _t9 = dirZ * _t3;
        } else {
            _t7 = 0.0;
            _t8 = 0.0;
            _t9 = 0.0;
        }
        double _t16 = Math.fma(upX, _t7, -(upY * _t8));
        double _t17 = Math.fma(upY, _t9, -(upZ * _t7));
        double _t18 = Math.fma(upZ, _t8, -(upX * _t9));
        double _t21 = Math.fma(_t16, _t16, Math.fma(_t17, _t17, _t18 * _t18));
        double _t22 = (1.0 / Math.sqrt(_t21));
        double _t26, _t27, _t28;
        if (_t21 > 0.0) {
            _t26 = _t17 * _t22;
            _t27 = _t16 * _t22;
            _t28 = _t18 * _t22;
        } else {
            _t26 = 0.0;
            _t27 = 0.0;
            _t28 = 0.0;
        }
        this.m00 = _t26;
        this.m01 = Math.fma(_t7, _t27, -(_t9 * _t28));
        this.m02 = _t8;
        this.m03 = 0.0;
        this.m10 = _t28;
        this.m11 = Math.fma(_t9, _t26, -(_t8 * _t27));
        this.m12 = _t7;
        this.m13 = 0.0;
        this.m20 = _t27;
        this.m21 = Math.fma(_t8, _t28, -(_t7 * _t26));
        this.m22 = _t9;
        this.m23 = 0.0;
        this.properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Set this matrix to the rotation represented by the quaternion {@code q}.
     *
     * @param q the quaternion (must be a unit quaternion)
     * @return this
     */
    public @Mutated Double3x4 makeRotationQuat(DoubleQuatR q) {
        return makeRotationQuat(q.x(), q.y(), q.z(), q.w());
    }


    /**
     * Set this matrix to the rotation represented by the quaternion ({@code qX}, {@code qY},
     * {@code qZ}, {@code qW}).
     *
     * @param qX the {@code x} component of the quaternion {@code (qX, qY, qZ, qW)} (the quaternion
     *        must have unit length)
     * @param qY the {@code y} component of the quaternion {@code (qX, qY, qZ, qW)} (the quaternion
     *        must have unit length)
     * @param qZ the {@code z} component of the quaternion {@code (qX, qY, qZ, qW)} (the quaternion
     *        must have unit length)
     * @param qW the {@code w} component of the quaternion {@code (qX, qY, qZ, qW)} (the quaternion
     *        must have unit length)
     * @return this
     */
    @Mutated public Double3x4 makeRotationQuat(double qX, double qY, double qZ, double qW) {
        double _t0 = qZ * qZ;
        double _t1 = qZ * qW;
        double _t2 = qY * qW;
        this.m00 = Math.fma(-2.0, Math.fma(qY, qY, _t0), 1.0);
        this.m01 = 2.0 * Math.fma(qX, qY, -_t1);
        this.m02 = 2.0 * Math.fma(qX, qZ, _t2);
        this.m03 = 0.0;
        this.m10 = 2.0 * Math.fma(qX, qY, _t1);
        this.m11 = Math.fma(-2.0, Math.fma(qX, qX, _t0), 1.0);
        this.m12 = 2.0 * Math.fma(qY, qZ, -(qX * qW));
        this.m13 = 0.0;
        this.m20 = 2.0 * Math.fma(qX, qZ, -_t2);
        this.m21 = 2.0 * Math.fma(qX, qW, qY * qZ);
        this.m22 = Math.fma(-2.0, Math.fma(qX, qX, qY * qY), 1.0);
        this.m23 = 0.0;
        this.properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Set this matrix to a rotation of {@code angle} radians about the X axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public Double3x4 makeRotationX(double angle) {
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        this.m00 = 1.0;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = _t0;
        this.m12 = -_t1;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = _t1;
        this.m22 = _t0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Set this matrix to a rotation of {@code angleX}, {@code angleY} and {@code angleZ} radians
     * about the X, Y and Z axes, in that order (the matrix product {@code Rx * Ry * Rz}, so a
     * vector is rotated about the Z axis first, then Y, then X).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public Double3x4 makeRotationXYZ(double angleX, double angleY, double angleZ) {
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleZ);
        double _t3 = Math.sin(angleY);
        double _t4 = Math.sin(angleX);
        double _t5 = Math.cos(angleX);
        double _t6 = _t4 * _t3;
        double _t7 = _t3 * _t5;
        this.m00 = _t0 * _t1;
        this.m01 = -(_t2 * _t0);
        this.m02 = _t3;
        this.m03 = 0.0;
        this.m10 = Math.fma(_t6, _t1, _t2 * _t5);
        this.m11 = Math.fma(_t5, _t1, -(_t6 * _t2));
        this.m12 = -(_t4 * _t0);
        this.m13 = 0.0;
        this.m20 = Math.fma(_t4, _t2, -(_t7 * _t1));
        this.m21 = Math.fma(_t7, _t2, _t4 * _t1);
        this.m22 = _t5 * _t0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Set this matrix to a rotation of {@code angleX}, {@code angleZ} and {@code angleY} radians
     * about the X, Z and Y axes, in that order (the matrix product {@code Rx * Rz * Ry}, so a
     * vector is rotated about the Y axis first, then Z, then X).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public Double3x4 makeRotationXZY(double angleX, double angleY, double angleZ) {
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleZ);
        double _t3 = Math.sin(angleY);
        double _t4 = Math.cos(angleX);
        double _t5 = Math.sin(angleX);
        double _t6 = _t2 * _t4;
        double _t7 = _t5 * _t2;
        this.m00 = _t0 * _t1;
        this.m01 = -_t2;
        this.m02 = _t3 * _t1;
        this.m03 = 0.0;
        this.m10 = Math.fma(_t6, _t0, _t5 * _t3);
        this.m11 = _t4 * _t1;
        this.m12 = Math.fma(_t6, _t3, -(_t5 * _t0));
        this.m13 = 0.0;
        this.m20 = Math.fma(_t7, _t0, -(_t3 * _t4));
        this.m21 = _t5 * _t1;
        this.m22 = Math.fma(_t7, _t3, _t4 * _t0);
        this.m23 = 0.0;
        this.properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Set this matrix to a rotation of {@code angle} radians about the Y axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public Double3x4 makeRotationY(double angle) {
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        this.m00 = _t0;
        this.m01 = 0.0;
        this.m02 = _t1;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = 1.0;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = -_t1;
        this.m21 = 0.0;
        this.m22 = _t0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Set this matrix to a rotation of {@code angleY}, {@code angleX} and {@code angleZ} radians
     * about the Y, X and Z axes, in that order (the matrix product {@code Ry * Rx * Rz}, so a
     * vector is rotated about the Z axis first, then X, then Y).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public Double3x4 makeRotationYXZ(double angleX, double angleY, double angleZ) {
        double _t0 = Math.sin(angleX);
        double _t1 = Math.sin(angleY);
        double _t2 = Math.sin(angleZ);
        double _t3 = Math.cos(angleY);
        double _t4 = Math.cos(angleZ);
        double _t5 = Math.cos(angleX);
        double _t6 = _t0 * _t1;
        double _t7 = _t0 * _t3;
        this.m00 = Math.fma(_t6, _t2, _t3 * _t4);
        this.m01 = Math.fma(_t6, _t4, -(_t2 * _t3));
        this.m02 = _t1 * _t5;
        this.m03 = 0.0;
        this.m10 = _t2 * _t5;
        this.m11 = _t5 * _t4;
        this.m12 = -_t0;
        this.m13 = 0.0;
        this.m20 = Math.fma(_t7, _t2, -(_t1 * _t4));
        this.m21 = Math.fma(_t7, _t4, _t1 * _t2);
        this.m22 = _t5 * _t3;
        this.m23 = 0.0;
        this.properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Set this matrix to a rotation of {@code angleY}, {@code angleZ} and {@code angleX} radians
     * about the Y, Z and X axes, in that order (the matrix product {@code Ry * Rz * Rx}, so a
     * vector is rotated about the X axis first, then Z, then Y).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public Double3x4 makeRotationYZX(double angleX, double angleY, double angleZ) {
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleX);
        double _t3 = Math.sin(angleY);
        double _t4 = Math.sin(angleZ);
        double _t5 = Math.cos(angleX);
        double _t6 = _t4 * _t0;
        double _t7 = _t3 * _t4;
        this.m00 = _t0 * _t1;
        this.m01 = Math.fma(_t2, _t3, -(_t6 * _t5));
        this.m02 = Math.fma(_t6, _t2, _t3 * _t5);
        this.m03 = 0.0;
        this.m10 = _t4;
        this.m11 = _t5 * _t1;
        this.m12 = -(_t2 * _t1);
        this.m13 = 0.0;
        this.m20 = -(_t3 * _t1);
        this.m21 = Math.fma(_t7, _t5, _t2 * _t0);
        this.m22 = Math.fma(_t5, _t0, -(_t7 * _t2));
        this.m23 = 0.0;
        this.properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Set this matrix to a rotation of {@code angle} radians about the Z axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public Double3x4 makeRotationZ(double angle) {
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        this.m00 = _t0;
        this.m01 = -_t1;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = _t1;
        this.m11 = _t0;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = 1.0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Set this matrix to a rotation of {@code angleZ}, {@code angleX} and {@code angleY} radians
     * about the Z, X and Y axes, in that order (the matrix product {@code Rz * Rx * Ry}, so a
     * vector is rotated about the Y axis first, then X, then Z).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public Double3x4 makeRotationZXY(double angleX, double angleY, double angleZ) {
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleX);
        double _t3 = Math.sin(angleZ);
        double _t4 = Math.sin(angleY);
        double _t5 = Math.cos(angleX);
        double _t6 = _t2 * _t3;
        double _t7 = _t2 * _t1;
        this.m00 = Math.fma(_t0, _t1, -(_t6 * _t4));
        this.m01 = -(_t3 * _t5);
        this.m02 = Math.fma(_t6, _t0, _t4 * _t1);
        this.m03 = 0.0;
        this.m10 = Math.fma(_t7, _t4, _t3 * _t0);
        this.m11 = _t5 * _t1;
        this.m12 = Math.fma(_t4, _t3, -(_t7 * _t0));
        this.m13 = 0.0;
        this.m20 = -(_t4 * _t5);
        this.m21 = _t2;
        this.m22 = _t5 * _t0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Set this matrix to a rotation of {@code angleZ}, {@code angleY} and {@code angleX} radians
     * about the Z, Y and X axes, in that order (the matrix product {@code Rz * Ry * Rx}, so a
     * vector is rotated about the X axis first, then Y, then Z).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public Double3x4 makeRotationZYX(double angleX, double angleY, double angleZ) {
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleY);
        double _t3 = Math.sin(angleX);
        double _t4 = Math.sin(angleZ);
        double _t5 = Math.cos(angleX);
        double _t6 = _t2 * _t1;
        double _t7 = _t2 * _t4;
        this.m00 = _t0 * _t1;
        this.m01 = Math.fma(_t6, _t3, -(_t4 * _t5));
        this.m02 = Math.fma(_t6, _t5, _t3 * _t4);
        this.m03 = 0.0;
        this.m10 = _t4 * _t0;
        this.m11 = Math.fma(_t7, _t3, _t5 * _t1);
        this.m12 = Math.fma(_t7, _t5, -(_t3 * _t1));
        this.m13 = 0.0;
        this.m20 = -_t2;
        this.m21 = _t3 * _t0;
        this.m22 = _t5 * _t0;
        this.m23 = 0.0;
        this.properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Set this matrix to a scaling transformation that scales by {@code v}.
     *
     * @param v the vector
     * @return this
     */
    public @Mutated Double3x4 makeScaling(Double3R v) {
        return makeScaling(v.x(), v.y(), v.z());
    }


    /**
     * Set this matrix to a scaling transformation that scales by ({@code vX}, {@code vY},
     * {@code vZ}).
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @return this
     */
    @Mutated public Double3x4 makeScaling(double vX, double vY, double vZ) {
        this.m00 = vX;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = vY;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = vZ;
        this.m23 = 0.0;
        this.properties = Joml.BIT_AFFINE;
        return this;
    }


    /**
     * Set this matrix to a scaling transformation that scales by {@code s}.
     *
     * @param s the uniform scale factor
     * @return this
     */
    @Mutated public Double3x4 makeScaling(double s) {
        this.m00 = s;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = s;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = s;
        this.m23 = 0.0;
        this.properties = Joml.BIT_AFFINE;
        return this;
    }


    /**
     * Set this matrix to a translation transformation that translates by {@code v}.
     *
     * @param v the translation offsets
     * @return this
     */
    public @Mutated Double3x4 makeTranslation(Double3R v) {
        return makeTranslation(v.x(), v.y(), v.z());
    }


    /**
     * Set this matrix to a translation transformation that translates by ({@code vX}, {@code vY},
     * {@code vZ}).
     *
     * @param vX the {@code x} component of the translation offsets {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the translation offsets {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the translation offsets {@code (vX, vY, vZ)}
     * @return this
     */
    @Mutated public Double3x4 makeTranslation(double vX, double vY, double vZ) {
        this.m00 = 1.0;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m03 = vX;
        this.m10 = 0.0;
        this.m11 = 1.0;
        this.m12 = 0.0;
        this.m13 = vY;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = 1.0;
        this.m23 = vZ;
        this.properties = Joml.BIT_TRANSLATION;
        return this;
    }


    /**
     * Private body of {@code mapXYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXYZ} dispatcher.
     */
    private Double3x4 mapXYZ_orthogonal_general(@Mutated Double3x4 dest, int _props) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = this.m00;
        d.m01 = this.m01;
        d.m02 = this.m02;
        d.m03 = this.m03;
        d.m10 = this.m10;
        d.m11 = this.m11;
        d.m12 = this.m12;
        d.m13 = this.m13;
        d.m20 = this.m20;
        d.m21 = this.m21;
        d.m22 = this.m22;
        d.m23 = this.m23;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code mapXYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXYZ} dispatcher.
     */
    private Double3x4 mapXYZ_identity(@Mutated Double3x4 dest) {
        return invert_identity(dest);
    }


    /**
     * Private in-place self-form body of {@code mapXYZ}, specialized by runtime matrix properties;
     * reached only through the public {@code mapXYZ} dispatcher.
     */
    private Double3x4 mapXYZ_identity_self(@Mutated Double3x4 dest) {
        return invert_identity_self(dest);
    }


    /**
     * Private body of {@code mapXYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXYZ} dispatcher.
     */
    private Double3x4 mapXYZ_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = this.m03;
        d.m10 = 0.0;
        d.m11 = 1.0;
        d.m12 = 0.0;
        d.m13 = this.m13;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 1.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_TRANSLATION;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapXYZ}, specialized by runtime matrix properties;
     * reached only through the public {@code mapXYZ} dispatcher.
     */
    private Double3x4 mapXYZ_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m03 = this.m03;
        d.m13 = this.m13;
        d.m23 = this.m23;
        d.properties = Joml.BIT_TRANSLATION;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, +y, +z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapXYZ(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapXYZ_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapXYZ_translation(dest);
        return mapXYZ_orthogonal_general(dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, +y, +z)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapXYZ() {
        if (Joml.RETURN_NEW) return mapXYZ(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapXYZ_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapXYZ_translation_self(this);
        return mapXYZ_orthogonal_general(this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapXYnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXYnZ} dispatcher.
     */
    private Double3x4 mapXYnZ_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = 0.0;
        d.m10 = 0.0;
        d.m11 = 1.0;
        d.m12 = 0.0;
        d.m13 = 0.0;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = -1.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapXYnZ}, specialized by runtime matrix properties;
     * reached only through the public {@code mapXYnZ} dispatcher.
     */
    private Double3x4 mapXYnZ_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m22 = -1.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapXYnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXYnZ} dispatcher.
     */
    private Double3x4 mapXYnZ_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = this.m03;
        d.m10 = 0.0;
        d.m11 = 1.0;
        d.m12 = 0.0;
        d.m13 = this.m13;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = -1.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapXYnZ}, specialized by runtime matrix properties;
     * reached only through the public {@code mapXYnZ} dispatcher.
     */
    private Double3x4 mapXYnZ_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m03 = this.m03;
        d.m13 = this.m13;
        d.m22 = -1.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapXYnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXYnZ} dispatcher.
     */
    private Double3x4 mapXYnZ_general(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = this.m00;
        d.m01 = this.m01;
        d.m02 = -this.m02;
        d.m03 = this.m03;
        d.m10 = this.m10;
        d.m11 = this.m11;
        d.m12 = -this.m12;
        d.m13 = this.m13;
        d.m20 = this.m20;
        d.m21 = this.m21;
        d.m22 = -this.m22;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, +y, -z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapXYnZ(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapXYnZ_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapXYnZ_translation(dest);
        return mapXYnZ_general(dest);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, +y, -z)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapXYnZ() {
        if (Joml.RETURN_NEW) return mapXYnZ(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapXYnZ_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapXYnZ_translation_self(this);
        return mapXYnZ_general(this);
    }


    /**
     * Private body of {@code mapXZY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXZY} dispatcher.
     */
    private Double3x4 mapXZY_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = 0.0;
        d.m10 = 0.0;
        d.m11 = 0.0;
        d.m12 = 1.0;
        d.m13 = 0.0;
        d.m20 = 0.0;
        d.m21 = 1.0;
        d.m22 = 0.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapXZY}, specialized by runtime matrix properties;
     * reached only through the public {@code mapXZY} dispatcher.
     */
    private Double3x4 mapXZY_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m11 = 0.0;
        d.m12 = 1.0;
        d.m21 = 1.0;
        d.m22 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapXZY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXZY} dispatcher.
     */
    private Double3x4 mapXZY_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = this.m03;
        d.m10 = 0.0;
        d.m11 = 0.0;
        d.m12 = 1.0;
        d.m13 = this.m13;
        d.m20 = 0.0;
        d.m21 = 1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapXZY}, specialized by runtime matrix properties;
     * reached only through the public {@code mapXZY} dispatcher.
     */
    private Double3x4 mapXZY_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m03 = this.m03;
        d.m11 = 0.0;
        d.m12 = 1.0;
        d.m13 = this.m13;
        d.m21 = 1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapXZY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXZY} dispatcher.
     */
    private Double3x4 mapXZY_general(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = this.m00;
        double _buf0 = this.m02;
        d.m02 = this.m01;
        d.m03 = this.m03;
        d.m10 = this.m10;
        double _buf1 = this.m12;
        d.m12 = this.m11;
        d.m13 = this.m13;
        d.m20 = this.m20;
        double _buf2 = this.m22;
        d.m22 = this.m21;
        d.m23 = this.m23;
        d.m01 = _buf0;
        d.m11 = _buf1;
        d.m21 = _buf2;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, +z, +y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapXZY(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapXZY_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapXZY_translation(dest);
        return mapXZY_general(dest);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, +z, +y)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapXZY() {
        if (Joml.RETURN_NEW) return mapXZY(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapXZY_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapXZY_translation_self(this);
        return mapXZY_general(this);
    }


    /**
     * Private body of {@code mapXZnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXZnY} dispatcher.
     */
    private Double3x4 mapXZnY_orthogonal_general(@Mutated Double3x4 dest, int _props) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = this.m00;
        double _buf0 = this.m02;
        d.m02 = -this.m01;
        d.m03 = this.m03;
        d.m10 = this.m10;
        double _buf1 = this.m12;
        d.m12 = -this.m11;
        d.m13 = this.m13;
        d.m20 = this.m20;
        double _buf2 = this.m22;
        d.m22 = -this.m21;
        d.m23 = this.m23;
        d.m01 = _buf0;
        d.m11 = _buf1;
        d.m21 = _buf2;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code mapXZnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXZnY} dispatcher.
     */
    private Double3x4 mapXZnY_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = 0.0;
        d.m10 = 0.0;
        d.m11 = 0.0;
        d.m12 = -1.0;
        d.m13 = 0.0;
        d.m20 = 0.0;
        d.m21 = 1.0;
        d.m22 = 0.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapXZnY}, specialized by runtime matrix properties;
     * reached only through the public {@code mapXZnY} dispatcher.
     */
    private Double3x4 mapXZnY_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m11 = 0.0;
        d.m12 = -1.0;
        d.m21 = 1.0;
        d.m22 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code mapXZnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXZnY} dispatcher.
     */
    private Double3x4 mapXZnY_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = this.m03;
        d.m10 = 0.0;
        d.m11 = 0.0;
        d.m12 = -1.0;
        d.m13 = this.m13;
        d.m20 = 0.0;
        d.m21 = 1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapXZnY}, specialized by runtime matrix properties;
     * reached only through the public {@code mapXZnY} dispatcher.
     */
    private Double3x4 mapXZnY_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m03 = this.m03;
        d.m11 = 0.0;
        d.m12 = -1.0;
        d.m13 = this.m13;
        d.m21 = 1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, +z, -y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapXZnY(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapXZnY_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapXZnY_translation(dest);
        return mapXZnY_orthogonal_general(dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, +z, -y)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapXZnY() {
        if (Joml.RETURN_NEW) return mapXZnY(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapXZnY_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapXZnY_translation_self(this);
        return mapXZnY_orthogonal_general(this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapXnYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXnYZ} dispatcher.
     */
    private Double3x4 mapXnYZ_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = 0.0;
        d.m10 = 0.0;
        d.m11 = -1.0;
        d.m12 = 0.0;
        d.m13 = 0.0;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 1.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapXnYZ}, specialized by runtime matrix properties;
     * reached only through the public {@code mapXnYZ} dispatcher.
     */
    private Double3x4 mapXnYZ_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m11 = -1.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapXnYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXnYZ} dispatcher.
     */
    private Double3x4 mapXnYZ_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = this.m03;
        d.m10 = 0.0;
        d.m11 = -1.0;
        d.m12 = 0.0;
        d.m13 = this.m13;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 1.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapXnYZ}, specialized by runtime matrix properties;
     * reached only through the public {@code mapXnYZ} dispatcher.
     */
    private Double3x4 mapXnYZ_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m03 = this.m03;
        d.m11 = -1.0;
        d.m13 = this.m13;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapXnYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXnYZ} dispatcher.
     */
    private Double3x4 mapXnYZ_general(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = this.m00;
        d.m01 = -this.m01;
        d.m02 = this.m02;
        d.m03 = this.m03;
        d.m10 = this.m10;
        d.m11 = -this.m11;
        d.m12 = this.m12;
        d.m13 = this.m13;
        d.m20 = this.m20;
        d.m21 = -this.m21;
        d.m22 = this.m22;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, -y, +z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapXnYZ(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapXnYZ_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapXnYZ_translation(dest);
        return mapXnYZ_general(dest);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, -y, +z)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapXnYZ() {
        if (Joml.RETURN_NEW) return mapXnYZ(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapXnYZ_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapXnYZ_translation_self(this);
        return mapXnYZ_general(this);
    }


    /**
     * Private body of {@code mapXnYnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXnYnZ} dispatcher.
     */
    private Double3x4 mapXnYnZ_orthogonal_general(@Mutated Double3x4 dest, int _props) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = this.m00;
        d.m01 = -this.m01;
        d.m02 = -this.m02;
        d.m03 = this.m03;
        d.m10 = this.m10;
        d.m11 = -this.m11;
        d.m12 = -this.m12;
        d.m13 = this.m13;
        d.m20 = this.m20;
        d.m21 = -this.m21;
        d.m22 = -this.m22;
        d.m23 = this.m23;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code mapXnYnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXnYnZ} dispatcher.
     */
    private Double3x4 mapXnYnZ_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = 0.0;
        d.m10 = 0.0;
        d.m11 = -1.0;
        d.m12 = 0.0;
        d.m13 = 0.0;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = -1.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapXnYnZ}, specialized by runtime matrix
     * properties; reached only through the public {@code mapXnYnZ} dispatcher.
     */
    private Double3x4 mapXnYnZ_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m11 = -1.0;
        d.m22 = -1.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code mapXnYnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXnYnZ} dispatcher.
     */
    private Double3x4 mapXnYnZ_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = this.m03;
        d.m10 = 0.0;
        d.m11 = -1.0;
        d.m12 = 0.0;
        d.m13 = this.m13;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = -1.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapXnYnZ}, specialized by runtime matrix
     * properties; reached only through the public {@code mapXnYnZ} dispatcher.
     */
    private Double3x4 mapXnYnZ_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m03 = this.m03;
        d.m11 = -1.0;
        d.m13 = this.m13;
        d.m22 = -1.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, -y, -z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapXnYnZ(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapXnYnZ_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapXnYnZ_translation(dest);
        return mapXnYnZ_orthogonal_general(dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, -y, -z)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapXnYnZ() {
        if (Joml.RETURN_NEW) return mapXnYnZ(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapXnYnZ_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapXnYnZ_translation_self(this);
        return mapXnYnZ_orthogonal_general(this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapXnZY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXnZY} dispatcher.
     */
    private Double3x4 mapXnZY_orthogonal_general(@Mutated Double3x4 dest, int _props) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = this.m00;
        double _buf0 = -this.m02;
        d.m02 = this.m01;
        d.m03 = this.m03;
        d.m10 = this.m10;
        double _buf1 = -this.m12;
        d.m12 = this.m11;
        d.m13 = this.m13;
        d.m20 = this.m20;
        double _buf2 = -this.m22;
        d.m22 = this.m21;
        d.m23 = this.m23;
        d.m01 = _buf0;
        d.m11 = _buf1;
        d.m21 = _buf2;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code mapXnZY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXnZY} dispatcher.
     */
    private Double3x4 mapXnZY_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = 0.0;
        d.m10 = 0.0;
        d.m11 = 0.0;
        d.m12 = 1.0;
        d.m13 = 0.0;
        d.m20 = 0.0;
        d.m21 = -1.0;
        d.m22 = 0.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapXnZY}, specialized by runtime matrix properties;
     * reached only through the public {@code mapXnZY} dispatcher.
     */
    private Double3x4 mapXnZY_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m11 = 0.0;
        d.m12 = 1.0;
        d.m21 = -1.0;
        d.m22 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code mapXnZY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXnZY} dispatcher.
     */
    private Double3x4 mapXnZY_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = this.m03;
        d.m10 = 0.0;
        d.m11 = 0.0;
        d.m12 = 1.0;
        d.m13 = this.m13;
        d.m20 = 0.0;
        d.m21 = -1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapXnZY}, specialized by runtime matrix properties;
     * reached only through the public {@code mapXnZY} dispatcher.
     */
    private Double3x4 mapXnZY_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m03 = this.m03;
        d.m11 = 0.0;
        d.m12 = 1.0;
        d.m13 = this.m13;
        d.m21 = -1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, -z, +y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapXnZY(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapXnZY_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapXnZY_translation(dest);
        return mapXnZY_orthogonal_general(dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, -z, +y)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapXnZY() {
        if (Joml.RETURN_NEW) return mapXnZY(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapXnZY_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapXnZY_translation_self(this);
        return mapXnZY_orthogonal_general(this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapXnZnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXnZnY} dispatcher.
     */
    private Double3x4 mapXnZnY_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = 0.0;
        d.m10 = 0.0;
        d.m11 = 0.0;
        d.m12 = -1.0;
        d.m13 = 0.0;
        d.m20 = 0.0;
        d.m21 = -1.0;
        d.m22 = 0.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapXnZnY}, specialized by runtime matrix
     * properties; reached only through the public {@code mapXnZnY} dispatcher.
     */
    private Double3x4 mapXnZnY_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m11 = 0.0;
        d.m12 = -1.0;
        d.m21 = -1.0;
        d.m22 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapXnZnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXnZnY} dispatcher.
     */
    private Double3x4 mapXnZnY_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = this.m03;
        d.m10 = 0.0;
        d.m11 = 0.0;
        d.m12 = -1.0;
        d.m13 = this.m13;
        d.m20 = 0.0;
        d.m21 = -1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapXnZnY}, specialized by runtime matrix
     * properties; reached only through the public {@code mapXnZnY} dispatcher.
     */
    private Double3x4 mapXnZnY_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m03 = this.m03;
        d.m11 = 0.0;
        d.m12 = -1.0;
        d.m13 = this.m13;
        d.m21 = -1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapXnZnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXnZnY} dispatcher.
     */
    private Double3x4 mapXnZnY_general(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = this.m00;
        double _buf0 = -this.m02;
        d.m02 = -this.m01;
        d.m03 = this.m03;
        d.m10 = this.m10;
        double _buf1 = -this.m12;
        d.m12 = -this.m11;
        d.m13 = this.m13;
        d.m20 = this.m20;
        double _buf2 = -this.m22;
        d.m22 = -this.m21;
        d.m23 = this.m23;
        d.m01 = _buf0;
        d.m11 = _buf1;
        d.m21 = _buf2;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, -z, -y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapXnZnY(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapXnZnY_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapXnZnY_translation(dest);
        return mapXnZnY_general(dest);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, -z, -y)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapXnZnY() {
        if (Joml.RETURN_NEW) return mapXnZnY(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapXnZnY_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapXnZnY_translation_self(this);
        return mapXnZnY_general(this);
    }


    /**
     * Private body of {@code mapYXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYXZ} dispatcher.
     */
    private Double3x4 mapYXZ_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 1.0;
        d.m02 = 0.0;
        d.m03 = 0.0;
        d.m10 = 1.0;
        d.m11 = 0.0;
        d.m12 = 0.0;
        d.m13 = 0.0;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 1.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapYXZ}, specialized by runtime matrix properties;
     * reached only through the public {@code mapYXZ} dispatcher.
     */
    private Double3x4 mapYXZ_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 1.0;
        d.m10 = 1.0;
        d.m11 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapYXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYXZ} dispatcher.
     */
    private Double3x4 mapYXZ_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 1.0;
        d.m02 = 0.0;
        d.m03 = this.m03;
        d.m10 = 1.0;
        d.m11 = 0.0;
        d.m12 = 0.0;
        d.m13 = this.m13;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 1.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapYXZ}, specialized by runtime matrix properties;
     * reached only through the public {@code mapYXZ} dispatcher.
     */
    private Double3x4 mapYXZ_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 1.0;
        d.m03 = this.m03;
        d.m10 = 1.0;
        d.m11 = 0.0;
        d.m13 = this.m13;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapYXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYXZ} dispatcher.
     */
    private Double3x4 mapYXZ_general(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = this.m01;
        d.m01 = this.m00;
        d.m02 = this.m02;
        d.m03 = this.m03;
        double _buf1 = this.m11;
        d.m11 = this.m10;
        d.m12 = this.m12;
        d.m13 = this.m13;
        double _buf2 = this.m21;
        d.m21 = this.m20;
        d.m22 = this.m22;
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, +x, +z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapYXZ(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapYXZ_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapYXZ_translation(dest);
        return mapYXZ_general(dest);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, +x, +z)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapYXZ() {
        if (Joml.RETURN_NEW) return mapYXZ(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapYXZ_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapYXZ_translation_self(this);
        return mapYXZ_general(this);
    }


    /**
     * Private body of {@code mapYXnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYXnZ} dispatcher.
     */
    private Double3x4 mapYXnZ_orthogonal_general(@Mutated Double3x4 dest, int _props) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = this.m01;
        d.m01 = this.m00;
        d.m02 = -this.m02;
        d.m03 = this.m03;
        double _buf1 = this.m11;
        d.m11 = this.m10;
        d.m12 = -this.m12;
        d.m13 = this.m13;
        double _buf2 = this.m21;
        d.m21 = this.m20;
        d.m22 = -this.m22;
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code mapYXnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYXnZ} dispatcher.
     */
    private Double3x4 mapYXnZ_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 1.0;
        d.m02 = 0.0;
        d.m03 = 0.0;
        d.m10 = 1.0;
        d.m11 = 0.0;
        d.m12 = 0.0;
        d.m13 = 0.0;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = -1.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapYXnZ}, specialized by runtime matrix properties;
     * reached only through the public {@code mapYXnZ} dispatcher.
     */
    private Double3x4 mapYXnZ_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 1.0;
        d.m10 = 1.0;
        d.m11 = 0.0;
        d.m22 = -1.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code mapYXnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYXnZ} dispatcher.
     */
    private Double3x4 mapYXnZ_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 1.0;
        d.m02 = 0.0;
        d.m03 = this.m03;
        d.m10 = 1.0;
        d.m11 = 0.0;
        d.m12 = 0.0;
        d.m13 = this.m13;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = -1.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapYXnZ}, specialized by runtime matrix properties;
     * reached only through the public {@code mapYXnZ} dispatcher.
     */
    private Double3x4 mapYXnZ_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 1.0;
        d.m03 = this.m03;
        d.m10 = 1.0;
        d.m11 = 0.0;
        d.m13 = this.m13;
        d.m22 = -1.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, +x, -z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapYXnZ(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapYXnZ_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapYXnZ_translation(dest);
        return mapYXnZ_orthogonal_general(dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, +x, -z)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapYXnZ() {
        if (Joml.RETURN_NEW) return mapYXnZ(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapYXnZ_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapYXnZ_translation_self(this);
        return mapYXnZ_orthogonal_general(this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapYZX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYZX} dispatcher.
     */
    private Double3x4 mapYZX_orthogonal_general(@Mutated Double3x4 dest, int _props) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = this.m01;
        d.m01 = this.m02;
        d.m02 = this.m00;
        d.m03 = this.m03;
        double _buf1 = this.m11;
        d.m11 = this.m12;
        d.m12 = this.m10;
        d.m13 = this.m13;
        double _buf2 = this.m21;
        d.m21 = this.m22;
        d.m22 = this.m20;
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code mapYZX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYZX} dispatcher.
     */
    private Double3x4 mapYZX_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 0.0;
        d.m02 = 1.0;
        d.m03 = 0.0;
        d.m10 = 1.0;
        d.m11 = 0.0;
        d.m12 = 0.0;
        d.m13 = 0.0;
        d.m20 = 0.0;
        d.m21 = 1.0;
        d.m22 = 0.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapYZX}, specialized by runtime matrix properties;
     * reached only through the public {@code mapYZX} dispatcher.
     */
    private Double3x4 mapYZX_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m02 = 1.0;
        d.m10 = 1.0;
        d.m11 = 0.0;
        d.m21 = 1.0;
        d.m22 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code mapYZX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYZX} dispatcher.
     */
    private Double3x4 mapYZX_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 0.0;
        d.m02 = 1.0;
        d.m03 = this.m03;
        d.m10 = 1.0;
        d.m11 = 0.0;
        d.m12 = 0.0;
        d.m13 = this.m13;
        d.m20 = 0.0;
        d.m21 = 1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapYZX}, specialized by runtime matrix properties;
     * reached only through the public {@code mapYZX} dispatcher.
     */
    private Double3x4 mapYZX_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m02 = 1.0;
        d.m03 = this.m03;
        d.m10 = 1.0;
        d.m11 = 0.0;
        d.m13 = this.m13;
        d.m21 = 1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, +z, +x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapYZX(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapYZX_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapYZX_translation(dest);
        return mapYZX_orthogonal_general(dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, +z, +x)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapYZX() {
        if (Joml.RETURN_NEW) return mapYZX(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapYZX_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapYZX_translation_self(this);
        return mapYZX_orthogonal_general(this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapYZnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYZnX} dispatcher.
     */
    private Double3x4 mapYZnX_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 0.0;
        d.m02 = -1.0;
        d.m03 = 0.0;
        d.m10 = 1.0;
        d.m11 = 0.0;
        d.m12 = 0.0;
        d.m13 = 0.0;
        d.m20 = 0.0;
        d.m21 = 1.0;
        d.m22 = 0.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapYZnX}, specialized by runtime matrix properties;
     * reached only through the public {@code mapYZnX} dispatcher.
     */
    private Double3x4 mapYZnX_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m02 = -1.0;
        d.m10 = 1.0;
        d.m11 = 0.0;
        d.m21 = 1.0;
        d.m22 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapYZnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYZnX} dispatcher.
     */
    private Double3x4 mapYZnX_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 0.0;
        d.m02 = -1.0;
        d.m03 = this.m03;
        d.m10 = 1.0;
        d.m11 = 0.0;
        d.m12 = 0.0;
        d.m13 = this.m13;
        d.m20 = 0.0;
        d.m21 = 1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapYZnX}, specialized by runtime matrix properties;
     * reached only through the public {@code mapYZnX} dispatcher.
     */
    private Double3x4 mapYZnX_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m02 = -1.0;
        d.m03 = this.m03;
        d.m10 = 1.0;
        d.m11 = 0.0;
        d.m13 = this.m13;
        d.m21 = 1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapYZnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYZnX} dispatcher.
     */
    private Double3x4 mapYZnX_general(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = this.m01;
        d.m01 = this.m02;
        d.m02 = -this.m00;
        d.m03 = this.m03;
        double _buf1 = this.m11;
        d.m11 = this.m12;
        d.m12 = -this.m10;
        d.m13 = this.m13;
        double _buf2 = this.m21;
        d.m21 = this.m22;
        d.m22 = -this.m20;
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, +z, -x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapYZnX(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapYZnX_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapYZnX_translation(dest);
        return mapYZnX_general(dest);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, +z, -x)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapYZnX() {
        if (Joml.RETURN_NEW) return mapYZnX(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapYZnX_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapYZnX_translation_self(this);
        return mapYZnX_general(this);
    }


    /**
     * Private body of {@code mapYnXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYnXZ} dispatcher.
     */
    private Double3x4 mapYnXZ_orthogonal_general(@Mutated Double3x4 dest, int _props) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = this.m01;
        d.m01 = -this.m00;
        d.m02 = this.m02;
        d.m03 = this.m03;
        double _buf1 = this.m11;
        d.m11 = -this.m10;
        d.m12 = this.m12;
        d.m13 = this.m13;
        double _buf2 = this.m21;
        d.m21 = -this.m20;
        d.m22 = this.m22;
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code mapYnXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYnXZ} dispatcher.
     */
    private Double3x4 mapYnXZ_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = -1.0;
        d.m02 = 0.0;
        d.m03 = 0.0;
        d.m10 = 1.0;
        d.m11 = 0.0;
        d.m12 = 0.0;
        d.m13 = 0.0;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 1.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapYnXZ}, specialized by runtime matrix properties;
     * reached only through the public {@code mapYnXZ} dispatcher.
     */
    private Double3x4 mapYnXZ_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = -1.0;
        d.m10 = 1.0;
        d.m11 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code mapYnXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYnXZ} dispatcher.
     */
    private Double3x4 mapYnXZ_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = -1.0;
        d.m02 = 0.0;
        d.m03 = this.m03;
        d.m10 = 1.0;
        d.m11 = 0.0;
        d.m12 = 0.0;
        d.m13 = this.m13;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 1.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapYnXZ}, specialized by runtime matrix properties;
     * reached only through the public {@code mapYnXZ} dispatcher.
     */
    private Double3x4 mapYnXZ_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = -1.0;
        d.m03 = this.m03;
        d.m10 = 1.0;
        d.m11 = 0.0;
        d.m13 = this.m13;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, -x, +z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapYnXZ(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapYnXZ_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapYnXZ_translation(dest);
        return mapYnXZ_orthogonal_general(dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, -x, +z)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapYnXZ() {
        if (Joml.RETURN_NEW) return mapYnXZ(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapYnXZ_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapYnXZ_translation_self(this);
        return mapYnXZ_orthogonal_general(this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapYnXnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYnXnZ} dispatcher.
     */
    private Double3x4 mapYnXnZ_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = -1.0;
        d.m02 = 0.0;
        d.m03 = 0.0;
        d.m10 = 1.0;
        d.m11 = 0.0;
        d.m12 = 0.0;
        d.m13 = 0.0;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = -1.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapYnXnZ}, specialized by runtime matrix
     * properties; reached only through the public {@code mapYnXnZ} dispatcher.
     */
    private Double3x4 mapYnXnZ_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = -1.0;
        d.m10 = 1.0;
        d.m11 = 0.0;
        d.m22 = -1.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapYnXnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYnXnZ} dispatcher.
     */
    private Double3x4 mapYnXnZ_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = -1.0;
        d.m02 = 0.0;
        d.m03 = this.m03;
        d.m10 = 1.0;
        d.m11 = 0.0;
        d.m12 = 0.0;
        d.m13 = this.m13;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = -1.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapYnXnZ}, specialized by runtime matrix
     * properties; reached only through the public {@code mapYnXnZ} dispatcher.
     */
    private Double3x4 mapYnXnZ_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = -1.0;
        d.m03 = this.m03;
        d.m10 = 1.0;
        d.m11 = 0.0;
        d.m13 = this.m13;
        d.m22 = -1.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapYnXnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYnXnZ} dispatcher.
     */
    private Double3x4 mapYnXnZ_general(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = this.m01;
        d.m01 = -this.m00;
        d.m02 = -this.m02;
        d.m03 = this.m03;
        double _buf1 = this.m11;
        d.m11 = -this.m10;
        d.m12 = -this.m12;
        d.m13 = this.m13;
        double _buf2 = this.m21;
        d.m21 = -this.m20;
        d.m22 = -this.m22;
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, -x, -z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapYnXnZ(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapYnXnZ_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapYnXnZ_translation(dest);
        return mapYnXnZ_general(dest);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, -x, -z)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapYnXnZ() {
        if (Joml.RETURN_NEW) return mapYnXnZ(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapYnXnZ_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapYnXnZ_translation_self(this);
        return mapYnXnZ_general(this);
    }


    /**
     * Private body of {@code mapYnZX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYnZX} dispatcher.
     */
    private Double3x4 mapYnZX_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 0.0;
        d.m02 = 1.0;
        d.m03 = 0.0;
        d.m10 = 1.0;
        d.m11 = 0.0;
        d.m12 = 0.0;
        d.m13 = 0.0;
        d.m20 = 0.0;
        d.m21 = -1.0;
        d.m22 = 0.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapYnZX}, specialized by runtime matrix properties;
     * reached only through the public {@code mapYnZX} dispatcher.
     */
    private Double3x4 mapYnZX_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m02 = 1.0;
        d.m10 = 1.0;
        d.m11 = 0.0;
        d.m21 = -1.0;
        d.m22 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapYnZX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYnZX} dispatcher.
     */
    private Double3x4 mapYnZX_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 0.0;
        d.m02 = 1.0;
        d.m03 = this.m03;
        d.m10 = 1.0;
        d.m11 = 0.0;
        d.m12 = 0.0;
        d.m13 = this.m13;
        d.m20 = 0.0;
        d.m21 = -1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapYnZX}, specialized by runtime matrix properties;
     * reached only through the public {@code mapYnZX} dispatcher.
     */
    private Double3x4 mapYnZX_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m02 = 1.0;
        d.m03 = this.m03;
        d.m10 = 1.0;
        d.m11 = 0.0;
        d.m13 = this.m13;
        d.m21 = -1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapYnZX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYnZX} dispatcher.
     */
    private Double3x4 mapYnZX_general(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = this.m01;
        d.m01 = -this.m02;
        d.m02 = this.m00;
        d.m03 = this.m03;
        double _buf1 = this.m11;
        d.m11 = -this.m12;
        d.m12 = this.m10;
        d.m13 = this.m13;
        double _buf2 = this.m21;
        d.m21 = -this.m22;
        d.m22 = this.m20;
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, -z, +x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapYnZX(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapYnZX_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapYnZX_translation(dest);
        return mapYnZX_general(dest);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, -z, +x)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapYnZX() {
        if (Joml.RETURN_NEW) return mapYnZX(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapYnZX_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapYnZX_translation_self(this);
        return mapYnZX_general(this);
    }


    /**
     * Private body of {@code mapYnZnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYnZnX} dispatcher.
     */
    private Double3x4 mapYnZnX_orthogonal_general(@Mutated Double3x4 dest, int _props) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = this.m01;
        d.m01 = -this.m02;
        d.m02 = -this.m00;
        d.m03 = this.m03;
        double _buf1 = this.m11;
        d.m11 = -this.m12;
        d.m12 = -this.m10;
        d.m13 = this.m13;
        double _buf2 = this.m21;
        d.m21 = -this.m22;
        d.m22 = -this.m20;
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code mapYnZnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYnZnX} dispatcher.
     */
    private Double3x4 mapYnZnX_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 0.0;
        d.m02 = -1.0;
        d.m03 = 0.0;
        d.m10 = 1.0;
        d.m11 = 0.0;
        d.m12 = 0.0;
        d.m13 = 0.0;
        d.m20 = 0.0;
        d.m21 = -1.0;
        d.m22 = 0.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapYnZnX}, specialized by runtime matrix
     * properties; reached only through the public {@code mapYnZnX} dispatcher.
     */
    private Double3x4 mapYnZnX_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m02 = -1.0;
        d.m10 = 1.0;
        d.m11 = 0.0;
        d.m21 = -1.0;
        d.m22 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code mapYnZnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYnZnX} dispatcher.
     */
    private Double3x4 mapYnZnX_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 0.0;
        d.m02 = -1.0;
        d.m03 = this.m03;
        d.m10 = 1.0;
        d.m11 = 0.0;
        d.m12 = 0.0;
        d.m13 = this.m13;
        d.m20 = 0.0;
        d.m21 = -1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapYnZnX}, specialized by runtime matrix
     * properties; reached only through the public {@code mapYnZnX} dispatcher.
     */
    private Double3x4 mapYnZnX_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m02 = -1.0;
        d.m03 = this.m03;
        d.m10 = 1.0;
        d.m11 = 0.0;
        d.m13 = this.m13;
        d.m21 = -1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, -z, -x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapYnZnX(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapYnZnX_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapYnZnX_translation(dest);
        return mapYnZnX_orthogonal_general(dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, -z, -x)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapYnZnX() {
        if (Joml.RETURN_NEW) return mapYnZnX(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapYnZnX_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapYnZnX_translation_self(this);
        return mapYnZnX_orthogonal_general(this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapZXY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZXY} dispatcher.
     */
    private Double3x4 mapZXY_orthogonal_general(@Mutated Double3x4 dest, int _props) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = this.m02;
        double _buf1 = this.m00;
        d.m02 = this.m01;
        d.m03 = this.m03;
        double _buf2 = this.m12;
        double _buf3 = this.m10;
        d.m12 = this.m11;
        d.m13 = this.m13;
        double _buf4 = this.m22;
        double _buf5 = this.m20;
        d.m22 = this.m21;
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m10 = _buf2;
        d.m11 = _buf3;
        d.m20 = _buf4;
        d.m21 = _buf5;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code mapZXY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZXY} dispatcher.
     */
    private Double3x4 mapZXY_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 1.0;
        d.m02 = 0.0;
        d.m03 = 0.0;
        d.m10 = 0.0;
        d.m11 = 0.0;
        d.m12 = 1.0;
        d.m13 = 0.0;
        d.m20 = 1.0;
        d.m21 = 0.0;
        d.m22 = 0.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapZXY}, specialized by runtime matrix properties;
     * reached only through the public {@code mapZXY} dispatcher.
     */
    private Double3x4 mapZXY_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 1.0;
        d.m11 = 0.0;
        d.m12 = 1.0;
        d.m20 = 1.0;
        d.m22 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code mapZXY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZXY} dispatcher.
     */
    private Double3x4 mapZXY_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 1.0;
        d.m02 = 0.0;
        d.m03 = this.m03;
        d.m10 = 0.0;
        d.m11 = 0.0;
        d.m12 = 1.0;
        d.m13 = this.m13;
        d.m20 = 1.0;
        d.m21 = 0.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapZXY}, specialized by runtime matrix properties;
     * reached only through the public {@code mapZXY} dispatcher.
     */
    private Double3x4 mapZXY_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 1.0;
        d.m03 = this.m03;
        d.m11 = 0.0;
        d.m12 = 1.0;
        d.m13 = this.m13;
        d.m20 = 1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, +x, +y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapZXY(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapZXY_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapZXY_translation(dest);
        return mapZXY_orthogonal_general(dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, +x, +y)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapZXY() {
        if (Joml.RETURN_NEW) return mapZXY(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapZXY_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapZXY_translation_self(this);
        return mapZXY_orthogonal_general(this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapZXnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZXnY} dispatcher.
     */
    private Double3x4 mapZXnY_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 1.0;
        d.m02 = 0.0;
        d.m03 = 0.0;
        d.m10 = 0.0;
        d.m11 = 0.0;
        d.m12 = -1.0;
        d.m13 = 0.0;
        d.m20 = 1.0;
        d.m21 = 0.0;
        d.m22 = 0.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapZXnY}, specialized by runtime matrix properties;
     * reached only through the public {@code mapZXnY} dispatcher.
     */
    private Double3x4 mapZXnY_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 1.0;
        d.m11 = 0.0;
        d.m12 = -1.0;
        d.m20 = 1.0;
        d.m22 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapZXnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZXnY} dispatcher.
     */
    private Double3x4 mapZXnY_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 1.0;
        d.m02 = 0.0;
        d.m03 = this.m03;
        d.m10 = 0.0;
        d.m11 = 0.0;
        d.m12 = -1.0;
        d.m13 = this.m13;
        d.m20 = 1.0;
        d.m21 = 0.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapZXnY}, specialized by runtime matrix properties;
     * reached only through the public {@code mapZXnY} dispatcher.
     */
    private Double3x4 mapZXnY_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 1.0;
        d.m03 = this.m03;
        d.m11 = 0.0;
        d.m12 = -1.0;
        d.m13 = this.m13;
        d.m20 = 1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapZXnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZXnY} dispatcher.
     */
    private Double3x4 mapZXnY_general(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = this.m02;
        double _buf1 = this.m00;
        d.m02 = -this.m01;
        d.m03 = this.m03;
        double _buf2 = this.m12;
        double _buf3 = this.m10;
        d.m12 = -this.m11;
        d.m13 = this.m13;
        double _buf4 = this.m22;
        double _buf5 = this.m20;
        d.m22 = -this.m21;
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m10 = _buf2;
        d.m11 = _buf3;
        d.m20 = _buf4;
        d.m21 = _buf5;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, +x, -y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapZXnY(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapZXnY_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapZXnY_translation(dest);
        return mapZXnY_general(dest);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, +x, -y)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapZXnY() {
        if (Joml.RETURN_NEW) return mapZXnY(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapZXnY_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapZXnY_translation_self(this);
        return mapZXnY_general(this);
    }


    /**
     * Private body of {@code mapZYX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZYX} dispatcher.
     */
    private Double3x4 mapZYX_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 0.0;
        d.m02 = 1.0;
        d.m03 = 0.0;
        d.m10 = 0.0;
        d.m11 = 1.0;
        d.m12 = 0.0;
        d.m13 = 0.0;
        d.m20 = 1.0;
        d.m21 = 0.0;
        d.m22 = 0.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapZYX}, specialized by runtime matrix properties;
     * reached only through the public {@code mapZYX} dispatcher.
     */
    private Double3x4 mapZYX_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m02 = 1.0;
        d.m20 = 1.0;
        d.m22 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapZYX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZYX} dispatcher.
     */
    private Double3x4 mapZYX_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 0.0;
        d.m02 = 1.0;
        d.m03 = this.m03;
        d.m10 = 0.0;
        d.m11 = 1.0;
        d.m12 = 0.0;
        d.m13 = this.m13;
        d.m20 = 1.0;
        d.m21 = 0.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapZYX}, specialized by runtime matrix properties;
     * reached only through the public {@code mapZYX} dispatcher.
     */
    private Double3x4 mapZYX_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m02 = 1.0;
        d.m03 = this.m03;
        d.m13 = this.m13;
        d.m20 = 1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapZYX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZYX} dispatcher.
     */
    private Double3x4 mapZYX_general(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = this.m02;
        d.m01 = this.m01;
        d.m02 = this.m00;
        d.m03 = this.m03;
        double _buf1 = this.m12;
        d.m11 = this.m11;
        d.m12 = this.m10;
        d.m13 = this.m13;
        double _buf2 = this.m22;
        d.m21 = this.m21;
        d.m22 = this.m20;
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, +y, +x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapZYX(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapZYX_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapZYX_translation(dest);
        return mapZYX_general(dest);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, +y, +x)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapZYX() {
        if (Joml.RETURN_NEW) return mapZYX(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapZYX_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapZYX_translation_self(this);
        return mapZYX_general(this);
    }


    /**
     * Private body of {@code mapZYnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZYnX} dispatcher.
     */
    private Double3x4 mapZYnX_orthogonal_general(@Mutated Double3x4 dest, int _props) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = this.m02;
        d.m01 = this.m01;
        d.m02 = -this.m00;
        d.m03 = this.m03;
        double _buf1 = this.m12;
        d.m11 = this.m11;
        d.m12 = -this.m10;
        d.m13 = this.m13;
        double _buf2 = this.m22;
        d.m21 = this.m21;
        d.m22 = -this.m20;
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code mapZYnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZYnX} dispatcher.
     */
    private Double3x4 mapZYnX_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 0.0;
        d.m02 = -1.0;
        d.m03 = 0.0;
        d.m10 = 0.0;
        d.m11 = 1.0;
        d.m12 = 0.0;
        d.m13 = 0.0;
        d.m20 = 1.0;
        d.m21 = 0.0;
        d.m22 = 0.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapZYnX}, specialized by runtime matrix properties;
     * reached only through the public {@code mapZYnX} dispatcher.
     */
    private Double3x4 mapZYnX_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m02 = -1.0;
        d.m20 = 1.0;
        d.m22 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code mapZYnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZYnX} dispatcher.
     */
    private Double3x4 mapZYnX_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 0.0;
        d.m02 = -1.0;
        d.m03 = this.m03;
        d.m10 = 0.0;
        d.m11 = 1.0;
        d.m12 = 0.0;
        d.m13 = this.m13;
        d.m20 = 1.0;
        d.m21 = 0.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapZYnX}, specialized by runtime matrix properties;
     * reached only through the public {@code mapZYnX} dispatcher.
     */
    private Double3x4 mapZYnX_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m02 = -1.0;
        d.m03 = this.m03;
        d.m13 = this.m13;
        d.m20 = 1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, +y, -x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapZYnX(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapZYnX_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapZYnX_translation(dest);
        return mapZYnX_orthogonal_general(dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, +y, -x)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapZYnX() {
        if (Joml.RETURN_NEW) return mapZYnX(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapZYnX_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapZYnX_translation_self(this);
        return mapZYnX_orthogonal_general(this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapZnXY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZnXY} dispatcher.
     */
    private Double3x4 mapZnXY_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = -1.0;
        d.m02 = 0.0;
        d.m03 = 0.0;
        d.m10 = 0.0;
        d.m11 = 0.0;
        d.m12 = 1.0;
        d.m13 = 0.0;
        d.m20 = 1.0;
        d.m21 = 0.0;
        d.m22 = 0.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapZnXY}, specialized by runtime matrix properties;
     * reached only through the public {@code mapZnXY} dispatcher.
     */
    private Double3x4 mapZnXY_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = -1.0;
        d.m11 = 0.0;
        d.m12 = 1.0;
        d.m20 = 1.0;
        d.m22 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapZnXY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZnXY} dispatcher.
     */
    private Double3x4 mapZnXY_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = -1.0;
        d.m02 = 0.0;
        d.m03 = this.m03;
        d.m10 = 0.0;
        d.m11 = 0.0;
        d.m12 = 1.0;
        d.m13 = this.m13;
        d.m20 = 1.0;
        d.m21 = 0.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapZnXY}, specialized by runtime matrix properties;
     * reached only through the public {@code mapZnXY} dispatcher.
     */
    private Double3x4 mapZnXY_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = -1.0;
        d.m03 = this.m03;
        d.m11 = 0.0;
        d.m12 = 1.0;
        d.m13 = this.m13;
        d.m20 = 1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapZnXY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZnXY} dispatcher.
     */
    private Double3x4 mapZnXY_general(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = this.m02;
        double _buf1 = -this.m00;
        d.m02 = this.m01;
        d.m03 = this.m03;
        double _buf2 = this.m12;
        double _buf3 = -this.m10;
        d.m12 = this.m11;
        d.m13 = this.m13;
        double _buf4 = this.m22;
        double _buf5 = -this.m20;
        d.m22 = this.m21;
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m10 = _buf2;
        d.m11 = _buf3;
        d.m20 = _buf4;
        d.m21 = _buf5;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, -x, +y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapZnXY(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapZnXY_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapZnXY_translation(dest);
        return mapZnXY_general(dest);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, -x, +y)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapZnXY() {
        if (Joml.RETURN_NEW) return mapZnXY(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapZnXY_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapZnXY_translation_self(this);
        return mapZnXY_general(this);
    }


    /**
     * Private body of {@code mapZnXnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZnXnY} dispatcher.
     */
    private Double3x4 mapZnXnY_orthogonal_general(@Mutated Double3x4 dest, int _props) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = this.m02;
        double _buf1 = -this.m00;
        d.m02 = -this.m01;
        d.m03 = this.m03;
        double _buf2 = this.m12;
        double _buf3 = -this.m10;
        d.m12 = -this.m11;
        d.m13 = this.m13;
        double _buf4 = this.m22;
        double _buf5 = -this.m20;
        d.m22 = -this.m21;
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m10 = _buf2;
        d.m11 = _buf3;
        d.m20 = _buf4;
        d.m21 = _buf5;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code mapZnXnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZnXnY} dispatcher.
     */
    private Double3x4 mapZnXnY_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = -1.0;
        d.m02 = 0.0;
        d.m03 = 0.0;
        d.m10 = 0.0;
        d.m11 = 0.0;
        d.m12 = -1.0;
        d.m13 = 0.0;
        d.m20 = 1.0;
        d.m21 = 0.0;
        d.m22 = 0.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapZnXnY}, specialized by runtime matrix
     * properties; reached only through the public {@code mapZnXnY} dispatcher.
     */
    private Double3x4 mapZnXnY_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = -1.0;
        d.m11 = 0.0;
        d.m12 = -1.0;
        d.m20 = 1.0;
        d.m22 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code mapZnXnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZnXnY} dispatcher.
     */
    private Double3x4 mapZnXnY_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = -1.0;
        d.m02 = 0.0;
        d.m03 = this.m03;
        d.m10 = 0.0;
        d.m11 = 0.0;
        d.m12 = -1.0;
        d.m13 = this.m13;
        d.m20 = 1.0;
        d.m21 = 0.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapZnXnY}, specialized by runtime matrix
     * properties; reached only through the public {@code mapZnXnY} dispatcher.
     */
    private Double3x4 mapZnXnY_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = -1.0;
        d.m03 = this.m03;
        d.m11 = 0.0;
        d.m12 = -1.0;
        d.m13 = this.m13;
        d.m20 = 1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, -x, -y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapZnXnY(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapZnXnY_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapZnXnY_translation(dest);
        return mapZnXnY_orthogonal_general(dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, -x, -y)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapZnXnY() {
        if (Joml.RETURN_NEW) return mapZnXnY(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapZnXnY_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapZnXnY_translation_self(this);
        return mapZnXnY_orthogonal_general(this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapZnYX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZnYX} dispatcher.
     */
    private Double3x4 mapZnYX_orthogonal_general(@Mutated Double3x4 dest, int _props) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = this.m02;
        d.m01 = -this.m01;
        d.m02 = this.m00;
        d.m03 = this.m03;
        double _buf1 = this.m12;
        d.m11 = -this.m11;
        d.m12 = this.m10;
        d.m13 = this.m13;
        double _buf2 = this.m22;
        d.m21 = -this.m21;
        d.m22 = this.m20;
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code mapZnYX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZnYX} dispatcher.
     */
    private Double3x4 mapZnYX_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 0.0;
        d.m02 = 1.0;
        d.m03 = 0.0;
        d.m10 = 0.0;
        d.m11 = -1.0;
        d.m12 = 0.0;
        d.m13 = 0.0;
        d.m20 = 1.0;
        d.m21 = 0.0;
        d.m22 = 0.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapZnYX}, specialized by runtime matrix properties;
     * reached only through the public {@code mapZnYX} dispatcher.
     */
    private Double3x4 mapZnYX_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m02 = 1.0;
        d.m11 = -1.0;
        d.m20 = 1.0;
        d.m22 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code mapZnYX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZnYX} dispatcher.
     */
    private Double3x4 mapZnYX_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 0.0;
        d.m02 = 1.0;
        d.m03 = this.m03;
        d.m10 = 0.0;
        d.m11 = -1.0;
        d.m12 = 0.0;
        d.m13 = this.m13;
        d.m20 = 1.0;
        d.m21 = 0.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapZnYX}, specialized by runtime matrix properties;
     * reached only through the public {@code mapZnYX} dispatcher.
     */
    private Double3x4 mapZnYX_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m02 = 1.0;
        d.m03 = this.m03;
        d.m11 = -1.0;
        d.m13 = this.m13;
        d.m20 = 1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, -y, +x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapZnYX(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapZnYX_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapZnYX_translation(dest);
        return mapZnYX_orthogonal_general(dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, -y, +x)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapZnYX() {
        if (Joml.RETURN_NEW) return mapZnYX(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapZnYX_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapZnYX_translation_self(this);
        return mapZnYX_orthogonal_general(this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapZnYnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZnYnX} dispatcher.
     */
    private Double3x4 mapZnYnX_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 0.0;
        d.m02 = -1.0;
        d.m03 = 0.0;
        d.m10 = 0.0;
        d.m11 = -1.0;
        d.m12 = 0.0;
        d.m13 = 0.0;
        d.m20 = 1.0;
        d.m21 = 0.0;
        d.m22 = 0.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapZnYnX}, specialized by runtime matrix
     * properties; reached only through the public {@code mapZnYnX} dispatcher.
     */
    private Double3x4 mapZnYnX_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m02 = -1.0;
        d.m11 = -1.0;
        d.m20 = 1.0;
        d.m22 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapZnYnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZnYnX} dispatcher.
     */
    private Double3x4 mapZnYnX_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 0.0;
        d.m02 = -1.0;
        d.m03 = this.m03;
        d.m10 = 0.0;
        d.m11 = -1.0;
        d.m12 = 0.0;
        d.m13 = this.m13;
        d.m20 = 1.0;
        d.m21 = 0.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapZnYnX}, specialized by runtime matrix
     * properties; reached only through the public {@code mapZnYnX} dispatcher.
     */
    private Double3x4 mapZnYnX_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m02 = -1.0;
        d.m03 = this.m03;
        d.m11 = -1.0;
        d.m13 = this.m13;
        d.m20 = 1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapZnYnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZnYnX} dispatcher.
     */
    private Double3x4 mapZnYnX_general(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = this.m02;
        d.m01 = -this.m01;
        d.m02 = -this.m00;
        d.m03 = this.m03;
        double _buf1 = this.m12;
        d.m11 = -this.m11;
        d.m12 = -this.m10;
        d.m13 = this.m13;
        double _buf2 = this.m22;
        d.m21 = -this.m21;
        d.m22 = -this.m20;
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, -y, -x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapZnYnX(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapZnYnX_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapZnYnX_translation(dest);
        return mapZnYnX_general(dest);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, -y, -x)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapZnYnX() {
        if (Joml.RETURN_NEW) return mapZnYnX(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapZnYnX_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapZnYnX_translation_self(this);
        return mapZnYnX_general(this);
    }


    /**
     * Private body of {@code mapnXYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXYZ} dispatcher.
     */
    private Double3x4 mapnXYZ_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = 0.0;
        d.m10 = 0.0;
        d.m11 = 1.0;
        d.m12 = 0.0;
        d.m13 = 0.0;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 1.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnXYZ}, specialized by runtime matrix properties;
     * reached only through the public {@code mapnXYZ} dispatcher.
     */
    private Double3x4 mapnXYZ_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -1.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapnXYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXYZ} dispatcher.
     */
    private Double3x4 mapnXYZ_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = this.m03;
        d.m10 = 0.0;
        d.m11 = 1.0;
        d.m12 = 0.0;
        d.m13 = this.m13;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 1.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnXYZ}, specialized by runtime matrix properties;
     * reached only through the public {@code mapnXYZ} dispatcher.
     */
    private Double3x4 mapnXYZ_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -1.0;
        d.m03 = this.m03;
        d.m13 = this.m13;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapnXYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXYZ} dispatcher.
     */
    private Double3x4 mapnXYZ_general(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -this.m00;
        d.m01 = this.m01;
        d.m02 = this.m02;
        d.m03 = this.m03;
        d.m10 = -this.m10;
        d.m11 = this.m11;
        d.m12 = this.m12;
        d.m13 = this.m13;
        d.m20 = -this.m20;
        d.m21 = this.m21;
        d.m22 = this.m22;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, +y, +z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapnXYZ(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnXYZ_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnXYZ_translation(dest);
        return mapnXYZ_general(dest);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, +y, +z)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapnXYZ() {
        if (Joml.RETURN_NEW) return mapnXYZ(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnXYZ_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnXYZ_translation_self(this);
        return mapnXYZ_general(this);
    }


    /**
     * Private body of {@code mapnXYnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXYnZ} dispatcher.
     */
    private Double3x4 mapnXYnZ_orthogonal_general(@Mutated Double3x4 dest, int _props) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -this.m00;
        d.m01 = this.m01;
        d.m02 = -this.m02;
        d.m03 = this.m03;
        d.m10 = -this.m10;
        d.m11 = this.m11;
        d.m12 = -this.m12;
        d.m13 = this.m13;
        d.m20 = -this.m20;
        d.m21 = this.m21;
        d.m22 = -this.m22;
        d.m23 = this.m23;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code mapnXYnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXYnZ} dispatcher.
     */
    private Double3x4 mapnXYnZ_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = 0.0;
        d.m10 = 0.0;
        d.m11 = 1.0;
        d.m12 = 0.0;
        d.m13 = 0.0;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = -1.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnXYnZ}, specialized by runtime matrix
     * properties; reached only through the public {@code mapnXYnZ} dispatcher.
     */
    private Double3x4 mapnXYnZ_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -1.0;
        d.m22 = -1.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code mapnXYnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXYnZ} dispatcher.
     */
    private Double3x4 mapnXYnZ_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = this.m03;
        d.m10 = 0.0;
        d.m11 = 1.0;
        d.m12 = 0.0;
        d.m13 = this.m13;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = -1.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnXYnZ}, specialized by runtime matrix
     * properties; reached only through the public {@code mapnXYnZ} dispatcher.
     */
    private Double3x4 mapnXYnZ_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -1.0;
        d.m03 = this.m03;
        d.m13 = this.m13;
        d.m22 = -1.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, +y, -z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapnXYnZ(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnXYnZ_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnXYnZ_translation(dest);
        return mapnXYnZ_orthogonal_general(dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, +y, -z)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapnXYnZ() {
        if (Joml.RETURN_NEW) return mapnXYnZ(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnXYnZ_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnXYnZ_translation_self(this);
        return mapnXYnZ_orthogonal_general(this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapnXZY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXZY} dispatcher.
     */
    private Double3x4 mapnXZY_orthogonal_general(@Mutated Double3x4 dest, int _props) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -this.m00;
        double _buf0 = this.m02;
        d.m02 = this.m01;
        d.m03 = this.m03;
        d.m10 = -this.m10;
        double _buf1 = this.m12;
        d.m12 = this.m11;
        d.m13 = this.m13;
        d.m20 = -this.m20;
        double _buf2 = this.m22;
        d.m22 = this.m21;
        d.m23 = this.m23;
        d.m01 = _buf0;
        d.m11 = _buf1;
        d.m21 = _buf2;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code mapnXZY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXZY} dispatcher.
     */
    private Double3x4 mapnXZY_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = 0.0;
        d.m10 = 0.0;
        d.m11 = 0.0;
        d.m12 = 1.0;
        d.m13 = 0.0;
        d.m20 = 0.0;
        d.m21 = 1.0;
        d.m22 = 0.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnXZY}, specialized by runtime matrix properties;
     * reached only through the public {@code mapnXZY} dispatcher.
     */
    private Double3x4 mapnXZY_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -1.0;
        d.m11 = 0.0;
        d.m12 = 1.0;
        d.m21 = 1.0;
        d.m22 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code mapnXZY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXZY} dispatcher.
     */
    private Double3x4 mapnXZY_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = this.m03;
        d.m10 = 0.0;
        d.m11 = 0.0;
        d.m12 = 1.0;
        d.m13 = this.m13;
        d.m20 = 0.0;
        d.m21 = 1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnXZY}, specialized by runtime matrix properties;
     * reached only through the public {@code mapnXZY} dispatcher.
     */
    private Double3x4 mapnXZY_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -1.0;
        d.m03 = this.m03;
        d.m11 = 0.0;
        d.m12 = 1.0;
        d.m13 = this.m13;
        d.m21 = 1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, +z, +y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapnXZY(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnXZY_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnXZY_translation(dest);
        return mapnXZY_orthogonal_general(dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, +z, +y)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapnXZY() {
        if (Joml.RETURN_NEW) return mapnXZY(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnXZY_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnXZY_translation_self(this);
        return mapnXZY_orthogonal_general(this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapnXZnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXZnY} dispatcher.
     */
    private Double3x4 mapnXZnY_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = 0.0;
        d.m10 = 0.0;
        d.m11 = 0.0;
        d.m12 = -1.0;
        d.m13 = 0.0;
        d.m20 = 0.0;
        d.m21 = 1.0;
        d.m22 = 0.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnXZnY}, specialized by runtime matrix
     * properties; reached only through the public {@code mapnXZnY} dispatcher.
     */
    private Double3x4 mapnXZnY_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -1.0;
        d.m11 = 0.0;
        d.m12 = -1.0;
        d.m21 = 1.0;
        d.m22 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapnXZnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXZnY} dispatcher.
     */
    private Double3x4 mapnXZnY_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = this.m03;
        d.m10 = 0.0;
        d.m11 = 0.0;
        d.m12 = -1.0;
        d.m13 = this.m13;
        d.m20 = 0.0;
        d.m21 = 1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnXZnY}, specialized by runtime matrix
     * properties; reached only through the public {@code mapnXZnY} dispatcher.
     */
    private Double3x4 mapnXZnY_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -1.0;
        d.m03 = this.m03;
        d.m11 = 0.0;
        d.m12 = -1.0;
        d.m13 = this.m13;
        d.m21 = 1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapnXZnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXZnY} dispatcher.
     */
    private Double3x4 mapnXZnY_general(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -this.m00;
        double _buf0 = this.m02;
        d.m02 = -this.m01;
        d.m03 = this.m03;
        d.m10 = -this.m10;
        double _buf1 = this.m12;
        d.m12 = -this.m11;
        d.m13 = this.m13;
        d.m20 = -this.m20;
        double _buf2 = this.m22;
        d.m22 = -this.m21;
        d.m23 = this.m23;
        d.m01 = _buf0;
        d.m11 = _buf1;
        d.m21 = _buf2;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, +z, -y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapnXZnY(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnXZnY_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnXZnY_translation(dest);
        return mapnXZnY_general(dest);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, +z, -y)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapnXZnY() {
        if (Joml.RETURN_NEW) return mapnXZnY(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnXZnY_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnXZnY_translation_self(this);
        return mapnXZnY_general(this);
    }


    /**
     * Private body of {@code mapnXnYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXnYZ} dispatcher.
     */
    private Double3x4 mapnXnYZ_orthogonal_general(@Mutated Double3x4 dest, int _props) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -this.m00;
        d.m01 = -this.m01;
        d.m02 = this.m02;
        d.m03 = this.m03;
        d.m10 = -this.m10;
        d.m11 = -this.m11;
        d.m12 = this.m12;
        d.m13 = this.m13;
        d.m20 = -this.m20;
        d.m21 = -this.m21;
        d.m22 = this.m22;
        d.m23 = this.m23;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code mapnXnYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXnYZ} dispatcher.
     */
    private Double3x4 mapnXnYZ_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = 0.0;
        d.m10 = 0.0;
        d.m11 = -1.0;
        d.m12 = 0.0;
        d.m13 = 0.0;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 1.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnXnYZ}, specialized by runtime matrix
     * properties; reached only through the public {@code mapnXnYZ} dispatcher.
     */
    private Double3x4 mapnXnYZ_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -1.0;
        d.m11 = -1.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code mapnXnYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXnYZ} dispatcher.
     */
    private Double3x4 mapnXnYZ_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = this.m03;
        d.m10 = 0.0;
        d.m11 = -1.0;
        d.m12 = 0.0;
        d.m13 = this.m13;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 1.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnXnYZ}, specialized by runtime matrix
     * properties; reached only through the public {@code mapnXnYZ} dispatcher.
     */
    private Double3x4 mapnXnYZ_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -1.0;
        d.m03 = this.m03;
        d.m11 = -1.0;
        d.m13 = this.m13;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, -y, +z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapnXnYZ(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnXnYZ_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnXnYZ_translation(dest);
        return mapnXnYZ_orthogonal_general(dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, -y, +z)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapnXnYZ() {
        if (Joml.RETURN_NEW) return mapnXnYZ(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnXnYZ_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnXnYZ_translation_self(this);
        return mapnXnYZ_orthogonal_general(this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapnXnYnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXnYnZ} dispatcher.
     */
    private Double3x4 mapnXnYnZ_identity(@Mutated Double3x4 dest) {
        return negate_identity(dest);
    }


    /**
     * Private in-place self-form body of {@code mapnXnYnZ}, specialized by runtime matrix
     * properties; reached only through the public {@code mapnXnYnZ} dispatcher.
     */
    private Double3x4 mapnXnYnZ_identity_self(@Mutated Double3x4 dest) {
        return negate_identity_self(dest);
    }


    /**
     * Private body of {@code mapnXnYnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXnYnZ} dispatcher.
     */
    private Double3x4 mapnXnYnZ_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = this.m03;
        d.m10 = 0.0;
        d.m11 = -1.0;
        d.m12 = 0.0;
        d.m13 = this.m13;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = -1.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnXnYnZ}, specialized by runtime matrix
     * properties; reached only through the public {@code mapnXnYnZ} dispatcher.
     */
    private Double3x4 mapnXnYnZ_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -1.0;
        d.m03 = this.m03;
        d.m11 = -1.0;
        d.m13 = this.m13;
        d.m22 = -1.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapnXnYnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXnYnZ} dispatcher.
     */
    private Double3x4 mapnXnYnZ_general(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -this.m00;
        d.m01 = -this.m01;
        d.m02 = -this.m02;
        d.m03 = this.m03;
        d.m10 = -this.m10;
        d.m11 = -this.m11;
        d.m12 = -this.m12;
        d.m13 = this.m13;
        d.m20 = -this.m20;
        d.m21 = -this.m21;
        d.m22 = -this.m22;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, -y, -z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapnXnYnZ(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnXnYnZ_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnXnYnZ_translation(dest);
        return mapnXnYnZ_general(dest);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, -y, -z)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapnXnYnZ() {
        if (Joml.RETURN_NEW) return mapnXnYnZ(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnXnYnZ_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnXnYnZ_translation_self(this);
        return mapnXnYnZ_general(this);
    }


    /**
     * Private body of {@code mapnXnZY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXnZY} dispatcher.
     */
    private Double3x4 mapnXnZY_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = 0.0;
        d.m10 = 0.0;
        d.m11 = 0.0;
        d.m12 = 1.0;
        d.m13 = 0.0;
        d.m20 = 0.0;
        d.m21 = -1.0;
        d.m22 = 0.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnXnZY}, specialized by runtime matrix
     * properties; reached only through the public {@code mapnXnZY} dispatcher.
     */
    private Double3x4 mapnXnZY_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -1.0;
        d.m11 = 0.0;
        d.m12 = 1.0;
        d.m21 = -1.0;
        d.m22 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapnXnZY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXnZY} dispatcher.
     */
    private Double3x4 mapnXnZY_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = this.m03;
        d.m10 = 0.0;
        d.m11 = 0.0;
        d.m12 = 1.0;
        d.m13 = this.m13;
        d.m20 = 0.0;
        d.m21 = -1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnXnZY}, specialized by runtime matrix
     * properties; reached only through the public {@code mapnXnZY} dispatcher.
     */
    private Double3x4 mapnXnZY_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -1.0;
        d.m03 = this.m03;
        d.m11 = 0.0;
        d.m12 = 1.0;
        d.m13 = this.m13;
        d.m21 = -1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapnXnZY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXnZY} dispatcher.
     */
    private Double3x4 mapnXnZY_general(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -this.m00;
        double _buf0 = -this.m02;
        d.m02 = this.m01;
        d.m03 = this.m03;
        d.m10 = -this.m10;
        double _buf1 = -this.m12;
        d.m12 = this.m11;
        d.m13 = this.m13;
        d.m20 = -this.m20;
        double _buf2 = -this.m22;
        d.m22 = this.m21;
        d.m23 = this.m23;
        d.m01 = _buf0;
        d.m11 = _buf1;
        d.m21 = _buf2;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, -z, +y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapnXnZY(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnXnZY_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnXnZY_translation(dest);
        return mapnXnZY_general(dest);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, -z, +y)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapnXnZY() {
        if (Joml.RETURN_NEW) return mapnXnZY(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnXnZY_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnXnZY_translation_self(this);
        return mapnXnZY_general(this);
    }


    /**
     * Private body of {@code mapnXnZnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXnZnY} dispatcher.
     */
    private Double3x4 mapnXnZnY_orthogonal_general(@Mutated Double3x4 dest, int _props) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -this.m00;
        double _buf0 = -this.m02;
        d.m02 = -this.m01;
        d.m03 = this.m03;
        d.m10 = -this.m10;
        double _buf1 = -this.m12;
        d.m12 = -this.m11;
        d.m13 = this.m13;
        d.m20 = -this.m20;
        double _buf2 = -this.m22;
        d.m22 = -this.m21;
        d.m23 = this.m23;
        d.m01 = _buf0;
        d.m11 = _buf1;
        d.m21 = _buf2;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code mapnXnZnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXnZnY} dispatcher.
     */
    private Double3x4 mapnXnZnY_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = 0.0;
        d.m10 = 0.0;
        d.m11 = 0.0;
        d.m12 = -1.0;
        d.m13 = 0.0;
        d.m20 = 0.0;
        d.m21 = -1.0;
        d.m22 = 0.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnXnZnY}, specialized by runtime matrix
     * properties; reached only through the public {@code mapnXnZnY} dispatcher.
     */
    private Double3x4 mapnXnZnY_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -1.0;
        d.m11 = 0.0;
        d.m12 = -1.0;
        d.m21 = -1.0;
        d.m22 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code mapnXnZnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXnZnY} dispatcher.
     */
    private Double3x4 mapnXnZnY_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = this.m03;
        d.m10 = 0.0;
        d.m11 = 0.0;
        d.m12 = -1.0;
        d.m13 = this.m13;
        d.m20 = 0.0;
        d.m21 = -1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnXnZnY}, specialized by runtime matrix
     * properties; reached only through the public {@code mapnXnZnY} dispatcher.
     */
    private Double3x4 mapnXnZnY_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = -1.0;
        d.m03 = this.m03;
        d.m11 = 0.0;
        d.m12 = -1.0;
        d.m13 = this.m13;
        d.m21 = -1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, -z, -y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapnXnZnY(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnXnZnY_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnXnZnY_translation(dest);
        return mapnXnZnY_orthogonal_general(dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, -z, -y)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapnXnZnY() {
        if (Joml.RETURN_NEW) return mapnXnZnY(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnXnZnY_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnXnZnY_translation_self(this);
        return mapnXnZnY_orthogonal_general(this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapnYXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYXZ} dispatcher.
     */
    private Double3x4 mapnYXZ_orthogonal_general(@Mutated Double3x4 dest, int _props) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = -this.m01;
        d.m01 = this.m00;
        d.m02 = this.m02;
        d.m03 = this.m03;
        double _buf1 = -this.m11;
        d.m11 = this.m10;
        d.m12 = this.m12;
        d.m13 = this.m13;
        double _buf2 = -this.m21;
        d.m21 = this.m20;
        d.m22 = this.m22;
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code mapnYXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYXZ} dispatcher.
     */
    private Double3x4 mapnYXZ_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 1.0;
        d.m02 = 0.0;
        d.m03 = 0.0;
        d.m10 = -1.0;
        d.m11 = 0.0;
        d.m12 = 0.0;
        d.m13 = 0.0;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 1.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnYXZ}, specialized by runtime matrix properties;
     * reached only through the public {@code mapnYXZ} dispatcher.
     */
    private Double3x4 mapnYXZ_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 1.0;
        d.m10 = -1.0;
        d.m11 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code mapnYXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYXZ} dispatcher.
     */
    private Double3x4 mapnYXZ_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 1.0;
        d.m02 = 0.0;
        d.m03 = this.m03;
        d.m10 = -1.0;
        d.m11 = 0.0;
        d.m12 = 0.0;
        d.m13 = this.m13;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 1.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnYXZ}, specialized by runtime matrix properties;
     * reached only through the public {@code mapnYXZ} dispatcher.
     */
    private Double3x4 mapnYXZ_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 1.0;
        d.m03 = this.m03;
        d.m10 = -1.0;
        d.m11 = 0.0;
        d.m13 = this.m13;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, +x, +z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapnYXZ(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnYXZ_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnYXZ_translation(dest);
        return mapnYXZ_orthogonal_general(dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, +x, +z)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapnYXZ() {
        if (Joml.RETURN_NEW) return mapnYXZ(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnYXZ_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnYXZ_translation_self(this);
        return mapnYXZ_orthogonal_general(this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapnYXnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYXnZ} dispatcher.
     */
    private Double3x4 mapnYXnZ_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 1.0;
        d.m02 = 0.0;
        d.m03 = 0.0;
        d.m10 = -1.0;
        d.m11 = 0.0;
        d.m12 = 0.0;
        d.m13 = 0.0;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = -1.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnYXnZ}, specialized by runtime matrix
     * properties; reached only through the public {@code mapnYXnZ} dispatcher.
     */
    private Double3x4 mapnYXnZ_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 1.0;
        d.m10 = -1.0;
        d.m11 = 0.0;
        d.m22 = -1.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapnYXnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYXnZ} dispatcher.
     */
    private Double3x4 mapnYXnZ_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 1.0;
        d.m02 = 0.0;
        d.m03 = this.m03;
        d.m10 = -1.0;
        d.m11 = 0.0;
        d.m12 = 0.0;
        d.m13 = this.m13;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = -1.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnYXnZ}, specialized by runtime matrix
     * properties; reached only through the public {@code mapnYXnZ} dispatcher.
     */
    private Double3x4 mapnYXnZ_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 1.0;
        d.m03 = this.m03;
        d.m10 = -1.0;
        d.m11 = 0.0;
        d.m13 = this.m13;
        d.m22 = -1.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapnYXnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYXnZ} dispatcher.
     */
    private Double3x4 mapnYXnZ_general(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = -this.m01;
        d.m01 = this.m00;
        d.m02 = -this.m02;
        d.m03 = this.m03;
        double _buf1 = -this.m11;
        d.m11 = this.m10;
        d.m12 = -this.m12;
        d.m13 = this.m13;
        double _buf2 = -this.m21;
        d.m21 = this.m20;
        d.m22 = -this.m22;
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, +x, -z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapnYXnZ(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnYXnZ_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnYXnZ_translation(dest);
        return mapnYXnZ_general(dest);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, +x, -z)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapnYXnZ() {
        if (Joml.RETURN_NEW) return mapnYXnZ(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnYXnZ_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnYXnZ_translation_self(this);
        return mapnYXnZ_general(this);
    }


    /**
     * Private body of {@code mapnYZX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYZX} dispatcher.
     */
    private Double3x4 mapnYZX_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 0.0;
        d.m02 = 1.0;
        d.m03 = 0.0;
        d.m10 = -1.0;
        d.m11 = 0.0;
        d.m12 = 0.0;
        d.m13 = 0.0;
        d.m20 = 0.0;
        d.m21 = 1.0;
        d.m22 = 0.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnYZX}, specialized by runtime matrix properties;
     * reached only through the public {@code mapnYZX} dispatcher.
     */
    private Double3x4 mapnYZX_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m02 = 1.0;
        d.m10 = -1.0;
        d.m11 = 0.0;
        d.m21 = 1.0;
        d.m22 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapnYZX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYZX} dispatcher.
     */
    private Double3x4 mapnYZX_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 0.0;
        d.m02 = 1.0;
        d.m03 = this.m03;
        d.m10 = -1.0;
        d.m11 = 0.0;
        d.m12 = 0.0;
        d.m13 = this.m13;
        d.m20 = 0.0;
        d.m21 = 1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnYZX}, specialized by runtime matrix properties;
     * reached only through the public {@code mapnYZX} dispatcher.
     */
    private Double3x4 mapnYZX_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m02 = 1.0;
        d.m03 = this.m03;
        d.m10 = -1.0;
        d.m11 = 0.0;
        d.m13 = this.m13;
        d.m21 = 1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapnYZX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYZX} dispatcher.
     */
    private Double3x4 mapnYZX_general(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = -this.m01;
        d.m01 = this.m02;
        d.m02 = this.m00;
        d.m03 = this.m03;
        double _buf1 = -this.m11;
        d.m11 = this.m12;
        d.m12 = this.m10;
        d.m13 = this.m13;
        double _buf2 = -this.m21;
        d.m21 = this.m22;
        d.m22 = this.m20;
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, +z, +x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapnYZX(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnYZX_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnYZX_translation(dest);
        return mapnYZX_general(dest);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, +z, +x)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapnYZX() {
        if (Joml.RETURN_NEW) return mapnYZX(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnYZX_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnYZX_translation_self(this);
        return mapnYZX_general(this);
    }


    /**
     * Private body of {@code mapnYZnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYZnX} dispatcher.
     */
    private Double3x4 mapnYZnX_orthogonal_general(@Mutated Double3x4 dest, int _props) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = -this.m01;
        d.m01 = this.m02;
        d.m02 = -this.m00;
        d.m03 = this.m03;
        double _buf1 = -this.m11;
        d.m11 = this.m12;
        d.m12 = -this.m10;
        d.m13 = this.m13;
        double _buf2 = -this.m21;
        d.m21 = this.m22;
        d.m22 = -this.m20;
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code mapnYZnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYZnX} dispatcher.
     */
    private Double3x4 mapnYZnX_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 0.0;
        d.m02 = -1.0;
        d.m03 = 0.0;
        d.m10 = -1.0;
        d.m11 = 0.0;
        d.m12 = 0.0;
        d.m13 = 0.0;
        d.m20 = 0.0;
        d.m21 = 1.0;
        d.m22 = 0.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnYZnX}, specialized by runtime matrix
     * properties; reached only through the public {@code mapnYZnX} dispatcher.
     */
    private Double3x4 mapnYZnX_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m02 = -1.0;
        d.m10 = -1.0;
        d.m11 = 0.0;
        d.m21 = 1.0;
        d.m22 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code mapnYZnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYZnX} dispatcher.
     */
    private Double3x4 mapnYZnX_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 0.0;
        d.m02 = -1.0;
        d.m03 = this.m03;
        d.m10 = -1.0;
        d.m11 = 0.0;
        d.m12 = 0.0;
        d.m13 = this.m13;
        d.m20 = 0.0;
        d.m21 = 1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnYZnX}, specialized by runtime matrix
     * properties; reached only through the public {@code mapnYZnX} dispatcher.
     */
    private Double3x4 mapnYZnX_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m02 = -1.0;
        d.m03 = this.m03;
        d.m10 = -1.0;
        d.m11 = 0.0;
        d.m13 = this.m13;
        d.m21 = 1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, +z, -x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapnYZnX(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnYZnX_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnYZnX_translation(dest);
        return mapnYZnX_orthogonal_general(dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, +z, -x)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapnYZnX() {
        if (Joml.RETURN_NEW) return mapnYZnX(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnYZnX_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnYZnX_translation_self(this);
        return mapnYZnX_orthogonal_general(this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapnYnXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYnXZ} dispatcher.
     */
    private Double3x4 mapnYnXZ_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = -1.0;
        d.m02 = 0.0;
        d.m03 = 0.0;
        d.m10 = -1.0;
        d.m11 = 0.0;
        d.m12 = 0.0;
        d.m13 = 0.0;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 1.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnYnXZ}, specialized by runtime matrix
     * properties; reached only through the public {@code mapnYnXZ} dispatcher.
     */
    private Double3x4 mapnYnXZ_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = -1.0;
        d.m10 = -1.0;
        d.m11 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapnYnXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYnXZ} dispatcher.
     */
    private Double3x4 mapnYnXZ_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = -1.0;
        d.m02 = 0.0;
        d.m03 = this.m03;
        d.m10 = -1.0;
        d.m11 = 0.0;
        d.m12 = 0.0;
        d.m13 = this.m13;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 1.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnYnXZ}, specialized by runtime matrix
     * properties; reached only through the public {@code mapnYnXZ} dispatcher.
     */
    private Double3x4 mapnYnXZ_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = -1.0;
        d.m03 = this.m03;
        d.m10 = -1.0;
        d.m11 = 0.0;
        d.m13 = this.m13;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapnYnXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYnXZ} dispatcher.
     */
    private Double3x4 mapnYnXZ_general(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = -this.m01;
        d.m01 = -this.m00;
        d.m02 = this.m02;
        d.m03 = this.m03;
        double _buf1 = -this.m11;
        d.m11 = -this.m10;
        d.m12 = this.m12;
        d.m13 = this.m13;
        double _buf2 = -this.m21;
        d.m21 = -this.m20;
        d.m22 = this.m22;
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, -x, +z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapnYnXZ(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnYnXZ_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnYnXZ_translation(dest);
        return mapnYnXZ_general(dest);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, -x, +z)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapnYnXZ() {
        if (Joml.RETURN_NEW) return mapnYnXZ(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnYnXZ_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnYnXZ_translation_self(this);
        return mapnYnXZ_general(this);
    }


    /**
     * Private body of {@code mapnYnXnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYnXnZ} dispatcher.
     */
    private Double3x4 mapnYnXnZ_orthogonal_general(@Mutated Double3x4 dest, int _props) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = -this.m01;
        d.m01 = -this.m00;
        d.m02 = -this.m02;
        d.m03 = this.m03;
        double _buf1 = -this.m11;
        d.m11 = -this.m10;
        d.m12 = -this.m12;
        d.m13 = this.m13;
        double _buf2 = -this.m21;
        d.m21 = -this.m20;
        d.m22 = -this.m22;
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code mapnYnXnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYnXnZ} dispatcher.
     */
    private Double3x4 mapnYnXnZ_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = -1.0;
        d.m02 = 0.0;
        d.m03 = 0.0;
        d.m10 = -1.0;
        d.m11 = 0.0;
        d.m12 = 0.0;
        d.m13 = 0.0;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = -1.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnYnXnZ}, specialized by runtime matrix
     * properties; reached only through the public {@code mapnYnXnZ} dispatcher.
     */
    private Double3x4 mapnYnXnZ_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = -1.0;
        d.m10 = -1.0;
        d.m11 = 0.0;
        d.m22 = -1.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code mapnYnXnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYnXnZ} dispatcher.
     */
    private Double3x4 mapnYnXnZ_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = -1.0;
        d.m02 = 0.0;
        d.m03 = this.m03;
        d.m10 = -1.0;
        d.m11 = 0.0;
        d.m12 = 0.0;
        d.m13 = this.m13;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = -1.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnYnXnZ}, specialized by runtime matrix
     * properties; reached only through the public {@code mapnYnXnZ} dispatcher.
     */
    private Double3x4 mapnYnXnZ_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = -1.0;
        d.m03 = this.m03;
        d.m10 = -1.0;
        d.m11 = 0.0;
        d.m13 = this.m13;
        d.m22 = -1.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, -x, -z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapnYnXnZ(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnYnXnZ_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnYnXnZ_translation(dest);
        return mapnYnXnZ_orthogonal_general(dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, -x, -z)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapnYnXnZ() {
        if (Joml.RETURN_NEW) return mapnYnXnZ(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnYnXnZ_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnYnXnZ_translation_self(this);
        return mapnYnXnZ_orthogonal_general(this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapnYnZX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYnZX} dispatcher.
     */
    private Double3x4 mapnYnZX_orthogonal_general(@Mutated Double3x4 dest, int _props) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = -this.m01;
        d.m01 = -this.m02;
        d.m02 = this.m00;
        d.m03 = this.m03;
        double _buf1 = -this.m11;
        d.m11 = -this.m12;
        d.m12 = this.m10;
        d.m13 = this.m13;
        double _buf2 = -this.m21;
        d.m21 = -this.m22;
        d.m22 = this.m20;
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code mapnYnZX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYnZX} dispatcher.
     */
    private Double3x4 mapnYnZX_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 0.0;
        d.m02 = 1.0;
        d.m03 = 0.0;
        d.m10 = -1.0;
        d.m11 = 0.0;
        d.m12 = 0.0;
        d.m13 = 0.0;
        d.m20 = 0.0;
        d.m21 = -1.0;
        d.m22 = 0.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnYnZX}, specialized by runtime matrix
     * properties; reached only through the public {@code mapnYnZX} dispatcher.
     */
    private Double3x4 mapnYnZX_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m02 = 1.0;
        d.m10 = -1.0;
        d.m11 = 0.0;
        d.m21 = -1.0;
        d.m22 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code mapnYnZX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYnZX} dispatcher.
     */
    private Double3x4 mapnYnZX_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 0.0;
        d.m02 = 1.0;
        d.m03 = this.m03;
        d.m10 = -1.0;
        d.m11 = 0.0;
        d.m12 = 0.0;
        d.m13 = this.m13;
        d.m20 = 0.0;
        d.m21 = -1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnYnZX}, specialized by runtime matrix
     * properties; reached only through the public {@code mapnYnZX} dispatcher.
     */
    private Double3x4 mapnYnZX_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m02 = 1.0;
        d.m03 = this.m03;
        d.m10 = -1.0;
        d.m11 = 0.0;
        d.m13 = this.m13;
        d.m21 = -1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, -z, +x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapnYnZX(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnYnZX_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnYnZX_translation(dest);
        return mapnYnZX_orthogonal_general(dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, -z, +x)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapnYnZX() {
        if (Joml.RETURN_NEW) return mapnYnZX(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnYnZX_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnYnZX_translation_self(this);
        return mapnYnZX_orthogonal_general(this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapnYnZnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYnZnX} dispatcher.
     */
    private Double3x4 mapnYnZnX_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 0.0;
        d.m02 = -1.0;
        d.m03 = 0.0;
        d.m10 = -1.0;
        d.m11 = 0.0;
        d.m12 = 0.0;
        d.m13 = 0.0;
        d.m20 = 0.0;
        d.m21 = -1.0;
        d.m22 = 0.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnYnZnX}, specialized by runtime matrix
     * properties; reached only through the public {@code mapnYnZnX} dispatcher.
     */
    private Double3x4 mapnYnZnX_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m02 = -1.0;
        d.m10 = -1.0;
        d.m11 = 0.0;
        d.m21 = -1.0;
        d.m22 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapnYnZnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYnZnX} dispatcher.
     */
    private Double3x4 mapnYnZnX_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 0.0;
        d.m02 = -1.0;
        d.m03 = this.m03;
        d.m10 = -1.0;
        d.m11 = 0.0;
        d.m12 = 0.0;
        d.m13 = this.m13;
        d.m20 = 0.0;
        d.m21 = -1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnYnZnX}, specialized by runtime matrix
     * properties; reached only through the public {@code mapnYnZnX} dispatcher.
     */
    private Double3x4 mapnYnZnX_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m02 = -1.0;
        d.m03 = this.m03;
        d.m10 = -1.0;
        d.m11 = 0.0;
        d.m13 = this.m13;
        d.m21 = -1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapnYnZnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYnZnX} dispatcher.
     */
    private Double3x4 mapnYnZnX_general(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = -this.m01;
        d.m01 = -this.m02;
        d.m02 = -this.m00;
        d.m03 = this.m03;
        double _buf1 = -this.m11;
        d.m11 = -this.m12;
        d.m12 = -this.m10;
        d.m13 = this.m13;
        double _buf2 = -this.m21;
        d.m21 = -this.m22;
        d.m22 = -this.m20;
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, -z, -x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapnYnZnX(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnYnZnX_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnYnZnX_translation(dest);
        return mapnYnZnX_general(dest);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, -z, -x)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapnYnZnX() {
        if (Joml.RETURN_NEW) return mapnYnZnX(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnYnZnX_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnYnZnX_translation_self(this);
        return mapnYnZnX_general(this);
    }


    /**
     * Private body of {@code mapnZXY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZXY} dispatcher.
     */
    private Double3x4 mapnZXY_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 1.0;
        d.m02 = 0.0;
        d.m03 = 0.0;
        d.m10 = 0.0;
        d.m11 = 0.0;
        d.m12 = 1.0;
        d.m13 = 0.0;
        d.m20 = -1.0;
        d.m21 = 0.0;
        d.m22 = 0.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnZXY}, specialized by runtime matrix properties;
     * reached only through the public {@code mapnZXY} dispatcher.
     */
    private Double3x4 mapnZXY_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 1.0;
        d.m11 = 0.0;
        d.m12 = 1.0;
        d.m20 = -1.0;
        d.m22 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapnZXY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZXY} dispatcher.
     */
    private Double3x4 mapnZXY_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 1.0;
        d.m02 = 0.0;
        d.m03 = this.m03;
        d.m10 = 0.0;
        d.m11 = 0.0;
        d.m12 = 1.0;
        d.m13 = this.m13;
        d.m20 = -1.0;
        d.m21 = 0.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnZXY}, specialized by runtime matrix properties;
     * reached only through the public {@code mapnZXY} dispatcher.
     */
    private Double3x4 mapnZXY_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 1.0;
        d.m03 = this.m03;
        d.m11 = 0.0;
        d.m12 = 1.0;
        d.m13 = this.m13;
        d.m20 = -1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapnZXY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZXY} dispatcher.
     */
    private Double3x4 mapnZXY_general(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = -this.m02;
        double _buf1 = this.m00;
        d.m02 = this.m01;
        d.m03 = this.m03;
        double _buf2 = -this.m12;
        double _buf3 = this.m10;
        d.m12 = this.m11;
        d.m13 = this.m13;
        double _buf4 = -this.m22;
        double _buf5 = this.m20;
        d.m22 = this.m21;
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m10 = _buf2;
        d.m11 = _buf3;
        d.m20 = _buf4;
        d.m21 = _buf5;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, +x, +y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapnZXY(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnZXY_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnZXY_translation(dest);
        return mapnZXY_general(dest);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, +x, +y)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapnZXY() {
        if (Joml.RETURN_NEW) return mapnZXY(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnZXY_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnZXY_translation_self(this);
        return mapnZXY_general(this);
    }


    /**
     * Private body of {@code mapnZXnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZXnY} dispatcher.
     */
    private Double3x4 mapnZXnY_orthogonal_general(@Mutated Double3x4 dest, int _props) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = -this.m02;
        double _buf1 = this.m00;
        d.m02 = -this.m01;
        d.m03 = this.m03;
        double _buf2 = -this.m12;
        double _buf3 = this.m10;
        d.m12 = -this.m11;
        d.m13 = this.m13;
        double _buf4 = -this.m22;
        double _buf5 = this.m20;
        d.m22 = -this.m21;
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m10 = _buf2;
        d.m11 = _buf3;
        d.m20 = _buf4;
        d.m21 = _buf5;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code mapnZXnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZXnY} dispatcher.
     */
    private Double3x4 mapnZXnY_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 1.0;
        d.m02 = 0.0;
        d.m03 = 0.0;
        d.m10 = 0.0;
        d.m11 = 0.0;
        d.m12 = -1.0;
        d.m13 = 0.0;
        d.m20 = -1.0;
        d.m21 = 0.0;
        d.m22 = 0.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnZXnY}, specialized by runtime matrix
     * properties; reached only through the public {@code mapnZXnY} dispatcher.
     */
    private Double3x4 mapnZXnY_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 1.0;
        d.m11 = 0.0;
        d.m12 = -1.0;
        d.m20 = -1.0;
        d.m22 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code mapnZXnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZXnY} dispatcher.
     */
    private Double3x4 mapnZXnY_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 1.0;
        d.m02 = 0.0;
        d.m03 = this.m03;
        d.m10 = 0.0;
        d.m11 = 0.0;
        d.m12 = -1.0;
        d.m13 = this.m13;
        d.m20 = -1.0;
        d.m21 = 0.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnZXnY}, specialized by runtime matrix
     * properties; reached only through the public {@code mapnZXnY} dispatcher.
     */
    private Double3x4 mapnZXnY_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 1.0;
        d.m03 = this.m03;
        d.m11 = 0.0;
        d.m12 = -1.0;
        d.m13 = this.m13;
        d.m20 = -1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, +x, -y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapnZXnY(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnZXnY_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnZXnY_translation(dest);
        return mapnZXnY_orthogonal_general(dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, +x, -y)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapnZXnY() {
        if (Joml.RETURN_NEW) return mapnZXnY(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnZXnY_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnZXnY_translation_self(this);
        return mapnZXnY_orthogonal_general(this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapnZYX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZYX} dispatcher.
     */
    private Double3x4 mapnZYX_orthogonal_general(@Mutated Double3x4 dest, int _props) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = -this.m02;
        d.m01 = this.m01;
        d.m02 = this.m00;
        d.m03 = this.m03;
        double _buf1 = -this.m12;
        d.m11 = this.m11;
        d.m12 = this.m10;
        d.m13 = this.m13;
        double _buf2 = -this.m22;
        d.m21 = this.m21;
        d.m22 = this.m20;
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code mapnZYX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZYX} dispatcher.
     */
    private Double3x4 mapnZYX_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 0.0;
        d.m02 = 1.0;
        d.m03 = 0.0;
        d.m10 = 0.0;
        d.m11 = 1.0;
        d.m12 = 0.0;
        d.m13 = 0.0;
        d.m20 = -1.0;
        d.m21 = 0.0;
        d.m22 = 0.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnZYX}, specialized by runtime matrix properties;
     * reached only through the public {@code mapnZYX} dispatcher.
     */
    private Double3x4 mapnZYX_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m02 = 1.0;
        d.m20 = -1.0;
        d.m22 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code mapnZYX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZYX} dispatcher.
     */
    private Double3x4 mapnZYX_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 0.0;
        d.m02 = 1.0;
        d.m03 = this.m03;
        d.m10 = 0.0;
        d.m11 = 1.0;
        d.m12 = 0.0;
        d.m13 = this.m13;
        d.m20 = -1.0;
        d.m21 = 0.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnZYX}, specialized by runtime matrix properties;
     * reached only through the public {@code mapnZYX} dispatcher.
     */
    private Double3x4 mapnZYX_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m02 = 1.0;
        d.m03 = this.m03;
        d.m13 = this.m13;
        d.m20 = -1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, +y, +x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapnZYX(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnZYX_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnZYX_translation(dest);
        return mapnZYX_orthogonal_general(dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, +y, +x)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapnZYX() {
        if (Joml.RETURN_NEW) return mapnZYX(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnZYX_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnZYX_translation_self(this);
        return mapnZYX_orthogonal_general(this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapnZYnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZYnX} dispatcher.
     */
    private Double3x4 mapnZYnX_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 0.0;
        d.m02 = -1.0;
        d.m03 = 0.0;
        d.m10 = 0.0;
        d.m11 = 1.0;
        d.m12 = 0.0;
        d.m13 = 0.0;
        d.m20 = -1.0;
        d.m21 = 0.0;
        d.m22 = 0.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnZYnX}, specialized by runtime matrix
     * properties; reached only through the public {@code mapnZYnX} dispatcher.
     */
    private Double3x4 mapnZYnX_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m02 = -1.0;
        d.m20 = -1.0;
        d.m22 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapnZYnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZYnX} dispatcher.
     */
    private Double3x4 mapnZYnX_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 0.0;
        d.m02 = -1.0;
        d.m03 = this.m03;
        d.m10 = 0.0;
        d.m11 = 1.0;
        d.m12 = 0.0;
        d.m13 = this.m13;
        d.m20 = -1.0;
        d.m21 = 0.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnZYnX}, specialized by runtime matrix
     * properties; reached only through the public {@code mapnZYnX} dispatcher.
     */
    private Double3x4 mapnZYnX_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m02 = -1.0;
        d.m03 = this.m03;
        d.m13 = this.m13;
        d.m20 = -1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapnZYnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZYnX} dispatcher.
     */
    private Double3x4 mapnZYnX_general(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = -this.m02;
        d.m01 = this.m01;
        d.m02 = -this.m00;
        d.m03 = this.m03;
        double _buf1 = -this.m12;
        d.m11 = this.m11;
        d.m12 = -this.m10;
        d.m13 = this.m13;
        double _buf2 = -this.m22;
        d.m21 = this.m21;
        d.m22 = -this.m20;
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, +y, -x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapnZYnX(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnZYnX_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnZYnX_translation(dest);
        return mapnZYnX_general(dest);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, +y, -x)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapnZYnX() {
        if (Joml.RETURN_NEW) return mapnZYnX(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnZYnX_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnZYnX_translation_self(this);
        return mapnZYnX_general(this);
    }


    /**
     * Private body of {@code mapnZnXY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZnXY} dispatcher.
     */
    private Double3x4 mapnZnXY_orthogonal_general(@Mutated Double3x4 dest, int _props) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = -this.m02;
        double _buf1 = -this.m00;
        d.m02 = this.m01;
        d.m03 = this.m03;
        double _buf2 = -this.m12;
        double _buf3 = -this.m10;
        d.m12 = this.m11;
        d.m13 = this.m13;
        double _buf4 = -this.m22;
        double _buf5 = -this.m20;
        d.m22 = this.m21;
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m10 = _buf2;
        d.m11 = _buf3;
        d.m20 = _buf4;
        d.m21 = _buf5;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code mapnZnXY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZnXY} dispatcher.
     */
    private Double3x4 mapnZnXY_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = -1.0;
        d.m02 = 0.0;
        d.m03 = 0.0;
        d.m10 = 0.0;
        d.m11 = 0.0;
        d.m12 = 1.0;
        d.m13 = 0.0;
        d.m20 = -1.0;
        d.m21 = 0.0;
        d.m22 = 0.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnZnXY}, specialized by runtime matrix
     * properties; reached only through the public {@code mapnZnXY} dispatcher.
     */
    private Double3x4 mapnZnXY_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = -1.0;
        d.m11 = 0.0;
        d.m12 = 1.0;
        d.m20 = -1.0;
        d.m22 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code mapnZnXY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZnXY} dispatcher.
     */
    private Double3x4 mapnZnXY_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = -1.0;
        d.m02 = 0.0;
        d.m03 = this.m03;
        d.m10 = 0.0;
        d.m11 = 0.0;
        d.m12 = 1.0;
        d.m13 = this.m13;
        d.m20 = -1.0;
        d.m21 = 0.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnZnXY}, specialized by runtime matrix
     * properties; reached only through the public {@code mapnZnXY} dispatcher.
     */
    private Double3x4 mapnZnXY_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = -1.0;
        d.m03 = this.m03;
        d.m11 = 0.0;
        d.m12 = 1.0;
        d.m13 = this.m13;
        d.m20 = -1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, -x, +y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapnZnXY(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnZnXY_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnZnXY_translation(dest);
        return mapnZnXY_orthogonal_general(dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, -x, +y)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapnZnXY() {
        if (Joml.RETURN_NEW) return mapnZnXY(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnZnXY_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnZnXY_translation_self(this);
        return mapnZnXY_orthogonal_general(this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapnZnXnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZnXnY} dispatcher.
     */
    private Double3x4 mapnZnXnY_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = -1.0;
        d.m02 = 0.0;
        d.m03 = 0.0;
        d.m10 = 0.0;
        d.m11 = 0.0;
        d.m12 = -1.0;
        d.m13 = 0.0;
        d.m20 = -1.0;
        d.m21 = 0.0;
        d.m22 = 0.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnZnXnY}, specialized by runtime matrix
     * properties; reached only through the public {@code mapnZnXnY} dispatcher.
     */
    private Double3x4 mapnZnXnY_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = -1.0;
        d.m11 = 0.0;
        d.m12 = -1.0;
        d.m20 = -1.0;
        d.m22 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapnZnXnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZnXnY} dispatcher.
     */
    private Double3x4 mapnZnXnY_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = -1.0;
        d.m02 = 0.0;
        d.m03 = this.m03;
        d.m10 = 0.0;
        d.m11 = 0.0;
        d.m12 = -1.0;
        d.m13 = this.m13;
        d.m20 = -1.0;
        d.m21 = 0.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnZnXnY}, specialized by runtime matrix
     * properties; reached only through the public {@code mapnZnXnY} dispatcher.
     */
    private Double3x4 mapnZnXnY_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = -1.0;
        d.m03 = this.m03;
        d.m11 = 0.0;
        d.m12 = -1.0;
        d.m13 = this.m13;
        d.m20 = -1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapnZnXnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZnXnY} dispatcher.
     */
    private Double3x4 mapnZnXnY_general(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = -this.m02;
        double _buf1 = -this.m00;
        d.m02 = -this.m01;
        d.m03 = this.m03;
        double _buf2 = -this.m12;
        double _buf3 = -this.m10;
        d.m12 = -this.m11;
        d.m13 = this.m13;
        double _buf4 = -this.m22;
        double _buf5 = -this.m20;
        d.m22 = -this.m21;
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m10 = _buf2;
        d.m11 = _buf3;
        d.m20 = _buf4;
        d.m21 = _buf5;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, -x, -y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapnZnXnY(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnZnXnY_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnZnXnY_translation(dest);
        return mapnZnXnY_general(dest);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, -x, -y)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapnZnXnY() {
        if (Joml.RETURN_NEW) return mapnZnXnY(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnZnXnY_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnZnXnY_translation_self(this);
        return mapnZnXnY_general(this);
    }


    /**
     * Private body of {@code mapnZnYX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZnYX} dispatcher.
     */
    private Double3x4 mapnZnYX_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 0.0;
        d.m02 = 1.0;
        d.m03 = 0.0;
        d.m10 = 0.0;
        d.m11 = -1.0;
        d.m12 = 0.0;
        d.m13 = 0.0;
        d.m20 = -1.0;
        d.m21 = 0.0;
        d.m22 = 0.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnZnYX}, specialized by runtime matrix
     * properties; reached only through the public {@code mapnZnYX} dispatcher.
     */
    private Double3x4 mapnZnYX_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m02 = 1.0;
        d.m11 = -1.0;
        d.m20 = -1.0;
        d.m22 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapnZnYX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZnYX} dispatcher.
     */
    private Double3x4 mapnZnYX_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 0.0;
        d.m02 = 1.0;
        d.m03 = this.m03;
        d.m10 = 0.0;
        d.m11 = -1.0;
        d.m12 = 0.0;
        d.m13 = this.m13;
        d.m20 = -1.0;
        d.m21 = 0.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnZnYX}, specialized by runtime matrix
     * properties; reached only through the public {@code mapnZnYX} dispatcher.
     */
    private Double3x4 mapnZnYX_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m02 = 1.0;
        d.m03 = this.m03;
        d.m11 = -1.0;
        d.m13 = this.m13;
        d.m20 = -1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code mapnZnYX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZnYX} dispatcher.
     */
    private Double3x4 mapnZnYX_general(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = -this.m02;
        d.m01 = -this.m01;
        d.m02 = this.m00;
        d.m03 = this.m03;
        double _buf1 = -this.m12;
        d.m11 = -this.m11;
        d.m12 = this.m10;
        d.m13 = this.m13;
        double _buf2 = -this.m22;
        d.m21 = -this.m21;
        d.m22 = this.m20;
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, -y, +x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapnZnYX(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnZnYX_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnZnYX_translation(dest);
        return mapnZnYX_general(dest);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, -y, +x)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapnZnYX() {
        if (Joml.RETURN_NEW) return mapnZnYX(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnZnYX_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnZnYX_translation_self(this);
        return mapnZnYX_general(this);
    }


    /**
     * Private body of {@code mapnZnYnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZnYnX} dispatcher.
     */
    private Double3x4 mapnZnYnX_orthogonal_general(@Mutated Double3x4 dest, int _props) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = -this.m02;
        d.m01 = -this.m01;
        d.m02 = -this.m00;
        d.m03 = this.m03;
        double _buf1 = -this.m12;
        d.m11 = -this.m11;
        d.m12 = -this.m10;
        d.m13 = this.m13;
        double _buf2 = -this.m22;
        d.m21 = -this.m21;
        d.m22 = -this.m20;
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code mapnZnYnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZnYnX} dispatcher.
     */
    private Double3x4 mapnZnYnX_identity(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 0.0;
        d.m02 = -1.0;
        d.m03 = 0.0;
        d.m10 = 0.0;
        d.m11 = -1.0;
        d.m12 = 0.0;
        d.m13 = 0.0;
        d.m20 = -1.0;
        d.m21 = 0.0;
        d.m22 = 0.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnZnYnX}, specialized by runtime matrix
     * properties; reached only through the public {@code mapnZnYnX} dispatcher.
     */
    private Double3x4 mapnZnYnX_identity_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m02 = -1.0;
        d.m11 = -1.0;
        d.m20 = -1.0;
        d.m22 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code mapnZnYnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZnYnX} dispatcher.
     */
    private Double3x4 mapnZnYnX_translation(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m01 = 0.0;
        d.m02 = -1.0;
        d.m03 = this.m03;
        d.m10 = 0.0;
        d.m11 = -1.0;
        d.m12 = 0.0;
        d.m13 = this.m13;
        d.m20 = -1.0;
        d.m21 = 0.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code mapnZnYnX}, specialized by runtime matrix
     * properties; reached only through the public {@code mapnZnYnX} dispatcher.
     */
    private Double3x4 mapnZnYnX_translation_self(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 0.0;
        d.m02 = -1.0;
        d.m03 = this.m03;
        d.m11 = -1.0;
        d.m13 = this.m13;
        d.m20 = -1.0;
        d.m22 = 0.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, -y, -x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 mapnZnYnX(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnZnYnX_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnZnYnX_translation(dest);
        return mapnZnYnX_orthogonal_general(dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, -y, -x)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 mapnZnYnX() {
        if (Joml.RETURN_NEW) return mapnZnYnX(Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnZnYnX_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnZnYnX_translation_self(this);
        return mapnZnYnX_orthogonal_general(this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Pre-multiply the rotation {@code rot} about the pivot point {@code pivot} onto this matrix
     * and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param rot the quaternion (must be a unit quaternion)
     * @param pivot the pivot point
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 preRotateAround(DoubleQuatR rot, Double3R pivot, @Mutated Double3x4 dest) {
        return preRotateAround(rot.x(), rot.y(), rot.z(), rot.w(), pivot.x(), pivot.y(), pivot.z(), dest);
    }


    /**
     * Pre-multiply the rotation {@code rot} about the pivot point {@code pivot} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param rot the quaternion (must be a unit quaternion)
     * @param pivot the pivot point
     * @return this
     */
    public @Mutated Double3x4 preRotateAround(DoubleQuatR rot, Double3R pivot) {
        return preRotateAround(rot.x(), rot.y(), rot.z(), rot.w(), pivot.x(), pivot.y(), pivot.z());
    }


    /**
     * Private body of {@code preRotateAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preRotateAround} dispatcher.
     */
    private Double3x4 preRotateAround_identity(double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = -pivotX;
        double _t1 = -pivotY;
        double _t2 = -pivotZ;
        double _t3 = rotZ * rotZ;
        double _t4 = rotZ * rotW;
        double _t5 = rotY * rotW;
        double _t21 = 2.0 * Math.fma(rotX, rotZ, _t5);
        double _t22 = 2.0 * Math.fma(rotX, rotY, _t4);
        double _t23 = 2.0 * Math.fma(rotX, rotW, rotY * rotZ);
        double _t24 = 2.0 * Math.fma(rotX, rotY, -_t4);
        double _t25 = 2.0 * Math.fma(rotY, rotZ, -(rotX * rotW));
        double _t26 = 2.0 * Math.fma(rotX, rotZ, -_t5);
        double _t27 = Math.fma(-2.0, Math.fma(rotY, rotY, _t3), 1.0);
        double _t28 = Math.fma(-2.0, Math.fma(rotX, rotX, _t3), 1.0);
        double _t29 = Math.fma(-2.0, Math.fma(rotX, rotX, rotY * rotY), 1.0);
        d.m00 = _t27;
        d.m01 = _t24;
        d.m02 = _t21;
        d.m03 = Math.fma(_t0, _t27, Math.fma(_t1, _t24, Math.fma(_t2, _t21, pivotX)));
        d.m10 = _t22;
        d.m11 = _t28;
        d.m12 = _t25;
        d.m13 = Math.fma(_t0, _t22, Math.fma(_t1, _t28, Math.fma(_t2, _t25, pivotY)));
        d.m20 = _t26;
        d.m21 = _t23;
        d.m22 = _t29;
        d.m23 = Math.fma(_t0, _t26, Math.fma(_t1, _t23, Math.fma(_t2, _t29, pivotZ)));
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code preRotateAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preRotateAround} dispatcher.
     */
    private Double3x4 preRotateAround_translation(double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = -pivotX;
        double _t1 = -pivotY;
        double _t2 = -pivotZ;
        double _t3 = rotZ * rotZ;
        double _t4 = rotZ * rotW;
        double _t5 = rotY * rotW;
        double _t21 = 2.0 * Math.fma(rotX, rotZ, _t5);
        double _t22 = 2.0 * Math.fma(rotX, rotY, _t4);
        double _t23 = 2.0 * Math.fma(rotX, rotW, rotY * rotZ);
        double _t24 = 2.0 * Math.fma(rotX, rotY, -_t4);
        double _t25 = 2.0 * Math.fma(rotY, rotZ, -(rotX * rotW));
        double _t26 = 2.0 * Math.fma(rotX, rotZ, -_t5);
        double _t27 = Math.fma(-2.0, Math.fma(rotY, rotY, _t3), 1.0);
        double _t28 = Math.fma(-2.0, Math.fma(rotX, rotX, _t3), 1.0);
        double _t29 = Math.fma(-2.0, Math.fma(rotX, rotX, rotY * rotY), 1.0);
        d.m00 = _t27;
        d.m01 = _t24;
        d.m02 = _t21;
        double _buf0 = Math.fma(_t0, _t27, Math.fma(_t1, _t24, Math.fma(_t2, _t21, Math.fma(this.m03, _t27, Math.fma(this.m13, _t24, Math.fma(this.m23, _t21, pivotX))))));
        d.m10 = _t22;
        d.m11 = _t28;
        d.m12 = _t25;
        double _buf1 = Math.fma(_t0, _t22, Math.fma(_t1, _t28, Math.fma(_t2, _t25, Math.fma(this.m03, _t22, Math.fma(this.m13, _t28, Math.fma(this.m23, _t25, pivotY))))));
        d.m20 = _t26;
        d.m21 = _t23;
        d.m22 = _t29;
        d.m23 = Math.fma(_t0, _t26, Math.fma(_t1, _t23, Math.fma(_t2, _t29, Math.fma(this.m03, _t26, Math.fma(this.m13, _t23, Math.fma(this.m23, _t29, pivotZ))))));
        d.m03 = _buf0;
        d.m13 = _buf1;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code preRotateAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preRotateAround} dispatcher.
     */
    private Double3x4 preRotateAround_orthogonal(double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
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
        double _buf0 = Math.fma(this.m20, _t21, Math.fma(this.m00, _t27, this.m10 * _t24));
        double _buf1 = Math.fma(this.m21, _t21, Math.fma(this.m01, _t27, this.m11 * _t24));
        double _buf2 = Math.fma(this.m22, _t21, Math.fma(this.m02, _t27, this.m12 * _t24));
        double _buf3 = Math.fma(_t0, _t27, Math.fma(_t1, _t24, Math.fma(_t2, _t21, Math.fma(this.m03, _t27, Math.fma(this.m13, _t24, Math.fma(this.m23, _t21, pivotX))))));
        double _buf4 = Math.fma(this.m20, _t25, Math.fma(this.m00, _t22, this.m10 * _t28));
        double _buf5 = Math.fma(this.m21, _t25, Math.fma(this.m01, _t22, this.m11 * _t28));
        double _buf6 = Math.fma(this.m22, _t25, Math.fma(this.m02, _t22, this.m12 * _t28));
        double _buf7 = Math.fma(_t0, _t22, Math.fma(_t1, _t28, Math.fma(_t2, _t25, Math.fma(this.m03, _t22, Math.fma(this.m13, _t28, Math.fma(this.m23, _t25, pivotY))))));
        d.m20 = Math.fma(this.m20, _t29, Math.fma(this.m00, _t26, this.m10 * _t23));
        d.m21 = Math.fma(this.m21, _t29, Math.fma(this.m01, _t26, this.m11 * _t23));
        d.m22 = Math.fma(this.m22, _t29, Math.fma(this.m02, _t26, this.m12 * _t23));
        d.m23 = Math.fma(_t0, _t26, Math.fma(_t1, _t23, Math.fma(_t2, _t29, Math.fma(this.m03, _t26, Math.fma(this.m13, _t23, Math.fma(this.m23, _t29, pivotZ))))));
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.m03 = _buf3;
        d.m10 = _buf4;
        d.m11 = _buf5;
        d.m12 = _buf6;
        d.m13 = _buf7;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code preRotateAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preRotateAround} dispatcher.
     */
    private Double3x4 preRotateAround_general(double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
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
        double _buf0 = Math.fma(this.m20, _t21, Math.fma(this.m00, _t27, this.m10 * _t24));
        double _buf1 = Math.fma(this.m21, _t21, Math.fma(this.m01, _t27, this.m11 * _t24));
        double _buf2 = Math.fma(this.m22, _t21, Math.fma(this.m02, _t27, this.m12 * _t24));
        double _buf3 = Math.fma(_t0, _t27, Math.fma(_t1, _t24, Math.fma(_t2, _t21, Math.fma(this.m03, _t27, Math.fma(this.m13, _t24, Math.fma(this.m23, _t21, pivotX))))));
        double _buf4 = Math.fma(this.m20, _t25, Math.fma(this.m00, _t22, this.m10 * _t28));
        double _buf5 = Math.fma(this.m21, _t25, Math.fma(this.m01, _t22, this.m11 * _t28));
        double _buf6 = Math.fma(this.m22, _t25, Math.fma(this.m02, _t22, this.m12 * _t28));
        double _buf7 = Math.fma(_t0, _t22, Math.fma(_t1, _t28, Math.fma(_t2, _t25, Math.fma(this.m03, _t22, Math.fma(this.m13, _t28, Math.fma(this.m23, _t25, pivotY))))));
        d.m20 = Math.fma(this.m20, _t29, Math.fma(this.m00, _t26, this.m10 * _t23));
        d.m21 = Math.fma(this.m21, _t29, Math.fma(this.m01, _t26, this.m11 * _t23));
        d.m22 = Math.fma(this.m22, _t29, Math.fma(this.m02, _t26, this.m12 * _t23));
        d.m23 = Math.fma(_t0, _t26, Math.fma(_t1, _t23, Math.fma(_t2, _t29, Math.fma(this.m03, _t26, Math.fma(this.m13, _t23, Math.fma(this.m23, _t29, pivotZ))))));
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.m03 = _buf3;
        d.m10 = _buf4;
        d.m11 = _buf5;
        d.m12 = _buf6;
        d.m13 = _buf7;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Pre-multiply the rotation ({@code rotX}, {@code rotY}, {@code rotZ}, {@code rotW}) about the
     * pivot point ({@code pivotX}, {@code pivotY}, {@code pivotZ}) onto this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param rotX the {@code x} component of the quaternion {@code (rotX, rotY, rotZ, rotW)} (the
     *        quaternion must have unit length)
     * @param rotY the {@code y} component of the quaternion {@code (rotX, rotY, rotZ, rotW)} (the
     *        quaternion must have unit length)
     * @param rotZ the {@code z} component of the quaternion {@code (rotX, rotY, rotZ, rotW)} (the
     *        quaternion must have unit length)
     * @param rotW the {@code w} component of the quaternion {@code (rotX, rotY, rotZ, rotW)} (the
     *        quaternion must have unit length)
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotZ the {@code z} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 preRotateAround(double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ, @Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotateAround_identity(rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotateAround_translation(rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preRotateAround_orthogonal(rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ, dest);
        return preRotateAround_general(rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ, dest);
    }


    /**
     * Pre-multiply the rotation ({@code rotX}, {@code rotY}, {@code rotZ}, {@code rotW}) about the
     * pivot point ({@code pivotX}, {@code pivotY}, {@code pivotZ}) onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param rotX the {@code x} component of the quaternion {@code (rotX, rotY, rotZ, rotW)} (the
     *        quaternion must have unit length)
     * @param rotY the {@code y} component of the quaternion {@code (rotX, rotY, rotZ, rotW)} (the
     *        quaternion must have unit length)
     * @param rotZ the {@code z} component of the quaternion {@code (rotX, rotY, rotZ, rotW)} (the
     *        quaternion must have unit length)
     * @param rotW the {@code w} component of the quaternion {@code (rotX, rotY, rotZ, rotW)} (the
     *        quaternion must have unit length)
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotZ the {@code z} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @return this
     */
    @Mutated public Double3x4 preRotateAround(double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ) {
        if (Joml.RETURN_NEW) return preRotateAround(rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ, Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotateAround_identity(rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotateAround_translation(rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ, this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preRotateAround_orthogonal(rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ, this);
        return preRotateAround_general(rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ, this);
    }


    /**
     * Pre-multiply a rotation of {@code angle} radians about the axis {@code axis} onto this matrix
     * and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 preRotateAxis(double angle, Double3R axis, @Mutated Double3x4 dest) {
        return preRotateAxis(angle, axis.x(), axis.y(), axis.z(), dest);
    }


    /**
     * Pre-multiply a rotation of {@code angle} radians about the axis {@code axis} onto this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @return this
     */
    public @Mutated Double3x4 preRotateAxis(double angle, Double3R axis) {
        return preRotateAxis(angle, axis.x(), axis.y(), axis.z());
    }


    /**
     * Private body of {@code preRotateAxis}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateAxis} dispatcher.
     */
    private Double3x4 preRotateAxis_identity(double angle, double axisX, double axisY, double axisZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t2 = 1.0 - _t0;
        double _t3 = axisX * axisY;
        double _t4 = axisX * axisZ;
        double _t5 = axisY * axisZ;
        d.m00 = Math.fma(_t2, axisX * axisX, _t0);
        d.m01 = Math.fma(_t2, _t3, -(axisZ * _t1));
        d.m02 = Math.fma(axisY, _t1, _t2 * _t4);
        d.m03 = 0.0;
        d.m10 = Math.fma(axisZ, _t1, _t2 * _t3);
        d.m11 = Math.fma(_t2, axisY * axisY, _t0);
        d.m12 = Math.fma(_t2, _t5, -(axisX * _t1));
        d.m13 = 0.0;
        d.m20 = Math.fma(_t2, _t4, -(axisY * _t1));
        d.m21 = Math.fma(axisX, _t1, _t2 * _t5);
        d.m22 = Math.fma(_t2, axisZ * axisZ, _t0);
        d.m23 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preRotateAxis}, specialized by runtime matrix
     * properties; reached only through the public {@code preRotateAxis} dispatcher.
     */
    private Double3x4 preRotateAxis_identity_self(double angle, double axisX, double axisY, double axisZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t2 = 1.0 - _t0;
        double _t3 = axisX * axisY;
        double _t4 = axisX * axisZ;
        double _t5 = axisY * axisZ;
        d.m00 = Math.fma(_t2, axisX * axisX, _t0);
        d.m01 = Math.fma(_t2, _t3, -(axisZ * _t1));
        d.m02 = Math.fma(axisY, _t1, _t2 * _t4);
        d.m10 = Math.fma(axisZ, _t1, _t2 * _t3);
        d.m11 = Math.fma(_t2, axisY * axisY, _t0);
        d.m12 = Math.fma(_t2, _t5, -(axisX * _t1));
        d.m20 = Math.fma(_t2, _t4, -(axisY * _t1));
        d.m21 = Math.fma(axisX, _t1, _t2 * _t5);
        d.m22 = Math.fma(_t2, axisZ * axisZ, _t0);
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code preRotateAxis}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateAxis} dispatcher.
     */
    private Double3x4 preRotateAxis_translation(double angle, double axisX, double axisY, double axisZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t2 = 1.0 - _t0;
        double _t4 = axisX * axisY;
        double _t6 = axisX * axisZ;
        double _t8 = axisY * axisZ;
        double _t18 = Math.fma(_t2, axisX * axisX, _t0);
        double _t19 = Math.fma(_t2, axisY * axisY, _t0);
        double _t20 = Math.fma(_t2, axisZ * axisZ, _t0);
        double _t21 = Math.fma(axisY, _t1, _t2 * _t6);
        double _t22 = Math.fma(axisZ, _t1, _t2 * _t4);
        double _t23 = Math.fma(axisX, _t1, _t2 * _t8);
        double _t24 = Math.fma(_t2, _t4, -(axisZ * _t1));
        double _t25 = Math.fma(_t2, _t8, -(axisX * _t1));
        double _t26 = Math.fma(_t2, _t6, -(axisY * _t1));
        d.m00 = _t18;
        d.m01 = _t24;
        d.m02 = _t21;
        double _buf0 = Math.fma(this.m23, _t21, Math.fma(this.m03, _t18, this.m13 * _t24));
        d.m10 = _t22;
        d.m11 = _t19;
        d.m12 = _t25;
        double _buf1 = Math.fma(this.m23, _t25, Math.fma(this.m03, _t22, this.m13 * _t19));
        d.m20 = _t26;
        d.m21 = _t23;
        d.m22 = _t20;
        d.m23 = Math.fma(this.m23, _t20, Math.fma(this.m03, _t26, this.m13 * _t23));
        d.m03 = _buf0;
        d.m13 = _buf1;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code preRotateAxis}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateAxis} dispatcher.
     */
    private Double3x4 preRotateAxis_orthogonal(double angle, double axisX, double axisY, double axisZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
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
        double _buf0 = Math.fma(this.m20, _t21, Math.fma(this.m00, _t18, this.m10 * _t24));
        double _buf1 = Math.fma(this.m21, _t21, Math.fma(this.m01, _t18, this.m11 * _t24));
        double _buf2 = Math.fma(this.m22, _t21, Math.fma(this.m02, _t18, this.m12 * _t24));
        double _buf3 = Math.fma(this.m23, _t21, Math.fma(this.m03, _t18, this.m13 * _t24));
        double _buf4 = Math.fma(this.m20, _t25, Math.fma(this.m00, _t22, this.m10 * _t19));
        double _buf5 = Math.fma(this.m21, _t25, Math.fma(this.m01, _t22, this.m11 * _t19));
        double _buf6 = Math.fma(this.m22, _t25, Math.fma(this.m02, _t22, this.m12 * _t19));
        double _buf7 = Math.fma(this.m23, _t25, Math.fma(this.m03, _t22, this.m13 * _t19));
        d.m20 = Math.fma(this.m20, _t20, Math.fma(this.m00, _t26, this.m10 * _t23));
        d.m21 = Math.fma(this.m21, _t20, Math.fma(this.m01, _t26, this.m11 * _t23));
        d.m22 = Math.fma(this.m22, _t20, Math.fma(this.m02, _t26, this.m12 * _t23));
        d.m23 = Math.fma(this.m23, _t20, Math.fma(this.m03, _t26, this.m13 * _t23));
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.m03 = _buf3;
        d.m10 = _buf4;
        d.m11 = _buf5;
        d.m12 = _buf6;
        d.m13 = _buf7;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code preRotateAxis}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateAxis} dispatcher.
     */
    private Double3x4 preRotateAxis_general(double angle, double axisX, double axisY, double axisZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
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
        double _buf0 = Math.fma(this.m20, _t21, Math.fma(this.m00, _t18, this.m10 * _t24));
        double _buf1 = Math.fma(this.m21, _t21, Math.fma(this.m01, _t18, this.m11 * _t24));
        double _buf2 = Math.fma(this.m22, _t21, Math.fma(this.m02, _t18, this.m12 * _t24));
        double _buf3 = Math.fma(this.m23, _t21, Math.fma(this.m03, _t18, this.m13 * _t24));
        double _buf4 = Math.fma(this.m20, _t25, Math.fma(this.m00, _t22, this.m10 * _t19));
        double _buf5 = Math.fma(this.m21, _t25, Math.fma(this.m01, _t22, this.m11 * _t19));
        double _buf6 = Math.fma(this.m22, _t25, Math.fma(this.m02, _t22, this.m12 * _t19));
        double _buf7 = Math.fma(this.m23, _t25, Math.fma(this.m03, _t22, this.m13 * _t19));
        d.m20 = Math.fma(this.m20, _t20, Math.fma(this.m00, _t26, this.m10 * _t23));
        d.m21 = Math.fma(this.m21, _t20, Math.fma(this.m01, _t26, this.m11 * _t23));
        d.m22 = Math.fma(this.m22, _t20, Math.fma(this.m02, _t26, this.m12 * _t23));
        d.m23 = Math.fma(this.m23, _t20, Math.fma(this.m03, _t26, this.m13 * _t23));
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.m03 = _buf3;
        d.m10 = _buf4;
        d.m11 = _buf5;
        d.m12 = _buf6;
        d.m13 = _buf7;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Pre-multiply a rotation of {@code angle} radians about the axis ({@code axisX},
     * {@code axisY}, {@code axisZ}) onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @param axisX the {@code x} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisY the {@code y} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisZ the {@code z} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 preRotateAxis(double angle, double axisX, double axisY, double axisZ, @Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotateAxis_identity(angle, axisX, axisY, axisZ, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotateAxis_translation(angle, axisX, axisY, axisZ, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preRotateAxis_orthogonal(angle, axisX, axisY, axisZ, dest);
        return preRotateAxis_general(angle, axisX, axisY, axisZ, dest);
    }


    /**
     * Pre-multiply a rotation of {@code angle} radians about the axis ({@code axisX},
     * {@code axisY}, {@code axisZ}) onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @param axisX the {@code x} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisY the {@code y} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisZ the {@code z} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @return this
     */
    @Mutated public Double3x4 preRotateAxis(double angle, double axisX, double axisY, double axisZ) {
        if (Joml.RETURN_NEW) return preRotateAxis(angle, axisX, axisY, axisZ, Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotateAxis_identity_self(angle, axisX, axisY, axisZ, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotateAxis_translation(angle, axisX, axisY, axisZ, this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preRotateAxis_orthogonal(angle, axisX, axisY, axisZ, this);
        return preRotateAxis_general(angle, axisX, axisY, axisZ, this);
    }


    /**
     * Pre-multiply the rotation represented by the quaternion {@code q} onto this matrix and store
     * the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param q the quaternion (must be a unit quaternion)
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 preRotateQuat(DoubleQuatR q, @Mutated Double3x4 dest) {
        return preRotateQuat(q.x(), q.y(), q.z(), q.w(), dest);
    }


    /**
     * Pre-multiply the rotation represented by the quaternion {@code q} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param q the quaternion (must be a unit quaternion)
     * @return this
     */
    public @Mutated Double3x4 preRotateQuat(DoubleQuatR q) {
        return preRotateQuat(q.x(), q.y(), q.z(), q.w());
    }


    /**
     * Private body of {@code preRotateQuat}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateQuat} dispatcher.
     */
    private Double3x4 preRotateQuat_identity(double qX, double qY, double qZ, double qW, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = qZ * qZ;
        double _t1 = qZ * qW;
        double _t2 = qY * qW;
        d.m00 = Math.fma(-2.0, Math.fma(qY, qY, _t0), 1.0);
        d.m01 = 2.0 * Math.fma(qX, qY, -_t1);
        d.m02 = 2.0 * Math.fma(qX, qZ, _t2);
        d.m03 = 0.0;
        d.m10 = 2.0 * Math.fma(qX, qY, _t1);
        d.m11 = Math.fma(-2.0, Math.fma(qX, qX, _t0), 1.0);
        d.m12 = 2.0 * Math.fma(qY, qZ, -(qX * qW));
        d.m13 = 0.0;
        d.m20 = 2.0 * Math.fma(qX, qZ, -_t2);
        d.m21 = 2.0 * Math.fma(qX, qW, qY * qZ);
        d.m22 = Math.fma(-2.0, Math.fma(qX, qX, qY * qY), 1.0);
        d.m23 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preRotateQuat}, specialized by runtime matrix
     * properties; reached only through the public {@code preRotateQuat} dispatcher.
     */
    private Double3x4 preRotateQuat_identity_self(double qX, double qY, double qZ, double qW, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = qZ * qZ;
        double _t1 = qZ * qW;
        double _t2 = qY * qW;
        d.m00 = Math.fma(-2.0, Math.fma(qY, qY, _t0), 1.0);
        d.m01 = 2.0 * Math.fma(qX, qY, -_t1);
        d.m02 = 2.0 * Math.fma(qX, qZ, _t2);
        d.m10 = 2.0 * Math.fma(qX, qY, _t1);
        d.m11 = Math.fma(-2.0, Math.fma(qX, qX, _t0), 1.0);
        d.m12 = 2.0 * Math.fma(qY, qZ, -(qX * qW));
        d.m20 = 2.0 * Math.fma(qX, qZ, -_t2);
        d.m21 = 2.0 * Math.fma(qX, qW, qY * qZ);
        d.m22 = Math.fma(-2.0, Math.fma(qX, qX, qY * qY), 1.0);
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code preRotateQuat}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateQuat} dispatcher.
     */
    private Double3x4 preRotateQuat_translation(double qX, double qY, double qZ, double qW, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = qZ * qZ;
        double _t1 = qZ * qW;
        double _t2 = qY * qW;
        double _t18 = 2.0 * Math.fma(qX, qZ, _t2);
        double _t19 = 2.0 * Math.fma(qX, qY, _t1);
        double _t20 = 2.0 * Math.fma(qX, qW, qY * qZ);
        double _t21 = 2.0 * Math.fma(qX, qY, -_t1);
        double _t22 = 2.0 * Math.fma(qY, qZ, -(qX * qW));
        double _t23 = 2.0 * Math.fma(qX, qZ, -_t2);
        double _t24 = Math.fma(-2.0, Math.fma(qY, qY, _t0), 1.0);
        double _t25 = Math.fma(-2.0, Math.fma(qX, qX, _t0), 1.0);
        double _t26 = Math.fma(-2.0, Math.fma(qX, qX, qY * qY), 1.0);
        d.m00 = _t24;
        d.m01 = _t21;
        d.m02 = _t18;
        double _buf0 = Math.fma(this.m23, _t18, Math.fma(this.m03, _t24, this.m13 * _t21));
        d.m10 = _t19;
        d.m11 = _t25;
        d.m12 = _t22;
        double _buf1 = Math.fma(this.m23, _t22, Math.fma(this.m03, _t19, this.m13 * _t25));
        d.m20 = _t23;
        d.m21 = _t20;
        d.m22 = _t26;
        d.m23 = Math.fma(this.m23, _t26, Math.fma(this.m03, _t23, this.m13 * _t20));
        d.m03 = _buf0;
        d.m13 = _buf1;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code preRotateQuat}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateQuat} dispatcher.
     */
    private Double3x4 preRotateQuat_orthogonal(double qX, double qY, double qZ, double qW, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
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
        double _buf0 = Math.fma(this.m20, _t18, Math.fma(this.m00, _t24, this.m10 * _t21));
        double _buf1 = Math.fma(this.m21, _t18, Math.fma(this.m01, _t24, this.m11 * _t21));
        double _buf2 = Math.fma(this.m22, _t18, Math.fma(this.m02, _t24, this.m12 * _t21));
        double _buf3 = Math.fma(this.m23, _t18, Math.fma(this.m03, _t24, this.m13 * _t21));
        double _buf4 = Math.fma(this.m20, _t22, Math.fma(this.m00, _t19, this.m10 * _t25));
        double _buf5 = Math.fma(this.m21, _t22, Math.fma(this.m01, _t19, this.m11 * _t25));
        double _buf6 = Math.fma(this.m22, _t22, Math.fma(this.m02, _t19, this.m12 * _t25));
        double _buf7 = Math.fma(this.m23, _t22, Math.fma(this.m03, _t19, this.m13 * _t25));
        d.m20 = Math.fma(this.m20, _t26, Math.fma(this.m00, _t23, this.m10 * _t20));
        d.m21 = Math.fma(this.m21, _t26, Math.fma(this.m01, _t23, this.m11 * _t20));
        d.m22 = Math.fma(this.m22, _t26, Math.fma(this.m02, _t23, this.m12 * _t20));
        d.m23 = Math.fma(this.m23, _t26, Math.fma(this.m03, _t23, this.m13 * _t20));
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.m03 = _buf3;
        d.m10 = _buf4;
        d.m11 = _buf5;
        d.m12 = _buf6;
        d.m13 = _buf7;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code preRotateQuat}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateQuat} dispatcher.
     */
    private Double3x4 preRotateQuat_general(double qX, double qY, double qZ, double qW, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
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
        double _buf0 = Math.fma(this.m20, _t18, Math.fma(this.m00, _t24, this.m10 * _t21));
        double _buf1 = Math.fma(this.m21, _t18, Math.fma(this.m01, _t24, this.m11 * _t21));
        double _buf2 = Math.fma(this.m22, _t18, Math.fma(this.m02, _t24, this.m12 * _t21));
        double _buf3 = Math.fma(this.m23, _t18, Math.fma(this.m03, _t24, this.m13 * _t21));
        double _buf4 = Math.fma(this.m20, _t22, Math.fma(this.m00, _t19, this.m10 * _t25));
        double _buf5 = Math.fma(this.m21, _t22, Math.fma(this.m01, _t19, this.m11 * _t25));
        double _buf6 = Math.fma(this.m22, _t22, Math.fma(this.m02, _t19, this.m12 * _t25));
        double _buf7 = Math.fma(this.m23, _t22, Math.fma(this.m03, _t19, this.m13 * _t25));
        d.m20 = Math.fma(this.m20, _t26, Math.fma(this.m00, _t23, this.m10 * _t20));
        d.m21 = Math.fma(this.m21, _t26, Math.fma(this.m01, _t23, this.m11 * _t20));
        d.m22 = Math.fma(this.m22, _t26, Math.fma(this.m02, _t23, this.m12 * _t20));
        d.m23 = Math.fma(this.m23, _t26, Math.fma(this.m03, _t23, this.m13 * _t20));
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.m03 = _buf3;
        d.m10 = _buf4;
        d.m11 = _buf5;
        d.m12 = _buf6;
        d.m13 = _buf7;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Pre-multiply the rotation represented by the quaternion ({@code qX}, {@code qY}, {@code qZ},
     * {@code qW}) onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param qX the {@code x} component of the quaternion {@code (qX, qY, qZ, qW)} (the quaternion
     *        must have unit length)
     * @param qY the {@code y} component of the quaternion {@code (qX, qY, qZ, qW)} (the quaternion
     *        must have unit length)
     * @param qZ the {@code z} component of the quaternion {@code (qX, qY, qZ, qW)} (the quaternion
     *        must have unit length)
     * @param qW the {@code w} component of the quaternion {@code (qX, qY, qZ, qW)} (the quaternion
     *        must have unit length)
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 preRotateQuat(double qX, double qY, double qZ, double qW, @Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotateQuat_identity(qX, qY, qZ, qW, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotateQuat_translation(qX, qY, qZ, qW, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preRotateQuat_orthogonal(qX, qY, qZ, qW, dest);
        return preRotateQuat_general(qX, qY, qZ, qW, dest);
    }


    /**
     * Pre-multiply the rotation represented by the quaternion ({@code qX}, {@code qY}, {@code qZ},
     * {@code qW}) onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param qX the {@code x} component of the quaternion {@code (qX, qY, qZ, qW)} (the quaternion
     *        must have unit length)
     * @param qY the {@code y} component of the quaternion {@code (qX, qY, qZ, qW)} (the quaternion
     *        must have unit length)
     * @param qZ the {@code z} component of the quaternion {@code (qX, qY, qZ, qW)} (the quaternion
     *        must have unit length)
     * @param qW the {@code w} component of the quaternion {@code (qX, qY, qZ, qW)} (the quaternion
     *        must have unit length)
     * @return this
     */
    @Mutated public Double3x4 preRotateQuat(double qX, double qY, double qZ, double qW) {
        if (Joml.RETURN_NEW) return preRotateQuat(qX, qY, qZ, qW, Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotateQuat_identity_self(qX, qY, qZ, qW, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotateQuat_translation(qX, qY, qZ, qW, this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preRotateQuat_orthogonal(qX, qY, qZ, qW, this);
        return preRotateQuat_general(qX, qY, qZ, qW, this);
    }


    /**
     * Private body of {@code preRotateX}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateX} dispatcher.
     */
    private Double3x4 preRotateX_orthogonal_general(double angle, @Mutated Double3x4 dest, int _props) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        d.m00 = this.m00;
        d.m01 = this.m01;
        d.m02 = this.m02;
        d.m03 = this.m03;
        double _buf0 = Math.fma(this.m10, _t0, -(this.m20 * _t1));
        double _buf1 = Math.fma(this.m11, _t0, -(this.m21 * _t1));
        double _buf2 = Math.fma(this.m12, _t0, -(this.m22 * _t1));
        double _buf3 = Math.fma(this.m13, _t0, -(this.m23 * _t1));
        d.m20 = Math.fma(this.m10, _t1, this.m20 * _t0);
        d.m21 = Math.fma(this.m11, _t1, this.m21 * _t0);
        d.m22 = Math.fma(this.m12, _t1, this.m22 * _t0);
        d.m23 = Math.fma(this.m13, _t1, this.m23 * _t0);
        d.m10 = _buf0;
        d.m11 = _buf1;
        d.m12 = _buf2;
        d.m13 = _buf3;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code preRotateX}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateX} dispatcher.
     */
    private Double3x4 preRotateX_identity(double angle, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        d.m00 = 1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = 0.0;
        d.m10 = 0.0;
        d.m11 = _t0;
        d.m12 = -_t1;
        d.m13 = 0.0;
        d.m20 = 0.0;
        d.m21 = _t1;
        d.m22 = _t0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preRotateX}, specialized by runtime matrix
     * properties; reached only through the public {@code preRotateX} dispatcher.
     */
    private Double3x4 preRotateX_identity_self(double angle, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        d.m11 = _t0;
        d.m12 = -_t1;
        d.m21 = _t1;
        d.m22 = _t0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code preRotateX}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateX} dispatcher.
     */
    private Double3x4 preRotateX_translation(double angle, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        d.m00 = 1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = this.m03;
        d.m10 = 0.0;
        d.m11 = _t0;
        d.m12 = -_t1;
        double _buf0 = Math.fma(this.m13, _t0, -(this.m23 * _t1));
        d.m20 = 0.0;
        d.m21 = _t1;
        d.m22 = _t0;
        d.m23 = Math.fma(this.m13, _t1, this.m23 * _t0);
        d.m13 = _buf0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preRotateX}, specialized by runtime matrix
     * properties; reached only through the public {@code preRotateX} dispatcher.
     */
    private Double3x4 preRotateX_translation_self(double angle, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        d.m03 = this.m03;
        d.m11 = _t0;
        d.m12 = -_t1;
        double _buf0 = Math.fma(this.m13, _t0, -(this.m23 * _t1));
        d.m21 = _t1;
        d.m22 = _t0;
        d.m23 = Math.fma(this.m13, _t1, this.m23 * _t0);
        d.m13 = _buf0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Pre-multiply a rotation of {@code angle} radians about the X axis onto this matrix and store
     * the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 preRotateX(double angle, @Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotateX_identity(angle, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotateX_translation(angle, dest);
        return preRotateX_orthogonal_general(angle, dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Pre-multiply a rotation of {@code angle} radians about the X axis onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public Double3x4 preRotateX(double angle) {
        if (Joml.RETURN_NEW) return preRotateX(angle, Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotateX_identity_self(angle, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotateX_translation_self(angle, this);
        return preRotateX_orthogonal_general(angle, this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code preRotateY}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateY} dispatcher.
     */
    private Double3x4 preRotateY_orthogonal_general(double angle, @Mutated Double3x4 dest, int _props) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _buf0 = Math.fma(this.m00, _t0, this.m20 * _t1);
        double _buf1 = Math.fma(this.m01, _t0, this.m21 * _t1);
        double _buf2 = Math.fma(this.m02, _t0, this.m22 * _t1);
        double _buf3 = Math.fma(this.m03, _t0, this.m23 * _t1);
        d.m10 = this.m10;
        d.m11 = this.m11;
        d.m12 = this.m12;
        d.m13 = this.m13;
        d.m20 = Math.fma(this.m20, _t0, -(this.m00 * _t1));
        d.m21 = Math.fma(this.m21, _t0, -(this.m01 * _t1));
        d.m22 = Math.fma(this.m22, _t0, -(this.m02 * _t1));
        d.m23 = Math.fma(this.m23, _t0, -(this.m03 * _t1));
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.m03 = _buf3;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code preRotateY}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateY} dispatcher.
     */
    private Double3x4 preRotateY_identity(double angle, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        d.m00 = _t0;
        d.m01 = 0.0;
        d.m02 = _t1;
        d.m03 = 0.0;
        d.m10 = 0.0;
        d.m11 = 1.0;
        d.m12 = 0.0;
        d.m13 = 0.0;
        d.m20 = -_t1;
        d.m21 = 0.0;
        d.m22 = _t0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preRotateY}, specialized by runtime matrix
     * properties; reached only through the public {@code preRotateY} dispatcher.
     */
    private Double3x4 preRotateY_identity_self(double angle, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        d.m00 = _t0;
        d.m02 = _t1;
        d.m20 = -_t1;
        d.m22 = _t0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code preRotateY}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateY} dispatcher.
     */
    private Double3x4 preRotateY_translation(double angle, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        d.m00 = _t0;
        d.m01 = 0.0;
        d.m02 = _t1;
        double _buf0 = Math.fma(this.m03, _t0, this.m23 * _t1);
        d.m10 = 0.0;
        d.m11 = 1.0;
        d.m12 = 0.0;
        d.m13 = this.m13;
        d.m20 = -_t1;
        d.m21 = 0.0;
        d.m22 = _t0;
        d.m23 = Math.fma(this.m23, _t0, -(this.m03 * _t1));
        d.m03 = _buf0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preRotateY}, specialized by runtime matrix
     * properties; reached only through the public {@code preRotateY} dispatcher.
     */
    private Double3x4 preRotateY_translation_self(double angle, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        d.m00 = _t0;
        d.m02 = _t1;
        double _buf0 = Math.fma(this.m03, _t0, this.m23 * _t1);
        d.m13 = this.m13;
        d.m20 = -_t1;
        d.m22 = _t0;
        d.m23 = Math.fma(this.m23, _t0, -(this.m03 * _t1));
        d.m03 = _buf0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Pre-multiply a rotation of {@code angle} radians about the Y axis onto this matrix and store
     * the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 preRotateY(double angle, @Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotateY_identity(angle, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotateY_translation(angle, dest);
        return preRotateY_orthogonal_general(angle, dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Pre-multiply a rotation of {@code angle} radians about the Y axis onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public Double3x4 preRotateY(double angle) {
        if (Joml.RETURN_NEW) return preRotateY(angle, Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotateY_identity_self(angle, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotateY_translation_self(angle, this);
        return preRotateY_orthogonal_general(angle, this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code preRotateZ}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateZ} dispatcher.
     */
    private Double3x4 preRotateZ_orthogonal_general(double angle, @Mutated Double3x4 dest, int _props) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _buf0 = Math.fma(this.m00, _t0, -(this.m10 * _t1));
        double _buf1 = Math.fma(this.m01, _t0, -(this.m11 * _t1));
        double _buf2 = Math.fma(this.m02, _t0, -(this.m12 * _t1));
        double _buf3 = Math.fma(this.m03, _t0, -(this.m13 * _t1));
        d.m10 = Math.fma(this.m00, _t1, this.m10 * _t0);
        d.m11 = Math.fma(this.m01, _t1, this.m11 * _t0);
        d.m12 = Math.fma(this.m02, _t1, this.m12 * _t0);
        d.m13 = Math.fma(this.m03, _t1, this.m13 * _t0);
        d.m20 = this.m20;
        d.m21 = this.m21;
        d.m22 = this.m22;
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.m03 = _buf3;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code preRotateZ}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateZ} dispatcher.
     */
    private Double3x4 preRotateZ_identity(double angle, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        d.m00 = _t0;
        d.m01 = -_t1;
        d.m02 = 0.0;
        d.m03 = 0.0;
        d.m10 = _t1;
        d.m11 = _t0;
        d.m12 = 0.0;
        d.m13 = 0.0;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 1.0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preRotateZ}, specialized by runtime matrix
     * properties; reached only through the public {@code preRotateZ} dispatcher.
     */
    private Double3x4 preRotateZ_identity_self(double angle, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        d.m00 = _t0;
        d.m01 = -_t1;
        d.m10 = _t1;
        d.m11 = _t0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code preRotateZ}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateZ} dispatcher.
     */
    private Double3x4 preRotateZ_translation(double angle, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        d.m00 = _t0;
        d.m01 = -_t1;
        d.m02 = 0.0;
        double _buf0 = Math.fma(this.m03, _t0, -(this.m13 * _t1));
        d.m10 = _t1;
        d.m11 = _t0;
        d.m12 = 0.0;
        d.m13 = Math.fma(this.m03, _t1, this.m13 * _t0);
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 1.0;
        d.m23 = this.m23;
        d.m03 = _buf0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preRotateZ}, specialized by runtime matrix
     * properties; reached only through the public {@code preRotateZ} dispatcher.
     */
    private Double3x4 preRotateZ_translation_self(double angle, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        d.m00 = _t0;
        d.m01 = -_t1;
        double _buf0 = Math.fma(this.m03, _t0, -(this.m13 * _t1));
        d.m10 = _t1;
        d.m11 = _t0;
        d.m13 = Math.fma(this.m03, _t1, this.m13 * _t0);
        d.m23 = this.m23;
        d.m03 = _buf0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Pre-multiply a rotation of {@code angle} radians about the Z axis onto this matrix and store
     * the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 preRotateZ(double angle, @Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotateZ_identity(angle, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotateZ_translation(angle, dest);
        return preRotateZ_orthogonal_general(angle, dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Pre-multiply a rotation of {@code angle} radians about the Z axis onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public Double3x4 preRotateZ(double angle) {
        if (Joml.RETURN_NEW) return preRotateZ(angle, Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotateZ_identity_self(angle, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotateZ_translation_self(angle, this);
        return preRotateZ_orthogonal_general(angle, this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Pre-multiply a scaling by {@code v} onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code p} with the new matrix by using
     * {@code S * M * p}, the scaling will be applied last.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 preScale(Double3R v, @Mutated Double3x4 dest) {
        return preScale(v.x(), v.y(), v.z(), dest);
    }


    /**
     * Pre-multiply a scaling by {@code v} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code p} with the new matrix by using
     * {@code S * M * p}, the scaling will be applied last.
     *
     * @param v the vector
     * @return this
     */
    public @Mutated Double3x4 preScale(Double3R v) {
        return preScale(v.x(), v.y(), v.z());
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Double3x4 preScale_identity(double vX, double vY, double vZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = vX;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = 0.0;
        d.m10 = 0.0;
        d.m11 = vY;
        d.m12 = 0.0;
        d.m13 = 0.0;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = vZ;
        d.m23 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preScale}, specialized by runtime matrix
     * properties; reached only through the public {@code preScale} dispatcher.
     */
    private Double3x4 preScale_identity_self(double vX, double vY, double vZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = vX;
        d.m11 = vY;
        d.m22 = vZ;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Double3x4 preScale_translation(double vX, double vY, double vZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = vX;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = this.m03 * vX;
        d.m10 = 0.0;
        d.m11 = vY;
        d.m12 = 0.0;
        d.m13 = this.m13 * vY;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = vZ;
        d.m23 = this.m23 * vZ;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preScale}, specialized by runtime matrix
     * properties; reached only through the public {@code preScale} dispatcher.
     */
    private Double3x4 preScale_translation_self(double vX, double vY, double vZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = vX;
        d.m03 = this.m03 * vX;
        d.m11 = vY;
        d.m13 = this.m13 * vY;
        d.m22 = vZ;
        d.m23 = this.m23 * vZ;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Double3x4 preScale_general(double vX, double vY, double vZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = this.m00 * vX;
        d.m01 = this.m01 * vX;
        d.m02 = this.m02 * vX;
        d.m03 = this.m03 * vX;
        d.m10 = this.m10 * vY;
        d.m11 = this.m11 * vY;
        d.m12 = this.m12 * vY;
        d.m13 = this.m13 * vY;
        d.m20 = this.m20 * vZ;
        d.m21 = this.m21 * vZ;
        d.m22 = this.m22 * vZ;
        d.m23 = this.m23 * vZ;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Pre-multiply a scaling by ({@code vX}, {@code vY}, {@code vZ}) onto this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 preScale(double vX, double vY, double vZ, @Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preScale_identity(vX, vY, vZ, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preScale_translation(vX, vY, vZ, dest);
        return preScale_general(vX, vY, vZ, dest);
    }


    /**
     * Pre-multiply a scaling by ({@code vX}, {@code vY}, {@code vZ}) onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @return this
     */
    @Mutated public Double3x4 preScale(double vX, double vY, double vZ) {
        if (Joml.RETURN_NEW) return preScale(vX, vY, vZ, Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preScale_identity_self(vX, vY, vZ, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preScale_translation_self(vX, vY, vZ, this);
        return preScale_general(vX, vY, vZ, this);
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Double3x4 preScale_identity(double s, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = s;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = 0.0;
        d.m10 = 0.0;
        d.m11 = s;
        d.m12 = 0.0;
        d.m13 = 0.0;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = s;
        d.m23 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preScale}, specialized by runtime matrix
     * properties; reached only through the public {@code preScale} dispatcher.
     */
    private Double3x4 preScale_identity_self(double s, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = s;
        d.m11 = s;
        d.m22 = s;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Double3x4 preScale_translation(double s, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = s;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = s * this.m03;
        d.m10 = 0.0;
        d.m11 = s;
        d.m12 = 0.0;
        d.m13 = s * this.m13;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = s;
        d.m23 = s * this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preScale}, specialized by runtime matrix
     * properties; reached only through the public {@code preScale} dispatcher.
     */
    private Double3x4 preScale_translation_self(double s, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = s;
        d.m03 = s * this.m03;
        d.m11 = s;
        d.m13 = s * this.m13;
        d.m22 = s;
        d.m23 = s * this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Double3x4 preScale_general(double s, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = s * this.m00;
        d.m01 = s * this.m01;
        d.m02 = s * this.m02;
        d.m03 = s * this.m03;
        d.m10 = s * this.m10;
        d.m11 = s * this.m11;
        d.m12 = s * this.m12;
        d.m13 = s * this.m13;
        d.m20 = s * this.m20;
        d.m21 = s * this.m21;
        d.m22 = s * this.m22;
        d.m23 = s * this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Pre-multiply a scaling by {@code s} onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param s the uniform scale factor
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 preScale(double s, @Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preScale_identity(s, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preScale_translation(s, dest);
        return preScale_general(s, dest);
    }


    /**
     * Pre-multiply a scaling by {@code s} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param s the uniform scale factor
     * @return this
     */
    @Mutated public Double3x4 preScale(double s) {
        if (Joml.RETURN_NEW) return preScale(s, Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preScale_identity_self(s, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preScale_translation_self(s, this);
        return preScale_general(s, this);
    }


    /**
     * Pre-multiply a scaling by {@code s} about the pivot point {@code pivot} onto this matrix and
     * store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param s the uniform scale factor
     * @param pivot the pivot point
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 preScaleAround(double s, Double3R pivot, @Mutated Double3x4 dest) {
        return preScaleAround(s, pivot.x(), pivot.y(), pivot.z(), dest);
    }


    /**
     * Pre-multiply a scaling by {@code s} about the pivot point {@code pivot} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param s the uniform scale factor
     * @param pivot the pivot point
     * @return this
     */
    public @Mutated Double3x4 preScaleAround(double s, Double3R pivot) {
        return preScaleAround(s, pivot.x(), pivot.y(), pivot.z());
    }


    /**
     * Private body of {@code preScaleAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preScaleAround} dispatcher.
     */
    private Double3x4 preScaleAround_identity(double s, double pivotX, double pivotY, double pivotZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = s;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = Math.fma(-s, pivotX, pivotX);
        d.m10 = 0.0;
        d.m11 = s;
        d.m12 = 0.0;
        d.m13 = Math.fma(-s, pivotY, pivotY);
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = s;
        d.m23 = Math.fma(-s, pivotZ, pivotZ);
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preScaleAround}, specialized by runtime matrix
     * properties; reached only through the public {@code preScaleAround} dispatcher.
     */
    private Double3x4 preScaleAround_identity_self(double s, double pivotX, double pivotY, double pivotZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = s;
        d.m03 = Math.fma(-s, pivotX, pivotX);
        d.m11 = s;
        d.m13 = Math.fma(-s, pivotY, pivotY);
        d.m22 = s;
        d.m23 = Math.fma(-s, pivotZ, pivotZ);
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code preScaleAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preScaleAround} dispatcher.
     */
    private Double3x4 preScaleAround_translation(double s, double pivotX, double pivotY, double pivotZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = s;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = Math.fma(-s, pivotX, Math.fma(s, this.m03, pivotX));
        d.m10 = 0.0;
        d.m11 = s;
        d.m12 = 0.0;
        d.m13 = Math.fma(-s, pivotY, Math.fma(s, this.m13, pivotY));
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = s;
        d.m23 = Math.fma(-s, pivotZ, Math.fma(s, this.m23, pivotZ));
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preScaleAround}, specialized by runtime matrix
     * properties; reached only through the public {@code preScaleAround} dispatcher.
     */
    private Double3x4 preScaleAround_translation_self(double s, double pivotX, double pivotY, double pivotZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = s;
        d.m03 = Math.fma(-s, pivotX, Math.fma(s, this.m03, pivotX));
        d.m11 = s;
        d.m13 = Math.fma(-s, pivotY, Math.fma(s, this.m13, pivotY));
        d.m22 = s;
        d.m23 = Math.fma(-s, pivotZ, Math.fma(s, this.m23, pivotZ));
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code preScaleAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preScaleAround} dispatcher.
     */
    private Double3x4 preScaleAround_general(double s, double pivotX, double pivotY, double pivotZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = s * this.m00;
        d.m01 = s * this.m01;
        d.m02 = s * this.m02;
        d.m03 = Math.fma(-s, pivotX, Math.fma(s, this.m03, pivotX));
        d.m10 = s * this.m10;
        d.m11 = s * this.m11;
        d.m12 = s * this.m12;
        d.m13 = Math.fma(-s, pivotY, Math.fma(s, this.m13, pivotY));
        d.m20 = s * this.m20;
        d.m21 = s * this.m21;
        d.m22 = s * this.m22;
        d.m23 = Math.fma(-s, pivotZ, Math.fma(s, this.m23, pivotZ));
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Pre-multiply a scaling by {@code s} about the pivot point ({@code pivotX}, {@code pivotY},
     * {@code pivotZ}) onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param s the uniform scale factor
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotZ the {@code z} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 preScaleAround(double s, double pivotX, double pivotY, double pivotZ, @Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preScaleAround_identity(s, pivotX, pivotY, pivotZ, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preScaleAround_translation(s, pivotX, pivotY, pivotZ, dest);
        return preScaleAround_general(s, pivotX, pivotY, pivotZ, dest);
    }


    /**
     * Pre-multiply a scaling by {@code s} about the pivot point ({@code pivotX}, {@code pivotY},
     * {@code pivotZ}) onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param s the uniform scale factor
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotZ the {@code z} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @return this
     */
    @Mutated public Double3x4 preScaleAround(double s, double pivotX, double pivotY, double pivotZ) {
        if (Joml.RETURN_NEW) return preScaleAround(s, pivotX, pivotY, pivotZ, Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preScaleAround_identity_self(s, pivotX, pivotY, pivotZ, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preScaleAround_translation_self(s, pivotX, pivotY, pivotZ, this);
        return preScaleAround_general(s, pivotX, pivotY, pivotZ, this);
    }


    /**
     * Pre-multiply a scaling by {@code s} about the pivot point {@code pivot} onto this matrix and
     * store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param s the scale factors
     * @param pivot the pivot point
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 preScaleAround(Double3R s, Double3R pivot, @Mutated Double3x4 dest) {
        return preScaleAround(s.x(), s.y(), s.z(), pivot.x(), pivot.y(), pivot.z(), dest);
    }


    /**
     * Pre-multiply a scaling by {@code s} about the pivot point {@code pivot} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param s the scale factors
     * @param pivot the pivot point
     * @return this
     */
    public @Mutated Double3x4 preScaleAround(Double3R s, Double3R pivot) {
        return preScaleAround(s.x(), s.y(), s.z(), pivot.x(), pivot.y(), pivot.z());
    }


    /**
     * Private body of {@code preScaleAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preScaleAround} dispatcher.
     */
    private Double3x4 preScaleAround_identity(double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = sX;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = Math.fma(-pivotX, sX, pivotX);
        d.m10 = 0.0;
        d.m11 = sY;
        d.m12 = 0.0;
        d.m13 = Math.fma(-pivotY, sY, pivotY);
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = sZ;
        d.m23 = Math.fma(-pivotZ, sZ, pivotZ);
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preScaleAround}, specialized by runtime matrix
     * properties; reached only through the public {@code preScaleAround} dispatcher.
     */
    private Double3x4 preScaleAround_identity_self(double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = sX;
        d.m03 = Math.fma(-pivotX, sX, pivotX);
        d.m11 = sY;
        d.m13 = Math.fma(-pivotY, sY, pivotY);
        d.m22 = sZ;
        d.m23 = Math.fma(-pivotZ, sZ, pivotZ);
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code preScaleAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preScaleAround} dispatcher.
     */
    private Double3x4 preScaleAround_translation(double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = sX;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = Math.fma(-pivotX, sX, Math.fma(sX, this.m03, pivotX));
        d.m10 = 0.0;
        d.m11 = sY;
        d.m12 = 0.0;
        d.m13 = Math.fma(-pivotY, sY, Math.fma(sY, this.m13, pivotY));
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = sZ;
        d.m23 = Math.fma(-pivotZ, sZ, Math.fma(sZ, this.m23, pivotZ));
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preScaleAround}, specialized by runtime matrix
     * properties; reached only through the public {@code preScaleAround} dispatcher.
     */
    private Double3x4 preScaleAround_translation_self(double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = sX;
        d.m03 = Math.fma(-pivotX, sX, Math.fma(sX, this.m03, pivotX));
        d.m11 = sY;
        d.m13 = Math.fma(-pivotY, sY, Math.fma(sY, this.m13, pivotY));
        d.m22 = sZ;
        d.m23 = Math.fma(-pivotZ, sZ, Math.fma(sZ, this.m23, pivotZ));
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code preScaleAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preScaleAround} dispatcher.
     */
    private Double3x4 preScaleAround_general(double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = sX * this.m00;
        d.m01 = sX * this.m01;
        d.m02 = sX * this.m02;
        d.m03 = Math.fma(-pivotX, sX, Math.fma(sX, this.m03, pivotX));
        d.m10 = sY * this.m10;
        d.m11 = sY * this.m11;
        d.m12 = sY * this.m12;
        d.m13 = Math.fma(-pivotY, sY, Math.fma(sY, this.m13, pivotY));
        d.m20 = sZ * this.m20;
        d.m21 = sZ * this.m21;
        d.m22 = sZ * this.m22;
        d.m23 = Math.fma(-pivotZ, sZ, Math.fma(sZ, this.m23, pivotZ));
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Pre-multiply a scaling by ({@code sX}, {@code sY}, {@code sZ}) about the pivot point
     * ({@code pivotX}, {@code pivotY}, {@code pivotZ}) onto this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param sX the {@code x} component of the vector {@code (sX, sY, sZ)}
     * @param sY the {@code y} component of the vector {@code (sX, sY, sZ)}
     * @param sZ the {@code z} component of the vector {@code (sX, sY, sZ)}
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotZ the {@code z} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 preScaleAround(double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ, @Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preScaleAround_identity(sX, sY, sZ, pivotX, pivotY, pivotZ, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preScaleAround_translation(sX, sY, sZ, pivotX, pivotY, pivotZ, dest);
        return preScaleAround_general(sX, sY, sZ, pivotX, pivotY, pivotZ, dest);
    }


    /**
     * Pre-multiply a scaling by ({@code sX}, {@code sY}, {@code sZ}) about the pivot point
     * ({@code pivotX}, {@code pivotY}, {@code pivotZ}) onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param sX the {@code x} component of the vector {@code (sX, sY, sZ)}
     * @param sY the {@code y} component of the vector {@code (sX, sY, sZ)}
     * @param sZ the {@code z} component of the vector {@code (sX, sY, sZ)}
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotZ the {@code z} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @return this
     */
    @Mutated public Double3x4 preScaleAround(double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ) {
        if (Joml.RETURN_NEW) return preScaleAround(sX, sY, sZ, pivotX, pivotY, pivotZ, Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preScaleAround_identity_self(sX, sY, sZ, pivotX, pivotY, pivotZ, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preScaleAround_translation_self(sX, sY, sZ, pivotX, pivotY, pivotZ, this);
        return preScaleAround_general(sX, sY, sZ, pivotX, pivotY, pivotZ, this);
    }


    /**
     * Pre-multiply a translation by {@code v} onto this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code T * M}. So when transforming a vector {@code p} with the new matrix by using
     * {@code T * M * p}, the translation will be applied last.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 preTranslate(Double3R v, @Mutated Double3x4 dest) {
        return preTranslate(v.x(), v.y(), v.z(), dest);
    }


    /**
     * Pre-multiply a translation by {@code v} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code T * M}. So when transforming a vector {@code p} with the new matrix by using
     * {@code T * M * p}, the translation will be applied last.
     *
     * @param v the vector
     * @return this
     */
    public @Mutated Double3x4 preTranslate(Double3R v) {
        return preTranslate(v.x(), v.y(), v.z());
    }


    /**
     * Private body of {@code preTranslate}, specialized by runtime matrix properties; reached only
     * through the public {@code preTranslate} dispatcher.
     */
    private Double3x4 preTranslate_identity(double vX, double vY, double vZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = vX;
        d.m10 = 0.0;
        d.m11 = 1.0;
        d.m12 = 0.0;
        d.m13 = vY;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 1.0;
        d.m23 = vZ;
        d.properties = Joml.BIT_TRANSLATION;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preTranslate}, specialized by runtime matrix
     * properties; reached only through the public {@code preTranslate} dispatcher.
     */
    private Double3x4 preTranslate_identity_self(double vX, double vY, double vZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m03 = vX;
        d.m13 = vY;
        d.m23 = vZ;
        d.properties = Joml.BIT_TRANSLATION;
        return d;
    }


    /**
     * Private body of {@code preTranslate}, specialized by runtime matrix properties; reached only
     * through the public {@code preTranslate} dispatcher.
     */
    private Double3x4 preTranslate_translation(double vX, double vY, double vZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = 1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = this.m03 + vX;
        d.m10 = 0.0;
        d.m11 = 1.0;
        d.m12 = 0.0;
        d.m13 = this.m13 + vY;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 1.0;
        d.m23 = this.m23 + vZ;
        d.properties = Joml.BIT_TRANSLATION;
        return d;
    }


    /**
     * Private in-place self-form body of {@code preTranslate}, specialized by runtime matrix
     * properties; reached only through the public {@code preTranslate} dispatcher.
     */
    private Double3x4 preTranslate_translation_self(double vX, double vY, double vZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m03 = this.m03 + vX;
        d.m13 = this.m13 + vY;
        d.m23 = this.m23 + vZ;
        d.properties = Joml.BIT_TRANSLATION;
        return d;
    }


    /**
     * Private body of {@code preTranslate}, specialized by runtime matrix properties; reached only
     * through the public {@code preTranslate} dispatcher.
     */
    private Double3x4 preTranslate_orthogonal(double vX, double vY, double vZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = this.m00;
        d.m01 = this.m01;
        d.m02 = this.m02;
        d.m03 = this.m03 + vX;
        d.m10 = this.m10;
        d.m11 = this.m11;
        d.m12 = this.m12;
        d.m13 = this.m13 + vY;
        d.m20 = this.m20;
        d.m21 = this.m21;
        d.m22 = this.m22;
        d.m23 = this.m23 + vZ;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code preTranslate}, specialized by runtime matrix properties; reached only
     * through the public {@code preTranslate} dispatcher.
     */
    private Double3x4 preTranslate_general(double vX, double vY, double vZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = this.m00;
        d.m01 = this.m01;
        d.m02 = this.m02;
        d.m03 = this.m03 + vX;
        d.m10 = this.m10;
        d.m11 = this.m11;
        d.m12 = this.m12;
        d.m13 = this.m13 + vY;
        d.m20 = this.m20;
        d.m21 = this.m21;
        d.m22 = this.m22;
        d.m23 = this.m23 + vZ;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Pre-multiply a translation by ({@code vX}, {@code vY}, {@code vZ}) onto this matrix and store
     * the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code T * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code T * M * v}, the translation will be applied last.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 preTranslate(double vX, double vY, double vZ, @Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preTranslate_identity(vX, vY, vZ, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preTranslate_translation(vX, vY, vZ, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preTranslate_orthogonal(vX, vY, vZ, dest);
        return preTranslate_general(vX, vY, vZ, dest);
    }


    /**
     * Pre-multiply a translation by ({@code vX}, {@code vY}, {@code vZ}) onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code T * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code T * M * v}, the translation will be applied last.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @return this
     */
    @Mutated public Double3x4 preTranslate(double vX, double vY, double vZ) {
        if (Joml.RETURN_NEW) return preTranslate(vX, vY, vZ, Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preTranslate_identity_self(vX, vY, vZ, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preTranslate_translation_self(vX, vY, vZ, this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preTranslate_orthogonal(vX, vY, vZ, this);
        return preTranslate_general(vX, vY, vZ, this);
    }


    /**
     * Apply a reflection about the plane through the origin with the normal {@code normal} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the reflection matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the reflection will be applied first.
     *
     * @param normal the normal (must be a unit vector)
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 reflect(Double3R normal, @Mutated Double3x4 dest) {
        return reflect(normal.x(), normal.y(), normal.z(), dest);
    }


    /**
     * Apply a reflection about the plane through the origin with the normal {@code normal} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the reflection matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the reflection will be applied first.
     *
     * @param normal the normal (must be a unit vector)
     * @return this
     */
    public @Mutated Double3x4 reflect(Double3R normal) {
        return reflect(normal.x(), normal.y(), normal.z());
    }


    /**
     * Private body of {@code reflect}, specialized by runtime matrix properties; reached only
     * through the public {@code reflect} dispatcher.
     */
    private Double3x4 reflect_identity(double normalX, double normalY, double normalZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t6 = -(2.0 * normalX * normalY);
        double _t7 = -(2.0 * normalX * normalZ);
        double _t8 = -(2.0 * normalY * normalZ);
        d.m00 = Math.fma(-2.0, normalX * normalX, 1.0);
        d.m01 = _t6;
        d.m02 = _t7;
        d.m03 = 0.0;
        d.m10 = _t6;
        d.m11 = Math.fma(-2.0, normalY * normalY, 1.0);
        d.m12 = _t8;
        d.m13 = 0.0;
        d.m20 = _t7;
        d.m21 = _t8;
        d.m22 = Math.fma(-2.0, normalZ * normalZ, 1.0);
        d.m23 = 0.0;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code reflect}, specialized by runtime matrix properties;
     * reached only through the public {@code reflect} dispatcher.
     */
    private Double3x4 reflect_identity_self(double normalX, double normalY, double normalZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t6 = -(2.0 * normalX * normalY);
        double _t7 = -(2.0 * normalX * normalZ);
        double _t8 = -(2.0 * normalY * normalZ);
        d.m00 = Math.fma(-2.0, normalX * normalX, 1.0);
        d.m01 = _t6;
        d.m02 = _t7;
        d.m10 = _t6;
        d.m11 = Math.fma(-2.0, normalY * normalY, 1.0);
        d.m12 = _t8;
        d.m20 = _t7;
        d.m21 = _t8;
        d.m22 = Math.fma(-2.0, normalZ * normalZ, 1.0);
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code reflect}, specialized by runtime matrix properties; reached only
     * through the public {@code reflect} dispatcher.
     */
    private Double3x4 reflect_translation(double normalX, double normalY, double normalZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t6 = -(2.0 * normalX * normalY);
        double _t7 = -(2.0 * normalX * normalZ);
        double _t8 = -(2.0 * normalY * normalZ);
        d.m00 = Math.fma(-2.0, normalX * normalX, 1.0);
        d.m01 = _t6;
        d.m02 = _t7;
        d.m03 = this.m03;
        d.m10 = _t6;
        d.m11 = Math.fma(-2.0, normalY * normalY, 1.0);
        d.m12 = _t8;
        d.m13 = this.m13;
        d.m20 = _t7;
        d.m21 = _t8;
        d.m22 = Math.fma(-2.0, normalZ * normalZ, 1.0);
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code reflect}, specialized by runtime matrix properties; reached only
     * through the public {@code reflect} dispatcher.
     */
    private Double3x4 reflect_orthogonal(double normalX, double normalY, double normalZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = -this.m02;
        double _t1 = -this.m12;
        double _t2 = -this.m22;
        double _t9 = 2.0 * normalX * normalZ;
        double _t10 = 2.0 * normalX * normalY;
        double _t11 = 2.0 * normalY * normalZ;
        double _t12 = Math.fma(-2.0, normalX * normalX, 1.0);
        double _t13 = Math.fma(-2.0, normalY * normalY, 1.0);
        double _t14 = Math.fma(-2.0, normalZ * normalZ, 1.0);
        double _buf0 = Math.fma(_t0, _t9, Math.fma(this.m00, _t12, -(this.m01 * _t10)));
        double _buf1 = Math.fma(_t0, _t11, Math.fma(this.m01, _t13, -(this.m00 * _t10)));
        d.m02 = Math.fma(this.m02, _t14, Math.fma(-this.m01, _t11, -(this.m00 * _t9)));
        d.m03 = this.m03;
        double _buf2 = Math.fma(_t1, _t9, Math.fma(this.m10, _t12, -(this.m11 * _t10)));
        double _buf3 = Math.fma(_t1, _t11, Math.fma(this.m11, _t13, -(this.m10 * _t10)));
        d.m12 = Math.fma(this.m12, _t14, Math.fma(-this.m11, _t11, -(this.m10 * _t9)));
        d.m13 = this.m13;
        double _buf4 = Math.fma(_t2, _t9, Math.fma(this.m20, _t12, -(this.m21 * _t10)));
        double _buf5 = Math.fma(_t2, _t11, Math.fma(this.m21, _t13, -(this.m20 * _t10)));
        d.m22 = Math.fma(this.m22, _t14, Math.fma(-this.m21, _t11, -(this.m20 * _t9)));
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m10 = _buf2;
        d.m11 = _buf3;
        d.m20 = _buf4;
        d.m21 = _buf5;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code reflect}, specialized by runtime matrix properties; reached only
     * through the public {@code reflect} dispatcher.
     */
    private Double3x4 reflect_general(double normalX, double normalY, double normalZ, @Mutated Double3x4 dest) {
        return reflect_orthogonal(normalX, normalY, normalZ, dest);
    }


    /**
     * Apply a reflection about the plane through the origin with the normal ({@code normalX},
     * {@code normalY}, {@code normalZ}) to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the reflection matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the reflection will be applied first.
     *
     * @param normalX the {@code x} component of the vector {@code (normalX, normalY, normalZ)} (the
     *        vector must have unit length)
     * @param normalY the {@code y} component of the vector {@code (normalX, normalY, normalZ)} (the
     *        vector must have unit length)
     * @param normalZ the {@code z} component of the vector {@code (normalX, normalY, normalZ)} (the
     *        vector must have unit length)
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 reflect(double normalX, double normalY, double normalZ, @Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return reflect_identity(normalX, normalY, normalZ, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return reflect_translation(normalX, normalY, normalZ, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return reflect_orthogonal(normalX, normalY, normalZ, dest);
        return reflect_general(normalX, normalY, normalZ, dest);
    }


    /**
     * Apply a reflection about the plane through the origin with the normal ({@code normalX},
     * {@code normalY}, {@code normalZ}) to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the reflection matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the reflection will be applied first.
     *
     * @param normalX the {@code x} component of the vector {@code (normalX, normalY, normalZ)} (the
     *        vector must have unit length)
     * @param normalY the {@code y} component of the vector {@code (normalX, normalY, normalZ)} (the
     *        vector must have unit length)
     * @param normalZ the {@code z} component of the vector {@code (normalX, normalY, normalZ)} (the
     *        vector must have unit length)
     * @return this
     */
    @Mutated public Double3x4 reflect(double normalX, double normalY, double normalZ) {
        if (Joml.RETURN_NEW) return reflect(normalX, normalY, normalZ, Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return reflect_identity_self(normalX, normalY, normalZ, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return reflect_translation(normalX, normalY, normalZ, this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return reflect_orthogonal(normalX, normalY, normalZ, this);
        return reflect_general(normalX, normalY, normalZ, this);
    }


    /**
     * Apply the rotation {@code rot} about the pivot point {@code pivot} to this matrix and store
     * the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param rot the quaternion (must be a unit quaternion)
     * @param pivot the pivot point
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 rotateAround(DoubleQuatR rot, Double3R pivot, @Mutated Double3x4 dest) {
        return rotateAround(rot.x(), rot.y(), rot.z(), rot.w(), pivot.x(), pivot.y(), pivot.z(), dest);
    }


    /**
     * Apply the rotation {@code rot} about the pivot point {@code pivot} to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param rot the quaternion (must be a unit quaternion)
     * @param pivot the pivot point
     * @return this
     */
    public @Mutated Double3x4 rotateAround(DoubleQuatR rot, Double3R pivot) {
        return rotateAround(rot.x(), rot.y(), rot.z(), rot.w(), pivot.x(), pivot.y(), pivot.z());
    }


    /**
     * Private body of {@code rotateAround}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAround} dispatcher.
     */
    private Double3x4 rotateAround_identity(double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ, @Mutated Double3x4 dest) {
        return preRotateAround_identity(rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ, dest);
    }


    /**
     * Private body of {@code rotateAround}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAround} dispatcher.
     */
    private Double3x4 rotateAround_translation(double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = -pivotX;
        double _t1 = -pivotY;
        double _t2 = -pivotZ;
        double _t3 = rotZ * rotZ;
        double _t4 = rotZ * rotW;
        double _t5 = rotY * rotW;
        double _t21 = 2.0 * Math.fma(rotX, rotZ, _t5);
        double _t22 = 2.0 * Math.fma(rotX, rotY, _t4);
        double _t23 = 2.0 * Math.fma(rotX, rotW, rotY * rotZ);
        double _t24 = 2.0 * Math.fma(rotX, rotY, -_t4);
        double _t25 = 2.0 * Math.fma(rotY, rotZ, -(rotX * rotW));
        double _t26 = 2.0 * Math.fma(rotX, rotZ, -_t5);
        double _t27 = Math.fma(-2.0, Math.fma(rotY, rotY, _t3), 1.0);
        double _t28 = Math.fma(-2.0, Math.fma(rotX, rotX, _t3), 1.0);
        double _t29 = Math.fma(-2.0, Math.fma(rotX, rotX, rotY * rotY), 1.0);
        d.m00 = _t27;
        d.m01 = _t24;
        d.m02 = _t21;
        d.m03 = Math.fma(_t0, _t27, Math.fma(_t1, _t24, Math.fma(_t2, _t21, this.m03 + pivotX)));
        d.m10 = _t22;
        d.m11 = _t28;
        d.m12 = _t25;
        d.m13 = Math.fma(_t0, _t22, Math.fma(_t1, _t28, Math.fma(_t2, _t25, this.m13 + pivotY)));
        d.m20 = _t26;
        d.m21 = _t23;
        d.m22 = _t29;
        d.m23 = Math.fma(_t0, _t26, Math.fma(_t1, _t23, Math.fma(_t2, _t29, this.m23 + pivotZ)));
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code rotateAround}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAround} dispatcher.
     */
    private Double3x4 rotateAround_orthogonal(double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
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
        double _buf0 = Math.fma(this.m02, _t24, Math.fma(this.m00, _t27, this.m01 * _t21));
        double _buf1 = Math.fma(this.m02, _t22, Math.fma(this.m00, _t25, this.m01 * _t28));
        double _buf2 = Math.fma(this.m02, _t29, Math.fma(this.m00, _t23, this.m01 * _t26));
        d.m03 = Math.fma(this.m00, _t36, Math.fma(this.m01, _t37, Math.fma(this.m02, _t38, this.m03)));
        double _buf3 = Math.fma(this.m12, _t24, Math.fma(this.m10, _t27, this.m11 * _t21));
        double _buf4 = Math.fma(this.m12, _t22, Math.fma(this.m10, _t25, this.m11 * _t28));
        double _buf5 = Math.fma(this.m12, _t29, Math.fma(this.m10, _t23, this.m11 * _t26));
        d.m13 = Math.fma(this.m10, _t36, Math.fma(this.m11, _t37, Math.fma(this.m12, _t38, this.m13)));
        double _buf6 = Math.fma(this.m22, _t24, Math.fma(this.m20, _t27, this.m21 * _t21));
        double _buf7 = Math.fma(this.m22, _t22, Math.fma(this.m20, _t25, this.m21 * _t28));
        double _buf8 = Math.fma(this.m22, _t29, Math.fma(this.m20, _t23, this.m21 * _t26));
        d.m23 = Math.fma(this.m20, _t36, Math.fma(this.m21, _t37, Math.fma(this.m22, _t38, this.m23)));
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.m10 = _buf3;
        d.m11 = _buf4;
        d.m12 = _buf5;
        d.m20 = _buf6;
        d.m21 = _buf7;
        d.m22 = _buf8;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code rotateAround}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAround} dispatcher.
     */
    private Double3x4 rotateAround_general(double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
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
        double _buf0 = Math.fma(this.m02, _t24, Math.fma(this.m00, _t27, this.m01 * _t21));
        double _buf1 = Math.fma(this.m02, _t22, Math.fma(this.m00, _t25, this.m01 * _t28));
        double _buf2 = Math.fma(this.m02, _t29, Math.fma(this.m00, _t23, this.m01 * _t26));
        d.m03 = Math.fma(this.m00, _t36, Math.fma(this.m01, _t37, Math.fma(this.m02, _t38, this.m03)));
        double _buf3 = Math.fma(this.m12, _t24, Math.fma(this.m10, _t27, this.m11 * _t21));
        double _buf4 = Math.fma(this.m12, _t22, Math.fma(this.m10, _t25, this.m11 * _t28));
        double _buf5 = Math.fma(this.m12, _t29, Math.fma(this.m10, _t23, this.m11 * _t26));
        d.m13 = Math.fma(this.m10, _t36, Math.fma(this.m11, _t37, Math.fma(this.m12, _t38, this.m13)));
        double _buf6 = Math.fma(this.m22, _t24, Math.fma(this.m20, _t27, this.m21 * _t21));
        double _buf7 = Math.fma(this.m22, _t22, Math.fma(this.m20, _t25, this.m21 * _t28));
        double _buf8 = Math.fma(this.m22, _t29, Math.fma(this.m20, _t23, this.m21 * _t26));
        d.m23 = Math.fma(this.m20, _t36, Math.fma(this.m21, _t37, Math.fma(this.m22, _t38, this.m23)));
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.m10 = _buf3;
        d.m11 = _buf4;
        d.m12 = _buf5;
        d.m20 = _buf6;
        d.m21 = _buf7;
        d.m22 = _buf8;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Apply the rotation ({@code rotX}, {@code rotY}, {@code rotZ}, {@code rotW}) about the pivot
     * point ({@code pivotX}, {@code pivotY}, {@code pivotZ}) to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param rotX the {@code x} component of the quaternion {@code (rotX, rotY, rotZ, rotW)} (the
     *        quaternion must have unit length)
     * @param rotY the {@code y} component of the quaternion {@code (rotX, rotY, rotZ, rotW)} (the
     *        quaternion must have unit length)
     * @param rotZ the {@code z} component of the quaternion {@code (rotX, rotY, rotZ, rotW)} (the
     *        quaternion must have unit length)
     * @param rotW the {@code w} component of the quaternion {@code (rotX, rotY, rotZ, rotW)} (the
     *        quaternion must have unit length)
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotZ the {@code z} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 rotateAround(double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ, @Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateAround_identity(rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateAround_translation(rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateAround_orthogonal(rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ, dest);
        return rotateAround_general(rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ, dest);
    }


    /**
     * Apply the rotation ({@code rotX}, {@code rotY}, {@code rotZ}, {@code rotW}) about the pivot
     * point ({@code pivotX}, {@code pivotY}, {@code pivotZ}) to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param rotX the {@code x} component of the quaternion {@code (rotX, rotY, rotZ, rotW)} (the
     *        quaternion must have unit length)
     * @param rotY the {@code y} component of the quaternion {@code (rotX, rotY, rotZ, rotW)} (the
     *        quaternion must have unit length)
     * @param rotZ the {@code z} component of the quaternion {@code (rotX, rotY, rotZ, rotW)} (the
     *        quaternion must have unit length)
     * @param rotW the {@code w} component of the quaternion {@code (rotX, rotY, rotZ, rotW)} (the
     *        quaternion must have unit length)
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotZ the {@code z} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @return this
     */
    @Mutated public Double3x4 rotateAround(double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ) {
        if (Joml.RETURN_NEW) return rotateAround(rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ, Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateAround_identity(rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateAround_translation(rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ, this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateAround_orthogonal(rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ, this);
        return rotateAround_general(rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ, this);
    }


    /**
     * Apply a rotation of {@code angle} radians about the axis {@code axis} to this matrix and
     * store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 rotateAxis(double angle, Double3R axis, @Mutated Double3x4 dest) {
        return rotateAxis(angle, axis.x(), axis.y(), axis.z(), dest);
    }


    /**
     * Apply a rotation of {@code angle} radians about the axis {@code axis} to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @return this
     */
    public @Mutated Double3x4 rotateAxis(double angle, Double3R axis) {
        return rotateAxis(angle, axis.x(), axis.y(), axis.z());
    }


    /**
     * Private body of {@code rotateAxis}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAxis} dispatcher.
     */
    private Double3x4 rotateAxis_identity(double angle, double axisX, double axisY, double axisZ, @Mutated Double3x4 dest) {
        return preRotateAxis_identity(angle, axisX, axisY, axisZ, dest);
    }


    /**
     * Private in-place self-form body of {@code rotateAxis}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateAxis} dispatcher.
     */
    private Double3x4 rotateAxis_identity_self(double angle, double axisX, double axisY, double axisZ, @Mutated Double3x4 dest) {
        return preRotateAxis_identity_self(angle, axisX, axisY, axisZ, dest);
    }


    /**
     * Private body of {@code rotateAxis}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAxis} dispatcher.
     */
    private Double3x4 rotateAxis_translation(double angle, double axisX, double axisY, double axisZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t2 = 1.0 - _t0;
        double _t3 = axisX * axisY;
        double _t4 = axisX * axisZ;
        double _t5 = axisY * axisZ;
        d.m00 = Math.fma(_t2, axisX * axisX, _t0);
        d.m01 = Math.fma(_t2, _t3, -(axisZ * _t1));
        d.m02 = Math.fma(axisY, _t1, _t2 * _t4);
        d.m03 = this.m03;
        d.m10 = Math.fma(axisZ, _t1, _t2 * _t3);
        d.m11 = Math.fma(_t2, axisY * axisY, _t0);
        d.m12 = Math.fma(_t2, _t5, -(axisX * _t1));
        d.m13 = this.m13;
        d.m20 = Math.fma(_t2, _t4, -(axisY * _t1));
        d.m21 = Math.fma(axisX, _t1, _t2 * _t5);
        d.m22 = Math.fma(_t2, axisZ * axisZ, _t0);
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code rotateAxis}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAxis} dispatcher.
     */
    private Double3x4 rotateAxis_orthogonal(double angle, double axisX, double axisY, double axisZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t2 = 1.0 - _t0;
        double _t3 = axisX * axisZ;
        double _t6 = axisX * axisY;
        double _t7 = axisY * axisZ;
        double _t18 = Math.fma(_t2, axisX * axisX, _t0);
        double _t19 = Math.fma(_t2, axisY * axisY, _t0);
        double _t20 = Math.fma(_t2, axisZ * axisZ, _t0);
        double _t21 = Math.fma(axisZ, _t1, _t2 * _t6);
        double _t22 = Math.fma(axisX, _t1, _t2 * _t7);
        double _t23 = Math.fma(axisY, _t1, _t2 * _t3);
        double _t24 = Math.fma(_t2, _t3, -(axisY * _t1));
        double _t25 = Math.fma(_t2, _t6, -(axisZ * _t1));
        double _t26 = Math.fma(_t2, _t7, -(axisX * _t1));
        double _buf0 = Math.fma(this.m02, _t24, Math.fma(this.m00, _t18, this.m01 * _t21));
        double _buf1 = Math.fma(this.m02, _t22, Math.fma(this.m00, _t25, this.m01 * _t19));
        d.m02 = Math.fma(this.m02, _t20, Math.fma(this.m00, _t23, this.m01 * _t26));
        d.m03 = this.m03;
        double _buf2 = Math.fma(this.m12, _t24, Math.fma(this.m10, _t18, this.m11 * _t21));
        double _buf3 = Math.fma(this.m12, _t22, Math.fma(this.m10, _t25, this.m11 * _t19));
        d.m12 = Math.fma(this.m12, _t20, Math.fma(this.m10, _t23, this.m11 * _t26));
        d.m13 = this.m13;
        double _buf4 = Math.fma(this.m22, _t24, Math.fma(this.m20, _t18, this.m21 * _t21));
        double _buf5 = Math.fma(this.m22, _t22, Math.fma(this.m20, _t25, this.m21 * _t19));
        d.m22 = Math.fma(this.m22, _t20, Math.fma(this.m20, _t23, this.m21 * _t26));
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m10 = _buf2;
        d.m11 = _buf3;
        d.m20 = _buf4;
        d.m21 = _buf5;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code rotateAxis}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAxis} dispatcher.
     */
    private Double3x4 rotateAxis_general(double angle, double axisX, double axisY, double axisZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t2 = 1.0 - _t0;
        double _t3 = axisX * axisZ;
        double _t6 = axisX * axisY;
        double _t7 = axisY * axisZ;
        double _t18 = Math.fma(_t2, axisX * axisX, _t0);
        double _t19 = Math.fma(_t2, axisY * axisY, _t0);
        double _t20 = Math.fma(_t2, axisZ * axisZ, _t0);
        double _t21 = Math.fma(axisZ, _t1, _t2 * _t6);
        double _t22 = Math.fma(axisX, _t1, _t2 * _t7);
        double _t23 = Math.fma(axisY, _t1, _t2 * _t3);
        double _t24 = Math.fma(_t2, _t3, -(axisY * _t1));
        double _t25 = Math.fma(_t2, _t6, -(axisZ * _t1));
        double _t26 = Math.fma(_t2, _t7, -(axisX * _t1));
        double _buf0 = Math.fma(this.m02, _t24, Math.fma(this.m00, _t18, this.m01 * _t21));
        double _buf1 = Math.fma(this.m02, _t22, Math.fma(this.m00, _t25, this.m01 * _t19));
        d.m02 = Math.fma(this.m02, _t20, Math.fma(this.m00, _t23, this.m01 * _t26));
        d.m03 = this.m03;
        double _buf2 = Math.fma(this.m12, _t24, Math.fma(this.m10, _t18, this.m11 * _t21));
        double _buf3 = Math.fma(this.m12, _t22, Math.fma(this.m10, _t25, this.m11 * _t19));
        d.m12 = Math.fma(this.m12, _t20, Math.fma(this.m10, _t23, this.m11 * _t26));
        d.m13 = this.m13;
        double _buf4 = Math.fma(this.m22, _t24, Math.fma(this.m20, _t18, this.m21 * _t21));
        double _buf5 = Math.fma(this.m22, _t22, Math.fma(this.m20, _t25, this.m21 * _t19));
        d.m22 = Math.fma(this.m22, _t20, Math.fma(this.m20, _t23, this.m21 * _t26));
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m10 = _buf2;
        d.m11 = _buf3;
        d.m20 = _buf4;
        d.m21 = _buf5;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Apply a rotation of {@code angle} radians about the axis ({@code axisX}, {@code axisY},
     * {@code axisZ}) to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param axisX the {@code x} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisY the {@code y} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisZ the {@code z} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 rotateAxis(double angle, double axisX, double axisY, double axisZ, @Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateAxis_identity(angle, axisX, axisY, axisZ, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateAxis_translation(angle, axisX, axisY, axisZ, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateAxis_orthogonal(angle, axisX, axisY, axisZ, dest);
        return rotateAxis_general(angle, axisX, axisY, axisZ, dest);
    }


    /**
     * Apply a rotation of {@code angle} radians about the axis ({@code axisX}, {@code axisY},
     * {@code axisZ}) to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param axisX the {@code x} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisY the {@code y} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisZ the {@code z} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @return this
     */
    @Mutated public Double3x4 rotateAxis(double angle, double axisX, double axisY, double axisZ) {
        if (Joml.RETURN_NEW) return rotateAxis(angle, axisX, axisY, axisZ, Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateAxis_identity_self(angle, axisX, axisY, axisZ, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateAxis_translation(angle, axisX, axisY, axisZ, this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateAxis_orthogonal(angle, axisX, axisY, axisZ, this);
        return rotateAxis_general(angle, axisX, axisY, axisZ, this);
    }


    /**
     * Apply the rotation represented by the quaternion {@code q} to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param q the quaternion (must be a unit quaternion)
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 rotateQuat(DoubleQuatR q, @Mutated Double3x4 dest) {
        return rotateQuat(q.x(), q.y(), q.z(), q.w(), dest);
    }


    /**
     * Apply the rotation represented by the quaternion {@code q} to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param q the quaternion (must be a unit quaternion)
     * @return this
     */
    public @Mutated Double3x4 rotateQuat(DoubleQuatR q) {
        return rotateQuat(q.x(), q.y(), q.z(), q.w());
    }


    /**
     * Private body of {@code rotateQuat}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateQuat} dispatcher.
     */
    private Double3x4 rotateQuat_identity(double qX, double qY, double qZ, double qW, @Mutated Double3x4 dest) {
        return preRotateQuat_identity(qX, qY, qZ, qW, dest);
    }


    /**
     * Private in-place self-form body of {@code rotateQuat}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateQuat} dispatcher.
     */
    private Double3x4 rotateQuat_identity_self(double qX, double qY, double qZ, double qW, @Mutated Double3x4 dest) {
        return preRotateQuat_identity_self(qX, qY, qZ, qW, dest);
    }


    /**
     * Private body of {@code rotateQuat}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateQuat} dispatcher.
     */
    private Double3x4 rotateQuat_translation(double qX, double qY, double qZ, double qW, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = qZ * qZ;
        double _t1 = qZ * qW;
        double _t2 = qY * qW;
        d.m00 = Math.fma(-2.0, Math.fma(qY, qY, _t0), 1.0);
        d.m01 = 2.0 * Math.fma(qX, qY, -_t1);
        d.m02 = 2.0 * Math.fma(qX, qZ, _t2);
        d.m03 = this.m03;
        d.m10 = 2.0 * Math.fma(qX, qY, _t1);
        d.m11 = Math.fma(-2.0, Math.fma(qX, qX, _t0), 1.0);
        d.m12 = 2.0 * Math.fma(qY, qZ, -(qX * qW));
        d.m13 = this.m13;
        d.m20 = 2.0 * Math.fma(qX, qZ, -_t2);
        d.m21 = 2.0 * Math.fma(qX, qW, qY * qZ);
        d.m22 = Math.fma(-2.0, Math.fma(qX, qX, qY * qY), 1.0);
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code rotateQuat}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateQuat} dispatcher.
     */
    private Double3x4 rotateQuat_orthogonal(double qX, double qY, double qZ, double qW, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = qY * qW;
        double _t1 = qZ * qZ;
        double _t2 = qZ * qW;
        double _t18 = 2.0 * Math.fma(qX, qY, _t2);
        double _t19 = 2.0 * Math.fma(qX, qW, qY * qZ);
        double _t20 = 2.0 * Math.fma(qX, qZ, _t0);
        double _t21 = 2.0 * Math.fma(qX, qZ, -_t0);
        double _t22 = 2.0 * Math.fma(qX, qY, -_t2);
        double _t23 = 2.0 * Math.fma(qY, qZ, -(qX * qW));
        double _t24 = Math.fma(-2.0, Math.fma(qY, qY, _t1), 1.0);
        double _t25 = Math.fma(-2.0, Math.fma(qX, qX, _t1), 1.0);
        double _t26 = Math.fma(-2.0, Math.fma(qX, qX, qY * qY), 1.0);
        double _buf0 = Math.fma(this.m02, _t21, Math.fma(this.m00, _t24, this.m01 * _t18));
        double _buf1 = Math.fma(this.m02, _t19, Math.fma(this.m00, _t22, this.m01 * _t25));
        d.m02 = Math.fma(this.m02, _t26, Math.fma(this.m00, _t20, this.m01 * _t23));
        d.m03 = this.m03;
        double _buf2 = Math.fma(this.m12, _t21, Math.fma(this.m10, _t24, this.m11 * _t18));
        double _buf3 = Math.fma(this.m12, _t19, Math.fma(this.m10, _t22, this.m11 * _t25));
        d.m12 = Math.fma(this.m12, _t26, Math.fma(this.m10, _t20, this.m11 * _t23));
        d.m13 = this.m13;
        double _buf4 = Math.fma(this.m22, _t21, Math.fma(this.m20, _t24, this.m21 * _t18));
        double _buf5 = Math.fma(this.m22, _t19, Math.fma(this.m20, _t22, this.m21 * _t25));
        d.m22 = Math.fma(this.m22, _t26, Math.fma(this.m20, _t20, this.m21 * _t23));
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m10 = _buf2;
        d.m11 = _buf3;
        d.m20 = _buf4;
        d.m21 = _buf5;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code rotateQuat}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateQuat} dispatcher.
     */
    private Double3x4 rotateQuat_general(double qX, double qY, double qZ, double qW, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = qY * qW;
        double _t1 = qZ * qZ;
        double _t2 = qZ * qW;
        double _t18 = 2.0 * Math.fma(qX, qY, _t2);
        double _t19 = 2.0 * Math.fma(qX, qW, qY * qZ);
        double _t20 = 2.0 * Math.fma(qX, qZ, _t0);
        double _t21 = 2.0 * Math.fma(qX, qZ, -_t0);
        double _t22 = 2.0 * Math.fma(qX, qY, -_t2);
        double _t23 = 2.0 * Math.fma(qY, qZ, -(qX * qW));
        double _t24 = Math.fma(-2.0, Math.fma(qY, qY, _t1), 1.0);
        double _t25 = Math.fma(-2.0, Math.fma(qX, qX, _t1), 1.0);
        double _t26 = Math.fma(-2.0, Math.fma(qX, qX, qY * qY), 1.0);
        double _buf0 = Math.fma(this.m02, _t21, Math.fma(this.m00, _t24, this.m01 * _t18));
        double _buf1 = Math.fma(this.m02, _t19, Math.fma(this.m00, _t22, this.m01 * _t25));
        d.m02 = Math.fma(this.m02, _t26, Math.fma(this.m00, _t20, this.m01 * _t23));
        d.m03 = this.m03;
        double _buf2 = Math.fma(this.m12, _t21, Math.fma(this.m10, _t24, this.m11 * _t18));
        double _buf3 = Math.fma(this.m12, _t19, Math.fma(this.m10, _t22, this.m11 * _t25));
        d.m12 = Math.fma(this.m12, _t26, Math.fma(this.m10, _t20, this.m11 * _t23));
        d.m13 = this.m13;
        double _buf4 = Math.fma(this.m22, _t21, Math.fma(this.m20, _t24, this.m21 * _t18));
        double _buf5 = Math.fma(this.m22, _t19, Math.fma(this.m20, _t22, this.m21 * _t25));
        d.m22 = Math.fma(this.m22, _t26, Math.fma(this.m20, _t20, this.m21 * _t23));
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m10 = _buf2;
        d.m11 = _buf3;
        d.m20 = _buf4;
        d.m21 = _buf5;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Apply the rotation represented by the quaternion ({@code qX}, {@code qY}, {@code qZ},
     * {@code qW}) to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param qX the {@code x} component of the quaternion {@code (qX, qY, qZ, qW)} (the quaternion
     *        must have unit length)
     * @param qY the {@code y} component of the quaternion {@code (qX, qY, qZ, qW)} (the quaternion
     *        must have unit length)
     * @param qZ the {@code z} component of the quaternion {@code (qX, qY, qZ, qW)} (the quaternion
     *        must have unit length)
     * @param qW the {@code w} component of the quaternion {@code (qX, qY, qZ, qW)} (the quaternion
     *        must have unit length)
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 rotateQuat(double qX, double qY, double qZ, double qW, @Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateQuat_identity(qX, qY, qZ, qW, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateQuat_translation(qX, qY, qZ, qW, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateQuat_orthogonal(qX, qY, qZ, qW, dest);
        return rotateQuat_general(qX, qY, qZ, qW, dest);
    }


    /**
     * Apply the rotation represented by the quaternion ({@code qX}, {@code qY}, {@code qZ},
     * {@code qW}) to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param qX the {@code x} component of the quaternion {@code (qX, qY, qZ, qW)} (the quaternion
     *        must have unit length)
     * @param qY the {@code y} component of the quaternion {@code (qX, qY, qZ, qW)} (the quaternion
     *        must have unit length)
     * @param qZ the {@code z} component of the quaternion {@code (qX, qY, qZ, qW)} (the quaternion
     *        must have unit length)
     * @param qW the {@code w} component of the quaternion {@code (qX, qY, qZ, qW)} (the quaternion
     *        must have unit length)
     * @return this
     */
    @Mutated public Double3x4 rotateQuat(double qX, double qY, double qZ, double qW) {
        if (Joml.RETURN_NEW) return rotateQuat(qX, qY, qZ, qW, Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateQuat_identity_self(qX, qY, qZ, qW, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateQuat_translation(qX, qY, qZ, qW, this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateQuat_orthogonal(qX, qY, qZ, qW, this);
        return rotateQuat_general(qX, qY, qZ, qW, this);
    }


    /**
     * Private body of {@code rotateX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX} dispatcher.
     */
    private Double3x4 rotateX_orthogonal_general(double angle, @Mutated Double3x4 dest, int _props) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        d.m00 = this.m00;
        double _buf0 = Math.fma(this.m01, _t0, this.m02 * _t1);
        d.m02 = Math.fma(this.m02, _t0, -(this.m01 * _t1));
        d.m03 = this.m03;
        d.m10 = this.m10;
        double _buf1 = Math.fma(this.m11, _t0, this.m12 * _t1);
        d.m12 = Math.fma(this.m12, _t0, -(this.m11 * _t1));
        d.m13 = this.m13;
        d.m20 = this.m20;
        double _buf2 = Math.fma(this.m21, _t0, this.m22 * _t1);
        d.m22 = Math.fma(this.m22, _t0, -(this.m21 * _t1));
        d.m23 = this.m23;
        d.m01 = _buf0;
        d.m11 = _buf1;
        d.m21 = _buf2;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code rotateX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX} dispatcher.
     */
    private Double3x4 rotateX_identity(double angle, @Mutated Double3x4 dest) {
        return preRotateX_identity(angle, dest);
    }


    /**
     * Private in-place self-form body of {@code rotateX}, specialized by runtime matrix properties;
     * reached only through the public {@code rotateX} dispatcher.
     */
    private Double3x4 rotateX_identity_self(double angle, @Mutated Double3x4 dest) {
        return preRotateX_identity_self(angle, dest);
    }


    /**
     * Private body of {@code rotateX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX} dispatcher.
     */
    private Double3x4 rotateX_translation(double angle, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        d.m00 = 1.0;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = this.m03;
        d.m10 = 0.0;
        d.m11 = _t0;
        d.m12 = -_t1;
        d.m13 = this.m13;
        d.m20 = 0.0;
        d.m21 = _t1;
        d.m22 = _t0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateX}, specialized by runtime matrix properties;
     * reached only through the public {@code rotateX} dispatcher.
     */
    private Double3x4 rotateX_translation_self(double angle, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        d.m03 = this.m03;
        d.m11 = _t0;
        d.m12 = -_t1;
        d.m13 = this.m13;
        d.m21 = _t1;
        d.m22 = _t0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Apply a rotation of {@code angle} radians about the X axis to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 rotateX(double angle, @Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateX_identity(angle, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateX_translation(angle, dest);
        return rotateX_orthogonal_general(angle, dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Apply a rotation of {@code angle} radians about the X axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public Double3x4 rotateX(double angle) {
        if (Joml.RETURN_NEW) return rotateX(angle, Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateX_identity_self(angle, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateX_translation_self(angle, this);
        return rotateX_orthogonal_general(angle, this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Apply a rotation of 180 degrees about the X axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 rotateX180(@Mutated Double3x4 dest) {
        return mapXnYnZ(dest);
    }


    /**
     * Apply a rotation of 180 degrees about the X axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 rotateX180() {
        return mapXnYnZ();
    }


    /**
     * Apply a rotation of 270 degrees about the X axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 rotateX270(@Mutated Double3x4 dest) {
        return mapXnZY(dest);
    }


    /**
     * Apply a rotation of 270 degrees about the X axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 rotateX270() {
        return mapXnZY();
    }


    /**
     * Apply a rotation of 90 degrees about the X axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 rotateX90(@Mutated Double3x4 dest) {
        return mapXZnY(dest);
    }


    /**
     * Apply a rotation of 90 degrees about the X axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 rotateX90() {
        return mapXZnY();
    }


    /**
     * Private body of {@code rotateXYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateXYZ} dispatcher.
     */
    private Double3x4 rotateXYZ_orthogonal_general(double angleX, double angleY, double angleZ, @Mutated Double3x4 dest, int _props) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.sin(angleX);
        double _t1 = Math.sin(angleZ);
        double _t2 = Math.sin(angleY);
        double _t3 = Math.cos(angleX);
        double _t4 = Math.cos(angleZ);
        double _t5 = Math.cos(angleY);
        double _t6 = _t2 * _t3;
        double _t7 = _t5 * _t4;
        double _t8 = _t0 * _t2;
        double _t11 = _t1 * _t5;
        double _t12 = _t3 * _t5;
        double _t13 = _t0 * _t5;
        double _t18 = Math.fma(_t8, _t4, _t1 * _t3);
        double _t19 = Math.fma(_t6, _t1, _t0 * _t4);
        double _t20 = Math.fma(_t0, _t1, -(_t6 * _t4));
        double _t21 = Math.fma(_t3, _t4, -(_t8 * _t1));
        double _buf0 = Math.fma(this.m02, _t20, Math.fma(this.m00, _t7, this.m01 * _t18));
        double _buf1 = Math.fma(this.m02, _t19, Math.fma(this.m01, _t21, -(this.m00 * _t11)));
        d.m02 = Math.fma(this.m02, _t12, Math.fma(this.m00, _t2, -(this.m01 * _t13)));
        d.m03 = this.m03;
        double _buf2 = Math.fma(this.m12, _t20, Math.fma(this.m10, _t7, this.m11 * _t18));
        double _buf3 = Math.fma(this.m12, _t19, Math.fma(this.m11, _t21, -(this.m10 * _t11)));
        d.m12 = Math.fma(this.m12, _t12, Math.fma(this.m10, _t2, -(this.m11 * _t13)));
        d.m13 = this.m13;
        double _buf4 = Math.fma(this.m22, _t20, Math.fma(this.m20, _t7, this.m21 * _t18));
        double _buf5 = Math.fma(this.m22, _t19, Math.fma(this.m21, _t21, -(this.m20 * _t11)));
        d.m22 = Math.fma(this.m22, _t12, Math.fma(this.m20, _t2, -(this.m21 * _t13)));
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m10 = _buf2;
        d.m11 = _buf3;
        d.m20 = _buf4;
        d.m21 = _buf5;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code rotateXYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateXYZ} dispatcher.
     */
    private Double3x4 rotateXYZ_identity(double angleX, double angleY, double angleZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleZ);
        double _t3 = Math.sin(angleY);
        double _t4 = Math.sin(angleX);
        double _t5 = Math.cos(angleX);
        double _t6 = _t4 * _t3;
        double _t7 = _t3 * _t5;
        d.m00 = _t0 * _t1;
        d.m01 = -(_t2 * _t0);
        d.m02 = _t3;
        d.m03 = 0.0;
        d.m10 = Math.fma(_t6, _t1, _t2 * _t5);
        d.m11 = Math.fma(_t5, _t1, -(_t6 * _t2));
        d.m12 = -(_t4 * _t0);
        d.m13 = 0.0;
        d.m20 = Math.fma(_t4, _t2, -(_t7 * _t1));
        d.m21 = Math.fma(_t7, _t2, _t4 * _t1);
        d.m22 = _t5 * _t0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateXYZ}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateXYZ} dispatcher.
     */
    private Double3x4 rotateXYZ_identity_self(double angleX, double angleY, double angleZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleZ);
        double _t3 = Math.sin(angleY);
        double _t4 = Math.sin(angleX);
        double _t5 = Math.cos(angleX);
        double _t6 = _t4 * _t3;
        double _t7 = _t3 * _t5;
        d.m00 = _t0 * _t1;
        d.m01 = -(_t2 * _t0);
        d.m02 = _t3;
        d.m10 = Math.fma(_t6, _t1, _t2 * _t5);
        d.m11 = Math.fma(_t5, _t1, -(_t6 * _t2));
        d.m12 = -(_t4 * _t0);
        d.m20 = Math.fma(_t4, _t2, -(_t7 * _t1));
        d.m21 = Math.fma(_t7, _t2, _t4 * _t1);
        d.m22 = _t5 * _t0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code rotateXYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateXYZ} dispatcher.
     */
    private Double3x4 rotateXYZ_translation(double angleX, double angleY, double angleZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleZ);
        double _t3 = Math.sin(angleY);
        double _t4 = Math.sin(angleX);
        double _t5 = Math.cos(angleX);
        double _t6 = _t4 * _t3;
        double _t7 = _t3 * _t5;
        d.m00 = _t0 * _t1;
        d.m01 = -(_t2 * _t0);
        d.m02 = _t3;
        d.m03 = this.m03;
        d.m10 = Math.fma(_t6, _t1, _t2 * _t5);
        d.m11 = Math.fma(_t5, _t1, -(_t6 * _t2));
        d.m12 = -(_t4 * _t0);
        d.m13 = this.m13;
        d.m20 = Math.fma(_t4, _t2, -(_t7 * _t1));
        d.m21 = Math.fma(_t7, _t2, _t4 * _t1);
        d.m22 = _t5 * _t0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Apply a rotation of {@code angleX}, {@code angleY} and {@code angleZ} radians about the X, Y
     * and Z axes, in that order (the matrix product {@code Rx * Ry * Rz}, so a vector is rotated
     * about the Z axis first, then Y, then X), to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 rotateXYZ(double angleX, double angleY, double angleZ, @Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateXYZ_identity(angleX, angleY, angleZ, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateXYZ_translation(angleX, angleY, angleZ, dest);
        return rotateXYZ_orthogonal_general(angleX, angleY, angleZ, dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Apply a rotation of {@code angleX}, {@code angleY} and {@code angleZ} radians about the X, Y
     * and Z axes, in that order (the matrix product {@code Rx * Ry * Rz}, so a vector is rotated
     * about the Z axis first, then Y, then X), to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public Double3x4 rotateXYZ(double angleX, double angleY, double angleZ) {
        if (Joml.RETURN_NEW) return rotateXYZ(angleX, angleY, angleZ, Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateXYZ_identity_self(angleX, angleY, angleZ, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateXYZ_translation(angleX, angleY, angleZ, this);
        return rotateXYZ_orthogonal_general(angleX, angleY, angleZ, this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code rotateXZY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateXZY} dispatcher.
     */
    private Double3x4 rotateXZY_orthogonal_general(double angleX, double angleY, double angleZ, @Mutated Double3x4 dest, int _props) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.sin(angleX);
        double _t1 = Math.sin(angleZ);
        double _t2 = Math.cos(angleY);
        double _t3 = Math.sin(angleY);
        double _t4 = Math.cos(angleX);
        double _t5 = Math.cos(angleZ);
        double _t6 = _t0 * _t1;
        double _t8 = _t2 * _t5;
        double _t9 = _t1 * _t4;
        double _t11 = _t0 * _t5;
        double _t12 = _t4 * _t5;
        double _t14 = _t3 * _t5;
        double _t18 = Math.fma(_t9, _t2, _t0 * _t3);
        double _t19 = Math.fma(_t6, _t3, _t4 * _t2);
        double _t20 = Math.fma(_t6, _t2, -(_t3 * _t4));
        double _t21 = Math.fma(_t9, _t3, -(_t0 * _t2));
        double _buf0 = Math.fma(this.m02, _t20, Math.fma(this.m00, _t8, this.m01 * _t18));
        double _buf1 = Math.fma(this.m02, _t11, Math.fma(this.m01, _t12, -(this.m00 * _t1)));
        d.m02 = Math.fma(this.m02, _t19, Math.fma(this.m00, _t14, this.m01 * _t21));
        d.m03 = this.m03;
        double _buf2 = Math.fma(this.m12, _t20, Math.fma(this.m10, _t8, this.m11 * _t18));
        double _buf3 = Math.fma(this.m12, _t11, Math.fma(this.m11, _t12, -(this.m10 * _t1)));
        d.m12 = Math.fma(this.m12, _t19, Math.fma(this.m10, _t14, this.m11 * _t21));
        d.m13 = this.m13;
        double _buf4 = Math.fma(this.m22, _t20, Math.fma(this.m20, _t8, this.m21 * _t18));
        double _buf5 = Math.fma(this.m22, _t11, Math.fma(this.m21, _t12, -(this.m20 * _t1)));
        d.m22 = Math.fma(this.m22, _t19, Math.fma(this.m20, _t14, this.m21 * _t21));
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m10 = _buf2;
        d.m11 = _buf3;
        d.m20 = _buf4;
        d.m21 = _buf5;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code rotateXZY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateXZY} dispatcher.
     */
    private Double3x4 rotateXZY_identity(double angleX, double angleY, double angleZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleZ);
        double _t3 = Math.sin(angleY);
        double _t4 = Math.cos(angleX);
        double _t5 = Math.sin(angleX);
        double _t6 = _t2 * _t4;
        double _t7 = _t5 * _t2;
        d.m00 = _t0 * _t1;
        d.m01 = -_t2;
        d.m02 = _t3 * _t1;
        d.m03 = 0.0;
        d.m10 = Math.fma(_t6, _t0, _t5 * _t3);
        d.m11 = _t4 * _t1;
        d.m12 = Math.fma(_t6, _t3, -(_t5 * _t0));
        d.m13 = 0.0;
        d.m20 = Math.fma(_t7, _t0, -(_t3 * _t4));
        d.m21 = _t5 * _t1;
        d.m22 = Math.fma(_t7, _t3, _t4 * _t0);
        d.m23 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateXZY}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateXZY} dispatcher.
     */
    private Double3x4 rotateXZY_identity_self(double angleX, double angleY, double angleZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleZ);
        double _t3 = Math.sin(angleY);
        double _t4 = Math.cos(angleX);
        double _t5 = Math.sin(angleX);
        double _t6 = _t2 * _t4;
        double _t7 = _t5 * _t2;
        d.m00 = _t0 * _t1;
        d.m01 = -_t2;
        d.m02 = _t3 * _t1;
        d.m10 = Math.fma(_t6, _t0, _t5 * _t3);
        d.m11 = _t4 * _t1;
        d.m12 = Math.fma(_t6, _t3, -(_t5 * _t0));
        d.m20 = Math.fma(_t7, _t0, -(_t3 * _t4));
        d.m21 = _t5 * _t1;
        d.m22 = Math.fma(_t7, _t3, _t4 * _t0);
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code rotateXZY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateXZY} dispatcher.
     */
    private Double3x4 rotateXZY_translation(double angleX, double angleY, double angleZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleZ);
        double _t3 = Math.sin(angleY);
        double _t4 = Math.cos(angleX);
        double _t5 = Math.sin(angleX);
        double _t6 = _t2 * _t4;
        double _t7 = _t5 * _t2;
        d.m00 = _t0 * _t1;
        d.m01 = -_t2;
        d.m02 = _t3 * _t1;
        d.m03 = this.m03;
        d.m10 = Math.fma(_t6, _t0, _t5 * _t3);
        d.m11 = _t4 * _t1;
        d.m12 = Math.fma(_t6, _t3, -(_t5 * _t0));
        d.m13 = this.m13;
        d.m20 = Math.fma(_t7, _t0, -(_t3 * _t4));
        d.m21 = _t5 * _t1;
        d.m22 = Math.fma(_t7, _t3, _t4 * _t0);
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Apply a rotation of {@code angleX}, {@code angleZ} and {@code angleY} radians about the X, Z
     * and Y axes, in that order (the matrix product {@code Rx * Rz * Ry}, so a vector is rotated
     * about the Y axis first, then Z, then X), to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 rotateXZY(double angleX, double angleY, double angleZ, @Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateXZY_identity(angleX, angleY, angleZ, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateXZY_translation(angleX, angleY, angleZ, dest);
        return rotateXZY_orthogonal_general(angleX, angleY, angleZ, dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Apply a rotation of {@code angleX}, {@code angleZ} and {@code angleY} radians about the X, Z
     * and Y axes, in that order (the matrix product {@code Rx * Rz * Ry}, so a vector is rotated
     * about the Y axis first, then Z, then X), to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public Double3x4 rotateXZY(double angleX, double angleY, double angleZ) {
        if (Joml.RETURN_NEW) return rotateXZY(angleX, angleY, angleZ, Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateXZY_identity_self(angleX, angleY, angleZ, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateXZY_translation(angleX, angleY, angleZ, this);
        return rotateXZY_orthogonal_general(angleX, angleY, angleZ, this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Apply a rotation of -180 degrees about the X axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 rotateXn180(@Mutated Double3x4 dest) {
        return mapXnYnZ(dest);
    }


    /**
     * Apply a rotation of -180 degrees about the X axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 rotateXn180() {
        return mapXnYnZ();
    }


    /**
     * Apply a rotation of -270 degrees about the X axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 rotateXn270(@Mutated Double3x4 dest) {
        return mapXZnY(dest);
    }


    /**
     * Apply a rotation of -270 degrees about the X axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 rotateXn270() {
        return mapXZnY();
    }


    /**
     * Apply a rotation of -90 degrees about the X axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 rotateXn90(@Mutated Double3x4 dest) {
        return mapXnZY(dest);
    }


    /**
     * Apply a rotation of -90 degrees about the X axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 rotateXn90() {
        return mapXnZY();
    }


    /**
     * Private body of {@code rotateY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY} dispatcher.
     */
    private Double3x4 rotateY_orthogonal_general(double angle, @Mutated Double3x4 dest, int _props) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _buf0 = Math.fma(this.m00, _t0, -(this.m02 * _t1));
        d.m01 = this.m01;
        d.m02 = Math.fma(this.m00, _t1, this.m02 * _t0);
        d.m03 = this.m03;
        double _buf1 = Math.fma(this.m10, _t0, -(this.m12 * _t1));
        d.m11 = this.m11;
        d.m12 = Math.fma(this.m10, _t1, this.m12 * _t0);
        d.m13 = this.m13;
        double _buf2 = Math.fma(this.m20, _t0, -(this.m22 * _t1));
        d.m21 = this.m21;
        d.m22 = Math.fma(this.m20, _t1, this.m22 * _t0);
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code rotateY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY} dispatcher.
     */
    private Double3x4 rotateY_identity(double angle, @Mutated Double3x4 dest) {
        return preRotateY_identity(angle, dest);
    }


    /**
     * Private in-place self-form body of {@code rotateY}, specialized by runtime matrix properties;
     * reached only through the public {@code rotateY} dispatcher.
     */
    private Double3x4 rotateY_identity_self(double angle, @Mutated Double3x4 dest) {
        return preRotateY_identity_self(angle, dest);
    }


    /**
     * Private body of {@code rotateY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY} dispatcher.
     */
    private Double3x4 rotateY_translation(double angle, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        d.m00 = _t0;
        d.m01 = 0.0;
        d.m02 = _t1;
        d.m03 = this.m03;
        d.m10 = 0.0;
        d.m11 = 1.0;
        d.m12 = 0.0;
        d.m13 = this.m13;
        d.m20 = -_t1;
        d.m21 = 0.0;
        d.m22 = _t0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateY}, specialized by runtime matrix properties;
     * reached only through the public {@code rotateY} dispatcher.
     */
    private Double3x4 rotateY_translation_self(double angle, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        d.m00 = _t0;
        d.m02 = _t1;
        d.m03 = this.m03;
        d.m13 = this.m13;
        d.m20 = -_t1;
        d.m22 = _t0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Apply a rotation of {@code angle} radians about the Y axis to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 rotateY(double angle, @Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateY_identity(angle, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateY_translation(angle, dest);
        return rotateY_orthogonal_general(angle, dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Apply a rotation of {@code angle} radians about the Y axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public Double3x4 rotateY(double angle) {
        if (Joml.RETURN_NEW) return rotateY(angle, Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateY_identity_self(angle, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateY_translation_self(angle, this);
        return rotateY_orthogonal_general(angle, this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Apply a rotation of 180 degrees about the Y axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 rotateY180(@Mutated Double3x4 dest) {
        return mapnXYnZ(dest);
    }


    /**
     * Apply a rotation of 180 degrees about the Y axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 rotateY180() {
        return mapnXYnZ();
    }


    /**
     * Apply a rotation of 270 degrees about the Y axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 rotateY270(@Mutated Double3x4 dest) {
        return mapZYnX(dest);
    }


    /**
     * Apply a rotation of 270 degrees about the Y axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 rotateY270() {
        return mapZYnX();
    }


    /**
     * Apply a rotation of 90 degrees about the Y axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 rotateY90(@Mutated Double3x4 dest) {
        return mapnZYX(dest);
    }


    /**
     * Apply a rotation of 90 degrees about the Y axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 rotateY90() {
        return mapnZYX();
    }


    /**
     * Private body of {@code rotateYXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateYXZ} dispatcher.
     */
    private Double3x4 rotateYXZ_orthogonal_general(double angleX, double angleY, double angleZ, @Mutated Double3x4 dest, int _props) {
        Double3x4Impl d = (Double3x4Impl) dest;
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
        double _buf0 = Math.fma(this.m02, _t20, Math.fma(this.m00, _t18, this.m01 * _t10));
        double _buf1 = Math.fma(this.m02, _t19, Math.fma(this.m00, _t21, this.m01 * _t13));
        d.m02 = Math.fma(this.m02, _t14, Math.fma(this.m00, _t15, -(this.m01 * _t0)));
        d.m03 = this.m03;
        double _buf2 = Math.fma(this.m12, _t20, Math.fma(this.m10, _t18, this.m11 * _t10));
        double _buf3 = Math.fma(this.m12, _t19, Math.fma(this.m10, _t21, this.m11 * _t13));
        d.m12 = Math.fma(this.m12, _t14, Math.fma(this.m10, _t15, -(this.m11 * _t0)));
        d.m13 = this.m13;
        double _buf4 = Math.fma(this.m22, _t20, Math.fma(this.m20, _t18, this.m21 * _t10));
        double _buf5 = Math.fma(this.m22, _t19, Math.fma(this.m20, _t21, this.m21 * _t13));
        d.m22 = Math.fma(this.m22, _t14, Math.fma(this.m20, _t15, -(this.m21 * _t0)));
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m10 = _buf2;
        d.m11 = _buf3;
        d.m20 = _buf4;
        d.m21 = _buf5;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code rotateYXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateYXZ} dispatcher.
     */
    private Double3x4 rotateYXZ_identity(double angleX, double angleY, double angleZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.sin(angleX);
        double _t1 = Math.sin(angleY);
        double _t2 = Math.sin(angleZ);
        double _t3 = Math.cos(angleY);
        double _t4 = Math.cos(angleZ);
        double _t5 = Math.cos(angleX);
        double _t6 = _t0 * _t1;
        double _t7 = _t0 * _t3;
        d.m00 = Math.fma(_t6, _t2, _t3 * _t4);
        d.m01 = Math.fma(_t6, _t4, -(_t2 * _t3));
        d.m02 = _t1 * _t5;
        d.m03 = 0.0;
        d.m10 = _t2 * _t5;
        d.m11 = _t5 * _t4;
        d.m12 = -_t0;
        d.m13 = 0.0;
        d.m20 = Math.fma(_t7, _t2, -(_t1 * _t4));
        d.m21 = Math.fma(_t7, _t4, _t1 * _t2);
        d.m22 = _t5 * _t3;
        d.m23 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateYXZ}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateYXZ} dispatcher.
     */
    private Double3x4 rotateYXZ_identity_self(double angleX, double angleY, double angleZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.sin(angleX);
        double _t1 = Math.sin(angleY);
        double _t2 = Math.sin(angleZ);
        double _t3 = Math.cos(angleY);
        double _t4 = Math.cos(angleZ);
        double _t5 = Math.cos(angleX);
        double _t6 = _t0 * _t1;
        double _t7 = _t0 * _t3;
        d.m00 = Math.fma(_t6, _t2, _t3 * _t4);
        d.m01 = Math.fma(_t6, _t4, -(_t2 * _t3));
        d.m02 = _t1 * _t5;
        d.m10 = _t2 * _t5;
        d.m11 = _t5 * _t4;
        d.m12 = -_t0;
        d.m20 = Math.fma(_t7, _t2, -(_t1 * _t4));
        d.m21 = Math.fma(_t7, _t4, _t1 * _t2);
        d.m22 = _t5 * _t3;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code rotateYXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateYXZ} dispatcher.
     */
    private Double3x4 rotateYXZ_translation(double angleX, double angleY, double angleZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.sin(angleX);
        double _t1 = Math.sin(angleY);
        double _t2 = Math.sin(angleZ);
        double _t3 = Math.cos(angleY);
        double _t4 = Math.cos(angleZ);
        double _t5 = Math.cos(angleX);
        double _t6 = _t0 * _t1;
        double _t7 = _t0 * _t3;
        d.m00 = Math.fma(_t6, _t2, _t3 * _t4);
        d.m01 = Math.fma(_t6, _t4, -(_t2 * _t3));
        d.m02 = _t1 * _t5;
        d.m03 = this.m03;
        d.m10 = _t2 * _t5;
        d.m11 = _t5 * _t4;
        d.m12 = -_t0;
        d.m13 = this.m13;
        d.m20 = Math.fma(_t7, _t2, -(_t1 * _t4));
        d.m21 = Math.fma(_t7, _t4, _t1 * _t2);
        d.m22 = _t5 * _t3;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Apply a rotation of {@code angleY}, {@code angleX} and {@code angleZ} radians about the Y, X
     * and Z axes, in that order (the matrix product {@code Ry * Rx * Rz}, so a vector is rotated
     * about the Z axis first, then X, then Y), to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 rotateYXZ(double angleX, double angleY, double angleZ, @Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateYXZ_identity(angleX, angleY, angleZ, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateYXZ_translation(angleX, angleY, angleZ, dest);
        return rotateYXZ_orthogonal_general(angleX, angleY, angleZ, dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Apply a rotation of {@code angleY}, {@code angleX} and {@code angleZ} radians about the Y, X
     * and Z axes, in that order (the matrix product {@code Ry * Rx * Rz}, so a vector is rotated
     * about the Z axis first, then X, then Y), to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public Double3x4 rotateYXZ(double angleX, double angleY, double angleZ) {
        if (Joml.RETURN_NEW) return rotateYXZ(angleX, angleY, angleZ, Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateYXZ_identity_self(angleX, angleY, angleZ, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateYXZ_translation(angleX, angleY, angleZ, this);
        return rotateYXZ_orthogonal_general(angleX, angleY, angleZ, this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code rotateYZX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateYZX} dispatcher.
     */
    private Double3x4 rotateYZX_orthogonal_general(double angleX, double angleY, double angleZ, @Mutated Double3x4 dest, int _props) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.sin(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.cos(angleY);
        double _t3 = Math.sin(angleZ);
        double _t4 = Math.cos(angleX);
        double _t5 = Math.sin(angleX);
        double _t6 = _t0 * _t1;
        double _t7 = _t2 * _t1;
        double _t8 = _t0 * _t3;
        double _t10 = _t3 * _t2;
        double _t11 = _t4 * _t1;
        double _t13 = _t5 * _t1;
        double _t18 = Math.fma(_t8, _t4, _t5 * _t2);
        double _t19 = Math.fma(_t10, _t5, _t0 * _t4);
        double _t20 = Math.fma(_t5, _t0, -(_t10 * _t4));
        double _t21 = Math.fma(_t4, _t2, -(_t8 * _t5));
        double _buf0 = Math.fma(-this.m02, _t6, Math.fma(this.m00, _t7, this.m01 * _t3));
        double _buf1 = Math.fma(this.m02, _t18, Math.fma(this.m00, _t20, this.m01 * _t11));
        d.m02 = Math.fma(this.m02, _t21, Math.fma(this.m00, _t19, -(this.m01 * _t13)));
        d.m03 = this.m03;
        double _buf2 = Math.fma(-this.m12, _t6, Math.fma(this.m10, _t7, this.m11 * _t3));
        double _buf3 = Math.fma(this.m12, _t18, Math.fma(this.m10, _t20, this.m11 * _t11));
        d.m12 = Math.fma(this.m12, _t21, Math.fma(this.m10, _t19, -(this.m11 * _t13)));
        d.m13 = this.m13;
        double _buf4 = Math.fma(-this.m22, _t6, Math.fma(this.m20, _t7, this.m21 * _t3));
        double _buf5 = Math.fma(this.m22, _t18, Math.fma(this.m20, _t20, this.m21 * _t11));
        d.m22 = Math.fma(this.m22, _t21, Math.fma(this.m20, _t19, -(this.m21 * _t13)));
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m10 = _buf2;
        d.m11 = _buf3;
        d.m20 = _buf4;
        d.m21 = _buf5;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code rotateYZX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateYZX} dispatcher.
     */
    private Double3x4 rotateYZX_identity(double angleX, double angleY, double angleZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleX);
        double _t3 = Math.sin(angleY);
        double _t4 = Math.sin(angleZ);
        double _t5 = Math.cos(angleX);
        double _t6 = _t4 * _t0;
        double _t7 = _t3 * _t4;
        d.m00 = _t0 * _t1;
        d.m01 = Math.fma(_t2, _t3, -(_t6 * _t5));
        d.m02 = Math.fma(_t6, _t2, _t3 * _t5);
        d.m03 = 0.0;
        d.m10 = _t4;
        d.m11 = _t5 * _t1;
        d.m12 = -(_t2 * _t1);
        d.m13 = 0.0;
        d.m20 = -(_t3 * _t1);
        d.m21 = Math.fma(_t7, _t5, _t2 * _t0);
        d.m22 = Math.fma(_t5, _t0, -(_t7 * _t2));
        d.m23 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateYZX}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateYZX} dispatcher.
     */
    private Double3x4 rotateYZX_identity_self(double angleX, double angleY, double angleZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleX);
        double _t3 = Math.sin(angleY);
        double _t4 = Math.sin(angleZ);
        double _t5 = Math.cos(angleX);
        double _t6 = _t4 * _t0;
        double _t7 = _t3 * _t4;
        d.m00 = _t0 * _t1;
        d.m01 = Math.fma(_t2, _t3, -(_t6 * _t5));
        d.m02 = Math.fma(_t6, _t2, _t3 * _t5);
        d.m10 = _t4;
        d.m11 = _t5 * _t1;
        d.m12 = -(_t2 * _t1);
        d.m20 = -(_t3 * _t1);
        d.m21 = Math.fma(_t7, _t5, _t2 * _t0);
        d.m22 = Math.fma(_t5, _t0, -(_t7 * _t2));
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code rotateYZX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateYZX} dispatcher.
     */
    private Double3x4 rotateYZX_translation(double angleX, double angleY, double angleZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleX);
        double _t3 = Math.sin(angleY);
        double _t4 = Math.sin(angleZ);
        double _t5 = Math.cos(angleX);
        double _t6 = _t4 * _t0;
        double _t7 = _t3 * _t4;
        d.m00 = _t0 * _t1;
        d.m01 = Math.fma(_t2, _t3, -(_t6 * _t5));
        d.m02 = Math.fma(_t6, _t2, _t3 * _t5);
        d.m03 = this.m03;
        d.m10 = _t4;
        d.m11 = _t5 * _t1;
        d.m12 = -(_t2 * _t1);
        d.m13 = this.m13;
        d.m20 = -(_t3 * _t1);
        d.m21 = Math.fma(_t7, _t5, _t2 * _t0);
        d.m22 = Math.fma(_t5, _t0, -(_t7 * _t2));
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Apply a rotation of {@code angleY}, {@code angleZ} and {@code angleX} radians about the Y, Z
     * and X axes, in that order (the matrix product {@code Ry * Rz * Rx}, so a vector is rotated
     * about the X axis first, then Z, then Y), to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 rotateYZX(double angleX, double angleY, double angleZ, @Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateYZX_identity(angleX, angleY, angleZ, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateYZX_translation(angleX, angleY, angleZ, dest);
        return rotateYZX_orthogonal_general(angleX, angleY, angleZ, dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Apply a rotation of {@code angleY}, {@code angleZ} and {@code angleX} radians about the Y, Z
     * and X axes, in that order (the matrix product {@code Ry * Rz * Rx}, so a vector is rotated
     * about the X axis first, then Z, then Y), to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public Double3x4 rotateYZX(double angleX, double angleY, double angleZ) {
        if (Joml.RETURN_NEW) return rotateYZX(angleX, angleY, angleZ, Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateYZX_identity_self(angleX, angleY, angleZ, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateYZX_translation(angleX, angleY, angleZ, this);
        return rotateYZX_orthogonal_general(angleX, angleY, angleZ, this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Apply a rotation of -180 degrees about the Y axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 rotateYn180(@Mutated Double3x4 dest) {
        return mapnXYnZ(dest);
    }


    /**
     * Apply a rotation of -180 degrees about the Y axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 rotateYn180() {
        return mapnXYnZ();
    }


    /**
     * Apply a rotation of -270 degrees about the Y axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 rotateYn270(@Mutated Double3x4 dest) {
        return mapnZYX(dest);
    }


    /**
     * Apply a rotation of -270 degrees about the Y axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 rotateYn270() {
        return mapnZYX();
    }


    /**
     * Apply a rotation of -90 degrees about the Y axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 rotateYn90(@Mutated Double3x4 dest) {
        return mapZYnX(dest);
    }


    /**
     * Apply a rotation of -90 degrees about the Y axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 rotateYn90() {
        return mapZYnX();
    }


    /**
     * Private body of {@code rotateZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ} dispatcher.
     */
    private Double3x4 rotateZ_orthogonal_general(double angle, @Mutated Double3x4 dest, int _props) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _buf0 = Math.fma(this.m00, _t0, this.m01 * _t1);
        d.m01 = Math.fma(this.m01, _t0, -(this.m00 * _t1));
        d.m02 = this.m02;
        d.m03 = this.m03;
        double _buf1 = Math.fma(this.m10, _t0, this.m11 * _t1);
        d.m11 = Math.fma(this.m11, _t0, -(this.m10 * _t1));
        d.m12 = this.m12;
        d.m13 = this.m13;
        double _buf2 = Math.fma(this.m20, _t0, this.m21 * _t1);
        d.m21 = Math.fma(this.m21, _t0, -(this.m20 * _t1));
        d.m22 = this.m22;
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code rotateZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ} dispatcher.
     */
    private Double3x4 rotateZ_identity(double angle, @Mutated Double3x4 dest) {
        return preRotateZ_identity(angle, dest);
    }


    /**
     * Private in-place self-form body of {@code rotateZ}, specialized by runtime matrix properties;
     * reached only through the public {@code rotateZ} dispatcher.
     */
    private Double3x4 rotateZ_identity_self(double angle, @Mutated Double3x4 dest) {
        return preRotateZ_identity_self(angle, dest);
    }


    /**
     * Private body of {@code rotateZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ} dispatcher.
     */
    private Double3x4 rotateZ_translation(double angle, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        d.m00 = _t0;
        d.m01 = -_t1;
        d.m02 = 0.0;
        d.m03 = this.m03;
        d.m10 = _t1;
        d.m11 = _t0;
        d.m12 = 0.0;
        d.m13 = this.m13;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = 1.0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateZ}, specialized by runtime matrix properties;
     * reached only through the public {@code rotateZ} dispatcher.
     */
    private Double3x4 rotateZ_translation_self(double angle, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        d.m00 = _t0;
        d.m01 = -_t1;
        d.m03 = this.m03;
        d.m10 = _t1;
        d.m11 = _t0;
        d.m13 = this.m13;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Apply a rotation of {@code angle} radians about the Z axis to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 rotateZ(double angle, @Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateZ_identity(angle, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateZ_translation(angle, dest);
        return rotateZ_orthogonal_general(angle, dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Apply a rotation of {@code angle} radians about the Z axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public Double3x4 rotateZ(double angle) {
        if (Joml.RETURN_NEW) return rotateZ(angle, Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateZ_identity_self(angle, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateZ_translation_self(angle, this);
        return rotateZ_orthogonal_general(angle, this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Apply a rotation of 180 degrees about the Z axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 rotateZ180(@Mutated Double3x4 dest) {
        return mapnXnYZ(dest);
    }


    /**
     * Apply a rotation of 180 degrees about the Z axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 rotateZ180() {
        return mapnXnYZ();
    }


    /**
     * Apply a rotation of 270 degrees about the Z axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 rotateZ270(@Mutated Double3x4 dest) {
        return mapnYXZ(dest);
    }


    /**
     * Apply a rotation of 270 degrees about the Z axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 rotateZ270() {
        return mapnYXZ();
    }


    /**
     * Apply a rotation of 90 degrees about the Z axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 rotateZ90(@Mutated Double3x4 dest) {
        return mapYnXZ(dest);
    }


    /**
     * Apply a rotation of 90 degrees about the Z axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 rotateZ90() {
        return mapYnXZ();
    }


    /**
     * Private body of {@code rotateZXY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZXY} dispatcher.
     */
    private Double3x4 rotateZXY_orthogonal_general(double angleX, double angleY, double angleZ, @Mutated Double3x4 dest, int _props) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.sin(angleY);
        double _t1 = Math.cos(angleX);
        double _t2 = Math.cos(angleY);
        double _t3 = Math.cos(angleZ);
        double _t4 = Math.sin(angleX);
        double _t5 = Math.sin(angleZ);
        double _t6 = _t0 * _t1;
        double _t7 = _t4 * _t5;
        double _t8 = _t4 * _t3;
        double _t10 = _t1 * _t3;
        double _t11 = _t5 * _t1;
        double _t12 = _t1 * _t2;
        double _t18 = Math.fma(_t8, _t0, _t5 * _t2);
        double _t19 = Math.fma(_t7, _t2, _t0 * _t3);
        double _t20 = Math.fma(_t2, _t3, -(_t7 * _t0));
        double _t21 = Math.fma(_t0, _t5, -(_t8 * _t2));
        double _buf0 = Math.fma(-this.m02, _t6, Math.fma(this.m00, _t20, this.m01 * _t18));
        double _buf1 = Math.fma(this.m02, _t4, Math.fma(this.m01, _t10, -(this.m00 * _t11)));
        d.m02 = Math.fma(this.m02, _t12, Math.fma(this.m00, _t19, this.m01 * _t21));
        d.m03 = this.m03;
        double _buf2 = Math.fma(-this.m12, _t6, Math.fma(this.m10, _t20, this.m11 * _t18));
        double _buf3 = Math.fma(this.m12, _t4, Math.fma(this.m11, _t10, -(this.m10 * _t11)));
        d.m12 = Math.fma(this.m12, _t12, Math.fma(this.m10, _t19, this.m11 * _t21));
        d.m13 = this.m13;
        double _buf4 = Math.fma(-this.m22, _t6, Math.fma(this.m20, _t20, this.m21 * _t18));
        double _buf5 = Math.fma(this.m22, _t4, Math.fma(this.m21, _t10, -(this.m20 * _t11)));
        d.m22 = Math.fma(this.m22, _t12, Math.fma(this.m20, _t19, this.m21 * _t21));
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m10 = _buf2;
        d.m11 = _buf3;
        d.m20 = _buf4;
        d.m21 = _buf5;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code rotateZXY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZXY} dispatcher.
     */
    private Double3x4 rotateZXY_identity(double angleX, double angleY, double angleZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleX);
        double _t3 = Math.sin(angleZ);
        double _t4 = Math.sin(angleY);
        double _t5 = Math.cos(angleX);
        double _t6 = _t2 * _t3;
        double _t7 = _t2 * _t1;
        d.m00 = Math.fma(_t0, _t1, -(_t6 * _t4));
        d.m01 = -(_t3 * _t5);
        d.m02 = Math.fma(_t6, _t0, _t4 * _t1);
        d.m03 = 0.0;
        d.m10 = Math.fma(_t7, _t4, _t3 * _t0);
        d.m11 = _t5 * _t1;
        d.m12 = Math.fma(_t4, _t3, -(_t7 * _t0));
        d.m13 = 0.0;
        d.m20 = -(_t4 * _t5);
        d.m21 = _t2;
        d.m22 = _t5 * _t0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateZXY}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateZXY} dispatcher.
     */
    private Double3x4 rotateZXY_identity_self(double angleX, double angleY, double angleZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleX);
        double _t3 = Math.sin(angleZ);
        double _t4 = Math.sin(angleY);
        double _t5 = Math.cos(angleX);
        double _t6 = _t2 * _t3;
        double _t7 = _t2 * _t1;
        d.m00 = Math.fma(_t0, _t1, -(_t6 * _t4));
        d.m01 = -(_t3 * _t5);
        d.m02 = Math.fma(_t6, _t0, _t4 * _t1);
        d.m10 = Math.fma(_t7, _t4, _t3 * _t0);
        d.m11 = _t5 * _t1;
        d.m12 = Math.fma(_t4, _t3, -(_t7 * _t0));
        d.m20 = -(_t4 * _t5);
        d.m21 = _t2;
        d.m22 = _t5 * _t0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code rotateZXY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZXY} dispatcher.
     */
    private Double3x4 rotateZXY_translation(double angleX, double angleY, double angleZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleX);
        double _t3 = Math.sin(angleZ);
        double _t4 = Math.sin(angleY);
        double _t5 = Math.cos(angleX);
        double _t6 = _t2 * _t3;
        double _t7 = _t2 * _t1;
        d.m00 = Math.fma(_t0, _t1, -(_t6 * _t4));
        d.m01 = -(_t3 * _t5);
        d.m02 = Math.fma(_t6, _t0, _t4 * _t1);
        d.m03 = this.m03;
        d.m10 = Math.fma(_t7, _t4, _t3 * _t0);
        d.m11 = _t5 * _t1;
        d.m12 = Math.fma(_t4, _t3, -(_t7 * _t0));
        d.m13 = this.m13;
        d.m20 = -(_t4 * _t5);
        d.m21 = _t2;
        d.m22 = _t5 * _t0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Apply a rotation of {@code angleZ}, {@code angleX} and {@code angleY} radians about the Z, X
     * and Y axes, in that order (the matrix product {@code Rz * Rx * Ry}, so a vector is rotated
     * about the Y axis first, then X, then Z), to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 rotateZXY(double angleX, double angleY, double angleZ, @Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateZXY_identity(angleX, angleY, angleZ, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateZXY_translation(angleX, angleY, angleZ, dest);
        return rotateZXY_orthogonal_general(angleX, angleY, angleZ, dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Apply a rotation of {@code angleZ}, {@code angleX} and {@code angleY} radians about the Z, X
     * and Y axes, in that order (the matrix product {@code Rz * Rx * Ry}, so a vector is rotated
     * about the Y axis first, then X, then Z), to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public Double3x4 rotateZXY(double angleX, double angleY, double angleZ) {
        if (Joml.RETURN_NEW) return rotateZXY(angleX, angleY, angleZ, Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateZXY_identity_self(angleX, angleY, angleZ, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateZXY_translation(angleX, angleY, angleZ, this);
        return rotateZXY_orthogonal_general(angleX, angleY, angleZ, this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code rotateZYX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZYX} dispatcher.
     */
    private Double3x4 rotateZYX_orthogonal_general(double angleX, double angleY, double angleZ, @Mutated Double3x4 dest, int _props) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.sin(angleY);
        double _t1 = Math.cos(angleY);
        double _t2 = Math.cos(angleZ);
        double _t3 = Math.sin(angleZ);
        double _t4 = Math.sin(angleX);
        double _t5 = Math.cos(angleX);
        double _t6 = _t1 * _t2;
        double _t7 = _t3 * _t1;
        double _t8 = _t4 * _t1;
        double _t9 = _t0 * _t2;
        double _t11 = _t0 * _t3;
        double _t13 = _t5 * _t1;
        double _t18 = Math.fma(_t11, _t4, _t5 * _t2);
        double _t19 = Math.fma(_t9, _t5, _t4 * _t3);
        double _t20 = Math.fma(_t9, _t4, -(_t3 * _t5));
        double _t21 = Math.fma(_t11, _t5, -(_t4 * _t2));
        double _buf0 = Math.fma(-this.m02, _t0, Math.fma(this.m00, _t6, this.m01 * _t7));
        double _buf1 = Math.fma(this.m02, _t8, Math.fma(this.m00, _t20, this.m01 * _t18));
        d.m02 = Math.fma(this.m02, _t13, Math.fma(this.m00, _t19, this.m01 * _t21));
        d.m03 = this.m03;
        double _buf2 = Math.fma(-this.m12, _t0, Math.fma(this.m10, _t6, this.m11 * _t7));
        double _buf3 = Math.fma(this.m12, _t8, Math.fma(this.m10, _t20, this.m11 * _t18));
        d.m12 = Math.fma(this.m12, _t13, Math.fma(this.m10, _t19, this.m11 * _t21));
        d.m13 = this.m13;
        double _buf4 = Math.fma(-this.m22, _t0, Math.fma(this.m20, _t6, this.m21 * _t7));
        double _buf5 = Math.fma(this.m22, _t8, Math.fma(this.m20, _t20, this.m21 * _t18));
        d.m22 = Math.fma(this.m22, _t13, Math.fma(this.m20, _t19, this.m21 * _t21));
        d.m23 = this.m23;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m10 = _buf2;
        d.m11 = _buf3;
        d.m20 = _buf4;
        d.m21 = _buf5;
        d.properties = _props;
        return d;
    }


    /**
     * Private body of {@code rotateZYX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZYX} dispatcher.
     */
    private Double3x4 rotateZYX_identity(double angleX, double angleY, double angleZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleY);
        double _t3 = Math.sin(angleX);
        double _t4 = Math.sin(angleZ);
        double _t5 = Math.cos(angleX);
        double _t6 = _t2 * _t1;
        double _t7 = _t2 * _t4;
        d.m00 = _t0 * _t1;
        d.m01 = Math.fma(_t6, _t3, -(_t4 * _t5));
        d.m02 = Math.fma(_t6, _t5, _t3 * _t4);
        d.m03 = 0.0;
        d.m10 = _t4 * _t0;
        d.m11 = Math.fma(_t7, _t3, _t5 * _t1);
        d.m12 = Math.fma(_t7, _t5, -(_t3 * _t1));
        d.m13 = 0.0;
        d.m20 = -_t2;
        d.m21 = _t3 * _t0;
        d.m22 = _t5 * _t0;
        d.m23 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private in-place self-form body of {@code rotateZYX}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateZYX} dispatcher.
     */
    private Double3x4 rotateZYX_identity_self(double angleX, double angleY, double angleZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleY);
        double _t3 = Math.sin(angleX);
        double _t4 = Math.sin(angleZ);
        double _t5 = Math.cos(angleX);
        double _t6 = _t2 * _t1;
        double _t7 = _t2 * _t4;
        d.m00 = _t0 * _t1;
        d.m01 = Math.fma(_t6, _t3, -(_t4 * _t5));
        d.m02 = Math.fma(_t6, _t5, _t3 * _t4);
        d.m10 = _t4 * _t0;
        d.m11 = Math.fma(_t7, _t3, _t5 * _t1);
        d.m12 = Math.fma(_t7, _t5, -(_t3 * _t1));
        d.m20 = -_t2;
        d.m21 = _t3 * _t0;
        d.m22 = _t5 * _t0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code rotateZYX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZYX} dispatcher.
     */
    private Double3x4 rotateZYX_translation(double angleX, double angleY, double angleZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleY);
        double _t3 = Math.sin(angleX);
        double _t4 = Math.sin(angleZ);
        double _t5 = Math.cos(angleX);
        double _t6 = _t2 * _t1;
        double _t7 = _t2 * _t4;
        d.m00 = _t0 * _t1;
        d.m01 = Math.fma(_t6, _t3, -(_t4 * _t5));
        d.m02 = Math.fma(_t6, _t5, _t3 * _t4);
        d.m03 = this.m03;
        d.m10 = _t4 * _t0;
        d.m11 = Math.fma(_t7, _t3, _t5 * _t1);
        d.m12 = Math.fma(_t7, _t5, -(_t3 * _t1));
        d.m13 = this.m13;
        d.m20 = -_t2;
        d.m21 = _t3 * _t0;
        d.m22 = _t5 * _t0;
        d.m23 = this.m23;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Apply a rotation of {@code angleZ}, {@code angleY} and {@code angleX} radians about the Z, Y
     * and X axes, in that order (the matrix product {@code Rz * Ry * Rx}, so a vector is rotated
     * about the X axis first, then Y, then Z), to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 rotateZYX(double angleX, double angleY, double angleZ, @Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateZYX_identity(angleX, angleY, angleZ, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateZYX_translation(angleX, angleY, angleZ, dest);
        return rotateZYX_orthogonal_general(angleX, angleY, angleZ, dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Apply a rotation of {@code angleZ}, {@code angleY} and {@code angleX} radians about the Z, Y
     * and X axes, in that order (the matrix product {@code Rz * Ry * Rx}, so a vector is rotated
     * about the X axis first, then Y, then Z), to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public Double3x4 rotateZYX(double angleX, double angleY, double angleZ) {
        if (Joml.RETURN_NEW) return rotateZYX(angleX, angleY, angleZ, Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateZYX_identity_self(angleX, angleY, angleZ, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateZYX_translation(angleX, angleY, angleZ, this);
        return rotateZYX_orthogonal_general(angleX, angleY, angleZ, this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Apply a rotation of -180 degrees about the Z axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 rotateZn180(@Mutated Double3x4 dest) {
        return mapnXnYZ(dest);
    }


    /**
     * Apply a rotation of -180 degrees about the Z axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 rotateZn180() {
        return mapnXnYZ();
    }


    /**
     * Apply a rotation of -270 degrees about the Z axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 rotateZn270(@Mutated Double3x4 dest) {
        return mapYnXZ(dest);
    }


    /**
     * Apply a rotation of -270 degrees about the Z axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 rotateZn270() {
        return mapYnXZ();
    }


    /**
     * Apply a rotation of -90 degrees about the Z axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 rotateZn90(@Mutated Double3x4 dest) {
        return mapnYXZ(dest);
    }


    /**
     * Apply a rotation of -90 degrees about the Z axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x4 rotateZn90() {
        return mapnYXZ();
    }


    /**
     * Apply a scaling by {@code v} to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code p} with the new matrix by using
     * {@code M * S * p}, the scaling will be applied first.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 scale(Double3R v, @Mutated Double3x4 dest) {
        return scale(v.x(), v.y(), v.z(), dest);
    }


    /**
     * Apply a scaling by {@code v} to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code p} with the new matrix by using
     * {@code M * S * p}, the scaling will be applied first.
     *
     * @param v the vector
     * @return this
     */
    public @Mutated Double3x4 scale(Double3R v) {
        return scale(v.x(), v.y(), v.z());
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Double3x4 scale_identity(double vX, double vY, double vZ, @Mutated Double3x4 dest) {
        return preScale_identity(vX, vY, vZ, dest);
    }


    /**
     * Private in-place self-form body of {@code scale}, specialized by runtime matrix properties;
     * reached only through the public {@code scale} dispatcher.
     */
    private Double3x4 scale_identity_self(double vX, double vY, double vZ, @Mutated Double3x4 dest) {
        return preScale_identity_self(vX, vY, vZ, dest);
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Double3x4 scale_translation(double vX, double vY, double vZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = vX;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = this.m03;
        d.m10 = 0.0;
        d.m11 = vY;
        d.m12 = 0.0;
        d.m13 = this.m13;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = vZ;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code scale}, specialized by runtime matrix properties;
     * reached only through the public {@code scale} dispatcher.
     */
    private Double3x4 scale_translation_self(double vX, double vY, double vZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = vX;
        d.m03 = this.m03;
        d.m11 = vY;
        d.m13 = this.m13;
        d.m22 = vZ;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Double3x4 scale_general(double vX, double vY, double vZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = this.m00 * vX;
        d.m01 = this.m01 * vY;
        d.m02 = this.m02 * vZ;
        d.m03 = this.m03;
        d.m10 = this.m10 * vX;
        d.m11 = this.m11 * vY;
        d.m12 = this.m12 * vZ;
        d.m13 = this.m13;
        d.m20 = this.m20 * vX;
        d.m21 = this.m21 * vY;
        d.m22 = this.m22 * vZ;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Apply a scaling by ({@code vX}, {@code vY}, {@code vZ}) to this matrix and store the result
     * in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 scale(double vX, double vY, double vZ, @Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return scale_identity(vX, vY, vZ, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return scale_translation(vX, vY, vZ, dest);
        return scale_general(vX, vY, vZ, dest);
    }


    /**
     * Apply a scaling by ({@code vX}, {@code vY}, {@code vZ}) to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @return this
     */
    @Mutated public Double3x4 scale(double vX, double vY, double vZ) {
        if (Joml.RETURN_NEW) return scale(vX, vY, vZ, Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return scale_identity_self(vX, vY, vZ, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return scale_translation_self(vX, vY, vZ, this);
        return scale_general(vX, vY, vZ, this);
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Double3x4 scale_identity(double s, @Mutated Double3x4 dest) {
        return preScale_identity(s, dest);
    }


    /**
     * Private in-place self-form body of {@code scale}, specialized by runtime matrix properties;
     * reached only through the public {@code scale} dispatcher.
     */
    private Double3x4 scale_identity_self(double s, @Mutated Double3x4 dest) {
        return preScale_identity_self(s, dest);
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Double3x4 scale_translation(double s, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = s;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = this.m03;
        d.m10 = 0.0;
        d.m11 = s;
        d.m12 = 0.0;
        d.m13 = this.m13;
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = s;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code scale}, specialized by runtime matrix properties;
     * reached only through the public {@code scale} dispatcher.
     */
    private Double3x4 scale_translation_self(double s, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = s;
        d.m03 = this.m03;
        d.m11 = s;
        d.m13 = this.m13;
        d.m22 = s;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Double3x4 scale_general(double s, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = s * this.m00;
        d.m01 = s * this.m01;
        d.m02 = s * this.m02;
        d.m03 = this.m03;
        d.m10 = s * this.m10;
        d.m11 = s * this.m11;
        d.m12 = s * this.m12;
        d.m13 = this.m13;
        d.m20 = s * this.m20;
        d.m21 = s * this.m21;
        d.m22 = s * this.m22;
        d.m23 = this.m23;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Apply a scaling by {@code s} to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param s the uniform scale factor
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 scale(double s, @Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return scale_identity(s, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return scale_translation(s, dest);
        return scale_general(s, dest);
    }


    /**
     * Apply a scaling by {@code s} to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param s the uniform scale factor
     * @return this
     */
    @Mutated public Double3x4 scale(double s) {
        if (Joml.RETURN_NEW) return scale(s, Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return scale_identity_self(s, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return scale_translation_self(s, this);
        return scale_general(s, this);
    }


    /**
     * Apply a scaling by {@code s} about the pivot point {@code pivot} to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param s the uniform scale factor
     * @param pivot the pivot point
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 scaleAround(double s, Double3R pivot, @Mutated Double3x4 dest) {
        return scaleAround(s, pivot.x(), pivot.y(), pivot.z(), dest);
    }


    /**
     * Apply a scaling by {@code s} about the pivot point {@code pivot} to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param s the uniform scale factor
     * @param pivot the pivot point
     * @return this
     */
    public @Mutated Double3x4 scaleAround(double s, Double3R pivot) {
        return scaleAround(s, pivot.x(), pivot.y(), pivot.z());
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Double3x4 scaleAround_identity(double s, double pivotX, double pivotY, double pivotZ, @Mutated Double3x4 dest) {
        return preScaleAround_identity(s, pivotX, pivotY, pivotZ, dest);
    }


    /**
     * Private in-place self-form body of {@code scaleAround}, specialized by runtime matrix
     * properties; reached only through the public {@code scaleAround} dispatcher.
     */
    private Double3x4 scaleAround_identity_self(double s, double pivotX, double pivotY, double pivotZ, @Mutated Double3x4 dest) {
        return preScaleAround_identity_self(s, pivotX, pivotY, pivotZ, dest);
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Double3x4 scaleAround_translation(double s, double pivotX, double pivotY, double pivotZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = s;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = Math.fma(-s, pivotX, this.m03 + pivotX);
        d.m10 = 0.0;
        d.m11 = s;
        d.m12 = 0.0;
        d.m13 = Math.fma(-s, pivotY, this.m13 + pivotY);
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = s;
        d.m23 = Math.fma(-s, pivotZ, this.m23 + pivotZ);
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code scaleAround}, specialized by runtime matrix
     * properties; reached only through the public {@code scaleAround} dispatcher.
     */
    private Double3x4 scaleAround_translation_self(double s, double pivotX, double pivotY, double pivotZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = s;
        d.m03 = Math.fma(-s, pivotX, this.m03 + pivotX);
        d.m11 = s;
        d.m13 = Math.fma(-s, pivotY, this.m13 + pivotY);
        d.m22 = s;
        d.m23 = Math.fma(-s, pivotZ, this.m23 + pivotZ);
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Double3x4 scaleAround_orthogonal(double s, double pivotX, double pivotY, double pivotZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = Math.fma(-s, pivotX, pivotX);
        double _t1 = Math.fma(-s, pivotY, pivotY);
        double _t2 = Math.fma(-s, pivotZ, pivotZ);
        double _buf0 = s * this.m00;
        double _buf1 = s * this.m01;
        double _buf2 = s * this.m02;
        d.m03 = Math.fma(this.m00, _t0, Math.fma(this.m01, _t1, Math.fma(this.m02, _t2, this.m03)));
        double _buf3 = s * this.m10;
        double _buf4 = s * this.m11;
        double _buf5 = s * this.m12;
        d.m13 = Math.fma(this.m10, _t0, Math.fma(this.m11, _t1, Math.fma(this.m12, _t2, this.m13)));
        double _buf6 = s * this.m20;
        double _buf7 = s * this.m21;
        double _buf8 = s * this.m22;
        d.m23 = Math.fma(this.m20, _t0, Math.fma(this.m21, _t1, Math.fma(this.m22, _t2, this.m23)));
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.m10 = _buf3;
        d.m11 = _buf4;
        d.m12 = _buf5;
        d.m20 = _buf6;
        d.m21 = _buf7;
        d.m22 = _buf8;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Double3x4 scaleAround_general(double s, double pivotX, double pivotY, double pivotZ, @Mutated Double3x4 dest) {
        return scaleAround_orthogonal(s, pivotX, pivotY, pivotZ, dest);
    }


    /**
     * Apply a scaling by {@code s} about the pivot point ({@code pivotX}, {@code pivotY},
     * {@code pivotZ}) to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param s the uniform scale factor
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotZ the {@code z} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 scaleAround(double s, double pivotX, double pivotY, double pivotZ, @Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return scaleAround_identity(s, pivotX, pivotY, pivotZ, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return scaleAround_translation(s, pivotX, pivotY, pivotZ, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return scaleAround_orthogonal(s, pivotX, pivotY, pivotZ, dest);
        return scaleAround_general(s, pivotX, pivotY, pivotZ, dest);
    }


    /**
     * Apply a scaling by {@code s} about the pivot point ({@code pivotX}, {@code pivotY},
     * {@code pivotZ}) to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param s the uniform scale factor
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotZ the {@code z} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @return this
     */
    @Mutated public Double3x4 scaleAround(double s, double pivotX, double pivotY, double pivotZ) {
        if (Joml.RETURN_NEW) return scaleAround(s, pivotX, pivotY, pivotZ, Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return scaleAround_identity_self(s, pivotX, pivotY, pivotZ, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return scaleAround_translation_self(s, pivotX, pivotY, pivotZ, this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return scaleAround_orthogonal(s, pivotX, pivotY, pivotZ, this);
        return scaleAround_general(s, pivotX, pivotY, pivotZ, this);
    }


    /**
     * Apply a scaling by {@code s} about the pivot point {@code pivot} to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param s the scale factors
     * @param pivot the pivot point
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 scaleAround(Double3R s, Double3R pivot, @Mutated Double3x4 dest) {
        return scaleAround(s.x(), s.y(), s.z(), pivot.x(), pivot.y(), pivot.z(), dest);
    }


    /**
     * Apply a scaling by {@code s} about the pivot point {@code pivot} to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param s the scale factors
     * @param pivot the pivot point
     * @return this
     */
    public @Mutated Double3x4 scaleAround(Double3R s, Double3R pivot) {
        return scaleAround(s.x(), s.y(), s.z(), pivot.x(), pivot.y(), pivot.z());
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Double3x4 scaleAround_identity(double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ, @Mutated Double3x4 dest) {
        return preScaleAround_identity(sX, sY, sZ, pivotX, pivotY, pivotZ, dest);
    }


    /**
     * Private in-place self-form body of {@code scaleAround}, specialized by runtime matrix
     * properties; reached only through the public {@code scaleAround} dispatcher.
     */
    private Double3x4 scaleAround_identity_self(double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ, @Mutated Double3x4 dest) {
        return preScaleAround_identity_self(sX, sY, sZ, pivotX, pivotY, pivotZ, dest);
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Double3x4 scaleAround_translation(double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = sX;
        d.m01 = 0.0;
        d.m02 = 0.0;
        d.m03 = Math.fma(-pivotX, sX, this.m03 + pivotX);
        d.m10 = 0.0;
        d.m11 = sY;
        d.m12 = 0.0;
        d.m13 = Math.fma(-pivotY, sY, this.m13 + pivotY);
        d.m20 = 0.0;
        d.m21 = 0.0;
        d.m22 = sZ;
        d.m23 = Math.fma(-pivotZ, sZ, this.m23 + pivotZ);
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private in-place self-form body of {@code scaleAround}, specialized by runtime matrix
     * properties; reached only through the public {@code scaleAround} dispatcher.
     */
    private Double3x4 scaleAround_translation_self(double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = sX;
        d.m03 = Math.fma(-pivotX, sX, this.m03 + pivotX);
        d.m11 = sY;
        d.m13 = Math.fma(-pivotY, sY, this.m13 + pivotY);
        d.m22 = sZ;
        d.m23 = Math.fma(-pivotZ, sZ, this.m23 + pivotZ);
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Double3x4 scaleAround_orthogonal(double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t3 = Math.fma(-pivotX, sX, pivotX);
        double _t4 = Math.fma(-pivotY, sY, pivotY);
        double _t5 = Math.fma(-pivotZ, sZ, pivotZ);
        double _buf0 = sX * this.m00;
        double _buf1 = sY * this.m01;
        double _buf2 = sZ * this.m02;
        d.m03 = Math.fma(this.m00, _t3, Math.fma(this.m01, _t4, Math.fma(this.m02, _t5, this.m03)));
        double _buf3 = sX * this.m10;
        double _buf4 = sY * this.m11;
        double _buf5 = sZ * this.m12;
        d.m13 = Math.fma(this.m10, _t3, Math.fma(this.m11, _t4, Math.fma(this.m12, _t5, this.m13)));
        double _buf6 = sX * this.m20;
        double _buf7 = sY * this.m21;
        double _buf8 = sZ * this.m22;
        d.m23 = Math.fma(this.m20, _t3, Math.fma(this.m21, _t4, Math.fma(this.m22, _t5, this.m23)));
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.m10 = _buf3;
        d.m11 = _buf4;
        d.m12 = _buf5;
        d.m20 = _buf6;
        d.m21 = _buf7;
        d.m22 = _buf8;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Double3x4 scaleAround_general(double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ, @Mutated Double3x4 dest) {
        return scaleAround_orthogonal(sX, sY, sZ, pivotX, pivotY, pivotZ, dest);
    }


    /**
     * Apply a scaling by ({@code sX}, {@code sY}, {@code sZ}) about the pivot point
     * ({@code pivotX}, {@code pivotY}, {@code pivotZ}) to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param sX the {@code x} component of the vector {@code (sX, sY, sZ)}
     * @param sY the {@code y} component of the vector {@code (sX, sY, sZ)}
     * @param sZ the {@code z} component of the vector {@code (sX, sY, sZ)}
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotZ the {@code z} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 scaleAround(double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ, @Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return scaleAround_identity(sX, sY, sZ, pivotX, pivotY, pivotZ, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return scaleAround_translation(sX, sY, sZ, pivotX, pivotY, pivotZ, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return scaleAround_orthogonal(sX, sY, sZ, pivotX, pivotY, pivotZ, dest);
        return scaleAround_general(sX, sY, sZ, pivotX, pivotY, pivotZ, dest);
    }


    /**
     * Apply a scaling by ({@code sX}, {@code sY}, {@code sZ}) about the pivot point
     * ({@code pivotX}, {@code pivotY}, {@code pivotZ}) to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param sX the {@code x} component of the vector {@code (sX, sY, sZ)}
     * @param sY the {@code y} component of the vector {@code (sX, sY, sZ)}
     * @param sZ the {@code z} component of the vector {@code (sX, sY, sZ)}
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotZ the {@code z} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @return this
     */
    @Mutated public Double3x4 scaleAround(double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ) {
        if (Joml.RETURN_NEW) return scaleAround(sX, sY, sZ, pivotX, pivotY, pivotZ, Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return scaleAround_identity_self(sX, sY, sZ, pivotX, pivotY, pivotZ, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return scaleAround_translation_self(sX, sY, sZ, pivotX, pivotY, pivotZ, this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return scaleAround_orthogonal(sX, sY, sZ, pivotX, pivotY, pivotZ, this);
        return scaleAround_general(sX, sY, sZ, pivotX, pivotY, pivotZ, this);
    }


    /**
     * Apply a translation by {@code v} to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code p} with the new matrix by using
     * {@code M * T * p}, the translation will be applied first.
     *
     * @param v the translation offsets
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 translate(Double3R v, @Mutated Double3x4 dest) {
        return translate(v.x(), v.y(), v.z(), dest);
    }


    /**
     * Apply a translation by {@code v} to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code p} with the new matrix by using
     * {@code M * T * p}, the translation will be applied first.
     *
     * @param v the translation offsets
     * @return this
     */
    public @Mutated Double3x4 translate(Double3R v) {
        return translate(v.x(), v.y(), v.z());
    }


    /**
     * Private body of {@code translate}, specialized by runtime matrix properties; reached only
     * through the public {@code translate} dispatcher.
     */
    private Double3x4 translate_identity(double vX, double vY, double vZ, @Mutated Double3x4 dest) {
        return preTranslate_identity(vX, vY, vZ, dest);
    }


    /**
     * Private in-place self-form body of {@code translate}, specialized by runtime matrix
     * properties; reached only through the public {@code translate} dispatcher.
     */
    private Double3x4 translate_identity_self(double vX, double vY, double vZ, @Mutated Double3x4 dest) {
        return preTranslate_identity_self(vX, vY, vZ, dest);
    }


    /**
     * Private body of {@code translate}, specialized by runtime matrix properties; reached only
     * through the public {@code translate} dispatcher.
     */
    private Double3x4 translate_translation(double vX, double vY, double vZ, @Mutated Double3x4 dest) {
        return preTranslate_translation(vX, vY, vZ, dest);
    }


    /**
     * Private in-place self-form body of {@code translate}, specialized by runtime matrix
     * properties; reached only through the public {@code translate} dispatcher.
     */
    private Double3x4 translate_translation_self(double vX, double vY, double vZ, @Mutated Double3x4 dest) {
        return preTranslate_translation_self(vX, vY, vZ, dest);
    }


    /**
     * Private body of {@code translate}, specialized by runtime matrix properties; reached only
     * through the public {@code translate} dispatcher.
     */
    private Double3x4 translate_orthogonal(double vX, double vY, double vZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = this.m00;
        double _buf1 = this.m01;
        double _buf2 = this.m02;
        d.m03 = Math.fma(this.m00, vX, Math.fma(this.m01, vY, Math.fma(this.m02, vZ, this.m03)));
        double _buf3 = this.m10;
        double _buf4 = this.m11;
        double _buf5 = this.m12;
        d.m13 = Math.fma(this.m10, vX, Math.fma(this.m11, vY, Math.fma(this.m12, vZ, this.m13)));
        double _buf6 = this.m20;
        double _buf7 = this.m21;
        double _buf8 = this.m22;
        d.m23 = Math.fma(this.m20, vX, Math.fma(this.m21, vY, Math.fma(this.m22, vZ, this.m23)));
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.m10 = _buf3;
        d.m11 = _buf4;
        d.m12 = _buf5;
        d.m20 = _buf6;
        d.m21 = _buf7;
        d.m22 = _buf8;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Private body of {@code translate}, specialized by runtime matrix properties; reached only
     * through the public {@code translate} dispatcher.
     */
    private Double3x4 translate_general(double vX, double vY, double vZ, @Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _buf0 = this.m00;
        double _buf1 = this.m01;
        double _buf2 = this.m02;
        d.m03 = Math.fma(this.m00, vX, Math.fma(this.m01, vY, Math.fma(this.m02, vZ, this.m03)));
        double _buf3 = this.m10;
        double _buf4 = this.m11;
        double _buf5 = this.m12;
        d.m13 = Math.fma(this.m10, vX, Math.fma(this.m11, vY, Math.fma(this.m12, vZ, this.m13)));
        double _buf6 = this.m20;
        double _buf7 = this.m21;
        double _buf8 = this.m22;
        d.m23 = Math.fma(this.m20, vX, Math.fma(this.m21, vY, Math.fma(this.m22, vZ, this.m23)));
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.m10 = _buf3;
        d.m11 = _buf4;
        d.m12 = _buf5;
        d.m20 = _buf6;
        d.m21 = _buf7;
        d.m22 = _buf8;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Apply a translation by ({@code vX}, {@code vY}, {@code vZ}) to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the translation will be applied first.
     *
     * @param vX the {@code x} component of the translation offsets {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the translation offsets {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the translation offsets {@code (vX, vY, vZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 translate(double vX, double vY, double vZ, @Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return translate_identity(vX, vY, vZ, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return translate_translation(vX, vY, vZ, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return translate_orthogonal(vX, vY, vZ, dest);
        return translate_general(vX, vY, vZ, dest);
    }


    /**
     * Apply a translation by ({@code vX}, {@code vY}, {@code vZ}) to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the translation will be applied first.
     *
     * @param vX the {@code x} component of the translation offsets {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the translation offsets {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the translation offsets {@code (vX, vY, vZ)}
     * @return this
     */
    @Mutated public Double3x4 translate(double vX, double vY, double vZ) {
        if (Joml.RETURN_NEW) return translate(vX, vY, vZ, Joml.double3x4());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return translate_identity_self(vX, vY, vZ, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return translate_translation_self(vX, vY, vZ, this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return translate_orthogonal(vX, vY, vZ, this);
        return translate_general(vX, vY, vZ, this);
    }


    /**
     * Multiply this matrix by the given vector and store the result in {@code dest}.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 mul(Double4R v, @Mutated Double3 dest) {
        return mul(v.x(), v.y(), v.z(), v.w(), dest);
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3 mul_identity(double vX, double vY, double vZ, double vW, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = vX;
        d.y = vY;
        d.z = vZ;
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3 mul_translation(double vX, double vY, double vZ, double vW, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = Math.fma(this.m03, vW, vX);
        d.y = Math.fma(this.m13, vW, vY);
        d.z = Math.fma(this.m23, vW, vZ);
        return d;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3 mul_general(double vX, double vY, double vZ, double vW, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = Math.fma(this.m03, vW, Math.fma(this.m02, vZ, Math.fma(this.m00, vX, this.m01 * vY)));
        d.y = Math.fma(this.m13, vW, Math.fma(this.m12, vZ, Math.fma(this.m10, vX, this.m11 * vY)));
        d.z = Math.fma(this.m23, vW, Math.fma(this.m22, vZ, Math.fma(this.m20, vX, this.m21 * vY)));
        return d;
    }


    /**
     * Multiply this matrix by the given vector and store the result in {@code dest}.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ, vW)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ, vW)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ, vW)}
     * @param vW the {@code w} component of the vector {@code (vX, vY, vZ, vW)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 mul(double vX, double vY, double vZ, double vW, @Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mul_identity(vX, vY, vZ, vW, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_translation(vX, vY, vZ, vW, dest);
        return mul_general(vX, vY, vZ, vW, dest);
    }


    /**
     * Transform the given axis-aligned box by this matrix and compute the axis-aligned box
     * enclosing the result and store the result in {@code dest}.
     *
     * @param aabb the axis-aligned bounding box
     * @param dest will hold the result
     * @return dest
     */
    public DoubleAABB transformAabb(DoubleAABBR aabb, @Mutated DoubleAABB dest) {
        return transformAabb(aabb.minX(), aabb.minY(), aabb.minZ(), aabb.maxX(), aabb.maxY(), aabb.maxZ(), dest);
    }


    /**
     * Private body of {@code transformAabb}, specialized by runtime matrix properties; reached only
     * through the public {@code transformAabb} dispatcher.
     */
    private DoubleAABB transformAabb_identity(double minX, double minY, double minZ, double maxX, double maxY, double maxZ, @Mutated DoubleAABB dest) {
        DoubleAABBImpl d = (DoubleAABBImpl) dest;
        d.minX = Math.min(minX, maxX);
        d.minY = Math.min(minY, maxY);
        d.minZ = Math.min(minZ, maxZ);
        d.maxX = Math.max(minX, maxX);
        d.maxY = Math.max(minY, maxY);
        d.maxZ = Math.max(minZ, maxZ);
        return d;
    }


    /**
     * Private body of {@code transformAabb}, specialized by runtime matrix properties; reached only
     * through the public {@code transformAabb} dispatcher.
     */
    private DoubleAABB transformAabb_translation(double minX, double minY, double minZ, double maxX, double maxY, double maxZ, @Mutated DoubleAABB dest) {
        DoubleAABBImpl d = (DoubleAABBImpl) dest;
        d.minX = this.m03 + Math.min(minX, maxX);
        d.minY = this.m13 + Math.min(minY, maxY);
        d.minZ = this.m23 + Math.min(minZ, maxZ);
        d.maxX = this.m03 + Math.max(minX, maxX);
        d.maxY = this.m13 + Math.max(minY, maxY);
        d.maxZ = this.m23 + Math.max(minZ, maxZ);
        return d;
    }


    /**
     * Private body of {@code transformAabb}, specialized by runtime matrix properties; reached only
     * through the public {@code transformAabb} dispatcher.
     */
    private DoubleAABB transformAabb_orthogonal(double minX, double minY, double minZ, double maxX, double maxY, double maxZ, @Mutated DoubleAABB dest) {
        DoubleAABBImpl d = (DoubleAABBImpl) dest;
        double _t0 = minX * this.m00;
        double _t1 = maxX * this.m00;
        double _t2 = minY * this.m01;
        double _t3 = maxY * this.m01;
        double _t4 = minZ * this.m02;
        double _t5 = maxZ * this.m02;
        double _t6 = minX * this.m10;
        double _t7 = maxX * this.m10;
        double _t8 = minY * this.m11;
        double _t9 = maxY * this.m11;
        double _t10 = minZ * this.m12;
        double _t11 = maxZ * this.m12;
        double _t12 = minX * this.m20;
        double _t13 = maxX * this.m20;
        double _t14 = minY * this.m21;
        double _t15 = maxY * this.m21;
        double _t16 = minZ * this.m22;
        double _t17 = maxZ * this.m22;
        d.minX = this.m03 + Math.min(_t0, _t1) + Math.min(_t2, _t3) + Math.min(_t4, _t5);
        d.minY = this.m13 + Math.min(_t6, _t7) + Math.min(_t8, _t9) + Math.min(_t10, _t11);
        d.minZ = this.m23 + Math.min(_t12, _t13) + Math.min(_t14, _t15) + Math.min(_t16, _t17);
        d.maxX = this.m03 + Math.max(_t0, _t1) + Math.max(_t2, _t3) + Math.max(_t4, _t5);
        d.maxY = this.m13 + Math.max(_t6, _t7) + Math.max(_t8, _t9) + Math.max(_t10, _t11);
        d.maxZ = this.m23 + Math.max(_t12, _t13) + Math.max(_t14, _t15) + Math.max(_t16, _t17);
        return d;
    }


    /**
     * Private body of {@code transformAabb}, specialized by runtime matrix properties; reached only
     * through the public {@code transformAabb} dispatcher.
     */
    private DoubleAABB transformAabb_general(double minX, double minY, double minZ, double maxX, double maxY, double maxZ, @Mutated DoubleAABB dest) {
        return transformAabb_orthogonal(minX, minY, minZ, maxX, maxY, maxZ, dest);
    }


    /**
     * Transform the given axis-aligned box by this matrix and compute the axis-aligned box
     * enclosing the result and store the result in {@code dest}.
     *
     * @param minX the {@code minX} component of the axis-aligned bounding box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @param minY the {@code minY} component of the axis-aligned bounding box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @param minZ the {@code minZ} component of the axis-aligned bounding box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @param maxX the {@code maxX} component of the axis-aligned bounding box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @param maxY the {@code maxY} component of the axis-aligned bounding box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @param maxZ the {@code maxZ} component of the axis-aligned bounding box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleAABB transformAabb(double minX, double minY, double minZ, double maxX, double maxY, double maxZ, @Mutated DoubleAABB dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return transformAabb_identity(minX, minY, minZ, maxX, maxY, maxZ, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return transformAabb_translation(minX, minY, minZ, maxX, maxY, maxZ, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return transformAabb_orthogonal(minX, minY, minZ, maxX, maxY, maxZ, dest);
        return transformAabb_general(minX, minY, minZ, maxX, maxY, maxZ, dest);
    }


    /**
     * Transform the given axis-aligned box by this matrix and compute the axis-aligned box
     * enclosing the result and store the result in {@code dest}.
     *
     * @param min the minimum corner
     * @param max the maximum corner
     * @param dest will hold the result
     * @return dest
     */
    public DoubleAABB transformAabb(Double3R min, Double3R max, @Mutated DoubleAABB dest) {
        return transformAabb(min.x(), min.y(), min.z(), max.x(), max.y(), max.z(), dest);
    }


    /**
     * Transform the given direction by this matrix, ignoring any translation and store the result
     * in {@code dest}.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformDirection(Double3R v, @Mutated Double3 dest) {
        return transformDirection(v.x(), v.y(), v.z(), dest);
    }


    /**
     * Private body of {@code transformDirection}, specialized by runtime matrix properties; reached
     * only through the public {@code transformDirection} dispatcher.
     */
    private Double3 transformDirection_identity(double vX, double vY, double vZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = vX;
        d.y = vY;
        d.z = vZ;
        return d;
    }


    /**
     * Private body of {@code transformDirection}, specialized by runtime matrix properties; reached
     * only through the public {@code transformDirection} dispatcher.
     */
    private Double3 transformDirection_general(double vX, double vY, double vZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = Math.fma(this.m02, vZ, Math.fma(this.m00, vX, this.m01 * vY));
        d.y = Math.fma(this.m12, vZ, Math.fma(this.m10, vX, this.m11 * vY));
        d.z = Math.fma(this.m22, vZ, Math.fma(this.m20, vX, this.m21 * vY));
        return d;
    }


    /**
     * Transform the given direction by this matrix, ignoring any translation and store the result
     * in {@code dest}.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformDirection(double vX, double vY, double vZ, @Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return transformDirection_identity(vX, vY, vZ, dest);
        return transformDirection_general(vX, vY, vZ, dest);
    }


    /**
     * Transform the given position by this matrix, treating it as a point with an implicit
     * {@code w = 1} and store the result in {@code dest}.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformPosition(Double3R v, @Mutated Double3 dest) {
        return transformPosition(v.x(), v.y(), v.z(), dest);
    }


    /**
     * Private body of {@code transformPosition}, specialized by runtime matrix properties; reached
     * only through the public {@code transformPosition} dispatcher.
     */
    private Double3 transformPosition_identity(double vX, double vY, double vZ, @Mutated Double3 dest) {
        return transformDirection_identity(vX, vY, vZ, dest);
    }


    /**
     * Private body of {@code transformPosition}, specialized by runtime matrix properties; reached
     * only through the public {@code transformPosition} dispatcher.
     */
    private Double3 transformPosition_translation(double vX, double vY, double vZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = this.m03 + vX;
        d.y = this.m13 + vY;
        d.z = this.m23 + vZ;
        return d;
    }


    /**
     * Private body of {@code transformPosition}, specialized by runtime matrix properties; reached
     * only through the public {@code transformPosition} dispatcher.
     */
    private Double3 transformPosition_general(double vX, double vY, double vZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = Math.fma(this.m00, vX, Math.fma(this.m01, vY, Math.fma(this.m02, vZ, this.m03)));
        d.y = Math.fma(this.m10, vX, Math.fma(this.m11, vY, Math.fma(this.m12, vZ, this.m13)));
        d.z = Math.fma(this.m20, vX, Math.fma(this.m21, vY, Math.fma(this.m22, vZ, this.m23)));
        return d;
    }


    /**
     * Transform the given position by this matrix, treating it as a point with an implicit
     * {@code w = 1} and store the result in {@code dest}.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformPosition(double vX, double vY, double vZ, @Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return transformPosition_identity(vX, vY, vZ, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return transformPosition_translation(vX, vY, vZ, dest);
        return transformPosition_general(vX, vY, vZ, dest);
    }

    public double m00() { return this.m00; }
    public double m01() { return this.m01; }
    public double m02() { return this.m02; }
    public double m03() { return this.m03; }
    public double m10() { return this.m10; }
    public double m11() { return this.m11; }
    public double m12() { return this.m12; }
    public double m13() { return this.m13; }
    public double m20() { return this.m20; }
    public double m21() { return this.m21; }
    public double m22() { return this.m22; }
    public double m23() { return this.m23; }

    @Override public String toString() {
        return "Double3x4(\n    " + m00() + ", " + m01() + ", " + m02() + ", " + m03() + "\n    " + m10() + ", " + m11() + ", " + m12() + ", " + m13() + "\n    " + m20() + ", " + m21() + ", " + m22() + ", " + m23() + "\n)";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Double3x4Impl)) return false;
        Double3x4Impl o = (Double3x4Impl) obj;
        return Double.doubleToLongBits(m00) == Double.doubleToLongBits(o.m00)
            && Double.doubleToLongBits(m01) == Double.doubleToLongBits(o.m01)
            && Double.doubleToLongBits(m02) == Double.doubleToLongBits(o.m02)
            && Double.doubleToLongBits(m03) == Double.doubleToLongBits(o.m03)
            && Double.doubleToLongBits(m10) == Double.doubleToLongBits(o.m10)
            && Double.doubleToLongBits(m11) == Double.doubleToLongBits(o.m11)
            && Double.doubleToLongBits(m12) == Double.doubleToLongBits(o.m12)
            && Double.doubleToLongBits(m13) == Double.doubleToLongBits(o.m13)
            && Double.doubleToLongBits(m20) == Double.doubleToLongBits(o.m20)
            && Double.doubleToLongBits(m21) == Double.doubleToLongBits(o.m21)
            && Double.doubleToLongBits(m22) == Double.doubleToLongBits(o.m22)
            && Double.doubleToLongBits(m23) == Double.doubleToLongBits(o.m23);
    }

    @Override public int hashCode() {
        int h = 1;
        h = 31 * h + (int)(Double.doubleToLongBits(m00) ^ (Double.doubleToLongBits(m00) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(m01) ^ (Double.doubleToLongBits(m01) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(m02) ^ (Double.doubleToLongBits(m02) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(m03) ^ (Double.doubleToLongBits(m03) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(m10) ^ (Double.doubleToLongBits(m10) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(m11) ^ (Double.doubleToLongBits(m11) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(m12) ^ (Double.doubleToLongBits(m12) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(m13) ^ (Double.doubleToLongBits(m13) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(m20) ^ (Double.doubleToLongBits(m20) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(m21) ^ (Double.doubleToLongBits(m21) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(m22) ^ (Double.doubleToLongBits(m22) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(m23) ^ (Double.doubleToLongBits(m23) >>> 32));
        return h;
    }

    @Override public boolean isFinite() {
        return Double.isFinite(m00)
            && Double.isFinite(m01)
            && Double.isFinite(m02)
            && Double.isFinite(m03)
            && Double.isFinite(m10)
            && Double.isFinite(m11)
            && Double.isFinite(m12)
            && Double.isFinite(m13)
            && Double.isFinite(m20)
            && Double.isFinite(m21)
            && Double.isFinite(m22)
            && Double.isFinite(m23);
    }

    @Override public boolean equalsEpsilon(Double3x4R other, double epsilon) {
        return Math.abs(m00 - other.m00()) <= epsilon
            && Math.abs(m01 - other.m01()) <= epsilon
            && Math.abs(m02 - other.m02()) <= epsilon
            && Math.abs(m03 - other.m03()) <= epsilon
            && Math.abs(m10 - other.m10()) <= epsilon
            && Math.abs(m11 - other.m11()) <= epsilon
            && Math.abs(m12 - other.m12()) <= epsilon
            && Math.abs(m13 - other.m13()) <= epsilon
            && Math.abs(m20 - other.m20()) <= epsilon
            && Math.abs(m21 - other.m21()) <= epsilon
            && Math.abs(m22 - other.m22()) <= epsilon
            && Math.abs(m23 - other.m23()) <= epsilon;
    }

    public double[] storeCM(@Mutated double[] dest, int offset) {
        dest[offset + 0] = this.m00;
        dest[offset + 1] = this.m10;
        dest[offset + 2] = this.m20;
        dest[offset + 3] = this.m01;
        dest[offset + 4] = this.m11;
        dest[offset + 5] = this.m21;
        dest[offset + 6] = this.m02;
        dest[offset + 7] = this.m12;
        dest[offset + 8] = this.m22;
        dest[offset + 9] = this.m03;
        dest[offset + 10] = this.m13;
        dest[offset + 11] = this.m23;
        return dest;
    }
    public @Mutated Double3x4 loadCM(double[] src, int offset) {
        this.m00 = src[offset + 0];
        this.m10 = src[offset + 1];
        this.m20 = src[offset + 2];
        this.m01 = src[offset + 3];
        this.m11 = src[offset + 4];
        this.m21 = src[offset + 5];
        this.m02 = src[offset + 6];
        this.m12 = src[offset + 7];
        this.m22 = src[offset + 8];
        this.m03 = src[offset + 9];
        this.m13 = src[offset + 10];
        this.m23 = src[offset + 11];
        this.properties = determineProperties();
        return this;
    }
    public DoubleBuffer storeCMAbsolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeCMAbsolute(this, index, buf);
    }
    @Mutated public Double3x4 loadCMAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadCMAbsolute(this, index, buf);
    }
    public ByteBuffer storeCMAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeCMAbsolute(this, index, buf);
    }
    public Double3x4 loadCMAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadCMAbsolute(this, index, buf);
    }
    public Double3x4 storeCMUnsafe(long address) {
        return RAW_OPS.storeCMUnsafe(this, address);
    }
    @Mutated public Double3x4 loadCMUnsafe(long address) {
        return RAW_OPS.loadCMUnsafe(this, address);
    }
    public MemorySegment storeCM(long offset, MemorySegment dest) {
        return SEG_OPS.storeCM(this, offset, dest);
    }
    public Double3x4 loadCM(long offset, MemorySegment src) {
        return SEG_OPS.loadCM(this, offset, src);
    }

    public float[] storeCM(@Mutated float[] dest, int offset) {
        dest[offset + 0] = (float) this.m00;
        dest[offset + 1] = (float) this.m10;
        dest[offset + 2] = (float) this.m20;
        dest[offset + 3] = (float) this.m01;
        dest[offset + 4] = (float) this.m11;
        dest[offset + 5] = (float) this.m21;
        dest[offset + 6] = (float) this.m02;
        dest[offset + 7] = (float) this.m12;
        dest[offset + 8] = (float) this.m22;
        dest[offset + 9] = (float) this.m03;
        dest[offset + 10] = (float) this.m13;
        dest[offset + 11] = (float) this.m23;
        return dest;
    }
    public @Mutated Double3x4 loadCM(float[] src, int offset) {
        this.m00 = src[offset + 0];
        this.m10 = src[offset + 1];
        this.m20 = src[offset + 2];
        this.m01 = src[offset + 3];
        this.m11 = src[offset + 4];
        this.m21 = src[offset + 5];
        this.m02 = src[offset + 6];
        this.m12 = src[offset + 7];
        this.m22 = src[offset + 8];
        this.m03 = src[offset + 9];
        this.m13 = src[offset + 10];
        this.m23 = src[offset + 11];
        this.properties = determineProperties();
        return this;
    }
    public FloatBuffer storeCMAbsolute(int index, @Mutated FloatBuffer buf) {
        return BB_OPS.storeCMAbsolute(this, index, buf);
    }
    @Mutated public Double3x4 loadCMAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadCMAbsolute(this, index, buf);
    }
    public ByteBuffer storeCMFloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeCMFloatAbsolute(this, index, buf);
    }
    public Double3x4 loadCMFloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadCMFloatAbsolute(this, index, buf);
    }
    public Double3x4 storeCMFloatUnsafe(long address) {
        return RAW_OPS.storeCMFloatUnsafe(this, address);
    }
    @Mutated public Double3x4 loadCMFloatUnsafe(long address) {
        return RAW_OPS.loadCMFloatUnsafe(this, address);
    }
    public MemorySegment storeCMFloat(long offset, MemorySegment dest) {
        return SEG_OPS.storeCMFloat(this, offset, dest);
    }
    public Double3x4 loadCMFloat(long offset, MemorySegment src) {
        return SEG_OPS.loadCMFloat(this, offset, src);
    }

    public double[] storeRM(@Mutated double[] dest, int offset) {
        dest[offset + 0] = this.m00;
        dest[offset + 1] = this.m01;
        dest[offset + 2] = this.m02;
        dest[offset + 3] = this.m03;
        dest[offset + 4] = this.m10;
        dest[offset + 5] = this.m11;
        dest[offset + 6] = this.m12;
        dest[offset + 7] = this.m13;
        dest[offset + 8] = this.m20;
        dest[offset + 9] = this.m21;
        dest[offset + 10] = this.m22;
        dest[offset + 11] = this.m23;
        return dest;
    }
    public @Mutated Double3x4 loadRM(double[] src, int offset) {
        this.m00 = src[offset + 0];
        this.m01 = src[offset + 1];
        this.m02 = src[offset + 2];
        this.m03 = src[offset + 3];
        this.m10 = src[offset + 4];
        this.m11 = src[offset + 5];
        this.m12 = src[offset + 6];
        this.m13 = src[offset + 7];
        this.m20 = src[offset + 8];
        this.m21 = src[offset + 9];
        this.m22 = src[offset + 10];
        this.m23 = src[offset + 11];
        this.properties = determineProperties();
        return this;
    }
    public DoubleBuffer storeRMAbsolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeRMAbsolute(this, index, buf);
    }
    @Mutated public Double3x4 loadRMAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadRMAbsolute(this, index, buf);
    }
    public ByteBuffer storeRMAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeRMAbsolute(this, index, buf);
    }
    public Double3x4 loadRMAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadRMAbsolute(this, index, buf);
    }
    public Double3x4 storeRMUnsafe(long address) {
        return RAW_OPS.storeRMUnsafe(this, address);
    }
    @Mutated public Double3x4 loadRMUnsafe(long address) {
        return RAW_OPS.loadRMUnsafe(this, address);
    }
    public MemorySegment storeRM(long offset, MemorySegment dest) {
        return SEG_OPS.storeRM(this, offset, dest);
    }
    public Double3x4 loadRM(long offset, MemorySegment src) {
        return SEG_OPS.loadRM(this, offset, src);
    }

    public float[] storeRM(@Mutated float[] dest, int offset) {
        dest[offset + 0] = (float) this.m00;
        dest[offset + 1] = (float) this.m01;
        dest[offset + 2] = (float) this.m02;
        dest[offset + 3] = (float) this.m03;
        dest[offset + 4] = (float) this.m10;
        dest[offset + 5] = (float) this.m11;
        dest[offset + 6] = (float) this.m12;
        dest[offset + 7] = (float) this.m13;
        dest[offset + 8] = (float) this.m20;
        dest[offset + 9] = (float) this.m21;
        dest[offset + 10] = (float) this.m22;
        dest[offset + 11] = (float) this.m23;
        return dest;
    }
    public @Mutated Double3x4 loadRM(float[] src, int offset) {
        this.m00 = src[offset + 0];
        this.m01 = src[offset + 1];
        this.m02 = src[offset + 2];
        this.m03 = src[offset + 3];
        this.m10 = src[offset + 4];
        this.m11 = src[offset + 5];
        this.m12 = src[offset + 6];
        this.m13 = src[offset + 7];
        this.m20 = src[offset + 8];
        this.m21 = src[offset + 9];
        this.m22 = src[offset + 10];
        this.m23 = src[offset + 11];
        this.properties = determineProperties();
        return this;
    }
    public FloatBuffer storeRMAbsolute(int index, @Mutated FloatBuffer buf) {
        return BB_OPS.storeRMAbsolute(this, index, buf);
    }
    @Mutated public Double3x4 loadRMAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadRMAbsolute(this, index, buf);
    }
    public ByteBuffer storeRMFloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeRMFloatAbsolute(this, index, buf);
    }
    public Double3x4 loadRMFloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadRMFloatAbsolute(this, index, buf);
    }
    public Double3x4 storeRMFloatUnsafe(long address) {
        return RAW_OPS.storeRMFloatUnsafe(this, address);
    }
    @Mutated public Double3x4 loadRMFloatUnsafe(long address) {
        return RAW_OPS.loadRMFloatUnsafe(this, address);
    }
    public MemorySegment storeRMFloat(long offset, MemorySegment dest) {
        return SEG_OPS.storeRMFloat(this, offset, dest);
    }
    public Double3x4 loadRMFloat(long offset, MemorySegment src) {
        return SEG_OPS.loadRMFloat(this, offset, src);
    }

    public double[] storeCM(@Mutated double[] dest, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        int _p3 = _p2 + stride;
        dest[offset] = this.m00;
        dest[offset + 1] = this.m10;
        dest[offset + 2] = this.m20;
        dest[_p1] = this.m01;
        dest[_p1 + 1] = this.m11;
        dest[_p1 + 2] = this.m21;
        dest[_p2] = this.m02;
        dest[_p2 + 1] = this.m12;
        dest[_p2 + 2] = this.m22;
        dest[_p3] = this.m03;
        dest[_p3 + 1] = this.m13;
        dest[_p3 + 2] = this.m23;
        return dest;
    }
    public @Mutated Double3x4 loadCM(double[] src, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        int _p3 = _p2 + stride;
        this.m00 = src[offset];
        this.m10 = src[offset + 1];
        this.m20 = src[offset + 2];
        this.m01 = src[_p1];
        this.m11 = src[_p1 + 1];
        this.m21 = src[_p1 + 2];
        this.m02 = src[_p2];
        this.m12 = src[_p2 + 1];
        this.m22 = src[_p2 + 2];
        this.m03 = src[_p3];
        this.m13 = src[_p3 + 1];
        this.m23 = src[_p3 + 2];
        this.properties = determineProperties();
        return this;
    }
    public DoubleBuffer storeCMAbsolute(int index, @Mutated DoubleBuffer buf, int stride) {
        return BB_OPS.storeCMAbsolute(this, index, buf, stride);
    }
    @Mutated public Double3x4 loadCMAbsolute(int index, DoubleBuffer buf, int stride) {
        return BB_OPS.loadCMAbsolute(this, index, buf, stride);
    }
    public ByteBuffer storeCMAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.storeCMAbsolute(this, index, buf, stride);
    }
    public Double3x4 loadCMAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.loadCMAbsolute(this, index, buf, stride);
    }
    public Double3x4 storeCMUnsafe(long address, int stride) {
        return RAW_OPS.storeCMUnsafe(this, address, stride);
    }
    @Mutated public Double3x4 loadCMUnsafe(long address, int stride) {
        return RAW_OPS.loadCMUnsafe(this, address, stride);
    }
    public MemorySegment storeCM(long offset, MemorySegment dest, int stride) {
        return SEG_OPS.storeCM(this, offset, dest, stride);
    }
    public Double3x4 loadCM(long offset, MemorySegment src, int stride) {
        return SEG_OPS.loadCM(this, offset, src, stride);
    }

    public float[] storeCM(@Mutated float[] dest, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        int _p3 = _p2 + stride;
        dest[offset] = (float) this.m00;
        dest[offset + 1] = (float) this.m10;
        dest[offset + 2] = (float) this.m20;
        dest[_p1] = (float) this.m01;
        dest[_p1 + 1] = (float) this.m11;
        dest[_p1 + 2] = (float) this.m21;
        dest[_p2] = (float) this.m02;
        dest[_p2 + 1] = (float) this.m12;
        dest[_p2 + 2] = (float) this.m22;
        dest[_p3] = (float) this.m03;
        dest[_p3 + 1] = (float) this.m13;
        dest[_p3 + 2] = (float) this.m23;
        return dest;
    }
    public @Mutated Double3x4 loadCM(float[] src, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        int _p3 = _p2 + stride;
        this.m00 = src[offset];
        this.m10 = src[offset + 1];
        this.m20 = src[offset + 2];
        this.m01 = src[_p1];
        this.m11 = src[_p1 + 1];
        this.m21 = src[_p1 + 2];
        this.m02 = src[_p2];
        this.m12 = src[_p2 + 1];
        this.m22 = src[_p2 + 2];
        this.m03 = src[_p3];
        this.m13 = src[_p3 + 1];
        this.m23 = src[_p3 + 2];
        this.properties = determineProperties();
        return this;
    }
    public FloatBuffer storeCMAbsolute(int index, @Mutated FloatBuffer buf, int stride) {
        return BB_OPS.storeCMAbsolute(this, index, buf, stride);
    }
    @Mutated public Double3x4 loadCMAbsolute(int index, FloatBuffer buf, int stride) {
        return BB_OPS.loadCMAbsolute(this, index, buf, stride);
    }
    public ByteBuffer storeCMFloatAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.storeCMFloatAbsolute(this, index, buf, stride);
    }
    public Double3x4 loadCMFloatAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.loadCMFloatAbsolute(this, index, buf, stride);
    }
    public Double3x4 storeCMFloatUnsafe(long address, int stride) {
        return RAW_OPS.storeCMFloatUnsafe(this, address, stride);
    }
    @Mutated public Double3x4 loadCMFloatUnsafe(long address, int stride) {
        return RAW_OPS.loadCMFloatUnsafe(this, address, stride);
    }
    public MemorySegment storeCMFloat(long offset, MemorySegment dest, int stride) {
        return SEG_OPS.storeCMFloat(this, offset, dest, stride);
    }
    public Double3x4 loadCMFloat(long offset, MemorySegment src, int stride) {
        return SEG_OPS.loadCMFloat(this, offset, src, stride);
    }

    public double[] storeRM(@Mutated double[] dest, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        dest[offset] = this.m00;
        dest[offset + 1] = this.m01;
        dest[offset + 2] = this.m02;
        dest[offset + 3] = this.m03;
        dest[_p1] = this.m10;
        dest[_p1 + 1] = this.m11;
        dest[_p1 + 2] = this.m12;
        dest[_p1 + 3] = this.m13;
        dest[_p2] = this.m20;
        dest[_p2 + 1] = this.m21;
        dest[_p2 + 2] = this.m22;
        dest[_p2 + 3] = this.m23;
        return dest;
    }
    public @Mutated Double3x4 loadRM(double[] src, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        this.m00 = src[offset];
        this.m01 = src[offset + 1];
        this.m02 = src[offset + 2];
        this.m03 = src[offset + 3];
        this.m10 = src[_p1];
        this.m11 = src[_p1 + 1];
        this.m12 = src[_p1 + 2];
        this.m13 = src[_p1 + 3];
        this.m20 = src[_p2];
        this.m21 = src[_p2 + 1];
        this.m22 = src[_p2 + 2];
        this.m23 = src[_p2 + 3];
        this.properties = determineProperties();
        return this;
    }
    public DoubleBuffer storeRMAbsolute(int index, @Mutated DoubleBuffer buf, int stride) {
        return BB_OPS.storeRMAbsolute(this, index, buf, stride);
    }
    @Mutated public Double3x4 loadRMAbsolute(int index, DoubleBuffer buf, int stride) {
        return BB_OPS.loadRMAbsolute(this, index, buf, stride);
    }
    public ByteBuffer storeRMAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.storeRMAbsolute(this, index, buf, stride);
    }
    public Double3x4 loadRMAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.loadRMAbsolute(this, index, buf, stride);
    }
    public Double3x4 storeRMUnsafe(long address, int stride) {
        return RAW_OPS.storeRMUnsafe(this, address, stride);
    }
    @Mutated public Double3x4 loadRMUnsafe(long address, int stride) {
        return RAW_OPS.loadRMUnsafe(this, address, stride);
    }
    public MemorySegment storeRM(long offset, MemorySegment dest, int stride) {
        return SEG_OPS.storeRM(this, offset, dest, stride);
    }
    public Double3x4 loadRM(long offset, MemorySegment src, int stride) {
        return SEG_OPS.loadRM(this, offset, src, stride);
    }

    public float[] storeRM(@Mutated float[] dest, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        dest[offset] = (float) this.m00;
        dest[offset + 1] = (float) this.m01;
        dest[offset + 2] = (float) this.m02;
        dest[offset + 3] = (float) this.m03;
        dest[_p1] = (float) this.m10;
        dest[_p1 + 1] = (float) this.m11;
        dest[_p1 + 2] = (float) this.m12;
        dest[_p1 + 3] = (float) this.m13;
        dest[_p2] = (float) this.m20;
        dest[_p2 + 1] = (float) this.m21;
        dest[_p2 + 2] = (float) this.m22;
        dest[_p2 + 3] = (float) this.m23;
        return dest;
    }
    public @Mutated Double3x4 loadRM(float[] src, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        this.m00 = src[offset];
        this.m01 = src[offset + 1];
        this.m02 = src[offset + 2];
        this.m03 = src[offset + 3];
        this.m10 = src[_p1];
        this.m11 = src[_p1 + 1];
        this.m12 = src[_p1 + 2];
        this.m13 = src[_p1 + 3];
        this.m20 = src[_p2];
        this.m21 = src[_p2 + 1];
        this.m22 = src[_p2 + 2];
        this.m23 = src[_p2 + 3];
        this.properties = determineProperties();
        return this;
    }
    public FloatBuffer storeRMAbsolute(int index, @Mutated FloatBuffer buf, int stride) {
        return BB_OPS.storeRMAbsolute(this, index, buf, stride);
    }
    @Mutated public Double3x4 loadRMAbsolute(int index, FloatBuffer buf, int stride) {
        return BB_OPS.loadRMAbsolute(this, index, buf, stride);
    }
    public ByteBuffer storeRMFloatAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.storeRMFloatAbsolute(this, index, buf, stride);
    }
    public Double3x4 loadRMFloatAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.loadRMFloatAbsolute(this, index, buf, stride);
    }
    public Double3x4 storeRMFloatUnsafe(long address, int stride) {
        return RAW_OPS.storeRMFloatUnsafe(this, address, stride);
    }
    @Mutated public Double3x4 loadRMFloatUnsafe(long address, int stride) {
        return RAW_OPS.loadRMFloatUnsafe(this, address, stride);
    }
    public MemorySegment storeRMFloat(long offset, MemorySegment dest, int stride) {
        return SEG_OPS.storeRMFloat(this, offset, dest, stride);
    }
    public Double3x4 loadRMFloat(long offset, MemorySegment src, int stride) {
        return SEG_OPS.loadRMFloat(this, offset, src, stride);
    }

    public double[] storeCM4x4(@Mutated double[] dest, int offset) {
        dest[offset + 0] = this.m00;
        dest[offset + 1] = this.m10;
        dest[offset + 2] = this.m20;
        dest[offset + 3] = 0.0;
        dest[offset + 4] = this.m01;
        dest[offset + 5] = this.m11;
        dest[offset + 6] = this.m21;
        dest[offset + 7] = 0.0;
        dest[offset + 8] = this.m02;
        dest[offset + 9] = this.m12;
        dest[offset + 10] = this.m22;
        dest[offset + 11] = 0.0;
        dest[offset + 12] = this.m03;
        dest[offset + 13] = this.m13;
        dest[offset + 14] = this.m23;
        dest[offset + 15] = 1.0;
        return dest;
    }
    public DoubleBuffer storeCM4x4Absolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeCM4x4Absolute(this, index, buf);
    }
    public ByteBuffer storeCM4x4Absolute(int index, ByteBuffer buf) {
        return BB_OPS.storeCM4x4Absolute(this, index, buf);
    }
    public Double3x4 storeCM4x4Unsafe(long address) {
        return RAW_OPS.storeCM4x4Unsafe(this, address);
    }
    public MemorySegment storeCM4x4(long offset, MemorySegment dest) {
        return SEG_OPS.storeCM4x4(this, offset, dest);
    }

    public float[] storeCM4x4(@Mutated float[] dest, int offset) {
        dest[offset + 0] = (float) this.m00;
        dest[offset + 1] = (float) this.m10;
        dest[offset + 2] = (float) this.m20;
        dest[offset + 3] = (float) 0.0;
        dest[offset + 4] = (float) this.m01;
        dest[offset + 5] = (float) this.m11;
        dest[offset + 6] = (float) this.m21;
        dest[offset + 7] = (float) 0.0;
        dest[offset + 8] = (float) this.m02;
        dest[offset + 9] = (float) this.m12;
        dest[offset + 10] = (float) this.m22;
        dest[offset + 11] = (float) 0.0;
        dest[offset + 12] = (float) this.m03;
        dest[offset + 13] = (float) this.m13;
        dest[offset + 14] = (float) this.m23;
        dest[offset + 15] = (float) 1.0;
        return dest;
    }
    public FloatBuffer storeCM4x4Absolute(int index, @Mutated FloatBuffer buf) {
        return BB_OPS.storeCM4x4Absolute(this, index, buf);
    }
    public ByteBuffer storeCM4x4FloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeCM4x4FloatAbsolute(this, index, buf);
    }
    public Double3x4 storeCM4x4FloatUnsafe(long address) {
        return RAW_OPS.storeCM4x4FloatUnsafe(this, address);
    }
    public MemorySegment storeCM4x4Float(long offset, MemorySegment dest) {
        return SEG_OPS.storeCM4x4Float(this, offset, dest);
    }

    public double[] storeRM4x4(@Mutated double[] dest, int offset) {
        dest[offset + 0] = this.m00;
        dest[offset + 1] = this.m01;
        dest[offset + 2] = this.m02;
        dest[offset + 3] = this.m03;
        dest[offset + 4] = this.m10;
        dest[offset + 5] = this.m11;
        dest[offset + 6] = this.m12;
        dest[offset + 7] = this.m13;
        dest[offset + 8] = this.m20;
        dest[offset + 9] = this.m21;
        dest[offset + 10] = this.m22;
        dest[offset + 11] = this.m23;
        dest[offset + 12] = 0.0;
        dest[offset + 13] = 0.0;
        dest[offset + 14] = 0.0;
        dest[offset + 15] = 1.0;
        return dest;
    }
    public DoubleBuffer storeRM4x4Absolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeRM4x4Absolute(this, index, buf);
    }
    public ByteBuffer storeRM4x4Absolute(int index, ByteBuffer buf) {
        return BB_OPS.storeRM4x4Absolute(this, index, buf);
    }
    public Double3x4 storeRM4x4Unsafe(long address) {
        return RAW_OPS.storeRM4x4Unsafe(this, address);
    }
    public MemorySegment storeRM4x4(long offset, MemorySegment dest) {
        return SEG_OPS.storeRM4x4(this, offset, dest);
    }

    public float[] storeRM4x4(@Mutated float[] dest, int offset) {
        dest[offset + 0] = (float) this.m00;
        dest[offset + 1] = (float) this.m01;
        dest[offset + 2] = (float) this.m02;
        dest[offset + 3] = (float) this.m03;
        dest[offset + 4] = (float) this.m10;
        dest[offset + 5] = (float) this.m11;
        dest[offset + 6] = (float) this.m12;
        dest[offset + 7] = (float) this.m13;
        dest[offset + 8] = (float) this.m20;
        dest[offset + 9] = (float) this.m21;
        dest[offset + 10] = (float) this.m22;
        dest[offset + 11] = (float) this.m23;
        dest[offset + 12] = (float) 0.0;
        dest[offset + 13] = (float) 0.0;
        dest[offset + 14] = (float) 0.0;
        dest[offset + 15] = (float) 1.0;
        return dest;
    }
    public FloatBuffer storeRM4x4Absolute(int index, @Mutated FloatBuffer buf) {
        return BB_OPS.storeRM4x4Absolute(this, index, buf);
    }
    public ByteBuffer storeRM4x4FloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeRM4x4FloatAbsolute(this, index, buf);
    }
    public Double3x4 storeRM4x4FloatUnsafe(long address) {
        return RAW_OPS.storeRM4x4FloatUnsafe(this, address);
    }
    public MemorySegment storeRM4x4Float(long offset, MemorySegment dest) {
        return SEG_OPS.storeRM4x4Float(this, offset, dest);
    }

}
